package com.nexops.auto.remediate.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.spec.KeySpec;
import java.util.Base64.Decoder;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.codec.binary.Base64;

public class Utility {

	//Mantis 0000670
	public static void sendEmail(String fromEmailId,String fromPassword,String toEmailId,String ccuser,String host,String subject,String body,String port,List<String> filename) throws IOException  //Mantis 0000682 //Mantis 0000711,0001106
	, AddressException
	{
		//String touser = toEmailId ;
		String fromuser = fromEmailId;
		String user_password=fromPassword;
		String hostname=host;
		String[] recipientList = toEmailId.split(",");   //Mantis 0001106
		InternetAddress[] ccreceipientaddress = null;
		InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
		int counter = 0;
		for (String recipient : recipientList) 
		{
			recipientAddress[counter] = new InternetAddress(recipient.trim());
			counter++;
		}
		
		if(!(ccuser.isEmpty()))
		{
			String[] ccreceipientlist = ccuser.split(",");   //Mantis 0001106
			ccreceipientaddress = new InternetAddress[ccreceipientlist.length];
			int countercc = 0;
			for (String ccrecipient : ccreceipientlist) 
			{
				ccreceipientaddress[countercc] = new InternetAddress(ccrecipient.trim());
				countercc++;
			}
		}

		//Get the session object  
		Properties props = new Properties();  
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host",hostname); 
		props.put("mail.smtp.port", port);
		props.put("mail.debug", "true");
		
		Session session = Session.getDefaultInstance(props,  
				new javax.mail.Authenticator() 
		{  
			protected PasswordAuthentication getPasswordAuthentication() 
			{  
				return new PasswordAuthentication(fromuser,user_password);  
			}  
		});   

		//compose the message  
		try{  
			MimeMessage message = new MimeMessage(session);  
			message.setFrom(new InternetAddress(fromuser));  
			message.setRecipients(Message.RecipientType.TO, recipientAddress);  //Mantis 0001106
			
			if(!(ccuser.isEmpty()))
			{
				message.setRecipients(Message.RecipientType.CC, ccreceipientaddress);  //Mantis 0001106
			}
			
			/*message.addRecipients(Message.RecipientType.TO, 
					InternetAddress.parse(touser));
			message.addRecipients(Message.RecipientType.CC, 
					InternetAddress.parse(ccuser));*/

			message.setSubject(subject);  

			//-----Mantis 0000682-----//

			BodyPart messageBodyPart1 = new MimeBodyPart(); 
			messageBodyPart1.setContent(body,"text/html");

			//create Multipart object and add MimeBodyPart objects to this object   
			Multipart multipart = new MimeMultipart();  
			multipart.addBodyPart(messageBodyPart1);  

			//Mantis 0000711
			if(filename.size()!=0)
			{
				for(int i=0;i<filename.size();i++)
				{
					MimeBodyPart messageBodyPart2 = new MimeBodyPart();
					DataSource source = new FileDataSource(filename.get(i));  
					messageBodyPart2.setDataHandler(new DataHandler(source)); 
					if(filename.get(i).contains("Debug_Log_")||filename.get(i).contains("Result_"))
					{
						String name=filename.get(i).substring(filename.get(i).lastIndexOf("\\")+1, filename.get(i).length());
						messageBodyPart2.setFileName("QTAF".concat("_"+name.substring(0,name.indexOf("_"))+"_Log.zip")); 
					}
					//Mantis 0000740
					else if(filename.get(i).toLowerCase().contains("resources"))
					{
						messageBodyPart2.setFileName("resources.zip"); 
					}
					else if(filename.get(i).toLowerCase().endsWith(".csv")) //Mantis 0000832
					{
						messageBodyPart2.setFileName(filename.get(i).substring(filename.get(i).lastIndexOf("/")+1, filename.get(i).length()));
					}
					else if(filename.get(i).toLowerCase().endsWith(".xls") || filename.get(i).toLowerCase().endsWith(".xlsx")) //Mantis 0000832
					{
						messageBodyPart2.setFileName(filename.get(i).substring(filename.get(i).lastIndexOf("/")+1, filename.get(i).length()));
					}
					else
					{
						messageBodyPart2.setFileName("QTAF_Results_Log.zip");     //Mantis 0001106
						//messageBodyPart2.setFileName("Appium_Log.zip"); 
					}
					multipart.addBodyPart(messageBodyPart2);  
				}
			}
			//set the multiplart object to the message object  
			message.setContent(multipart); 


			//-----Mantis 0000682-----//

			// Send message  
			Transport.send(message);  
			System.out.println("Email sent successfully....");  

		}catch (MessagingException mex) {mex.printStackTrace();}  
	}

