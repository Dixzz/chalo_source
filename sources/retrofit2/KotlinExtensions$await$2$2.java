package retrofit2;

import com.razorpay.AnalyticsConstants;
import java.lang.reflect.Method;
import java.util.Objects;

/* compiled from: KotlinExtensions.kt */
public final class KotlinExtensions$await$2$2 implements Callback<T> {
    public final /* synthetic */ ra6 $continuation;

    public KotlinExtensions$await$2$2(ra6 ra6) {
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
        if (response.isSuccessful()) {
            T body = response.body();
            if (body == null) {
                ji6 request = call.request();
                Objects.requireNonNull(request);
                n86.f(Invocation.class, "type");
                Object cast = Invocation.class.cast(request.f.get(Invocation.class));
                if (cast != null) {
                    n86.b(cast, "call.request().tag(Invocation::class.java)!!");
                    Method method = ((Invocation) cast).method();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Response from ");
                    n86.b(method, "method");
                    Class<?> declaringClass = method.getDeclaringClass();
                    n86.b(declaringClass, "method.declaringClass");
                    sb.append(declaringClass.getName());
                    sb.append('.');
                    sb.append(method.getName());
                    sb.append(" was null but response body type was declared as non-null");
                    this.$continuation.resumeWith(hd3.Z(new h56(sb.toString())));
                    return;
                }
                n86.k();
                throw null;
            }
            this.$continuation.resumeWith(body);
            return;
        }
        this.$continuation.resumeWith(hd3.Z(new HttpException(response)));
    }
}
