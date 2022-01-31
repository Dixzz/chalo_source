package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzai;

/* renamed from: t03  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class t03 implements e63<zzwg> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfileChangeRequest f3290a;
    public final /* synthetic */ t43 b;
    public final /* synthetic */ y03 c;

    public t03(y03 y03, UserProfileChangeRequest userProfileChangeRequest, t43 t43) {
        this.c = y03;
        this.f3290a = userProfileChangeRequest;
        this.b = t43;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(zzwg zzwg) {
        zzwg zzwg2 = zzwg;
        x73 x73 = new x73();
        String str = zzwg2.g;
        gj1.j(str);
        x73.f = str;
        if (this.f3290a.zzb() || this.f3290a.getDisplayName() != null) {
            String displayName = this.f3290a.getDisplayName();
            if (displayName == null) {
                x73.l.g.add("DISPLAY_NAME");
            } else {
                x73.g = displayName;
            }
        }
        if (this.f3290a.zzc() || this.f3290a.getPhotoUri() != null) {
            String zza = this.f3290a.zza();
            if (zza == null) {
                x73.l.g.add("PHOTO_URL");
            } else {
                x73.k = zza;
            }
        }
        y03.c(this.c, this.b, zzwg2, x73, this);
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.b.d(zzai.zza(str));
    }
}
