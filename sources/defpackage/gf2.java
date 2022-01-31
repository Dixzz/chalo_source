package defpackage;

import android.content.SharedPreferences;

/* renamed from: gf2  reason: default package */
public final class gf2 extends af2<String> {
    public gf2(kf2 kf2, String str, String str2) {
        super(kf2, str, str2, null);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.af2
    public final String b(SharedPreferences sharedPreferences) {
        try {
            return sharedPreferences.getString(this.b, null);
        } catch (ClassCastException unused) {
            String valueOf = String.valueOf(this.b);
            if (valueOf.length() != 0) {
                "Invalid string value in SharedPreferences for ".concat(valueOf);
                return null;
            }
            new String("Invalid string value in SharedPreferences for ");
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.af2
    public final /* synthetic */ String e(String str) {
        return str;
    }
}
