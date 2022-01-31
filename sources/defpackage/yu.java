package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.razorpay.AnalyticsConstants;
import defpackage.jk;

/* renamed from: yu  reason: default package */
/* compiled from: OnlineCardRechargeAdapter.kt */
public final class yu extends ok<OnlineCardRecharge, b> {
    public final Context c;
    public final boolean d;
    public final s76<OnlineCardRecharge, s56> e;

    /* renamed from: yu$a */
    /* compiled from: OnlineCardRechargeAdapter.kt */
    public static final class a extends jk.e<OnlineCardRecharge> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.jk.e
        public boolean a(OnlineCardRecharge onlineCardRecharge, OnlineCardRecharge onlineCardRecharge2) {
            OnlineCardRecharge onlineCardRecharge3 = onlineCardRecharge;
            OnlineCardRecharge onlineCardRecharge4 = onlineCardRecharge2;
            n86.e(onlineCardRecharge3, "oldItem");
            n86.e(onlineCardRecharge4, "newItem");
            return onlineCardRecharge3.getCardRechargePaymentProperties().getCardRechargeInfo().getRechargeStatus() == onlineCardRecharge4.getCardRechargePaymentProperties().getCardRechargeInfo().getRechargeStatus() && onlineCardRecharge3.getCardRechargePaymentProperties().getCardRechargeInfo().getPaymentStatus() == onlineCardRecharge4.getCardRechargePaymentProperties().getCardRechargeInfo().getPaymentStatus();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.jk.e
        public boolean b(OnlineCardRecharge onlineCardRecharge, OnlineCardRecharge onlineCardRecharge2) {
            OnlineCardRecharge onlineCardRecharge3 = onlineCardRecharge;
            OnlineCardRecharge onlineCardRecharge4 = onlineCardRecharge2;
            n86.e(onlineCardRecharge3, "oldItem");
            n86.e(onlineCardRecharge4, "newItem");
            return n86.a(onlineCardRecharge3.getCardRechargePaymentProperties().getTransactionId(), onlineCardRecharge4.getCardRechargePaymentProperties().getTransactionId());
        }
    }

    /* renamed from: yu$b */
    /* compiled from: OnlineCardRechargeAdapter.kt */
    public final class b extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final oy f4085a;
        public final /* synthetic */ yu b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(yu yuVar, oy oyVar) {
            super(oyVar.f2741a);
            n86.e(yuVar, "this$0");
            n86.e(oyVar, "itemBinding");
            this.b = yuVar;
            this.f4085a = oyVar;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: s76<? super app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge, s56> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yu(Context context, boolean z, s76<? super OnlineCardRecharge, s56> s76) {
        super(new a());
        n86.e(context, AnalyticsConstants.CONTEXT);
        n86.e(s76, "cardItemClickListener");
        this.c = context;
        this.d = z;
        this.e = s76;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(RecyclerView.a0 a0Var, int i) {
        b bVar = (b) a0Var;
        n86.e(bVar, "holder");
        T t = this.f2701a.f.get(i);
        n86.d(t, "getItem(position)");
        T t2 = t;
        n86.e(t2, "lCardRecharge");
        oy oyVar = bVar.f4085a;
        yu yuVar = bVar.b;
        oyVar.c.setText(f71.b(f71.f1097a, t2.getCardProperties().getCardNo(), 0, 2));
        oyVar.f.setText(wh1.a(wh1.f3781a, t2.getCardRechargePaymentProperties().getCardRechargeInfo().getRechargeAmount(), 0, 2));
        if (yuVar.d) {
            Group group = oyVar.b;
            n86.d(group, "briefSummaryGroup");
            group.setVisibility(0);
            oyVar.e.setText(jh1.d(t2.getCardRechargePaymentProperties().getPaymentTime()));
            oy oyVar2 = bVar.f4085a;
            int ordinal = t2.getCardRechargePaymentProperties().getCardRechargeInfo().getPaymentStatus().ordinal();
            if (ordinal == 0) {
                hj1.w0(yuVar.c, R.string.processing, oyVar2.g);
            } else if (ordinal == 1) {
                int ordinal2 = t2.getCardRechargePaymentProperties().getCardRechargeInfo().getRechargeStatus().ordinal();
                if (ordinal2 == 0) {
                    hj1.w0(yuVar.c, R.string.recharge_pending_title, oyVar2.g);
                } else if (ordinal2 == 1) {
                    hj1.w0(yuVar.c, R.string.recharge_success_title, oyVar2.g);
                } else if (ordinal2 == 2) {
                    hj1.w0(yuVar.c, R.string.recharge_failed_title, oyVar2.g);
                }
            } else if (ordinal == 2) {
                hj1.w0(yuVar.c, R.string.failed, oyVar2.g);
            }
        } else {
            Group group2 = oyVar.b;
            n86.d(group2, "briefSummaryGroup");
            group2.setVisibility(8);
        }
        oyVar.d.setOnClickListener(new wu(yuVar, t2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public RecyclerView.a0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        n86.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.online_card_recharge_item_view, viewGroup, false);
        int i2 = R.id.brief_summary_group;
        Group group = (Group) inflate.findViewById(R.id.brief_summary_group);
        if (group != null) {
            i2 = R.id.card_no;
            MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.card_no);
            if (materialTextView != null) {
                i2 = R.id.parent_layout;
                ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.parent_layout);
                if (constraintLayout != null) {
                    i2 = R.id.payment_date;
                    MaterialTextView materialTextView2 = (MaterialTextView) inflate.findViewById(R.id.payment_date);
                    if (materialTextView2 != null) {
                        i2 = R.id.recharge_amt;
                        MaterialTextView materialTextView3 = (MaterialTextView) inflate.findViewById(R.id.recharge_amt);
                        if (materialTextView3 != null) {
                            i2 = R.id.status;
                            MaterialTextView materialTextView4 = (MaterialTextView) inflate.findViewById(R.id.status);
                            if (materialTextView4 != null) {
                                oy oyVar = new oy((MaterialCardView) inflate, group, materialTextView, constraintLayout, materialTextView2, materialTextView3, materialTextView4);
                                n86.d(oyVar, "inflate(LayoutInflater.f….context), parent, false)");
                                return new b(this, oyVar);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }
}
