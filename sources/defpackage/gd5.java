package defpackage;

import defpackage.id5;

/* renamed from: gd5  reason: default package */
/* compiled from: Tweaks */
public class gd5 implements fd5<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1242a;
    public final /* synthetic */ id5 b;

    public gd5(id5 id5, String str) {
        this.b = id5;
        this.f1242a = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.fd5
    public Boolean get() {
        id5.b bVar;
        id5 id5 = this.b;
        String str = this.f1242a;
        synchronized (id5) {
            bVar = id5.f1507a.get(str);
        }
        return bVar.b();
    }
}
