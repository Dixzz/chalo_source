package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.UniversalPickerActivity;
import app.zophop.ui.fragments.SchedulerInputFormFragment;
import java.util.Objects;

/* renamed from: dw0  reason: default package */
/* compiled from: SchedulerInputFormFragment */
public class dw0 implements View.OnClickListener {
    public final /* synthetic */ SchedulerInputFormFragment f;

    public dw0(SchedulerInputFormFragment schedulerInputFormFragment) {
        this.f = schedulerInputFormFragment;
    }

    public void onClick(View view) {
        SchedulerInputFormFragment schedulerInputFormFragment = this.f;
        int i = SchedulerInputFormFragment.v;
        Objects.requireNonNull(schedulerInputFormFragment);
        Intent intent = new Intent(schedulerInputFormFragment.getActivity(), UniversalPickerActivity.class);
        intent.putExtra("extra:source", "scheduler screen bus route search");
        schedulerInputFormFragment.getActivity().startActivity(intent);
    }
}
