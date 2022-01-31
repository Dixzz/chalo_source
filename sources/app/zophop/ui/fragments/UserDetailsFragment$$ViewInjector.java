package app.zophop.ui.fragments;

import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.ui.views.ZophopFormInput;
import butterknife.ButterKnife;

public class UserDetailsFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, UserDetailsFragment userDetailsFragment, Object obj) {
        userDetailsFragment._termsCheckBox = (CheckBox) finder.findRequiredView(obj, R.id.checkBox, "field '_termsCheckBox'");
        userDetailsFragment._checkBoxLayout = (RelativeLayout) finder.findRequiredView(obj, R.id.checkBoxLayout, "field '_checkBoxLayout'");
        userDetailsFragment._passengerTypeView = (LinearLayout) finder.findRequiredView(obj, R.id.form_passenger_type, "field '_passengerTypeView'");
        userDetailsFragment._firstNameView = (ZophopFormInput) finder.findRequiredView(obj, R.id.form_first_name, "field '_firstNameView'");
        userDetailsFragment._lastNameView = (ZophopFormInput) finder.findRequiredView(obj, R.id.form_last_name, "field '_lastNameView'");
        userDetailsFragment._genderView = (ZophopFormInput) finder.findRequiredView(obj, R.id.form_gender, "field '_genderView'");
        userDetailsFragment._dateOfBirthView = (ZophopFormInput) finder.findRequiredView(obj, R.id.form_dob, "field '_dateOfBirthView'");
        userDetailsFragment._passengerDetailsNotes = (TextView) finder.findRequiredView(obj, R.id.passenger_details_notes, "field '_passengerDetailsNotes'");
        userDetailsFragment._documentDetailsNotes = (TextView) finder.findRequiredView(obj, R.id.document_details_notes, "field '_documentDetailsNotes'");
        userDetailsFragment._mainLayout = (ScrollView) finder.findRequiredView(obj, R.id.register_scroller, "field '_mainLayout'");
    }

    public static void reset(UserDetailsFragment userDetailsFragment) {
        userDetailsFragment._termsCheckBox = null;
        userDetailsFragment._checkBoxLayout = null;
        userDetailsFragment._passengerTypeView = null;
        userDetailsFragment._firstNameView = null;
        userDetailsFragment._lastNameView = null;
        userDetailsFragment._genderView = null;
        userDetailsFragment._dateOfBirthView = null;
        userDetailsFragment._passengerDetailsNotes = null;
        userDetailsFragment._documentDetailsNotes = null;
        userDetailsFragment._mainLayout = null;
    }
}
