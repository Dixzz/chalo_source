package defpackage;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import defpackage.w0;
import defpackage.z0;

@SuppressLint({"RestrictedAPI"})
/* renamed from: v0  reason: default package */
/* compiled from: AnimatedStateListDrawableCompat */
public class v0 extends z0 implements l6 {
    public c u;
    public g v;
    public int w;
    public int x;
    public boolean y;

    /* renamed from: v0$b */
    /* compiled from: AnimatedStateListDrawableCompat */
    public static class b extends g {

        /* renamed from: a  reason: collision with root package name */
        public final Animatable f3576a;

        public b(Animatable animatable) {
            super(null);
            this.f3576a = animatable;
        }

        @Override // defpackage.v0.g
        public void c() {
            this.f3576a.start();
        }

        @Override // defpackage.v0.g
        public void d() {
            this.f3576a.stop();
        }
    }

    /* renamed from: v0$c */
    /* compiled from: AnimatedStateListDrawableCompat */
    public static class c extends z0.a {
        public r2<Long> K;
        public v2<Integer> L;

        public c(c cVar, v0 v0Var, Resources resources) {
            super(cVar, v0Var, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
                return;
            }
            this.K = new r2<>();
            this.L = new v2<>();
        }

        public static long h(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        @Override // defpackage.z0.a, defpackage.w0.c
        public void e() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        public int i(int i) {
            if (i < 0) {
                return 0;
            }
            return this.L.e(i, 0).intValue();
        }

        @Override // defpackage.z0.a
        public Drawable newDrawable() {
            return new v0(this, null);
        }

        @Override // defpackage.z0.a
        public Drawable newDrawable(Resources resources) {
            return new v0(this, resources);
        }
    }

    /* renamed from: v0$d */
    /* compiled from: AnimatedStateListDrawableCompat */
    public static class d extends g {

        /* renamed from: a  reason: collision with root package name */
        public final io f3577a;

        public d(io ioVar) {
            super(null);
            this.f3577a = ioVar;
        }

        @Override // defpackage.v0.g
        public void c() {
            this.f3577a.start();
        }

        @Override // defpackage.v0.g
        public void d() {
            this.f3577a.stop();
        }
    }

    /* renamed from: v0$e */
    /* compiled from: AnimatedStateListDrawableCompat */
    public static class e extends g {

        /* renamed from: a  reason: collision with root package name */
        public final ObjectAnimator f3578a;
        public final boolean b;

        public e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super(null);
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            ofInt.setAutoCancel(true);
            ofInt.setDuration((long) fVar.c);
            ofInt.setInterpolator(fVar);
            this.b = z2;
            this.f3578a = ofInt;
        }

        @Override // defpackage.v0.g
        public boolean a() {
            return this.b;
        }

        @Override // defpackage.v0.g
        public void b() {
            this.f3578a.reverse();
        }

        @Override // defpackage.v0.g
        public void c() {
            this.f3578a.start();
        }

        @Override // defpackage.v0.g
        public void d() {
            this.f3578a.cancel();
        }
    }

    /* renamed from: v0$f */
    /* compiled from: AnimatedStateListDrawableCompat */
    public static class f implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        public int[] f3579a;
        public int b;
        public int c;

        public f(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.b = numberOfFrames;
            int[] iArr = this.f3579a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f3579a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f3579a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.c = i;
        }

        public float getInterpolation(float f) {
            int i = (int) ((f * ((float) this.c)) + 0.5f);
            int i2 = this.b;
            int[] iArr = this.f3579a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (((float) i3) / ((float) i2)) + (i3 < i2 ? ((float) i) / ((float) this.c) : 0.0f);
        }
    }

    /* renamed from: v0$g */
    /* compiled from: AnimatedStateListDrawableCompat */
    public static abstract class g {
        public g(a aVar) {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public v0() {
        this(null, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0207, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(defpackage.hj1.d0(r20, new java.lang.StringBuilder(), ": <transition> tag requires 'fromId' & 'toId' attributes"));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.v0 g(android.content.Context r18, android.content.res.Resources r19, org.xmlpull.v1.XmlPullParser r20, android.util.AttributeSet r21, android.content.res.Resources.Theme r22) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
        // Method dump skipped, instructions count: 587
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v0.g(android.content.Context, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):v0");
    }

    @Override // defpackage.z0, defpackage.w0
    public w0.c b() {
        return new c(this.u, this, null);
    }

    @Override // defpackage.z0, defpackage.w0
    public void e(w0.c cVar) {
        super.e(cVar);
        if (cVar instanceof c) {
            this.u = (c) cVar;
        }
    }

    @Override // defpackage.z0
    public z0.a f() {
        return new c(this.u, this, null);
    }

    @Override // defpackage.z0
    public boolean isStateful() {
        return true;
    }

    @Override // defpackage.w0
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.v;
        if (gVar != null) {
            gVar.d();
            this.v = null;
            d(this.w);
            this.w = -1;
            this.x = -1;
        }
    }

    @Override // defpackage.z0, defpackage.w0
    public Drawable mutate() {
        if (!this.y) {
            super.mutate();
            if (this == this) {
                this.u.e();
                this.y = true;
            }
        }
        return this;
    }

    @Override // defpackage.z0, defpackage.w0
    public boolean onStateChange(int[] iArr) {
        boolean z;
        g gVar;
        c cVar = this.u;
        int g2 = cVar.g(iArr);
        if (g2 < 0) {
            g2 = cVar.g(StateSet.WILD_CARD);
        }
        int i = this.l;
        boolean z2 = false;
        if (g2 != i) {
            g gVar2 = this.v;
            if (gVar2 != null) {
                if (g2 != this.w) {
                    if (g2 != this.x || !gVar2.a()) {
                        i = this.w;
                        gVar2.d();
                    } else {
                        gVar2.b();
                        this.w = this.x;
                        this.x = g2;
                    }
                }
                z = true;
                if (z || d(g2)) {
                    z2 = true;
                }
            }
            this.v = null;
            this.x = -1;
            this.w = -1;
            c cVar2 = this.u;
            int i2 = cVar2.i(i);
            int i3 = cVar2.i(g2);
            if (!(i3 == 0 || i2 == 0)) {
                int longValue = (int) cVar2.K.g(c.h(i2, i3), -1L).longValue();
                if (longValue >= 0) {
                    boolean z3 = (cVar2.K.g(c.h(i2, i3), -1L).longValue() & 8589934592L) != 0;
                    d(longValue);
                    Drawable drawable = this.h;
                    if (drawable instanceof AnimationDrawable) {
                        gVar = new e((AnimationDrawable) drawable, (cVar2.K.g(c.h(i2, i3), -1L).longValue() & 4294967296L) != 0, z3);
                    } else if (drawable instanceof io) {
                        gVar = new d((io) drawable);
                    } else if (drawable instanceof Animatable) {
                        gVar = new b((Animatable) drawable);
                    }
                    gVar.c();
                    this.v = gVar;
                    this.x = i;
                    this.w = g2;
                    z = true;
                    z2 = true;
                }
            }
            z = false;
            z2 = true;
        }
        Drawable drawable2 = this.h;
        return drawable2 != null ? z2 | drawable2.setState(iArr) : z2;
    }

    @Override // defpackage.w0
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        g gVar = this.v;
        if (gVar != null && (visible || z2)) {
            if (z) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public v0(c cVar, Resources resources) {
        super(null);
        this.w = -1;
        this.x = -1;
        c cVar2 = new c(cVar, this, resources);
        super.e(cVar2);
        this.u = cVar2;
        onStateChange(getState());
        jumpToCurrentState();
    }
}
