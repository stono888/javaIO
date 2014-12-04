package com.srie.test;

public class EncodeDemo {

	public static void main(String[] args) throws Exception {
		String s = "����ABCa";
		byte[] bs = s.getBytes();// ת�����ֽڲ��õ�����ĿĬ�ϵı��뷽ʽ
		for (byte b : bs) {
			// ���ֽڣ�ת����int����16���Ʊ�ʾ
			System.out.print(Integer.toHexString(b & 0xff) + " ");
			// System.out.println(Integer.toString(b));
		}
		System.out.println();
		byte[] bs2 = s.getBytes("gbk");
		// gbk��������ռ�������ֽڣ�Ӣ��ռ��һ���ֽڣ�
		for (byte b : bs2) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		byte[] bs3 = s.getBytes("utf-8");
		// utf-8����������ռ�������ֽڣ�Ӣ��ռ��һ���ֽڣ�
		for (byte b : bs3) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		// java��˫�ֽڱ��룬utf-16be
		byte[] bs4 = s.getBytes("utf-16be");
		// utf-16be����ռ�������ֽڣ�Ӣ��ռ�������ֽ�
		for (byte b : bs4) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		/*
		 * ������ֽ�������ĳ�ֱ���ʱ�����ʱ������ֽ����б���ַ����� Ҳ��Ҫʹ�����ֱ��뷽ʽ�������������룻
		 */
		String str1 = new String(bs4);// ����ĿĬ�ϵı��뷽ʽ��
		System.out.println(str1);
		String str2 = new String(bs4, "utf-16be");
		System.out.println(str2);
		/*
		 * �ı��ļ� �����ֽ����У����������������ֽ����У�������������Ļ�������ֱ�Ӵ����ı��ļ��� ���ļ�ֻ��ʶansi���룻
		 * ��ͨ��������һ���ɺϣ��������÷�����utf-8����Ĺ���
		 */
		String string = "��";
		byte[] bs5 = string.getBytes();
		for (byte b : bs5) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		byte[] bs6 = string.getBytes("utf-8");
		for (byte b : bs6) {
			System.out.print(Integer.toHexString(b&0xff)+" ");
		}
	}

}
