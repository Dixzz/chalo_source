package app.zophop.ui.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.models.Agency;
import app.zophop.models.mTicketing.AgencyProfileField;
import app.zophop.models.mTicketing.BasicProfileFields;
import app.zophop.models.mTicketing.Gender;
import app.zophop.models.mTicketing.PassengerType;
import app.zophop.models.mTicketing.ProofViewInfo;
import app.zophop.models.mTicketing.UserAgencyInfo;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.pubsub.eventbus.events.UserProfileEvent;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.views.ZophopFormInput;
import app.zophop.ui.views.collapse_on_scroll.ProfileVerificationStateView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.theartofdev.edmodo.cropper.CropImageOptions;
import defpackage.i61;
import defpackage.nb1;
import defpackage.xt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@SuppressLint({"ValidFragment"})
public class ProfileFragment extends Fragment implements i61 {
    public static final /* synthetic */ int H = 0;
    public boolean A;
    public Uri B;
    public int C;
    public List<ProofViewInfo> D;
    public nb1 E;
    public List<AgencyProfileField> F;
    public ja1 G;
    @InjectView(R.id.form_dob)
    public ZophopFormInput _dateOfBirthView;
    @InjectView(R.id.form_email_id)
    public ZophopFormInput _emailIdView;
    @InjectView(R.id.form_first_name)
    public ZophopFormInput _firstNameView;
    @InjectView(R.id.form_gender)
    public ZophopFormInput _genderView;
    @InjectView(R.id.form_last_name)
    public ZophopFormInput _lastNameView;
    @InjectView(R.id.form_passenger_type)
    public ZophopFormInput _passengerTypeView;
    @InjectView(R.id.form_phone_number)
    public ZophopFormInput _phoneNumberView;
    @InjectView(R.id.profile_pic_progressbar)
    public ProgressBar _profilePictureLoader;
    @InjectView(R.id.register_profile_picture)
    public ImageView _profilePictureView;
    @InjectView(R.id.profile_pic_text)
    public TextView _profileText;
    public String f;
    public Agency g;
    public String h;
    public String i;
    public Gender j;
    public String k;
    public String l;
    public String m;
    public Bitmap n;
    public UserProfile o;
    public boolean p;
    public String q;
    public ArrayList<String> r;
    public HashMap<Integer, Gender> s;
    public ct1<Bitmap> t;
    public boolean u;
    public boolean v;
    public UserProfileEvent w;
    public DialogFragment x;
    public boolean y;
    public String z;

    public class a implements ZophopFormInput.b {
        public a() {
        }

        @Override // app.zophop.ui.views.ZophopFormInput.b
        public void a() {
            ProfileFragment profileFragment = ProfileFragment.this;
            int i = ProfileFragment.H;
            profileFragment.e();
            if (ProfileFragment.this.getView() != null) {
                ProfileFragment.this.m();
            }
        }

        @Override // app.zophop.ui.views.ZophopFormInput.b
        public void b() {
        }

        @Override // app.zophop.ui.views.ZophopFormInput.b
        public void c() {
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", ProfileFragment.this.getActivity().getPackageName(), null));
            ProfileFragment.this.startActivityForResult(intent, 7);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            ProfileFragment.this.y();
        }
    }

    public class d implements nb1.b {
        public d() {
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            ProfileFragment profileFragment = ProfileFragment.this;
            DialogFragment dialogFragment = profileFragment.x;
            if (dialogFragment != null && dialogFragment.isVisible()) {
                profileFragment.x.dismiss();
            }
        }
    }

    public ProfileFragment() {
        this.p = false;
        this.r = new ArrayList<>();
        this.s = new HashMap<>();
        this.u = false;
        this.v = false;
        this.y = false;
        this.A = false;
        this.D = new ArrayList();
    }

    public static void a(ProfileFragment profileFragment, Bitmap bitmap, int i2) {
        if (i2 == -1) {
            profileFragment._profilePictureLoader.setVisibility(8);
            profileFragment.n = bitmap;
            profileFragment._profilePictureView.setImageBitmap(bitmap);
            profileFragment.l();
        } else {
            nb1 nb1 = profileFragment.E;
            ProofViewInfo proofViewInfo = nb1.f.get(i2);
            proofViewInfo.setImage(bitmap);
            proofViewInfo.setEdited();
            nb1.removeViewAt(i2);
            nb1.addView(nb1.a(proofViewInfo, i2), i2);
        }
        profileFragment.m();
    }

