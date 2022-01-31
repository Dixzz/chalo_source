package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.ProofUploadDetails;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.List;

/* renamed from: ru  reason: default package */
/* compiled from: UserProofPhotosAdapter.kt */
public final class ru extends RecyclerView.e<b> {

    /* renamed from: a  reason: collision with root package name */
    public final ve f3131a;
    public final List<ProofUploadDetails> b;
    public final a c;

    /* renamed from: ru$a */
    /* compiled from: UserProofPhotosAdapter.kt */
    public interface a {
        void a(View view, ProofUploadDetails proofUploadDetails);
    }

    /* renamed from: ru$b */
    /* compiled from: UserProofPhotosAdapter.kt */
    public final class b extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final wy f3132a;
        public final /* synthetic */ ru b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ru ruVar, wy wyVar) {
            super(wyVar.f3858a);
            n86.e(ruVar, "this$0");
            n86.e(wyVar, "itemBinding");
            this.b = ruVar;
            this.f3132a = wyVar;
        }
    }

    public ru(ve veVar, List<ProofUploadDetails> list, a aVar) {
        n86.e(list, "proofUploadDetailsList");
        n86.e(aVar, "proofPhotoClickListener");
        this.f3131a = veVar;
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
        ProofUploadDetails proofUploadDetails = this.b.get(i);
        n86.e(proofUploadDetails, "lProofUploadDetails");
        wy wyVar = bVar2.f3132a;
        ru ruVar = bVar2.b;
        ve veVar = ruVar.f3131a;
        if (veVar != null) {
            gl1.g(veVar).p(proofUploadDetails.getProofImageLocalUri()).e(wyVar.b);
        }
        wyVar.b.setOnClickListener(new fu(ruVar, bVar2, proofUploadDetails));
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$a0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        n86.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.proof_photo_item, viewGroup, false);
        ShapeableImageView shapeableImageView = (ShapeableImageView) inflate.findViewById(R.id.proof_image);
        if (shapeableImageView != null) {
            wy wyVar = new wy((ConstraintLayout) inflate, shapeableImageView);
            n86.d(wyVar, "inflate(LayoutInflater.f….context), parent, false)");
            return new b(this, wyVar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.proof_image)));
    }
}
