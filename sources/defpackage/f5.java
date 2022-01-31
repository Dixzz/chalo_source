package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.R;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: f5  reason: default package */
/* compiled from: NotificationCompat */
public class f5 {

    /* renamed from: a  reason: collision with root package name */
    public Context f1091a;
    public ArrayList<c5> b = new ArrayList<>();
    public ArrayList<m5> c = new ArrayList<>();
    public ArrayList<c5> d = new ArrayList<>();
    public CharSequence e;
    public CharSequence f;
    public PendingIntent g;
    public Bitmap h;
    public int i;
    public int j;
    public boolean k = true;
    public h5 l;
    public CharSequence m;
    public boolean n = false;
    public String o;
    public Bundle p;
    public int q = 0;
    public int r = 0;
    public Notification s;
    public String t;
    public boolean u;
    public Notification v;
    @Deprecated
    public ArrayList<String> w;

    public f5(Context context, String str) {
        Notification notification = new Notification();
        this.v = notification;
        this.f1091a = context;
        this.t = str;
        notification.when = System.currentTimeMillis();
        this.v.audioStreamType = -1;
        this.j = 0;
        this.w = new ArrayList<>();
        this.u = true;
    }

    public static CharSequence d(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public f5 a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
        IconCompat iconCompat;
        ArrayList<c5> arrayList = this.b;
        if (i2 == 0) {
            iconCompat = null;
        } else {
            iconCompat = IconCompat.b(null, "", i2);
        }
        arrayList.add(new c5(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false));
        return this;
    }

    public Notification b() {
        Notification notification;
        Bundle bundle;
        j5 j5Var = new j5(this);
        h5 h5Var = j5Var.c.l;
        if (h5Var != null) {
            h5Var.b(j5Var);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            notification = j5Var.b.build();
        } else if (i2 >= 24) {
            notification = j5Var.b.build();
        } else {
            j5Var.b.setExtras(j5Var.e);
            notification = j5Var.b.build();
        }
        Objects.requireNonNull(j5Var.c);
        if (h5Var != null) {
            Objects.requireNonNull(j5Var.c.l);
        }
        if (!(h5Var == null || (bundle = notification.extras) == null)) {
            h5Var.a(bundle);
        }
        return notification;
    }

    public Bundle c() {
        if (this.p == null) {
            this.p = new Bundle();
        }
        return this.p;
    }

    public f5 e(String str) {
        this.t = str;
        return this;
    }

    public f5 f(CharSequence charSequence) {
        this.f = d(charSequence);
        return this;
    }

    public f5 g(CharSequence charSequence) {
        this.e = d(charSequence);
        return this;
    }

    public f5 h(int i2) {
        Notification notification = this.v;
        notification.defaults = i2;
        if ((i2 & 4) != 0) {
            notification.flags |= 1;
        }
        return this;
    }

    public final void i(int i2, boolean z) {
        if (z) {
            Notification notification = this.v;
            notification.flags = i2 | notification.flags;
            return;
        }
        Notification notification2 = this.v;
        notification2.flags = (~i2) & notification2.flags;
    }

    public f5 j(Bitmap bitmap) {
        if (bitmap != null && Build.VERSION.SDK_INT < 27) {
            Resources resources = this.f1091a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                double min = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
                bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * min), (int) Math.ceil(((double) bitmap.getHeight()) * min), true);
            }
        }
        this.h = bitmap;
        return this;
    }

    public f5 k(Uri uri) {
        Notification notification = this.v;
        notification.sound = uri;
        notification.audioStreamType = -1;
        notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
        return this;
    }

    public f5 l(h5 h5Var) {
        if (this.l != h5Var) {
            this.l = h5Var;
            if (!(h5Var == null || h5Var.f1340a == this)) {
                h5Var.f1340a = this;
                l(h5Var);
            }
        }
        return this;
    }

    public f5 m(CharSequence charSequence) {
        this.m = d(charSequence);
        return this;
    }

    public f5 n(CharSequence charSequence) {
        this.v.tickerText = d(charSequence);
        return this;
    }
}
