package com.srie.test;

import java.io.File;
import java.io.IOException;

/**
 * �г�file���һЩ���ò�����������ˡ�������
 * 
 * @author ThinkPad
 *
 */
public class FileUtils {
	/**
	 * �ݹ��г�Ŀ¼�µ������ļ�
	 * 
	 * @param dir
	 * @throws IOException
	 */
	public static void listDirectory(File dir) throws IOException {
		if (!dir.exists()) {
			throw new IllegalArgumentException("Ŀ¼" + dir + "������.");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + "����Ŀ¼.");
		}
		// String[] filenames = dir.list();//���ص����ַ������飬�ӵ����ƣ���������һ����
		// for (String string : filenames) {
		// System.out.println(dir+File.separator+string);
		// }
		/*
		 * �����Ҫ������Ŀ¼�µ����ݣ�����Ҫ�����file�������ݹ飻file�ṩ��ֱ�ӷ���file�����api��
		 */
		File[] files = dir.listFiles();// ���ص���ֱ����Ŀ¼�ĳ���
		// for (File file : files) {
		// System.out.println(file);
		// if(file.isDirectory()){
		// listDirectory(file);
		// }
		// }
		if (files != null && files.length > 0) {
			for (File file : files) {
				if (file.isDirectory()) {
					listDirectory(file);
				} else {
					System.out.println(file);
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
