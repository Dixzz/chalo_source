package defpackage;

import app.zophop.models.City;
import defpackage.xt;
import org.json.JSONException;
import org.json.JSONObject;

@y66(c = "app.zophop.ui.viewmodels.HomeScreenMainFragmentViewModel$setupOccupancyFactorAndMode$2", f = "HomeScreenMainFragmentViewModel.kt", l = {}, m = "invokeSuspend")
/* renamed from: n81  reason: default package */
/* compiled from: HomeScreenMainFragmentViewModel.kt */
public final class n81 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ d81 f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n81(d81 d81, k66<? super n81> k66) {
        super(2, k66);
        this.f = d81;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new n81(this.f, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        n81 n81 = new n81(this.f, k66);
        s56 s56 = s56.f3190a;
        n81.invokeSuspend(s56);
        return s56;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(obj);
        xt.t1 t1Var = xt.f3961a;
        String f2 = t1Var.t().f("cityWiseSeatOccupancyConfiguration");
        City d = t1Var.k().d();
        n86.c(d);
        String name = d.getName();
        n86.d(name, "cityProvider.currentCity!!.name");
        String lowerCase = name.toLowerCase();
        n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
        String j = n86.j("seatAvailabilityOccupancyFactor", lowerCase);
        String j2 = n86.j("seatAvailabilityApiMode", lowerCase);
        String j3 = n86.j("seatOccupancyDialogNotice", lowerCase);
        String j4 = n86.j("shouldShowSeatOccupancyDialogHomescreen", lowerCase);
        String j5 = n86.j("seatOccupancyDialoglearnMoreUrl", lowerCase);
        try {
            JSONObject jSONObject = new JSONObject(f2);
            t1Var.l().put("seatAvailabilityDelayThreshold", String.valueOf(jSONObject.optInt("SODelayThreshold", 15)));
            if (jSONObject.has(lowerCase)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(lowerCase);
                int optInt = jSONObject2.optInt("occupancyFactor", -1);
                int optInt2 = jSONObject2.optInt("mode", 0);
                String optString = jSONObject2.optString("noticeText", new String());
                boolean optBoolean = jSONObject2.optBoolean("shouldShowDialog", false);
                String optString2 = jSONObject2.optString("learnMore", new String());
                if (optBoolean) {
                    t1Var.l().put(j4, "true");
                } else {
                    t1Var.l().put(j4, "false");
                }
                t1Var.l().put(j, String.valueOf(optInt));
                t1Var.l().put(j2, String.valueOf(optInt2));
                t1Var.l().put(j3, optString);
                t1Var.l().put(j5, optString2);
            } else {
                d81.e(this.f, j, j2, j4);
            }
        } catch (JSONException e) {
            d81.e(this.f, j, j2, j4);
            e.printStackTrace();
        }
        return s56.f3190a;
    }
}
