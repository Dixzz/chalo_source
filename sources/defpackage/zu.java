package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import java.util.List;

/* renamed from: zu  reason: default package */
/* compiled from: SuggestedRechargeAmountsAdapter.kt */
public final class zu extends RecyclerView.e<b> {

    /* renamed from: a  reason: collision with root package name */
    public final List<Long> f4212a;
    public final a b;

    /* renamed from: zu$a */
    /* compiled from: SuggestedRechargeAmountsAdapter.kt */
    public interface a {
        void a(long j);
    }

    /* renamed from: zu$b */
    /* compiled from: SuggestedRechargeAmountsAdapter.kt */
    public final class b extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final jz f4213a;
        public final /* synthetic */ zu b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(zu zuVar, jz jzVar) {
            super(jzVar.f1997a);
            n86.e(zuVar, "this$0");
            n86.e(jzVar, "itemBinding");
            this.b = zuVar;
            this.f4213a = jzVar;
        }
    }

    public zu(List<Long> list, a aVar) {
        n86.e(list, "suggestedRechargeAmountsList");
        n86.e(aVar, "suggestedAmountClickListener");
        this.f4212a = list;
        this.b = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return this.f4212a.size();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$a0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(b bVar, int i) {
        b bVar2 = bVar;
        n86.e(bVar2, "holder");
        long longValue = this.f4212a.get(i).longValue();
        jz jzVar = bVar2.f4213a;
        zu zuVar = bVar2.b;
        jzVar.c.setText(wh1.a(wh1.f3781a, longValue, 0, 2));
        jzVar.b.setOnClickListener(new xu(zuVar, longValue));
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$a0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        n86.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.suggested_recharge_amount_view, viewGroup, false);
        MaterialCardView materialCardView = (MaterialCardView) inflate;
        MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.suggested_amount);
        if (materialTextView != null) {
            jz jzVar = new jz((MaterialCardView) inflate, materialCardView, materialTextView);
            n86.d(jzVar, "inflate(LayoutInflater.f….context), parent, false)");
            return new b(this, jzVar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.suggested_amount)));
    }
}
