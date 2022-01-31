package defpackage;

import android.view.View;
import app.zophop.ui.fragments.TutorialViewPagerFragment;

/* renamed from: ls0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ls0 implements View.OnClickListener {
    public final /* synthetic */ TutorialViewPagerFragment f;

    public /* synthetic */ ls0(TutorialViewPagerFragment tutorialViewPagerFragment) {
        this.f = tutorialViewPagerFragment;
    }

    public final void onClick(View view) {
        TutorialViewPagerFragment tutorialViewPagerFragment = this.f;
        int i = TutorialViewPagerFragment.h;
        n86.e(tutorialViewPagerFragment, "this$0");
        ui1.m0(new ed1("go to next page in tutorial clicked", Long.MIN_VALUE));
        T t = tutorialViewPagerFragment.f;
        n86.c(t);
        ((kz) t).e.setCurrentItem(tutorialViewPagerFragment.f() - 1);
    }
}
