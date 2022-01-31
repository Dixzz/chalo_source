package com.google.firebase.database.android;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;
import java.util.concurrent.ExecutorService;

public abstract class AndroidAuthTokenProvider implements AuthTokenProvider {
    public static AuthTokenProvider forAuthenticatedAccess(final InternalAuthProvider internalAuthProvider) {
        return new AuthTokenProvider() {
            /* class com.google.firebase.database.android.AndroidAuthTokenProvider.AnonymousClass1 */

            public static /* synthetic */ void lambda$getToken$1(AuthTokenProvider.GetTokenCompletionListener getTokenCompletionListener, Exception exc) {
                if (AndroidAuthTokenProvider.isUnauthenticatedUsage(exc)) {
                    getTokenCompletionListener.onSuccess(null);
                } else {
                    getTokenCompletionListener.onError(exc.getMessage());
                }
            }

            @Override // com.google.firebase.database.core.AuthTokenProvider
            public void addTokenChangeListener(ExecutorService executorService, AuthTokenProvider.TokenChangeListener tokenChangeListener) {
                InternalAuthProvider.this.addIdTokenListener(AndroidAuthTokenProvider$1$$Lambda$3.lambdaFactory$(executorService, tokenChangeListener));
            }

            @Override // com.google.firebase.database.core.AuthTokenProvider
            public void getToken(boolean z, AuthTokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
                InternalAuthProvider.this.getAccessToken(z).f(AndroidAuthTokenProvider$1$$Lambda$1.lambdaFactory$(getTokenCompletionListener)).d(AndroidAuthTokenProvider$1$$Lambda$2.lambdaFactory$(getTokenCompletionListener));
            }

            @Override // com.google.firebase.database.core.AuthTokenProvider
            public void removeTokenChangeListener(AuthTokenProvider.TokenChangeListener tokenChangeListener) {
            }
        };
    }

    public static AuthTokenProvider forUnauthenticatedAccess() {
        return new AuthTokenProvider() {
            /* class com.google.firebase.database.android.AndroidAuthTokenProvider.AnonymousClass2 */

            @Override // com.google.firebase.database.core.AuthTokenProvider
            public void addTokenChangeListener(ExecutorService executorService, AuthTokenProvider.TokenChangeListener tokenChangeListener) {
                executorService.execute(AndroidAuthTokenProvider$2$$Lambda$1.lambdaFactory$(tokenChangeListener));
            }

            @Override // com.google.firebase.database.core.AuthTokenProvider
            public void getToken(boolean z, AuthTokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
                getTokenCompletionListener.onSuccess(null);
            }

            @Override // com.google.firebase.database.core.AuthTokenProvider
            public void removeTokenChangeListener(AuthTokenProvider.TokenChangeListener tokenChangeListener) {
            }
        };
    }

    /* access modifiers changed from: private */
    public static boolean isUnauthenticatedUsage(Exception exc) {
        return (exc instanceof FirebaseApiNotAvailableException) || (exc instanceof FirebaseNoSignedInUserException);
    }
}
