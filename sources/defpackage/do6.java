package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: do6  reason: default package */
/* compiled from: ApkLibraryInstaller */
public class do6 implements fo6 {

    /* renamed from: do6$a */
    /* compiled from: ApkLibraryInstaller */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ZipFile f872a;
        public ZipEntry b;

        public a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f872a = zipFile;
            this.b = zipEntry;
        }
    }

    public final a a(Context context, String[] strArr, String str, io6 io6) {
        String[] strArr2;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr3 = applicationInfo.splitSourceDirs;
        char c = 0;
        int i = 1;
        if (strArr3 == null || strArr3.length == 0) {
            strArr2 = new String[]{applicationInfo.sourceDir};
        } else {
            strArr2 = new String[(strArr3.length + 1)];
            strArr2[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr3, 0, strArr2, 1, strArr3.length);
        }
        int length = strArr2.length;
        int i2 = 0;
        ZipFile zipFile = null;
        while (i2 < length) {
            String str2 = strArr2[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), i);
                    break;
                } catch (IOException unused) {
                    i3 = i4;
                }
            }
            if (zipFile != null) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 < 5) {
                        int length2 = strArr.length;
                        int i7 = 0;
                        while (i7 < length2) {
                            String str3 = strArr[i7];
                            StringBuilder i0 = hj1.i0("lib");
                            i0.append(File.separatorChar);
                            i0.append(str3);
                            i0.append(File.separatorChar);
                            i0.append(str);
                            String sb = i0.toString();
                            Object[] objArr = new Object[2];
                            objArr[c] = sb;
                            objArr[i] = str2;
                            Objects.requireNonNull(io6);
                            String.format(Locale.US, "Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(sb);
                            if (entry != null) {
                                return new a(zipFile, entry);
                            }
                            i7++;
                            c = 0;
                            i = 1;
                        }
                        i5 = i6;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i2++;
            c = 0;
            i = 1;
        }
        return null;
    }
}
