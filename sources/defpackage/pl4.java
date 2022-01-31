package defpackage;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* renamed from: pl4  reason: default package */
/* compiled from: CircularRevealWidget */
public interface pl4 {

    /* renamed from: pl4$b */
    /* compiled from: CircularRevealWidget */
    public static class b implements TypeEvaluator<e> {
        public static final TypeEvaluator<e> b = new b();

        /* renamed from: a  reason: collision with root package name */
        public final e f2823a = new e(null);

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
        @Override // android.animation.TypeEvaluator
        public e evaluate(float f, e eVar, e eVar2) {
            e eVar3 = eVar;
            e eVar4 = eVar2;
            e eVar5 = this.f2823a;
            float b2 = hd3.b2(eVar3.f2826a, eVar4.f2826a, f);
            float b22 = hd3.b2(eVar3.b, eVar4.b, f);
            float b23 = hd3.b2(eVar3.c, eVar4.c, f);
            eVar5.f2826a = b2;
            eVar5.b = b22;
            eVar5.c = b23;
            return this.f2823a;
        }
    }

    /* renamed from: pl4$c */
    /* compiled from: CircularRevealWidget */
    public static class c extends Property<pl4, e> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<pl4, e> f2824a = new c("circularReveal");

        public c(String str) {
            super(e.class, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public e get(pl4 pl4) {
            return pl4.getRevealInfo();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(pl4 pl4, e eVar) {
            pl4.setRevealInfo(eVar);
        }
    }

    /* renamed from: pl4$d */
    /* compiled from: CircularRevealWidget */
    public static class d extends Property<pl4, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<pl4, Integer> f2825a = new d("circularRevealScrimColor");

        public d(String str) {
            super(Integer.class, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Integer get(pl4 pl4) {
            return Integer.valueOf(pl4.getCircularRevealScrimColor());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(pl4 pl4, Integer num) {
            pl4.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* renamed from: pl4$e */
    /* compiled from: CircularRevealWidget */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public float f2826a;
        public float b;
        public float c;

        public e() {
        }

        public e(a aVar) {
        }

        public e(float f, float f2, float f3) {
            this.f2826a = f;
            this.b = f2;
            this.c = f3;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(e eVar);
}
