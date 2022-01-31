package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import app.zophop.R;

/* renamed from: xa1  reason: default package */
/* compiled from: HomeScreenCard */
public class xa1 extends LinearLayout {
    public xa1(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.home_screen_card, (ViewGroup) this, true);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        findViewById(R.id.card).setPadding(i, i2, i3, i4);
    }
}
