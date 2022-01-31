package defpackage;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import java.util.concurrent.Executor;

/* renamed from: yi4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public abstract class yi4<TResult> {
    public yi4<TResult> a(@RecentlyNonNull Executor executor, @RecentlyNonNull si4 si4) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    public yi4<TResult> b(@RecentlyNonNull ti4<TResult> ti4) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public yi4<TResult> c(@RecentlyNonNull Executor executor, @RecentlyNonNull ti4<TResult> ti4) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract yi4<TResult> d(@RecentlyNonNull ui4 ui4);

    public abstract yi4<TResult> e(@RecentlyNonNull Executor executor, @RecentlyNonNull ui4 ui4);

    public abstract yi4<TResult> f(@RecentlyNonNull vi4<? super TResult> vi4);

    public abstract yi4<TResult> g(@RecentlyNonNull Executor executor, @RecentlyNonNull vi4<? super TResult> vi4);

    public <TContinuationResult> yi4<TContinuationResult> h(@RecentlyNonNull qi4<TResult, TContinuationResult> qi4) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> yi4<TContinuationResult> i(@RecentlyNonNull Executor executor, @RecentlyNonNull qi4<TResult, TContinuationResult> qi4) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> yi4<TContinuationResult> j(@RecentlyNonNull qi4<TResult, yi4<TContinuationResult>> qi4) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public <TContinuationResult> yi4<TContinuationResult> k(@RecentlyNonNull Executor executor, @RecentlyNonNull qi4<TResult, yi4<TContinuationResult>> qi4) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    @RecentlyNullable
    public abstract Exception l();

    @RecentlyNonNull
    public abstract TResult m();

    @RecentlyNonNull
    public abstract <X extends Throwable> TResult n(@RecentlyNonNull Class<X> cls) throws Throwable;

    public abstract boolean o();

    public abstract boolean p();

    public abstract boolean q();

    public <TContinuationResult> yi4<TContinuationResult> r(@RecentlyNonNull xi4<TResult, TContinuationResult> xi4) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    public <TContinuationResult> yi4<TContinuationResult> s(@RecentlyNonNull Executor executor, @RecentlyNonNull xi4<TResult, TContinuationResult> xi4) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }
}
