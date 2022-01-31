package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;

public final class DefaultCallAdapterFactory extends CallAdapter.Factory {
    @Nullable
    private final Executor callbackExecutor;

    public static final class ExecutorCallbackCall<T> implements Call<T> {
        public final Executor callbackExecutor;
        public final Call<T> delegate;

        public ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.callbackExecutor = executor;
            this.delegate = call;
        }

        @Override // retrofit2.Call
        public void cancel() {
            this.delegate.cancel();
        }

        @Override // retrofit2.Call
        public void enqueue(final Callback<T> callback) {
            Utils.checkNotNull(callback, "callback == null");
            this.delegate.enqueue(new Callback<T>() {
                /* class retrofit2.DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 */

                @Override // retrofit2.Callback
                public void onFailure(Call<T> call, final Throwable th) {
                    ExecutorCallbackCall.this.callbackExecutor.execute(new Runnable() {
                        /* class retrofit2.DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1.AnonymousClass2 */

                        public void run() {
                            AnonymousClass1 r0 = AnonymousClass1.this;
                            callback.onFailure(ExecutorCallbackCall.this, th);
                        }
                    });
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<T> call, final Response<T> response) {
                    ExecutorCallbackCall.this.callbackExecutor.execute(new Runnable() {
                        /* class retrofit2.DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            if (ExecutorCallbackCall.this.delegate.isCanceled()) {
                                AnonymousClass1 r0 = AnonymousClass1.this;
                                callback.onFailure(ExecutorCallbackCall.this, new IOException("Canceled"));
                                return;
                            }
                            AnonymousClass1 r02 = AnonymousClass1.this;
                            callback.onResponse(ExecutorCallbackCall.this, response);
                        }
                    });
                }
            });
        }

        @Override // retrofit2.Call
        public Response<T> execute() throws IOException {
            return this.delegate.execute();
        }

        @Override // retrofit2.Call
        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        @Override // retrofit2.Call
        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        @Override // retrofit2.Call
        public ji6 request() {
            return this.delegate.request();
        }

        @Override // java.lang.Object, retrofit2.Call
        public Call<T> clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }
    }

    public DefaultCallAdapterFactory(@Nullable Executor executor) {
        this.callbackExecutor = executor;
    }

    @Override // retrofit2.CallAdapter.Factory
    @Nullable
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        final Executor executor = null;
        if (CallAdapter.Factory.getRawType(type) != Call.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            final Type parameterUpperBound = Utils.getParameterUpperBound(0, (ParameterizedType) type);
            if (!Utils.isAnnotationPresent(annotationArr, SkipCallbackExecutor.class)) {
                executor = this.callbackExecutor;
            }
            return new CallAdapter<Object, Call<?>>() {
                /* class retrofit2.DefaultCallAdapterFactory.AnonymousClass1 */

                @Override // retrofit2.CallAdapter
                public Type responseType() {
                    return parameterUpperBound;
                }

                /* Return type fixed from 'retrofit2.Call<java.lang.Object>' to match base method */
                @Override // retrofit2.CallAdapter
                public Call<?> adapt(Call<Object> call) {
                    Executor executor = executor;
                    return executor == null ? call : new ExecutorCallbackCall(executor, call);
                }
            };
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
