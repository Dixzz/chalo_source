package com.google.firebase.auth.internal;

import com.google.android.gms.internal.p000firebaseauthapi.zzwk;
import com.google.android.gms.internal.p000firebaseauthapi.zzwr;
import com.google.firebase.auth.ActionCodeInfo;
import com.google.firebase.auth.ActionCodeResult;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzo implements ActionCodeResult {
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final ActionCodeInfo zzd;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public zzo(zzwr zzwr) {
        char c;
        String str = zzwr.g;
        boolean z = false;
        this.zzb = !(str != null) ? zzwr.f : str;
        this.zzc = zzwr.f;
        String str2 = zzwr.h;
        ActionCodeInfo actionCodeInfo = null;
        if (!(str2 != null)) {
            this.zza = 3;
            this.zzd = null;
            return;
        }
        int i = 5;
        switch (str2.hashCode()) {
            case -1874510116:
                if (str2.equals("REVERT_SECOND_FACTOR_ADDITION")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1452371317:
                if (str2.equals("PASSWORD_RESET")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1341836234:
                if (str2.equals("VERIFY_EMAIL")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1288726400:
                if (str2.equals("VERIFY_BEFORE_UPDATE_EMAIL")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 870738373:
                if (str2.equals("EMAIL_SIGNIN")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 970484929:
                if (str2.equals("RECOVER_EMAIL")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            i = 0;
        } else if (c == 1) {
            i = 1;
        } else if (c == 2) {
            i = 4;
        } else if (c != 3) {
            i = c != 4 ? c != 5 ? 3 : 6 : 2;
        }
        this.zza = i;
        if (i == 4 || i == 3) {
            this.zzd = null;
            return;
        }
        zzwk zzwk = zzwr.i;
        if (zzwk != null) {
            actionCodeInfo = new zzn(zzwr.f, zzba.zza(zzwk));
        } else {
            String str3 = zzwr.g;
            if (str3 != null) {
                actionCodeInfo = new zzl(str3, zzwr.f);
            } else {
                String str4 = zzwr.f;
                if (str4 != null ? true : z) {
                    actionCodeInfo = new zzm(str4);
                }
            }
        }
        this.zzd = actionCodeInfo;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final String getData(int i) {
        if (this.zza == 4) {
            return null;
        }
        if (i == 0) {
            return this.zzb;
        }
        if (i != 1) {
            return null;
        }
        return this.zzc;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final ActionCodeInfo getInfo() {
        return this.zzd;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final int getOperation() {
        return this.zza;
    }
}
