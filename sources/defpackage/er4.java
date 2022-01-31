package defpackage;

import android.content.Context;
import java.io.File;

/* renamed from: er4  reason: default package */
public final class er4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1020a;

    public er4(Context context) {
        this.f1020a = context;
    }

    public static long a(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                j += a(file2);
            }
        }
        return j;
    }
}
