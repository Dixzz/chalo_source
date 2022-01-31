package defpackage;

import android.content.Intent;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.fragments.LanguageSelectSplashScreen;
import com.razorpay.AnalyticsConstants;
import defpackage.xt;
import java.util.Objects;

/* renamed from: kr0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class kr0 implements View.OnClickListener {
    public final /* synthetic */ LanguageSelectSplashScreen f;

    public /* synthetic */ kr0(LanguageSelectSplashScreen languageSelectSplashScreen) {
        this.f = languageSelectSplashScreen;
    }

    public final void onClick(View view) {
        LanguageSelectSplashScreen languageSelectSplashScreen = this.f;
        int i = LanguageSelectSplashScreen.i;
        n86.e(languageSelectSplashScreen, "this$0");
        o81 g = languageSelectSplashScreen.g();
        Objects.requireNonNull(g);
        xt.t1 t1Var = xt.f3961a;
        t1Var.t().d(g.c);
        if (!n86.a(g.c, t1Var.z().b())) {
            h30 z = t1Var.z();
            String str = g.c;
            Objects.requireNonNull(z);
            ed1 ed1 = new ed1("language changed", Long.MIN_VALUE);
            ed1.a("language", str);
            ui1.m0(ed1);
            t1Var.l().put(z.b, str);
        }
        ed1 ed12 = new ed1("language screen continue clicked", Long.MAX_VALUE);
        ed12.a(AnalyticsConstants.LOCALE, g.c);
        ui1.m0(ed12);
        zz zzVar = new zz("languageSelected", null, 2);
        zzVar.a("selectedLanguage", t1Var.z().c(g.c));
        ui1.l0(zzVar);
        t1Var.l().put("language_selected", "true");
        if (languageSelectSplashScreen.f().a()) {
            vh1 vh1 = vh1.f3649a;
            n86.f(languageSelectSplashScreen, "$this$findNavController");
            NavController d = NavHostFragment.d(languageSelectSplashScreen);
            n86.b(d, "NavHostFragment.findNavController(this)");
            cv0 cv0 = new cv0(null);
            cv0.f755a.put("isFromSplash", Boolean.TRUE);
            n86.d(cv0, "actionLanguageSelectSpla…t().setIsFromSplash(true)");
            vh1.a(d, cv0);
            return;
        }
        Intent intent = new Intent(languageSelectSplashScreen.getContext(), HomeActivity.class);
        intent.addFlags(67108864);
        languageSelectSplashScreen.startActivity(intent);
        ve activity = languageSelectSplashScreen.c();
        if (activity != null) {
            activity.finish();
        }
    }
}
