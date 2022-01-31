package defpackage;

import android.app.Application;
import androidx.lifecycle.LiveData;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import defpackage.xt;
import java.util.HashMap;
import java.util.Map;

/* renamed from: y91  reason: default package */
/* compiled from: SuperPassValidationScreensSharedViewModel.kt */
public final class y91 extends lg {
    public static final a j = new a(null);
    public final wh d;
    public String e;
    public SuperPassSubType f;
    public final j56 g = hd3.a2(new c(this));
    public final j56 h = hd3.a2(new b(this));
    public boolean i;

    /* renamed from: y91$a */
    /* compiled from: SuperPassValidationScreensSharedViewModel.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* renamed from: y91$b */
    /* compiled from: SuperPassValidationScreensSharedViewModel.kt */
    public static final class b extends o86 implements h76<qe6<? extends SuperPass>> {
        public final /* synthetic */ y91 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(y91 y91) {
            super(0);
            this.f = y91;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public qe6<? extends SuperPass> invoke() {
            if (this.f.f == SuperPassSubType.RIDE_BASED_SUPER_PASS) {
                return xt.f3961a.e0().getRideBasedSuperPass(this.f.e);
            }
            return xt.f3961a.e0().getMagicSuperPass(this.f.e);
        }
    }

    /* renamed from: y91$c */
    /* compiled from: SuperPassValidationScreensSharedViewModel.kt */
    public static final class c extends o86 implements h76<LiveData<SuperPass>> {
        public final /* synthetic */ y91 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(y91 y91) {
            super(0);
            this.f = y91;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public LiveData<SuperPass> invoke() {
            return wg.a((qe6) this.f.h.getValue(), null, 0, 3);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y91(Application application, wh whVar) {
        super(application);
        n86.e(application, "application");
        n86.e(whVar, "savedStateHandle");
        this.d = whVar;
        this.e = String.valueOf(whVar.f3779a.get("arg_super_pass_id"));
        Object obj = whVar.f3779a.get("arg_super_pass_sub_type");
        n86.c(obj);
        n86.d(obj, "savedStateHandle.get<Sup…RG_SUPER_PASS_SUB_TYPE)!!");
        this.f = (SuperPassSubType) obj;
        xt.t1 t1Var = xt.f3961a;
        this.i = t1Var.l().h.optString("keySoundFragmentTutorialShown", null) != null ? Boolean.parseBoolean(t1Var.l().h.optString("keySoundFragmentTutorialShown", null)) : false;
    }

    public final LiveData<SuperPass> d() {
        return (LiveData) this.g.getValue();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x003d */
    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: z25 */
    /* JADX DEBUG: Multi-variable search result rejected for r9v4, resolved type: z25 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v9, types: [f45] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0052 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap e(defpackage.z25 r9, app.zophop.models.mTicketing.superPass.SuperPass r10) {
        /*
        // Method dump skipped, instructions count: 193
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y91.e(z25, app.zophop.models.mTicketing.superPass.SuperPass):android.graphics.Bitmap");
    }

    public final Map<String, String> f(SuperPass superPass) {
        n86.e(superPass, "lSuperPass");
        HashMap hashMap = new HashMap();
        hashMap.put("userPropertyCity", superPass.getSuperPassProperties().getCityName());
        SuperPassUserDetails superPassUserDetails = superPass.getSuperPassUIProperties().getSuperPassUserDetails();
        hashMap.put("userPropertyUserName", superPassUserDetails.getFullName());
        hashMap.put("userPropertyPhoneNo", superPassUserDetails.getMobileNumber());
        hashMap.put("userPropertyUserID", superPassUserDetails.getUserId());
        hashMap.put("userPropertyAgencyName", superPass.getSuperPassProperties().getAgencyName());
        hashMap.put("userPropertyMPassId", superPass.getSuperPassProperties().getPassId());
        hashMap.put("userPropertyOrderId", superPass.getSuperPassTransactionDetails().getTransactionId());
        return hashMap;
    }
}
