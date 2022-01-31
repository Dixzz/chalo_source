package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.p000firebaseauthapi.zzlc;
import com.google.android.gms.internal.p000firebaseauthapi.zzle;
import com.google.android.gms.internal.p000firebaseauthapi.zzlg;
import com.google.android.gms.internal.p000firebaseauthapi.zzli;
import com.google.android.gms.internal.p000firebaseauthapi.zzlk;
import com.google.android.gms.internal.p000firebaseauthapi.zzlm;
import com.google.android.gms.internal.p000firebaseauthapi.zzlo;
import com.google.android.gms.internal.p000firebaseauthapi.zzlq;
import com.google.android.gms.internal.p000firebaseauthapi.zzls;
import com.google.android.gms.internal.p000firebaseauthapi.zzlu;
import com.google.android.gms.internal.p000firebaseauthapi.zzlw;
import com.google.android.gms.internal.p000firebaseauthapi.zzly;
import com.google.android.gms.internal.p000firebaseauthapi.zzma;
import com.google.android.gms.internal.p000firebaseauthapi.zzmc;
import com.google.android.gms.internal.p000firebaseauthapi.zzme;
import com.google.android.gms.internal.p000firebaseauthapi.zzmg;
import com.google.android.gms.internal.p000firebaseauthapi.zzmi;
import com.google.android.gms.internal.p000firebaseauthapi.zzmk;
import com.google.android.gms.internal.p000firebaseauthapi.zzmm;
import com.google.android.gms.internal.p000firebaseauthapi.zzmo;
import com.google.android.gms.internal.p000firebaseauthapi.zzmq;
import com.google.android.gms.internal.p000firebaseauthapi.zzms;
import com.google.android.gms.internal.p000firebaseauthapi.zzmu;
import com.google.android.gms.internal.p000firebaseauthapi.zzmw;
import com.google.android.gms.internal.p000firebaseauthapi.zzmy;
import com.google.android.gms.internal.p000firebaseauthapi.zzna;
import com.google.android.gms.internal.p000firebaseauthapi.zznc;
import com.google.android.gms.internal.p000firebaseauthapi.zzne;
import com.google.android.gms.internal.p000firebaseauthapi.zzng;
import com.google.android.gms.internal.p000firebaseauthapi.zzni;
import com.google.android.gms.internal.p000firebaseauthapi.zznk;
import com.google.android.gms.internal.p000firebaseauthapi.zznm;

