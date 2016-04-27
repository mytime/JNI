package com.yanwanfu.hellojni;

public class JniBridge {
    public static native String getString();
    static {
        System.loadLibrary("hellojni");
    }
}
