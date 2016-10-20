package jtsutils.ultils;

/**
 * Class gồm các hàm tiện ích thao tác với hệ thống
 * @author hbc
 *
 */
public class SystemUT {

	/**
	 * Tra ve user hien tai dang thuc thi chuong trinh
	 * 
	 * @return String
	 */
	public static String getCurrentUser() {
		return System.getProperty("user.name");
	}
	
	/**
	 * Lay ve duong dan cua thu muc home cua user
	 * 
	 * @return String
	 */
	public static String getHomeDirectory() {
		return System.getProperty("user.home");
	}
}
