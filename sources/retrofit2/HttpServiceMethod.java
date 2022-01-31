package retrofit2;

import defpackage.ih6;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.Utils;

public abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {
    private final ih6.a callFactory;
    private final RequestFactory requestFactory;
    private final Converter<oi6, ResponseT> responseConverter;

    public static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {
        private final CallAdapter<ResponseT, ReturnT> callAdapter;

        public CallAdapted(RequestFactory requestFactory, ih6.a aVar, Converter<oi6, ResponseT> converter, CallAdapter<ResponseT, ReturnT> callAdapter2) {
            super(requestFactory, aVar, converter);
            this.callAdapter = callAdapter2;
        }

        @Override // retrofit2.HttpServiceMethod
        public ReturnT adapt(Call<ResponseT> call, Object[] objArr) {
            return this.callAdapter.adapt(call);
        }
    }

    public static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;
        private final boolean isNullable;

        public SuspendForBody(RequestFactory requestFactory, ih6.a aVar, Converter<oi6, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter2, boolean z) {
            super(requestFactory, aVar, converter);
            this.callAdapter = callAdapter2;
            this.isNullable = z;
        }

        @Override // retrofit2.HttpServiceMethod
        public Object adapt(Call<ResponseT> call, Object[] objArr) {
            Call<ResponseT> adapt = this.callAdapter.adapt(call);
            k66 k66 = (k66) objArr[objArr.length - 1];
            if (this.isNullable) {
                return KotlinExtensions.awaitNullable(adapt, k66);
            }
            return KotlinExtensions.await(adapt, k66);
        }
    }

    public static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;

        public SuspendForResponse(RequestFactory requestFactory, ih6.a aVar, Converter<oi6, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter2) {
            super(requestFactory, aVar, converter);
            this.callAdapter = callAdapter2;
        }

        @Override // retrofit2.HttpServiceMethod
        public Object adapt(Call<ResponseT> call, Object[] objArr) {
            return KotlinExtensions.awaitResponse(this.callAdapter.adapt(call), (k66) objArr[objArr.length - 1]);
        }
    }

    public HttpServiceMethod(RequestFactory requestFactory2, ih6.a aVar, Converter<oi6, ResponseT> converter) {
        this.requestFactory = requestFactory2;
        this.callFactory = aVar;
        this.responseConverter = converter;
    }

    private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(Retrofit retrofit, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (CallAdapter<ResponseT, ReturnT>) retrofit.callAdapter(type, annotationArr);
        } catch (RuntimeException e) {
            throw Utils.methodError(method, e, "Unable to create call adapter for %s", type);
        }
    }

    private static <ResponseT> Converter<oi6, ResponseT> createResponseConverter(Retrofit retrofit, Method method, Type type) {
        try {
            return retrofit.responseBodyConverter(type, method.getAnnotations());
        } catch (RuntimeException e) {
            throw Utils.methodError(method, e, "Unable to create converter for %s", type);
        }
    }

    public static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(Retrofit retrofit, Method method, RequestFactory requestFactory2) {
        Type type;
        boolean z;
        boolean z2 = requestFactory2.isKotlinSuspendFunction;
        Annotation[] annotations = method.getAnnotations();
        if (z2) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type parameterLowerBound = Utils.getParameterLowerBound(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (Utils.getRawType(parameterLowerBound) != Response.class || !(parameterLowerBound instanceof ParameterizedType)) {
                z = false;
            } else {
                parameterLowerBound = Utils.getParameterUpperBound(0, (ParameterizedType) parameterLowerBound);
                z = true;
            }
            type = new Utils.ParameterizedTypeImpl(null, Call.class, parameterLowerBound);
            annotations = SkipCallbackExecutorImpl.ensurePresent(annotations);
        } else {
            type = method.getGenericReturnType();
            z = false;
        }
        CallAdapter createCallAdapter = createCallAdapter(retrofit, method, type, annotations);
        Type responseType = createCallAdapter.responseType();
        if (responseType == ni6.class) {
            StringBuilder i0 = hj1.i0("'");
            i0.append(Utils.getRawType(responseType).getName());
            i0.append("' is not a valid response body type. Did you mean ResponseBody?");
            throw Utils.methodError(method, i0.toString(), new Object[0]);
        } else if (responseType == Response.class) {
            throw Utils.methodError(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        } else if (!requestFactory2.httpMethod.equals("HEAD") || Void.class.equals(responseType)) {
            Converter createResponseConverter = createResponseConverter(retrofit, method, responseType);
            ih6.a aVar = retrofit.callFactory;
            if (!z2) {
                return new CallAdapted(requestFactory2, aVar, createResponseConverter, createCallAdapter);
            }
            if (z) {
                return new SuspendForResponse(requestFactory2, aVar, createResponseConverter, createCallAdapter);
            }
            return new SuspendForBody(requestFactory2, aVar, createResponseConverter, createCallAdapter, false);
        } else {
            throw Utils.methodError(method, "HEAD method must use Void as response type.", new Object[0]);
        }
    }

    @Nullable
    public abstract ReturnT adapt(Call<ResponseT> call, Object[] objArr);

    @Override // retrofit2.ServiceMethod
    @Nullable
    public final ReturnT invoke(Object[] objArr) {
        return adapt(new OkHttpCall(this.requestFactory, objArr, this.callFactory, this.responseConverter), objArr);
    }
}
