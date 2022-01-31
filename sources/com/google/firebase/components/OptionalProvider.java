package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public class OptionalProvider<T> implements Provider<T>, Deferred<T> {
    private static final Provider<Object> EMPTY_PROVIDER = xy4.f3981a;
    private static final Deferred.DeferredHandler<Object> NOOP_HANDLER = yy4.f4100a;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f650a = 0;
    private volatile Provider<T> delegate;
    private Deferred.DeferredHandler<T> handler;

    private OptionalProvider(Deferred.DeferredHandler<T> deferredHandler, Provider<T> provider) {
        this.handler = deferredHandler;
        this.delegate = provider;
    }

    public static <T> OptionalProvider<T> empty() {
        return new OptionalProvider<>(NOOP_HANDLER, EMPTY_PROVIDER);
    }

    public static <T> OptionalProvider<T> of(Provider<T> provider) {
        return new OptionalProvider<>(null, provider);
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        return this.delegate.get();
    }

    public void set(Provider<T> provider) {
        Deferred.DeferredHandler<T> deferredHandler;
        if (this.delegate == EMPTY_PROVIDER) {
            synchronized (this) {
                deferredHandler = this.handler;
                this.handler = null;
                this.delegate = provider;
            }
            deferredHandler.handle(provider);
            return;
        }
        throw new IllegalStateException("provide() can be called only once.");
    }

    @Override // com.google.firebase.inject.Deferred
    public void whenAvailable(Deferred.DeferredHandler<T> deferredHandler) {
        Provider<T> provider;
        Provider<T> provider2 = this.delegate;
        Provider<Object> provider3 = EMPTY_PROVIDER;
        if (provider2 != provider3) {
            deferredHandler.handle(provider2);
            return;
        }
        Provider<T> provider4 = null;
        synchronized (this) {
            provider = this.delegate;
            if (provider != provider3) {
                provider4 = provider;
            } else {
                this.handler = new zy4(this.handler, deferredHandler);
            }
        }
        if (provider4 != null) {
            deferredHandler.handle(provider);
        }
    }
}
