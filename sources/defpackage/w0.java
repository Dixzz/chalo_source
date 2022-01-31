package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import com.google.firebase.perf.util.Constants;
import defpackage.z0;
import java.util.Objects;

/* renamed from: w0  reason: default package */
/* compiled from: DrawableContainer */
public class w0 extends Drawable implements Drawable.Callback {
    public static final /* synthetic */ int r = 0;
    public c f;
    public Rect g;
    public Drawable h;
    public Drawable i;
    public int j = Constants.MAX_HOST_LENGTH;
    public boolean k;
    public int l = -1;
    public boolean m;
    public Runnable n;
    public long o;
    public long p;
    public b q;

    /* renamed from: w0$a */
    /* compiled from: DrawableContainer */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            w0.this.a(true);
            w0.this.invalidateSelf();
        }
    }

    /* renamed from: w0$b */
    /* compiled from: DrawableContainer */
    public static class b implements Drawable.Callback {
        public Drawable.Callback f;

        public void invalidateDrawable(Drawable drawable) {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Drawable.Callback callback = this.f;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* renamed from: w0$c */
    /* compiled from: DrawableContainer */
    public static abstract class c extends Drawable.ConstantState {
        public int A = 0;
        public int B = 0;
        public boolean C;
        public ColorFilter D;
        public boolean E;
        public ColorStateList F;
        public PorterDuff.Mode G;
        public boolean H;
        public boolean I;

        /* renamed from: a  reason: collision with root package name */
        public final w0 f3700a;
        public Resources b;
        public int c;
        public int d;
        public int e;
        public SparseArray<Drawable.ConstantState> f;
        public Drawable[] g;
        public int h;
        public boolean i = false;
        public boolean j;
        public Rect k;
        public boolean l = false;
        public boolean m;
        public int n;
        public int o;
        public int p;
        public int q;
        public boolean r;
        public int s;
        public boolean t;
        public boolean u;
        public boolean v;
        public boolean w;
        public boolean x = true;
        public boolean y;
        public int z;

        public c(c cVar, w0 w0Var, Resources resources) {
            Resources resources2;
            this.f3700a = w0Var;
            Rect rect = null;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = cVar != null ? cVar.b : null;
            }
            this.b = resources2;
            int i2 = cVar != null ? cVar.c : 0;
            int i3 = w0.r;
            i2 = resources != null ? resources.getDisplayMetrics().densityDpi : i2;
            i2 = i2 == 0 ? 160 : i2;
            this.c = i2;
            if (cVar != null) {
                this.d = cVar.d;
                this.e = cVar.e;
                this.v = true;
                this.w = true;
                this.i = cVar.i;
                this.l = cVar.l;
                this.x = cVar.x;
                this.y = cVar.y;
                this.z = cVar.z;
                this.A = cVar.A;
                this.B = cVar.B;
                this.C = cVar.C;
                this.D = cVar.D;
                this.E = cVar.E;
                this.F = cVar.F;
                this.G = cVar.G;
                this.H = cVar.H;
                this.I = cVar.I;
                if (cVar.c == i2) {
                    if (cVar.j) {
                        this.k = cVar.k != null ? new Rect(cVar.k) : rect;
                        this.j = true;
                    }
                    if (cVar.m) {
                        this.n = cVar.n;
                        this.o = cVar.o;
                        this.p = cVar.p;
                        this.q = cVar.q;
                        this.m = true;
                    }
                }
                if (cVar.r) {
                    this.s = cVar.s;
                    this.r = true;
                }
                if (cVar.t) {
                    this.u = cVar.u;
                    this.t = true;
                }
                Drawable[] drawableArr = cVar.g;
                this.g = new Drawable[drawableArr.length];
                this.h = cVar.h;
                SparseArray<Drawable.ConstantState> sparseArray = cVar.f;
                if (sparseArray != null) {
                    this.f = sparseArray.clone();
                } else {
                    this.f = new SparseArray<>(this.h);
                }
                int i4 = this.h;
                for (int i5 = 0; i5 < i4; i5++) {
                    if (drawableArr[i5] != null) {
                        Drawable.ConstantState constantState = drawableArr[i5].getConstantState();
                        if (constantState != null) {
                            this.f.put(i5, constantState);
                        } else {
                            this.g[i5] = drawableArr[i5];
                        }
                    }
                }
                return;
            }
            this.g = new Drawable[10];
            this.h = 0;
        }

        public final int a(Drawable drawable) {
            int i2 = this.h;
            if (i2 >= this.g.length) {
                int i3 = i2 + 10;
                z0.a aVar = (z0.a) this;
                Drawable[] drawableArr = new Drawable[i3];
                Drawable[] drawableArr2 = aVar.g;
                if (drawableArr2 != null) {
                    System.arraycopy(drawableArr2, 0, drawableArr, 0, i2);
                }
                aVar.g = drawableArr;
                int[][] iArr = new int[i3][];
                System.arraycopy(aVar.J, 0, iArr, 0, i2);
                aVar.J = iArr;
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f3700a);
            this.g[i2] = drawable;
            this.h++;
            this.e = drawable.getChangingConfigurations() | this.e;
            this.r = false;
            this.t = false;
            this.k = null;
            this.j = false;
            this.m = false;
            this.v = false;
            return i2;
        }

        public void b() {
            this.m = true;
            c();
            int i2 = this.h;
            Drawable[] drawableArr = this.g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.n) {
                    this.n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.o) {
                    this.o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.p) {
                    this.p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.q) {
                    this.q = minimumHeight;
                }
            }
        }

        public final void c() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    int keyAt = this.f.keyAt(i2);
                    Drawable[] drawableArr = this.g;
                    Drawable newDrawable = this.f.valueAt(i2).newDrawable(this.b);
                    if (Build.VERSION.SDK_INT >= 23) {
                        h.s0(newDrawable, this.z);
                    }
                    Drawable mutate = newDrawable.mutate();
                    mutate.setCallback(this.f3700a);
                    drawableArr[keyAt] = mutate;
                }
                this.f = null;
            }
        }

        public boolean canApplyTheme() {
            int i2 = this.h;
            Drawable[] drawableArr = this.g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f.get(i3);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        public final Drawable d(int i2) {
            int indexOfKey;
            Drawable drawable = this.g[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i2)) < 0) {
                return null;
            }
            Drawable newDrawable = this.f.valueAt(indexOfKey).newDrawable(this.b);
            if (Build.VERSION.SDK_INT >= 23) {
                h.s0(newDrawable, this.z);
            }
            Drawable mutate = newDrawable.mutate();
            mutate.setCallback(this.f3700a);
            this.g[i2] = mutate;
            this.f.removeAt(indexOfKey);
            if (this.f.size() == 0) {
                this.f = null;
            }
            return mutate;
        }

        public abstract void e();

        public final void f(Resources resources) {
            if (resources != null) {
                this.b = resources;
                int i2 = w0.r;
                int i3 = resources.getDisplayMetrics().densityDpi;
                if (i3 == 0) {
                    i3 = 160;
                }
                int i4 = this.c;
                this.c = i3;
                if (i4 != i3) {
                    this.m = false;
                    this.j = false;
                }
            }
        }

        public int getChangingConfigurations() {
            return this.d | this.e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r14) {
        /*
        // Method dump skipped, instructions count: 117
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w0.a(boolean):void");
    }

    public void applyTheme(Resources.Theme theme) {
        c cVar = this.f;
        Objects.requireNonNull(cVar);
        if (theme != null) {
            cVar.c();
            int i2 = cVar.h;
            Drawable[] drawableArr = cVar.g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3] != null && drawableArr[i3].canApplyTheme()) {
                    drawableArr[i3].applyTheme(theme);
                    cVar.e |= drawableArr[i3].getChangingConfigurations();
                }
            }
            cVar.f(theme.getResources());
        }
    }

    public c b() {
        throw null;
    }

    public final void c(Drawable drawable) {
        if (this.q == null) {
            this.q = new b();
        }
        b bVar = this.q;
        bVar.f = drawable.getCallback();
        drawable.setCallback(bVar);
        try {
            if (this.f.A <= 0 && this.k) {
                drawable.setAlpha(this.j);
            }
            c cVar = this.f;
            if (cVar.E) {
                drawable.setColorFilter(cVar.D);
            } else {
                if (cVar.H) {
                    drawable.setTintList(cVar.F);
                }
                c cVar2 = this.f;
                if (cVar2.I) {
                    drawable.setTintMode(cVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f.x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                h.s0(drawable, h.M(this));
            }
            drawable.setAutoMirrored(this.f.C);
            Rect rect = this.g;
            if (rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            b bVar2 = this.q;
            Drawable.Callback callback = bVar2.f;
            bVar2.f = null;
            drawable.setCallback(callback);
        }
    }

    public boolean canApplyTheme() {
        return this.f.canApplyTheme();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d(int r10) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w0.d(int):boolean");
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.h;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.i;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public void e(c cVar) {
        throw null;
    }

    public int getAlpha() {
        return this.j;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        c cVar = this.f;
        boolean z = false;
        if (!cVar.v) {
            cVar.c();
            cVar.v = true;
            int i2 = cVar.h;
            Drawable[] drawableArr = cVar.g;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    cVar.w = true;
                    z = true;
                    break;
                } else if (drawableArr[i3].getConstantState() == null) {
                    cVar.w = false;
                    break;
                } else {
                    i3++;
                }
            }
        } else {
            z = cVar.w;
        }
        if (!z) {
            return null;
        }
        this.f.d = getChangingConfigurations();
        return this.f;
    }

    public Drawable getCurrent() {
        return this.h;
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.g;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        c cVar = this.f;
        if (cVar.l) {
            if (!cVar.m) {
                cVar.b();
            }
            return cVar.o;
        }
        Drawable drawable = this.h;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        c cVar = this.f;
        if (cVar.l) {
            if (!cVar.m) {
                cVar.b();
            }
            return cVar.n;
        }
        Drawable drawable = this.h;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        c cVar = this.f;
        if (cVar.l) {
            if (!cVar.m) {
                cVar.b();
            }
            return cVar.q;
        }
        Drawable drawable = this.h;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        c cVar = this.f;
        if (cVar.l) {
            if (!cVar.m) {
                cVar.b();
            }
            return cVar.p;
        }
        Drawable drawable = this.h;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.h;
        int i2 = -2;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        c cVar = this.f;
        if (cVar.r) {
            return cVar.s;
        }
        cVar.c();
        int i3 = cVar.h;
        Drawable[] drawableArr = cVar.g;
        if (i3 > 0) {
            i2 = drawableArr[0].getOpacity();
        }
        for (int i4 = 1; i4 < i3; i4++) {
            i2 = Drawable.resolveOpacity(i2, drawableArr[i4].getOpacity());
        }
        cVar.s = i2;
        cVar.r = true;
        return i2;
    }

    public void getOutline(Outline outline) {
        Drawable drawable = this.h;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean z;
        c cVar = this.f;
        Rect rect2 = null;
        boolean z2 = true;
        if (!cVar.i) {
            Rect rect3 = cVar.k;
            if (rect3 != null || cVar.j) {
                rect2 = rect3;
            } else {
                cVar.c();
                Rect rect4 = new Rect();
                int i2 = cVar.h;
                Drawable[] drawableArr = cVar.g;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3].getPadding(rect4)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i4 = rect4.left;
                        if (i4 > rect2.left) {
                            rect2.left = i4;
                        }
                        int i5 = rect4.top;
                        if (i5 > rect2.top) {
                            rect2.top = i5;
                        }
                        int i6 = rect4.right;
                        if (i6 > rect2.right) {
                            rect2.right = i6;
                        }
                        int i7 = rect4.bottom;
                        if (i7 > rect2.bottom) {
                            rect2.bottom = i7;
                        }
                    }
                }
                cVar.j = true;
                cVar.k = rect2;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            z = (((rect2.left | rect2.top) | rect2.bottom) | rect2.right) != 0;
        } else {
            Drawable drawable = this.h;
            if (drawable != null) {
                z = drawable.getPadding(rect);
            } else {
                z = super.getPadding(rect);
            }
        }
        if (!this.f.C || h.M(this) != 1) {
            z2 = false;
        }
        if (z2) {
            int i8 = rect.left;
            rect.left = rect.right;
            rect.right = i8;
        }
        return z;
    }

    public void invalidateDrawable(Drawable drawable) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.r = false;
            cVar.t = false;
        }
        if (drawable == this.h && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.f.C;
    }

    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.i;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.i = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.k) {
                this.h.setAlpha(this.j);
            }
        }
        if (this.p != 0) {
            this.p = 0;
            z = true;
        }
        if (this.o != 0) {
            this.o = 0;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.m && super.mutate() == this) {
            c b2 = b();
            b2.e();
            e(b2);
            this.m = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.i;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i2) {
        c cVar = this.f;
        int i3 = this.l;
        int i4 = cVar.h;
        Drawable[] drawableArr = cVar.g;
        boolean z = false;
        for (int i5 = 0; i5 < i4; i5++) {
            if (drawableArr[i5] != null) {
                boolean s0 = Build.VERSION.SDK_INT >= 23 ? h.s0(drawableArr[i5], i2) : false;
                if (i5 == i3) {
                    z = s0;
                }
            }
        }
        cVar.z = i2;
        return z;
    }

    public boolean onLevelChange(int i2) {
        Drawable drawable = this.i;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.i;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        if (drawable == this.h && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        if (!this.k || this.j != i2) {
            this.k = true;
            this.j = i2;
            Drawable drawable = this.h;
            if (drawable == null) {
                return;
            }
            if (this.o == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    public void setAutoMirrored(boolean z) {
        c cVar = this.f;
        if (cVar.C != z) {
            cVar.C = z;
            Drawable drawable = this.h;
            if (drawable != null) {
                drawable.setAutoMirrored(z);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        c cVar = this.f;
        cVar.E = true;
        if (cVar.D != colorFilter) {
            cVar.D = colorFilter;
            Drawable drawable = this.h;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean z) {
        c cVar = this.f;
        if (cVar.x != z) {
            cVar.x = z;
            Drawable drawable = this.h;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.h;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.g;
        if (rect == null) {
            this.g = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.h;
        if (drawable != null) {
            drawable.setHotspotBounds(i2, i3, i4, i5);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        c cVar = this.f;
        cVar.H = true;
        if (cVar.F != colorStateList) {
            cVar.F = colorStateList;
            h.y0(this.h, colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f;
        cVar.I = true;
        if (cVar.G != mode) {
            cVar.G = mode;
            h.z0(this.h, mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.i;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.h && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
