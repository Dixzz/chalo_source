package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.RouteInfo;
import java.util.List;

/* renamed from: ml0  reason: default package */
/* compiled from: ZophopPickRouteDefaultAdapter */
public class ml0 extends BaseAdapter {
    public final boolean f = xt.f3961a.c().K();
    public final Context g;
    public final LayoutInflater h;
    public final boolean i;
    public final List<b> j;

    /* renamed from: ml0$a */
    /* compiled from: ZophopPickRouteDefaultAdapter */
    public enum a {
        RECENT_ITEM,
        RECENT_SEARCH_STRING,
        DIVIDER
    }

    /* renamed from: ml0$b */
    /* compiled from: ZophopPickRouteDefaultAdapter */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final a f2394a;
        public final RouteInfo b;

        public b(a aVar, RouteInfo routeInfo) {
            this.f2394a = aVar;
            this.b = routeInfo;
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/content/Context;Ljava/util/List<Lml0$b;>;Ljava/lang/String;Z)V */
    public ml0(Context context, List list, boolean z) {
        this.g = context;
        this.h = LayoutInflater.from(context);
        this.j = list;
        this.i = z;
    }

    public int getCount() {
        return this.j.size();
    }

    public Object getItem(int i2) {
        return this.j.get(i2).b;
    }

    public long getItemId(int i2) {
        return 0;
    }

    public int getItemViewType(int i2) {
        return 0;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        int ordinal = this.j.get(i2).f2394a.ordinal();
        if (ordinal == 0) {
            return fk0.b(this.j.get(i2).b, null, this.g, this.f, this.i);
        }
        if (ordinal == 1) {
            TextView textView = (TextView) this.h.inflate(R.layout.universal_recent_view, viewGroup, false);
            textView.setText(this.g.getString(R.string.Recent_searches));
            textView.setClickable(false);
            return textView;
        } else if (ordinal != 2) {
            return null;
        } else {
            return this.h.inflate(R.layout.divider, viewGroup, false);
        }
    }

    public int getViewTypeCount() {
        a.values();
        return 3;
    }

    public boolean isEnabled(int i2) {
        int ordinal = this.j.get(i2).f2394a.ordinal();
        return (ordinal == 1 || ordinal == 2) ? false : true;
    }
}
