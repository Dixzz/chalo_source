package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.ProductDuration;
import app.zophop.models.mTicketing.ProductFareMapping;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;

/* renamed from: pu  reason: default package */
/* compiled from: DurationAdapter */
public class pu extends RecyclerView.e<a> {

    /* renamed from: a  reason: collision with root package name */
    public final List<ProductFareMapping> f2849a;
    public final Context b;
    public int c = -1;
    public boolean d;

    /* renamed from: pu$a */
    /* compiled from: DurationAdapter */
    public class a extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final RadioButton f2850a;
        public final TextView b;
        public final TextView c;
        public final TextView d;
        public final TextView e;
        public final TextView f;
        public final View g;
        public final LinearLayout h;
        public final ConstraintLayout i;
        public TextView j;
        public long k;
        public List<String> l;
        public String m;
        public int n;
        public int o;

        public a(View view) {
            super(view);
            this.g = view;
            RadioButton radioButton = (RadioButton) view.findViewById(R.id.duration_button);
            this.f2850a = radioButton;
            this.b = (TextView) view.findViewById(R.id.fare);
            this.c = (TextView) view.findViewById(R.id.discounted_fare);
            this.d = (TextView) view.findViewById(R.id.additional_info);
            this.e = (TextView) view.findViewById(R.id.duration_info);
            this.f = (TextView) view.findViewById(R.id.desc);
            this.i = (ConstraintLayout) view.findViewById(R.id.pass_layout_content);
            this.h = (LinearLayout) view.findViewById(R.id.pass_duration_item_disabled_banner);
            this.j = (TextView) view.findViewById(R.id.product_disabled_textview);
            radioButton.setOnClickListener(new ou(this));
            view.setOnClickListener(new ou(this));
        }
    }

    public pu(List<ProductFareMapping> list, boolean z, Context context) {
        this.f2849a = list;
        this.b = context;
        this.d = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return this.f2849a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public long getItemId(int i) {
        return (long) i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemViewType(int i) {
        return i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$a0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(a aVar, int i) {
        a aVar2 = aVar;
        ProductDuration productDuration = this.f2849a.get(i).getProductDuration();
        if (productDuration != null) {
            String productDisplayName = !TextUtils.isEmpty(this.f2849a.get(i).getProductDisplayName()) ? this.f2849a.get(i).getProductDisplayName() : productDuration.getValidityName();
            RadioButton radioButton = aVar2.f2850a;
            radioButton.setText(" " + productDisplayName);
        }
        aVar2.k = this.f2849a.get(i).getDurationId();
        aVar2.n = this.f2849a.get(i).getMaxRides();
        aVar2.o = this.f2849a.get(i).getMaxRidesPerDay();
        if (((double) this.f2849a.get(i).getDiscountFare()) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || ((double) this.f2849a.get(i).getDiscountFare()) == -1.0d || this.f2849a.get(i).getDiscountFare() == this.f2849a.get(i).getFare()) {
            aVar2.c.setVisibility(8);
            TextView textView = aVar2.b;
            textView.setText(ui1.H() + this.f2849a.get(i).getFare());
        } else {
            TextView textView2 = aVar2.b;
            textView2.setText(ui1.H() + this.f2849a.get(i).getDiscountFare());
            TextView textView3 = aVar2.c;
            textView3.setPaintFlags(textView3.getPaintFlags() | 16);
            TextView textView4 = aVar2.c;
            textView4.setText(ui1.H() + this.f2849a.get(i).getFare());
            aVar2.c.setVisibility(0);
        }
        aVar2.d.setText(this.f2849a.get(i).getAdditionalInfo());
        if (this.f2849a.get(i).getSpecialFeatures() != null) {
            ArrayList arrayList = new ArrayList();
            aVar2.l = arrayList;
            arrayList.addAll(this.f2849a.get(i).getSpecialFeatures());
        }
        aVar2.f2850a.setChecked(this.c == i);
        aVar2.e.setText(this.f2849a.get(i).getDurationInfo());
        aVar2.e.setVisibility(TextUtils.isEmpty(this.f2849a.get(i).getDurationInfo()) ? 8 : 0);
        aVar2.f.setText(this.f2849a.get(i).getDesc());
        aVar2.f.setVisibility(TextUtils.isEmpty(this.f2849a.get(i).getDesc()) ? 8 : 0);
        aVar2.m = this.f2849a.get(i).getProductDisplayName();
        aVar2.d.setVisibility(TextUtils.isEmpty(this.f2849a.get(i).getAdditionalInfo()) ? 8 : 0);
        if (this.f2849a.get(i).getSpecialFeatures() != null) {
            aVar2.f2850a.append(ui1.J(this.b, this.f2849a.get(i).getSpecialFeatures()));
        }
        if (this.d) {
            aVar2.i.setAlpha(0.4f);
            aVar2.g.setClickable(false);
            aVar2.f2850a.setClickable(false);
            aVar2.h.setVisibility(8);
        } else if (productDuration != null && !productDuration.getIsActive()) {
            aVar2.i.setAlpha(0.4f);
            aVar2.g.setClickable(false);
            aVar2.f2850a.setClickable(false);
            aVar2.h.setVisibility(0);
            if (!TextUtils.isEmpty(productDuration.getInactiveReason())) {
                aVar2.j.setText(productDuration.getInactiveReason());
            }
        } else if (!this.f2849a.get(i).getLegacyIsActive().booleanValue()) {
            aVar2.i.setAlpha(0.4f);
            aVar2.g.setClickable(false);
            aVar2.f2850a.setClickable(false);
            aVar2.h.setVisibility(0);
            String inactiveReason = this.f2849a.get(i).getInactiveReason();
            if (!TextUtils.isEmpty(inactiveReason)) {
                aVar2.j.setText(inactiveReason);
            }
        } else {
            aVar2.i.setAlpha(1.0f);
            aVar2.h.setVisibility(8);
            aVar2.j.setVisibility(8);
        }
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$a0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.b).inflate(R.layout.pass_duration_item, viewGroup, false));
    }
}
