package defpackage;

import android.view.View;
import androidx.appcompat.app.AlertController;

/* renamed from: c0  reason: default package */
/* compiled from: AlertController */
public class c0 implements Runnable {
    public final /* synthetic */ View f;
    public final /* synthetic */ View g;
    public final /* synthetic */ AlertController h;

    public c0(AlertController alertController, View view, View view2) {
        this.h = alertController;
        this.f = view;
        this.g = view2;
    }

    public void run() {
        AlertController.c(this.h.g, this.f, this.g);
    }
}
