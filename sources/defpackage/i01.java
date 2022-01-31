package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import java.io.Serializable;
import java.util.HashMap;

/* renamed from: i01  reason: default package */
/* compiled from: SuperPassBookingSummaryFragmentDirections */
public class i01 implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1455a;

    public i01(String str, String str2, SuperPassSubType superPassSubType, h01 h01) {
        HashMap hashMap = new HashMap();
        this.f1455a = hashMap;
        if (str != null) {
            hashMap.put("arg_source", str);
            if (str2 != null) {
                hashMap.put("arg_superPassId", str2);
                if (superPassSubType != null) {
                    hashMap.put("arg_superPassSubType", superPassSubType);
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
        return R.id.action_superPassBookingSummaryFragment_to_digitalTripReceiptHistoryFragment;
    }

    public String b() {
        return (String) this.f1455a.get("arg_source");
    }

    public String c() {
        return (String) this.f1455a.get("arg_superPassId");
    }

    public SuperPassSubType d() {
        return (SuperPassSubType) this.f1455a.get("arg_superPassSubType");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i01.class != obj.getClass()) {
            return false;
        }
        i01 i01 = (i01) obj;
        if (this.f1455a.containsKey("arg_source") != i01.f1455a.containsKey("arg_source")) {
            return false;
        }
        if (b() == null ? i01.b() != null : !b().equals(i01.b())) {
            return false;
        }
        if (this.f1455a.containsKey("arg_superPassId") != i01.f1455a.containsKey("arg_superPassId")) {
            return false;
        }
        if (c() == null ? i01.c() != null : !c().equals(i01.c())) {
            return false;
        }
        if (this.f1455a.containsKey("arg_superPassSubType") != i01.f1455a.containsKey("arg_superPassSubType")) {
            return false;
        }
        return d() == null ? i01.d() == null : d().equals(i01.d());
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f1455a.containsKey("arg_source")) {
            bundle.putString("arg_source", (String) this.f1455a.get("arg_source"));
        }
        if (this.f1455a.containsKey("arg_superPassId")) {
            bundle.putString("arg_superPassId", (String) this.f1455a.get("arg_superPassId"));
        }
        if (this.f1455a.containsKey("arg_superPassSubType")) {
            SuperPassSubType superPassSubType = (SuperPassSubType) this.f1455a.get("arg_superPassSubType");
            if (Parcelable.class.isAssignableFrom(SuperPassSubType.class) || superPassSubType == null) {
                bundle.putParcelable("arg_superPassSubType", (Parcelable) Parcelable.class.cast(superPassSubType));
            } else if (Serializable.class.isAssignableFrom(SuperPassSubType.class)) {
                bundle.putSerializable("arg_superPassSubType", (Serializable) Serializable.class.cast(superPassSubType));
            } else {
                throw new UnsupportedOperationException(hj1.G(SuperPassSubType.class, new StringBuilder(), " must implement Parcelable or Serializable or must be an Enum."));
            }
        }
        return bundle;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((b() != null ? b().hashCode() : 0) + 31) * 31) + (c() != null ? c().hashCode() : 0)) * 31;
        if (d() != null) {
            i = d().hashCode();
        }
        return hj1.b(hashCode, i, 31, R.id.action_superPassBookingSummaryFragment_to_digitalTripReceiptHistoryFragment);
    }

    public String toString() {
        StringBuilder j0 = hj1.j0("ActionSuperPassBookingSummaryFragmentToDigitalTripReceiptHistoryFragment(actionId=", R.id.action_superPassBookingSummaryFragment_to_digitalTripReceiptHistoryFragment, "){argSource=");
        j0.append(b());
        j0.append(", argSuperPassId=");
        j0.append(c());
        j0.append(", argSuperPassSubType=");
        j0.append(d());
        j0.append("}");
        return j0.toString();
    }
}
