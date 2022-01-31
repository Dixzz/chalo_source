package defpackage;

/* renamed from: nb6  reason: default package */
/* compiled from: CoroutineStart.kt */
public enum nb6 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public static /* synthetic */ void isLazy$annotations() {
    }

    /* JADX INFO: finally extract failed */
    public final <T> void invoke(s76<? super k66<? super T>, ? extends Object> s76, k66<? super T> k66) {
        s56 s56 = s56.f3190a;
        int ordinal = ordinal();
        if (ordinal == 0) {
            try {
                rf6.b(hd3.B1(hd3.X(s76, k66)), s56, null, 2);
            } catch (Throwable th) {
                k66.resumeWith(hd3.Z(th));
            }
        } else if (ordinal == 1) {
        } else {
            if (ordinal == 2) {
                n86.e(s76, "$this$startCoroutine");
                n86.e(k66, "completion");
                hd3.B1(hd3.X(s76, k66)).resumeWith(s56);
            } else if (ordinal == 3) {
                n86.e(k66, "completion");
                try {
                    m66 context = k66.getContext();
                    Object b = fg6.b(context, null);
                    if (s76 != null) {
                        try {
                            b96.b(s76, 1);
                            Object invoke = s76.invoke(k66);
                            fg6.a(context, b);
                            if (invoke != p66.COROUTINE_SUSPENDED) {
                                k66.resumeWith(invoke);
                            }
                        } catch (Throwable th2) {
                            fg6.a(context, b);
                            throw th2;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                    }
                } catch (Throwable th3) {
                    k66.resumeWith(hd3.Z(th3));
                }
            } else {
                throw new l56();
            }
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }

    /* JADX INFO: finally extract failed */
    public final <R, T> void invoke(w76<? super R, ? super k66<? super T>, ? extends Object> w76, R r, k66<? super T> k66) {
        int ordinal = ordinal();
        if (ordinal == 0) {
            ec6.B(w76, r, k66, null, 4);
        } else if (ordinal == 1) {
        } else {
            if (ordinal == 2) {
                n86.e(w76, "$this$startCoroutine");
                n86.e(k66, "completion");
                hd3.B1(hd3.Y(w76, r, k66)).resumeWith(s56.f3190a);
            } else if (ordinal == 3) {
                n86.e(k66, "completion");
                try {
                    m66 context = k66.getContext();
                    Object b = fg6.b(context, null);
                    if (w76 != null) {
                        try {
                            b96.b(w76, 2);
                            Object invoke = w76.invoke(r, k66);
                            fg6.a(context, b);
                            if (invoke != p66.COROUTINE_SUSPENDED) {
                                k66.resumeWith(invoke);
                            }
                        } catch (Throwable th) {
                            fg6.a(context, b);
                            throw th;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                    }
                } catch (Throwable th2) {
                    k66.resumeWith(hd3.Z(th2));
                }
            } else {
                throw new l56();
            }
        }
    }
}
