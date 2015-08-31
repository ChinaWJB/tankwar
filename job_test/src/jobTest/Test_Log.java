package jobTest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Test_Log {

	private static Log log = LogFactory.getLog(Test_Log.class);

	public static void main(String[] args) {
		log.error("ERROR");	//必须要有配置文件log4j.properties
		log.debug("DEBUG");	//必须要有配置文件log4j.properties
		log.warn("WARN");	//必须要有配置文件log4j.properties
		log.info("INFO");	//必须要有配置文件log4j.properties
		log.trace("TRACE");	//必须要有配置文件log4j.properties
		System.out.println(log.getClass());
	}
}
