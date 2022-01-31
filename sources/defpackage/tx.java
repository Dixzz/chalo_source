package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import app.zophop.R;

/* renamed from: tx  reason: default package */
/* compiled from: FragmentUserProofUploadBinding */
public final class tx implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f3415a;
    public final TextView b;
    public final ProgressBar c;
    public final ImageView d;
    public final TextView e;
    public final TextView f;
    public final Group g;
    public final TextView h;

    public tx(ConstraintLayout constraintLayout, LinearLayout linearLayout, View view, TextView textView, Guideline guideline, Guideline guideline2, ProgressBar progressBar, ImageView imageView, TextView textView2, TextView textView3, ImageView imageView2, Group group, TextView textView4) {
        this.f3415a = constraintLayout;
        this.b = textView;
        this.c = progressBar;
        this.d = imageView;
        this.e = textView2;
        this.f = textView3;
        this.g = group;
        this.h = textView4;
    }

    public static tx b(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.fragment_user_proof_upload, (ViewGroup) null, false);
        int i = R.id.bottom_sheet_next_btn;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.bottom_sheet_next_btn);
        if (linearLayout != null) {
            i = R.id.bottomsheet_shadow;
            View findViewById = inflate.findViewById(R.id.bottomsheet_shadow);
            if (findViewById != null) {
                i = R.id.btn_upload_proof;
                TextView textView = (TextView) inflate.findViewById(R.id.btn_upload_proof);
                if (textView != null) {
                    i = R.id.guideline_left;
                    Guideline guideline = (Guideline) inflate.findViewById(R.id.guideline_left);
                    if (guideline != null) {
                        i = R.id.guideline_right;
                        Guideline guideline2 = (Guideline) inflate.findViewById(R.id.guideline_right);
                        if (guideline2 != null) {
                            i = R.id.placeholder_image_loader;
                            ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.placeholder_image_loader);
                            if (progressBar != null) {
                                i = R.id.placeholder_image_view;
                                ImageView imageView = (ImageView) inflate.findViewById(R.id.placeholder_image_view);
                                if (imageView != null) {
                                    i = R.id.proof_long_desc;
                                    TextView textView2 = (TextView) inflate.findViewById(R.id.proof_long_desc);
                                    if (textView2 != null) {
                                        i = R.id.proof_name;
                                        TextView textView3 = (TextView) inflate.findViewById(R.id.proof_name);
                                        if (textView3 != null) {
                                            i = R.id.watch_video_icon;
                                            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.watch_video_icon);
                                            if (imageView2 != null) {
                                                i = R.id.watch_video_layout_group;
                                                Group group = (Group) inflate.findViewById(R.id.watch_video_layout_group);
                                                if (group != null) {
                                                    i = R.id.watch_video_text_view;
                                                    TextView textView4 = (TextView) inflate.findViewById(R.id.watch_video_text_view);
                                                    if (textView4 != null) {
                                                        return new tx((ConstraintLayout) inflate, linearLayout, findViewById, textView, guideline, guideline2, progressBar, imageView, textView2, textView3, imageView2, group, textView4);
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
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // defpackage.qo
    public View a() {
        return this.f3415a;
    }
}
