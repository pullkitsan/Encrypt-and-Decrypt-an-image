import java.util.*;
import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;


import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.imageio.stream.FileImageInputStream;

public class encImg {

	public static void main(String[] args)
	{
		try { 
		
			KeyGenerator kGen= KeyGenerator.getInstance("AES");
			SecureRandom sRan= new SecureRandom();
			kGen.init(256,sRan);
			Key key=kGen.generateKey();
			
			//Generate initialization vector
			
			byte[] ivRan = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
			IvParameterSpec ivspec = new IvParameterSpec(ivRan); 
			
			
			//Create the cipher instance and initialize it 
			Cipher pEnc = Cipher.getInstance("AES/CBC/PKCS5Padding");
			pEnc.init(Cipher.ENCRYPT_MODE,key,ivspec);  //initialization of encryption
					
			//Encrypting the input png file
			File f1=new File(args[0]);
		    FileInputStream iStream=new FileInputStream(f1);
		    CipherInputStream cStream=new CipherInputStream(iStream,pEnc);
		    System.out.println("The Encryption key is :"+key.getEncoded()+" Please save it for decryption purpose.");
		    
		    
		    //Sending the file to output stream
		    FileOutputStream oStream=new FileOutputStream(new File("EncFile.png"));
		    int i;
		    while((i=cStream.read())!=-1)
		    {
		    	oStream.write(i);
		    }
		    
		}
		
		
		catch(Exception ex )
		{
			ex.printStackTrace();
		}
			
	}
	
}

