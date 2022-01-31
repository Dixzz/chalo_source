package com.google.firebase.auth;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.android.gms.internal.p000firebaseauthapi.zzwt;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzay;
import com.google.firebase.auth.internal.zzbg;
import com.google.firebase.auth.internal.zzbi;
import com.google.firebase.auth.internal.zzbj;
import com.google.firebase.auth.internal.zzbk;
import com.google.firebase.auth.internal.zzbm;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzw;
import com.google.firebase.auth.internal.zzx;
import com.google.firebase.internal.InternalTokenResult;
import defpackage.x22;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class FirebaseAuth implements InternalAuthProvider {
    private FirebaseApp zza;
    private final List<IdTokenListener> zzb;
    private final List<com.google.firebase.auth.internal.IdTokenListener> zzc;
    private List<AuthStateListener> zzd;
    private p43 zze;
    private FirebaseUser zzf;
    private zzw zzg;
    private final Object zzh = new Object();
    private String zzi;
    private final Object zzj = new Object();
    private String zzk;
    private final zzbg zzl;
    private final zzbm zzm;
    private final zzf zzn;
    private zzbi zzo;
    private zzbj zzp;

    /* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
    public interface AuthStateListener {
        void onAuthStateChanged(FirebaseAuth firebaseAuth);
    }

    /* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
    public interface IdTokenListener {
        void onIdTokenChanged(FirebaseAuth firebaseAuth);
    }

    public FirebaseAuth(FirebaseApp firebaseApp) {
        zzwg zzd2;
        String apiKey = firebaseApp.getOptions().getApiKey();
        gj1.j(apiKey);
        l53 l53 = new l53(apiKey);
        Context applicationContext = firebaseApp.getApplicationContext();
        x22.g<u43> gVar = m53.f2329a;
        p43 p43 = new p43(applicationContext, l53);
        zzbg zzbg = new zzbg(firebaseApp.getApplicationContext(), firebaseApp.getPersistenceKey());
        zzbm zza2 = zzbm.zza();
        zzf zza3 = zzf.zza();
        this.zza = firebaseApp;
        this.zze = p43;
        this.zzl = zzbg;
        this.zzg = new zzw();
        Objects.requireNonNull(zza2, "null reference");
        this.zzm = zza2;
        Objects.requireNonNull(zza3, "null reference");
        this.zzn = zza3;
        this.zzb = new CopyOnWriteArrayList();
        this.zzc = new CopyOnWriteArrayList();
        this.zzd = new CopyOnWriteArrayList();
        this.zzp = zzbj.zza();
        FirebaseUser zzb2 = zzbg.zzb();
        this.zzf = zzb2;
        if (!(zzb2 == null || (zzd2 = zzbg.zzd(zzb2)) == null)) {
            zza(this.zzf, zzd2, false, false);
        }
        zza2.zzf(this);
    }

    @Keep
    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) FirebaseApp.getInstance().get(FirebaseAuth.class);
    }

    /* access modifiers changed from: private */
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zzJ(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        return (!this.zzg.zzc() || !str.equals(this.zzg.zza())) ? onVerificationStateChangedCallbacks : new zzq(this, onVerificationStateChangedCallbacks);
    }

    private final boolean zzK(String str) {
        ActionCodeUrl parseLink = ActionCodeUrl.parseLink(str);
        return parseLink != null && !TextUtils.equals(this.zzk, parseLink.zza());
    }

    public void addAuthStateListener(AuthStateListener authStateListener) {
        this.zzd.add(authStateListener);
        this.zzp.execute(new zzk(this, authStateListener));
    }

    public void addIdTokenListener(IdTokenListener idTokenListener) {
        this.zzb.add(idTokenListener);
        this.zzp.execute(new zzj(this, idTokenListener));
    }

    public yi4<Void> applyActionCode(String str) {
        gj1.j(str);
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        String str2 = this.zzk;
        Objects.requireNonNull(p43);
        g13 g13 = new g13(str, str2);
        g13.b(firebaseApp);
        return p43.c(g13);
    }

    public yi4<ActionCodeResult> checkActionCode(String str) {
        gj1.j(str);
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        String str2 = this.zzk;
        Objects.requireNonNull(p43);
        i13 i13 = new i13(str, str2);
        i13.b(firebaseApp);
        return p43.c(i13);
    }

    public yi4<Void> confirmPasswordReset(String str, String str2) {
        gj1.j(str);
        gj1.j(str2);
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        String str3 = this.zzk;
        Objects.requireNonNull(p43);
        k13 k13 = new k13(str, str2, str3);
        k13.b(firebaseApp);
        return p43.c(k13);
    }

    public yi4<AuthResult> createUserWithEmailAndPassword(String str, String str2) {
        gj1.j(str);
        gj1.j(str2);
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        String str3 = this.zzk;
        zzs zzs = new zzs(this);
        Objects.requireNonNull(p43);
        m13 m13 = new m13(str, str2, str3);
        m13.b(firebaseApp);
        m13.d(zzs);
        return p43.c(m13);
    }

    public yi4<SignInMethodQueryResult> fetchSignInMethodsForEmail(String str) {
        gj1.j(str);
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        String str2 = this.zzk;
        Objects.requireNonNull(p43);
        r13 r13 = new r13(str, str2);
        r13.b(firebaseApp);
        return p43.b(r13);
    }

    @Override // com.google.firebase.internal.InternalTokenProvider, com.google.firebase.auth.internal.InternalAuthProvider
    public final yi4<GetTokenResult> getAccessToken(boolean z) {
        return zzh(this.zzf, z);
    }

    public FirebaseApp getApp() {
        return this.zza;
    }

    public FirebaseUser getCurrentUser() {
        return this.zzf;
    }

    public FirebaseAuthSettings getFirebaseAuthSettings() {
        return this.zzg;
    }

    public String getLanguageCode() {
        String str;
        synchronized (this.zzh) {
            str = this.zzi;
        }
        return str;
    }

    public yi4<AuthResult> getPendingAuthResult() {
        return this.zzm.zzd();
    }

    public String getTenantId() {
        String str;
        synchronized (this.zzj) {
            str = this.zzk;
        }
        return str;
    }

    @Override // com.google.firebase.internal.InternalTokenProvider, com.google.firebase.auth.internal.InternalAuthProvider
    public final String getUid() {
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser == null) {
            return null;
        }
        return firebaseUser.getUid();
    }

    public boolean isSignInWithEmailLink(String str) {
        return EmailAuthCredential.zzi(str);
    }

    public void removeAuthStateListener(AuthStateListener authStateListener) {
        this.zzd.remove(authStateListener);
    }

    public void removeIdTokenListener(IdTokenListener idTokenListener) {
        this.zzb.remove(idTokenListener);
    }

    public yi4<Void> sendPasswordResetEmail(String str) {
        gj1.j(str);
        return sendPasswordResetEmail(str, null);
    }

    public yi4<Void> sendSignInLinkToEmail(String str, ActionCodeSettings actionCodeSettings) {
        gj1.j(str);
        Objects.requireNonNull(actionCodeSettings, "null reference");
        if (actionCodeSettings.canHandleCodeInApp()) {
            String str2 = this.zzi;
            if (str2 != null) {
                actionCodeSettings.zzc(str2);
            }
            p43 p43 = this.zze;
            FirebaseApp firebaseApp = this.zza;
            String str3 = this.zzk;
            Objects.requireNonNull(p43);
            actionCodeSettings.zze(6);
            b33 b33 = new b33(str, actionCodeSettings, str3, "sendSignInLinkToEmail");
            b33.b(firebaseApp);
            return p43.c(b33);
        }
        throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
    }

    public yi4<Void> setFirebaseUIVersion(String str) {
        p43 p43 = this.zze;
        Objects.requireNonNull(p43);
        return p43.c(new d33(str));
    }

    public void setLanguageCode(String str) {
        gj1.j(str);
        synchronized (this.zzh) {
            this.zzi = str;
        }
    }

    public void setTenantId(String str) {
        gj1.j(str);
        synchronized (this.zzj) {
            this.zzk = str;
        }
    }

    public yi4<AuthResult> signInAnonymously() {
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser == null || !firebaseUser.isAnonymous()) {
            p43 p43 = this.zze;
            FirebaseApp firebaseApp = this.zza;
            zzs zzs = new zzs(this);
            String str = this.zzk;
            Objects.requireNonNull(p43);
            f33 f33 = new f33(str);
            f33.b(firebaseApp);
            f33.d(zzs);
            return p43.c(f33);
        }
        zzx zzx = (zzx) this.zzf;
        zzx.zzn(false);
        return hd3.W0(new zzr(zzx));
    }

    public yi4<AuthResult> signInWithCredential(AuthCredential authCredential) {
        Objects.requireNonNull(authCredential, "null reference");
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if (!emailAuthCredential.zzh()) {
                p43 p43 = this.zze;
                FirebaseApp firebaseApp = this.zza;
                String zzb2 = emailAuthCredential.zzb();
                String zzc2 = emailAuthCredential.zzc();
                String str = this.zzk;
                zzs zzs = new zzs(this);
                Objects.requireNonNull(p43);
                l33 l33 = new l33(zzb2, zzc2, str);
                l33.b(firebaseApp);
                l33.d(zzs);
                return p43.c(l33);
            } else if (zzK(emailAuthCredential.zzd())) {
                return hd3.V0(w43.a(new Status(17072, null)));
            } else {
                p43 p432 = this.zze;
                FirebaseApp firebaseApp2 = this.zza;
                zzs zzs2 = new zzs(this);
                Objects.requireNonNull(p432);
                n33 n33 = new n33(emailAuthCredential);
                n33.b(firebaseApp2);
                n33.d(zzs2);
                return p432.c(n33);
            }
        } else if (zza2 instanceof PhoneAuthCredential) {
            p43 p433 = this.zze;
            FirebaseApp firebaseApp3 = this.zza;
            String str2 = this.zzk;
            zzs zzs3 = new zzs(this);
            Objects.requireNonNull(p433);
            k63.a();
            p33 p33 = new p33((PhoneAuthCredential) zza2, str2);
            p33.b(firebaseApp3);
            p33.d(zzs3);
            return p433.c(p33);
        } else {
            p43 p434 = this.zze;
            FirebaseApp firebaseApp4 = this.zza;
            String str3 = this.zzk;
            zzs zzs4 = new zzs(this);
            Objects.requireNonNull(p434);
            h33 h33 = new h33(zza2, str3);
            h33.b(firebaseApp4);
            h33.d(zzs4);
            return p434.c(h33);
        }
    }

    public yi4<AuthResult> signInWithCustomToken(String str) {
        gj1.j(str);
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        String str2 = this.zzk;
        zzs zzs = new zzs(this);
        Objects.requireNonNull(p43);
        j33 j33 = new j33(str, str2);
        j33.b(firebaseApp);
        j33.d(zzs);
        return p43.c(j33);
    }

    public yi4<AuthResult> signInWithEmailAndPassword(String str, String str2) {
        gj1.j(str);
        gj1.j(str2);
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        String str3 = this.zzk;
        zzs zzs = new zzs(this);
        Objects.requireNonNull(p43);
        l33 l33 = new l33(str, str2, str3);
        l33.b(firebaseApp);
        l33.d(zzs);
        return p43.c(l33);
    }

    public yi4<AuthResult> signInWithEmailLink(String str, String str2) {
        return signInWithCredential(EmailAuthProvider.getCredentialWithLink(str, str2));
    }

    public void signOut() {
        zzb();
        zzbi zzbi = this.zzo;
        if (zzbi != null) {
            zzbi.zzc();
        }
    }

    public yi4<AuthResult> startActivityForSignInWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        Objects.requireNonNull(federatedAuthProvider, "null reference");
        Objects.requireNonNull(activity, "null reference");
        if (!s43.f3183a) {
            return hd3.V0(w43.a(new Status(17063, null)));
        }
        zi4<AuthResult> zi4 = new zi4<>();
        if (!this.zzm.zzi(activity, zi4, this)) {
            return hd3.V0(w43.a(new Status(17057, null)));
        }
        this.zzm.zzb(activity.getApplicationContext(), this);
        federatedAuthProvider.zza(activity);
        return zi4.f4178a;
    }

    public yi4<Void> updateCurrentUser(FirebaseUser firebaseUser) {
        String str;
        if (firebaseUser == null) {
            throw new IllegalArgumentException("Cannot update current user with null user!");
        } else if ((firebaseUser.getTenantId() != null && !firebaseUser.getTenantId().equals(this.zzk)) || ((str = this.zzk) != null && !str.equals(firebaseUser.getTenantId()))) {
            return hd3.V0(w43.a(new Status(17072, null)));
        } else {
            String apiKey = firebaseUser.zzd().getOptions().getApiKey();
            String apiKey2 = this.zza.getOptions().getApiKey();
            if (!firebaseUser.zze().zzb() || !apiKey2.equals(apiKey)) {
                return zzm(firebaseUser, new zzu(this));
            }
            zza(zzx.zzs(this.zza, firebaseUser), firebaseUser.zze(), true, false);
            return hd3.W0(null);
        }
    }

    public void useAppLanguage() {
        synchronized (this.zzh) {
            this.zzi = gj1.S0();
        }
    }

    public void useEmulator(String str, int i) {
        u2 u2Var;
        gj1.j(str);
        boolean z = false;
        if (i >= 0 && i <= 65535) {
            z = true;
        }
        gj1.c(z, "Port number must be in the range 0-65535");
        FirebaseApp firebaseApp = this.zza;
        Map<String, r63> map = t63.f3313a;
        String apiKey = firebaseApp.getOptions().getApiKey();
        Map<String, r63> map2 = t63.f3313a;
        synchronized (map2) {
            r63 r63 = new r63(str, i);
            u2Var = (u2) map2;
            u2Var.put(apiKey, r63);
        }
        Map<String, WeakReference<s63>> map3 = t63.b;
        synchronized (map3) {
            u2 u2Var2 = (u2) map3;
            if (u2Var2.containsKey(apiKey)) {
                s63 s63 = (s63) ((WeakReference) u2Var2.get(apiKey)).get();
                if (s63 != null) {
                    s63.zza();
                } else {
                    u2Var.remove(apiKey);
                }
            }
        }
    }

    public yi4<String> verifyPasswordResetCode(String str) {
        gj1.j(str);
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        String str2 = this.zzk;
        Objects.requireNonNull(p43);
        m43 m43 = new m43(str, str2);
        m43.b(firebaseApp);
        return p43.c(m43);
    }

    public final yi4<Void> zzA(FirebaseUser firebaseUser, MultiFactorAssertion multiFactorAssertion, String str) {
        Objects.requireNonNull(firebaseUser, "null reference");
        Objects.requireNonNull(multiFactorAssertion, "null reference");
        if (!(multiFactorAssertion instanceof PhoneMultiFactorAssertion)) {
            return hd3.V0(w43.a(new Status(FirebaseError.ERROR_INTERNAL_ERROR, null)));
        }
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        zzs zzs = new zzs(this);
        Objects.requireNonNull(p43);
        k63.a();
        t13 t13 = new t13((PhoneMultiFactorAssertion) multiFactorAssertion, firebaseUser.zzg(), str);
        t13.b(firebaseApp);
        t13.d(zzs);
        return p43.c(t13);
    }

    public final void zza(FirebaseUser firebaseUser, zzwg zzwg, boolean z, boolean z2) {
        boolean z3;
        Objects.requireNonNull(firebaseUser, "null reference");
        Objects.requireNonNull(zzwg, "null reference");
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = this.zzf != null && firebaseUser.getUid().equals(this.zzf.getUid());
        if (z6 || !z2) {
            FirebaseUser firebaseUser2 = this.zzf;
            if (firebaseUser2 == null) {
                z3 = true;
            } else {
                boolean z7 = !firebaseUser2.zze().g.equals(zzwg.g);
                if (!z6 || z7) {
                    z4 = true;
                }
                z3 = true ^ z6;
                z5 = z4;
            }
            FirebaseUser firebaseUser3 = this.zzf;
            if (firebaseUser3 == null) {
                this.zzf = firebaseUser;
            } else {
                firebaseUser3.zzb(firebaseUser.getProviderData());
                if (!firebaseUser.isAnonymous()) {
                    this.zzf.zzc();
                }
                this.zzf.zzi(firebaseUser.getMultiFactor().getEnrolledFactors());
            }
            if (z) {
                this.zzl.zza(this.zzf);
            }
            if (z5) {
                FirebaseUser firebaseUser4 = this.zzf;
                if (firebaseUser4 != null) {
                    firebaseUser4.zzf(zzwg);
                }
                zzf(this.zzf);
            }
            if (z3) {
                zzg(this.zzf);
            }
            if (z) {
                this.zzl.zzc(firebaseUser, zzwg);
            }
            zzd().zzb(this.zzf.zze());
        }
    }

    public final void zzb() {
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser != null) {
            this.zzl.zze(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()));
            this.zzf = null;
        }
        this.zzl.zze("com.google.firebase.auth.FIREBASE_USER");
        zzf(null);
        zzg(null);
    }

    public final synchronized void zzc(zzbi zzbi) {
        this.zzo = zzbi;
    }

    public final synchronized zzbi zzd() {
        if (this.zzo == null) {
            zzc(new zzbi(this.zza));
        }
        return this.zzo;
    }

    public final FirebaseApp zze() {
        return this.zza;
    }

    public final void zzf(FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String.valueOf(firebaseUser.getUid()).length();
        }
        this.zzp.execute(new zzl(this, new InternalTokenResult(firebaseUser != null ? firebaseUser.zzh() : null)));
    }

    public final void zzg(FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String.valueOf(firebaseUser.getUid()).length();
        }
        this.zzp.execute(new zzm(this));
    }

    public final yi4<GetTokenResult> zzh(FirebaseUser firebaseUser, boolean z) {
        if (firebaseUser == null) {
            return hd3.V0(w43.a(new Status(FirebaseError.ERROR_NO_SIGNED_IN_USER, null)));
        }
        zzwg zze2 = firebaseUser.zze();
        if (zze2.zzb() && !z) {
            return hd3.W0(zzay.zza(zze2.g));
        }
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        String str = zze2.f;
        zzn zzn2 = new zzn(this);
        Objects.requireNonNull(p43);
        x13 x13 = new x13(str);
        x13.b(firebaseApp);
        x13.c(firebaseUser);
        x13.d(zzn2);
        x13.e(zzn2);
        return p43.b(x13);
    }

    public final yi4<Void> zzi(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Objects.requireNonNull(firebaseUser, "null reference");
        Objects.requireNonNull(authCredential, "null reference");
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                p43 p43 = this.zze;
                FirebaseApp firebaseApp = this.zza;
                String zzb2 = emailAuthCredential.zzb();
                String zzc2 = emailAuthCredential.zzc();
                String tenantId = firebaseUser.getTenantId();
                zzt zzt = new zzt(this);
                Objects.requireNonNull(p43);
                p23 p23 = new p23(zzb2, zzc2, tenantId);
                p23.b(firebaseApp);
                p23.c(firebaseUser);
                p23.d(zzt);
                p23.e(zzt);
                return p43.c(p23);
            } else if (zzK(emailAuthCredential.zzd())) {
                return hd3.V0(w43.a(new Status(17072, null)));
            } else {
                p43 p432 = this.zze;
                FirebaseApp firebaseApp2 = this.zza;
                zzt zzt2 = new zzt(this);
                Objects.requireNonNull(p432);
                l23 l23 = new l23(emailAuthCredential);
                l23.b(firebaseApp2);
                l23.c(firebaseUser);
                l23.d(zzt2);
                l23.e(zzt2);
                return p432.c(l23);
            }
        } else if (zza2 instanceof PhoneAuthCredential) {
            p43 p433 = this.zze;
            FirebaseApp firebaseApp3 = this.zza;
            String str = this.zzk;
            zzt zzt3 = new zzt(this);
            Objects.requireNonNull(p433);
            k63.a();
            t23 t23 = new t23((PhoneAuthCredential) zza2, str);
            t23.b(firebaseApp3);
            t23.c(firebaseUser);
            t23.d(zzt3);
            t23.e(zzt3);
            return p433.c(t23);
        } else {
            p43 p434 = this.zze;
            FirebaseApp firebaseApp4 = this.zza;
            String tenantId2 = firebaseUser.getTenantId();
            zzt zzt4 = new zzt(this);
            Objects.requireNonNull(p434);
            h23 h23 = new h23(zza2, tenantId2);
            h23.b(firebaseApp4);
            h23.c(firebaseUser);
            h23.d(zzt4);
            h23.e(zzt4);
            return p434.c(h23);
        }
    }

    public final yi4<AuthResult> zzj(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Objects.requireNonNull(firebaseUser, "null reference");
        Objects.requireNonNull(authCredential, "null reference");
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                p43 p43 = this.zze;
                FirebaseApp firebaseApp = this.zza;
                String zzb2 = emailAuthCredential.zzb();
                String zzc2 = emailAuthCredential.zzc();
                String tenantId = firebaseUser.getTenantId();
                zzt zzt = new zzt(this);
                Objects.requireNonNull(p43);
                r23 r23 = new r23(zzb2, zzc2, tenantId);
                r23.b(firebaseApp);
                r23.c(firebaseUser);
                r23.d(zzt);
                r23.e(zzt);
                return p43.c(r23);
            } else if (zzK(emailAuthCredential.zzd())) {
                return hd3.V0(w43.a(new Status(17072, null)));
            } else {
                p43 p432 = this.zze;
                FirebaseApp firebaseApp2 = this.zza;
                zzt zzt2 = new zzt(this);
                Objects.requireNonNull(p432);
                n23 n23 = new n23(emailAuthCredential);
                n23.b(firebaseApp2);
                n23.c(firebaseUser);
                n23.d(zzt2);
                n23.e(zzt2);
                return p432.c(n23);
            }
        } else if (zza2 instanceof PhoneAuthCredential) {
            p43 p433 = this.zze;
            FirebaseApp firebaseApp3 = this.zza;
            String str = this.zzk;
            zzt zzt3 = new zzt(this);
            Objects.requireNonNull(p433);
            k63.a();
            v23 v23 = new v23((PhoneAuthCredential) zza2, str);
            v23.b(firebaseApp3);
            v23.c(firebaseUser);
            v23.d(zzt3);
            v23.e(zzt3);
            return p433.c(v23);
        } else {
            p43 p434 = this.zze;
            FirebaseApp firebaseApp4 = this.zza;
            String tenantId2 = firebaseUser.getTenantId();
            zzt zzt4 = new zzt(this);
            Objects.requireNonNull(p434);
            j23 j23 = new j23(zza2, tenantId2);
            j23.b(firebaseApp4);
            j23.c(firebaseUser);
            j23.d(zzt4);
            j23.e(zzt4);
            return p434.c(j23);
        }
    }

    public final void zzk(String str, long j, TimeUnit timeUnit, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor, boolean z, String str2, String str3) {
        long convert = TimeUnit.SECONDS.convert(j, timeUnit);
        if (convert < 0 || convert > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        zzwt zzwt = new zzwt(str, convert, z, this.zzi, this.zzk, str2, s43.f3183a, str3);
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zzJ = zzJ(str, onVerificationStateChangedCallbacks);
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        Objects.requireNonNull(p43);
        o43 o43 = new o43(zzwt);
        o43.b(firebaseApp);
        o43.f(zzJ, activity, executor, zzwt.f);
        p43.c(o43);
    }

    public final void zzl(PhoneAuthOptions phoneAuthOptions) {
        String str;
        if (phoneAuthOptions.zzk()) {
            FirebaseAuth zza2 = phoneAuthOptions.zza();
            zzag zzag = (zzag) phoneAuthOptions.zzg();
            if (phoneAuthOptions.zzf() != null) {
                if (zzag.zze()) {
                    str = phoneAuthOptions.zzb();
                } else {
                    str = phoneAuthOptions.zzj().getUid();
                }
                if (k63.b(str, phoneAuthOptions.zzd(), phoneAuthOptions.zzi(), phoneAuthOptions.zze())) {
                    return;
                }
            }
            zza2.zzn.zzb(zza2, phoneAuthOptions.zzb(), phoneAuthOptions.zzi(), s43.f3183a).b(new zzp(zza2, phoneAuthOptions));
            return;
        }
        FirebaseAuth zza3 = phoneAuthOptions.zza();
        String zzb2 = phoneAuthOptions.zzb();
        long longValue = phoneAuthOptions.zzc().longValue();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zzd2 = phoneAuthOptions.zzd();
        Activity zzi2 = phoneAuthOptions.zzi();
        Executor zze2 = phoneAuthOptions.zze();
        boolean z = phoneAuthOptions.zzf() != null;
        if (z || !k63.b(zzb2, zzd2, zzi2, zze2)) {
            zza3.zzn.zzb(zza3, zzb2, zzi2, s43.f3183a).b(new zzo(zza3, zzb2, longValue, timeUnit, zzd2, zzi2, zze2, z));
        }
    }

    public final yi4<Void> zzm(FirebaseUser firebaseUser, zzbk zzbk) {
        Objects.requireNonNull(firebaseUser, "null reference");
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        Objects.requireNonNull(p43);
        x23 x23 = new x23();
        x23.b(firebaseApp);
        x23.c(firebaseUser);
        x23.d(zzbk);
        x23.e(zzbk);
        return p43.b(x23);
    }

    public final yi4<AuthResult> zzn(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Objects.requireNonNull(authCredential, "null reference");
        Objects.requireNonNull(firebaseUser, "null reference");
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        AuthCredential zza2 = authCredential.zza();
        zzt zzt = new zzt(this);
        Objects.requireNonNull(p43);
        Objects.requireNonNull(firebaseApp, "null reference");
        Objects.requireNonNull(zza2, "null reference");
        List<String> zza3 = firebaseUser.zza();
        if (zza3 != null && zza3.contains(zza2.getProvider())) {
            return hd3.V0(w43.a(new Status(FirebaseError.ERROR_PROVIDER_ALREADY_LINKED, null)));
        }
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if (!emailAuthCredential.zzh()) {
                z13 z13 = new z13(emailAuthCredential);
                z13.b(firebaseApp);
                z13.c(firebaseUser);
                z13.d(zzt);
                z13.e(zzt);
                return p43.c(z13);
            }
            f23 f23 = new f23(emailAuthCredential);
            f23.b(firebaseApp);
            f23.c(firebaseUser);
            f23.d(zzt);
            f23.e(zzt);
            return p43.c(f23);
        } else if (zza2 instanceof PhoneAuthCredential) {
            k63.a();
            d23 d23 = new d23((PhoneAuthCredential) zza2);
            d23.b(firebaseApp);
            d23.c(firebaseUser);
            d23.d(zzt);
            d23.e(zzt);
            return p43.c(d23);
        } else {
            b23 b23 = new b23(zza2);
            b23.b(firebaseApp);
            b23.c(firebaseUser);
            b23.d(zzt);
            b23.e(zzt);
            return p43.c(b23);
        }
    }

    public final yi4<AuthResult> zzo(FirebaseUser firebaseUser, String str) {
        gj1.j(str);
        Objects.requireNonNull(firebaseUser, "null reference");
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        zzt zzt = new zzt(this);
        Objects.requireNonNull(p43);
        Objects.requireNonNull(firebaseApp, "null reference");
        gj1.j(str);
        List<String> zza2 = firebaseUser.zza();
        if ((zza2 != null && !zza2.contains(str)) || firebaseUser.isAnonymous()) {
            return hd3.V0(w43.a(new Status(FirebaseError.ERROR_NO_SUCH_PROVIDER, str)));
        }
        if (((str.hashCode() == 1216985755 && str.equals("password")) ? (char) 0 : 65535) != 0) {
            a43 a43 = new a43(str);
            a43.b(firebaseApp);
            a43.c(firebaseUser);
            a43.d(zzt);
            a43.e(zzt);
            return p43.c(a43);
        }
        y33 y33 = new y33();
        y33.b(firebaseApp);
        y33.c(firebaseUser);
        y33.d(zzt);
        y33.e(zzt);
        return p43.c(y33);
    }

    public final yi4<Void> zzp(FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest) {
        Objects.requireNonNull(firebaseUser, "null reference");
        Objects.requireNonNull(userProfileChangeRequest, "null reference");
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        zzt zzt = new zzt(this);
        Objects.requireNonNull(p43);
        i43 i43 = new i43(userProfileChangeRequest);
        i43.b(firebaseApp);
        i43.c(firebaseUser);
        i43.d(zzt);
        i43.e(zzt);
        return p43.c(i43);
    }

    public final yi4<Void> zzq(FirebaseUser firebaseUser, String str) {
        Objects.requireNonNull(firebaseUser, "null reference");
        gj1.j(str);
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        zzt zzt = new zzt(this);
        Objects.requireNonNull(p43);
        c43 c43 = new c43(str);
        c43.b(firebaseApp);
        c43.c(firebaseUser);
        c43.d(zzt);
        c43.e(zzt);
        return p43.c(c43);
    }

    public final yi4<Void> zzr(FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential) {
        Objects.requireNonNull(firebaseUser, "null reference");
        Objects.requireNonNull(phoneAuthCredential, "null reference");
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        PhoneAuthCredential zzi2 = phoneAuthCredential.clone();
        zzt zzt = new zzt(this);
        Objects.requireNonNull(p43);
        k63.a();
        g43 g43 = new g43(zzi2);
        g43.b(firebaseApp);
        g43.c(firebaseUser);
        g43.d(zzt);
        g43.e(zzt);
        return p43.c(g43);
    }

    public final yi4<Void> zzs(FirebaseUser firebaseUser, String str) {
        Objects.requireNonNull(firebaseUser, "null reference");
        gj1.j(str);
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        zzt zzt = new zzt(this);
        Objects.requireNonNull(p43);
        e43 e43 = new e43(str);
        e43.b(firebaseApp);
        e43.c(firebaseUser);
        e43.d(zzt);
        e43.e(zzt);
        return p43.c(e43);
    }

    public final yi4<Void> zzt(ActionCodeSettings actionCodeSettings, String str) {
        gj1.j(str);
        if (this.zzi != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.zza();
            }
            actionCodeSettings.zzc(this.zzi);
        }
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        Objects.requireNonNull(p43);
        z23 z23 = new z23(str, actionCodeSettings);
        z23.b(firebaseApp);
        return p43.c(z23);
    }

    public final yi4<Void> zzu(FirebaseUser firebaseUser, String str) {
        Objects.requireNonNull(firebaseUser, "null reference");
        gj1.j(str);
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        zzt zzt = new zzt(this);
        Objects.requireNonNull(p43);
        w33 w33 = new w33(firebaseUser.zzg(), str);
        w33.b(firebaseApp);
        w33.c(firebaseUser);
        w33.d(zzt);
        w33.e(zzt);
        return p43.c(w33).j(new zzr(this));
    }

    public final yi4<AuthResult> zzv(MultiFactorAssertion multiFactorAssertion, zzag zzag, FirebaseUser firebaseUser) {
        Objects.requireNonNull(multiFactorAssertion, "null reference");
        Objects.requireNonNull(zzag, "null reference");
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        String zzd2 = zzag.zzd();
        zzs zzs = new zzs(this);
        Objects.requireNonNull(p43);
        k63.a();
        v13 v13 = new v13((PhoneMultiFactorAssertion) multiFactorAssertion, zzd2);
        v13.b(firebaseApp);
        v13.d(zzs);
        if (firebaseUser != null) {
            v13.c(firebaseUser);
        }
        return p43.c(v13);
    }

    public final yi4<AuthResult> zzw(Activity activity, FederatedAuthProvider federatedAuthProvider, FirebaseUser firebaseUser) {
        Objects.requireNonNull(activity, "null reference");
        Objects.requireNonNull(federatedAuthProvider, "null reference");
        Objects.requireNonNull(firebaseUser, "null reference");
        if (!s43.f3183a) {
            return hd3.V0(w43.a(new Status(17063, null)));
        }
        zi4<AuthResult> zi4 = new zi4<>();
        if (!this.zzm.zzj(activity, zi4, this, firebaseUser)) {
            return hd3.V0(w43.a(new Status(17057, null)));
        }
        this.zzm.zzc(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zzb(activity);
        return zi4.f4178a;
    }

    public final yi4<AuthResult> zzx(Activity activity, FederatedAuthProvider federatedAuthProvider, FirebaseUser firebaseUser) {
        Objects.requireNonNull(activity, "null reference");
        Objects.requireNonNull(federatedAuthProvider, "null reference");
        Objects.requireNonNull(firebaseUser, "null reference");
        if (!s43.f3183a) {
            return hd3.V0(w43.a(new Status(17063, null)));
        }
        zi4<AuthResult> zi4 = new zi4<>();
        if (!this.zzm.zzj(activity, zi4, this, firebaseUser)) {
            return hd3.V0(w43.a(new Status(17057, null)));
        }
        this.zzm.zzc(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zzc(activity);
        return zi4.f4178a;
    }

    public final yi4<Void> zzy(FirebaseUser firebaseUser) {
        Objects.requireNonNull(firebaseUser, "null reference");
        p43 p43 = this.zze;
        zzi zzi2 = new zzi(this, firebaseUser);
        Objects.requireNonNull(p43);
        o13 o13 = new o13();
        o13.c(firebaseUser);
        o13.d(zzi2);
        o13.e(zzi2);
        return p43.c(o13);
    }

    public final yi4<Void> zzz(String str, String str2, ActionCodeSettings actionCodeSettings) {
        gj1.j(str);
        gj1.j(str2);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zza();
        }
        String str3 = this.zzi;
        if (str3 != null) {
            actionCodeSettings.zzc(str3);
        }
        p43 p43 = this.zze;
        Objects.requireNonNull(p43);
        actionCodeSettings.zze(7);
        return p43.c(new k43(str, str2, actionCodeSettings));
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void removeIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Objects.requireNonNull(idTokenListener, "null reference");
        this.zzc.remove(idTokenListener);
        zzd().zza(this.zzc.size());
    }

    @Keep
    public static FirebaseAuth getInstance(FirebaseApp firebaseApp) {
        return (FirebaseAuth) firebaseApp.get(FirebaseAuth.class);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void addIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Objects.requireNonNull(idTokenListener, "null reference");
        this.zzc.add(idTokenListener);
        zzd().zza(this.zzc.size());
    }

    public yi4<Void> sendPasswordResetEmail(String str, ActionCodeSettings actionCodeSettings) {
        gj1.j(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zza();
        }
        String str2 = this.zzi;
        if (str2 != null) {
            actionCodeSettings.zzc(str2);
        }
        actionCodeSettings.zze(1);
        p43 p43 = this.zze;
        FirebaseApp firebaseApp = this.zza;
        String str3 = this.zzk;
        Objects.requireNonNull(p43);
        actionCodeSettings.zze(1);
        b33 b33 = new b33(str, actionCodeSettings, str3, "sendPasswordResetEmail");
        b33.b(firebaseApp);
        return p43.c(b33);
    }
}
