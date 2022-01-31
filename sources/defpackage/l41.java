package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import app.zophop.ui.enums.TicketVerificationStatus;
import java.io.Serializable;
import java.util.HashMap;

/* renamed from: l41  reason: default package */
/* compiled from: SoundVerificationFragmentSuperPassArgs */
public class l41 implements wi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f2160a = new HashMap();

    public static l41 fromBundle(Bundle bundle) {
        l41 l41 = new l41();
        bundle.setClassLoader(l41.class.getClassLoader());
        if (bundle.containsKey("arg_soure")) {
            String string = bundle.getString("arg_soure");
            if (string != null) {
                l41.f2160a.put("arg_soure", string);
            } else {
                throw new IllegalArgumentException("Argument \"arg_soure\" is marked as non-null but was passed a null value.");
            }
        } else {
            l41.f2160a.put("arg_soure", "\"\"");
        }
        if (!bundle.containsKey("arg_verification_status")) {
            throw new IllegalArgumentException("Required argument \"arg_verification_status\" is missing and does not have an android:defaultValue");
        } else if (Parcelable.class.isAssignableFrom(TicketVerificationStatus.class) || Serializable.class.isAssignableFrom(TicketVerificationStatus.class)) {
            TicketVerificationStatus ticketVerificationStatus = (TicketVerificationStatus) bundle.get("arg_verification_status");
            if (ticketVerificationStatus != null) {
                l41.f2160a.put("arg_verification_status", ticketVerificationStatus);
                return l41;
            }
            throw new IllegalArgumentException("Argument \"arg_verification_status\" is marked as non-null but was passed a null value.");
        } else {
            throw new UnsupportedOperationException(hj1.G(TicketVerificationStatus.class, new StringBuilder(), " must implement Parcelable or Serializable or must be an Enum."));
        }
    }

    public String a() {
        return (String) this.f2160a.get("arg_soure");
    }

    public TicketVerificationStatus b() {
        return (TicketVerificationStatus) this.f2160a.get("arg_verification_status");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l41.class != obj.getClass()) {
            return false;
        }
        l41 l41 = (l41) obj;
        if (this.f2160a.containsKey("arg_soure") != l41.f2160a.containsKey("arg_soure")) {
            return false;
        }
        if (a() == null ? l41.a() != null : !a().equals(l41.a())) {
            return false;
        }
        if (this.f2160a.containsKey("arg_verification_status") != l41.f2160a.containsKey("arg_verification_status")) {
            return false;
        }
        return b() == null ? l41.b() == null : b().equals(l41.b());
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((a() != null ? a().hashCode() : 0) + 31) * 31;
        if (b() != null) {
            i = b().hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SoundVerificationFragmentSuperPassArgs{argSoure=");
        i0.append(a());
        i0.append(", argVerificationStatus=");
        i0.append(b());
        i0.append("}");
        return i0.toString();
    }
}
