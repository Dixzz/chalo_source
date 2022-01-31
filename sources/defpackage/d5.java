package defpackage;

import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;

/* renamed from: d5  reason: default package */
/* compiled from: NotificationCompat */
public class d5 extends h5 {
    public Bitmap e;
    public IconCompat f;
    public boolean g;

    @Override // defpackage.h5
    public void b(b5 b5Var) {
        int i = Build.VERSION.SDK_INT;
        j5 j5Var = (j5) b5Var;
        Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(j5Var.b).setBigContentTitle(this.b).bigPicture(this.e);
        if (this.g) {
            IconCompat iconCompat = this.f;
            Bitmap bitmap = null;
            if (iconCompat == null) {
                bigPicture.bigLargeIcon((Bitmap) null);
            } else if (i >= 23) {
                bigPicture.bigLargeIcon(iconCompat.g(j5Var.f1878a));
            } else if (iconCompat.d() == 1) {
                IconCompat iconCompat2 = this.f;
                int i2 = iconCompat2.f204a;
                if (i2 == -1 && i >= 23) {
                    Object obj = iconCompat2.b;
                    if (obj instanceof Bitmap) {
                        bitmap = (Bitmap) obj;
                    }
                } else if (i2 == 1) {
                    bitmap = (Bitmap) iconCompat2.b;
                } else if (i2 == 5) {
                    bitmap = IconCompat.a((Bitmap) iconCompat2.b, true);
                } else {
                    throw new IllegalStateException("called getBitmap() on " + iconCompat2);
                }
                bigPicture.bigLargeIcon(bitmap);
            } else {
                bigPicture.bigLargeIcon((Bitmap) null);
            }
        }
        if (this.d) {
            bigPicture.setSummaryText(this.c);
        }
    }

    @Override // defpackage.h5
    public String c() {
        return "androidx.core.app.NotificationCompat$BigPictureStyle";
    }

    public d5 d(Bitmap bitmap) {
        this.f = null;
        this.g = true;
        return this;
    }

    public d5 e(CharSequence charSequence) {
        this.c = f5.d(charSequence);
        this.d = true;
        return this;
    }
}
