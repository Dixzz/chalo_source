package defpackage;

import android.database.Cursor;
import android.widget.Filter;

/* renamed from: y9  reason: default package */
/* compiled from: CursorFilter */
public class y9 extends Filter {

    /* renamed from: a  reason: collision with root package name */
    public a f4022a;

    /* renamed from: y9$a */
    /* compiled from: CursorFilter */
    public interface a {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    public y9(a aVar) {
        this.f4022a = aVar;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f4022a.convertToString((Cursor) obj);
    }

    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.f4022a.runQueryOnBackgroundThread(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filterResults.count = runQueryOnBackgroundThread.getCount();
            filterResults.values = runQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursor = this.f4022a.getCursor();
        Object obj = filterResults.values;
        if (obj != null && obj != cursor) {
            this.f4022a.changeCursor((Cursor) obj);
        }
    }
}
