package app.zophop.ui.views;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;

public class EditTextListeners extends EditText {
    public EditTextListeners(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onSelectionChanged(int i, int i2) {
        Editable text = getText();
        if (text == null || (i == text.length() && i2 == text.length())) {
            super.onSelectionChanged(i, i2);
        } else {
            setSelection(text.length(), text.length());
        }
    }
}
