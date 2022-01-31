package defpackage;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* renamed from: c5  reason: default package */
/* compiled from: NotificationCompat */
public class c5 {

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f519a;
    public IconCompat b;
    public final n5[] c;
    public final n5[] d;
    public boolean e;
    public boolean f = true;
    public final int g;
    public final boolean h;
    @Deprecated
    public int i;
    public CharSequence j;
    public PendingIntent k;

    /* renamed from: c5$a */
    /* compiled from: NotificationCompat */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final IconCompat f520a;
        public final CharSequence b;
        public final PendingIntent c;
        public boolean d;
        public final Bundle e;
        public ArrayList<n5> f;
        public boolean g;

        public a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            IconCompat b2 = i == 0 ? null : IconCompat.b(null, "", i);
            Bundle bundle = new Bundle();
            this.d = true;
            this.g = true;
            this.f520a = b2;
            this.b = f5.d(charSequence);
            this.c = pendingIntent;
            this.e = bundle;
            this.f = null;
            this.d = true;
            this.g = true;
        }

        public c5 a() {
            n5[] n5VarArr;
            CharSequence[] charSequenceArr;
            Set<String> set;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList<n5> arrayList3 = this.f;
            if (arrayList3 != null) {
                Iterator<n5> it = arrayList3.iterator();
                while (it.hasNext()) {
                    n5 next = it.next();
                    if (!next.d && ((charSequenceArr = next.c) == null || charSequenceArr.length == 0) && (set = next.g) != null && !set.isEmpty()) {
                        arrayList.add(next);
                    } else {
                        arrayList2.add(next);
                    }
                }
            }
            n5[] n5VarArr2 = null;
            if (arrayList.isEmpty()) {
                n5VarArr = null;
            } else {
                n5VarArr = (n5[]) arrayList.toArray(new n5[arrayList.size()]);
            }
            if (!arrayList2.isEmpty()) {
                n5VarArr2 = (n5[]) arrayList2.toArray(new n5[arrayList2.size()]);
            }
            return new c5(this.f520a, this.b, this.c, this.e, n5VarArr2, n5VarArr, this.d, 0, this.g, false);
        }
    }

    public c5(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, n5[] n5VarArr, n5[] n5VarArr2, boolean z, int i2, boolean z2, boolean z3) {
        this.b = iconCompat;
        if (iconCompat != null && iconCompat.d() == 2) {
            this.i = iconCompat.c();
        }
        this.j = f5.d(charSequence);
        this.k = pendingIntent;
        this.f519a = bundle == null ? new Bundle() : bundle;
        this.c = n5VarArr;
        this.d = n5VarArr2;
        this.e = z;
        this.g = i2;
        this.f = z2;
        this.h = z3;
    }

    public IconCompat a() {
        int i2;
        if (this.b == null && (i2 = this.i) != 0) {
            this.b = IconCompat.b(null, "", i2);
        }
        return this.b;
    }
}
