package com.freshchat.consumer.sdk.g;

import android.content.Context;

public abstract class d<T> extends ki<T> {
    private T eR;

    public d(Context context) {
        super(context);
    }

    @Override // defpackage.li
    public void deliverResult(T t) {
        if (isReset()) {
            this.eR = null;
            return;
        }
        this.eR = t;
        if (isStarted()) {
            super.deliverResult(t);
        }
    }

    public abstract T getData();

    @Override // defpackage.ki
    public T loadInBackground() {
        return getData();
    }

    @Override // defpackage.ki
    public void onCanceled(T t) {
        this.eR = null;
    }

    @Override // defpackage.li
    public void onReset() {
        super.onReset();
        onStopLoading();
        this.eR = null;
    }

    @Override // defpackage.li
    public void onStartLoading() {
        T t = this.eR;
        if (t != null) {
            deliverResult(t);
        }
        if (takeContentChanged() || this.eR == null) {
            forceLoad();
        }
    }

    @Override // defpackage.li
    public void onStopLoading() {
        cancelLoad();
    }
}
