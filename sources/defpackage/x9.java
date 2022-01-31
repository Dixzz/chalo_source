package defpackage;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import defpackage.y9;

/* renamed from: x9  reason: default package */
/* compiled from: CursorAdapter */
public abstract class x9 extends BaseAdapter implements Filterable, y9.a {
    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    public boolean mAutoRequery;
    public a mChangeObserver;
    public Context mContext;
    public Cursor mCursor;
    public y9 mCursorFilter;
    public DataSetObserver mDataSetObserver;
    public boolean mDataValid;
    public FilterQueryProvider mFilterQueryProvider;
    public int mRowIDColumn;

    /* renamed from: x9$a */
    /* compiled from: CursorAdapter */
    public class a extends ContentObserver {
        public a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            x9.this.onContentChanged();
        }
    }

    /* renamed from: x9$b */
    /* compiled from: CursorAdapter */
    public class b extends DataSetObserver {
        public b() {
        }

        public void onChanged() {
            x9 x9Var = x9.this;
            x9Var.mDataValid = true;
            x9Var.notifyDataSetChanged();
        }

        public void onInvalidated() {
            x9 x9Var = x9.this;
            x9Var.mDataValid = false;
            x9Var.notifyDataSetInvalidated();
        }
    }

    @Deprecated
    public x9(Context context, Cursor cursor) {
        init(context, cursor, 1);
    }

    public abstract void bindView(View view, Context context, Cursor cursor);

    @Override // defpackage.y9.a
    public void changeCursor(Cursor cursor) {
        Cursor swapCursor = swapCursor(cursor);
        if (swapCursor != null) {
            swapCursor.close();
        }
    }

    @Override // defpackage.y9.a
    public abstract CharSequence convertToString(Cursor cursor);

    public int getCount() {
        Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // defpackage.y9.a
    public Cursor getCursor() {
        return this.mCursor;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.mDataValid) {
            return null;
        }
        this.mCursor.moveToPosition(i);
        if (view == null) {
            view = newDropDownView(this.mContext, this.mCursor, viewGroup);
        }
        bindView(view, this.mContext, this.mCursor);
        return view;
    }

    public Filter getFilter() {
        if (this.mCursorFilter == null) {
            this.mCursorFilter = new y9(this);
        }
        return this.mCursorFilter;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.mFilterQueryProvider;
    }

    public Object getItem(int i) {
        Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.mCursor;
    }

    public long getItemId(int i) {
        Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null || !cursor.moveToPosition(i)) {
            return 0;
        }
        return this.mCursor.getLong(this.mRowIDColumn);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.mDataValid) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.mCursor.moveToPosition(i)) {
            if (view == null) {
                view = newView(this.mContext, this.mCursor, viewGroup);
            }
            bindView(view, this.mContext, this.mCursor);
            return view;
        } else {
            throw new IllegalStateException(hj1.I("couldn't move cursor to position ", i));
        }
    }

    public abstract boolean hasStableIds();

    @Deprecated
    public void init(Context context, Cursor cursor, boolean z) {
        init(context, cursor, z ? 1 : 2);
    }

    public abstract View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    public void onContentChanged() {
        Cursor cursor;
        if (this.mAutoRequery && (cursor = this.mCursor) != null && !cursor.isClosed()) {
            this.mDataValid = this.mCursor.requery();
        }
    }

    @Override // defpackage.y9.a
    public abstract Cursor runQueryOnBackgroundThread(CharSequence charSequence);

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        this.mFilterQueryProvider = filterQueryProvider;
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            a aVar = this.mChangeObserver;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mCursor = cursor;
        if (cursor != null) {
            a aVar2 = this.mChangeObserver;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.mDataSetObserver;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.mRowIDColumn = cursor.getColumnIndexOrThrow("_id");
            this.mDataValid = true;
            notifyDataSetChanged();
        } else {
            this.mRowIDColumn = -1;
            this.mDataValid = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public void init(Context context, Cursor cursor, int i) {
        boolean z = false;
        if ((i & 1) == 1) {
            i |= 2;
            this.mAutoRequery = true;
        } else {
            this.mAutoRequery = false;
        }
        if (cursor != null) {
            z = true;
        }
        this.mCursor = cursor;
        this.mDataValid = z;
        this.mContext = context;
        this.mRowIDColumn = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.mChangeObserver = new a();
            this.mDataSetObserver = new b();
        } else {
            this.mChangeObserver = null;
            this.mDataSetObserver = null;
        }
        if (z) {
            a aVar = this.mChangeObserver;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public x9(Context context, Cursor cursor, boolean z) {
        init(context, cursor, z ? 1 : 2);
    }

    public x9(Context context, Cursor cursor, int i) {
        init(context, cursor, i);
    }
}
