package defpackage;

import android.os.Bundle;
import com.urbanairship.actions.ActionValue;

/* renamed from: ok5  reason: default package */
/* compiled from: ActionArguments */
public final class ok5 {

    /* renamed from: a  reason: collision with root package name */
    public final int f2706a;
    public final ActionValue b;
    public final Bundle c;

    public ok5(int i, ActionValue actionValue, Bundle bundle) {
        this.f2706a = i;
        this.b = actionValue == null ? new ActionValue() : actionValue;
        this.c = new Bundle(bundle);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ActionArguments { situation: ");
        i0.append(this.f2706a);
        i0.append(", value: ");
        i0.append(this.b);
        i0.append(", metadata: ");
        i0.append(this.c);
        i0.append(" }");
        return i0.toString();
    }
}
