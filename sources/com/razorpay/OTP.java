package com.razorpay;

import java.util.regex.Pattern;

public class OTP {

    /* renamed from: a  reason: collision with root package name */
    public String f682a;
    private String b;
    private String c;

    public OTP(String str, String str2, String str3) {
        this.b = str;
        this.c = str2;
        this.f682a = str3;
        if (!Pattern.compile("^\\d").matcher(this.b).find()) {
            this.b = this.b.substring(1);
        }
        if (!Pattern.compile("\\d$").matcher(this.b).find()) {
            String str4 = this.b;
            this.b = str4.substring(0, str4.length() - 1);
        }
    }

    public String toString() {
        return "Pin: " + this.b + " bank: " + this.c + " sender: " + this.f682a;
    }
}
