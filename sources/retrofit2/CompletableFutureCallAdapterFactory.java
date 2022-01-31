package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.CallAdapter;

@IgnoreJRERequirement
public final class CompletableFutureCallAdapterFactory extends CallAdapter.Factory {
    public static final CallAdapter.Factory INSTANCE = new CompletableFutureCallAdapterFactory();

    @IgnoreJRERequirement
    public static final class BodyCallAdapter<R> implements CallAdapter<R, CompletableFuture<R>> {
        private final Type responseType;

        public BodyCallAdapter(Type type) {
            this.responseType = type;
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return this.responseType;
        }

        @Override // retrofit2.CallAdapter
        public CompletableFuture<R> adapt(final Call<R> call) {
            final AnonymousClass1 r0 = new CompletableFuture<R>() {
                /* class retrofit2.CompletableFutureCallAdapterFactory.BodyCallAdapter.AnonymousClass1 */

                public boolean cancel(boolean z) {
                    if (z) {
                        call.cancel();
                    }
                    return super.cancel(z);
                }
            };
            call.enqueue(new Callback<R>() {
                /* class retrofit2.CompletableFutureCallAdapterFactory.BodyCallAdapter.AnonymousClass2 */

                @Override // retrofit2.Callback
                public void onFailure(Call<R> call, Throwable th) {
                    r0.completeExceptionally(th);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<R> call, Response<R> response) {
                    if (response.isSuccessful()) {
                        r0.complete(response.body());
                    } else {
                        r0.completeExceptionally(new HttpException(response));
                    }
                }
            });
            return r0;
        }
    }

    @IgnoreJRERequirement
    public static final class ResponseCallAdapter<R> implements CallAdapter<R, CompletableFuture<Response<R>>> {
        private final Type responseType;

        public ResponseCallAdapter(Type type) {
            this.responseType = type;
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return this.responseType;
        }

        @Override // retrofit2.CallAdapter
        public CompletableFuture<Response<R>> adapt(final Call<R> call) {
            final AnonymousClass1 r0 = new CompletableFuture<Response<R>>() {
                /* class retrofit2.CompletableFutureCallAdapterFactory.ResponseCallAdapter.AnonymousClass1 */

                public boolean cancel(boolean z) {
                    if (z) {
                        call.cancel();
                    }
                    return super.cancel(z);
                }
            };
            call.enqueue(new Callback<R>() {
                /* class retrofit2.CompletableFutureCallAdapterFactory.ResponseCallAdapter.AnonymousClass2 */

                @Override // retrofit2.Callback
                public void onFailure(Call<R> call, Throwable th) {
                    r0.completeExceptionally(th);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<R> call, Response<R> response) {
                    r0.complete(response);
                }
            });
            return r0;
        }
    }

    @Override // retrofit2.CallAdapter.Factory
    @Nullable
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (CallAdapter.Factory.getRawType(type) != CompletableFuture.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
            if (CallAdapter.Factory.getRawType(parameterUpperBound) != Response.class) {
                return new BodyCallAdapter(parameterUpperBound);
            }
            if (parameterUpperBound instanceof ParameterizedType) {
                return new ResponseCallAdapter(CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound));
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }
}
