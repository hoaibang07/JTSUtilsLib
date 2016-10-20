package jtsutils.datacollection;

/**
 * Class mô tả một dòng lịch sử
 * @author hbc
 *
 */
public class History {
	/**
	 * thoi gian xay ra su kien
	 */
	protected String _timeString;
	
	/**
	 * thong bao cua su kien
	 */
	protected String _message;
	
	/**
	 * Tao mot doi tuong History
	 * @param message
	 * 		thong bao truyen vao
	 * @param timeString
	 * 		thoi gian xay ra
	 */
	public History(String message, String timeString)
	{
		_timeString = timeString;
		_message = message;
	}
	
	/**
	 * Trav ve thoi gian cua doi tuong History hien tai
	 * @return
	 */
	public String getTimeString(){
		return _timeString;
	}
	
	/**
	 * tra ve thong bao cua doi tuong History hien tai
	 * @return
	 */
	public String getMessage(){
		return _message;
	}
}
