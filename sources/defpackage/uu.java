package defpackage;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.ProofDocumentProps;
import app.zophop.models.mTicketing.ProofRejectionReason;
import app.zophop.models.mTicketing.ProofUploadDetails;
import app.zophop.ui.views.OrderedTextList;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: uu  reason: default package */
/* compiled from: UserProofsOverviewAdapter.kt */
public final class uu extends RecyclerView.e<b> {

    /* renamed from: a  reason: collision with root package name */
    public final ve f3554a;
    public final List<ProofDocumentProps> b;
    public final Map<String, ProofUploadDetails> c;
    public final boolean d;
    public final List<ProofRejectionReason> e;
    public final a f;

    /* renamed from: uu$a */
    /* compiled from: UserProofsOverviewAdapter.kt */
    public interface a {
        void a(ProofDocumentProps proofDocumentProps);

        void b(ProofDocumentProps proofDocumentProps, boolean z);

        void c(ProofDocumentProps proofDocumentProps);

        void d(String str, View view, boolean z);

        void e(ProofDocumentProps proofDocumentProps);
    }

    /* renamed from: uu$b */
    /* compiled from: UserProofsOverviewAdapter.kt */
    public final class b extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final uy f3555a;
        public final /* synthetic */ uu b;

        /* renamed from: uu$b$a */
        /* compiled from: UserProofsOverviewAdapter.kt */
        public static final class a extends ClickableSpan {
            public final /* synthetic */ uu f;
            public final /* synthetic */ ProofDocumentProps g;

            public a(uu uuVar, ProofDocumentProps proofDocumentProps) {
                this.f = uuVar;
                this.g = proofDocumentProps;
            }

            public void onClick(View view) {
                n86.e(view, "widget");
                this.f.f.a(this.g);
            }

