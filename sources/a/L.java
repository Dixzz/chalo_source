package a;

import j$.util.function.s;
import java.util.function.DoublePredicate;

public final /* synthetic */ class L implements s {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DoublePredicate f25a;

    private /* synthetic */ L(DoublePredicate doublePredicate) {
        this.f25a = doublePredicate;
    }

    public static /* synthetic */ s a(DoublePredicate doublePredicate) {
        if (doublePredicate == null) {
            return null;
        }
        return doublePredicate instanceof M ? ((M) doublePredicate).f27a : new L(doublePredicate);
    }

    public /* synthetic */ boolean b(double d) {
        return this.f25a.test(d);
    }
}
