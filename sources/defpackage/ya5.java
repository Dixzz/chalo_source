package defpackage;

import android.annotation.SuppressLint;
import com.google.firebase.appindexing.Indexable;
import defpackage.bb5;
import defpackage.pb5;
import defpackage.wa5;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@SuppressLint({"Assert"})
/* renamed from: ya5  reason: default package */
/* compiled from: WebSocketImpl */
public class ya5 implements wa5 {
    public static final List<bb5> s;
    public final BlockingQueue<ByteBuffer> f = new LinkedBlockingQueue();
    public volatile boolean g = false;
    public wa5.a h = wa5.a.NOT_YET_CONNECTED;
    public final za5 i;
    public bb5 j = null;
    public wa5.b k;
    public pb5.a l = null;
    public ByteBuffer m = ByteBuffer.allocate(0);
    public rb5 n = null;
    public String o = null;
    public Integer p = null;
    public Boolean q = null;
    public String r = null;

    static {
        ArrayList arrayList = new ArrayList(4);
        s = arrayList;
        arrayList.add(new db5());
        arrayList.add(new cb5());
        arrayList.add(new fb5());
        arrayList.add(new eb5());
    }

    public ya5(za5 za5, bb5 bb5) {
        new LinkedBlockingQueue();
        this.i = za5;
        this.k = wa5.b.CLIENT;
        this.j = bb5.e();
    }

    public final void a(int i2, String str, boolean z) {
        wa5.a aVar = this.h;
        wa5.a aVar2 = wa5.a.CLOSING;
        if (aVar != aVar2 && aVar != wa5.a.CLOSED) {
            if (aVar == wa5.a.OPEN) {
                if (i2 == 1006) {
                    this.h = aVar2;
                    f(i2, str, false);
                    return;
                }
                if (this.j.h() != bb5.a.NONE) {
                    if (!z) {
                        try {
                            Objects.requireNonNull((ab5) this.i);
                        } catch (RuntimeException e) {
                            try {
                                ((ab5) this.i).d(e);
                            } catch (hb5 e2) {
                                ((ab5) this.i).d(e2);
                                f(1006, "generated frame is invalid", false);
                            }
                        }
                    }
                    l(this.j.f(new nb5(i2, str)));
                }
                f(i2, str, z);
            } else if (i2 == -3) {
                f(-3, str, true);
            } else {
                f(-1, str, false);
            }
            if (i2 == 1002) {
                f(i2, str, z);
            }
            this.h = wa5.a.CLOSING;
            this.m = null;
        }
    }

