package defpackage;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.Stop;
import java.util.List;

/* renamed from: gl0  reason: default package */
/* compiled from: ZophopPickLocationDefaultAdapter */
public class gl0 extends BaseAdapter {
    public final String f;
    public final Context g;
    public final LayoutInflater h;
    public final List<d> i;
    public PopupWindow j;

    /* renamed from: gl0$a */
    /* compiled from: ZophopPickLocationDefaultAdapter */
    public class a implements View.OnClickListener {
        public final /* synthetic */ ImageView f;
        public final /* synthetic */ mf1 g;

        public a(ImageView imageView, mf1 mf1) {
            this.f = imageView;
            this.g = mf1;
        }

        public void onClick(View view) {
            gl0 gl0 = gl0.this;
            ImageView imageView = this.f;
            mf1 mf1 = this.g;
            View inflate = gl0.h.inflate(R.layout.favorite_edit_pop_up, (ViewGroup) null, false);
            int dimensionPixelSize = gl0.g.getResources().getDimensionPixelSize(R.dimen.favorite_edit_pop_up_width);
            PopupWindow popupWindow = new PopupWindow(gl0.g);
            gl0.j = popupWindow;
            popupWindow.setContentView(inflate);
            gl0.j.setWidth(dimensionPixelSize);
            gl0.j.setHeight(-2);
            gl0.j.setFocusable(true);
            gl0.j.setBackgroundDrawable(new BitmapDrawable());
            gl0.j.setSoftInputMode(3);
            gl0.j.showAsDropDown(imageView, 0, 0);
            inflate.findViewById(R.id.remove).setOnClickListener(new ll0(gl0, mf1));
            inflate.findViewById(R.id.edit).setOnClickListener(new kl0(gl0, mf1));
        }
    }

    /* renamed from: gl0$b */
    /* compiled from: ZophopPickLocationDefaultAdapter */
    public enum b {
        HOME,
        WORK,
        RECENT,
        FAVORITE,
        STOP
    }

    /* renamed from: gl0$c */
    /* compiled from: ZophopPickLocationDefaultAdapter */
    public enum c {
        MY_LOCATION,
        FAVORITE_ITEM,
        RECENT_ITEM,
        SET_HOME,
        SET_WORK,
        RECENT_SEARCH_STRING,
        DIVIDER,
        STOP
    }

    public gl0(Context context, List<d> list, String str) {
        this.f = str;
        this.g = context;
        this.h = LayoutInflater.from(context);
        this.i = list;
    }

    public rg1 a(mf1 mf1, c cVar) {
        String str;
        String str2;
        rg1 rg1 = new rg1(this.g);
        String str3 = mf1.c;
        int indexOf = str3.indexOf(",");
        if (indexOf != -1) {
            str2 = str3.substring(0, indexOf).trim();
            str = str3.substring(indexOf + 1).trim();
        } else {
            str2 = str3.trim();
            str = null;
        }
        rg1.b(str2, str, b(cVar.equals(c.RECENT_ITEM) ? b.RECENT : b.STOP), d(false));
        rg1.setBackgroundResource(R.color.white);
        rg1.findViewById(R.id.bus_agency_name).setVisibility(8);
        return rg1;
    }

    public int b(b bVar) {
        int ordinal = bVar.ordinal();
        if (ordinal == 0) {
            return R.drawable.favorite_home;
        }
        if (ordinal == 1) {
            return R.drawable.favorite_work;
        }
        if (ordinal != 3) {
            return ordinal != 4 ? R.drawable.location_search : R.drawable.bus_stop_details;
        }
        return R.drawable.favorite_added;
    }

    public rg1 c(mf1 mf1) {
        rg1 rg1 = new rg1(this.g);
        rg1.setBackgroundResource(R.color.white);
        ImageView settingsIconView = rg1.getSettingsIconView();
        settingsIconView.setOnClickListener(new a(settingsIconView, mf1));
        rg1.findViewById(R.id.bus_agency_name).setVisibility(8);
        return rg1;
    }

    public int d(boolean z) {
        return z ? R.drawable.favorite_overflow : R.drawable.favorite_add;
    }

