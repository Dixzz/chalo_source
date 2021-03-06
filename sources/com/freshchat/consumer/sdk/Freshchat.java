package com.freshchat.consumer.sdk;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.freshchat.consumer.sdk.b.c;
import com.freshchat.consumer.sdk.b.d;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.User;
import com.freshchat.consumer.sdk.exception.InvalidDomainException;
import com.freshchat.consumer.sdk.exception.JwtException;
import com.freshchat.consumer.sdk.exception.MethodNotAllowedException;
import com.freshchat.consumer.sdk.exception.PermissionNotGrantedException;
import com.freshchat.consumer.sdk.h.b;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.af;
import com.freshchat.consumer.sdk.j.ag;
import com.freshchat.consumer.sdk.j.ah;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.am;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.aw;
import com.freshchat.consumer.sdk.j.ba;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.by;
import com.freshchat.consumer.sdk.j.f;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.o;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.j.y;
import com.freshchat.consumer.sdk.service.a;
import com.freshchat.consumer.sdk.service.e.d;
import com.freshchat.consumer.sdk.service.e.g;
import com.freshchat.consumer.sdk.service.e.l;
import com.freshchat.consumer.sdk.util.DeepLinkUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class Freshchat {
    public static final String FRESHCHAT_ACTION_MESSAGE_COUNT_CHANGED = "com.freshchat.consumer.sdk.MessageCountChanged";
    public static final String FRESHCHAT_ACTION_NOTIFICATION_INTERCEPTED = "com.freshchat.consumer.sdk.FreshchatNotificationIntercepted";
    public static final String FRESHCHAT_EVENTS = "com.freshchat.consumer.sdk.FreshchatEvents";
    public static final String FRESHCHAT_SET_TOKEN_TO_REFRESH_DEVICE_PROPERTIES = "com.freshchat.consumer.sdk.actions.SetTokenToRefreshDeviceProperties";
    public static final String FRESHCHAT_UNREAD_MESSAGE_COUNT_CHANGED = "com.freshchat.consumer.sdk.MessageCountChanged";
    public static final String FRESHCHAT_USER_RESTORE_ID_GENERATED = "com.freshchat.consumer.sdk.UserRestoreIdGenerated";
    private static volatile Freshchat INSTANCE;
    private static AtomicBoolean lifecycleCallbacksRegistered = new AtomicBoolean(false);
    private final Context context;
    private WeakReference<FreshchatUserInteractionListener> freshchatUserInteractionListenerReference;
    private WeakReference<LinkHandler> linkHandlerReference;
    private WeakReference<FreshchatWebViewListener> webviewListenerReference;

    private Freshchat(Context context2) {
        this.context = context2.getApplicationContext();
    }

    /* access modifiers changed from: private */
    public static void executeUnreadCountCallback(final UnreadCountCallback unreadCountCallback, final FreshchatCallbackStatus freshchatCallbackStatus, final int i) {
        if (unreadCountCallback != null) {
            new f().execute(new Runnable() {
                /* class com.freshchat.consumer.sdk.Freshchat.AnonymousClass2 */

                public void run() {
                    UnreadCountCallback.this.onResult(freshchatCallbackStatus, i);
                }
            });
        }
    }

    private Context getContext() {
        return this.context;
    }

    public static Event getEventFromBundle(Bundle bundle) {
        return bg.e(bundle);
    }

    public static Freshchat getInstance(Context context2) {
        if (context2 != null) {
            if (INSTANCE == null) {
                synchronized (Freshchat.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new Freshchat(context2);
                    }
                }
            }
            return INSTANCE;
        }
        throw new IllegalArgumentException("getInstance() requires a valid context");
    }

    public static int getSDKVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    public static void handleFcmMessage(Context context2, Object obj) {
        if (context2 != null) {
            Bundle a2 = b.a(obj);
            if (a2 == null) {
                throw new IllegalArgumentException(c.INVALID_NOTIFICATION_PAYLOAD.toString());
            } else if (isFreshchatNotification(a2)) {
                StringBuilder i0 = hj1.i0("Got notification for ");
                i0.append(context2.getPackageName());
                ai.d("FRESHCHAT", i0.toString());
                Intent intent = new Intent();
                intent.putExtras(a2);
                ag.a("FRESHCHAT", intent);
                b.b(context2, intent);
            }
        } else {
            throw new IllegalArgumentException("Context is a mandatory param for handleFcmMessage()");
        }
    }

    private static boolean hasSavedConfig(Context context2) {
        e i = e.i(context2);
        return !as.isEmpty(i.getAppId()) && !as.isEmpty(i.getAppKey());
    }

    public static boolean isFreshchatNotification(Intent intent) {
        if (intent != null) {
            return isFreshchatNotification(intent.getExtras());
        }
        return false;
    }

    public static boolean isFreshchatNotification(Bundle bundle) {
        return bundle != null && bundle.containsKey("source") && "freshchat_user".equals(bundle.getString("source"));
    }

    public static boolean isFreshchatNotification(Object obj) {
        Bundle a2 = b.a(obj);
        return a2 != null && isFreshchatNotification(a2);
    }

    public static void notifyAppLocaleChange(Context context2) {
        if (context2 == null) {
            throw new IllegalArgumentException("notifyAppLocaleChange() requires a valid context");
        } else if (!hasSavedConfig(context2)) {
            String replace = context2.getString(R.string.freshchat_error_message_init_not_completed).replace(context2.getString(R.string.freshchat_error_message_init_not_completed_method_name_placeholder), "notifyAppLocaleChange()");
            Toast.makeText(context2, replace, 1).show();
            ai.w("FRESHCHAT_WARNING", replace);
        } else {
            ah.bN(context2);
        }
    }

    public static void openFreshchatDeeplink(Context context2, String str) {
        if (context2 == null) {
            throw new IllegalArgumentException("Context is a mandatory param for openFreshchatDeeplink()");
        } else if (!as.isEmpty(str)) {
            try {
                Uri parse = Uri.parse(str);
                if (DeepLinkUtils.c(parse)) {
                    DeepLinkUtils.b(context2, parse, null);
                } else {
                    DeepLinkUtils.c(context2, parse, (Bundle) null);
                }
            } catch (Exception unused) {
            }
        } else {
            throw new IllegalArgumentException("Deeplink url is a mandatory param for openFreshchatDeeplink()");
        }
    }

    private void registerLifecycleCallbacks() {
        try {
            if (!lifecycleCallbacksRegistered.get()) {
                ((Application) this.context).registerActivityLifecycleCallbacks(new d());
                lifecycleCallbacksRegistered.set(true);
            }
        } catch (Exception e) {
            q.a(e);
        }
    }

    public static void resetUser(Context context2) {
        aa.a(context2, true, true);
    }

    public static void sendMessage(Context context2, FreshchatMessage freshchatMessage) {
        if (context2 == null) {
            throw new IllegalArgumentException("sendMessage() requires a valid context");
        } else if (freshchatMessage == null) {
            throw new IllegalArgumentException("sendMessage() requires a non null instance of FreshchatMessage");
        } else if (!as.isEmpty(freshchatMessage.getMessage())) {
            if (!o.bB(context2) || o.bz(context2) == JwtTokenStatus.TOKEN_VALID) {
                com.freshchat.consumer.sdk.service.e.o oVar = new com.freshchat.consumer.sdk.service.e.o();
                oVar.ao(freshchatMessage.getTag());
                oVar.setText(freshchatMessage.getMessage());
                com.freshchat.consumer.sdk.service.d.d.b(context2, oVar);
            }
        }
    }

    public static void setConversationBannerMessage(Context context2, String str) {
        e i = e.i(context2);
        if (str == null) {
            str = "";
        }
        i.putString("CONFIG_CONVERSATION_BANNER_MESSAGE", str.trim());
    }

    public static void setImageLoader(FreshchatImageLoader freshchatImageLoader) {
        af.a(freshchatImageLoader);
    }

    public static void showConversations(Context context2) {
        showConversations(context2, null);
    }

    public static void showConversations(Context context2, ConversationOptions conversationOptions) {
        if (!aw.eQ()) {
            ai.w("FRESHCHAT_WARNING", c.ERROR_UNSUPPORTED_OS_VERSION.toString());
        } else if (context2 == null) {
            throw new IllegalArgumentException("showConversations() requires a valid context");
        } else if (!w.ay(context2)) {
            com.freshchat.consumer.sdk.j.b.L(context2);
            i.a(context2, R.string.freshchat_error_message_account_not_active);
        } else if (!w.aA(context2)) {
            i.a(context2, R.string.freshchat_error_message_inbox_section_not_enabled);
        } else if (!hasSavedConfig(context2)) {
            String replace = context2.getString(R.string.freshchat_error_message_init_not_completed).replace(context2.getString(R.string.freshchat_error_message_init_not_completed_method_name_placeholder), "showConversations()");
            Toast.makeText(context2, replace, 1).show();
            ai.w("FRESHCHAT_WARNING", replace);
        } else {
            com.freshchat.consumer.sdk.j.b.R(context2);
            if (conversationOptions == null) {
                conversationOptions = new ConversationOptions();
            }
            if (k.b(conversationOptions.getTags()) > 25) {
                i.a(context2, R.string.freshchat_error_message_failed_to_launch_support_section);
                ai.e("FRESHCHAT_WARNING", c.ERROR_TAGS_COUNT_EXCEEDED.toString());
                return;
            }
            com.freshchat.consumer.sdk.j.c.a(context2, conversationOptions).ea();
        }
    }

    public static void showFAQs(Context context2) {
        showFAQs(context2, new FaqOptions());
    }

    public static void showFAQs(Context context2, FaqOptions faqOptions) {
        if (!aw.eQ()) {
            ai.w("FRESHCHAT_WARNING", c.ERROR_UNSUPPORTED_OS_VERSION.toString());
        } else if (context2 == null) {
            throw new IllegalArgumentException("showFAQs() requires a valid context");
        } else if (!w.ay(context2)) {
            com.freshchat.consumer.sdk.j.b.L(context2);
            i.a(context2, R.string.freshchat_error_message_account_not_active);
        } else if (!w.az(context2)) {
            i.a(context2, R.string.freshchat_error_message_faq_section_not_enabled);
        } else if (!hasSavedConfig(context2)) {
            String replace = context2.getString(R.string.freshchat_error_message_init_not_completed).replace(context2.getString(R.string.freshchat_error_message_init_not_completed_method_name_placeholder), "showFAQs()");
            Toast.makeText(context2, replace, 1).show();
            ai.w("FRESHCHAT_WARNING", replace);
        } else {
            if (faqOptions == null) {
                faqOptions = new FaqOptions();
            }
            if (k.b(faqOptions.getTags()) > 25) {
                i.a(context2, R.string.freshchat_error_message_failed_to_launch_support_section);
                ai.e("FRESHCHAT_WARNING", c.ERROR_TAGS_COUNT_EXCEEDED.toString());
                return;
            }
            com.freshchat.consumer.sdk.j.c.a(context2, faqOptions).ea();
        }
    }

    public static void trackEvent(Context context2, String str, Map<String, Object> map) {
        if (!aw.eQ()) {
            ai.w("FRESHCHAT_WARNING", c.ERROR_UNSUPPORTED_OS_VERSION.toString());
        } else if (context2 == null) {
            throw new IllegalArgumentException("trackEvent() requires a valid context");
        } else if (!w.ay(context2)) {
            ai.e("FRESHCHAT", context2.getString(R.string.freshchat_error_message_account_not_active));
        } else if (!e.i(context2).isUserEventsTrackingEnabled()) {
            ai.w("FRESHCHAT", c.USER_EVENT_TRACKING_DISABLED.toString());
        } else if (!o.bB(context2) || o.bz(context2) != JwtTokenStatus.TOKEN_INVALID) {
            by.gN().b(context2.getApplicationContext(), str, map);
        }
    }

    public LinkHandler getCustomLinkHandler() {
        WeakReference<LinkHandler> weakReference = this.linkHandlerReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String getFreshchatUserId() {
        return com.freshchat.consumer.sdk.j.d.C(getContext());
    }

    public FreshchatUserInteractionListener getFreshchatUserInteractionListener() {
        WeakReference<FreshchatUserInteractionListener> weakReference = this.freshchatUserInteractionListenerReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void getUnreadCountAsync(UnreadCountCallback unreadCountCallback) {
        getUnreadCountAsync(unreadCountCallback, null);
    }

    public final void getUnreadCountAsync(final UnreadCountCallback unreadCountCallback, final List<String> list) {
        if (unreadCountCallback == null) {
            ai.e("FRESHCHAT_WARNING", "Invalid callback received. Not fetching unread count");
            return;
        }
        if (this.context == null) {
            com.freshchat.consumer.sdk.service.e.w wVar = new com.freshchat.consumer.sdk.service.e.w();
            wVar.a(FreshchatCallbackStatus.STATUS_ERROR);
            executeUnreadCountCallback(unreadCountCallback, wVar.dO(), wVar.getCount());
        }
        com.freshchat.consumer.sdk.j.b.a(this.context, 5, d.a.LAID_BACK, new a() {
            /* class com.freshchat.consumer.sdk.Freshchat.AnonymousClass1 */

            @Override // com.freshchat.consumer.sdk.service.a
            public void a(com.freshchat.consumer.sdk.service.e.k kVar) {
                com.freshchat.consumer.sdk.service.d.d.c(Freshchat.this.context, new g().t(list), new a<com.freshchat.consumer.sdk.service.e.w>() {
                    /* class com.freshchat.consumer.sdk.Freshchat.AnonymousClass1.AnonymousClass1 */

                    public void a(com.freshchat.consumer.sdk.service.e.w wVar) {
                        if (wVar != null) {
                            Freshchat.executeUnreadCountCallback(unreadCountCallback, wVar.dO(), wVar.getCount());
                        }
                    }
                });
            }
        });
    }

    public FreshchatUser getUser() {
        e i = e.i(this.context);
        return com.freshchat.consumer.sdk.j.d.b(getContext(), new FreshchatUser(i.bk(), i.bI()));
    }

    public JwtTokenStatus getUserIdTokenStatus() {
        return o.bz(getContext());
    }

    public FreshchatWebViewListener getWebviewListener() {
        WeakReference<FreshchatWebViewListener> weakReference = this.webviewListenerReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Freshchat identifyUser(String str, String str2) throws MethodNotAllowedException {
        o.v(getContext(), "identifyUser()");
        try {
            e i = e.i(this.context);
            int b = com.freshchat.consumer.sdk.j.d.b(i.bk(), i.bI(), str, str2);
            if (b != 100) {
                if (b != 200) {
                    if (b == 300 || b == 400) {
                        resetUser(this.context);
                    }
                    com.freshchat.consumer.sdk.j.b.a(this.context, new User().setExternalId(str).setRestoreId(str2));
                    return INSTANCE;
                }
            }
            return INSTANCE;
        } catch (Exception e) {
            q.a(e);
        }
    }

    public void init(FreshchatConfig freshchatConfig) {
        if (!aw.eQ()) {
            ai.w("FRESHCHAT_WARNING", c.ERROR_UNSUPPORTED_OS_VERSION.toString());
        } else if (!w.ay(this.context)) {
            com.freshchat.consumer.sdk.j.b.L(this.context);
            ai.w("FRESHCHAT_WARNING", "Account is not active");
            i.a(this.context, R.string.freshchat_error_message_account_not_active);
        } else {
            try {
                y.a(freshchatConfig);
            } catch (InvalidDomainException e) {
                i.e(this.context, e.getMessage());
            }
            aa.aH(getContext());
            ba.fX();
            if (freshchatConfig.isCameraCaptureEnabled()) {
                com.freshchat.consumer.sdk.j.g.ak(this.context);
            }
            try {
                am.aT(getContext());
            } catch (PermissionNotGrantedException e2) {
                ai.e("FRESHCHAT_WARNING", "Permission required for Freshchat is missing!", e2);
            }
            com.freshchat.consumer.sdk.j.b.c.fD();
            registerLifecycleCallbacks();
            e.i(this.context).dp();
            l lVar = new l(freshchatConfig);
            if (as.isEmpty(e.i(this.context).getAppId())) {
                y.a(this.context, lVar);
            }
            com.freshchat.consumer.sdk.service.d.d.b(this.context, lVar);
            com.freshchat.consumer.sdk.j.b.R(this.context);
            ai.d("FRESHCHAT", "Freshchat init completed for app " + freshchatConfig.getAppId());
        }
    }

    public Freshchat linkifyWithPattern(String str, String str2) {
        e i = e.i(getContext());
        i.w(str);
        i.x(str2);
        return INSTANCE;
    }

    public Freshchat restoreUser(String str) throws MethodNotAllowedException, JwtException {
        o.w(getContext(), "restoreUser()");
        o.r(str, "restoreUser()");
        if (o.ba(str)) {
            try {
                int v = com.freshchat.consumer.sdk.j.d.v(e.i(this.context).gh(), str);
                if (v != 100) {
                    if (v != 200) {
                        if (v == 300 || v == 400) {
                            resetUser(this.context);
                        }
                        o.a(getContext(), JwtTokenStatus.TOKEN_NOT_PROCESSED, str);
                        com.freshchat.consumer.sdk.j.b.a(this.context, new User().setJwtIdToken(str));
                        return INSTANCE;
                    }
                }
                return INSTANCE;
            } catch (Exception e) {
                q.a(e);
            }
        } else {
            o.a(getContext(), JwtTokenStatus.TOKEN_INVALID, str);
            throw new JwtException(hj1.T("JWT Id Token provided in ", "restoreUser()", " doesn't have the mandatory field reference_id"));
        }
    }

    public void setCustomLinkHandler(LinkHandler linkHandler) {
        if (linkHandler == null) {
            this.linkHandlerReference = null;
        } else {
            this.linkHandlerReference = new WeakReference<>(linkHandler);
        }
    }

    public void setFreshchatUserInteractionListener(FreshchatUserInteractionListener freshchatUserInteractionListener) {
        this.freshchatUserInteractionListenerReference = new WeakReference<>(freshchatUserInteractionListener);
    }

    public Freshchat setNotificationConfig(FreshchatNotificationConfig freshchatNotificationConfig) {
        if (freshchatNotificationConfig != null) {
            b.a(getContext(), freshchatNotificationConfig);
            b.O(getContext());
        } else {
            ai.w("FRESHCHAT", c.INVALID_NOTIFICATION_CONFIG.toString());
        }
        return INSTANCE;
    }

    public void setPushRegistrationToken(String str) {
        e i = e.i(this.context);
        String bP = i.bP();
        if (!as.isEmpty(str) && !as.o(str, bP)) {
            i.G(str);
            com.freshchat.consumer.sdk.j.b.Q(this.context, str);
        }
    }

    public Freshchat setUser(FreshchatUser freshchatUser) throws MethodNotAllowedException {
        o.v(this.context, "setUser()");
        if (freshchatUser != null) {
            com.freshchat.consumer.sdk.j.d.a(this.context, freshchatUser);
            return INSTANCE;
        }
        throw new IllegalArgumentException("setUser() requires a valid FreshchatUser object");
    }

    public Freshchat setUser(String str) throws MethodNotAllowedException, JwtException {
        o.w(getContext(), "setUser()");
        o.r(str, "setUser()");
        o.f(this.context, str, "setUser()");
        if (as.o(e.i(this.context).gh(), str)) {
            return INSTANCE;
        }
        o.a(getContext(), JwtTokenStatus.TOKEN_NOT_PROCESSED, str);
        o.x(this.context, str);
        return INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.Freshchat setUserProperties(java.util.Map<java.lang.String, java.lang.String> r3) throws com.freshchat.consumer.sdk.exception.MethodNotAllowedException {
        /*
            r2 = this;
            android.content.Context r0 = r2.getContext()
            java.lang.String r1 = "setUserProperties()"
            com.freshchat.consumer.sdk.j.o.v(r0, r1)
            boolean r0 = com.freshchat.consumer.sdk.j.k.d(r3)
            if (r0 == 0) goto L_0x0039
            java.util.Set r0 = r3.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0017:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0034
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x002c
            java.lang.Object r1 = r3.get(r1)
            if (r1 == 0) goto L_0x002c
            goto L_0x0017
        L_0x002c:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "setUserProperties() requires non null keys and values"
            r3.<init>(r0)
            throw r3
        L_0x0034:
            android.content.Context r0 = r2.context
            com.freshchat.consumer.sdk.j.d.a(r0, r3)
        L_0x0039:
            com.freshchat.consumer.sdk.Freshchat r3 = com.freshchat.consumer.sdk.Freshchat.INSTANCE
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.Freshchat.setUserProperties(java.util.Map):com.freshchat.consumer.sdk.Freshchat");
    }

    public Freshchat setUserProperty(String str, String str2) throws MethodNotAllowedException {
        o.v(getContext(), "setUserProperty()");
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("setUserProperty() requires a non null key and value");
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        setUserProperties(hashMap);
        return INSTANCE;
    }

    public void setWebviewListener(FreshchatWebViewListener freshchatWebViewListener) {
        if (freshchatWebViewListener == null) {
            this.webviewListenerReference = null;
        } else {
            this.webviewListenerReference = new WeakReference<>(freshchatWebViewListener);
        }
    }
}