    public boolean b(boolean z2) {
        boolean z3;
        Iterator<AgencyProfileField> it = this.F.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().getExistingValue() == null) {
                    z3 = false;
                    break;
                }
            } else {
                z3 = true;
                break;
            }
        }
        if (!z3 && z2) {
            Toast.makeText(getActivity(), getString(R.string.profile_fields_unset), 1).show();
        }
        return z3;
    }

    @Override // defpackage.i61
    public void c(i61.a aVar, int i2) {
        if (aVar.equals(i61.a.GENDER)) {
            this.j = this.s.get(Integer.valueOf(i2));
            this._genderView.setText(this.r.get(i2));
            this._genderView.setTag(this.j.toString());
        }
        m();
    }

    public final void d() {
        boolean z2;
        View currentFocus;
        if (this.p) {
            String[] strArr = {"android.permission.CAMERA"};
            if (!ui1.T(getActivity(), strArr)) {
                requestPermissions(strArr, 123);
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                if (!(getActivity() == null || (currentFocus = getActivity().getCurrentFocus()) == null)) {
                    vn.E0(currentFocus, getActivity());
                }
                this.B = vn.S0(this);
                this.C = -1;
            }
        } else if (!TextUtils.isEmpty(this.q)) {
            String str = this.q;
            ImageView imageView = this._profilePictureView;
            getString(R.string.profile_image_title);
            z(str, imageView);
        }
    }

    public final void e() {
        try {
            this.j = Gender.fromString(this._genderView.getTag().toString());
            this.f = this._passengerTypeView.getTag().toString();
        } catch (Exception unused) {
        }
        this.h = this._firstNameView.getText();
        this.i = this._lastNameView.getText();
        this.l = this._emailIdView.getText();
        this.m = this._phoneNumberView.getText();
        this.k = this._dateOfBirthView.getText();
        this.F = this.G.getAgencyFields();
        this.D = this.E.getProofsList();
    }

    public BasicProfileFields f() {
        e();
        return new BasicProfileFields.Builder().withDateOfBirth(this.k).withEmailId(this.l).withFirstName(this.h).withLastName(this.i).withGender(this.j).withPhone(this.m).build();
    }

    public final void g(View view) {
        if (this.A) {
            this.G = new ja1(getActivity(), this.F, this.p);
            this.E = new nb1(getActivity(), this.D, new d());
            view.findViewById(R.id.pass_profile_info).setVisibility(0);
            String str = this.f;
            if (str != null) {
                this._passengerTypeView.setText(str);
                this._passengerTypeView.setTag(this.f);
                this._passengerTypeView.setEditable(false);
            }
            n();
            view.findViewById(R.id.form_email_id).setVisibility(8);
            view.findViewById(R.id.form_phone_number).setVisibility(8);
            ProfileVerificationStateView profileVerificationStateView = (ProfileVerificationStateView) view.findViewById(R.id.profile_verification_status);
            profileVerificationStateView.setVisibility(0);
            Agency agency = this.g;
            String str2 = this.f;
            if (!PassengerType.ADULT.equals(str2)) {
                UserProfile e2 = xt.f3961a.L().e();
                if (e2 != null) {
                    ui1.v0(e2, agency, str2, profileVerificationStateView.getContext(), profileVerificationStateView);
                } else {
                    ui1.u0(profileVerificationStateView.getContext().getString(R.string.student_detials_not_entered), R.color.profile_unverified, profileVerificationStateView.getContext(), profileVerificationStateView);
                }
            } else {
                profileVerificationStateView.setVisibility(8);
            }
        } else {
            hj1.x0(view, R.id.pass_profile_info, 8, R.id.form_email_id, 0);
            view.findViewById(R.id.form_phone_number).setVisibility(0);
            this.G = new ja1(getActivity(), new ArrayList(), this.p);
            this.E = new nb1(getActivity(), this.D, null);
        }
    }

    public final boolean h(String str) {
        return !TextUtils.isEmpty(str);
    }

    public final boolean i(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        if (!TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return !str.equals(str2);
        }
        return true;
    }

    public final void j() {
        xt.t1 t1Var = xt.f3961a;
        String optString = t1Var.l().h.optString("first_name", null);
        String optString2 = t1Var.l().h.optString("last_name", null);
        String optString3 = t1Var.l().h.optString("email_id", null);
        String optString4 = t1Var.l().h.optString("phone_no", null);
        this._firstNameView.setText(optString);
        this._lastNameView.setText(optString2);
        this._phoneNumberView.setText(optString4);
        this.m = optString4;
        this._phoneNumberView.a();
        if (!TextUtils.isEmpty(optString3)) {
            this._emailIdView.setText(optString3);
            this.l = optString3;
            this._emailIdView.a();
        }
    }

    public boolean k(boolean z2) {
        boolean f2 = ui1.f(this.D);
        if (!f2 && z2) {
            Toast.makeText(getActivity(), getString(R.string.proof_unset), 1).show();
        }
        return f2;
    }

    public final void l() {
        this._profilePictureView.setEnabled(true);
        if (this.p) {
            this._profileText.setText(getString(R.string.profile_upload_pic));
            h.w0(this._profileText, R.style.profile_pic_text_style);
        } else {
            if (this.o != null) {
                this._profileText.setText(this.o.getFirstName() + " " + this.o.getLastName());
            } else {
                this._profileText.setText(getString(R.string.profile_your_pic));
            }
            h.w0(this._profileText, R.style.form_input_style);
        }
        boolean z2 = this.p;
        View findViewById = getView().findViewById(R.id.camera_icon);
        if (!z2 || this.n == null) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        if (!this.p) {
            this._profilePictureView.requestFocus();
        }
    }

    public final void m() {
        TextView textView = (TextView) getView().findViewById(R.id.action_button);
        if (!x(false) || !k(false) || !vn.K0(getActivity())) {
            textView.setEnabled(false);
            textView.setAlpha(0.4f);
            return;
        }
        textView.setAlpha(1.0f);
        textView.setEnabled(true);
    }

    public final void n() {
        LinearLayout linearLayout = (LinearLayout) this._passengerTypeView.getParent();
        linearLayout.removeAllViews();
        linearLayout.addView(this._passengerTypeView);
        linearLayout.addView(this.G);
        this.G.setEditable(this.p);
        this.E.setEditable(this.p);
        linearLayout.addView(this.E);
    }

    public final void o(View view) {
        View findViewById = view.findViewById(R.id.action_button);
        q(this.y);
        p(this.z);
        findViewById.setOnClickListener(new c());
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 != -1) {
            super.onActivityResult(i2, i3, intent);
        } else if (i2 == 227) {
            Uri uri = null;
            if (intent != null) {
                uri = intent.getData();
            }
            if (uri == null) {
                uri = this.B;
            }
            wf5 h2 = hd3.h(uri);
            CropImageOptions cropImageOptions = h2.b;
            cropImageOptions.T = true;
            cropImageOptions.U = false;
            startActivityForResult(h2.a(getActivity()), 203);
        } else if (i2 == 203) {
            this.B = hd3.a1(intent).g;
            int i4 = this.C;
            if (i4 == -1) {
                this.u = true;
            } else {
                this.D.get(i4).setEdited();
            }
            s(this.B.toString(), this.C);
            m();
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.v) {
            onEvent(this.w);
            this.v = false;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.register_layout, viewGroup, false);
        this.s = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        this.r = arrayList;
        Gender gender = Gender.MALE;
        arrayList.add(0, getString(gender.getResId()));
        this.s.put(0, gender);
        ArrayList<String> arrayList2 = this.r;
        Gender gender2 = Gender.FEMALE;
        arrayList2.add(1, getString(gender2.getResId()));
        this.s.put(1, gender2);
        ArrayList<String> arrayList3 = this.r;
        Gender gender3 = Gender.OTHER;
        arrayList3.add(2, getString(gender3.getResId()));
        this.s.put(2, gender3);
        ButterKnife.inject(this, inflate);
        getActivity().invalidateOptionsMenu();
        this._passengerTypeView.setHint(getString(R.string.profile_hint_passenger_type));
        this._genderView.setHint(getString(R.string.profile_hint_gender));
        this._dateOfBirthView.setHint(getString(R.string.profile_hint_dob));
        this._firstNameView.setInputType(16384);
        this._lastNameView.setInputType(16384);
        this._emailIdView.setInputType(32);
        this._phoneNumberView.setInputType(3);
        o(inflate);
        View findViewById = inflate.findViewById(R.id.register_profile_picture);
        View findViewById2 = inflate.findViewById(R.id.camera_icon);
        findViewById.setOnClickListener(new nv0(this));
        findViewById2.setOnClickListener(new mv0(this));
        g(inflate);
        this._profilePictureView.requestFocus();
        this.x = vn.T(null, getString(R.string.please_wait), false, false);
        return inflate;
    }

    public void onEvent(UserProfileEvent userProfileEvent) {
        if (!userProfileEvent.getUserProfileEventType().equals(UserProfileEvent.TYPE.REGISTRATION_DETAIL_UPDATE)) {
            new Handler().postDelayed(new e(), 500);
            if (userProfileEvent.getResponseType().equals(ad1.SUCCESS)) {
                if (userProfileEvent.getUserProfileEventType().equals(UserProfileEvent.TYPE.PROFILE_UPDATE)) {
                    Toast.makeText(getActivity(), getString(R.string.profile_update_success), 1).show();
                }
                this.u = false;
            }
        } else if (userProfileEvent.getResponseType().equals(ad1.SUCCESS)) {
            j();
        }
        jz5.b().m(userProfileEvent);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 123) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        } else if (iArr.length > 0 && iArr[0] == 0) {
            d();
        } else if (!t4.d(getActivity(), "android.permission.CAMERA")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(getString(R.string.camera_prompt)).setPositiveButton(getString(R.string.settings), new b()).setNegativeButton("CANCEL", (DialogInterface.OnClickListener) null);
            builder.create().show();
        }
    }

    public void onResume() {
        super.onResume();
        e();
        m();
    }

    public void onSaveInstanceState(Bundle bundle) {
        e();
        String str = this.f;
        if (str != null) {
            bundle.putString("passenger_type", str);
        }
        Gender gender = this.j;
        if (gender != null) {
            bundle.putString(SuperPassJsonKeys.GENDER, gender.name());
        }
        bundle.putString("first_name", this.h);
        bundle.putString("last_name", this.i);
        bundle.putString("dob", this.k);
        bundle.putString("mail_id", this.l);
        bundle.putString("phone_number", this.m);
        bundle.putBoolean("profile_edited", this.u);
        bundle.putBoolean("state_editable", this.p);
        String str2 = this.q;
        if (str2 != null) {
            bundle.putString("profile_image_url", str2);
        }
        Uri uri = this.B;
        if (uri != null) {
            bundle.putString("curr_photo_uri", uri.toString());
        }
        bundle.putInt("curr_photo_num", this.C);
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    public void onStop() {
        jz5.b().o(this);
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        UserProfile userProfile = this.o;
        if (userProfile != null) {
            t(userProfile);
        }
        j();
        r(this.p);
        u(this._firstNameView);
        u(this._lastNameView);
        u(this._emailIdView);
        u(this._phoneNumberView);
        o(view);
        m();
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            if (bundle.containsKey("passenger_type")) {
                this.f = bundle.getString("passenger_type");
            }
            if (bundle.containsKey(SuperPassJsonKeys.GENDER)) {
                this.j = Gender.fromString(bundle.getString(SuperPassJsonKeys.GENDER));
            }
            this.h = bundle.getString("first_name");
            this.i = bundle.getString("last_name");
            this.m = bundle.getString("phone_number");
            this.k = bundle.getString("dob");
            this.l = bundle.getString("mail_id");
            this.u = bundle.getBoolean("profile_edited");
            this.p = bundle.getBoolean("state_editable");
            String string = bundle.getString("profile_image_url");
            this.q = string;
            if (string != null) {
                s(string, -1);
            }
            if (bundle.containsKey("curr_photo_uri")) {
                this.B = Uri.parse(bundle.getString("curr_photo_uri"));
            }
            this.C = bundle.getInt("curr_photo_num");
        }
        String str = this.f;
        if (str != null) {
            this._passengerTypeView.setText(str);
            this._passengerTypeView.setTag(this.f);
        }
        Gender gender = this.j;
        if (gender != null) {
            this._genderView.setText(getString(gender.getResId()));
            this._genderView.setTag(this.j.toString());
        }
        this._firstNameView.setText(vn.g(this.h));
        this._lastNameView.setText(vn.g(this.i));
        this._emailIdView.setText(this.l);
        this._phoneNumberView.setText(this.m);
        String str2 = this.k;
        if (str2 != null) {
            this._dateOfBirthView.setText(str2);
        }
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            this._profilePictureView.setImageBitmap(bitmap);
        }
    }

    public void p(String str) {
        if (getView() == null) {
            this.z = str;
            return;
        }
        if (str == null) {
            str = getString(R.string.proceed);
        }
        SpannableStringBuilder f2 = hj1.f(str);
        f2.setSpan(vn.N(getActivity(), wg1.NOTOSANS_MEDIUM), 0, f2.length(), 17);
        ((TextView) getView().findViewById(R.id.action_button)).setText(f2);
    }

    public void q(boolean z2) {
        if (getView() == null) {
            this.y = z2;
        } else if (z2) {
            getView().findViewById(R.id.action_button).setVisibility(0);
        } else {
            getView().findViewById(R.id.action_button).setVisibility(8);
        }
    }

    public void r(boolean z2) {
        this.p = z2;
        if (getView() != null) {
            f();
            ViewGroup viewGroup = (ViewGroup) getView().findViewById(R.id.register_form);
            this._firstNameView.setEnabled(z2);
            this._lastNameView.setEnabled(z2);
            this._genderView.setEnabled(z2);
            this._dateOfBirthView.setEnabled(z2);
            this._emailIdView.setEnabled(z2);
            this._firstNameView.setEditable(z2);
            this._lastNameView.setEditable(z2);
            if (z2) {
                this._firstNameView.setVisibility(0);
                this._lastNameView.setVisibility(0);
            } else {
                this._firstNameView.setVisibility(8);
                this._lastNameView.setVisibility(8);
            }
            this._phoneNumberView.setEditable(z2);
            this._emailIdView.setEditable(z2);
            this.G.setEditable(z2);
            if (z2) {
                this._genderView.setOnClickListener(new sv0(this));
                this._dateOfBirthView.setOnClickListener(new uv0(this, new DatePickerDialog(getActivity(), new tv0(this), 1980, 1, 1)));
                this._passengerTypeView.setOnClickListener(new vv0(this));
            } else {
                this._genderView.setOnClickListener(null);
                this._dateOfBirthView.setOnClickListener(null);
                this._passengerTypeView.setOnClickListener(null);
            }
            n();
            if (!z2) {
                vn.E0(viewGroup, getActivity());
                viewGroup.invalidate();
                viewGroup.requestLayout();
            }
            l();
        }
    }

    public final void s(String str, int i2) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.profile_image_size);
        if (i2 == -1) {
            if (this.t != null) {
                gl1 b2 = gl1.b(getActivity());
                Objects.requireNonNull(b2);
                rt1.a();
                ((ot1) b2.g).e(0);
                b2.f.b();
                b2.j.b();
            }
            int measuredWidth = this._profilePictureView.getMeasuredWidth() == 0 ? dimensionPixelSize : this._profilePictureView.getMeasuredWidth();
            if (this._profilePictureView.getMeasuredHeight() != 0) {
                dimensionPixelSize = this._profilePictureView.getMeasuredHeight();
            }
            this.q = str;
            if (!TextUtils.isEmpty(str) && URLUtil.isValidUrl(str)) {
                this._profilePictureLoader.setVisibility(0);
                ml1<Bitmap> j2 = gl1.e(this).j();
                j2.m = str;
                j2.p = true;
                pv0 pv0 = new pv0(this, measuredWidth, dimensionPixelSize, i2);
                j2.f(pv0);
                this.t = pv0;
                return;
            }
            return;
        }
        getResources().getDimensionPixelOffset(R.dimen.proof_height);
        nb1 nb1 = this.E;
        nb1.f.get(i2).setUrl(str);
        nb1.f.get(i2).setEdited();
        ml1<Bitmap> j3 = gl1.e(this).j();
        j3.m = str;
        j3.p = true;
        j3.f(new ov0(this, i2));
    }

    public void t(UserProfile userProfile) {
        this.o = userProfile;
        if (this.F == null) {
            this.F = new ArrayList();
        }
        if (!(getView() == null || userProfile == null)) {
            if (userProfile.getGender() != null && h(getString(userProfile.getGender().getResId()))) {
                this._genderView.setText(getString(userProfile.getGender().getResId()));
            }
            if (userProfile.getGender() != null && h(userProfile.getGender().toString())) {
                this._genderView.setTag(userProfile.getGender().toString());
            }
            if (h(userProfile.getFirstName())) {
                this._firstNameView.setText(vn.g(userProfile.getFirstName()));
            }
            if (h(userProfile.getLastName())) {
                this._lastNameView.setText(vn.g(userProfile.getLastName()));
            }
            if (h(userProfile.getEmailId())) {
                this._emailIdView.setText(userProfile.getEmailId());
            }
            if (h(userProfile.getPhone())) {
                this._phoneNumberView.setText(userProfile.getPhone());
            }
            if (h(userProfile.getDateOfBirth())) {
                this._dateOfBirthView.setText(userProfile.getDateOfBirth());
            }
            e();
            if (userProfile.getProfilePhoto() != null && this.B == null) {
                s(userProfile.getProfilePhoto(), -1);
            }
            if (this.A) {
                nb1 nb1 = this.E;
                String agencyName = this.g.getAgencyName();
                Objects.requireNonNull(nb1);
                UserAgencyInfo userAgencyInfo = userProfile.getAgencyInfo().get(agencyName);
                ArrayList arrayList = new ArrayList();
                for (ProofViewInfo proofViewInfo : nb1.f) {
                    String name = proofViewInfo.getName();
                    if (userAgencyInfo == null || userAgencyInfo.getProofs().get(name) == null) {
                        arrayList.add(new ProofViewInfo(name, null));
                    } else {
                        arrayList.add(new ProofViewInfo(name, userAgencyInfo.getProofs().get(name)));
                    }
                }
                nb1.f = arrayList;
                nb1.b();
                ja1 ja1 = this.G;
                String agencyName2 = this.g.getAgencyName();
                Objects.requireNonNull(ja1);
                if (userProfile.getAgencyInfo().containsKey(agencyName2)) {
                    UserAgencyInfo userAgencyInfo2 = userProfile.getAgencyInfo().get(agencyName2);
                    for (AgencyProfileField agencyProfileField : ja1.f) {
                        String fieldName = agencyProfileField.getFieldName();
                        if (userAgencyInfo2.getAgencyFields().containsKey(fieldName)) {
                            agencyProfileField.setExistingValue(userAgencyInfo2.getAgencyFields().get(fieldName));
                        }
                    }
                }
                ja1.a();
                ProfileVerificationStateView profileVerificationStateView = (ProfileVerificationStateView) getView().findViewById(R.id.profile_verification_status);
                profileVerificationStateView.setVisibility(0);
                profileVerificationStateView.a(userProfile, this.g, this.f);
            }
        }
    }

    public final void u(ZophopFormInput zophopFormInput) {
        zophopFormInput.setInputChangeListener(new a());
    }

    public final void v() {
        if (!this.x.isVisible()) {
            this.x.show(getFragmentManager(), "TAG");
        }
    }

    public final boolean w(UserProfile userProfile) {
        return i(this.h, userProfile.getFirstName()) || i(this.i, userProfile.getLastName()) || i(this.k, userProfile.getDateOfBirth()) || !userProfile.getGender().equals(this.j) || i(this.l, userProfile.getEmailId());
    }

    public final boolean x(boolean z2) {
        if (!this.A) {
            return true;
        }
        if (this.j == null) {
            if (z2) {
                Toast.makeText(getActivity(), getString(R.string.gender_not_set), 0).show();
            }
            return false;
        } else if (TextUtils.isEmpty(this.k)) {
            if (z2) {
                Toast.makeText(getActivity(), getString(R.string.dob_not_set), 0).show();
            }
            return false;
        } else {
            String str = this.h;
            if (str == null || str.length() < 2) {
                if (z2) {
                    Toast.makeText(getActivity(), getString(R.string.first_name_not_set), 0).show();
                }
                return false;
            }
            String str2 = this.i;
            if (str2 == null || str2.length() < 2) {
                if (z2) {
                    Toast.makeText(getActivity(), getString(R.string.last_name_not_set), 0).show();
                }
                return false;
            } else if (this.n != null) {
                return true;
            } else {
                if (z2) {
                    Toast.makeText(getActivity(), getString(R.string.set_profile_image), 0).show();
                }
                return false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0163, code lost:
        if (((r10.u && r2.getProfilePhoto() != null) || w(r2)) != false) goto L_0x0167;
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0150  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void y() {
        /*
        // Method dump skipped, instructions count: 433
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.fragments.ProfileFragment.y():void");
    }

    public final void z(String str, View view) {
        f();
        ZoomedImageViewActivity.h0(getActivity(), (ImageView) view, str, null);
    }

    public ProfileFragment(UserProfile userProfile) {
        this.p = false;
        this.r = new ArrayList<>();
        this.s = new HashMap<>();
        this.u = false;
        this.v = false;
        this.y = false;
        this.A = false;
        this.o = userProfile;
        this.A = false;
        this.D = new ArrayList();
    }
}