    public View e(ViewGroup viewGroup, mf1 mf1, c cVar) {
        String str;
        int i2;
        rg1 c2 = c(mf1);
        String str2 = mf1.b;
        if (cVar.equals(c.SET_HOME)) {
            str = this.g.getString(R.string.saved_destination_dialog_home);
            i2 = b(b.HOME);
        } else {
            str = this.g.getString(R.string.saved_destination_dialog_work);
            i2 = b(b.WORK);
        }
        if (mf1.b == null || mf1.f2368a == null) {
            View inflate = this.h.inflate(R.layout.favorite_list_recent, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(R.id.item_description);
            textView.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
            textView.setPadding(this.g.getResources().getDimensionPixelSize(R.dimen.favorite_set_homework_left_padding), this.g.getResources().getDimensionPixelSize(R.dimen.favorite_set_homework_top_padding), 0, this.g.getResources().getDimensionPixelSize(R.dimen.favorite_set_homework_top_padding));
            inflate.setAlpha(0.15f);
            g(textView, this.g.getString(R.string.favorite_saving_data));
            return inflate;
        }
        c2.b(str, str2, i2, d(true));
        g(c2.getTitleView(), str);
        return c2;
    }

    public View f(ViewGroup viewGroup, c cVar) {
        String str;
        int i2;
        View inflate = this.h.inflate(R.layout.favorite_list_recent, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.item_description);
        if (cVar.equals(c.SET_HOME)) {
            str = this.g.getString(R.string.favorite_set_home);
            i2 = b(b.HOME);
            inflate.setOnClickListener(new il0(this, 1));
        } else {
            str = this.g.getString(R.string.favorite_set_work);
            i2 = b(b.WORK);
            inflate.setOnClickListener(new il0(this, 2));
        }
        g(textView, str);
        textView.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
        textView.setPadding(this.g.getResources().getDimensionPixelSize(R.dimen.favorite_set_homework_left_padding), this.g.getResources().getDimensionPixelSize(R.dimen.favorite_set_homework_top_padding), 0, this.g.getResources().getDimensionPixelSize(R.dimen.favorite_set_homework_top_padding));
        return inflate;
    }

    public void g(TextView textView, String str) {
        SpannableStringBuilder f2 = hj1.f(str);
        f2.setSpan(vn.N(this.g, wg1.NOTOSANS_MEDIUM), 0, f2.length(), 17);
        f2.setSpan(new AbsoluteSizeSpan(18, true), 0, f2.length(), 17);
        textView.setText(f2);
    }

    public int getCount() {
        return this.i.size();
    }

    public Object getItem(int i2) {
        if (!this.i.get(i2).f1277a.equals(c.STOP)) {
            return this.i.get(i2).b;
        }
        return this.i.get(i2).c;
    }

    public long getItemId(int i2) {
        return 0;
    }

    public int getItemViewType(int i2) {
        return 0;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        String str;
        String str2;
        c cVar = this.i.get(i2).f1277a;
        c cVar2 = c.STOP;
        mf1 mf1 = !cVar.equals(cVar2) ? (mf1) getItem(i2) : null;
        switch (cVar.ordinal()) {
            case 0:
                rg1 c2 = c(mf1);
                c2.b(this.g.getString(R.string.favorite_my_location), null, R.drawable.mylocation_search, 0);
                return c2;
            case 1:
                rg1 c3 = c(mf1);
                String str3 = mf1.c;
                c3.b(str3, mf1.b, b(b.FAVORITE), d(true));
                g(c3.getTitleView(), str3);
                return c3;
            case 2:
                rg1 a2 = a(mf1, c.RECENT_ITEM);
                a2.getSettingsIconView().setOnClickListener(new jl0(this, mf1));
                return a2;
            case 3:
                if (mf1 == null) {
                    return f(viewGroup, c.SET_HOME);
                }
                return e(viewGroup, mf1, c.SET_HOME);
            case 4:
                if (mf1 == null) {
                    return f(viewGroup, c.SET_WORK);
                }
                return e(viewGroup, mf1, c.SET_WORK);
            case 5:
                View inflate = this.h.inflate(R.layout.favorite_list_recent, viewGroup, false);
                TextView textView = (TextView) inflate.findViewById(R.id.item_description);
                textView.setPadding(this.g.getResources().getDimensionPixelSize(R.dimen.favorite_set_homework_left_padding), this.g.getResources().getDimensionPixelSize(R.dimen.favorite_recent_top_padding), 0, this.g.getResources().getDimensionPixelSize(R.dimen.favorite_recent_top_padding));
                hj1.v0(this.g, R.color.black_60, textView);
                inflate.setBackgroundColor(this.g.getResources().getColor(R.color.favorite_recent_background));
                inflate.setClickable(false);
                return inflate;
            case 6:
                return this.h.inflate(R.layout.divider, viewGroup, false);
            case 7:
                Stop stop = (Stop) getItem(i2);
                String name = stop.getName();
                stop.getLatLong();
                rg1 rg1 = new rg1(this.g);
                int indexOf = name.indexOf(",");
                if (indexOf != -1) {
                    str2 = name.substring(0, indexOf).trim();
                    str = name.substring(indexOf + 1).trim();
                } else {
                    str2 = name.trim();
                    str = null;
                }
                rg1.b(str2, str, b(cVar2.equals(c.RECENT_ITEM) ? b.RECENT : b.STOP), d(false));
                rg1.setBackgroundResource(R.color.white);
                rg1.findViewById(R.id.bus_agency_name).setVisibility(8);
                rg1.getLeftSideIcon().setImageResource(mk0.b(stop.getMode()));
                rg1.getSettingsIconView().setOnClickListener(new hl0(this, stop));
                return rg1;
            default:
                return null;
        }
    }

    public int getViewTypeCount() {
        c.values();
        return 8;
    }

    public boolean isEnabled(int i2) {
        int ordinal = this.i.get(i2).f1277a.ordinal();
        if (ordinal != 3 && ordinal != 4) {
            return (ordinal == 5 || ordinal == 6) ? false : true;
        }
        mf1 mf1 = (mf1) getItem(i2);
        if (mf1 == null) {
            return true;
        }
        if (mf1.f2368a == null || mf1.b == null) {
            return false;
        }
        return true;
    }

    /* renamed from: gl0$d */
    /* compiled from: ZophopPickLocationDefaultAdapter */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final c f1277a;
        public final mf1 b;
        public final Stop c;

        public d(c cVar, mf1 mf1) {
            this.f1277a = cVar;
            this.b = mf1;
            this.c = null;
        }

        public d(c cVar, Stop stop) {
            this.f1277a = cVar;
            this.c = stop;
            this.b = null;
        }
    }
}
