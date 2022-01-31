package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: en  reason: default package */
/* compiled from: ChangeBounds */
public class en extends kn {
    public static final String[] D = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final Property<Drawable, PointF> E = new a(PointF.class, "boundsOrigin");
    public static final Property<i, PointF> F = new b(PointF.class, "topLeft");
    public static final Property<i, PointF> G = new c(PointF.class, "bottomRight");
    public static final Property<View, PointF> H = new d(PointF.class, "bottomRight");
    public static final Property<View, PointF> I = new e(PointF.class, "topLeft");
    public static final Property<View, PointF> J = new f(PointF.class, "position");
    public static in K = new in();
    public int[] C = new int[2];

    /* renamed from: en$a */
    /* compiled from: ChangeBounds */
    public static class a extends Property<Drawable, PointF> {

        /* renamed from: a  reason: collision with root package name */
        public Rect f997a = new Rect();

        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f997a);
            Rect rect = this.f997a;
            return new PointF((float) rect.left, (float) rect.top);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(Drawable drawable, PointF pointF) {
            Drawable drawable2 = drawable;
            PointF pointF2 = pointF;
            drawable2.copyBounds(this.f997a);
            this.f997a.offsetTo(Math.round(pointF2.x), Math.round(pointF2.y));
            drawable2.setBounds(this.f997a);
        }
    }

    /* renamed from: en$b */
    /* compiled from: ChangeBounds */
    public static class b extends Property<i, PointF> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(i iVar) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(i iVar, PointF pointF) {
            i iVar2 = iVar;
            PointF pointF2 = pointF;
            Objects.requireNonNull(iVar2);
            iVar2.f1000a = Math.round(pointF2.x);
            int round = Math.round(pointF2.y);
            iVar2.b = round;
            int i = iVar2.f + 1;
            iVar2.f = i;
            if (i == iVar2.g) {
                wn.b(iVar2.e, iVar2.f1000a, round, iVar2.c, iVar2.d);
                iVar2.f = 0;
                iVar2.g = 0;
            }
        }
    }

    /* renamed from: en$c */
    /* compiled from: ChangeBounds */
    public static class c extends Property<i, PointF> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(i iVar) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(i iVar, PointF pointF) {
            i iVar2 = iVar;
            PointF pointF2 = pointF;
            Objects.requireNonNull(iVar2);
            iVar2.c = Math.round(pointF2.x);
            int round = Math.round(pointF2.y);
            iVar2.d = round;
            int i = iVar2.g + 1;
            iVar2.g = i;
            if (iVar2.f == i) {
                wn.b(iVar2.e, iVar2.f1000a, iVar2.b, iVar2.c, round);
                iVar2.f = 0;
                iVar2.g = 0;
            }
        }
    }

    /* renamed from: en$d */
    /* compiled from: ChangeBounds */
    public static class d extends Property<View, PointF> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            wn.b(view2, view2.getLeft(), view2.getTop(), Math.round(pointF2.x), Math.round(pointF2.y));
        }
    }

    /* renamed from: en$e */
    /* compiled from: ChangeBounds */
    public static class e extends Property<View, PointF> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            wn.b(view2, Math.round(pointF2.x), Math.round(pointF2.y), view2.getRight(), view2.getBottom());
        }
    }

    /* renamed from: en$f */
    /* compiled from: ChangeBounds */
    public static class f extends Property<View, PointF> {
        public f(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int round = Math.round(pointF2.x);
            int round2 = Math.round(pointF2.y);
            wn.b(view2, round, round2, view2.getWidth() + round, view2.getHeight() + round2);
        }
    }

    /* renamed from: en$g */
    /* compiled from: ChangeBounds */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f998a;
        private i mViewBounds;

        public g(en enVar, i iVar) {
            this.f998a = iVar;
            this.mViewBounds = iVar;
        }
    }

    /* renamed from: en$h */
    /* compiled from: ChangeBounds */
    public class h extends nn {

        /* renamed from: a  reason: collision with root package name */
        public boolean f999a = false;
        public final /* synthetic */ ViewGroup b;

        public h(en enVar, ViewGroup viewGroup) {
            this.b = viewGroup;
        }

        @Override // defpackage.nn, defpackage.kn.d
        public void b(kn knVar) {
            un.a(this.b, false);
        }

        @Override // defpackage.kn.d
        public void c(kn knVar) {
            if (!this.f999a) {
                un.a(this.b, false);
            }
            knVar.w(this);
        }

        @Override // defpackage.nn, defpackage.kn.d
        public void d(kn knVar) {
            un.a(this.b, false);
            this.f999a = true;
        }

        @Override // defpackage.nn, defpackage.kn.d
        public void e(kn knVar) {
            un.a(this.b, true);
        }
    }

    /* renamed from: en$i */
    /* compiled from: ChangeBounds */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public int f1000a;
        public int b;
        public int c;
        public int d;
        public View e;
        public int f;
        public int g;

        public i(View view) {
            this.e = view;
        }
    }

    public final void I(sn snVar) {
        View view = snVar.b;
        AtomicInteger atomicInteger = r8.f3055a;
        if (view.isLaidOut() || view.getWidth() != 0 || view.getHeight() != 0) {
            snVar.f3229a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            snVar.f3229a.put("android:changeBounds:parent", snVar.b.getParent());
        }
    }

    @Override // defpackage.kn
    public void d(sn snVar) {
        I(snVar);
    }

    @Override // defpackage.kn
    public void g(sn snVar) {
        I(snVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v9, resolved type: android.animation.AnimatorSet */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.kn
    public Animator k(ViewGroup viewGroup, sn snVar, sn snVar2) {
        int i2;
        ObjectAnimator objectAnimator;
        en enVar;
        if (snVar == null || snVar2 == null) {
            return null;
        }
        Map<String, Object> map = snVar.f3229a;
        Map<String, Object> map2 = snVar2.f3229a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view = snVar2.b;
        Rect rect = (Rect) snVar.f3229a.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) snVar2.f3229a.get("android:changeBounds:bounds");
        int i3 = rect.left;
        int i4 = rect2.left;
        int i5 = rect.top;
        int i6 = rect2.top;
        int i7 = rect.right;
        int i8 = rect2.right;
        int i9 = rect.bottom;
        int i10 = rect2.bottom;
        int i11 = i7 - i3;
        int i12 = i9 - i5;
        int i13 = i8 - i4;
        int i14 = i10 - i6;
        Rect rect3 = (Rect) snVar.f3229a.get("android:changeBounds:clip");
        Rect rect4 = (Rect) snVar2.f3229a.get("android:changeBounds:clip");
        if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
            i2 = 0;
        } else {
            i2 = (i3 == i4 && i5 == i6) ? 0 : 1;
            if (!(i7 == i8 && i9 == i10)) {
                i2++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i2++;
        }
        if (i2 <= 0) {
            return null;
        }
        wn.b(view, i3, i5, i7, i9);
        if (i2 != 2) {
            enVar = this;
            if (i3 == i4 && i5 == i6) {
                objectAnimator = h.l0(view, H, enVar.y.a((float) i7, (float) i9, (float) i8, (float) i10));
            } else {
                objectAnimator = h.l0(view, I, enVar.y.a((float) i3, (float) i5, (float) i4, (float) i6));
            }
        } else if (i11 == i13 && i12 == i14) {
            enVar = this;
            objectAnimator = h.l0(view, J, enVar.y.a((float) i3, (float) i5, (float) i4, (float) i6));
        } else {
            enVar = this;
            i iVar = new i(view);
            ObjectAnimator l0 = h.l0(iVar, F, enVar.y.a((float) i3, (float) i5, (float) i4, (float) i6));
            ObjectAnimator l02 = h.l0(iVar, G, enVar.y.a((float) i7, (float) i9, (float) i8, (float) i10));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(l0, l02);
            animatorSet.addListener(new g(enVar, iVar));
            objectAnimator = animatorSet;
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            un.a(viewGroup4, true);
            enVar.a(new h(enVar, viewGroup4));
        }
        return objectAnimator;
    }

    @Override // defpackage.kn
    public String[] q() {
        return D;
    }
}
