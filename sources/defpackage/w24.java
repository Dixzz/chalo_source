package defpackage;

import com.google.android.gms.common.api.Status;

/* renamed from: w24  reason: default package */
public abstract class w24 extends q24<ph4> {
    public r24 q = new y24(this);

    public w24(a32 a32) {
        super(a32);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ f32 d(Status status) {
        return new v24(status, null);
    }
}
