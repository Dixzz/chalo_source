package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import android.os.UserManager;
import android.util.Log;
import com.google.firebase.appindexing.Indexable;
import defpackage.x22;
import java.util.Objects;
import java.util.TimeZone;

/* renamed from: i12  reason: default package */
public final class i12 {
    public static final x22.g<vk2> m;
    public static final x22.a<vk2, x22.d.c> n;
    @Deprecated
    public static final x22<x22.d.c> o;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1461a;
    public final String b;
    public final int c;
    public String d;
    public int e = -1;
    public String f;
    public final boolean g;
    public ik2 h = ik2.DEFAULT;
    public final k12 i;
    public final cb2 j;
    public d k;
    public final b l;

    /* renamed from: i12$a */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1462a;
        public String b;
        public String c;
        public ik2 d;
        public final sk2 e;
        public boolean f = false;

        public a(byte[] bArr, j12 j12) {
            this.f1462a = i12.this.e;
            this.b = i12.this.d;
            this.c = i12.this.f;
            this.d = i12.this.h;
            sk2 sk2 = new sk2();
            this.e = sk2;
            boolean z = false;
            this.c = i12.this.f;
            Context context = i12.this.f1461a;
            UserManager userManager = we2.f3767a;
            if (Build.VERSION.SDK_INT >= 24) {
                boolean z2 = we2.b;
                if (!z2) {
                    UserManager userManager2 = we2.f3767a;
                    if (userManager2 == null) {
                        synchronized (we2.class) {
                            userManager2 = we2.f3767a;
                            if (userManager2 == null) {
                                UserManager userManager3 = (UserManager) context.getSystemService(UserManager.class);
                                we2.f3767a = userManager3;
                                if (userManager3 == null) {
                                    we2.b = true;
                                    z2 = true;
                                } else {
                                    userManager2 = userManager3;
                                }
                            }
                        }
                    }
                    z2 = userManager2.isUserUnlocked();
                    we2.b = z2;
                    if (z2) {
                        we2.f3767a = null;
                    }
                }
                if (!z2) {
                    z = true;
                }
            }
            sk2.x = z;
            Objects.requireNonNull((db2) i12.this.j);
            sk2.h = System.currentTimeMillis();
            Objects.requireNonNull((db2) i12.this.j);
            sk2.i = SystemClock.elapsedRealtime();
            sk2.r = (long) (TimeZone.getDefault().getOffset(sk2.h) / Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL);
            if (bArr != null) {
                sk2.m = bArr;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:56:0x014a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
            // Method dump skipped, instructions count: 546
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.i12.a.a():void");
        }
    }

    /* renamed from: i12$b */
    public interface b {
    }

    /* renamed from: i12$c */
    public interface c {
        byte[] zza();
    }

    /* renamed from: i12$d */
    public static class d {
    }

    static {
        x22.g<vk2> gVar = new x22.g<>();
        m = gVar;
        j12 j12 = new j12();
        n = j12;
        o = new x22<>("ClearcutLogger.API", j12, gVar);
    }

    public i12(Context context, String str, String str2, boolean z, k12 k12, cb2 cb2, b bVar) {
        this.f1461a = context;
        this.b = context.getPackageName();
        int i2 = 0;
        try {
            i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.wtf("ClearcutLogger", "This can't happen.", e2);
        }
        this.c = i2;
        this.e = -1;
        this.d = str;
        this.f = null;
        this.g = z;
        this.i = k12;
        this.j = cb2;
        this.k = new d();
        this.h = ik2.DEFAULT;
        this.l = bVar;
        if (z) {
            gj1.c(true, "can't be anonymous with an upload account");
        }
    }
}
