package defpackage;

import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

@AutoValue
@Encodable
/* renamed from: tu1  reason: default package */
/* compiled from: BatchedLogRequest */
public abstract class tu1 {
    @Encodable.Field(name = "logRequest")
    public abstract List<wu1> a();
}
