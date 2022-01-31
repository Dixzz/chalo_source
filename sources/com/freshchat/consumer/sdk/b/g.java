package com.freshchat.consumer.sdk.b;

import java.util.regex.Pattern;

public class g {
    public Pattern dN;
    public Pattern dO;
    public Pattern dP;

    public g(String str) {
        StringBuilder i0 = hj1.i0("(?:");
        i0.append(Pattern.quote(str.trim()));
        i0.append(")");
        this.dN = Pattern.compile(i0.toString(), 2);
        StringBuilder i02 = hj1.i0("^");
        i02.append(Pattern.quote(str.trim()));
        this.dO = Pattern.compile(i02.toString(), 2);
        StringBuilder i03 = hj1.i0("\\b(?:");
        i03.append(Pattern.quote(str.trim()));
        i03.append(")\\b");
        this.dP = Pattern.compile(i03.toString(), 2);
    }

    public int a(String str, String str2) {
        int i = this.dN.matcher(str2).find() ? 1 : 0;
        if (this.dN.matcher(str).find()) {
            i += 2;
        }
        if (this.dO.matcher(str2).find()) {
            i++;
        }
        if (this.dO.matcher(str).find()) {
            i += 2;
        }
        if (this.dP.matcher(str2).find()) {
            i++;
        }
        return this.dP.matcher(str).find() ? i + 2 : i;
    }
}
