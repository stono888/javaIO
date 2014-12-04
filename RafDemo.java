package com.srie.test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RafDemo {

	public static void main(String[] args) throws IOException {
		File demo = new File("demo");
		if (!demo.exists()) {
			demo.mkdir();
		}
		File file = new File(demo, "raf.dat");
		if (!file.exists()) {
			file.createNewFile();
		}

		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		// ָ���λ��
		System.out.println(raf.getFilePointer());
		raf.write('A');// ֻд��һ���ֽ�
		System.out.println(raf.getFilePointer());
		raf.write('B');
		int i = 0x7fffffff;
		// ��write������ÿ��ֻ��дһ���ֽڣ�Ҫ��iд���룬��Ҫд�ĴΣ�
		raf.write(i >>> 24);// �߰�λ��
		raf.write(i >>> 16);
		raf.write(i >>> 8);
		raf.write(i);
		System.out.println(raf.getFilePointer());
		// ����ֱ��дһ��int
		raf.writeInt(i);
		System.out.println(raf.length());
		String s = "��";
		byte[] gbk = s.getBytes("gbk");
		raf.write(gbk);
		System.out.println(raf.length());
		// ���ļ��������ָ���Ƶ�ͷ��
		raf.seek(0);
		// һ���Զ�ȡ,���ļ��е����ݶ������ֽ������У�
		byte[] buf = new byte[(int) raf.length()];
		raf.read(buf);
		System.out.println(Arrays.toString(buf));
		/**
		 * ������װҲ��û�õģ���Ϊ���С���java�ַ�������utf-16be���룻��ǰ����һЩ����ֽڣ� ����ֻ���ǿ��ֽ��ó�����
		 */
		// String s1 = new String(buf,"gbk");
		// System.out.println(s1);
		// byte [] buf2 = new byte[2];
		// buf2[0]=buf[10];
		// buf2[1]= buf[11];
		// String s2 = new String(buf2,"gbk");
		// System.out.println(s2);
		for (byte b : buf) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		raf.close();
	}

}
