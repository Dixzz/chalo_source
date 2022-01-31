package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.models.City;
import app.zophop.models.TransitMode;
import app.zophop.ui.activities.AlertsListActivity;
import app.zophop.ui.activities.CitySelectionActivity;
import app.zophop.ui.activities.FavoriteListActivity;
import app.zophop.ui.activities.LanguageSelectionActivity;
import app.zophop.ui.activities.NearbyStopsActivity;
import app.zophop.ui.activities.ProductHistoryActivity;
import app.zophop.ui.activities.SchedulerActivity;
import app.zophop.ui.activities.UserProfileActivity;
import app.zophop.ui.activities.WebViewActivity;
import app.zophop.ui.activities.ZophopSosActivity;
import app.zophop.ui.activities.cardRecharge.OnlineCardRechargeHistoryActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import com.crashlytics.android.answers.InviteEvent;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.Freshchat;
import com.razorpay.AnalyticsConstants;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: op0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class op0 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ HomeScreenMainFragment f;

    public /* synthetic */ op0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f = homeScreenMainFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str;
        Intent intent;
        HomeScreenMainFragment homeScreenMainFragment = this.f;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        T t = homeScreenMainFragment.f;
        n86.c(t);
        Object item = ((cy) t).n.getAdapter().getItem(i);
        Objects.requireNonNull(item, "null cannot be cast to non-null type app.zophop.ui.adapters.HomeDrawerOption");
        int ordinal = ((qj0) item).ordinal();
        Intent intent2 = null;
        intent2 = null;
        String str2 = null;
        intent2 = null;
        intent2 = null;
        if (ordinal == 0) {
            ed1 l = hj1.l("home screen profile", Long.MIN_VALUE, "source", "home screen drawer");
            l.a("isLoggedIn", xt.f3961a.L().m() + "");
            ui1.m0(l);
            ve activity = homeScreenMainFragment.c();
            int i2 = UserProfileActivity.x;
            Intent intent3 = new Intent(activity, UserProfileActivity.class);
            intent3.putExtra("profile_state", false);
            activity.startActivityForResult(intent3, 1122);
        } else if (ordinal == 8) {
            hj1.P0("transit purchase history clicked", Long.MIN_VALUE, "source", "home screen drawer");
            xt.f3961a.j().a();
            intent2 = new Intent(homeScreenMainFragment.getContext(), ProductHistoryActivity.class);
            intent2.putExtra("source", "home screen drawer");
        } else if (ordinal == 10) {
            ed1 ed1 = new ed1("home screen favorite button clicked", Long.MIN_VALUE);
            ed1.a("source", "home screen drawer");
            ui1.m0(ed1);
            intent2 = new Intent(homeScreenMainFragment.getContext(), FavoriteListActivity.class);
        } else if (ordinal == 15) {
            ed1 ed12 = new ed1("sos screen open", Long.MIN_VALUE);
            ed12.a("source", "home screen drawer");
            ui1.m0(ed12);
            intent2 = new Intent(homeScreenMainFragment.getContext(), ZophopSosActivity.class);
        } else if (ordinal == 28) {
            ed1 ed13 = new ed1("terms and conditions clicked", Long.MIN_VALUE);
            ed13.a("source", "home screen drawer");
            ui1.m0(ed13);
            intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse("https://www.chalo.com/terms-of-use"));
        } else if (ordinal == 3) {
            ed1 ed14 = new ed1("home screen check schedules clicked", Long.MIN_VALUE);
            ed14.a("source", "home screen drawer");
            ui1.m0(ed14);
            intent2 = new Intent(homeScreenMainFragment.getContext(), SchedulerActivity.class);
        } else if (ordinal == 4) {
            hj1.P0("home screen nearby stops clicked", Long.MIN_VALUE, "source", "home screen drawer");
            TransitMode transitMode = TransitMode.bus;
            Context context = homeScreenMainFragment.getContext();
            Float f2 = NearbyStopsActivity.Y;
            Intent intent4 = new Intent(context, NearbyStopsActivity.class);
            intent4.putExtra("nearby:mode", transitMode.toString());
            intent2 = intent4;
        } else if (ordinal == 12) {
            ed1 ed15 = new ed1("alert screen open", Long.MIN_VALUE);
            ed15.a("source", "home screen drawer");
            ui1.m0(ed15);
            intent2 = new Intent(homeScreenMainFragment.getContext(), AlertsListActivity.class);
        } else if (ordinal == 13) {
            ve activity2 = homeScreenMainFragment.c();
            ArrayList arrayList = new ArrayList();
            String C = hj1.C(xt.f3961a);
            if (C != null) {
                arrayList.add(C);
            }
            arrayList.add("commontag");
            Freshchat.showFAQs(activity2, new FaqOptions().showFaqCategoriesAsGrid(false).filterByTags(arrayList, "Help and Support", FaqOptions.FilterType.CATEGORY));
            jz5.b().g(hj1.l("chat screen", Long.MIN_VALUE, "source", "home screen drawer"));
        } else if (ordinal == 36) {
            FragmentManager parentFragmentManager = homeScreenMainFragment.getParentFragmentManager();
            n86.d(parentFragmentManager, "parentFragmentManager");
            Context requireContext = homeScreenMainFragment.requireContext();
            n86.d(requireContext, "requireContext()");
            n86.e(parentFragmentManager, "fragmentManager");
            n86.e(requireContext, AnalyticsConstants.CONTEXT);
            eu0 eu0 = new eu0(requireContext);
            eu0.setStyle(0, 16973838);
            eu0.show(parentFragmentManager, (String) null);
        } else if (ordinal != 37) {
            switch (ordinal) {
                case 17:
                    ed1 ed16 = new ed1("change city pressed", Long.MIN_VALUE);
                    ed16.a("source", "home screen drawer");
                    ui1.m0(ed16);
                    intent2 = new Intent(homeScreenMainFragment.getContext(), CitySelectionActivity.class);
                    break;
                case 18:
                    hj1.P0("line map opened", Long.MIN_VALUE, "source", "home screen drawer");
                    xt.t1 t1Var = xt.f3961a;
                    City d = t1Var.k().d();
                    n86.c(d);
                    if (d.getModes().contains(TransitMode.train) || d.getModes().contains(TransitMode.metro)) {
                        str = homeScreenMainFragment.getString(R.string.drawer_train_map);
                        n86.d(str, "{\n                      …ap)\n                    }");
                    } else {
                        str = homeScreenMainFragment.getString(R.string.busMapCopy);
                        n86.d(str, "{\n                      …py)\n                    }");
                    }
                    f20 t2 = t1Var.t();
                    String name = d.getName();
                    n86.d(name, "lCity.name");
                    String lowerCase = name.toLowerCase();
                    n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
                    String f3 = t2.f(n86.j(lowerCase, "MapCopy"));
                    n86.d(f3, "lLineMapCopy");
                    if (f3.length() > 0) {
                        Resources resources = homeScreenMainFragment.getResources();
                        Context context2 = homeScreenMainFragment.getContext();
                        if (context2 != null) {
                            str2 = context2.getPackageName();
                        }
                        str = homeScreenMainFragment.getString(resources.getIdentifier(f3, "string", str2));
                        n86.d(str, "getString(lResourceId)");
                    }
                    if (d.getLineMaps().isEmpty()) {
                        intent = WebViewActivity.i0(homeScreenMainFragment.getContext(), d.getBusMapUrl(), str, true, false);
                    } else {
                        City d2 = t1Var.k().d();
                        n86.c(d2);
                        City.LineMap lineMap = d2.getLineMaps().get(0);
                        n86.d(lineMap, "cityProvider.currentCity!!.lineMaps.get(0)");
                        intent = WebViewActivity.i0(homeScreenMainFragment.getContext(), lineMap.getUrl(), str, true, false);
                    }
                    intent2 = intent;
                    break;
                case 19:
                    ed1 ed17 = new ed1("change language pressed", Long.MIN_VALUE);
                    ed17.a("source", "home screen drawer");
                    ui1.m0(ed17);
                    intent2 = new Intent(homeScreenMainFragment.getContext(), LanguageSelectionActivity.class);
                    break;
                case 20:
                    hj1.P0(InviteEvent.TYPE, Long.MIN_VALUE, "source", "home screen drawer");
                    ve activity3 = homeScreenMainFragment.c();
                    String packageName = activity3.getPackageName();
                    Intent intent5 = new Intent("android.intent.action.SEND");
                    intent5.putExtra("android.intent.extra.SUBJECT", activity3.getString(R.string.zophop_recommend_subject));
                    intent5.putExtra("android.intent.extra.TEXT", String.format(activity3.getString(R.string.zophop_recommend_text), xt.f3961a.P().a(packageName)));
                    intent5.setType("text/plain");
                    activity3.startActivity(Intent.createChooser(intent5, activity3.getString(R.string.invite_friend)));
                    break;
                default:
                    return;
            }
        } else {
            hj1.P0("ocr card payments homescreen drawer clicked", Long.MIN_VALUE, "source", "sourceHomeScreen");
            Context requireContext2 = homeScreenMainFragment.requireContext();
            n86.d(requireContext2, "requireContext()");
            OnlineCardRechargeHistoryActivity.u0("homeScreen", requireContext2);
            return;
        }
        if (intent2 != null) {
            homeScreenMainFragment.startActivity(intent2);
        }
    }
}
