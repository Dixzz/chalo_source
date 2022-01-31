package defpackage;

import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.common.api.Status;

/* renamed from: de2  reason: default package */
public final class de2 extends fe2<xz1> {
    public final /* synthetic */ CredentialRequest q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public de2(a32 a32, CredentialRequest credentialRequest) {
        super(a32);
        this.q = credentialRequest;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final f32 d(Status status) {
        return new be2(status, null);
    }
}
