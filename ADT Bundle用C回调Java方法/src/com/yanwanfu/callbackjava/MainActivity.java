package com.yanwanfu.callbackjava;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * ## C代码回调java方法
 * 
 * ① 找到字节码对象 //jclass (*FindClass)(JNIEnv*, const char*); 
 * 	  	第二个参数: 要回调的java方法所在的类的路径 "com/itheima/callbackjava/JNI" 
 * ② 通过字节码对象找到方法对象 //jmethodID (*GetMethodID)(JNIEnv*, jclass, const char*, const char*); 
 * 		第二个参数 字节码对象 
 * 		第三个参数 要反射调用的java方法名 
 * 		第四个参数 要反射调用的java方法签名 javap -s 要获取方法签名的类的全类名 项目/bin/classes运行javap 
 * ③ 通过字节码创建 java对象(可选) 如果本地方法和要回调的java方法在同一个类里可以直接用 jni传过来的java对象
 * 		调用创建的Method jobject obj =(*env)->AllocObject(env,claz); 
 * 		当回调的方法跟本地方法不在一个类里需要通过刚创建的字节码对象手动创建一个java对象 
 * 		再通过这个对象来回调java的方法 需要注意的是 如果创建的是一个activity对象回调的方法还包含上下文 
 * 		这个方法行不通!!!回报空指针异常 
 * ④ 反射调用java方法 //void (*CallVoidMethod)(JNIEnv*,jobject, jmethodID, ...); 
 * 		第二个参数 调用java方法的对象 
 * 		第三个参数 要调用的jmethodID对象 可选的参数调用方法时接收的参数
 * 
 * 
 */
public class MainActivity extends Activity {

	JNI jni;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		jni = new JNI();
	}

	public void callbackvoid(View v) {
		jni.callbackvoidmethod();
	}
	public void callbackint(View v){
		jni.callbackintmethod();
	}
}
