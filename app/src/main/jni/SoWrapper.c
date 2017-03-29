//
// Created by 刘心贤 on 2017/3/29.
//
#include "jni.h"
JNIEXPORT jstring JNICALL Java_com_sj_ndk_SoWrapper_getString(JNIEnv *env, jobject jobject1){
    return (*env)->NewStringUTF(env,"JJJJJJJJ");
}

JNIEXPORT void JNICALL Java_com_sj_ndk_SoWrapper_printf(JNIEnv *env, jobject j){

}
