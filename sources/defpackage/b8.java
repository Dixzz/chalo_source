package defpackage;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import java.util.Locale;
import java.util.Objects;

/* renamed from: b8  reason: default package */
/* compiled from: ContentInfoCompat */
public final class b8 {

    /* renamed from: a  reason: collision with root package name */
    public final ClipData f392a;
    public final int b;
    public final int c;
    public final Uri d;
    public final Bundle e;

    /* renamed from: b8$a */
    /* compiled from: ContentInfoCompat */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public ClipData f393a;
        public int b;
        public int c;
        public Uri d;
        public Bundle e;

        public a(ClipData clipData, int i) {
            this.f393a = clipData;
            this.b = i;
        }
    }

    public b8(a aVar) {
        ClipData clipData = aVar.f393a;
        Objects.requireNonNull(clipData);
        this.f392a = clipData;
        int i = aVar.b;
        if (i < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", "source", 0, 3));
        } else if (i <= 3) {
            this.b = i;
            int i2 = aVar.c;
            if ((i2 & 1) == i2) {
                this.c = i2;
                this.d = aVar.d;
                this.e = aVar.e;
                return;
            }
            StringBuilder i0 = hj1.i0("Requested flags 0x");
            i0.append(Integer.toHexString(i2));
            i0.append(", but only 0x");
            i0.append(Integer.toHexString(1));
            i0.append(" are allowed");
            throw new IllegalArgumentException(i0.toString());
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", "source", 0, 3));
        }
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder i0 = hj1.i0("ContentInfoCompat{clip=");
        i0.append(this.f392a.getDescription());
        i0.append(", source=");
        int i = this.b;
        i0.append(i != 0 ? i != 1 ? i != 2 ? i != 3 ? String.valueOf(i) : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
        i0.append(", flags=");
        int i2 = this.c;
        if ((i2 & 1) != 0) {
            str = "FLAG_CONVERT_TO_PLAIN_TEXT";
        } else {
            str = String.valueOf(i2);
        }
        i0.append(str);
        String str3 = "";
        if (this.d == null) {
            str2 = str3;
        } else {
            StringBuilder i02 = hj1.i0(", hasLinkUri(");
            i02.append(this.d.toString().length());
            i02.append(")");
            str2 = i02.toString();
        }
        i0.append(str2);
        if (this.e != null) {
            str3 = ", hasExtras";
        }
        return hj1.a0(i0, str3, "}");
    }
}
