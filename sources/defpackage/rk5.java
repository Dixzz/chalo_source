package defpackage;

import com.urbanairship.actions.ActionValue;

/* renamed from: rk5  reason: default package */
/* compiled from: ActionResult */
public final class rk5 {

    /* renamed from: a  reason: collision with root package name */
    public final Exception f3092a;
    public final ActionValue b;
    public final int c;

    public rk5(ActionValue actionValue, Exception exc, int i) {
        this.b = actionValue == null ? new ActionValue() : actionValue;
        this.f3092a = exc;
        this.c = i;
    }

    public static rk5 a() {
        return new rk5(null, null, 1);
    }

    public static rk5 b(int i) {
        return new rk5(null, null, i);
    }

    public static rk5 c(Exception exc) {
        return new rk5(null, exc, 4);
    }

    public static rk5 d(ActionValue actionValue) {
        return new rk5(actionValue, null, 1);
    }
}
