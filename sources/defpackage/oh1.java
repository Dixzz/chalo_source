package defpackage;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

/* renamed from: oh1  reason: default package */
/* compiled from: ExtensionUtils.kt */
public final class oh1 implements ActionMode.Callback {
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        n86.e(menuItem, "item");
        return false;
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        n86.e(menu, "menu");
        return false;
    }

    public void onDestroyActionMode(ActionMode actionMode) {
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        n86.e(menu, "menu");
        return false;
    }
}