            public void updateDrawState(TextPaint textPaint) {
                n86.e(textPaint, "ds");
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(uu uuVar, uy uyVar) {
            super(uyVar.f3569a);
            n86.e(uuVar, "this$0");
            n86.e(uyVar, "lItemBinding");
            this.b = uuVar;
            this.f3555a = uyVar;
        }

        public final void a(ProofDocumentProps proofDocumentProps, ProofRejectionReason proofRejectionReason, boolean z) {
            String str;
            n86.e(proofDocumentProps, "lProofDocumentProps");
            ProofUploadDetails proofUploadDetails = this.b.c.get(proofDocumentProps.getProofId());
            if (proofUploadDetails == null) {
                proofUploadDetails = new ProofUploadDetails(null, null, null, null, false, 31, null);
            }
            uy uyVar = this.f3555a;
            uu uuVar = this.b;
            uyVar.h.setText(proofDocumentProps.getProofName());
            if (proofDocumentProps.getFormUrl().length() > 0) {
                TextView textView = uyVar.j;
                n86.d(textView, "proofShortDesc");
                textView.setVisibility(0);
                ve veVar = uuVar.f3554a;
                if (veVar == null) {
                    str = null;
                } else {
                    str = veVar.getString(R.string.download_form);
                }
                if (str == null) {
                    str = new String();
                }
                SpannableString spannableString = new SpannableString(n86.j(proofDocumentProps.getShortDescription(), str));
                spannableString.setSpan(new a(uuVar, proofDocumentProps), spannableString.length() - str.length(), spannableString.length(), 33);
                ve veVar2 = uuVar.f3554a;
                if (veVar2 != null) {
                    spannableString.setSpan(new ForegroundColorSpan(q5.b(veVar2, R.color.chalo_primary)), spannableString.length() - str.length(), spannableString.length(), 33);
                }
                TextView textView2 = uyVar.j;
                textView2.setText(spannableString);
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                if (proofDocumentProps.getShortDescription().length() > 0) {
                    TextView textView3 = uyVar.j;
                    n86.d(textView3, "proofShortDesc");
                    textView3.setVisibility(0);
                    uyVar.j.setText(proofDocumentProps.getShortDescription());
                } else {
                    TextView textView4 = uyVar.j;
                    n86.d(textView4, "proofShortDesc");
                    textView4.setVisibility(8);
                }
            }
            int ordinal = proofUploadDetails.getProofUploadStatus().ordinal();
            if (ordinal == 0) {
                ConstraintLayout constraintLayout = uyVar.b;
                n86.d(constraintLayout, "addPhotoPlaceholder");
                constraintLayout.setVisibility(0);
                ProgressBar progressBar = uyVar.f;
                n86.d(progressBar, "picUploadProgressBar");
                progressBar.setVisibility(8);
                ShapeableImageView shapeableImageView = uyVar.g;
                n86.d(shapeableImageView, "proofImage");
                shapeableImageView.setVisibility(8);
                ImageView imageView = uyVar.c;
                n86.d(imageView, "btnEditCancelUpload");
                imageView.setVisibility(8);
                uyVar.b.setOnClickListener(new hu(uuVar, proofDocumentProps));
            } else if (ordinal == 1) {
                ConstraintLayout constraintLayout2 = uyVar.b;
                n86.d(constraintLayout2, "addPhotoPlaceholder");
                constraintLayout2.setVisibility(8);
                ProgressBar progressBar2 = uyVar.f;
                n86.d(progressBar2, "picUploadProgressBar");
                progressBar2.setVisibility(8);
                ShapeableImageView shapeableImageView2 = uyVar.g;
                n86.d(shapeableImageView2, "proofImage");
                shapeableImageView2.setVisibility(0);
                if (proofUploadDetails.getProofImageLocalUri().length() > 0) {
                    ShapeableImageView shapeableImageView3 = uyVar.g;
                    n86.d(shapeableImageView3, "proofImage");
                    shapeableImageView3.setVisibility(0);
                    ve veVar3 = uuVar.f3554a;
                    if (veVar3 != null) {
                        gl1.g(veVar3).p(proofUploadDetails.getProofImageLocalUri()).e(uyVar.g);
                    }
                }
                ImageView imageView2 = uyVar.c;
                n86.d(imageView2, "btnEditCancelUpload");
                imageView2.setVisibility(0);
                uyVar.c.setImageResource(R.drawable.ic_edit);
                uyVar.c.setOnClickListener(new iu(uuVar, proofDocumentProps));
                uyVar.g.setOnClickListener(new ju(uuVar, proofUploadDetails, uyVar));
            } else if (ordinal == 2) {
                ConstraintLayout constraintLayout3 = uyVar.b;
                n86.d(constraintLayout3, "addPhotoPlaceholder");
                constraintLayout3.setVisibility(8);
                ProgressBar progressBar3 = uyVar.f;
                n86.d(progressBar3, "picUploadProgressBar");
                progressBar3.setVisibility(0);
                ShapeableImageView shapeableImageView4 = uyVar.g;
                n86.d(shapeableImageView4, "proofImage");
                shapeableImageView4.setVisibility(8);
                ImageView imageView3 = uyVar.c;
                n86.d(imageView3, "btnEditCancelUpload");
                imageView3.setVisibility(0);
                uyVar.c.setImageResource(R.drawable.ic_cancel);
                uyVar.c.setOnClickListener(new gu(uuVar, proofDocumentProps));
            } else if (ordinal == 3) {
                ConstraintLayout constraintLayout4 = uyVar.b;
                n86.d(constraintLayout4, "addPhotoPlaceholder");
                constraintLayout4.setVisibility(0);
                ProgressBar progressBar4 = uyVar.f;
                n86.d(progressBar4, "picUploadProgressBar");
                progressBar4.setVisibility(8);
                ShapeableImageView shapeableImageView5 = uyVar.g;
                n86.d(shapeableImageView5, "proofImage");
                shapeableImageView5.setVisibility(8);
                ImageView imageView4 = uyVar.c;
                n86.d(imageView4, "btnEditCancelUpload");
                imageView4.setVisibility(8);
            }
            LinearLayout linearLayout = uyVar.d;
            n86.d(linearLayout, "componentDivider");
            linearLayout.setVisibility(z ^ true ? 0 : 8);
            View view = uyVar.e;
            n86.d(view, "lastItemBottomPadding");
            view.setVisibility(z ? 0 : 8);
            uy uyVar2 = this.f3555a;
            if (proofRejectionReason == null) {
                LinearLayout linearLayout2 = uyVar2.m;
                n86.d(linearLayout2, "lItemBinding.rejectionReasonsLayout");
                linearLayout2.setVisibility(8);
                return;
            }
            LinearLayout linearLayout3 = uyVar2.m;
            n86.d(linearLayout3, "lItemBinding.rejectionReasonsLayout");
            linearLayout3.setVisibility(0);
            ve veVar4 = this.b.f3554a;
            if (veVar4 != null) {
                gl1.g(veVar4).p(proofRejectionReason.getLProofUrl()).e(uyVar2.l);
            }
            uyVar2.l.setOnClickListener(new ku(this.b, proofRejectionReason, uyVar2));
            List<String> reasonsList = proofRejectionReason.getReasonsList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (reasonsList.size() == 1) {
                OrderedTextList orderedTextList = uyVar2.i;
                n86.d(orderedTextList, "lItemBinding.proofRejectionReasonsListView");
                orderedTextList.setVisibility(8);
                spannableStringBuilder.append((CharSequence) reasonsList.get(0));
                spannableStringBuilder.append((CharSequence) "\n");
            } else {
                OrderedTextList orderedTextList2 = uyVar2.i;
                n86.d(orderedTextList2, "lItemBinding.proofRejectionReasonsListView");
                orderedTextList2.setVisibility(0);
                uyVar2.i.setShowDotAfterNumber(true);
                uyVar2.i.b(reasonsList, R.layout.numbered_text_list_layout);
            }
            uu uuVar2 = this.b;
            ve veVar5 = uuVar2.f3554a;
            if (veVar5 != null) {
                spannableStringBuilder.append((CharSequence) veVar5.getResources().getString(R.string.reupload_guideline));
                spannableStringBuilder.setSpan(new vu(uuVar2, proofDocumentProps), spannableStringBuilder.length() - 11, spannableStringBuilder.length(), 33);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(q5.b(veVar5, R.color.chalo_primary)), spannableStringBuilder.length() - 11, spannableStringBuilder.length(), 33);
                TextView textView5 = uyVar2.k;
                textView5.setText(spannableStringBuilder);
                textView5.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    public uu(ve veVar, List<ProofDocumentProps> list, Map<String, ProofUploadDetails> map, boolean z, List<ProofRejectionReason> list2, a aVar) {
        n86.e(list, "proofDocumentPropsList");
        n86.e(map, "proofUploadDetailsMap");
        n86.e(aVar, "proofItemClickListener");
        this.f3554a = veVar;
        this.b = list;
        this.c = map;
        this.d = z;
        this.e = list2;
        this.f = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        if (!this.d) {
            return this.b.size();
        }
        List<ProofRejectionReason> list = this.e;
        n86.c(list);
        return list.size();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$a0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(b bVar, int i) {
        b bVar2 = bVar;
        n86.e(bVar2, "holder");
        boolean z = false;
        ProofDocumentProps proofDocumentProps = null;
        if (this.d) {
            List<ProofRejectionReason> list = this.e;
            n86.c(list);
            ProofRejectionReason proofRejectionReason = list.get(i);
            Iterator<ProofDocumentProps> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ProofDocumentProps next = it.next();
                if (n86.a(proofRejectionReason.getProofId(), next.getProofId())) {
                    proofDocumentProps = next;
                    break;
                }
            }
            if (proofDocumentProps != null) {
                if (i == this.e.size() - 1) {
                    z = true;
                }
                bVar2.a(proofDocumentProps, proofRejectionReason, z);
                return;
            }
            return;
        }
        ProofDocumentProps proofDocumentProps2 = this.b.get(i);
        if (i == this.b.size() - 1) {
            z = true;
        }
        bVar2.a(proofDocumentProps2, null, z);
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$a0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        n86.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.proof_detail_item, viewGroup, false);
        int i2 = R.id.add_photo_placeholder;
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.add_photo_placeholder);
        if (constraintLayout != null) {
            i2 = R.id.btn_edit_cancel_upload;
            ImageView imageView = (ImageView) inflate.findViewById(R.id.btn_edit_cancel_upload);
            if (imageView != null) {
                i2 = R.id.component_divider;
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.component_divider);
                if (linearLayout != null) {
                    i2 = R.id.frameLayout;
                    FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.frameLayout);
                    if (frameLayout != null) {
                        i2 = R.id.image_add;
                        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.image_add);
                        if (imageView2 != null) {
                            i2 = R.id.last_item_bottom_padding;
                            View findViewById = inflate.findViewById(R.id.last_item_bottom_padding);
                            if (findViewById != null) {
                                i2 = R.id.pic_upload_progress_bar;
                                ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.pic_upload_progress_bar);
                                if (progressBar != null) {
                                    i2 = R.id.proof_image;
                                    ShapeableImageView shapeableImageView = (ShapeableImageView) inflate.findViewById(R.id.proof_image);
                                    if (shapeableImageView != null) {
                                        i2 = R.id.proof_name;
                                        TextView textView = (TextView) inflate.findViewById(R.id.proof_name);
                                        if (textView != null) {
                                            i2 = R.id.proof_rejection_reasons_list_view;
                                            OrderedTextList orderedTextList = (OrderedTextList) inflate.findViewById(R.id.proof_rejection_reasons_list_view);
                                            if (orderedTextList != null) {
                                                i2 = R.id.proof_short_desc;
                                                TextView textView2 = (TextView) inflate.findViewById(R.id.proof_short_desc);
                                                if (textView2 != null) {
                                                    i2 = R.id.proof_single_rejection_reasons_text;
                                                    TextView textView3 = (TextView) inflate.findViewById(R.id.proof_single_rejection_reasons_text);
                                                    if (textView3 != null) {
                                                        i2 = R.id.rejected_proof_thumbnail;
                                                        ShapeableImageView shapeableImageView2 = (ShapeableImageView) inflate.findViewById(R.id.rejected_proof_thumbnail);
                                                        if (shapeableImageView2 != null) {
                                                            i2 = R.id.rejection_reasons_layout;
                                                            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.rejection_reasons_layout);
                                                            if (linearLayout2 != null) {
                                                                i2 = R.id.text_add_photo;
                                                                TextView textView4 = (TextView) inflate.findViewById(R.id.text_add_photo);
                                                                if (textView4 != null) {
                                                                    uy uyVar = new uy((ConstraintLayout) inflate, constraintLayout, imageView, linearLayout, frameLayout, imageView2, findViewById, progressBar, shapeableImageView, textView, orderedTextList, textView2, textView3, shapeableImageView2, linearLayout2, textView4);
                                                                    n86.d(uyVar, "inflate(LayoutInflater.f….context), parent, false)");
                                                                    return new b(this, uyVar);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }
}
