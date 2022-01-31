package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* renamed from: kn4  reason: default package */
/* compiled from: TextDrawableHelper */
public class kn4 {

    /* renamed from: a  reason: collision with root package name */
    public final TextPaint f2086a = new TextPaint(1);
    public final xn4 b = new a();
    public float c;
    public boolean d = true;
    public WeakReference<b> e = new WeakReference<>(null);
    public vn4 f;

    /* renamed from: kn4$a */
    /* compiled from: TextDrawableHelper */
    public class a extends xn4 {
        public a() {
        }

        @Override // defpackage.xn4
        public void a(int i) {
            kn4 kn4 = kn4.this;
            kn4.d = true;
            b bVar = kn4.e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // defpackage.xn4
        public void b(Typeface typeface, boolean z) {
            if (!z) {
                kn4 kn4 = kn4.this;
                kn4.d = true;
                b bVar = kn4.e.get();
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    /* renamed from: kn4$b */
    /* compiled from: TextDrawableHelper */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public kn4(b bVar) {
        this.e = new WeakReference<>(bVar);
    }

    public float a(String str) {
        float f2;
        if (!this.d) {
            return this.c;
        }
        if (str == null) {
            f2 = 0.0f;
        } else {
            f2 = this.f2086a.measureText((CharSequence) str, 0, str.length());
        }
        this.c = f2;
        this.d = false;
        return f2;
    }

    public void b(vn4 vn4, Context context) {
        if (this.f != vn4) {
            this.f = vn4;
            if (vn4 != null) {
                TextPaint textPaint = this.f2086a;
                xn4 xn4 = this.b;
                vn4.a();
                vn4.d(textPaint, vn4.n);
                vn4.b(context, new wn4(vn4, textPaint, xn4));
                b bVar = this.e.get();
                if (bVar != null) {
                    this.f2086a.drawableState = bVar.getState();
                }
                vn4.c(context, this.f2086a, this.b);
                this.d = true;
            }
            b bVar2 = this.e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }
}