	// Mantis 0000669
	public static String getSummaryReportTemplate()
	{


		String text="<h style=\"font-size:300%\"><b><u>Summary Report</u></b></h>"+"<br>"+"<br>"
				+"<head>"
				+"<style>"
				+"table, th, td {border:2px solid black; border-collapse:collapse;}"
				+"th, td {padding: 15px;}"
				+"</style>"
				+"</head>"
				+"<body>"
				+"<table style=\"width:100%; align:center\">"
				+ "<tr align='center'>"
				+ "<td bgcolor=\"###headercolor\"><b>Scenario<b></td>"         // Mantis 0000675
				+ "<td bgcolor=\"###headercolor\"><b>Test Steps<b></td>"       // Mantis 0000675
				+ "<td bgcolor=\"###headercolor\"><b>Status<b></td>"           // Mantis 0000675
				+ "<td bgcolor=\"###headercolor\"><b>Start Time<b></td>"       // Mantis 0000675
				+ "<td bgcolor=\"###headercolor\"><b>End Time<b></td>"         // Mantis 0000675
				+ "<td bgcolor=\"###headercolor\"><b>Total Time Taken<b></td>" // Mantis 0000675
				+ "</tr>"
				+ "<tr align='center'>"
				+ "<td>##scenario</td>"
				+ "<td>##teststeps</td>"
				+ "<td>##Status</td>"
				+ "<td>##Starttime</td>"
				+ "<td>##Endime</td>"
				+ "<td>##Totaltime</td>"
				+ "</tr>"
				+"</table>"    
				+"</body>";
		return text;

	}


	//-----Mantis 0000682-----//
	public static String zipFolder(String debugFolder) throws Exception
	{
		String sourceFolderName = null;
		String zipFolderName = null;

		//------Mantis 0000710----//
		File debugfile=new File(debugFolder);
		if(debugfile.isDirectory())
		{
			sourceFolderName =debugFolder;
			zipFolderName = sourceFolderName.concat(".zip");
		}
		else
		{
			sourceFolderName =debugFolder;
			String logfolder=debugFolder.substring(0, debugFolder.indexOf('.'));
			zipFolderName = logfolder.concat(".zip");
		}
		//------Mantis 0000710----//

		FileOutputStream fos = new FileOutputStream(zipFolderName);
		ZipOutputStream zos = new ZipOutputStream(fos);
		//level - the compression level (0-9)
		zos.setLevel(9);

		System.out.println("Begin to compress folder : " + sourceFolderName + " to " + zipFolderName);
		addFolder(zos, sourceFolderName, sourceFolderName);

		zos.close();
		System.out.println("Debug folder zipped successfully!");
		return zipFolderName;
	}

