package defpackage;

import android.view.View;
import android.widget.AbsListView;
import androidx.appcompat.app.AlertController;

/* renamed from: b0  reason: default package */
/* compiled from: AlertController */
public class b0 implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f357a;
    public final /* synthetic */ View b;

    public b0(AlertController alertController, View view, View view2) {
        this.f357a = view;
        this.b = view2;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AlertController.c(absListView, this.f357a, this.b);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
