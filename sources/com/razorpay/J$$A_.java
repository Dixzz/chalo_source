package com.razorpay;

/* compiled from: OtpElfData */
public final class J$$A_ implements Callback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f676a;
    private /* synthetic */ K$$z$ b;

    public J$$A_(K$$z$ k$$z$, String str) {
        this.b = k$$z$;
        this.f676a = str;
    }

    @Override // com.razorpay.Callback
    public final void run(ResponseObject responseObject) {
        String decryptFile;
        if (responseObject.getResponseResult() != null && (decryptFile = BaseUtils.decryptFile(responseObject.getResponseResult())) != null) {
            if (BaseUtils.storeFileInInternal(this.b.f678a, BaseUtils.getVersionedAssetName(this.f676a, g__v_.a().getOTPElfJsFileName()), responseObject.getResponseResult())) {
                this.b.c = decryptFile;
                BaseUtils.updateLocalVersion(this.b.f678a, K$$z$.b, this.f676a);
            }
        }
    }
}
