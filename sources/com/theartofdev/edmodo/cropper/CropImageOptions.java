package com.theartofdev.edmodo.cropper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.firebase.perf.util.Constants;
import com.theartofdev.edmodo.cropper.CropImageView;

public class CropImageOptions implements Parcelable {
    public static final Parcelable.Creator<CropImageOptions> CREATOR = new a();
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public CharSequence I;
    public int J;
    public Uri K;
    public Bitmap.CompressFormat L;
    public int M;
    public int N;
    public int O;
    public CropImageView.j P;
    public boolean Q;
    public Rect R;
    public int S;
    public boolean T;
    public boolean U;
    public boolean V;
    public int W;
    public boolean X;
    public boolean Y;
    public CharSequence Z;
    public int a0;
    public CropImageView.c f;
    public float g;
    public float h;
    public CropImageView.d i;
    public CropImageView.k j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public float p;
    public boolean q;
    public int r;
    public int s;
    public float t;
    public int u;
    public float v;
    public float w;
    public float x;
    public int y;
    public float z;

    public static class a implements Parcelable.Creator<CropImageOptions> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public CropImageOptions createFromParcel(Parcel parcel) {
            return new CropImageOptions(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public CropImageOptions[] newArray(int i) {
            return new CropImageOptions[i];
        }
    }

    public CropImageOptions() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        this.f = CropImageView.c.RECTANGLE;
        this.g = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.h = TypedValue.applyDimension(1, 24.0f, displayMetrics);
        this.i = CropImageView.d.ON_TOUCH;
        this.j = CropImageView.k.FIT_CENTER;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = false;
        this.o = 4;
        this.p = 0.1f;
        this.q = false;
        this.r = 1;
        this.s = 1;
        this.t = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.u = Color.argb(170, (int) Constants.MAX_HOST_LENGTH, (int) Constants.MAX_HOST_LENGTH, (int) Constants.MAX_HOST_LENGTH);
        this.v = TypedValue.applyDimension(1, 2.0f, displayMetrics);
        this.w = TypedValue.applyDimension(1, 5.0f, displayMetrics);
        this.x = TypedValue.applyDimension(1, 14.0f, displayMetrics);
        this.y = -1;
        this.z = TypedValue.applyDimension(1, 1.0f, displayMetrics);
        this.A = Color.argb(170, (int) Constants.MAX_HOST_LENGTH, (int) Constants.MAX_HOST_LENGTH, (int) Constants.MAX_HOST_LENGTH);
        this.B = Color.argb(119, 0, 0, 0);
        this.C = (int) TypedValue.applyDimension(1, 42.0f, displayMetrics);
        this.D = (int) TypedValue.applyDimension(1, 42.0f, displayMetrics);
        this.E = 40;
        this.F = 40;
        this.G = 99999;
        this.H = 99999;
        this.I = "";
        this.J = 0;
        this.K = Uri.EMPTY;
        this.L = Bitmap.CompressFormat.JPEG;
        this.M = 90;
        this.N = 0;
        this.O = 0;
        this.P = CropImageView.j.NONE;
        this.Q = false;
        this.R = null;
        this.S = -1;
        this.T = true;
        this.U = true;
        this.V = false;
        this.W = 90;
        this.X = false;
        this.Y = false;
        this.Z = null;
        this.a0 = 0;
    }

