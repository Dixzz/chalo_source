package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.StrictMode;
import android.util.Log;
import defpackage.ap1;
import defpackage.bp1;
import defpackage.gp1;
import defpackage.np1;
import defpackage.pp1;
import defpackage.qp1;
import defpackage.rm1;
import defpackage.rp1;
import defpackage.so1;
import defpackage.sp1;
import defpackage.sq1;
import defpackage.tp1;
import defpackage.up1;
import defpackage.vo1;
import defpackage.vp1;
import defpackage.wo1;
import defpackage.wp1;
import defpackage.xo1;
import defpackage.xp1;
import defpackage.zo1;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;
import java.util.regex.Pattern;

@TargetApi(14)
/* renamed from: gl1  reason: default package */
/* compiled from: Glide */
public class gl1 implements ComponentCallbacks2 {
    public static volatile gl1 n;
    public static volatile boolean o;
    public final zn1 f;
    public final ro1 g;
    public final il1 h;
    public final ll1 i;
    public final xn1 j;
    public final xr1 k;
    public final pr1 l;
    public final List<nl1> m = new ArrayList();

    @TargetApi(14)
    public gl1(Context context, hn1 hn1, ro1 ro1, zn1 zn1, xn1 xn1, xr1 xr1, pr1 pr1, int i2, rs1 rs1, Map<Class<?>, ol1<?, ?>> map) {
        jl1 jl1 = jl1.NORMAL;
        this.f = zn1;
        this.j = xn1;
        this.g = ro1;
        this.k = xr1;
        this.l = pr1;
        yl1 yl1 = (yl1) rs1.v.c(kq1.f);
        new Handler(Looper.getMainLooper());
        Resources resources = context.getResources();
        ll1 ll1 = new ll1();
        this.i = ll1;
        iq1 iq1 = new iq1();
        is1 is1 = ll1.g;
        synchronized (is1) {
            is1.f1567a.add(iq1);
        }
        kq1 kq1 = new kq1(ll1.c(), resources.getDisplayMetrics(), zn1, xn1);
        xq1 xq1 = new xq1(context, ll1.c(), zn1, xn1);
        ll1.g(ByteBuffer.class, new yo1());
        ll1.g(InputStream.class, new op1(xn1));
        ll1.a(ByteBuffer.class, Bitmap.class, new fq1(kq1));
        ll1.a(InputStream.class, Bitmap.class, new pq1(kq1, xn1));
        ll1.a(ParcelFileDescriptor.class, Bitmap.class, new rq1(zn1));
        ll1.h(Bitmap.class, new cq1());
        ll1.a(ByteBuffer.class, BitmapDrawable.class, new zp1(resources, zn1, new fq1(kq1)));
        ll1.a(InputStream.class, BitmapDrawable.class, new zp1(resources, zn1, new pq1(kq1, xn1)));
        ll1.a(ParcelFileDescriptor.class, BitmapDrawable.class, new zp1(resources, zn1, new rq1(zn1)));
        ll1.h(BitmapDrawable.class, new aq1(zn1, new cq1()));
        ll1.e(InputStream.class, zq1.class, new fr1(ll1.c(), xq1, xn1));
        ll1.e(ByteBuffer.class, zq1.class, xq1);
        ll1.h(zq1.class, new ar1());
        ll1.b(sl1.class, sl1.class, new qp1.a());
        ll1.a(sl1.class, Bitmap.class, new er1(zn1));
        ll1.f(new sq1.a());
        ll1.b(File.class, ByteBuffer.class, new zo1.b());
        ll1.b(File.class, InputStream.class, new bp1.e());
        ll1.a(File.class, File.class, new vq1());
        ll1.b(File.class, ParcelFileDescriptor.class, new bp1.b());
        ll1.b(File.class, File.class, new qp1.a());
        ll1.f(new rm1.a(xn1));
        Class cls = Integer.TYPE;
        ll1.b(cls, InputStream.class, new np1.b(resources));
        ll1.b(cls, ParcelFileDescriptor.class, new np1.a(resources));
        ll1.b(Integer.class, InputStream.class, new np1.b(resources));
        ll1.b(Integer.class, ParcelFileDescriptor.class, new np1.a(resources));
        ll1.b(String.class, InputStream.class, new ap1.c());
        ll1.b(String.class, InputStream.class, new pp1.b());
        ll1.b(String.class, ParcelFileDescriptor.class, new pp1.a());
        ll1.b(Uri.class, InputStream.class, new up1.a());
        ll1.b(Uri.class, InputStream.class, new wo1.c(context.getAssets()));
        ll1.b(Uri.class, ParcelFileDescriptor.class, new wo1.b(context.getAssets()));
        ll1.b(Uri.class, InputStream.class, new vp1.a(context));
        ll1.b(Uri.class, InputStream.class, new wp1.a(context));
        ll1.b(Uri.class, InputStream.class, new rp1.c(context.getContentResolver()));
        ll1.b(Uri.class, ParcelFileDescriptor.class, new rp1.a(context.getContentResolver()));
        ll1.b(Uri.class, InputStream.class, new sp1.a());
        ll1.b(URL.class, InputStream.class, new xp1.a());
        ll1.b(Uri.class, File.class, new gp1.a(context));
        ll1.b(cp1.class, InputStream.class, new tp1.a());
        ll1.b(byte[].class, ByteBuffer.class, new xo1.a());
        ll1.b(byte[].class, InputStream.class, new xo1.d());
        ll1.i(Bitmap.class, BitmapDrawable.class, new hr1(resources, zn1));
        ll1.i(Bitmap.class, byte[].class, new gr1());
        ll1.i(zq1.class, byte[].class, new ir1());
        this.h = new il1(context, ll1, new zs1(), rs1, map, hn1, i2);
    }

