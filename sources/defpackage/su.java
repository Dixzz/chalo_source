package defpackage;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.ProfileRejectionReason;
import app.zophop.ui.views.OrderedTextList;
import app.zophop.ui.views.ZophopFormInput;
import com.google.android.material.textview.MaterialTextView;
import java.util.List;

/* renamed from: su  reason: default package */
/* compiled from: UserProofsHeaderAdapter.kt */
public final class su extends RecyclerView.e<b> {

    /* renamed from: a  reason: collision with root package name */
    public final ve f3256a;
    public final boolean b;
    public final boolean c;
    public final List<String> d;
    public final ProfileRejectionReason e;
    public final String f;
    public final a g;

    /* renamed from: su$a */
    /* compiled from: UserProofsHeaderAdapter.kt */
    public interface a {
        void a(String str);
    }

    /* renamed from: su$b */
    /* compiled from: UserProofsHeaderAdapter.kt */
    public final class b extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final vx f3257a;
        public final /* synthetic */ su b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(su suVar, vx vxVar) {
            super(vxVar.f3688a);
            n86.e(suVar, "this$0");
            n86.e(vxVar, "lItemBinding");
            this.b = suVar;
            this.f3257a = vxVar;
        }
    }

    public su(ve veVar, boolean z, boolean z2, List<String> list, ProfileRejectionReason profileRejectionReason, String str, a aVar) {
        this.f3256a = veVar;
        this.b = z;
        this.c = z2;
        this.d = list;
        this.e = profileRejectionReason;
        this.f = str;
        this.g = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return 1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$a0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(b bVar, int i) {
        boolean z;
        Resources resources;
        Resources resources2;
        Resources resources3;
        Resources resources4;
        Resources resources5;
        Resources resources6;
        Resources resources7;
        Resources resources8;
        b bVar2 = bVar;
        n86.e(bVar2, "holder");
        su suVar = bVar2.b;
        String str = null;
        if (suVar.b) {
            MaterialTextView materialTextView = bVar2.f3257a.h;
            ve veVar = suVar.f3256a;
            materialTextView.setText((veVar == null || (resources8 = veVar.getResources()) == null) ? null : resources8.getString(R.string.proofs_overview_fragment_subtitle));
        } else {
            MaterialTextView materialTextView2 = bVar2.f3257a.h;
            ve veVar2 = suVar.f3256a;
            materialTextView2.setText((veVar2 == null || (resources7 = veVar2.getResources()) == null) ? null : resources7.getString(R.string.proofs_overview_fragment_subtitle_no_verification));
        }
        su suVar2 = bVar2.b;
        if (suVar2.c) {
            vx vxVar = bVar2.f3257a;
            MaterialTextView materialTextView3 = vxVar.i;
            ve veVar3 = suVar2.f3256a;
            materialTextView3.setText((veVar3 == null || (resources6 = veVar3.getResources()) == null) ? null : resources6.getString(R.string.proofs_rejected_title));
            MaterialTextView materialTextView4 = vxVar.h;
            ve veVar4 = suVar2.f3256a;
            materialTextView4.setText((veVar4 == null || (resources5 = veVar4.getResources()) == null) ? null : resources5.getString(R.string.proofs_rejected_subtitle));
        }
        List<String> list = bVar2.b.d;
        if (list == null || list.isEmpty()) {
            LinearLayout linearLayout = bVar2.f3257a.d;
            n86.d(linearLayout, "lItemBinding.generalRejectionReasonsLayout");
            linearLayout.setVisibility(8);
            z = false;
        } else {
            vx vxVar2 = bVar2.f3257a;
            su suVar3 = bVar2.b;
            MaterialTextView materialTextView5 = vxVar2.i;
            ve veVar5 = suVar3.f3256a;
            materialTextView5.setText((veVar5 == null || (resources4 = veVar5.getResources()) == null) ? null : resources4.getString(R.string.proofs_rejected_title));
            MaterialTextView materialTextView6 = vxVar2.h;
            ve veVar6 = suVar3.f3256a;
            materialTextView6.setText((veVar6 == null || (resources3 = veVar6.getResources()) == null) ? null : resources3.getString(R.string.proofs_rejected_subtitle));
            Group group = vxVar2.l;
            n86.d(group, "userNameRejectionGroup");
            group.setVisibility(8);
            LinearLayout linearLayout2 = vxVar2.d;
            n86.d(linearLayout2, "generalRejectionReasonsLayout");
            linearLayout2.setVisibility(0);
            if (suVar3.d.size() == 1) {
                OrderedTextList orderedTextList = vxVar2.e;
                n86.d(orderedTextList, "generalRejectionReasonsListView");
                orderedTextList.setVisibility(8);
                TextView textView = vxVar2.j;
                n86.d(textView, "singleGeneralRejectionReasonText");
                textView.setVisibility(0);
                vxVar2.j.setText(suVar3.d.get(0));
            } else {
                OrderedTextList orderedTextList2 = vxVar2.e;
                n86.d(orderedTextList2, "generalRejectionReasonsListView");
                orderedTextList2.setVisibility(0);
                TextView textView2 = vxVar2.j;
                n86.d(textView2, "singleGeneralRejectionReasonText");
                textView2.setVisibility(8);
                vxVar2.e.setShowBracketAfterNumber(true);
                vxVar2.e.b(suVar3.d, R.layout.numbered_text_list_layout);
            }
            z = true;
        }
        if (!z) {
            ProfileRejectionReason profileRejectionReason = bVar2.b.e;
            if (profileRejectionReason != null) {
                List<String> reasonsList = profileRejectionReason.getReasonsList();
                if (!(reasonsList == null || reasonsList.isEmpty())) {
                    vx vxVar3 = bVar2.f3257a;
                    su suVar4 = bVar2.b;
                    MaterialTextView materialTextView7 = vxVar3.i;
                    ve veVar7 = suVar4.f3256a;
                    materialTextView7.setText((veVar7 == null || (resources2 = veVar7.getResources()) == null) ? null : resources2.getString(R.string.proofs_rejected_title));
                    MaterialTextView materialTextView8 = vxVar3.h;
                    ve veVar8 = suVar4.f3256a;
                    if (!(veVar8 == null || (resources = veVar8.getResources()) == null)) {
                        str = resources.getString(R.string.proofs_rejected_subtitle);
                    }
                    materialTextView8.setText(str);
                    ZophopFormInput zophopFormInput = vxVar3.c;
                    n86.d(zophopFormInput, "formFullName");
                    zophopFormInput.setVisibility(0);
                    LinearLayout linearLayout3 = vxVar3.f;
                    n86.d(linearLayout3, "profileRejectionReasonsLayout");
                    List<String> reasonsList2 = suVar4.e.getReasonsList();
                    linearLayout3.setVisibility((reasonsList2 == null || reasonsList2.isEmpty()) ^ true ? 0 : 8);
                    View view = vxVar3.b;
                    n86.d(view, "bottomPadding");
                    view.setVisibility(suVar4.c ^ true ? 0 : 8);
                    vxVar3.c.setText(suVar4.f);
                    ZophopFormInput zophopFormInput2 = vxVar3.c;
                    zophopFormInput2.setEditable(true);
                    EditText editText = zophopFormInput2.getEditText();
                    n86.d(editText, "editText");
                    editText.addTextChangedListener(new tu(suVar4, zophopFormInput2));
                    if (suVar4.e.getReasonsList().size() == 1) {
                        OrderedTextList orderedTextList3 = vxVar3.g;
                        n86.d(orderedTextList3, "profileRejectionReasonsListView");
                        orderedTextList3.setVisibility(8);
                        TextView textView3 = vxVar3.k;
                        n86.d(textView3, "singleProfileRejectionReasonsText");
                        textView3.setVisibility(0);
                        vxVar3.k.setText(suVar4.e.getReasonsList().get(0));
                        return;
                    }
                    OrderedTextList orderedTextList4 = vxVar3.g;
                    n86.d(orderedTextList4, "profileRejectionReasonsListView");
                    orderedTextList4.setVisibility(0);
                    TextView textView4 = vxVar3.k;
                    n86.d(textView4, "singleProfileRejectionReasonsText");
                    textView4.setVisibility(8);
                    vxVar3.g.setShowDotAfterNumber(true);
                    vxVar3.g.b(suVar4.e.getReasonsList(), R.layout.numbered_text_list_layout);
                    return;
                }
            }
            Group group2 = bVar2.f3257a.l;
            n86.d(group2, "lItemBinding.userNameRejectionGroup");
            group2.setVisibility(8);
        }
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$a0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        n86.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_user_proofs_overview, viewGroup, false);
        int i2 = R.id.bottom_padding;
        View findViewById = inflate.findViewById(R.id.bottom_padding);
        if (findViewById != null) {
            i2 = R.id.form_full_name;
            ZophopFormInput zophopFormInput = (ZophopFormInput) inflate.findViewById(R.id.form_full_name);
            if (zophopFormInput != null) {
                i2 = R.id.general_rejection_reasons_layout;
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.general_rejection_reasons_layout);
                if (linearLayout != null) {
                    i2 = R.id.general_rejection_reasons_list_view;
                    OrderedTextList orderedTextList = (OrderedTextList) inflate.findViewById(R.id.general_rejection_reasons_list_view);
                    if (orderedTextList != null) {
                        i2 = R.id.profile_rejection_reasons_layout;
                        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.profile_rejection_reasons_layout);
                        if (linearLayout2 != null) {
                            i2 = R.id.profile_rejection_reasons_list_view;
                            OrderedTextList orderedTextList2 = (OrderedTextList) inflate.findViewById(R.id.profile_rejection_reasons_list_view);
                            if (orderedTextList2 != null) {
                                i2 = R.id.proofs_overview_subtitle;
                                MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.proofs_overview_subtitle);
                                if (materialTextView != null) {
                                    i2 = R.id.proofs_overview_title;
                                    MaterialTextView materialTextView2 = (MaterialTextView) inflate.findViewById(R.id.proofs_overview_title);
                                    if (materialTextView2 != null) {
                                        i2 = R.id.single_general_rejection_reason_text;
                                        TextView textView = (TextView) inflate.findViewById(R.id.single_general_rejection_reason_text);
                                        if (textView != null) {
                                            i2 = R.id.single_profile_rejection_reasons_text;
                                            TextView textView2 = (TextView) inflate.findViewById(R.id.single_profile_rejection_reasons_text);
                                            if (textView2 != null) {
                                                i2 = R.id.user_name_rejection;
                                                MaterialTextView materialTextView3 = (MaterialTextView) inflate.findViewById(R.id.user_name_rejection);
                                                if (materialTextView3 != null) {
                                                    i2 = R.id.user_name_rejection_group;
                                                    Group group = (Group) inflate.findViewById(R.id.user_name_rejection_group);
                                                    if (group != null) {
                                                        vx vxVar = new vx((ConstraintLayout) inflate, findViewById, zophopFormInput, linearLayout, orderedTextList, linearLayout2, orderedTextList2, materialTextView, materialTextView2, textView, textView2, materialTextView3, group);
                                                        n86.d(vxVar, "inflate(LayoutInflater.f….context), parent, false)");
                                                        return new b(this, vxVar);
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
}
