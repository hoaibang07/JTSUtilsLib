package jtsutils.test;

import jtsutils.enums.DEFAULT_VALUE;
import jtsutils.ultils.Watcher;

/**
 * Class dùng để test
 * @author hbc
 *
 */
public class Test {
	public static void main(String[] args){
		try {			
			Watcher wat = new Watcher(DEFAULT_VALUE.CURRENT_DIR);
			Thread t = new Thread(wat);
			t.start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
