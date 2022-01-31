package defpackage;

import android.app.Activity;
import android.content.Context;
import app.zophop.sharedflowevents.TrillSoundValidationResponse;
import com.crashlytics.android.answers.SessionEvent;
import defpackage.j50;
import defpackage.ut;
import java.util.Map;
import java.util.Objects;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: k50  reason: default package */
/* compiled from: TrillSoundFeature.kt */
public final class k50 extends cg5 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f2024a;
    public final /* synthetic */ j50 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;

    @y66(c = "app.zophop.features.TrillSoundFeature$init$1$onError$1", f = "TrillSoundFeature.kt", l = {}, m = "invokeSuspend")
    /* renamed from: k50$a */
    /* compiled from: TrillSoundFeature.kt */
    public static final class a extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public /* synthetic */ Object f;
        public final /* synthetic */ j50 g;
        public final /* synthetic */ int h;
        public final /* synthetic */ String i;
        public final /* synthetic */ int j;

        @y66(c = "app.zophop.features.TrillSoundFeature$init$1$onError$1$1", f = "TrillSoundFeature.kt", l = {}, m = "invokeSuspend")
        /* renamed from: k50$a$a  reason: collision with other inner class name */
        /* compiled from: TrillSoundFeature.kt */
        public static final class C0039a extends b76 implements s76<k66<? super s56>, Object> {
            public final /* synthetic */ j50 f;
            public final /* synthetic */ int g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0039a(j50 j50, int i, k66<? super C0039a> k66) {
                super(1, k66);
                this.f = j50;
                this.g = i;
            }

            @Override // defpackage.u66
            public final k66<s56> create(k66<?> k66) {
                return new C0039a(this.f, this.g, k66);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // defpackage.s76
            public Object invoke(k66<? super s56> k66) {
                C0039a aVar = new C0039a(this.f, this.g, k66);
                s56 s56 = s56.f3190a;
                aVar.invokeSuspend(s56);
                return s56;
            }

            @Override // defpackage.u66
            public final Object invokeSuspend(Object obj) {
                p66 p66 = p66.COROUTINE_SUSPENDED;
                hd3.Y2(obj);
                Context context = this.f.c;
                Objects.requireNonNull(context, "null cannot be cast to non-null type app.zophop.features.TrillSoundFeature.SoundValidations");
                ((j50.a) context).a(this.g);
                return s56.f3190a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(j50 j50, int i2, String str, int i3, k66<? super a> k66) {
            super(2, k66);
            this.g = j50;
            this.h = i2;
            this.i = str;
            this.j = i3;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            a aVar = new a(this.g, this.h, this.i, this.j, k66);
            aVar.f = obj;
            return aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            a aVar = new a(this.g, this.h, this.i, this.j, k66);
            aVar.f = mb6;
            s56 s56 = s56.f3190a;
            aVar.invokeSuspend(s56);
            return s56;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            hd3.Y2(obj);
            mb6 mb6 = (mb6) this.f;
            j50 j50 = this.g;
            if (!j50.j) {
                xb6 xb6 = xb6.f3911a;
                ad6 ad6 = xf6.c;
                C0039a aVar = new C0039a(j50, this.h, null);
                n86.e(mb6, "<this>");
                n86.e(ad6, "dispatcher");
                n86.e(aVar, "action");
                hd3.Y1(mb6, hj1.t0(CoroutineExceptionHandler.a.f, ad6), null, new qh1(aVar, null), 2, null);
            }
            ut.a aVar2 = ut.f3552a;
            return s56.f3190a;
        }
    }

    @y66(c = "app.zophop.features.TrillSoundFeature$init$1$onResponseReceived$1", f = "TrillSoundFeature.kt", l = {}, m = "invokeSuspend")
    /* renamed from: k50$b */
    /* compiled from: TrillSoundFeature.kt */
    public static final class b extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public /* synthetic */ Object f;
        public final /* synthetic */ j50 g;
        public final /* synthetic */ int h;

        @y66(c = "app.zophop.features.TrillSoundFeature$init$1$onResponseReceived$1$1", f = "TrillSoundFeature.kt", l = {}, m = "invokeSuspend")
        /* renamed from: k50$b$a */
        /* compiled from: TrillSoundFeature.kt */
        public static final class a extends b76 implements s76<k66<? super s56>, Object> {
            public final /* synthetic */ j50 f;
            public final /* synthetic */ int g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(j50 j50, int i, k66<? super a> k66) {
                super(1, k66);
                this.f = j50;
                this.g = i;
            }

            @Override // defpackage.u66
            public final k66<s56> create(k66<?> k66) {
                return new a(this.f, this.g, k66);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // defpackage.s76
            public Object invoke(k66<? super s56> k66) {
                a aVar = new a(this.f, this.g, k66);
                s56 s56 = s56.f3190a;
                aVar.invokeSuspend(s56);
                return s56;
            }

            @Override // defpackage.u66
            public final Object invokeSuspend(Object obj) {
                p66 p66 = p66.COROUTINE_SUSPENDED;
                hd3.Y2(obj);
                Context context = this.f.c;
                Objects.requireNonNull(context, "null cannot be cast to non-null type app.zophop.features.TrillSoundFeature.SoundValidations");
                ((j50.a) context).d(this.g);
                return s56.f3190a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(j50 j50, int i, k66<? super b> k66) {
            super(2, k66);
            this.g = j50;
            this.h = i;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            b bVar = new b(this.g, this.h, k66);
            bVar.f = obj;
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            b bVar = new b(this.g, this.h, k66);
            bVar.f = mb6;
            s56 s56 = s56.f3190a;
            bVar.invokeSuspend(s56);
            return s56;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            hd3.Y2(obj);
            mb6 mb6 = (mb6) this.f;
            j50 j50 = this.g;
            if (j50.j) {
                jz5.b().i(new TrillSoundValidationResponse(a90.RESPONSE_RECEIVED, this.h));
            } else {
                xb6 xb6 = xb6.f3911a;
                ad6 ad6 = xf6.c;
                a aVar = new a(j50, this.h, null);
                n86.e(mb6, "<this>");
                n86.e(ad6, "dispatcher");
                n86.e(aVar, "action");
                hd3.Y1(mb6, hj1.t0(CoroutineExceptionHandler.a.f, ad6), null, new qh1(aVar, null), 2, null);
            }
            ut.a aVar2 = ut.f3552a;
            return s56.f3190a;
        }
    }

    public k50(Map<String, Object> map, j50 j50, String str, boolean z, int i) {
        this.f2024a = map;
        this.b = j50;
        this.c = str;
        this.d = i;
    }

    @Override // defpackage.cg5
    public void a(int i, String str) {
        n86.e(str, "errMessage");
        this.f2024a.clear();
        this.f2024a.put("code", Integer.valueOf(i));
        this.f2024a.put("errMessage", str);
        this.f2024a.put("bookingId", this.b.d);
        this.f2024a.put(SessionEvent.SESSION_ID_KEY, this.b.e);
        j50.f(this.b, this.f2024a, this.c, false);
        j50.g(this.b, "sound error", this.f2024a);
        Context context = this.b.c;
        if (context instanceof f0) {
            Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            wg.b((f0) context).i(new a(this.b, i, str, this.d, null));
        }
    }

    @Override // defpackage.cg5
    public void b(int i, String str) {
        n86.e(str, "logs");
        this.f2024a.clear();
        this.f2024a.put("code", Integer.valueOf(i));
        this.f2024a.put("logs", str);
        this.f2024a.put("bookingId", this.b.d);
        this.f2024a.put(SessionEvent.SESSION_ID_KEY, this.b.e);
        j50.f(this.b, this.f2024a, this.c, false);
        j50.g(this.b, "sound info received", this.f2024a);
        if (this.b.c instanceof Activity) {
            ut.a aVar = ut.f3552a;
        }
    }

    @Override // defpackage.cg5
    public void c(int i) {
        this.b.g = ui1.Q();
        this.f2024a.clear();
        this.f2024a.put("code", Integer.valueOf(i));
        this.f2024a.put("bookingId", this.b.d);
        this.f2024a.put(SessionEvent.SESSION_ID_KEY, this.b.e);
        Map<String, Object> map = this.f2024a;
        j50 j50 = this.b;
        map.put("total response time", Long.valueOf(j50.g - j50.h));
        this.f2024a.put("t2", Long.valueOf(this.b.g - 0));
        j50.f(this.b, this.f2024a, this.c, false);
        j50.g(this.b, "sound code received", this.f2024a);
        Context context = this.b.c;
        if (context instanceof f0) {
            Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            wg.b((f0) context).i(new b(this.b, i, null));
        }
    }

    @Override // defpackage.cg5
    public void d(int i) {
        this.f2024a.clear();
        this.f2024a.put("status", Integer.valueOf(i));
        this.f2024a.put("bookingId", this.b.d);
        this.f2024a.put(SessionEvent.SESSION_ID_KEY, this.b.e);
        j50.f(this.b, this.f2024a, this.c, false);
        j50.g(this.b, "sound sdk initialized", this.f2024a);
    }

    @Override // defpackage.cg5
    public void e(int i) {
        n86.j("onVerificationCompleted: status = ", Integer.valueOf(i));
    }

    @Override // defpackage.cg5
    public void f(int i) {
        n86.j("onVerificationStarted: status = ", Integer.valueOf(i));
        this.f2024a.clear();
        this.f2024a.put("status", Integer.valueOf(i));
        this.f2024a.put("bookingId", this.b.d);
        this.f2024a.put(SessionEvent.SESSION_ID_KEY, this.b.e);
        j50.f(this.b, this.f2024a, this.c, false);
        j50.g(this.b, "sound verification started", this.f2024a);
        this.b.h = ui1.Q();
        if (this.b.c instanceof Activity) {
            ut.a aVar = ut.f3552a;
        }
    }
}
