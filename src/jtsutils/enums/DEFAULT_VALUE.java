package jtsutils.enums;

import jtsutils.ultils.Directory;
import jtsutils.ultils.SystemUT;

/**
 * Class gồm các biến static mô tả các giá trị mặc định
 * @author hbc
 *
 */
public class DEFAULT_VALUE {
	
	/**
	 * curent Directory, ex: /home/hbc
	 */
	public static String CURRENT_DIR = Directory.getCurrentDirectory();
	
	/**
	 * default log error file name
	 */
	public static String LOG_FILENAME = CURRENT_DIR + "log.txt";
	
	/**
	 * current user execute program
	 */
	public static String CURENT_USER = SystemUT.getCurrentUser();
	
	/**
	 * Default date format
	 */
	public static String DATE_FORMAT = "MM/dd/yyyy";

}
