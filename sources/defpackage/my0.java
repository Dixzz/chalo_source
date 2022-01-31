package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import app.zophop.R;
import app.zophop.models.mTicketing.CardRechargeConfiguration;
import java.io.Serializable;
import java.util.HashMap;

/* renamed from: my0  reason: default package */
/* compiled from: CardDetailsFragmentDirections */
public class my0 implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f2459a;

    public my0(CardRechargeConfiguration cardRechargeConfiguration, long j, String str, ly0 ly0) {
        HashMap hashMap = new HashMap();
        this.f2459a = hashMap;
        if (cardRechargeConfiguration != null) {
            hashMap.put("arg_cardRechargeConfiguration", cardRechargeConfiguration);
            hashMap.put("arg_rechargeLimit", Long.valueOf(j));
            if (str != null) {
                hashMap.put("arg_cardNumber", str);
                return;
            }
            throw new IllegalArgumentException("Argument \"arg_cardNumber\" is marked as non-null but was passed a null value.");
        }
        throw new IllegalArgumentException("Argument \"arg_cardRechargeConfiguration\" is marked as non-null but was passed a null value.");
    }

    @Override // defpackage.fj
    public int a() {
        return R.id.action_cardDetailsFragment_to_cardRechargeAmountFragment;
    }

    public String b() {
        return (String) this.f2459a.get("arg_cardNumber");
    }

    public CardRechargeConfiguration c() {
        return (CardRechargeConfiguration) this.f2459a.get("arg_cardRechargeConfiguration");
    }

    public long d() {
        return ((Long) this.f2459a.get("arg_rechargeLimit")).longValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || my0.class != obj.getClass()) {
            return false;
        }
        my0 my0 = (my0) obj;
        if (this.f2459a.containsKey("arg_cardRechargeConfiguration") != my0.f2459a.containsKey("arg_cardRechargeConfiguration")) {
            return false;
        }
        if (c() == null ? my0.c() != null : !c().equals(my0.c())) {
            return false;
        }
        if (this.f2459a.containsKey("arg_rechargeLimit") == my0.f2459a.containsKey("arg_rechargeLimit") && d() == my0.d() && this.f2459a.containsKey("arg_cardNumber") == my0.f2459a.containsKey("arg_cardNumber")) {
            return b() == null ? my0.b() == null : b().equals(my0.b());
        }
        return false;
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f2459a.containsKey("arg_cardRechargeConfiguration")) {
            CardRechargeConfiguration cardRechargeConfiguration = (CardRechargeConfiguration) this.f2459a.get("arg_cardRechargeConfiguration");
            if (Parcelable.class.isAssignableFrom(CardRechargeConfiguration.class) || cardRechargeConfiguration == null) {
                bundle.putParcelable("arg_cardRechargeConfiguration", (Parcelable) Parcelable.class.cast(cardRechargeConfiguration));
            } else if (Serializable.class.isAssignableFrom(CardRechargeConfiguration.class)) {
                bundle.putSerializable("arg_cardRechargeConfiguration", (Serializable) Serializable.class.cast(cardRechargeConfiguration));
            } else {
                throw new UnsupportedOperationException(hj1.G(CardRechargeConfiguration.class, new StringBuilder(), " must implement Parcelable or Serializable or must be an Enum."));
            }
        }
        if (this.f2459a.containsKey("arg_rechargeLimit")) {
            bundle.putLong("arg_rechargeLimit", ((Long) this.f2459a.get("arg_rechargeLimit")).longValue());
        }
        if (this.f2459a.containsKey("arg_cardNumber")) {
            bundle.putString("arg_cardNumber", (String) this.f2459a.get("arg_cardNumber"));
        }
        return bundle;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((c() != null ? c().hashCode() : 0) + 31) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31;
        if (b() != null) {
            i = b().hashCode();
        }
        return hj1.b(hashCode, i, 31, R.id.action_cardDetailsFragment_to_cardRechargeAmountFragment);
    }

    public String toString() {
        StringBuilder j0 = hj1.j0("ActionCardDetailsFragmentToCardRechargeAmountFragment(actionId=", R.id.action_cardDetailsFragment_to_cardRechargeAmountFragment, "){argCardRechargeConfiguration=");
        j0.append(c());
        j0.append(", argRechargeLimit=");
        j0.append(d());
        j0.append(", argCardNumber=");
        j0.append(b());
        j0.append("}");
        return j0.toString();
    }
}
