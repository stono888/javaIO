package com.srie.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BrAndBwOrPwDemo {

	public static void main(String[] args) throws IOException {
		// ���ļ����ж�д����
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("e:/software/a.txt"), "gbk"));
		/*
		 * BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( new
		 * FileOutputStream("e:/software/aa.txt"), "gbk"));
		 */
		PrintWriter pw = new PrintWriter("e:/software/a4.txt");
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);// һ�ζ�һ�У�������ʶ���з���
			/*
			 * bw.write(line); // ����д������ bw.newLine();// ���в��� bw.flush();
			 */
			pw.println(line);
			pw.flush();
		}
		/*
		 * bw.close();
		 */
		pw.close();
		br.close();
	}
}
