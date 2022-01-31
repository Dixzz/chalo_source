package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.zzn;
import com.google.android.gms.common.zzq;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
/* renamed from: v22  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class v22 {
    @Nullable
    public static v22 c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f3585a;
    public volatile String b;

    public v22(@RecentlyNonNull Context context) {
        this.f3585a = context.getApplicationContext();
    }

    @RecentlyNonNull
    public static v22 a(@RecentlyNonNull Context context) {
        Objects.requireNonNull(context, "null reference");
        synchronized (v22.class) {
            if (c == null) {
                zb2 zb2 = bc2.f410a;
                synchronized (bc2.class) {
                    if (bc2.e == null) {
                        bc2.e = context.getApplicationContext();
                    }
                }
                c = new v22(context);
            }
        }
        return c;
    }

    @Nullable
    public static final xb2 c(PackageInfo packageInfo, xb2... xb2Arr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1) {
            return null;
        }
        yb2 yb2 = new yb2(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < xb2Arr.length; i++) {
            if (xb2Arr[i].equals(yb2)) {
                return xb2Arr[i];
            }
        }
        return null;
    }

    public static final boolean d(@RecentlyNonNull PackageInfo packageInfo, boolean z) {
        xb2 xb2;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                xb2 = c(packageInfo, ac2.f145a);
            } else {
                xb2 = c(packageInfo, ac2.f145a[0]);
            }
            if (xb2 != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    public boolean b(int i) {
        gc2 gc2;
        int length;
        boolean z;
        ApplicationInfo applicationInfo;
        String str;
        String[] packagesForUid = this.f3585a.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            gc2 = null;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    Objects.requireNonNull(gc2, "null reference");
                    break;
                }
                String str2 = packagesForUid[i2];
                gc2 gc22 = gc2.d;
                if (str2 == null) {
                    gc2 = gc2.b("null pkg");
                } else {
                    if (!str2.equals(this.b)) {
                        zb2 zb2 = bc2.f410a;
                        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            bc2.a();
                            z = bc2.c.x();
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                        } catch (RemoteException | DynamiteModule.a unused) {
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                            z = false;
                        } catch (Throwable th) {
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                            throw th;
                        }
                        if (z) {
                            boolean honorsDebugCertificates = u22.honorsDebugCertificates(this.f3585a);
                            StrictMode.ThreadPolicy allowThreadDiskReads2 = StrictMode.allowThreadDiskReads();
                            try {
                                Objects.requireNonNull(bc2.e, "null reference");
                                try {
                                    bc2.a();
                                    try {
                                        zzq o1 = bc2.c.o1(new zzn(str2, honorsDebugCertificates, false, new kc2(bc2.e), false));
                                        if (!o1.f) {
                                            String str3 = o1.g;
                                            if (str3 == null) {
                                                str3 = "error checking package certificate";
                                            }
                                            gc22 = gj1.k1(o1.h) == 4 ? gc2.c(str3, new PackageManager.NameNotFoundException()) : gc2.b(str3);
                                        }
                                    } catch (RemoteException e) {
                                        gc22 = gc2.c("module call", e);
                                    }
                                } catch (DynamiteModule.a e2) {
                                    String valueOf = String.valueOf(e2.getMessage());
                                    if (valueOf.length() != 0) {
                                        str = "module init: ".concat(valueOf);
                                    } else {
                                        str = new String("module init: ");
                                    }
                                    gc22 = gc2.c(str, e2);
                                }
                            } finally {
                                StrictMode.setThreadPolicy(allowThreadDiskReads2);
                            }
                        } else {
                            try {
                                PackageInfo packageInfo = this.f3585a.getPackageManager().getPackageInfo(str2, 64);
                                boolean honorsDebugCertificates2 = u22.honorsDebugCertificates(this.f3585a);
                                if (packageInfo == null) {
                                    gc22 = gc2.b("null pkg");
                                } else {
                                    Signature[] signatureArr = packageInfo.signatures;
                                    if (signatureArr == null || signatureArr.length != 1) {
                                        gc22 = gc2.b("single cert required");
                                    } else {
                                        yb2 yb2 = new yb2(packageInfo.signatures[0].toByteArray());
                                        String str4 = packageInfo.packageName;
                                        StrictMode.ThreadPolicy allowThreadDiskReads3 = StrictMode.allowThreadDiskReads();
                                        try {
                                            gc22 = bc2.b(str4, yb2, honorsDebugCertificates2, false);
                                            StrictMode.setThreadPolicy(allowThreadDiskReads3);
                                            if (!(!gc22.f1238a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0)) {
                                                StrictMode.ThreadPolicy allowThreadDiskReads4 = StrictMode.allowThreadDiskReads();
                                                try {
                                                    gc2 b2 = bc2.b(str4, yb2, false, true);
                                                    StrictMode.setThreadPolicy(allowThreadDiskReads4);
                                                    if (b2.f1238a) {
                                                        gc22 = gc2.b("debuggable release cert app rejected");
                                                    }
                                                } catch (Throwable th2) {
                                                    StrictMode.setThreadPolicy(allowThreadDiskReads4);
                                                    throw th2;
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            StrictMode.setThreadPolicy(allowThreadDiskReads3);
                                            throw th3;
                                        }
                                    }
                                }
                            } catch (PackageManager.NameNotFoundException e3) {
                                gc2 = gc2.c(str2.length() != 0 ? "no pkg ".concat(str2) : new String("no pkg "), e3);
                            }
                        }
                        if (gc22.f1238a) {
                            this.b = str2;
                        }
                    }
                    gc2 = gc22;
                }
                if (gc2.f1238a) {
                    break;
                }
                i2++;
            }
        } else {
            gc2 = gc2.b("no pkgs");
        }
        if (!gc2.f1238a && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (gc2.c != null) {
                gc2.a();
            } else {
                gc2.a();
            }
        }
        return gc2.f1238a;
    }
}
