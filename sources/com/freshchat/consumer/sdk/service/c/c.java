package com.freshchat.consumer.sdk.service.c;

import android.content.Context;
import com.freshchat.consumer.sdk.JwtTokenStatus;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.User;
import com.freshchat.consumer.sdk.beans.reqres.UserRequest;
import com.freshchat.consumer.sdk.beans.reqres.UserResponse;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.d;
import com.freshchat.consumer.sdk.j.o;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.e.a;
import com.freshchat.consumer.sdk.service.e.d;
import com.freshchat.consumer.sdk.service.e.k;
import java.util.HashMap;
import java.util.Map;

public class c extends a<a, k> {
    public static final String TAG = "com.freshchat.consumer.sdk.service.c.c";

    private static User a(Context context, a aVar, com.freshchat.consumer.sdk.c.k kVar) {
        e i = e.i(context);
        a(context, aVar.getUser(), kVar, false);
        if (kVar.bV() && !aVar.cY()) {
            return null;
        }
        User a2 = kVar.a(false, true);
        String C = d.C(context);
        a2.setAlias(C);
        String jwtIdToken = kVar.a(true, true).getJwtIdToken();
        if (as.a(jwtIdToken)) {
            return new User().setAlias(C).setJwtIdToken(jwtIdToken);
        }
        if (as.isEmpty(i.bI()) && as.isEmpty(a2.getExternalId()) && as.a(i.bk())) {
            a2.setExternalId(i.bk());
        }
        return a2;
    }

    private User a(User user, String str) throws DeletedException {
        e i = e.i(getContext());
        try {
            UserRequest userRequest = new UserRequest();
            userRequest.setUser(user.setJwtIdToken(null));
            userRequest.setJwtIdToken(str);
            UserResponse a2 = new com.freshchat.consumer.sdk.e.a(getContext()).a(userRequest);
            if (a2 == null) {
                return null;
            }
            if (a2.getStatusCode() == 409) {
                d.bG(getContext());
                return null;
            } else if (a2.getUser() == null) {
                return null;
            } else {
                User user2 = a2.getUser();
                f(user2);
                return user2;
            }
        } catch (Exception e) {
            i.c(false);
            i.t(user.getAlias());
            throw new RuntimeException(e);
        }
    }

    private User a(User user, String str, com.freshchat.consumer.sdk.c.k kVar) throws DeletedException {
        UserResponse userResponse;
        boolean a2 = as.a(str);
        User user2 = null;
        if (a2) {
            UserRequest userRequest = new UserRequest();
            userRequest.setUser(user.setJwtIdToken(null));
            userRequest.setJwtIdToken(str);
            userResponse = new com.freshchat.consumer.sdk.e.a(getContext()).c(userRequest);
        } else {
            userResponse = new com.freshchat.consumer.sdk.e.a(getContext()).n(user.getExternalId(), user.getRestoreId());
        }
        if (userResponse.getStatusCode() == 200) {
            user2 = userResponse.getUser();
            if (user2 != null) {
                if (as.a(str)) {
                    user2.setJwtIdToken(str);
                }
                f(user2);
                Context context = getContext();
                if (!a2) {
                    b.u(context);
                } else {
                    com.freshchat.consumer.sdk.b.a.cn(context);
                }
                b.a(getContext(), 1, d.a.IMMEDIATE);
            }
        } else if ((!a2 && userResponse.getStatusCode() == 418) || (a2 && userResponse.getStatusCode() == 404)) {
            if (a2) {
                o.a(getContext(), JwtTokenStatus.TOKEN_VALID, str);
            }
            user.setAlias(null);
            user.setRestoreId(null);
            dw().is();
            kVar.iu();
            b.a(getContext(), user, w.aB(getContext()));
        }
        return user2;
    }

    private static void a(Context context, User user, com.freshchat.consumer.sdk.c.k kVar, boolean z) {
        if (user == null) {
            user = com.freshchat.consumer.sdk.j.d.bF(context);
        }
        com.freshchat.consumer.sdk.j.d.a(e.i(context), user);
        if (z) {
            kVar.b(user);
        } else {
            kVar.a(user);
        }
    }

    private static void a(Context context, a aVar) {
        ab abVar = new ab(new ab.a());
        com.freshchat.consumer.sdk.service.a.a m = com.freshchat.consumer.sdk.service.a.c.m(context, 1);
        com.freshchat.consumer.sdk.service.a.a aVar2 = new com.freshchat.consumer.sdk.service.a.a(1);
        if (m != null) {
            Map<String, String> meta = m.getMeta();
            a aVar3 = (a) abVar.fromJson(com.freshchat.consumer.sdk.j.k.d(meta) ? meta.get("fc_create_or_update_user") : "{}", a.class);
            if (aVar3 != null) {
                if (aVar3.cN()) {
                    aVar.n(true);
                }
                if (aVar3.cY()) {
                    aVar.o(true);
                }
            }
        }
        String json = abVar.toJson(aVar);
        HashMap hashMap = new HashMap();
        hashMap.put("fc_create_or_update_user", json);
        aVar2.b(hashMap);
        aa.c(context, aVar2);
    }

