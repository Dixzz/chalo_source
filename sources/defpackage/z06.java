package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: z06  reason: default package */
/* compiled from: PriorityTask */
public class z06 implements t06<a16>, y06, a16 {
    private final List<a16> dependencies = new ArrayList();
    private final AtomicBoolean hasRun = new AtomicBoolean(false);
    private final AtomicReference<Throwable> throwable = new AtomicReference<>(null);

    public static boolean isProperDelegate(Object obj) {
        try {
            t06 t06 = (t06) obj;
            a16 a16 = (a16) obj;
            y06 y06 = (y06) obj;
            if (t06 == null || a16 == null || y06 == null) {
                return false;
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean areDependenciesMet() {
        for (a16 a16 : getDependencies()) {
            if (!a16.isFinished()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return v06.compareTo(this, obj);
    }

    @Override // defpackage.t06
    public synchronized Collection<a16> getDependencies() {
        return Collections.unmodifiableCollection(this.dependencies);
    }

    public Throwable getError() {
        return this.throwable.get();
    }

    @Override // defpackage.y06
    public v06 getPriority() {
        return v06.NORMAL;
    }

    @Override // defpackage.a16
    public boolean isFinished() {
        return this.hasRun.get();
    }

    public void setError(Throwable th) {
        this.throwable.set(th);
    }

    public synchronized void setFinished(boolean z) {
        this.hasRun.set(z);
    }

    public synchronized void addDependency(a16 a16) {
        this.dependencies.add(a16);
    }
}
