package com.srie.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {

	/**
	 * ��ȡָ���ļ����ݣ�����16�������������̨������ÿ���10��byte�����У� ���ӽڶ�ȡ�����ʺϽϴ���ļ���
	 * 
	 * @param fileName
	 */
	public static void printHex(String fileName) throws IOException {
		// ���ļ���Ϊ�ֽ������ж�����
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int i = 1;
		while ((b = in.read()) != -1) {
			if (b <= 0xf) {
				// ��λ��ǰ�油0
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b) + " ");
			if (i++ % 10 == 0) {
				System.out.println();
			}
		}
		in.close();
	}

	/**
	 * ������ȡ���Դ��ļ����ԣ�Ч�ʸߣ�Ҳ��������õĶ��ļ��ķ�ʽ��
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public static void printHexByByteArray(String fileName) throws IOException {
		FileInputStream in = new FileInputStream(fileName);
		byte[] buf = new byte[20 * 1024];
		// ��in��������ȡ�ֽڣ����뵽buf����ֽ������У��ӵ�0��λ�ÿ�ʼ�ţ�
		// ����buf.length�������ص��Ƕ������ֽڸ�����
		/*
		 * int bytes = in.read(buf, 0, buf.length);// һ���Զ��꣬˵���ֽ������㹻�� int j = 1;
		 * for (int i = 0; i < bytes; i++) { if (buf[i] <= 0xf) {
		 * System.out.print("0"); }
		 * System.out.print(Integer.toHexString(buf[i]&0xff)+" "); if (j++ % 10
		 * == 0) { System.out.println(); } }
		 */
		int bytes = 0;
		while ((bytes = in.read(buf, 0, buf.length)) != -1) {
			int j = 1;
			for (int i = 0; i < bytes; i++) {
				if (buf[i] <= 0xf) {
					System.out.print("0");
				}
				System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
				if (j++ % 10 == 0) {
					System.out.println();
				}
			}
		}
		in.close();

	}

	/**
	 * �ļ��������ֽ�������ȡ
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFile(File srcFile, File destFile) throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("�ļ���" + srcFile + "������");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "�����ļ�");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] buf = new byte[8 * 1024];
		int b;
		while ((b = in.read(buf, 0, buf.length)) != -1) {
			out.write(buf, 0, b);
			out.flush();// ��ü��ϣ������ֽ������ԣ�
		}
		in.close();
		out.close();
	}

	/**
	 * ������Ŀ������������ֽڿ�����
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByBufferAndBytes(File srcFile, File destFile)
			throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("�ļ���" + srcFile + "������");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "�����ļ�");
		}
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(destFile));
		byte[] bs = new byte[8 * 1024];
		int c = 1;
		while ((c = bis.read(bs, 0, bs.length)) != -1) {
			bos.write(bs, 0, c);
			bos.flush();
		}
		bis.close();
		bos.close();
	}

	/**
	 * �����ļ����������ô�������ֽ���
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByBuffer(File srcFile, File destFile)
			throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("�ļ���" + srcFile + "������");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "�����ļ�");
		}
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(destFile));
		int c;
		while ((c = bis.read()) != -1) {
			bos.write(c);
			bos.flush();// һ��Ҫд��ˢ�»�����������д�����ļ���ȥ��
		}
		bis.close();
		bos.close();
	}

	/**
	 * ���ӽڣ�������������ļ�������
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByByte(File srcFile, File destFile)
			throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("�ļ���" + srcFile + "������");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "�����ļ�");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
			out.flush();
		}
		in.close();
		out.close();
	}

	public static void main(String[] args) {

	}

}
