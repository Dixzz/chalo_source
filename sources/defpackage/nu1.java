package defpackage;

import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;
import java.util.Objects;

/* renamed from: nu1  reason: default package */
/* compiled from: AutoValue_BatchedLogRequest */
public final class nu1 extends tu1 {

    /* renamed from: a  reason: collision with root package name */
    public final List<wu1> f2605a;

    public nu1(List<wu1> list) {
        Objects.requireNonNull(list, "Null logRequests");
        this.f2605a = list;
    }

    @Override // defpackage.tu1
    @Encodable.Field(name = "logRequest")
    public List<wu1> a() {
        return this.f2605a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof tu1) {
            return this.f2605a.equals(((tu1) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.f2605a.hashCode() ^ 1000003;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("BatchedLogRequest{logRequests=");
        i0.append(this.f2605a);
        i0.append("}");
        return i0.toString();
    }
}
