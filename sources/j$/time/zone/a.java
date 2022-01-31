package j$.time.zone;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.chrono.b;
import j$.time.h;
import java.io.Serializable;
import java.util.Objects;

public final class a implements Comparable<a>, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final LocalDateTime f1640a;
    private final h b;
    private final h c;

    a(long j, h hVar, h hVar2) {
        this.f1640a = LocalDateTime.z(j, 0, hVar);
        this.b = hVar;
        this.c = hVar2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(a aVar) {
        return h().t(aVar.h());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f1640a.equals(aVar.f1640a) && this.b.equals(aVar.b) && this.c.equals(aVar.c);
    }

    public Instant h() {
        LocalDateTime localDateTime = this.f1640a;
        return Instant.y(localDateTime.A(this.b), (long) localDateTime.b().x());
    }

    public int hashCode() {
        return (this.f1640a.hashCode() ^ this.b.hashCode()) ^ Integer.rotateLeft(this.c.hashCode(), 16);
    }

    public h j() {
        return this.c;
    }

    public h l() {
        return this.b;
    }

    public String toString() {
        StringBuilder a2 = j$.com.android.tools.r8.a.a("Transition[");
        a2.append(this.c.x() > this.b.x() ? "Gap" : "Overlap");
        a2.append(" at ");
        a2.append(this.f1640a);
        a2.append(this.b);
        a2.append(" to ");
        a2.append(this.c);
        a2.append(']');
        return a2.toString();
    }

    public long u() {
        LocalDateTime localDateTime = this.f1640a;
        h hVar = this.b;
        Objects.requireNonNull(localDateTime);
        return b.l(localDateTime, hVar);
    }
}
