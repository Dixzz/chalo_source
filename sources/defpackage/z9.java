package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: z9  reason: default package */
/* compiled from: ResourceCursorAdapter */
public abstract class z9 extends x9 {
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;

    @Deprecated
    public z9(Context context, int i, Cursor cursor) {
        super(context, cursor);
        this.mDropDownLayout = i;
        this.mLayout = i;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // defpackage.x9
    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.mDropDownLayout, viewGroup, false);
    }

    @Override // defpackage.x9
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.mLayout, viewGroup, false);
    }

    public void setDropDownViewResource(int i) {
        this.mDropDownLayout = i;
    }

    public void setViewResource(int i) {
        this.mLayout = i;
    }

    @Deprecated
    public z9(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.mDropDownLayout = i;
        this.mLayout = i;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public z9(Context context, int i, Cursor cursor, int i2) {
        super(context, cursor, i2);
        this.mDropDownLayout = i;
        this.mLayout = i;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
