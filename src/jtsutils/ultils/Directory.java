package jtsutils.ultils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Class gồm các hàm tiện ích thao tác với thư mục
 * @author hbc
 *
 */
public class Directory {
	/**
	 * Kiem tra xem mot thu muc co ton tai hay khong
	 * 
	 * @param dirPath
	 *            Duong dan thu muc can kiem tra
	 * @return Tra ve true neu thu muc ton tai, false neu nguoc lai
	 */
	public static boolean isExisted(String dirPath) {
		File dir = new File(dirPath);
		if (dir.exists() && dir.isDirectory()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Tao mot thu muc theo duong dan truyen vao
	 * 
	 * @param dirPath Duong dan thu muc can tao
	 */
	public static void create(String dirPath)
	{
		File theDir = new File(dirPath);
		
		// if the directory does not exist, create it
		if (!theDir.exists()) {
			theDir.mkdir();
		}
	}
	
	/**
	 * Lay ve duong dan cua thu muc hien tai
	 * 			ex: /home/hbc/(linux) or D:\hbc\(windows)
	 * 
	 * @return 
	 * 		   Tra ve duong dan cua thu muc bin neu o che do debug cua ide neu
	 *         release thanh file jar thi tra ve duong dan chua file jar
	 */	
	public static String getCurrentDirectory(){
		try{
//			return URLDecoder.decode((new File(Directory.class.getProtectionDomain().getCodeSource().getLocation().getPath()) + File.separator), "UTF-8");
			return URLDecoder.decode((new File(Directory.class
					.getProtectionDomain().getCodeSource().getLocation()
					.getPath()).getParent()), "UTF-8")
					+ File.separator;
		}catch(UnsupportedEncodingException ext)
		{
			return null;
		}
	}
}
