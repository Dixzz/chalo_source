package app.zophop.ui.fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.City;
import app.zophop.pubsub.eventbus.events.CityResponseEvent;
import com.google.android.material.appbar.AppBarLayout;
import defpackage.wi0;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CitySelectionFragment.kt */
public final class CitySelectionFragment extends rl0<uw> {
    public static final /* synthetic */ int k = 0;
    public wi0 g;
    public final int h = 1;
    public final j56 i = h.B(this, z86.a(b81.class), new d(new c(this)), null);
    public final xi j = new xi(z86.a(zt0.class), new b(this));

    /* compiled from: CitySelectionFragment.kt */
    public static final class a implements TextWatcher {
        public final /* synthetic */ CitySelectionFragment f;

        public a(CitySelectionFragment citySelectionFragment) {
            this.f = citySelectionFragment;
        }

        public void afterTextChanged(Editable editable) {
            String displayName;
            n86.e(editable, "s");
            CitySelectionFragment citySelectionFragment = this.f;
            int i = CitySelectionFragment.k;
            b81 f2 = citySelectionFragment.f();
            Objects.requireNonNull(f2);
            n86.e(editable, "lQueryString");
            f2.c.b("currentQuery", editable.toString());
            oh ohVar = (oh) f2.g.getValue();
            ArrayList arrayList = new ArrayList();
            for (Object obj : (List) f2.f.getValue()) {
                wi0.b bVar = (wi0.b) obj;
                City city = bVar.b;
                boolean z = false;
                if (((city == null || (displayName = city.getDisplayName()) == null || !ea6.a(displayName, editable, true)) ? false : true) || bVar.f3786a == wi0.c.FOOTER) {
                    z = true;
                }
                if (z) {
                    arrayList.add(obj);
                }
            }
            ohVar.l(arrayList);
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            n86.e(charSequence, "s");
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            n86.e(charSequence, "s");
        }
    }

