package jtsutils.ultils;


import jtsutils.enums.DEFAULT_VALUE;
import jtsutils.enums.LOG_TYPE;

/**
 * Class gồm các hàm tiện ích dùng để báo cáo
 * @author hbc
 *
 */
public class Report {
	private static String userName = DEFAULT_VALUE.CURENT_USER;
	private static String DEFAULT_LOG_FILENAME = DEFAULT_VALUE.LOG_FILENAME;
	
	/**
	 * LOG HEADER
	 */
	private static String LOG_HEADER = getLogHeader();
	
	/**
	 * Ghi thong bao vao file log, dat cung thu muc, file log co ten log.txt
	 * 
	 * @param type
	 * 			kieu thong bao
	 * @param message
	 *          thong bao can ghi
	 * @param timeString
	 * 			thoi gian log
	 * @throws FileNotFoundException 
	 */
	public static void writeLog(LOG_TYPE type, String message, String timeString){
		writeLog(DEFAULT_LOG_FILENAME, type, message, timeString);
	}
	
	/**
	 * Ghi thong bao vao file
	 * 
	 * @param logFileName
	 * 			duong dan den file log can ghi
	 * @param type
	 * 			kieu thong bao
	 * @param message
	 *          thong bao can ghi
	 * @param timeString
	 * 			thoi gian log
	 * @throws FileNotFoundException 
	 */
	public static void writeLog(String logFileName, LOG_TYPE type, String message, String timeString){
		
		// Format [time] [type] [user] [error_detail]
		String log_line = "[" + timeString + "] [" + type.message() + "] [" + userName + "] "
				+ message;
		if (!File.isExisted(logFileName)) {
			File.appendAllText(logFileName, LOG_HEADER + log_line);
		} else {
			File.appendAllText(logFileName, log_line);
		}
	}
	
	/**
	 * In ra man hinh console dong thong bao
	 * @param message
	 * 		thong bao truyen vao
	 */
	public static void report(String message){
		System.out.println(message);
	}
	
	/**
	 * ghi thong bao ra mot file theo dang append
	 * nghia la:
	 *  	neu file chua ton tai thi tao file moi,
	 * 		neu file da ton tai thi se message se duoc them vao cuoi file
	 * @param fileName
	 * 		duong dan toi file can ghi
	 * @param message
	 * 		thong bao can ghi, tu dong them dau xuong hang "\n" cuoi message truyen vao
	 */
	public static void reportToFileInAppendMode(String fileName, String message){
		File.appendAllText(fileName, message + "\n");
	}
	
	/**
	 * ghi thong bao ra mot file theo dang write
	 * nghia la:
	 *  	neu file chua ton tai thi tao file moi,
	 * 		neu file da ton tai thi se bi ghi de
	 * @param fileName
	 * 		duong dan toi file can ghi
	 * @param message
	 * 		thong bao can ghi, tu dong them dau xuong hang "\n" cuoi message truyen vao
	 */
	public static void reportToFileInWriteMode(String fileName, String message){
		File.writeAllText(fileName, message + "\n");
	}
	
	private static String getLogHeader()
	{
		String cm = "";
		cm += "========================================================================================================================\n";
		cm += "||                         [#Time(MM/dd/yyyy HH:mm:ss)] [message_type] [user] [error_detail]                          ||\n";
		cm += "========================================================================================================================\n";
		return cm;
	}
}
