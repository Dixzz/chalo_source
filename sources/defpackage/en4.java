package defpackage;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import defpackage.jn4;
import defpackage.r7;
import defpackage.un4;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: en4  reason: default package */
/* compiled from: CollapsingTextHelper */
public final class en4 {
    public Bitmap A;
    public float B;
    public float C;
    public int[] D;
    public boolean E;
    public final TextPaint F;
    public final TextPaint G;
    public TimeInterpolator H;
    public TimeInterpolator I;
    public float J;
    public float K;
    public float L;
    public ColorStateList M;
    public float N;
    public float O;
    public float P;
    public ColorStateList Q;
    public float R;
    public float S;
    public StaticLayout T;
    public float U;
    public float V;
    public float W;
    public CharSequence X;
    public int Y = 1;

    /* renamed from: a  reason: collision with root package name */
    public final View f1005a;
    public boolean b;
    public float c;
    public final Rect d;
    public final Rect e;
    public final RectF f;
    public int g = 16;
    public int h = 16;
    public float i = 15.0f;
    public float j = 15.0f;
    public ColorStateList k;
    public ColorStateList l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public Typeface s;
    public Typeface t;
    public Typeface u;
    public un4 v;
    public un4 w;
    public CharSequence x;
    public CharSequence y;
    public boolean z;

    /* renamed from: en4$a */
    /* compiled from: CollapsingTextHelper */
    public class a implements un4.a {
        public a() {
        }

        @Override // defpackage.un4.a
        public void a(Typeface typeface) {
            en4.this.r(typeface);
        }
    }

    /* renamed from: en4$b */
    /* compiled from: CollapsingTextHelper */
    public class b implements un4.a {
        public b() {
        }

        @Override // defpackage.un4.a
        public void a(Typeface typeface) {
            en4.this.v(typeface);
        }
    }

    public en4(View view) {
        this.f1005a = view;
        TextPaint textPaint = new TextPaint(129);
        this.F = textPaint;
        this.G = new TextPaint(textPaint);
        this.e = new Rect();
        this.d = new Rect();
        this.f = new RectF();
    }

