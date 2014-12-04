package com.srie.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IsrAndOswDemo {

	public static void main(String[] args) throws IOException {
		try {
			FileInputStream in = new FileInputStream("e:/software/autf8.txt");
			InputStreamReader isr = new InputStreamReader(in,"utf-8");
			
			FileOutputStream out = new FileOutputStream("e:/software/autf81.txt");
			OutputStreamWriter osw = new OutputStreamWriter(out,"utf-8");
			// ������ʱ��Ҫд�ļ�����ĸ�ʽ��
			// Ĭ���ǰ���gbk��������ģ���Ϊ��ĿĬ����gbk����ģ�
			// �����Ŀ��utf-8���Ϳ��ܳ������룻
			// InputStreamReader isr = new InputStreamReader(in, "gbk");
			/*
			 * int c; while ((c = isr.read()) != -1) { System.out.print((char)
			 * c); }
			 */
			char[] buff = new char[8 * 1024];
			int c;
			// ������ȡ������buff�ַ����飬�ӵ�0��λ�ÿ�ʼ���ã�������buff.length����
			// ���ص��Ƕ������ַ��ĸ���
			while ((c = isr.read(buff, 0, buff.length)) != -1) {
				String s = new String(buff, 0, c);
				System.out.print(s);
				osw.write(buff, 0, c);
				osw.flush();
			}
			osw.close();
			isr.close();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
