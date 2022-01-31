package defpackage;

import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import com.urbanairship.messagecenter.R;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: lu5  reason: default package */
/* compiled from: DefaultMultiChoiceModeListener */
public class lu5 implements AbsListView.MultiChoiceModeListener {

    /* renamed from: a  reason: collision with root package name */
    public final fv5 f2280a;

    public lu5(fv5 fv5) {
        this.f2280a = fv5;
    }

    public final Set<String> a() {
        wu5 f;
        HashSet hashSet = new HashSet();
        AbsListView absListView = this.f2280a.g;
        if (absListView == null) {
            return hashSet;
        }
        SparseBooleanArray checkedItemPositions = absListView.getCheckedItemPositions();
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            if (checkedItemPositions.valueAt(i) && (f = this.f2280a.f(checkedItemPositions.keyAt(i))) != null) {
                hashSet.add(f.j);
            }
        }
        return hashSet;
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        if (this.f2280a.g == null) {
            return false;
        }
        if (menuItem.getItemId() == R.id.mark_read) {
            yu5.j().g.f(a());
            actionMode.finish();
        } else if (menuItem.getItemId() == R.id.delete) {
            qu5 qu5 = yu5.j().g;
            Set<String> a2 = a();
            qu5.h.execute(new ru5(qu5, a2));
            synchronized (qu5.y) {
                Iterator it = ((HashSet) a2).iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    wu5 d = qu5.d(str);
                    if (d != null) {
                        d.q = true;
                        qu5.c.remove(str);
                        qu5.d.remove(str);
                        qu5.b.add(str);
                    }
                }
            }
            qu5.g();
            actionMode.finish();
        } else if (menuItem.getItemId() == R.id.select_all) {
            int count = this.f2280a.g.getCount();
            for (int i = 0; i < count; i++) {
                this.f2280a.g.setItemChecked(i, true);
            }
        }
        return true;
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        wu5 f;
        boolean z = false;
        if (this.f2280a.g == null) {
            return false;
        }
        actionMode.getMenuInflater().inflate(R.menu.ua_mc_action_mode, menu);
        int checkedItemCount = this.f2280a.g.getCheckedItemCount();
        actionMode.setTitle(this.f2280a.getResources().getQuantityString(R.plurals.ua_selected_count, checkedItemCount, Integer.valueOf(checkedItemCount)));
        SparseBooleanArray checkedItemPositions = this.f2280a.g.getCheckedItemPositions();
        int i = 0;
        while (true) {
            if (i < checkedItemPositions.size()) {
                if (checkedItemPositions.valueAt(i) && (f = this.f2280a.f(checkedItemPositions.keyAt(i))) != null && !(!f.r)) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        menu.findItem(R.id.mark_read).setVisible(z);
        return true;
    }

    public void onDestroyActionMode(ActionMode actionMode) {
    }

    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        AbsListView absListView = this.f2280a.g;
        if (absListView != null) {
            int checkedItemCount = absListView.getCheckedItemCount();
            actionMode.setTitle(this.f2280a.getResources().getQuantityString(R.plurals.ua_selected_count, checkedItemCount, Integer.valueOf(checkedItemCount)));
            if (this.f2280a.e() != null) {
                this.f2280a.e().notifyDataSetChanged();
            }
            actionMode.invalidate();
        }
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        wu5 f;
        AbsListView absListView = this.f2280a.g;
        boolean z = false;
        if (absListView == null) {
            return false;
        }
        SparseBooleanArray checkedItemPositions = absListView.getCheckedItemPositions();
        int i = 0;
        while (true) {
            if (i < checkedItemPositions.size()) {
                if (checkedItemPositions.valueAt(i) && (f = this.f2280a.f(checkedItemPositions.keyAt(i))) != null && !(!f.r)) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        menu.findItem(R.id.mark_read).setVisible(z);
        return true;
    }
}
