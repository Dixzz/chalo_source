package defpackage;

import com.google.firebase.installations.FirebaseInstallations;
import java.util.concurrent.Callable;

/* renamed from: mz4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class mz4 implements Callable {
    public final /* synthetic */ FirebaseInstallations f;

    public /* synthetic */ mz4(FirebaseInstallations firebaseInstallations) {
        this.f = firebaseInstallations;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f.deleteFirebaseInstallationId();
    }
}
