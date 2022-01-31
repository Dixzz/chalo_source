package defpackage;

import com.truecaller.android.sdk.ITrueCallback;
import com.truecaller.android.sdk.TrueException;
import com.truecaller.android.sdk.TrueProfile;
import com.truecaller.android.sdk.clients.VerificationCallback;
import com.truecaller.android.sdk.models.VerifyInstallationModel;
import defpackage.ch5;
import java.util.regex.Pattern;

/* renamed from: dh5  reason: default package */
/* compiled from: VerificationRequestManagerImpl */
public class dh5 implements ch5 {

    /* renamed from: a  reason: collision with root package name */
    public final uh5 f838a;
    public final vh5 b;
    public final ITrueCallback c;
    public final ch5.a d;
    public final rh5 e;
    public String f;
    public String g;
    public String h;
    public String i;
    public final Pattern j = Pattern.compile("^(?=.*?[\\w&&[\\D]&&[^_]])[\\w\\W]{1,128}$");

    public dh5(ch5.a aVar, uh5 uh5, vh5 vh5, ITrueCallback iTrueCallback, rh5 rh5) {
        this.f838a = uh5;
        this.b = vh5;
        this.d = aVar;
        this.c = iTrueCallback;
        this.e = rh5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, boolean r14, com.truecaller.android.sdk.clients.VerificationCallback r15) {
        /*
        // Method dump skipped, instructions count: 270
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dh5.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, com.truecaller.android.sdk.clients.VerificationCallback):void");
    }

    public void b(TrueProfile trueProfile, String str, String str2, VerificationCallback verificationCallback) {
        boolean z;
        boolean z2;
        if (this.f == null || this.h == null || this.g == null) {
            verificationCallback.onRequestFailure(5, new TrueException(3, TrueException.TYPE_MISSING_CREATE_CALL_MESSAGE));
            return;
        }
        String str3 = trueProfile.firstName;
        boolean z3 = false;
        if (str3 != null && !str3.trim().isEmpty()) {
            z = this.j.matcher(str3).matches();
        } else {
            z = false;
        }
        if (z) {
            String str4 = trueProfile.lastName;
            if (str4 == null) {
                z2 = false;
            } else if (str4.trim().isEmpty()) {
                z2 = true;
            } else {
                z2 = this.j.matcher(str4).matches();
            }
            if (z2) {
                z3 = true;
            }
        }
        if (z3) {
            VerifyInstallationModel verifyInstallationModel = new VerifyInstallationModel(this.h, this.f, this.g, str);
            this.b.a(str2, verifyInstallationModel).enqueue(new qh5(str2, verifyInstallationModel, verificationCallback, trueProfile, this, true));
            return;
        }
        verificationCallback.onRequestFailure(5, new TrueException(5, TrueException.TYPE_INVALID_NAME_MESSAGE));
    }
}
