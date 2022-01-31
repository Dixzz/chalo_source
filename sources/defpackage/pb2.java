package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import java.util.Objects;

@SuppressLint({"HandlerLeak"})
/* renamed from: pb2  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class pb2 extends ve2 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2790a;
    public final /* synthetic */ q22 b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public pb2(q22 q22, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.b = q22;
        this.f2790a = context.getApplicationContext();
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            int e = this.b.e(this.f2790a);
            Objects.requireNonNull(this.b);
            if (u22.isUserRecoverableError(e)) {
                this.b.f(this.f2790a, e);
            }
        }
    }
}
