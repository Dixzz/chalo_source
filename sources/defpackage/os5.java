package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.urbanairship.iam.html.HtmlActivity;

/* renamed from: os5  reason: default package */
/* compiled from: HtmlActivity */
public class os5 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f2726a;

    public os5(HtmlActivity htmlActivity, View view) {
        this.f2726a = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2726a.setVisibility(8);
    }
}
