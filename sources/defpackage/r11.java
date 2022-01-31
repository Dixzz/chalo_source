package defpackage;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.ui.fragments.superPassValidation.SoundFragmentSuperPass;
import com.google.android.material.textview.MaterialTextView;
import java.util.Objects;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: r11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class r11 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SoundFragmentSuperPass f3025a;

    public /* synthetic */ r11(SoundFragmentSuperPass soundFragmentSuperPass) {
        this.f3025a = soundFragmentSuperPass;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        SoundFragmentSuperPass soundFragmentSuperPass = this.f3025a;
        SuperPass superPass = (SuperPass) obj;
        SoundFragmentSuperPass.a aVar = SoundFragmentSuperPass.j;
        n86.e(soundFragmentSuperPass, "this$0");
        n86.d(superPass, "lSuperPass");
        gi1.h(gi1.f1265a, "super pass fetched", superPass, "sound fragment", 0, 8);
        T t = soundFragmentSuperPass.f;
        n86.c(t);
        ez ezVar = ((dz) t).b;
        ProgressBar progressBar = ezVar.b;
        n86.d(progressBar, "passProfilePicProgressbar");
        int i = 0;
        progressBar.setVisibility(0);
        ezVar.c.setText(superPass.getSuperPassUIProperties().getPassName());
        String profilePhotoUrl = superPass.getProfilePhotoUrl();
        if (profilePhotoUrl.length() > 0) {
            ml1<Bitmap> j = gl1.g(soundFragmentSuperPass.c()).j();
            j.h(profilePhotoUrl);
            j.a(new rs1().q(50000));
            j.f(new z31(soundFragmentSuperPass, ezVar));
            ezVar.d.setOnClickListener(new u11(soundFragmentSuperPass, profilePhotoUrl, ezVar));
        }
        String passId = superPass.getSuperPassProperties().getPassId();
        if (soundFragmentSuperPass.h != null) {
            String f = xt.f3961a.t().f("easyConductorVerification");
            if (f != null) {
                try {
                    JSONObject jSONObject = new JSONObject(f);
                    if (jSONObject.has("numDigits")) {
                        i = jSONObject.getInt("numDigits");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (i <= 0) {
                T t2 = soundFragmentSuperPass.f;
                n86.c(t2);
                ((dz) t2).b.e.d.setText(soundFragmentSuperPass.getString(R.string.reference_code));
                T t3 = soundFragmentSuperPass.f;
                n86.c(t3);
                MaterialTextView materialTextView = ((dz) t3).b.e.c;
                n86.d(materialTextView, "viewBinding.bottomSheet.…CodeContainer.refCodeHash");
                materialTextView.setVisibility(8);
            } else if (soundFragmentSuperPass.h != null) {
                n86.e(passId, "productId");
                String valueOf = String.valueOf((Math.abs(passId.hashCode()) % (((int) Math.pow(10.0d, (double) i)) - 1)) + 1);
                T t4 = soundFragmentSuperPass.f;
                n86.c(t4);
                ((dz) t4).b.e.c.setText(valueOf);
                T t5 = soundFragmentSuperPass.f;
                n86.c(t5);
                ((dz) t5).b.e.d.setText(soundFragmentSuperPass.getString(R.string.ticket_number));
                SuperPassSubType superPassSubType = soundFragmentSuperPass.j().f;
                ed1 ed1 = new ed1("hash code shown", Long.MIN_VALUE);
                n86.e(ed1, "lEvent");
                n86.e(superPassSubType, "superPassSubType");
                n86.e(passId, "superPassId");
                hj1.I0(ed1, "isSuperPass", Boolean.TRUE, superPassSubType, "productSubType");
                ed1.a("passId", passId);
                ed1.a("hashCode", valueOf);
                ed1.a("numDigits", Integer.valueOf(i));
                ui1.m0(ed1);
            } else {
                n86.l("localViewModel");
                throw null;
            }
            T t6 = soundFragmentSuperPass.f;
            n86.c(t6);
            MaterialTextView materialTextView2 = ((dz) t6).b.e.b;
            Objects.requireNonNull(passId, "null cannot be cast to non-null type java.lang.String");
            String upperCase = passId.toUpperCase();
            n86.d(upperCase, "(this as java.lang.String).toUpperCase()");
            materialTextView2.setText(upperCase);
            T t7 = soundFragmentSuperPass.f;
            n86.c(t7);
            ((dz) t7).f.setOnMenuItemClickListener(new t11(soundFragmentSuperPass, superPass));
            ah b = wg.b(soundFragmentSuperPass);
            xb6 xb6 = xb6.f3911a;
            hd3.Y1(b, hj1.t0(CoroutineExceptionHandler.a.f, xf6.c), null, new x31(soundFragmentSuperPass, superPass, null), 2, null);
            return;
        }
        n86.l("localViewModel");
        throw null;
    }
}
