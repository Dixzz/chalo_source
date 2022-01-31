package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import app.zophop.models.mTicketing.CardRechargeConfiguration;
import java.io.Serializable;
import java.util.HashMap;

/* renamed from: qy0  reason: default package */
/* compiled from: CardRechargeAmountFragmentArgs */
public class qy0 implements wi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f3005a = new HashMap();

    public static qy0 fromBundle(Bundle bundle) {
        qy0 qy0 = new qy0();
        bundle.setClassLoader(qy0.class.getClassLoader());
        if (!bundle.containsKey("arg_cardRechargeConfiguration")) {
            throw new IllegalArgumentException("Required argument \"arg_cardRechargeConfiguration\" is missing and does not have an android:defaultValue");
        } else if (Parcelable.class.isAssignableFrom(CardRechargeConfiguration.class) || Serializable.class.isAssignableFrom(CardRechargeConfiguration.class)) {
            CardRechargeConfiguration cardRechargeConfiguration = (CardRechargeConfiguration) bundle.get("arg_cardRechargeConfiguration");
            if (cardRechargeConfiguration != null) {
                qy0.f3005a.put("arg_cardRechargeConfiguration", cardRechargeConfiguration);
                if (bundle.containsKey("arg_rechargeLimit")) {
                    qy0.f3005a.put("arg_rechargeLimit", Long.valueOf(bundle.getLong("arg_rechargeLimit")));
                    if (bundle.containsKey("arg_cardNumber")) {
                        String string = bundle.getString("arg_cardNumber");
                        if (string != null) {
                            qy0.f3005a.put("arg_cardNumber", string);
                            return qy0;
                        }
                        throw new IllegalArgumentException("Argument \"arg_cardNumber\" is marked as non-null but was passed a null value.");
                    }
                    throw new IllegalArgumentException("Required argument \"arg_cardNumber\" is missing and does not have an android:defaultValue");
                }
                throw new IllegalArgumentException("Required argument \"arg_rechargeLimit\" is missing and does not have an android:defaultValue");
            }
            throw new IllegalArgumentException("Argument \"arg_cardRechargeConfiguration\" is marked as non-null but was passed a null value.");
        } else {
            throw new UnsupportedOperationException(hj1.G(CardRechargeConfiguration.class, new StringBuilder(), " must implement Parcelable or Serializable or must be an Enum."));
        }
    }

    public String a() {
        return (String) this.f3005a.get("arg_cardNumber");
    }

    public CardRechargeConfiguration b() {
        return (CardRechargeConfiguration) this.f3005a.get("arg_cardRechargeConfiguration");
    }

    public long c() {
        return ((Long) this.f3005a.get("arg_rechargeLimit")).longValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || qy0.class != obj.getClass()) {
            return false;
        }
        qy0 qy0 = (qy0) obj;
        if (this.f3005a.containsKey("arg_cardRechargeConfiguration") != qy0.f3005a.containsKey("arg_cardRechargeConfiguration")) {
            return false;
        }
        if (b() == null ? qy0.b() != null : !b().equals(qy0.b())) {
            return false;
        }
        if (this.f3005a.containsKey("arg_rechargeLimit") == qy0.f3005a.containsKey("arg_rechargeLimit") && c() == qy0.c() && this.f3005a.containsKey("arg_cardNumber") == qy0.f3005a.containsKey("arg_cardNumber")) {
            return a() == null ? qy0.a() == null : a().equals(qy0.a());
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((b() != null ? b().hashCode() : 0) + 31) * 31) + ((int) (c() ^ (c() >>> 32)))) * 31;
        if (a() != null) {
            i = a().hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CardRechargeAmountFragmentArgs{argCardRechargeConfiguration=");
        i0.append(b());
        i0.append(", argRechargeLimit=");
        i0.append(c());
        i0.append(", argCardNumber=");
        i0.append(a());
        i0.append("}");
        return i0.toString();
    }
}
