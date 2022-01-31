package defpackage;

import android.content.Context;
import android.text.TextUtils;
import app.zophop.R;
import app.zophop.models.UniversalSearchItem;
import app.zophop.models.UniversalSearchViewItem;
import app.zophop.pubsub.eventbus.events.TripPlannerEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: z61  reason: default package */
/* compiled from: UniversalSearchListDiffUtil */
public class z61 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4136a = false;
    public String b;
    public List<UniversalSearchItem> c = new ArrayList();
    public final Context d;
    public boolean e;
    public List<UniversalSearchViewItem> f;
    public TripPlannerEvent.ResponseType g;
    public boolean h = false;

    public z61(Context context) {
        this.d = context;
        i();
    }

    public void a() {
        this.b = null;
        this.c.clear();
        this.c = new ArrayList();
        i();
    }

    public final UniversalSearchViewItem b() {
        return new UniversalSearchViewItem(UniversalSearchViewItem.Type.DIVIDER, "");
    }

    public int c(UniversalSearchItem.UniversalSearchItemType universalSearchItemType) {
        int i = 0;
        for (UniversalSearchItem universalSearchItem : this.c) {
            if (universalSearchItem.getType().equals(universalSearchItemType)) {
                i++;
            }
        }
        return i;
    }

    public final List<UniversalSearchViewItem> d() {
        ArrayList arrayList = new ArrayList();
        List<UniversalSearchItem> g2 = g(UniversalSearchItem.UniversalSearchItemType.ROUTE);
        if (g2.size() > 0) {
            String string = this.d.getString(R.string.Routes);
            UniversalSearchViewItem universalSearchViewItem = new UniversalSearchViewItem(UniversalSearchViewItem.Type.HEADER, string);
            UniversalSearchViewItem universalSearchViewItem2 = new UniversalSearchViewItem(UniversalSearchViewItem.Type.SEE_MORE, string);
            if (this.f4136a) {
                universalSearchViewItem2 = new UniversalSearchViewItem(UniversalSearchViewItem.Type.SEE_LESS, string);
            }
            arrayList.add(universalSearchViewItem);
            for (UniversalSearchItem universalSearchItem : g2) {
                arrayList.add(new UniversalSearchViewItem(UniversalSearchViewItem.Type.ITEM, universalSearchItem));
                arrayList.add(b());
            }
            if (c(UniversalSearchItem.UniversalSearchItemType.ROUTE) > 2) {
                arrayList.add(universalSearchViewItem2);
                arrayList.add(b());
            }
        }
        return arrayList;
    }

    public final List<UniversalSearchViewItem> e() {
        ArrayList arrayList = new ArrayList();
        UniversalSearchItem.UniversalSearchItemType universalSearchItemType = UniversalSearchItem.UniversalSearchItemType.STOP;
        ArrayList arrayList2 = (ArrayList) f(universalSearchItemType);
        if (arrayList2.size() > 0) {
            if (ui1.e0()) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.add(new UniversalSearchViewItem(UniversalSearchViewItem.Type.ITEM, (UniversalSearchItem) it.next()));
                    arrayList.add(b());
                }
            } else {
                String string = this.d.getString(R.string.STOPS_HEADER);
                List<UniversalSearchItem> g2 = g(universalSearchItemType);
                UniversalSearchViewItem universalSearchViewItem = new UniversalSearchViewItem(UniversalSearchViewItem.Type.HEADER, string);
                UniversalSearchViewItem universalSearchViewItem2 = new UniversalSearchViewItem(UniversalSearchViewItem.Type.SEE_MORE, string);
                if (this.h) {
                    universalSearchViewItem2 = new UniversalSearchViewItem(UniversalSearchViewItem.Type.SEE_LESS, string);
                }
                arrayList.add(universalSearchViewItem);
                for (UniversalSearchItem universalSearchItem : g2) {
                    arrayList.add(new UniversalSearchViewItem(UniversalSearchViewItem.Type.ITEM, universalSearchItem));
                    arrayList.add(b());
                }
                if (c(UniversalSearchItem.UniversalSearchItemType.STOP) > 2) {
                    arrayList.add(universalSearchViewItem2);
                    arrayList.add(b());
                }
            }
        }
        return arrayList;
    }

    public List<UniversalSearchItem> f(UniversalSearchItem.UniversalSearchItemType universalSearchItemType) {
        ArrayList arrayList = new ArrayList();
        for (UniversalSearchItem universalSearchItem : this.c) {
            if (universalSearchItem.getType().equals(universalSearchItemType)) {
                arrayList.add(universalSearchItem);
            }
        }
        return arrayList;
    }

    public List<UniversalSearchItem> g(UniversalSearchItem.UniversalSearchItemType universalSearchItemType) {
        if (ui1.Y() || ui1.X() ? !((!this.f4136a || !universalSearchItemType.equals(UniversalSearchItem.UniversalSearchItemType.ROUTE)) && (!this.h || !universalSearchItemType.equals(UniversalSearchItem.UniversalSearchItemType.STOP))) : !(!this.f4136a && universalSearchItemType.equals(UniversalSearchItem.UniversalSearchItemType.ROUTE))) {
            return f(universalSearchItemType);
        }
        return ((ArrayList) f(universalSearchItemType)).subList(0, Math.min(((ArrayList) f(universalSearchItemType)).size(), 2));
    }

    public final boolean h() {
        return c(UniversalSearchItem.UniversalSearchItemType.ROUTE) > 0;
    }

    public final void i() {
        ArrayList arrayList = new ArrayList();
        List<UniversalSearchItem> f2 = f(UniversalSearchItem.UniversalSearchItemType.TRIPS_LOCATIONS);
        List<UniversalSearchItem> f3 = f(UniversalSearchItem.UniversalSearchItemType.TRIPS_STOPS);
        ArrayList arrayList2 = new ArrayList();
        if (!(((ArrayList) f2).size() == 0 && ((ArrayList) f3).size() == 0)) {
            arrayList2.add(new UniversalSearchViewItem(UniversalSearchViewItem.Type.HEADER, xt.f3961a.t().f("tripUniversalSearchCopy")));
        }
        for (UniversalSearchItem universalSearchItem : this.c) {
            UniversalSearchViewItem universalSearchViewItem = new UniversalSearchViewItem(UniversalSearchViewItem.Type.ITEM, universalSearchItem);
            if (universalSearchItem.getType().equals(UniversalSearchItem.UniversalSearchItemType.TRIPS_STOPS) || universalSearchItem.getType().equals(UniversalSearchItem.UniversalSearchItemType.TRIPS_LOCATIONS)) {
                arrayList2.add(universalSearchViewItem);
                arrayList2.add(b());
            }
        }
        arrayList.addAll(arrayList2);
        if (ui1.e0()) {
            arrayList.addAll(e());
        } else if (ui1.X()) {
            arrayList.addAll(d());
            arrayList.addAll(e());
            ArrayList arrayList3 = new ArrayList();
            List<UniversalSearchItem> g2 = g(UniversalSearchItem.UniversalSearchItemType.LOCATION);
            UniversalSearchViewItem universalSearchViewItem2 = new UniversalSearchViewItem(UniversalSearchViewItem.Type.HEADER, this.d.getString(R.string.places));
            if (!vn.K0(this.d) && h()) {
                arrayList3.add(universalSearchViewItem2);
                arrayList3.add(new UniversalSearchViewItem(UniversalSearchViewItem.Type.ERROR_STATE, this.d.getString(R.string.universal_internet_no_places)));
            } else if (g2.size() > 0) {
                arrayList3.add(universalSearchViewItem2);
                for (UniversalSearchItem universalSearchItem2 : this.c) {
                    UniversalSearchViewItem universalSearchViewItem3 = new UniversalSearchViewItem(UniversalSearchViewItem.Type.ITEM, universalSearchItem2);
                    if (universalSearchItem2.getType().equals(UniversalSearchItem.UniversalSearchItemType.LOCATION)) {
                        arrayList3.add(universalSearchViewItem3);
                        arrayList3.add(b());
                    }
                }
                if (this.e) {
                    arrayList3.add(new UniversalSearchViewItem(UniversalSearchViewItem.Type.LOADER, ""));
                    arrayList3.add(b());
                }
            } else if (this.e && h()) {
                arrayList3.add(universalSearchViewItem2);
                arrayList3.add(new UniversalSearchViewItem(UniversalSearchViewItem.Type.LOADER, ""));
                arrayList3.add(b());
            }
            arrayList.addAll(arrayList3);
        } else {
            arrayList.addAll(d());
            ArrayList arrayList4 = new ArrayList();
            List<UniversalSearchItem> g3 = g(UniversalSearchItem.UniversalSearchItemType.STOP);
            List<UniversalSearchItem> g4 = g(UniversalSearchItem.UniversalSearchItemType.LOCATION);
            UniversalSearchViewItem universalSearchViewItem4 = new UniversalSearchViewItem(UniversalSearchViewItem.Type.HEADER, this.d.getString(R.string.places));
            if (!vn.K0(this.d) && h()) {
                arrayList4.add(universalSearchViewItem4);
                arrayList4.add(new UniversalSearchViewItem(UniversalSearchViewItem.Type.ERROR_STATE, this.d.getString(R.string.universal_internet_no_places)));
            } else if (g3.size() > 0 || g4.size() > 0) {
                arrayList4.add(universalSearchViewItem4);
                for (UniversalSearchItem universalSearchItem3 : this.c) {
                    UniversalSearchViewItem universalSearchViewItem5 = new UniversalSearchViewItem(UniversalSearchViewItem.Type.ITEM, universalSearchItem3);
                    if (universalSearchItem3.getType().equals(UniversalSearchItem.UniversalSearchItemType.LOCATION) || universalSearchItem3.getType().equals(UniversalSearchItem.UniversalSearchItemType.STOP)) {
                        arrayList4.add(universalSearchViewItem5);
                        arrayList4.add(b());
                    }
                }
                if (this.e) {
                    arrayList4.add(new UniversalSearchViewItem(UniversalSearchViewItem.Type.LOADER, ""));
                    arrayList4.add(b());
                }
            } else if (this.e && h()) {
                arrayList4.add(universalSearchViewItem4);
                arrayList4.add(new UniversalSearchViewItem(UniversalSearchViewItem.Type.LOADER, ""));
                arrayList4.add(b());
            }
            arrayList.addAll(arrayList4);
        }
        if (arrayList.size() == 0 && !this.e && !TextUtils.isEmpty(this.b)) {
            String string = this.d.getString(R.string.no_results_found);
            if (TripPlannerEvent.ResponseType.FAILED.equals(this.g)) {
                arrayList.add(new UniversalSearchViewItem(UniversalSearchViewItem.Type.QUERY_FAILED, this.d.getString(R.string.something_bad_happened)));
            } else {
                arrayList.add(new UniversalSearchViewItem(UniversalSearchViewItem.Type.EMPTY_STATE, string));
            }
        }
        this.f = arrayList;
    }

    public void j(List<UniversalSearchItem> list, String str) {
        ArrayList arrayList = new ArrayList(list);
        String str2 = this.b;
        if (str2 == null || !str2.equals(str)) {
            a();
            this.b = str;
            this.c = new ArrayList(arrayList);
        } else {
            boolean z = !h();
            boolean z2 = true ^ (c(UniversalSearchItem.UniversalSearchItemType.STOP) > 0);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                UniversalSearchItem universalSearchItem = (UniversalSearchItem) it.next();
                if (ui1.e0()) {
                    if (universalSearchItem.getType().equals(UniversalSearchItem.UniversalSearchItemType.STOP)) {
                        this.c.add(universalSearchItem);
                    }
                } else if (universalSearchItem.getType().equals(UniversalSearchItem.UniversalSearchItemType.LOCATION)) {
                    this.c.add(universalSearchItem);
                } else if (universalSearchItem.getType().equals(UniversalSearchItem.UniversalSearchItemType.ROUTE) && z) {
                    this.c.add(universalSearchItem);
                } else if (universalSearchItem.getType().equals(UniversalSearchItem.UniversalSearchItemType.STOP) && z2) {
                    this.c.add(universalSearchItem);
                } else if (universalSearchItem.getType().equals(UniversalSearchItem.UniversalSearchItemType.TRIPS_STOPS)) {
                    this.c.add(universalSearchItem);
                } else if (universalSearchItem.getType().equals(UniversalSearchItem.UniversalSearchItemType.TRIPS_LOCATIONS)) {
                    this.c.add(universalSearchItem);
                }
            }
        }
        i();
    }
}
