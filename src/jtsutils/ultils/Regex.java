package jtsutils.ultils;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Class gồm các hàm tiện ích thao tác với regular expression
 * @author hbc
 *
 */
public class Regex {

	/**
	 * Tim kiem xem key co ton tai trong Hashtable hay khong
	 * 
	 * @param ht
	 *            Hashtable can tim kiem
	 * @param regexKey
	 *            Regex key truyen vao dung de so sanh voi key
	 * @return Tra ve true neu tim thay va tra ve false neu khong tim thay
	 */
	public static boolean containKeyInHashTable(Hashtable<String, String> ht,
			String regexKey) {
		String key = "";
		Enumeration<String> keys = ht.keys();
		while (keys.hasMoreElements()) {
			key = keys.nextElement();
			if (key.matches(regexKey)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Lay ve gia tri dau tien cua key khop voi regex truyen vao
	 * 
	 * @param ht Hashtable can tim kiem
	 * @param regex Regex dung de so sanh voi key
	 * @return Tra ve Gia tri cua key khop voi regex neu tim thay, null neu khong tim thay
	 */
	public static String getValueByRegexKeyInHastable(Hashtable<String, String> ht, String regexKey)
	{
		String key = "";
		Enumeration<String> keys = ht.keys();
		while (keys.hasMoreElements()) {
			key = keys.nextElement();
			if (key.matches(regexKey)) {
				return ht.get(key);
			}
		}
		return null;
	}
}
