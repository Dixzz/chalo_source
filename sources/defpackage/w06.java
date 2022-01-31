package defpackage;

import java.util.Collection;

/* renamed from: w06  reason: default package */
/* compiled from: PriorityAsyncTask */
public abstract class w06<Params, Progress, Result> extends s06<Params, Progress, Result> implements t06<a16>, y06, a16 {
    public final z06 s = new z06();

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return v06.compareTo(this, obj);
    }

    @Override // defpackage.t06
    public Collection<a16> getDependencies() {
        return this.s.getDependencies();
    }

    @Override // defpackage.a16
    public boolean isFinished() {
        return this.s.isFinished();
    }
}
