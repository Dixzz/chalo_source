package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class DynamiteModule {
    @RecentlyNonNull
    public static final b b = new xc2();
    @RecentlyNonNull
    public static final b c = new yc2();
    @RecentlyNonNull
    public static final b d = new zc2();
    @RecentlyNonNull
    public static final b e = new ad2();
    @GuardedBy("DynamiteModule.class")
    public static Boolean f = null;
    @GuardedBy("DynamiteModule.class")
    public static String g = null;
    @GuardedBy("DynamiteModule.class")
    public static int h = -1;
    public static final ThreadLocal<bd2> i = new ThreadLocal<>();
    public static final ThreadLocal<Long> j = new vc2();
    public static final dd2 k = new wc2();
    @GuardedBy("DynamiteModule.class")
    public static fd2 l;
    @GuardedBy("DynamiteModule.class")
    public static gd2 m;

    /* renamed from: a  reason: collision with root package name */
    public final Context f604a;

    @DynamiteApi
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public static class DynamiteLoaderClassLoader {
        @RecentlyNullable
        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public static class a extends Exception {
        public /* synthetic */ a(String str) {
            super(str);
        }

        public /* synthetic */ a(String str, Throwable th) {
            super(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface b {
        ed2 a(Context context, String str, dd2 dd2) throws a;
    }

    public DynamiteModule(Context context) {
        Objects.requireNonNull(context, "null reference");
        this.f604a = context;
    }

    public static int a(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".");
            sb.append("ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (gj1.G(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            String.valueOf(declaredField.get(null)).length();
            String.valueOf(str).length();
            return 0;
        } catch (ClassNotFoundException unused) {
            String.valueOf(str).length();
            return 0;
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                "Failed to load module descriptor class: ".concat(valueOf);
            } else {
                new String("Failed to load module descriptor class: ");
            }
            return 0;
        }
    }

    @RecentlyNonNull
    public static DynamiteModule c(@RecentlyNonNull Context context, @RecentlyNonNull b bVar, @RecentlyNonNull String str) throws a {
        Boolean bool;
        DynamiteModule dynamiteModule;
        ic2 ic2;
        gd2 gd2;
        Boolean valueOf;
        ic2 ic22;
        ThreadLocal<bd2> threadLocal = i;
        bd2 bd2 = threadLocal.get();
        bd2 bd22 = new bd2(null);
        threadLocal.set(bd22);
        ThreadLocal<Long> threadLocal2 = j;
        long longValue = threadLocal2.get().longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            ed2 a2 = bVar.a(context, str, k);
            int i2 = a2.f962a;
            str.length();
            str.length();
            int i3 = a2.c;
            if (i3 == 0 || ((i3 == -1 && a2.f962a == 0) || (i3 == 1 && a2.b == 0))) {
                int i4 = a2.f962a;
                int i5 = a2.b;
                StringBuilder sb = new StringBuilder(91);
                sb.append("No acceptable module found. Local version is ");
                sb.append(i4);
                sb.append(" and remote version is ");
                sb.append(i5);
                sb.append(".");
                throw new a(sb.toString());
            } else if (i3 == -1) {
                DynamiteModule g2 = g(context, str);
                if (longValue == 0) {
                    threadLocal2.remove();
                } else {
                    threadLocal2.set(Long.valueOf(longValue));
                }
                Cursor cursor = bd22.f413a;
                if (cursor != null) {
                    cursor.close();
                }
                threadLocal.set(bd2);
                return g2;
            } else if (i3 == 1) {
                try {
                    int i6 = a2.b;
                    try {
                        synchronized (DynamiteModule.class) {
                            bool = f;
                        }
                        if (bool != null) {
                            if (bool.booleanValue()) {
                                str.length();
                                synchronized (DynamiteModule.class) {
                                    gd2 = m;
                                }
                                if (gd2 != null) {
                                    bd2 bd23 = threadLocal.get();
                                    if (bd23 == null || bd23.f413a == null) {
                                        throw new a("No result cursor");
                                    }
                                    Context applicationContext = context.getApplicationContext();
                                    Cursor cursor2 = bd23.f413a;
                                    new kc2(null);
                                    synchronized (DynamiteModule.class) {
                                        valueOf = Boolean.valueOf(h >= 2);
                                    }
                                    if (valueOf.booleanValue()) {
                                        ic22 = gd2.C1(new kc2(applicationContext), str, i6, new kc2(cursor2));
                                    } else {
                                        ic22 = gd2.L(new kc2(applicationContext), str, i6, new kc2(cursor2));
                                    }
                                    Context context2 = (Context) kc2.L(ic22);
                                    if (context2 != null) {
                                        dynamiteModule = new DynamiteModule(context2);
                                    } else {
                                        throw new a("Failed to get module context");
                                    }
                                } else {
                                    throw new a("DynamiteLoaderV2 was not cached.");
                                }
                            } else {
                                str.length();
                                fd2 i7 = i(context);
                                if (i7 != null) {
                                    Parcel C = i7.C(6, i7.F());
                                    int readInt = C.readInt();
                                    C.recycle();
                                    if (readInt >= 3) {
                                        bd2 bd24 = threadLocal.get();
                                        if (bd24 != null) {
                                            ic2 = i7.N3(new kc2(context), str, i6, new kc2(bd24.f413a));
                                        } else {
                                            throw new a("No cached result cursor holder");
                                        }
                                    } else if (readInt == 2) {
                                        ic2 = i7.C1(new kc2(context), str, i6);
                                    } else {
                                        ic2 = i7.L(new kc2(context), str, i6);
                                    }
                                    if (kc2.L(ic2) != null) {
                                        dynamiteModule = new DynamiteModule((Context) kc2.L(ic2));
                                    } else {
                                        throw new a("Failed to load remote module.");
                                    }
                                } else {
                                    throw new a("Failed to create IDynamiteLoader.");
                                }
                            }
                            if (longValue == 0) {
                                threadLocal2.remove();
                            } else {
                                threadLocal2.set(Long.valueOf(longValue));
                            }
                            Cursor cursor3 = bd22.f413a;
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            threadLocal.set(bd2);
                            return dynamiteModule;
                        }
                        throw new a("Failed to determine which loading route to use.");
                    } catch (RemoteException e2) {
                        throw new a("Failed to load remote module.", e2);
                    } catch (a e3) {
                        throw e3;
                    } catch (Throwable th) {
                        try {
                            Objects.requireNonNull(context, "null reference");
                        } catch (Exception unused) {
                        }
                        throw new a("Failed to load remote module.", th);
                    }
                } catch (a e4) {
                    String valueOf2 = String.valueOf(e4.getMessage());
                    if (valueOf2.length() != 0) {
                        "Failed to load remote module: ".concat(valueOf2);
                    } else {
                        new String("Failed to load remote module: ");
                    }
                    int i8 = a2.f962a;
                    if (i8 == 0 || bVar.a(context, str, new cd2(i8)).c != -1) {
                        throw new a("Remote load failed. No local fallback found.", e4);
                    }
                    DynamiteModule g3 = g(context, str);
                    if (r3 != 0) {
                        j.set(Long.valueOf(longValue));
                    }
                    return g3;
                }
            } else {
                throw new a("VersionPolicy returned invalid code:0");
            }
        } finally {
            if (longValue == 0) {
                j.remove();
            } else {
                j.set(Long.valueOf(longValue));
            }
            Cursor cursor4 = bd22.f413a;
            if (cursor4 != null) {
                cursor4.close();
            }
            i.set(bd2);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00bd A[SYNTHETIC, Splitter:B:52:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0194 A[Catch:{ all -> 0x017f }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0198 A[Catch:{ all -> 0x017f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int d(@androidx.annotation.RecentlyNonNull android.content.Context r11, @androidx.annotation.RecentlyNonNull java.lang.String r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 436
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.d(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0074, code lost:
        if (f(r9) != false) goto L_0x007b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009b A[Catch:{ all -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009c A[Catch:{ all -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int e(android.content.Context r9, java.lang.String r10, boolean r11) throws com.google.android.gms.dynamite.DynamiteModule.a {
        /*
        // Method dump skipped, instructions count: 170
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.e(android.content.Context, java.lang.String, boolean):int");
    }

    public static boolean f(Cursor cursor) {
        bd2 bd2 = i.get();
        if (bd2 == null || bd2.f413a != null) {
            return false;
        }
        bd2.f413a = cursor;
        return true;
    }

    public static DynamiteModule g(Context context, String str) {
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            "Selected local version of ".concat(valueOf);
        } else {
            new String("Selected local version of ");
        }
        return new DynamiteModule(context.getApplicationContext());
    }

    @GuardedBy("DynamiteModule.class")
    public static void h(ClassLoader classLoader) throws a {
        gd2 gd2;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                gd2 = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof gd2) {
                    gd2 = (gd2) queryLocalInterface;
                } else {
                    gd2 = new gd2(iBinder);
                }
            }
            m = gd2;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new a("Failed to instantiate dynamite loader", e2);
        }
    }

    public static fd2 i(Context context) {
        fd2 fd2;
        synchronized (DynamiteModule.class) {
            fd2 fd22 = l;
            if (fd22 != null) {
                return fd22;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    fd2 = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof fd2) {
                        fd2 = (fd2) queryLocalInterface;
                    } else {
                        fd2 = new fd2(iBinder);
                    }
                }
                if (fd2 != null) {
                    l = fd2;
                    return fd2;
                }
            } catch (Exception e2) {
                String valueOf = String.valueOf(e2.getMessage());
                if (valueOf.length() != 0) {
                    "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf);
                } else {
                    new String("Failed to load IDynamiteLoader from GmsCore: ");
                }
            }
            return null;
        }
    }

    @RecentlyNonNull
    public IBinder b(@RecentlyNonNull String str) throws a {
        try {
            return (IBinder) this.f604a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new a(str.length() != 0 ? "Failed to instantiate module class: ".concat(str) : new String("Failed to instantiate module class: "), e2);
        }
    }
}
