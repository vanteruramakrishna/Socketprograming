package com.socketprog;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

public interface FileTransferProtocols {
	
	void readFolder(final File folder,Socket s)throws IOException;
	void upload(String fileFolder,Socket s,String verification) throws IOException;
	void delete(File file);
	void writeFolder();
	

}
