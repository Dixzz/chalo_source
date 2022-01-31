package defpackage;

import defpackage.hp1;
import defpackage.ip1;
import java.io.InputStream;
import java.util.Objects;
import java.util.Queue;

/* renamed from: tp1  reason: default package */
/* compiled from: HttpGlideUrlLoader */
public class tp1 implements ip1<cp1, InputStream> {
    public static final em1<Integer> b = em1.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: a  reason: collision with root package name */
    public final hp1<cp1, cp1> f3388a;

    /* renamed from: tp1$a */
    /* compiled from: HttpGlideUrlLoader */
    public static class a implements jp1<cp1, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final hp1<cp1, cp1> f3389a = new hp1<>(500);

        @Override // defpackage.jp1
        public ip1<cp1, InputStream> b(mp1 mp1) {
            return new tp1(this.f3389a);
        }
    }

    public tp1(hp1<cp1, cp1> hp1) {
        this.f3388a = hp1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ip1
    public /* bridge */ /* synthetic */ boolean a(cp1 cp1) {
        return true;
    }

    /* Return type fixed from 'ip1$a' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.Queue<hp1$b<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.ip1
    public ip1.a<InputStream> b(cp1 cp1, int i, int i2, fm1 fm1) {
        cp1 cp12 = cp1;
        hp1<cp1, cp1> hp1 = this.f3388a;
        if (hp1 != null) {
            hp1.b a2 = hp1.b.a(cp12, 0, 0);
            B a3 = hp1.f1406a.a(a2);
            Queue<hp1.b<?>> queue = hp1.b.d;
            synchronized (queue) {
                queue.offer(a2);
            }
            B b2 = a3;
            if (b2 == null) {
                hp1<cp1, cp1> hp12 = this.f3388a;
                Objects.requireNonNull(hp12);
                hp12.f1406a.d(hp1.b.a(cp12, 0, 0), cp12);
            } else {
                cp12 = b2;
            }
        }
        return new ip1.a(cp12, new qm1(cp12, ((Integer) fm1.c(b)).intValue()));
    }
}
