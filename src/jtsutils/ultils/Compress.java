package jtsutils.ultils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Class gồm các hàm liên quan đến xử lý nén file
 * @author hbc
 *
 */
public class Compress {
	
	/**
	 * Nen mot file thanh file zip
	 * @param source 
	 * 			file can nen
	 * @param output
	 * 			file output (zip)
	 * @return
	 * 		true neu nen thanh cong
	 * 		false neu khong thanh cong
	 */
	public static boolean zipFile(String source, String output)
	{		
		byte[] buffer = new byte[1024];

    	try{

    		FileOutputStream fos = new FileOutputStream(output);
    		ZipOutputStream zos = new ZipOutputStream(fos);
    		ZipEntry ze= new ZipEntry("ziplog");
    		zos.putNextEntry(ze);
    		FileInputStream in = new FileInputStream(source);

    		int len;
    		while ((len = in.read(buffer)) > 0) {
    			zos.write(buffer, 0, len);
    		}

    		in.close();
    		zos.closeEntry();

    		//remember close it
    		zos.close();

    		return true;

    	}catch(IOException ex){
    	   return false;
    	}
	}

}