    public static void a(Context context) {
        el1 el1;
        if (!o) {
            o = true;
            Context applicationContext = context.getApplicationContext();
            File[] fileArr = null;
            try {
                el1 = (el1) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").newInstance();
            } catch (ClassNotFoundException unused) {
                el1 = null;
            } catch (InstantiationException e) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e2);
            }
            Collections.emptyList();
            ArrayList arrayList = new ArrayList();
            try {
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                if (applicationInfo.metaData != null) {
                    if (Log.isLoggable("ManifestParser", 2)) {
                        String str = "Got app info metadata: " + applicationInfo.metaData;
                    }
                    for (String str2 : applicationInfo.metaData.keySet()) {
                        if ("GlideModule".equals(applicationInfo.metaData.get(str2))) {
                            arrayList.add(fs1.a(str2));
                        }
                    }
                }
                if (el1 != null && !el1.c().isEmpty()) {
                    Set<Class<?>> c = el1.c();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        es1 es1 = (es1) it.next();
                        if (c.contains(es1.getClass())) {
                            if (Log.isLoggable("Glide", 3)) {
                                String str3 = "AppGlideModule excludes manifest GlideModule: " + es1;
                            }
                            it.remove();
                        }
                    }
                }
                if (Log.isLoggable("Glide", 3)) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        StringBuilder i0 = hj1.i0("Discovered GlideModule from manifest: ");
                        i0.append(((es1) it2.next()).getClass());
                        i0.toString();
                    }
                }
                hl1 hl1 = new hl1();
                hl1.l = null;
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((es1) it3.next()).a(applicationContext, hl1);
                }
                if (hl1.f == null) {
                    int i2 = vo1.h;
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        fileArr = new File("/sys/devices/system/cpu/").listFiles(new uo1(Pattern.compile("cpu[0-9]+")));
                    } catch (Throwable unused2) {
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    hl1.f = new vo1(Math.min(4, Math.max(Math.max(1, Runtime.getRuntime().availableProcessors()), fileArr != null ? fileArr.length : 0)), "source", vo1.b.DEFAULT, false, false);
                }
                if (hl1.g == null) {
                    int i3 = vo1.h;
                    hl1.g = new vo1(1, "disk-cache", vo1.b.DEFAULT, true, false);
                }
                if (hl1.i == null) {
                    hl1.i = new so1(new so1.a(applicationContext));
                }
                if (hl1.j == null) {
                    hl1.j = new rr1();
                }
                if (hl1.c == null) {
                    int i4 = hl1.i.f3234a;
                    if (i4 > 0) {
                        hl1.c = new fo1(i4);
                    } else {
                        hl1.c = new ao1();
                    }
                }
                if (hl1.d == null) {
                    hl1.d = new eo1(hl1.i.d);
                }
                if (hl1.e == null) {
                    hl1.e = new qo1(hl1.i.b);
                }
                if (hl1.h == null) {
                    hl1.h = new po1(applicationContext);
                }
                if (hl1.b == null) {
                    hl1.b = new hn1(hl1.e, hl1.h, hl1.g, hl1.f, new vo1(0, Integer.MAX_VALUE, vo1.g, "source-unlimited", vo1.b.DEFAULT, false, false, new SynchronousQueue()));
                }
                xr1 xr1 = new xr1(hl1.l);
                hn1 hn1 = hl1.b;
                ro1 ro1 = hl1.e;
                zn1 zn1 = hl1.c;
                xn1 xn1 = hl1.d;
                pr1 pr1 = hl1.j;
                rs1 rs1 = hl1.k;
                rs1.y = true;
                gl1 gl1 = new gl1(applicationContext, hn1, ro1, zn1, xn1, xr1, pr1, 4, rs1, hl1.f1387a);
                Iterator it4 = arrayList.iterator();
                while (it4.hasNext()) {
                    ((es1) it4.next()).b(applicationContext, gl1, gl1.i);
                }
                context.getApplicationContext().registerComponentCallbacks(gl1);
                n = gl1;
                o = false;
            } catch (PackageManager.NameNotFoundException e3) {
                throw new RuntimeException("Unable to find metadata to parse GlideModules", e3);
            }
        } else {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
    }

    public static gl1 b(Context context) {
        if (n == null) {
            synchronized (gl1.class) {
                if (n == null) {
                    a(context);
                }
            }
        }
        return n;
    }

    public static xr1 c(Context context) {
        Objects.requireNonNull(context, "You cannot start a load on a not yet attached View or a  Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return b(context).k;
    }

    public static nl1 d(Activity activity) {
        Objects.requireNonNull(activity, "You cannot start a load on a not yet attached View or a  Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return b(activity).k.b(activity);
    }

    public static nl1 e(Fragment fragment) {
        xr1 c = c(fragment.getActivity());
        Objects.requireNonNull(c);
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        } else if (rt1.g()) {
            return c.c(fragment.getActivity().getApplicationContext());
        } else {
            return c.a(fragment.getActivity(), fragment.getChildFragmentManager(), fragment);
        }
    }

    public static nl1 f(Context context) {
        Objects.requireNonNull(context, "You cannot start a load on a not yet attached View or a  Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return b(context).k.c(context);
    }

    public static nl1 g(ve veVar) {
        Objects.requireNonNull(veVar, "You cannot start a load on a not yet attached View or a  Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return b(veVar).k.d(veVar);
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        rt1.a();
        ((ot1) this.g).e(0);
        this.f.b();
        this.j.b();
    }

    public void onTrimMemory(int i2) {
        int i3;
        rt1.a();
        qo1 qo1 = (qo1) this.g;
        Objects.requireNonNull(qo1);
        if (i2 >= 40) {
            qo1.e(0);
        } else if (i2 >= 20) {
            synchronized (qo1) {
                i3 = qo1.c;
            }
            qo1.e(i3 / 2);
        }
        this.f.a(i2);
        this.j.a(i2);
    }
}
