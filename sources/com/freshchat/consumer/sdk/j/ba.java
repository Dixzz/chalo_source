package com.freshchat.consumer.sdk.j;

public class ba {
    public static void fX() {
        Class ay;
        if (!af.fW() && (ay = ao.ay("com.squareup.picasso.Picasso")) != null && ao.c(ay, "get") == null) {
            throw new IllegalArgumentException("Unsupported version of Picasso found. Please create and set custom Image loader using Freshchat.setImageLoader().");
        }
    }

    public static boolean fY() {
        return ao.ay("com.squareup.picasso.Picasso") != null;
    }

    public static boolean fZ() {
        return !fY();
    }
}
