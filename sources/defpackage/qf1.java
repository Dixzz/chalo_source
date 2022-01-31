package defpackage;

import com.google.android.gms.maps.model.LatLng;
import java.util.regex.Pattern;

/* renamed from: qf1  reason: default package */
/* compiled from: LocationIntentDataParser */
public class qf1 {

    /* renamed from: a  reason: collision with root package name */
    public String f2937a;
    public Pattern b = Pattern.compile("q=[0-9\\.]+,[0-9\\.]+(.)*");
    public Pattern c = Pattern.compile("geo:[0-9\\.]+,[0-9\\.]+");
    public boolean d;
    public mf1 e;

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public qf1(android.content.Intent r9) {
        /*
        // Method dump skipped, instructions count: 269
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qf1.<init>(android.content.Intent):void");
    }

    public final LatLng a(String str) {
        String[] split = str.split(",");
        String str2 = split[0];
        String str3 = split[1];
        if (!str2.equals("0") || !str3.equals("0")) {
            try {
                return new LatLng(Double.valueOf(str2).doubleValue(), Double.valueOf(str3).doubleValue());
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
