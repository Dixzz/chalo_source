package defpackage;

import com.urbanairship.json.JsonValue;
import java.util.List;

/* renamed from: wo5  reason: default package */
/* compiled from: ScheduleEntity */
public class wo5 {

    /* renamed from: a  reason: collision with root package name */
    public int f3817a;
    public String b;
    public String c;
    public zt5 d;
    public int e;
    public int f;
    public long g;
    public long h;
    public long i;
    public long j;
    public String k;
    public JsonValue l;
    public int m;
    public int n;
    public long o;
    public pn5 p;
    public int q;
    public List<String> r;
    public long s;
    public String t;
    public fm5 u;
    public JsonValue v;
    public List<String> w;

    public String toString() {
        StringBuilder i0 = hj1.i0("ScheduleEntity{id=");
        i0.append(this.f3817a);
        i0.append(", scheduleId='");
        hj1.U0(i0, this.b, '\'', ", group='");
        hj1.U0(i0, this.c, '\'', ", metadata=");
        i0.append(this.d);
        i0.append(", limit=");
        i0.append(this.e);
        i0.append(", priority=");
        i0.append(this.f);
        i0.append(", scheduleStart=");
        i0.append(this.g);
        i0.append(", scheduleEnd=");
        i0.append(this.h);
        i0.append(", editGracePeriod=");
        i0.append(this.i);
        i0.append(", interval=");
        i0.append(this.j);
        i0.append(", scheduleType='");
        hj1.U0(i0, this.k, '\'', ", data=");
        i0.append(this.l);
        i0.append(", count=");
        i0.append(this.m);
        i0.append(", executionState=");
        i0.append(this.n);
        i0.append(", executionStateChangeDate=");
        i0.append(this.o);
        i0.append(", triggerContext=");
        i0.append(this.p);
        i0.append(", appState=");
        i0.append(this.q);
        i0.append(", screens=");
        i0.append(this.r);
        i0.append(", seconds=");
        i0.append(this.s);
        i0.append(", regionId='");
        hj1.U0(i0, this.t, '\'', ", audience=");
        i0.append(this.u);
        i0.append(", campaigns=");
        i0.append(this.v);
        i0.append(", frequencyConstraintIds=");
        i0.append(this.w);
        i0.append('}');
        return i0.toString();
    }
}
