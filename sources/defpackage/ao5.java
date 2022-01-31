package defpackage;

/* renamed from: ao5  reason: default package */
/* compiled from: AuthManager */
public class ao5 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f271a = new Object();
    public final yn5 b;
    public final kp5 c;
    public bo5 d;

    public ao5(kq5 kq5, kp5 kp5) {
        yn5 yn5 = new yn5(kq5);
        this.b = yn5;
        this.c = kp5;
    }

    public String a() throws zn5 {
        String str;
        String l = this.c.l();
        if (l != null) {
            synchronized (this.f271a) {
                str = null;
                if (this.d != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    bo5 bo5 = this.d;
                    if (currentTimeMillis < bo5.f458a) {
                        if (hd3.R0(l, bo5.c)) {
                            str = this.d.b;
                        }
                    }
                }
            }
            if (str != null) {
                return str;
            }
            try {
                tq5<bo5> b2 = this.b.b(l);
                if (b2.e == null || !b2.c()) {
                    throw new zn5("Failed to generate token. Response: " + b2);
                }
                T t = b2.e;
                synchronized (this.f271a) {
                    this.d = t;
                }
                return b2.e.b;
            } catch (rq5 e) {
                throw new zn5("Failed to generate token.", e);
            }
        } else {
            throw new zn5("Unable to create token, channel not created");
        }
    }
}
