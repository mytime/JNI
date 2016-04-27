#include <jni.h>
#include<stdlib.h>

#include <android/log.h>
#define LOG_TAG "System.out"
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)


/**
 * 把一个jstring转换成一个c语言的char* 类型.
 */
char* _JString2CStr(JNIEnv* env, jstring jstr) {
	char* rtn = NULL;
	jclass clsstring = (*env)->FindClass(env, "java/lang/String");
	jstring strencode = (*env)->NewStringUTF(env, "GB2312");
	jmethodID mid = (*env)->GetMethodID(env, clsstring, "getBytes",
			"(Ljava/lang/String;)[B");
	jbyteArray barr = (jbyteArray) (*env)->CallObjectMethod(env, jstr, mid,
			strencode); // String .getByte("GB2312");
	jsize alen = (*env)->GetArrayLength(env, barr);
	jbyte* ba = (*env)->GetByteArrayElements(env, barr, JNI_FALSE);
	if (alen > 0) {
		rtn = (char*) malloc(alen + 1); //"\0"
		memcpy(rtn, ba, alen);
		rtn[alen] = 0;
	}
	(*env)->ReleaseByteArrayElements(env, barr, ba, 0);
	return rtn;
}

/*
 * Class:     com_hello_javapassc_JNI
 * Method:    add
 * Signature: (II)I
 */JNIEXPORT jint JNICALL Java_com_hello_javapassc_JNI_add(JNIEnv *env,
		jobject clazz, jint x, jint y) {

	return x + y;

}

/*
 * Class:     com_hello_javapassc_JNI
 * Method:    sayHelloC
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */JNIEXPORT jstring JNICALL Java_com_hello_javapassc_JNI_sayHelloC(JNIEnv *env,
		jobject clazz, jstring jstr) {

	//调用了工具方法，把java中的string类型转换成C语言中的char*;
	char* cstr = _JString2CStr(env, jstr);

	//获取字符串的长度
	int length = strlen(cstr);
	int i;
	for (i = 0; i < length; i++) {
		*(cstr + i) += 1;
	}

	return (*env)->NewStringUTF(env, cstr); //转换成jstring,

}

/*
 * Class:     com_hello_javapassc_JNI
 * Method:    arrElementsIncrease
 * Signature: ([I)[I
 */
 JNIEXPORT jintArray JNICALL Java_com_hello_javapassc_JNI_arrElementsIncrease(
		JNIEnv *env, jobject clazz, jintArray jArray) {
	jsize length = (*env)->GetArrayLength(env, jArray);
	LOGD("lenght=%d",length);
	int* arrayPointer = (*env)->GetIntArrayElements(env, jArray, NULL);
	int i;
	for (i = 0; i < length; i++) {
		*(arrayPointer + i) += 10;

	}

	return jArray;

}
