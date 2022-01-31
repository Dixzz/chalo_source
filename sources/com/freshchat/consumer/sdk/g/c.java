package com.freshchat.consumer.sdk.g;

import android.content.Context;
import java.util.List;

public abstract class c<T> extends ki<List<T>> {
    private List<T> eQ;

    public c(Context context) {
        super(context);
    }

    public abstract List<T> dd();

    /* renamed from: de */
    public List<T> loadInBackground() {
        return dd();
    }

    @Override // defpackage.li
    public void onReset() {
        super.onReset();
        onStopLoading();
        List<T> list = this.eQ;
        if (list != null && list.size() > 0) {
            this.eQ.clear();
        }
        this.eQ = null;
    }

    @Override // defpackage.li
    public void onStartLoading() {
        List<T> list = this.eQ;
        if (list != null) {
            deliverResult(list);
        }
        if (takeContentChanged() || this.eQ == null) {
            forceLoad();
        }
    }

    @Override // defpackage.li
    public void onStopLoading() {
        cancelLoad();
    }

    /* renamed from: q */
    public void deliverResult(List<T> list) {
        if (!isReset()) {
            List<T> list2 = this.eQ;
            this.eQ = list;
            if (isStarted()) {
                super.deliverResult(list);
            }
            if (list2 != null && list2 != list && list2.size() > 0) {
                list2.clear();
            }
        } else if (list != null) {
            list.clear();
        }
    }

    /* renamed from: r */
    public void onCanceled(List<T> list) {
        if (list != null && list.size() > 0) {
            list.clear();
        }
    }
}
