package other;
import java.util.Calendar;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import static io.jsonwebtoken.SignatureAlgorithm.*;
import other.Constants;
public class Token {
	public static final String TOKEN_SUBJECT = "ACCESS";
	
	public static String createToken(String username){
		JwtBuilder jwt = Jwts.builder().setSubject(TOKEN_SUBJECT);
		jwt.setIssuer(username);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, 15);
		System.out.println("Time: " + c.getTime());
		jwt.setExpiration(c.getTime());
		jwt.signWith(HS256, Constants.JWT_TOKEN_SECRET);
		return jwt.compact();
	}
	public static boolean validateToken(String jwtString, String username){
		JwtParser parser= Jwts.parser().setSigningKey(Constants.JWT_TOKEN_SECRET);
		try{
			Claims claims = parser.parseClaimsJws(jwtString).getBody();
			if(!claims.getSubject().equals(TOKEN_SUBJECT)){
				return false;
			}
			if(! claims.getExpiration().after(new Date())){
				return false;
			}
			if( !claims.getIssuer().equals(username)){
				return false;
			}
		}catch(SignatureException e ){
			return false;
		}
		
		return true;
	}
}
