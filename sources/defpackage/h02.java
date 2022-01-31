package defpackage;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* renamed from: h02  reason: default package */
public class h02 implements f32 {
    public Status f;
    public GoogleSignInAccount g;

    public h02(GoogleSignInAccount googleSignInAccount, Status status) {
        this.g = googleSignInAccount;
        this.f = status;
    }

    @Override // defpackage.f32
    public Status M0() {
        return this.f;
    }
}
