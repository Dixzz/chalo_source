package defpackage;

import defpackage.ih6;
import defpackage.ri6;
import java.util.Map;

/* renamed from: i46  reason: default package */
/* compiled from: Transport */
public abstract class i46 extends m36 {
    public boolean b;
    public String c;
    public Map<String, String> d;
    public boolean e;
    public boolean f;
    public int g;
    public String h;
    public String i;
    public String j;
    public d k;
    public ri6.a l;
    public ih6.a m;

    /* renamed from: i46$a */
    /* compiled from: Transport */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            i46 i46 = i46.this;
            d dVar = i46.k;
            if (dVar == d.OPENING || dVar == d.OPEN) {
                i46.f();
                i46.this.h();
            }
        }
    }

    /* renamed from: i46$b */
    /* compiled from: Transport */
    public class b implements Runnable {
        public final /* synthetic */ s46[] f;

        public b(s46[] s46Arr) {
            this.f = s46Arr;
        }

        public void run() {
            i46 i46 = i46.this;
            if (i46.k == d.OPEN) {
                try {
                    i46.l(this.f);
                } catch (e56 e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new RuntimeException("Transport not open");
            }
        }
    }

    /* renamed from: i46$c */
    /* compiled from: Transport */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f1476a;
        public String b;
        public String c;
        public boolean d;
        public boolean e;
        public int f = -1;
        public int g = -1;
        public Map<String, String> h;
        public u36 i;
        public ri6.a j;
        public ih6.a k;
    }

    /* renamed from: i46$d */
    /* compiled from: Transport */
    public enum d {
        OPENING,
        OPEN,
        CLOSED,
        PAUSED;

        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    public i46(c cVar) {
        this.h = cVar.b;
        this.i = cVar.f1476a;
        this.g = cVar.f;
        this.e = cVar.d;
        this.d = cVar.h;
        this.j = cVar.c;
        this.f = cVar.e;
        this.l = cVar.j;
        this.m = cVar.k;
    }

    public i46 e() {
        c56.a(new a());
        return this;
    }

    public abstract void f();

    public abstract void g();

    public void h() {
        this.k = d.CLOSED;
        a("close", new Object[0]);
    }

    public i46 i(String str, Exception exc) {
        a("error", new n36(str, exc));
        return this;
    }

    public void j(s46 s46) {
        a("packet", s46);
    }

    public void k(s46[] s46Arr) {
        c56.a(new b(s46Arr));
    }

    public abstract void l(s46[] s46Arr) throws e56;
}
