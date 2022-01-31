package defpackage;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: xp4  reason: default package */
/* compiled from: MaterialAutoCompleteTextView */
public class xp4 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ yp4 f;

    public xp4(yp4 yp4) {
        this.f = yp4;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        yp4.a(this.f, i < 0 ? this.f.f.getSelectedItem() : this.f.getAdapter().getItem(i));
        AdapterView.OnItemClickListener onItemClickListener = this.f.getOnItemClickListener();
        if (onItemClickListener != null) {
            if (view == null || i < 0) {
                view = this.f.f.getSelectedView();
                i = this.f.f.getSelectedItemPosition();
                j = this.f.f.getSelectedItemId();
            }
            onItemClickListener.onItemClick(this.f.f.getListView(), view, i, j);
        }
        this.f.f.dismiss();
    }
}
