#include <jni.h>

/*
 * <jni.h>路径
 * /Users/iwan/opt/android-ndk-r11c/platforms/android-14/arch-arm/usr/include/
 *
 * */
JNIEXPORT jstring JNICALL Java_com_hello_simplejni_MainActivity_helloFromC
  (JNIEnv *env, jobject clazz){
	return (*env)->NewStringUTF(env,"Hello from c");
}
