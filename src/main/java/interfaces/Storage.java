package interfaces;

import java.io.IOException;
import java.util.ArrayList;

import com.google.api.client.http.FileContent;

import other.FileDownloadLink;

public interface Storage {
	public ArrayList<FileDownloadLink>getFileDownloadLinks() throws IOException;
	public void upload(com.google.api.services.drive.model.File body, FileContent mediaContent) throws IOException;
}
