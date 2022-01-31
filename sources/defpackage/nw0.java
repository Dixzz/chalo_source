package defpackage;

import android.content.Intent;
import android.view.LayoutInflater;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import app.zophop.ui.activities.ValidationScreen;

/* renamed from: nw0  reason: default package */
/* compiled from: SoundInfoRationaleFragment.kt */
public final class nw0 extends ql0<ox> {
    public static final a j = new a(null);
    public String g;
    public final r<Intent> h;
    public final r<String> i;

    /* renamed from: nw0$a */
    /* compiled from: SoundInfoRationaleFragment.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* renamed from: nw0$b */
    /* compiled from: SoundInfoRationaleFragment.kt */
    public static final class b extends o86 implements s76<l, s56> {
        public final /* synthetic */ nw0 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(nw0 nw0) {
            super(1);
            this.f = nw0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.s76
        public s56 invoke(l lVar) {
            n86.e(lVar, "$this$addCallback");
            nw0 nw0 = this.f;
            a aVar = nw0.j;
            nw0.g();
            return s56.f3190a;
        }
    }

    public nw0() {
        r<Intent> registerForActivityResult = registerForActivityResult(new w(), new es0(this));
        n86.d(registerForActivityResult, "registerForActivityResul…SoundFragment()\n        }");
        this.h = registerForActivityResult;
        r<String> registerForActivityResult2 = registerForActivityResult(new v(), new is0(this));
        n86.d(registerForActivityResult2, "registerForActivityResul…)\n            }\n        }");
        this.i = registerForActivityResult2;
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.ql0
    public ox d(LayoutInflater layoutInflater) {
        n86.e(layoutInflater, "lInflater");
        ox b2 = ox.b(layoutInflater);
        n86.d(b2, "inflate(lInflater)");
        return b2;
    }

    @Override // defpackage.ql0
    public void e() {
        OnBackPressedDispatcher onBackPressedDispatcher;
        String str = this.g;
        if (str != null) {
            hj1.R0("sound info rationale screen open", "lName", str, "lSource", "sound info rationale screen open", Long.MIN_VALUE, "source", str);
            T t = this.f;
            n86.c(t);
            ((ox) t).b.setOnClickListener(new fs0(this));
            ve activity = c();
            if (!(activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null)) {
                h.e(onBackPressedDispatcher, this, false, new b(this), 2);
            }
            T t2 = this.f;
            n86.c(t2);
            ((ox) t2).c.setNavigationOnClickListener(new gs0(this));
            return;
        }
        n86.l("argSource");
        throw null;
    }

    @Override // defpackage.ql0
    public void f() {
    }

    public final void g() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        int i2 = ValidationScreen.u;
        Fragment I = parentFragmentManager.I("sound_fragment");
        if (I instanceof hw0) {
            hw0 hw0 = (hw0) I;
            hw0.y = true;
            hw0.f();
        }
        dismiss();
    }
}
