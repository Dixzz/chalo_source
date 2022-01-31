package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import app.zophop.models.mTicketing.CardRechargeConfiguration;
import java.io.Serializable;
import java.util.HashMap;

/* renamed from: uy0  reason: default package */
/* compiled from: CardRechargeConfirmPaymentFragmentArgs */
public class uy0 implements wi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f3570a = new HashMap();

    public static uy0 fromBundle(Bundle bundle) {
        uy0 uy0 = new uy0();
        bundle.setClassLoader(uy0.class.getClassLoader());
        if (!bundle.containsKey("arg_cardRechargeConfiguration")) {
            throw new IllegalArgumentException("Required argument \"arg_cardRechargeConfiguration\" is missing and does not have an android:defaultValue");
        } else if (Parcelable.class.isAssignableFrom(CardRechargeConfiguration.class) || Serializable.class.isAssignableFrom(CardRechargeConfiguration.class)) {
            CardRechargeConfiguration cardRechargeConfiguration = (CardRechargeConfiguration) bundle.get("arg_cardRechargeConfiguration");
            if (cardRechargeConfiguration != null) {
                uy0.f3570a.put("arg_cardRechargeConfiguration", cardRechargeConfiguration);
                if (bundle.containsKey("arg_rechargeAmount")) {
                    uy0.f3570a.put("arg_rechargeAmount", Long.valueOf(bundle.getLong("arg_rechargeAmount")));
                    if (bundle.containsKey("arg_cardNumber")) {
                        String string = bundle.getString("arg_cardNumber");
                        if (string != null) {
                            uy0.f3570a.put("arg_cardNumber", string);
                            return uy0;
                        }
                        throw new IllegalArgumentException("Argument \"arg_cardNumber\" is marked as non-null but was passed a null value.");
                    }
                    throw new IllegalArgumentException("Required argument \"arg_cardNumber\" is missing and does not have an android:defaultValue");
                }
                throw new IllegalArgumentException("Required argument \"arg_rechargeAmount\" is missing and does not have an android:defaultValue");
            }
            throw new IllegalArgumentException("Argument \"arg_cardRechargeConfiguration\" is marked as non-null but was passed a null value.");
        } else {
            throw new UnsupportedOperationException(hj1.G(CardRechargeConfiguration.class, new StringBuilder(), " must implement Parcelable or Serializable or must be an Enum."));
        }
    }

    public String a() {
        return (String) this.f3570a.get("arg_cardNumber");
    }

    public CardRechargeConfiguration b() {
        return (CardRechargeConfiguration) this.f3570a.get("arg_cardRechargeConfiguration");
    }

    public long c() {
        return ((Long) this.f3570a.get("arg_rechargeAmount")).longValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || uy0.class != obj.getClass()) {
            return false;
        }
        uy0 uy0 = (uy0) obj;
        if (this.f3570a.containsKey("arg_cardRechargeConfiguration") != uy0.f3570a.containsKey("arg_cardRechargeConfiguration")) {
            return false;
        }
        if (b() == null ? uy0.b() != null : !b().equals(uy0.b())) {
            return false;
        }
        if (this.f3570a.containsKey("arg_rechargeAmount") == uy0.f3570a.containsKey("arg_rechargeAmount") && c() == uy0.c() && this.f3570a.containsKey("arg_cardNumber") == uy0.f3570a.containsKey("arg_cardNumber")) {
            return a() == null ? uy0.a() == null : a().equals(uy0.a());
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
        StringBuilder i0 = hj1.i0("CardRechargeConfirmPaymentFragmentArgs{argCardRechargeConfiguration=");
        i0.append(b());
        i0.append(", argRechargeAmount=");
        i0.append(c());
        i0.append(", argCardNumber=");
        i0.append(a());
        i0.append("}");
        return i0.toString();
    }
}
