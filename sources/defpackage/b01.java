package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import java.io.Serializable;
import java.util.HashMap;

/* renamed from: b01  reason: default package */
/* compiled from: DigitalTripReceiptHistoryFragmentArgs */
public class b01 implements wi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f359a = new HashMap();

    public static b01 fromBundle(Bundle bundle) {
        b01 b01 = new b01();
        bundle.setClassLoader(b01.class.getClassLoader());
        if (bundle.containsKey("arg_source")) {
            String string = bundle.getString("arg_source");
            if (string != null) {
                b01.f359a.put("arg_source", string);
                if (bundle.containsKey("arg_superPassId")) {
                    String string2 = bundle.getString("arg_superPassId");
                    if (string2 != null) {
                        b01.f359a.put("arg_superPassId", string2);
                        if (!bundle.containsKey("arg_superPassSubType")) {
                            throw new IllegalArgumentException("Required argument \"arg_superPassSubType\" is missing and does not have an android:defaultValue");
                        } else if (Parcelable.class.isAssignableFrom(SuperPassSubType.class) || Serializable.class.isAssignableFrom(SuperPassSubType.class)) {
                            SuperPassSubType superPassSubType = (SuperPassSubType) bundle.get("arg_superPassSubType");
                            if (superPassSubType != null) {
                                b01.f359a.put("arg_superPassSubType", superPassSubType);
                                return b01;
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

    public String a() {
        return (String) this.f359a.get("arg_source");
    }

    public String b() {
        return (String) this.f359a.get("arg_superPassId");
    }

    public SuperPassSubType c() {
        return (SuperPassSubType) this.f359a.get("arg_superPassSubType");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b01.class != obj.getClass()) {
            return false;
        }
        b01 b01 = (b01) obj;
        if (this.f359a.containsKey("arg_source") != b01.f359a.containsKey("arg_source")) {
            return false;
        }
        if (a() == null ? b01.a() != null : !a().equals(b01.a())) {
            return false;
        }
        if (this.f359a.containsKey("arg_superPassId") != b01.f359a.containsKey("arg_superPassId")) {
            return false;
        }
        if (b() == null ? b01.b() != null : !b().equals(b01.b())) {
            return false;
        }
        if (this.f359a.containsKey("arg_superPassSubType") != b01.f359a.containsKey("arg_superPassSubType")) {
            return false;
        }
        return c() == null ? b01.c() == null : c().equals(b01.c());
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((a() != null ? a().hashCode() : 0) + 31) * 31) + (b() != null ? b().hashCode() : 0)) * 31;
        if (c() != null) {
            i = c().hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("DigitalTripReceiptHistoryFragmentArgs{argSource=");
        i0.append(a());
        i0.append(", argSuperPassId=");
        i0.append(b());
        i0.append(", argSuperPassSubType=");
        i0.append(c());
        i0.append("}");
        return i0.toString();
    }
}
