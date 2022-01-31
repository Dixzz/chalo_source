package app.zophop.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
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

public class PassDurationFormInput extends LinearLayout {
    public static final /* synthetic */ int p = 0;
    public EditText f;
    public TextView g;
    public View h;
    public String i;
    public String j;
    public boolean k = false;
    public int l;
    public int m;
    public int n;
    public b o;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            b bVar;
            PassDurationFormInput.this.i = charSequence.toString();
            PassDurationFormInput passDurationFormInput = PassDurationFormInput.this;
            passDurationFormInput.f.setSelection(passDurationFormInput.i.length());
            PassDurationFormInput passDurationFormInput2 = PassDurationFormInput.this;
            if (passDurationFormInput2.k && passDurationFormInput2.hasFocus() && (bVar = PassDurationFormInput.this.o) != null) {
                bVar.a();
            }
        }
    }

    public interface b {
        void a();
    }

    public PassDurationFormInput(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setOrientation(1);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.pass_duration_layout, (ViewGroup) this, false);
        addView(inflate);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ZophopFormInput, 0, 0);
        this.k = obtainStyledAttributes.getBoolean(0, false);
        this.i = obtainStyledAttributes.getString(3);
        this.j = obtainStyledAttributes.getString(1);
        this.l = obtainStyledAttributes.getResourceId(4, -1);
        this.m = obtainStyledAttributes.getResourceId(2, -1);
        this.n = obtainStyledAttributes.getResourceId(5, 100);
        obtainStyledAttributes.recycle();
        EditText editText = (EditText) ((LinearLayout) inflate.findViewById(R.id.input_edit)).getChildAt(0);
        this.f = editText;
        editText.setId(View.generateViewId());
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
        this.f.setOnFocusChangeListener(new kb1(this));
        a();
        setInputType(96);
    }

    private TextWatcher getCurrentTextChangeListener() {
        return new a();
    }

    public final void a() {
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
                setOnClickListener(new lb1(this));
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

    public String getText() {
        return this.i;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.k) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setEditable(boolean z) {
        this.k = z;
        a();
        invalidate();
        a();
    }

    public void setHint(String str) {
        this.j = str;
        this.g.setText(str);
    }

    public void setInputChangeListener(b bVar) {
        this.o = bVar;
    }

    public void setInputType(int i2) {
        this.f.setInputType(i2 | 1 | 524288);
        EditText editText = this.f;
        editText.setSelection(editText.getText().length());
    }

    public void setText(String str) {
        this.i = str;
        this.f.setText(str);
        String str2 = this.i;
        if (str2 != null) {
            this.f.setSelection(str2.length());
        }
        a();
    }

    public void setText(SpannableStringBuilder spannableStringBuilder) {
        this.i = spannableStringBuilder.toString();
        this.f.setText(spannableStringBuilder);
        String str = this.i;
        if (str != null) {
            this.f.setSelection(str.length());
        }
        a();
    }
}
