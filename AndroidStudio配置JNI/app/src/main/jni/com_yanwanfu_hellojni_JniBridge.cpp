//
// Created by Administrator on 2016/4/18.
//
#include "com_yanwanfu_hellojni_JniBridge.h"

JNIEXPORT jstring JNICALL Java_com_yanwanfu_hellojni_JniBridge_getString
        (JNIEnv *env, jobject){

    return env->NewStringUTF("Hello NDK");
}
