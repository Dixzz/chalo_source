package defpackage;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* renamed from: be2  reason: default package */
public final class be2 implements xz1 {
    public final Status f;
    public final Credential g;

    public be2(Status status, Credential credential) {
        this.f = status;
        this.g = credential;
    }

    @Override // defpackage.f32
    public final Status M0() {
        return this.f;
    }

    @Override // defpackage.xz1
    public final Credential getCredential() {
        return this.g;
    }
}
