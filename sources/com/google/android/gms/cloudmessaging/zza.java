package com.google.android.gms.cloudmessaging;

import android.os.Build;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public class zza implements Parcelable {
    public static final Parcelable.Creator<zza> CREATOR = new q12();
    public Messenger f;

    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
    public static final class a extends ClassLoader {
        @Override // java.lang.ClassLoader
        public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if ("com.google.android.gms.iid.MessengerCompat".equals(str)) {
                return (Log.isLoggable("CloudMessengerCompat", 3) || Build.VERSION.SDK_INT != 23 || Log.isLoggable("CloudMessengerCompat", 3)) ? zza.class : zza.class;
            }
            return super.loadClass(str, z);
        }
    }

    public zza(IBinder iBinder) {
        this.f = new Messenger(iBinder);
    }

    public final IBinder a() {
        Messenger messenger = this.f;
        Objects.requireNonNull(messenger);
        return messenger.getBinder();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((zza) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return a().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.f;
        Objects.requireNonNull(messenger);
        parcel.writeStrongBinder(messenger.getBinder());
    }
}
