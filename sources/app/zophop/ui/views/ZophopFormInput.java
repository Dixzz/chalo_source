package app.zophop.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;

public class ZophopFormInput extends LinearLayout {
    public EditTextListeners f;
    public TextView g;
    public View h;
    public String i;
    public String j;
    public boolean k = false;
    public int l;
    public int m;
    public int n;
    public boolean o = false;
    public b p;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            b bVar = ZophopFormInput.this.p;
            if (bVar != null) {
                bVar.c();
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            b bVar = ZophopFormInput.this.p;
            if (bVar != null) {
                bVar.b();
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            b bVar;
            ZophopFormInput.this.i = charSequence.toString();
            ZophopFormInput zophopFormInput = ZophopFormInput.this;
            if (zophopFormInput.k && zophopFormInput.hasFocus() && (bVar = ZophopFormInput.this.p) != null) {
                bVar.a();
            }
        }
    }

    public interface b {
        void a();

        void b();

        void c();
    }

    public ZophopFormInput(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setOrientation(1);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.zophop_form_input, (ViewGroup) this, false);
        addView(inflate);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ZophopFormInput, 0, 0);
        this.k = obtainStyledAttributes.getBoolean(0, false);
        this.i = obtainStyledAttributes.getString(3);
        this.j = obtainStyledAttributes.getString(1);
        this.l = obtainStyledAttributes.getResourceId(4, -1);
        this.m = obtainStyledAttributes.getResourceId(2, -1);
        this.n = obtainStyledAttributes.getResourceId(5, 100);
        obtainStyledAttributes.recycle();
        EditTextListeners editTextListeners = (EditTextListeners) ((LinearLayout) inflate.findViewById(R.id.input_edit)).getChildAt(0);
        this.f = editTextListeners;
        editTextListeners.setId(View.generateViewId());
        this.h = inflate.findViewById(R.id.input_container);
        TextView textView = (TextView) inflate.findViewById(R.id.field_description);
        this.g = textView;
        textView.setText(this.j);
        this.f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.n)});
        if (this.l >= 0) {
            this.f.setTextAppearance(inflate.getContext(), this.l);
        }
        if (this.m >= 0) {
            this.g.setTextAppearance(inflate.getContext(), this.m);
        }
        this.f.addTextChangedListener(getCurrentTextChangeListener());
        this.f.setOnFocusChangeListener(new yb1(this));
        b();
        setInputType(96);
    }

    private TextWatcher getCurrentTextChangeListener() {
        return new a();
    }

    public void a() {
        setEditable(false);
        setEnabled(false);
        setOnClickListener(null);
        this.o = true;
    }

    public final void b() {
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        if (!this.k) {
            layoutParams.width = -2;
        } else {
            layoutParams.width = -1;
        }
        this.f.setLayoutParams(layoutParams);
        String str = this.i;
        if (str == null || str.length() == 0) {
            this.h.setVisibility(8);
            if (this.k) {
                setOnClickListener(new zb1(this));
            }
        } else {
            this.h.setVisibility(0);
            this.f.setText(this.i);
            this.f.setFocusableInTouchMode(this.k);
            this.f.setFocusable(this.k);
        }
        this.f.setClickable(true);
        requestLayout();
        invalidate();
    }

    public EditText getEditText() {
        return this.f;
    }

    public String getText() {
        return this.i;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.k) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setCustomTextChangeListener(TextWatcher textWatcher) {
        this.f.addTextChangedListener(textWatcher);
    }

    public void setEditable(boolean z) {
        if (!this.o) {
            this.k = z;
            b();
            invalidate();
        }
        b();
    }

    public void setHint(String str) {
        this.j = str;
        this.g.setText(str);
    }

    public void setInputChangeListener(b bVar) {
        this.p = bVar;
    }

    public void setInputType(int i2) {
        this.f.setInputType(i2 | 1 | 524288);
        EditTextListeners editTextListeners = this.f;
        editTextListeners.setSelection(editTextListeners.getText().length());
    }

    public void setText(String str) {
        this.i = str;
        this.f.setText(str);
        String str2 = this.i;
        if (str2 != null) {
            this.f.setSelection(str2.length());
        }
        b();
    }
}
