package defpackage;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/* renamed from: hp1  reason: default package */
/* compiled from: ModelCache */
public class hp1<A, B> {

    /* renamed from: a  reason: collision with root package name */
    public final ot1<b<A>, B> f1406a;

    /* renamed from: hp1$a */
    /* compiled from: ModelCache */
    public class a extends ot1<b<A>, B> {
        public a(hp1 hp1, int i) {
            super(i);
        }

        @Override // defpackage.ot1
        public void c(Object obj, Object obj2) {
            b<?> bVar = (b) obj;
            Objects.requireNonNull(bVar);
            Queue<b<?>> queue = b.d;
            synchronized (queue) {
                queue.offer(bVar);
            }
        }
    }

    /* renamed from: hp1$b */
    /* compiled from: ModelCache */
    public static final class b<A> {
        public static final Queue<b<?>> d = new ArrayDeque(0);

        /* renamed from: a  reason: collision with root package name */
        public int f1407a;
        public int b;
        public A c;

        static {
            char[] cArr = rt1.f3126a;
        }

        public static <A> b<A> a(A a2, int i, int i2) {
            b<A> bVar;
            Queue<b<?>> queue = d;
            synchronized (queue) {
                bVar = (b<A>) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.c = a2;
            bVar.b = i;
            bVar.f1407a = i2;
            return bVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.b == bVar.b && this.f1407a == bVar.f1407a && this.c.equals(bVar.c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.c.hashCode() + (((this.f1407a * 31) + this.b) * 31);
        }
    }

    public hp1(int i) {
        this.f1406a = new a(this, i);
    }
}
