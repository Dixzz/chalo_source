package defpackage;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: iu4  reason: default package */
public final /* synthetic */ class iu4 implements px4 {

    /* renamed from: a  reason: collision with root package name */
    public final bs4 f1575a;

    public iu4(bs4 bs4) {
        this.f1575a = bs4;
    }

    @Override // defpackage.px4
    public final void onSuccess(Object obj) {
        bs4 bs4 = this.f1575a;
        List list = (List) obj;
        int a2 = bs4.b.a();
        Iterator it = ((ArrayList) bs4.d()).iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (!list.contains(file.getName()) && bs4.c(file, true) != ((long) a2)) {
                bs4.h(file);
            }
        }
    }
}
