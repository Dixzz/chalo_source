package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import java.io.File;

/* renamed from: ns4  reason: default package */
public final class ns4 {
    public static final nv4 f = new nv4("ExtractChunkTaskHandler");

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f2600a = new byte[RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST];
    public final bs4 b;
    public final kw4<vu4> c;
    public final kw4<yr4> d;
    public final ss4 e;

    public ns4(bs4 bs4, kw4<vu4> kw4, kw4<yr4> kw42, ss4 ss4) {
        this.b = bs4;
        this.c = kw4;
        this.d = kw42;
        this.e = ss4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x02a5 A[SYNTHETIC, Splitter:B:111:0x02a5] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0320  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x035c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01af A[Catch:{ all -> 0x0299 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(defpackage.ms4 r23) {
        /*
        // Method dump skipped, instructions count: 934
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ns4.a(ms4):void");
    }

    public final File b(ms4 ms4) {
        File k = this.b.k(ms4.b, ms4.c, ms4.d, ms4.e);
        if (!k.exists()) {
            k.mkdirs();
        }
        return k;
    }
}
