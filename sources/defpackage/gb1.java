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
import app.zophop.models.Agency;
import app.zophop.models.mTicketing.ProofViewInfo;
import defpackage.xt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: gb1  reason: default package */
/* compiled from: MagicProofsListView */
public class gb1 extends LinearLayout {
    public List<ProofViewInfo> f;
    public boolean g;
    public final a h;
    public final Agency i;
    public final Map<String, String> j;

    /* renamed from: gb1$a */
    /* compiled from: MagicProofsListView */
    public interface a {
    }

    public gb1(Context context, Agency agency, Map<String, String> map, List<ProofViewInfo> list, a aVar) {
        super(context);
        this.i = agency;
        this.f = list;
        this.j = map;
        this.h = aVar;
        setOrientation(1);
        removeAllViews();
        if (this.f != null) {
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                ProofViewInfo proofViewInfo = this.f.get(i2);
                Context context2 = getContext();
                View inflate = LayoutInflater.from(context2).inflate(R.layout.zophop_form_image_input, (ViewGroup) this, false);
                xt.t1 t1Var = xt.f3961a;
                ((TextView) inflate.findViewById(R.id.proof_name)).setText(t1Var.c().k0(proofViewInfo.getName()));
                ImageView imageView = (ImageView) inflate.findViewById(R.id.add_image_view);
                if (proofViewInfo.getImage() != null) {
                    imageView.setImageBitmap(proofViewInfo.getImage());
                } else if (proofViewInfo.getUrl() != null) {
                    ml1<Bitmap> j2 = gl1.f(context2).j();
                    j2.h(proofViewInfo.getUrl());
                    j2.f(new b71(context2.getResources().getDimensionPixelOffset(R.dimen.pass_proof_image_size), context2.getResources().getDimensionPixelOffset(R.dimen.pass_proof_image_size), imageView, proofViewInfo));
                }
                String C = hj1.C(t1Var);
                Map<String, String> map2 = this.j;
                if (t1Var.c().u(C, this.i.getAgencyName(), (map2 == null || !map2.containsKey(proofViewInfo.getName())) ? proofViewInfo.getName() : this.j.get(proofViewInfo.getName())) != null) {
                    inflate.findViewById(R.id.guidelines).setVisibility(0);
                } else {
                    inflate.findViewById(R.id.guidelines).setVisibility(8);
                }
                inflate.findViewById(R.id.proof_layout).findViewById(R.id.card_view).setOnClickListener(new db1(this, inflate, proofViewInfo, i2));
                inflate.findViewById(R.id.guidelines).setOnClickListener(new eb1(this, inflate, proofViewInfo, i2));
                if (proofViewInfo.getUrl() != null) {
                    ImageView imageView2 = (ImageView) inflate.findViewById(R.id.remove_icon);
                    imageView2.setVisibility(0);
                    imageView2.setOnClickListener(new fb1(this, inflate, proofViewInfo, i2));
                }
                addView(inflate);
            }
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/content/Context;)Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>; */
    public Map a() {
        HashMap hashMap = new HashMap();
        for (ProofViewInfo proofViewInfo : this.f) {
            if (proofViewInfo.isEdited()) {
                hashMap.put(proofViewInfo.getName(), proofViewInfo.getImageUrl() == null ? proofViewInfo.getUrl() : proofViewInfo.getImageUrl());
            }
        }
        return hashMap;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/content/Context;)Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>; */
    public Map b() {
        HashMap hashMap = new HashMap();
        for (ProofViewInfo proofViewInfo : this.f) {
            if (proofViewInfo.isEdited()) {
                hashMap.put(proofViewInfo.getName(), proofViewInfo.getImageUrl() == null ? proofViewInfo.getUrl() : proofViewInfo.getImageUrl());
            }
        }
        return hashMap;
    }

    public void c(String str, String str2, int i2) {
        this.f.get(i2).setUrl(str2);
        this.f.get(i2).setEdited();
        this.f.get(i2).setImageUrl(str);
    }

    public List<ProofViewInfo> getProofsList() {
        return this.f;
    }

    public void setEditable(boolean z) {
        this.g = z;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
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
