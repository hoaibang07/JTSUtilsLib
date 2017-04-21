package jtsutils.ultils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Class gồm các hàm tiện ích thao tác với file
 * @author hbc
 *
 */
public class File {
	
	/**
	 * Tao mot file moi
	 * 
	 * @param fileName
	 *            Duong dan toi file can tao
	 */
	public static void createNewFile(String fileName){
		try{
			FileWriter fw = new FileWriter(fileName, true);
			fw.close();
		}catch(IOException io)
		{}
	}

	/**
	 * Kiem tra mot file da ton tai hay chua
	 * 
	 * @param fileName
	 *            Duong dan toi file
	 */
	public static boolean isExisted(String fileName) {
		java.io.File f = new java.io.File(fileName);
		if (f.exists() && !f.isDirectory()) {
			return true;
		}
		return false;
	}

	/**
	 * Doc tung dong cua file va ghi vao ArrayList
	 * 
	 * @param fileName
	 *            Duong dan toi file can doc
	 * @return ArrayList, moi phan tu cua ArrayList la mot dong doc duoc tu file
	 * @throws IOException
	 */
	public static ArrayList<String> fileToArrayList(String fileName)
			throws IOException {
		ArrayList<String> rs = new ArrayList<String>();

		java.io.File fin = new java.io.File(fileName);
		FileInputStream fis;
		fis = new FileInputStream(fin);

		// Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line = null;
		while ((line = br.readLine()) != null) {
			rs.add(line);
		}
		br.close();

		return rs;
	}

	/**
	 * ghi them noi dung vao mot file
	 * Neu file chua ton tai thi tao file va ghi vao
	 * Neu file da ton tai thi se ghi noi dung vao cuoi file
	 * @param fileName
	 * 		duong dan toi file can ghi
	 * @param content
	 * 		noi dung can ghi
	 */
	public static void appendAllText(String fileName, String content){
		try(FileWriter fw = new FileWriter(fileName, true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.print(content);
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
	}
	
	/**
	 * Ghi them noi dung va mot dong moi vao mot file
	 * Neu file chua ton tai thi tao file va ghi vao
	 * Neu file da ton tai thi se ghi noi dung vao cuoi file
	 * @param fileName
	 * 		duong dan toi file can ghi
	 * @param content
	 * 		noi dung can ghi
	 */
	public static void appendAllTextAddNewLine(String fileName, String content){
		try(FileWriter fw = new FileWriter(fileName, true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(content);
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
	}
	
	/**
	 * ghi noi dung vao mot file
	 * Neu file da ton tai thi se bi ghi de
	 * @param fileName
	 * 		duong dan toi file can ghi
	 * @param content
	 * 		noi dung can ghi
	 */
	public static void writeAllText(String fileName, String content){
		try(FileWriter fw = new FileWriter(fileName, false);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.print(content);
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
	}
	
	/**
	 * Xoa mot file voi duong dan truyen vao
	 * @param fileName
	 * @return
	 */
	public static boolean deleteFile(String fileName){
		java.io.File file = new java.io.File(fileName);
		if(file.delete()){
			return true;
		}else{
			return false;
		}
	}
	
}
