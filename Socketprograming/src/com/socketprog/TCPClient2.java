package com.socketprog;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient2 extends Thread{
	public void run(){
		try {
			TCPClient2.transferProtocal();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws UnknownHostException,
	IOException {
//transferProtocal();
		TCPClient2 t=new TCPClient2();
		t.start();
}

public static void transferProtocal() throws UnknownHostException,
	IOException {

Socket s = new Socket("localhost", 7777);

FileTransferProtocolsImp ftpi = new FileTransferProtocolsImp();
ftpi.readFolder(new File("C:\\Test1"), s);
while(true){
ftpi.upload("c:\\clientside2\\", s,"- ACKNOWLEDGEMENT RECEIVED");
}
}
}
