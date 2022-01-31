package defpackage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.ScanPayTicket;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.ui.activities.HomeActivity;
import defpackage.ut;
import defpackage.xt;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: hw0  reason: default package */
/* compiled from: SoundFragment */
public class hw0 extends Fragment {
    public static final /* synthetic */ int z = 0;
    public g90 f;
    public MTicket g;
    public MPass h;
    public ScanPayTicket i;
    public View j;
    public String k;
    public String l;
    public String m;
    public ProgressBar n;
    public View o;
    public ImageView p;
    public String q;
    public UserProfile r;
    public rf1 s;
    public ImageView t;
    public d u;
    public int v = -1;
    public boolean w;
    public boolean x = true;
    public boolean y = true;

    /* renamed from: hw0$a */
    /* compiled from: SoundFragment */
    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            try {
                ed1 ed1 = new ed1("sound bottom sheet clicked", Long.MIN_VALUE);
                ed1.a("source", "validationScreen");
                jz5.b().g(ed1);
                jt0 jt0 = new jt0();
                Bundle bundle = new Bundle();
                bundle.putParcelable("mticket_info", hw0.this.g);
                bundle.putParcelable("mpass_info", hw0.this.h);
                bundle.putParcelable("scanPay_info", hw0.this.i);
                jt0.setArguments(bundle);
                jt0.show(hw0.this.getFragmentManager(), "bottom_sheet");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: hw0$b */
    /* compiled from: SoundFragment */
    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            hw0 hw0 = hw0.this;
            int i = hw0.z;
            Objects.requireNonNull(hw0);
            n86.e("sound qr tap here clicked", "lName");
            n86.e("sound fragment", "lSource");
            ed1 ed1 = new ed1("sound qr tap here clicked", Long.MIN_VALUE);
            ed1.a("source", "sound fragment");
            ui1.m0(ed1);
            lm0 b = lm0.b(hw0.c().getFragmentManager(), hw0.getString(R.string.qr_requested_dialog_title), hw0.getString(R.string.qr_requested_dialog_desc), hw0.getString(R.string.okay), hw0.getString(R.string.cancel), null);
            b.setCancelable(false);
            kw0 kw0 = new kw0(hw0, b);
            TextView textView = b.i;
            if (textView != null) {
                textView.setOnClickListener(kw0);
            } else {
                b.q = kw0;
            }
            lw0 lw0 = new lw0(hw0, b);
            TextView textView2 = b.j;
            if (textView2 != null) {
                textView2.setOnClickListener(lw0);
            } else {
                b.r = lw0;
            }
        }
    }

    /* renamed from: hw0$c */
    /* compiled from: SoundFragment */
    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            hw0 hw0 = hw0.this;
            int i = hw0.z;
            Objects.requireNonNull(hw0);
            n86.e("sound verification screen continue clicked", "lName");
            n86.e("sound fragment", "lSource");
            ed1 ed1 = new ed1("sound verification screen continue clicked", Long.MIN_VALUE);
            ed1.a("source", "sound fragment");
            ui1.m0(ed1);
            Intent intent = new Intent(hw0.this.getContext(), HomeActivity.class);
            intent.setFlags(268468224);
            hw0.this.startActivity(intent);
        }
    }

    /* renamed from: hw0$d */
    /* compiled from: SoundFragment */
    public enum d {
        RESONSE_CODE_MISMATCH,
        REJECTED,
        ACCEPTED
    }

    public void d(int i2) {
        this.v = i2;
        int d2 = this.s.d(this.m, Integer.MAX_VALUE);
        if (!this.s.a(this.m) || i2 / 10 != d2) {
            this.u = d.RESONSE_CODE_MISMATCH;
            ml1<zq1> k2 = gl1.g(c()).k();
            k2.g(Integer.valueOf((int) R.drawable.sound_waiting));
            k2.e(this.t);
        } else if (i2 % 2 == 0) {
            this.u = d.ACCEPTED;
            if (!(this.g == null && this.i == null)) {
                rf1 rf1 = this.s;
                rf1.g(this.m + "_isExpired", true);
            }
            xt.f3961a.g0().a();
            this.j.findViewById(R.id.active_sound_fragment_group).setVisibility(8);
            this.j.findViewById(R.id.verification_status_group).setVisibility(0);
            ((TextView) this.j.findViewById(R.id.verification_heading)).setText(getString(R.string.ticket_verification_success));
            ((ImageView) this.j.findViewById(R.id.verification_status_img)).setImageResource(R.drawable.sound_success);
        } else {
            this.u = d.REJECTED;
            this.j.findViewById(R.id.active_sound_fragment_group).setVisibility(8);
            this.j.findViewById(R.id.verification_status_group).setVisibility(0);
            ((TextView) this.j.findViewById(R.id.verification_heading)).setText(getString(R.string.ticket_verification_failed));
            ((ImageView) this.j.findViewById(R.id.verification_status_img)).setImageResource(R.drawable.sound_failure);
        }
    }

    public final void e(Bitmap bitmap) {
        this.p.setImageBitmap(bitmap);
    }

    public void f() {
        ed1 ed1 = new ed1("sound headphone connected", Long.MIN_VALUE);
        xt.t1 t1Var = xt.f3961a;
        ed1.a("code", Boolean.valueOf(t1Var.g0().b()));
        jz5.b().g(ed1);
        if (t1Var.g0().b()) {
            if (!this.w) {
                this.w = true;
                lm0 b2 = lm0.b(c().getFragmentManager(), getString(R.string.headphones_header), getString(R.string.headphones_desc), getString(R.string.yes), null, null);
                b2.setCancelable(false);
                jw0 jw0 = new jw0(this, b2);
                TextView textView = b2.i;
                if (textView != null) {
                    textView.setOnClickListener(jw0);
                } else {
                    b2.q = jw0;
                }
            }
        } else if (this.u == null && this.k != null) {
            if (this.x) {
                if (!this.s.b.getBoolean("soundInfoShowed", false) || !ui1.T(getContext(), "android.permission.RECORD_AUDIO")) {
                    this.y = false;
                    this.x = false;
                    rf1 rf1 = this.s;
                    rf1.f3075a.putBoolean("soundInfoShowed", true);
                    rf1.f3075a.commit();
                    FragmentManager parentFragmentManager = getParentFragmentManager();
                    n86.e(parentFragmentManager, "lFragmentManager");
                    n86.e("sound fragment", "lSource");
                    mw0 mw0 = new mw0();
                    mw0.i = "sound fragment";
                    mw0.show(parentFragmentManager, "Sound info fragment");
                    return;
                }
                t1Var.g0().e(Base64.decode(this.k, 0));
            } else if (this.y) {
                t1Var.g0().e(Base64.decode(this.k, 0));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = new rf1(c(), "OTP_STORAGE");
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.sound_fragment, viewGroup, false);
        this.j = inflate;
        this.n = (ProgressBar) inflate.findViewById(R.id.bottom_sheet).findViewById(R.id.pass_profile_pic_progressbar);
        this.p = (ImageView) this.j.findViewById(R.id.bottom_sheet).findViewById(R.id.profile_pic);
        this.o = this.j.findViewById(R.id.bottom_sheet);
        this.t = (ImageView) this.j.findViewById(R.id.ticket_status_img);
        this.j.findViewById(R.id.bottom_sheet).setOnClickListener(new a());
        return this.j;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        xt.f3961a.g0().a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MTicket mTicket = this.g;
        if (mTicket != null) {
            this.l = mTicket.getMTicketConfiguration().getId();
            this.m = this.g.getMTicketId();
            this.k = this.g.getTone();
            this.r = this.g.get_userProfile();
            ((TextView) this.j.findViewById(R.id.bottom_sheet).findViewById(R.id.product_name)).setText(vn.E(c(), this.l));
        } else {
            MPass mPass = this.h;
            if (mPass != null) {
                this.l = mPass.getConfigId();
                this.m = this.h.getBookingPassId();
                this.k = this.h.getTone();
                this.r = this.h.getUserProfile();
                ((TextView) this.j.findViewById(R.id.bottom_sheet).findViewById(R.id.product_name)).setText(vn.E(c(), this.l));
            } else {
                ScanPayTicket scanPayTicket = this.i;
                if (scanPayTicket != null) {
                    this.k = scanPayTicket.get_tone();
                    this.m = this.i.get_transactionId();
                    ((TextView) this.j.findViewById(R.id.bottom_sheet).findViewById(R.id.product_name)).setText("Ticket");
                }
            }
        }
        UserProfile userProfile = this.r;
        if (userProfile != null) {
            this.q = userProfile.getProfilePhoto();
        }
        int i2 = 0;
        if (this.q != null) {
            this.o.setVisibility(0);
            String str = this.q;
            ml1<Bitmap> j2 = gl1.g(c()).j();
            j2.m = str;
            j2.p = true;
            j2.a(new rs1().q(50000));
            j2.f(new iw0(this, 0));
            this.j.findViewById(R.id.bottom_sheet).setVisibility(0);
        } else {
            this.j.findViewById(R.id.bottom_sheet).findViewById(R.id.profile_pic_group).setVisibility(8);
        }
        if (this.m != null) {
            ((TextView) this.j.findViewById(R.id.bottom_sheet).findViewById(R.id.ref_code_container).findViewById(R.id.ref_code)).setText(this.m.toUpperCase());
        } else {
            this.o.setVisibility(8);
        }
        String str2 = this.m;
        if (str2 != null) {
            String f2 = xt.f3961a.t().f("easyConductorVerification");
            if (f2 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(f2);
                    if (jSONObject.has("numDigits")) {
                        i2 = jSONObject.getInt("numDigits");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (i2 > 0) {
                String valueOf = String.valueOf((Math.abs(str2.hashCode()) % (((int) Math.pow(10.0d, (double) i2)) - 1)) + 1);
                ed1 ed1 = new ed1("hash code shown", Long.MIN_VALUE);
                ed1.a("productId", this.l);
                ed1.a("hashCode", valueOf);
                ed1.a("numDigits", Integer.valueOf(i2));
                ((TextView) this.j.findViewById(R.id.bottom_sheet).findViewById(R.id.ref_code_container).findViewById(R.id.ref_code_hash)).setText(valueOf);
                ((TextView) this.j.findViewById(R.id.bottom_sheet).findViewById(R.id.ref_code_container).findViewById(R.id.reference_code_title)).setText(getString(R.string.ticket_number));
                ui1.m0(ed1);
            } else {
                ((TextView) this.j.findViewById(R.id.bottom_sheet).findViewById(R.id.ref_code_container).findViewById(R.id.reference_code_title)).setText(getString(R.string.reference_code));
                this.j.findViewById(R.id.bottom_sheet).findViewById(R.id.ref_code_container).findViewById(R.id.ref_code_hash).setVisibility(8);
            }
        }
        f();
        int i3 = this.v;
        if (i3 != -1) {
            d(i3);
            return;
        }
        ml1<zq1> k2 = gl1.g(c()).k();
        k2.g(Integer.valueOf((int) R.drawable.sound_waiting));
        k2.e(this.t);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((TextView) view.findViewById(R.id.btn_tap_here)).setOnClickListener(new b());
        view.findViewById(R.id.continue_btn).setOnClickListener(new c());
        if (c() != null) {
            ut.a aVar = ut.f3552a;
            c().getWindow().setFlags(RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST, RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
        }
    }
}
