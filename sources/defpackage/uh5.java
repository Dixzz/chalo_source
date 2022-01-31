package defpackage;

import com.truecaller.android.sdk.TrueProfile;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/* renamed from: uh5  reason: default package */
/* compiled from: ProfileService */
public interface uh5 {
    @GET("profile")
    Call<TrueProfile> a(@Header("Authorization") String str);

    @POST("profile")
    Call<JSONObject> b(@Header("Authorization") String str, @Body TrueProfile trueProfile);
}
