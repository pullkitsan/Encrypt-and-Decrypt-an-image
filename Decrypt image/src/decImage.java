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


public class decImage {

	public static void main(String[] args)
	{
		try
		{
		 Cipher dcipher = Cipher.getInstance("AES");
		 dcipher.init(Cipher.DECRYPT_MODE, args[1]);
		 
		
		 File f1=new File(args[0]);
		 FileInputStream
		
		}
		catch ( Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
}
