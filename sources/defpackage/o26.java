package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.razorpay.AnalyticsConstants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: o26  reason: default package */
/* compiled from: -ViewPumpLayoutInflater.kt */
public final class o26 extends LayoutInflater {
    public static final Set<String> e = y56.t("android.widget.", "android.webkit.");
    public static final j56 f = hd3.a2(a.f);
    public static final b g = new b(null);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2637a;
    public final e26 b;
    public final e26 c;
    public boolean d;

    /* renamed from: o26$a */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static final class a extends o86 implements h76<Field> {
        public static final a f = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public Field invoke() {
            Field declaredField = LayoutInflater.class.getDeclaredField("mConstructorArgs");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return declaredField;
            }
            throw new IllegalArgumentException("No constructor arguments field found in LayoutInflater!".toString());
        }
    }

    /* renamed from: o26$b */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ s96[] f2638a;

        static {
            r86 r86 = new r86(z86.a(b.class), "CONSTRUCTOR_ARGS_FIELD", "getCONSTRUCTOR_ARGS_FIELD()Ljava/lang/reflect/Field;");
            Objects.requireNonNull(z86.f4146a);
            f2638a = new s96[]{r86};
        }

        public b() {
        }

        public static final Field a(b bVar) {
            Objects.requireNonNull(bVar);
            j56 j56 = o26.f;
            b bVar2 = o26.g;
            s96 s96 = f2638a[0];
            return (Field) j56.getValue();
        }

        public b(j86 j86) {
        }
    }

    /* renamed from: o26$c */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static final class c implements e26 {

        /* renamed from: a  reason: collision with root package name */
        public final o26 f2639a;

        public c(o26 o26) {
            n86.f(o26, "inflater");
            this.f2639a = o26;
        }

        @Override // defpackage.e26
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            n86.f(str, "name");
            n86.f(context, AnalyticsConstants.CONTEXT);
            View view2 = null;
            for (String str2 : o26.e) {
                try {
                    view2 = this.f2639a.createView(str, str2, attributeSet);
                    if (view2 != null) {
                        break;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            return view2 == null ? o26.b(this.f2639a, str, attributeSet) : view2;
        }
    }

    /* renamed from: o26$d */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static final class d implements e26 {

        /* renamed from: a  reason: collision with root package name */
        public final o26 f2640a;

        public d(o26 o26) {
            n86.f(o26, "inflater");
            this.f2640a = o26;
        }

        @Override // defpackage.e26
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            n86.f(str, "name");
            n86.f(context, AnalyticsConstants.CONTEXT);
            return o26.a(this.f2640a, view, str, attributeSet);
        }
    }

    /* renamed from: o26$e */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static final class e extends g {
        public final f g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(LayoutInflater.Factory2 factory2, o26 o26) {
            super(factory2);
            n86.f(factory2, "factory2");
            n86.f(o26, "inflater");
            this.g = new f(factory2, o26);
        }

        @Override // defpackage.o26.g
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            n86.f(str, "name");
            n86.f(context, AnalyticsConstants.CONTEXT);
            return i26.g.a().a(new f26(str, context, attributeSet, view, this.g)).f1206a;
        }
    }

    /* renamed from: o26$f */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static final class f extends h implements e26 {
        public final o26 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(LayoutInflater.Factory2 factory2, o26 o26) {
            super(factory2);
            n86.f(factory2, "factory2");
            n86.f(o26, "inflater");
            this.b = o26;
        }

        @Override // defpackage.o26.h, defpackage.e26
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            Field field;
            n86.f(str, "name");
            n86.f(context, AnalyticsConstants.CONTEXT);
            o26 o26 = this.b;
            View onCreateView = this.f2641a.onCreateView(view, str, context, attributeSet);
            Set<String> set = o26.e;
            Objects.requireNonNull(o26);
            if (!i26.g.a().d || onCreateView != null || ea6.m(str, '.', 0, false, 6) <= -1) {
                return onCreateView;
            }
            if (o26.f2637a) {
                return o26.cloneInContext(context).createView(str, null, attributeSet);
            }
            b bVar = o26.g;
            Object obj = b.a(bVar).get(o26);
            if (obj != null) {
                Object[] objArr = (Object[]) obj;
                Object obj2 = objArr[0];
                objArr[0] = context;
                hd3.O2(b.a(bVar), o26, objArr);
                try {
                    onCreateView = o26.createView(str, null, attributeSet);
                    objArr[0] = obj2;
                    field = b.a(bVar);
                } catch (ClassNotFoundException unused) {
                    objArr[0] = obj2;
                    field = b.a(o26.g);
                } catch (Throwable th) {
                    objArr[0] = obj2;
                    hd3.O2(b.a(o26.g), o26, objArr);
                    throw th;
                }
                hd3.O2(field, o26, objArr);
                return onCreateView;
            }
            throw new p56("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
        }
    }

    /* renamed from: o26$g */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static class g implements LayoutInflater.Factory2 {
        public final h f;

        public g(LayoutInflater.Factory2 factory2) {
            n86.f(factory2, "factory2");
            this.f = new h(factory2);
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            n86.f(str, "name");
            n86.f(context, AnalyticsConstants.CONTEXT);
            return onCreateView(null, str, context, attributeSet);
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            n86.f(str, "name");
            n86.f(context, AnalyticsConstants.CONTEXT);
            return i26.g.a().a(new f26(str, context, attributeSet, view, this.f)).f1206a;
        }
    }

    /* renamed from: o26$h */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static class h implements e26 {

        /* renamed from: a  reason: collision with root package name */
        public final LayoutInflater.Factory2 f2641a;

        public h(LayoutInflater.Factory2 factory2) {
            n86.f(factory2, "factory2");
            this.f2641a = factory2;
        }

        @Override // defpackage.e26
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            n86.f(str, "name");
            n86.f(context, AnalyticsConstants.CONTEXT);
            return this.f2641a.onCreateView(view, str, context, attributeSet);
        }
    }

    /* renamed from: o26$i */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static final class i implements LayoutInflater.Factory {
        public final e26 f;

        public i(LayoutInflater.Factory factory) {
            n86.f(factory, "factory");
            this.f = new j(factory);
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            n86.f(str, "name");
            n86.f(context, AnalyticsConstants.CONTEXT);
            return i26.g.a().a(new f26(str, context, attributeSet, null, this.f, 8)).f1206a;
        }
    }

    /* renamed from: o26$j */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static final class j implements e26 {

        /* renamed from: a  reason: collision with root package name */
        public final LayoutInflater.Factory f2642a;

        public j(LayoutInflater.Factory factory) {
            n86.f(factory, "factory");
            this.f2642a = factory;
        }

        @Override // defpackage.e26
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            n86.f(str, "name");
            n86.f(context, AnalyticsConstants.CONTEXT);
            return this.f2642a.onCreateView(str, context, attributeSet);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 >= 29) != false) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public o26(android.view.LayoutInflater r3, android.content.Context r4, boolean r5) {
        /*
            r2 = this;
            java.lang.String r0 = "original"
            defpackage.n86.f(r3, r0)
            java.lang.String r0 = "newContext"
            defpackage.n86.f(r4, r0)
            r2.<init>(r3, r4)
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 0
            r0 = 1
            r1 = 28
            if (r3 > r1) goto L_0x001e
            r1 = 29
            if (r3 < r1) goto L_0x001b
            r3 = 1
            goto L_0x001c
        L_0x001b:
            r3 = 0
        L_0x001c:
            if (r3 == 0) goto L_0x001f
        L_0x001e:
            r4 = 1
        L_0x001f:
            r2.f2637a = r4
            o26$c r3 = new o26$c
            r3.<init>(r2)
            r2.b = r3
            o26$d r3 = new o26$d
            r3.<init>(r2)
            r2.c = r3
            i26$b r3 = defpackage.i26.g
            r3.a()
            if (r5 == 0) goto L_0x0037
            goto L_0x0061
        L_0x0037:
            android.view.LayoutInflater$Factory2 r3 = r2.getFactory2()
            if (r3 == 0) goto L_0x004c
            android.view.LayoutInflater$Factory2 r3 = r2.getFactory2()
            boolean r3 = r3 instanceof defpackage.o26.g
            if (r3 != 0) goto L_0x004c
            android.view.LayoutInflater$Factory2 r3 = r2.getFactory2()
            r2.setFactory2(r3)
        L_0x004c:
            android.view.LayoutInflater$Factory r3 = r2.getFactory()
            if (r3 == 0) goto L_0x0061
            android.view.LayoutInflater$Factory r3 = r2.getFactory()
            boolean r3 = r3 instanceof defpackage.o26.i
            if (r3 != 0) goto L_0x0061
            android.view.LayoutInflater$Factory r3 = r2.getFactory()
            r2.setFactory(r3)
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o26.<init>(android.view.LayoutInflater, android.content.Context, boolean):void");
    }

    public static final View a(o26 o26, View view, String str, AttributeSet attributeSet) {
        Objects.requireNonNull(o26);
        try {
            return super.onCreateView(view, str, attributeSet);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static final View b(o26 o26, String str, AttributeSet attributeSet) {
        Objects.requireNonNull(o26);
        try {
            return super.onCreateView(str, attributeSet);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public LayoutInflater cloneInContext(Context context) {
        n86.f(context, "newContext");
        return new o26(this, context, true);
    }

    @Override // android.view.LayoutInflater
    public View inflate(int i2, ViewGroup viewGroup, boolean z) {
        return super.inflate(i2, viewGroup, z);
    }

    @Override // android.view.LayoutInflater
    public View onCreateView(View view, String str, AttributeSet attributeSet) throws ClassNotFoundException {
        n86.f(str, "name");
        i26 a2 = i26.g.a();
        Context context = getContext();
        n86.b(context, AnalyticsConstants.CONTEXT);
        return a2.a(new f26(str, context, attributeSet, view, this.c)).f1206a;
    }

    public void setFactory(LayoutInflater.Factory factory) {
        n86.f(factory, "factory");
        if (!(factory instanceof i)) {
            super.setFactory(new i(factory));
        } else {
            super.setFactory(factory);
        }
    }

    public void setFactory2(LayoutInflater.Factory2 factory2) {
        n86.f(factory2, "factory2");
        if (!(factory2 instanceof g)) {
            super.setFactory2(new g(factory2));
        } else {
            super.setFactory2(factory2);
        }
    }

    @Override // android.view.LayoutInflater
    public View inflate(XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z) {
        Method method;
        n86.f(xmlPullParser, "parser");
        if (!this.d && i26.g.a().c) {
            if (!(getContext() instanceof LayoutInflater.Factory2)) {
                this.d = true;
            } else {
                n86.f(LayoutInflater.class, "receiver$0");
                n86.f("setPrivateFactory", "methodName");
                Method[] methods = LayoutInflater.class.getMethods();
                int length = methods.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        method = null;
                        break;
                    }
                    method = methods[i2];
                    n86.b(method, "method");
                    if (n86.a(method.getName(), "setPrivateFactory")) {
                        method.setAccessible(true);
                        break;
                    }
                    i2++;
                }
                Object[] objArr = new Object[1];
                Context context = getContext();
                if (context != null) {
                    objArr[0] = new e((LayoutInflater.Factory2) context, this);
                    n86.f(this, "target");
                    n86.f(objArr, "args");
                    if (method != null) {
                        try {
                            method.invoke(this, Arrays.copyOf(objArr, 1));
                        } catch (IllegalAccessException | InvocationTargetException unused) {
                        }
                    }
                    this.d = true;
                } else {
                    throw new p56("null cannot be cast to non-null type android.view.LayoutInflater.Factory2");
                }
            }
        }
        View inflate = super.inflate(xmlPullParser, viewGroup, z);
        n86.b(inflate, "super.inflate(parser, root, attachToRoot)");
        return inflate;
    }

    @Override // android.view.LayoutInflater
    public View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        n86.f(str, "name");
        i26 a2 = i26.g.a();
        Context context = getContext();
        n86.b(context, AnalyticsConstants.CONTEXT);
        return a2.a(new f26(str, context, attributeSet, null, this.b, 8)).f1206a;
    }
}
