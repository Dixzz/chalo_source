package defpackage;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.ui.views.summary_card.LoaderView;

/* renamed from: g71  reason: default package */
/* compiled from: WindowUtils */
public class g71 extends DialogFragment {
    public final /* synthetic */ String f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ String h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ View.OnClickListener j;
    public final /* synthetic */ String k;

    public g71(String str, boolean z, String str2, boolean z2, View.OnClickListener onClickListener, String str3) {
        this.f = str;
        this.g = z;
        this.h = str2;
        this.i = z2;
        this.j = onClickListener;
        this.k = str3;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.loader_fragment_layout, viewGroup, true);
        ((TextView) inflate.findViewById(R.id.dialog_text)).setText(this.f);
        TextView textView = (TextView) inflate.findViewById(R.id.loader_title);
        View findViewById = inflate.findViewById(R.id.loader_container);
        if (this.g) {
            textView.setVisibility(0);
            textView.setText(this.h);
        } else {
            findViewById.setPadding(getResources().getDimensionPixelSize(R.dimen.loader_container_top_padding), 0, 0, getResources().getDimensionPixelSize(R.dimen.loader_container_bottom_padding_no_title));
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.action_loader_dialog);
        if (this.i) {
            textView2.setVisibility(0);
            textView2.setOnClickListener(this.j);
            textView2.setText(this.k);
        } else {
            textView2.setVisibility(8);
        }
        return inflate;
    }

    public void onStart() {
        super.onStart();
        getDialog().findViewById(R.id.dialog_loader).setVisibility(0);
        ((LoaderView) getDialog().findViewById(R.id.dialog_loader)).d();
    }
}
