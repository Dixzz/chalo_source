package defpackage;

import com.google.firebase.installations.FirebaseInstallations;

/* renamed from: lz4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class lz4 implements Runnable {
    public final /* synthetic */ FirebaseInstallations f;
    public final /* synthetic */ boolean g;

    public /* synthetic */ lz4(FirebaseInstallations firebaseInstallations, boolean z) {
        this.f = firebaseInstallations;
        this.g = z;
    }

    public final void run() {
        this.f.c(this.g);
    }
}
