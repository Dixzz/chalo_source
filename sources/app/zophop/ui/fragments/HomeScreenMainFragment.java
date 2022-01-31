package app.zophop.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import app.zophop.R;
import app.zophop.models.CardInfo;
import app.zophop.models.City;
import app.zophop.models.CityAvailability;
import app.zophop.models.RouteWithoutTimings;
import app.zophop.models.SeatInfo;
import app.zophop.models.Stop;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import app.zophop.pubsub.eventbus.events.CardInfoFetchEvent;
import app.zophop.pubsub.eventbus.events.CheckedinEvent;
import app.zophop.pubsub.eventbus.events.DatabaseSyncEvent;
import app.zophop.pubsub.eventbus.events.DestinationEvent;
import app.zophop.pubsub.eventbus.events.DisruptionEvent;
import app.zophop.pubsub.eventbus.events.ETAEvent;
import app.zophop.pubsub.eventbus.events.NearbyStopTripEvent;
import app.zophop.pubsub.eventbus.events.ProductConfigurationFetchedEvent;
import app.zophop.pubsub.eventbus.events.SeatAvailabilityStatusEvent;
import app.zophop.pubsub.eventbus.events.TransactionsFetchedOnlineEvent;
import app.zophop.pubsub.eventbus.events.TripPlannerEvent;
import app.zophop.pubsub.eventbus.events.UpdateEvent;
import app.zophop.service.LocationTrackingService;
import app.zophop.ui.activities.ForceUpdateActivity;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.activities.WebViewActivity;
import app.zophop.ui.views.summary_card.CardItem;
import app.zophop.utilities.models.InAppMessageDetails;
import app.zophop.utils.URLSpanNoUnderLine;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.android.gms.location.LocationRequest;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textview.MaterialTextView;
import de.hdodenhof.circleimageview.CircleImageView;
import defpackage.d81;
import defpackage.km0;
import defpackage.xt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: HomeScreenMainFragment.kt */
public final class HomeScreenMainFragment extends rl0<cy> {
    public static final a v = new a(null);
    public final j56 g = hd3.a2(new j(this));
    public final j56 h = hd3.a2(new n(this));
    public final j56 i = hd3.a2(new h(this));
    public pj0 j;
    public final j56 k = defpackage.h.B(this, z86.a(d81.class), new l(new k(this)), null);
    public rc1 l;
    public final r<Intent> m;
    public final j56 n;
    public final r<String> o;
    public final r<Intent> p;
    public final j56 q;
    public final j56 r;
    public final j56 s;
    public final j56 t;
    public final j56 u;

    /* compiled from: HomeScreenMainFragment.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* compiled from: HomeScreenMainFragment.kt */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f308a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c = {1, 2, 3};