/* renamed from: g53  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class g53 extends mo2 implements h53 {
    public g53() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    @Override // defpackage.mo2
    public final boolean C(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        e53 e53 = null;
        switch (i) {
            case 101:
                zzlu zzlu = (zzlu) mp2.a(parcel, zzlu.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof e53) {
                        e53 = (e53) queryLocalInterface;
                    } else {
                        e53 = new c53(readStrongBinder);
                    }
                }
                ((x43) this).X0(zzlu, e53);
                break;
            case 102:
                zzms zzms = (zzms) mp2.a(parcel, zzms.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof e53) {
                        e53 = (e53) queryLocalInterface2;
                    } else {
                        e53 = new c53(readStrongBinder2);
                    }
                }
                ((x43) this).G3(zzms, e53);
                break;
            case 103:
                zzmq zzmq = (zzmq) mp2.a(parcel, zzmq.CREATOR);
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface3 instanceof e53) {
                        e53 = (e53) queryLocalInterface3;
                    } else {
                        e53 = new c53(readStrongBinder3);
                    }
                }
                ((x43) this).E2(zzmq, e53);
                break;
            case 104:
                zznk zznk = (zznk) mp2.a(parcel, zznk.CREATOR);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface4 instanceof e53) {
                        e53 = (e53) queryLocalInterface4;
                    } else {
                        e53 = new c53(readStrongBinder4);
                    }
                }
                ((x43) this).W2(zznk, e53);
                break;
            case 105:
                zzle zzle = (zzle) mp2.a(parcel, zzle.CREATOR);
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface5 instanceof e53) {
                        e53 = (e53) queryLocalInterface5;
                    } else {
                        e53 = new c53(readStrongBinder5);
                    }
                }
                ((x43) this).u2(zzle, e53);
                break;
            case 106:
                zzlg zzlg = (zzlg) mp2.a(parcel, zzlg.CREATOR);
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface6 instanceof e53) {
                        e53 = (e53) queryLocalInterface6;
                    } else {
                        e53 = new c53(readStrongBinder6);
                    }
                }
                ((x43) this).O(zzlg, e53);
                break;
            case 107:
                zzlm zzlm = (zzlm) mp2.a(parcel, zzlm.CREATOR);
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface7 instanceof e53) {
                        e53 = (e53) queryLocalInterface7;
                    } else {
                        e53 = new c53(readStrongBinder7);
                    }
                }
                ((x43) this).y3(zzlm, e53);
                break;
            case 108:
                zzmu zzmu = (zzmu) mp2.a(parcel, zzmu.CREATOR);
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface8 instanceof e53) {
                        e53 = (e53) queryLocalInterface8;
                    } else {
                        e53 = new c53(readStrongBinder8);
                    }
                }
                ((x43) this).p3(zzmu, e53);
                break;
            case 109:
                zzlw zzlw = (zzlw) mp2.a(parcel, zzlw.CREATOR);
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface9 instanceof e53) {
                        e53 = (e53) queryLocalInterface9;
                    } else {
                        e53 = new c53(readStrongBinder9);
                    }
                }
                ((x43) this).i2(zzlw, e53);
                break;
            case 110:
            case 118:
            case 125:
            default:
                return false;
            case 111:
                zzly zzly = (zzly) mp2.a(parcel, zzly.CREATOR);
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface10 instanceof e53) {
                        e53 = (e53) queryLocalInterface10;
                    } else {
                        e53 = new c53(readStrongBinder10);
                    }
                }
                ((x43) this).z3(zzly, e53);
                break;
            case 112:
                zzma zzma = (zzma) mp2.a(parcel, zzma.CREATOR);
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface11 instanceof e53) {
                        e53 = (e53) queryLocalInterface11;
                    } else {
                        e53 = new c53(readStrongBinder11);
                    }
                }
                ((x43) this).K1(zzma, e53);
                break;
            case 113:
                zzng zzng = (zzng) mp2.a(parcel, zzng.CREATOR);
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface12 instanceof e53) {
                        e53 = (e53) queryLocalInterface12;
                    } else {
                        e53 = new c53(readStrongBinder12);
                    }
                }
                ((x43) this).F0(zzng, e53);
                break;
            case 114:
                zzni zzni = (zzni) mp2.a(parcel, zzni.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface13 instanceof e53) {
                        e53 = (e53) queryLocalInterface13;
                    } else {
                        e53 = new c53(readStrongBinder13);
                    }
                }
                ((x43) this).X1(zzni, e53);
                break;
            case 115:
                zzme zzme = (zzme) mp2.a(parcel, zzme.CREATOR);
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface14 instanceof e53) {
                        e53 = (e53) queryLocalInterface14;
                    } else {
                        e53 = new c53(readStrongBinder14);
                    }
                }
                ((x43) this).I1(zzme, e53);
                break;
            case 116:
                zzmo zzmo = (zzmo) mp2.a(parcel, zzmo.CREATOR);
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface15 instanceof e53) {
                        e53 = (e53) queryLocalInterface15;
                    } else {
                        e53 = new c53(readStrongBinder15);
                    }
                }
                ((x43) this).o3(zzmo, e53);
                break;
            case 117:
                zzlo zzlo = (zzlo) mp2.a(parcel, zzlo.CREATOR);
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface16 instanceof e53) {
                        e53 = (e53) queryLocalInterface16;
                    } else {
                        e53 = new c53(readStrongBinder16);
                    }
                }
                ((x43) this).M0(zzlo, e53);
                break;
            case 119:
                zzli zzli = (zzli) mp2.a(parcel, zzli.CREATOR);
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface17 instanceof e53) {
                        e53 = (e53) queryLocalInterface17;
                    } else {
                        e53 = new c53(readStrongBinder17);
                    }
                }
                ((x43) this).Y1(zzli, e53);
                break;
            case 120:
                zzlc zzlc = (zzlc) mp2.a(parcel, zzlc.CREATOR);
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface18 instanceof e53) {
                        e53 = (e53) queryLocalInterface18;
                    } else {
                        e53 = new c53(readStrongBinder18);
                    }
                }
                ((x43) this).i3(zzlc, e53);
                break;
            case 121:
                zzlk zzlk = (zzlk) mp2.a(parcel, zzlk.CREATOR);
                IBinder readStrongBinder19 = parcel.readStrongBinder();
                if (readStrongBinder19 != null) {
                    IInterface queryLocalInterface19 = readStrongBinder19.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface19 instanceof e53) {
                        e53 = (e53) queryLocalInterface19;
                    } else {
                        e53 = new c53(readStrongBinder19);
                    }
                }
                ((x43) this).e0(zzlk, e53);
                break;
            case 122:
                zzmk zzmk = (zzmk) mp2.a(parcel, zzmk.CREATOR);
                IBinder readStrongBinder20 = parcel.readStrongBinder();
                if (readStrongBinder20 != null) {
                    IInterface queryLocalInterface20 = readStrongBinder20.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface20 instanceof e53) {
                        e53 = (e53) queryLocalInterface20;
                    } else {
                        e53 = new c53(readStrongBinder20);
                    }
                }
                ((x43) this).J3(zzmk, e53);
                break;
            case 123:
                zzmy zzmy = (zzmy) mp2.a(parcel, zzmy.CREATOR);
                IBinder readStrongBinder21 = parcel.readStrongBinder();
                if (readStrongBinder21 != null) {
                    IInterface queryLocalInterface21 = readStrongBinder21.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface21 instanceof e53) {
                        e53 = (e53) queryLocalInterface21;
                    } else {
                        e53 = new c53(readStrongBinder21);
                    }
                }
                ((x43) this).E3(zzmy, e53);
                break;
            case 124:
                zzmc zzmc = (zzmc) mp2.a(parcel, zzmc.CREATOR);
                IBinder readStrongBinder22 = parcel.readStrongBinder();
                if (readStrongBinder22 != null) {
                    IInterface queryLocalInterface22 = readStrongBinder22.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface22 instanceof e53) {
                        e53 = (e53) queryLocalInterface22;
                    } else {
                        e53 = new c53(readStrongBinder22);
                    }
                }
                ((x43) this).a0(zzmc, e53);
                break;
            case 126:
                zzmg zzmg = (zzmg) mp2.a(parcel, zzmg.CREATOR);
                IBinder readStrongBinder23 = parcel.readStrongBinder();
                if (readStrongBinder23 != null) {
                    IInterface queryLocalInterface23 = readStrongBinder23.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface23 instanceof e53) {
                        e53 = (e53) queryLocalInterface23;
                    } else {
                        e53 = new c53(readStrongBinder23);
                    }
                }
                ((x43) this).N2(zzmg, e53);
                break;
            case 127:
                zzmm zzmm = (zzmm) mp2.a(parcel, zzmm.CREATOR);
                IBinder readStrongBinder24 = parcel.readStrongBinder();
                if (readStrongBinder24 != null) {
                    IInterface queryLocalInterface24 = readStrongBinder24.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface24 instanceof e53) {
                        e53 = (e53) queryLocalInterface24;
                    } else {
                        e53 = new c53(readStrongBinder24);
                    }
                }
                ((x43) this).D2(zzmm, e53);
                break;
            case 128:
                zzmi zzmi = (zzmi) mp2.a(parcel, zzmi.CREATOR);
                IBinder readStrongBinder25 = parcel.readStrongBinder();
                if (readStrongBinder25 != null) {
                    IInterface queryLocalInterface25 = readStrongBinder25.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface25 instanceof e53) {
                        e53 = (e53) queryLocalInterface25;
                    } else {
                        e53 = new c53(readStrongBinder25);
                    }
                }
                ((x43) this).J0(zzmi, e53);
                break;
            case 129:
                zzmw zzmw = (zzmw) mp2.a(parcel, zzmw.CREATOR);
                IBinder readStrongBinder26 = parcel.readStrongBinder();
                if (readStrongBinder26 != null) {
                    IInterface queryLocalInterface26 = readStrongBinder26.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface26 instanceof e53) {
                        e53 = (e53) queryLocalInterface26;
                    } else {
                        e53 = new c53(readStrongBinder26);
                    }
                }
                ((x43) this).S1(zzmw, e53);
                break;
            case 130:
                zzna zzna = (zzna) mp2.a(parcel, zzna.CREATOR);
                IBinder readStrongBinder27 = parcel.readStrongBinder();
                if (readStrongBinder27 != null) {
                    IInterface queryLocalInterface27 = readStrongBinder27.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface27 instanceof e53) {
                        e53 = (e53) queryLocalInterface27;
                    } else {
                        e53 = new c53(readStrongBinder27);
                    }
                }
                ((x43) this).U0(zzna, e53);
                break;
            case 131:
                zzne zzne = (zzne) mp2.a(parcel, zzne.CREATOR);
                IBinder readStrongBinder28 = parcel.readStrongBinder();
                if (readStrongBinder28 != null) {
                    IInterface queryLocalInterface28 = readStrongBinder28.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface28 instanceof e53) {
                        e53 = (e53) queryLocalInterface28;
                    } else {
                        e53 = new c53(readStrongBinder28);
                    }
                }
                ((x43) this).o0(zzne, e53);
                break;
            case 132:
                zzlq zzlq = (zzlq) mp2.a(parcel, zzlq.CREATOR);
                IBinder readStrongBinder29 = parcel.readStrongBinder();
                if (readStrongBinder29 != null) {
                    IInterface queryLocalInterface29 = readStrongBinder29.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface29 instanceof e53) {
                        e53 = (e53) queryLocalInterface29;
                    } else {
                        e53 = new c53(readStrongBinder29);
                    }
                }
                ((x43) this).D0(zzlq, e53);
                break;
            case 133:
                zznc zznc = (zznc) mp2.a(parcel, zznc.CREATOR);
                IBinder readStrongBinder30 = parcel.readStrongBinder();
                if (readStrongBinder30 != null) {
                    IInterface queryLocalInterface30 = readStrongBinder30.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface30 instanceof e53) {
                        e53 = (e53) queryLocalInterface30;
                    } else {
                        e53 = new c53(readStrongBinder30);
                    }
                }
                ((x43) this).x3(zznc, e53);
                break;
            case 134:
                zzls zzls = (zzls) mp2.a(parcel, zzls.CREATOR);
                IBinder readStrongBinder31 = parcel.readStrongBinder();
                if (readStrongBinder31 != null) {
                    IInterface queryLocalInterface31 = readStrongBinder31.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface31 instanceof e53) {
                        e53 = (e53) queryLocalInterface31;
                    } else {
                        e53 = new c53(readStrongBinder31);
                    }
                }
                ((x43) this).Y2(zzls, e53);
                break;
            case 135:
                zznm zznm = (zznm) mp2.a(parcel, zznm.CREATOR);
                IBinder readStrongBinder32 = parcel.readStrongBinder();
                if (readStrongBinder32 != null) {
                    IInterface queryLocalInterface32 = readStrongBinder32.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface32 instanceof e53) {
                        e53 = (e53) queryLocalInterface32;
                    } else {
                        e53 = new c53(readStrongBinder32);
                    }
                }
                ((x43) this).h2(zznm, e53);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
