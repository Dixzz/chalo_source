package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.FareInfo;
import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.models.mTicketing.ProductSubCategory;
import com.razorpay.AnalyticsConstants;
import java.util.List;

/* renamed from: lu  reason: default package */
/* compiled from: BookableConfigAdapter.kt */
public final class lu extends RecyclerView.e<b> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2270a;
    public final List<BookableSuperPassConfiguration> b;
    public final a c;
    public final boolean d;
    public Integer e;

    /* renamed from: lu$a */
    /* compiled from: BookableConfigAdapter.kt */
    public interface a {
        void a(int i);
    }

    /* renamed from: lu$b */
    /* compiled from: BookableConfigAdapter.kt */
    public final class b extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final mw f2271a;
        public final a b;
        public final /* synthetic */ lu c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(lu luVar, mw mwVar, a aVar) {
            super(mwVar.f2450a);
            n86.e(luVar, "this$0");
            n86.e(mwVar, "itemBinding");
            n86.e(aVar, "bookableItemClickListener");
            this.c = luVar;
            this.f2271a = mwVar;
            this.b = aVar;
        }
    }

    public lu(Context context, List<BookableSuperPassConfiguration> list, a aVar, boolean z) {
        n86.e(context, AnalyticsConstants.CONTEXT);
        n86.e(list, "bookablePassConfigurationList");
        n86.e(aVar, "bookableItemClickListener");
        this.f2270a = context;
        this.b = list;
        this.c = aVar;
        this.d = z;
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
        BookableSuperPassConfiguration bookableSuperPassConfiguration = this.b.get(i);
        n86.e(bookableSuperPassConfiguration, "bookablePassConfiguration");
        ProductFareMapping selectedProductFareMapping = bookableSuperPassConfiguration.getSelectedProductFareMapping();
        String productDisplayName = !TextUtils.isEmpty(selectedProductFareMapping.getProductDisplayName()) ? selectedProductFareMapping.getProductDisplayName() : "";
        bVar2.f2271a.f2450a.setOnClickListener(new cu(bVar2.c, selectedProductFareMapping, bVar2));
        bVar2.f2271a.e.setOnClickListener(new du(bVar2.c, selectedProductFareMapping, bVar2));
        bVar2.f2271a.e.setText(n86.j(" ", productDisplayName));
        FareInfo fareInfo = selectedProductFareMapping.getFareInfo();
        boolean z = false;
        if (fareInfo.isDiscountApplicable()) {
            bVar2.f2271a.g.setText(n86.j(ui1.H(), fareInfo.getDiscountedFareString()));
            TextView textView = bVar2.f2271a.d;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
            bVar2.f2271a.d.setText(n86.j(ui1.H(), fareInfo.getActualFareString()));
            bVar2.f2271a.d.setVisibility(0);
        } else {
            bVar2.f2271a.d.setVisibility(8);
            bVar2.f2271a.g.setText(n86.j(ui1.H(), fareInfo.getActualFareString()));
        }
        if (!TextUtils.isEmpty(selectedProductFareMapping.getDurationInfo())) {
            bVar2.f2271a.f.setText(selectedProductFareMapping.getDurationInfo());
            bVar2.f2271a.f.setVisibility(0);
        } else {
            bVar2.f2271a.f.setVisibility(8);
        }
        if (!TextUtils.isEmpty(selectedProductFareMapping.getDesc())) {
            bVar2.f2271a.c.setText(selectedProductFareMapping.getDesc());
            bVar2.f2271a.c.setVisibility(0);
        } else {
            bVar2.f2271a.c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(selectedProductFareMapping.getAdditionalInfo())) {
            bVar2.f2271a.b.setText(selectedProductFareMapping.getAdditionalInfo());
            bVar2.f2271a.b.setVisibility(0);
        } else {
            bVar2.f2271a.b.setVisibility(8);
        }
        ProductSubCategory selectedSubCategory = bookableSuperPassConfiguration.getSelectedSubCategory();
        if (!(selectedSubCategory != null && selectedSubCategory.getShouldHideSpecialFeatureTags())) {
            bVar2.f2271a.e.append(f71.f1097a.d(bVar2.c.f2270a, selectedProductFareMapping.getSpecialFeatures()));
        }
        if (bVar2.c.d) {
            bVar2.f2271a.i.setAlpha(0.4f);
            bVar2.f2271a.f2450a.setClickable(false);
            bVar2.f2271a.e.setClickable(false);
            bVar2.f2271a.h.setVisibility(8);
        } else if (selectedProductFareMapping.getIsActive() == null || selectedProductFareMapping.getIsActive().booleanValue()) {
            bVar2.f2271a.i.setAlpha(1.0f);
            bVar2.f2271a.h.setVisibility(8);
            bVar2.f2271a.j.setVisibility(8);
            RadioButton radioButton = bVar2.f2271a.e;
            Integer num = bVar2.c.e;
            int fareMappingId = selectedProductFareMapping.getFareMappingId();
            if (num != null && num.intValue() == fareMappingId) {
                z = true;
            }
            radioButton.setChecked(z);
        } else {
            bVar2.f2271a.i.setAlpha(0.4f);
            bVar2.f2271a.f2450a.setClickable(false);
            bVar2.f2271a.e.setClickable(false);
            bVar2.f2271a.h.setVisibility(0);
            if (!TextUtils.isEmpty(selectedProductFareMapping.getInactiveReason())) {
                bVar2.f2271a.j.setText(selectedProductFareMapping.getInactiveReason());
            }
        }
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$a0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        n86.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bookable_pass_config_item, viewGroup, false);
        int i2 = R.id.additional_info;
        TextView textView = (TextView) inflate.findViewById(R.id.additional_info);
        if (textView != null) {
            i2 = R.id.alertIcon;
            ImageView imageView = (ImageView) inflate.findViewById(R.id.alertIcon);
            if (imageView != null) {
                i2 = R.id.desc;
                TextView textView2 = (TextView) inflate.findViewById(R.id.desc);
                if (textView2 != null) {
                    i2 = R.id.discounted_fare;
                    TextView textView3 = (TextView) inflate.findViewById(R.id.discounted_fare);
                    if (textView3 != null) {
                        i2 = R.id.duration_button;
                        RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.duration_button);
                        if (radioButton != null) {
                            i2 = R.id.duration_info;
                            TextView textView4 = (TextView) inflate.findViewById(R.id.duration_info);
                            if (textView4 != null) {
                                i2 = R.id.fare;
                                TextView textView5 = (TextView) inflate.findViewById(R.id.fare);
                                if (textView5 != null) {
                                    i2 = R.id.pass_duration_item_disabled_banner;
                                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.pass_duration_item_disabled_banner);
                                    if (linearLayout != null) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                                        i2 = R.id.pass_layout_content;
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate.findViewById(R.id.pass_layout_content);
                                        if (constraintLayout2 != null) {
                                            i2 = R.id.product_disabled_textview;
                                            TextView textView6 = (TextView) inflate.findViewById(R.id.product_disabled_textview);
                                            if (textView6 != null) {
                                                i2 = R.id.trip_details_disruption_cta;
                                                TextView textView7 = (TextView) inflate.findViewById(R.id.trip_details_disruption_cta);
                                                if (textView7 != null) {
                                                    mw mwVar = new mw(constraintLayout, textView, imageView, textView2, textView3, radioButton, textView4, textView5, linearLayout, constraintLayout, constraintLayout2, textView6, textView7);
                                                    n86.d(mwVar, "inflate(LayoutInflater.f….context), parent, false)");
                                                    return new b(this, mwVar, this.c);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }
}
