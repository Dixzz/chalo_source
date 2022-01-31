package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.truecaller.android.sdk.ITrueCallback;
import com.truecaller.android.sdk.PartnerInformation;
import com.truecaller.android.sdk.R;
import com.truecaller.android.sdk.TrueError;
import com.truecaller.android.sdk.TrueException;
import com.truecaller.android.sdk.clients.CustomDataBundle;
import java.util.Objects;
import java.util.UUID;

/* renamed from: yg5  reason: default package */
/* compiled from: TrueClient */
public class yg5 extends xg5 {
    public final wg5 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated
    public yg5(Context context, String str, ITrueCallback iTrueCallback) {
        super(context, str, iTrueCallback, 1);
        wg5 wg5 = new wg5(4, 0, null);
        this.h = wg5;
    }

    public Intent a(Activity activity) {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        try {
            packageInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 64);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        String encodeToString = (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length == 0) ? null : Base64.encodeToString(hd3.u1(signatureArr[0].toByteArray()).getBytes(), 2);
        if (encodeToString != null) {
            if (TextUtils.isEmpty(this.e)) {
                this.e = UUID.randomUUID().toString();
            }
            PartnerInformation partnerInformation = new PartnerInformation("2.6.0", this.d, activity.getPackageName(), encodeToString, this.e, this.f, this.g, activity.getString(R.string.sdk_variant), activity.getString(R.string.sdk_variant_version));
            wg5 wg5 = this.h;
            Intent b = tg5.b(activity, wg5);
            if (b == null) {
                return null;
            }
            Bundle bundle = new Bundle();
            partnerInformation.writeToBundle(bundle);
            bundle.putParcelable(PartnerInformation.PARTNER_INFO_EXTRA, partnerInformation);
            b.putExtra("PARTNERINFO_OTHER_NUMBER", true);
            b.putExtra("truesdk flags", wg5.f3777a);
            b.putExtra("truesdk_consent_title", wg5.b);
            CustomDataBundle customDataBundle = wg5.c;
            if (customDataBundle != null) {
                bundle.putInt("CUSTOMDATA_BTN_COLOR", customDataBundle.f);
                bundle.putInt("CUSTOMDATA_BTN_TEXT_COLOR", customDataBundle.g);
                bundle.putString("CUSTOMDATA_PRIVACY_URL", customDataBundle.h);
                bundle.putString("CUSTOMDATA_TERMS_URL", customDataBundle.i);
                bundle.putInt("CUSTOMDATA_CTA_TEXT_PREFIX_OPTION", customDataBundle.l);
                bundle.putInt("CUSTOMDATA_LOGIN_TEXT_PREFIX_OPTION", customDataBundle.j);
                bundle.putInt("CUSTOMDATA_LOGIN_TEXT_SUFFIX_OPTION", customDataBundle.k);
            }
            b.putExtras(bundle);
            return b;
        }
        throw new RuntimeException(TrueException.TYPE_APP_SIGNATURE_MISSING);
    }

    public void b(ve veVar, int i) {
        if (this.h.a(32)) {
            sg5 sg5 = sg5.b;
            Context context = this.f3926a;
            String str = this.d;
            ITrueCallback iTrueCallback = this.b;
            Objects.requireNonNull(sg5);
            ah5 ah5 = new ah5(context, str, iTrueCallback, true);
            hd3.Q2(veVar);
            iTrueCallback.onVerificationRequired(new TrueError(i));
            sg5.f3212a = ah5;
            return;
        }
        this.b.onFailureProfileShared(new TrueError(i));
    }

    public yg5(Context context, String str, ITrueCallback iTrueCallback, wg5 wg5) {
        super(context, str, iTrueCallback, 1);
        this.h = wg5;
    }
}
