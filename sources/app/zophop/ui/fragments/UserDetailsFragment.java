package app.zophop.ui.fragments;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.cardview.widget.CardView;
import app.zophop.R;
import app.zophop.models.Agency;
import app.zophop.models.RouteInfo;
import app.zophop.models.mTicketing.BasicProfileFields;
import app.zophop.models.mTicketing.Gender;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.ProfileRequestInfo;
import app.zophop.models.mTicketing.ProofViewInfo;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.pubsub.eventbus.events.BookingTransactionEvent;
import app.zophop.pubsub.eventbus.events.ImageUploadUrlEvent;
import app.zophop.pubsub.eventbus.events.RazorPayOrderData;
import app.zophop.pubsub.eventbus.events.UserProfileEvent;
import app.zophop.room.ProductRepository;
import app.zophop.room.Ticket;
import app.zophop.ui.activities.ActivateMTicketScreen;
import app.zophop.ui.activities.CheckoutActivity;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.views.PassDurationFormInput;
import app.zophop.ui.views.ZophopFormInput;
import app.zophop.ui.views.collapse_on_scroll.ProfileVerificationStateView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.google.gson.Gson;
import com.razorpay.AnalyticsConstants;
import com.theartofdev.edmodo.cropper.CropImageOptions;
import defpackage.i61;
import defpackage.xt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class UserDetailsFragment extends Fragment implements i61 {
    public static final /* synthetic */ int Y = 0;
    public List<ProofViewInfo> A = new ArrayList();
    public String B;
    public gb1 C;
    public View D;
    public Map<String, String> E;
    public final Calendar F = Calendar.getInstance();
    public final Calendar G = Calendar.getInstance();
    public final Calendar H = Calendar.getInstance();
    public ProfileRequestInfo I = null;
    public String J;
    public MPass K;
    public MTicket L;
    public boolean M;
    public ProfileRequestInfo N;
    public mh1 O;
    public Bundle P;
    public ArrayList<String> Q;
    public String R;
    public List<String> S;
    public RouteInfo T;
    public PassDurationFormInput U;
    public View V;
    public String W;
    public DialogFragment X;
    @InjectView(R.id.checkBoxLayout)
    public RelativeLayout _checkBoxLayout;
    @InjectView(R.id.form_dob)
    public ZophopFormInput _dateOfBirthView;
    @InjectView(R.id.document_details_notes)
    public TextView _documentDetailsNotes;
    @InjectView(R.id.form_first_name)
    public ZophopFormInput _firstNameView;
    @InjectView(R.id.form_gender)
    public ZophopFormInput _genderView;
    @InjectView(R.id.form_last_name)
    public ZophopFormInput _lastNameView;
    @InjectView(R.id.register_scroller)
    public ScrollView _mainLayout;
    @InjectView(R.id.passenger_details_notes)
    public TextView _passengerDetailsNotes;
    @InjectView(R.id.form_passenger_type)
    public LinearLayout _passengerTypeView;
    @InjectView(R.id.checkBox)
    public CheckBox _termsCheckBox;
    public Agency f;
    public String g;
    public String h;
    public Gender i;
    public String j;
    public String k;
    public String l;
    public Bitmap m;
    public UserProfile n;
    public boolean o = false;
    public String p;
    public ArrayList<String> q = new ArrayList<>();
    public HashMap<Integer, Gender> r = new HashMap<>();
    public List<String> s;
    public boolean t = false;
    public boolean u = false;
    public View.OnClickListener v;
    public String w;
    public boolean x = false;
    public Uri y;
    public int z = -1;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", UserDetailsFragment.this.getActivity().getPackageName(), null));
            UserDetailsFragment.this.startActivityForResult(intent, 7);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            if (UserDetailsFragment.this._termsCheckBox.isChecked()) {
                UserDetailsFragment.this._termsCheckBox.setChecked(false);
            } else {
                UserDetailsFragment.this._termsCheckBox.setChecked(true);
            }
        }
    }

    public class c implements CompoundButton.OnCheckedChangeListener {
        public c() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                UserDetailsFragment userDetailsFragment = UserDetailsFragment.this;
                userDetailsFragment.M = z;
                userDetailsFragment.h();
                return;
            }
            UserDetailsFragment userDetailsFragment2 = UserDetailsFragment.this;
            userDetailsFragment2.M = z;
            userDetailsFragment2.h();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            UserDetailsFragment.this.p(xt.f3961a.L().e());
        }
    }

    public class e extends at1<Bitmap> {
        public final /* synthetic */ int i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(int i2, String str, String str2) {
            super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
            this.i = i2;
            this.j = str;
            this.k = str2;
        }

        @Override // defpackage.ct1
        public void b(Object obj, ft1 ft1) {
            Bitmap bitmap = (Bitmap) obj;
            gb1 gb1 = UserDetailsFragment.this.C;
            int i2 = this.i;
            ProofViewInfo proofViewInfo = gb1.f.get(i2);
            proofViewInfo.setImage(bitmap);
            proofViewInfo.setEdited();
            gb1.f.set(i2, proofViewInfo);
            UserDetailsFragment.this.C.c(this.j, this.k, this.i);
            UserDetailsFragment userDetailsFragment = UserDetailsFragment.this;
            String str = this.j;
            int i3 = this.i;
            if (i3 == 0) {
                userDetailsFragment.m = bitmap;
                userDetailsFragment.p = str;
                userDetailsFragment.D = userDetailsFragment.C.getChildAt(0);
                userDetailsFragment.A.get(0).setEdited();
                userDetailsFragment.A.get(0).setImage(bitmap);
            } else {
                userDetailsFragment.D = userDetailsFragment.C.getChildAt(i3);
                gb1 gb12 = userDetailsFragment.C;
                ProofViewInfo proofViewInfo2 = gb12.f.get(i3);
                proofViewInfo2.setImage(bitmap);
                proofViewInfo2.setEdited();
                gb12.f.set(i3, proofViewInfo2);
                userDetailsFragment.C.c(str, "", i3);
            }
            View view = userDetailsFragment.D;
            if (view != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.card_view).findViewById(R.id.add_image_view);
                ImageView imageView2 = (ImageView) userDetailsFragment.D.findViewById(R.id.remove_icon);
                imageView.setVisibility(0);
                ((CardView) userDetailsFragment.D.findViewById(R.id.card_view)).setOnClickListener(new dx0(userDetailsFragment, i3));
                imageView2.setVisibility(0);
                imageView.setImageBitmap(bitmap);
                ((ProgressBar) userDetailsFragment.D.findViewById(R.id.card_view).findViewById(R.id.profile_pic_progressbar)).setVisibility(8);
                imageView2.setOnClickListener(new cx0(userDetailsFragment, userDetailsFragment.D, i3));
                userDetailsFragment.h();
            }
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            UserDetailsFragment.this.p(xt.f3961a.L().e());
        }
    }

    public static boolean a(UserDetailsFragment userDetailsFragment) {
        String[] strArr = {"android.permission.CAMERA"};
        if (ui1.T(userDetailsFragment.getActivity(), strArr)) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            userDetailsFragment.requestPermissions(strArr, 123);
            jz5.b().g(hj1.l("permission_popup", Long.MIN_VALUE, "element", "mTicket_proofs"));
        } else {
            Toast.makeText(userDetailsFragment.getActivity(), "Please give camera permission", 1).show();
        }
        return false;
    }

    public final void b() {
        try {
            this.i = Gender.fromString(this._genderView.getTag().toString());
        } catch (Exception unused) {
        }
        this.g = this._firstNameView.getText();
        this.h = this._lastNameView.getText();
        this.j = (String) this._dateOfBirthView.getTag();
    }

    @Override // defpackage.i61
    public void c(i61.a aVar, int i2) {
        if (aVar.equals(i61.a.GENDER)) {
            this.i = this.r.get(Integer.valueOf(i2));
            this._genderView.setText(this.q.get(i2));
            this._genderView.setTag(this.i.toString());
        }
        h();
    }

    public BasicProfileFields d(UserProfile userProfile) {
        String str;
        b();
        String str2 = null;
        if (userProfile != null) {
            String phone = userProfile.getPhone();
            str2 = userProfile.getEmailId();
            str = phone;
        } else {
            str = null;
        }
        return new BasicProfileFields.Builder().withDateOfBirth(this.j).withEmailId(str2).withFirstName(this.g).withLastName(this.h).withGender(this.i).withPhone(str).build();
    }

    public final void e() {
        if (this.x) {
            this.C = new gb1(getActivity(), this.f, this.E, this.A, new jx0(this));
            LinearLayout linearLayout = this._passengerTypeView;
            linearLayout.removeAllViews();
            this.C.setEditable(this.o);
            linearLayout.addView(this.C);
            this._mainLayout.invalidate();
            this._mainLayout.requestLayout();
        } else {
            this.C = new gb1(getActivity(), this.f, this.E, this.A, null);
        }
        List<ProofViewInfo> list = this.A;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(this.B)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.B);
            if (this.B.startsWith(getResources().getString(R.string.note))) {
                spannableString.setSpan(new StyleSpan(1), 0, 5, 0);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
            this._documentDetailsNotes.setText(spannableStringBuilder);
            this._documentDetailsNotes.setVisibility(0);
        }
    }

    public final void f(String str, String str2, int i2) {
        ml1<Bitmap> j2 = gl1.e(this).j();
        j2.a(new rs1().q(50000));
        j2.m = str2;
        j2.p = true;
        j2.f(new e(i2, str, str2));
    }

    public final boolean g(String str, String str2) {
        if (str == null && str2 == null) {
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

    public final void h() {
        if (getView() != null) {
            TextView textView = (TextView) getView().findViewById(R.id.action_button);
            if (!o(false) || !ui1.f(this.A) || !this.M) {
                textView.setEnabled(false);
                textView.setAlpha(0.4f);
                return;
            }
            textView.setAlpha(1.0f);
            textView.setEnabled(true);
        }
    }

    public final void i(View view) {
        View findViewById = view.findViewById(R.id.action_button);
        j(this.u);
        String str = this.w;
        if (getView() == null) {
            this.w = str;
        } else {
            if (str == null) {
                str = getString(R.string.proceed_pass);
            }
            SpannableStringBuilder f2 = hj1.f(str);
            f2.setSpan(vn.N(getActivity(), wg1.NOTOSANS_MEDIUM), 0, f2.length(), 17);
            ((TextView) getView().findViewById(R.id.action_button)).setText(f2);
        }
        View.OnClickListener onClickListener = this.v;
        if (onClickListener == null) {
            findViewById.setOnClickListener(new f());
        } else {
            findViewById.setOnClickListener(onClickListener);
        }
    }

    public void j(boolean z2) {
        if (getView() == null) {
            this.u = z2;
        } else if (z2) {
            getView().findViewById(R.id.action_button).setVisibility(0);
        } else {
            getView().findViewById(R.id.action_button).setVisibility(8);
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Lapp/zophop/models/Agency;Ljava/lang/String;Ljava/lang/String;Ljava/util/List<Lapp/zophop/models/mTicketing/ProofViewInfo;>;Ljava/util/List<Lapp/zophop/models/mTicketing/AgencyProfileField;>;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;)V */
    public void k(Agency agency, String str, List list, Map map) {
        this.x = true;
        this.f = agency;
        this.E = map;
        this.A = list;
        this.B = str;
        if (getView() != null) {
            getView();
            e();
        }
    }

    public void l(boolean z2) {
        this.o = z2;
        if (getView() != null) {
            d(null);
            ViewGroup viewGroup = (ViewGroup) getView().findViewById(R.id.register_form);
            this._firstNameView.setEnabled(z2);
            this._lastNameView.setEnabled(z2);
            this._genderView.setEnabled(z2);
            this._dateOfBirthView.setEnabled(z2);
            this._firstNameView.setEditable(z2);
            this._lastNameView.setEditable(z2);
            if (z2) {
                this._firstNameView.setVisibility(0);
                this._lastNameView.setVisibility(0);
            } else {
                this._firstNameView.setVisibility(8);
                this._lastNameView.setVisibility(8);
            }
            this._firstNameView.getEditText().addTextChangedListener(new gx0(this, SuperPassJsonKeys.FIRST_NAME));
            this._lastNameView.getEditText().addTextChangedListener(new gx0(this, SuperPassJsonKeys.LAST_NAME));
            if (z2) {
                this._genderView.setOnClickListener(new zw0(this));
                this._dateOfBirthView.setOnClickListener(new bx0(this, new DatePickerDialog(getActivity(), new ax0(this), 1980, 1, 1)));
            } else {
                this._genderView.setOnClickListener(null);
                this._dateOfBirthView.setOnClickListener(null);
            }
            if (!z2) {
                vn.E0(viewGroup, getActivity());
                viewGroup.invalidate();
                viewGroup.requestLayout();
            }
        }
    }

    public final void m(String str, String str2, int i2) {
        getResources().getDimensionPixelSize(R.dimen.attachment_image_size);
        getResources().getDimensionPixelOffset(R.dimen.proof_height);
        this.C.c(str, str2, i2);
        f(str, str2, i2);
    }

    public void n(UserProfile userProfile) {
        List<ProofViewInfo> list;
        this.n = userProfile;
        if (getView() != null) {
            this._genderView.setText(getString(userProfile.getGender().getResId()));
            this._genderView.setTag(userProfile.getGender().toString());
            this._firstNameView.setText(vn.g(userProfile.getFirstName()));
            this._lastNameView.setText(vn.g(userProfile.getLastName()));
            this.n.getDateOfBirth();
            if (userProfile.getDateOfBirth() != null && !userProfile.getDateOfBirth().isEmpty()) {
                this._dateOfBirthView.setText(ui1.w(userProfile.getDateOfBirth()));
                this._dateOfBirthView.setTag(userProfile.getDateOfBirth());
            }
            if (userProfile.getProfilePhoto() != null && (list = this.A) != null && list.size() > 0 && this.A.get(0).getUrl() == null) {
                f(userProfile.getProfilePhoto(), userProfile.getProfilePhoto(), 0);
            }
            b();
            if (this.x && this.K != null) {
                ProfileVerificationStateView profileVerificationStateView = (ProfileVerificationStateView) getView().findViewById(R.id.profile_verification_status);
                profileVerificationStateView.setVisibility(0);
                profileVerificationStateView.a(userProfile, this.f, this.J);
            }
        }
    }

    public final boolean o(boolean z2) {
        b();
        if (this.x) {
            Gender gender = this.i;
            if (gender == null || gender.toString().isEmpty()) {
                if (z2) {
                    Toast.makeText(getActivity(), getString(R.string.gender_not_set), 0).show();
                }
                return false;
            } else if (TextUtils.isEmpty(this.j)) {
                if (z2) {
                    Toast.makeText(getActivity(), getString(R.string.dob_not_set), 0).show();
                }
                return false;
            } else {
                String str = this.g;
                if (str == null || str.length() < 1) {
                    if (z2) {
                        Toast.makeText(getActivity(), getString(R.string.first_name_not_set), 0).show();
                    }
                    return false;
                }
                String str2 = this.h;
                if (str2 == null || str2.length() < 1) {
                    if (z2) {
                        Toast.makeText(getActivity(), getString(R.string.last_name_not_set), 0).show();
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1) {
            Uri uri = null;
            if (i2 == 227) {
                if (intent != null) {
                    uri = intent.getData();
                }
                if (uri == null) {
                    uri = this.y;
                }
                wf5 h2 = hd3.h(uri);
                CropImageOptions cropImageOptions = h2.b;
                cropImageOptions.T = true;
                cropImageOptions.U = false;
                startActivityForResult(h2.a(getActivity()), 203);
            } else if (i2 == 203) {
                this.y = hd3.a1(intent).g;
                this.A.get(this.z).setImage(null);
                this.A.get(this.z).setUrl(null);
                this.A.get(this.z).setImageUrl(null);
                this.A.get(this.z).setEdited();
                try {
                    View childAt = this.C.getChildAt(this.z);
                    this.D = childAt;
                    ((ImageView) childAt.findViewById(R.id.card_view).findViewById(R.id.add_image_view)).setVisibility(8);
                    ((ImageView) this.D.findViewById(R.id.remove_icon)).setVisibility(8);
                    this.D.findViewById(R.id.profile_pic_progressbar).setVisibility(0);
                    String uuid = UUID.randomUUID().toString();
                    this.s.add(uuid);
                    xt.f3961a.c().i(MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), this.y), uuid, this.z);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ProofViewInfo proofViewInfo;
        JSONException e2;
        View inflate = layoutInflater.inflate(R.layout.user_details, viewGroup, false);
        fv0 fv0 = (fv0) getFragmentManager().findFragmentByTag("loader_tag");
        this.X = fv0;
        if (fv0 == null) {
            fv0 T2 = vn.T(null, getString(R.string.loading), false, false);
            this.X = T2;
            T2.setRetainInstance(true);
        }
        this.r = new HashMap<>();
        this.q = new ArrayList<>();
        this.s = new ArrayList();
        ArrayList<String> arrayList = this.q;
        Gender gender = Gender.MALE;
        arrayList.add(0, getString(gender.getResId()));
        this.r.put(0, gender);
        ArrayList<String> arrayList2 = this.q;
        Gender gender2 = Gender.FEMALE;
        arrayList2.add(1, getString(gender2.getResId()));
        this.r.put(1, gender2);
        ArrayList<String> arrayList3 = this.q;
        Gender gender3 = Gender.OTHER;
        arrayList3.add(2, getString(gender3.getResId()));
        this.r.put(2, gender3);
        ButterKnife.inject(this, inflate);
        getActivity().invalidateOptionsMenu();
        this._genderView.setHint(getString(R.string.profile_hint_gender_pass));
        this._dateOfBirthView.setHint(getString(R.string.profile_hint_dob_pass));
        this._firstNameView.setInputType(16384);
        this._lastNameView.setInputType(16384);
        i(inflate);
        e();
        ov ovVar = new ov();
        Bundle arguments = getArguments();
        if (!TextUtils.isEmpty(arguments.getString("magic_pass_info"))) {
            this.K = ov.r(arguments.getString("magic_pass_info"));
        } else if (!TextUtils.isEmpty(arguments.getString("mticket_info"))) {
            this.L = ovVar.q(arguments.getString("mticket_info"));
        }
        this.N = (ProfileRequestInfo) new Gson().fromJson(arguments.getString("request_info"), ProfileRequestInfo.class);
        this.T = (RouteInfo) new Gson().fromJson(arguments.getString("route_info_extra"), RouteInfo.class);
        this.R = arguments.getString("productId");
        this.S = arguments.getStringArrayList("productIds");
        MPass mPass = this.K;
        if (mPass != null) {
            this.J = mPass.getPassengerType();
        }
        jz5.b().l(UserProfileEvent.class);
        FragmentManager fragmentManager = getFragmentManager();
        mh1 mh1 = (mh1) fragmentManager.findFragmentByTag("data");
        this.O = mh1;
        if (mh1 == null) {
            this.O = new mh1();
            fragmentManager.beginTransaction().add(this.O, "data").commitAllowingStateLoss();
        }
        if (this.P == null) {
            this.P = this.O.g;
        }
        if (this.Q == null) {
            this.Q = this.O.f;
        }
        Bundle bundle2 = this.P;
        if (bundle2 != null) {
            if (bundle2.containsKey("passenger_type")) {
                this.J = this.P.getString("passenger_type");
            }
            if (this.P.containsKey(SuperPassJsonKeys.GENDER)) {
                this.i = Gender.fromString(this.P.getString(SuperPassJsonKeys.GENDER));
            }
            this.g = this.P.getString("first_name");
            this.h = this.P.getString("last_name");
            this.l = this.P.getString("phone_number");
            this.j = this.P.getString("dob");
            this.k = this.P.getString("mail_id");
            this.t = this.P.getBoolean("profile_edited");
            this.o = this.P.getBoolean("state_editable");
            this.t = this.P.getBoolean("profile_edited");
            this.p = this.P.getString("profile_image_url");
            if (this.P.containsKey("current_edited_photo")) {
                this.z = this.P.getInt("current_edited_photo");
            }
            if (this.P.containsKey("proof_list")) {
                Iterator<String> it = this.P.getStringArrayList("proof_list").iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    List<ProofViewInfo> list = this.A;
                    try {
                        JSONObject jSONObject = new JSONObject(next);
                        String optString = jSONObject.optString("proof_name", null);
                        String optString2 = jSONObject.optString("proof_url", null);
                        String optString3 = jSONObject.optString("proof_image", null);
                        proofViewInfo = new ProofViewInfo(optString, optString2);
                        if (optString3 != null) {
                            try {
                                byte[] decode = Base64.decode(optString3, 0);
                                proofViewInfo.setImage(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                            } catch (JSONException e3) {
                                e2 = e3;
                                b00 b00 = b00.f358a;
                                hj1.W0(e2);
                                list.add(proofViewInfo);
                            }
                        }
                        proofViewInfo.setEdited();
                    } catch (JSONException e4) {
                        e2 = e4;
                        proofViewInfo = null;
                        b00 b002 = b00.f358a;
                        hj1.W0(e2);
                        list.add(proofViewInfo);
                    }
                    list.add(proofViewInfo);
                }
            }
            String str = this.p;
            if (str != null) {
                m(str, str, 0);
            }
            if (this.P.containsKey("curr_photo_uri")) {
                this.y = new Uri.Builder().appendPath(this.P.getString("curr_photo_uri")).build();
            }
        }
        Gender gender4 = this.i;
        if (gender4 != null) {
            this._genderView.setText(getString(gender4.getResId()));
            this._genderView.setTag(this.i.toString());
        }
        this._firstNameView.setText(vn.g(this.g));
        this._lastNameView.setText(vn.g(this.h));
        String str2 = this.j;
        if (str2 != null && !str2.isEmpty()) {
            this._dateOfBirthView.setTag(this.j);
            this._dateOfBirthView.setText(ui1.w(this.j));
        }
        this.G.getTime();
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
        this.U = (PassDurationFormInput) inflate.findViewById(R.id.select_date);
        this.V = inflate.findViewById(R.id.start_date_seperator);
        int i2 = 8;
        this.U.setVisibility(this.L != null ? 8 : 0);
        View view = this.V;
        if (this.L == null) {
            i2 = 0;
        }
        view.setVisibility(i2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.passenger_details_notes));
        spannableString.setSpan(new StyleSpan(1), 0, 5, 0);
        spannableStringBuilder.append((CharSequence) spannableString);
        this._passengerDetailsNotes.setText(spannableStringBuilder);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(ui1.Q());
        Date time = instance.getTime();
        ra1 ra1 = new ra1(getActivity());
        long time2 = time.getTime();
        ra1.setPassDate(jh1.d(time2));
        PassDurationFormInput passDurationFormInput = this.U;
        passDurationFormInput.setHint(getString(R.string.select_pass_start_date));
        passDurationFormInput.findViewById(R.id.header_separator).setVisibility(4);
        passDurationFormInput.setText(jh1.d(time2));
        passDurationFormInput.setBackgroundColor(getResources().getColor(R.color.white));
        passDurationFormInput.setOnClickListener(new ex0(this, ra1, passDurationFormInput));
        this._checkBoxLayout.setOnClickListener(new b());
        this._termsCheckBox.setOnCheckedChangeListener(new c());
        d dVar = new d();
        if (getView() == null) {
            this.v = dVar;
        } else {
            getView().findViewById(R.id.action_button).setOnClickListener(dVar);
        }
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        jz5.b().o(this);
    }

    public void onDetach() {
        String str;
        super.onDetach();
        b();
        if (this.P == null) {
            this.P = new Bundle();
        }
        String str2 = this.J;
        if (str2 != null) {
            this.P.putString("passenger_type", str2);
        }
        Gender gender = this.i;
        if (gender != null) {
            this.P.putString(SuperPassJsonKeys.GENDER, gender.name());
        }
        this.P.putString("first_name", this.g);
        this.P.putString("last_name", this.h);
        this.P.putString("dob", this.j);
        this.P.putString("mail_id", this.k);
        this.P.putString("phone_number", this.l);
        this.P.putBoolean("profile_edited", this.t);
        this.P.putBoolean("state_editable", this.o);
        if (this.A != null) {
            this.Q = new ArrayList<>();
            for (ProofViewInfo proofViewInfo : this.A) {
                ArrayList<String> arrayList = this.Q;
                getActivity();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("proof_name", proofViewInfo.getName());
                    jSONObject.put("proof_url", proofViewInfo.getUrl());
                    if (proofViewInfo.getImage() != null) {
                        jSONObject.put("proof_image", vn.q(proofViewInfo.getImage()));
                    }
                    jSONObject.put("proof_edited", proofViewInfo.isEdited());
                    str = jSONObject.toString();
                } catch (JSONException e2) {
                    b00 b00 = b00.f358a;
                    hj1.W0(e2);
                    str = null;
                }
                arrayList.add(str);
            }
            FragmentManager fragmentManager = getFragmentManager();
            mh1 mh1 = (mh1) fragmentManager.findFragmentByTag("data");
            this.O = mh1;
            if (mh1 == null) {
                this.O = new mh1();
                fragmentManager.beginTransaction().add(this.O, "data").commitAllowingStateLoss();
            }
            mh1 mh12 = this.O;
            ArrayList<String> arrayList2 = this.Q;
            mh12.f = arrayList2;
            this.P.putStringArrayList("proof_list", arrayList2);
        }
        int i2 = this.z;
        if (i2 != -1) {
            this.P.putInt("current_edited_photo", i2);
        }
        String str3 = this.p;
        if (str3 != null) {
            this.P.putString("profile_image_url", str3);
        }
        Uri uri = this.y;
        if (uri != null) {
            this.P.putString("curr_photo_uri", uri.toString());
        }
        this.P.putInt("curr_photo_num", this.z);
        this.O.g = this.P;
    }

    public void onEvent(ImageUploadUrlEvent imageUploadUrlEvent) {
        jz5.b().m(this);
        String imageUrl = imageUploadUrlEvent.getImageUrl();
        int picNo = imageUploadUrlEvent.getPicNo();
        this.D = this.C.getChildAt(picNo);
        if (this.s.contains(imageUploadUrlEvent.getConfigRequestId())) {
            String charSequence = ((TextView) this.D.findViewById(R.id.proof_name)).getText().toString();
            ad1 responseType = imageUploadUrlEvent.getResponseType();
            String failureReason = imageUploadUrlEvent.getFailureReason();
            long responseTime = imageUploadUrlEvent.getResponseTime();
            ed1 ed1 = new ed1("document uploaded", Long.MIN_VALUE);
            ed1.a("response", responseType.name());
            ed1.a("reason", failureReason);
            ed1.a("response time", Long.valueOf(responseTime));
            ed1.a(SuperPassJsonKeys.PROOF_NAME, charSequence);
            jz5.b().g(ed1);
        }
        if (TextUtils.isEmpty(imageUrl)) {
            if (this.s.contains(imageUploadUrlEvent.getConfigRequestId())) {
                Toast.makeText(getActivity(), "Network Error !! Please try again", 1).show();
                View view = this.D;
                ((ImageView) view.findViewById(R.id.card_view).findViewById(R.id.add_image_view)).setVisibility(0);
                ((ImageView) view.findViewById(R.id.remove_icon)).setVisibility(8);
                ((ProgressBar) view.findViewById(R.id.card_view).findViewById(R.id.profile_pic_progressbar)).setVisibility(8);
                ((ImageView) this.D.findViewById(R.id.card_view).findViewById(R.id.add_image_view)).setVisibility(0);
            }
        } else if (this.s.contains(imageUploadUrlEvent.getConfigRequestId())) {
            m(imageUrl, imageUrl, picNo);
        }
        h();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 123) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        } else if (iArr.length > 0 && iArr[0] == 0) {
            this.y = vn.S0(this);
        } else if (!t4.d(getActivity(), "android.permission.CAMERA")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(getString(R.string.camera_prompt)).setPositiveButton(getString(R.string.settings), new a()).setNegativeButton("CANCEL", (DialogInterface.OnClickListener) null);
            builder.create().show();
        }
    }

    public void onResume() {
        super.onResume();
        b();
        h();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int i2 = this.z;
        if (i2 != -1 && this.y != null) {
            bundle.putInt("currentlySavedPhotoVal", i2);
            bundle.putString("uriString", this.y.toString());
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        UserProfile userProfile = this.n;
        if (userProfile != null) {
            n(userProfile);
        }
        l(this.o);
        i(view);
        h();
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            this.z = bundle.getInt("currentlySavedPhotoVal");
            this.y = Uri.parse(bundle.getString("uriString"));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x016b, code lost:
        if (r2 == false) goto L_0x016e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x011c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void p(app.zophop.models.mTicketing.UserProfile r10) {
        /*
        // Method dump skipped, instructions count: 721
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.fragments.UserDetailsFragment.p(app.zophop.models.mTicketing.UserProfile):void");
    }

    public final void q(String str, View view) {
        ZoomedImageViewActivity.h0(getActivity(), (ImageView) view, str, null);
    }

    public void onEvent(BookingTransactionEvent bookingTransactionEvent) {
        if (this.L != null) {
            jz5.b().m(bookingTransactionEvent);
            if (bookingTransactionEvent.getResponseType().equals(ad1.SUCCESS)) {
                this.L = bookingTransactionEvent.getBookingTransaction().getMTicket();
                boolean isLpEligible = bookingTransactionEvent.getBookingTransaction().isLpEligible();
                String lpId = bookingTransactionEvent.getBookingTransaction().getLpId();
                if (this.L.isPaymentRequired()) {
                    try {
                        RazorPayOrderData razorPayOrderData = bookingTransactionEvent.getRazorPayOrderData();
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("ticketId", this.L.getMTicketId());
                        jSONObject2.put("agency", this.L.getAgency());
                        jSONObject2.put("userId", this.L.getUserId());
                        jSONObject.put("currency", "INR");
                        jSONObject.put(AnalyticsConstants.ORDER_ID, razorPayOrderData.get_orderId());
                        jSONObject.put(AnalyticsConstants.AMOUNT, (((int) razorPayOrderData.get_amount()) * 100) + "");
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(AnalyticsConstants.CONTACT, this.L.getUserId());
                        jSONObject.put("prefill", jSONObject3);
                        jSONObject.put("notes", jSONObject2);
                        Bundle bundle = new Bundle();
                        bundle.putString("currency", "INR");
                        bundle.putString(AnalyticsConstants.ORDER_ID, razorPayOrderData.get_orderId());
                        bundle.putString(AnalyticsConstants.AMOUNT, ((int) razorPayOrderData.get_amount()) + "");
                        bundle.putParcelable("mticket_pass_info", this.L);
                        bundle.putBoolean("lpEligible", isLpEligible);
                        bundle.putString("eligibilityResponseId", lpId);
                        bundle.putString(AnalyticsConstants.MERCHANT_KEY, razorPayOrderData.getMerchantKey());
                        bundle.putParcelableArrayList("card_details", (ArrayList) this.L.getCardDetails());
                        Intent intent = new Intent(getActivity(), CheckoutActivity.class);
                        intent.putExtra("src", "Confirm Mticket Screen");
                        intent.putExtras(bundle);
                        startActivityForResult(intent, 12345);
                    } catch (JSONException e2) {
                        RazorPayOrderData razorPayOrderData2 = bookingTransactionEvent.getRazorPayOrderData();
                        String str = null;
                        if (razorPayOrderData2 != null) {
                            StringBuilder i0 = hj1.i0(razorPayOrderData2.get_orderId());
                            i0.append(jh1.c(System.currentTimeMillis()));
                            str = i0.toString();
                        }
                        b00 b00 = b00.f358a;
                        c00 a2 = b00.a();
                        StringBuilder i02 = hj1.i0("Payment exception for ");
                        i02.append(this.L.getMTicketId());
                        i02.append(" ");
                        i02.append(str);
                        a2.b(new Throwable(i02.toString()));
                        b00.a().b(e2);
                    }
                } else {
                    ProductRepository productRepository = new ProductRepository(getActivity());
                    MTicket mTicket = this.L;
                    mTicket.setCityName(mTicket.getCityName().toLowerCase());
                    Ticket ticket = new Ticket();
                    ticket.setTicketId(this.L.getMTicketId());
                    ticket.setmTicket(this.L);
                    productRepository.insertTicket(ticket);
                    xt.t1 t1Var = xt.f3961a;
                    t1Var.c().d(t1Var.L().getUserId(), t1Var.L().j());
                    ActivateMTicketScreen.h0(getActivity(), this.L, "user details screen", true);
                }
            } else if (bookingTransactionEvent.getStatusCode() == null) {
                Toast.makeText(getActivity(), bookingTransactionEvent.getErrorMessage(), 1).show();
            } else if (bookingTransactionEvent.getStatusCode().equals("410")) {
                this.L.set_isFreeRide(false);
                this.L.setPaymentRequired(true);
            } else {
                Toast.makeText(getActivity(), (int) R.string.toast_generic_error_message, 1).show();
            }
            DialogFragment dialogFragment = this.X;
            if (dialogFragment != null) {
                dialogFragment.dismiss();
            }
        }
    }
}
