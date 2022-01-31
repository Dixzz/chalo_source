package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: i5  reason: default package */
/* compiled from: NotificationCompat */
public final class i5 {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<c5> f1477a = new ArrayList<>();
    public int b = 1;
    public PendingIntent c;
    public ArrayList<Notification> d = new ArrayList<>();
    public Bitmap e;
    public int f;
    public int g = 8388613;
    public int h = -1;
    public int i = 0;
    public int j;
    public int k = 80;
    public int l;
    public String m;
    public String n;

    public f5 a(f5 f5Var) {
        Notification.Action.Builder builder;
        Bundle bundle;
        Icon icon;
        Bundle bundle2 = new Bundle();
        if (!this.f1477a.isEmpty()) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.f1477a.size());
            Iterator<c5> it = this.f1477a.iterator();
            while (it.hasNext()) {
                c5 next = it.next();
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 23) {
                    IconCompat a2 = next.a();
                    if (a2 == null) {
                        icon = null;
                    } else {
                        icon = a2.f();
                    }
                    builder = new Notification.Action.Builder(icon, next.j, next.k);
                } else {
                    IconCompat a3 = next.a();
                    builder = new Notification.Action.Builder((a3 == null || a3.d() != 2) ? 0 : a3.c(), next.j, next.k);
                }
                if (next.f519a != null) {
                    bundle = new Bundle(next.f519a);
                } else {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android.support.allowGeneratedReplies", next.e);
                if (i2 >= 24) {
                    builder.setAllowGeneratedReplies(next.e);
                }
                builder.addExtras(bundle);
                n5[] n5VarArr = next.c;
                if (n5VarArr != null) {
                    for (RemoteInput remoteInput : n5.a(n5VarArr)) {
                        builder.addRemoteInput(remoteInput);
                    }
                }
                arrayList.add(builder.build());
            }
            bundle2.putParcelableArrayList("actions", arrayList);
        }
        int i3 = this.b;
        if (i3 != 1) {
            bundle2.putInt("flags", i3);
        }
        PendingIntent pendingIntent = this.c;
        if (pendingIntent != null) {
            bundle2.putParcelable("displayIntent", pendingIntent);
        }
        if (!this.d.isEmpty()) {
            ArrayList<Notification> arrayList2 = this.d;
            bundle2.putParcelableArray("pages", (Parcelable[]) arrayList2.toArray(new Notification[arrayList2.size()]));
        }
        Bitmap bitmap = this.e;
        if (bitmap != null) {
            bundle2.putParcelable(ProductPromotionsObject.KEY_BACKGROUND, bitmap);
        }
        int i4 = this.f;
        if (i4 != 0) {
            bundle2.putInt("contentIcon", i4);
        }
        int i5 = this.g;
        if (i5 != 8388613) {
            bundle2.putInt("contentIconGravity", i5);
        }
        int i6 = this.h;
        if (i6 != -1) {
            bundle2.putInt("contentActionIndex", i6);
        }
        int i7 = this.i;
        if (i7 != 0) {
            bundle2.putInt("customSizePreset", i7);
        }
        int i8 = this.j;
        if (i8 != 0) {
            bundle2.putInt("customContentHeight", i8);
        }
        int i9 = this.k;
        if (i9 != 80) {
            bundle2.putInt("gravity", i9);
        }
        int i10 = this.l;
        if (i10 != 0) {
            bundle2.putInt("hintScreenTimeout", i10);
        }
        String str = this.m;
        if (str != null) {
            bundle2.putString("dismissalId", str);
        }
        String str2 = this.n;
        if (str2 != null) {
            bundle2.putString("bridgeTag", str2);
        }
        f5Var.c().putBundle("android.wearable.EXTENSIONS", bundle2);
        return f5Var;
    }

    public Object clone() throws CloneNotSupportedException {
        i5 i5Var = new i5();
        i5Var.f1477a = new ArrayList<>(this.f1477a);
        i5Var.b = this.b;
        i5Var.c = this.c;
        i5Var.d = new ArrayList<>(this.d);
        i5Var.e = this.e;
        i5Var.f = this.f;
        i5Var.g = this.g;
        i5Var.h = this.h;
        i5Var.i = this.i;
        i5Var.j = this.j;
        i5Var.k = this.k;
        i5Var.l = this.l;
        i5Var.m = this.m;
        i5Var.n = this.n;
        return i5Var;
    }
}
