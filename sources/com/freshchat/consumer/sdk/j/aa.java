package com.freshchat.consumer.sdk.j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Environment;
import android.util.SparseBooleanArray;
import com.freshchat.consumer.sdk.ConversationOptions;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.FreshchatConfig;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Conversation;
import com.freshchat.consumer.sdk.beans.MarketingMessageStatus;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.c.e;
import com.freshchat.consumer.sdk.exception.FreshchatComponentNotFoundException;
import com.freshchat.consumer.sdk.exception.InvalidDomainException;
import com.freshchat.consumer.sdk.h.b;
import com.freshchat.consumer.sdk.receiver.FreshchatNetworkChangeReceiver;
import com.freshchat.consumer.sdk.service.a.c;
import com.freshchat.consumer.sdk.service.e.d;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.List;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.Stream;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Spliterator;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

public class aa {
    private static final List<String> hJ = new j$.util.List() {
        /* class com.freshchat.consumer.sdk.j.aa.AnonymousClass1 */

        {
            add("com.freshchat.consumer.sdk.activity.CategoryListActivity");
            add("com.freshchat.consumer.sdk.activity.ArticleListActivity");
            add("com.freshchat.consumer.sdk.activity.ArticleDetailActivity");
            add("com.freshchat.consumer.sdk.activity.ChannelListActivity");
            add("com.freshchat.consumer.sdk.activity.ConversationDetailActivity");
            add("com.freshchat.consumer.sdk.activity.DeeplinkInterstitialActivity");
            add("com.freshchat.consumer.sdk.activity.PictureAttachmentActivity");
            add("com.freshchat.consumer.sdk.service.FreshchatService");
            add("com.freshchat.consumer.sdk.receiver.FreshchatReceiver");
            add("com.freshchat.consumer.sdk.provider.FreshchatInitProvider");
            add("com.freshchat.consumer.sdk.activity.FAQCategoriesActivity");
            add("com.freshchat.consumer.sdk.activity.FAQListActivity");
            add("com.freshchat.consumer.sdk.activity.FAQDetailsActivity");
            add("com.freshchat.consumer.sdk.activity.FAQSearchActivity");
            add("com.freshchat.consumer.sdk.activity.InterstitialActivity");
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        @Override // j$.util.Collection, java.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return Collection.CC.$default$parallelStream(this);
        }

        @Override // j$.util.Collection
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        @Override // j$.util.List
        public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
            List.CC.$default$replaceAll(this, unaryOperator);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.List, java.util.ArrayList, java.util.List
        public /* synthetic */ void sort(Comparator<? super String> comparator) {
            List.CC.$default$sort(this, comparator);
        }

        /* Return type fixed from 'j$.util.Spliterator' to match base method */
        @Override // j$.util.Collection, java.util.Collection, j$.util.List, java.lang.Iterable, java.util.ArrayList, java.util.List, j$.lang.Iterable
        public /* synthetic */ Spliterator<String> spliterator() {
            return List.CC.$default$spliterator(this);
        }

        @Override // j$.util.Collection, java.util.Collection
        public /* synthetic */ Stream stream() {
            return Collection.CC.$default$stream(this);
        }
    };

    public enum a {
        CLEAR_USER_INFO,
        CLEAR_ALL_INFO
    }

    public static m a(Context context, ConversationOptions conversationOptions) {
        c a2 = c.a(context, conversationOptions);
        if (a2 instanceof m) {
            return (m) a2;
        }
        return null;
    }

    public static v a(Context context, FaqOptions faqOptions) {
        c a2 = c.a(context, faqOptions);
        if (a2 instanceof v) {
            return (v) a2;
        }
        return null;
    }

