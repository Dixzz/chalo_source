package defpackage;

import defpackage.a13;
import defpackage.x22;
import java.util.concurrent.Future;

/* renamed from: d13  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class d13<T extends a13> {

    /* renamed from: a  reason: collision with root package name */
    public z03<T> f778a;

    public abstract Future<z03<T>> a();

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: yi4<TResult>, yi4<ResultT> */
    public final <ResultT, A extends x22.b> yi4<ResultT> b(c13<A, ResultT> c13) {
        return (yi4<TResult>) d().f4105a.doRead(c13.zzb());
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: yi4<TResult>, yi4<ResultT> */
    public final <ResultT, A extends x22.b> yi4<ResultT> c(c13<A, ResultT> c13) {
        return (yi4<TResult>) d().f4105a.doWrite(c13.zzb());
    }

    public final z03<T> d() {
        z03<T> z03;
        synchronized (this) {
            if (this.f778a == null) {
                try {
                    this.f778a = a().get();
                } catch (Exception e) {
                    String valueOf = String.valueOf(e.getMessage());
                    throw new RuntimeException(valueOf.length() != 0 ? "There was an error while initializing the connection to the GoogleApi: ".concat(valueOf) : new String("There was an error while initializing the connection to the GoogleApi: "));
                }
            }
            z03 = this.f778a;
        }
        return z03;
    }
}
