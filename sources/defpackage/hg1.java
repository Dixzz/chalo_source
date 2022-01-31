package defpackage;

import android.widget.RadioGroup;
import app.zophop.utilities.R;

/* renamed from: hg1  reason: default package */
/* compiled from: FavoriteDialog */
public class hg1 implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ig1 f1369a;

    public hg1(ig1 ig1) {
        this.f1369a = ig1;
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.radio_home || i == R.id.radio_work) {
            this.f1369a.h.setVisibility(8);
        } else {
            this.f1369a.h.setVisibility(0);
        }
    }
}
