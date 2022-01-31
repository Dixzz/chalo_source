package defpackage;

import android.os.Looper;
import androidx.annotation.RecentlyNonNull;

/* renamed from: t32  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class t32<L> {

    /* renamed from: a  reason: collision with root package name */
    public final z52 f3303a;
    public volatile L b;
    public volatile a<L> c;

    /* renamed from: t32$a */
    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    public static final class a<L> {

        /* renamed from: a  reason: collision with root package name */
        public final L f3304a;
        public final String b;

        public a(L l, String str) {
            this.f3304a = l;
            this.b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f3304a == aVar.f3304a && this.b.equals(aVar.b);
        }

        public int hashCode() {
            return this.b.hashCode() + (System.identityHashCode(this.f3304a) * 31);
        }
    }

    /* renamed from: t32$b */
    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    public interface b<L> {
        void a(@RecentlyNonNull L l);

        void b();
    }

    public t32(Looper looper, L l, String str) {
        this.f3303a = new z52(this, looper);
        gj1.l(l, "Listener must not be null");
        this.b = l;
        gj1.j(str);
        this.c = new a<>(l, str);
    }

    public void a(@RecentlyNonNull b<? super L> bVar) {
        gj1.l(bVar, "Notifier must not be null");
        this.f3303a.sendMessage(this.f3303a.obtainMessage(1, bVar));
    }
}