    public static boolean a(JwtTokenStatus jwtTokenStatus, String str, String str2, boolean z) {
        if (z) {
            return false;
        }
        if (!(as.a(str2) && o.ba(str2) && jwtTokenStatus == JwtTokenStatus.TOKEN_NOT_PROCESSED)) {
            return false;
        }
        return (!o.bc(str) || !o.bc(str2)) ? as.p(str, str2) : o.u(str, str2);
    }

    private boolean a(a aVar, User user) {
        boolean bl = dw().bl();
        return as.a(user.getJwtIdToken()) ? (o.bz(getContext()) == JwtTokenStatus.TOKEN_VALID || o.bz(getContext()) == JwtTokenStatus.TOKEN_NOT_PROCESSED) && !bl && aVar.cN() : !bl && aVar.cN();
    }

    private boolean a(String str, User user) {
        if (user == null) {
            return false;
        }
        return a(o.bz(getContext()), str, user.getJwtIdToken(), dw().bl());
    }

    private boolean a(String str, String str2, User user) {
        if (user == null) {
            return false;
        }
        String externalId = user.getExternalId();
        String restoreId = user.getRestoreId();
        boolean z = true;
        boolean z2 = as.a(externalId) && as.a(restoreId);
        if (z2) {
            if (!as.o(str, externalId) || !as.o(str2, restoreId)) {
                z = false;
            }
            if (z) {
                return false;
            }
        }
        return z2;
    }

    private User b(User user, String str) throws DeletedException {
        JwtTokenStatus bz;
        if (as.a(str) && (bz = o.bz(getContext())) != JwtTokenStatus.TOKEN_NOT_PROCESSED) {
            if (bz != JwtTokenStatus.TOKEN_VALID) {
                ai.e("FreshchatTest", "Stopping user update");
                return null;
            } else if (o.P(getContext(), str)) {
                return null;
            }
        }
        UserRequest userRequest = new UserRequest();
        userRequest.setUser(user.setJwtIdToken(null));
        userRequest.setJwtIdToken(str);
        UserResponse b = new com.freshchat.consumer.sdk.e.a(getContext()).b(userRequest);
        if (b.getStatusCode() == 409) {
            o.bA(getContext());
        } else if (b.getUser() != null) {
            if (com.freshchat.consumer.sdk.service.a.c.bd(getContext())) {
                b.M(getContext());
            }
            if (as.a(str)) {
                b.bJ(getContext());
            }
        }
        return b.getUser();
    }

    private void c(a aVar) {
        com.freshchat.consumer.sdk.service.a.a m = com.freshchat.consumer.sdk.service.a.c.m(getContext(), 1);
        if (m != null) {
            ab abVar = new ab(new ab.a());
            Map<String, String> meta = m.getMeta();
            a aVar2 = (a) abVar.fromJson(com.freshchat.consumer.sdk.j.k.d(meta) ? meta.get("fc_create_or_update_user") : "{}", a.class);
            if (aVar2 != null) {
                if (aVar2.cN()) {
                    aVar.n(true);
                }
                if (aVar2.cY()) {
                    aVar.o(true);
                }
            }
        }
    }

    private void f(User user) {
        if (user != null) {
            String alias = user.getAlias();
            String str = TAG;
            ai.d(str, "Result for create user is " + alias);
            e i = e.i(getContext());
            i.t(alias);
            i.c(true);
            b.Q(getContext(), i.bP());
            b.U(getContext());
            b.T(getContext());
            b.S(getContext());
            if (com.freshchat.consumer.sdk.service.a.c.s(getContext())) {
                b.M(getContext());
            }
        }
    }

    private void g(User user) {
        if (!com.freshchat.consumer.sdk.j.k.c(user.getAndroidDeviceMeta())) {
            e i = e.i(getContext());
            Map<String, String> androidDeviceMeta = user.getAndroidDeviceMeta();
            if (androidDeviceMeta.containsKey(User.DEVICE_META_APP_VERSION_CODE)) {
                String str = androidDeviceMeta.get(User.DEVICE_META_APP_VERSION_CODE);
                if (as.a(str) && !str.equals(i.bm())) {
                    i.v(str);
                }
            }
            if (androidDeviceMeta.containsKey(User.DEVICE_META_SDK_VERSION_CODE)) {
                i.k(Integer.parseInt(androidDeviceMeta.get(User.DEVICE_META_SDK_VERSION_CODE)));
            }
        }
    }

    public boolean a(a aVar) {
        return w.ay(getContext()) && w.aA(getContext()) && e.i(getContext()).bl();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0188, code lost:
        if (com.freshchat.consumer.sdk.j.as.a(r10.dr()) != false) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x018a, code lost:
        com.freshchat.consumer.sdk.j.aa.l(getContext(), r10.dr());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01cc, code lost:
        if (com.freshchat.consumer.sdk.j.as.a(r10.dr()) != false) goto L_0x018a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.service.e.k b(com.freshchat.consumer.sdk.service.e.a r10) {
        /*
        // Method dump skipped, instructions count: 529
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.service.c.c.b(com.freshchat.consumer.sdk.service.e.a):com.freshchat.consumer.sdk.service.e.k");
    }
}
