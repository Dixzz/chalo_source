package defpackage;

import com.truecaller.android.sdk.TrueException;
import com.truecaller.android.sdk.clients.VerificationCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* renamed from: lh5  reason: default package */
/* compiled from: BaseApiCallback */
public abstract class lh5<T> implements Callback<T> {

    /* renamed from: a  reason: collision with root package name */
    public final VerificationCallback f2221a;
    public final int b;
    public boolean c;

    public lh5(VerificationCallback verificationCallback, boolean z, int i) {
        this.f2221a = verificationCallback;
        this.c = z;
        this.b = i;
    }

    public abstract void a();

    public abstract void b(T t);

    @Override // retrofit2.Callback
    public void onFailure(Call<T> call, Throwable th) {
        this.f2221a.onRequestFailure(this.b, new TrueException(2, th.getMessage()));
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<T> call, Response<T> response) {
        if (response == null) {
            this.f2221a.onRequestFailure(this.b, new TrueException(1, TrueException.TYPE_UNKNOWN_MESSAGE));
        } else if (response.isSuccessful() && response.body() != null) {
            b(response.body());
        } else if (response.errorBody() != null) {
            String r2 = hd3.r2(response.errorBody());
            if (!this.c || !TrueException.TYPE_INTERNAL_SERVER_ERROR.equalsIgnoreCase(r2)) {
                this.f2221a.onRequestFailure(this.b, new TrueException(2, r2));
                return;
            }
            this.c = false;
            a();
        } else {
            this.f2221a.onRequestFailure(this.b, new TrueException(1, TrueException.TYPE_UNKNOWN_MESSAGE));
        }
    }
}
