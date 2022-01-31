package defpackage;

import android.graphics.Typeface;

/* renamed from: un4  reason: default package */
/* compiled from: CancelableFontCallback */
public final class un4 extends xn4 {

    /* renamed from: a  reason: collision with root package name */
    public final Typeface f3529a;
    public final a b;
    public boolean c;

    /* renamed from: un4$a */
    /* compiled from: CancelableFontCallback */
    public interface a {
        void a(Typeface typeface);
    }

    public un4(a aVar, Typeface typeface) {
        this.f3529a = typeface;
        this.b = aVar;
    }

    @Override // defpackage.xn4
    public void a(int i) {
        Typeface typeface = this.f3529a;
        if (!this.c) {
            this.b.a(typeface);
        }
    }

    @Override // defpackage.xn4
    public void b(Typeface typeface, boolean z) {
        if (!this.c) {
            this.b.a(typeface);
        }
    }
}
