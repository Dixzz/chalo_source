package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.google.android.material.imageview.ShapeableImageView;
import com.razorpay.AnalyticsConstants;
import defpackage.jk;

/* renamed from: rj0  reason: default package */
/* compiled from: HomeScreenPromotionCardsViewPagerAdapter.kt */
public final class rj0 extends ok<ProductPromotionsObject, c> {
    public static final a d = new a(null);
    public final Context c;

    /* renamed from: rj0$a */
    /* compiled from: HomeScreenPromotionCardsViewPagerAdapter.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* renamed from: rj0$b */
    /* compiled from: HomeScreenPromotionCardsViewPagerAdapter.kt */
    public static final class b extends jk.e<ProductPromotionsObject> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.jk.e
        public boolean a(ProductPromotionsObject productPromotionsObject, ProductPromotionsObject productPromotionsObject2) {
            n86.e(productPromotionsObject, "oldItem");
            n86.e(productPromotionsObject2, "newItem");
            return false;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.jk.e
        public boolean b(ProductPromotionsObject productPromotionsObject, ProductPromotionsObject productPromotionsObject2) {
            n86.e(productPromotionsObject, "oldItem");
            n86.e(productPromotionsObject2, "newItem");
            return false;
        }
    }

    /* renamed from: rj0$c */
    /* compiled from: HomeScreenPromotionCardsViewPagerAdapter.kt */
    public final class c extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final gy f3087a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(rj0 rj0, gy gyVar) {
            super(gyVar.f1315a);
            n86.e(rj0, "this$0");
            n86.e(gyVar, "viewBinding");
            this.f3087a = gyVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public rj0(Context context) {
        super(new b());
        n86.e(context, AnalyticsConstants.CONTEXT);
        this.c = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(RecyclerView.a0 a0Var, int i) {
        c cVar = (c) a0Var;
        n86.e(cVar, "holder");
        T t = this.f2701a.f.get(i);
        if (t.getBgVisibility()) {
            gl1.f(this.c).p(t.getBgUrl()).e(cVar.f3087a.b);
            if (t.getAction() != null) {
                cVar.itemView.setOnClickListener(new li0(i, t, this));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public RecyclerView.a0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        n86.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.c).inflate(R.layout.home_screen_promotion_card, viewGroup, false);
        ShapeableImageView shapeableImageView = (ShapeableImageView) inflate.findViewById(R.id.promotion_image);
        if (shapeableImageView != null) {
            gy gyVar = new gy((ConstraintLayout) inflate, shapeableImageView);
            n86.d(gyVar, "inflate(LayoutInflater.f…(context), parent, false)");
            return new c(this, gyVar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.promotion_image)));
    }
}
