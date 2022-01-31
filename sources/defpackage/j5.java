package defpackage;

import android.app.Notification;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* renamed from: j5  reason: default package */
/* compiled from: NotificationCompatBuilder */
public class j5 implements b5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1878a;
    public final Notification.Builder b;
    public final f5 c;
    public final List<Bundle> d = new ArrayList();
    public final Bundle e = new Bundle();

    public j5(f5 f5Var) {
        List<String> list;
        Notification.Action.Builder builder;
        Bundle bundle;
        int i = Build.VERSION.SDK_INT;
        this.c = f5Var;
        this.f1878a = f5Var.f1091a;
        if (i >= 26) {
            this.b = new Notification.Builder(f5Var.f1091a, f5Var.t);
        } else {
            this.b = new Notification.Builder(f5Var.f1091a);
        }
        Notification notification = f5Var.v;
        this.b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(f5Var.e).setContentText(f5Var.f).setContentInfo(null).setContentIntent(f5Var.g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) == 0 ? false : true).setLargeIcon(f5Var.h).setNumber(f5Var.i).setProgress(0, 0, false);
        this.b.setSubText(f5Var.m).setUsesChronometer(false).setPriority(f5Var.j);
        Iterator<c5> it = f5Var.b.iterator();
        while (it.hasNext()) {
            c5 next = it.next();
            IconCompat a2 = next.a();
            if (i >= 23) {
                builder = new Notification.Action.Builder(a2 != null ? a2.f() : null, next.j, next.k);
            } else {
                builder = new Notification.Action.Builder(a2 != null ? a2.c() : 0, next.j, next.k);
            }
            n5[] n5VarArr = next.c;
            if (n5VarArr != null) {
                for (RemoteInput remoteInput : n5.a(n5VarArr)) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            if (next.f519a != null) {
                bundle = new Bundle(next.f519a);
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", next.e);
            if (i >= 24) {
                builder.setAllowGeneratedReplies(next.e);
            }
            bundle.putInt("android.support.action.semanticAction", next.g);
            if (i >= 28) {
                builder.setSemanticAction(next.g);
            }
            if (i >= 29) {
                builder.setContextual(next.h);
            }
            bundle.putBoolean("android.support.action.showsUserInterface", next.f);
            builder.addExtras(bundle);
            this.b.addAction(builder.build());
        }
        Bundle bundle2 = f5Var.p;
        if (bundle2 != null) {
            this.e.putAll(bundle2);
        }
        this.b.setShowWhen(f5Var.k);
        this.b.setLocalOnly(f5Var.n).setGroup(null).setGroupSummary(false).setSortKey(null);
        this.b.setCategory(f5Var.o).setColor(f5Var.q).setVisibility(f5Var.r).setPublicVersion(f5Var.s).setSound(notification.sound, notification.audioAttributes);
        if (i < 28) {
            list = a(b(f5Var.c), f5Var.w);
        } else {
            list = f5Var.w;
        }
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                this.b.addPerson(str);
            }
        }
        if (f5Var.d.size() > 0) {
            Bundle bundle3 = f5Var.c().getBundle("android.car.EXTENSIONS");
            bundle3 = bundle3 == null ? new Bundle() : bundle3;
            Bundle bundle4 = new Bundle(bundle3);
            Bundle bundle5 = new Bundle();
            for (int i2 = 0; i2 < f5Var.d.size(); i2++) {
                bundle5.putBundle(Integer.toString(i2), k5.a(f5Var.d.get(i2)));
            }
            bundle3.putBundle("invisible_actions", bundle5);
            bundle4.putBundle("invisible_actions", bundle5);
            f5Var.c().putBundle("android.car.EXTENSIONS", bundle3);
            this.e.putBundle("android.car.EXTENSIONS", bundle4);
        }
        if (i >= 24) {
            this.b.setExtras(f5Var.p).setRemoteInputHistory(null);
        }
        if (i >= 26) {
            this.b.setBadgeIconType(0).setSettingsText(null).setShortcutId(null).setTimeoutAfter(0).setGroupAlertBehavior(0);
            if (!TextUtils.isEmpty(f5Var.t)) {
                this.b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i >= 28) {
            Iterator<m5> it2 = f5Var.c.iterator();
            while (it2.hasNext()) {
                Notification.Builder builder2 = this.b;
                Objects.requireNonNull(it2.next());
                builder2.addPerson(new Person.Builder().setName(null).setIcon(null).setUri(null).setKey(null).setBot(false).setImportant(false).build());
            }
        }
        if (i >= 29) {
            this.b.setAllowSystemGeneratedContextualActions(f5Var.u);
            this.b.setBubbleMetadata(null);
        }
    }

    public static List<String> a(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        p2 p2Var = new p2(list2.size() + list.size());
        p2Var.addAll(list);
        p2Var.addAll(list2);
        return new ArrayList(p2Var);
    }

    public static List<String> b(List<m5> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (m5 m5Var : list) {
            Objects.requireNonNull(m5Var);
            arrayList.add("");
        }
        return arrayList;
    }
}
