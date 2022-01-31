package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* renamed from: qx  reason: default package */
/* compiled from: FragmentSuperPassBookingSummaryBinding */
public final class qx implements qo {
    public final CircleImageView A;
    public final LinearLayout B;

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f3000a;
    public final TextView b;
    public final TextView c;
    public final ImageView d;
    public final ImageView e;
    public final CardView f;
    public final CardView g;
    public final TextView h;
    public final View i;
    public final LinearLayout j;
    public final LinearLayout k;
    public final TextView l;
    public final TextView m;
    public final LinearLayout n;
    public final TextView o;
    public final TextView p;
    public final ImageView q;
    public final TextView r;
    public final TextView s;
    public final RecyclerView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final CardView y;
    public final TextView z;

    public qx(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, CardView cardView, CardView cardView2, TextView textView3, View view, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView4, TextView textView5, LinearLayout linearLayout4, TextView textView6, TextView textView7, ImageView imageView3, TextView textView8, TextView textView9, ProgressBar progressBar, RecyclerView recyclerView, TextView textView10, TextView textView11, TextView textView12, LinearLayout linearLayout5, TextView textView13, CardView cardView3, TextView textView14, CircleImageView circleImageView, LinearLayout linearLayout6) {
        this.f3000a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = imageView;
        this.e = imageView2;
        this.f = cardView;
        this.g = cardView2;
        this.h = textView3;
        this.i = view;
        this.j = linearLayout2;
        this.k = linearLayout3;
        this.l = textView4;
        this.m = textView5;
        this.n = linearLayout4;
        this.o = textView6;
        this.p = textView7;
        this.q = imageView3;
        this.r = textView8;
        this.s = textView9;
        this.t = recyclerView;
        this.u = textView10;
        this.v = textView11;
        this.w = textView12;
        this.x = textView13;
        this.y = cardView3;
        this.z = textView14;
        this.A = circleImageView;
        this.B = linearLayout6;
    }

