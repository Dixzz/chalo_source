package defpackage;

import com.truecaller.android.sdk.TrueException;
import com.truecaller.android.sdk.TrueProfile;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* renamed from: mh5  reason: default package */
/* compiled from: CreateProfileCallback */
public class mh5 implements Callback<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    public final String f2377a;
    public final TrueProfile b;
    public final ch5 c;
    public boolean d;

    public mh5(String str, TrueProfile trueProfile, ch5 ch5, boolean z) {
        this.f2377a = str;
        this.b = trueProfile;
        this.c = ch5;
        this.d = z;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<JSONObject> call, Throwable th) {
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
        if (response != null && response.errorBody() != null) {
            String r2 = hd3.r2(response.errorBody());
            if (this.d && TrueException.TYPE_INTERNAL_SERVER_ERROR.equals(r2)) {
                this.d = false;
                ch5 ch5 = this.c;
                String str = this.f2377a;
                TrueProfile trueProfile = this.b;
                ((dh5) ch5).f838a.b(String.format("Bearer %s", str), trueProfile).enqueue(this);
            }
        }
    }
}
