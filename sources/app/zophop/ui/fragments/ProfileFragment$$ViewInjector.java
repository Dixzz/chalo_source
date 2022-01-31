package app.zophop.ui.fragments;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.ui.views.ZophopFormInput;
import butterknife.ButterKnife;

public class ProfileFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, ProfileFragment profileFragment, Object obj) {
        profileFragment._profileText = (TextView) finder.findRequiredView(obj, R.id.profile_pic_text, "field '_profileText'");
        profileFragment._passengerTypeView = (ZophopFormInput) finder.findRequiredView(obj, R.id.form_passenger_type, "field '_passengerTypeView'");
        profileFragment._firstNameView = (ZophopFormInput) finder.findRequiredView(obj, R.id.form_first_name, "field '_firstNameView'");
        profileFragment._lastNameView = (ZophopFormInput) finder.findRequiredView(obj, R.id.form_last_name, "field '_lastNameView'");
        profileFragment._genderView = (ZophopFormInput) finder.findRequiredView(obj, R.id.form_gender, "field '_genderView'");
        profileFragment._dateOfBirthView = (ZophopFormInput) finder.findRequiredView(obj, R.id.form_dob, "field '_dateOfBirthView'");
        profileFragment._emailIdView = (ZophopFormInput) finder.findRequiredView(obj, R.id.form_email_id, "field '_emailIdView'");
        profileFragment._phoneNumberView = (ZophopFormInput) finder.findRequiredView(obj, R.id.form_phone_number, "field '_phoneNumberView'");
        profileFragment._profilePictureView = (ImageView) finder.findRequiredView(obj, R.id.register_profile_picture, "field '_profilePictureView'");
        profileFragment._profilePictureLoader = (ProgressBar) finder.findRequiredView(obj, R.id.profile_pic_progressbar, "field '_profilePictureLoader'");
    }

    public static void reset(ProfileFragment profileFragment) {
        profileFragment._profileText = null;
        profileFragment._passengerTypeView = null;
        profileFragment._firstNameView = null;
        profileFragment._lastNameView = null;
        profileFragment._genderView = null;
        profileFragment._dateOfBirthView = null;
        profileFragment._emailIdView = null;
        profileFragment._phoneNumberView = null;
        profileFragment._profilePictureView = null;
        profileFragment._profilePictureLoader = null;
    }
}
