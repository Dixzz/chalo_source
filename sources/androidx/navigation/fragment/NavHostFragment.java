package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavBackStackEntryState;
import androidx.navigation.NavController;
import androidx.navigation.R;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class NavHostFragment extends Fragment {
    public ij f;
    public Boolean g = null;
    public View h;
    public int i;
    public boolean j;

    public static NavController d(Fragment fragment) {
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getParentFragment()) {
            if (fragment2 instanceof NavHostFragment) {
                return ((NavHostFragment) fragment2).e();
            }
            Fragment fragment3 = fragment2.getParentFragmentManager().t;
            if (fragment3 instanceof NavHostFragment) {
                return ((NavHostFragment) fragment3).e();
            }
        }
        View view = fragment.getView();
        if (view != null) {
            return h.G(view);
        }
        Dialog dialog = fragment instanceof ue ? ((ue) fragment).getDialog() : null;
        if (!(dialog == null || dialog.getWindow() == null)) {
            return h.G(dialog.getWindow().getDecorView());
        }
        throw new IllegalStateException(hj1.O("Fragment ", fragment, " does not have a NavController set"));
    }

    public final NavController e() {
        ij ijVar = this.f;
        if (ijVar != null) {
            return ijVar;
        }
        throw new IllegalStateException("NavController is not available before onCreate()");
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.j) {
            ke keVar = new ke(getParentFragmentManager());
            keVar.r(this);
            keVar.d();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        nj njVar = this.f.k;
        Objects.requireNonNull(njVar);
        DialogFragmentNavigator dialogFragmentNavigator = (DialogFragmentNavigator) njVar.c(nj.b(DialogFragmentNavigator.class));
        if (dialogFragmentNavigator.d.remove(fragment.getTag())) {
            fragment.getLifecycle().a(dialogFragmentNavigator.e);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        ij ijVar = new ij(requireContext());
        this.f = ijVar;
        if (this != ijVar.i) {
            ijVar.i = this;
            getLifecycle().a(ijVar.m);
        }
        ij ijVar2 = this.f;
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        if (ijVar2.i != null) {
            ijVar2.n.b();
            onBackPressedDispatcher.a(ijVar2.i, ijVar2.n);
            ijVar2.i.getLifecycle().b(ijVar2.m);
            ijVar2.i.getLifecycle().a(ijVar2.m);
            ij ijVar3 = this.f;
            Boolean bool = this.g;
            int i2 = 0;
            ijVar3.o = bool != null && bool.booleanValue();
            ijVar3.j();
            Bundle bundle3 = null;
            this.g = null;
            ij ijVar4 = this.f;
            gi viewModelStore = getViewModelStore();
            if (ijVar4.j != bj.d(viewModelStore)) {
                if (ijVar4.h.isEmpty()) {
                    ijVar4.j = bj.d(viewModelStore);
                } else {
                    throw new IllegalStateException("ViewModelStore should be set before setGraph call");
                }
            }
            ij ijVar5 = this.f;
            ijVar5.k.a(new DialogFragmentNavigator(requireContext(), getChildFragmentManager()));
            nj njVar = ijVar5.k;
            Context requireContext = requireContext();
            FragmentManager childFragmentManager = getChildFragmentManager();
            int id = getId();
            if (id == 0 || id == -1) {
                id = R.id.nav_host_fragment_container;
            }
            njVar.a(new oj(requireContext, childFragmentManager, id));
            if (bundle != null) {
                bundle2 = bundle.getBundle("android-support-nav:fragment:navControllerState");
                if (bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
                    this.j = true;
                    ke keVar = new ke(getParentFragmentManager());
                    keVar.r(this);
                    keVar.d();
                }
                this.i = bundle.getInt("android-support-nav:fragment:graphId");
            } else {
                bundle2 = null;
            }
            if (bundle2 != null) {
                ij ijVar6 = this.f;
                Objects.requireNonNull(ijVar6);
                bundle2.setClassLoader(ijVar6.f226a.getClassLoader());
                ijVar6.e = bundle2.getBundle("android-support-nav:controller:navigatorState");
                ijVar6.f = bundle2.getParcelableArray("android-support-nav:controller:backStack");
                ijVar6.g = bundle2.getBoolean("android-support-nav:controller:deepLinkHandled");
            }
            int i3 = this.i;
            if (i3 != 0) {
                ij ijVar7 = this.f;
                ijVar7.i(ijVar7.e().c(i3), null);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    i2 = arguments.getInt("android-support-nav:fragment:graphId");
                }
                if (arguments != null) {
                    bundle3 = arguments.getBundle("android-support-nav:fragment:startDestinationArgs");
                }
                if (i2 != 0) {
                    ij ijVar8 = this.f;
                    ijVar8.i(ijVar8.e().c(i2), bundle3);
                }
            }
            super.onCreate(bundle);
            return;
        }
        throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
        int id = getId();
        if (id == 0 || id == -1) {
            id = R.id.nav_host_fragment_container;
        }
        fragmentContainerView.setId(id);
        return fragmentContainerView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View view = this.h;
        if (view != null && h.G(view) == this.f) {
            this.h.setTag(R.id.nav_controller_view_tag, null);
        }
        this.h = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NavHost);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.NavHost_navGraph, 0);
        if (resourceId != 0) {
            this.i = resourceId;
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.NavHostFragment);
        if (obtainStyledAttributes2.getBoolean(R.styleable.NavHostFragment_defaultNavHost, false)) {
            this.j = true;
        }
        obtainStyledAttributes2.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrimaryNavigationFragmentChanged(boolean z) {
        ij ijVar = this.f;
        if (ijVar != null) {
            ijVar.o = z;
            ijVar.j();
            return;
        }
        this.g = Boolean.valueOf(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2;
        super.onSaveInstanceState(bundle);
        ij ijVar = this.f;
        Objects.requireNonNull(ijVar);
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle3 = new Bundle();
        for (Map.Entry<String, mj<? extends ej>> entry : ijVar.k.f2563a.entrySet()) {
            String key = entry.getKey();
            Bundle d = entry.getValue().d();
            if (d != null) {
                arrayList.add(key);
                bundle3.putBundle(key, d);
            }
        }
        if (!arrayList.isEmpty()) {
            bundle2 = new Bundle();
            bundle3.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle2.putBundle("android-support-nav:controller:navigatorState", bundle3);
        } else {
            bundle2 = null;
        }
        if (!ijVar.h.isEmpty()) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[ijVar.h.size()];
            int i2 = 0;
            for (aj ajVar : ijVar.h) {
                parcelableArr[i2] = new NavBackStackEntryState(ajVar);
                i2++;
            }
            bundle2.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (ijVar.g) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putBoolean("android-support-nav:controller:deepLinkHandled", ijVar.g);
        }
        if (bundle2 != null) {
            bundle.putBundle("android-support-nav:fragment:navControllerState", bundle2);
        }
        if (this.j) {
            bundle.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
        int i3 = this.i;
        if (i3 != 0) {
            bundle.putInt("android-support-nav:fragment:graphId", i3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (view instanceof ViewGroup) {
            ij ijVar = this.f;
            int i2 = R.id.nav_controller_view_tag;
            view.setTag(i2, ijVar);
            if (view.getParent() != null) {
                View view2 = (View) view.getParent();
                this.h = view2;
                if (view2.getId() == getId()) {
                    this.h.setTag(i2, this.f);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("created host view " + view + " is not a ViewGroup");
    }
}
