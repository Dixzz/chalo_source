package app.zophop.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.Agency;
import app.zophop.models.RouteInfo;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.ProductCategory;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.ProfileRequestAgencyInfo;
import app.zophop.models.mTicketing.ProfileRequestInfo;
import app.zophop.models.mTicketing.ProofViewInfo;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.ui.fragments.UserDetailsFragment;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDetailsActivity extends wt {
    public static ProfileRequestInfo x;
    public UserDetailsFragment l;
    public MPass m;
    public MTicket n;
    public Agency o;
    public String p;
    public String q;
    public RouteInfo r;
    public String s;
    public String t;
    public ov u;
    public String v;
    public String w;

    /* JADX WARN: Incorrect args count in method signature: (Landroid/content/Context;Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;Lapp/zophop/models/mTicketing/MPass;Lapp/zophop/models/RouteInfo;Lapp/zophop/models/mTicketing/ProfileRequestInfo;Ljava/lang/String;I)V */
    public static void i0(Context context, String str, List list, MPass mPass, RouteInfo routeInfo, ProfileRequestInfo profileRequestInfo, String str2) {
        x = profileRequestInfo;
        Intent intent = new Intent(context, UserDetailsActivity.class);
        if (routeInfo != null) {
            intent.putExtra("route_info_extra", new Gson().toJson(routeInfo));
        }
        intent.putExtra("src", str2);
        intent.putExtra("magic_pass_info", ov.f(mPass));
        intent.putExtra("productId", str);
        intent.putStringArrayListExtra("productIds", (ArrayList) list);
        context.startActivity(intent);
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.activity_user_profile);
        setSupportActionBar((Toolbar) findViewById(R.id.activity_user_profile_toolbar));
        getSupportActionBar().o(true);
        this.u = new ov();
        this.v = getIntent().getStringExtra("magic_pass_info");
        this.w = getIntent().getStringExtra("mticket_info");
        String stringExtra = getIntent().getStringExtra("route_info_extra");
        RouteInfo routeInfo = stringExtra != null ? (RouteInfo) hj1.s(stringExtra, RouteInfo.class) : null;
        if (getIntent() != null) {
            this.t = getIntent().getStringExtra("src");
        }
        if (getIntent() != null) {
            this.t = getIntent().getStringExtra("src");
        }
        this.r = routeInfo;
        this.s = getIntent().getStringExtra("productId");
        if (!TextUtils.isEmpty(this.v)) {
            this.m = ov.r(this.v);
        }
        if (!TextUtils.isEmpty(this.w)) {
            this.n = this.u.q(this.w);
        }
        h0();
        MPass mPass = this.m;
        if (mPass != null) {
            ed1 ed1 = new ed1("user details screen open", Long.MIN_VALUE);
            ed1.a("passengerType", mPass.getPassengerType());
            ed1.a("startDate", jh1.c(this.m.getStartingTime()));
            ed1.a("bookingDate", jh1.c(ui1.Q()));
            ed1.a(SuperPassJsonKeys.FARE, this.m.getFare() + "");
            ed1.a("numDays", this.m.getNoOfDays() + "");
            hj1.K0(ed1, "src", this.t, ed1);
        }
    }

    public final void h0() {
        MPass mPass = this.m;
        if (mPass != null) {
            this.p = mPass.getAgency();
            this.q = this.m.getPassengerType();
            k0();
        } else {
            MTicket mTicket = this.n;
            if (mTicket != null) {
                this.p = mTicket.getAgency();
                k0();
            }
        }
        if (getFragmentManager().findFragmentByTag("profile_tag") != null) {
            this.l = (UserDetailsFragment) getFragmentManager().findFragmentByTag("profile_tag");
        }
        if (this.l == null) {
            this.l = new UserDetailsFragment();
            getFragmentManager().beginTransaction().add(R.id.fragment_container_frame, this.l, "profile_tag").commit();
            this.l.setRetainInstance(true);
            Bundle bundle = new Bundle();
            MPass mPass2 = this.m;
            if (mPass2 != null) {
                bundle.putString("magic_pass_info", ov.f(mPass2));
            } else {
                MTicket mTicket2 = this.n;
                if (mTicket2 != null) {
                    bundle.putString("mticket_info", this.u.e(mTicket2));
                }
            }
            if (this.r != null) {
                bundle.putString("route_info_extra", new Gson().toJson(this.r));
            }
            bundle.putString("productId", this.s);
            bundle.putStringArrayList("productIds", getIntent().getStringArrayListExtra("productIds"));
            this.l.setArguments(bundle);
            this.l.N = x;
            x = null;
        }
        MPass mPass3 = this.m;
        if (mPass3 == null || mPass3.getAgency() == null || xt.f3961a.L().e() == null) {
            MTicket mTicket3 = this.n;
            if (mTicket3 != null && mTicket3.getAgency() != null && xt.f3961a.L().e() != null) {
                l0();
                j0();
                return;
            }
            return;
        }
        l0();
        j0();
    }

    public final void j0() {
        this.l.n(xt.f3961a.L().e());
        this.l.l(true);
        getSupportActionBar().z(getString(R.string.enter_user_details));
        this.l.j(true);
        getSupportActionBar().t(R.drawable.abc_ic_ab_back_material);
    }

    public final void k0() {
        String str = this.p;
        for (Agency agency : xt.f3961a.k().d().getModeAgencyMap().get(TransitMode.bus)) {
            if (agency.getAgencyName().equalsIgnoreCase(str)) {
                this.o = agency;
            }
        }
    }

    public final void l0() {
        ProductCategory productCategory;
        ProductConfiguration productConfiguration;
        ProfileRequestAgencyInfo agencyInfo;
        ArrayList arrayList = new ArrayList();
        UserProfile e = xt.f3961a.L().e();
        ProfileRequestInfo profileRequestInfo = this.l.N;
        Map<String, String> originalProofs = (profileRequestInfo == null || (agencyInfo = profileRequestInfo.getAgencyInfo()) == null) ? null : agencyInfo.getOriginalProofs();
        MPass mPass = this.m;
        if (mPass != null) {
            productConfiguration = vn.m0(mPass.getConfigId());
            productCategory = vn.k0(productConfiguration.getProductCategoryList(), this.m.getPassengerType());
        } else {
            MTicket mTicket = this.n;
            if (mTicket != null) {
                productConfiguration = vn.m0(mTicket.getMTicketConfiguration().getId());
                productCategory = productConfiguration.getProductCategoryList().get(0);
            } else {
                productConfiguration = null;
                productCategory = null;
            }
        }
        if (!(productConfiguration == null || productCategory == null)) {
            String documentDescription = productCategory.getDocumentDescription();
            List<String> categoryProofsList = productCategory.getCategoryProofsList();
            if (categoryProofsList == null || categoryProofsList.size() <= 0) {
                arrayList.add(new ProofViewInfo("PHOTOGRAPH", null));
            } else {
                for (String str : categoryProofsList) {
                    if (e != null) {
                        arrayList.add(new ProofViewInfo(str, originalProofs != null ? originalProofs.get(str) : null));
                    }
                }
            }
            new ArrayList();
            HashMap hashMap = new HashMap();
            Agency agency = this.o;
            if (!(agency == null || agency.getProofDocumentGroups() == null)) {
                for (String str2 : this.o.getProofDocumentGroups().keySet()) {
                    Set<String> set = this.o.getProofDocumentGroups().get(str2);
                    if (set != null) {
                        for (String str3 : set) {
                            if (str3 != null) {
                                hashMap.put(str3, str2);
                            }
                        }
                    }
                }
            }
            this.l.k(this.o, documentDescription, arrayList, xt.f3961a.c().p());
        }
    }

    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // androidx.activity.ComponentActivity, defpackage.t4.b, defpackage.ve
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }
}
