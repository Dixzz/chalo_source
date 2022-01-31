package app.zophop.ui.activities;

import android.app.DialogFragment;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.Agency;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.AgencyProfileField;
import app.zophop.models.mTicketing.ProofViewInfo;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.products.ProductSelectionActivity;
import app.zophop.pubsub.eventbus.events.UserProfileEvent;
import app.zophop.ui.fragments.ProfileFragment;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.urbanairship.UAirship;
import defpackage.xt;
import java.util.ArrayList;

public class UserProfileActivity extends wt {
    public static final /* synthetic */ int x = 0;
    public ProfileFragment l;
    public UserProfile m;
    public a n = a.VIEW_SCREEN;
    public boolean o = false;
    public boolean p;
    public boolean q;
    public Agency r;
    public String s;
    public DialogFragment t;
    public LinearLayout u;
    public String v;
    public boolean w;

    public enum a {
        VIEW_SCREEN,
        VIEW_OTHER_SCREEN,
        EDIT_SCREEN,
        REGISTER
    }

    public static Intent h0(Context context) {
        Intent intent = new Intent(context, UserProfileActivity.class);
        intent.putExtra("profile_state", false);
        intent.putExtra("return_after_login", true);
        return intent;
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.activity_user_profile);
        this.v = getIntent().getStringExtra("src");
        this.p = getIntent().getBooleanExtra("return_after_login", false);
        this.q = getIntent().getBooleanExtra("is_login_for_mpass_purchase_flow", false);
        if (getIntent().hasExtra("agency_name") || getIntent().hasExtra("passenger_type")) {
            String stringExtra = getIntent().getStringExtra("agency_name");
            for (Agency agency : xt.f3961a.k().d().getModeAgencyMap().get(TransitMode.bus)) {
                if (agency.getAgencyName().equals(stringExtra)) {
                    this.r = agency;
                }
            }
            this.s = getIntent().getStringExtra("passenger_type");
        }
        if (getIntent().hasExtra("profile_info")) {
            this.m = ov.H(getIntent().getStringExtra("profile_info"));
            this.n = a.VIEW_OTHER_SCREEN;
        } else {
            this.m = xt.f3961a.L().e();
        }
        if (this.m == null || !l0()) {
            this.n = a.REGISTER;
        } else {
            this.n = a.VIEW_SCREEN;
            if (getIntent().getBooleanExtra("state_editable_only", false)) {
                this.n = a.EDIT_SCREEN;
                this.p = true;
            }
        }
        this.o = getIntent().getBooleanExtra("show_action_button", false);
        if (bundle != null) {
            if (bundle.containsKey("activity_user_profile")) {
                this.m = ov.H(bundle.getString("activity_user_profile"));
            }
            this.n = a.valueOf(bundle.getString(RemoteConfigConstants.ResponseFieldKey.STATE));
        }
        setSupportActionBar((Toolbar) findViewById(R.id.activity_user_profile_toolbar));
        getSupportActionBar().o(true);
        fv0 fv0 = (fv0) getFragmentManager().findFragmentByTag("loader_tag");
        this.t = fv0;
        if (fv0 == null) {
            fv0 T = vn.T(null, getString(R.string.loading), false, false);
            this.t = T;
            T.setRetainInstance(true);
        }
        if (xt.f3961a.L().f() || ((ProfileFragment) getFragmentManager().findFragmentByTag("profile_tag")) != null) {
            i0();
            return;
        }
        Intent intent = new Intent(this, AccountLoginActivity.class);
        intent.putExtra("src", this.v);
        intent.putExtras(getIntent());
        startActivityForResult(intent, 98);
    }

    public final void i0() {
        findViewById(R.id.fragment_container_frame).setBackgroundResource(R.color.black);
        this.u = (LinearLayout) findViewById(R.id.user_profile_linear_layout);
        UserProfile userProfile = this.m;
        ProfileFragment profileFragment = (ProfileFragment) getFragmentManager().findFragmentByTag("profile_tag");
        this.l = profileFragment;
        if (profileFragment == null) {
            if (userProfile == null) {
                this.l = new ProfileFragment();
            } else {
                this.l = new ProfileFragment(userProfile);
            }
            getFragmentManager().beginTransaction().add(R.id.fragment_container_frame, this.l, "profile_tag").commit();
            this.l.setRetainInstance(true);
        } else if (this.m != null) {
            if (!(this.n.equals(a.EDIT_SCREEN) || this.n.equals(a.REGISTER))) {
                this.l.t(this.m);
            }
        }
        Agency agency = this.r;
        if (!(agency == null || agency.getAgencyName().equalsIgnoreCase(ui1.s(xt.f3961a.k().d())))) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.r.getPassengerTypeProofs().get(this.s)) {
                UserProfile userProfile2 = this.m;
                if (userProfile2 != null && userProfile2.getAgencyInfo().containsKey(this.r.getAgencyName())) {
                    arrayList.add(new ProofViewInfo(str, this.m.getAgencyInfo().get(this.r.getAgencyName()).getProofs().get(str)));
                } else if (!this.n.equals(a.VIEW_OTHER_SCREEN)) {
                    arrayList.add(new ProofViewInfo(str));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (String str2 : this.r.getPassengerTypeFields().get(this.s)) {
                UserProfile userProfile3 = this.m;
                if (userProfile3 != null && userProfile3.getAgencyInfo().containsKey(this.r.getAgencyName())) {
                    arrayList2.add(new AgencyProfileField(true, this.m.getAgencyInfo().get(this.r.getAgencyName()).getAgencyFields().get(str2), str2));
                } else if (!this.n.equals(a.VIEW_OTHER_SCREEN)) {
                    arrayList2.add(new AgencyProfileField(true, null, str2));
                }
            }
            ProfileFragment profileFragment2 = this.l;
            Agency agency2 = this.r;
            String str3 = this.s;
            profileFragment2.D = arrayList;
            profileFragment2.f = str3;
            profileFragment2.A = true;
            profileFragment2.g = agency2;
            profileFragment2.F = arrayList2;
            if (profileFragment2.getView() != null) {
                profileFragment2.g(profileFragment2.getView());
            }
            if (userProfile == null) {
                return;
            }
            if (!this.l.k(false) || !this.l.b(false)) {
                this.n = a.REGISTER;
            }
        }
    }

    public final boolean j0() {
        return (this.r == null && this.s == null) ? false : true;
    }

    public final void k0() {
        if (this.n.equals(a.VIEW_SCREEN)) {
            this.l.t(xt.f3961a.L().e());
            this.l.r(false);
            getSupportActionBar().z(getString(R.string.profile_view_title));
            this.l.q(false);
            getSupportActionBar().t(R.drawable.abc_ic_ab_back_material);
        } else if (this.n.equals(a.VIEW_OTHER_SCREEN)) {
            this.l.t(this.m);
            this.l.r(false);
            getSupportActionBar().z(getString(R.string.profile_other_title));
            this.l.q(false);
            getSupportActionBar().t(R.drawable.abc_ic_ab_back_material);
        } else if (this.n.equals(a.EDIT_SCREEN)) {
            this.l.t(xt.f3961a.L().e());
            this.l.r(true);
            getSupportActionBar().z(getString(R.string.profile_edit_title));
            this.l.q(false);
            getSupportActionBar().t(R.drawable.close_nearby);
        } else if (this.n.equals(a.REGISTER)) {
            this.l.r(true);
            getSupportActionBar().z(getString(R.string.profile_view_title));
            this.l.q(true);
            this.l.p(getString(R.string.submit));
            getSupportActionBar().t(R.drawable.abc_ic_ab_back_material);
        }
        invalidateOptionsMenu();
    }

    public final boolean l0() {
        if (!j0()) {
            return true;
        }
        UserProfile userProfile = this.m;
        if (!(userProfile.getProfilePhoto() != null && !TextUtils.isEmpty(userProfile.getDateOfBirth()) && !TextUtils.isEmpty(userProfile.getFirstName()) && !TextUtils.isEmpty(userProfile.getLastName()) && userProfile.getGender() != null) || !ui1.e(this.m, this.r, this.s) || !ui1.d(this.m, this.r, this.s)) {
            return false;
        }
        return true;
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 99 || i != 98) {
            return;
        }
        if (intent == null) {
            setResult(i2);
            finish();
            return;
        }
        findViewById(R.id.fragment_container_frame).setBackgroundResource(R.color.white);
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("first_name");
        String stringExtra3 = intent.getStringExtra("last_name");
        String stringExtra4 = intent.getStringExtra("email_id");
        String stringExtra5 = intent.getStringExtra("phone_no");
        if (stringExtra != null && intent.getStringExtra("src") != null && intent.getStringExtra("src").startsWith("home screen")) {
            xt.t1 t1Var = xt.f3961a;
            t1Var.L().r(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5);
            t1Var.L().l(false);
            if (!this.t.isVisible()) {
                this.t.show(getFragmentManager(), "loader_tag");
            }
        } else if (stringExtra != null) {
            xt.t1 t1Var2 = xt.f3961a;
            t1Var2.L().r(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5);
            t1Var2.L().l(false);
            jz5.b().i(new UserProfileEvent(ad1.SUCCESS, UserProfileEvent.TYPE.REGISTRATION_DETAIL_UPDATE));
            if (!this.t.isVisible()) {
                this.t.show(getFragmentManager(), "loader_tag");
            }
        } else {
            Toast.makeText(this, getString(R.string.something_bad_happened), 0).show();
            setResult(i);
            finish();
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.wt
    public void onBackPressed() {
        a aVar = this.n;
        a aVar2 = a.VIEW_SCREEN;
        if (aVar.equals(aVar2) || this.n.equals(a.VIEW_OTHER_SCREEN) || !xt.f3961a.L().m()) {
            xt.t1 t1Var = xt.f3961a;
            if (t1Var.L().m() && l0()) {
                setResult(-1);
            }
            String str = this.v;
            if (str != null && str.equalsIgnoreCase("auth")) {
                TaskStackBuilder.create(this).addNextIntentWithParentStack(h.R(this)).startActivities();
                super.onBackPressed();
            } else if (!this.q || t1Var.L().m()) {
                finish();
                super.onBackPressed();
            } else {
                new Intent();
                setResult(0);
                finish();
            }
        } else if (!j0() || (l0() && !this.p)) {
            this.n = aVar2;
            k0();
        } else {
            finish();
            super.onBackPressed();
        }
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_screen_menu, menu);
        if (this.n.equals(a.VIEW_SCREEN)) {
            menu.findItem(R.id.profile_menu_edit).setVisible(true);
            menu.findItem(R.id.profile_menu_logout).setVisible(!j0());
            menu.findItem(R.id.profile_menu_save).setVisible(false);
        } else if (this.n.equals(a.VIEW_OTHER_SCREEN)) {
            menu.findItem(R.id.profile_menu_edit).setVisible(false);
            menu.findItem(R.id.profile_menu_logout).setVisible(false);
            menu.findItem(R.id.profile_menu_save).setVisible(false);
        } else if (this.n.equals(a.EDIT_SCREEN)) {
            menu.findItem(R.id.profile_menu_edit).setVisible(false);
            menu.findItem(R.id.profile_menu_logout).setVisible(false);
            menu.findItem(R.id.profile_menu_save).setVisible(true);
        } else if (this.n.equals(a.REGISTER)) {
            menu.findItem(R.id.profile_menu_edit).setVisible(false);
            menu.findItem(R.id.profile_menu_logout).setVisible(!j0());
            menu.findItem(R.id.profile_menu_save).setVisible(false);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public void onEvent(UserProfileEvent userProfileEvent) {
        UserProfile e;
        if (UAirship.u && (e = xt.f3961a.L().e()) != null) {
            op5 k = UAirship.l().j.k();
            k.d(SuperPassJsonKeys.FIRST_NAME, e.getFirstName());
            k.d(SuperPassJsonKeys.LAST_NAME, e.getLastName());
            k.d("email", e.getEmailId());
            k.d("phoneNo", e.getPhone());
            k.a();
        }
        String str = this.v;
        if (str != null) {
            if ((str.equals("magicPass") || this.v.equals("routePass") || this.v.equals("multipleProducts") || this.v.equals("mticketing")) || this.v.startsWith("deeplink")) {
                if (userProfileEvent.getResponseType().equals(ad1.SUCCESS)) {
                    Intent intent = new Intent(this, ProductSelectionActivity.class);
                    if (getIntent() != null) {
                        intent.putExtras(getIntent());
                    }
                    intent.putExtra("src", this.v);
                    intent.putExtra("extraIsUserLoggedIn", true);
                    startActivity(intent);
                    jz5.b().m(userProfileEvent);
                    jz5.b().o(this);
                    finish();
                }
                ProfileFragment profileFragment = this.l;
                if (profileFragment != null && profileFragment.isAdded()) {
                    this.l.onEvent(userProfileEvent);
                }
                ProfileFragment profileFragment2 = this.l;
                if (profileFragment2 != null && !profileFragment2.isAdded()) {
                    ProfileFragment profileFragment3 = this.l;
                    profileFragment3.v = true;
                    profileFragment3.w = userProfileEvent;
                }
                jz5.b().m(userProfileEvent);
            }
        }
        String str2 = this.v;
        if (str2 == null || (!str2.equals("route details") && !this.v.equals("trip details"))) {
            if (userProfileEvent.getUserProfileEventType().equals(UserProfileEvent.TYPE.PROFILE_FETCH)) {
                DialogFragment dialogFragment = this.t;
                if (dialogFragment != null && dialogFragment.isAdded()) {
                    this.t.dismiss();
                }
                if (userProfileEvent.getResponseType().equals(ad1.SUCCESS)) {
                    xt.t1 t1Var = xt.f3961a;
                    this.m = t1Var.L().e();
                    if (!this.p || !l0()) {
                        UserProfile e2 = t1Var.L().e();
                        this.m = e2;
                        if (e2.getUserId() != null) {
                            t1Var.c().d(t1Var.L().e().getUserId(), t1Var.l().h.optString("access_token", null));
                        }
                        i0();
                        if (!j0() || l0()) {
                            this.n = a.VIEW_SCREEN;
                            k0();
                        } else {
                            this.n = a.REGISTER;
                            k0();
                        }
                    } else {
                        setResult(-1);
                        finish();
                    }
                } else if (UserProfileEvent.RESPONSE_CODE.USER_NOT_FOUND.equals(userProfileEvent.getCode())) {
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this).edit();
                    edit.putBoolean("is_first_login", true);
                    edit.commit();
                    i0();
                    this.n = a.REGISTER;
                    k0();
                }
            } else if (userProfileEvent.getResponseType().equals(ad1.SUCCESS)) {
                if (userProfileEvent.getUserProfileEventType().equals(UserProfileEvent.TYPE.LOGOUT)) {
                    setResult(-1);
                    finish();
                } else if (!userProfileEvent.getUserProfileEventType().equals(UserProfileEvent.TYPE.REGISTRATION_DETAIL_UPDATE)) {
                    if ((j0() && a.REGISTER.equals(this.n)) || this.p) {
                        setResult(-1);
                        finish();
                    } else if (!this.n.equals(a.VIEW_OTHER_SCREEN)) {
                        this.n = a.VIEW_SCREEN;
                        k0();
                    }
                    this.m = xt.f3961a.L().e();
                }
            }
            ProfileFragment profileFragment4 = this.l;
            this.l.onEvent(userProfileEvent);
            ProfileFragment profileFragment22 = this.l;
            ProfileFragment profileFragment32 = this.l;
            profileFragment32.v = true;
            profileFragment32.w = userProfileEvent;
            jz5.b().m(userProfileEvent);
        }
        if (userProfileEvent.getResponseType().equals(ad1.SUCCESS)) {
            Intent intent2 = new Intent(this, MTicketTripInfoActivity.class);
            intent2.putExtra("src", this.v);
            intent2.putExtra("route_extra", getIntent().getStringExtra("route_extra"));
            intent2.putExtra("from_stop_extra", getIntent().getStringExtra("from_stop_extra"));
            intent2.putExtra("to_stop_extra", getIntent().getStringExtra("to_stop_extra"));
            startActivity(intent2);
            jz5.b().m(userProfileEvent);
            jz5.b().o(this);
            finish();
        }
        ProfileFragment profileFragment42 = this.l;
        this.l.onEvent(userProfileEvent);
        ProfileFragment profileFragment222 = this.l;
        ProfileFragment profileFragment322 = this.l;
        profileFragment322.v = true;
        profileFragment322.w = userProfileEvent;
        jz5.b().m(userProfileEvent);
    }

    @Override // defpackage.wt
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != 16908332) {
            if (itemId == R.id.profile_menu_edit) {
                if (!j0() || !this.o) {
                    this.n = a.EDIT_SCREEN;
                    k0();
                } else {
                    this.n = a.REGISTER;
                    k0();
                }
            } else if (itemId == R.id.profile_menu_save) {
                View currentFocus = getCurrentFocus();
                if (currentFocus != null) {
                    ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                }
                this.l.y();
            } else if (itemId == R.id.profile_menu_logout) {
                xt.f3961a.L().i(false, null);
                Toast.makeText(this, getString(R.string.profile_logout_success), 0).show();
                setResult(-1);
                finish();
            }
            return false;
        } else if (!this.n.equals(a.EDIT_SCREEN) || this.p) {
            onBackPressed();
            return true;
        } else {
            this.n = a.VIEW_SCREEN;
            k0();
            return true;
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
        UserProfile userProfile = this.m;
        if (userProfile != null) {
            bundle.putString("activity_user_profile", ov.l(userProfile));
        }
        bundle.putString(RemoteConfigConstants.ResponseFieldKey.STATE, this.n.name());
        super.onSaveInstanceState(bundle);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        jz5 b = jz5.b();
        b.k(this, b.e, true, 0);
        if (this.l != null) {
            k0();
        }
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        jz5.b().o(this);
        super.onStop();
    }

    public void onEvent(qd1 qd1) {
        if (vn.K0(this)) {
            e0();
            this.w = false;
        } else if (!this.w) {
            this.w = f0(this.u);
        }
    }
}
