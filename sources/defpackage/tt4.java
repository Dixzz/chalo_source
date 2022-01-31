package defpackage;

import java.io.File;

/* renamed from: tt4  reason: default package */
public final /* synthetic */ class tt4 implements Runnable {
    public final vt4 f;
    public final st4 g;

    public tt4(vt4 vt4, st4 st4) {
        this.f = vt4;
        this.g = st4;
    }

    public final void run() {
        vt4 vt4 = this.f;
        st4 st4 = this.g;
        bs4 bs4 = vt4.f3682a;
        String str = st4.b;
        int i = st4.c;
        long j = st4.d;
        File a2 = bs4.a(str);
        if (a2.exists()) {
            File[] listFiles = a2.listFiles();
            for (File file : listFiles) {
                if (!file.getName().equals(String.valueOf(i)) && !file.getName().equals("stale.tmp")) {
                    bs4.h(file);
                } else if (file.getName().equals(String.valueOf(i))) {
                    File[] listFiles2 = file.listFiles();
                    for (File file2 : listFiles2) {
                        if (!file2.getName().equals(String.valueOf(j))) {
                            bs4.h(file2);
                        }
                    }
                }
            }
        }
    }
}
