package app.zophop.models.mTicketing.superPass;

import androidx.appcompat.widget.RtlSpacingHelper;

@y66(c = "app.zophop.models.mTicketing.superPass.SuperPassJsonParser", f = "SuperPassJsonParser.kt", l = {167}, m = "parsePassesArray")
/* compiled from: SuperPassJsonParser.kt */
public final class SuperPassJsonParser$parsePassesArray$1 extends w66 {
    public int I$0;
    public int I$1;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SuperPassJsonParser this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperPassJsonParser$parsePassesArray$1(SuperPassJsonParser superPassJsonParser, k66<? super SuperPassJsonParser$parsePassesArray$1> k66) {
        super(k66);
        this.this$0 = superPassJsonParser;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= RtlSpacingHelper.UNDEFINED;
        return this.this$0.parsePassesArray(null, this);
    }
}