        static {
            qj0.values();
            int[] iArr = new int[38];
            qj0 qj0 = qj0.MY_PROFILE;
            iArr[0] = 1;
            qj0 qj02 = qj0.CHANGE_CITY;
            iArr[17] = 2;
            qj0 qj03 = qj0.CHANGE_LANG;
            iArr[19] = 3;
            qj0 qj04 = qj0.PASS_TICKET_HISTORY;
            iArr[8] = 4;
            qj0 qj05 = qj0.CARD_RECHARGES;
            iArr[37] = 5;
            qj0 qj06 = qj0.TRAIN_MAP;
            iArr[18] = 6;
            qj0 qj07 = qj0.CHAT;
            iArr[13] = 7;
            qj0 qj08 = qj0.NEARBY_STOPS;
            iArr[4] = 8;
            qj0 qj09 = qj0.SCHEDULER;
            iArr[3] = 9;
            qj0 qj010 = qj0.ALERT;
            iArr[12] = 10;
            qj0 qj011 = qj0.FAVORITES;
            iArr[10] = 11;
            qj0 qj012 = qj0.INVITE;
            iArr[20] = 12;
            qj0 qj013 = qj0.SOS;
            iArr[15] = 13;
            qj0 qj014 = qj0.TERMS;
            iArr[28] = 14;
            qj0 qj015 = qj0.CHANGE_ENVIRONMENT;
            iArr[36] = 15;
            f308a = iArr;
            CheckedinEvent.STATE.values();
            int[] iArr2 = new int[3];
            CheckedinEvent.STATE state = CheckedinEvent.STATE.STOP;
            iArr2[1] = 1;
            CheckedinEvent.STATE state2 = CheckedinEvent.STATE.START;
            iArr2[0] = 2;
            b = iArr2;
            CheckedinEvent.STOP_SOURCE.values();
            CheckedinEvent.STOP_SOURCE stop_source = CheckedinEvent.STOP_SOURCE.SERVER;
            CheckedinEvent.STOP_SOURCE stop_source2 = CheckedinEvent.STOP_SOURCE.USER;
            CheckedinEvent.STOP_SOURCE stop_source3 = CheckedinEvent.STOP_SOURCE.PROXIMITY;
        }
    }

    /* compiled from: HomeScreenMainFragment.kt */
    public static final class c extends o86 implements h76<pa1> {
        public final /* synthetic */ HomeScreenMainFragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(HomeScreenMainFragment homeScreenMainFragment) {
            super(0);
            this.f = homeScreenMainFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public pa1 invoke() {
            Context requireContext = this.f.requireContext();
            n86.d(requireContext, "requireContext()");
            zx zxVar = HomeScreenMainFragment.g(this.f).g;
            n86.d(zxVar, "viewBinding.homeCheckInCardContainer");
            HomeScreenMainFragment homeScreenMainFragment = this.f;
            Objects.requireNonNull(homeScreenMainFragment);
            return new pa1(requireContext, zxVar, new er0(homeScreenMainFragment));
        }
    }

    /* compiled from: HomeScreenMainFragment.kt */
    public static final class d extends o86 implements h76<Handler> {
        public static final d f = new d();

        public d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public Handler invoke() {
            return new Handler();
        }
    }

    /* compiled from: HomeScreenMainFragment.kt */
    public static final class e extends o86 implements h76<ah1> {
        public final /* synthetic */ HomeScreenMainFragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(HomeScreenMainFragment homeScreenMainFragment) {
            super(0);
            this.f = homeScreenMainFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ah1 invoke() {
            return new ah1(this.f.c(), xt.f3961a.B().a());
        }
    }

    /* compiled from: HomeScreenMainFragment.kt */
    public static final class f extends o86 implements h76<oq4> {
        public final /* synthetic */ HomeScreenMainFragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(HomeScreenMainFragment homeScreenMainFragment) {
            super(0);
            this.f = homeScreenMainFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oq4 invoke() {
            hr4 hr4;
            Context requireContext = this.f.requireContext();
            synchronized (hd3.class) {
                if (hd3.c == null) {
                    Context applicationContext = requireContext.getApplicationContext();
                    if (applicationContext != null) {
                        requireContext = applicationContext;
                    }
                    tq4 tq4 = new tq4(requireContext);
                    hd3.y1(tq4, tq4.class);
                    hd3.c = new hr4(tq4);
                }
                hr4 = hd3.c;
            }
            oq4 a2 = hr4.f.a();
            n86.d(a2, "create(\n            requireContext()\n        )");
            return a2;
        }
    }

    @y66(c = "app.zophop.ui.fragments.HomeScreenMainFragment$onViewCreated$1", f = "HomeScreenMainFragment.kt", l = {258, 260}, m = "invokeSuspend")
    /* compiled from: HomeScreenMainFragment.kt */
    public static final class g extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public int f;
        public final /* synthetic */ HomeScreenMainFragment g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(HomeScreenMainFragment homeScreenMainFragment, k66<? super g> k66) {
            super(2, k66);
            this.g = homeScreenMainFragment;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new g(this.g, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            return new g(this.g, k66).invokeSuspend(s56.f3190a);
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            s56 s56 = s56.f3190a;
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i = this.f;
            if (i == 0) {
                hd3.Y2(obj);
                HomeScreenMainFragment homeScreenMainFragment = this.g;
                a aVar = HomeScreenMainFragment.v;
                d81 o = homeScreenMainFragment.o();
                this.f = 1;
                Objects.requireNonNull(o);
                Object j3 = hd3.j3(defpackage.h.Z(o).n().plus(xb6.c).plus(new lh1(CoroutineExceptionHandler.a.f)), new n81(o, null), this);
                if (j3 != p66) {
                    j3 = s56;
                }
                if (j3 == p66) {
                    return p66;
                }
            } else if (i == 1) {
                hd3.Y2(obj);
            } else if (i == 2) {
                hd3.Y2(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            HomeScreenMainFragment homeScreenMainFragment2 = this.g;
            a aVar2 = HomeScreenMainFragment.v;
            Objects.requireNonNull(homeScreenMainFragment2);
            xt.t1 t1Var = xt.f3961a;
            if (!t1Var.l().h.has("seatOccupancyDialogShown")) {
                City d = t1Var.k().d();
                n86.c(d);
                String name = d.getName();
                n86.d(name, "cityProvider.currentCity!!.name");
                String lowerCase = name.toLowerCase();
                n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
                String str = (String) t1Var.l().get(n86.j("shouldShowSeatOccupancyDialogHomescreen", lowerCase));
                if (str == null || !n86.a(str, "false")) {
                    i20 o2 = t1Var.o();
                    HomeActivity.a aVar3 = HomeActivity.k;
                    o2.b("Home Screen", new rn0(65, new mp0(homeScreenMainFragment2)));
                }
            }
            HomeScreenMainFragment homeScreenMainFragment3 = this.g;
            this.f = 2;
            return HomeScreenMainFragment.f(homeScreenMainFragment3, this) == p66 ? p66 : s56;
        }
    }

    /* compiled from: HomeScreenMainFragment.kt */
    public static final class h extends o86 implements h76<rj0> {
        public final /* synthetic */ HomeScreenMainFragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(HomeScreenMainFragment homeScreenMainFragment) {
            super(0);
            this.f = homeScreenMainFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public rj0 invoke() {
            Context requireContext = this.f.requireContext();
            n86.d(requireContext, "requireContext()");
            return new rj0(requireContext);
        }
    }

    /* compiled from: HomeScreenMainFragment.kt */
    public static final class i extends o86 implements h76<w76<? super String, ? super String, ? extends s56>> {
        public final /* synthetic */ HomeScreenMainFragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(HomeScreenMainFragment homeScreenMainFragment) {
            super(0);
            this.f = homeScreenMainFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public w76<? super String, ? super String, ? extends s56> invoke() {
            return new qu0(this.f);
        }
    }

    /* compiled from: HomeScreenMainFragment.kt */
    public static final class j extends o86 implements h76<bk0> {
        public final /* synthetic */ HomeScreenMainFragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(HomeScreenMainFragment homeScreenMainFragment) {
            super(0);
            this.f = homeScreenMainFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public bk0 invoke() {
            Context requireContext = this.f.requireContext();
            n86.d(requireContext, "requireContext()");
            return new bk0(requireContext, new su0(this.f));
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    public static final class k extends o86 implements h76<Fragment> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(Fragment fragment) {
            super(0);
            this.f = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public Fragment invoke() {
            return this.f;
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    public static final class l extends o86 implements h76<gi> {
        public final /* synthetic */ h76 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(h76 h76) {
            super(0);
            this.f = h76;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public gi invoke() {
            gi viewModelStore = ((hi) this.f.invoke()).getViewModelStore();
            n86.d(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    /* compiled from: HomeScreenMainFragment.kt */
    public static final class m extends o86 implements h76<Timer> {
        public static final m f = new m();

        public m() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public Timer invoke() {
            return new Timer();
        }
    }

    /* compiled from: HomeScreenMainFragment.kt */
    public static final class n extends o86 implements h76<dl0> {
        public final /* synthetic */ HomeScreenMainFragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(HomeScreenMainFragment homeScreenMainFragment) {
            super(0);
            this.f = homeScreenMainFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public dl0 invoke() {
            Context requireContext = this.f.requireContext();
            n86.d(requireContext, "requireContext()");
            return new dl0(requireContext, new yu0(this.f), true, "Home Screen");
        }
    }

    public HomeScreenMainFragment() {
        r<Intent> registerForActivityResult = registerForActivityResult(new w(), hq0.f1411a);
        n86.d(registerForActivityResult, "registerForActivityResul…rtActivityForResult()) {}");
        this.m = registerForActivityResult;
        this.n = hd3.a2(new e(this));
        r<String> registerForActivityResult2 = registerForActivityResult(new v(), new ip0(this));
        n86.d(registerForActivityResult2, "registerForActivityResul…\n            }\n\n        }");
        this.o = registerForActivityResult2;
        r<Intent> registerForActivityResult3 = registerForActivityResult(new w(), new pp0(this));
        n86.d(registerForActivityResult3, "registerForActivityResul…}\n            }\n        }");
        this.p = registerForActivityResult3;
        this.q = hd3.a2(new f(this));
        this.r = hd3.a2(m.f);
        this.s = hd3.a2(d.f);
        this.t = hd3.a2(new c(this));
        this.u = hd3.a2(new i(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object f(app.zophop.ui.fragments.HomeScreenMainFragment r7, defpackage.k66 r8) {
        /*
        // Method dump skipped, instructions count: 160
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.fragments.HomeScreenMainFragment.f(app.zophop.ui.fragments.HomeScreenMainFragment, k66):java.lang.Object");
    }

    public static final cy g(HomeScreenMainFragment homeScreenMainFragment) {
        T t2 = homeScreenMainFragment.f;
        n86.c(t2);
        return (cy) t2;
    }

    public static final void h(HomeScreenMainFragment homeScreenMainFragment) {
        Objects.requireNonNull(homeScreenMainFragment);
        try {
            ui1.m0(new ed1("redirected to play store", Long.MIN_VALUE));
            Context context = homeScreenMainFragment.getContext();
            String j2 = n86.j("https://play.google.com/store/apps/details?id=", context == null ? null : context.getPackageName());
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(j2));
            intent.setPackage("com.android.vending");
            homeScreenMainFragment.startActivity(intent);
        } catch (Exception e2) {
            e2.toString();
            b00 b00 = b00.f358a;
            b00.a().b(e2);
        }
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.rl0
    public cy e() {
        View inflate = getLayoutInflater().inflate(R.layout.home_screen_main_fragment, (ViewGroup) null, false);
        MaterialCardView materialCardView = (MaterialCardView) inflate.findViewById(R.id.disruption_card);
        int i2 = R.id.divider_product_list;
        if (materialCardView != null) {
            MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.disruption_message);
            if (materialTextView != null) {
                ShapeableImageView shapeableImageView = (ShapeableImageView) inflate.findViewById(R.id.disruption_message_close);
                if (shapeableImageView != null) {
                    View findViewById = inflate.findViewById(R.id.divider_home_screen_mumbai_card_recent_searches);
                    if (findViewById != null) {
                        View findViewById2 = inflate.findViewById(R.id.divider_product_list);
                        if (findViewById2 != null) {
                            View findViewById3 = inflate.findViewById(R.id.divider_recent_searches);
                            if (findViewById3 != null) {
                                View findViewById4 = inflate.findViewById(R.id.divider_your_plans);
                                if (findViewById4 != null) {
                                    DrawerLayout drawerLayout = (DrawerLayout) inflate;
                                    View findViewById5 = inflate.findViewById(R.id.home_check_in_card_container);
                                    if (findViewById5 != null) {
                                        int i3 = R.id.bottom_container;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById5.findViewById(R.id.bottom_container);
                                        if (constraintLayout != null) {
                                            i3 = R.id.check_in_card;
                                            MaterialCardView materialCardView2 = (MaterialCardView) findViewById5.findViewById(R.id.check_in_card);
                                            if (materialCardView2 != null) {
                                                i3 = R.id.check_in_card_heading;
                                                View findViewById6 = findViewById5.findViewById(R.id.check_in_card_heading);
                                                if (findViewById6 != null) {
                                                    ay b2 = ay.b(findViewById6);
                                                    i3 = R.id.destination_view;
                                                    View findViewById7 = findViewById5.findViewById(R.id.destination_view);
                                                    if (findViewById7 != null) {
                                                        tw b3 = tw.b(findViewById7);
                                                        i3 = R.id.divider_check_in_card;
                                                        View findViewById8 = findViewById5.findViewById(R.id.divider_check_in_card);
                                                        if (findViewById8 != null) {
                                                            i3 = R.id.end_trip;
                                                            MaterialTextView materialTextView2 = (MaterialTextView) findViewById5.findViewById(R.id.end_trip);
                                                            if (materialTextView2 != null) {
                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById5;
                                                                i3 = R.id.next_stop_view;
                                                                View findViewById9 = findViewById5.findViewById(R.id.next_stop_view);
                                                                if (findViewById9 != null) {
                                                                    tw b4 = tw.b(findViewById9);
                                                                    i3 = R.id.share_trip;
                                                                    MaterialTextView materialTextView3 = (MaterialTextView) findViewById5.findViewById(R.id.share_trip);
                                                                    if (materialTextView3 != null) {
                                                                        i3 = R.id.view5;
                                                                        View findViewById10 = findViewById5.findViewById(R.id.view5);
                                                                        if (findViewById10 != null) {
                                                                            i3 = R.id.view6;
                                                                            View findViewById11 = findViewById5.findViewById(R.id.view6);
                                                                            if (findViewById11 != null) {
                                                                                zx zxVar = new zx(constraintLayout2, constraintLayout, materialCardView2, b2, b3, findViewById8, materialTextView2, constraintLayout2, b4, materialTextView3, findViewById10, findViewById11);
                                                                                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate.findViewById(R.id.home_screen_main_container);
                                                                                if (coordinatorLayout != null) {
                                                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) inflate.findViewById(R.id.home_screen_map_container);
                                                                                    if (constraintLayout3 != null) {
                                                                                        MaterialCardView materialCardView3 = (MaterialCardView) inflate.findViewById(R.id.home_screen_map_fragment_container);
                                                                                        if (materialCardView3 != null) {
                                                                                            View findViewById12 = inflate.findViewById(R.id.home_screen_map_heading);
                                                                                            if (findViewById12 != null) {
                                                                                                ay b5 = ay.b(findViewById12);
                                                                                                View findViewById13 = inflate.findViewById(R.id.home_screen_map_overlay);
                                                                                                if (findViewById13 != null) {
                                                                                                    View findViewById14 = inflate.findViewById(R.id.home_screen_mumbai_bottom_card);
                                                                                                    if (findViewById14 != null) {
                                                                                                        ey b6 = ey.b(findViewById14);
                                                                                                        View findViewById15 = inflate.findViewById(R.id.home_screen_mumbai_card);
                                                                                                        if (findViewById15 != null) {
                                                                                                            ey b7 = ey.b(findViewById15);
                                                                                                            Group group = (Group) inflate.findViewById(R.id.home_screen_mumbai_card_group);
                                                                                                            if (group != null) {
                                                                                                                ListView listView = (ListView) inflate.findViewById(R.id.left_drawer);
                                                                                                                if (listView != null) {
                                                                                                                    View findViewById16 = inflate.findViewById(R.id.loading_screen);
                                                                                                                    if (findViewById16 != null) {
                                                                                                                        ky b8 = ky.b(findViewById16);
                                                                                                                        MaterialCardView materialCardView4 = (MaterialCardView) inflate.findViewById(R.id.nearby_cards);
                                                                                                                        if (materialCardView4 != null) {
                                                                                                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) inflate.findViewById(R.id.nearest_bus_stop_container);
                                                                                                                            if (constraintLayout4 != null) {
                                                                                                                                View findViewById17 = inflate.findViewById(R.id.nearest_bus_stop_heading);
                                                                                                                                if (findViewById17 != null) {
                                                                                                                                    by b9 = by.b(findViewById17);
                                                                                                                                    View findViewById18 = inflate.findViewById(R.id.nearest_bus_stop_skeleton_loader);
                                                                                                                                    if (findViewById18 != null) {
                                                                                                                                        int i4 = R.id.nearby_stop_trip_card_header;
                                                                                                                                        LinearLayout linearLayout = (LinearLayout) findViewById18.findViewById(R.id.nearby_stop_trip_card_header);
                                                                                                                                        int i5 = R.id.skeleton_header;
                                                                                                                                        if (linearLayout != null) {
                                                                                                                                            LinearLayout linearLayout2 = (LinearLayout) findViewById18.findViewById(R.id.nearby_stop_trip_card_skeleton);
                                                                                                                                            if (linearLayout2 != null) {
                                                                                                                                                View findViewById19 = findViewById18.findViewById(R.id.new_nearby_first_div);
                                                                                                                                                if (findViewById19 != null) {
                                                                                                                                                    ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) findViewById18.findViewById(R.id.shimmer_view_container);
                                                                                                                                                    if (shimmerFrameLayout != null) {
                                                                                                                                                        View findViewById20 = findViewById18.findViewById(R.id.skeleton_header);
                                                                                                                                                        if (findViewById20 != null) {
                                                                                                                                                            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) findViewById20;
                                                                                                                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) findViewById18;
                                                                                                                                                            ny nyVar = new ny(constraintLayout5, linearLayout, linearLayout2, findViewById19, shimmerFrameLayout, new iy(shimmerFrameLayout2, shimmerFrameLayout2), constraintLayout5);
                                                                                                                                                            MaterialCardView materialCardView5 = (MaterialCardView) inflate.findViewById(R.id.partner_card);
                                                                                                                                                            if (materialCardView5 != null) {
                                                                                                                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) inflate.findViewById(R.id.partner_card_container);
                                                                                                                                                                if (constraintLayout6 != null) {
                                                                                                                                                                    View findViewById21 = inflate.findViewById(R.id.partner_card_heading);
                                                                                                                                                                    if (findViewById21 != null) {
                                                                                                                                                                        ay b10 = ay.b(findViewById21);
                                                                                                                                                                        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.product_list);
                                                                                                                                                                        if (recyclerView != null) {
                                                                                                                                                                            ConstraintLayout constraintLayout7 = (ConstraintLayout) inflate.findViewById(R.id.product_list_container);
                                                                                                                                                                            if (constraintLayout7 != null) {
                                                                                                                                                                                View findViewById22 = inflate.findViewById(R.id.product_list_heading);
                                                                                                                                                                                if (findViewById22 != null) {
                                                                                                                                                                                    by b11 = by.b(findViewById22);
                                                                                                                                                                                    View findViewById23 = inflate.findViewById(R.id.product_list_skeleton_loader);
                                                                                                                                                                                    if (findViewById23 != null) {
                                                                                                                                                                                        ShimmerFrameLayout shimmerFrameLayout3 = (ShimmerFrameLayout) findViewById23.findViewById(R.id.shimmer_view_container);
                                                                                                                                                                                        if (shimmerFrameLayout3 != null) {
                                                                                                                                                                                            View findViewById24 = findViewById23.findViewById(R.id.skeleton_header);
                                                                                                                                                                                            if (findViewById24 != null) {
                                                                                                                                                                                                ShimmerFrameLayout shimmerFrameLayout4 = (ShimmerFrameLayout) findViewById24;
                                                                                                                                                                                                iy iyVar = new iy(shimmerFrameLayout4, shimmerFrameLayout4);
                                                                                                                                                                                                ConstraintLayout constraintLayout8 = (ConstraintLayout) findViewById23;
                                                                                                                                                                                                View findViewById25 = findViewById23.findViewById(R.id.view);
                                                                                                                                                                                                if (findViewById25 != null) {
                                                                                                                                                                                                    fy fyVar = new fy(constraintLayout8, shimmerFrameLayout3, iyVar, constraintLayout8, findViewById25);
                                                                                                                                                                                                    CircleImageView circleImageView = (CircleImageView) inflate.findViewById(R.id.profile_and_drawer_icon);
                                                                                                                                                                                                    if (circleImageView != null) {
                                                                                                                                                                                                        ViewPager2 viewPager2 = (ViewPager2) inflate.findViewById(R.id.promotions_card);
                                                                                                                                                                                                        if (viewPager2 != null) {
                                                                                                                                                                                                            ConstraintLayout constraintLayout9 = (ConstraintLayout) inflate.findViewById(R.id.promotions_card_container);
                                                                                                                                                                                                            if (constraintLayout9 != null) {
                                                                                                                                                                                                                RecyclerView recyclerView2 = (RecyclerView) inflate.findViewById(R.id.recent_searches);
                                                                                                                                                                                                                if (recyclerView2 != null) {
                                                                                                                                                                                                                    ConstraintLayout constraintLayout10 = (ConstraintLayout) inflate.findViewById(R.id.recent_searches_container);
                                                                                                                                                                                                                    if (constraintLayout10 != null) {
                                                                                                                                                                                                                        MaterialCardView materialCardView6 = (MaterialCardView) inflate.findViewById(R.id.search_container);
                                                                                                                                                                                                                        if (materialCardView6 != null) {
                                                                                                                                                                                                                            ImageView imageView = (ImageView) inflate.findViewById(R.id.search_icon);
                                                                                                                                                                                                                            if (imageView != null) {
                                                                                                                                                                                                                                MaterialTextView materialTextView4 = (MaterialTextView) inflate.findViewById(R.id.search_route_stop_trip);
                                                                                                                                                                                                                                if (materialTextView4 != null) {
                                                                                                                                                                                                                                    TabLayout tabLayout = (TabLayout) inflate.findViewById(R.id.tab_layout);
                                                                                                                                                                                                                                    if (tabLayout != null) {
                                                                                                                                                                                                                                        AppBarLayout appBarLayout = (AppBarLayout) inflate.findViewById(R.id.toolbar_top_container);
                                                                                                                                                                                                                                        if (appBarLayout != null) {
                                                                                                                                                                                                                                            View findViewById26 = inflate.findViewById(R.id.universal_pass_hook);
                                                                                                                                                                                                                                            if (findViewById26 != null) {
                                                                                                                                                                                                                                                int i6 = R.id.learn_more;
                                                                                                                                                                                                                                                MaterialTextView materialTextView5 = (MaterialTextView) findViewById26.findViewById(R.id.learn_more);
                                                                                                                                                                                                                                                if (materialTextView5 != null) {
                                                                                                                                                                                                                                                    MaterialTextView materialTextView6 = (MaterialTextView) findViewById26.findViewById(R.id.mumbai_home_screen_card_title);
                                                                                                                                                                                                                                                    if (materialTextView6 != null) {
                                                                                                                                                                                                                                                        nz nzVar = new nz((MaterialCardView) findViewById26, materialTextView5, materialTextView6);
                                                                                                                                                                                                                                                        ConstraintLayout constraintLayout11 = (ConstraintLayout) inflate.findViewById(R.id.welcome_container);
                                                                                                                                                                                                                                                        if (constraintLayout11 != null) {
                                                                                                                                                                                                                                                            MaterialTextView materialTextView7 = (MaterialTextView) inflate.findViewById(R.id.welcome_message);
                                                                                                                                                                                                                                                            if (materialTextView7 != null) {
                                                                                                                                                                                                                                                                RecyclerView recyclerView3 = (RecyclerView) inflate.findViewById(R.id.your_plans);
                                                                                                                                                                                                                                                                if (recyclerView3 != null) {
                                                                                                                                                                                                                                                                    ConstraintLayout constraintLayout12 = (ConstraintLayout) inflate.findViewById(R.id.your_plans_container);
                                                                                                                                                                                                                                                                    if (constraintLayout12 != null) {
                                                                                                                                                                                                                                                                        View findViewById27 = inflate.findViewById(R.id.your_plans_heading);
                                                                                                                                                                                                                                                                        if (findViewById27 != null) {
                                                                                                                                                                                                                                                                            by b12 = by.b(findViewById27);
                                                                                                                                                                                                                                                                            View findViewById28 = inflate.findViewById(R.id.your_plans_skeleton_loader);
                                                                                                                                                                                                                                                                            if (findViewById28 != null) {
                                                                                                                                                                                                                                                                                ShimmerFrameLayout shimmerFrameLayout5 = (ShimmerFrameLayout) findViewById28.findViewById(R.id.shimmer_view_container);
                                                                                                                                                                                                                                                                                if (shimmerFrameLayout5 != null) {
                                                                                                                                                                                                                                                                                    View findViewById29 = findViewById28.findViewById(R.id.skeleton_header);
                                                                                                                                                                                                                                                                                    if (findViewById29 != null) {
                                                                                                                                                                                                                                                                                        ShimmerFrameLayout shimmerFrameLayout6 = (ShimmerFrameLayout) findViewById29;
                                                                                                                                                                                                                                                                                        iy iyVar2 = new iy(shimmerFrameLayout6, shimmerFrameLayout6);
                                                                                                                                                                                                                                                                                        ConstraintLayout constraintLayout13 = (ConstraintLayout) findViewById28;
                                                                                                                                                                                                                                                                                        View findViewById30 = findViewById28.findViewById(R.id.view);
                                                                                                                                                                                                                                                                                        if (findViewById30 != null) {
                                                                                                                                                                                                                                                                                            cy cyVar = new cy(drawerLayout, materialCardView, materialTextView, shapeableImageView, findViewById, findViewById2, findViewById3, findViewById4, drawerLayout, zxVar, coordinatorLayout, constraintLayout3, materialCardView3, b5, findViewById13, b6, b7, group, listView, b8, materialCardView4, constraintLayout4, b9, nyVar, materialCardView5, constraintLayout6, b10, recyclerView, constraintLayout7, b11, fyVar, circleImageView, viewPager2, constraintLayout9, recyclerView2, constraintLayout10, materialCardView6, imageView, materialTextView4, tabLayout, appBarLayout, nzVar, constraintLayout11, materialTextView7, recyclerView3, constraintLayout12, b12, new hy(constraintLayout13, shimmerFrameLayout5, iyVar2, constraintLayout13, findViewById30));
                                                                                                                                                                                                                                                                                            n86.d(cyVar, "inflate(layoutInflater)");
                                                                                                                                                                                                                                                                                            return cyVar;
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                        i5 = R.id.view;
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                                                                    i5 = R.id.shimmer_view_container;
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                throw new NullPointerException("Missing required view with ID: ".concat(findViewById28.getResources().getResourceName(i5)));
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                            i2 = R.id.your_plans_skeleton_loader;
                                                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                                                            i2 = R.id.your_plans_heading;
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                                        i2 = R.id.your_plans_container;
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                                                    i2 = R.id.your_plans;
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                i2 = R.id.welcome_message;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                                            i2 = R.id.welcome_container;
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        i6 = R.id.mumbai_home_screen_card_title;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                throw new NullPointerException("Missing required view with ID: ".concat(findViewById26.getResources().getResourceName(i6)));
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            i2 = R.id.universal_pass_hook;
                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                            i2 = R.id.toolbar_top_container;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                        i2 = R.id.tab_layout;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                    i2 = R.id.search_route_stop_trip;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                i2 = R.id.search_icon;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                            i2 = R.id.search_container;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                        i2 = R.id.recent_searches_container;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                    i2 = R.id.recent_searches;
                                                                                                                                                                                                                }
                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                i2 = R.id.promotions_card_container;
                                                                                                                                                                                                            }
                                                                                                                                                                                                        } else {
                                                                                                                                                                                                            i2 = R.id.promotions_card;
                                                                                                                                                                                                        }
                                                                                                                                                                                                    } else {
                                                                                                                                                                                                        i2 = R.id.profile_and_drawer_icon;
                                                                                                                                                                                                    }
                                                                                                                                                                                                } else {
                                                                                                                                                                                                    i5 = R.id.view;
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        } else {
                                                                                                                                                                                            i5 = R.id.shimmer_view_container;
                                                                                                                                                                                        }
                                                                                                                                                                                        throw new NullPointerException("Missing required view with ID: ".concat(findViewById23.getResources().getResourceName(i5)));
                                                                                                                                                                                    }
                                                                                                                                                                                    i2 = R.id.product_list_skeleton_loader;
                                                                                                                                                                                } else {
                                                                                                                                                                                    i2 = R.id.product_list_heading;
                                                                                                                                                                                }
                                                                                                                                                                            } else {
                                                                                                                                                                                i2 = R.id.product_list_container;
                                                                                                                                                                            }
                                                                                                                                                                        } else {
                                                                                                                                                                            i2 = R.id.product_list;
                                                                                                                                                                        }
                                                                                                                                                                    } else {
                                                                                                                                                                        i2 = R.id.partner_card_heading;
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                    i2 = R.id.partner_card_container;
                                                                                                                                                                }
                                                                                                                                                            } else {
                                                                                                                                                                i2 = R.id.partner_card;
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            i4 = R.id.skeleton_header;
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        i4 = R.id.shimmer_view_container;
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    i4 = R.id.new_nearby_first_div;
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                i4 = R.id.nearby_stop_trip_card_skeleton;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        throw new NullPointerException("Missing required view with ID: ".concat(findViewById18.getResources().getResourceName(i4)));
                                                                                                                                    }
                                                                                                                                    i2 = R.id.nearest_bus_stop_skeleton_loader;
                                                                                                                                } else {
                                                                                                                                    i2 = R.id.nearest_bus_stop_heading;
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                i2 = R.id.nearest_bus_stop_container;
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            i2 = R.id.nearby_cards;
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        i2 = R.id.loading_screen;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    i2 = R.id.left_drawer;
                                                                                                                }
                                                                                                            } else {
                                                                                                                i2 = R.id.home_screen_mumbai_card_group;
                                                                                                            }
                                                                                                        } else {
                                                                                                            i2 = R.id.home_screen_mumbai_card;
                                                                                                        }
                                                                                                    } else {
                                                                                                        i2 = R.id.home_screen_mumbai_bottom_card;
                                                                                                    }
                                                                                                } else {
                                                                                                    i2 = R.id.home_screen_map_overlay;
                                                                                                }
                                                                                            } else {
                                                                                                i2 = R.id.home_screen_map_heading;
                                                                                            }
                                                                                        } else {
                                                                                            i2 = R.id.home_screen_map_fragment_container;
                                                                                        }
                                                                                    } else {
                                                                                        i2 = R.id.home_screen_map_container;
                                                                                    }
                                                                                } else {
                                                                                    i2 = R.id.home_screen_main_container;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        throw new NullPointerException("Missing required view with ID: ".concat(findViewById5.getResources().getResourceName(i3)));
                                    }
                                    i2 = R.id.home_check_in_card_container;
                                } else {
                                    i2 = R.id.divider_your_plans;
                                }
                            } else {
                                i2 = R.id.divider_recent_searches;
                            }
                        }
                    } else {
                        i2 = R.id.divider_home_screen_mumbai_card_recent_searches;
                    }
                } else {
                    i2 = R.id.disruption_message_close;
                }
            } else {
                i2 = R.id.disruption_message;
            }
        } else {
            i2 = R.id.disruption_card;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    public final void i() {
        ConstraintLayout constraintLayout = k().b.e;
        n86.d(constraintLayout, "viewBinding.homeCheckInCard");
        constraintLayout.setVisibility(8);
    }

    public final void j() {
        if (ui1.T(getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
            x();
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.o.a("android.permission.ACCESS_FINE_LOCATION", null);
            hj1.P0("permission_popup", Long.MIN_VALUE, "element", "home_location");
        }
    }

    public final pa1 k() {
        return (pa1) this.t.getValue();
    }

    public final oq4 l() {
        return (oq4) this.q.getValue();
    }

    public final w76<String, String, s56> m() {
        return (w76) this.u.getValue();
    }

    public final bk0 n() {
        return (bk0) this.g.getValue();
    }

    public final d81 o() {
        return (d81) this.k.getValue();
    }

    @Override // defpackage.rl0, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((Timer) this.r.getValue()).cancel();
        ((Handler) this.s.getValue()).removeCallbacksAndMessages(null);
        if (o().k != null) {
            xt.f3961a.E().b(o().k);
        }
    }

    public final void onEvent(qd1 qd1) {
        n86.e(qd1, "networkConnectivityEvent");
        boolean z = qd1.f2931a;
        if (z != o().o) {
            if (qd1.f2931a) {
                j();
                s();
                ve activity = c();
                Objects.requireNonNull(activity, "null cannot be cast to non-null type app.zophop.ui.activities.HomeActivity");
                ((HomeActivity) activity).k0();
            } else {
                w();
            }
            o().o = z;
        } else if (!o().o) {
            w();
        }
        jz5.b().m(qd1);
    }

    public final void onEventMainThread(NearbyStopTripEvent nearbyStopTripEvent) {
        n86.e(nearbyStopTripEvent, "event");
        if (!n86.a(nearbyStopTripEvent.getReqId(), o().k)) {
            xt.f3961a.E().b(nearbyStopTripEvent.getReqId());
        } else if (nearbyStopTripEvent.getResponseType() == TripPlannerEvent.ResponseType.SUCCESS) {
            rc1 rc1 = this.l;
            if (rc1 == null) {
                this.l = new rc1(c());
            } else {
                n86.c(rc1);
                if (rc1.getParent() != null) {
                    rc1 rc12 = this.l;
                    n86.c(rc12);
                    ViewParent parent = rc12.getParent();
                    Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                    ((ViewGroup) parent).removeView(this.l);
                }
            }
            HashMap hashMap = new HashMap();
            d81 o2 = o();
            rc1 rc13 = this.l;
            n86.c(rc13);
            Map<String, CardItem> d2 = rc13.d(nearbyStopTripEvent, hashMap);
            n86.d(d2, "nearbyStopTripCard!!.ren…lVehicleNoVehicleInfoMap)");
            Objects.requireNonNull(o2);
            n86.e(d2, "<set-?>");
            o2.l = d2;
            T t2 = this.f;
            n86.c(t2);
            ((cy) t2).p.addView(this.l);
            T t3 = this.f;
            n86.c(t3);
            ((cy) t3).r.b.setText(getString(R.string.nearest_bus_stop));
            T t4 = this.f;
            n86.c(t4);
            ((cy) t4).q.setVisibility(0);
            T t5 = this.f;
            n86.c(t5);
            ((cy) t5).s.b.setVisibility(8);
            boolean z = !o().l().isEmpty();
            xt.t1 t1Var = xt.f3961a;
            t1Var.Z().g(hashMap);
            if (!o().m && z) {
                t1Var.Z().e((Handler) o().n.getValue());
                Runnable a2 = t1Var.Z().a();
                if (a2 != null) {
                    a2.run();
                    o().m = true;
                }
            }
            d81 o3 = o();
            d81.a aVar = d81.a.SUCCESS;
            Objects.requireNonNull(o3);
            n86.e(aVar, "<set-?>");
            o3.j = aVar;
        } else {
            d81 o4 = o();
            d81.a aVar2 = d81.a.FAILURE;
            Objects.requireNonNull(o4);
            n86.e(aVar2, "<set-?>");
            o4.j = aVar2;
            o().r();
        }
        jz5.b().m(nearbyStopTripEvent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
        o().r();
        pj0 pj0 = this.j;
        if (pj0 != null) {
            pj0.notifyDataSetChanged();
            xt.t1 t1Var = xt.f3961a;
            if (t1Var.L().e() != null) {
                T t2 = this.f;
                n86.c(t2);
                ((cy) t2).K.setText(getString(R.string.homescreen_welcome_message_logged_in_user));
                ml1<Drawable> p2 = gl1.f(getContext()).p(t1Var.L().e().getProfilePhoto());
                p2.a(new rs1().j(R.drawable.home_screen_profile_icon));
                T t3 = this.f;
                n86.c(t3);
                p2.e(((cy) t3).A);
            } else {
                T t4 = this.f;
                n86.c(t4);
                ((cy) t4).K.setText(getString(R.string.homescreen_welcome_message_logged_out_user));
                ml1<Drawable> p3 = gl1.f(getContext()).p(Integer.valueOf((int) R.drawable.home_screen_profile_icon));
                p3.a(new rs1().j(R.drawable.home_screen_profile_icon));
                T t5 = this.f;
                n86.c(t5);
                p3.e(((cy) t5).A);
            }
            d81 o2 = o();
            ((oh) o2.s.getValue()).j(o2.k());
            if (o().k != null) {
                t1Var.E().a(o().k, false);
            }
            if (t1Var.L().f()) {
                HashMap hashMap = new HashMap();
                String p4 = t1Var.L().p();
                n86.d(p4, "profileFeature.registeredDetail");
                hashMap.put("phone", p4);
                t1Var.a().a(hashMap);
                t1Var.a().b(hashMap);
                return;
            }
            return;
        }
        n86.l("drawerAdapter");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (o().k != null) {
            xt.f3961a.E().a(o().k, true);
        }
        ((Handler) o().n.getValue()).removeCallbacksAndMessages(null);
        xt.f3961a.Z().b();
        o().m = false;
        jz5.b().o(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x033c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x03ae  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0462  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0465  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x04bb  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x04bd  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x04c0  */
    @Override // androidx.fragment.app.Fragment
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r11, android.os.Bundle r12) {
        /*
        // Method dump skipped, instructions count: 1402
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.fragments.HomeScreenMainFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public final dl0 p() {
        return (dl0) this.h.getValue();
    }

    public final void q() {
        String string = getString(R.string.partners);
        n86.d(string, "getString(R.string.partners)");
        ve activity = c();
        City d2 = xt.f3961a.k().d();
        n86.c(d2);
        String name = d2.getName();
        n86.d(name, "cityProvider.currentCity!!.name");
        String lowerCase = name.toLowerCase();
        n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
        startActivity(WebViewActivity.i0(activity, n86.j("https://www.chalo.com/inapp/partners/", lowerCase), string, false, false));
    }

    public final void r() {
        d81 o2 = o();
        hu0 hu0 = new hu0(this);
        Objects.requireNonNull(o2);
        n86.e(hu0, "locationListener");
        if (!vn.M0(o2.d)) {
            o2.j = d81.a.NOT_QUERIED;
            o2.r();
        } else if (ui1.T(o2.d, "android.permission.ACCESS_FINE_LOCATION")) {
            je1 B = xt.f3961a.B();
            LocationRequest locationRequest = new LocationRequest();
            locationRequest.m1(100);
            locationRequest.l1(1000);
            B.b(locationRequest, hu0);
        }
    }

    public final void s() {
        if (vn.K0(getContext())) {
            o().p();
            y();
            T t2 = this.f;
            n86.c(t2);
            ((cy) t2).o.c.setVisibility(8);
            T t3 = this.f;
            n86.c(t3);
            ((cy) t3).h.setVisibility(0);
        }
    }

    public final void t(String str, boolean z) {
        SpannableStringBuilder k2 = vn.k(str, 0, str.length(), q5.b(requireContext(), R.color.white), true);
        n86.d(k2, "colorPartialString(\n    …           true\n        )");
        T t2 = this.f;
        n86.c(t2);
        Snackbar j2 = Snackbar.j(((cy) t2).f, k2, -2);
        n86.d(j2, "make(viewBinding.drawerL…ackbar.LENGTH_INDEFINITE)");
        if (z) {
            j2.k("Install", new fp0(this));
            View findViewById = j2.c.findViewById(R.id.snackbar_action);
            n86.d(findViewById, "lSnackBar.view.findViewById(R.id.snackbar_action)");
            TextView textView = (TextView) findViewById;
            textView.setTypeface(textView.getTypeface(), 1);
            j2.l(q5.b(requireContext(), R.color.mticket_status_action_color));
        }
        j2.m();
    }

    public final void u(boolean z) {
        City d2 = xt.f3961a.k().d();
        n86.c(d2);
        boolean z2 = true;
        boolean f2 = ea6.f("mumbai", d2.getDisplayName(), true);
        T t2 = this.f;
        n86.c(t2);
        Group group = ((cy) t2).m;
        n86.d(group, "viewBinding.homeScreenMumbaiCardGroup");
        int i2 = 0;
        group.setVisibility(f2 && !z ? 0 : 8);
        T t3 = this.f;
        n86.c(t3);
        MaterialCardView materialCardView = ((cy) t3).k.f1041a;
        n86.d(materialCardView, "viewBinding.homeScreenMumbaiBottomCard.root");
        if (!f2 || !z) {
            z2 = false;
        }
        if (!z2) {
            i2 = 8;
        }
        materialCardView.setVisibility(i2);
    }

    public final void v() {
        ConstraintLayout constraintLayout = k().b.e;
        n86.d(constraintLayout, "viewBinding.homeCheckInCard");
        int i2 = 0;
        constraintLayout.setVisibility(0);
        Stop stop = LocationTrackingService.o;
        Stop stop2 = LocationTrackingService.r;
        v80 v80 = LocationTrackingService.p;
        if (v80 == null) {
            b00 b00 = b00.f358a;
            hj1.Q0("LocationTrackingService getDestinationEta called with checkinValidator null", b00.a());
        } else {
            i2 = v80.a();
        }
        if (stop != null && stop2 != null) {
            pa1 k2 = k();
            Integer valueOf = Integer.valueOf(i2);
            k2.b.c.e.setText(stop.getName());
            k2.c(valueOf);
            pa1 k3 = k();
            Integer valueOf2 = Integer.valueOf(i2);
            String str = LocationTrackingService.k;
            k3.a(stop2, valueOf2);
            pa1 k4 = k();
            k4.b.c.c.setOnClickListener(new jq0(this, LocationTrackingService.m, stop2));
        }
    }

    public final void w() {
        T t2 = this.f;
        n86.c(t2);
        ConstraintLayout constraintLayout = ((cy) t2).h;
        n86.d(constraintLayout, "viewBinding.homeScreenMapContainer");
        constraintLayout.setVisibility(8);
        T t3 = this.f;
        n86.c(t3);
        ConstraintLayout constraintLayout2 = ((cy) t3).o.c;
        n86.d(constraintLayout2, "viewBinding.loadingScreen.loadingScreenContainer");
        if (!(constraintLayout2.getVisibility() == 0)) {
            ve activity = c();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type app.zophop.ui.activities.HomeActivity");
            T t4 = this.f;
            n86.c(t4);
            ((HomeActivity) activity).l0(((cy) t4).f767a);
        }
    }

    public final void x() {
        if (!vn.J0(c())) {
            ((ah1) this.n.getValue()).b(getString(R.string.gps_not_available_toast));
        } else {
            r();
        }
    }

    public final void y() {
        if (o().n()) {
            T t2 = this.f;
            n86.c(t2);
            if (((cy) t2).x.getVisibility() == 8) {
                T t3 = this.f;
                n86.c(t3);
                ((cy) t3).z.b.setVisibility(0);
            }
        }
        if (o().n() && xt.f3961a.L().m()) {
            T t4 = this.f;
            n86.c(t4);
            if (((cy) t4).M.getVisibility() == 8) {
                T t5 = this.f;
                n86.c(t5);
                ((cy) t5).O.b.setVisibility(0);
            }
        }
        T t6 = this.f;
        n86.c(t6);
        if (((cy) t6).q.getVisibility() == 8) {
            T t7 = this.f;
            n86.c(t7);
            ((cy) t7).s.b.setVisibility(0);
        }
        ((Handler) this.s.getValue()).postDelayed(new yp0(this), DefaultRefreshIntervals.ACTIVE_CONV_MIN_FETCH_INTERVAL);
    }

    public final void onEvent(DisruptionEvent disruptionEvent) {
        jz5.b().m(disruptionEvent);
        if (disruptionEvent.getCityAvailability() != null) {
            CityAvailability cityAvailability = disruptionEvent.getCityAvailability();
            if (cityAvailability != null) {
                boolean isSticky = cityAvailability.isSticky();
                String priority = cityAvailability.getPriority();
                boolean isVisible = cityAvailability.isVisible();
                String data = cityAvailability.getData();
                if (isVisible) {
                    n86.d(priority, "lPriority");
                    ed1 ed1 = new ed1("availability onboarding", Long.MIN_VALUE);
                    ed1.a("availability priority", priority);
                    ed1.a("availability banner sticky", Boolean.valueOf(isSticky));
                    xt.t1 t1Var = xt.f3961a;
                    City d2 = t1Var.k().d();
                    n86.c(d2);
                    ed1.a("city", d2.getName());
                    ui1.m0(ed1);
                    boolean z = false;
                    if (n86.a(priority, "medium")) {
                        new InAppMessageDetails(data);
                        if (!(InAppMessageDetails.l != 0)) {
                            T t2 = this.f;
                            n86.c(t2);
                            ((cy) t2).c.setText(InAppMessageDetails.q);
                        } else {
                            SpannableString spannableString = new SpannableString(InAppMessageDetails.q + ' ' + getString(R.string.know_more));
                            String str = InAppMessageDetails.n;
                            n86.d(str, "lMessageDetails.keyButtonCta");
                            spannableString.setSpan(new URLSpanNoUnderLine(str), InAppMessageDetails.q.length() + 1, spannableString.length(), 33);
                            Context context = getContext();
                            if (context != null) {
                                spannableString.setSpan(new ForegroundColorSpan(q5.b(context, R.color.chalo_primary)), InAppMessageDetails.q.length() + 1, spannableString.length(), 33);
                            }
                            T t3 = this.f;
                            n86.c(t3);
                            MaterialTextView materialTextView = ((cy) t3).c;
                            materialTextView.setText(spannableString);
                            materialTextView.setMovementMethod(LinkMovementMethod.getInstance());
                        }
                        T t4 = this.f;
                        n86.c(t4);
                        ((cy) t4).b.setVisibility(0);
                    } else if (n86.a(priority, "high")) {
                        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                        if (!defaultSharedPreferences.contains("availabilityBannerShown")) {
                            edit.putBoolean("availabilityBannerShown", true).commit();
                            z = true;
                        }
                        if (z) {
                            InAppMessageDetails inAppMessageDetails = new InAppMessageDetails(data);
                            i20 o2 = t1Var.o();
                            HomeActivity.a aVar = HomeActivity.k;
                            o2.b("Home Screen", new rn0(10, new kp0(this, inAppMessageDetails)));
                        }
                    }
                }
            }
        } else if (disruptionEvent.getResponseType() == ad1.FAILED && disruptionEvent.isInitialFetch()) {
            T t5 = this.f;
            n86.c(t5);
            ((cy) t5).b.setVisibility(8);
        }
    }

    public final void onEventMainThread(DatabaseSyncEvent databaseSyncEvent) {
        n86.e(databaseSyncEvent, "event");
        if (databaseSyncEvent.getStatus() == DatabaseSyncEvent.STATUS.STOPS_DONE || databaseSyncEvent.getStatus() == DatabaseSyncEvent.STATUS.DONE) {
            o().r();
        }
        jz5.b().m(databaseSyncEvent);
    }

    public final void onEvent(CardInfoFetchEvent cardInfoFetchEvent) {
        n86.e(cardInfoFetchEvent, "event");
        jz5.b().m(cardInfoFetchEvent);
        ed1 ed1 = new ed1("homescreen dynamic card rendered", Long.MIN_VALUE);
        ed1.a("cardsCount", Integer.valueOf(cardInfoFetchEvent.getCardsList().size()));
        jz5.b().i(ed1);
        List<CardInfo> cardsList = cardInfoFetchEvent.getCardsList();
        if (cardsList != null && cardsList.size() > 0) {
            CardInfo cardInfo = cardsList.get(0);
            if (cardInfo.isEnabled()) {
                List<ProductPromotionsObject> contentList = cardInfo.getContentList();
                ((rj0) this.i.getValue()).f2701a.b(contentList, new ep0(this, contentList));
            }
        }
    }

    public final void onEvent(ProductConfigurationFetchedEvent productConfigurationFetchedEvent) {
        jz5.b().m(productConfigurationFetchedEvent);
        d81 o2 = o();
        Objects.requireNonNull(o2);
        hd3.Y1(defpackage.h.Z(o2), hj1.s0(CoroutineExceptionHandler.a.f, xb6.b), null, new m81(productConfigurationFetchedEvent, o2, null), 2, null);
    }

    public final void onEvent(TransactionsFetchedOnlineEvent transactionsFetchedOnlineEvent) {
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.t().b("passStatusPromptVisibility")) {
            List<MPass> g2 = t1Var.c().g();
            int i2 = 0;
            int size = g2.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i3 = i2 + 1;
                    if (!o().f().a(String.valueOf(g2.get(i2).getStartingTime()))) {
                        MPass mPass = g2.get(i2);
                        n86.d(mPass, "lMPassList[i]");
                        MPass mPass2 = mPass;
                        ed1 ed1 = new ed1("pass status prompt open", Long.MIN_VALUE);
                        ed1.a("pass status", mPass2.getStatus());
                        ui1.m0(ed1);
                        if (n86.a(mPass2.getStatus(), "REJECTED")) {
                            i20 o2 = xt.f3961a.o();
                            HomeActivity.a aVar = HomeActivity.k;
                            o2.b("Home Screen", new rn0(80, new sp0(this, mPass2)));
                        } else if (n86.a(mPass2.getStatus(), "VERIFIED")) {
                            i20 o3 = xt.f3961a.o();
                            HomeActivity.a aVar2 = HomeActivity.k;
                            o3.b("Home Screen", new rn0(80, new zp0(this, mPass2)));
                        }
                    } else if (i3 > size) {
                        break;
                    } else {
                        i2 = i3;
                    }
                }
            }
            xt.f3961a.j().a();
        }
        jz5.b().m(transactionsFetchedOnlineEvent);
    }

    public final void onEvent(SeatAvailabilityStatusEvent seatAvailabilityStatusEvent) {
        CardItem cardItem;
        CardItem.b content;
        n86.e(seatAvailabilityStatusEvent, "event");
        if (o().m && seatAvailabilityStatusEvent.getResponseType() == ad1.SUCCESS) {
            List<SeatInfo> seatInfoList = seatAvailabilityStatusEvent.getSeatInfoList();
            n86.d(seatInfoList, "lSeatInfoList");
            for (SeatInfo seatInfo : seatInfoList) {
                String vehicleNo = seatInfo.getVehicleNo();
                if (o().l().containsKey(vehicleNo)) {
                    CardItem cardItem2 = o().l().get(vehicleNo);
                    String str = null;
                    if (!(cardItem2 == null || (content = cardItem2.getContent()) == null)) {
                        str = content.p;
                    }
                    if (n86.a(str, vehicleNo) && (cardItem = o().l().get(vehicleNo)) != null) {
                        int seatStatus = seatInfo.getSeatStatus();
                        if (seatStatus == -1) {
                            cardItem.getSeatAvailabilityIconView().setVisibility(8);
                        } else {
                            cardItem.getSeatAvailabilityIconView().setVisibility(0);
                            cardItem.getSeatAvailabilityIconView().setImageResource(vn.v0(seatStatus));
                        }
                    }
                }
            }
            xt.f3961a.Z().c(seatInfoList, "Nearby Stops Trip Card");
        }
    }

    public final void onEvent(UpdateEvent updateEvent) {
        n86.e(updateEvent, "event");
        jz5.b().m(updateEvent);
        if (updateEvent.getStatus() == ad1.SUCCESS && xt.f3961a.t().b("shouldUpdate")) {
            boolean z = true;
            boolean z2 = false;
            if (!updateEvent.isForceUpdate()) {
                z = false;
                if (updateEvent.isRecommendedUpdate()) {
                    z2 = true;
                }
            }
            if (z || z2) {
                Intent intent = new Intent(getContext(), ForceUpdateActivity.class);
                intent.putExtra("forceUpdate", z);
                intent.putExtra("recommendedUpdate", z2);
                startActivity(intent);
            }
        }
    }

    public final void onEvent(pd1 pd1) {
        n86.e(pd1, "event");
        j();
        jz5.b().m(pd1);
    }

    public final void onEvent(ke1 ke1) {
        n86.e(ke1, "lEvent");
        r();
        jz5.b().m(ke1);
    }

    public final void onEvent(CheckedinEvent checkedinEvent) {
        if (checkedinEvent != null) {
            n86.j("check in home", checkedinEvent.state);
            CheckedinEvent.STATE state = checkedinEvent.state;
            int i2 = -1;
            int i3 = state == null ? -1 : b.b[state.ordinal()];
            if (i3 == 1) {
                CheckedinEvent.STOP_SOURCE stop_source = checkedinEvent.stopSource;
                if (stop_source != null) {
                    i2 = b.c[stop_source.ordinal()];
                }
                if (i2 == 1) {
                    i();
                    FragmentManager parentFragmentManager = getParentFragmentManager();
                    km0.a aVar = km0.a.SERVER_ERROR;
                    n86.e(aVar, "checkInEnd");
                    km0 km0 = new km0();
                    Bundle bundle = new Bundle();
                    bundle.putString("check_in_stop_source", aVar.name());
                    km0.setArguments(bundle);
                    if (parentFragmentManager != null) {
                        km0.show(parentFragmentManager, "confirmation_dialog");
                    }
                } else if (i2 == 2) {
                    i();
                } else if (i2 == 3) {
                    i();
                    FragmentManager parentFragmentManager2 = getParentFragmentManager();
                    km0.a aVar2 = km0.a.DESTINAITON_REACHED;
                    n86.e(aVar2, "checkInEnd");
                    km0 km02 = new km0();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("check_in_stop_source", aVar2.name());
                    km02.setArguments(bundle2);
                    if (parentFragmentManager2 != null) {
                        km02.show(parentFragmentManager2, "confirmation_dialog");
                    }
                }
            } else if (i3 == 2) {
                v();
                RouteWithoutTimings routeWithoutTimings = checkedinEvent.route;
                Stop stop = checkedinEvent.startStop;
                if (!(routeWithoutTimings == null || stop == null)) {
                    int indexOf = routeWithoutTimings.getStopSequence().indexOf(stop);
                    if (indexOf != routeWithoutTimings.getStopSequence().size() - 1) {
                        stop = routeWithoutTimings.getStopSequence().get(indexOf + 1);
                    }
                    k().b.c.c.setOnClickListener(new jq0(this, routeWithoutTimings, stop));
                    pa1 k2 = k();
                    String string = k2.f2788a.getString(R.string.you_just_checked_in);
                    n86.d(string, "context.getString(R.string.you_just_checked_in)");
                    k2.b.b.b.setText(string);
                    k2.d(stop);
                }
            }
        }
        jz5.b().l(CheckedinEvent.class);
    }

    public final void onEvent(ETAEvent eTAEvent) {
        n86.e(eTAEvent, "etaEvent");
        if (!o().q) {
            v();
            pa1 k2 = k();
            Stop stop = eTAEvent.nextStop;
            Integer valueOf = Integer.valueOf(eTAEvent.eta);
            String str = LocationTrackingService.k;
            k2.a(stop, valueOf);
            pa1 k3 = k();
            k3.b.c.c.setOnClickListener(new jq0(this, LocationTrackingService.m, eTAEvent.nextStop));
        }
    }

    public final void onEvent(DestinationEvent destinationEvent) {
        if (destinationEvent != null) {
            o().q = true;
            v();
            pa1 k2 = k();
            Stop stop = LocationTrackingService.r;
            String string = k2.f2788a.getString(R.string.get_ready_step_out);
            n86.d(string, "context.getString(R.string.get_ready_step_out)");
            k2.b.b.b.setText(string);
            k2.d(stop);
        }
    }
}
