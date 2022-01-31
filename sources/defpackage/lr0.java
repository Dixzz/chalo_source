package defpackage;

import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import app.zophop.ui.fragments.LanguageSelectSplashScreen;

/* renamed from: lr0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class lr0 implements View.OnClickListener {
    public final /* synthetic */ LanguageSelectSplashScreen f;

    public /* synthetic */ lr0(LanguageSelectSplashScreen languageSelectSplashScreen) {
        this.f = languageSelectSplashScreen;
    }

    public final void onClick(View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        LanguageSelectSplashScreen languageSelectSplashScreen = this.f;
        int i = LanguageSelectSplashScreen.i;
        n86.e(languageSelectSplashScreen, "this$0");
        ve activity = languageSelectSplashScreen.c();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.b();
        }
    }
}
