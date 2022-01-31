package defpackage;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;

/* renamed from: d8  reason: default package */
/* compiled from: GestureDetectorCompat */
public final class d8 {

    /* renamed from: a  reason: collision with root package name */
    public final a f806a;

    /* renamed from: d8$a */
    /* compiled from: GestureDetectorCompat */
    public interface a {
    }

    /* renamed from: d8$b */
    /* compiled from: GestureDetectorCompat */
    public static class b implements a {

        /* renamed from: a  reason: collision with root package name */
        public final GestureDetector f807a;

        public b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f807a = new GestureDetector(context, onGestureListener, handler);
        }
    }

    public d8(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this.f806a = new b(context, onGestureListener, null);
    }
}
