package defpackage;

import android.view.View;
import android.widget.ImageView;
import app.zophop.R;
import app.zophop.models.mTicketing.ProofViewInfo;
import defpackage.gb1;
import java.util.Objects;

/* renamed from: fb1  reason: default package */
/* compiled from: MagicProofsListView */
public class fb1 implements View.OnClickListener {
    public final /* synthetic */ View f;
    public final /* synthetic */ ProofViewInfo g;
    public final /* synthetic */ int h;
    public final /* synthetic */ gb1 i;

    public fb1(gb1 gb1, View view, ProofViewInfo proofViewInfo, int i2) {
        this.i = gb1;
        this.f = view;
        this.g = proofViewInfo;
        this.h = i2;
    }

    public void onClick(View view) {
        gb1.a aVar = this.i.h;
        if (aVar != null) {
            View view2 = this.f;
            int i2 = this.h;
            jx0 jx0 = (jx0) aVar;
            Objects.requireNonNull(jx0);
            ImageView imageView = (ImageView) view2.findViewById(R.id.card_view).findViewById(R.id.add_image_view);
            imageView.setVisibility(0);
            imageView.setImageDrawable(jx0.f1990a.getResources().getDrawable(R.drawable.add_proof_selection));
            ((ImageView) view2.findViewById(R.id.remove_icon)).setVisibility(8);
            jx0.f1990a.A.get(i2).setUrl(null);
            jx0.f1990a.h();
        }
    }
}
