package defpackage;

import defpackage.id5;
import java.util.Objects;

/* renamed from: hd5  reason: default package */
/* compiled from: Tweaks */
public class hd5 implements fd5<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1361a;
    public final /* synthetic */ id5 b;

    public hd5(id5 id5, String str) {
        this.b = id5;
        this.f1361a = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.fd5
    public String get() {
        id5.b bVar;
        String str;
        id5 id5 = this.b;
        String str2 = this.f1361a;
        synchronized (id5) {
            bVar = id5.f1507a.get(str2);
        }
        Objects.requireNonNull(bVar);
        try {
            str = (String) bVar.c;
        } catch (ClassCastException unused) {
            str = null;
        }
        try {
            return (String) bVar.b;
        } catch (ClassCastException unused2) {
            return str;
        }
    }
}
