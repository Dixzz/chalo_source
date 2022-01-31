package retrofit2;

import com.rabbitmq.client.AMQP;
import defpackage.ji6;
import defpackage.ni6;
import javax.annotation.Nullable;

public final class Response<T> {
    @Nullable
    private final T body;
    @Nullable
    private final oi6 errorBody;
    private final ni6 rawResponse;

    private Response(ni6 ni6, @Nullable T t, @Nullable oi6 oi6) {
        this.rawResponse = ni6;
        this.body = t;
        this.errorBody = oi6;
    }

    public static <T> Response<T> error(int i, oi6 oi6) {
        if (i >= 400) {
            ni6.a aVar = new ni6.a();
            aVar.c = i;
            aVar.e("Response.error()");
            aVar.f(ii6.HTTP_1_1);
            ji6.a aVar2 = new ji6.a();
            aVar2.i("http://localhost/");
            aVar.g(aVar2.b());
            return error(oi6, aVar.a());
        }
        throw new IllegalArgumentException(hj1.I("code < 400: ", i));
    }

    public static <T> Response<T> success(@Nullable T t) {
        ni6.a aVar = new ni6.a();
        aVar.c = AMQP.REPLY_SUCCESS;
        aVar.e("OK");
        aVar.f(ii6.HTTP_1_1);
        ji6.a aVar2 = new ji6.a();
        aVar2.i("http://localhost/");
        aVar.g(aVar2.b());
        return success(t, aVar.a());
    }

    @Nullable
    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.j;
    }

    @Nullable
    public oi6 errorBody() {
        return this.errorBody;
    }

    public ci6 headers() {
        return this.rawResponse.l;
    }

    public boolean isSuccessful() {
        return this.rawResponse.e();
    }

    public String message() {
        return this.rawResponse.i;
    }

    public ni6 raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    public static <T> Response<T> success(int i, @Nullable T t) {
        if (i < 200 || i >= 300) {
            throw new IllegalArgumentException(hj1.I("code < 200 or >= 300: ", i));
        }
        ni6.a aVar = new ni6.a();
        aVar.c = i;
        aVar.e("Response.success()");
        aVar.f(ii6.HTTP_1_1);
        ji6.a aVar2 = new ji6.a();
        aVar2.i("http://localhost/");
        aVar.g(aVar2.b());
        return success(t, aVar.a());
    }

    public static <T> Response<T> error(oi6 oi6, ni6 ni6) {
        Utils.checkNotNull(oi6, "body == null");
        Utils.checkNotNull(ni6, "rawResponse == null");
        if (!ni6.e()) {
            return new Response<>(ni6, null, oi6);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> Response<T> success(@Nullable T t, ci6 ci6) {
        Utils.checkNotNull(ci6, "headers == null");
        ni6.a aVar = new ni6.a();
        aVar.c = AMQP.REPLY_SUCCESS;
        aVar.e("OK");
        aVar.f(ii6.HTTP_1_1);
        aVar.d(ci6);
        ji6.a aVar2 = new ji6.a();
        aVar2.i("http://localhost/");
        aVar.g(aVar2.b());
        return success(t, aVar.a());
    }

    public static <T> Response<T> success(@Nullable T t, ni6 ni6) {
        Utils.checkNotNull(ni6, "rawResponse == null");
        if (ni6.e()) {
            return new Response<>(ni6, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }
}
