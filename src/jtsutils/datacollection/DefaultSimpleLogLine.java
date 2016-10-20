package jtsutils.datacollection;

import jtsutils.enums.DEFAULT_VALUE;
import jtsutils.enums.LOG_TYPE;

/**
 * Class Mô tả một dòng log mặc định
 * @author hbc
 *
 */
public class DefaultSimpleLogLine extends SimpleLogLine{
	
	/**
	 * Tao ra mot doi tuong DefaultSimpleLogLine
	 * @param type
	 * 		kieu log truyen vao
	 * @param message
	 * 		thong bao truyen vao
	 * @param timeString
	 * 		thoi gian xay ra
	 */
	public DefaultSimpleLogLine(LOG_TYPE type, String message, String timeString) {
		super(DEFAULT_VALUE.LOG_FILENAME, type, message, timeString);
	}
}
