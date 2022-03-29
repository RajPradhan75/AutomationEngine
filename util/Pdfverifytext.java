package com.nexops.auto.remediate.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.JPEGFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;

public class Pdfverifytext {

	public static	List<String> finalresult = new ArrayList<String>(); // Variable to store the verified lines 
	public static int cp =0;
	public static PDFTextStripper globtxtstrip ;
	public static COSDocument globcosdoc;

	/*public static void main(String args[]) throws IOException 
	{
		System.out.println(FindTextCompletePdf("C:\\Users\\anums\\Documents\\dashbaordpic.pdf", "Dashboard"));
	}*/

	private static void connectfile(String filepath) throws IOException
	{
		System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
		File file = new File(filepath);  // Declaring file 
		FileInputStream fis = new FileInputStream(file); //FileInputStream is useful to read data from a file 
		RandomAccessRead source = new RandomAccessBuffer(fis);
		PDFParser parser = new PDFParser(source);
		parser.parse();
		globcosdoc =  parser.getDocument();
	}

	// To find a particular Text/String in entire PDF file, it will return number of occurrence found.
	public static int FindTextCompletePdf(String filepath, String Searchtext) throws IOException
	{
		globtxtstrip = new PDFTextStripper();
		connectfile(filepath);
		PDDocument pddoc = new PDDocument(globcosdoc);
		int a = pddoc.getNumberOfPages();
		globtxtstrip.setStartPage(1); // Strip pdf from page
		globtxtstrip.setEndPage(a); // Strip pdf to page
		String alltext = globtxtstrip.getText(pddoc);
		int lastIndex = 0;
		int count = 0;
		while (lastIndex != -1)
		{
			lastIndex = alltext.toLowerCase().indexOf(Searchtext.toLowerCase(),lastIndex);
			if( lastIndex != -1)
			{
				count++;
				lastIndex += Searchtext.length();
			}
		}
		return count;
	}

	// To find a particular Text/String in specific page of PDF file, it will return number of occurrence found.
	public static int FindTextPdfSinglePage(String filepath, String Searchtext, int page)throws IOException
	{
		globtxtstrip = new PDFTextStripper();
		connectfile(filepath);
		PDDocument pddoc = new PDDocument(globcosdoc);
		globtxtstrip.setStartPage(page); // Strip pdf from page
		globtxtstrip.setEndPage(page); // Strip pdf to page
		String alltext = globtxtstrip.getText(pddoc);
		int lastIndex = 0;
		int count = 0;
		while (lastIndex != -1)
		{
			lastIndex = alltext.toLowerCase().indexOf(Searchtext.toLowerCase(),lastIndex);
			if( lastIndex != -1)
			{
				count++;
				lastIndex += Searchtext.length();
			}
		}
		return count;
	}

	// To find a particular Text/String in specific page range of PDF file, it will return number of occurrence found.
	public static int FindTextPdfPageRange(String filepath, String Searchtext, int startpage, int endpage) throws IOException
	{
		int lastIndex = 0;
		int count = 0;
		globtxtstrip = new PDFTextStripper();
		if (startpage<=endpage)
		{
			connectfile(filepath);
			PDDocument pddoc = new PDDocument(globcosdoc);
			globtxtstrip.setStartPage(startpage); // Strip pdf from page
			globtxtstrip.setEndPage(endpage); // Strip pdf to page
			String alltext = globtxtstrip.getText(pddoc);

			while (lastIndex != -1)
			{
				lastIndex = alltext.toLowerCase().indexOf(Searchtext.toLowerCase(),lastIndex);
				if( lastIndex != -1)
				{
					count++;
					lastIndex += Searchtext.length();
				}
			}

		}
		else
		{
			System.out.println("Input Paramater: Start Page should be <= End Page");
		}
		return count;
	}


	//To get the pages list in which the expected text/string found, it returns array integer list of page number
	public static int[] TextinPage(String filepath, String Searchtext) throws IOException
	{
		int[] returnvalue = null;
		int[] returnvalues = null;
		globtxtstrip = new PDFTextStripper();
		connectfile(filepath);
		PDDocument pddoc = new PDDocument(globcosdoc);
		int a = pddoc.getNumberOfPages();
		returnvalue = new int[a];
		int j=0;
		for(int i=1;i<=a;i++) 
		{
			globtxtstrip.setStartPage(i); // Strip pdf from page
			globtxtstrip.setEndPage(i); // Strip pdf to page
			String alltext = globtxtstrip.getText(pddoc);
			if((alltext.toLowerCase()).contains(Searchtext.toLowerCase()))
			{
				returnvalue[j] = i;
				j=j+1;
			}
		}
		returnvalues = new int[j];	
		for(int k = 0; k<j;k++ )
		{
			returnvalues[k]=returnvalue[k];			
		}
		return returnvalues;
	}

