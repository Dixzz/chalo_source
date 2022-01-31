package retrofit2;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import defpackage.ci6;
import defpackage.ih6;
import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class OkHttpCall<T> implements Call<T> {
    private final Object[] args;
    private final ih6.a callFactory;
    private volatile boolean canceled;
    @GuardedBy("this")
    @Nullable
    private Throwable creationFailure;
    @GuardedBy("this")
    private boolean executed;
    @GuardedBy("this")
    @Nullable
    private ih6 rawCall;
    private final RequestFactory requestFactory;
    private final Converter<oi6, T> responseConverter;

    public static final class ExceptionCatchingResponseBody extends oi6 {
        private final oi6 delegate;
        private final ym6 delegateSource;
        @Nullable
        public IOException thrownException;

        public ExceptionCatchingResponseBody(oi6 oi6) {
            this.delegate = oi6;
            AnonymousClass1 r0 = new cn6(oi6.source()) {
                /* class retrofit2.OkHttpCall.ExceptionCatchingResponseBody.AnonymousClass1 */

                @Override // defpackage.qn6, defpackage.cn6
                public long read(vm6 vm6, long j) throws IOException {
                    try {
                        return super.read(vm6, j);
                    } catch (IOException e) {
                        ExceptionCatchingResponseBody.this.thrownException = e;
                        throw e;
                    }
                }
            };
            n86.f(r0, "$this$buffer");
            this.delegateSource = new kn6(r0);
        }

        @Override // java.io.Closeable, defpackage.oi6, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // defpackage.oi6
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // defpackage.oi6
        public fi6 contentType() {
            return this.delegate.contentType();
        }

        @Override // defpackage.oi6
        public ym6 source() {
            return this.delegateSource;
        }

        public void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    public static final class NoContentResponseBody extends oi6 {
        private final long contentLength;
        @Nullable
        private final fi6 contentType;

        public NoContentResponseBody(@Nullable fi6 fi6, long j) {
            this.contentType = fi6;
            this.contentLength = j;
        }

        @Override // defpackage.oi6
        public long contentLength() {
            return this.contentLength;
        }

        @Override // defpackage.oi6
        public fi6 contentType() {
            return this.contentType;
        }

        @Override // defpackage.oi6
        public ym6 source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(RequestFactory requestFactory2, Object[] objArr, ih6.a aVar, Converter<oi6, T> converter) {
        this.requestFactory = requestFactory2;
        this.args = objArr;
        this.callFactory = aVar;
        this.responseConverter = converter;
    }

    private ih6 createRawCall() throws IOException {
        ih6 a2 = this.callFactory.a(this.requestFactory.create(this.args));
        Objects.requireNonNull(a2, "Call.Factory returned null.");
        return a2;
    }

    @Override // retrofit2.Call
    public void cancel() {
        ih6 ih6;
        this.canceled = true;
        synchronized (this) {
            ih6 = this.rawCall;
        }
        if (ih6 != null) {
            ih6.cancel();
        }
    }

    @Override // retrofit2.Call
    public void enqueue(final Callback<T> callback) {
        ih6 ih6;
        Throwable th;
        Utils.checkNotNull(callback, "callback == null");
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                ih6 = this.rawCall;
                th = this.creationFailure;
                if (ih6 == null && th == null) {
                    try {
                        ih6 createRawCall = createRawCall();
                        this.rawCall = createRawCall;
                        ih6 = createRawCall;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.throwIfFatal(th);
                        this.creationFailure = th;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            ih6.cancel();
        }
        FirebasePerfOkHttpClient.enqueue(ih6, new jh6() {
            /* class retrofit2.OkHttpCall.AnonymousClass1 */

            private void callFailure(Throwable th) {
                try {
                    callback.onFailure(OkHttpCall.this, th);
                } catch (Throwable th2) {
                    Utils.throwIfFatal(th2);
                    th2.printStackTrace();
                }
            }

            @Override // defpackage.jh6
            public void onFailure(ih6 ih6, IOException iOException) {
                callFailure(iOException);
            }

            @Override // defpackage.jh6
            public void onResponse(ih6 ih6, ni6 ni6) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(ni6));
                    } catch (Throwable th) {
                        Utils.throwIfFatal(th);
                        th.printStackTrace();
                    }
                } catch (Throwable th2) {
                    Utils.throwIfFatal(th2);
                    callFailure(th2);
                }
            }
        });
    }

    @Override // retrofit2.Call
    public Response<T> execute() throws IOException {
        ih6 ih6;
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                Throwable th = this.creationFailure;
                if (th == null) {
                    ih6 = this.rawCall;
                    if (ih6 == null) {
                        try {
                            ih6 = createRawCall();
                            this.rawCall = ih6;
                        } catch (IOException | Error | RuntimeException e) {
                            Utils.throwIfFatal(e);
                            this.creationFailure = e;
                            throw e;
                        }
                    }
                } else if (th instanceof IOException) {
                    throw ((IOException) th);
                } else if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                } else {
                    throw ((Error) th);
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.canceled) {
            ih6.cancel();
        }
        return parseResponse(FirebasePerfOkHttpClient.execute(ih6));
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        boolean z = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            ih6 ih6 = this.rawCall;
            if (ih6 == null || !ih6.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    @Override // retrofit2.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public Response<T> parseResponse(ni6 ni6) throws IOException {
        oi6 oi6 = ni6.m;
        n86.f(ni6, "response");
        ji6 ji6 = ni6.g;
        ii6 ii6 = ni6.h;
        int i = ni6.j;
        String str = ni6.i;
        bi6 bi6 = ni6.k;
        ci6.a e = ni6.l.e();
        ni6 ni62 = ni6.n;
        ni6 ni63 = ni6.o;
        ni6 ni64 = ni6.p;
        long j = ni6.q;
        long j2 = ni6.r;
        lj6 lj6 = ni6.s;
        NoContentResponseBody noContentResponseBody = new NoContentResponseBody(oi6.contentType(), oi6.contentLength());
        if (!(i >= 0)) {
            throw new IllegalStateException(hj1.I("code < 0: ", i).toString());
        } else if (ji6 == null) {
            throw new IllegalStateException("request == null".toString());
        } else if (ii6 == null) {
            throw new IllegalStateException("protocol == null".toString());
        } else if (str != null) {
            ni6 ni65 = new ni6(ji6, ii6, str, i, bi6, e.d(), noContentResponseBody, ni62, ni63, ni64, j, j2, lj6);
            int i2 = ni65.j;
            if (i2 < 200 || i2 >= 300) {
                try {
                    return Response.error(Utils.buffer(oi6), ni65);
                } finally {
                    oi6.close();
                }
            } else if (i2 == 204 || i2 == 205) {
                oi6.close();
                return Response.success((Object) null, ni65);
            } else {
                ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(oi6);
                try {
                    return Response.success(this.responseConverter.convert(exceptionCatchingResponseBody), ni65);
                } catch (RuntimeException e2) {
                    exceptionCatchingResponseBody.throwIfCaught();
                    throw e2;
                }
            }
        } else {
            throw new IllegalStateException("message == null".toString());
        }
    }

    @Override // retrofit2.Call
    public synchronized ji6 request() {
        ih6 ih6 = this.rawCall;
        if (ih6 != null) {
            return ih6.request();
        }
        Throwable th = this.creationFailure;
        if (th == null) {
            try {
                ih6 createRawCall = createRawCall();
                this.rawCall = createRawCall;
                return createRawCall.request();
            } catch (Error | RuntimeException e) {
                Utils.throwIfFatal(e);
                this.creationFailure = e;
                throw e;
            } catch (IOException e2) {
                this.creationFailure = e2;
                throw new RuntimeException("Unable to create request.", e2);
            }
        } else if (th instanceof IOException) {
            throw new RuntimeException("Unable to create request.", this.creationFailure);
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else {
            throw ((Error) th);
        }
    }

    @Override // java.lang.Object, retrofit2.Call
    public OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }
}
