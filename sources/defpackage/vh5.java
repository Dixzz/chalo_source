package defpackage;

import com.truecaller.android.sdk.models.CreateInstallationModel;
import com.truecaller.android.sdk.models.VerifyInstallationModel;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/* renamed from: vh5  reason: default package */
/* compiled from: VerificationService */
public interface vh5 {
    @POST("verify")
    Call<Map<String, Object>> a(@Header("appKey") String str, @Body VerifyInstallationModel verifyInstallationModel);

    @POST("create")
    Call<Map<String, Object>> b(@Header("appKey") String str, @Body CreateInstallationModel createInstallationModel);
}
