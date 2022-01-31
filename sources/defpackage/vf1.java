package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import app.zophop.utilities.R;

/* renamed from: vf1  reason: default package */
/* compiled from: PickerActivity */
public abstract class vf1 extends tf1 {
    public LinearLayout j;
    public ListView k;
    public EditText l;
    public boolean m;
    public View n;
    public View o;
    public View p;
    public Handler q;
    public boolean r;

    /* renamed from: vf1$a */
    /* compiled from: PickerActivity */
    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.toString().trim().length() == 0) {
                vf1.this.p.setVisibility(4);
                vf1.this.findViewById(R.id.loading_spinner).setVisibility(4);
                return;
            }
            vf1.this.p.setVisibility(0);
            vf1.this.l.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            vf1.this.findViewById(R.id.loading_spinner).setVisibility(0);
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            vf1.this.q.removeMessages(1);
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("bundle:queryString", charSequence.toString());
            message.what = 1;
            message.setData(bundle);
            vf1.this.q.sendMessageDelayed(message, 300);
        }
    }

    /* renamed from: vf1$b */
    /* compiled from: PickerActivity */
    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            vf1.this.upPressed(view);
        }
    }

    /* renamed from: vf1$c */
    /* compiled from: PickerActivity */
    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            vf1.this.clear(view);
        }
    }

    public void clear(View view) {
        this.l.setText((CharSequence) null);
        this.p.setVisibility(4);
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        getSupportActionBar().f();
        setContentView(R.layout.pick_location);
        n0();
        findViewById(R.id.loading_spinner).setVisibility(8);
        String stringExtra = getIntent().getStringExtra("extra:search_copy");
        int intExtra = getIntent().getIntExtra("extra:search_color", R.color.black);
        this.m = true;
        this.k.setAdapter(i0());
        this.l.setHint(stringExtra);
        this.l.setHintTextColor(getResources().getColor(intExtra));
        this.q = new wf1(this);
        this.l.addTextChangedListener(new a());
        this.k.setOnItemClickListener(j0());
        if (!vn.K0(this)) {
            this.r = f0(this.j);
        }
    }

    public abstract ListAdapter h0();

    public abstract ListAdapter i0();

    public abstract AdapterView.OnItemClickListener j0();

    public String k0() {
        return this.l.getText().toString();
    }

    public void l0(boolean z) {
        if (!z) {
            e0();
            this.r = false;
        } else if (!this.r) {
            this.r = f0(this.j);
        }
    }

    public void m0() {
    }

    public void n0() {
        this.n = findViewById(R.id.back);
        this.j = (LinearLayout) findViewById(R.id.pick_location_container);
        this.k = (ListView) findViewById(R.id.location_list);
        this.p = findViewById(R.id.location_clear);
        this.o = findViewById(R.id.settings_error);
        EditText editText = (EditText) findViewById(R.id.location_input);
        this.l = editText;
        vn.X0(this, editText);
        this.n.setOnClickListener(new b());
        this.p.setOnClickListener(new c());
        this.o.setOnClickListener(new gh1(this));
    }

    public void o0(String str) {
        String trim = str.trim();
        if (trim.length() == 0) {
            this.m = true;
            this.k.setAdapter(i0());
        } else if (trim.length() <= 0 || !this.m) {
            ((Filterable) this.k.getAdapter()).getFilter().filter(trim);
        } else {
            this.m = false;
            this.k.setAdapter(h0());
            ((Filterable) this.k.getAdapter()).getFilter().filter(trim);
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m0();
        e(bundle);
    }

    public void onEvent(qd1 qd1) {
        l0(!qd1.f2931a);
    }

    public void onEventMainThread(od1 od1) {
        EditText editText = this.l;
        if (editText != null && od1.f2678a.equals(editText.getText().toString())) {
            findViewById(R.id.loading_spinner).setVisibility(8);
        }
    }

    @Override // defpackage.f0, defpackage.ve
    public void onStart() {
        super.onStart();
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    @Override // defpackage.f0, defpackage.ve
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }

    public void upPressed(View view) {
        finish();
    }
}
