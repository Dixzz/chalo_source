package defpackage;

import android.content.SharedPreferences;

/* renamed from: ff2  reason: default package */
public final class ff2 extends af2<Boolean> {
    public ff2(kf2 kf2, String str, Boolean bool) {
        super(kf2, str, bool, null);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.af2
    public final Boolean b(SharedPreferences sharedPreferences) {
        try {
            return Boolean.valueOf(sharedPreferences.getBoolean(this.b, false));
        } catch (ClassCastException unused) {
            String valueOf = String.valueOf(this.b);
            if (valueOf.length() != 0) {
                "Invalid boolean value in SharedPreferences for ".concat(valueOf);
            } else {
                new String("Invalid boolean value in SharedPreferences for ");
            }
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.af2
    public final /* synthetic */ Boolean e(String str) {
        if (dl2.c.matcher(str).matches()) {
            return Boolean.TRUE;
        }
        if (dl2.d.matcher(str).matches()) {
            return Boolean.FALSE;
        }
        String.valueOf(this.b).length();
        str.length();
        return null;
    }
}
