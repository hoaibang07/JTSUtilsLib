package jtsutils.ultils;

import java.text.SimpleDateFormat;
import java.util.Date;

import jtsutils.enums.DEFAULT_VALUE;

/**
 * Class gồm các hàm tiện ích truy xuất ngày giờ
 * @author hbc
 *
 */
public class DateTime {

	/**
	 * Lay ve chuoi thoi gian hien tai cua he thong
	 * 
	 * @param dateFormat
	 *            Dinh dang ngay thang nam, vi du dd/MM/yyyy
	 * @param addTime
	 *            neu la true thi chuoi se co them thoi gian
	 * @param addMilisecond
	 *            neu true thi thoi gian se co milisecond
	 * @return chuoi thoi gian hien tai cua he thong
	 */
	private static String _getCurrentDateTime(String dateFormat, boolean addTime,
			boolean addMilisecond){
		SimpleDateFormat sdfDate = new SimpleDateFormat(dateFormat + " HH:mm:ss.SSS");
	    Date now = new Date();
	    String dateTimeNow = sdfDate.format(now);
		if (addTime) {
			
			//neu them milisecond trong ket qua tra ve
			if(addMilisecond)
			{
				return dateTimeNow;
			}
			else
			{
				return dateTimeNow.substring(0, 19);
			}
		}
		else{
			return dateTimeNow.substring(0, 10);
		}
	}
	
	/**
	 * Tra ve thoi gian hien tai cua he thong theo dinh dang ngay truyen vao
	 * @param dateFormat
	 * 		dinh dang cua ngay
	 * @return
	 * 		ngay gio, ex 09/21/2016 05:01:01
	 */
	public static String getCurrentDateTime(String dateFormat)
	{
		return _getCurrentDateTime(dateFormat, true, false);
	}
	
	/**
	 * Tra ve thoi gian hien tai cua he thong theo dinh dang ngay truyen vao
	 * @param dateFormat
	 * 		dinh dang cua ngay
	 * @return
	 * 		ngay gio bao gom milisecond, ex: 09/21/2016 05:01:01.123
	 */
	public static String getCurrentDateTimeIncludeMilisecond(String dateFormat)
	{
		return _getCurrentDateTime(dateFormat, true, true);
	}
	
	/**
	 * Tra ve ngay gio hien tai cua he thong theo dinh dang ngay mac dinh
	 * @return
	 * tra ve ngay gio, ex: 09/21/2016 05:05:01
	 */
	public static String getDefaultCurrentDateTime(){
		return _getCurrentDateTime(DEFAULT_VALUE.DATE_FORMAT, true, false);
	}
	
	/**
	 * Tra ve ngay gio hien tai cua he thong theo dinh dang mac dinh
	 * bao gom ca milisecond
	 * @return
	 * tra ve ngay gio, ex: 09/21/2016 05:05:01.123
	 */
	public static String getDefaultCurrentDateTimeInclueMilisecond()
	{
		return _getCurrentDateTime(DEFAULT_VALUE.DATE_FORMAT, true, true);
	}
	
	/**
	 * Lay ve ngay hien tai cua he thong theo dinh dang ngay truyen vao
	 * @param dateFormat
	 * 		dinh dang ngay truyen vao, ex: MM-dd-yyyy 
	 * @return
	 * 		ngay hien tai cua he thong theo dinh dang truyen vao
			ex: MM/dd/yyyy: 09/21/2016
	 */
	public static String getCurrentDate(String dateFormat)
	{
		return _getCurrentDateTime(dateFormat, false, false);
	}
	
	/**
	 * Lay ve ngay hien tai cua he thong theo dinh dang mac dinh
	 * 
	 * @return
	 * 		ngay hien tai cua he thong theo dinh dang truyen vao
			ex: MM/dd/yyyy: 09/21/2016
	 */
	public static String getDefaultCurrentDate()
	{
		return _getCurrentDateTime(DEFAULT_VALUE.DATE_FORMAT, false, false);
	}
	
	/**
	 * tra ve thoi gian hien tai cua he thong
	 * @return
	 */
	public static String getCurrentTime(){
		String dateTimeAll = _getCurrentDateTime(DEFAULT_VALUE.DATE_FORMAT, true, true);
		return dateTimeAll.substring(11, 19);
	}
	
	/**
	 * Tra ve thoi gian hien tai cua he thong, bao gom ca milisecond
	 * @return
	 */
	public static String getCurrentTimeIncludeMilisecond(){
		String dateTimeAll = _getCurrentDateTime(DEFAULT_VALUE.DATE_FORMAT, true, true);
		return dateTimeAll.substring(11);
	}
}
