package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public class Lazy<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    public Lazy(T t) {
        this.instance = t;
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        T t = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (t == obj) {
            synchronized (this) {
                t = this.instance;
                if (t == obj) {
                    t = this.provider.get();
                    this.instance = t;
                    this.provider = null;
                }
            }
        }
        return t;
    }

    public boolean isInitialized() {
        return this.instance != UNINITIALIZED;
    }

    public Lazy(Provider<T> provider2) {
        this.provider = provider2;
    }
}
