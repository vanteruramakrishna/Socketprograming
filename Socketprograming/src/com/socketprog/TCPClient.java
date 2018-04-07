package com.socketprog;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		transferProtocal();
	}

	public static void transferProtocal() throws UnknownHostException,
			IOException {

		Socket s = new Socket("localhost", 7777);

		FileTransferProtocolsImp ftpi = new FileTransferProtocolsImp();
		ftpi.readFolder(new File("C:\\Test"), s);
		while(true){
		ftpi.upload("c:\\clientside\\", s,"- ACKNOWLEDGEMENT RECEIVED");
		}
//		}
//		DataInputStream dis = new DataInputStream(s.getInputStream());
//		String kC1 = dis.readUTF();
//		kC1 = kC1 + "-ACKNOWLEDGE RECEIVED";
//		System.out.println("File Transferred");
//		FileOutputStream fos = new FileOutputStream("c:\\clientside\\c.txt");
//		byte[] b1 = kC1.getBytes();
//		fos.write(b1);

	}
}
