package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.api.Status;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: a53  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public interface a53 {
    public static final wa2 b = new wa2("FirebaseAuth", "GetAuthDomainTaskResponseHandler");

    void zza(Uri uri, String str);

    HttpURLConnection zzb(URL url);

    String zzc(String str);

    Uri.Builder zzd(Intent intent, String str, String str2);

    void zze(String str, Status status);

    Context zzf();
}
