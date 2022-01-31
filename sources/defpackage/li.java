package defpackage;

import android.content.Context;
import defpackage.ji;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: li  reason: default package */
/* compiled from: Loader */
public class li<D> {
    public boolean mAbandoned = false;
    public boolean mContentChanged = false;
    public Context mContext;
    public int mId;
    public b<D> mListener;
    public a<D> mOnLoadCanceledListener;
    public boolean mProcessingChange = false;
    public boolean mReset = true;
    public boolean mStarted = false;

    /* renamed from: li$a */
    /* compiled from: Loader */
    public interface a<D> {
        void a(li<D> liVar);
    }

    /* renamed from: li$b */
    /* compiled from: Loader */
    public interface b<D> {
    }

    public li(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    public boolean cancelLoad() {
        return onCancelLoad();
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    public String dataToString(D d) {
        StringBuilder sb = new StringBuilder(64);
        h.i(d, sb);
        sb.append("}");
        return sb.toString();
    }

    public void deliverCancellation() {
        a<D> aVar = this.mOnLoadCanceledListener;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void deliverResult(D d) {
        b<D> bVar = this.mListener;
        if (bVar != null) {
            ((ji.a) bVar).o(this, d);
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.mListener);
        if (this.mStarted || this.mContentChanged || this.mProcessingChange) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.mContentChanged);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.mProcessingChange);
        }
        if (this.mAbandoned || this.mReset) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.mAbandoned);
            printWriter.print(" mReset=");
            printWriter.println(this.mReset);
        }
    }

    public void forceLoad() {
        onForceLoad();
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public void onAbandon() {
    }

    public boolean onCancelLoad() {
        throw null;
    }

    public void onContentChanged() {
        if (this.mStarted) {
            forceLoad();
        } else {
            this.mContentChanged = true;
        }
    }

    public void onForceLoad() {
    }

    public void onReset() {
    }

    public void onStartLoading() {
        throw null;
    }

    public void onStopLoading() {
    }

    public void registerListener(int i, b<D> bVar) {
        if (this.mListener == null) {
            this.mListener = bVar;
            this.mId = i;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void registerOnLoadCanceledListener(a<D> aVar) {
        if (this.mOnLoadCanceledListener == null) {
            this.mOnLoadCanceledListener = aVar;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        if (this.mProcessingChange) {
            onContentChanged();
        }
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean z = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= z;
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        h.i(this, sb);
        sb.append(" id=");
        return hj1.X(sb, this.mId, "}");
    }

    public void unregisterListener(b<D> bVar) {
        b<D> bVar2 = this.mListener;
        if (bVar2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (bVar2 == bVar) {
            this.mListener = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    public void unregisterOnLoadCanceledListener(a<D> aVar) {
        a<D> aVar2 = this.mOnLoadCanceledListener;
        if (aVar2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (aVar2 == aVar) {
            this.mOnLoadCanceledListener = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }
}
