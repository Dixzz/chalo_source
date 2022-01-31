package defpackage;

import android.os.Bundle;
import app.zophop.models.mTicketing.ProofDocumentProps;
import com.razorpay.AnalyticsConstants;
import server.zophop.queue.TaskKeys;

/* renamed from: f91  reason: default package */
/* compiled from: UserProofUploadFragmentViewModel.kt */
public final class f91 extends zh {
    public final wh c;
    public final ProofDocumentProps d;
    public String e;

    /* renamed from: f91$a */
    /* compiled from: UserProofUploadFragmentViewModel.kt */
    public static final class a extends kg {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(mm mmVar, Bundle bundle) {
            super(mmVar, bundle);
            n86.e(mmVar, TaskKeys.OWNER);
        }

        @Override // defpackage.kg
        public <T extends zh> T d(String str, Class<T> cls, wh whVar) {
            n86.e(str, AnalyticsConstants.KEY);
            n86.e(cls, "modelClass");
            n86.e(whVar, "handle");
            return new f91(whVar);
        }
    }

    public f91(wh whVar) {
        n86.e(whVar, "savedStateHandle");
        this.c = whVar;
        Object obj = whVar.f3779a.get("keyProofDetails");
        n86.c(obj);
        n86.d(obj, "savedStateHandle.get<Pro…ops>(KEY_PROOF_DETAILS)!!");
        this.d = (ProofDocumentProps) obj;
        String str = (String) whVar.f3779a.get("keyLocalImageUri");
        this.e = str == null ? new String() : str;
    }

    public final void d(String str) {
        n86.e(str, "lLocalImageUri");
        this.e = str;
        this.c.b("keyLocalImageUri", str);
    }
}