    /* compiled from: FragmentNavArgsLazy.kt */
    public static final class b extends o86 implements h76<Bundle> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.f = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public Bundle invoke() {
            Bundle arguments = this.f.getArguments();
            if (arguments != null) {
                return arguments;
            }
            throw new IllegalStateException(hj1.Y(hj1.i0("Fragment "), this.f, " has null arguments"));
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    public static final class c extends o86 implements h76<Fragment> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
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
    public static final class d extends o86 implements h76<gi> {
        public final /* synthetic */ h76 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(h76 h76) {
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

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.rl0
    public uw e() {
        View inflate = getLayoutInflater().inflate(R.layout.city_selection_fragment, (ViewGroup) null, false);
        int i2 = R.id.city_selection_list;
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.city_selection_list);
        if (recyclerView != null) {
            i2 = R.id.et_city_name_query;
            EditText editText = (EditText) inflate.findViewById(R.id.et_city_name_query);
            if (editText != null) {
                i2 = R.id.loading_screen;
                View findViewById = inflate.findViewById(R.id.loading_screen);
                if (findViewById != null) {
                    ky b2 = ky.b(findViewById);
                    i2 = R.id.search_city;
                    TextView textView = (TextView) inflate.findViewById(R.id.search_city);
                    if (textView != null) {
                        i2 = R.id.search_container;
                        CardView cardView = (CardView) inflate.findViewById(R.id.search_container);
                        if (cardView != null) {
                            i2 = R.id.search_icon;
                            ImageView imageView = (ImageView) inflate.findViewById(R.id.search_icon);
                            if (imageView != null) {
                                i2 = R.id.toolbar;
                                Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
                                if (toolbar != null) {
                                    i2 = R.id.toolbar_top_container;
                                    AppBarLayout appBarLayout = (AppBarLayout) inflate.findViewById(R.id.toolbar_top_container);
                                    if (appBarLayout != null) {
                                        uw uwVar = new uw((CoordinatorLayout) inflate, recyclerView, editText, b2, textView, cardView, imageView, toolbar, appBarLayout);
                                        n86.d(uwVar, "inflate(layoutInflater)");
                                        return uwVar;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    public final b81 f() {
        return (b81) this.i.getValue();
    }

    public final void g() {
        try {
            T t = this.f;
            n86.c(t);
            vn.E0(((uw) t).c, getContext());
        } catch (Exception e) {
            e.toString();
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }

    public final void h() {
        OnBackPressedDispatcher onBackPressedDispatcher;
        T t = this.f;
        n86.c(t);
        ((uw) t).i.setVisibility(0);
        T t2 = this.f;
        n86.c(t2);
        ((uw) t2).b.setVisibility(0);
        T t3 = this.f;
        n86.c(t3);
        ((uw) t3).d.b.setVisibility(8);
        T t4 = this.f;
        n86.c(t4);
        ((uw) t4).d.d.setVisibility(8);
        if (f().f()) {
            ve activity = c();
            if (!(activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null)) {
                h.e(onBackPressedDispatcher, this, false, new wt0(this), 2);
            }
            T t5 = this.f;
            n86.c(t5);
            ((uw) t5).h.setNavigationOnClickListener(new no0(this));
            T t6 = this.f;
            n86.c(t6);
            AppBarLayout appBarLayout = ((uw) t6).i;
            n86.d(appBarLayout, "viewBinding.toolbarTopContainer");
            n86.e(appBarLayout, "<this>");
            ViewGroup.LayoutParams layoutParams = appBarLayout.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            AppBarLayout.Behavior behavior = new AppBarLayout.Behavior();
            behavior.q = new ph1();
            ((CoordinatorLayout.f) layoutParams).b(behavior);
            T t7 = this.f;
            n86.c(t7);
            ((uw) t7).f.setOnClickListener(new po0(this));
            T t8 = this.f;
            n86.c(t8);
            ((uw) t8).b.setLayoutManager(new LinearLayoutManager(getContext()));
            ui1.m0(new ed1("city selection screen displayed", Long.MAX_VALUE));
            Context context = getContext();
            if (context != null) {
                this.g = new wi0(context, f().e(), new yt0(this), new mo0(this));
                City d2 = f().d().d();
                if (d2 != null && !d2.isCityDiscontinued()) {
                    wi0 wi0 = this.g;
                    if (wi0 != null) {
                        String displayName = d2.getDisplayName();
                        n86.d(displayName, "it.displayName");
                        n86.e(displayName, "lCityName");
                        wi0.g = displayName;
                    } else {
                        n86.l("citySelectionListAdapter");
                        throw null;
                    }
                }
                T t9 = this.f;
                n86.c(t9);
                RecyclerView recyclerView = ((uw) t9).b;
                wi0 wi02 = this.g;
                if (wi02 != null) {
                    recyclerView.setAdapter(wi02);
                } else {
                    n86.l("citySelectionListAdapter");
                    throw null;
                }
            }
            if (!TextUtils.isEmpty(f().e().d())) {
                i();
                T t10 = this.f;
                n86.c(t10);
                ((uw) t10).c.setText(f().e().d());
            }
            ((oh) f().g.getValue()).f(getViewLifecycleOwner(), new oo0(this));
        }
    }

    public final void i() {
        T t = this.f;
        n86.c(t);
        ((uw) t).i.c(false, true, true);
        T t2 = this.f;
        n86.c(t2);
        RecyclerView recyclerView = ((uw) t2).b;
        AtomicInteger atomicInteger = r8.f3055a;
        recyclerView.setNestedScrollingEnabled(false);
        T t3 = this.f;
        n86.c(t3);
        ((uw) t3).g.setVisibility(8);
        T t4 = this.f;
        n86.c(t4);
        ((uw) t4).e.setVisibility(8);
        T t5 = this.f;
        n86.c(t5);
        EditText editText = ((uw) t5).c;
        editText.setVisibility(0);
        editText.setEnabled(true);
        editText.addTextChangedListener(new a(this));
        try {
            T t6 = this.f;
            n86.c(t6);
            ((uw) t6).c.requestFocus();
            T t7 = this.f;
            n86.c(t7);
            vn.Z0(((uw) t7).c, getContext());
        } catch (Exception e) {
            e.toString();
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }

    public final void onEvent(CityResponseEvent cityResponseEvent) {
        n86.e(cityResponseEvent, "cityResponseEvent");
        jz5.b().m(cityResponseEvent);
        if (cityResponseEvent.success) {
            h();
            return;
        }
        T t = this.f;
        n86.c(t);
        ((uw) t).i.setVisibility(8);
        T t2 = this.f;
        n86.c(t2);
        ((uw) t2).b.setVisibility(8);
        T t3 = this.f;
        n86.c(t3);
        ((uw) t3).d.b.setVisibility(0);
        T t4 = this.f;
        n86.c(t4);
        ((uw) t4).d.d.setVisibility(8);
        T t5 = this.f;
        n86.c(t5);
        ((uw) t5).d.e.setOnClickListener(new lo0(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        T t = this.f;
        n86.c(t);
        if (((uw) t).c.getVisibility() == 0) {
            g();
        }
        jz5.b().o(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n86.e(view, "view");
        super.onViewCreated(view, bundle);
        xt.t1 t1Var = xt.f3961a;
        boolean has = t1Var.l().h.has("cityScreenSeen");
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION"};
        if (!ui1.T(getContext(), (String[]) Arrays.copyOf(strArr, 1)) && !has) {
            t1Var.l().put("cityScreenSeen", "true");
            if (Build.VERSION.SDK_INT >= 23) {
                requestPermissions(strArr, this.h);
                hj1.P0("permission_popup", Long.MIN_VALUE, "element", "tutorial_location");
            }
        }
        h();
    }
}
