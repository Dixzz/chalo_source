package app.zophop.ui.activities;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.autofill.AutofillManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.ScanPayTicket;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.pubsub.eventbus.events.UserProfileEvent;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.auth.FirebaseUser;
import com.razorpay.AnalyticsConstants;
import com.truecaller.android.sdk.ITrueCallback;
import com.truecaller.android.sdk.TrueError;
import com.truecaller.android.sdk.TrueProfile;
import com.truecaller.android.sdk.TruecallerSDK;
import com.truecaller.android.sdk.TruecallerSdkScope;
import defpackage.a32;
import defpackage.au;
import defpackage.ft0;
import defpackage.q20;
import defpackage.yj1;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class AccountLoginActivity extends au implements a32.b, a32.c {
    public static final /* synthetic */ int E = 0;
    public final ITrueCallback A = new f();
    public final View.OnClickListener B = new b();
    public final View.OnClickListener C = new c();
    public final View.OnClickListener D = new d();
    @InjectView(R.id.login_continue)
    public Button _continue;
    @InjectView(R.id.error)
    public TextView _errorView;
    @InjectView(R.id.login_truecaller_scrollview)
    public ScrollView _loginTruecallerScrollview;
    @InjectView(R.id.mobile_no)
    public EditText _mobileTextInput;
    @InjectView(R.id.otp_layout)
    public TextInputLayout _otpLayout;
    @InjectView(R.id.otp_verification)
    public TextInputEditText _otpVerification;
    @InjectView(R.id.resend_sms)
    public TextView _resendSmsView;
    @InjectView(R.id.toolbar)
    public Toolbar _toolbar;
    @InjectView(R.id.verify_login)
    public Button _verifyLogin;
    public DialogFragment k;
    public DialogFragment l;
    public TruecallerSdkScope m;
    public String n;
    public Dialog o;
    public xj1 p;
    public String q;
    public String r;
    public MPass s;
    public MTicket t;
    public ScanPayTicket u;
    public a32 v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public class a implements q20.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f285a;

        /* renamed from: app.zophop.ui.activities.AccountLoginActivity$a$a  reason: collision with other inner class name */
        public class RunnableC0003a implements Runnable {
            public RunnableC0003a() {
            }

            public void run() {
                if (!AccountLoginActivity.this.j.equals(au.a.DESTROYED) && !AccountLoginActivity.this.isFinishing()) {
                    AccountLoginActivity.n0(AccountLoginActivity.this, "otp sent");
                    AccountLoginActivity.this.p0();
                    AccountLoginActivity.this.findViewById(R.id.landing_page).setVisibility(8);
                    AccountLoginActivity.this.findViewById(R.id.verify_screen).setVisibility(0);
                    AccountLoginActivity.this._otpLayout.setFocusable(true);
                    AccountLoginActivity.this._otpLayout.requestFocus();
                    AccountLoginActivity accountLoginActivity = AccountLoginActivity.this;
                    ((InputMethodManager) accountLoginActivity.getSystemService("input_method")).showSoftInput(accountLoginActivity._otpLayout, 2);
                    AccountLoginActivity.this.getWindow().setSoftInputMode(5);
                    AccountLoginActivity.this.p0();
                }
            }
        }

        public a(String str) {
            this.f285a = str;
        }

        @Override // defpackage.q20.a
        public void a() {
            new Handler().postDelayed(new RunnableC0003a(), 5000);
        }

        @Override // defpackage.q20.a
        public void b() {
            AccountLoginActivity accountLoginActivity = AccountLoginActivity.this;
            int i = AccountLoginActivity.E;
            accountLoginActivity.p0();
            AccountLoginActivity.h0(AccountLoginActivity.this, "login failed", false, "authentication failed", this.f285a);
        }

        @Override // defpackage.q20.a
        public void c(FirebaseUser firebaseUser) {
            AccountLoginActivity accountLoginActivity = AccountLoginActivity.this;
            int i = AccountLoginActivity.E;
            Objects.requireNonNull(accountLoginActivity);
            firebaseUser.getIdToken(true).b(new ab0(accountLoginActivity, firebaseUser));
        }

        @Override // defpackage.q20.a
        public void d() {
            AccountLoginActivity accountLoginActivity = AccountLoginActivity.this;
            int i = AccountLoginActivity.E;
            accountLoginActivity.p0();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            AccountLoginActivity.n0(AccountLoginActivity.this, "otp sent");
            if (vn.K0(AccountLoginActivity.this)) {
                AccountLoginActivity.this.u0();
                return;
            }
            AccountLoginActivity accountLoginActivity = AccountLoginActivity.this;
            if (!accountLoginActivity.y) {
                accountLoginActivity.y = accountLoginActivity.f0(accountLoginActivity._loginTruecallerScrollview);
            }
        }
    }

    public class c implements View.OnClickListener {

        public class a implements q20.a {
            public a() {
            }

            @Override // defpackage.q20.a
            public void a() {
                AccountLoginActivity accountLoginActivity = AccountLoginActivity.this;
                int i = AccountLoginActivity.E;
                accountLoginActivity.q0();
                AccountLoginActivity.n0(AccountLoginActivity.this, "otp sent");
            }

            @Override // defpackage.q20.a
            public void b() {
                AccountLoginActivity accountLoginActivity = AccountLoginActivity.this;
                int i = AccountLoginActivity.E;
                accountLoginActivity.q0();
                AccountLoginActivity accountLoginActivity2 = AccountLoginActivity.this;
                AccountLoginActivity.h0(accountLoginActivity2, "login failed", false, "invalid otp", AccountLoginActivity.l0(accountLoginActivity2));
                AccountLoginActivity.this._otpLayout.setError("Verification failed. Please check OTP and try again");
            }

            @Override // defpackage.q20.a
            public void c(FirebaseUser firebaseUser) {
                AccountLoginActivity accountLoginActivity = AccountLoginActivity.this;
                int i = AccountLoginActivity.E;
                Objects.requireNonNull(accountLoginActivity);
                firebaseUser.getIdToken(true).b(new ab0(accountLoginActivity, firebaseUser));
            }

            @Override // defpackage.q20.a
            public void d() {
                AccountLoginActivity accountLoginActivity = AccountLoginActivity.this;
                int i = AccountLoginActivity.E;
                accountLoginActivity.q0();
            }
        }

        public c() {
        }

        public void onClick(View view) {
            String obj = AccountLoginActivity.this._otpVerification.getText().toString();
            if (TextUtils.isEmpty(obj) || !TextUtils.isDigitsOnly(obj)) {
                AccountLoginActivity.this._otpLayout.setError("Please enter OTP");
                return;
            }
            AccountLoginActivity.this.w0();
            AccountLoginActivity.n0(AccountLoginActivity.this, "otp entered");
            xt.f3961a.I().c(obj, new a(), AccountLoginActivity.this);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            AccountLoginActivity.n0(AccountLoginActivity.this, "resend otp button clicked");
            AccountLoginActivity.this.u0();
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            AccountLoginActivity.this._mobileTextInput.requestFocus();
            AccountLoginActivity.this.getApplicationContext();
            ((InputMethodManager) AccountLoginActivity.this.getSystemService("input_method")).showSoftInput(AccountLoginActivity.this._mobileTextInput, 1);
            AccountLoginActivity.this.getWindow().setSoftInputMode(4);
        }
    }

    public class f implements ITrueCallback {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                AccountLoginActivity.this._mobileTextInput.requestFocus();
                AccountLoginActivity.this.getApplicationContext();
                ((InputMethodManager) AccountLoginActivity.this.getSystemService("input_method")).showSoftInput(AccountLoginActivity.this._mobileTextInput, 1);
                AccountLoginActivity.this.getWindow().setSoftInputMode(4);
            }
        }

        public f() {
        }

        @Override // com.truecaller.android.sdk.ITrueCallback
        public void onFailureProfileShared(TrueError trueError) {
            if (trueError.getErrorType() == 10) {
                Toast.makeText(AccountLoginActivity.this.getApplicationContext(), "Please sign in", 1).show();
            } else if (trueError.getErrorType() == 14) {
                AccountLoginActivity accountLoginActivity = AccountLoginActivity.this;
                AccountLoginActivity.h0(accountLoginActivity, "truecaller use other number clicked", true, trueError.getErrorType() + "", AccountLoginActivity.l0(AccountLoginActivity.this));
                new Handler().postDelayed(new a(), 200);
            }
            AccountLoginActivity accountLoginActivity2 = AccountLoginActivity.this;
            AccountLoginActivity.h0(accountLoginActivity2, "login failed", true, trueError.getErrorType() + "", AccountLoginActivity.l0(AccountLoginActivity.this));
        }

        @Override // com.truecaller.android.sdk.ITrueCallback
        public void onSuccessProfileShared(TrueProfile trueProfile) {
            AccountLoginActivity.h0(AccountLoginActivity.this, "truecaller bottomsheet rendered for login", true, null, trueProfile.phoneNumber);
            try {
                AccountLoginActivity.i0(AccountLoginActivity.this, trueProfile);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.truecaller.android.sdk.ITrueCallback
        public void onVerificationRequired(TrueError trueError) {
        }
    }

    public class g implements yj1.b<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f288a;

        public g(boolean z) {
            this.f288a = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(String str) {
            String str2 = str;
            AccountLoginActivity accountLoginActivity = AccountLoginActivity.this;
            int i = AccountLoginActivity.E;
            accountLoginActivity.q0();
            try {
                AccountLoginActivity.this.r = new JSONObject(str2).getString("uid");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            AccountLoginActivity accountLoginActivity2 = AccountLoginActivity.this;
            boolean z = this.f288a;
            accountLoginActivity2.t0(true);
            if (z) {
                TruecallerSDK.getInstance().setRequestNonce(accountLoginActivity2.r);
                TruecallerSDK.getInstance().getUserProfile(accountLoginActivity2);
            } else {
                new Handler().postDelayed(new fb0(accountLoginActivity2), 200);
            }
            accountLoginActivity2.t0(z);
        }
    }

    public class h implements yj1.a {
        public h() {
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            Toast.makeText(AccountLoginActivity.this, "Something went wrong! Please try again", 1).show();
            AccountLoginActivity accountLoginActivity = AccountLoginActivity.this;
            int i = AccountLoginActivity.E;
            accountLoginActivity.q0();
        }
    }

    public class i extends e70 {
        public i(AccountLoginActivity accountLoginActivity, int i, String str, yj1.b bVar, yj1.a aVar, String str2) {
            super(i, str, bVar, aVar, null);
        }

        @Override // defpackage.e70, defpackage.wj1
        public Map<String, String> m() {
            HashMap hashMap = new HashMap();
            hashMap.put("deviceId", xt.f3961a.n().a());
            return hashMap;
        }
    }

    public class j implements ft0.b {
        public j() {
        }

        @Override // defpackage.ft0.b
        public void a() {
            AccountLoginActivity accountLoginActivity = AccountLoginActivity.this;
            int i = AccountLoginActivity.E;
            accountLoginActivity.q0();
        }
    }

    static {
        String str = ut.i;
    }

    public static void h0(AccountLoginActivity accountLoginActivity, String str, boolean z2, String str2, String str3) {
        Objects.requireNonNull(accountLoginActivity);
        ed1 ed1 = new ed1(str, Long.MIN_VALUE);
        if (z2) {
            ed1.a("method", "trueCaller");
        } else {
            ed1.a("method", AnalyticsConstants.OTP);
        }
        if (str2 != null) {
            ed1.a("reason", str2);
        }
        if (str3 != null) {
            ed1.a("userId", str3);
        }
        jz5.b().g(ed1);
    }

    public static void i0(AccountLoginActivity accountLoginActivity, TrueProfile trueProfile) throws JSONException {
        Objects.requireNonNull(accountLoginActivity);
        accountLoginActivity.p = gj1.U(accountLoginActivity);
        accountLoginActivity.v0(accountLoginActivity.getString(R.string.loading));
        accountLoginActivity.w0();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("AuthType", "TrueCallerAuth");
        jSONObject.put("payload", trueProfile.payload);
        jSONObject.put("signature", trueProfile.signature);
        jSONObject.put("userId", trueProfile.phoneNumber.substring(3));
        jSONObject.put("signatureAlgorithm", trueProfile.signatureAlgorithm);
        jSONObject.put("deviceId", xt.f3961a.n().a());
        jSONObject.put("uid", accountLoginActivity.r);
        String jSONObject2 = jSONObject.toString();
        String str = ut.u;
        accountLoginActivity.q = str;
        e70 e70 = new e70(1, str, new db0(accountLoginActivity, trueProfile), new eb0(accountLoginActivity), jSONObject2);
        e70.n = false;
        e70.q = new nj1(Indexable.MAX_STRING_LENGTH, 1, 1.0f);
        accountLoginActivity.p.a(e70);
    }

    public static void j0(AccountLoginActivity accountLoginActivity, FirebaseUser firebaseUser, String str) throws JSONException {
        Objects.requireNonNull(accountLoginActivity);
        accountLoginActivity.p = gj1.U(accountLoginActivity);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("AuthType", "FireBaseAuth");
        jSONObject.put("userId", firebaseUser.getPhoneNumber().substring(3));
        firebaseUser.getIdToken(true);
        jSONObject.put(AnalyticsConstants.TOKEN, str);
        jSONObject.put("deviceId", xt.f3961a.n().a());
        jSONObject.put("uid", firebaseUser.getUid());
        String jSONObject2 = jSONObject.toString();
        String str2 = ut.u;
        accountLoginActivity.q = str2;
        e70 e70 = new e70(1, str2, new bb0(accountLoginActivity), new cb0(accountLoginActivity), jSONObject2);
        e70.n = false;
        accountLoginActivity.p.a(e70);
    }

    public static void k0(AccountLoginActivity accountLoginActivity, String str) throws JSONException {
        SharedPreferences.Editor edit = accountLoginActivity.getSharedPreferences("accessToken", 0).edit();
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("status");
        String string2 = jSONObject.getString("accessToken");
        String string3 = jSONObject.getString("refreshToken");
        edit.putString("status", string);
        edit.commit();
        edit.putString("accessToken", string2);
        edit.commit();
        edit.putString("refreshToken", string3);
        edit.commit();
        edit.putString("uid", accountLoginActivity.r);
        edit.commit();
        try {
            ui1.k(accountLoginActivity, string2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String l0(AccountLoginActivity accountLoginActivity) {
        return accountLoginActivity._mobileTextInput.getText().toString();
    }

    public static void m0(AccountLoginActivity accountLoginActivity, String str, String str2, String str3, String str4, String str5) {
        Objects.requireNonNull(accountLoginActivity);
        xt.f3961a.L().r(str, str2, str3, str4, str5);
    }

    public static void n0(AccountLoginActivity accountLoginActivity, String str) {
        Objects.requireNonNull(accountLoginActivity);
        jz5.b().g(new ed1(str, Long.MIN_VALUE));
    }

    @Override // defpackage.n32
    public void C(int i2) {
    }

    @Override // defpackage.w32
    public void F(ConnectionResult connectionResult) {
    }

    @Override // defpackage.n32
    public void L(Bundle bundle) {
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.login_truecaller);
        ButterKnife.inject(this);
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, false, 0);
        if (vn.K0(this)) {
            this.y = false;
            e0();
        } else if (!this.y) {
            this.y = f0(this._loginTruecallerScrollview);
        }
        fv0 fv0 = (fv0) getFragmentManager().findFragmentByTag("loader_tag");
        this.k = fv0;
        if (fv0 == null) {
            fv0 D2 = vn.D(null, getString(R.string.verifying_phone_number), false, false, 25000, new lb0(this));
            this.k = D2;
            D2.setRetainInstance(true);
        }
        fv0 fv02 = (fv0) getFragmentManager().findFragmentByTag("otp_loader_tag");
        this.l = fv02;
        if (fv02 == null) {
            fv0 D3 = vn.D(null, getString(R.string.verifying_otp), false, false, 25000, new mb0(this));
            this.l = D3;
            D3.setRetainInstance(true);
        }
        a32.a aVar = new a32.a(this);
        aVar.b(this);
        aVar.c(this);
        r32 r32 = new r32(this);
        gj1.c(true, "clientId must be non-negative");
        aVar.i = 0;
        aVar.j = this;
        aVar.h = r32;
        aVar.a(uz1.e);
        this.v = aVar.d();
        if (this.m != null) {
            this.z = TruecallerSDK.getInstance().isUsable();
        } else {
            TruecallerSdkScope build = new TruecallerSdkScope.Builder(this, this.A).consentMode(128).buttonColor(Color.parseColor("#f57c00")).buttonShapeOptions(2048).consentTitleOption(3).footerType(2).loginTextPrefix(1).loginTextSuffix(0).sdkOptions(16).build();
            this.m = build;
            TruecallerSDK.init(build);
            this.z = TruecallerSDK.getInstance().isUsable();
        }
        if (Build.VERSION.SDK_INT < 26 || this.z) {
            ed1 ed1 = new ed1("auto fill manager status", Long.MIN_VALUE);
            hj1.J0(ed1, "disabled auto fill", Boolean.TRUE, ed1);
        } else {
            boolean isEnabled = ((AutofillManager) getSystemService(AutofillManager.class)).isEnabled();
            this.x = isEnabled;
            ed1 ed12 = new ed1("auto fill manager status", Long.MIN_VALUE);
            hj1.d(isEnabled, ed12, "status", ed12);
        }
        this.n = getIntent().getStringExtra("src");
        String stringExtra = getIntent().getStringExtra("magic_pass_info");
        String stringExtra2 = getIntent().getStringExtra("mticket_info");
        String stringExtra3 = getIntent().getStringExtra("scanPayInfo");
        ov ovVar = new ov();
        if (!TextUtils.isEmpty(stringExtra)) {
            this.s = ov.r(stringExtra);
        }
        if (!TextUtils.isEmpty(stringExtra3)) {
            this.u = ovVar.E(stringExtra3);
        }
        if (!TextUtils.isEmpty(stringExtra2)) {
            this.t = ovVar.q(stringExtra2);
        }
        this._continue.setOnClickListener(this.B);
        this._verifyLogin.setOnClickListener(this.C);
        this._resendSmsView.setOnClickListener(this.D);
        this._mobileTextInput.clearFocus();
        this._mobileTextInput.getBackground().setColorFilter(getResources().getColor(R.color.orange_primary), PorterDuff.Mode.SRC_IN);
        setSupportActionBar(this._toolbar);
        getSupportActionBar().z(getString(R.string.login));
        getSupportActionBar().o(true);
        this._mobileTextInput.setOnFocusChangeListener(new jb0(this));
        this._mobileTextInput.setOnClickListener(new ib0(this));
        this._mobileTextInput.addTextChangedListener(new hb0(this));
        if (this.z) {
            o0();
        } else {
            new Handler().postDelayed(new e(), 200);
        }
    }

    public void o0() {
        v0(getString(R.string.loading));
        w0();
        try {
            r0(TruecallerSDK.getInstance().isUsable());
        } catch (JSONException e2) {
            q0();
            e2.printStackTrace();
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i2, int i3, Intent intent) {
        h02 h02;
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    Objects.requireNonNull((l02) uz1.h);
                    wa2 wa2 = n02.f2502a;
                    if (intent == null || (!intent.hasExtra("googleSignInStatus") && !intent.hasExtra("googleSignInAccount"))) {
                        h02 = null;
                    } else {
                        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
                        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
                        if (googleSignInAccount != null) {
                            status = Status.k;
                        }
                        h02 = new h02(googleSignInAccount, status);
                    }
                    if (h02.f.m1()) {
                        GoogleSignInAccount googleSignInAccount2 = h02.g;
                        String.format("Logged in as %s (%s)", googleSignInAccount2.j, googleSignInAccount2.i);
                    }
                } else if (i2 == 1200) {
                    super.onActivityResult(i2, i3, intent);
                    return;
                }
            } else if (i3 == -1) {
                Credential credential = (Credential) intent.getParcelableExtra("com.google.android.gms.credentials.Credential");
                String.format("onHintRetrieved %s", credential.f);
                String.format("Account Type: %s", credential.k);
                if (!TextUtils.isEmpty(credential.f)) {
                    this._mobileTextInput.setText(credential.f.substring(3));
                    this._mobileTextInput.setCursorVisible(false);
                }
                if (!credential.i.isEmpty()) {
                    String.format("ID Token: %s", credential.i.get(0).g);
                }
            } else {
                this._mobileTextInput.requestFocus();
                this._mobileTextInput.setCursorVisible(true);
            }
        } else if (i3 == -1) {
            s0((Credential) intent.getParcelableExtra("com.google.android.gms.credentials.Credential"));
        }
        if (intent == null) {
            Toast.makeText(this, "Please login through phone number", 1).show();
            b00 b00 = b00.f358a;
            b00.a().a("Truecaller SDK", "Intent null");
        } else if (this.z) {
            TruecallerSDK.getInstance().onActivityResultObtained(this, i2, i3, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        String str = this.n;
        if (str != null && str.equalsIgnoreCase("auth")) {
            TaskStackBuilder.create(this).addNextIntentWithParentStack(defpackage.h.R(this)).startActivities();
            super.onBackPressed();
        }
        if (findViewById(R.id.verify_screen).getVisibility() == 0) {
            findViewById(R.id.verify_screen).setVisibility(8);
            findViewById(R.id.landing_page).setVisibility(0);
            this._otpVerification.setText("");
            this._otpLayout.setErrorEnabled(false);
            this._errorView.setVisibility(8);
            return;
        }
        super.onBackPressed();
        finish();
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onDestroy() {
        super.onDestroy();
        jz5.b().o(this);
    }

    public void onEvent(qd1 qd1) {
        if (qd1.f2931a) {
            this.y = false;
            e0();
        } else if (!this.y) {
            this.y = f0(this._loginTruecallerScrollview);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        String str = this.n;
        if (str != null && str.equalsIgnoreCase("auth")) {
            TaskStackBuilder.create(this).addNextIntentWithParentStack(defpackage.h.R(this)).startActivities();
            return true;
        } else if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            onBackPressed();
            return true;
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.t4.b, defpackage.ve
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (iArr[0] == 0 && i2 == 0) {
            o0();
        }
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onResume() {
        super.onResume();
        Object obj = q22.c;
        q22 q22 = q22.d;
        int c2 = q22.c(this, r22.f3028a);
        if (c2 == 0) {
            Dialog dialog = this.o;
            if (dialog != null) {
                dialog.dismiss();
            }
        } else if (u22.isUserRecoverableError(c2)) {
            Dialog dialog2 = this.o;
            if (dialog2 != null) {
                dialog2.dismiss();
            }
            Dialog d2 = q22.d(this, c2, 1200, new kb0(this));
            this.o = d2;
            if (d2 != null) {
                d2.setCanceledOnTouchOutside(false);
                this.o.show();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        if (!xt.f3961a.I().a()) {
            p0();
        }
    }

    public final void p0() {
        if (this.k.isVisible()) {
            this.k.dismiss();
        }
    }

    public final void q0() {
        if (this.l.isVisible()) {
            this.l.dismiss();
        }
    }

    public final void r0(boolean z2) throws JSONException {
        this.p = gj1.U(this);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("deviceId", xt.f3961a.n().a());
        jSONObject.toString();
        String str = ut.w;
        this.q = str;
        i iVar = new i(this, 0, str, new g(z2), new h(), null);
        iVar.q = new nj1(Indexable.MAX_STRING_LENGTH, 1, 1.0f);
        iVar.n = false;
        this.p.a(iVar);
    }

    public final void s0(Credential credential) {
        String str = credential.k;
        if (str == null) {
            String.format("onCredentialRetrieved:password (%s)", credential.j);
            return;
        }
        String.format("Account Type: %s", str);
        String.format("ID: %s", credential.f);
        if (!credential.i.isEmpty()) {
            String.format("ID Token: %s", credential.i.get(0).g);
        }
    }

    public final void t0(boolean z2) {
        ed1 ed1 = new ed1("login screen displayed", Long.MIN_VALUE);
        ed1.a("isTrueCallerInstalled", String.valueOf(z2));
        jz5.b().g(ed1);
    }

    public void u0() {
        String obj = this._mobileTextInput.getText().toString();
        if (obj.isEmpty() || obj.length() < 10) {
            this._errorView.setVisibility(0);
        } else if (x0(obj)) {
            if (!this.k.isVisible()) {
                this.k.show(getFragmentManager(), "loader_tag");
            }
            xt.f3961a.I().b(obj, new a(obj), this);
        } else {
            this._errorView.setVisibility(0);
        }
    }

    public final void v0(String str) {
        fv0 fv0 = (fv0) getFragmentManager().findFragmentByTag("otp_loader_tag");
        this.l = fv0;
        if (fv0 == null) {
            fv0 D2 = vn.D(null, str, false, false, 25000, new j());
            this.l = D2;
            D2.setRetainInstance(true);
            return;
        }
        fv0.f.setText(str);
    }

    public final void w0() {
        if (!this.l.isVisible()) {
            this.l.show(getFragmentManager(), "otp_loader_tag");
        }
    }

    public final boolean x0(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (str.length() > 10 || !str.matches("[0-9]+")) {
            return false;
        }
        return true;
    }

    public void onEvent(UserProfileEvent userProfileEvent) {
        jz5.b().m(userProfileEvent);
        q0();
        if (userProfileEvent.getResponseType().equals(ad1.SUCCESS)) {
            if (this.s != null) {
                Intent intent = new Intent(this, UserDetailsActivity.class);
                if (getIntent() != null) {
                    intent.putExtras(getIntent());
                }
                intent.putExtra("src", this.n);
                intent.putExtra("extraIsUserLoggedIn", true);
                startActivity(intent);
                jz5.b().m(userProfileEvent);
                jz5.b().o(this);
                finish();
            }
            if (this.t != null) {
                setResult(-1);
                finish();
            }
            if (this.u != null) {
                setResult(-1);
                finish();
            }
        } else if (userProfileEvent.getMessage() != null && !"AUTHENTICATION_ERROR".equals(userProfileEvent.getMessage())) {
            StringBuilder i0 = hj1.i0("message = ");
            i0.append(userProfileEvent.getMessage());
            ed1 l2 = hj1.l("login log event", Long.MIN_VALUE, "remarks", i0.toString());
            l2.a("source", "accountLoginActivity");
            ui1.m0(l2);
            xt.f3961a.L().i(false, null);
            Toast.makeText(this, getString(R.string.profile_fetch_please_try_again), 0).show();
            finish();
        }
    }
}
