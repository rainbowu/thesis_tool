package com.line.decrypt;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.HashMap;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;


// external library:
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class Decryption {
	
	final static Base64 base64 = new Base64();
	
	public static final byte[] key = {
		// bad word key:
		76, -86, -111, 47, -128, -21, 62, -44, 4, -91, 44, 60, 72, -46, 91, -42, -9, 46, -127, -110, -37, 85, -98, 73, -86, 27, -103, 103, -25, 81, 117, -89
	}; 
	
	public  String androidid = "b9de07a51366a54d";

	public static final long  magic_number_setting = 15485863 ;
	
	public static final long  magic_number_channels = 13637594 ;
	
	public String decrypt_aes(String encryptedFile, String android_id) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException { 	
		
		byte[] encryptedBytes = base64.decode(encryptedFile);
		// channel key:
		SecretKeySpec secretKey = new SecretKeySpec( generate_key_channel(magic_number_channels, android_id), "AES");
	
		// setting key
//		SecretKeySpec secretKey = new SecretKeySpec( generate_key_utility(magic_number_setting, android_id), "AES");
	
		
		Security.addProvider(new BouncyCastleProvider());
		Cipher c = Cipher.getInstance("AES", new BouncyCastleProvider());
		c.init(Cipher.DECRYPT_MODE, secretKey);
		String decryptedWords = new String(c.doFinal(encryptedBytes), "UTF-8"); 
		
		
		return decryptedWords;
	}
	
	public final static byte[] generate_key_utility(long magicNumber , String androidid)
	{
		if (androidid == null) 
			androidid = ""; 
		int i = androidid.hashCode();
		return generateKeyFromHash((byte)i, magicNumber);
	}
	
	public static final byte[] generate_key_channel(Long paramLong,String android_id)
	{
	   
		HashMap a = new HashMap();

		byte[] arrayOfByte = (byte[])a.get(paramLong);
	    if (arrayOfByte == null);
	    try
	    {
	      arrayOfByte = (byte[])a.get(paramLong);
	      if (arrayOfByte == null)
	      {
	        arrayOfByte = generate_key_utility(paramLong.longValue() , android_id);
	        a.put(paramLong, arrayOfByte);
	      }
	      return arrayOfByte;
	    }
	    finally
	    {
	    }
	}	
	
	public static byte[] generateKeyFromHash(byte paramByte, long paramLong) {
		   int i = 0;
		    byte[] arrayOfByte1 = new byte[16];
		    arrayOfByte1[0] = paramByte;
		    arrayOfByte1[1] = ((byte)(paramByte - 71));
		    arrayOfByte1[2] = ((byte)(-71 + (paramByte - 71)));
		    for (int j = 3; j < 16; j++)
		      arrayOfByte1[j] = ((byte)(j ^ (0xFFFFFFB9 ^ (arrayOfByte1[(j - 3)] ^ arrayOfByte1[(j - 2)]))));
		    int k = -7;
		    byte[] arrayOfByte2 = arrayOfByte1.clone();
		    int m = arrayOfByte2.length;
		    if ((paramLong < 2L) && (paramLong > -2L))
		      paramLong = -313187L + 13819823L * paramLong;
		    int n = 0;
		    while (n < m)
		    {
		      int i1 = i + 1 & m - 1;
		      long l = paramLong * arrayOfByte2[i1] + k;
		      k = (byte)(int)(l >> 32);
		      int i2 = (int)(l + k);
		      if (i2 < k)
		      {
		        i2++;
		        k++;
		      }
		      arrayOfByte2[i1] = ((byte)(-2 - i2));
		      n++;
		      i = i1;
		    }
		    return arrayOfByte2;
	}
	
}
