package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.firebase.crashlytics.internal.common.IdManager;
import defpackage.c26;
import defpackage.k06;
import java.util.Objects;

public class Answers extends c06<Boolean> {
    public static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    public static final String TAG = "Answers";
    public SessionAnalyticsManager analyticsManager;

    public static Answers getInstance() {
        xz5.a(Answers.class);
        throw null;
    }

    @Override // defpackage.c06
    public String getIdentifier() {
        return "com.crashlytics.sdk.android:answers";
    }

    public String getOverridenSpiEndpoint() {
        return j06.g(getContext(), "com.crashlytics.ApiEndpoint");
    }

    @Override // defpackage.c06
    public String getVersion() {
        return "1.3.10.143";
    }

    public void logAddToCart(AddToCartEvent addToCartEvent) {
        Objects.requireNonNull(addToCartEvent, "event must not be null");
        SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(addToCartEvent);
        }
    }

    public void logContentView(ContentViewEvent contentViewEvent) {
        Objects.requireNonNull(contentViewEvent, "event must not be null");
        SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(contentViewEvent);
        }
    }

    public void logCustom(CustomEvent customEvent) {
        Objects.requireNonNull(customEvent, "event must not be null");
        SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onCustom(customEvent);
        }
    }

    public void logInvite(InviteEvent inviteEvent) {
        Objects.requireNonNull(inviteEvent, "event must not be null");
        SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(inviteEvent);
        }
    }

    public void logLevelEnd(LevelEndEvent levelEndEvent) {
        Objects.requireNonNull(levelEndEvent, "event must not be null");
        SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(levelEndEvent);
        }
    }

    public void logLevelStart(LevelStartEvent levelStartEvent) {
        Objects.requireNonNull(levelStartEvent, "event must not be null");
        SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(levelStartEvent);
        }
    }

    public void logLogin(LoginEvent loginEvent) {
        Objects.requireNonNull(loginEvent, "event must not be null");
        SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(loginEvent);
        }
    }

    public void logPurchase(PurchaseEvent purchaseEvent) {
        Objects.requireNonNull(purchaseEvent, "event must not be null");
        SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(purchaseEvent);
        }
    }

    public void logRating(RatingEvent ratingEvent) {
        Objects.requireNonNull(ratingEvent, "event must not be null");
        SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(ratingEvent);
        }
    }

    public void logSearch(SearchEvent searchEvent) {
        Objects.requireNonNull(searchEvent, "event must not be null");
        SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(searchEvent);
        }
    }

    public void logShare(ShareEvent shareEvent) {
        Objects.requireNonNull(shareEvent, "event must not be null");
        SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(shareEvent);
        }
    }

    public void logSignUp(SignUpEvent signUpEvent) {
        Objects.requireNonNull(signUpEvent, "event must not be null");
        SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(signUpEvent);
        }
    }

    public void logStartCheckout(StartCheckoutEvent startCheckoutEvent) {
        Objects.requireNonNull(startCheckoutEvent, "event must not be null");
        SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(startCheckoutEvent);
        }
    }

    public void onException(k06.b bVar) {
        SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onError(bVar.f2008a);
        }
    }

    @Override // defpackage.c06
    @SuppressLint({"NewApi"})
    public boolean onPreExecute() {
        try {
            Context context = getContext();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String num = Integer.toString(packageInfo.versionCode);
            String str = packageInfo.versionName;
            if (str == null) {
                str = IdManager.DEFAULT_VERSION_NAME;
            }
            SessionAnalyticsManager build = SessionAnalyticsManager.build(this, context, getIdManager(), num, str, packageInfo.firstInstallTime);
            this.analyticsManager = build;
            build.enable();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // defpackage.c06
    public Boolean doInBackground() {
        Boolean bool = Boolean.FALSE;
        try {
            if (c26.b.f510a.a() == null) {
                return bool;
            }
            throw null;
        } catch (Exception unused) {
            return bool;
        }
    }

    public void onException(k06.a aVar) {
        SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onCrash(aVar.f2008a, aVar.b);
        }
    }
}
