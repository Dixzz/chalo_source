package defpackage;

import app.zophop.models.Agency;
import app.zophop.models.City;
import app.zophop.models.mTicketing.BasicProfileFields;
import app.zophop.models.mTicketing.BasicUserProfile;
import app.zophop.models.mTicketing.ProfileRequestAgencyInfo;
import app.zophop.models.mTicketing.ProfileRequestInfo;
import app.zophop.models.mTicketing.UserProfile;
import java.util.Map;
import java.util.Objects;

@y66(c = "app.zophop.ui.viewmodels.MPassPurchaseSharedViewModel$getProfileRequestInfo$lProfileRequestInfoJob$1", f = "MPassPurchaseSharedViewModel.kt", l = {325, 328}, m = "invokeSuspend")
/* renamed from: q81  reason: default package */
/* compiled from: MPassPurchaseSharedViewModel.kt */
public final class q81 extends b76 implements w76<mb6, k66<? super ProfileRequestInfo>, Object> {
    public int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ p81 h;

    @y66(c = "app.zophop.ui.viewmodels.MPassPurchaseSharedViewModel$getProfileRequestInfo$lProfileRequestInfoJob$1$lProfileRequestInfoFromMapJob$1", f = "MPassPurchaseSharedViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: q81$a */
    /* compiled from: MPassPurchaseSharedViewModel.kt */
    public static final class a extends b76 implements w76<mb6, k66<? super ProfileRequestInfo>, Object> {
        public final /* synthetic */ p81 f;
        public final /* synthetic */ Map<String, String> g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(p81 p81, Map<String, String> map, k66<? super a> k66) {
            super(2, k66);
            this.f = p81;
            this.g = map;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new a(this.f, this.g, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super ProfileRequestInfo> k66) {
            return new a(this.f, this.g, k66).invokeSuspend(s56.f3190a);
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            hd3.Y2(obj);
            p81 p81 = this.f;
            Map<String, String> map = this.g;
            Objects.requireNonNull(p81);
            Agency agency = p81.q;
            BasicUserProfile basicUserProfile = null;
            String agencyName = agency == null ? null : agency.getAgencyName();
            City d = xt.f3961a.k().d();
            ProfileRequestAgencyInfo profileRequestAgencyInfo = new ProfileRequestAgencyInfo(null, map, map, agencyName, d == null ? null : d.getName(), p81.g.getPassengerType());
            UserProfile d2 = p81.g().d();
            if (d2 != null) {
                BasicProfileFields build = new BasicProfileFields.Builder().withFirstName(d2.getFirstName()).withLastName(d2.getLastName()).withGender(d2.getGender()).withDateOfBirth(d2.getDateOfBirth()).withPhone(d2.getPhone()).withEmailId(d2.getEmailId()).build();
                String str = map.get("PHOTOGRAPH");
                if (str != null) {
                    basicUserProfile = new BasicUserProfile(build, str);
                } else {
                    basicUserProfile = new BasicUserProfile(build);
                }
            }
            return new ProfileRequestInfo(basicUserProfile, profileRequestAgencyInfo, p81.g);
        }
    }

    @y66(c = "app.zophop.ui.viewmodels.MPassPurchaseSharedViewModel$getProfileRequestInfo$lProfileRequestInfoJob$1$lUploadedProofsMapJob$1", f = "MPassPurchaseSharedViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: q81$b */
    /* compiled from: MPassPurchaseSharedViewModel.kt */
    public static final class b extends b76 implements w76<mb6, k66<? super Map<String, ? extends String>>, Object> {
        public final /* synthetic */ p81 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(p81 p81, k66<? super b> k66) {
            super(2, k66);
            this.f = p81;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new b(this.f, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super Map<String, ? extends String>> k66) {
            b bVar = new b(this.f, k66);
            s56 s56 = s56.f3190a;
            p66 p66 = p66.COROUTINE_SUSPENDED;
            hd3.Y2(s56);
            return bVar.f.f();
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            hd3.Y2(obj);
            return this.f.f();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q81(p81 p81, k66<? super q81> k66) {
        super(2, k66);
        this.h = p81;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        q81 q81 = new q81(this.h, k66);
        q81.g = obj;
        return q81;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super ProfileRequestInfo> k66) {
        q81 q81 = new q81(this.h, k66);
        q81.g = mb6;
        return q81.invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        mb6 mb6;
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.f;
        if (i == 0) {
            hd3.Y2(obj);
            mb6 = (mb6) this.g;
            rb6 t = hd3.t(mb6, null, null, new b(this.h, null), 3, null);
            this.g = mb6;
            this.f = 1;
            obj = ((sb6) t).v(this);
            if (obj == p66) {
                return p66;
            }
        } else if (i == 1) {
            mb6 = (mb6) this.g;
            hd3.Y2(obj);
        } else if (i == 2) {
            hd3.Y2(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        rb6 t2 = hd3.t(mb6, null, null, new a(this.h, (Map) obj, null), 3, null);
        this.g = null;
        this.f = 2;
        obj = ((sb6) t2).v(this);
        return obj == p66 ? p66 : obj;
    }
}
