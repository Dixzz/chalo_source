package defpackage;

import java.io.File;
import java.io.IOException;

/* renamed from: qt4  reason: default package */
public final class qt4 {
    public static final nv4 b = new nv4("MergeSliceTaskHandler");

    /* renamed from: a  reason: collision with root package name */
    public final bs4 f2989a;

    public qt4(bs4 bs4) {
        this.f2989a = bs4;
    }

    public static void b(File file, File file2) {
        if (file.isDirectory()) {
            file2.mkdirs();
            File[] listFiles = file.listFiles();
            for (File file3 : listFiles) {
                b(file3, new File(file2, file3.getName()));
            }
            if (!file.delete()) {
                String valueOf = String.valueOf(file);
                throw new os4(hj1.a0(new StringBuilder(valueOf.length() + 28), "Unable to delete directory: ", valueOf));
            }
        } else if (file2.exists()) {
            String valueOf2 = String.valueOf(file2);
            throw new os4(hj1.a0(new StringBuilder(valueOf2.length() + 51), "File clashing with existing file from other slice: ", valueOf2));
        } else if (!file.renameTo(file2)) {
            String valueOf3 = String.valueOf(file);
            throw new os4(hj1.a0(new StringBuilder(valueOf3.length() + 21), "Unable to move file: ", valueOf3));
        }
    }

    public final void a(pt4 pt4) {
        File l = this.f2989a.l(pt4.b, pt4.c, pt4.d, pt4.e);
        if (l.exists()) {
            File m = this.f2989a.m(pt4.b, pt4.c, pt4.d);
            if (!m.exists()) {
                m.mkdirs();
            }
            b(l, m);
            try {
                this.f2989a.o(pt4.b, pt4.c, pt4.d, this.f2989a.n(pt4.b, pt4.c, pt4.d) + 1);
            } catch (IOException e) {
                b.b(6, "Writing merge checkpoint failed with %s.", new Object[]{e.getMessage()});
                throw new os4("Writing merge checkpoint failed.", e, pt4.f1171a);
            }
        } else {
            throw new os4(String.format("Cannot find verified files for slice %s.", pt4.e), pt4.f1171a);
        }
    }
}
