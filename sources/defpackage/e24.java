package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzae;
import defpackage.ic2;

/* renamed from: e24  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public abstract class e24 extends mq3 implements f24 {
    public e24() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static f24 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (queryLocalInterface instanceof f24) {
            return (f24) queryLocalInterface;
        }
        return new h24(iBinder);
    }

    @Override // defpackage.mq3
    public final boolean C(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        g24 g24;
        boolean z = false;
        g24 g242 = null;
        g24 g243 = null;
        g24 g244 = null;
        ko3 ko3 = null;
        ko3 ko32 = null;
        ko3 ko33 = null;
        g24 g245 = null;
        g24 g246 = null;
        g24 g247 = null;
        g24 g248 = null;
        g24 g249 = null;
        g24 g2410 = null;
        lo3 lo3 = null;
        g24 g2411 = null;
        g24 g2412 = null;
        g24 g2413 = null;
        g24 g2414 = null;
        g24 g2415 = null;
        switch (i) {
            case 1:
                initialize(ic2.a.F(parcel.readStrongBinder()), (zzae) hp3.a(parcel, zzae.CREATOR), parcel.readLong());
                break;
            case 2:
                logEvent(parcel.readString(), parcel.readString(), (Bundle) hp3.a(parcel, Bundle.CREATOR), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readLong());
                break;
            case 3:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Bundle bundle = (Bundle) hp3.a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface instanceof g24) {
                        g24 = (g24) queryLocalInterface;
                    } else {
                        g24 = new i24(readStrongBinder);
                    }
                    g242 = g24;
                }
                logEventAndBundle(readString, readString2, bundle, g242, parcel.readLong());
                break;
            case 4:
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                ic2 F = ic2.a.F(parcel.readStrongBinder());
                ClassLoader classLoader = hp3.f1408a;
                setUserProperty(readString3, readString4, F, parcel.readInt() != 0, parcel.readLong());
                break;
            case 5:
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                ClassLoader classLoader2 = hp3.f1408a;
                if (parcel.readInt() != 0) {
                    z = true;
                }
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface2 instanceof g24) {
                        g2415 = (g24) queryLocalInterface2;
                    } else {
                        g2415 = new i24(readStrongBinder2);
                    }
                }
                getUserProperties(readString5, readString6, z, g2415);
                break;
            case 6:
                String readString7 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface3 instanceof g24) {
                        g2414 = (g24) queryLocalInterface3;
                    } else {
                        g2414 = new i24(readStrongBinder3);
                    }
                }
                getMaxUserProperties(readString7, g2414);
                break;
            case 7:
                setUserId(parcel.readString(), parcel.readLong());
                break;
            case 8:
                setConditionalUserProperty((Bundle) hp3.a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 9:
                clearConditionalUserProperty(parcel.readString(), parcel.readString(), (Bundle) hp3.a(parcel, Bundle.CREATOR));
                break;
            case 10:
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface4 instanceof g24) {
                        g2413 = (g24) queryLocalInterface4;
                    } else {
                        g2413 = new i24(readStrongBinder4);
                    }
                }
                getConditionalUserProperties(readString8, readString9, g2413);
                break;
            case 11:
                ClassLoader classLoader3 = hp3.f1408a;
                if (parcel.readInt() != 0) {
                    z = true;
                }
                setMeasurementEnabled(z, parcel.readLong());
                break;
            case 12:
                resetAnalyticsData(parcel.readLong());
                break;
            case 13:
                setMinimumSessionDuration(parcel.readLong());
                break;
            case 14:
                setSessionTimeoutDuration(parcel.readLong());
                break;
            case 15:
                setCurrentScreen(ic2.a.F(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readLong());
                break;
            case 16:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface5 instanceof g24) {
                        g2412 = (g24) queryLocalInterface5;
                    } else {
                        g2412 = new i24(readStrongBinder5);
                    }
                }
                getCurrentScreenName(g2412);
                break;
            case 17:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface6 instanceof g24) {
                        g2411 = (g24) queryLocalInterface6;
                    } else {
                        g2411 = new i24(readStrongBinder6);
                    }
                }
                getCurrentScreenClass(g2411);
                break;
            case 18:
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    if (queryLocalInterface7 instanceof lo3) {
                        lo3 = (lo3) queryLocalInterface7;
                    } else {
                        lo3 = new no3(readStrongBinder7);
                    }
                }
                setInstanceIdProvider(lo3);
                break;
            case 19:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface8 instanceof g24) {
                        g2410 = (g24) queryLocalInterface8;
                    } else {
                        g2410 = new i24(readStrongBinder8);
                    }
                }
                getCachedAppInstanceId(g2410);
                break;
            case 20:
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface9 instanceof g24) {
                        g249 = (g24) queryLocalInterface9;
                    } else {
                        g249 = new i24(readStrongBinder9);
                    }
                }
                getAppInstanceId(g249);
                break;
            case 21:
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface10 instanceof g24) {
                        g248 = (g24) queryLocalInterface10;
                    } else {
                        g248 = new i24(readStrongBinder10);
                    }
                }
                getGmpAppId(g248);
                break;
            case 22:
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface11 instanceof g24) {
                        g247 = (g24) queryLocalInterface11;
                    } else {
                        g247 = new i24(readStrongBinder11);
                    }
                }
                generateEventId(g247);
                break;
            case 23:
                beginAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 24:
                endAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 25:
                onActivityStarted(ic2.a.F(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 26:
                onActivityStopped(ic2.a.F(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 27:
                onActivityCreated(ic2.a.F(parcel.readStrongBinder()), (Bundle) hp3.a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 28:
                onActivityDestroyed(ic2.a.F(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 29:
                onActivityPaused(ic2.a.F(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 30:
                onActivityResumed(ic2.a.F(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 31:
                ic2 F2 = ic2.a.F(parcel.readStrongBinder());
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface12 instanceof g24) {
                        g246 = (g24) queryLocalInterface12;
                    } else {
                        g246 = new i24(readStrongBinder12);
                    }
                }
                onActivitySaveInstanceState(F2, g246, parcel.readLong());
                break;
            case 32:
                Bundle bundle2 = (Bundle) hp3.a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface13 instanceof g24) {
                        g245 = (g24) queryLocalInterface13;
                    } else {
                        g245 = new i24(readStrongBinder13);
                    }
                }
                performAction(bundle2, g245, parcel.readLong());
                break;
            case 33:
                logHealthData(parcel.readInt(), parcel.readString(), ic2.a.F(parcel.readStrongBinder()), ic2.a.F(parcel.readStrongBinder()), ic2.a.F(parcel.readStrongBinder()));
                break;
            case 34:
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface14 instanceof ko3) {
                        ko33 = (ko3) queryLocalInterface14;
                    } else {
                        ko33 = new mo3(readStrongBinder14);
                    }
                }
                setEventInterceptor(ko33);
                break;
            case 35:
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface15 instanceof ko3) {
                        ko32 = (ko3) queryLocalInterface15;
                    } else {
                        ko32 = new mo3(readStrongBinder15);
                    }
                }
                registerOnMeasurementEventListener(ko32);
                break;
            case 36:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface16 instanceof ko3) {
                        ko3 = (ko3) queryLocalInterface16;
                    } else {
                        ko3 = new mo3(readStrongBinder16);
                    }
                }
                unregisterOnMeasurementEventListener(ko3);
                break;
            case 37:
                initForTests(parcel.readHashMap(hp3.f1408a));
                break;
            case 38:
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface17 instanceof g24) {
                        g244 = (g24) queryLocalInterface17;
                    } else {
                        g244 = new i24(readStrongBinder17);
                    }
                }
                getTestFlag(g244, parcel.readInt());
                break;
            case 39:
                ClassLoader classLoader4 = hp3.f1408a;
                if (parcel.readInt() != 0) {
                    z = true;
                }
                setDataCollectionEnabled(z);
                break;
            case 40:
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface18 instanceof g24) {
                        g243 = (g24) queryLocalInterface18;
                    } else {
                        g243 = new i24(readStrongBinder18);
                    }
                }
                isDataCollectionEnabled(g243);
                break;
            case 41:
            default:
                return false;
            case 42:
                setDefaultEventParameters((Bundle) hp3.a(parcel, Bundle.CREATOR));
                break;
            case 43:
                clearMeasurementEnabled(parcel.readLong());
                break;
            case 44:
                setConsent((Bundle) hp3.a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 45:
                setConsentThirdParty((Bundle) hp3.a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
