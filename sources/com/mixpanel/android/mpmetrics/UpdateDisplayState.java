package com.mixpanel.android.mpmetrics;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(16)
public class UpdateDisplayState implements Parcelable {
    public static final Parcelable.Creator<UpdateDisplayState> CREATOR = new a();
    public static final ReentrantLock i = new ReentrantLock();
    public static long j = -1;
    public static UpdateDisplayState k = null;
    public static int l = 0;
    public static int m = -1;
    public final String f;
    public final String g;
    public final DisplayState h;

    public static abstract class DisplayState implements Parcelable {
        public static final Parcelable.Creator<DisplayState> CREATOR = new a();

        public class a implements Parcelable.Creator<DisplayState> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public DisplayState createFromParcel(Parcel parcel) {
                Bundle bundle = new Bundle(DisplayState.class.getClassLoader());
                bundle.readFromParcel(parcel);
                String string = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_TYPE_KEY");
                Bundle bundle2 = bundle.getBundle("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_IMPL_KEY");
                if ("InAppNotificationState".equals(string)) {
                    return new InAppNotificationState(bundle2, (a) null);
                }
                throw new RuntimeException(hj1.S("Unrecognized display state type ", string));
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public DisplayState[] newArray(int i) {
                return new DisplayState[i];
            }
        }

        public DisplayState() {
        }

        public DisplayState(a aVar) {
        }

        public static final class InAppNotificationState extends DisplayState {
            public static final Parcelable.Creator<InAppNotificationState> CREATOR = new a();
            public final InAppNotification f;
            public final int g;

            public class a implements Parcelable.Creator<InAppNotificationState> {
                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public InAppNotificationState createFromParcel(Parcel parcel) {
                    Bundle bundle = new Bundle(InAppNotificationState.class.getClassLoader());
                    bundle.readFromParcel(parcel);
                    return new InAppNotificationState(bundle, (a) null);
                }

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public InAppNotificationState[] newArray(int i) {
                    return new InAppNotificationState[i];
                }
            }

            public InAppNotificationState(InAppNotification inAppNotification, int i) {
                super(null);
                this.f = inAppNotification;
                this.g = i;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.INAPP_KEY", this.f);
                bundle.putInt("com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.HIGHLIGHT_KEY", this.g);
                parcel.writeBundle(bundle);
            }

            public InAppNotificationState(Bundle bundle, a aVar) {
                super(null);
                this.f = (InAppNotification) bundle.getParcelable("com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.INAPP_KEY");
                this.g = bundle.getInt("com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.HIGHLIGHT_KEY");
            }
        }
    }

    public class a implements Parcelable.Creator<UpdateDisplayState> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public UpdateDisplayState createFromParcel(Parcel parcel) {
            Bundle bundle = new Bundle(UpdateDisplayState.class.getClassLoader());
            bundle.readFromParcel(parcel);
            return new UpdateDisplayState(bundle, null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public UpdateDisplayState[] newArray(int i) {
            return new UpdateDisplayState[i];
        }
    }

    public UpdateDisplayState(DisplayState displayState, String str, String str2) {
        this.f = str;
        this.g = str2;
        this.h = displayState;
    }

    public static UpdateDisplayState a(int i2) {
        ReentrantLock reentrantLock = i;
        reentrantLock.lock();
        try {
            int i3 = m;
            if (i3 > 0 && i3 != i2) {
                reentrantLock.unlock();
                return null;
            } else if (k == null) {
                reentrantLock.unlock();
                return null;
            } else {
                j = System.currentTimeMillis();
                m = i2;
                UpdateDisplayState updateDisplayState = k;
                reentrantLock.unlock();
                return updateDisplayState;
            }
        } catch (Throwable th) {
            i.unlock();
            throw th;
        }
    }

    public static boolean b() {
        if (i.isHeldByCurrentThread()) {
            long currentTimeMillis = System.currentTimeMillis() - j;
            if (l > 0 && currentTimeMillis > 43200000) {
                k = null;
            }
            return k != null;
        }
        throw new AssertionError();
    }

    public static void c(int i2) {
        ReentrantLock reentrantLock = i;
        reentrantLock.lock();
        try {
            if (i2 == m) {
                m = -1;
                k = null;
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            i.unlock();
            throw th;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY", this.f);
        bundle.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY", this.g);
        bundle.putParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY", this.h);
        parcel.writeBundle(bundle);
    }

    public UpdateDisplayState(Bundle bundle, a aVar) {
        this.f = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY");
        this.g = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY");
        this.h = (DisplayState) bundle.getParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY");
    }
}
