package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import app.zophop.models.City;

/* renamed from: pi1  reason: default package */
/* compiled from: Utils */
public class pi1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ e80 f;
    public final /* synthetic */ City g;
    public final /* synthetic */ Context h;
    public final /* synthetic */ Class i;

    public pi1(e80 e80, City city, Context context, Class cls) {
        this.f = e80;
        this.g = city;
        this.h = context;
        this.i = cls;
    }

    public void onClick(DialogInterface dialogInterface, int i2) {
        this.f.c(this.g);
        Intent intent = new Intent(this.h, this.i);
        intent.addFlags(32768);
        this.h.startActivity(intent);
        dialogInterface.dismiss();
    }
}
