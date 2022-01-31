package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPassProofProperties;
import de.hdodenhof.circleimageview.CircleImageView;
import defpackage.ti0;

/* renamed from: hi0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class hi0 implements View.OnClickListener {
    public final /* synthetic */ ti0 f;
    public final /* synthetic */ SuperPassProofProperties g;
    public final /* synthetic */ ti0.b h;

    public /* synthetic */ hi0(ti0 ti0, SuperPassProofProperties superPassProofProperties, ti0.b bVar) {
        this.f = ti0;
        this.g = superPassProofProperties;
        this.h = bVar;
    }

    public final void onClick(View view) {
        ti0 ti0 = this.f;
        SuperPassProofProperties superPassProofProperties = this.g;
        ti0.b bVar = this.h;
        n86.e(ti0, "this$0");
        n86.e(superPassProofProperties, "$lSuperPassProofProperties");
        n86.e(bVar, "this$1");
        ti0.a aVar = ti0.c;
        String proofUrl = superPassProofProperties.getProofUrl();
        CircleImageView circleImageView = bVar.f3361a.b;
        n86.d(circleImageView, "lItemBinding.proofDocumentImage");
        aVar.a(proofUrl, circleImageView);
    }
}
