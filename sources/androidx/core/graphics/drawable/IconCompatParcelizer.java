package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import java.nio.charset.Charset;
import java.util.Objects;

public class IconCompatParcelizer {
    public static IconCompat read(no noVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f204a = noVar.k(iconCompat.f204a, 1);
        byte[] bArr = iconCompat.c;
        if (noVar.i(2)) {
            bArr = noVar.g();
        }
        iconCompat.c = bArr;
        iconCompat.d = noVar.m(iconCompat.d, 3);
        iconCompat.e = noVar.k(iconCompat.e, 4);
        iconCompat.f = noVar.k(iconCompat.f, 5);
        iconCompat.g = (ColorStateList) noVar.m(iconCompat.g, 6);
        String str = iconCompat.i;
        if (noVar.i(7)) {
            str = noVar.n();
        }
        iconCompat.i = str;
        String str2 = iconCompat.j;
        if (noVar.i(8)) {
            str2 = noVar.n();
        }
        iconCompat.j = str2;
        iconCompat.h = PorterDuff.Mode.valueOf(iconCompat.i);
        switch (iconCompat.f204a) {
            case -1:
                Parcelable parcelable = iconCompat.d;
                if (parcelable != null) {
                    iconCompat.b = parcelable;
                    break;
                } else {
                    throw new IllegalArgumentException("Invalid icon");
                }
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.d;
                if (parcelable2 == null) {
                    byte[] bArr2 = iconCompat.c;
                    iconCompat.b = bArr2;
                    iconCompat.f204a = 3;
                    iconCompat.e = 0;
                    iconCompat.f = bArr2.length;
                    break;
                } else {
                    iconCompat.b = parcelable2;
                    break;
                }
            case 2:
            case 4:
            case 6:
                String str3 = new String(iconCompat.c, Charset.forName("UTF-16"));
                iconCompat.b = str3;
                if (iconCompat.f204a == 2 && iconCompat.j == null) {
                    iconCompat.j = str3.split(ProductDiscountsObject.KEY_DELIMITER, -1)[0];
                    break;
                }
            case 3:
                iconCompat.b = iconCompat.c;
                break;
        }
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, no noVar) {
        Objects.requireNonNull(noVar);
        iconCompat.i = iconCompat.h.name();
        switch (iconCompat.f204a) {
            case -1:
                iconCompat.d = (Parcelable) iconCompat.b;
                break;
            case 1:
            case 5:
                iconCompat.d = (Parcelable) iconCompat.b;
                break;
            case 2:
                iconCompat.c = ((String) iconCompat.b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.c = (byte[]) iconCompat.b;
                break;
            case 4:
            case 6:
                iconCompat.c = iconCompat.b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i = iconCompat.f204a;
        if (-1 != i) {
            noVar.p(1);
            noVar.t(i);
        }
        byte[] bArr = iconCompat.c;
        if (bArr != null) {
            noVar.p(2);
            noVar.r(bArr);
        }
        Parcelable parcelable = iconCompat.d;
        if (parcelable != null) {
            noVar.p(3);
            noVar.u(parcelable);
        }
        int i2 = iconCompat.e;
        if (i2 != 0) {
            noVar.p(4);
            noVar.t(i2);
        }
        int i3 = iconCompat.f;
        if (i3 != 0) {
            noVar.p(5);
            noVar.t(i3);
        }
        ColorStateList colorStateList = iconCompat.g;
        if (colorStateList != null) {
            noVar.p(6);
            noVar.u(colorStateList);
        }
        String str = iconCompat.i;
        if (str != null) {
            noVar.p(7);
            noVar.v(str);
        }
        String str2 = iconCompat.j;
        if (str2 != null) {
            noVar.p(8);
            noVar.v(str2);
        }
    }
}