    public synchronized void b(int i2, String str, boolean z) {
        if (this.h != wa5.a.CLOSED) {
            try {
                ((ab5) this.i).g(this, i2, str, z);
            } catch (RuntimeException e) {
                ((ab5) this.i).d(e);
            }
            bb5 bb5 = this.j;
            if (bb5 != null) {
                bb5.k();
            }
            this.n = null;
            this.h = wa5.a.CLOSED;
            this.f.clear();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(java.nio.ByteBuffer r8) {
        /*
        // Method dump skipped, instructions count: 367
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ya5.c(java.nio.ByteBuffer):void");
    }

    public final void d(ByteBuffer byteBuffer) {
        try {
            for (pb5 pb5 : this.j.l(byteBuffer)) {
                pb5.a c = pb5.c();
                boolean d = pb5.d();
                if (c == pb5.a.CLOSING) {
                    int i2 = 1005;
                    String str = "";
                    if (pb5 instanceof mb5) {
                        mb5 mb5 = (mb5) pb5;
                        i2 = mb5.e();
                        str = mb5.a();
                    }
                    if (this.h == wa5.a.CLOSING) {
                        b(i2, str, true);
                    } else if (this.j.h() == bb5.a.TWOWAY) {
                        a(i2, str, true);
                    } else {
                        f(i2, str, false);
                    }
                } else if (c == pb5.a.PING) {
                    Objects.requireNonNull((xa5) this.i);
                    qb5 qb5 = new qb5(pb5);
                    qb5.b = pb5.a.PONG;
                    l(this.j.f(qb5));
                } else if (c == pb5.a.PONG) {
                    Objects.requireNonNull((xa5) this.i);
                } else {
                    if (d) {
                        if (c != pb5.a.CONTINUOUS) {
                            if (this.l != null) {
                                throw new hb5(1002, "Continuous frame sequence not completed.");
                            } else if (c == pb5.a.TEXT) {
                                try {
                                    ((ab5) this.i).e(zb5.a(pb5.f()));
                                } catch (RuntimeException e) {
                                    ((ab5) this.i).d(e);
                                }
                            } else if (c == pb5.a.BINARY) {
                                try {
                                    za5 za5 = this.i;
                                    pb5.f();
                                    Objects.requireNonNull((ab5) za5);
                                } catch (RuntimeException e2) {
                                    ((ab5) this.i).d(e2);
                                }
                            } else {
                                throw new hb5(1002, "non control or continious frame expected");
                            }
                        }
                    }
                    if (c != pb5.a.CONTINUOUS) {
                        if (this.l == null) {
                            this.l = c;
                        } else {
                            throw new hb5(1002, "Previous continuous frame sequence not completed.");
                        }
                    } else if (d) {
                        if (this.l != null) {
                            this.l = null;
                        } else {
                            throw new hb5(1002, "Continuous frame sequence was not started.");
                        }
                    } else if (this.l == null) {
                        throw new hb5(1002, "Continuous frame sequence was not started.");
                    }
                    try {
                        Objects.requireNonNull((ab5) this.i);
                    } catch (RuntimeException e3) {
                        ((ab5) this.i).d(e3);
                    }
                }
            }
        } catch (hb5 e4) {
            ((ab5) this.i).d(e4);
            a(e4.f, e4.getMessage(), false);
        }
    }

    public void e() {
        if (this.h == wa5.a.NOT_YET_CONNECTED) {
            b(-1, "", true);
        } else if (this.g) {
            b(this.p.intValue(), this.o, this.q.booleanValue());
        } else if (this.j.h() == bb5.a.NONE) {
            b(Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL, "", true);
        } else if (this.j.h() != bb5.a.ONEWAY) {
            b(1006, "", true);
        } else if (this.k == wa5.b.SERVER) {
            b(1006, "", true);
        } else {
            b(Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL, "", true);
        }
    }

    public synchronized void f(int i2, String str, boolean z) {
        if (!this.g) {
            this.p = Integer.valueOf(i2);
            this.o = str;
            this.q = Boolean.valueOf(z);
            this.g = true;
            Objects.requireNonNull((ab5) this.i);
            try {
                Objects.requireNonNull((ab5) this.i);
            } catch (RuntimeException e) {
                ((ab5) this.i).d(e);
            }
            bb5 bb5 = this.j;
            if (bb5 != null) {
                bb5.k();
            }
            this.n = null;
        }
    }

    public InetSocketAddress g() {
        Socket socket = ((ab5) this.i).h;
        if (socket != null) {
            return (InetSocketAddress) socket.getLocalSocketAddress();
        }
        return null;
    }

    public final bb5.b h(ByteBuffer byteBuffer) throws gb5 {
        byteBuffer.mark();
        int limit = byteBuffer.limit();
        byte[] bArr = bb5.c;
        if (limit > bArr.length) {
            return bb5.b.NOT_MATCHED;
        }
        if (byteBuffer.limit() >= bArr.length) {
            int i2 = 0;
            while (byteBuffer.hasRemaining()) {
                if (bb5.c[i2] != byteBuffer.get()) {
                    byteBuffer.reset();
                    return bb5.b.NOT_MATCHED;
                }
                i2++;
            }
            return bb5.b.MATCHED;
        }
        throw new gb5(bArr.length);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean i() {
        return this.h == wa5.a.OPEN;
    }

    public final void j(vb5 vb5) {
        this.h = wa5.a.OPEN;
        try {
            ab5 ab5 = (ab5) this.i;
            ab5.n.countDown();
            ab5.f((xb5) vb5);
        } catch (RuntimeException e) {
            ((ab5) this.i).d(e);
        }
    }

    public void k(pb5 pb5) {
        l(this.j.f(pb5));
    }

    public final void l(ByteBuffer byteBuffer) {
        this.f.add(byteBuffer);
        Objects.requireNonNull((ab5) this.i);
    }

    public final void m(List<ByteBuffer> list) {
        for (ByteBuffer byteBuffer : list) {
            l(byteBuffer);
        }
    }

    public String toString() {
        return super.toString();
    }
}
