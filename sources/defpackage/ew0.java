package defpackage;

import android.view.View;
import app.zophop.ui.fragments.SchedulerInputFormFragment;
import java.util.Objects;

/* renamed from: ew0  reason: default package */
/* compiled from: SchedulerInputFormFragment */
public class ew0 implements View.OnClickListener {
    public final /* synthetic */ SchedulerInputFormFragment f;

    public ew0(SchedulerInputFormFragment schedulerInputFormFragment) {
        this.f = schedulerInputFormFragment;
    }

    public void onClick(View view) {
        SchedulerInputFormFragment schedulerInputFormFragment = this.f;
        int i = SchedulerInputFormFragment.v;
        Objects.requireNonNull(schedulerInputFormFragment);
        xt.f3961a.l().put("card_details_tut_shown", String.valueOf(true));
        this.f._cardTutView.setVisibility(8);
    }
}
