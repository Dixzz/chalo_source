package defpackage;

import android.widget.TextView;
import app.zophop.R;
import app.zophop.ui.fragments.cardRecharge.CardRechargeAmountFragment;
import java.util.Arrays;

/* renamed from: zx0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class zx0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CardRechargeAmountFragment f4223a;

    public /* synthetic */ zx0(CardRechargeAmountFragment cardRechargeAmountFragment) {
        this.f4223a = cardRechargeAmountFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        CardRechargeAmountFragment cardRechargeAmountFragment = this.f4223a;
        String str = (String) obj;
        int i = CardRechargeAmountFragment.j;
        n86.e(cardRechargeAmountFragment, "this$0");
        if (cardRechargeAmountFragment.c() != null && str != null) {
            switch (str.hashCode()) {
                case -1681341281:
                    if (str.equals("errorAmountBelowMinAllowedAmount")) {
                        n86.d(str, "lErrorMessage");
                        cardRechargeAmountFragment.k(str);
                        String string = cardRechargeAmountFragment.getString(R.string.error_amount_below_min);
                        n86.d(string, "getString(R.string.error_amount_below_min)");
                        String format = String.format(string, Arrays.copyOf(new Object[]{wh1.a(wh1.f3781a, cardRechargeAmountFragment.j().f.getFareInfo().getMinAmount(), 0, 2)}, 1));
                        n86.d(format, "java.lang.String.format(format, *args)");
                        cardRechargeAmountFragment.l(format);
                        return;
                    }
                    return;
                case -806783060:
                    if (str.equals("errorAmountNotInRequiredMultiples")) {
                        n86.d(str, "lErrorMessage");
                        cardRechargeAmountFragment.k(str);
                        String string2 = cardRechargeAmountFragment.getString(R.string.error_amount_multiple_issue);
                        n86.d(string2, "getString(R.string.error_amount_multiple_issue)");
                        String format2 = String.format(string2, Arrays.copyOf(new Object[]{wh1.a(wh1.f3781a, cardRechargeAmountFragment.j().f.getFareInfo().getMultiplesAllowed(), 0, 2)}, 1));
                        n86.d(format2, "java.lang.String.format(format, *args)");
                        cardRechargeAmountFragment.l(format2);
                        return;
                    }
                    return;
                case 850019231:
                    if (str.equals("errorRechargeLimitExceeded")) {
                        n86.d(str, "lErrorMessage");
                        cardRechargeAmountFragment.k(str);
                        String string3 = cardRechargeAmountFragment.getString(R.string.error_amount_max_limit_exceeded);
                        n86.d(string3, "getString(R.string.error…mount_max_limit_exceeded)");
                        String format3 = String.format(string3, Arrays.copyOf(new Object[]{wh1.a(wh1.f3781a, cardRechargeAmountFragment.j().h, 0, 2)}, 1));
                        n86.d(format3, "java.lang.String.format(format, *args)");
                        cardRechargeAmountFragment.l(format3);
                        return;
                    }
                    return;
                case 2086225095:
                    if (str.equals("noError") && cardRechargeAmountFragment.j().i > 0) {
                        T t = cardRechargeAmountFragment.f;
                        n86.c(t);
                        TextView textView = ((ix) t).e;
                        n86.d(textView, "viewBinding.errorText");
                        textView.setVisibility(8);
                        T t2 = cardRechargeAmountFragment.f;
                        n86.c(t2);
                        ((ix) t2).b.setAlpha(1.0f);
                        T t3 = cardRechargeAmountFragment.f;
                        n86.c(t3);
                        ((ix) t3).b.setEnabled(true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
