package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import com.google.firebase.perf.util.Constants;
import defpackage.lo4;
import defpackage.no4;
import java.util.BitSet;
import java.util.Objects;

/* renamed from: ho4  reason: default package */
/* compiled from: MaterialShapeDrawable */
public class ho4 extends Drawable implements l6, oo4 {
    public static final String B = ho4.class.getSimpleName();
    public static final Paint C = new Paint(1);
    public boolean A;
    public b f;
    public final no4.f[] g;
    public final no4.f[] h;
    public final BitSet i;
    public boolean j;
    public final Matrix k;
    public final Path l;
    public final Path m;
    public final RectF n;
    public final RectF o;
    public final Region p;
    public final Region q;
    public ko4 r;
    public final Paint s;
    public final Paint t;
    public final zn4 u;
    public final lo4.b v;
    public final lo4 w;
    public PorterDuffColorFilter x;
    public PorterDuffColorFilter y;
    public final RectF z;

    /* renamed from: ho4$a */
    /* compiled from: MaterialShapeDrawable */
    public class a implements lo4.b {
        public a() {
        }
    }

    public ho4() {
        this(new ko4());
    }

    public final void b(RectF rectF, Path path) {
        c(rectF, path);
        if (this.f.j != 1.0f) {
            this.k.reset();
            Matrix matrix = this.k;
            float f2 = this.f.j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.k);
        }
        path.computeBounds(this.z, true);
    }

    public final void c(RectF rectF, Path path) {
        lo4 lo4 = this.w;
        b bVar = this.f;
        lo4.a(bVar.f1403a, bVar.k, rectF, this.v, path);
    }

    public final PorterDuffColorFilter d(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z2) {
        int color;
        int e;
        if (colorStateList == null || mode == null) {
            return (!z2 || (e = e((color = paint.getColor()))) == color) ? null : new PorterDuffColorFilter(e, PorterDuff.Mode.SRC_IN);
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z2) {
            colorForState = e(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00eb, code lost:
        if ((!o() && !r12.l.isConvex() && android.os.Build.VERSION.SDK_INT < 29) != false) goto L_0x00ed;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r13) {
        /*
        // Method dump skipped, instructions count: 481
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ho4.draw(android.graphics.Canvas):void");
    }

    public int e(int i2) {
        b bVar = this.f;
        float f2 = bVar.o + bVar.p + bVar.n;
        tm4 tm4 = bVar.b;
        if (tm4 == null || !tm4.f3378a) {
            return i2;
        }
        if (!(a6.c(i2, Constants.MAX_HOST_LENGTH) == tm4.c)) {
            return i2;
        }
        float f3 = tm4.d;
        float f4 = 0.0f;
        if (f3 > 0.0f && f2 > 0.0f) {
            f4 = Math.min(((((float) Math.log1p((double) (f2 / f3))) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        }
        return a6.c(hd3.Z1(a6.c(i2, Constants.MAX_HOST_LENGTH), tm4.b, f4), Color.alpha(i2));
    }

    public final void f(Canvas canvas) {
        this.i.cardinality();
        if (this.f.s != 0) {
            canvas.drawPath(this.l, this.u.f4191a);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            no4.f fVar = this.g[i2];
            zn4 zn4 = this.u;
            int i3 = this.f.r;
            Matrix matrix = no4.f.f2583a;
            fVar.a(matrix, zn4, i3, canvas);
            this.h[i2].a(matrix, this.u, this.f.r, canvas);
        }
        if (this.A) {
            int i4 = i();
            int j2 = j();
            canvas.translate((float) (-i4), (float) (-j2));
            canvas.drawPath(this.l, C);
            canvas.translate((float) i4, (float) j2);
        }
    }

    public final void g(Canvas canvas, Paint paint, Path path, ko4 ko4, RectF rectF) {
        if (ko4.d(rectF)) {
            float a2 = ko4.f.a(rectF) * this.f.k;
            canvas.drawRoundRect(rectF, a2, a2, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    public Drawable.ConstantState getConstantState() {
        return this.f;
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f.q != 2) {
            if (o()) {
                outline.setRoundRect(getBounds(), l() * this.f.k);
                return;
            }
            b(h(), this.l);
            if (this.l.isConvex() || Build.VERSION.SDK_INT >= 29) {
                try {
                    outline.setConvexPath(this.l);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f.i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public Region getTransparentRegion() {
        this.p.set(getBounds());
        b(h(), this.l);
        this.q.setPath(this.l, this.p);
        this.p.op(this.q, Region.Op.DIFFERENCE);
        return this.p;
    }

    public RectF h() {
        this.n.set(getBounds());
        return this.n;
    }

    public int i() {
        b bVar = this.f;
        return (int) (Math.sin(Math.toRadians((double) bVar.t)) * ((double) bVar.s));
    }

    public void invalidateSelf() {
        this.j = true;
        super.invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f.g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f.f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f.e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f.d) != null && colorStateList4.isStateful())));
    }

    public int j() {
        b bVar = this.f;
        return (int) (Math.cos(Math.toRadians((double) bVar.t)) * ((double) bVar.s));
    }

    public final float k() {
        if (m()) {
            return this.t.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public float l() {
        return this.f.f1403a.e.a(h());
    }

    public final boolean m() {
        Paint.Style style = this.f.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.t.getStrokeWidth() > 0.0f;
    }

    public Drawable mutate() {
        this.f = new b(this.f);
        return this;
    }

    public void n(Context context) {
        this.f.b = new tm4(context);
        y();
    }

    public boolean o() {
        return this.f.f1403a.d(h());
    }

    public void onBoundsChange(Rect rect) {
        this.j = true;
        super.onBoundsChange(rect);
    }

    public boolean onStateChange(int[] iArr) {
        boolean z2 = w(iArr) || x();
        if (z2) {
            invalidateSelf();
        }
        return z2;
    }

    public void p(float f2) {
        b bVar = this.f;
        if (bVar.o != f2) {
            bVar.o = f2;
            y();
        }
    }

    public void q(ColorStateList colorStateList) {
        b bVar = this.f;
        if (bVar.d != colorStateList) {
            bVar.d = colorStateList;
            onStateChange(getState());
        }
    }

    public void r(float f2) {
        b bVar = this.f;
        if (bVar.k != f2) {
            bVar.k = f2;
            this.j = true;
            invalidateSelf();
        }
    }

    public void s(int i2) {
        this.u.a(i2);
        this.f.u = false;
        super.invalidateSelf();
    }

    public void setAlpha(int i2) {
        b bVar = this.f;
        if (bVar.m != i2) {
            bVar.m = i2;
            super.invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f.c = colorFilter;
        super.invalidateSelf();
    }

    @Override // defpackage.oo4
    public void setShapeAppearanceModel(ko4 ko4) {
        this.f.f1403a = ko4;
        invalidateSelf();
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f.g = colorStateList;
        x();
        super.invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        b bVar = this.f;
        if (bVar.h != mode) {
            bVar.h = mode;
            x();
            super.invalidateSelf();
        }
    }

    public void t(float f2, int i2) {
        this.f.l = f2;
        invalidateSelf();
        v(ColorStateList.valueOf(i2));
    }

    public void u(float f2, ColorStateList colorStateList) {
        this.f.l = f2;
        invalidateSelf();
        v(colorStateList);
    }

    public void v(ColorStateList colorStateList) {
        b bVar = this.f;
        if (bVar.e != colorStateList) {
            bVar.e = colorStateList;
            onStateChange(getState());
        }
    }

    public final boolean w(int[] iArr) {
        boolean z2;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f.d == null || color2 == (colorForState2 = this.f.d.getColorForState(iArr, (color2 = this.s.getColor())))) {
            z2 = false;
        } else {
            this.s.setColor(colorForState2);
            z2 = true;
        }
        if (this.f.e == null || color == (colorForState = this.f.e.getColorForState(iArr, (color = this.t.getColor())))) {
            return z2;
        }
        this.t.setColor(colorForState);
        return true;
    }

    public final boolean x() {
        PorterDuffColorFilter porterDuffColorFilter = this.x;
        PorterDuffColorFilter porterDuffColorFilter2 = this.y;
        b bVar = this.f;
        this.x = d(bVar.g, bVar.h, this.s, true);
        b bVar2 = this.f;
        this.y = d(bVar2.f, bVar2.h, this.t, false);
        b bVar3 = this.f;
        if (bVar3.u) {
            this.u.a(bVar3.g.getColorForState(getState(), 0));
        }
        if (!Objects.equals(porterDuffColorFilter, this.x) || !Objects.equals(porterDuffColorFilter2, this.y)) {
            return true;
        }
        return false;
    }

    public final void y() {
        b bVar = this.f;
        float f2 = bVar.o + bVar.p;
        bVar.r = (int) Math.ceil((double) (0.75f * f2));
        this.f.s = (int) Math.ceil((double) (f2 * 0.25f));
        x();
        super.invalidateSelf();
    }

    public ho4(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(ko4.b(context, null, i2, i3).a());
    }

    public ho4(ko4 ko4) {
        this(new b(ko4, null));
    }

    public ho4(b bVar) {
        lo4 lo4;
        this.g = new no4.f[4];
        this.h = new no4.f[4];
        this.i = new BitSet(8);
        this.k = new Matrix();
        this.l = new Path();
        this.m = new Path();
        this.n = new RectF();
        this.o = new RectF();
        this.p = new Region();
        this.q = new Region();
        Paint paint = new Paint(1);
        this.s = paint;
        Paint paint2 = new Paint(1);
        this.t = paint2;
        this.u = new zn4();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            lo4 = lo4.a.f2250a;
        } else {
            lo4 = new lo4();
        }
        this.w = lo4;
        this.z = new RectF();
        this.A = true;
        this.f = bVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = C;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        x();
        w(getState());
        this.v = new a();
    }

    /* renamed from: ho4$b */
    /* compiled from: MaterialShapeDrawable */
    public static final class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public ko4 f1403a;
        public tm4 b;
        public ColorFilter c;
        public ColorStateList d = null;
        public ColorStateList e = null;
        public ColorStateList f = null;
        public ColorStateList g = null;
        public PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
        public Rect i = null;
        public float j = 1.0f;
        public float k = 1.0f;
        public float l;
        public int m = Constants.MAX_HOST_LENGTH;
        public float n = 0.0f;
        public float o = 0.0f;
        public float p = 0.0f;
        public int q = 0;
        public int r = 0;
        public int s = 0;
        public int t = 0;
        public boolean u = false;
        public Paint.Style v = Paint.Style.FILL_AND_STROKE;

        public b(ko4 ko4, tm4 tm4) {
            this.f1403a = ko4;
            this.b = null;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            ho4 ho4 = new ho4(this);
            ho4.j = true;
            return ho4;
        }

        public b(b bVar) {
            this.f1403a = bVar.f1403a;
            this.b = bVar.b;
            this.l = bVar.l;
            this.c = bVar.c;
            this.d = bVar.d;
            this.e = bVar.e;
            this.h = bVar.h;
            this.g = bVar.g;
            this.m = bVar.m;
            this.j = bVar.j;
            this.s = bVar.s;
            this.q = bVar.q;
            this.u = bVar.u;
            this.k = bVar.k;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.r = bVar.r;
            this.t = bVar.t;
            this.f = bVar.f;
            this.v = bVar.v;
            if (bVar.i != null) {
                this.i = new Rect(bVar.i);
            }
        }
    }
}
