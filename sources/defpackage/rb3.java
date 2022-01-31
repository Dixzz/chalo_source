package defpackage;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* renamed from: rb3  reason: default package */
public final class rb3 extends yb3 {
    public static boolean m;
    public AdvertisingIdClient.Info h;
    public final ee3 i;
    public String j;
    public boolean k = false;
    public final Object l = new Object();

    public rb3(ac3 ac3) {
        super(ac3);
        this.i = new ee3(ac3.c);
    }

    public static String w0(String str) {
        MessageDigest messageDigest;
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                messageDigest = null;
                break;
            }
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                if (messageDigest != null) {
                    break;
                }
                i2++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        if (messageDigest == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigest.digest(str.getBytes())));
    }

    @Override // defpackage.yb3
    public final void a0() {
    }

    public final boolean i0(AdvertisingIdClient.Info info, AdvertisingIdClient.Info info2) {
        String str;
        String id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        String j0 = this.f.g().j0();
        synchronized (this.l) {
            if (!this.k) {
                this.j = q0();
                this.k = true;
            } else if (TextUtils.isEmpty(this.j)) {
                if (info == null) {
                    str = null;
                } else {
                    str = info.getId();
                }
                if (str == null) {
                    String valueOf = String.valueOf(id);
                    String valueOf2 = String.valueOf(j0);
                    return x0(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                }
                String valueOf3 = String.valueOf(j0);
                this.j = w0(valueOf3.length() != 0 ? str.concat(valueOf3) : new String(str));
            }
            String valueOf4 = String.valueOf(id);
            String valueOf5 = String.valueOf(j0);
            String w0 = w0(valueOf5.length() != 0 ? valueOf4.concat(valueOf5) : new String(valueOf4));
            if (TextUtils.isEmpty(w0)) {
                return false;
            }
            if (w0.equals(this.j)) {
                return true;
            }
            if (!TextUtils.isEmpty(this.j)) {
                M("Resetting the client id because Advertising Id changed.");
                sc3 g = this.f.g();
                synchronized (g) {
                    g.h = null;
                    g.i = g.w().a(new uc3(g));
                }
                j0 = g.j0();
                k("New client Id", j0);
            }
            String valueOf6 = String.valueOf(id);
            String valueOf7 = String.valueOf(j0);
            return x0(valueOf7.length() != 0 ? valueOf6.concat(valueOf7) : new String(valueOf6));
        }
    }

    public final boolean j0() {
        g0();
        AdvertisingIdClient.Info o0 = o0();
        if (o0 == null || o0.isLimitAdTrackingEnabled()) {
            return false;
        }
        return true;
    }

    public final String m0() {
        g0();
        AdvertisingIdClient.Info o0 = o0();
        String id = o0 != null ? o0.getId() : null;
        if (TextUtils.isEmpty(id)) {
            return null;
        }
        return id;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.ads.identifier.AdvertisingIdClient.Info o0() {
        /*
            r3 = this;
            monitor-enter(r3)
            ee3 r0 = r3.i     // Catch:{ all -> 0x004b }
            r1 = 1000(0x3e8, double:4.94E-321)
            boolean r0 = r0.b(r1)     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x0047
            ee3 r0 = r3.i     // Catch:{ all -> 0x004b }
            r0.a()     // Catch:{ all -> 0x004b }
            ac3 r0 = r3.f     // Catch:{ IllegalStateException -> 0x0027, Exception -> 0x0019 }
            android.content.Context r0 = r0.f146a     // Catch:{ IllegalStateException -> 0x0027, Exception -> 0x0019 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r0 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r0)     // Catch:{ IllegalStateException -> 0x0027, Exception -> 0x0019 }
            goto L_0x002d
        L_0x0019:
            r0 = move-exception
            boolean r1 = defpackage.rb3.m
            if (r1 != 0) goto L_0x002c
            r1 = 1
            defpackage.rb3.m = r1
            java.lang.String r1 = "Error getting advertiser id"
            r3.J(r1, r0)
            goto L_0x002c
        L_0x0027:
            java.lang.String r0 = "IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details."
            r3.T(r0)
        L_0x002c:
            r0 = 0
        L_0x002d:
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r1 = r3.h
            boolean r1 = r3.i0(r1, r0)
            if (r1 == 0) goto L_0x0038
            r3.h = r0
            goto L_0x0047
        L_0x0038:
            java.lang.String r0 = "Failed to reset client id on adid change. Not using adid"
            r3.V(r0)
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r0 = new com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
            java.lang.String r1 = ""
            r2 = 0
            r0.<init>(r1, r2)
            r3.h = r0
        L_0x0047:
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r0 = r3.h
            monitor-exit(r3)
            return r0
        L_0x004b:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rb3.o0():com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
    }

    public final String q0() {
        IOException e;
        String str = null;
        try {
            FileInputStream openFileInput = this.f.f146a.openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                T("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                this.f.f146a.deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                M("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                } catch (FileNotFoundException unused) {
                } catch (IOException e2) {
                    e = e2;
                    str = str2;
                    J("Error reading Hash file, deleting it", e);
                    this.f.f146a.deleteFile("gaClientIdData");
                    return str;
                }
                return str2;
            }
        } catch (FileNotFoundException unused2) {
            return null;
        } catch (IOException e3) {
            e = e3;
            J("Error reading Hash file, deleting it", e);
            this.f.f146a.deleteFile("gaClientIdData");
            return str;
        }
    }

    public final boolean x0(String str) {
        try {
            String w0 = w0(str);
            M("Storing hashed adid.");
            FileOutputStream openFileOutput = this.f.f146a.openFileOutput("gaClientIdData", 0);
            openFileOutput.write(w0.getBytes());
            openFileOutput.close();
            this.j = w0;
            return true;
        } catch (IOException e) {
            L("Error creating hash file", e);
            return false;
        }
    }
}
