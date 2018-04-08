package com.socketprog;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer extends Thread{
	static ServerSocket ss;
	static Socket s;
	public void run(){
		try {
			
			TCPServer.serverWriteProg();
			s.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static void main(String[] args) throws IOException {
		//serverWriteProg();
		TCPServer t=new TCPServer();
		t.start();
	}

	private static void serverWriteProg() throws IOException {
		
		 ss=new ServerSocket(7777);  
		 s=ss.accept();
		FileTransferProtocolsImp file=new FileTransferProtocolsImp();
		while(true){
		file.upload("c:\\server1\\", s,"-VERIFIED");
		file.readFolder(new File("c:\\server1"), s);
		file.delete(new File("c:\\server1\\"));
		}
		
		
	}
	
}
