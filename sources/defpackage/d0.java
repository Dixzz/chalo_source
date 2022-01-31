package defpackage;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* renamed from: d0  reason: default package */
/* compiled from: AlertController */
public class d0 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ AlertController f;
    public final /* synthetic */ AlertController.b g;

    public d0(AlertController.b bVar, AlertController alertController) {
        this.g = bVar;
        this.f = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.g.p.onClick(this.f.b, i);
        if (!this.g.r) {
            this.f.b.dismiss();
        }
    }
}
