import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.net.Socket;


public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bytesRead;
	    int current = 0;
		try{      
			Socket s=new Socket("localhost",6666);  
			
			byte [] mybytearray  = new byte [2000];
			InputStream is = s.getInputStream();
			File file=new File("c:\\Test\\a.txt");
			BufferedReader br = new BufferedReader(new FileReader(file)); 
            byte [] b = new byte[3000]; 
            String k = br.readLine(); 
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
            dos.writeUTF(k); 
            System.out.println("Transfer Complete");
            
            
            DataInputStream dis = new DataInputStream(s.getInputStream()); 
            String kC1=dis.readUTF(); 
            kC1=kC1+"-ACKNOWLEDGE RECEIVED";
            System.out.println("File Transferred"); 
            FileOutputStream fos = new FileOutputStream("c:\\clientside\\c.txt"); 
            byte[] b1 = kC1.getBytes(); 
            fos.write(b1);
            
            
			}catch(Exception e){System.out.println(e);}  
		
			}  

	}


