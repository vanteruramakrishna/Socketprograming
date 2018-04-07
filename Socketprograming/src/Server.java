import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;




public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{  
			ServerSocket ss=new ServerSocket(6666);  
			Socket s=ss.accept();//establishes connection 
			DataInputStream dis = new DataInputStream(s.getInputStream()); 
            String k=dis.readUTF(); 
            k=k+"-VERIFIED_New";
            System.out.println("File Transferred"); 
            FileOutputStream fos = new FileOutputStream("c:\\serverside\\c.txt"); 
            byte[] b = k.getBytes(); 
            fos.write(b);
            
            
            //---------------------------------------------------------------
            
            File file=new File("c:\\serverside\\c.txt");
			BufferedReader br = new BufferedReader(new FileReader(file)); 
            byte [] s1 = new byte[3000]; 
            String k1 = br.readLine(); 
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
            dos.writeUTF(k); 
            
            
            
            
            
			}catch(Exception e){System.out.println(e);} 
		
	}

}
