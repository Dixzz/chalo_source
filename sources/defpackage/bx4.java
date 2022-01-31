package defpackage;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.play.core.assetpacks.ExtractionForegroundService;

/* renamed from: bx4  reason: default package */
public abstract class bx4 extends pw4 implements IInterface {
    public bx4() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionService");
    }

    @Override // defpackage.pw4
    public final boolean C(int i, Parcel parcel) throws RemoteException {
        dx4 dx4;
        ComponentName componentName = null;
        dx4 dx42 = null;
        if (i == 2) {
            Bundle bundle = (Bundle) qw4.a(parcel, Bundle.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                dx4 = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
                dx4 = queryLocalInterface instanceof dx4 ? (dx4) queryLocalInterface : new cx4(readStrongBinder);
            }
            gs4 gs4 = (gs4) this;
            gs4.f.b(3, "updateServiceState AIDL call", new Object[0]);
            if (!zv4.a(gs4.g) || !zv4.b(gs4.g)) {
                dx4.A2(new Bundle());
            } else {
                synchronized (gs4) {
                    Intent intent = new Intent(gs4.g, ExtractionForegroundService.class);
                    int i2 = bundle.getInt("action_type");
                    intent.putExtra("action_type", i2);
                    if (i2 == 1) {
                        intent.putExtra("notification_channel_name", bundle.getString("notification_channel_name"));
                        intent.putExtra("notification_title", bundle.getString("notification_title"));
                        intent.putExtra("notification_subtext", bundle.getString("notification_subtext"));
                        intent.putExtra("notification_timeout", bundle.getLong("notification_timeout"));
                        Parcelable parcelable = bundle.getParcelable("notification_on_click_intent");
                        if (parcelable instanceof PendingIntent) {
                            intent.putExtra("notification_on_click_intent", parcelable);
                        }
                        intent.putExtra("notification_color", bundle.getInt("notification_color"));
                    }
                    try {
                        componentName = Build.VERSION.SDK_INT >= 26 ? gs4.g.startForegroundService(intent) : gs4.g.startService(intent);
                    } catch (IllegalStateException | SecurityException e) {
                        gs4.f.a(e, "Failed starting installation service.", new Object[0]);
                    }
                    if (componentName == null) {
                        gs4.f.b(6, "Failed starting installation service.", new Object[0]);
                    }
                }
                dx4.V1(new Bundle(), new Bundle());
            }
        } else if (i != 3) {
            return false;
        } else {
            Bundle bundle2 = (Bundle) qw4.a(parcel, Bundle.CREATOR);
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            if (readStrongBinder2 != null) {
                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
                dx42 = queryLocalInterface2 instanceof dx4 ? (dx4) queryLocalInterface2 : new cx4(readStrongBinder2);
            }
            gs4 gs42 = (gs4) this;
            gs42.f.b(3, "clearAssetPackStorage AIDL call", new Object[0]);
            if (!zv4.a(gs42.g) || !zv4.b(gs42.g)) {
                dx42.A2(new Bundle());
            } else {
                bs4.h(gs42.h.g());
                dx42.Z1(new Bundle());
            }
        }
        return true;
    }
}
