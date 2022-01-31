package defpackage;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Iterator;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: ho2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ho2 {
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    public final gv2 f1401a;

    public ho2(gv2 gv2) {
        this.f1401a = gv2;
    }

    public static ho2 a(go2 go2) {
        kv2 kv2 = go2.f1289a;
        ba3 ba3 = (ba3) kv2.i(5, null, null);
        ba3.e(kv2);
        return new ho2((gv2) ba3);
    }

    public static int g() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        int i = 0;
        while (i == 0) {
            secureRandom.nextBytes(bArr);
            i = ((bArr[0] & Byte.MAX_VALUE) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return i;
    }

    public final synchronized go2 b() throws GeneralSecurityException {
        return go2.a((kv2) this.f1401a.c());
    }

    public final synchronized ho2 c(co2 co2) throws GeneralSecurityException {
        cv2 cv2 = co2.f589a;
        synchronized (this) {
            jv2 e = e(cv2);
            gv2 gv2 = this.f1401a;
            if (gv2.h) {
                gv2.a();
                gv2.h = false;
            }
            kv2.A((kv2) gv2.g, e);
        }
        return this;
        return this;
    }

    public final synchronized ho2 d(int i) throws GeneralSecurityException {
        for (int i2 = 0; i2 < ((kv2) this.f1401a.g).u(); i2++) {
            jv2 v = ((kv2) this.f1401a.g).v(i2);
            if (v.v() == i) {
                if (v.u().equals(zu2.ENABLED)) {
                    gv2 gv2 = this.f1401a;
                    if (gv2.h) {
                        gv2.a();
                        gv2.h = false;
                    }
                    ((kv2) gv2.g).zzb = i;
                } else {
                    StringBuilder sb = new StringBuilder(63);
                    sb.append("cannot set key as primary because it's not enabled: ");
                    sb.append(i);
                    throw new GeneralSecurityException(sb.toString());
                }
            }
        }
        StringBuilder sb2 = new StringBuilder(26);
        sb2.append("key not found: ");
        sb2.append(i);
        throw new GeneralSecurityException(sb2.toString());
        return this;
    }

    public final synchronized jv2 e(cv2 cv2) throws GeneralSecurityException {
        hv2 x;
        xu2 c = xo2.c(cv2);
        int f = f();
        bw2 u = cv2.u();
        if (u != bw2.UNKNOWN_PREFIX) {
            x = jv2.x();
            if (x.h) {
                x.a();
                x.h = false;
            }
            jv2.z((jv2) x.g, c);
            if (x.h) {
                x.a();
                x.h = false;
            }
            jv2.B((jv2) x.g, f);
            zu2 zu2 = zu2.ENABLED;
            if (x.h) {
                x.a();
                x.h = false;
            }
            jv2.A((jv2) x.g, zu2);
            if (x.h) {
                x.a();
                x.h = false;
            }
            jv2.C((jv2) x.g, u);
        } else {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return (jv2) x.c();
    }

    public final synchronized int f() {
        int g;
        boolean z;
        g = g();
        while (true) {
            synchronized (this) {
                Iterator it = Collections.unmodifiableList(((kv2) this.f1401a.g).t()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((jv2) it.next()).v() == g) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            }
            return g;
            g = g();
        }
        if (!z) {
            return g;
        }
        g = g();
    }
}
