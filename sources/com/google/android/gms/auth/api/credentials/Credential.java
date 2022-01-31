package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new zz1();
    @Nonnull
    public final String f;
    public final String g;
    public final Uri h;
    @Nonnull
    public final List<IdToken> i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;

    public Credential(String str, String str2, Uri uri, List<IdToken> list, String str3, String str4, String str5, String str6) {
        List<IdToken> list2;
        gj1.l(str, "credential identifier cannot be null");
        String trim = str.trim();
        gj1.i(trim, "credential identifier cannot be empty");
        if (str3 == null || !TextUtils.isEmpty(str3)) {
            if (str4 != null) {
                boolean z = false;
                if (!TextUtils.isEmpty(str4)) {
                    Uri parse = Uri.parse(str4);
                    if (parse.isAbsolute() && parse.isHierarchical() && !TextUtils.isEmpty(parse.getScheme()) && !TextUtils.isEmpty(parse.getAuthority()) && ("http".equalsIgnoreCase(parse.getScheme()) || "https".equalsIgnoreCase(parse.getScheme()))) {
                        z = true;
                    }
                }
                if (!Boolean.valueOf(z).booleanValue()) {
                    throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
                }
            }
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                if (str2 != null && TextUtils.isEmpty(str2.trim())) {
                    str2 = null;
                }
                this.g = str2;
                this.h = uri;
                if (list == null) {
                    list2 = Collections.emptyList();
                } else {
                    list2 = Collections.unmodifiableList(list);
                }
                this.i = list2;
                this.f = trim;
                this.j = str3;
                this.k = str4;
                this.l = str5;
                this.m = str6;
                return;
            }
            throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
        }
        throw new IllegalArgumentException("Password must not be empty if set");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.f, credential.f) && TextUtils.equals(this.g, credential.g) && gj1.G(this.h, credential.h) && TextUtils.equals(this.j, credential.j) && TextUtils.equals(this.k, credential.k);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f, this.g, this.h, this.j, this.k});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.f, false);
        gj1.B0(parcel, 2, this.g, false);
        gj1.A0(parcel, 3, this.h, i2, false);
        gj1.F0(parcel, 4, this.i, false);
        gj1.B0(parcel, 5, this.j, false);
        gj1.B0(parcel, 6, this.k, false);
        gj1.B0(parcel, 9, this.l, false);
        gj1.B0(parcel, 10, this.m, false);
        gj1.H1(parcel, o1);
    }
}
