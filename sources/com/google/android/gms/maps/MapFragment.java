package com.google.android.gms.maps;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@TargetApi(11)
public class MapFragment extends Fragment {
    public final b f = new b(this);

    public static class a implements jc2 {

        /* renamed from: a  reason: collision with root package name */
        public final Fragment f605a;
        public final m44 b;

        public a(Fragment fragment, m44 m44) {
            this.b = m44;
            Objects.requireNonNull(fragment, "null reference");
            this.f605a = fragment;
        }

        @Override // defpackage.jc2
        public final void I() {
            try {
                this.b.I();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // defpackage.jc2
        public final void K(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                c54.b(bundle, bundle2);
                Bundle arguments = this.f605a.getArguments();
                if (arguments != null && arguments.containsKey("MapOptions")) {
                    c54.c(bundle2, "MapOptions", arguments.getParcelable("MapOptions"));
                }
                this.b.K(bundle2);
                c54.b(bundle2, bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // defpackage.jc2
        public final void L(Activity activity, Bundle bundle, Bundle bundle2) {
            GoogleMapOptions googleMapOptions = (GoogleMapOptions) bundle.getParcelable("MapOptions");
            try {
                Bundle bundle3 = new Bundle();
                c54.b(bundle2, bundle3);
                this.b.S0(new kc2(activity), googleMapOptions, bundle3);
                c54.b(bundle3, bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // defpackage.jc2
        public final View M(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                c54.b(bundle, bundle2);
                ic2 Z0 = this.b.Z0(new kc2(layoutInflater), new kc2(viewGroup), bundle2);
                c54.b(bundle2, bundle);
                return (View) kc2.L(Z0);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void a(g44 g44) {
            try {
                this.b.Q2(new r54(g44));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // defpackage.jc2
        public final void l() {
            try {
                this.b.l();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // defpackage.jc2
        public final void m() {
            try {
                this.b.m();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // defpackage.jc2
        public final void n() {
            try {
                this.b.n();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // defpackage.jc2
        public final void onLowMemory() {
            try {
                this.b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // defpackage.jc2
        public final void u() {
            try {
                this.b.u();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // defpackage.jc2
        public final void w() {
            try {
                this.b.w();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // defpackage.jc2
        public final void z(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                c54.b(bundle, bundle2);
                this.b.z(bundle2);
                c54.b(bundle2, bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    public static class b extends hc2<a> {
        public final Fragment e;
        public lc2<a> f;
        public Activity g;
        public final List<g44> h = new ArrayList();

        public b(Fragment fragment) {
            this.e = fragment;
        }

        @Override // defpackage.hc2
        public final void a(lc2<a> lc2) {
            this.f = lc2;
            e();
        }

        public final void e() {
            Activity activity = this.g;
            if (activity != null && this.f != null && this.f1357a == null) {
                try {
                    f44.a(activity);
                    m44 n3 = d54.a(this.g).n3(new kc2(this.g));
                    if (n3 != null) {
                        this.f.a(new a(this.e, n3));
                        for (g44 g44 : this.h) {
                            ((a) this.f1357a).a(g44);
                        }
                        this.h.clear();
                    }
                } catch (RemoteException e2) {
                    throw new RuntimeRemoteException(e2);
                } catch (s22 unused) {
                }
            }
        }
    }

    public void e(g44 g44) {
        gj1.h("getMapAsync must be called on the main thread.");
        b bVar = this.f;
        T t = bVar.f1357a;
        if (t != null) {
            try {
                ((a) t).b.Q2(new r54(g44));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            bVar.h.add(g44);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        b bVar = this.f;
        bVar.g = activity;
        bVar.e();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b bVar = this.f;
        bVar.d(bundle, new nc2(bVar, bundle));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View b2 = this.f.b(layoutInflater, viewGroup, bundle);
        b2.setClickable(true);
        return b2;
    }

    public void onDestroy() {
        b bVar = this.f;
        T t = bVar.f1357a;
        if (t != null) {
            t.l();
        } else {
            bVar.c(1);
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        b bVar = this.f;
        T t = bVar.f1357a;
        if (t != null) {
            t.I();
        } else {
            bVar.c(2);
        }
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    @SuppressLint({"NewApi"})
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            b bVar = this.f;
            bVar.g = activity;
            bVar.e();
            GoogleMapOptions l1 = GoogleMapOptions.l1(activity, attributeSet);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("MapOptions", l1);
            b bVar2 = this.f;
            bVar2.d(bundle, new mc2(bVar2, activity, bundle2, bundle));
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void onLowMemory() {
        T t = this.f.f1357a;
        if (t != null) {
            t.onLowMemory();
        }
        super.onLowMemory();
    }

    public void onPause() {
        b bVar = this.f;
        T t = bVar.f1357a;
        if (t != null) {
            t.w();
        } else {
            bVar.c(5);
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        b bVar = this.f;
        bVar.d(null, new rc2(bVar));
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        b bVar = this.f;
        T t = bVar.f1357a;
        if (t != null) {
            t.z(bundle);
            return;
        }
        Bundle bundle2 = bVar.b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public void onStart() {
        super.onStart();
        b bVar = this.f;
        bVar.d(null, new qc2(bVar));
    }

    public void onStop() {
        b bVar = this.f;
        T t = bVar.f1357a;
        if (t != null) {
            t.m();
        } else {
            bVar.c(4);
        }
        super.onStop();
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
