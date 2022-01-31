package defpackage;

import com.urbanairship.json.JsonValue;

/* renamed from: du5  reason: default package */
/* compiled from: ValueMatcher */
public abstract class du5 implements cu5, dk5<cu5> {
    public abstract boolean a(JsonValue jsonValue, boolean z);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.dk5
    public boolean apply(cu5 cu5) {
        cu5 cu52 = cu5;
        return a(cu52 == null ? JsonValue.g : cu52.b(), false);
    }

    public String toString() {
        return b().toString();
    }
}
