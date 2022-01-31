package defpackage;

import com.urbanairship.json.JsonValue;
import java.text.ParseException;

/* renamed from: by5  reason: default package */
/* compiled from: RemoteDataPayload */
public class by5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f491a;
    public final long b;
    public final zt5 c;
    public final zt5 d;

    /* renamed from: by5$b */
    /* compiled from: RemoteDataPayload */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f492a;
        public long b;
        public zt5 c;
        public zt5 d;

        public by5 a() {
            hd3.E(this.f492a, "Missing type");
            hd3.E(this.c, "Missing data");
            return new by5(this, null);
        }
    }

    public by5(b bVar, a aVar) {
        this.f491a = bVar.f492a;
        this.b = bVar.b;
        this.c = bVar.c;
        zt5 zt5 = bVar.d;
        this.d = zt5 == null ? zt5.g : zt5;
    }

    public static by5 a(JsonValue jsonValue, zt5 zt5) throws xt5 {
        zt5 n = jsonValue.n();
        JsonValue u = n.u("type");
        JsonValue u2 = n.u("timestamp");
        JsonValue u3 = n.u("data");
        try {
            if (!(u.f instanceof String) || !(u2.f instanceof String) || !(u3.f instanceof zt5)) {
                throw new xt5("Invalid remote data payload: " + jsonValue.toString());
            }
            long b2 = ly5.b(u2.i());
            b bVar = new b();
            bVar.c = u3.n();
            bVar.b = b2;
            bVar.f492a = u.o();
            bVar.d = zt5;
            return bVar.a();
        } catch (IllegalArgumentException | ParseException e) {
            StringBuilder i0 = hj1.i0("Invalid remote data payload: ");
            i0.append(jsonValue.toString());
            throw new xt5(i0.toString(), e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || by5.class != obj.getClass()) {
            return false;
        }
        by5 by5 = (by5) obj;
        if (this.b == by5.b && this.f491a.equals(by5.f491a) && this.c.equals(by5.c)) {
            return this.d.equals(by5.d);
        }
        return false;
    }

    public int hashCode() {
        long j = this.b;
        int hashCode = this.c.hashCode();
        return this.d.hashCode() + ((hashCode + (((this.f491a.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31)) * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("RemoteDataPayload{type='");
        hj1.U0(i0, this.f491a, '\'', ", timestamp=");
        i0.append(this.b);
        i0.append(", data=");
        i0.append(this.c);
        i0.append(", metadata=");
        i0.append(this.d);
        i0.append('}');
        return i0.toString();
    }
}
