package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.CardDetails;
import app.zophop.models.PaymentItem;
import com.google.firebase.perf.util.Constants;
import com.razorpay.AnalyticsConstants;
import io.github.inflationx.calligraphy3.TypefaceUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: vj0  reason: default package */
/* compiled from: PaymentItemAdapter */
public class vj0 extends RecyclerView.e<b> implements Filterable {
    public final Context f;
    public String g;
    public final List<PaymentItem> h;
    public List<PaymentItem> i;
    public List<PaymentItem> j;
    public p61 k;
    public String l;
    public boolean m;

    /* renamed from: vj0$a */
    /* compiled from: PaymentItemAdapter */
    public class a extends Filter {
        public a() {
        }

        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            String charSequence2 = charSequence.toString();
            if (charSequence2.isEmpty()) {
                vj0 vj0 = vj0.this;
                vj0.j = vj0.h;
            } else {
                ArrayList arrayList = new ArrayList();
                for (PaymentItem paymentItem : vj0.this.h) {
                    if (paymentItem.getAppName().toLowerCase().contains(charSequence2.toLowerCase()) || paymentItem.getAppName().contains(charSequence)) {
                        arrayList.add(paymentItem);
                    }
                }
                vj0.this.j = arrayList;
            }
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.values = vj0.this.j;
            return filterResults;
        }

        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            vj0 vj0 = vj0.this;
            vj0.j = (ArrayList) filterResults.values;
            vj0.notifyDataSetChanged();
        }
    }

    /* renamed from: vj0$b */
    /* compiled from: PaymentItemAdapter */
    public class b extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f3656a;
        public final TextView b;
        public final TextView c;
        public final ImageView d;
        public String e;
        public String f;
        public String g;
        public boolean h;
        public CardDetails i;
        public final View j;
        public final TextView k;

        /* renamed from: vj0$b$a */
        /* compiled from: PaymentItemAdapter */
        public class a implements View.OnClickListener {
            public a(vj0 vj0) {
            }

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b6, code lost:
                if (r0.equals("top_mode") == false) goto L_0x00b8;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.view.View r14) {
                /*
                // Method dump skipped, instructions count: 696
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.vj0.b.a.onClick(android.view.View):void");
            }
        }

        public b(View view) {
            super(view);
            this.j = view;
            this.f3656a = (TextView) view.findViewById(R.id.app_name);
            this.b = (TextView) view.findViewById(R.id.desc);
            this.c = (TextView) view.findViewById(R.id.label);
            this.d = (ImageView) view.findViewById(R.id.app_logo);
            this.k = (TextView) view.findViewById(R.id.payment_mode_error);
            view.setOnClickListener(new a(vj0.this));
        }
    }

    public vj0(Context context, List<PaymentItem> list, String str, boolean z) {
        this.m = z;
        this.h = list;
        this.f = context;
        this.g = str;
        this.j = list;
    }

    public Filter getFilter() {
        return new a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return this.j.size();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$a0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(b bVar, int i2) {
        b bVar2 = bVar;
        String appName = this.j.get(i2).getAppName();
        bVar2.f = this.j.get(i2).getPackageName();
        bVar2.e = this.j.get(i2).getTagName();
        bVar2.i = this.j.get(i2).getCardDetails();
        if (!TextUtils.isEmpty(this.j.get(i2).getLabel())) {
            bVar2.c.setText(this.j.get(i2).getLabel());
            bVar2.c.setVisibility(0);
        } else {
            bVar2.c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.j.get(i2).getDesc())) {
            bVar2.b.setVisibility(0);
            bVar2.b.setText(this.j.get(i2).getDesc());
        } else {
            bVar2.b.setVisibility(8);
        }
        if (bVar2.e.equalsIgnoreCase(AnalyticsConstants.WALLET)) {
            TextView textView = bVar2.f3656a;
            textView.setText(appName.substring(0, 1).toUpperCase() + appName.substring(1).toLowerCase());
        } else if (!bVar2.e.equalsIgnoreCase(AnalyticsConstants.UPI) || !appName.equalsIgnoreCase("paytm")) {
            bVar2.f3656a.setText(appName);
        } else {
            TextView textView2 = bVar2.f3656a;
            textView2.setText(appName + " UPI");
        }
        TextUtils.isEmpty(this.j.get(i2).getAppLogoUrl());
        if (this.j.get(i2).getTagName().equalsIgnoreCase(this.f.getString(R.string.error))) {
            bVar2.j.setClickable(false);
            bVar2.f3656a.setTextSize(12.0f);
            bVar2.f3656a.setGravity(3);
            hj1.v0(this.f, R.color.dark_red_color, bVar2.f3656a);
            bVar2.f3656a.setPadding(0, 16, 16, 16);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(16, 16, 0, 16);
            bVar2.f3656a.setLayoutParams(layoutParams);
            bVar2.f3656a.setTypeface(TypefaceUtils.load(this.f.getResources().getAssets(), "fonts/NotoSans-Regular.ttf"));
            bVar2.d.setVisibility(8);
        }
        bVar2.g = this.j.get(i2).getBankName();
        bVar2.h = this.j.get(i2).isPreferredMode();
        if (this.j.get(i2).getAppLogoUrl() == null) {
            bVar2.d.setImageDrawable(this.f.getResources().getDrawable(this.j.get(i2).getAppLogoDrawale()));
        } else {
            String appLogoUrl = this.j.get(i2).getAppLogoUrl();
            ImageView imageView = bVar2.d;
            if (TextUtils.isEmpty(appLogoUrl)) {
                imageView.setVisibility(8);
            }
            ml1<Bitmap> j2 = gl1.f(this.f).j();
            j2.n = new wj0(this, imageView);
            j2.m = appLogoUrl;
            j2.p = true;
            j2.e(imageView);
        }
        if (!this.j.get(i2).isEnabled()) {
            bVar2.j.setClickable(false);
            bVar2.j.setAlpha(20.0f);
            bVar2.d.setAlpha(40);
            hj1.v0(this.f, R.color.black_40, bVar2.f3656a);
            if (this.j.get(i2).isModeEnable()) {
                bVar2.k.setVisibility(8);
                return;
            }
            if (this.j.get(i2).getAppName().equalsIgnoreCase("lazypay") && !this.j.get(i2).is_isLazypayDisabled()) {
                this.g = this.f.getResources().getString(R.string.lazypay_eligibility);
            }
            if (!TextUtils.isEmpty(this.j.get(i2).getWarningMsg())) {
                this.g = this.j.get(i2).getWarningMsg();
            }
            if (!TextUtils.isEmpty(this.g)) {
                bVar2.k.setText(this.g);
            }
            bVar2.k.setVisibility(0);
        } else if (!this.j.get(i2).getTagName().equalsIgnoreCase(this.f.getString(R.string.error))) {
            bVar2.j.setClickable(true);
            bVar2.d.setAlpha(Constants.MAX_HOST_LENGTH);
            hj1.v0(this.f, R.color.black, bVar2.f3656a);
            if (!this.j.get(i2).isEnabled() || TextUtils.isEmpty(this.j.get(i2).getWarningMsg())) {
                bVar2.k.setVisibility(8);
                return;
            }
            bVar2.k.setVisibility(0);
            bVar2.k.setText(this.j.get(i2).getWarningMsg());
        }
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$a0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public b onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(this.f).inflate(R.layout.payment_item, viewGroup, false));
    }

    public vj0(Context context, List<PaymentItem> list, String str) {
        this.h = list;
        this.f = context;
        this.g = str;
        this.j = list;
    }
}
