package jobTest;

import java.io.File;
import java.io.IOException;
public class Test_RunTime {
	public static void main(String[] args) throws IOException{
		Runtime.getRuntime().exec("cmd /k start D:\\Tomcat2\\apache-tomcat-6.0.43\\bin\\startup.bat");
	}
}
