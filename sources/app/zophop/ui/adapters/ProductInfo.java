package app.zophop.ui.adapters;

import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.ProductGroup;
import java.util.List;

public class ProductInfo implements Parcelable {
    public static final Parcelable.Creator<ProductInfo> CREATOR = new a();
    public String f;
    public String g;
    public int h;
    public String i;
    public String j;
    public String k;
    public String l;
    public final int m;
    public String n;
    public String o;
    public List<String> p;
    public int q;
    public boolean r;
    public String s;
    public boolean t;
    public ProductGroup u;

    public class a implements Parcelable.Creator<ProductInfo> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ProductInfo createFromParcel(Parcel parcel) {
            return new ProductInfo(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ProductInfo[] newArray(int i) {
            return new ProductInfo[i];
        }
    }

    public ProductInfo(Parcel parcel) {
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readInt();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readInt();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readArrayList(ClassLoader.getSystemClassLoader());
        this.q = parcel.readInt();
        boolean z = true;
        this.r = parcel.readByte() != 0;
        this.s = parcel.readString();
        this.t = parcel.readByte() == 0 ? false : z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeInt(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeList(this.p);
        parcel.writeInt(this.q);
        parcel.writeByte(this.r ? (byte) 1 : 0);
        parcel.writeString(this.s);
        parcel.writeByte(this.t ? (byte) 1 : 0);
    }

    public ProductInfo(String str, String str2, String str3, String str4, int i2, ProductGroup productGroup) {
        this.i = str;
        this.f = str2;
        this.g = str3;
        this.k = str4;
        this.m = i2;
        this.u = productGroup;
    }

    public ProductInfo(String str, int i2, int i3, String str2, ProductGroup productGroup) {
        this.f = str;
        this.q = i2;
        this.m = i3;
        this.n = str2;
        this.u = productGroup;
    }
}