    public static qx b(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.fragment_super_pass_booking_summary, (ViewGroup) null, false);
        int i2 = R.id.booking_date;
        TextView textView = (TextView) inflate.findViewById(R.id.booking_date);
        if (textView != null) {
            i2 = R.id.booking_id;
            TextView textView2 = (TextView) inflate.findViewById(R.id.booking_id);
            if (textView2 != null) {
                i2 = R.id.btn_documents_expansion;
                ImageView imageView = (ImageView) inflate.findViewById(R.id.btn_documents_expansion);
                if (imageView != null) {
                    i2 = R.id.btn_expand_fare_split;
                    ImageView imageView2 = (ImageView) inflate.findViewById(R.id.btn_expand_fare_split);
                    if (imageView2 != null) {
                        i2 = R.id.btn_renew;
                        CardView cardView = (CardView) inflate.findViewById(R.id.btn_renew);
                        if (cardView != null) {
                            i2 = R.id.btn_view_pass_trip_history;
                            CardView cardView2 = (CardView) inflate.findViewById(R.id.btn_view_pass_trip_history);
                            if (cardView2 != null) {
                                i2 = R.id.date_of_birth;
                                TextView textView3 = (TextView) inflate.findViewById(R.id.date_of_birth);
                                if (textView3 != null) {
                                    i2 = R.id.divider;
                                    View findViewById = inflate.findViewById(R.id.divider);
                                    if (findViewById != null) {
                                        i2 = R.id.fare_details_layout;
                                        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.fare_details_layout);
                                        if (linearLayout != null) {
                                            i2 = R.id.fare_split_layout;
                                            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.fare_split_layout);
                                            if (linearLayout2 != null) {
                                                i2 = R.id.fare_split_title;
                                                LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.fare_split_title);
                                                if (linearLayout3 != null) {
                                                    i2 = R.id.gender;
                                                    TextView textView4 = (TextView) inflate.findViewById(R.id.gender);
                                                    if (textView4 != null) {
                                                        i2 = R.id.order_id;
                                                        TextView textView5 = (TextView) inflate.findViewById(R.id.order_id);
                                                        if (textView5 != null) {
                                                            i2 = R.id.order_id_layout;
                                                            LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.order_id_layout);
                                                            if (linearLayout4 != null) {
                                                                i2 = R.id.pass_expiry_details;
                                                                TextView textView6 = (TextView) inflate.findViewById(R.id.pass_expiry_details);
                                                                if (textView6 != null) {
                                                                    i2 = R.id.pass_name;
                                                                    TextView textView7 = (TextView) inflate.findViewById(R.id.pass_name);
                                                                    if (textView7 != null) {
                                                                        i2 = R.id.pass_status_image;
                                                                        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.pass_status_image);
                                                                        if (imageView3 != null) {
                                                                            i2 = R.id.pass_status_text;
                                                                            TextView textView8 = (TextView) inflate.findViewById(R.id.pass_status_text);
                                                                            if (textView8 != null) {
                                                                                i2 = R.id.payment_mode;
                                                                                TextView textView9 = (TextView) inflate.findViewById(R.id.payment_mode);
                                                                                if (textView9 != null) {
                                                                                    i2 = R.id.profile_pic_progressbar;
                                                                                    ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.profile_pic_progressbar);
                                                                                    if (progressBar != null) {
                                                                                        i2 = R.id.proof_documents_list;
                                                                                        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.proof_documents_list);
                                                                                        if (recyclerView != null) {
                                                                                            i2 = R.id.ride_based_pass_fare_limits_description;
                                                                                            TextView textView10 = (TextView) inflate.findViewById(R.id.ride_based_pass_fare_limits_description);
                                                                                            if (textView10 != null) {
                                                                                                i2 = R.id.ride_based_pass_trip_limits_description;
                                                                                                TextView textView11 = (TextView) inflate.findViewById(R.id.ride_based_pass_trip_limits_description);
                                                                                                if (textView11 != null) {
                                                                                                    i2 = R.id.super_pass_description;
                                                                                                    TextView textView12 = (TextView) inflate.findViewById(R.id.super_pass_description);
                                                                                                    if (textView12 != null) {
                                                                                                        i2 = R.id.total_fare;
                                                                                                        LinearLayout linearLayout5 = (LinearLayout) inflate.findViewById(R.id.total_fare);
                                                                                                        if (linearLayout5 != null) {
                                                                                                            i2 = R.id.total_fare_text;
                                                                                                            TextView textView13 = (TextView) inflate.findViewById(R.id.total_fare_text);
                                                                                                            if (textView13 != null) {
                                                                                                                i2 = R.id.transaction_details_layout;
                                                                                                                CardView cardView3 = (CardView) inflate.findViewById(R.id.transaction_details_layout);
                                                                                                                if (cardView3 != null) {
                                                                                                                    i2 = R.id.user_name;
                                                                                                                    TextView textView14 = (TextView) inflate.findViewById(R.id.user_name);
                                                                                                                    if (textView14 != null) {
                                                                                                                        i2 = R.id.user_profile_pic;
                                                                                                                        CircleImageView circleImageView = (CircleImageView) inflate.findViewById(R.id.user_profile_pic);
                                                                                                                        if (circleImageView != null) {
                                                                                                                            i2 = R.id.view_documents_header;
                                                                                                                            LinearLayout linearLayout6 = (LinearLayout) inflate.findViewById(R.id.view_documents_header);
                                                                                                                            if (linearLayout6 != null) {
                                                                                                                                return new qx((ConstraintLayout) inflate, textView, textView2, imageView, imageView2, cardView, cardView2, textView3, findViewById, linearLayout, linearLayout2, linearLayout3, textView4, textView5, linearLayout4, textView6, textView7, imageView3, textView8, textView9, progressBar, recyclerView, textView10, textView11, textView12, linearLayout5, textView13, cardView3, textView14, circleImageView, linearLayout6);
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

    @Override // defpackage.qo
    public View a() {
        return this.f3000a;
    }
}
