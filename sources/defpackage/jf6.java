package defpackage;

/* renamed from: jf6  reason: default package */
/* compiled from: SafeCollector.kt */
public final class jf6 {

    /* renamed from: a  reason: collision with root package name */
    public static final x76<re6<Object>, Object, k66<? super s56>, Object> f1919a;

    /* renamed from: jf6$a */
    /* compiled from: SafeCollector.kt */
    public /* synthetic */ class a extends m86 implements x76<re6<? super Object>, Object, s56> {
        public static final a n = new a();

        public a() {
            super(3, re6.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // defpackage.x76
        public Object e(Object obj, Object obj2, Object obj3) {
            return ((re6) obj).a(obj2, (k66) obj3);
        }
    }

    static {
        a aVar = a.n;
        b96.b(aVar, 3);
        f1919a = aVar;
    }
}
