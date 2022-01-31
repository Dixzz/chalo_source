package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.os.Handler;
import android.util.Base64;
import com.freshchat.consumer.sdk.JwtTokenStatus;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.User;
import com.freshchat.consumer.sdk.beans.config.UserAuthConfig;
import com.freshchat.consumer.sdk.exception.JwtException;
import com.freshchat.consumer.sdk.exception.MethodNotAllowedException;
import java.lang.ref.WeakReference;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class o {
    private static Handler lh;
    private static a li;

    public static class a implements Runnable {
        private final WeakReference<Context> lk;

        private a(Context context) {
            this.lk = new WeakReference<>(context.getApplicationContext());
        }

        public /* synthetic */ a(Context context, bb bbVar) {
            this(context);
        }

        public void run() {
            if (this.lk.get() != null) {
                com.freshchat.consumer.sdk.b.a.ba(this.lk.get());
            }
            o.go();
        }
    }

    public static boolean P(Context context, String str) {
        String bj = e.i(context).bj();
        return as.a(bj) && as.p(bj, bd(str));
    }

    public static com.freshchat.consumer.sdk.j.c.a a(JwtTokenStatus jwtTokenStatus, JwtTokenStatus jwtTokenStatus2) {
        if (jwtTokenStatus == null) {
            throw new IllegalArgumentException("oldIdTokenState cannot be null in JwtUtils.getUiActionForTokenStatus()");
        } else if (jwtTokenStatus2 != null) {
            JwtTokenStatus jwtTokenStatus3 = JwtTokenStatus.TOKEN_VALID;
            if (jwtTokenStatus2 == jwtTokenStatus3 || jwtTokenStatus2 == JwtTokenStatus.TOKEN_INVALID || jwtTokenStatus2 == JwtTokenStatus.TOKEN_NOT_SET) {
                return b(jwtTokenStatus2);
            }
            JwtTokenStatus jwtTokenStatus4 = JwtTokenStatus.TOKEN_EXPIRED;
            if (jwtTokenStatus2 == jwtTokenStatus4) {
                return jwtTokenStatus == jwtTokenStatus3 ? com.freshchat.consumer.sdk.j.c.a.SHOW_CONTENT : com.freshchat.consumer.sdk.j.c.a.SHOW_PROGRESS;
            }
            if (jwtTokenStatus2 == JwtTokenStatus.TOKEN_NOT_PROCESSED) {
                return jwtTokenStatus == jwtTokenStatus4 ? com.freshchat.consumer.sdk.j.c.a.SHOW_CONTENT : com.freshchat.consumer.sdk.j.c.a.SHOW_PROGRESS;
            }
            StringBuilder i0 = hj1.i0("Cannot determine UiAction for ");
            i0.append(jwtTokenStatus2.name());
            i0.append(" in JwtUtils.getUiActionForTransition()");
            throw new IllegalArgumentException(i0.toString());
        } else {
            throw new IllegalArgumentException("newIdTokenState cannot be null in JwtUtils.getUiActionForTokenStatus()");
        }
    }

    public static void a(Context context, JwtTokenStatus jwtTokenStatus) {
        a(context, jwtTokenStatus, null);
    }

    public static void a(Context context, JwtTokenStatus jwtTokenStatus, String str) {
        e i = e.i(context);
        if (jwtTokenStatus == JwtTokenStatus.TOKEN_EXPIRED || jwtTokenStatus == JwtTokenStatus.TOKEN_INVALID) {
            i.gi();
        } else if (as.a(str)) {
            i.c(str);
        }
        i.a(jwtTokenStatus);
        if (jwtTokenStatus == JwtTokenStatus.TOKEN_VALID) {
            go();
        }
        bg.bM(context);
        com.freshchat.consumer.sdk.b.a.ax(context);
    }

    public static com.freshchat.consumer.sdk.j.c.a b(JwtTokenStatus jwtTokenStatus) {
        if (jwtTokenStatus != null) {
            int i = bb.lj[jwtTokenStatus.ordinal()];
            if (i == 1) {
                return com.freshchat.consumer.sdk.j.c.a.SHOW_CONTENT;
            }
            if (i == 2 || i == 3 || i == 4) {
                return com.freshchat.consumer.sdk.j.c.a.SHOW_PROGRESS;
            }
            if (i == 5) {
                return com.freshchat.consumer.sdk.j.c.a.EXIT_WITH_MESSAGE;
            }
            StringBuilder i0 = hj1.i0("UI Action for jwtTokenStatus - ");
            i0.append(jwtTokenStatus.name());
            i0.append(" is not defined");
            throw new IllegalArgumentException(i0.toString());
        }
        throw new IllegalArgumentException("jwtTokenStatus cannot be null in JwtUtils.getUiActionForTokenStatus()");
    }

    public static void b(Context context, JwtTokenStatus jwtTokenStatus) {
        if (jwtTokenStatus != null) {
            if (jwtTokenStatus == JwtTokenStatus.TOKEN_NOT_SET || jwtTokenStatus == JwtTokenStatus.TOKEN_EXPIRED) {
                bC(context);
            }
        }
    }

    public static void bA(Context context) {
        a(context, JwtTokenStatus.TOKEN_INVALID);
    }

    public static boolean bB(Context context) {
        UserAuthConfig userAuthConfig;
        return ap.aZ(context) && (userAuthConfig = ap.bD(context).getUserAuthConfig()) != null && userAuthConfig.isJwtAuthEnabled() && userAuthConfig.isStrictModeEnabled();
    }

    private static void bC(Context context) {
        if (lh == null) {
            lh = new Handler();
            li = new a(context, null);
            lh.postDelayed(li, ap.bD(context).getUserAuthConfig().getAuthTimeOutInterval());
        }
    }

    public static boolean ba(String str) {
        return s(str, "reference_id");
    }

    public static String bb(String str) {
        return t(str, "reference_id");
    }

    public static boolean bc(String str) {
        return s(str, "freshchat_uuid");
    }

    public static String bd(String str) {
        return t(str, "freshchat_uuid");
    }

    private static Long be(String str) {
        String t = t(str, "exp");
        try {
            if (as.a(t)) {
                return Long.valueOf(Long.parseLong(t));
            }
            return null;
        } catch (Exception e) {
            q.a(e);
            return null;
        }
    }

    private static JSONObject bf(String str) {
        try {
            if (as.a(str)) {
                String[] split = str.split(Pattern.quote("."));
                if (split.length != 3) {
                    return null;
                }
                return new JSONObject(new String(Base64.decode(split[1], 3)));
            }
        } catch (Exception e) {
            q.a(e);
        }
        return null;
    }

    public static boolean bg(String str) {
        Long be;
        if (!as.isEmpty(str) && (be = be(str)) != null) {
            return be.longValue() < n.fP() / 1000;
        }
        return false;
    }

    public static void by(Context context) {
        if (bz(context) == JwtTokenStatus.TOKEN_NOT_PROCESSED && al.aS(context)) {
            x(context, e.i(context).gh());
        }
    }

    public static JwtTokenStatus bz(Context context) {
        e i = e.i(context);
        JwtTokenStatus fromInt = JwtTokenStatus.fromInt(i.gj());
        if ((fromInt != JwtTokenStatus.TOKEN_NOT_PROCESSED && fromInt != JwtTokenStatus.TOKEN_VALID) || !bg(i.gh())) {
            return fromInt;
        }
        JwtTokenStatus jwtTokenStatus = JwtTokenStatus.TOKEN_EXPIRED;
        a(context, jwtTokenStatus);
        return jwtTokenStatus;
    }

    public static void f(Context context, String str, String str2) throws JwtException {
        if (P(context, str)) {
            String bj = e.i(context).bj();
            String bd = bd(str);
            throw new JwtException("Got a JWT Id Token with a different freshchat_uuid in " + str2 + ". Expected uuid:" + bj + ", instead got uuid: " + bd);
        }
    }

    /* access modifiers changed from: private */
    public static void go() {
        a aVar;
        Handler handler = lh;
        if (!(handler == null || (aVar = li) == null)) {
            handler.removeCallbacks(aVar);
        }
        lh = null;
        li = null;
    }

    public static void r(String str, String str2) {
        if (as.isEmpty(str)) {
            throw new IllegalArgumentException(hj1.S(str2, " requires a valid jwt id token object"));
        }
    }

    public static boolean s(String str, String str2) {
        try {
            JSONObject bf = bf(str);
            if (bf == null || !bf.has(str2)) {
                return false;
            }
            return as.a(bf.getString(str2));
        } catch (Exception e) {
            q.a(e);
            return false;
        }
    }

    public static String t(String str, String str2) {
        try {
            JSONObject bf = bf(str);
            if (bf == null || !bf.has(str2)) {
                return null;
            }
            String string = bf.getString(str2);
            if (as.a(string)) {
                return string;
            }
            return null;
        } catch (Exception e) {
            q.a(e);
            return null;
        }
    }

    public static boolean u(String str, String str2) {
        return as.p(as.a(str) ? bd(str) : null, bd(str2));
    }

    public static void v(Context context, String str) throws MethodNotAllowedException {
        if (bB(context)) {
            throw new MethodNotAllowedException(hj1.S(str, " is not allowed because strict mode of identifying users with JWT is enabled for this account"));
        }
    }

    public static void w(Context context, String str) throws MethodNotAllowedException {
        if (!bB(context)) {
            throw new MethodNotAllowedException(hj1.S(str, " is not allowed because identifying users with JWT is not yet enabled for this account!"));
        }
    }

    public static void x(Context context, String str) {
        if (e.i(context).bl()) {
            b.a(context, new User().setJwtIdToken(str));
        } else {
            b.t(context, str);
        }
    }
}
