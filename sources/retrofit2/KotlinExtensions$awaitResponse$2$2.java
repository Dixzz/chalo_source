package retrofit2;

import com.razorpay.AnalyticsConstants;

/* compiled from: KotlinExtensions.kt */
public final class KotlinExtensions$awaitResponse$2$2 implements Callback<T> {
    public final /* synthetic */ ra6 $continuation;

    public KotlinExtensions$awaitResponse$2$2(ra6 ra6) {
        this.$continuation = ra6;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<T> call, Throwable th) {
        n86.f(call, AnalyticsConstants.CALL);
        n86.f(th, "t");
        this.$continuation.resumeWith(hd3.Z(th));
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<T> call, Response<T> response) {
        n86.f(call, AnalyticsConstants.CALL);
        n86.f(response, "response");
        this.$continuation.resumeWith(response);
    }
}
