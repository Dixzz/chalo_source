package defpackage;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import app.zophop.R;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.FareInfo;
import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.models.mTicketing.ProductSubCategory;
import com.google.android.material.textview.MaterialTextView;
import com.razorpay.AnalyticsConstants;
import java.util.Objects;

/* renamed from: lt0  reason: default package */
/* compiled from: BottomSheetPassSelectionConfirmation.kt */
public final class lt0 extends pl0<nw> {
    public static final /* synthetic */ int i = 0;
    public final j56 h = h.B(this, z86.a(ca1.class), new a(this), new b(this));

    /* renamed from: lt0$a */
    /* compiled from: FragmentViewModelLazy.kt */
    public static final class a extends o86 implements h76<gi> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Fragment fragment) {
            super(0);
            this.f = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public gi invoke() {
            return hj1.j(this.f, "requireActivity()", "requireActivity().viewModelStore");
        }
    }

    /* renamed from: lt0$b */
    /* compiled from: FragmentViewModelLazy.kt */
    public static final class b extends o86 implements h76<ci> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.f = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            ve requireActivity = this.f.requireActivity();
            n86.d(requireActivity, "requireActivity()");
            return requireActivity.getDefaultViewModelProviderFactory();
        }
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.pl0
    public nw d(LayoutInflater layoutInflater) {
        n86.e(layoutInflater, "lInflater");
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_pass_selection_confirmation, (ViewGroup) null, false);
        int i2 = R.id.btn_proceed;
        MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.btn_proceed);
        if (materialTextView != null) {
            i2 = R.id.discount;
            MaterialTextView materialTextView2 = (MaterialTextView) inflate.findViewById(R.id.discount);
            if (materialTextView2 != null) {
                i2 = R.id.discount_amount_text;
                MaterialTextView materialTextView3 = (MaterialTextView) inflate.findViewById(R.id.discount_amount_text);
                if (materialTextView3 != null) {
                    i2 = R.id.discount_layout_group;
                    Group group = (Group) inflate.findViewById(R.id.discount_layout_group);
                    if (group != null) {
                        i2 = R.id.fare_text;
                        MaterialTextView materialTextView4 = (MaterialTextView) inflate.findViewById(R.id.fare_text);
                        if (materialTextView4 != null) {
                            i2 = R.id.guideline_left;
                            Guideline guideline = (Guideline) inflate.findViewById(R.id.guideline_left);
                            if (guideline != null) {
                                i2 = R.id.guideline_right;
                                Guideline guideline2 = (Guideline) inflate.findViewById(R.id.guideline_right);
                                if (guideline2 != null) {
                                    i2 = R.id.plan_details;
                                    MaterialTextView materialTextView5 = (MaterialTextView) inflate.findViewById(R.id.plan_details);
                                    if (materialTextView5 != null) {
                                        i2 = R.id.product_name_text;
                                        MaterialTextView materialTextView6 = (MaterialTextView) inflate.findViewById(R.id.product_name_text);
                                        if (materialTextView6 != null) {
                                            i2 = R.id.strike_through_text;
                                            MaterialTextView materialTextView7 = (MaterialTextView) inflate.findViewById(R.id.strike_through_text);
                                            if (materialTextView7 != null) {
                                                i2 = R.id.sub_category_additional_info;
                                                MaterialTextView materialTextView8 = (MaterialTextView) inflate.findViewById(R.id.sub_category_additional_info);
                                                if (materialTextView8 != null) {
                                                    i2 = R.id.sub_category_info_text;
                                                    MaterialTextView materialTextView9 = (MaterialTextView) inflate.findViewById(R.id.sub_category_info_text);
                                                    if (materialTextView9 != null) {
                                                        i2 = R.id.supporting_text;
                                                        MaterialTextView materialTextView10 = (MaterialTextView) inflate.findViewById(R.id.supporting_text);
                                                        if (materialTextView10 != null) {
                                                            i2 = R.id.total_amount;
                                                            MaterialTextView materialTextView11 = (MaterialTextView) inflate.findViewById(R.id.total_amount);
                                                            if (materialTextView11 != null) {
                                                                nw nwVar = new nw((ConstraintLayout) inflate, materialTextView, materialTextView2, materialTextView3, group, materialTextView4, guideline, guideline2, materialTextView5, materialTextView6, materialTextView7, materialTextView8, materialTextView9, materialTextView10, materialTextView11);
                                                                n86.d(nwVar, "inflate(lInflater)");
                                                                return nwVar;
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // defpackage.pl0
    public void e() {
        ProductFareMapping selectedProductFareMapping;
        FareInfo fareInfo;
        BookableSuperPassConfiguration f = ((ca1) this.h.getValue()).f();
        int i2 = 0;
        if (f != null) {
            T t = this.f;
            n86.c(t);
            ((nw) t).f.setText(f.getSuperPassProductConfigurationProperties().getProductName());
            T t2 = this.f;
            n86.c(t2);
            MaterialTextView materialTextView = ((nw) t2).j;
            n86.d(materialTextView, "viewBinding.supportingText");
            String desc = f.getSelectedProductFareMapping().getDesc();
            materialTextView.setVisibility((desc == null || desc.length() == 0) ^ true ? 0 : 8);
            T t3 = this.f;
            n86.c(t3);
            MaterialTextView materialTextView2 = ((nw) t3).i;
            n86.d(materialTextView2, "viewBinding.subCategoryInfoText");
            ProductSubCategory selectedSubCategory = f.getSelectedSubCategory();
            String str = null;
            String infoNote = selectedSubCategory == null ? null : selectedSubCategory.getInfoNote();
            materialTextView2.setVisibility((infoNote == null || infoNote.length() == 0) ^ true ? 0 : 8);
            T t4 = this.f;
            n86.c(t4);
            MaterialTextView materialTextView3 = ((nw) t4).h;
            n86.d(materialTextView3, "viewBinding.subCategoryAdditionalInfo");
            ProductSubCategory selectedSubCategory2 = f.getSelectedSubCategory();
            String additionalInfo = selectedSubCategory2 == null ? null : selectedSubCategory2.getAdditionalInfo();
            materialTextView3.setVisibility((additionalInfo == null || additionalInfo.length() == 0) ^ true ? 0 : 8);
            T t5 = this.f;
            n86.c(t5);
            ((nw) t5).j.setText(f.getSelectedProductFareMapping().getDesc());
            T t6 = this.f;
            n86.c(t6);
            MaterialTextView materialTextView4 = ((nw) t6).i;
            ProductSubCategory selectedSubCategory3 = f.getSelectedSubCategory();
            materialTextView4.setText(selectedSubCategory3 == null ? null : selectedSubCategory3.getInfoNote());
            T t7 = this.f;
            n86.c(t7);
            MaterialTextView materialTextView5 = ((nw) t7).h;
            ProductSubCategory selectedSubCategory4 = f.getSelectedSubCategory();
            if (selectedSubCategory4 != null) {
                str = selectedSubCategory4.getAdditionalInfo();
            }
            materialTextView5.setText(str);
        }
        BookableSuperPassConfiguration f2 = ((ca1) this.h.getValue()).f();
        if (!(f2 == null || (selectedProductFareMapping = f2.getSelectedProductFareMapping()) == null || (fareInfo = selectedProductFareMapping.getFareInfo()) == null)) {
            T t8 = this.f;
            n86.c(t8);
            Group group = ((nw) t8).d;
            n86.d(group, "viewBinding.discountLayoutGroup");
            if (!fareInfo.isDiscountApplicable()) {
                i2 = 8;
            }
            group.setVisibility(i2);
            if (fareInfo.isDiscountApplicable()) {
                T t9 = this.f;
                n86.c(t9);
                MaterialTextView materialTextView6 = ((nw) t9).c;
                StringBuilder i0 = hj1.i0("- ");
                i0.append((Object) ui1.H());
                i0.append(fareInfo.getDiscountAmountString());
                materialTextView6.setText(i0.toString());
                T t10 = this.f;
                n86.c(t10);
                MaterialTextView materialTextView7 = ((nw) t10).g;
                T t11 = this.f;
                n86.c(t11);
                materialTextView7.setPaintFlags(((nw) t11).g.getPaintFlags() | 16);
                T t12 = this.f;
                n86.c(t12);
                ((nw) t12).g.setText(n86.j(ui1.H(), fareInfo.getActualFareString()));
                T t13 = this.f;
                n86.c(t13);
                ((nw) t13).e.setText(n86.j(ui1.H(), fareInfo.getDiscountedFareString()));
            } else {
                T t14 = this.f;
                n86.c(t14);
                MaterialTextView materialTextView8 = ((nw) t14).g;
                n86.d(materialTextView8, "viewBinding.strikeThroughText");
                materialTextView8.setVisibility(8);
                T t15 = this.f;
                n86.c(t15);
                ((nw) t15).e.setText(n86.j(ui1.H(), fareInfo.getActualFareString()));
                T t16 = this.f;
                n86.c(t16);
                MaterialTextView materialTextView9 = ((nw) t16).k;
                n86.d(materialTextView9, "viewBinding.totalAmount");
                Float valueOf = Float.valueOf(18.0f);
                n86.e(materialTextView9, "<this>");
                if (materialTextView9.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.LayoutParams layoutParams = materialTextView9.getLayoutParams();
                    Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (valueOf != null) {
                        float floatValue = valueOf.floatValue();
                        Context context = materialTextView9.getContext();
                        n86.d(context, AnalyticsConstants.CONTEXT);
                        marginLayoutParams.topMargin = (int) TypedValue.applyDimension(1, floatValue, context.getResources().getDisplayMetrics());
                    }
                }
            }
        }
        T t17 = this.f;
        n86.c(t17);
        ((nw) t17).b.setOnClickListener(new ko0(this));
    }

    @Override // defpackage.pl0
    public void f() {
    }
}
