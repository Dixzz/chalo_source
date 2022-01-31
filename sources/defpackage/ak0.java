package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.ProductGroup;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.razorpay.AnalyticsConstants;
import defpackage.jk;

/* renamed from: ak0  reason: default package */
/* compiled from: ProductListAdapter.kt */
public final class ak0 extends ok<ProductGroup, d> {
    public static final a e = new a(null);
    public final Context c;
    public final c d;

    /* renamed from: ak0$a */
    /* compiled from: ProductListAdapter.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* renamed from: ak0$b */
    /* compiled from: ProductListAdapter.kt */
    public static final class b extends jk.e<ProductGroup> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.jk.e
        public boolean a(ProductGroup productGroup, ProductGroup productGroup2) {
            ProductGroup productGroup3 = productGroup;
            ProductGroup productGroup4 = productGroup2;
            n86.e(productGroup3, "oldItem");
            n86.e(productGroup4, "newItem");
            return productGroup3 == productGroup4;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.jk.e
        public boolean b(ProductGroup productGroup, ProductGroup productGroup2) {
            ProductGroup productGroup3 = productGroup;
            ProductGroup productGroup4 = productGroup2;
            n86.e(productGroup3, "oldItem");
            n86.e(productGroup4, "newItem");
            return productGroup3 == productGroup4;
        }
    }

    /* renamed from: ak0$c */
    /* compiled from: ProductListAdapter.kt */
    public interface c {
        void a();
    }

    /* renamed from: ak0$d */
    /* compiled from: ProductListAdapter.kt */
    public final class d extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final ty f171a;
        public final /* synthetic */ ak0 b;

        /* renamed from: ak0$d$a */
        /* compiled from: ProductListAdapter.kt */
        public /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f172a = {1, 3, 2, 4};

            static {
                ProductGroup.values();
                ProductGroup productGroup = ProductGroup.TICKET;
                ProductGroup productGroup2 = ProductGroup.SCANANDPAY;
                ProductGroup productGroup3 = ProductGroup.LONGTERM;
                ProductGroup productGroup4 = ProductGroup.CARDRECHARGE;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ak0 ak0, ty tyVar) {
            super(tyVar.f3419a);
            n86.e(ak0, "this$0");
            n86.e(tyVar, "viewBinding");
            this.b = ak0;
            this.f171a = tyVar;
            tyVar.f3419a.setOnClickListener(new ni0(this, ak0));
        }
    }

    /* renamed from: ak0$e */
    /* compiled from: ProductListAdapter.kt */
    public /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f173a = {1, 2, 3, 4};

        static {
            ProductGroup.values();
            ProductGroup productGroup = ProductGroup.TICKET;
            ProductGroup productGroup2 = ProductGroup.LONGTERM;
            ProductGroup productGroup3 = ProductGroup.SCANANDPAY;
            ProductGroup productGroup4 = ProductGroup.CARDRECHARGE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ak0(Context context, c cVar) {
        super(new b());
        n86.e(context, AnalyticsConstants.CONTEXT);
        n86.e(cVar, "onlineCardRechargeBtnClickListener");
        this.c = context;
        this.d = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(RecyclerView.a0 a0Var, int i) {
        d dVar = (d) a0Var;
        n86.e(dVar, "holder");
        ty tyVar = dVar.f171a;
        T t = this.f2701a.f.get(i);
        int i2 = t == null ? -1 : e.f173a[t.ordinal()];
        if (i2 == 1) {
            tyVar.b.setImageResource(R.drawable.oneway_ticket_icon);
            tyVar.c.setText(this.c.getString(R.string.one_way_ticket));
        } else if (i2 == 2) {
            tyVar.b.setImageResource(R.drawable.longterm_product_icon);
            tyVar.c.setText(this.c.getString(R.string.bus_pass));
        } else if (i2 == 3) {
            tyVar.b.setImageResource(R.drawable.scan_and_pay_product_icon);
            tyVar.c.setText(this.c.getString(R.string.scan_and_pay));
        } else if (i2 == 4) {
            tyVar.b.setImageResource(R.drawable.ic_online_card_recharge);
            tyVar.c.setText("Card Recharge");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public RecyclerView.a0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        n86.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.c).inflate(R.layout.product_home_screen, (ViewGroup) null, false);
        int i2 = R.id.product_icon;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.product_icon);
        if (imageView != null) {
            i2 = R.id.product_name;
            MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.product_name);
            if (materialTextView != null) {
                ty tyVar = new ty((MaterialCardView) inflate, imageView, materialTextView);
                n86.d(tyVar, "inflate(LayoutInflater.from(context))");
                return new d(this, tyVar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }
}
