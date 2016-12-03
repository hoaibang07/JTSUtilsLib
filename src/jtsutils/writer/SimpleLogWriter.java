package jtsutils.writer;

import java.util.LinkedList;
import java.util.Queue;

import jtsutils.datacollection.SimpleLogLine;
import jtsutils.ultils.Report;

/**
 * Class gồm các hàm tiện ích ghi log file
 * @author hbc
 *
 */
public class SimpleLogWriter {
	/**
	 * thread dung de ghi log
	 */
	private Thread threadWriteLog;
	
	/**
	 * Queue dung de chua cac dong log
	 */
	private Queue<SimpleLogLine> logStore = new LinkedList<SimpleLogLine>();
	
	/**
	 * ten cua file log se ghi
	 */
	protected String logFileName;
	
	/**
	 * Tao moi doi tuong SimpleLogWriter de tien hanh ghi log
	 * 
	 * @param logFileName
	 * 		duong dan toi file log se ghi vao
	 */
	public SimpleLogWriter(String logFileName)
	{
		this.logFileName = logFileName;
		
		//bat dau thead de ghi file log
		startThreadWriteLog();
	}
	
	/**
	 * Them mot dong log
	 * @param line
	 */
	public void addLog(SimpleLogLine line)
	{
		logStore.add(line);
	}
	
	/**
	 * tra ve duong dan cua file log dang ghi
	 * @return
	 */
	public String getLogFileName()
	{
		return this.logFileName;
	}
	
	private void startThreadWriteLog()
	{
		threadWriteLog = new Thread(){
			public void run()
			{
				while(true)
				{
					if(!logStore.isEmpty())
					{
						SimpleLogLine sll = (SimpleLogLine) logStore.remove();
						Report.writeLog(logFileName, sll.getLogType(), sll.getMessage() + "\n", sll.getTimeString());
					}
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		threadWriteLog.start();
	}
}
