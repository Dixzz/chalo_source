package defpackage;

import defpackage.qk1;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* renamed from: uk1  reason: default package */
/* compiled from: Decoder */
public final class uk1 {

    /* renamed from: a  reason: collision with root package name */
    public final y25 f3516a;
    public final a b;
    public final c c;
    public final Map<s25, Object> d;
    public final Object e = new Object();
    public volatile sk1 f;
    public volatile tk1 g;
    public volatile b h;

    /* renamed from: uk1$a */
    /* compiled from: Decoder */
    public final class a extends Thread {
        public a() {
            super("cs-decoder");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
            defpackage.uk1.a(r4.f, defpackage.uk1.b.DECODING);
            r0 = r1.a(r4.f.f3516a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
            if (r0 == null) goto L_0x0005;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
            r4.f.g = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
            if (defpackage.uk1.a(r4.f, defpackage.uk1.b.DECODED) == false) goto L_0x0005;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
            r1 = r4.f.f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
            if (r1 == null) goto L_0x0005;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
            r1 = (app.zophop.scanPay.ScanPayBaseActivity.a) r1;
            app.zophop.scanPay.ScanPayBaseActivity.this.runOnUiThread(new defpackage.o80(r1, r0));
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            // Method dump skipped, instructions count: 102
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.uk1.a.run():void");
        }
    }

    /* renamed from: uk1$b */
    /* compiled from: Decoder */
    public enum b {
        INITIALIZED,
        IDLE,
        DECODING,
        DECODED,
        STOPPED
    }

    /* renamed from: uk1$c */
    /* compiled from: Decoder */
    public interface c {
    }

    public uk1(c cVar, List<o25> list, sk1 sk1) {
        y25 y25 = new y25();
        this.f3516a = y25;
        this.b = new a();
        EnumMap enumMap = new EnumMap(s25.class);
        this.d = enumMap;
        enumMap.put((Object) s25.POSSIBLE_FORMATS, (Object) list);
        y25.e(enumMap);
        this.f = sk1;
        this.c = cVar;
        this.h = b.INITIALIZED;
    }

    public static boolean a(uk1 uk1, b bVar) {
        uk1.h = bVar;
        qk1.b bVar2 = (qk1.b) uk1.c;
        Objects.requireNonNull(bVar2);
        if (bVar != b.DECODED) {
            return true;
        }
        zk1 zk1 = qk1.this.n;
        if (zk1 == zk1.PREVIEW) {
            return false;
        }
        if (zk1 != zk1.SINGLE) {
            return true;
        }
        qk1.this.u = true;
        qk1 qk1 = qk1.this;
        qk1.c.post(qk1.k);
        return true;
    }
}
