package com.socketprog;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;

public class FileTransferProtocolsImp implements FileTransferProtocols {
	FileOutputStream fos = null;

	@Override
	public void readFolder(final File folder, Socket s) throws IOException {

		File[] listOfFiles = folder.listFiles();
		BufferedReader br = null;
		System.out.println("the list of files===="+listOfFiles.length);
		
		if (listOfFiles != null) {
			for (File child : listOfFiles) {

				String stringData = "FILENAME," + child.getName();
                  System.out.println("the string data=="+stringData );
				br = new BufferedReader(new FileReader(child));
				byte[] b = new byte[30000];
				String k = br.readLine() ;          //readLine(b,0,b.length);
				System.out.println("readline data=="+k);
				k = ",FILEDATA," + k;
				System.out.println("readline filedata=="+k);
				stringData = stringData + k;
				System.out.println("readline filedata=="+stringData);
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				dos.writeUTF(stringData);

			}

			// Add if you want to delete the source folder

			//folder.delete();

		}

	}

	@Override
	public void upload(String fileFolder, Socket s,String verified) throws IOException {
		System.out.println("the upload method file folder name==" + fileFolder);
		DataInputStream dis = new DataInputStream(s.getInputStream());

		String k = dis.readUTF();
		System.out.println("the upload the k values==" + k);

		String[] param = k.split(",");
		for (String ss : param) {
			System.out.println(ss);

		}

		if (param[0].equals("FILENAME")) {
			fos = new FileOutputStream(fileFolder + param[1]);
			System.out.println("param[0]===" + fileFolder + param[1]);
			// byte[] b = param[1].getBytes();
			// fos.write(b);
		}

		if (param[2].equals("FILEDATA")) {
			String receivedData=param[3]+verified;
			byte[] b = receivedData.getBytes();
			fos.write(b);
		}

	}

	@Override
	public void delete() {

	}

	@Override
	public void writeFolder() {

	}

}
