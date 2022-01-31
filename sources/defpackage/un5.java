package defpackage;

import com.urbanairship.UAirship;
import java.util.Objects;

/* renamed from: un5  reason: default package */
/* compiled from: TriggerObservables */
public final class un5 implements ox5<sw5<cu5>> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.ox5
    public sw5<cu5> apply() {
        if (!UAirship.l().g.h) {
            return sw5.c();
        }
        Objects.requireNonNull(UAirship.l().g);
        return sw5.e(hd3.b0(UAirship.c()));
    }
}
