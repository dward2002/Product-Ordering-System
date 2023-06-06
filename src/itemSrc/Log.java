package itemSrc;

public class Log {
	private StringBuffer logs;
	private static Log log = new Log();
	
	private Log () {
		logs = new StringBuffer();
	}
	
	public static Log getInstance() {
		return log;
	}
	
	public void addEntry (String s) {
		logs.append(s + "\n");
	}
	
	public String toString() {
		return logs.toString();
	}
}


