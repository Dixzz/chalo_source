package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.universalPass.UniversalPassInfo;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.razorpay.AnalyticsConstants;
import defpackage.jk;

/* renamed from: bv  reason: default package */
/* compiled from: UniversalPassInfoAdapter.kt */
public final class bv extends ok<UniversalPassInfo, c> {
    public static final a d = new a(null);
    public final Context c;

    /* renamed from: bv$a */
    /* compiled from: UniversalPassInfoAdapter.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* renamed from: bv$b */
    /* compiled from: UniversalPassInfoAdapter.kt */
    public static final class b extends jk.e<UniversalPassInfo> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.jk.e
        public boolean a(UniversalPassInfo universalPassInfo, UniversalPassInfo universalPassInfo2) {
            UniversalPassInfo universalPassInfo3 = universalPassInfo;
            UniversalPassInfo universalPassInfo4 = universalPassInfo2;
            n86.e(universalPassInfo3, "oldItem");
            n86.e(universalPassInfo4, "newItem");
            return n86.a(universalPassInfo3, universalPassInfo4);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.jk.e
        public boolean b(UniversalPassInfo universalPassInfo, UniversalPassInfo universalPassInfo2) {
            UniversalPassInfo universalPassInfo3 = universalPassInfo;
            UniversalPassInfo universalPassInfo4 = universalPassInfo2;
            n86.e(universalPassInfo3, "oldItem");
            n86.e(universalPassInfo4, "newItem");
            return n86.a(universalPassInfo3.getBeneficiaryId(), universalPassInfo4.getBeneficiaryId());
        }
    }

    /* renamed from: bv$c */
    /* compiled from: UniversalPassInfoAdapter.kt */
    public final class c extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final oz f478a;
        public final /* synthetic */ bv b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(bv bvVar, oz ozVar) {
            super(ozVar.f2746a);
            n86.e(bvVar, "this$0");
            n86.e(ozVar, "viewBinding");
            this.b = bvVar;
            this.f478a = ozVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bv(Context context) {
        super(new b());
        n86.e(context, AnalyticsConstants.CONTEXT);
        this.c = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(RecyclerView.a0 a0Var, int i) {
        c cVar = (c) a0Var;
        n86.e(cVar, "holder");
        T t = this.f2701a.f.get(i);
        n86.d(t, "getItem(position)");
        T t2 = t;
        n86.e(t2, "lUniversalPassInfo");
        cVar.f478a.b.setText(t2.getName());
        MaterialTextView materialTextView = cVar.f478a.c;
        materialTextView.setText(cVar.b.c.getString(R.string.universal_pass_id) + ' ' + t2.getBeneficiaryId());
        cVar.f478a.f2746a.setOnClickListener(new av(cVar, t2, cVar.b));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public RecyclerView.a0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        n86.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.universal_pass_info_item, viewGroup, false);
        int i2 = R.id.name;
        MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.name);
        if (materialTextView != null) {
            i2 = R.id.parent_layout;
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.parent_layout);
            if (constraintLayout != null) {
                i2 = R.id.universal_pass_id;
                MaterialTextView materialTextView2 = (MaterialTextView) inflate.findViewById(R.id.universal_pass_id);
                if (materialTextView2 != null) {
                    oz ozVar = new oz((MaterialCardView) inflate, materialTextView, constraintLayout, materialTextView2);
                    n86.d(ozVar, "inflate(LayoutInflater.f….context), parent, false)");
                    return new c(this, ozVar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }
}
