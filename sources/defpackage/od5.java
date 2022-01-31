package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.recyclerview.widget.RecyclerView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: od5  reason: default package */
/* compiled from: HttpService */
public class od5 implements ud5 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2679a;

    public static byte[] c(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST];
        while (true) {
            int read = inputStream.read(bArr, 0, RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public boolean a(Context context, td5 td5) {
        if (f2679a) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return true;
            }
            return activeNetworkInfo.isConnectedOrConnecting();
        } catch (SecurityException unused) {
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0005 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d2 A[SYNTHETIC, Splitter:B:53:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f6 A[SYNTHETIC, Splitter:B:65:0x00f6] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00fd A[SYNTHETIC, Splitter:B:69:0x00fd] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0104 A[SYNTHETIC, Splitter:B:73:0x0104] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0117 A[SYNTHETIC, Splitter:B:87:0x0117] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011e A[SYNTHETIC, Splitter:B:91:0x011e] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0125 A[SYNTHETIC, Splitter:B:95:0x0125] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x012c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] b(java.lang.String r11, java.util.Map<java.lang.String, java.lang.Object> r12, javax.net.ssl.SSLSocketFactory r13) throws defpackage.ud5.a, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 306
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.od5.b(java.lang.String, java.util.Map, javax.net.ssl.SSLSocketFactory):byte[]");
    }
}
