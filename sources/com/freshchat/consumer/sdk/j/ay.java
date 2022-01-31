package com.freshchat.consumer.sdk.j;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import androidx.appcompat.app.AlertController;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Message;
import defpackage.e0;
import java.util.List;

public class ay {
    public static final String TAG = "com.freshchat.consumer.sdk.j.ay";

    private static void a(Context context, boolean z) {
        e.i(context).putBoolean("XIAOMI_AUTOSTART_USER_NOTIFIED", z);
    }

    private static boolean b(Context context, List<Message> list) {
        boolean z = !e.i(context).getBoolean("XIAOMI_AUTOSTART_USER_NOTIFIED");
        if (z) {
            z = bf(context);
        }
        if (!z || list == null || list.size() > 5) {
            return z;
        }
        int i = 0;
        while (i < list.size() && i < 5) {
            if (list.get(i).isUserMessage()) {
                return false;
            }
            i++;
        }
        return z;
    }

    /* access modifiers changed from: private */
    public static void be(Context context) {
        try {
            context.startActivity(fd());
        } catch (Exception e) {
            String str = TAG;
            StringBuilder i0 = hj1.i0("Failed to launch AutoStart Screen - ");
            i0.append(e.getMessage());
            ai.e(str, i0.toString());
        }
    }

    private static boolean bf(Context context) {
        List<ResolveInfo> list;
        try {
            list = context.getPackageManager().queryIntentActivities(fd(), 65536);
        } catch (Exception e) {
            String str = TAG;
            StringBuilder i0 = hj1.i0("Failed to launch AutoStart Screen - ");
            i0.append(e.getMessage());
            ai.e(str, i0.toString());
            list = null;
        }
        return k.a(list);
    }

    public static void c(final Context context, List<Message> list) {
        if (context.getResources().getBoolean(R.bool.freshchat_xiaomi_autostart_prompt_enabled) && p.ew() && b(context, list)) {
            String string = context.getString(R.string.freshchat_xiaomi_auto_start_prompt_message);
            if (as.a(string)) {
                e0.a m = i.m(context);
                m.f908a.f = string;
                m.b(R.string.freshchat_xiaomi_auto_start_prompt_positive, new DialogInterface.OnClickListener() {
                    /* class com.freshchat.consumer.sdk.j.ay.AnonymousClass1 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        ay.be(context);
                        dialogInterface.dismiss();
                    }
                });
                int i = R.string.freshchat_xiaomi_auto_start_prompt_negative;
                AlertController.b bVar = m.f908a;
                bVar.i = bVar.f194a.getText(i);
                m.f908a.j = null;
                m.a().show();
            }
            a(context, true);
        }
    }

    private static Intent fd() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
        return intent;
    }
}
