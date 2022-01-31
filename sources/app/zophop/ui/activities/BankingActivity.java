package app.zophop.ui.activities;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.PaymentItem;
import app.zophop.ui.activities.CheckoutActivity;
import defpackage.q5;
import defpackage.vj0;
import java.util.List;
import java.util.Objects;

public class BankingActivity extends tf1 {
    public List<PaymentItem> j;
    public vj0 k;
    public String l;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            BankingActivity.this.upPressed(view);
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
            vj0 vj0 = BankingActivity.this.k;
            Objects.requireNonNull(vj0);
            new vj0.a().filter(editable);
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    @Override // defpackage.tf1
    public void d0() {
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.netbanking_layout);
        jz5.b().g(new ed1("Banking Screen Opened", Long.MIN_VALUE));
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().y(R.string.banking_title);
        getSupportActionBar().o(true);
        getSupportActionBar().f();
        if (getIntent().getParcelableArrayListExtra("bankNames") != null) {
            this.j = getIntent().getParcelableArrayListExtra("bankNames");
        }
        if (getIntent().hasExtra("errorCopy")) {
            this.l = getIntent().getStringExtra("errorCopy");
        }
        if (getIntent().hasExtra("warningCopy")) {
            getIntent().getStringExtra("warningCopy");
        }
        findViewById(R.id.back).setOnClickListener(new a());
        findViewById(R.id.picker_search_bar).setVisibility(0);
        findViewById(R.id.loading_spinner).setVisibility(8);
        EditText editText = (EditText) findViewById(R.id.location_input);
        editText.setHint(R.string.banking_hint);
        editText.setHintTextColor(getResources().getColor(R.color.black_40));
        editText.addTextChangedListener(new b());
        if (Build.VERSION.SDK_INT >= 28) {
            editText.requestFocus();
        }
        editText.setOnEditorActionListener(new bd1(editText, this));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.bankingLayout);
        recyclerView.setLayoutManager(new LinearLayoutManager(1, false));
        recyclerView.setNestedScrollingEnabled(false);
        Object obj = q5.f2896a;
        recyclerView.f(new CheckoutActivity.f(q5.c.b(this, R.drawable.divider)));
        vj0 vj0 = new vj0(this, this.j, this.l, true);
        this.k = vj0;
        recyclerView.setAdapter(vj0);
    }

    @Override // defpackage.tf1
    public void g0() {
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e(bundle);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void upPressed(View view) {
        finish();
    }
}
