package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.android.gms.cloudmessaging.zza;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: m22  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final class m22 extends fl2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o12 f2311a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m22(o12 o12, Looper looper) {
        super(looper);
        this.f2311a = o12;
    }

    public final void handleMessage(Message message) {
        o12 o12 = this.f2311a;
        Objects.requireNonNull(o12);
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zza.a());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zza) {
                        o12.g = (zza) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        o12.f = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    String stringExtra = intent2.getStringExtra("registration_id");
                    if (stringExtra == null) {
                        stringExtra = intent2.getStringExtra("unregistered");
                    }
                    if (stringExtra == null) {
                        String stringExtra2 = intent2.getStringExtra("error");
                        if (stringExtra2 == null) {
                            String.valueOf(intent2.getExtras()).length();
                            return;
                        }
                        if (Log.isLoggable("Rpc", 3)) {
                            if (stringExtra2.length() != 0) {
                                "Received InstanceID error ".concat(stringExtra2);
                            } else {
                                new String("Received InstanceID error ");
                            }
                        }
                        if (stringExtra2.startsWith("|")) {
                            String[] split = stringExtra2.split("\\|");
                            if (split.length > 2 && "ID".equals(split[1])) {
                                String str = split[2];
                                String str2 = split[3];
                                if (str2.startsWith(ProductDiscountsObject.KEY_DELIMITER)) {
                                    str2 = str2.substring(1);
                                }
                                o12.b(str, intent2.putExtra("error", str2).getExtras());
                            } else if (stringExtra2.length() != 0) {
                                "Unexpected structured response ".concat(stringExtra2);
                            } else {
                                new String("Unexpected structured response ");
                            }
                        } else {
                            synchronized (o12.f2632a) {
                                int i = 0;
                                while (true) {
                                    u2<String, zi4<Bundle>> u2Var = o12.f2632a;
                                    if (i < u2Var.h) {
                                        o12.b(u2Var.h(i), intent2.getExtras());
                                        i++;
                                    }
                                }
                            }
                        }
                    } else {
                        Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                        if (matcher.matches()) {
                            String group = matcher.group(1);
                            String group2 = matcher.group(2);
                            if (group != null) {
                                Bundle extras = intent2.getExtras();
                                extras.putString("registration_id", group2);
                                o12.b(group, extras);
                            }
                        } else if (!Log.isLoggable("Rpc", 3)) {
                        } else {
                            if (stringExtra.length() != 0) {
                                "Unexpected response string: ".concat(stringExtra);
                            } else {
                                new String("Unexpected response string: ");
                            }
                        }
                    }
                } else if (Log.isLoggable("Rpc", 3)) {
                    String valueOf = String.valueOf(action);
                    if (valueOf.length() != 0) {
                        "Unexpected response action: ".concat(valueOf);
                    } else {
                        new String("Unexpected response action: ");
                    }
                }
            }
        }
    }
}
