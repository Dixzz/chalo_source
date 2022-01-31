package defpackage;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;

/* renamed from: hy4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class hy4 implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f1444a;
    public final /* synthetic */ Context b;

    public /* synthetic */ hy4(FirebaseApp firebaseApp, Context context) {
        this.f1444a = firebaseApp;
        this.b = context;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        return this.f1444a.a(this.b);
    }
}
