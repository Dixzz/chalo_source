package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.firebase.auth.internal.zzai;
import com.razorpay.AnalyticsConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* renamed from: z43  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class z43 extends AsyncTask<Void, Void, y43> {
    public static final wa2 f = new wa2("FirebaseAuth", "GetAuthDomainTask");

    /* renamed from: a  reason: collision with root package name */
    public final String f4124a;
    public final String b;
    public final WeakReference<a53> c;
    public final Uri.Builder d;
    public final String e;

    public z43(String str, String str2, Intent intent, a53 a53) {
        gj1.j(str);
        this.f4124a = str;
        gj1.j(str2);
        Objects.requireNonNull(intent, "null reference");
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        gj1.j(stringExtra);
        Uri.Builder buildUpon = Uri.parse(a53.zzc(stringExtra)).buildUpon();
        Uri.Builder appendQueryParameter = buildUpon.appendPath("getProjectConfig").appendQueryParameter(AnalyticsConstants.KEY, stringExtra).appendQueryParameter("androidPackageName", str);
        Objects.requireNonNull(str2, "null reference");
        appendQueryParameter.appendQueryParameter("sha1Cert", str2);
        this.b = buildUpon.build().toString();
        this.c = new WeakReference<>(a53);
        this.d = a53.zzd(intent, str, str2);
        this.e = intent.getStringExtra("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN");
    }

    public static byte[] a(InputStream inputStream, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            byteArrayOutputStream.close();
        }
    }

    /* renamed from: b */
    public final void onPostExecute(y43 y43) {
        String str;
        Uri.Builder builder;
        a53 a53 = this.c.get();
        String str2 = null;
        if (y43 != null) {
            str2 = y43.f3996a;
            str = y43.b;
        } else {
            str = null;
        }
        if (a53 == null) {
            f.b("An error has occurred: the handler reference has returned null.", new Object[0]);
        } else if (TextUtils.isEmpty(str2) || (builder = this.d) == null) {
            a53.zze(this.f4124a, zzai.zza(str));
        } else {
            builder.authority(str2);
            a53.zza(this.d.build(), this.f4124a);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006c, code lost:
        r3 = defpackage.z43.f;
        r1 = java.lang.String.valueOf(r1);
        r5 = new java.lang.StringBuilder(r1.length() + 75);
        r5.append("Error parsing error message from response body in getErrorMessageFromBody. ");
        r5.append(r1);
        r3.b(r5.toString(), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f2, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00f3, code lost:
        r2 = defpackage.z43.f;
        r1 = java.lang.String.valueOf(r1);
        r2.b(defpackage.hj1.a0(new java.lang.StringBuilder(r1.length() + 33), "ConversionException encountered: ", r1), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0110, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0111, code lost:
        r2 = defpackage.z43.f;
        r1 = java.lang.String.valueOf(r1);
        r2.b(defpackage.hj1.a0(new java.lang.StringBuilder(r1.length() + 26), "Null pointer encountered: ", r1), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00f2 A[ExcHandler: e13 (r1v6 'e' e13 A[CUSTOM_DECLARE]), Splitter:B:4:0x0017] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0110 A[ExcHandler: NullPointerException (r1v3 'e' java.lang.NullPointerException A[CUSTOM_DECLARE]), Splitter:B:4:0x0017] */
    @Override // android.os.AsyncTask
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.y43 doInBackground(java.lang.Void[] r7) {
        /*
        // Method dump skipped, instructions count: 332
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z43.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onCancelled(y43 y43) {
        onPostExecute(null);
    }
}
