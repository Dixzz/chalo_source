package defpackage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPassConstants;
import app.zophop.products.CategorySelectionActivity;
import app.zophop.products.PassSelectionActivity;
import app.zophop.products.ProductSelectionActivity;
import app.zophop.scanPay.ScanPayBaseActivity;
import app.zophop.ui.activities.MTicketTripInfoActivity;
import app.zophop.ui.adapters.ProductInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* renamed from: zj0  reason: default package */
/* compiled from: ProductAdapter */
public class zj0 extends RecyclerView.e<a> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4181a;
    public final String b;
    public Set<ProductInfo> c;
    public boolean d;

    /* renamed from: zj0$a */
    /* compiled from: ProductAdapter */
    public class a extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f4182a;
        public TextView b;
        public TextView c;
        public String d;
        public List<String> e;
        public TextView f;
        public TextView g;
        public String h;
        public RelativeLayout i;
        public LinearLayout j;
        public TextView k;
        public CardView l;

        /* renamed from: zj0$a$a  reason: collision with other inner class name */
        /* compiled from: ProductAdapter */
        public class View$OnClickListenerC0071a implements View.OnClickListener {
            public View$OnClickListenerC0071a(zj0 zj0) {
            }

            public void onClick(View view) {
                Intent intent;
                a aVar = a.this;
                zj0 zj0 = zj0.this;
                String str = aVar.h;
                Objects.requireNonNull(zj0);
                zz zzVar = new zz("product hook product selection screen clicked", new HashMap());
                zzVar.a("product type", str);
                ui1.l0(zzVar);
                if (a.this.h.equals(SuperPassConstants.PRODUCT_TYPE_SUPER_PASS)) {
                    a aVar2 = a.this;
                    PassSelectionActivity.t0(zj0.this.f4181a, aVar2.d, "ProductSelectionActivity");
                }
                if (a.this.h.equals("routePass") || a.this.h.contains("rpPass")) {
                    ((ProductSelectionActivity) zj0.this.f4181a).w0();
                    a aVar3 = a.this;
                    ((ProductSelectionActivity) zj0.this.f4181a).r = aVar3.d;
                    xt.f3961a.c().c();
                    return;
                }
                if (a.this.h.equals("magicPass") || a.this.h.contains("pass")) {
                    intent = new Intent(zj0.this.f4181a, CategorySelectionActivity.class);
                    intent.putExtra("src", "magicPass");
                    intent.putExtra("productId", a.this.d);
                    intent.putStringArrayListExtra("productIds", (ArrayList) a.this.e);
                } else if (a.this.h.equals("singleJourneyTicket") || a.this.h.contains("sjPass")) {
                    intent = new Intent(zj0.this.f4181a, MTicketTripInfoActivity.class);
                    intent.putExtra("src", "singleJourneyTicket");
                    intent.putExtra("productId", a.this.d);
                } else if (a.this.h.equals("scanPay")) {
                    intent = new Intent(zj0.this.f4181a, ScanPayBaseActivity.class);
                    intent.putExtra("src", "scanPay");
                    intent.putExtra("productId", a.this.d);
                } else if (a.this.h.equals("superSaver")) {
                    intent = new Intent(zj0.this.f4181a, CategorySelectionActivity.class);
                    intent.putExtra("src", "superSaver");
                    intent.putExtra("productId", a.this.d);
                } else {
                    intent = null;
                }
                if (intent != null) {
                    intent.putExtra("source", zj0.this.b);
                    zj0.this.f4181a.startActivity(intent);
                }
            }
        }

        public a(View view) {
            super(view);
            this.f4182a = (ImageView) view.findViewById(R.id.product_logo);
            this.b = (TextView) view.findViewById(R.id.product_title);
            this.c = (TextView) view.findViewById(R.id.product_subtitle);
            this.g = (TextView) view.findViewById(R.id.label);
            this.f = (TextView) view.findViewById(R.id.product_add_info);
            this.i = (RelativeLayout) view.findViewById(R.id.content_layout);
            this.l = (CardView) view.findViewById(R.id.product_card_view);
            this.j = (LinearLayout) view.findViewById(R.id.product_selection_disabled_banner);
            this.k = (TextView) view.findViewById(R.id.product_disabled_card_banner_text);
            this.l.setOnClickListener(new View$OnClickListenerC0071a(zj0.this));
        }
    }

    public zj0(Set<ProductInfo> set, boolean z, Context context, String str) {
        this.c = set;
        this.f4181a = context;
        this.b = str;
        this.d = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return this.c.size();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$a0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(a aVar, int i) {
        a aVar2 = aVar;
        Iterator<ProductInfo> it = this.c.iterator();
        ProductInfo productInfo = null;
        int i2 = 0;
        while (it.hasNext()) {
            productInfo = it.next();
            if (i2 == i) {
                break;
            }
            i2++;
        }
        if (productInfo.q != 0) {
            aVar2.f4182a.setImageDrawable(this.f4181a.getResources().getDrawable(productInfo.q));
            aVar2.f4182a.setVisibility(0);
        } else {
            String str = productInfo.k;
            ImageView imageView = aVar2.f4182a;
            if (TextUtils.isEmpty(str)) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
            }
            ml1<Bitmap> j = gl1.f(this.f4181a).j();
            j.n = new yj0(this, imageView);
            j.m = str;
            j.p = true;
            j.e(imageView);
        }
        aVar2.h = productInfo.n;
        aVar2.b.setText(productInfo.f);
        aVar2.c.setText(productInfo.g);
        aVar2.c.setVisibility(TextUtils.isEmpty(productInfo.g) ? 8 : 0);
        String str2 = productInfo.l;
        String str3 = productInfo.j;
        aVar2.g.setVisibility(TextUtils.isEmpty(str2) ? 8 : 0);
        aVar2.f.setVisibility(TextUtils.isEmpty(str3) ? 8 : 0);
        new SpannableStringBuilder();
        aVar2.g.setText(str2);
        aVar2.f.setText(productInfo.j);
        aVar2.d = productInfo.i;
        aVar2.e = productInfo.p;
        if (this.d) {
            aVar2.i.setAlpha(0.4f);
            aVar2.g.setAlpha(0.4f);
            aVar2.l.setClickable(false);
            aVar2.j.setVisibility(8);
        } else if (!productInfo.r) {
            aVar2.i.setAlpha(0.4f);
            aVar2.l.setClickable(false);
            aVar2.g.setAlpha(0.4f);
            aVar2.j.setVisibility(0);
            String str4 = productInfo.s;
            if (str4 != null) {
                aVar2.k.setText(str4);
            }
        } else {
            aVar2.j.setVisibility(8);
        }
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$a0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_item_type, viewGroup, false);
        CardView cardView = (CardView) inflate.findViewById(R.id.product_card_view);
        return new a(inflate);
    }
}
