package com.srie.test;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		// �˽⹹�캯���ļ������
		File file = new File("E:\\software\\imooc\\a\\b\\c");
		// File file2 = new File("e:"+File.separator);
		System.out.println(file.exists());
		if (!file.exists())
			file.mkdir();//file.mkdirs();
		else
			file.delete();
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		// File file2 = new File("e:\\software\\�ռ�1.txt");
		File file2 = new File("e:\\software", "����1.txt");
		if (!file2.exists())
			try {
				file2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		else
			file2.delete();
		System.out.println(file);
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file2.getName());
		System.out.println(file.getParent());
		System.out.println(file2.getParent());
		System.out.println(file.getParentFile().getAbsolutePath());
	}

}
