package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import app.zophop.R;
import app.zophop.models.mTicketing.CardRechargeConfiguration;
import java.io.Serializable;
import java.util.HashMap;

/* renamed from: sy0  reason: default package */
/* compiled from: CardRechargeAmountFragmentDirections */
public class sy0 implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f3278a;

    public sy0(CardRechargeConfiguration cardRechargeConfiguration, long j, String str, ry0 ry0) {
        HashMap hashMap = new HashMap();
        this.f3278a = hashMap;
        if (cardRechargeConfiguration != null) {
            hashMap.put("arg_cardRechargeConfiguration", cardRechargeConfiguration);
            hashMap.put("arg_rechargeAmount", Long.valueOf(j));
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
        return R.id.action_cardRechargeAmountFragment_to_cardRechargeConfirmPaymentFragment;
    }

    public String b() {
        return (String) this.f3278a.get("arg_cardNumber");
    }

    public CardRechargeConfiguration c() {
        return (CardRechargeConfiguration) this.f3278a.get("arg_cardRechargeConfiguration");
    }

    public long d() {
        return ((Long) this.f3278a.get("arg_rechargeAmount")).longValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || sy0.class != obj.getClass()) {
            return false;
        }
        sy0 sy0 = (sy0) obj;
        if (this.f3278a.containsKey("arg_cardRechargeConfiguration") != sy0.f3278a.containsKey("arg_cardRechargeConfiguration")) {
            return false;
        }
        if (c() == null ? sy0.c() != null : !c().equals(sy0.c())) {
            return false;
        }
        if (this.f3278a.containsKey("arg_rechargeAmount") == sy0.f3278a.containsKey("arg_rechargeAmount") && d() == sy0.d() && this.f3278a.containsKey("arg_cardNumber") == sy0.f3278a.containsKey("arg_cardNumber")) {
            return b() == null ? sy0.b() == null : b().equals(sy0.b());
        }
        return false;
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f3278a.containsKey("arg_cardRechargeConfiguration")) {
            CardRechargeConfiguration cardRechargeConfiguration = (CardRechargeConfiguration) this.f3278a.get("arg_cardRechargeConfiguration");
            if (Parcelable.class.isAssignableFrom(CardRechargeConfiguration.class) || cardRechargeConfiguration == null) {
                bundle.putParcelable("arg_cardRechargeConfiguration", (Parcelable) Parcelable.class.cast(cardRechargeConfiguration));
            } else if (Serializable.class.isAssignableFrom(CardRechargeConfiguration.class)) {
                bundle.putSerializable("arg_cardRechargeConfiguration", (Serializable) Serializable.class.cast(cardRechargeConfiguration));
            } else {
                throw new UnsupportedOperationException(hj1.G(CardRechargeConfiguration.class, new StringBuilder(), " must implement Parcelable or Serializable or must be an Enum."));
            }
        }
        if (this.f3278a.containsKey("arg_rechargeAmount")) {
            bundle.putLong("arg_rechargeAmount", ((Long) this.f3278a.get("arg_rechargeAmount")).longValue());
        }
        if (this.f3278a.containsKey("arg_cardNumber")) {
            bundle.putString("arg_cardNumber", (String) this.f3278a.get("arg_cardNumber"));
        }
        return bundle;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((c() != null ? c().hashCode() : 0) + 31) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31;
        if (b() != null) {
            i = b().hashCode();
        }
        return hj1.b(hashCode, i, 31, R.id.action_cardRechargeAmountFragment_to_cardRechargeConfirmPaymentFragment);
    }

    public String toString() {
        StringBuilder j0 = hj1.j0("ActionCardRechargeAmountFragmentToCardRechargeConfirmPaymentFragment(actionId=", R.id.action_cardRechargeAmountFragment_to_cardRechargeConfirmPaymentFragment, "){argCardRechargeConfiguration=");
        j0.append(c());
        j0.append(", argRechargeAmount=");
        j0.append(d());
        j0.append(", argCardNumber=");
        j0.append(b());
        j0.append("}");
        return j0.toString();
    }
}
