package com.srie.test;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {

	private String stuno;
	private String stuname;
	// ��Ԫ�ز������jvmĬ�ϵ����л���Ҳ�����Լ�������Ԫ�ص����л���
	private transient int stuage;
	private transient int age2;

	public Student(String stuno, String stuname, int stuage, int age2) {
		super();
		this.stuno = stuno;
		this.stuname = stuname;
		this.stuage = stuage;
		this.age2 = age2;
	}

	public int getAge2() {
		return age2;
	}

	public void setAge2(int age2) {
		this.age2 = age2;
	}

	public Student() {
	}

	public Student(String stuno, String stuname, int stuage) {
		super();
		this.stuno = stuno;
		this.stuname = stuname;
		this.stuage = stuage;
	}

	public String getStuno() {
		return stuno;
	}

	public void setStuno(String stuno) {
		this.stuno = stuno;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public int getStuage() {
		return stuage;
	}

	public void setStuage(int stuage) {
		this.stuage = stuage;
	}

	@Override
	public String toString() {
		return "Student [stuno=" + stuno + ", stuname=" + stuname + ", stuage="
				+ stuage + ", age2=" + age2 + "]";
	}

	private void writeObject(java.io.ObjectOutputStream s)
			throws java.io.IOException {
		s.defaultWriteObject();// ��jvm��Ĭ�����л���Ԫ�ؽ������л�������
		s.writeInt(stuage);// �Լ����stuage�����л���
		// ���������Ԫ�أ�������writeObject()
		s.writeInt(age2);
	}

	private void readObject(java.io.ObjectInputStream s)
			throws java.io.IOException, ClassNotFoundException {
		s.defaultReadObject();// ��jvm��Ĭ�Ϸ����л�Ԫ�ؽ��з����л�������
		this.age2 = s.readInt();// �����෴��˳����ж�ȡ��������ʲôЧ����
		/**
		 * ��������෴��˳����ж�ȡ���ͻ��stuage��age2�����ˣ�
		 */
		this.stuage = s.readInt();// �Լ����stuage�ķ����л�������

	}
}
