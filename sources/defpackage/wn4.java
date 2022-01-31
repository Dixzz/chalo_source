package defpackage;

import android.graphics.Typeface;
import android.text.TextPaint;

/* renamed from: wn4  reason: default package */
/* compiled from: TextAppearance */
public class wn4 extends xn4 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextPaint f3807a;
    public final /* synthetic */ xn4 b;
    public final /* synthetic */ vn4 c;

    public wn4(vn4 vn4, TextPaint textPaint, xn4 xn4) {
        this.c = vn4;
        this.f3807a = textPaint;
        this.b = xn4;
    }

    @Override // defpackage.xn4
    public void a(int i) {
        this.b.a(i);
    }

    @Override // defpackage.xn4
    public void b(Typeface typeface, boolean z) {
        this.c.d(this.f3807a, typeface);
        this.b.b(typeface, z);
    }
}
