package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: io  reason: default package */
/* compiled from: AnimatedVectorDrawableCompat */
public class io extends lo implements Animatable {
    public b g;
    public Context h;
    public ArgbEvaluator i;
    public final Drawable.Callback j;

    /* renamed from: io$a */
    /* compiled from: AnimatedVectorDrawableCompat */
    public class a implements Drawable.Callback {
        public a() {
        }

        public void invalidateDrawable(Drawable drawable) {
            io.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            io.this.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            io.this.unscheduleSelf(runnable);
        }
    }

    /* renamed from: io$b */
    /* compiled from: AnimatedVectorDrawableCompat */
    public static class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public int f1542a;
        public mo b;
        public AnimatorSet c;
        public ArrayList<Animator> d;
        public n2<Animator, String> e;

        public b(b bVar, Drawable.Callback callback, Resources resources) {
            if (bVar != null) {
                this.f1542a = bVar.f1542a;
                mo moVar = bVar.b;
                if (moVar != null) {
                    Drawable.ConstantState constantState = moVar.getConstantState();
                    if (resources != null) {
                        this.b = (mo) constantState.newDrawable(resources);
                    } else {
                        this.b = (mo) constantState.newDrawable();
                    }
                    mo moVar2 = this.b;
                    moVar2.mutate();
                    this.b = moVar2;
                    moVar2.setCallback(callback);
                    this.b.setBounds(bVar.b.getBounds());
                    this.b.k = false;
                }
                ArrayList<Animator> arrayList = bVar.d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.d = new ArrayList<>(size);
                    this.e = new n2<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = bVar.d.get(i);
                        Animator clone = animator.clone();
                        String orDefault = bVar.e.getOrDefault(animator, null);
                        clone.setTarget(this.b.g.b.p.getOrDefault(orDefault, null));
                        this.d.add(clone);
                        this.e.put(clone, orDefault);
                    }
                    if (this.c == null) {
                        this.c = new AnimatorSet();
                    }
                    this.c.playTogether(this.d);
                }
            }
        }

        public int getChangingConfigurations() {
            return this.f1542a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public io() {
        this(null, null, null);
    }

    @Override // defpackage.lo
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.applyTheme(theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.g.b.draw(canvas);
        if (this.g.c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.g.b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.g.f1542a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getColorFilter();
        }
        return this.g.b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new c(this.f.getConstantState());
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.g.b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.g.b.getIntrinsicWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.g.b.getOpacity();
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007a A[Catch:{ IOException | XmlPullParserException -> 0x0087 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x007f A[SYNTHETIC] */
    @Override // android.graphics.drawable.Drawable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void inflate(android.content.res.Resources r23, org.xmlpull.v1.XmlPullParser r24, android.util.AttributeSet r25, android.content.res.Resources.Theme r26) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 402
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.io.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.g.b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.g.c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.g.b.isStateful();
    }

    public Drawable mutate() {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.g.b.setBounds(rect);
        }
    }

    @Override // defpackage.lo
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        return this.g.b.setLevel(i2);
    }

    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.g.b.setState(iArr);
    }

    public void setAlpha(int i2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else {
            this.g.b.setAlpha(i2);
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
            return;
        }
        mo moVar = this.g.b;
        Drawable drawable2 = moVar.f;
        if (drawable2 != null) {
            drawable2.setAutoMirrored(z);
        } else {
            moVar.g.e = z;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        mo moVar = this.g.b;
        Drawable drawable2 = moVar.f;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
            return;
        }
        moVar.i = colorFilter;
        moVar.invalidateSelf();
    }

    public void setTint(int i2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            h.x0(drawable, i2);
        } else {
            this.g.b.setTint(i2);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f;
        if (drawable != null) {
            h.y0(drawable, colorStateList);
        } else {
            this.g.b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f;
        if (drawable != null) {
            h.z0(drawable, mode);
        } else {
            this.g.b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.g.b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        Drawable drawable = this.f;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.g.c.isStarted()) {
            this.g.c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.f;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.g.c.end();
        }
    }

    public io(Context context, b bVar, Resources resources) {
        this.i = null;
        a aVar = new a();
        this.j = aVar;
        this.h = context;
        this.g = new b(null, aVar, null);
    }

    /* renamed from: io$c */
    /* compiled from: AnimatedVectorDrawableCompat */
    public static class c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public final Drawable.ConstantState f1543a;

        public c(Drawable.ConstantState constantState) {
            this.f1543a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f1543a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f1543a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            io ioVar = new io(null, null, null);
            Drawable newDrawable = this.f1543a.newDrawable();
            ioVar.f = newDrawable;
            newDrawable.setCallback(ioVar.j);
            return ioVar;
        }

        public Drawable newDrawable(Resources resources) {
            io ioVar = new io(null, null, null);
            Drawable newDrawable = this.f1543a.newDrawable(resources);
            ioVar.f = newDrawable;
            newDrawable.setCallback(ioVar.j);
            return ioVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            io ioVar = new io(null, null, null);
            Drawable newDrawable = this.f1543a.newDrawable(resources, theme);
            ioVar.f = newDrawable;
            newDrawable.setCallback(ioVar.j);
            return ioVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
