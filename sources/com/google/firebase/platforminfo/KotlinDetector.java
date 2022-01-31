package com.google.firebase.platforminfo;

public final class KotlinDetector {
    private KotlinDetector() {
    }

    public static String detectVersion() {
        try {
            return i56.j.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
