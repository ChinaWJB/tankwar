package jobTest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Test_Log {

	private static Log log = LogFactory.getLog(Test_Log.class);

	public static void main(String[] args) {
		log.error("ERROR");	//����Ҫ�������ļ�log4j.properties
		log.debug("DEBUG");	//����Ҫ�������ļ�log4j.properties
		log.warn("WARN");	//����Ҫ�������ļ�log4j.properties
		log.info("INFO");	//����Ҫ�������ļ�log4j.properties
		log.trace("TRACE");	//����Ҫ�������ļ�log4j.properties
		System.out.println(log.getClass());
	}
}
