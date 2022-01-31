package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;
import com.rabbitmq.client.AMQP;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;

/* renamed from: ua  reason: default package */
/* compiled from: SingleProcessDataStore.kt */
public final class ua<T> implements oa<T> {
    public static final ua j = null;
    public static final Set<String> k = new LinkedHashSet();
    public static final Object l = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final h76<File> f3478a;
    public final sa<T> b;
    public final ha<T> c;
    public final mb6 d;
    public final String e = ".tmp";
    public final j56 f = hd3.a2(new g(this));
    public final ve6<xa<T>> g = new xe6(ya.f4024a);
    public List<? extends w76<? super qa<T>, ? super k66<? super s56>, ? extends Object>> h;
    public final ta<a<T>> i;

    /* renamed from: ua$a */
    /* compiled from: SingleProcessDataStore.kt */
    public static abstract class a<T> {

        /* renamed from: ua$a$a  reason: collision with other inner class name */
        /* compiled from: SingleProcessDataStore.kt */
        public static final class C0057a<T> extends a<T> {

            /* renamed from: a  reason: collision with root package name */
            public final xa<T> f3479a;

            public C0057a(xa<T> xaVar) {
                super(null);
                this.f3479a = xaVar;
            }
        }

        /* renamed from: ua$a$b */
        /* compiled from: SingleProcessDataStore.kt */
        public static final class b<T> extends a<T> {

            /* renamed from: a  reason: collision with root package name */
            public final w76<T, k66<? super T>, Object> f3480a;
            public final ab6<T> b;
            public final xa<T> c;
            public final m66 d;

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: w76<? super T, ? super k66<? super T>, ? extends java.lang.Object> */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(w76<? super T, ? super k66<? super T>, ? extends Object> w76, ab6<T> ab6, xa<T> xaVar, m66 m66) {
                super(null);
                n86.e(w76, "transform");
                n86.e(ab6, "ack");
                n86.e(m66, "callerContext");
                this.f3480a = w76;
                this.b = ab6;
                this.c = xaVar;
                this.d = m66;
            }
        }

        public a() {
        }

        public a(j86 j86) {
        }
    }

    /* renamed from: ua$b */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class b extends OutputStream {
        public final FileOutputStream f;

        public b(FileOutputStream fileOutputStream) {
            n86.e(fileOutputStream, "fileOutputStream");
            this.f = fileOutputStream;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            this.f.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            this.f.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            n86.e(bArr, "b");
            this.f.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            n86.e(bArr, "bytes");
            this.f.write(bArr, i, i2);
        }
    }

    /* renamed from: ua$c */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class c extends o86 implements s76<Throwable, s56> {
        public final /* synthetic */ ua<T> f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ua<T> uaVar) {
            super(1);
            this.f = uaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.s76
        public s56 invoke(Throwable th) {
            Throwable th2 = th;
            if (th2 != null) {
                this.f.g.setValue(new pa(th2));
            }
            ua uaVar = ua.j;
            Object obj = ua.l;
            ua<T> uaVar2 = this.f;
            synchronized (obj) {
                ua.k.remove(uaVar2.c().getAbsolutePath());
            }
            return s56.f3190a;
        }
    }

    /* renamed from: ua$d */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class d extends o86 implements w76<a<T>, Throwable, s56> {
        public static final d f = new d();

        public d() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public s56 invoke(Object obj, Throwable th) {
            a aVar = (a) obj;
            Throwable th2 = th;
            n86.e(aVar, "msg");
            if (aVar instanceof a.b) {
                ab6<T> ab6 = ((a.b) aVar).b;
                if (th2 == null) {
                    th2 = new CancellationException("DataStore scope was cancelled before updateData could complete");
                }
                ab6.q(th2);
            }
            return s56.f3190a;
        }
    }

