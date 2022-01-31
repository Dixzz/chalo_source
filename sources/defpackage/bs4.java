package defpackage;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/* renamed from: bs4  reason: default package */
public final class bs4 {
    public static final nv4 c = new nv4("AssetPackStorage");
    public static final long d;
    public static final long e;

    /* renamed from: a  reason: collision with root package name */
    public final Context f470a;
    public final xt4 b;

    static {
        TimeUnit timeUnit = TimeUnit.DAYS;
        d = timeUnit.toMillis(14);
        e = timeUnit.toMillis(28);
    }

    public bs4(Context context, xt4 xt4) {
        this.f470a = context;
        this.b = xt4;
    }

    public static void b(File file) {
        if (file.listFiles() != null && file.listFiles().length > 1) {
            long c2 = c(file, false);
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (!file2.getName().equals(String.valueOf(c2)) && !file2.getName().equals("stale.tmp")) {
                    h(file2);
                }
            }
        }
    }

    public static long c(File file, boolean z) {
        if (!file.exists()) {
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        if (z && file.listFiles().length > 1) {
            c.b(5, "Multiple pack versions found, using highest version code.", new Object[0]);
        }
        try {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (!file2.getName().equals("stale.tmp")) {
                    arrayList.add(Long.valueOf(file2.getName()));
                }
            }
        } catch (NumberFormatException e2) {
            c.a(e2, "Corrupt asset pack directories.", new Object[0]);
        }
        if (arrayList.isEmpty()) {
            return -1;
        }
        Collections.sort(arrayList);
        return ((Long) arrayList.get(arrayList.size() - 1)).longValue();
    }

    public static boolean h(File file) {
        boolean z;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            z = true;
            for (File file2 : listFiles) {
                z &= h(file2);
            }
        } else {
            z = true;
        }
        return file.delete() && true == z;
    }

    public final File a(String str) {
        return new File(g(), str);
    }

    public final List<File> d() {
        ArrayList arrayList = new ArrayList();
        try {
            if (g().exists()) {
                if (g().listFiles() != null) {
                    File[] listFiles = g().listFiles();
                    for (File file : listFiles) {
                        if (!file.getCanonicalPath().equals(f().getCanonicalPath())) {
                            arrayList.add(file);
                        }
                    }
                    return arrayList;
                }
            }
            return arrayList;
        } catch (IOException e2) {
            c.b(6, "Could not process directory while scanning installed packs. %s", new Object[]{e2});
        }
    }

    public final File e(String str, int i, long j) {
        return new File(new File(new File(f(), str), String.valueOf(i)), String.valueOf(j));
    }

    public final File f() {
        return new File(g(), "_tmp");
    }

    public final File g() {
        return new File(this.f470a.getFilesDir(), "assetpacks");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0095 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.jr4 i(java.lang.String r9) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 185
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bs4.i(java.lang.String):jr4");
    }

    public final File j(String str, int i, long j) {
        return new File(new File(a(str), String.valueOf(i)), String.valueOf(j));
    }

    public final File k(String str, int i, long j, String str2) {
        return new File(new File(new File(e(str, i, j), "_slices"), "_unverified"), str2);
    }

    public final File l(String str, int i, long j, String str2) {
        return new File(new File(new File(e(str, i, j), "_slices"), "_verified"), str2);
    }

    public final File m(String str, int i, long j) {
        return new File(e(str, i, j), "_packs");
    }

    public final int n(String str, int i, long j) throws IOException {
        File file = new File(m(str, i, j), "merge.tmp");
        if (!file.exists()) {
            return 0;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("numberOfMerges") != null) {
                try {
                    return Integer.parseInt(properties.getProperty("numberOfMerges"));
                } catch (NumberFormatException e2) {
                    throw new os4("Merge checkpoint file corrupt.", e2);
                }
            } else {
                throw new os4("Merge checkpoint file corrupt.");
            }
        } catch (Throwable th) {
            jw4.f1988a.a(th, th);
        }
        throw th;
    }

    public final void o(String str, int i, long j, int i2) throws IOException {
        File file = new File(m(str, i, j), "merge.tmp");
        Properties properties = new Properties();
        properties.put("numberOfMerges", String.valueOf(i2));
        file.getParentFile().mkdirs();
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    public final File p(String str, int i, long j, String str2) {
        return new File(q(str, i, j, str2), "checkpoint.dat");
    }

    public final File q(String str, int i, long j, String str2) {
        return new File(new File(new File(e(str, i, j), "_slices"), "_metadata"), str2);
    }

    public final void r() {
        Iterator it = ((ArrayList) d()).iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (file.listFiles() != null) {
                b(file);
                long c2 = c(file, false);
                if (((long) this.b.a()) != c2) {
                    try {
                        new File(new File(file, String.valueOf(c2)), "stale.tmp").createNewFile();
                    } catch (IOException unused) {
                        c.b(6, "Could not write staleness marker.", new Object[0]);
                    }
                }
                for (File file2 : file.listFiles()) {
                    b(file2);
                }
            }
        }
    }

    public final long s(String str) {
        return c(new File(a(str), String.valueOf((int) c(a(str), true))), true);
    }
}
