package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPassProofProperties;
import com.razorpay.AnalyticsConstants;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

/* renamed from: ti0  reason: default package */
/* compiled from: BookingSummaryProofDocumentsAdapter.kt */
public final class ti0 extends RecyclerView.e<b> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3360a;
    public final List<SuperPassProofProperties> b;
    public final a c;

    /* renamed from: ti0$a */
    /* compiled from: BookingSummaryProofDocumentsAdapter.kt */
    public interface a {
        void a(String str, View view);
    }

    /* renamed from: ti0$b */
    /* compiled from: BookingSummaryProofDocumentsAdapter.kt */
    public final class b extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final vy f3361a;
        public final /* synthetic */ ti0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ti0 ti0, vy vyVar) {
            super(vyVar.f3691a);
            n86.e(ti0, "this$0");
            n86.e(vyVar, "lItemBinding");
            this.b = ti0;
            this.f3361a = vyVar;
        }
    }

    public ti0(Context context, List<SuperPassProofProperties> list, a aVar) {
        n86.e(context, AnalyticsConstants.CONTEXT);
        n86.e(list, "superPassProofPropertiesList");
        n86.e(aVar, "proofDocumentItemClickListener");
        this.f3360a = context;
        this.b = list;
        this.c = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return this.b.size();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$a0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(b bVar, int i) {
        b bVar2 = bVar;
        n86.e(bVar2, "holder");
        SuperPassProofProperties superPassProofProperties = this.b.get(i);
        n86.e(superPassProofProperties, "lSuperPassProofProperties");
        if (superPassProofProperties.getProofUrl().length() > 0) {
            gl1.f(bVar2.b.f3360a).p(superPassProofProperties.getProofUrl()).e(bVar2.f3361a.b);
            bVar2.f3361a.b.setOnClickListener(new hi0(bVar2.b, superPassProofProperties, bVar2));
        }
        bVar2.f3361a.c.setText(superPassProofProperties.getProofName());
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$a0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        n86.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.proof_document_item, viewGroup, false);
        int i2 = R.id.proof_document_image;
        CircleImageView circleImageView = (CircleImageView) inflate.findViewById(R.id.proof_document_image);
        if (circleImageView != null) {
            i2 = R.id.proof_document_name;
            TextView textView = (TextView) inflate.findViewById(R.id.proof_document_name);
            if (textView != null) {
                vy vyVar = new vy((ConstraintLayout) inflate, circleImageView, textView);
                n86.d(vyVar, "inflate(LayoutInflater.f….context), parent, false)");
                return new b(this, vyVar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }
}
