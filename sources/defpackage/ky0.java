package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import app.zophop.models.mTicketing.CardRechargeConfiguration;
import java.io.Serializable;
import java.util.HashMap;

/* renamed from: ky0  reason: default package */
/* compiled from: CardDetailsFragmentArgs */
public class ky0 implements wi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f2135a = new HashMap();

    public static ky0 fromBundle(Bundle bundle) {
        ky0 ky0 = new ky0();
        bundle.setClassLoader(ky0.class.getClassLoader());
        if (!bundle.containsKey("arg_cardRechargeConfiguration")) {
            throw new IllegalArgumentException("Required argument \"arg_cardRechargeConfiguration\" is missing and does not have an android:defaultValue");
        } else if (Parcelable.class.isAssignableFrom(CardRechargeConfiguration.class) || Serializable.class.isAssignableFrom(CardRechargeConfiguration.class)) {
            CardRechargeConfiguration cardRechargeConfiguration = (CardRechargeConfiguration) bundle.get("arg_cardRechargeConfiguration");
            if (cardRechargeConfiguration != null) {
                ky0.f2135a.put("arg_cardRechargeConfiguration", cardRechargeConfiguration);
                return ky0;
            }
            throw new IllegalArgumentException("Argument \"arg_cardRechargeConfiguration\" is marked as non-null but was passed a null value.");
        } else {
            throw new UnsupportedOperationException(hj1.G(CardRechargeConfiguration.class, new StringBuilder(), " must implement Parcelable or Serializable or must be an Enum."));
        }
    }

    public CardRechargeConfiguration a() {
        return (CardRechargeConfiguration) this.f2135a.get("arg_cardRechargeConfiguration");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ky0.class != obj.getClass()) {
            return false;
        }
        ky0 ky0 = (ky0) obj;
        if (this.f2135a.containsKey("arg_cardRechargeConfiguration") != ky0.f2135a.containsKey("arg_cardRechargeConfiguration")) {
            return false;
        }
        return a() == null ? ky0.a() == null : a().equals(ky0.a());
    }

    public int hashCode() {
        return 31 + (a() != null ? a().hashCode() : 0);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CardDetailsFragmentArgs{argCardRechargeConfiguration=");
        i0.append(a());
        i0.append("}");
        return i0.toString();
    }
}
