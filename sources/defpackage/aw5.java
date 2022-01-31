package defpackage;

import com.urbanairship.json.JsonValue;

/* renamed from: aw5  reason: default package */
/* compiled from: QuietTimeInterval */
public class aw5 implements cu5 {
    public final int f;
    public final int g;
    public final int h;
    public final int i;

    /* renamed from: aw5$b */
    /* compiled from: QuietTimeInterval */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f341a = -1;
        public int b = -1;
        public int c = -1;
        public int d = -1;
    }

    public aw5(b bVar, a aVar) {
        this.f = bVar.f341a;
        this.g = bVar.b;
        this.h = bVar.c;
        this.i = bVar.d;
    }

    public static aw5 a(JsonValue jsonValue) throws xt5 {
        zt5 n = jsonValue.n();
        if (!n.isEmpty()) {
            b bVar = new b();
            bVar.f341a = n.u("start_hour").e(-1);
            bVar.b = n.u("start_min").e(-1);
            bVar.c = n.u("end_hour").e(-1);
            bVar.d = n.u("end_min").e(-1);
            return new aw5(bVar, null);
        }
        throw new xt5(hj1.R("Invalid quiet time interval: ", jsonValue));
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        return JsonValue.x(zt5.s().c("start_hour", this.f).c("start_min", this.g).c("end_hour", this.h).c("end_min", this.i).a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || aw5.class != obj.getClass()) {
            return false;
        }
        aw5 aw5 = (aw5) obj;
        if (this.f == aw5.f && this.g == aw5.g && this.h == aw5.h && this.i == aw5.i) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f * 31) + this.g) * 31) + this.h) * 31) + this.i;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("QuietTimeInterval{startHour=");
        i0.append(this.f);
        i0.append(", startMin=");
        i0.append(this.g);
        i0.append(", endHour=");
        i0.append(this.h);
        i0.append(", endMin=");
        return hj1.W(i0, this.i, '}');
    }
}
