package defpackage;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import defpackage.a32;
import defpackage.x22;
import java.util.List;

/* renamed from: s02  reason: default package */
public abstract class s02 extends zd2 implements IInterface {
    public s02() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override // defpackage.zd2
    public final boolean C(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            x02 x02 = (x02) this;
            x02.F();
            i02 a2 = i02.a(x02.f);
            GoogleSignInAccount b = a2.b();
            GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.p;
            if (b != null) {
                googleSignInOptions = a2.c();
            }
            a32.a aVar = new a32.a(x02.f);
            x22<GoogleSignInOptions> x22 = uz1.f;
            gj1.l(x22, "Api must not be null");
            gj1.l(googleSignInOptions, "Null options are not permitted for this Api");
            aVar.g.put(x22, googleSignInOptions);
            x22.a<?, O> aVar2 = x22.f3873a;
            gj1.l(aVar2, "Base client builder must not be null");
            List<Scope> impliedScopes = aVar2.getImpliedScopes(googleSignInOptions);
            aVar.b.addAll(impliedScopes);
            aVar.f104a.addAll(impliedScopes);
            a32 d = aVar.d();
            try {
                if (d.d().m1()) {
                    if (b != null) {
                        ((l02) uz1.h).a(d);
                    } else {
                        d.e();
                    }
                }
            } finally {
                d.g();
            }
        } else if (i != 2) {
            return false;
        } else {
            x02 x022 = (x02) this;
            x022.F();
            r02.b(x022.f).a();
        }
        return true;
    }
}
