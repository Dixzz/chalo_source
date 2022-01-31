package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.IOException;

/* renamed from: br2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class br2 implements io2 {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences.Editor f469a;

    public br2(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        if (str == null) {
            this.f469a = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        } else {
            this.f469a = applicationContext.getSharedPreferences(str, 0).edit();
        }
    }

    @Override // defpackage.io2
    public final void a(kv2 kv2) throws IOException {
        if (!this.f469a.putString("GenericIdpKeyset", gj1.V0(kv2.a())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }

    @Override // defpackage.io2
    public final void b(gu2 gu2) throws IOException {
        if (!this.f469a.putString("GenericIdpKeyset", gj1.V0(gu2.a())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }
}