	//To get the pages number with line number in which the expected text/string found, it returns array String list of line number with page number
	public static List<String> TextinPageLine(String filepath, String SearchString, int startPage, int endPage, String ExactMatch) throws IOException  //IOException as it read file 
	{
		globtxtstrip = new PDFTextStripper();
		List<String> results = null; // Variable to store result of pdf file read output 
		connectfile(filepath);
		PDDocument pddoc = new PDDocument(globcosdoc);
		if(endPage>=startPage && endPage<=pddoc.getNumberOfPages())
		{
			for( int k = startPage; k <= endPage ; k++)
			{
				globtxtstrip.setStartPage(k); // Strip pdf from page
				globtxtstrip.setEndPage(k); // Strip pdf to page
				String x1= globtxtstrip.getText(pddoc); // Store Striped data to string 
				results= Arrays.asList(x1.split("\r\n")); // break complete data in lines and store in list 
				if (ExactMatch=="Yes")
				{
					//System.out.println("Exact match yes Start");
					setExactResult(k, results, SearchString);
					//	System.out.println("Exact match yes Start");
				}
				else
				{
					setResult(k, results, SearchString);
				}
			}
		}
		else
		{
			if (endPage>pddoc.getNumberOfPages())
			{
				System.out.println("Invalid Page parameter, Max page in pdf is "+ pddoc.getNumberOfPages());
			}
			else
			{
				System.out.println("Invalid Page parameter, End Page value is greater then Start Page");
			}
		}
		pddoc.close();
		return finalresult; // return list array data
	}
	// Called in TextinPageLine to set the result 
	public static void setExactResult(int Page, List<String> results , String SearchString )
	{
		int len = results.size();
		int add=0;
		for(int i=0;i<len;i++)
		{
			if((results.get(i).toLowerCase()).contains(SearchString.toLowerCase()))
			{
				int tt =0;
				String string = results.get(i).toLowerCase();
				String[] spart = SearchString.toLowerCase().split(" ");
				int slen = spart.length;
				if (slen>1)
				{
					String[] cpart = string.split(" ");
					int clen = cpart.length;

					String kk;
					String tStr1=null,tStr2=null;
					for(int ii=0;ii<clen;ii++)
					{
						if(cpart[ii].equals(spart[0]))
						{
							tStr1 = SearchString.toLowerCase();
							tStr2=cpart[ii];
							int ttp = slen;
							for(int tp = 1; tp<ttp; tp++)
							{
								tStr2= tStr2.concat(" "+cpart[ii+tp]);
							}

							if(tStr1.equals(tStr2))
							{	
								tt=tt+1;
								add=1;
							}
						}
					}
					if(add==1)
					{
						add=0;
						kk= ""+ SearchString.toLowerCase()+ " found in Page "+ Page +" Line : "+ (i+1) + " Number of Times  :"+ tt;
						cp=cp+1;
						finalresult.add(cp-1,kk);
					}
				}
				else
				{
					String[] parts = string.split(" ");
					for (int kk = 0; kk<parts.length;kk++)
					{
						if(SearchString.toLowerCase().equals(parts[kk].toLowerCase())) {
							tt=tt+1;
						}
					}
					String aa;
					int k =i+1;
					if(tt>0)
					{ 
						aa= ""+ SearchString.toLowerCase()+ " found in Page "+ Page +" Line : "+ i + " Number of Time :"+ tt;
						cp=cp+1;
						finalresult.add(cp-1,aa);
					}
					else
					{
						aa = "'"+SearchString + "': found in Page : "+Page+" Line: "+ k + " without exact match";
					}
				}
			}
		}
	}

	// Called in TextinPageLine to set the result 
	public static void setResult(int Page, List<String> results , String SearchString )
	{
		int len = results.size();
		for(int i=0;i<len;i++)
		{

			if((results.get(i).toLowerCase()).contains(SearchString.toLowerCase()))
			{
				cp=cp+1;
				int k =i+1;
				String aa = "'"+SearchString + "': found in Page : "+Page+" Line: "+ k;
				finalresult.add(cp-1,aa);
			}

		}
	}
	public static boolean createPDF(String fileName,String text,String imageName) throws FileNotFoundException, IOException
	{
		System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
		PDDocument doc = new PDDocument(); // creating instance of pdfDoc
		PDPage page = new PDPage();
		doc.addPage(page); // adding page in pdf doc file
		PDImageXObject image;
		image = JPEGFactory.createFromStream(doc, new FileInputStream(imageName));	
		PDPageContentStream contant = new PDPageContentStream(doc, page);
		contant.drawImage(image, 2, 400 );
		contant.beginText();
		contant.setFont(PDType1Font.COURIER_BOLD, 36);
		contant.newLineAtOffset(120,720);
		contant.showText(text);
		contant.endText();
		contant.close();
		doc.save(fileName); // saving as pdf file with name perm 
		doc.close(); // cleaning memory 
		System.out.println("your file created in : "+ System.getProperty("user.dir"));
		return true;
	}
	public static boolean createPDF(String fileName,String text) throws FileNotFoundException, IOException
	{
		System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
		PDDocument doc = new PDDocument(); // creating instance of pdfDoc
		PDPage page = new PDPage();
		doc.addPage(page); // adding page in pdf doc file
		PDPageContentStream contant = new PDPageContentStream(doc, page);
		contant.beginText();
		contant.setFont(PDType1Font.COURIER_BOLD, 11);
		contant.newLineAtOffset(10, 700);
		contant.showText(text);
		contant.endText();
		contant.close();
		doc.save(fileName); // saving as pdf file with name perm 
		doc.close(); // cleaning memory 
		System.out.println("your file created in : "+ System.getProperty("user.dir"));
		return true;
	}
}
