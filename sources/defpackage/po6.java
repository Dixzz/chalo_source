package defpackage;

import com.graphhopper.GHResponse;

/* renamed from: po6  reason: default package */
/* compiled from: PolylineEncoder */
public class po6 {
    public static void a(long j, StringBuffer stringBuffer) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        long j2 = j << 1;
        if (i < 0) {
            j2 = ~j2;
        }
        while (j2 >= 32) {
            stringBuffer.append(Character.toChars((int) ((32 | (31 & j2)) + 63)));
            j2 >>= 5;
        }
        stringBuffer.append(Character.toChars((int) (j2 + 63)));
    }

    public static String b(GHResponse gHResponse) {
        StringBuffer stringBuffer = new StringBuffer();
        if (gHResponse.getPoints().size() == 0) {
            return null;
        }
        long j = 0;
        long j2 = 0;
        for (Double[] dArr : gHResponse.getPoints().toGeoJson()) {
            long round = Math.round(dArr[1].doubleValue() * 100000.0d);
            long round2 = Math.round(dArr[0].doubleValue() * 100000.0d);
            a(round - j, stringBuffer);
            a(round2 - j2, stringBuffer);
            j = round;
            j2 = round2;
        }
        return stringBuffer.toString();
    }
}
