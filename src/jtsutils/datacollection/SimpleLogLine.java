package jtsutils.datacollection;

import jtsutils.enums.LOG_TYPE;

/**
 * Class mô tả dòng log, extends từ class History
 * @author hbc
 *
 */
public class SimpleLogLine extends History{
	protected String logFileName;
	protected LOG_TYPE type;
	
	/**
	 * Khoi tao mot dong log
	 * @param logFileName
	 * 		log File ghi
	 * @param type
	 * 		kieu log
	 * @param message
	 * 		thong bao log
	 * @param timeString
	 * 		thoi gian xay ra
	 */
	public SimpleLogLine(String logFileName, LOG_TYPE type, String message, String timeString) {
		super(message, timeString);
		this.logFileName = logFileName;
		this.type = type;
	}
	
	/**
	 * Tra ve LogFileName cua LogLine hien tai
	 * @return
	 */
	public String getLogFileName()
	{
		return logFileName;
	}
	
	/**
	 * Tra ve kieu log
	 * @return
	 */
	public LOG_TYPE getLogType()
	{
		return this.type;
	}
}
