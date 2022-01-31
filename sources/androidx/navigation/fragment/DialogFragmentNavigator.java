package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import defpackage.mj;
import defpackage.zg;
import java.util.HashSet;

@mj.b("dialog")
public final class DialogFragmentNavigator extends mj<a> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f227a;
    public final FragmentManager b;
    public int c = 0;
    public final HashSet<String> d = new HashSet<>();
    public dh e = new dh(this) {
        /* class androidx.navigation.fragment.DialogFragmentNavigator.AnonymousClass1 */

        @Override // defpackage.dh
        public void c(fh fhVar, zg.a aVar) {
            if (aVar == zg.a.ON_STOP) {
                ue ueVar = (ue) fhVar;
                if (!ueVar.requireDialog().isShowing()) {
                    NavHostFragment.d(ueVar).g();
                }
            }
        }
    };

    public static class a extends ej implements ui {
        public String n;

        public a(mj<? extends a> mjVar) {
            super(mjVar);
        }

        @Override // defpackage.ej
        public void s(Context context, AttributeSet attributeSet) {
            super.s(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.DialogFragmentNavigator);
            String string = obtainAttributes.getString(R.styleable.DialogFragmentNavigator_android_name);
            if (string != null) {
                this.n = string;
            }
            obtainAttributes.recycle();
        }
    }

    public DialogFragmentNavigator(Context context, FragmentManager fragmentManager) {
        this.f227a = context;
        this.b = fragmentManager;
    }

    /* Return type fixed from 'ej' to match base method */
    @Override // defpackage.mj
    public a a() {
        return new a(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [ej, android.os.Bundle, kj, mj$a] */
    @Override // defpackage.mj
    public ej b(a aVar, Bundle bundle, kj kjVar, mj.a aVar2) {
        a aVar3 = aVar;
        if (this.b.S()) {
            return null;
        }
        String str = aVar3.n;
        if (str != null) {
            if (str.charAt(0) == '.') {
                str = this.f227a.getPackageName() + str;
            }
            Fragment a2 = this.b.K().a(this.f227a.getClassLoader(), str);
            if (!ue.class.isAssignableFrom(a2.getClass())) {
                StringBuilder i0 = hj1.i0("Dialog destination ");
                String str2 = aVar3.n;
                if (str2 != null) {
                    throw new IllegalArgumentException(hj1.a0(i0, str2, " is not an instance of DialogFragment"));
                }
                throw new IllegalStateException("DialogFragment class was not set");
            }
            ue ueVar = (ue) a2;
            ueVar.setArguments(bundle);
            ueVar.getLifecycle().a(this.e);
            FragmentManager fragmentManager = this.b;
            StringBuilder i02 = hj1.i0("androidx-nav-fragment:navigator:dialog:");
            int i = this.c;
            this.c = i + 1;
            i02.append(i);
            ueVar.show(fragmentManager, i02.toString());
            return aVar3;
        }
        throw new IllegalStateException("DialogFragment class was not set");
    }

    @Override // defpackage.mj
    public void c(Bundle bundle) {
        this.c = bundle.getInt("androidx-nav-dialogfragment:navigator:count", 0);
        for (int i = 0; i < this.c; i++) {
            FragmentManager fragmentManager = this.b;
            ue ueVar = (ue) fragmentManager.I("androidx-nav-fragment:navigator:dialog:" + i);
            if (ueVar != null) {
                ueVar.getLifecycle().a(this.e);
            } else {
                HashSet<String> hashSet = this.d;
                hashSet.add("androidx-nav-fragment:navigator:dialog:" + i);
            }
        }
    }

    @Override // defpackage.mj
    public Bundle d() {
        if (this.c == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("androidx-nav-dialogfragment:navigator:count", this.c);
        return bundle;
    }

    @Override // defpackage.mj
    public boolean e() {
        if (this.c == 0 || this.b.S()) {
            return false;
        }
        FragmentManager fragmentManager = this.b;
        StringBuilder i0 = hj1.i0("androidx-nav-fragment:navigator:dialog:");
        int i = this.c - 1;
        this.c = i;
        i0.append(i);
        Fragment I = fragmentManager.I(i0.toString());
        if (I != null) {
            I.getLifecycle().b(this.e);
            ((ue) I).dismiss();
        }
        return true;
    }
}
