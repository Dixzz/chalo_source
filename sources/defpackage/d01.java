package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import java.io.Serializable;
import java.util.HashMap;

/* renamed from: d01  reason: default package */
/* compiled from: DigitalTripReceiptHistoryFragmentDirections */
public class d01 implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f772a;

    public d01(String str, String str2, SuperPassSubType superPassSubType, long j, c01 c01) {
        HashMap hashMap = new HashMap();
        this.f772a = hashMap;
        if (str != null) {
            hashMap.put("arg_source", str);
            if (str2 != null) {
                hashMap.put("arg_superPassId", str2);
                if (superPassSubType != null) {
                    hashMap.put("arg_superPassSubType", superPassSubType);
                    hashMap.put("arg_activationTimeStamp", Long.valueOf(j));
                    return;
                }
                throw new IllegalArgumentException("Argument \"arg_superPassSubType\" is marked as non-null but was passed a null value.");
            }
            throw new IllegalArgumentException("Argument \"arg_superPassId\" is marked as non-null but was passed a null value.");
        }
        throw new IllegalArgumentException("Argument \"arg_source\" is marked as non-null but was passed a null value.");
    }

    @Override // defpackage.fj
    public int a() {
        return R.id.action_digitalTripReceiptHistoryFragment_to_superPassTripReceiptFragment;
    }

    public long b() {
        return ((Long) this.f772a.get("arg_activationTimeStamp")).longValue();
    }

    public String c() {
        return (String) this.f772a.get("arg_source");
    }

    public String d() {
        return (String) this.f772a.get("arg_superPassId");
    }

    public SuperPassSubType e() {
        return (SuperPassSubType) this.f772a.get("arg_superPassSubType");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d01.class != obj.getClass()) {
            return false;
        }
        d01 d01 = (d01) obj;
        if (this.f772a.containsKey("arg_source") != d01.f772a.containsKey("arg_source")) {
            return false;
        }
        if (c() == null ? d01.c() != null : !c().equals(d01.c())) {
            return false;
        }
        if (this.f772a.containsKey("arg_superPassId") != d01.f772a.containsKey("arg_superPassId")) {
            return false;
        }
        if (d() == null ? d01.d() != null : !d().equals(d01.d())) {
            return false;
        }
        if (this.f772a.containsKey("arg_superPassSubType") != d01.f772a.containsKey("arg_superPassSubType")) {
            return false;
        }
        if (e() == null ? d01.e() == null : e().equals(d01.e())) {
            return this.f772a.containsKey("arg_activationTimeStamp") == d01.f772a.containsKey("arg_activationTimeStamp") && b() == d01.b();
        }
        return false;
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f772a.containsKey("arg_source")) {
            bundle.putString("arg_source", (String) this.f772a.get("arg_source"));
        }
        if (this.f772a.containsKey("arg_superPassId")) {
            bundle.putString("arg_superPassId", (String) this.f772a.get("arg_superPassId"));
        }
        if (this.f772a.containsKey("arg_superPassSubType")) {
            SuperPassSubType superPassSubType = (SuperPassSubType) this.f772a.get("arg_superPassSubType");
            if (Parcelable.class.isAssignableFrom(SuperPassSubType.class) || superPassSubType == null) {
                bundle.putParcelable("arg_superPassSubType", (Parcelable) Parcelable.class.cast(superPassSubType));
            } else if (Serializable.class.isAssignableFrom(SuperPassSubType.class)) {
                bundle.putSerializable("arg_superPassSubType", (Serializable) Serializable.class.cast(superPassSubType));
            } else {
                throw new UnsupportedOperationException(hj1.G(SuperPassSubType.class, new StringBuilder(), " must implement Parcelable or Serializable or must be an Enum."));
            }
        }
        if (this.f772a.containsKey("arg_activationTimeStamp")) {
            bundle.putLong("arg_activationTimeStamp", ((Long) this.f772a.get("arg_activationTimeStamp")).longValue());
        }
        return bundle;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((c() != null ? c().hashCode() : 0) + 31) * 31) + (d() != null ? d().hashCode() : 0)) * 31;
        if (e() != null) {
            i = e().hashCode();
        }
        return hj1.b((hashCode + i) * 31, (int) (b() ^ (b() >>> 32)), 31, R.id.action_digitalTripReceiptHistoryFragment_to_superPassTripReceiptFragment);
    }

    public String toString() {
        StringBuilder j0 = hj1.j0("ActionDigitalTripReceiptHistoryFragmentToSuperPassTripReceiptFragment(actionId=", R.id.action_digitalTripReceiptHistoryFragment_to_superPassTripReceiptFragment, "){argSource=");
        j0.append(c());
        j0.append(", argSuperPassId=");
        j0.append(d());
        j0.append(", argSuperPassSubType=");
        j0.append(e());
        j0.append(", argActivationTimeStamp=");
        j0.append(b());
        j0.append("}");
        return j0.toString();
    }
}
