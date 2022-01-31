package com.razorpay;

/* compiled from: OtpElfData */
public final class B_$q$ implements Callback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ K$$z$ f668a;

    public B_$q$(K$$z$ k$$z$) {
        this.f668a = k$$z$;
    }

    @Override // com.razorpay.Callback
    public final void run(ResponseObject responseObject) {
        if (responseObject.getResponseResult() != null) {
            try {
                String versionFromJsonString = BaseUtils.getVersionFromJsonString(responseObject.getResponseResult(), K$$z$.b);
                if (!BaseUtils.getLocalVersion(this.f668a.f678a, K$$z$.b).equals(versionFromJsonString)) {
                    T__j$.a(g__v_.a().getOtpElfJsUrl(), new J$$A_(this.f668a, versionFromJsonString));
                }
            } catch (Exception e) {
                AnalyticsUtil.reportError(e, "error", "Could not extract version from server json");
            }
        }
    }
}