    public static void a(Context context, long j, long j2, int i, d.a aVar, boolean z) {
        if (context != null && j > 0) {
            boolean z2 = false;
            e eVar = new e(context);
            Conversation conversation = null;
            int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i2 == 0) {
                conversation = eVar.f(j);
            }
            boolean z3 = true;
            if (conversation == null || conversation.getConversationId() == 0) {
                if (i2 > 0) {
                    Conversation conversation2 = new Conversation(j2);
                    conversation2.setChannelId(j);
                    eVar.a(conversation2);
                }
                z2 = true;
            }
            if (z2 || i != 6 || z) {
                z3 = z2;
            }
            if (z3) {
                b.a(context, i, aVar);
            }
        }
    }

    private static void a(Context context, long j, boolean z, boolean z2, boolean z3) {
        ai.d("FRESHCHAT", "updateMarketingMessageStatus => marketingId = [" + j + "], isDelivered = [" + z + "], isClicked = [" + z2 + "], isSeen = [" + z3 + "]");
        if (j >= 1) {
            try {
                b.a(context, new MarketingMessageStatus.Builder().clicked(z2 ? 1 : 0).delivered(z ? 1 : 0).seen(z3 ? 1 : 0).marketingId(j).build());
            } catch (Exception e) {
                q.a(e);
            }
        }
    }

    private static void a(Context context, a aVar) {
        com.freshchat.consumer.sdk.b.e i = com.freshchat.consumer.sdk.b.e.i(context);
        if (i == null) {
            return;
        }
        if (aVar == a.CLEAR_USER_INFO) {
            i.bW();
        } else if (aVar == a.CLEAR_ALL_INFO) {
            i.aq(context);
        }
    }

    private static void a(Context context, a aVar, boolean z, boolean z2) {
        b.bj(context);
        com.freshchat.consumer.sdk.service.d.d.bl(context);
        com.freshchat.consumer.sdk.b.e i = com.freshchat.consumer.sdk.b.e.i(context);
        String bP = i.bP();
        String bj = i.bj();
        boolean bl = i.bl();
        FreshchatConfig aG = y.aG(context);
        a(context, aVar);
        b(context, aVar);
        if (z2) {
            try {
                y.a(aG);
                Freshchat.getInstance(context).init(aG);
            } catch (InvalidDomainException e) {
                i.e(context, e.getMessage());
            } catch (IllegalArgumentException e2) {
                String str = aVar == a.CLEAR_USER_INFO ? "resetUser" : "clear";
                ai.e("FRESHCHAT_WARNING", "Freshchat SDK has not been initialized and " + str + " has been called", e2);
            } catch (Exception e3) {
                ai.e("FRESHCHAT_WARNING", "Unexpected Exception while processing resetUser", e3);
            }
        }
        i.G(bP);
        if (z && bl && as.a(bj)) {
            b.r(context, bj);
        }
    }

    public static void a(Context context, java.util.List<Message> list) {
        if (!(context == null || k.isEmpty(list))) {
            for (Message message : list) {
                if (!c.f(context, message.getAlias())) {
                    b.a(context, message);
                }
            }
        }
    }

    public static void a(Context context, boolean z, boolean z2) {
        a(context, a.CLEAR_USER_INFO, z, z2);
    }

    private static void a(ComponentInfo[] componentInfoArr, SparseBooleanArray sparseBooleanArray) {
        int az;
        for (ComponentInfo componentInfo : componentInfoArr) {
            String str = componentInfo.name;
            if (hJ.contains(str) && (az = az(str)) != -1) {
                sparseBooleanArray.put(az, true);
            }
        }
    }

    public static String aA(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return b(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    public static int aB(String str) {
        if (as.isEmpty(str)) {
            return new Random().nextInt();
        }
        int i = 7;
        for (char c : str.toCharArray()) {
            i += c;
        }
        return i;
    }

    public static void aH(Context context) {
        PackageInfo packageInfo;
        if (!aw.fc()) {
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            int i = 0;
            for (int i2 = 0; i2 < hJ.size(); i2++) {
                sparseBooleanArray.append(i2, false);
            }
            try {
                String ab = g.ab(context);
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (packageInfo = packageManager.getPackageInfo(ab, 15)) != null) {
                    ActivityInfo[] activityInfoArr = packageInfo.activities;
                    if (activityInfoArr != null) {
                        a(activityInfoArr, sparseBooleanArray);
                        ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                        if (activityInfoArr2 != null) {
                            a(activityInfoArr2, sparseBooleanArray);
                            ServiceInfo[] serviceInfoArr = packageInfo.services;
                            if (serviceInfoArr != null) {
                                a(serviceInfoArr, sparseBooleanArray);
                                ProviderInfo[] providerInfoArr = packageInfo.providers;
                                if (providerInfoArr != null) {
                                    a(providerInfoArr, sparseBooleanArray);
                                    while (true) {
                                        java.util.List<String> list = hJ;
                                        if (i >= list.size()) {
                                            return;
                                        }
                                        if (sparseBooleanArray.get(i)) {
                                            i++;
                                        } else {
                                            throw new FreshchatComponentNotFoundException(list.get(i));
                                        }
                                    }
                                } else {
                                    throw new FreshchatComponentNotFoundException("Providers");
                                }
                            } else {
                                throw new FreshchatComponentNotFoundException("Services");
                            }
                        } else {
                            throw new FreshchatComponentNotFoundException("Receivers");
                        }
                    } else {
                        throw new FreshchatComponentNotFoundException("Activities");
                    }
                }
            } catch (FreshchatComponentNotFoundException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static Intent aI(Context context) {
        if (context != null) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage != null) {
                String className = launchIntentForPackage.getComponent().getClassName();
                ai.d("FRESHCHAT", "Detected launch intent " + launchIntentForPackage + " of class " + className);
            }
            return launchIntentForPackage;
        }
        throw new IllegalArgumentException("getLaunchIntentForApp() requires a valid context");
    }

    public static void aK(Context context) {
        a(context, a.CLEAR_ALL_INFO, false, false);
    }

    public static boolean aL(Context context) {
        return am.aU(context) && "mounted".equals(Environment.getExternalStorageState());
    }

    public static void aM(Context context) {
        if (context != null) {
            ai.d("FRESHCHAT", "enableConnectivityChangeReceiver() called");
            ComponentName componentName = new ComponentName(context, FreshchatNetworkChangeReceiver.class);
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getComponentEnabledSetting(componentName) != 1) {
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            }
        }
    }

    public static void aN(Context context) {
        if (context != null) {
            ai.d("FRESHCHAT", "disableConnectivityChangeReceiver() called");
            ComponentName componentName = new ComponentName(context, FreshchatNetworkChangeReceiver.class);
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        }
    }

    private static int az(String str) {
        int i = 0;
        while (true) {
            java.util.List<String> list = hJ;
            if (i >= list.size()) {
                return -1;
            }
            if (list.get(i).equalsIgnoreCase(str)) {
                return i;
            }
            i++;
        }
    }

    private static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private static void b(Context context, a aVar) {
        com.freshchat.consumer.sdk.c.d dVar = new com.freshchat.consumer.sdk.c.d(context);
        if (aVar == a.CLEAR_USER_INFO) {
            dVar.bW();
        } else if (aVar == a.CLEAR_ALL_INFO) {
            dVar.cx();
        }
    }

    public static void c(Context context, com.freshchat.consumer.sdk.service.a.a aVar) {
        if (context != null && aVar != null) {
            c.b(context, aVar);
            if (c.s(context)) {
                e.Y(context);
                aM(context);
            }
        }
    }

    public static void c(Context context, boolean z) {
        if (z) {
            com.freshchat.consumer.sdk.j.b.c.fD();
            if (c.s(context)) {
                b.M(context);
            }
            o.by(context);
        }
    }

    public static void e(Context context, long j) {
        a(context, j, true, false, false);
    }

    public static void f(Context context, long j) {
        a(context, j, true, true, false);
    }

    public static void fF() {
        try {
            if (aw.fG()) {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, null, null);
                HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void g(Context context, long j) {
        a(context, j, true, false, true);
    }

    public static void h(Context context, long j) {
        a(context, j, true, true, true);
    }

    public static void k(Context context, String str) {
        try {
            context.startActivity(new Intent(context, Class.forName(str)));
        } catch (ClassNotFoundException e) {
            q.a(e);
        }
    }

    public static void l(Context context, String str) {
        if (context != null && !as.isEmpty(str)) {
            new com.freshchat.consumer.sdk.c.a(context).T(str);
            if (!c.s(context)) {
                e.aa(context);
                aN(context);
            }
        }
    }
}
