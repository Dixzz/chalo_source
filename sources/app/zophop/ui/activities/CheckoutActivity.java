package app.zophop.ui.activities;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.CardDetails;
import app.zophop.models.PaymentItem;
import app.zophop.models.PaymentMethod.MethodDetails;
import app.zophop.models.RecentPaymentMethod;
import app.zophop.models.ScanPayTicket;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.CardRechargeConfiguration;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.models.mTicketing.RideDetails;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRechargeOrderDetails;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassOrderDetails;
import app.zophop.models.mTicketing.superPass.SuperPassPaymentConstants;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.pubsub.eventbus.events.LpInitiatePayResponseEvent;
import app.zophop.pubsub.eventbus.events.RazorPayVerificationStatus;
import app.zophop.pubsub.eventbus.events.RazorpayPaymentFetchEvent;
import app.zophop.pubsub.eventbus.events.UpdateTimeoutEvent;
import app.zophop.room.ProductRepository;
import app.zophop.room.Ticket;
import butterknife.ButterKnife;
import com.google.firebase.messaging.Constants;
import com.razorpay.AnalyticsConstants;
import com.razorpay.BaseRazorpay;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;
import com.razorpay.Razorpay;
import defpackage.au;
import defpackage.q5;
import defpackage.xt;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CheckoutActivity extends fe0 implements p61, PaymentResultWithDataListener {
    public static final /* synthetic */ int d0 = 0;
    public MTicket A;
    public ScanPayTicket B;
    public boolean C;
    public SuperPassOrderDetails D;
    public BookableSuperPassConfiguration E;
    public SuperPassUserDetails F;
    public boolean G;
    public boolean H;
    public String I;
    public CardRechargeConfiguration J;
    public OnlineCardRechargeOrderDetails K;
    public List<RecentPaymentMethod> L;
    public JSONObject M;
    public Map<String, List<String>> N;
    public String O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public String S;
    public boolean T;
    public String U;
    public DialogFragment V;
    public rf1 W;
    public rf1 X;
    public String Y;
    public boolean Z = false;
    public boolean a0 = false;
    public String b0;
    public boolean c0;
    public Razorpay m;
    public WebView n;
    public RecyclerView o;
    public RecyclerView p;
    public RecyclerView q;
    public TextView r;
    public RecyclerView.m s;
    public JSONObject t;
    public NestedScrollView u;
    public ProgressBar v;
    public String w;
    public List<PaymentItem> x;
    public Map<String, List<String>> y;
    public MPass z;

    public class a implements View.OnClickListener {
        public final /* synthetic */ AlertDialog f;
        public final /* synthetic */ String g;

        public a(AlertDialog alertDialog, String str) {
            this.f = alertDialog;
            this.g = str;
        }

        public void onClick(View view) {
            AlertDialog alertDialog = this.f;
            if (alertDialog != null) {
                alertDialog.dismiss();
                CheckoutActivity checkoutActivity = CheckoutActivity.this;
                String str = this.g;
                int i = CheckoutActivity.d0;
                Objects.requireNonNull(checkoutActivity);
                ed1 ed1 = new ed1("pass status prompt negative button click", Long.MIN_VALUE);
                ed1.a("reason", str);
                jz5.b().g(ed1);
                Intent intent = new Intent(CheckoutActivity.this, HomeActivity.class);
                intent.addFlags(268468224);
                CheckoutActivity.this.startActivity(intent);
            }
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ String f;
        public final /* synthetic */ AlertDialog g;
        public final /* synthetic */ boolean h;

        public b(String str, AlertDialog alertDialog, boolean z) {
            this.f = str;
            this.g = alertDialog;
            this.h = z;
        }

        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f) || !this.f.equalsIgnoreCase("checkHistory")) {
                this.g.dismiss();
                if (this.h) {
                    CheckoutActivity.this.finish();
                    return;
                }
                return;
            }
            Intent intent = new Intent(CheckoutActivity.this, HomeActivity.class);
            intent.addFlags(268468224);
            CheckoutActivity.this.startActivity(intent);
            CheckoutActivity checkoutActivity = CheckoutActivity.this;
            String str = this.f;
            int i2 = CheckoutActivity.d0;
            Objects.requireNonNull(checkoutActivity);
            ed1 ed1 = new ed1("pass status prompt positive button click", Long.MIN_VALUE);
            ed1.a("reason", str);
            jz5.b().g(ed1);
            this.g.dismiss();
        }
    }

    public class c implements Comparator<Map.Entry<String, MethodDetails>>, j$.util.Comparator {
        public c(CheckoutActivity checkoutActivity) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(Map.Entry<String, MethodDetails> entry, Map.Entry<String, MethodDetails> entry2) {
            return Integer.valueOf(entry.getValue().getOrder()).compareTo(Integer.valueOf(entry2.getValue().getOrder()));
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<Map.Entry<String, MethodDetails>> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<Map.Entry<String, MethodDetails>> thenComparing(java.util.Comparator<? super Map.Entry<String, MethodDetails>> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    public class d extends WebChromeClient {
        public d() {
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i >= 80) {
                CheckoutActivity checkoutActivity = CheckoutActivity.this;
                int i2 = CheckoutActivity.d0;
                checkoutActivity.r0();
            }
        }
    }

    public class e extends WebViewClient {
        public e() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            CheckoutActivity checkoutActivity = CheckoutActivity.this;
            int i = CheckoutActivity.d0;
            checkoutActivity.r0();
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            CheckoutActivity checkoutActivity = CheckoutActivity.this;
            checkoutActivity.Y = null;
            checkoutActivity.Z = true;
            checkoutActivity.findViewById(R.id.toolbar).setVisibility(0);
            CheckoutActivity.this.x0();
            xt.f3961a.c().a(CheckoutActivity.this.S, null);
            CheckoutActivity.this.n.setVisibility(8);
            CheckoutActivity.this.u.setVisibility(0);
            return true;
        }
    }

    public static class f extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        public final Drawable f297a;

        public f(Drawable drawable) {
            this.f297a = drawable;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar) {
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i <= childCount - 2; i++) {
                View childAt = recyclerView.getChildAt(i);
                RecyclerView.n nVar = (RecyclerView.n) childAt.getLayoutParams();
                int bottom = childAt.getBottom();
                this.f297a.setBounds(paddingLeft, bottom, width, this.f297a.getIntrinsicHeight() + bottom);
                this.f297a.draw(canvas);
            }
        }
    }

    @Override // defpackage.fe0
    public void init() {
        this.x = new ArrayList();
        new ArrayList();
        this.N = new HashMap();
        this.y = new HashMap();
        new ArrayList();
        this.W = new rf1(this, "processingStore");
        this.X = new rf1(this, "superSaverStore");
        Map<String, List<String>> map = this.y;
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(xt.f3961a.t().f("preferredPaymentModes"));
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray jSONArray = jSONObject.getJSONArray(next);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                hashMap.put(next, arrayList);
            }
        } catch (JSONException unused) {
        }
        map.putAll(hashMap);
        if (getIntent() != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("card_details");
            if (parcelableArrayListExtra != null) {
                for (int i2 = 0; i2 < parcelableArrayListExtra.size(); i2++) {
                    StringBuilder i0 = hj1.i0("************");
                    i0.append(((CardDetails) parcelableArrayListExtra.get(i2)).getSavedCard().getLastFourDigits());
                    PaymentItem paymentItem = new PaymentItem((int) R.drawable.debit_card, i0.toString(), "saved_card", true, (String) null);
                    paymentItem.setCardDetails((CardDetails) parcelableArrayListExtra.get(i2));
                    arrayList2.add(paymentItem);
                    this.x.add(paymentItem);
                }
            }
        }
        ButterKnife.inject(this, this);
        if (this.M == null) {
            xt.t1 t1Var = xt.f3961a;
            t1Var.M().a(this);
            this.z = (MPass) getIntent().getParcelableExtra("magic_pass_info");
            this.A = (MTicket) getIntent().getParcelableExtra("mticket_pass_info");
            this.B = (ScanPayTicket) getIntent().getParcelableExtra("scanPayInfo");
            RideDetails rideDetails = (RideDetails) getIntent().getParcelableExtra("super_saver_info");
            this.C = getIntent().getBooleanExtra("arg_isSuperPassBookingFlow", false);
            this.D = (SuperPassOrderDetails) getIntent().getParcelableExtra("arg_superPassOrderDetails");
            this.F = (SuperPassUserDetails) getIntent().getParcelableExtra("arg_superPassUserDetails");
            this.E = (BookableSuperPassConfiguration) getIntent().getParcelableExtra("arg_bookableSuperPassConfig");
            this.G = getIntent().getBooleanExtra("arg_isCashPaymentAllowedForSuperPass", false);
            this.H = getIntent().getBooleanExtra("arg_isOnlineCardRechargePaymentFlow", false);
            this.I = getIntent().getStringExtra("argCardNumber");
            this.J = (CardRechargeConfiguration) getIntent().getParcelableExtra("arg_onlineCardRechargeConfig");
            this.K = (OnlineCardRechargeOrderDetails) getIntent().getParcelableExtra("arg_onlineCardRechargeOrderDetails");
            MPass mPass = this.z;
            if (mPass != null) {
                this.b0 = mPass.getAgency().toLowerCase();
            } else {
                MTicket mTicket = this.A;
                if (mTicket != null) {
                    this.b0 = mTicket.getAgency().toLowerCase();
                } else {
                    ScanPayTicket scanPayTicket = this.B;
                    if (scanPayTicket != null) {
                        this.b0 = scanPayTicket.get_agencyName().toLowerCase();
                    } else if (this.C) {
                        this.b0 = this.E.getSuperPassProductConfigurationProperties().getProductAgency().toLowerCase();
                    } else if (this.H) {
                        this.b0 = this.J.getAgency().toLowerCase();
                    }
                }
            }
            this.m = t1Var.M().b();
            if (this.B != null) {
                i0();
                s0("{\n\t\"emi\": false,\n\t\"upi\": true,\n\t\"amex\": false,\n\t\"card\": true,\n\t\"cash\": false,\n\t\"entity\": \"methods\",\n\t\"wallet\": true,\n\t\"paylater\": [],\n\t\"debit_card\": true,\n\t\"error_copy\": \"We are facing issues with this payment mode.Try some other mode.\",\n\t\"netbanking\": true,\n\t\"upi_intent\": true,\n\t\"credit_card\": true,\n\t\"upi_details\": {\n\t\t\"BHIM\": {\n\t\t\t\"name\": \"BHIM\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"Paytm\": {\n\t\t\t\"name\": \"Paytm\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"Airtel\": {\n\t\t\t\"name\": \"Airtel\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"PhonePe\": {\n\t\t\t\"name\": \"PhonePe\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"imobile\": {\n\t\t\t\"name\": \"imobile\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"Google Pay\": {\n\t\t\t\"name\": \"Google Pay\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"Amazon Shopping\": {\n\t\t\t\"name\": \"Amazon Shopping\",\n\t\t\t\"status\": true\n\t\t}\n\t},\n\t\"cardless_emi\": [],\n\t\"prepaid_card\": true,\n\t\"card_networks\": {\n\t\t\"MC\": true,\n\t\t\"JCB\": true,\n\t\t\"AMEX\": false,\n\t\t\"DICL\": true,\n\t\t\"MAES\": true,\n\t\t\"VISA\": true,\n\t\t\"BAJAJ\": false,\n\t\t\"RUPAY\": true\n\t},\n\t\"payment_modes\": {\n\t\t\"chalo_wallet\": {\n\t\t\t\"name\": \"Chalo Wallet\",\n\t\t\t\"warning\": \"Insufficient Balance. Add money to Proceed\",\n\t\t\t\"order\": 1,\n\t\t\t\"status\": true\n\t\t},\n\t\t\"upi\": {\n\t\t\t\"name\": \"UPI\",\n\t\t\t\"order\": 3,\n\t\t\t\"status\": true\n\t\t},\n\t\t\"card\": {\n\t\t\t\"name\": \"Debit/Credit card\",\n\t\t\t\"order\": 1,\n\t\t\t\"status\": true\n\t\t},\n\t\t\"cash\": {\n\t\t\t\"name\": \"Cash\",\n\t\t\t\"order\": 5,\n\t\t\t\"status\": false,\n\t\t\t\"isVisible\": false\n\t\t},\n\t\t\"wallet\": {\n\t\t\t\"name\": \"Wallet\",\n\t\t\t\"order\": 2,\n\t\t\t\"status\": true\n\t\t},\n\t\t\"netbanking\": {\n\t\t\t\"name\": \"Netbanking\",\n\t\t\t\"order\": 4,\n\t\t\t\"status\": true\n\t\t}\n\t},\n\t\"wallet_details\": {\n\t\t\"payzapp\": {\n\t\t\t\"name\": \"payzapp\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"jiomoney\": {\n\t\t\t\"name\": \"jiomoney\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"mobikwik\": {\n\t\t\t\"name\": \"mobikwik\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"olamoney\": {\n\t\t\t\"name\": \"olamoney\",\n\t\t\t\"status\": false,\n\t\t\t\"isVisible\": false\n\t\t},\n\t\t\"freecharge\": {\n\t\t\t\"name\": \"freecharge\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"airtelmoney\": {\n\t\t\t\"name\": \"airtelmoney\",\n\t\t\t\"status\": false,\n\t\t\t\"isVisible\": false\n\t\t}\n\t},\n\t\"netbanking_details\": {\n\t\t\"ABPB\": {\n\t\t\t\"name\": \"Aditya Birla Idea Payments Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"AIRP\": {\n\t\t\t\"name\": \"Airtel Payments Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"ALLA\": {\n\t\t\t\"name\": \"Allahabad Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"ANDB\": {\n\t\t\t\"name\": \"Andhra Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"AUBL\": {\n\t\t\t\"name\": \"AU Small Finance Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"BACB\": {\n\t\t\t\"name\": \"Bassein Catholic Co-operativ e Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"BBKM\": {\n\t\t\t\"name\": \"Bank of Bahrein and Kuwait\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"BDBL\": {\n\t\t\t\"name\": \"Bandhan Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"BKDN\": {\n\t\t\t\"name\": \"Dena Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"BKID\": {\n\t\t\t\"name\": \"Bank of India\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"CBIN\": {\n\t\t\t\"name\": \"Central Bank of India\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"CIUB\": {\n\t\t\t\"name\": \"City Union Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"CNRB\": {\n\t\t\t\"name\": \"Canara Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"CORP\": {\n\t\t\t\"name\": \"Corporation Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"COSB\": {\n\t\t\t\"name\": \"Cosmos Co-operative Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"CSBK\": {\n\t\t\t\"name\": \"Catholic Syrian Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"DBSS\": {\n\t\t\t\"name\": \"Development Bank of Singapore\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"DCBL\": {\n\t\t\t\"name\": \"DC B Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"DEUT\": {\n\t\t\t\"name\": \"Deutsche Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"DLXB\": {\n\t\t\t\"name\": \"Dhanlaxmi Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"ESAF\": {\n\t\t\t\"name\": \"ESAF Small Finance Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"FDRL\": {\n\t\t\t\"name\": \"Federal Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"HDFC\": {\n\t\t\t\"name\": \"HDFC Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"IBKL\": {\n\t\t\t\"name\": \"IDBI\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"ICIC\": {\n\t\t\t\"name\": \"ICICI Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"IDFB\": {\n\t\t\t\"name\": \"IDFC FIRST Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"IDIB\": {\n\t\t\t\"name\": \"Indian Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"INDB\": {\n\t\t\t\"name\": \"Indusind Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"IOBA\": {\n\t\t\t\"name\": \"Indian Overseas Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"JAKA\": {\n\t\t\t\"name\": \"Jammu and Kashmir Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"JSBP\": {\n\t\t\t\"name\": \"Janata Sahakari Bank (Pune)\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"KARB\": {\n\t\t\t\"name\": \"Karnataka Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"KCCB\": {\n\t\t\t\"name\": \"Kalupur Commercial Co-operative Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"KJSB\": {\n\t\t\t\"name\": \"Kalyan Janata Sah akari Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"KKBK\": {\n\t\t\t\"name\": \"Kotak Mahindra Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"KVBL\": {\n\t\t\t\"name\": \"Karur Vysya Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"MAHB\": {\n\t\t\t\"name\": \"Bank of Maharashtra\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"MSNU\": {\n\t\t\t\"name\": \"Mehsana Urba n Co-operative Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"NESF\": {\n\t\t\t\"name\": \"North East Small Finance Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"NKGS\": {\n\t\t\t\"name\": \"NKGSB Co-operative Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"ORBC\": {\n\t\t\t\"name\": \"Ori ental Bank of Commerce\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"PMCB\": {\n\t\t\t\"name\": \"Punjab & Maharashtra Co-operative Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"PSIB\": {\n\t\t\t\"name\": \"Punjab & Sind Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"RATN\": {\n\t\t\t\"name\": \"RBL Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"SBBJ\": {\n\t\t\t\"name\": \"State Bank of Bikaner and Jaipur\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"SBHY\": {\n\t\t\t\"name\": \"State Bank of Hyderabad\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"SBIN\": {\n\t\t\t\"name\": \"State Bank of India\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"SBMY\": {\n\t\t\t\"name\": \"State Bank of Mysore\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"SBTR\": {\n\t\t\t\"name\": \"State Bank of Travancore\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"SCBL\": {\n\t\t\t\"name\": \"Standard Chartered Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"SIBL\": {\n\t\t\t\"name\": \"South Indian Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"SRCB\": {\n\t\t\t\"name\": \"Saraswat Co-operative Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"STBP\": {\n\t\t\t\"name\": \"State Bank of Patiala\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"SURY\": {\n\t\t\t\"name\": \"Suryoday Small Finance Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"SVCB\": {\n\t\t\t\"name\": \"Shamrao Vithal Co-operative Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"SYNB\": {\n\t\t\t\"name\": \"Syndicate Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"TBSB\": {\n\t\t\t\"name\": \"Thane Bharat Sahakari Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"TJSB\": {\n\t\t\t\"name\": \"Thane Janata Sahakari Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"TMBL\": {\n\t\t\t\"name\": \"Tamilnadu Mercantile Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"TNSC\": {\n\t\t\t\"name\": \"Tamilnadu State Apex Co-operative Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"UBIN\": {\n\t\t\t\"name\": \"Union Bank of India\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"UCBA\": {\n\t\t\t\"name\": \"UCO Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"UTBI\": {\n\t\t\t\"name\": \"United Bank of India\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"UTIB\": {\n\t\t\t\"name\": \"Axis Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"VARA\": {\n\t\t\t\"name\": \"Varachha Co-operative Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"VIJB\": {\n\t\t\t\"name\": \"Vijaya Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"YESB\": {\n\t\t\t\"name\": \"Yes Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"ZCBL\": {\n\t\t\t\"name\": \"Zoroastrian Co-operative Bank \",\n\t\t\t\"status\": true\n\t\t},\n\t\t\" ESFB\": {\n\t\t\t\"name\": \"Equitas Small Finance Bank\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"ANDB_C\": {\n\t\t\t\"name\": \"Andhra Bank - Corporate Banking\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"BARB_R\": {\n\t\t\t\"name\": \"Bank of Baroda - Retail Banking\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"DLXB_C\": {\n\t\t\t\"name\": \"Dhanlaxmi Bank - Corporate Banking\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"IBKL_C\": {\n\t\t\t\"name\": \"IDBI - Corporate Banking\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"LAVB_C\": {\n\t\t\t\"name\": \"Lakshmi Vilas Bank - Corporate Banking\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"LAVB_R\": {\n\t\t\t\"name\": \"Lakshmi Vilas Bank - Retail Banking\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"PUNB_R\": {\n\t\t\t\"name\": \"Punjab National Bank - Retail Banking\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"RATN_C\": {\n\t\t\t\"name\": \"RBL Bank - Corporate Banking\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"SVCB_C\": {\n\t\t\t\"name\": \"Shamrao Vithal Bank - Corporate Banking\",\n\t\t\t\"status\": true\n\t\t},\n\t\t\"YESB_C\": {\n\t\t\t\"name\": \"Yes Bank - Corporate Banking\",\n\t\t\t\"status\": true\n\t\t}\n\t}\n}");
                return;
            }
            t1Var.c().n(this.b0);
        }
    }

    @Override // defpackage.fe0
    public void j0() {
        setContentView(R.layout.custom_payment_layout);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().y(R.string.custom_payment_title);
        getSupportActionBar().o(true);
        this.r = (TextView) findViewById(R.id.popular_header);
        if (getIntent() != null) {
            getIntent().getStringExtra("src");
        }
        this.t = new JSONObject();
        this.z = (MPass) getIntent().getParcelableExtra("magic_pass_info");
        this.A = (MTicket) getIntent().getParcelableExtra("mticket_pass_info");
        this.C = getIntent().getBooleanExtra("arg_isSuperPassBookingFlow", false);
        this.D = (SuperPassOrderDetails) getIntent().getParcelableExtra("arg_superPassOrderDetails");
        this.F = (SuperPassUserDetails) getIntent().getParcelableExtra("arg_superPassUserDetails");
        this.E = (BookableSuperPassConfiguration) getIntent().getParcelableExtra("arg_bookableSuperPassConfig");
        this.G = getIntent().getBooleanExtra("arg_isCashPaymentAllowedForSuperPass", false);
        this.H = getIntent().getBooleanExtra("arg_isOnlineCardRechargePaymentFlow", false);
        this.I = getIntent().getStringExtra("argCardNumber");
        this.J = (CardRechargeConfiguration) getIntent().getParcelableExtra("arg_onlineCardRechargeConfig");
        this.K = (OnlineCardRechargeOrderDetails) getIntent().getParcelableExtra("arg_onlineCardRechargeOrderDetails");
        this.S = getIntent().getStringExtra(AnalyticsConstants.ORDER_ID);
        this.T = getIntent().getBooleanExtra("lpEligible", false);
        this.U = getIntent().getStringExtra("eligibilityResponseId");
        MTicket mTicket = this.A;
        if (mTicket != null) {
            this.L = mTicket.getRecentPaymentMethod();
        } else {
            MPass mPass = this.z;
            if (mPass != null) {
                this.L = mPass.getRecentPaymentMethod();
            } else {
                ScanPayTicket scanPayTicket = this.B;
                if (scanPayTicket != null) {
                    this.L = scanPayTicket.get_recentPaymentMethod();
                } else if (this.C) {
                    this.L = this.D.getRecentPaymentMethodsList();
                } else if (this.H) {
                    this.L = this.K.getRecentPaymentMethodsList();
                }
            }
        }
        for (String str : getIntent().getExtras().keySet()) {
            try {
                if (!str.equalsIgnoreCase("src") && !str.equalsIgnoreCase("eligibilityResponseId") && !str.equalsIgnoreCase("agency") && !str.equalsIgnoreCase("walletStatus")) {
                    if (str.equalsIgnoreCase(AnalyticsConstants.AMOUNT)) {
                        this.w = getIntent().getStringExtra(str);
                        getSupportActionBar().z(ui1.l(this.w));
                    }
                    if (str.equalsIgnoreCase(AnalyticsConstants.MERCHANT_KEY)) {
                        this.m.changeApiKey(getIntent().getStringExtra(AnalyticsConstants.MERCHANT_KEY));
                    } else {
                        this.t.put(str, getIntent().getStringExtra(str));
                    }
                    JSONObject jSONObject = new JSONObject();
                    MPass mPass2 = this.z;
                    if (mPass2 != null) {
                        jSONObject.put("passId", mPass2.getBookingPassId());
                        jSONObject.put("agency", this.z.getAgency());
                        jSONObject.put("passengerType", this.z.getPassengerType());
                        jSONObject.put("userId", this.z.getUserProfile().getUserId());
                        this.t.put("notes", jSONObject);
                        this.t.put(AnalyticsConstants.CONTACT, this.z.getUserProfile().getPhone());
                        this.t.put("customer_id", this.z.getCustomerId());
                    } else {
                        MTicket mTicket2 = this.A;
                        if (mTicket2 != null) {
                            jSONObject.put("passId", mTicket2.getMTicketId());
                            jSONObject.put("agency", this.A.getAgency());
                            jSONObject.put("userId", this.A.getUserId());
                            this.t.put("notes", jSONObject);
                            this.t.put(AnalyticsConstants.CONTACT, this.A.getUserId());
                            this.t.put("customer_id", this.A.getCustomerId());
                        } else {
                            ScanPayTicket scanPayTicket2 = this.B;
                            if (scanPayTicket2 != null) {
                                jSONObject.put("passId", scanPayTicket2.get_transactionId());
                                jSONObject.put("agency", this.B.get_agencyName());
                                jSONObject.put("userId", this.B.get_userId());
                                this.t.put("notes", jSONObject);
                                this.t.put(AnalyticsConstants.CONTACT, this.B.get_userId());
                                this.t.put("customer_id", this.B.get_customerId());
                            } else if (this.C) {
                                jSONObject.put("passId", this.D.getTransactionId());
                                jSONObject.put("agency", this.E.getSuperPassProductConfigurationProperties().getProductAgency());
                                jSONObject.put("passengerType", this.E.getSelectedProductCategory().getCategoryId());
                                jSONObject.put("userId", this.F.getUserId());
                                this.t.put("notes", jSONObject);
                                this.t.put(AnalyticsConstants.CONTACT, this.F.getMobileNumber());
                                this.t.put("customer_id", this.D.getRazorPayCustomerId());
                            } else if (this.H) {
                                jSONObject.put("passId", this.K.getTransactionId());
                                jSONObject.put("agency", this.J.getAgency());
                                xt.t1 t1Var = xt.f3961a;
                                jSONObject.put("userId", t1Var.m0());
                                this.t.put("notes", jSONObject);
                                this.t.put(AnalyticsConstants.CONTACT, t1Var.L().e().getPhone());
                                this.t.put("customer_id", this.K.getRazorPayCustomerId());
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.p = (RecyclerView) findViewById(R.id.payment_modes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1, false);
        this.s = linearLayoutManager;
        this.p.setLayoutManager(linearLayoutManager);
        this.p.setNestedScrollingEnabled(false);
        Object obj = q5.f2896a;
        this.p.f(new f(q5.c.b(this, R.drawable.divider)));
        this.o = (RecyclerView) findViewById(R.id.preferred_mode_container);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(1, false);
        this.s = linearLayoutManager2;
        this.o.setLayoutManager(linearLayoutManager2);
        this.o.setNestedScrollingEnabled(false);
        this.o.f(new f(q5.c.b(this, R.drawable.divider)));
        this.q = (RecyclerView) findViewById(R.id.other_modes);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(1, false);
        this.s = linearLayoutManager3;
        this.q.setLayoutManager(linearLayoutManager3);
        this.q.setNestedScrollingEnabled(false);
        this.q.f(new f(q5.c.b(this, R.drawable.divider)));
        this.n = (WebView) findViewById(R.id.payment_webview);
        this.v = (ProgressBar) findViewById(R.id.progressBar);
        this.u = (NestedScrollView) findViewById(R.id.main_layout);
        this.n.setVisibility(8);
        this.v.setVisibility(8);
        this.u.setVisibility(0);
        this.m.setWebView(this.n);
        findViewById(R.id.checkout_no_internet).setVisibility(8);
        n0();
    }

    public final void k0(List<PaymentItem> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.x.size(); i++) {
            if (this.x.get(i).getTagName().equalsIgnoreCase("top_mode")) {
                PaymentItem paymentItem = this.x.get(i);
                paymentItem.setIsEnabled(!(!paymentItem.isEnabled()));
                arrayList.add(this.x.get(i));
            }
        }
        vj0 vj0 = new vj0(this, arrayList, this.O);
        vj0.l = this.w;
        vj0.i = list;
        vj0.k = this;
        this.p.setAdapter(vj0);
    }

    public final void l0(Intent intent) {
        try {
            Set<String> keySet = intent.getExtras().keySet();
            for (String str : keySet) {
                if (!str.equalsIgnoreCase("src") && !str.equalsIgnoreCase("eligibilityResponseId") && !str.equalsIgnoreCase("agency") && !str.equalsIgnoreCase("walletStatus")) {
                    if (str.equalsIgnoreCase("card[number]")) {
                        if (keySet.contains("save") && intent.getIntExtra("save", 0) == 1) {
                            sf1 l = xt.f3961a.l();
                            String stringExtra = intent.getStringExtra("card[number]");
                            int length = stringExtra.length();
                            if (length > 4) {
                                stringExtra = "************" + stringExtra.substring(length - 4, length);
                            }
                            l.put("paymentApp", stringExtra);
                        }
                        this.t.put(str, intent.getStringExtra(str));
                    } else if (str.equalsIgnoreCase("save")) {
                        this.t.put(str, intent.getIntExtra("save", 0));
                    } else if (str.equalsIgnoreCase(AnalyticsConstants.MERCHANT_KEY)) {
                        this.m.changeApiKey(getIntent().getStringExtra(AnalyticsConstants.MERCHANT_KEY));
                    } else {
                        this.t.put(str, intent.getStringExtra(str));
                    }
                }
            }
            JSONObject jSONObject = this.t;
            this.m.validateFields(jSONObject, new sd0(this, jSONObject));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void m0() {
        int i;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            this.x.get(i2).setPreferredMode(false);
        }
        List<RecentPaymentMethod> list = this.L;
        if (list == null || list.size() <= 0) {
            i = 0;
        } else {
            this.r.setText(getResources().getString(R.string.preferred_payment_heading));
            i = this.L.size();
            for (int i3 = 0; i3 < this.L.size(); i3++) {
                for (int i4 = 0; i4 < this.x.size(); i4++) {
                    PaymentItem paymentItem = this.x.get(i4);
                    if (this.L.get(i3).getPaymentMethod().equalsIgnoreCase(AnalyticsConstants.NETBANKING)) {
                        if (paymentItem.getTagName().equalsIgnoreCase("netbanking_items") && paymentItem.getBankName().equalsIgnoreCase(this.L.get(i3).getPaymentDetails())) {
                            paymentItem.setPreferredMode(true);
                            this.x.get(i4).setPreferredMode(true);
                            if (arrayList.size() < 5) {
                                arrayList.add(paymentItem);
                            }
                        }
                    } else if (this.L.get(i3).getPaymentMethod().equalsIgnoreCase(AnalyticsConstants.WALLET)) {
                        if (paymentItem.getTagName().equalsIgnoreCase(AnalyticsConstants.WALLET) && paymentItem.getAppName().equalsIgnoreCase(this.L.get(i3).getPaymentDetails())) {
                            paymentItem.setPreferredMode(true);
                            this.x.get(i4).setPreferredMode(true);
                            if (arrayList.size() < 5) {
                                arrayList.add(paymentItem);
                            }
                        }
                    } else if (this.L.get(i3).getPaymentMethod().equalsIgnoreCase(AnalyticsConstants.UPI)) {
                        if (paymentItem.getAppName().equalsIgnoreCase(this.L.get(i3).getPaymentAppName())) {
                            paymentItem.setPreferredMode(true);
                            this.x.get(i4).setPreferredMode(true);
                            if (arrayList.size() < 5) {
                                arrayList.add(paymentItem);
                            }
                        }
                    } else if (this.L.get(i3).getPaymentMethod().equalsIgnoreCase(AnalyticsConstants.CARD) && paymentItem.getAppName().equalsIgnoreCase(this.L.get(i3).getPaymentAppName())) {
                        paymentItem.setPreferredMode(true);
                        this.x.get(i4).setPreferredMode(true);
                        if (arrayList.size() < 5) {
                            arrayList.add(paymentItem);
                        }
                    }
                }
            }
        }
        Iterator<Map.Entry<String, List<String>>> it = this.y.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, List<String>> next = it.next();
            List<String> value = next.getValue();
            for (int i5 = 0; i5 < value.size(); i5++) {
                for (int i6 = 0; i6 < this.x.size(); i6++) {
                    if (this.x.get(i6).getTagName().equalsIgnoreCase(next.getKey().toString())) {
                        this.x.get(i6).getTagName().equalsIgnoreCase(AnalyticsConstants.UPI);
                        if (this.x.get(i6).getAppName().equalsIgnoreCase(value.get(i5)) && !this.x.get(i6).isPreferredMode()) {
                            this.x.get(i6).setPreferredMode(true);
                            if (arrayList.size() < 5) {
                                arrayList.add(this.x.get(i6));
                            }
                        }
                    }
                }
            }
            it.remove();
        }
        int size = arrayList.size();
        if (arrayList.size() == 0) {
            this.R = false;
            this.r.setVisibility(8);
            this.o.setVisibility(8);
            findViewById(R.id.other_title).setVisibility(8);
        } else {
            this.R = true;
            this.r.setVisibility(0);
            this.o.setVisibility(0);
            findViewById(R.id.other_title).setVisibility(0);
        }
        vj0 vj0 = new vj0(this, arrayList, this.O);
        vj0.k = this;
        vj0.l = this.w;
        this.o.setAdapter(vj0);
        String valueOf = String.valueOf(i);
        String valueOf2 = String.valueOf(size);
        ed1 l = hj1.l("Payment Modes Screen opened", Long.MIN_VALUE, "preferred mode", valueOf);
        l.a("popular mode", valueOf2);
        if (getIntent().hasExtra("src")) {
            hj1.F0(this, "src", l, "source");
        }
        jz5.b().g(l);
        zz zzVar = new zz("payment checkout screen open", new HashMap());
        if (getIntent().hasExtra("src")) {
            zzVar.a("source", getIntent().getStringExtra("src"));
        }
        ui1.l0(zzVar);
    }

    public final void n0() {
        if (vn.K0(this)) {
            this.c0 = false;
            e0();
        } else if (!this.c0) {
            this.c0 = f0(null);
        }
    }

    public final void o0() {
        xt.f3961a.j().a();
        Intent intent = new Intent();
        intent.putExtra("arg_paymentMode", "online");
        setResult(-1, intent);
        finish();
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (findViewById(R.id.checkout_no_internet) != null) {
            findViewById(R.id.checkout_no_internet).setVisibility(8);
        }
        if (i == 137 && i2 == -1) {
            l0(intent);
        } else if (i == 138 && i2 == -1) {
            l0(intent);
        } else {
            Razorpay razorpay = this.m;
            if (razorpay != null && i != 137 && i != 138) {
                razorpay.onActivityResult(i, i2, intent);
                if (i == 431 && i2 == -1) {
                    r0();
                    this.Z = true;
                    if (this.C) {
                        p0(intent.getStringExtra(SuperPassJsonKeys.QR_CODE), intent.getStringExtra(SuperPassJsonKeys.TONE));
                    } else if (this.H) {
                        o0();
                    } else {
                        t0(intent.getStringExtra(SuperPassJsonKeys.QR_CODE), intent.getStringExtra(SuperPassJsonKeys.TONE));
                    }
                }
            } else if (i == 431 && i2 == -1) {
                r0();
                this.Z = true;
                if (this.C) {
                    p0(intent.getStringExtra(SuperPassJsonKeys.QR_CODE), intent.getStringExtra(SuperPassJsonKeys.TONE));
                } else if (this.H) {
                    o0();
                } else {
                    t0(intent.getStringExtra(SuperPassJsonKeys.QR_CODE), intent.getStringExtra(SuperPassJsonKeys.TONE));
                }
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.wt
    public void onBackPressed() {
        if (this.Q) {
            this.n.setVisibility(8);
            q0(this.u);
            q0(this.o);
            q0(this.p);
            this.q.setVisibility(8);
            this.Q = false;
            getSupportActionBar().z(ui1.l(this.w));
            this.P = false;
            if (this.R) {
                this.r.setVisibility(0);
                findViewById(R.id.other_title).setVisibility(0);
                return;
            }
            findViewById(R.id.other_title).setVisibility(8);
            this.r.setVisibility(8);
        } else if (this.P) {
            q0(this.u);
            getSupportActionBar().z(ui1.l(this.w));
            q0(this.o);
            q0(this.p);
            this.q.setVisibility(8);
            this.P = false;
            if (this.R) {
                this.r.setVisibility(0);
                findViewById(R.id.other_title).setVisibility(0);
                return;
            }
            findViewById(R.id.other_title).setVisibility(8);
            this.r.setVisibility(8);
        } else {
            Razorpay razorpay = this.m;
            if (razorpay != null) {
                razorpay.onBackPressed();
            }
            WebView webView = this.n;
            if (webView == null || webView.getVisibility() != 0) {
                super.onBackPressed();
                return;
            }
            this.n.setVisibility(8);
            this.u.setVisibility(0);
            findViewById(R.id.toolbar).setVisibility(0);
            getSupportActionBar().z(ui1.l(this.w));
        }
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onDestroy() {
        super.onDestroy();
        jz5.b().o(this);
    }

    public void onEvent(RazorpayPaymentFetchEvent razorpayPaymentFetchEvent) {
        if (razorpayPaymentFetchEvent.getResponseType().equals(ad1.SUCCESS)) {
            String valueOf = String.valueOf(true);
            HashMap hashMap = new HashMap();
            hashMap.put("response", valueOf);
            xt.t1 t1Var = xt.f3961a;
            t1Var.M().a(this);
            this.m = t1Var.M().b();
            String paymentMethods = razorpayPaymentFetchEvent.getPaymentMethods();
            if (paymentMethods != null) {
                i0();
                s0(paymentMethods);
                return;
            }
            String valueOf2 = String.valueOf(false);
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            hashMap.put("response", valueOf2);
            h0();
            return;
        }
        new HashMap().put("response", String.valueOf(false));
        h0();
        b00 b00 = b00.f358a;
        c00 a2 = b00.a();
        StringBuilder i0 = hj1.i0("Razorpay response error => ");
        i0.append(razorpayPaymentFetchEvent.getPaymentMethods());
        a2.b(new Throwable(i0.toString()));
    }

    @Override // defpackage.wt
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // com.razorpay.PaymentResultWithDataListener
    public void onPaymentError(int i, String str, PaymentData paymentData) {
        Toast.makeText(this, "Inside order id failed", 0);
    }

    @Override // com.razorpay.PaymentResultWithDataListener
    public void onPaymentSuccess(String str, PaymentData paymentData) {
        Toast.makeText(this, "Inside order id", 0);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        if (!jz5.b().f(this)) {
            jz5 b2 = jz5.b();
            b2.k(this, b2.e, true, 0);
        }
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }

    public final void p0(String str, String str2) {
        xt.f3961a.j().a();
        Intent intent = new Intent();
        intent.putExtra("arg_paymentMode", "online");
        intent.putExtra("arg_qrCode", str);
        intent.putExtra("arg_tone", str2);
        setResult(-1, intent);
        finish();
    }

    public final void q0(View view) {
        view.setAlpha(0.0f);
        view.setVisibility(0);
        view.animate().alpha(1.0f).setDuration(200).setListener(null);
    }

    public final void r0() {
        DialogFragment dialogFragment = this.V;
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void s0(String str) {
        JSONException e2;
        String str2;
        String str3;
        String str4;
        char c2;
        String str5;
        String str6;
        MPass mPass;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.M = jSONObject;
            this.O = jSONObject.optString("error_copy", getString(R.string.payment_issue));
            JSONObject jSONObject2 = this.M.getJSONObject("payment_modes");
            JSONObject jSONObject3 = this.M.getJSONObject("wallet_details");
            JSONObject jSONObject4 = this.M.getJSONObject("netbanking_details");
            JSONObject jSONObject5 = this.M.getJSONObject("upi_details");
            Iterator<String> keys = jSONObject2.keys();
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            while (true) {
                boolean hasNext = keys.hasNext();
                str2 = "isVisible";
                str3 = AnalyticsConstants.WARNING;
                str4 = "status";
                if (!hasNext) {
                    break;
                }
                String next = keys.next();
                JSONObject jSONObject6 = jSONObject2.getJSONObject(next);
                String string = jSONObject6.getString("name");
                String optString = jSONObject6.optString(Constants.ScionAnalytics.PARAM_LABEL);
                String optString2 = jSONObject6.optString(SuperPassJsonKeys.FARE_MAPPING_DESCRIPTION);
                boolean z2 = jSONObject6.getBoolean(str4);
                String optString3 = jSONObject6.optString(str3);
                int optInt = jSONObject6.optInt(ProductDiscountsObject.KEY_ORDER, Integer.MAX_VALUE);
                boolean optBoolean = jSONObject6.optBoolean(str2, true);
                MethodDetails methodDetails = new MethodDetails(string, z2);
                methodDetails.setOrder(optInt);
                methodDetails.setLabel(optString);
                methodDetails.setDesc(optString2);
                methodDetails.setIsTopMode(true);
                methodDetails.setWarning(optString3);
                methodDetails.setIsVisible(optBoolean);
                arrayList.add(methodDetails);
                hashMap.put(next, methodDetails);
                jSONObject2 = jSONObject2;
                keys = keys;
            }
            LinkedList<Map.Entry> linkedList = new LinkedList(hashMap.entrySet());
            Collections.sort(linkedList, new c(this));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : linkedList) {
                linkedHashMap.put((String) entry.getKey(), (MethodDetails) entry.getValue());
            }
            Iterator it = linkedHashMap.entrySet().iterator();
            ArrayList arrayList2 = new ArrayList();
            while (it.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it.next();
                MethodDetails methodDetails2 = (MethodDetails) entry2.getValue();
                String valueOf = String.valueOf(entry2.getKey());
                switch (valueOf.hashCode()) {
                    case -795192327:
                        if (valueOf.equals(AnalyticsConstants.WALLET)) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -40437580:
                        if (valueOf.equals("lazypay")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 116014:
                        if (valueOf.equals(AnalyticsConstants.UPI)) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3046160:
                        if (valueOf.equals(AnalyticsConstants.CARD)) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3046195:
                        if (valueOf.equals(SuperPassPaymentConstants.PAYMENT_MODE_CASH)) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1954534377:
                        if (valueOf.equals(AnalyticsConstants.NETBANKING)) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                int i = c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? c2 != 4 ? c2 != 5 ? -1 : R.drawable.netbanking : R.drawable.cash : R.drawable.debit_card : R.drawable.upi : R.drawable.lazy_pay : R.drawable.wallet;
                if (i != -1) {
                    PaymentItem paymentItem = new PaymentItem(i, methodDetails2.getMethodName(), "top_mode", methodDetails2.getMethodStatus(), methodDetails2.getWarning());
                    paymentItem.setDesc(methodDetails2.getDesc());
                    paymentItem.setLabel(methodDetails2.getLabel());
                    if (methodDetails2.getVisibility()) {
                        if (methodDetails2.getMethodName().equalsIgnoreCase("lazypay")) {
                            paymentItem.setIsEnabled(this.T && methodDetails2.getMethodStatus());
                            paymentItem.setIsModeEnable(this.T && methodDetails2.getMethodStatus());
                            paymentItem.set_isLazypayDisabled(this.T);
                            str5 = str2;
                            str6 = str3;
                            ed1 ed1 = new ed1("lpEligibility", Long.MIN_VALUE);
                            ed1.a("lpEligibilityValue", Boolean.valueOf(this.T));
                            jz5.b().g(ed1);
                        } else {
                            str5 = str2;
                            str6 = str3;
                        }
                        if ((!methodDetails2.getMethodName().equalsIgnoreCase(SuperPassPaymentConstants.PAYMENT_MODE_CASH) || (((mPass = this.z) != null && mPass.getNoOfDays() > 1) || (this.C && this.G))) && ((methodDetails2.getMethodName().equalsIgnoreCase("lazypay") && xt.f3961a.t().b("lazyPayVisibility") && (this.B == null || this.T)) || !methodDetails2.getMethodName().equalsIgnoreCase("lazypay"))) {
                            arrayList2.add(paymentItem);
                            this.x.add(paymentItem);
                        }
                        it = it;
                        jSONObject5 = jSONObject5;
                        str3 = str6;
                        str2 = str5;
                    }
                }
                str5 = str2;
                str6 = str3;
                it = it;
                jSONObject5 = jSONObject5;
                str3 = str6;
                str2 = str5;
            }
            JSONObject jSONObject7 = jSONObject5;
            String str7 = str2;
            String str8 = str3;
            Iterator<String> keys2 = jSONObject3.keys();
            HashMap hashMap2 = new HashMap();
            while (keys2.hasNext()) {
                try {
                    String next2 = keys2.next();
                    JSONObject jSONObject8 = jSONObject3.getJSONObject(next2);
                    String string2 = jSONObject8.getString("name");
                    String optString4 = jSONObject8.optString(SuperPassJsonKeys.FARE_MAPPING_DESCRIPTION);
                    String optString5 = jSONObject8.optString(Constants.ScionAnalytics.PARAM_LABEL);
                    boolean z3 = jSONObject8.getBoolean(str4);
                    String optString6 = jSONObject8.optString(str8);
                    boolean optBoolean2 = jSONObject8.optBoolean(str7, true);
                    MethodDetails methodDetails3 = new MethodDetails(string2, z3);
                    methodDetails3.setWarning(optString6);
                    methodDetails3.setIsVisible(optBoolean2);
                    methodDetails3.setDesc(optString4);
                    methodDetails3.setLabel(optString5);
                    if (optBoolean2) {
                        hashMap2.put(next2, methodDetails3);
                    }
                    str7 = str7;
                    keys2 = keys2;
                    jSONObject3 = jSONObject3;
                    str8 = str8;
                } catch (JSONException e3) {
                    e2 = e3;
                    e2.getMessage();
                }
            }
            Iterator<String> keys3 = jSONObject4.keys();
            HashMap hashMap3 = new HashMap();
            while (keys3.hasNext()) {
                String next3 = keys3.next();
                JSONObject jSONObject9 = jSONObject4.getJSONObject(next3);
                String string3 = jSONObject9.getString("name");
                String optString7 = jSONObject9.optString(str8);
                boolean z4 = jSONObject9.getBoolean(str4);
                String optString8 = jSONObject9.optString(Constants.ScionAnalytics.PARAM_LABEL);
                String optString9 = jSONObject9.optString(SuperPassJsonKeys.FARE_MAPPING_DESCRIPTION);
                boolean optBoolean3 = jSONObject9.optBoolean(str7, true);
                MethodDetails methodDetails4 = new MethodDetails(string3, z4);
                methodDetails4.setWarning(optString7);
                methodDetails4.setDesc(optString9);
                methodDetails4.setLabel(optString8);
                if (optBoolean3) {
                    hashMap3.put(next3, methodDetails4);
                }
                keys3 = keys3;
                jSONObject4 = jSONObject4;
            }
            Iterator<String> keys4 = jSONObject7.keys();
            HashMap hashMap4 = new HashMap();
            while (keys4.hasNext()) {
                String next4 = keys4.next();
                JSONObject jSONObject10 = jSONObject7.getJSONObject(next4);
                String string4 = jSONObject10.getString("name");
                boolean z5 = jSONObject10.getBoolean(str4);
                String optString10 = jSONObject10.optString(SuperPassJsonKeys.FARE_MAPPING_DESCRIPTION);
                String optString11 = jSONObject10.optString(Constants.ScionAnalytics.PARAM_LABEL);
                jSONObject7 = jSONObject7;
                String optString12 = jSONObject10.optString(str8);
                boolean optBoolean4 = jSONObject10.optBoolean(str7, true);
                MethodDetails methodDetails5 = new MethodDetails(string4, z5);
                methodDetails5.setIsVisible(optBoolean4);
                methodDetails5.setDesc(optString10);
                methodDetails5.setLabel(optString11);
                methodDetails5.setWarning(optString12);
                hashMap4.put(next4, methodDetails5);
                keys4 = keys4;
                str4 = str4;
            }
            try {
                JSONObject optJSONObject = this.M.optJSONObject("error");
                if (optJSONObject != null) {
                    try {
                        Iterator<String> keys5 = optJSONObject.keys();
                        while (keys5.hasNext()) {
                            String next5 = keys5.next();
                            ArrayList arrayList3 = new ArrayList();
                            JSONArray optJSONArray = optJSONObject.optJSONArray(next5);
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                arrayList3.add(String.valueOf(optJSONArray.get(i2)));
                            }
                            this.N.put(next5, arrayList3);
                        }
                    } catch (JSONException unused) {
                    }
                }
                ArrayList arrayList4 = new ArrayList();
                for (Map.Entry entry3 : hashMap3.entrySet()) {
                    String str9 = (String) entry3.getKey();
                    PaymentItem paymentItem2 = new PaymentItem(this.m.getBankLogoUrl(str9), ((MethodDetails) entry3.getValue()).getMethodName(), "netbanking_items", ((MethodDetails) entry3.getValue()).getMethodStatus(), ((MethodDetails) entry3.getValue()).getWarning());
                    paymentItem2.putBankName(str9);
                    arrayList4.add(paymentItem2);
                }
                this.x.addAll(arrayList4);
                ArrayList arrayList5 = new ArrayList();
                for (Map.Entry entry4 : hashMap2.entrySet()) {
                    String methodName = ((MethodDetails) entry4.getValue()).getMethodName();
                    arrayList5.add(new PaymentItem(this.m.getWalletSqLogoUrl(methodName), methodName, AnalyticsConstants.WALLET, ((MethodDetails) entry4.getValue()).getMethodStatus(), ((MethodDetails) entry4.getValue()).getWarning()));
                }
                this.x.addAll(arrayList5);
                k0(arrayList4);
                BaseRazorpay.getAppsWhichSupportUpi(this, new rd0(this, hashMap4));
                m0();
            } catch (JSONException e4) {
                e2 = e4;
                e2.getMessage();
            }
        } catch (JSONException e5) {
            e2 = e5;
            e2.getMessage();
        }
    }

    public final void t0(String str, String str2) {
        MPass mPass = this.z;
        if (mPass != null) {
            mPass.setQrCode(str);
            this.z.setTone(str2);
            xt.f3961a.c().S(this.z, false);
            ActivatePassScreen.i0(this, this.z, "checkout screen", true);
        }
        MTicket mTicket = this.A;
        if (mTicket != null) {
            mTicket.setQrCode(str);
            this.A.setTone(str2);
            ed1 ed1 = new ed1("mticket get qrCode response received", Long.MIN_VALUE);
            ed1.a("response", String.valueOf(true));
            vn.a(ed1, this.A);
            if (getIntent().hasExtra("src")) {
                hj1.F0(this, "src", ed1, "source");
            }
            jz5.b().g(ed1);
            ProductRepository productRepository = new ProductRepository(this);
            Ticket ticket = new Ticket();
            ticket.setTicketId(this.A.getMTicketId());
            this.A.setQrCode(str);
            MTicket mTicket2 = this.A;
            mTicket2.setCityName(mTicket2.getCityName().toLowerCase());
            ticket.setmTicket(this.A);
            productRepository.insertTicket(ticket);
            ActivateMTicketScreen.h0(this, this.A, "checkout screen", true);
        }
        ScanPayTicket scanPayTicket = this.B;
        if (scanPayTicket != null) {
            scanPayTicket.set_qrCode(str);
            this.B.set_tone(str2);
            if (!ui1.B0() || str2 == null) {
                ActiveScanPayScreen.h0(this, this.B, "checkout screen", true);
            } else {
                ValidationScreen.j0(this, this.B, "checkout screen", true);
            }
        }
        xt.f3961a.j().a();
    }

    public final void u0(String str, ad1 ad1) {
        ed1 ed1 = new ed1(str, Long.MIN_VALUE);
        ed1.a("response", ad1.name());
        MPass mPass = this.z;
        if (mPass != null) {
            ed1.a(SuperPassJsonKeys.ORDER_ID, mPass.getOrderId());
            ed1.a("bookingId", this.z.getBookingPassId());
        } else {
            MTicket mTicket = this.A;
            if (mTicket != null) {
                ed1.a(SuperPassJsonKeys.ORDER_ID, mTicket.getOrderId());
                ed1.a("bookingId", this.A.getMTicketId());
            } else if (this.C) {
                ed1.a(SuperPassJsonKeys.ORDER_ID, this.S);
                ed1.a("bookingId", this.D.getTransactionId());
            } else if (this.H) {
                ed1.a(SuperPassJsonKeys.ORDER_ID, this.S);
                ed1.a("bookingId", this.K.getTransactionId());
            }
        }
        jz5.b().g(ed1);
    }

    public void v0(Bundle bundle) {
        findViewById(R.id.toolbar).setVisibility(0);
        try {
            for (String str : bundle.keySet()) {
                if (!str.equalsIgnoreCase("src") && !str.equalsIgnoreCase("eligibilityResponseId")) {
                    this.t.put(str, bundle.get(str));
                }
            }
            JSONObject jSONObject = this.t;
            this.m.validateFields(jSONObject, new sd0(this, jSONObject));
        } catch (JSONException unused) {
        }
    }

    public void w0(String str) {
        this.P = true;
        this.r.setVisibility(8);
        this.o.setVisibility(8);
        findViewById(R.id.other_title).setVisibility(8);
        int i = 0;
        findViewById(R.id.toolbar).setVisibility(0);
        this.p.setVisibility(8);
        findViewById(R.id.checkout_no_internet).setVisibility(8);
        q0(this.q);
        q0(findViewById(R.id.main_layout));
        if (str.equalsIgnoreCase(AnalyticsConstants.UPI)) {
            ArrayList arrayList = new ArrayList();
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.other_modes);
            this.q = recyclerView;
            recyclerView.setVisibility(0);
            while (i < this.x.size()) {
                if (this.x.get(i).getTagName().equalsIgnoreCase(AnalyticsConstants.UPI)) {
                    PaymentItem paymentItem = this.x.get(i);
                    paymentItem.setIsEnabled(!(!paymentItem.isEnabled()));
                    arrayList.add(paymentItem);
                }
                i++;
            }
            if (arrayList.size() == 0) {
                q0(findViewById(R.id.upi_empty_state));
                findViewById(R.id.main_layout).setVisibility(8);
                return;
            }
            vj0 vj0 = new vj0(this, arrayList, this.O);
            vj0.l = this.w;
            vj0.k = this;
            vj0.notifyDataSetChanged();
            this.q.setAdapter(vj0);
        } else if (str.equalsIgnoreCase(AnalyticsConstants.WALLET)) {
            findViewById(R.id.other_title).setVisibility(8);
            RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.other_modes);
            this.q = recyclerView2;
            q0(recyclerView2);
            ArrayList arrayList2 = new ArrayList();
            while (i < this.x.size()) {
                if (this.x.get(i).getTagName().equalsIgnoreCase(AnalyticsConstants.WALLET)) {
                    PaymentItem paymentItem2 = this.x.get(i);
                    paymentItem2.setIsEnabled(!(!paymentItem2.isEnabled()));
                    arrayList2.add(paymentItem2);
                }
                i++;
            }
            vj0 vj02 = new vj0(this, arrayList2, this.O);
            vj02.l = this.w;
            vj02.k = this;
            this.q.setAdapter(vj02);
            vj02.notifyDataSetChanged();
        }
    }

    public final void x0() {
        DialogFragment dialogFragment;
        fv0 fv0 = (fv0) getFragmentManager().findFragmentByTag("loader_tag");
        this.V = fv0;
        if (fv0 == null) {
            fv0 T2 = vn.T(null, getString(R.string.loading), false, false);
            this.V = T2;
            T2.setRetainInstance(true);
        }
        if (!this.j.equals(au.a.DESTROYED) && !isFinishing() && (dialogFragment = this.V) != null && !dialogFragment.isVisible()) {
            this.V.show(getFragmentManager(), "TAG");
        }
    }

    public final void y0(String str, boolean z2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(R.layout.aler_dialog_view, (ViewGroup) null);
        builder.setView(inflate);
        builder.setCancelable(false);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_subtitle);
        TextView textView3 = (TextView) inflate.findViewById(R.id.positive_button);
        TextView textView4 = (TextView) inflate.findViewById(R.id.negative_button);
        AlertDialog create = builder.create();
        if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("checkHistory")) {
            textView.setText(getString(R.string.payment_failed_title));
            textView2.setText(getString(R.string.payment_failed_details));
        } else {
            textView.setText(getString(R.string.payment_status_unclear_title));
            textView2.setText(getString(R.string.payment_internet_issue));
            this.W.g(this.S, true);
        }
        textView3.setText(getString(R.string.ok));
        textView4.setText(getString(R.string.dismiss_caps));
        textView4.setVisibility(8);
        create.show();
        textView4.setOnClickListener(new a(create, str));
        textView3.setOnClickListener(new b(str, create, z2));
        r0();
    }

    public final void z0(JSONObject jSONObject) {
        try {
            if (jSONObject.has("isPreferredMode")) {
                this.Q = !jSONObject.getBoolean("isPreferredMode");
                if (this.P) {
                    this.Q = true;
                }
            } else {
                this.Q = true;
                this.P = true;
            }
            jSONObject.remove("isPreferredMode");
            this.n.loadUrl("about:blank");
            this.n.setVisibility(0);
            getSupportActionBar().y(R.string.payment_breakdown);
            this.u.setVisibility(8);
            findViewById(R.id.checkout_no_internet).setVisibility(8);
            this.m.setWebChromeClient(new qd0(this, this.m));
            this.m.setWebviewClient(new td0(this, this.m));
            MPass mPass = this.z;
            if (mPass != null && mPass.get_productType().equals("superSaver")) {
                this.X.g(this.z.getBookingPassId(), true);
                xt.f3961a.c().n0(this.z.getBookingPassId());
            }
            this.m.submit(jSONObject, new PaymentResultWithDataListener() {
                /* class app.zophop.ui.activities.CheckoutActivity.AnonymousClass8 */

                @Override // com.razorpay.PaymentResultWithDataListener
                public void onPaymentError(int i, String str, PaymentData paymentData) {
                    CheckoutActivity checkoutActivity = CheckoutActivity.this;
                    int i2 = CheckoutActivity.d0;
                    checkoutActivity.x0();
                    MPass mPass = CheckoutActivity.this.z;
                    if (mPass != null && mPass.get_productType().equals("superSaver")) {
                        CheckoutActivity checkoutActivity2 = CheckoutActivity.this;
                        checkoutActivity2.X.k(checkoutActivity2.z.getBookingPassId());
                    }
                    xt.f3961a.c().a(CheckoutActivity.this.S, null);
                    CheckoutActivity.this.getSupportActionBar().z(ui1.l(CheckoutActivity.this.getIntent().getStringExtra(AnalyticsConstants.AMOUNT)));
                    CheckoutActivity checkoutActivity3 = CheckoutActivity.this;
                    MPass mPass2 = checkoutActivity3.z;
                    if (mPass2 != null) {
                        ed1 ed1 = new ed1("pass payment failed", Long.MIN_VALUE);
                        ed1.a("passengerType", mPass2.getPassengerType());
                        ed1.a("numDays", "" + checkoutActivity3.z.getNoOfDays());
                        ed1.a("bookingId", checkoutActivity3.z.getBookingPassId());
                        ed1.a("bookingDate", jh1.c(checkoutActivity3.z.getBookingTime()));
                        ed1.a("startDate", jh1.c(checkoutActivity3.z.getStartingTime()));
                        ed1.a("expiryDate", jh1.c(checkoutActivity3.z.getExpiryTime()));
                        ed1.a("hourOfEvent", jh1.j(System.currentTimeMillis()) + "");
                        ed1.a("errorCode", "" + i);
                        StringBuilder f0 = hj1.f0(ed1, "reason", str);
                        f0.append(checkoutActivity3.z.getNoOfDays());
                        f0.append("");
                        ed1.a("productType", f0.toString());
                        ed1.a("productCost", checkoutActivity3.z.getFare() + "");
                        if (checkoutActivity3.getIntent() != null) {
                            hj1.F0(checkoutActivity3, "src", ed1, "source");
                        }
                        ed1.a("paymentMode", checkoutActivity3.z.getPaymentMode());
                        jz5.b().g(ed1);
                    } else {
                        MTicket mTicket = checkoutActivity3.A;
                        if (mTicket != null) {
                            ed1 ed12 = new ed1("mticket payment failed", Long.MIN_VALUE);
                            vn.a(ed12, mTicket);
                            ed12.a("hourOfEvent", jh1.j(System.currentTimeMillis()) + "");
                            ed12.a("paymentMode", "online");
                            ed12.a("errorCode", "" + i);
                            ed12.a("reason", str);
                            if (checkoutActivity3.getIntent().hasExtra("src")) {
                                hj1.F0(checkoutActivity3, "src", ed12, "source");
                            }
                            jz5.b().g(ed12);
                        } else if (checkoutActivity3.C) {
                            ed1 ed13 = new ed1("pass payment failed", Long.MIN_VALUE);
                            ed13.a("passengerType", checkoutActivity3.E.getSelectedProductCategory().getCategoryId());
                            ed13.a("numDays", "" + checkoutActivity3.E.getSelectedProductFareMapping().getNoOfDays());
                            ed13.a("bookingId", checkoutActivity3.D.getTransactionId());
                            ed13.a("hourOfEvent", jh1.j(ui1.Q()) + "");
                            ed13.a("errorCode", "" + i);
                            ed13.a("reason", str);
                            ed13.a("bookingDate", jh1.c(checkoutActivity3.D.getBookingTime()));
                            ed13.a("expiryDate", jh1.c(checkoutActivity3.D.getExpiryTime()));
                            ed13.a("productType", checkoutActivity3.E.getSuperPassProductConfigurationProperties().getProductType() + "");
                            ed13.a("productSubType", checkoutActivity3.E.getSuperPassProductConfigurationProperties().getProductSubType() + "");
                            ed13.a("productCost", checkoutActivity3.E.getSelectedProductFareMapping().getFareInfo().getPayableAmount() + "");
                            if (checkoutActivity3.getIntent() != null) {
                                hj1.F0(checkoutActivity3, "src", ed13, "source");
                            }
                            jz5.b().g(ed13);
                        } else if (checkoutActivity3.H) {
                            ed1 ed14 = new ed1("online card recharge payment failed", Long.MIN_VALUE);
                            ed14.a("cardNumber", checkoutActivity3.I);
                            ed14.a("transactionId", checkoutActivity3.K.getTransactionId());
                            ed14.a("hourOfEvent", jh1.j(ui1.Q()) + "");
                            ed14.a("errorCode", "" + i);
                            ed14.a("reason", str);
                            ed14.a("bookingDate", jh1.c(checkoutActivity3.K.getBookingTime()));
                            ed14.a("productType", checkoutActivity3.J.getProductType());
                            ed14.a("productSubType", checkoutActivity3.J.getProductSubType());
                            ed14.a(AnalyticsConstants.AMOUNT, checkoutActivity3.w);
                            if (checkoutActivity3.getIntent() != null) {
                                hj1.F0(checkoutActivity3, "src", ed14, "source");
                            }
                            jz5.b().g(ed14);
                        }
                    }
                    CheckoutActivity.this.n.setVisibility(8);
                    CheckoutActivity.this.u.setVisibility(0);
                }

                @Override // com.razorpay.PaymentResultWithDataListener
                public void onPaymentSuccess(String str, PaymentData paymentData) {
                    String orderId = paymentData.getOrderId();
                    String paymentId = paymentData.getPaymentId();
                    CheckoutActivity checkoutActivity = CheckoutActivity.this;
                    MPass mPass = checkoutActivity.z;
                    if (mPass != null) {
                        ed1 ed1 = new ed1("pass booked", Long.MIN_VALUE);
                        ed1.a("passengerType", mPass.getPassengerType());
                        ed1.a("numDays", "" + checkoutActivity.z.getNoOfDays());
                        ed1.a("bookingId", checkoutActivity.z.getBookingPassId());
                        ed1.a("productType", checkoutActivity.z.get_productType());
                        ed1.a(SuperPassJsonKeys.ORDER_ID, orderId);
                        ed1.a("paymentId", paymentId);
                        ed1.a("bookingDate", jh1.c(checkoutActivity.z.getBookingTime()));
                        ed1.a("startDate", jh1.c(checkoutActivity.z.getStartingTime()));
                        ed1.a("expiryDate", jh1.c(checkoutActivity.z.getExpiryTime()));
                        ed1.a("hourOfEvent", jh1.j(System.currentTimeMillis()) + "");
                        List<MPass> l = xt.f3961a.c().l();
                        if (!(l == null || l.size() == 0)) {
                            boolean z = false;
                            for (MPass mPass2 : l) {
                                if (mPass2.getPassengerType().equals(checkoutActivity.z.getPassengerType()) && !checkoutActivity.z.getBookingPassId().equals(mPass2.getBookingPassId())) {
                                    z = true;
                                }
                            }
                            ed1.a("isRenewedPass", String.valueOf(z));
                        }
                        if (checkoutActivity.getIntent() != null) {
                            hj1.F0(checkoutActivity, "src", ed1, "source");
                        }
                        ed1.a("productType", checkoutActivity.z.getNoOfDays() + "");
                        ed1.a("paymentMode", checkoutActivity.z.getPaymentMode());
                        ed1.a("productCost", checkoutActivity.z.getFare() + "");
                        jz5.b().g(ed1);
                    } else {
                        MTicket mTicket = checkoutActivity.A;
                        if (mTicket != null) {
                            ed1 ed12 = new ed1("mticket payment success", Long.MIN_VALUE);
                            vn.a(ed12, mTicket);
                            ed12.a(SuperPassJsonKeys.ORDER_ID, orderId);
                            ed12.a("paymentId", paymentId);
                            ed12.a("paymentMode", "online");
                            ed12.a("hourOfEvent", jh1.j(System.currentTimeMillis()) + "");
                            if (checkoutActivity.getIntent().hasExtra("src")) {
                                hj1.F0(checkoutActivity, "src", ed12, "source");
                            }
                            jz5.b().g(ed12);
                        } else if (checkoutActivity.C) {
                            ed1 ed13 = new ed1("pass booked", Long.MIN_VALUE);
                            ed13.a("passengerType", checkoutActivity.E.getSelectedProductCategory().getCategoryId());
                            ed13.a("bookingId", checkoutActivity.D.getTransactionId());
                            ed13.a("productType", checkoutActivity.E.getSuperPassProductConfigurationProperties().getProductType());
                            ed13.a(SuperPassJsonKeys.ORDER_ID, orderId);
                            ed13.a("paymentId", paymentId);
                            ed13.a("bookingDate", jh1.c(checkoutActivity.D.getBookingTime()));
                            ed13.a("expiryDate", jh1.c(checkoutActivity.D.getExpiryTime()));
                            ed13.a("hourOfEvent", jh1.j(ui1.Q()) + "");
                            ed13.a("isSuperPass", Boolean.TRUE);
                            if (checkoutActivity.getIntent() != null) {
                                hj1.F0(checkoutActivity, "src", ed13, "source");
                            }
                            jz5.b().g(ed13);
                        } else if (checkoutActivity.H) {
                            ed1 ed14 = new ed1("online card recharge payment successful", Long.MIN_VALUE);
                            ed14.a("cardNumber", checkoutActivity.I);
                            ed14.a("transactionId", checkoutActivity.K.getTransactionId());
                            ed14.a("hourOfEvent", jh1.j(ui1.Q()) + "");
                            ed14.a("bookingDate", jh1.c(checkoutActivity.K.getBookingTime()));
                            ed14.a("productType", checkoutActivity.J.getProductType());
                            ed14.a("productSubType", checkoutActivity.J.getProductSubType());
                            ed14.a(AnalyticsConstants.AMOUNT, checkoutActivity.w);
                            if (checkoutActivity.getIntent() != null) {
                                hj1.F0(checkoutActivity, "src", ed14, "source");
                            }
                            jz5.b().g(ed14);
                        }
                    }
                    CheckoutActivity.this.x0();
                    xt.f3961a.c().a(CheckoutActivity.this.S, paymentId);
                    CheckoutActivity.this.n.setVisibility(8);
                    CheckoutActivity.this.u.setVisibility(0);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onEvent(LpInitiatePayResponseEvent lpInitiatePayResponseEvent) {
        jz5.b().m(lpInitiatePayResponseEvent);
        if (lpInitiatePayResponseEvent.get_responseType().equals(ad1.SUCCESS)) {
            this.n.setVisibility(0);
            getSupportActionBar().y(R.string.payment_breakdown);
            findViewById(R.id.toolbar).setVisibility(8);
            this.u.setVisibility(8);
            findViewById(R.id.checkout_no_internet).setVisibility(8);
            this.n.setWebChromeClient(new d());
            this.n.setWebViewClient(new e());
            String checkoutUrl = lpInitiatePayResponseEvent.getCheckoutUrl();
            this.Y = checkoutUrl;
            this.n.loadUrl(checkoutUrl);
            return;
        }
        r0();
        Toast.makeText(this, "Please Try some other payment mode!!!", 1).show();
    }

    public void onEvent(UpdateTimeoutEvent updateTimeoutEvent) {
        String str;
        jz5.b().m(updateTimeoutEvent);
        u0("update order time response", updateTimeoutEvent.get_responseType());
        if (updateTimeoutEvent.get_responseType().equals(ad1.SUCCESS)) {
            r0();
            if (this.C) {
                p0(updateTimeoutEvent.get_qrCode(), updateTimeoutEvent.get_tone());
            } else if (this.H) {
                o0();
            } else {
                t0(updateTimeoutEvent.get_qrCode(), updateTimeoutEvent.get_tone());
            }
        } else if (!updateTimeoutEvent.get_responseType().equals(ad1.PENDING)) {
            r0();
            finish();
            Toast.makeText(this, getString(R.string.retry_payment), 1).show();
        } else if (this.a0) {
            MPass mPass = this.z;
            if (mPass != null) {
                str = mPass.getUserProfile().getUserId();
            } else {
                MTicket mTicket = this.A;
                if (mTicket != null) {
                    str = mTicket.getUserId();
                } else {
                    ScanPayTicket scanPayTicket = this.B;
                    if (scanPayTicket != null) {
                        str = scanPayTicket.get_userId();
                    } else if (this.C) {
                        str = this.F.getUserId();
                    } else {
                        str = this.H ? xt.f3961a.m0() : null;
                    }
                }
            }
            if (TextUtils.isEmpty(this.Y)) {
                xt.f3961a.c().V(this.U, str, this.S);
                return;
            }
            this.n.loadUrl("about:blank");
            this.n.loadUrl(this.Y);
            this.n.setVisibility(0);
            getSupportActionBar().y(R.string.payment_breakdown);
            findViewById(R.id.toolbar).setVisibility(8);
            this.u.setVisibility(8);
            findViewById(R.id.checkout_no_internet).setVisibility(8);
        } else {
            r0();
            z0(this.t);
        }
    }

    public void onEvent(RazorPayVerificationStatus razorPayVerificationStatus) {
        u0("order status response", razorPayVerificationStatus.get_responseType());
        jz5.b().m(razorPayVerificationStatus);
        r0();
        if (razorPayVerificationStatus.get_responseType().equals(ad1.SUCCESS)) {
            r0();
            this.Z = true;
            if (this.C) {
                p0(razorPayVerificationStatus.getQrCode(), razorPayVerificationStatus.getTone());
            } else if (this.H) {
                o0();
            } else {
                t0(razorPayVerificationStatus.getQrCode(), razorPayVerificationStatus.getTone());
                MPass mPass = this.z;
                if (!(mPass == null || mPass.get_productType() == null || !this.z.get_productType().equals("superSaver"))) {
                    this.X.g(this.z.getBookingPassId(), true);
                    razorPayVerificationStatus.getQrCode();
                    xt.f3961a.c().n0(this.z.getBookingPassId());
                }
                Intent intent = new Intent(this, BookingSuccessActivity.class);
                intent.putExtra(SuperPassJsonKeys.QR_CODE, razorPayVerificationStatus.getQrCode());
                intent.putExtra("extraMTicket", this.A);
                intent.putExtra("magic_pass_info", this.z);
                intent.putExtra("scanPayInfo", this.B);
                startActivityForResult(intent, 431);
            }
        } else if (razorPayVerificationStatus.get_responseType().equals(ad1.PENDING)) {
            r0();
            y0(null, this.Z);
        } else if (razorPayVerificationStatus.get_responseType().equals(ad1.FAILED)) {
            r0();
            y0(null, true);
        } else if (razorPayVerificationStatus.get_responseType().equals(ad1.UNKNOWN)) {
            r0();
            y0("checkHistory", false);
        }
    }

    public void onEvent(qd1 qd1) {
        n0();
    }
}
