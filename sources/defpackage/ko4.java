package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R;
import java.util.Objects;

/* renamed from: ko4  reason: default package */
/* compiled from: ShapeAppearanceModel */
public class ko4 {

    /* renamed from: a  reason: collision with root package name */
    public eo4 f2092a;
    public eo4 b;
    public eo4 c;
    public eo4 d;
    public do4 e;
    public do4 f;
    public do4 g;
    public do4 h;
    public go4 i;
    public go4 j;
    public go4 k;
    public go4 l;

    public ko4(b bVar, a aVar) {
        this.f2092a = bVar.f2093a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
    }

    public static b a(Context context, int i2, int i3, do4 do4) {
        if (i3 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i2);
            i2 = i3;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.ShapeAppearance);
        try {
            int i4 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
            int i5 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, i4);
            int i6 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, i4);
            int i7 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, i4);
            int i8 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i4);
            do4 c2 = c(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSize, do4);
            do4 c3 = c(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopLeft, c2);
            do4 c4 = c(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopRight, c2);
            do4 c5 = c(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomRight, c2);
            do4 c6 = c(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomLeft, c2);
            b bVar = new b();
            eo4 W = hd3.W(i5);
            bVar.f2093a = W;
            b.b(W);
            bVar.e = c3;
            eo4 W2 = hd3.W(i6);
            bVar.b = W2;
            b.b(W2);
            bVar.f = c4;
            eo4 W3 = hd3.W(i7);
            bVar.c = W3;
            b.b(W3);
            bVar.g = c5;
            eo4 W4 = hd3.W(i8);
            bVar.d = W4;
            b.b(W4);
            bVar.h = c6;
            return bVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static b b(Context context, AttributeSet attributeSet, int i2, int i3) {
        bo4 bo4 = new bo4((float) 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, bo4);
    }

    public static do4 c(TypedArray typedArray, int i2, do4 do4) {
        TypedValue peekValue = typedArray.peekValue(i2);
        if (peekValue == null) {
            return do4;
        }
        int i3 = peekValue.type;
        if (i3 == 5) {
            return new bo4((float) TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i3 == 6 ? new io4(peekValue.getFraction(1.0f, 1.0f)) : do4;
    }

    public boolean d(RectF rectF) {
        boolean z = this.l.getClass().equals(go4.class) && this.j.getClass().equals(go4.class) && this.i.getClass().equals(go4.class) && this.k.getClass().equals(go4.class);
        float a2 = this.e.a(rectF);
        boolean z2 = this.f.a(rectF) == a2 && this.h.a(rectF) == a2 && this.g.a(rectF) == a2;
        boolean z3 = (this.b instanceof jo4) && (this.f2092a instanceof jo4) && (this.c instanceof jo4) && (this.d instanceof jo4);
        if (!z || !z2 || !z3) {
            return false;
        }
        return true;
    }

    public ko4 e(float f2) {
        b bVar = new b(this);
        bVar.c(f2);
        return bVar.a();
    }

    /* renamed from: ko4$b */
    /* compiled from: ShapeAppearanceModel */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public eo4 f2093a = new jo4();
        public eo4 b = new jo4();
        public eo4 c = new jo4();
        public eo4 d = new jo4();
        public do4 e = new bo4(0.0f);
        public do4 f = new bo4(0.0f);
        public do4 g = new bo4(0.0f);
        public do4 h = new bo4(0.0f);
        public go4 i = new go4();
        public go4 j = new go4();
        public go4 k = new go4();
        public go4 l = new go4();

        public b() {
        }

        public static float b(eo4 eo4) {
            if (eo4 instanceof jo4) {
                Objects.requireNonNull((jo4) eo4);
                return -1.0f;
            }
            if (eo4 instanceof fo4) {
                Objects.requireNonNull((fo4) eo4);
            }
            return -1.0f;
        }

        public ko4 a() {
            return new ko4(this, null);
        }

        public b c(float f2) {
            this.e = new bo4(f2);
            this.f = new bo4(f2);
            this.g = new bo4(f2);
            this.h = new bo4(f2);
            return this;
        }

        public b d(float f2) {
            this.h = new bo4(f2);
            return this;
        }

        public b e(float f2) {
            this.g = new bo4(f2);
            return this;
        }

        public b f(float f2) {
            this.e = new bo4(f2);
            return this;
        }

        public b g(float f2) {
            this.f = new bo4(f2);
            return this;
        }

        public b(ko4 ko4) {
            this.f2093a = ko4.f2092a;
            this.b = ko4.b;
            this.c = ko4.c;
            this.d = ko4.d;
            this.e = ko4.e;
            this.f = ko4.f;
            this.g = ko4.g;
            this.h = ko4.h;
            this.i = ko4.i;
            this.j = ko4.j;
            this.k = ko4.k;
            this.l = ko4.l;
        }
    }

    public ko4() {
        this.f2092a = new jo4();
        this.b = new jo4();
        this.c = new jo4();
        this.d = new jo4();
        this.e = new bo4(0.0f);
        this.f = new bo4(0.0f);
        this.g = new bo4(0.0f);
        this.h = new bo4(0.0f);
        this.i = new go4();
        this.j = new go4();
        this.k = new go4();
        this.l = new go4();
    }
}