	private static void addFolder(ZipOutputStream zos,String folderName,String baseFolderName)throws Exception{
		File f = new File(folderName);
		if(f.exists())
		{

			if(f.isDirectory())
			{

				//For pointing out missing entry for empty folder
				if(!folderName.equalsIgnoreCase(baseFolderName))
				{
					String entryName = folderName.substring(baseFolderName.length()+1,folderName.length()) + File.separatorChar;
					System.out.println("Adding folder entry " + entryName);
					ZipEntry ze= new ZipEntry(entryName);
					zos.putNextEntry(ze);    
				}
				File f2[] = f.listFiles();
				for(int i=0;i<f2.length;i++)
				{
					addFolder(zos,f2[i].getAbsolutePath(),baseFolderName);    
				}
			}
			else
			{
				//add file
				//extract the relative name for entry purpose
				if(!baseFolderName.equalsIgnoreCase(folderName))
				{
					String entryName = folderName.substring(baseFolderName.length()+1,folderName.length());
					System.out.print("Adding file entry " + entryName + "...");
					ZipEntry ze= new ZipEntry(entryName);
					zos.putNextEntry(ze);
					FileInputStream in = new FileInputStream(folderName);
					int len;
					byte buffer[] = new byte[1024];
					while ((len = in.read(buffer)) > 0) 
					{
						zos.write(buffer, 0, len);
					}
					in.close();
					zos.closeEntry();
					System.out.println("OK!");
				}
				//------Mantis 0000710----//
				else if(baseFolderName.equalsIgnoreCase(folderName))
				{
					String entryName = folderName.substring(folderName.lastIndexOf("/")+1,folderName.length());
					System.out.print("Adding file entry " + entryName + "...");
					ZipEntry ze= new ZipEntry(entryName);
					zos.putNextEntry(ze);
					FileInputStream in = new FileInputStream(folderName);
					int len;
					byte buffer[] = new byte[1024];
					while ((len = in.read(buffer)) > 0) 
					{
						zos.write(buffer, 0, len);
					}
					in.close();
					zos.closeEntry();
					System.out.println("OK!");
				}
				//------Mantis 0000710----//
			}
		}
		else
		{
			System.out.println("File or directory not found " + folderName);
		}

	}
	//-----Mantis 0000682-----//

	public static String decryptpasssword(String encryptedString) throws Exception //Mantis 0001155 
	{
		String UNICODE_FORMAT = "UTF8";
		String DESEDE_ENCRYPTION_SCHEME = "DESede";
		KeySpec myKeySpec;
		SecretKeyFactory mySecretKeyFactory;

		String myEncryptionKey="neverUnderEstimatePowerOfCom0n@Man";
		String myEncryptionScheme=DESEDE_ENCRYPTION_SCHEME;
		byte[] keyAsBytes=myEncryptionKey.getBytes(UNICODE_FORMAT);
		myKeySpec = new DESedeKeySpec(keyAsBytes);
		mySecretKeyFactory = SecretKeyFactory.getInstance(myEncryptionScheme);
		Cipher cipher = Cipher.getInstance(myEncryptionScheme);
		SecretKey key = mySecretKeyFactory.generateSecret(myKeySpec);

		String decryptedText=null;
		cipher.init(Cipher.DECRYPT_MODE, key);
		Decoder base64decoder=java.util.Base64.getDecoder();
		byte[] encryptedText = base64decoder.decode(encryptedString);
		byte[] plainText = cipher.doFinal(encryptedText);
		decryptedText= bytes2String(plainText);

		return decryptedText;
	}
	private static String bytes2String(byte[] bytes) 
	{
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i <bytes.length; i++)
		{
			stringBuffer.append((char) bytes[i]);
		}
		return stringBuffer.toString();
	}
	
	/*-------------- Multilicense decryption code for Mobile Framework Start (Mantis #0000718)----------------*/

	/*--------------------------------------- START : hash ---------------------------------------------- */
	public static String hash(String testString) throws Exception
	{
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] messageDigest = md.digest(testString.getBytes());       
		BigInteger number = new BigInteger(1, messageDigest);
		String hashtext = number.toString(16);
		while (hashtext.length() < 32)
		{
			hashtext = "0" + hashtext;
		}       
		return hashtext;
	} 


	/*--------------------------------------- START : Decryption ----------------------------------------------*/

	public static String decrypt(String key, String initVector, String encrypted) throws Exception
	{

		IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));		
		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"),"AES");			
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");			
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
		byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));			
		return new String(original);

	}


	/*--------------------------------------- START : getKey ----------------------------------------------*/
	public static String getKey(String line) throws Exception	 
	{ 
		String keyString=line.substring(32,line.length());

		return keyString;	     
	}


	/*--------------------------------------- START : gethash ----------------------------------------------*/
	public static String getHash(String line) throws Exception	 
	{  
		String keyString=line.substring(0,32);    

		return keyString;	     
	}

	/*-------------- Multilicense decryption code for Mobile Framework End (Mantis #0000718)----------------*/

}
