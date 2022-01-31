package defpackage;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonValue;
import com.urbanairship.messagecenter.MessageItemView;
import defpackage.kt5;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/* renamed from: jv5  reason: default package */
/* compiled from: MessageViewAdapter */
public abstract class jv5 extends BaseAdapter {
    public final List<wu5> f = new ArrayList();
    public final Context g;
    public final int h;

    public jv5(Context context, int i) {
        this.g = context;
        this.h = i;
    }

    public int getCount() {
        return this.f.size();
    }

    public Object getItem(int i) {
        if (i >= this.f.size() || i < 0) {
            return null;
        }
        return this.f.get(i);
    }

    public long getItemId(int i) {
        if (i >= this.f.size() || i < 0) {
            return -1;
        }
        return (long) this.f.get(i).j.hashCode();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.g).inflate(this.h, viewGroup, false);
        }
        if (i < this.f.size() && i >= 0) {
            wu5 wu5 = this.f.get(i);
            hv5 hv5 = (hv5) this;
            if (view instanceof MessageItemView) {
                MessageItemView messageItemView = (MessageItemView) view;
                int i2 = hv5.i.n;
                TextView textView = messageItemView.g;
                DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(messageItemView.getContext());
                Objects.requireNonNull(wu5);
                textView.setText(dateFormat.format(new Date(wu5.h)));
                if (!wu5.r) {
                    messageItemView.f.setText(wu5.o);
                } else {
                    SpannableString spannableString = new SpannableString(wu5.o);
                    spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 0);
                    messageItemView.f.setText(spannableString, TextView.BufferType.SPANNABLE);
                }
                CheckBox checkBox = messageItemView.i;
                if (checkBox != null) {
                    checkBox.setChecked(messageItemView.isActivated());
                }
                if (messageItemView.h != null) {
                    JsonValue u = wu5.p.n().u("icons");
                    kt5.b bVar = new kt5.b(u.f instanceof zt5 ? u.n().u("list_icon").i() : null, null);
                    bVar.f2120a = i2;
                    kt5 kt5 = new kt5(bVar, null);
                    UAirship l = UAirship.l();
                    if (l.p == null) {
                        l.p = new gt5(UAirship.d());
                    }
                    ((gt5) l.p).a(messageItemView.getContext(), messageItemView.h, kt5);
                }
                messageItemView.setHighlighted(wu5.j.equals(hv5.i.k));
                messageItemView.setSelectionListener(new gv5(hv5, i));
            }
        }
        return view;
    }

    public boolean hasStableIds() {
        return true;
    }
}
