package defpackage;

import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

@AutoValue
/* renamed from: wu1  reason: default package */
/* compiled from: LogRequest */
public abstract class wu1 {
    public abstract uu1 a();

    @Encodable.Field(name = "logEvent")
    public abstract List<vu1> b();

    public abstract Integer c();

    public abstract String d();

    public abstract zu1 e();

    public abstract long f();

    public abstract long g();
}
