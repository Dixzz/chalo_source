package defpackage;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import app.zophop.models.mTicketing.ProofUploadDetails;
import com.razorpay.AnalyticsConstants;
import server.zophop.queue.TaskKeys;

/* renamed from: g91  reason: default package */
/* compiled from: UserProofsOverViewFragmentViewModel.kt */
public final class g91 extends zh {
    public final wh c;
    public String d;
    public ProofUploadDetails e;
    public final j56 f;
    public final j56 g;
    public final mh<Boolean> h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public String l;

    /* renamed from: g91$a */
    /* compiled from: UserProofsOverViewFragmentViewModel.kt */
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
            return new g91(whVar);
        }
    }

    /* renamed from: g91$b */
    /* compiled from: UserProofsOverViewFragmentViewModel.kt */
    public static final class b extends o86 implements h76<oh<Boolean>> {
        public final /* synthetic */ g91 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g91 g91) {
            super(0);
            this.f = g91;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Boolean> invoke() {
            return this.f.c.a("keyAreAllProofsUploaded", Boolean.FALSE);
        }
    }

    /* renamed from: g91$c */
    /* compiled from: UserProofsOverViewFragmentViewModel.kt */
    public static final class c extends o86 implements h76<oh<Boolean>> {
        public final /* synthetic */ g91 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(g91 g91) {
            super(0);
            this.f = g91;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Boolean> invoke() {
            return this.f.c.a("keyIsNameChangeCompleted", Boolean.FALSE);
        }
    }

    public g91(wh whVar) {
        Boolean bool = Boolean.FALSE;
        n86.e(whVar, "savedStateHandle");
        this.c = whVar;
        this.d = (String) whVar.f3779a.get("keyEditedProofId");
        ProofUploadDetails proofUploadDetails = (ProofUploadDetails) whVar.f3779a.get("keyEditedProofUploadDetails");
        this.e = proofUploadDetails == null ? new ProofUploadDetails(null, null, null, null, false, 31, null) : proofUploadDetails;
        j56 a2 = hd3.a2(new b(this));
        this.f = a2;
        j56 a22 = hd3.a2(new c(this));
        this.g = a22;
        mh<Boolean> mhVar = new mh<>();
        this.h = mhVar;
        Boolean bool2 = (Boolean) whVar.f3779a.get("keyShouldReInitiate");
        this.i = (bool2 == null ? bool : bool2).booleanValue();
        Boolean bool3 = (Boolean) whVar.f3779a.get("keyShouldReapply");
        this.j = (bool3 != null ? bool3 : bool).booleanValue();
        Boolean bool4 = (Boolean) whVar.f3779a.get("keyIsFreshApplicationFlow");
        this.k = (bool4 == null ? Boolean.TRUE : bool4).booleanValue();
        this.l = (String) whVar.f3779a.get("keyFullName");
        Object value = ((o56) a2).getValue();
        n86.d(value, "<get-areAllProofsUploaded>(...)");
        mhVar.m((LiveData) value, new y71(this));
        Object value2 = ((o56) a22).getValue();
        n86.d(value2, "<get-isNameChangeCompleted>(...)");
        mhVar.m((LiveData) value2, new z71(this));
    }
}
