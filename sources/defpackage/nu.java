package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.digitalTripReceipt.SuperPassTripReceipt;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import defpackage.jk;

/* renamed from: nu  reason: default package */
/* compiled from: DigitalTripReceiptHistoryAdapter.kt */
public final class nu extends ok<SuperPassTripReceipt, b> {
    public final s76<SuperPassTripReceipt, s56> c;

    /* renamed from: nu$a */
    /* compiled from: DigitalTripReceiptHistoryAdapter.kt */
    public static final class a extends jk.e<SuperPassTripReceipt> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.jk.e
        public boolean a(SuperPassTripReceipt superPassTripReceipt, SuperPassTripReceipt superPassTripReceipt2) {
            SuperPassTripReceipt superPassTripReceipt3 = superPassTripReceipt;
            SuperPassTripReceipt superPassTripReceipt4 = superPassTripReceipt2;
            n86.e(superPassTripReceipt3, "oldItem");
            n86.e(superPassTripReceipt4, "newItem");
            return superPassTripReceipt3.getActivationTimeStamp() == superPassTripReceipt4.getActivationTimeStamp();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.jk.e
        public boolean b(SuperPassTripReceipt superPassTripReceipt, SuperPassTripReceipt superPassTripReceipt2) {
            SuperPassTripReceipt superPassTripReceipt3 = superPassTripReceipt;
            SuperPassTripReceipt superPassTripReceipt4 = superPassTripReceipt2;
            n86.e(superPassTripReceipt3, "oldItem");
            n86.e(superPassTripReceipt4, "newItem");
            return n86.a(superPassTripReceipt3.getPassId(), superPassTripReceipt4.getPassId()) && superPassTripReceipt3.getActivationTimeStamp() == superPassTripReceipt4.getActivationTimeStamp() && superPassTripReceipt3.getPunchTimeStamp() == superPassTripReceipt4.getPunchTimeStamp();
        }
    }

    /* renamed from: nu$b */
    /* compiled from: DigitalTripReceiptHistoryAdapter.kt */
    public final class b extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final ax f2604a;
        public final /* synthetic */ nu b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(nu nuVar, ax axVar) {
            super(axVar.f342a);
            n86.e(nuVar, "this$0");
            n86.e(axVar, "itemBinding");
            this.b = nuVar;
            this.f2604a = axVar;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: s76<? super app.zophop.models.mTicketing.digitalTripReceipt.SuperPassTripReceipt, s56> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public nu(s76<? super SuperPassTripReceipt, s56> s76) {
        super(new a());
        n86.e(s76, "cardItemClickListener");
        this.c = s76;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(RecyclerView.a0 a0Var, int i) {
        b bVar = (b) a0Var;
        n86.e(bVar, "holder");
        T t = this.f2701a.f.get(i);
        n86.d(t, "getItem(position)");
        T t2 = t;
        n86.e(t2, "lSuperPassTripReceipt");
        ax axVar = bVar.f2604a;
        nu nuVar = bVar.b;
        axVar.b.setText(f71.f1097a.c(t2.getActivationTimeStamp()));
        axVar.c.setOnClickListener(new eu(nuVar, t2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public RecyclerView.a0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        n86.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.digital_trip_receipt_item_view, viewGroup, false);
        int i2 = R.id.activation_time;
        MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.activation_time);
        if (materialTextView != null) {
            i2 = R.id.parent_layout;
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.parent_layout);
            if (constraintLayout != null) {
                i2 = R.id.sync_error_group;
                Group group = (Group) inflate.findViewById(R.id.sync_error_group);
                if (group != null) {
                    i2 = R.id.text_refresh;
                    MaterialTextView materialTextView2 = (MaterialTextView) inflate.findViewById(R.id.text_refresh);
                    if (materialTextView2 != null) {
                        i2 = R.id.trip_error_card_text;
                        MaterialTextView materialTextView3 = (MaterialTextView) inflate.findViewById(R.id.trip_error_card_text);
                        if (materialTextView3 != null) {
                            i2 = R.id.trip_error_card_title;
                            MaterialTextView materialTextView4 = (MaterialTextView) inflate.findViewById(R.id.trip_error_card_title);
                            if (materialTextView4 != null) {
                                ax axVar = new ax((MaterialCardView) inflate, materialTextView, constraintLayout, group, materialTextView2, materialTextView3, materialTextView4);
                                n86.d(axVar, "inflate(LayoutInflater.f….context), parent, false)");
                                return new b(this, axVar);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }
}
