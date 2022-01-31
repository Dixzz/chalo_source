package defpackage;

import defpackage.ak2;
import java.io.IOException;

/* renamed from: ak2  reason: default package */
public class ak2<M extends ak2<M>> extends ek2 {
    public bk2 g;

    @Override // defpackage.ek2
    public void a(yj2 yj2) throws IOException {
        if (this.g != null) {
            int i = 0;
            while (true) {
                bk2 bk2 = this.g;
                if (i < bk2.h) {
                    bk2.g[i].a();
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // defpackage.ek2
    public int d() {
        if (this.g != null) {
            int i = 0;
            while (true) {
                bk2 bk2 = this.g;
                if (i >= bk2.h) {
                    break;
                }
                bk2.g[i].b();
                i++;
            }
        }
        return 0;
    }

    @Override // defpackage.ek2
    public /* synthetic */ ek2 e() throws CloneNotSupportedException {
        return (ak2) clone();
    }

    /* renamed from: f */
    public M clone() throws CloneNotSupportedException {
        M m = (M) ((ak2) super.clone());
        Object obj = dk2.f848a;
        bk2 bk2 = this.g;
        if (bk2 != null) {
            m.g = (bk2) bk2.clone();
        }
        return m;
    }
}
