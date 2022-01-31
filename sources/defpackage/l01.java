package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import java.io.Serializable;
import java.util.HashMap;

/* renamed from: l01  reason: default package */
/* compiled from: SuperPassTripReceiptFragmentArgs */
public class l01 implements wi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f2145a = new HashMap();

    public static l01 fromBundle(Bundle bundle) {
        l01 l01 = new l01();
        bundle.setClassLoader(l01.class.getClassLoader());
        if (bundle.containsKey("arg_source")) {
            String string = bundle.getString("arg_source");
            if (string != null) {
                l01.f2145a.put("arg_source", string);
                if (bundle.containsKey("arg_superPassId")) {
                    String string2 = bundle.getString("arg_superPassId");
                    if (string2 != null) {
                        l01.f2145a.put("arg_superPassId", string2);
                        if (!bundle.containsKey("arg_superPassSubType")) {
                            throw new IllegalArgumentException("Required argument \"arg_superPassSubType\" is missing and does not have an android:defaultValue");
                        } else if (Parcelable.class.isAssignableFrom(SuperPassSubType.class) || Serializable.class.isAssignableFrom(SuperPassSubType.class)) {
                            SuperPassSubType superPassSubType = (SuperPassSubType) bundle.get("arg_superPassSubType");
                            if (superPassSubType != null) {
                                l01.f2145a.put("arg_superPassSubType", superPassSubType);
                                if (bundle.containsKey("arg_activationTimeStamp")) {
                                    l01.f2145a.put("arg_activationTimeStamp", Long.valueOf(bundle.getLong("arg_activationTimeStamp")));
                                    return l01;
                                }
                                throw new IllegalArgumentException("Required argument \"arg_activationTimeStamp\" is missing and does not have an android:defaultValue");
                            }
                            throw new IllegalArgumentException("Argument \"arg_superPassSubType\" is marked as non-null but was passed a null value.");
                        } else {
                            throw new UnsupportedOperationException(hj1.G(SuperPassSubType.class, new StringBuilder(), " must implement Parcelable or Serializable or must be an Enum."));
                        }
                    } else {
                        throw new IllegalArgumentException("Argument \"arg_superPassId\" is marked as non-null but was passed a null value.");
                    }
                } else {
                    throw new IllegalArgumentException("Required argument \"arg_superPassId\" is missing and does not have an android:defaultValue");
                }
            } else {
                throw new IllegalArgumentException("Argument \"arg_source\" is marked as non-null but was passed a null value.");
            }
        } else {
            throw new IllegalArgumentException("Required argument \"arg_source\" is missing and does not have an android:defaultValue");
        }
    }

    public long a() {
        return ((Long) this.f2145a.get("arg_activationTimeStamp")).longValue();
    }

    public String b() {
        return (String) this.f2145a.get("arg_source");
    }

    public String c() {
        return (String) this.f2145a.get("arg_superPassId");
    }

    public SuperPassSubType d() {
        return (SuperPassSubType) this.f2145a.get("arg_superPassSubType");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l01.class != obj.getClass()) {
            return false;
        }
        l01 l01 = (l01) obj;
        if (this.f2145a.containsKey("arg_source") != l01.f2145a.containsKey("arg_source")) {
            return false;
        }
        if (b() == null ? l01.b() != null : !b().equals(l01.b())) {
            return false;
        }
        if (this.f2145a.containsKey("arg_superPassId") != l01.f2145a.containsKey("arg_superPassId")) {
            return false;
        }
        if (c() == null ? l01.c() != null : !c().equals(l01.c())) {
            return false;
        }
        if (this.f2145a.containsKey("arg_superPassSubType") != l01.f2145a.containsKey("arg_superPassSubType")) {
            return false;
        }
        if (d() == null ? l01.d() == null : d().equals(l01.d())) {
            return this.f2145a.containsKey("arg_activationTimeStamp") == l01.f2145a.containsKey("arg_activationTimeStamp") && a() == l01.a();
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((b() != null ? b().hashCode() : 0) + 31) * 31) + (c() != null ? c().hashCode() : 0)) * 31;
        if (d() != null) {
            i = d().hashCode();
        }
        return ((hashCode + i) * 31) + ((int) (a() ^ (a() >>> 32)));
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SuperPassTripReceiptFragmentArgs{argSource=");
        i0.append(b());
        i0.append(", argSuperPassId=");
        i0.append(c());
        i0.append(", argSuperPassSubType=");
        i0.append(d());
        i0.append(", argActivationTimeStamp=");
        i0.append(a());
        i0.append("}");
        return i0.toString();
    }
}