    public static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i3)) * f2) + (((float) Color.alpha(i2)) * f3)), (int) ((((float) Color.red(i3)) * f2) + (((float) Color.red(i2)) * f3)), (int) ((((float) Color.green(i3)) * f2) + (((float) Color.green(i2)) * f3)), (int) ((((float) Color.blue(i3)) * f2) + (((float) Color.blue(i2)) * f3)));
    }

    public static float k(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        TimeInterpolator timeInterpolator2 = zj4.f4184a;
        return hj1.a(f3, f2, f4, f2);
    }

    public static boolean n(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    public void A(Typeface typeface) {
        boolean z2;
        un4 un4 = this.w;
        boolean z3 = true;
        if (un4 != null) {
            un4.c = true;
        }
        if (this.s != typeface) {
            this.s = typeface;
            z2 = true;
        } else {
            z2 = false;
        }
        un4 un42 = this.v;
        if (un42 != null) {
            un42.c = true;
        }
        if (this.t != typeface) {
            this.t = typeface;
        } else {
            z3 = false;
        }
        if (z2 || z3) {
            m();
        }
    }

    public float b() {
        if (this.x == null) {
            return 0.0f;
        }
        TextPaint textPaint = this.G;
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
        textPaint.setLetterSpacing(this.R);
        TextPaint textPaint2 = this.G;
        CharSequence charSequence = this.x;
        return textPaint2.measureText(charSequence, 0, charSequence.length());
    }

    public final boolean c(CharSequence charSequence) {
        View view = this.f1005a;
        AtomicInteger atomicInteger = r8.f3055a;
        boolean z2 = true;
        if (view.getLayoutDirection() != 1) {
            z2 = false;
        }
        return ((r7.c) (z2 ? r7.d : r7.c)).b(charSequence, 0, charSequence.length());
    }

    public final void d(float f2) {
        this.f.left = k((float) this.d.left, (float) this.e.left, f2, this.H);
        this.f.top = k(this.m, this.n, f2, this.H);
        this.f.right = k((float) this.d.right, (float) this.e.right, f2, this.H);
        this.f.bottom = k((float) this.d.bottom, (float) this.e.bottom, f2, this.H);
        this.q = k(this.o, this.p, f2, this.H);
        this.r = k(this.m, this.n, f2, this.H);
        x(k(this.i, this.j, f2, this.I));
        TimeInterpolator timeInterpolator = zj4.b;
        this.U = 1.0f - k(0.0f, 1.0f, 1.0f - f2, timeInterpolator);
        View view = this.f1005a;
        AtomicInteger atomicInteger = r8.f3055a;
        view.postInvalidateOnAnimation();
        this.V = k(1.0f, 0.0f, f2, timeInterpolator);
        this.f1005a.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.l;
        ColorStateList colorStateList2 = this.k;
        if (colorStateList != colorStateList2) {
            this.F.setColor(a(j(colorStateList2), i(), f2));
        } else {
            this.F.setColor(i());
        }
        float f3 = this.R;
        float f4 = this.S;
        if (f3 != f4) {
            this.F.setLetterSpacing(k(f4, f3, f2, timeInterpolator));
        } else {
            this.F.setLetterSpacing(f3);
        }
        this.F.setShadowLayer(k(this.N, this.J, f2, null), k(this.O, this.K, f2, null), k(this.P, this.L, f2, null), a(j(this.Q), j(this.M), f2));
        this.f1005a.postInvalidateOnAnimation();
    }

    public final void e(float f2) {
        float f3;
        boolean z2;
        StaticLayout staticLayout;
        if (this.x != null) {
            float width = (float) this.e.width();
            float width2 = (float) this.d.width();
            int i2 = 1;
            if (Math.abs(f2 - this.j) < 0.001f) {
                f3 = this.j;
                this.B = 1.0f;
                Typeface typeface = this.u;
                Typeface typeface2 = this.s;
                if (typeface != typeface2) {
                    this.u = typeface2;
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                float f4 = this.i;
                Typeface typeface3 = this.u;
                Typeface typeface4 = this.t;
                if (typeface3 != typeface4) {
                    this.u = typeface4;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (Math.abs(f2 - f4) < 0.001f) {
                    this.B = 1.0f;
                } else {
                    this.B = f2 / this.i;
                }
                float f5 = this.j / this.i;
                width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
                f3 = f4;
            }
            if (width > 0.0f) {
                z2 = this.C != f3 || this.E || z2;
                this.C = f3;
                this.E = false;
            }
            if (this.y == null || z2) {
                this.F.setTextSize(this.C);
                this.F.setTypeface(this.u);
                this.F.setLinearText(this.B != 1.0f);
                boolean c2 = c(this.x);
                this.z = c2;
                int i3 = this.Y;
                if (i3 > 1 && !c2) {
                    i2 = i3;
                }
                try {
                    jn4 jn4 = new jn4(this.x, this.F, (int) width);
                    jn4.i = TextUtils.TruncateAt.END;
                    jn4.h = c2;
                    jn4.e = Layout.Alignment.ALIGN_NORMAL;
                    jn4.g = false;
                    jn4.f = i2;
                    staticLayout = jn4.a();
                } catch (jn4.a e2) {
                    e2.getCause().getMessage();
                    staticLayout = null;
                }
                Objects.requireNonNull(staticLayout);
                this.T = staticLayout;
                this.y = staticLayout.getText();
            }
        }
    }

    public final void f() {
        Bitmap bitmap = this.A;
        if (bitmap != null) {
            bitmap.recycle();
            this.A = null;
        }
    }

    public void g(Canvas canvas) {
        int save = canvas.save();
        if (this.y != null && this.b) {
            float lineLeft = (this.T.getLineLeft(0) + this.q) - (this.W * 2.0f);
            this.F.setTextSize(this.C);
            float f2 = this.q;
            float f3 = this.r;
            float f4 = this.B;
            if (f4 != 1.0f) {
                canvas.scale(f4, f4, f2, f3);
            }
            boolean z2 = true;
            if (this.Y <= 1 || this.z) {
                z2 = false;
            }
            if (z2) {
                int alpha = this.F.getAlpha();
                canvas.translate(lineLeft, f3);
                float f5 = (float) alpha;
                this.F.setAlpha((int) (this.V * f5));
                this.T.draw(canvas);
                this.F.setAlpha((int) (this.U * f5));
                int lineBaseline = this.T.getLineBaseline(0);
                CharSequence charSequence = this.X;
                float f6 = (float) lineBaseline;
                canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f6, this.F);
                String trim = this.X.toString().trim();
                if (trim.endsWith("…")) {
                    trim = trim.substring(0, trim.length() - 1);
                }
                this.F.setAlpha(alpha);
                canvas.drawText(trim, 0, Math.min(this.T.getLineEnd(0), trim.length()), 0.0f, f6, (Paint) this.F);
            } else {
                canvas.translate(f2, f3);
                this.T.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    public float h() {
        TextPaint textPaint = this.G;
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
        textPaint.setLetterSpacing(this.R);
        return -this.G.ascent();
    }

    public int i() {
        return j(this.l);
    }

    public final int j(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.D;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    public void l() {
        this.b = this.e.width() > 0 && this.e.height() > 0 && this.d.width() > 0 && this.d.height() > 0;
    }

    public void m() {
        StaticLayout staticLayout;
        if (this.f1005a.getHeight() > 0 && this.f1005a.getWidth() > 0) {
            float f2 = this.C;
            e(this.j);
            CharSequence charSequence = this.y;
            if (!(charSequence == null || (staticLayout = this.T) == null)) {
                this.X = TextUtils.ellipsize(charSequence, this.F, (float) staticLayout.getWidth(), TextUtils.TruncateAt.END);
            }
            CharSequence charSequence2 = this.X;
            float f3 = 0.0f;
            float measureText = charSequence2 != null ? this.F.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
            int absoluteGravity = Gravity.getAbsoluteGravity(this.h, this.z ? 1 : 0);
            int i2 = absoluteGravity & 112;
            if (i2 == 48) {
                this.n = (float) this.e.top;
            } else if (i2 != 80) {
                this.n = ((float) this.e.centerY()) - ((this.F.descent() - this.F.ascent()) / 2.0f);
            } else {
                this.n = this.F.ascent() + ((float) this.e.bottom);
            }
            int i3 = absoluteGravity & 8388615;
            if (i3 == 1) {
                this.p = ((float) this.e.centerX()) - (measureText / 2.0f);
            } else if (i3 != 5) {
                this.p = (float) this.e.left;
            } else {
                this.p = ((float) this.e.right) - measureText;
            }
            e(this.i);
            StaticLayout staticLayout2 = this.T;
            float height = staticLayout2 != null ? (float) staticLayout2.getHeight() : 0.0f;
            CharSequence charSequence3 = this.y;
            float measureText2 = charSequence3 != null ? this.F.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
            StaticLayout staticLayout3 = this.T;
            if (staticLayout3 != null && this.Y > 1 && !this.z) {
                measureText2 = (float) staticLayout3.getWidth();
            }
            StaticLayout staticLayout4 = this.T;
            if (staticLayout4 != null) {
                f3 = staticLayout4.getLineLeft(0);
            }
            this.W = f3;
            int absoluteGravity2 = Gravity.getAbsoluteGravity(this.g, this.z ? 1 : 0);
            int i4 = absoluteGravity2 & 112;
            if (i4 == 48) {
                this.m = (float) this.d.top;
            } else if (i4 != 80) {
                this.m = ((float) this.d.centerY()) - (height / 2.0f);
            } else {
                this.m = this.F.descent() + (((float) this.d.bottom) - height);
            }
            int i5 = absoluteGravity2 & 8388615;
            if (i5 == 1) {
                this.o = ((float) this.d.centerX()) - (measureText2 / 2.0f);
            } else if (i5 != 5) {
                this.o = (float) this.d.left;
            } else {
                this.o = ((float) this.d.right) - measureText2;
            }
            f();
            x(f2);
            d(this.c);
        }
    }

    public void o(int i2) {
        vn4 vn4 = new vn4(this.f1005a.getContext(), i2);
        ColorStateList colorStateList = vn4.f3665a;
        if (colorStateList != null) {
            this.l = colorStateList;
        }
        float f2 = vn4.k;
        if (f2 != 0.0f) {
            this.j = f2;
        }
        ColorStateList colorStateList2 = vn4.b;
        if (colorStateList2 != null) {
            this.M = colorStateList2;
        }
        this.K = vn4.f;
        this.L = vn4.g;
        this.J = vn4.h;
        this.R = vn4.j;
        un4 un4 = this.w;
        if (un4 != null) {
            un4.c = true;
        }
        a aVar = new a();
        vn4.a();
        this.w = new un4(aVar, vn4.n);
        vn4.b(this.f1005a.getContext(), this.w);
        m();
    }

    public void p(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            m();
        }
    }

    public void q(int i2) {
        if (this.h != i2) {
            this.h = i2;
            m();
        }
    }

    public void r(Typeface typeface) {
        un4 un4 = this.w;
        boolean z2 = true;
        if (un4 != null) {
            un4.c = true;
        }
        if (this.s != typeface) {
            this.s = typeface;
        } else {
            z2 = false;
        }
        if (z2) {
            m();
        }
    }

    public void s(int i2) {
        vn4 vn4 = new vn4(this.f1005a.getContext(), i2);
        ColorStateList colorStateList = vn4.f3665a;
        if (colorStateList != null) {
            this.k = colorStateList;
        }
        float f2 = vn4.k;
        if (f2 != 0.0f) {
            this.i = f2;
        }
        ColorStateList colorStateList2 = vn4.b;
        if (colorStateList2 != null) {
            this.Q = colorStateList2;
        }
        this.O = vn4.f;
        this.P = vn4.g;
        this.N = vn4.h;
        this.S = vn4.j;
        un4 un4 = this.v;
        if (un4 != null) {
            un4.c = true;
        }
        b bVar = new b();
        vn4.a();
        this.v = new un4(bVar, vn4.n);
        vn4.b(this.f1005a.getContext(), this.v);
        m();
    }

    public void t(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            m();
        }
    }

    public void u(int i2) {
        if (this.g != i2) {
            this.g = i2;
            m();
        }
    }

    public void v(Typeface typeface) {
        un4 un4 = this.v;
        boolean z2 = true;
        if (un4 != null) {
            un4.c = true;
        }
        if (this.t != typeface) {
            this.t = typeface;
        } else {
            z2 = false;
        }
        if (z2) {
            m();
        }
    }

    public void w(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f2 != this.c) {
            this.c = f2;
            d(f2);
        }
    }

    public final void x(float f2) {
        e(f2);
        View view = this.f1005a;
        AtomicInteger atomicInteger = r8.f3055a;
        view.postInvalidateOnAnimation();
    }

    public final boolean y(int[] iArr) {
        ColorStateList colorStateList;
        this.D = iArr;
        ColorStateList colorStateList2 = this.l;
        if (!((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.k) != null && colorStateList.isStateful()))) {
            return false;
        }
        m();
        return true;
    }

    public void z(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.x, charSequence)) {
            this.x = charSequence;
            this.y = null;
            f();
            m();
        }
    }
}
