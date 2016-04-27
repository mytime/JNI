package com.hello.javapassc;

public class JNI {
	//静态模块
	static{
		System.loadLibrary("passdata");
	}
	
	//传递数字给C，相加后返回结果
	public native int add(int x,int y);
	
	//传递字符串给C，处理后返回结果
	public native String sayHelloC(String c);
	
	//传递int数组给C，处理后返回结果
	public native int[] arrElementsIncrease(int[] intArray);
	
	
	
}