    public void a() {
        if (this.o < 0) {
            throw new IllegalArgumentException("Cannot set max zoom to a number < 1");
        } else if (this.h >= 0.0f) {
            float f2 = this.p;
            if (f2 < 0.0f || ((double) f2) >= 0.5d) {
                throw new IllegalArgumentException("Cannot set initial crop window padding value to a number < 0 or >= 0.5");
            } else if (this.r <= 0) {
                throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
            } else if (this.s <= 0) {
                throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
            } else if (this.t < 0.0f) {
                throw new IllegalArgumentException("Cannot set line thickness value to a number less than 0.");
            } else if (this.v < 0.0f) {
                throw new IllegalArgumentException("Cannot set corner thickness value to a number less than 0.");
            } else if (this.z < 0.0f) {
                throw new IllegalArgumentException("Cannot set guidelines thickness value to a number less than 0.");
            } else if (this.D >= 0) {
                int i2 = this.E;
                if (i2 >= 0) {
                    int i3 = this.F;
                    if (i3 < 0) {
                        throw new IllegalArgumentException("Cannot set min crop result height value to a number < 0 ");
                    } else if (this.G < i2) {
                        throw new IllegalArgumentException("Cannot set max crop result width to smaller value than min crop result width");
                    } else if (this.H < i3) {
                        throw new IllegalArgumentException("Cannot set max crop result height to smaller value than min crop result height");
                    } else if (this.N < 0) {
                        throw new IllegalArgumentException("Cannot set request width value to a number < 0 ");
                    } else if (this.O >= 0) {
                        int i4 = this.W;
                        if (i4 < 0 || i4 > 360) {
                            throw new IllegalArgumentException("Cannot set rotation degrees value to a number < 0 or > 360");
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot set request height value to a number < 0 ");
                    }
                } else {
                    throw new IllegalArgumentException("Cannot set min crop result width value to a number < 0 ");
                }
            } else {
                throw new IllegalArgumentException("Cannot set min crop window height value to a number < 0 ");
            }
        } else {
            throw new IllegalArgumentException("Cannot set touch radius value to a number <= 0 ");
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f.ordinal());
        parcel.writeFloat(this.g);
        parcel.writeFloat(this.h);
        parcel.writeInt(this.i.ordinal());
        parcel.writeInt(this.j.ordinal());
        parcel.writeByte(this.k ? (byte) 1 : 0);
        parcel.writeByte(this.l ? (byte) 1 : 0);
        parcel.writeByte(this.m ? (byte) 1 : 0);
        parcel.writeByte(this.n ? (byte) 1 : 0);
        parcel.writeInt(this.o);
        parcel.writeFloat(this.p);
        parcel.writeByte(this.q ? (byte) 1 : 0);
        parcel.writeInt(this.r);
        parcel.writeInt(this.s);
        parcel.writeFloat(this.t);
        parcel.writeInt(this.u);
        parcel.writeFloat(this.v);
        parcel.writeFloat(this.w);
        parcel.writeFloat(this.x);
        parcel.writeInt(this.y);
        parcel.writeFloat(this.z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G);
        parcel.writeInt(this.H);
        TextUtils.writeToParcel(this.I, parcel, i2);
        parcel.writeInt(this.J);
        parcel.writeParcelable(this.K, i2);
        parcel.writeString(this.L.name());
        parcel.writeInt(this.M);
        parcel.writeInt(this.N);
        parcel.writeInt(this.O);
        parcel.writeInt(this.P.ordinal());
        parcel.writeInt(this.Q ? 1 : 0);
        parcel.writeParcelable(this.R, i2);
        parcel.writeInt(this.S);
        parcel.writeByte(this.T ? (byte) 1 : 0);
        parcel.writeByte(this.U ? (byte) 1 : 0);
        parcel.writeByte(this.V ? (byte) 1 : 0);
        parcel.writeInt(this.W);
        parcel.writeByte(this.X ? (byte) 1 : 0);
        parcel.writeByte(this.Y ? (byte) 1 : 0);
        TextUtils.writeToParcel(this.Z, parcel, i2);
        parcel.writeInt(this.a0);
    }

    public CropImageOptions(Parcel parcel) {
        this.f = CropImageView.c.values()[parcel.readInt()];
        this.g = parcel.readFloat();
        this.h = parcel.readFloat();
        this.i = CropImageView.d.values()[parcel.readInt()];
        this.j = CropImageView.k.values()[parcel.readInt()];
        boolean z2 = true;
        this.k = parcel.readByte() != 0;
        this.l = parcel.readByte() != 0;
        this.m = parcel.readByte() != 0;
        this.n = parcel.readByte() != 0;
        this.o = parcel.readInt();
        this.p = parcel.readFloat();
        this.q = parcel.readByte() != 0;
        this.r = parcel.readInt();
        this.s = parcel.readInt();
        this.t = parcel.readFloat();
        this.u = parcel.readInt();
        this.v = parcel.readFloat();
        this.w = parcel.readFloat();
        this.x = parcel.readFloat();
        this.y = parcel.readInt();
        this.z = parcel.readFloat();
        this.A = parcel.readInt();
        this.B = parcel.readInt();
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = parcel.readInt();
        this.F = parcel.readInt();
        this.G = parcel.readInt();
        this.H = parcel.readInt();
        this.I = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.J = parcel.readInt();
        this.K = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.L = Bitmap.CompressFormat.valueOf(parcel.readString());
        this.M = parcel.readInt();
        this.N = parcel.readInt();
        this.O = parcel.readInt();
        this.P = CropImageView.j.values()[parcel.readInt()];
        this.Q = parcel.readByte() != 0;
        this.R = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        this.S = parcel.readInt();
        this.T = parcel.readByte() != 0;
        this.U = parcel.readByte() != 0;
        this.V = parcel.readByte() != 0;
        this.W = parcel.readInt();
        this.X = parcel.readByte() != 0;
        this.Y = parcel.readByte() == 0 ? false : z2;
        this.Z = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.a0 = parcel.readInt();
    }
}