    @y66(c = "androidx.datastore.core.SingleProcessDataStore$actor$3", f = "SingleProcessDataStore.kt", l = {239, 242}, m = "invokeSuspend")
    /* renamed from: ua$e */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class e extends b76 implements w76<a<T>, k66<? super s56>, Object> {
        public int f;
        public /* synthetic */ Object g;
        public final /* synthetic */ ua<T> h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ua<T> uaVar, k66<? super e> k66) {
            super(2, k66);
            this.h = uaVar;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            e eVar = new e(this.h, k66);
            eVar.g = obj;
            return eVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(Object obj, k66<? super s56> k66) {
            e eVar = new e(this.h, k66);
            eVar.g = (a) obj;
            return eVar.invokeSuspend(s56.f3190a);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
            if (r6 == r1) goto L_0x005c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
            if (r6 == r1) goto L_0x005c;
         */
        @Override // defpackage.u66
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
            // Method dump skipped, instructions count: 125
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ua.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @y66(c = "androidx.datastore.core.SingleProcessDataStore$data$1", f = "SingleProcessDataStore.kt", l = {117}, m = "invokeSuspend")
    /* renamed from: ua$f */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class f extends b76 implements w76<re6<? super T>, k66<? super s56>, Object> {
        public int f;
        public /* synthetic */ Object g;
        public final /* synthetic */ ua<T> h;

        @y66(c = "androidx.datastore.core.SingleProcessDataStore$data$1$1", f = "SingleProcessDataStore.kt", l = {}, m = "invokeSuspend")
        /* renamed from: ua$f$a */
        /* compiled from: SingleProcessDataStore.kt */
        public static final class a extends b76 implements w76<xa<T>, k66<? super Boolean>, Object> {
            public /* synthetic */ Object f;
            public final /* synthetic */ xa<T> g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(xa<T> xaVar, k66<? super a> k66) {
                super(2, k66);
                this.g = xaVar;
            }

            @Override // defpackage.u66
            public final k66<s56> create(Object obj, k66<?> k66) {
                a aVar = new a(this.g, k66);
                aVar.f = obj;
                return aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // defpackage.w76
            public Object invoke(Object obj, k66<? super Boolean> k66) {
                a aVar = new a(this.g, k66);
                aVar.f = (xa) obj;
                return aVar.invokeSuspend(s56.f3190a);
            }

            @Override // defpackage.u66
            public final Object invokeSuspend(Object obj) {
                p66 p66 = p66.COROUTINE_SUSPENDED;
                hd3.Y2(obj);
                xa<T> xaVar = (xa) this.f;
                xa<T> xaVar2 = this.g;
                boolean z = false;
                if (!(xaVar2 instanceof ia) && !(xaVar2 instanceof pa) && xaVar == xaVar2) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ua<T> uaVar, k66<? super f> k66) {
            super(2, k66);
            this.h = uaVar;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            f fVar = new f(this.h, k66);
            fVar.g = obj;
            return fVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(Object obj, k66<? super s56> k66) {
            f fVar = new f(this.h, k66);
            fVar.g = (re6) obj;
            return fVar.invokeSuspend(s56.f3190a);
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x005f */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0063 */
        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            Object obj2 = s56.f3190a;
            Object obj3 = p66.COROUTINE_SUSPENDED;
            int i = this.f;
            if (i == 0) {
                hd3.Y2(obj);
                re6 re6 = (re6) this.g;
                xa<T> value = this.h.g.getValue();
                if (!(value instanceof ia)) {
                    this.h.i.a(new a.C0057a(value));
                }
                ve6<xa<T>> ve6 = this.h.g;
                a aVar = new a(value, null);
                this.f = 1;
                if (!(re6 instanceof bf6)) {
                    Object b = ve6.b(new te6(new v86(), new va(re6), aVar), this);
                    Object obj4 = b;
                    if (b != obj3) {
                        obj4 = obj2;
                    }
                    if (obj4 != obj3) {
                        obj4 = obj2;
                    }
                    if (obj4 != obj3) {
                        obj4 = obj2;
                    }
                    if (obj4 == obj3) {
                        return obj3;
                    }
                } else {
                    Objects.requireNonNull((bf6) re6);
                    throw null;
                }
            } else if (i == 1) {
                hd3.Y2(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj2;
        }
    }

    /* renamed from: ua$g */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class g extends o86 implements h76<File> {
        public final /* synthetic */ ua<T> f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ua<T> uaVar) {
            super(0);
            this.f = uaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public File invoke() {
            File invoke = this.f.f3478a.invoke();
            String absolutePath = invoke.getAbsolutePath();
            ua uaVar = ua.j;
            synchronized (ua.l) {
                Set<String> set = ua.k;
                if (!set.contains(absolutePath)) {
                    n86.d(absolutePath, "it");
                    set.add(absolutePath);
                } else {
                    throw new IllegalStateException(("There are multiple DataStores active for the same file: " + invoke + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                }
            }
            return invoke;
        }
    }

    @y66(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {322, 348, AMQP.UNEXPECTED_FRAME}, m = "readAndInit")
    /* renamed from: ua$h */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class h extends w66 {
        public Object f;
        public Object g;
        public Object h;
        public Object i;
        public Object j;
        public Object k;
        public /* synthetic */ Object l;
        public final /* synthetic */ ua<T> m;
        public int n;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(ua<T> uaVar, k66<? super h> k66) {
            super(k66);
            this.m = uaVar;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            this.l = obj;
            this.n |= RtlSpacingHelper.UNDEFINED;
            ua<T> uaVar = this.m;
            ua uaVar2 = ua.j;
            return uaVar.d(this);
        }
    }

    /* renamed from: ua$i */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class i implements qa<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ yg6 f3481a;
        public final /* synthetic */ v86 b;
        public final /* synthetic */ y86<T> c;
        public final /* synthetic */ ua<T> d;

        @y66(c = "androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1", f = "SingleProcessDataStore.kt", l = {AMQP.COMMAND_INVALID, 337, 339}, m = "updateData")
        /* renamed from: ua$i$a */
        /* compiled from: SingleProcessDataStore.kt */
        public static final class a extends w66 {
            public Object f;
            public Object g;
            public Object h;
            public Object i;
            public Object j;
            public /* synthetic */ Object k;
            public final /* synthetic */ i l;
            public int m;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(i iVar, k66<? super a> k66) {
                super(k66);
                this.l = iVar;
            }

            @Override // defpackage.u66
            public final Object invokeSuspend(Object obj) {
                this.k = obj;
                this.m |= RtlSpacingHelper.UNDEFINED;
                return this.l.a(null, this);
            }
        }

        public i(yg6 yg6, v86 v86, y86<T> y86, ua<T> uaVar) {
            this.f3481a = yg6;
            this.b = v86;
            this.c = y86;
            this.d = uaVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0097 A[Catch:{ all -> 0x00e0 }] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00b7  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00cd  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00d8  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        @Override // defpackage.qa
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object a(defpackage.w76<? super T, ? super defpackage.k66<? super T>, ? extends java.lang.Object> r11, defpackage.k66<? super T> r12) {
            /*
            // Method dump skipped, instructions count: 229
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ua.i.a(w76, k66):java.lang.Object");
        }
    }

    @y66(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {302}, m = "readAndInitOrPropagateAndThrowFailure")
    /* renamed from: ua$j */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class j extends w66 {
        public Object f;
        public /* synthetic */ Object g;
        public final /* synthetic */ ua<T> h;
        public int i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(ua<T> uaVar, k66<? super j> k66) {
            super(k66);
            this.h = uaVar;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= RtlSpacingHelper.UNDEFINED;
            ua<T> uaVar = this.h;
            ua uaVar2 = ua.j;
            return uaVar.e(this);
        }
    }

    @y66(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {AMQP.CONTENT_TOO_LARGE}, m = "readAndInitOrPropagateFailure")
    /* renamed from: ua$k */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class k extends w66 {
        public Object f;
        public /* synthetic */ Object g;
        public final /* synthetic */ ua<T> h;
        public int i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(ua<T> uaVar, k66<? super k> k66) {
            super(k66);
            this.h = uaVar;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= RtlSpacingHelper.UNDEFINED;
            ua<T> uaVar = this.h;
            ua uaVar2 = ua.j;
            return uaVar.f(this);
        }
    }

    @y66(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {381}, m = "readData")
    /* renamed from: ua$l */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class l extends w66 {
        public Object f;
        public Object g;
        public /* synthetic */ Object h;
        public final /* synthetic */ ua<T> i;
        public int j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(ua<T> uaVar, k66<? super l> k66) {
            super(k66);
            this.i = uaVar;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= RtlSpacingHelper.UNDEFINED;
            ua<T> uaVar = this.i;
            ua uaVar2 = ua.j;
            return uaVar.g(this);
        }
    }

    @y66(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {359, 362, 365}, m = "readDataOrHandleCorruption")
    /* renamed from: ua$m */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class m extends w66 {
        public Object f;
        public Object g;
        public /* synthetic */ Object h;
        public final /* synthetic */ ua<T> i;
        public int j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(ua<T> uaVar, k66<? super m> k66) {
            super(k66);
            this.i = uaVar;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= RtlSpacingHelper.UNDEFINED;
            ua<T> uaVar = this.i;
            ua uaVar2 = ua.j;
            return uaVar.h(this);
        }
    }

    @y66(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {AMQP.INVALID_PATH, 410}, m = "transformAndWrite")
    /* renamed from: ua$n */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class n extends w66 {
        public Object f;
        public Object g;
        public Object h;
        public /* synthetic */ Object i;
        public final /* synthetic */ ua<T> j;
        public int k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(ua<T> uaVar, k66<? super n> k66) {
            super(k66);
            this.j = uaVar;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.k |= RtlSpacingHelper.UNDEFINED;
            ua<T> uaVar = this.j;
            ua uaVar2 = ua.j;
            return uaVar.i(null, null, this);
        }
    }

    @y66(c = "androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1", f = "SingleProcessDataStore.kt", l = {AMQP.INVALID_PATH}, m = "invokeSuspend")
    /* renamed from: ua$o */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class o extends b76 implements w76<mb6, k66<? super T>, Object> {
        public int f;
        public final /* synthetic */ w76<T, k66<? super T>, Object> g;
        public final /* synthetic */ T h;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: w76<? super T, ? super k66<? super T>, ? extends java.lang.Object> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(w76<? super T, ? super k66<? super T>, ? extends Object> w76, T t, k66<? super o> k66) {
            super(2, k66);
            this.g = w76;
            this.h = t;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new o(this.g, this.h, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, Object obj) {
            return new o(this.g, this.h, (k66) obj).invokeSuspend(s56.f3190a);
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i = this.f;
            if (i == 0) {
                hd3.Y2(obj);
                w76<T, k66<? super T>, Object> w76 = this.g;
                T t = this.h;
                this.f = 1;
                obj = w76.invoke(t, this);
                if (obj == p66) {
                    return p66;
                }
            } else if (i == 1) {
                hd3.Y2(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    @y66(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {426}, m = "writeData$datastore_core")
    /* renamed from: ua$p */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class p extends w66 {
        public Object f;
        public Object g;
        public Object h;
        public Object i;
        public /* synthetic */ Object j;
        public final /* synthetic */ ua<T> k;
        public int l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(ua<T> uaVar, k66<? super p> k66) {
            super(k66);
            this.k = uaVar;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            this.j = obj;
            this.l |= RtlSpacingHelper.UNDEFINED;
            return this.k.j(null, this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: h76<? extends java.io.File> */
    /* JADX WARN: Multi-variable type inference failed */
    public ua(h76<? extends File> h76, sa<T> saVar, List<? extends w76<? super qa<T>, ? super k66<? super s56>, ? extends Object>> list, ha<T> haVar, mb6 mb6) {
        n86.e(h76, "produceFile");
        n86.e(saVar, "serializer");
        n86.e(list, "initTasksList");
        n86.e(haVar, "corruptionHandler");
        n86.e(mb6, "scope");
        this.f3478a = h76;
        this.b = saVar;
        this.c = haVar;
        this.d = mb6;
        new f(this, null);
        this.h = y56.y(list);
        this.i = new ta<>(mb6, new c(this), d.f, new e(this, null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(defpackage.ua r8, defpackage.ua.a.b r9, defpackage.k66 r10) {
        /*
        // Method dump skipped, instructions count: 215
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ua.b(ua, ua$a$b, k66):java.lang.Object");
    }

    @Override // defpackage.oa
    public Object a(w76<? super T, ? super k66<? super T>, ? extends Object> w76, k66<? super T> k66) {
        bb6 bb6 = new bb6(null);
        this.i.a(new a.b(w76, bb6, this.g.getValue(), k66.getContext()));
        return bb6.v(k66);
    }

    public final File c() {
        return (File) this.f.getValue();
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0109 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(defpackage.k66<? super defpackage.s56> r14) {
        /*
        // Method dump skipped, instructions count: 312
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ua.d(k66):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(defpackage.k66<? super defpackage.s56> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof defpackage.ua.j
            if (r0 == 0) goto L_0x0013
            r0 = r5
            ua$j r0 = (defpackage.ua.j) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.i = r1
            goto L_0x0018
        L_0x0013:
            ua$j r0 = new ua$j
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.g
            p66 r1 = defpackage.p66.COROUTINE_SUSPENDED
            int r2 = r0.i
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f
            ua r0 = (defpackage.ua) r0
            defpackage.hd3.Y2(r5)     // Catch:{ all -> 0x002b }
            goto L_0x0043
        L_0x002b:
            r5 = move-exception
            goto L_0x0048
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            defpackage.hd3.Y2(r5)
            r0.f = r4     // Catch:{ all -> 0x0046 }
            r0.i = r3     // Catch:{ all -> 0x0046 }
            java.lang.Object r5 = r4.d(r0)     // Catch:{ all -> 0x0046 }
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            s56 r5 = defpackage.s56.f3190a
            return r5
        L_0x0046:
            r5 = move-exception
            r0 = r4
        L_0x0048:
            ve6<xa<T>> r0 = r0.g
            ra r1 = new ra
            r1.<init>(r5)
            r0.setValue(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ua.e(k66):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(defpackage.k66<? super defpackage.s56> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof defpackage.ua.k
            if (r0 == 0) goto L_0x0013
            r0 = r5
            ua$k r0 = (defpackage.ua.k) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.i = r1
            goto L_0x0018
        L_0x0013:
            ua$k r0 = new ua$k
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.g
            p66 r1 = defpackage.p66.COROUTINE_SUSPENDED
            int r2 = r0.i
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f
            ua r0 = (defpackage.ua) r0
            defpackage.hd3.Y2(r5)     // Catch:{ all -> 0x002b }
            goto L_0x004f
        L_0x002b:
            r5 = move-exception
            goto L_0x0045
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            defpackage.hd3.Y2(r5)
            r0.f = r4     // Catch:{ all -> 0x0043 }
            r0.i = r3     // Catch:{ all -> 0x0043 }
            java.lang.Object r5 = r4.d(r0)     // Catch:{ all -> 0x0043 }
            if (r5 != r1) goto L_0x004f
            return r1
        L_0x0043:
            r5 = move-exception
            r0 = r4
        L_0x0045:
            ve6<xa<T>> r0 = r0.g
            ra r1 = new ra
            r1.<init>(r5)
            r0.setValue(r1)
        L_0x004f:
            s56 r5 = defpackage.s56.f3190a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ua.f(k66):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(defpackage.k66<? super T> r5) {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ua.g(k66):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0083 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(defpackage.k66<? super T> r8) {
        /*
        // Method dump skipped, instructions count: 140
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ua.h(k66):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(defpackage.w76<? super T, ? super defpackage.k66<? super T>, ? extends java.lang.Object> r8, defpackage.m66 r9, defpackage.k66<? super T> r10) {
        /*
        // Method dump skipped, instructions count: 157
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ua.i(w76, m66, k66):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j(T r7, defpackage.k66<? super defpackage.s56> r8) {
        /*
        // Method dump skipped, instructions count: 229
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ua.j(java.lang.Object, k66):java.lang.Object");
    }
}
