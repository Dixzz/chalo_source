package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.mTicketing.ProofViewInfo;
import app.zophop.ui.fragments.ProfileFragment;
import java.util.List;

/* renamed from: nb1  reason: default package */
/* compiled from: ProofsListView */
public class nb1 extends LinearLayout {
    public List<ProofViewInfo> f;
    public boolean g;
    public final b h;

    /* renamed from: nb1$a */
    /* compiled from: ProofsListView */
    public class a implements View.OnClickListener {
        public final /* synthetic */ ProofViewInfo f;
        public final /* synthetic */ int g;

        public a(ProofViewInfo proofViewInfo, int i) {
            this.f = proofViewInfo;
            this.g = i;
        }

        public void onClick(View view) {
            b bVar = nb1.this.h;
            if (bVar != null) {
                ProofViewInfo proofViewInfo = this.f;
                int i = this.g;
                ProfileFragment.d dVar = (ProfileFragment.d) bVar;
                ProfileFragment profileFragment = ProfileFragment.this;
                if (profileFragment.p) {
                    profileFragment.B = vn.S0(profileFragment);
                    ProfileFragment.this.C = i;
                } else if (proofViewInfo.getImage() != null) {
                    ProfileFragment profileFragment2 = ProfileFragment.this;
                    String url = proofViewInfo.getUrl();
                    View findViewById = view.findViewById(R.id.proof_image);
                    proofViewInfo.getName();
                    profileFragment2.z(url, findViewById);
                }
            }
        }
    }

    /* renamed from: nb1$b */
    /* compiled from: ProofsListView */
    public interface b {
    }

    public nb1(Context context, List<ProofViewInfo> list, b bVar) {
        super(context);
        this.f = list;
        this.h = bVar;
        setOrientation(1);
        b();
    }

    public final View a(ProofViewInfo proofViewInfo, int i) {
        Context context = getContext();
        boolean z = this.g;
        View inflate = LayoutInflater.from(context).inflate(R.layout.proof_layout, (ViewGroup) this, false);
        ((TextView) inflate.findViewById(R.id.proof_name)).setText(xt.f3961a.c().k0(proofViewInfo.getName()));
        ImageView imageView = (ImageView) inflate.findViewById(R.id.proof_image);
        if (proofViewInfo.getImage() != null) {
            imageView.setImageBitmap(proofViewInfo.getImage());
        } else if (proofViewInfo.getUrl() != null) {
            ml1<Bitmap> j = gl1.f(context).j();
            j.h(proofViewInfo.getUrl());
            j.f(new c71(context.getResources().getDimensionPixelOffset(R.dimen.pass_proof_image_size), context.getResources().getDimensionPixelOffset(R.dimen.pass_proof_image_size), imageView, proofViewInfo));
        }
        if (z) {
            inflate.findViewById(R.id.upload_photo).setVisibility(0);
        } else {
            inflate.findViewById(R.id.upload_photo).setVisibility(8);
        }
        inflate.findViewById(R.id.proof_container).setOnClickListener(new a(proofViewInfo, i));
        return inflate;
    }

    public final void b() {
        removeAllViews();
        if (this.f != null) {
            for (int i = 0; i < this.f.size(); i++) {
                addView(a(this.f.get(i), i));
            }
        }
    }

    public boolean c() {
        for (ProofViewInfo proofViewInfo : this.f) {
            if (proofViewInfo.isEdited()) {
                return true;
            }
        }
        return false;
    }

    public List<ProofViewInfo> getProofsList() {
        return this.f;
    }

    public void setEditable(boolean z) {
        this.g = z;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.findViewById(R.id.upload_photo) != null) {
                if (z) {
                    childAt.findViewById(R.id.upload_photo).setVisibility(0);
                } else {
                    childAt.findViewById(R.id.upload_photo).setVisibility(8);
                }
            }
        }
    }
}
