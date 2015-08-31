package jobTest;

import java.io.File;

public class Test_File_isDirectory {
	public static void main(String[] args) {
		boolean flog1;
		boolean flog2;
		String name;
		File f1 = new File("D:\\Program Files");
		File[] files = f1.listFiles();
		for(File f:files){
			flog1 = f.isDirectory();
			flog2 = f.isFile();
			name = f.getName();
			System.out.println(name + " 是目录文件吗？ " + flog1 + " 是标准File文件吗？ " + flog2);
		}
	}
}
