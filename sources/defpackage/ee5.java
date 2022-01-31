package defpackage;

import android.os.Looper;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: ee5  reason: default package */
/* compiled from: UIThreadSet */
public class ee5<T> {

    /* renamed from: a  reason: collision with root package name */
    public Set<T> f966a = new HashSet();

    public Set<T> a() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return Collections.unmodifiableSet(this.f966a);
        }
        throw new RuntimeException("Can't remove an activity when not on the UI thread");
    }
}
