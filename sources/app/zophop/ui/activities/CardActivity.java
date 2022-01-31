package app.zophop.ui.activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.CardDetails;
import app.zophop.ui.views.ZophopFormInput;
import com.razorpay.AnalyticsConstants;
import java.util.ArrayList;
import java.util.Objects;

public class CardActivity extends au {
    public static final /* synthetic */ int l = 0;
    public final ArrayList<String> k = new ArrayList<>();

    public static class a implements TextWatcher {
        public final View f;

        public a(View view) {
            this.f = view;
        }

        public void afterTextChanged(Editable editable) {
            this.f.setVisibility(8);
            if (editable.length() > 19) {
                editable.delete(editable.length() - 1, editable.length());
            }
            if (editable.length() > 0 && editable.length() % 5 == 0 && ' ' == editable.charAt(editable.length() - 1)) {
                editable.delete(editable.length() - 1, editable.length());
            }
            if (editable.length() > 0 && editable.length() % 5 == 0 && Character.isDigit(editable.charAt(editable.length() - 1)) && TextUtils.split(editable.toString(), String.valueOf(' ')).length <= 3) {
                editable.insert(editable.length() - 1, String.valueOf(' '));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public static boolean h0(CardActivity cardActivity, String str) {
        Objects.requireNonNull(cardActivity);
        int length = str.trim().length();
        for (int i = 1; i < length; i++) {
            if (!(Character.isDigit(str.charAt(i)) || Character.isWhitespace(str.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        jz5.b().g(new ed1("card screen opened", Long.MIN_VALUE));
        setContentView(R.layout.card_layout);
        this.k.add("^4[0-9]{6,}$");
        this.k.add("^5[1-5][0-9]{5,}$");
        this.k.add("^3[47][0-9]{5,}$");
        this.k.add("^3(?:0[0-5]|[68][0-9])[0-9]{4,}$");
        this.k.add("^6(?:011|5[0-9]{2})[0-9]{3,}$");
        this.k.add("^(?:2131|1800|35[0-9]{3})[0-9]{3,}$");
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().y(R.string.card_details_title);
        getSupportActionBar().o(true);
        CheckBox checkBox = (CheckBox) findViewById(R.id.save_card_checkbox);
        ZophopFormInput zophopFormInput = (ZophopFormInput) findViewById(R.id.expiryDate);
        ZophopFormInput zophopFormInput2 = (ZophopFormInput) findViewById(R.id.cvv);
        ZophopFormInput zophopFormInput3 = (ZophopFormInput) findViewById(R.id.cardNumber);
        ZophopFormInput zophopFormInput4 = (ZophopFormInput) findViewById(R.id.cardName);
        EditText editText = (EditText) findViewById(R.id.cvv_saved);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.card_layout);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.saved_card_container);
        zophopFormInput3.getEditText().setInputType(3);
        zophopFormInput2.getEditText().setInputType(18);
        editText.setInputType(18);
        zophopFormInput.getEditText().setInputType(2);
        editText.addTextChangedListener(new jd0(this, editText));
        TextView textView = (TextView) findViewById(R.id.proceedBtn);
        textView.setText(ui1.l(getIntent().getStringExtra(AnalyticsConstants.AMOUNT)));
        ((RelativeLayout) findViewById(R.id.checkbox_layout)).setOnClickListener(new kd0(this, checkBox));
        textView.setOnClickListener(new ld0(this, linearLayout2, editText, linearLayout, zophopFormInput3, zophopFormInput, zophopFormInput2, zophopFormInput4, checkBox));
        zophopFormInput4.setInputChangeListener(new md0(this, zophopFormInput4));
        zophopFormInput2.setInputChangeListener(new nd0(this, zophopFormInput2));
        zophopFormInput3.getEditText().addTextChangedListener(new a(findViewById(R.id.card_number_error)));
        zophopFormInput.setInputChangeListener(new od0(this, zophopFormInput, new boolean[]{false}));
        CardDetails cardDetails = (getIntent() == null || getIntent().getParcelableExtra("cardDetails") == null) ? null : (CardDetails) getIntent().getParcelableExtra("cardDetails");
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.card_layout);
        LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.saved_card_container);
        if (cardDetails != null) {
            linearLayout4.setVisibility(0);
            linearLayout3.setVisibility(8);
            findViewById(R.id.cvv_saved).postDelayed(new id0(this, (InputMethodManager) getSystemService("input_method")), 100);
            return;
        }
        linearLayout4.setVisibility(8);
        linearLayout3.setVisibility(0);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        super.onBackPressed();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive() && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onDestroy() {
        super.onDestroy();
        jz5.b().o(this);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onPause() {
        super.onPause();
        ui1.U(this);
    }
}
