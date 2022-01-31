package com.google.firebase.iid.internal;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-iid-interop@@17.1.0 */
public interface FirebaseInstanceIdInternal {

    /* compiled from: com.google.firebase:firebase-iid-interop@@17.1.0 */
    public interface NewTokenListener {
        void onNewToken(String str);
    }

    void addNewTokenListener(NewTokenListener newTokenListener);

    void deleteToken(String str, String str2) throws IOException;

    String getId();

    String getToken();

    yi4<String> getTokenTask();
}
