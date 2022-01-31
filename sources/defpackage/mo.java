package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import com.google.firebase.perf.util.Constants;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: mo  reason: default package */
/* compiled from: VectorDrawableCompat */
public class mo extends lo {
    public static final PorterDuff.Mode o = PorterDuff.Mode.SRC_IN;
    public h g;
    public PorterDuffColorFilter h;
    public ColorFilter i;
    public boolean j;
    public boolean k;
    public final float[] l;
    public final Matrix m;
    public final Rect n;

    /* renamed from: mo$b */
    /* compiled from: VectorDrawableCompat */
    public static class b extends f {
        public b() {
        }

        @Override // defpackage.mo.f
        public boolean c() {
            return true;
        }

        public b(b bVar) {
            super(bVar);
        }
    }

    /* renamed from: mo$e */
    /* compiled from: VectorDrawableCompat */
    public static abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }

        public e(a aVar) {
        }
    }

    /* renamed from: mo$h */
    /* compiled from: VectorDrawableCompat */
    public static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public int f2415a;
        public g b;
        public ColorStateList c;
        public PorterDuff.Mode d;
        public boolean e;
        public Bitmap f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public int i;
        public boolean j;
        public boolean k;
        public Paint l;

        public h(h hVar) {
            this.c = null;
            this.d = mo.o;
            if (hVar != null) {
                this.f2415a = hVar.f2415a;
                g gVar = new g(hVar.b);
                this.b = gVar;
                if (hVar.b.e != null) {
                    gVar.e = new Paint(hVar.b.e);
                }
                if (hVar.b.d != null) {
                    this.b.d = new Paint(hVar.b.d);
                }
                this.c = hVar.c;
                this.d = hVar.d;
                this.e = hVar.e;
            }
        }

        public boolean a() {
            g gVar = this.b;
            if (gVar.o == null) {
                gVar.o = Boolean.valueOf(gVar.h.a());
            }
            return gVar.o.booleanValue();
        }

        public void b(int i2, int i3) {
            this.f.eraseColor(0);
            Canvas canvas = new Canvas(this.f);
            g gVar = this.b;
            gVar.a(gVar.h, g.q, canvas, i2, i3, null);
        }

        public int getChangingConfigurations() {
            return this.f2415a;
        }

        public Drawable newDrawable() {
            return new mo(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new mo(this);
        }

        public h() {
            this.c = null;
            this.d = mo.o;
            this.b = new g();
        }
    }

    public mo() {
        this.k = true;
        this.l = new float[9];
        this.m = new Matrix();
        this.n = new Rect();
        this.g = new h();
    }

    public static mo a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        mo moVar = new mo();
        moVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return moVar;
    }

    public PorterDuffColorFilter b(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f;
        if (drawable == null) {
            return false;
        }
        drawable.canApplyTheme();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d3, code lost:
        if ((r1 == r7.getWidth() && r3 == r6.f.getHeight()) == false) goto L_0x00d5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r11) {
        /*
        // Method dump skipped, instructions count: 364
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mo.draw(android.graphics.Canvas):void");
    }

    public int getAlpha() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.g.b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.g.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getColorFilter();
        }
        return this.i;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.f.getConstantState());
        }
        this.g.f2415a = getChangingConfigurations();
        return this.g;
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.g.b.j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.g.b.i;
    }

    public int getOpacity() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.g.e;
    }

    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((hVar = this.g) != null && (hVar.a() || ((colorStateList = this.g.c) != null && colorStateList.isStateful())));
    }

    public Drawable mutate() {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.j && super.mutate() == this) {
            this.g = new h(this.g);
            this.j = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        h hVar = this.g;
        ColorStateList colorStateList = hVar.c;
        if (!(colorStateList == null || (mode = hVar.d) == null)) {
            this.h = b(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (hVar.a()) {
            boolean b2 = hVar.b.h.b(iArr);
            hVar.k |= b2;
            if (b2) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.g.b.getRootAlpha() != i2) {
            this.g.b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.g.e = z;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.i = colorFilter;
        invalidateSelf();
    }

    public void setTint(int i2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            h.x0(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f;
        if (drawable != null) {
            h.y0(drawable, colorStateList);
            return;
        }
        h hVar = this.g;
        if (hVar.c != colorStateList) {
            hVar.c = colorStateList;
            this.h = b(colorStateList, hVar.d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f;
        if (drawable != null) {
            h.z0(drawable, mode);
            return;
        }
        h hVar = this.g;
        if (hVar.d != mode) {
            hVar.d = mode;
            this.h = b(hVar.c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* renamed from: mo$i */
    /* compiled from: VectorDrawableCompat */
    public static class i extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public final Drawable.ConstantState f2416a;

        public i(Drawable.ConstantState constantState) {
            this.f2416a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f2416a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f2416a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            mo moVar = new mo();
            moVar.f = (VectorDrawable) this.f2416a.newDrawable();
            return moVar;
        }

        public Drawable newDrawable(Resources resources) {
            mo moVar = new mo();
            moVar.f = (VectorDrawable) this.f2416a.newDrawable(resources);
            return moVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            mo moVar = new mo();
            moVar.f = (VectorDrawable) this.f2416a.newDrawable(resources, theme);
            return moVar;
        }
    }

    /* renamed from: mo$f */
    /* compiled from: VectorDrawableCompat */
    public static abstract class f extends e {

        /* renamed from: a  reason: collision with root package name */
        public c6[] f2413a = null;
        public String b;
        public int c = 0;
        public int d;

        public f() {
            super(null);
        }

        public boolean c() {
            return false;
        }

        public c6[] getPathData() {
            return this.f2413a;
        }

        public String getPathName() {
            return this.b;
        }

        public void setPathData(c6[] c6VarArr) {
            if (!h.l(this.f2413a, c6VarArr)) {
                this.f2413a = h.D(c6VarArr);
                return;
            }
            c6[] c6VarArr2 = this.f2413a;
            for (int i = 0; i < c6VarArr.length; i++) {
                c6VarArr2[i].f524a = c6VarArr[i].f524a;
                for (int i2 = 0; i2 < c6VarArr[i].b.length; i2++) {
                    c6VarArr2[i].b[i2] = c6VarArr[i].b[i2];
                }
            }
        }

        public f(f fVar) {
            super(null);
            this.b = fVar.b;
            this.d = fVar.d;
            this.f2413a = h.D(fVar.f2413a);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:199:0x04cc  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f0  */
    @Override // android.graphics.drawable.Drawable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void inflate(android.content.res.Resources r27, org.xmlpull.v1.XmlPullParser r28, android.util.AttributeSet r29, android.content.res.Resources.Theme r30) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1266
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mo.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    public mo(h hVar) {
        this.k = true;
        this.l = new float[9];
        this.m = new Matrix();
        this.n = new Rect();
        this.g = hVar;
        this.h = b(hVar.c, hVar.d);
    }

    /* renamed from: mo$c */
    /* compiled from: VectorDrawableCompat */
    public static class c extends f {
        public int[] e;
        public s5 f;
        public float g = 0.0f;
        public s5 h;
        public float i = 1.0f;
        public float j = 1.0f;
        public float k = 0.0f;
        public float l = 1.0f;
        public float m = 0.0f;
        public Paint.Cap n = Paint.Cap.BUTT;
        public Paint.Join o = Paint.Join.MITER;
        public float p = 4.0f;

        public c() {
        }

        @Override // defpackage.mo.e
        public boolean a() {
            return this.h.c() || this.f.c();
        }

        @Override // defpackage.mo.e
        public boolean b(int[] iArr) {
            return this.f.d(iArr) | this.h.d(iArr);
        }

        public float getFillAlpha() {
            return this.j;
        }

        public int getFillColor() {
            return this.h.c;
        }

        public float getStrokeAlpha() {
            return this.i;
        }

        public int getStrokeColor() {
            return this.f.c;
        }

        public float getStrokeWidth() {
            return this.g;
        }

        public float getTrimPathEnd() {
            return this.l;
        }

        public float getTrimPathOffset() {
            return this.m;
        }

        public float getTrimPathStart() {
            return this.k;
        }

        public void setFillAlpha(float f2) {
            this.j = f2;
        }

        public void setFillColor(int i2) {
            this.h.c = i2;
        }

        public void setStrokeAlpha(float f2) {
            this.i = f2;
        }

        public void setStrokeColor(int i2) {
            this.f.c = i2;
        }

        public void setStrokeWidth(float f2) {
            this.g = f2;
        }

        public void setTrimPathEnd(float f2) {
            this.l = f2;
        }

        public void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        public void setTrimPathStart(float f2) {
            this.k = f2;
        }

        public c(c cVar) {
            super(cVar);
            this.e = cVar.e;
            this.f = cVar.f;
            this.g = cVar.g;
            this.i = cVar.i;
            this.h = cVar.h;
            this.c = cVar.c;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }
    }

    /* renamed from: mo$g */
    /* compiled from: VectorDrawableCompat */
    public static class g {
        public static final Matrix q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        public final Path f2414a;
        public final Path b;
        public final Matrix c;
        public Paint d;
        public Paint e;
        public PathMeasure f;
        public int g;
        public final d h;
        public float i;
        public float j;
        public float k;
        public float l;
        public int m;
        public String n;
        public Boolean o;
        public final n2<String, Object> p;

        public g() {
            this.c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = Constants.MAX_HOST_LENGTH;
            this.n = null;
            this.o = null;
            this.p = new n2<>();
            this.h = new d();
            this.f2414a = new Path();
            this.b = new Path();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r13v11, resolved type: android.graphics.PathMeasure */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(defpackage.mo.d r18, android.graphics.Matrix r19, android.graphics.Canvas r20, int r21, int r22, android.graphics.ColorFilter r23) {
            /*
            // Method dump skipped, instructions count: 606
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.mo.g.a(mo$d, android.graphics.Matrix, android.graphics.Canvas, int, int, android.graphics.ColorFilter):void");
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.m;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.m = i2;
        }

        public g(g gVar) {
            this.c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = Constants.MAX_HOST_LENGTH;
            this.n = null;
            this.o = null;
            n2<String, Object> n2Var = new n2<>();
            this.p = n2Var;
            this.h = new d(gVar.h, n2Var);
            this.f2414a = new Path(gVar.f2414a);
            this.b = new Path(gVar.b);
            this.i = gVar.i;
            this.j = gVar.j;
            this.k = gVar.k;
            this.l = gVar.l;
            this.g = gVar.g;
            this.m = gVar.m;
            this.n = gVar.n;
            String str = gVar.n;
            if (str != null) {
                n2Var.put(str, this);
            }
            this.o = gVar.o;
        }
    }

    /* renamed from: mo$d */
    /* compiled from: VectorDrawableCompat */
    public static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        public final Matrix f2412a;
        public final ArrayList<e> b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;
        public float i;
        public final Matrix j;
        public int k;
        public int[] l;
        public String m;

        public d(d dVar, n2<String, Object> n2Var) {
            super(null);
            f fVar;
            this.f2412a = new Matrix();
            this.b = new ArrayList<>();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            Matrix matrix = new Matrix();
            this.j = matrix;
            this.m = null;
            this.c = dVar.c;
            this.d = dVar.d;
            this.e = dVar.e;
            this.f = dVar.f;
            this.g = dVar.g;
            this.h = dVar.h;
            this.i = dVar.i;
            this.l = dVar.l;
            String str = dVar.m;
            this.m = str;
            this.k = dVar.k;
            if (str != null) {
                n2Var.put(str, this);
            }
            matrix.set(dVar.j);
            ArrayList<e> arrayList = dVar.b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e eVar = arrayList.get(i2);
                if (eVar instanceof d) {
                    this.b.add(new d((d) eVar, n2Var));
                } else {
                    if (eVar instanceof c) {
                        fVar = new c((c) eVar);
                    } else if (eVar instanceof b) {
                        fVar = new b((b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.b.add(fVar);
                    String str2 = fVar.b;
                    if (str2 != null) {
                        n2Var.put(str2, fVar);
                    }
                }
            }
        }

        @Override // defpackage.mo.e
        public boolean a() {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                if (this.b.get(i2).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // defpackage.mo.e
        public boolean b(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                z |= this.b.get(i2).b(iArr);
            }
            return z;
        }

        public final void c() {
            this.j.reset();
            this.j.postTranslate(-this.d, -this.e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.d, this.i + this.e);
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.d;
        }

        public float getPivotY() {
            return this.e;
        }

        public float getRotation() {
            return this.c;
        }

        public float getScaleX() {
            return this.f;
        }

        public float getScaleY() {
            return this.g;
        }

        public float getTranslateX() {
            return this.h;
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.d) {
                this.d = f2;
                c();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.e) {
                this.e = f2;
                c();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.c) {
                this.c = f2;
                c();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f) {
                this.f = f2;
                c();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.g) {
                this.g = f2;
                c();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.h) {
                this.h = f2;
                c();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.i) {
                this.i = f2;
                c();
            }
        }

        public d() {
            super(null);
            this.f2412a = new Matrix();
            this.b = new ArrayList<>();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }
    }
}
