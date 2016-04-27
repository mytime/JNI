package com.yanwanfu.callbackjava;

/** java与C桥接类 */

public class JNI {

	static {

		System.loadLibrary("callback"); // LOCAL_MODULE:= callback
	}

	/**
	 * C调用java空方法
	 * 
	 * callbackvoidmethod() -> callback.c
	 * ->Java_com_yanwanfu_callbackjava_JNI_callbackvoidmethod() ->JNI.java ->
	 * helloFromJava()
	 */
	public native void callbackvoidmethod();

	/** C调用java带有两个int参数的方法 */
	public native void callbackintmethod();

	/** 被C调用的java空方法 */
	public void helloFromJava() {
		System.out.println("hello from java");
	}

	/** 被C调用的Java带有两个int参数的方法 */
	public int add(int x, int y) {
		return x + y;
	}

	/** 被C调用java中参数为String的方法 */
	public void printString(String s) {

	}

}
