package app.zophop.models.mTicketing.superPass;

import androidx.appcompat.widget.RtlSpacingHelper;

@y66(c = "app.zophop.models.mTicketing.superPass.SuperPassJsonParser", f = "SuperPassJsonParser.kt", l = {107}, m = "parseRideBasedSuperPass")
/* compiled from: SuperPassJsonParser.kt */
public final class SuperPassJsonParser$parseRideBasedSuperPass$1 extends w66 {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SuperPassJsonParser this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperPassJsonParser$parseRideBasedSuperPass$1(SuperPassJsonParser superPassJsonParser, k66<? super SuperPassJsonParser$parseRideBasedSuperPass$1> k66) {
        super(k66);
        this.this$0 = superPassJsonParser;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= RtlSpacingHelper.UNDEFINED;
        return SuperPassJsonParser.access$parseRideBasedSuperPass(this.this$0, null, this);
    }
}
