package jtsutils.ultils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
	
	public static String getHardSerialNumber() throws Exception {
		String rs = null;
		try {
			if (OSValidator.isUnix()) {
				String sc = "/sbin/udevadm info --query=property --name=sda"; // get
																				// HDD
																				// parameters
																				// as
																				// non
																				// root
																				// user
				String[] scargs = { "/bin/sh", "-c", sc };

				Process p = Runtime.getRuntime().exec(scargs);
				p.waitFor();

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(p.getInputStream()));
				String line;
				StringBuilder sb = new StringBuilder();

				while ((line = reader.readLine()) != null) {
					if (line.indexOf("ID_SERIAL_SHORT") != -1) { // look for
																	// ID_SERIAL_SHORT
																	// or
																	// ID_SERIAL
						sb.append(line);
					}
				}
				return sb.substring(sb.indexOf("=") + 1);
			}
			
			if(OSValidator.isWindows()){
				String sc = "cmd /c" + "wmic diskdrive get serialnumber";

			    Process p = Runtime.getRuntime().exec(sc);
			    p.waitFor();

			    BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			    String line;
			    StringBuilder sb = new StringBuilder();

			    while ((line = reader.readLine()) != null) {
			        sb.append(line);
			    }
			    return sb.substring(sb.lastIndexOf("r") + 1).trim();
			}
			
		} catch (Exception ex) {
			throw new Exception ("cannot retrieve hard drive serial number");
		}
		return rs;
	}
}
