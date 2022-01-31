package defpackage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* renamed from: hu4  reason: default package */
public final /* synthetic */ class hu4 implements Runnable {
    public final ku4 f;

    public hu4(ku4 ku4) {
        this.f = ku4;
    }

    public final void run() {
        ku4 ku4 = this.f;
        vu4 a2 = ku4.b.a();
        bs4 bs4 = ku4.f2122a;
        Objects.requireNonNull(bs4);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            Iterator it = ((ArrayList) bs4.d()).iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                jr4 i = bs4.i(file.getName());
                if (i != null) {
                    hashMap2.put(file.getName(), i);
                }
            }
        } catch (IOException e) {
            bs4.c.b(6, "Could not process directory while scanning installed packs: %s", new Object[]{e});
        }
        for (String str : hashMap2.keySet()) {
            hashMap.put(str, Long.valueOf(bs4.s(str)));
        }
        ey4<List<String>> e2 = a2.e(hashMap);
        bs4 bs42 = ku4.f2122a;
        bs42.getClass();
        e2.b(ku4.d.a(), new iu4(bs42));
        e2.b.a(new vx4(ku4.d.a(), ju4.f1984a));
        e2.d();
    }
}
