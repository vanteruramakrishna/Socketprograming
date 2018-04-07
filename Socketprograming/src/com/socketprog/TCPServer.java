package com.socketprog;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws IOException {
		serverWriteProg();
	}

	private static void serverWriteProg() throws IOException {
		
		ServerSocket ss=new ServerSocket(7777);  
		Socket s=ss.accept();
		FileTransferProtocolsImp file=new FileTransferProtocolsImp();
		while(true){
		file.upload("c:\\server1\\", s,"-VERIFIED");
		file.readFolder(new File("c:\\server1"), s);
		}
		//ss.close();
	}
}
