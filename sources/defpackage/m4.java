package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.constraintlayout.widget.R;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import defpackage.n4;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: m4  reason: default package */
/* compiled from: ConstraintSet */
public class m4 {
    public static final int[] d = {0, 4, 8};
    public static SparseIntArray e;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, j4> f2320a = new HashMap<>();
    public boolean b = true;
    public HashMap<Integer, a> c = new HashMap<>();

    /* renamed from: m4$a */
    /* compiled from: ConstraintSet */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2321a;
        public final d b = new d();
        public final c c = new c();
        public final b d = new b();
        public final e e = new e();
        public HashMap<String, j4> f = new HashMap<>();

        public void a(ConstraintLayout.a aVar) {
            b bVar = this.d;
            aVar.d = bVar.h;
            aVar.e = bVar.i;
            aVar.f = bVar.j;
            aVar.g = bVar.k;
            aVar.h = bVar.l;
            aVar.i = bVar.m;
            aVar.j = bVar.n;
            aVar.k = bVar.o;
            aVar.l = bVar.p;
            aVar.p = bVar.q;
            aVar.q = bVar.r;
            aVar.r = bVar.s;
            aVar.s = bVar.t;
            ((ViewGroup.MarginLayoutParams) aVar).leftMargin = bVar.D;
            ((ViewGroup.MarginLayoutParams) aVar).rightMargin = bVar.E;
            ((ViewGroup.MarginLayoutParams) aVar).topMargin = bVar.F;
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = bVar.G;
            aVar.x = bVar.O;
            aVar.y = bVar.N;
            aVar.u = bVar.K;
            aVar.w = bVar.M;
            aVar.z = bVar.u;
            aVar.A = bVar.v;
            aVar.m = bVar.x;
            aVar.n = bVar.y;
            b bVar2 = this.d;
            aVar.o = bVar2.z;
            aVar.B = bVar2.w;
            aVar.P = bVar2.A;
            aVar.Q = bVar2.B;
            aVar.E = bVar2.P;
            aVar.D = bVar2.Q;
            aVar.G = bVar2.S;
            aVar.F = bVar2.R;
            aVar.S = bVar2.h0;
            aVar.T = bVar2.i0;
            aVar.H = bVar2.T;
            aVar.I = bVar2.U;
            aVar.L = bVar2.V;
            aVar.M = bVar2.W;
            aVar.J = bVar2.X;
            aVar.K = bVar2.Y;
            aVar.N = bVar2.Z;
            aVar.O = bVar2.a0;
            aVar.R = bVar2.C;
            aVar.c = bVar2.g;
            aVar.f197a = bVar2.e;
            aVar.b = bVar2.f;
            ((ViewGroup.MarginLayoutParams) aVar).width = bVar2.c;
            ((ViewGroup.MarginLayoutParams) aVar).height = bVar2.d;
            String str = bVar2.g0;
            if (str != null) {
                aVar.U = str;
            }
            aVar.setMarginStart(this.d.I);
            aVar.setMarginEnd(this.d.H);
            aVar.a();
        }

        public final void b(int i, ConstraintLayout.a aVar) {
            this.f2321a = i;
            b bVar = this.d;
            bVar.h = aVar.d;
            bVar.i = aVar.e;
            bVar.j = aVar.f;
            bVar.k = aVar.g;
            bVar.l = aVar.h;
            bVar.m = aVar.i;
            bVar.n = aVar.j;
            bVar.o = aVar.k;
            bVar.p = aVar.l;
            bVar.q = aVar.p;
            bVar.r = aVar.q;
            bVar.s = aVar.r;
            bVar.t = aVar.s;
            bVar.u = aVar.z;
            bVar.v = aVar.A;
            bVar.w = aVar.B;
            bVar.x = aVar.m;
            bVar.y = aVar.n;
            bVar.z = aVar.o;
            bVar.A = aVar.P;
            bVar.B = aVar.Q;
            bVar.C = aVar.R;
            bVar.g = aVar.c;
            bVar.e = aVar.f197a;
            bVar.f = aVar.b;
            b bVar2 = this.d;
            bVar2.c = ((ViewGroup.MarginLayoutParams) aVar).width;
            bVar2.d = ((ViewGroup.MarginLayoutParams) aVar).height;
            bVar2.D = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
            bVar2.E = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
            bVar2.F = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
            bVar2.G = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
            bVar2.P = aVar.E;
            bVar2.Q = aVar.D;
            bVar2.S = aVar.G;
            bVar2.R = aVar.F;
            bVar2.h0 = aVar.S;
            bVar2.i0 = aVar.T;
            bVar2.T = aVar.H;
            bVar2.U = aVar.I;
            bVar2.V = aVar.L;
            bVar2.W = aVar.M;
            bVar2.X = aVar.J;
            bVar2.Y = aVar.K;
            bVar2.Z = aVar.N;
            bVar2.a0 = aVar.O;
            bVar2.g0 = aVar.U;
            bVar2.K = aVar.u;
            bVar2.M = aVar.w;
            bVar2.J = aVar.t;
            bVar2.L = aVar.v;
            b bVar3 = this.d;
            bVar3.O = aVar.x;
            bVar3.N = aVar.y;
            bVar3.H = aVar.getMarginEnd();
            this.d.I = aVar.getMarginStart();
        }

        public final void c(int i, n4.a aVar) {
            b(i, aVar);
            this.b.d = aVar.m0;
            e eVar = this.e;
            eVar.b = aVar.p0;
            eVar.c = aVar.q0;
            eVar.d = aVar.r0;
            eVar.e = aVar.s0;
            eVar.f = aVar.t0;
            eVar.g = aVar.u0;
            eVar.h = aVar.v0;
            eVar.i = aVar.w0;
            eVar.j = aVar.x0;
            eVar.k = aVar.y0;
            eVar.m = aVar.o0;
            eVar.l = aVar.n0;
        }

        public Object clone() throws CloneNotSupportedException {
            a aVar = new a();
            b bVar = aVar.d;
            b bVar2 = this.d;
            Objects.requireNonNull(bVar);
            bVar.f2322a = bVar2.f2322a;
            bVar.c = bVar2.c;
            bVar.b = bVar2.b;
            bVar.d = bVar2.d;
            bVar.e = bVar2.e;
            bVar.f = bVar2.f;
            bVar.g = bVar2.g;
            bVar.h = bVar2.h;
            bVar.i = bVar2.i;
            bVar.j = bVar2.j;
            bVar.k = bVar2.k;
            bVar.l = bVar2.l;
            bVar.m = bVar2.m;
            bVar.n = bVar2.n;
            bVar.o = bVar2.o;
            bVar.p = bVar2.p;
            bVar.q = bVar2.q;
            bVar.r = bVar2.r;
            bVar.s = bVar2.s;
            bVar.t = bVar2.t;
            bVar.u = bVar2.u;
            bVar.v = bVar2.v;
            bVar.w = bVar2.w;
            bVar.x = bVar2.x;
            bVar.y = bVar2.y;
            bVar.z = bVar2.z;
            bVar.A = bVar2.A;
            bVar.B = bVar2.B;
            bVar.C = bVar2.C;
            bVar.D = bVar2.D;
            bVar.E = bVar2.E;
            bVar.F = bVar2.F;
            bVar.G = bVar2.G;
            bVar.H = bVar2.H;
            bVar.I = bVar2.I;
            bVar.J = bVar2.J;
            bVar.K = bVar2.K;
            bVar.L = bVar2.L;
            bVar.M = bVar2.M;
            bVar.N = bVar2.N;
            bVar.O = bVar2.O;
            bVar.P = bVar2.P;
            bVar.Q = bVar2.Q;
            bVar.R = bVar2.R;
            bVar.S = bVar2.S;
            bVar.T = bVar2.T;
            bVar.U = bVar2.U;
            bVar.V = bVar2.V;
            bVar.W = bVar2.W;
            bVar.X = bVar2.X;
            bVar.Y = bVar2.Y;
            bVar.Z = bVar2.Z;
            bVar.a0 = bVar2.a0;
            bVar.b0 = bVar2.b0;
            bVar.c0 = bVar2.c0;
            bVar.d0 = bVar2.d0;
            bVar.g0 = bVar2.g0;
            int[] iArr = bVar2.e0;
            if (iArr != null) {
                bVar.e0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                bVar.e0 = null;
            }
            bVar.f0 = bVar2.f0;
            bVar.h0 = bVar2.h0;
            bVar.i0 = bVar2.i0;
            bVar.j0 = bVar2.j0;
            c cVar = aVar.c;
            c cVar2 = this.c;
            Objects.requireNonNull(cVar);
            cVar.f2323a = cVar2.f2323a;
            cVar.b = cVar2.b;
            cVar.c = cVar2.c;
            cVar.d = cVar2.d;
            cVar.e = cVar2.e;
            cVar.g = cVar2.g;
            cVar.f = cVar2.f;
            d dVar = aVar.b;
            d dVar2 = this.b;
            Objects.requireNonNull(dVar);
            dVar.f2324a = dVar2.f2324a;
            dVar.b = dVar2.b;
            dVar.d = dVar2.d;
            dVar.e = dVar2.e;
            dVar.c = dVar2.c;
            e eVar = aVar.e;
            e eVar2 = this.e;
            Objects.requireNonNull(eVar);
            eVar.f2325a = eVar2.f2325a;
            eVar.b = eVar2.b;
            eVar.c = eVar2.c;
            eVar.d = eVar2.d;
            eVar.e = eVar2.e;
            eVar.f = eVar2.f;
            eVar.g = eVar2.g;
            eVar.h = eVar2.h;
            eVar.i = eVar2.i;
            eVar.j = eVar2.j;
            eVar.k = eVar2.k;
            eVar.l = eVar2.l;
            eVar.m = eVar2.m;
            aVar.f2321a = this.f2321a;
            return aVar;
        }
    }

    /* renamed from: m4$b */
    /* compiled from: ConstraintSet */
    public static class b {
        public static SparseIntArray k0;
        public int A = -1;
        public int B = -1;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = -1;
        public int I = -1;
        public int J = -1;
        public int K = -1;
        public int L = -1;
        public int M = -1;
        public int N = -1;
        public int O = -1;
        public float P = -1.0f;
        public float Q = -1.0f;
        public int R = 0;
        public int S = 0;
        public int T = 0;
        public int U = 0;
        public int V = -1;
        public int W = -1;
        public int X = -1;
        public int Y = -1;
        public float Z = 1.0f;

        /* renamed from: a  reason: collision with root package name */
        public boolean f2322a = false;
        public float a0 = 1.0f;
        public boolean b = false;
        public int b0 = -1;
        public int c;
        public int c0 = 0;
        public int d;
        public int d0 = -1;
        public int e = -1;
        public int[] e0;
        public int f = -1;
        public String f0;
        public float g = -1.0f;
        public String g0;
        public int h = -1;
        public boolean h0 = false;
        public int i = -1;
        public boolean i0 = false;
        public int j = -1;
        public boolean j0 = true;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public float u = 0.5f;
        public float v = 0.5f;
        public String w = null;
        public int x = -1;
        public int y = 0;
        public float z = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            k0 = sparseIntArray;
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            k0.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            k0.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            k0.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            k0.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            k0.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            k0.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            k0.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            k0.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            k0.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            k0.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            k0.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            k0.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            k0.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            k0.append(R.styleable.Layout_android_orientation, 26);
            k0.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            k0.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            k0.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            k0.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            k0.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            k0.append(R.styleable.Layout_layout_goneMarginTop, 16);
            k0.append(R.styleable.Layout_layout_goneMarginRight, 14);
            k0.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            k0.append(R.styleable.Layout_layout_goneMarginStart, 15);
            k0.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            k0.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            k0.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            k0.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            k0.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            k0.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            k0.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            k0.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            k0.append(R.styleable.Layout_layout_constraintLeft_creator, 76);
            k0.append(R.styleable.Layout_layout_constraintTop_creator, 76);
            k0.append(R.styleable.Layout_layout_constraintRight_creator, 76);
            k0.append(R.styleable.Layout_layout_constraintBottom_creator, 76);
            k0.append(R.styleable.Layout_layout_constraintBaseline_creator, 76);
            k0.append(R.styleable.Layout_android_layout_marginLeft, 23);
            k0.append(R.styleable.Layout_android_layout_marginRight, 27);
            k0.append(R.styleable.Layout_android_layout_marginStart, 30);
            k0.append(R.styleable.Layout_android_layout_marginEnd, 8);
            k0.append(R.styleable.Layout_android_layout_marginTop, 33);
            k0.append(R.styleable.Layout_android_layout_marginBottom, 2);
            k0.append(R.styleable.Layout_android_layout_width, 22);
            k0.append(R.styleable.Layout_android_layout_height, 21);
            k0.append(R.styleable.Layout_layout_constraintCircle, 61);
            k0.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            k0.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            k0.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            k0.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            k0.append(R.styleable.Layout_chainUseRtl, 71);
            k0.append(R.styleable.Layout_barrierDirection, 72);
            k0.append(R.styleable.Layout_barrierMargin, 73);
            k0.append(R.styleable.Layout_constraint_referenced_ids, 74);
            k0.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Layout);
            this.b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = k0.get(index);
                if (i3 == 80) {
                    this.h0 = obtainStyledAttributes.getBoolean(index, this.h0);
                } else if (i3 != 81) {
                    switch (i3) {
                        case 1:
                            int i4 = this.p;
                            int[] iArr = m4.d;
                            int resourceId = obtainStyledAttributes.getResourceId(index, i4);
                            if (resourceId == -1) {
                                resourceId = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.p = resourceId;
                            continue;
                        case 2:
                            this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            continue;
                        case 3:
                            int i5 = this.o;
                            int[] iArr2 = m4.d;
                            int resourceId2 = obtainStyledAttributes.getResourceId(index, i5);
                            if (resourceId2 == -1) {
                                resourceId2 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.o = resourceId2;
                            continue;
                        case 4:
                            int i6 = this.n;
                            int[] iArr3 = m4.d;
                            int resourceId3 = obtainStyledAttributes.getResourceId(index, i6);
                            if (resourceId3 == -1) {
                                resourceId3 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.n = resourceId3;
                            continue;
                        case 5:
                            this.w = obtainStyledAttributes.getString(index);
                            continue;
                        case 6:
                            this.A = obtainStyledAttributes.getDimensionPixelOffset(index, this.A);
                            continue;
                        case 7:
                            this.B = obtainStyledAttributes.getDimensionPixelOffset(index, this.B);
                            continue;
                        case 8:
                            this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                            continue;
                        case 9:
                            int i7 = this.t;
                            int[] iArr4 = m4.d;
                            int resourceId4 = obtainStyledAttributes.getResourceId(index, i7);
                            if (resourceId4 == -1) {
                                resourceId4 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.t = resourceId4;
                            continue;
                        case 10:
                            int i8 = this.s;
                            int[] iArr5 = m4.d;
                            int resourceId5 = obtainStyledAttributes.getResourceId(index, i8);
                            if (resourceId5 == -1) {
                                resourceId5 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.s = resourceId5;
                            continue;
                        case 11:
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            continue;
                        case 12:
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            continue;
                        case 13:
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            continue;
                        case 14:
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            continue;
                        case 15:
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            continue;
                        case 16:
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            continue;
                        case 17:
                            this.e = obtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                            continue;
                        case 18:
                            this.f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                            continue;
                        case 19:
                            this.g = obtainStyledAttributes.getFloat(index, this.g);
                            continue;
                        case 20:
                            this.u = obtainStyledAttributes.getFloat(index, this.u);
                            continue;
                        case 21:
                            this.d = obtainStyledAttributes.getLayoutDimension(index, this.d);
                            continue;
                        case 22:
                            this.c = obtainStyledAttributes.getLayoutDimension(index, this.c);
                            continue;
                        case 23:
                            this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                            continue;
                        case 24:
                            int i9 = this.h;
                            int[] iArr6 = m4.d;
                            int resourceId6 = obtainStyledAttributes.getResourceId(index, i9);
                            if (resourceId6 == -1) {
                                resourceId6 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.h = resourceId6;
                            continue;
                        case 25:
                            int i10 = this.i;
                            int[] iArr7 = m4.d;
                            int resourceId7 = obtainStyledAttributes.getResourceId(index, i10);
                            if (resourceId7 == -1) {
                                resourceId7 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.i = resourceId7;
                            continue;
                        case 26:
                            this.C = obtainStyledAttributes.getInt(index, this.C);
                            continue;
                        case 27:
                            this.E = obtainStyledAttributes.getDimensionPixelSize(index, this.E);
                            continue;
                        case 28:
                            int i11 = this.j;
                            int[] iArr8 = m4.d;
                            int resourceId8 = obtainStyledAttributes.getResourceId(index, i11);
                            if (resourceId8 == -1) {
                                resourceId8 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.j = resourceId8;
                            continue;
                        case 29:
                            int i12 = this.k;
                            int[] iArr9 = m4.d;
                            int resourceId9 = obtainStyledAttributes.getResourceId(index, i12);
                            if (resourceId9 == -1) {
                                resourceId9 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.k = resourceId9;
                            continue;
                        case 30:
                            this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                            continue;
                        case 31:
                            int i13 = this.q;
                            int[] iArr10 = m4.d;
                            int resourceId10 = obtainStyledAttributes.getResourceId(index, i13);
                            if (resourceId10 == -1) {
                                resourceId10 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.q = resourceId10;
                            continue;
                        case 32:
                            int i14 = this.r;
                            int[] iArr11 = m4.d;
                            int resourceId11 = obtainStyledAttributes.getResourceId(index, i14);
                            if (resourceId11 == -1) {
                                resourceId11 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.r = resourceId11;
                            continue;
                        case 33:
                            this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                            continue;
                        case 34:
                            int i15 = this.m;
                            int[] iArr12 = m4.d;
                            int resourceId12 = obtainStyledAttributes.getResourceId(index, i15);
                            if (resourceId12 == -1) {
                                resourceId12 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.m = resourceId12;
                            continue;
                        case 35:
                            int i16 = this.l;
                            int[] iArr13 = m4.d;
                            int resourceId13 = obtainStyledAttributes.getResourceId(index, i16);
                            if (resourceId13 == -1) {
                                resourceId13 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.l = resourceId13;
                            continue;
                        case 36:
                            this.v = obtainStyledAttributes.getFloat(index, this.v);
                            continue;
                        case 37:
                            this.Q = obtainStyledAttributes.getFloat(index, this.Q);
                            continue;
                        case 38:
                            this.P = obtainStyledAttributes.getFloat(index, this.P);
                            continue;
                        case 39:
                            this.R = obtainStyledAttributes.getInt(index, this.R);
                            continue;
                        case 40:
                            this.S = obtainStyledAttributes.getInt(index, this.S);
                            continue;
                        default:
                            switch (i3) {
                                case 54:
                                    this.T = obtainStyledAttributes.getInt(index, this.T);
                                    continue;
                                case 55:
                                    this.U = obtainStyledAttributes.getInt(index, this.U);
                                    continue;
                                case 56:
                                    this.V = obtainStyledAttributes.getDimensionPixelSize(index, this.V);
                                    continue;
                                case 57:
                                    this.W = obtainStyledAttributes.getDimensionPixelSize(index, this.W);
                                    continue;
                                case 58:
                                    this.X = obtainStyledAttributes.getDimensionPixelSize(index, this.X);
                                    continue;
                                case 59:
                                    this.Y = obtainStyledAttributes.getDimensionPixelSize(index, this.Y);
                                    continue;
                                default:
                                    switch (i3) {
                                        case 61:
                                            int i17 = this.x;
                                            int[] iArr14 = m4.d;
                                            int resourceId14 = obtainStyledAttributes.getResourceId(index, i17);
                                            if (resourceId14 == -1) {
                                                resourceId14 = obtainStyledAttributes.getInt(index, -1);
                                            }
                                            this.x = resourceId14;
                                            continue;
                                        case 62:
                                            this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                                            continue;
                                        case 63:
                                            this.z = obtainStyledAttributes.getFloat(index, this.z);
                                            continue;
                                        default:
                                            switch (i3) {
                                                case 69:
                                                    this.Z = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 70:
                                                    this.a0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 71:
                                                    continue;
                                                    continue;
                                                    continue;
                                                case 72:
                                                    this.b0 = obtainStyledAttributes.getInt(index, this.b0);
                                                    continue;
                                                case 73:
                                                    this.c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.c0);
                                                    continue;
                                                case 74:
                                                    this.f0 = obtainStyledAttributes.getString(index);
                                                    continue;
                                                case 75:
                                                    this.j0 = obtainStyledAttributes.getBoolean(index, this.j0);
                                                    continue;
                                                case 76:
                                                    Integer.toHexString(index);
                                                    k0.get(index);
                                                    continue;
                                                case 77:
                                                    this.g0 = obtainStyledAttributes.getString(index);
                                                    continue;
                                                default:
                                                    Integer.toHexString(index);
                                                    k0.get(index);
                                                    continue;
                                            }
                                    }
                            }
                    }
                } else {
                    this.i0 = obtainStyledAttributes.getBoolean(index, this.i0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: m4$c */
    /* compiled from: ConstraintSet */
    public static class c {
        public static SparseIntArray h;

        /* renamed from: a  reason: collision with root package name */
        public boolean f2323a = false;
        public int b = -1;
        public String c = null;
        public int d = -1;
        public int e = 0;
        public float f = Float.NaN;
        public float g = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            h = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            h.append(R.styleable.Motion_pathMotionArc, 2);
            h.append(R.styleable.Motion_transitionEasing, 3);
            h.append(R.styleable.Motion_drawPath, 4);
            h.append(R.styleable.Motion_animate_relativeTo, 5);
            h.append(R.styleable.Motion_motionStagger, 6);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Motion);
            this.f2323a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (h.get(index)) {
                    case 1:
                        this.g = obtainStyledAttributes.getFloat(index, this.g);
                        break;
                    case 2:
                        this.d = obtainStyledAttributes.getInt(index, this.d);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.c = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.c = b3.f372a[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.e = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        int i2 = this.b;
                        int[] iArr = m4.d;
                        int resourceId = obtainStyledAttributes.getResourceId(index, i2);
                        if (resourceId == -1) {
                            resourceId = obtainStyledAttributes.getInt(index, -1);
                        }
                        this.b = resourceId;
                        break;
                    case 6:
                        this.f = obtainStyledAttributes.getFloat(index, this.f);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: m4$d */
    /* compiled from: ConstraintSet */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2324a = false;
        public int b = 0;
        public int c = 0;
        public float d = 1.0f;
        public float e = Float.NaN;

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PropertySet);
            this.f2324a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.PropertySet_android_alpha) {
                    this.d = obtainStyledAttributes.getFloat(index, this.d);
                } else if (index == R.styleable.PropertySet_android_visibility) {
                    int i2 = obtainStyledAttributes.getInt(index, this.b);
                    this.b = i2;
                    int[] iArr = m4.d;
                    this.b = m4.d[i2];
                } else if (index == R.styleable.PropertySet_visibilityMode) {
                    this.c = obtainStyledAttributes.getInt(index, this.c);
                } else if (index == R.styleable.PropertySet_motionProgress) {
                    this.e = obtainStyledAttributes.getFloat(index, this.e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: m4$e */
    /* compiled from: ConstraintSet */
    public static class e {
        public static SparseIntArray n;

        /* renamed from: a  reason: collision with root package name */
        public boolean f2325a = false;
        public float b = 0.0f;
        public float c = 0.0f;
        public float d = 0.0f;
        public float e = 1.0f;
        public float f = 1.0f;
        public float g = Float.NaN;
        public float h = Float.NaN;
        public float i = 0.0f;
        public float j = 0.0f;
        public float k = 0.0f;
        public boolean l = false;
        public float m = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            n = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            n.append(R.styleable.Transform_android_rotationX, 2);
            n.append(R.styleable.Transform_android_rotationY, 3);
            n.append(R.styleable.Transform_android_scaleX, 4);
            n.append(R.styleable.Transform_android_scaleY, 5);
            n.append(R.styleable.Transform_android_transformPivotX, 6);
            n.append(R.styleable.Transform_android_transformPivotY, 7);
            n.append(R.styleable.Transform_android_translationX, 8);
            n.append(R.styleable.Transform_android_translationY, 9);
            n.append(R.styleable.Transform_android_translationZ, 10);
            n.append(R.styleable.Transform_android_elevation, 11);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transform);
            this.f2325a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (n.get(index)) {
                    case 1:
                        this.b = obtainStyledAttributes.getFloat(index, this.b);
                        break;
                    case 2:
                        this.c = obtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 3:
                        this.d = obtainStyledAttributes.getFloat(index, this.d);
                        break;
                    case 4:
                        this.e = obtainStyledAttributes.getFloat(index, this.e);
                        break;
                    case 5:
                        this.f = obtainStyledAttributes.getFloat(index, this.f);
                        break;
                    case 6:
                        this.g = obtainStyledAttributes.getDimension(index, this.g);
                        break;
                    case 7:
                        this.h = obtainStyledAttributes.getDimension(index, this.h);
                        break;
                    case 8:
                        this.i = obtainStyledAttributes.getDimension(index, this.i);
                        break;
                    case 9:
                        this.j = obtainStyledAttributes.getDimension(index, this.j);
                        break;
                    case 10:
                        this.k = obtainStyledAttributes.getDimension(index, this.k);
                        break;
                    case 11:
                        this.l = true;
                        this.m = obtainStyledAttributes.getDimension(index, this.m);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        e = sparseIntArray;
        sparseIntArray.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        e.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        e.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        e.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        e.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        e.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        e.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        e.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        e.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        e.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        e.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        e.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        e.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        e.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        e.append(R.styleable.Constraint_android_orientation, 27);
        e.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        e.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        e.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        e.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        e.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        e.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        e.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        e.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        e.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        e.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        e.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        e.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        e.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        e.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        e.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        e.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        e.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        e.append(R.styleable.Constraint_layout_constraintLeft_creator, 82);
        e.append(R.styleable.Constraint_layout_constraintTop_creator, 82);
        e.append(R.styleable.Constraint_layout_constraintRight_creator, 82);
        e.append(R.styleable.Constraint_layout_constraintBottom_creator, 82);
        e.append(R.styleable.Constraint_layout_constraintBaseline_creator, 82);
        e.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        e.append(R.styleable.Constraint_android_layout_marginRight, 28);
        e.append(R.styleable.Constraint_android_layout_marginStart, 31);
        e.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        e.append(R.styleable.Constraint_android_layout_marginTop, 34);
        e.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        e.append(R.styleable.Constraint_android_layout_width, 23);
        e.append(R.styleable.Constraint_android_layout_height, 21);
        e.append(R.styleable.Constraint_android_visibility, 22);
        e.append(R.styleable.Constraint_android_alpha, 43);
        e.append(R.styleable.Constraint_android_elevation, 44);
        e.append(R.styleable.Constraint_android_rotationX, 45);
        e.append(R.styleable.Constraint_android_rotationY, 46);
        e.append(R.styleable.Constraint_android_rotation, 60);
        e.append(R.styleable.Constraint_android_scaleX, 47);
        e.append(R.styleable.Constraint_android_scaleY, 48);
        e.append(R.styleable.Constraint_android_transformPivotX, 49);
        e.append(R.styleable.Constraint_android_transformPivotY, 50);
        e.append(R.styleable.Constraint_android_translationX, 51);
        e.append(R.styleable.Constraint_android_translationY, 52);
        e.append(R.styleable.Constraint_android_translationZ, 53);
        e.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        e.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        e.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        e.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        e.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        e.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        e.append(R.styleable.Constraint_layout_constraintCircle, 61);
        e.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        e.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        e.append(R.styleable.Constraint_animate_relativeTo, 64);
        e.append(R.styleable.Constraint_transitionEasing, 65);
        e.append(R.styleable.Constraint_drawPath, 66);
        e.append(R.styleable.Constraint_transitionPathRotate, 67);
        e.append(R.styleable.Constraint_motionStagger, 79);
        e.append(R.styleable.Constraint_android_id, 38);
        e.append(R.styleable.Constraint_motionProgress, 68);
        e.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        e.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        e.append(R.styleable.Constraint_chainUseRtl, 71);
        e.append(R.styleable.Constraint_barrierDirection, 72);
        e.append(R.styleable.Constraint_barrierMargin, 73);
        e.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        e.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        e.append(R.styleable.Constraint_pathMotionArc, 76);
        e.append(R.styleable.Constraint_layout_constraintTag, 77);
        e.append(R.styleable.Constraint_visibilityMode, 78);
        e.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        e.append(R.styleable.Constraint_layout_constrainedHeight, 81);
    }

    public void a(ConstraintLayout constraintLayout, boolean z) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.c.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.c.containsKey(Integer.valueOf(id))) {
                try {
                    childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                }
            } else if (this.b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1 && this.c.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                a aVar = this.c.get(Integer.valueOf(id));
                if (childAt instanceof Barrier) {
                    aVar.d.d0 = 1;
                }
                int i2 = aVar.d.d0;
                if (i2 != -1 && i2 == 1) {
                    Barrier barrier = (Barrier) childAt;
                    barrier.setId(id);
                    barrier.setType(aVar.d.b0);
                    barrier.setMargin(aVar.d.c0);
                    barrier.setAllowsGoneWidget(aVar.d.j0);
                    b bVar = aVar.d;
                    int[] iArr = bVar.e0;
                    if (iArr != null) {
                        barrier.setReferencedIds(iArr);
                    } else {
                        String str = bVar.f0;
                        if (str != null) {
                            bVar.e0 = c(barrier, str);
                            barrier.setReferencedIds(aVar.d.e0);
                        }
                    }
                }
                ConstraintLayout.a aVar2 = (ConstraintLayout.a) childAt.getLayoutParams();
                aVar2.a();
                aVar.a(aVar2);
                if (z) {
                    HashMap<String, j4> hashMap = aVar.f;
                    Class<?> cls = childAt.getClass();
                    for (String str2 : hashMap.keySet()) {
                        j4 j4Var = hashMap.get(str2);
                        String S = hj1.S("set", str2);
                        try {
                            switch (j4Var.b.ordinal()) {
                                case 0:
                                    cls.getMethod(S, Integer.TYPE).invoke(childAt, Integer.valueOf(j4Var.c));
                                    break;
                                case 1:
                                    cls.getMethod(S, Float.TYPE).invoke(childAt, Float.valueOf(j4Var.d));
                                    break;
                                case 2:
                                    cls.getMethod(S, Integer.TYPE).invoke(childAt, Integer.valueOf(j4Var.g));
                                    break;
                                case 3:
                                    Method method = cls.getMethod(S, Drawable.class);
                                    ColorDrawable colorDrawable = new ColorDrawable();
                                    colorDrawable.setColor(j4Var.g);
                                    method.invoke(childAt, colorDrawable);
                                    break;
                                case 4:
                                    cls.getMethod(S, CharSequence.class).invoke(childAt, j4Var.e);
                                    break;
                                case 5:
                                    cls.getMethod(S, Boolean.TYPE).invoke(childAt, Boolean.valueOf(j4Var.f));
                                    break;
                                case 6:
                                    cls.getMethod(S, Float.TYPE).invoke(childAt, Float.valueOf(j4Var.d));
                                    break;
                            }
                        } catch (NoSuchMethodException e2) {
                            e2.getMessage();
                            cls.getName();
                        } catch (IllegalAccessException e3) {
                            cls.getName();
                            e3.printStackTrace();
                        } catch (InvocationTargetException e4) {
                            cls.getName();
                            e4.printStackTrace();
                        }
                    }
                }
                childAt.setLayoutParams(aVar2);
                d dVar = aVar.b;
                if (dVar.c == 0) {
                    childAt.setVisibility(dVar.b);
                }
                childAt.setAlpha(aVar.b.d);
                childAt.setRotation(aVar.e.b);
                childAt.setRotationX(aVar.e.c);
                childAt.setRotationY(aVar.e.d);
                childAt.setScaleX(aVar.e.e);
                childAt.setScaleY(aVar.e.f);
                if (!Float.isNaN(aVar.e.g)) {
                    childAt.setPivotX(aVar.e.g);
                }
                if (!Float.isNaN(aVar.e.h)) {
                    childAt.setPivotY(aVar.e.h);
                }
                childAt.setTranslationX(aVar.e.i);
                childAt.setTranslationY(aVar.e.j);
                childAt.setTranslationZ(aVar.e.k);
                e eVar = aVar.e;
                if (eVar.l) {
                    childAt.setElevation(eVar.m);
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar3 = this.c.get(num);
            int i3 = aVar3.d.d0;
            if (i3 != -1 && i3 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                b bVar2 = aVar3.d;
                int[] iArr2 = bVar2.e0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str3 = bVar2.f0;
                    if (str3 != null) {
                        bVar2.e0 = c(barrier2, str3);
                        barrier2.setReferencedIds(aVar3.d.e0);
                    }
                }
                barrier2.setType(aVar3.d.b0);
                barrier2.setMargin(aVar3.d.c0);
                ConstraintLayout.a b2 = constraintLayout.generateDefaultLayoutParams();
                barrier2.j();
                aVar3.a(b2);
                constraintLayout.addView(barrier2, b2);
            }
            if (aVar3.d.f2322a) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.a b3 = constraintLayout.generateDefaultLayoutParams();
                aVar3.a(b3);
                constraintLayout.addView(guideline, b3);
            }
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        NoSuchMethodException e2;
        IllegalAccessException e3;
        InvocationTargetException e4;
        m4 m4Var = this;
        int childCount = constraintLayout.getChildCount();
        m4Var.c.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.a aVar = (ConstraintLayout.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!m4Var.b || id != -1) {
                if (!m4Var.c.containsKey(Integer.valueOf(id))) {
                    m4Var.c.put(Integer.valueOf(id), new a());
                }
                a aVar2 = m4Var.c.get(Integer.valueOf(id));
                HashMap<String, j4> hashMap = m4Var.f2320a;
                HashMap<String, j4> hashMap2 = new HashMap<>();
                Class<?> cls = childAt.getClass();
                for (String str : hashMap.keySet()) {
                    j4 j4Var = hashMap.get(str);
                    try {
                        if (str.equals("BackgroundColor")) {
                            hashMap2.put(str, new j4(j4Var, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                        } else {
                            try {
                                hashMap2.put(str, new j4(j4Var, cls.getMethod("getMap" + str, new Class[0]).invoke(childAt, new Object[0])));
                            } catch (NoSuchMethodException e5) {
                                e2 = e5;
                            } catch (IllegalAccessException e6) {
                                e3 = e6;
                                e3.printStackTrace();
                            } catch (InvocationTargetException e7) {
                                e4 = e7;
                                e4.printStackTrace();
                            }
                        }
                    } catch (NoSuchMethodException e8) {
                        e2 = e8;
                        e2.printStackTrace();
                    } catch (IllegalAccessException e9) {
                        e3 = e9;
                        e3.printStackTrace();
                    } catch (InvocationTargetException e10) {
                        e4 = e10;
                        e4.printStackTrace();
                    }
                }
                aVar2.f = hashMap2;
                aVar2.b(id, aVar);
                aVar2.b.b = childAt.getVisibility();
                aVar2.b.d = childAt.getAlpha();
                aVar2.e.b = childAt.getRotation();
                aVar2.e.c = childAt.getRotationX();
                aVar2.e.d = childAt.getRotationY();
                aVar2.e.e = childAt.getScaleX();
                aVar2.e.f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (!(((double) pivotX) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && ((double) pivotY) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
                    e eVar = aVar2.e;
                    eVar.g = pivotX;
                    eVar.h = pivotY;
                }
                aVar2.e.i = childAt.getTranslationX();
                aVar2.e.j = childAt.getTranslationY();
                aVar2.e.k = childAt.getTranslationZ();
                e eVar2 = aVar2.e;
                if (eVar2.l) {
                    eVar2.m = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    b bVar = aVar2.d;
                    bVar.j0 = barrier.n.h0;
                    bVar.e0 = barrier.getReferencedIds();
                    aVar2.d.b0 = barrier.getType();
                    aVar2.d.c0 = barrier.getMargin();
                }
                i++;
                m4Var = this;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public final int[] c(View view, String str) {
        int i;
        Object c2;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = R.id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (c2 = ((ConstraintLayout) view.getParent()).c(0, trim)) != null && (c2 instanceof Integer)) {
                i = ((Integer) c2).intValue();
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    public final a d(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Constraint);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (!(index == R.styleable.Constraint_android_id || R.styleable.Constraint_android_layout_marginStart == index || R.styleable.Constraint_android_layout_marginEnd == index)) {
                aVar.c.f2323a = true;
                aVar.d.b = true;
                aVar.b.f2324a = true;
                aVar.e.f2325a = true;
            }
            switch (e.get(index)) {
                case 1:
                    b bVar = aVar.d;
                    int resourceId = obtainStyledAttributes.getResourceId(index, bVar.p);
                    if (resourceId == -1) {
                        resourceId = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar.p = resourceId;
                    break;
                case 2:
                    b bVar2 = aVar.d;
                    bVar2.G = obtainStyledAttributes.getDimensionPixelSize(index, bVar2.G);
                    break;
                case 3:
                    b bVar3 = aVar.d;
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, bVar3.o);
                    if (resourceId2 == -1) {
                        resourceId2 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar3.o = resourceId2;
                    break;
                case 4:
                    b bVar4 = aVar.d;
                    int resourceId3 = obtainStyledAttributes.getResourceId(index, bVar4.n);
                    if (resourceId3 == -1) {
                        resourceId3 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar4.n = resourceId3;
                    break;
                case 5:
                    aVar.d.w = obtainStyledAttributes.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.d;
                    bVar5.A = obtainStyledAttributes.getDimensionPixelOffset(index, bVar5.A);
                    break;
                case 7:
                    b bVar6 = aVar.d;
                    bVar6.B = obtainStyledAttributes.getDimensionPixelOffset(index, bVar6.B);
                    break;
                case 8:
                    b bVar7 = aVar.d;
                    bVar7.H = obtainStyledAttributes.getDimensionPixelSize(index, bVar7.H);
                    break;
                case 9:
                    b bVar8 = aVar.d;
                    int resourceId4 = obtainStyledAttributes.getResourceId(index, bVar8.t);
                    if (resourceId4 == -1) {
                        resourceId4 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar8.t = resourceId4;
                    break;
                case 10:
                    b bVar9 = aVar.d;
                    int resourceId5 = obtainStyledAttributes.getResourceId(index, bVar9.s);
                    if (resourceId5 == -1) {
                        resourceId5 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar9.s = resourceId5;
                    break;
                case 11:
                    b bVar10 = aVar.d;
                    bVar10.M = obtainStyledAttributes.getDimensionPixelSize(index, bVar10.M);
                    break;
                case 12:
                    b bVar11 = aVar.d;
                    bVar11.N = obtainStyledAttributes.getDimensionPixelSize(index, bVar11.N);
                    break;
                case 13:
                    b bVar12 = aVar.d;
                    bVar12.J = obtainStyledAttributes.getDimensionPixelSize(index, bVar12.J);
                    break;
                case 14:
                    b bVar13 = aVar.d;
                    bVar13.L = obtainStyledAttributes.getDimensionPixelSize(index, bVar13.L);
                    break;
                case 15:
                    b bVar14 = aVar.d;
                    bVar14.O = obtainStyledAttributes.getDimensionPixelSize(index, bVar14.O);
                    break;
                case 16:
                    b bVar15 = aVar.d;
                    bVar15.K = obtainStyledAttributes.getDimensionPixelSize(index, bVar15.K);
                    break;
                case 17:
                    b bVar16 = aVar.d;
                    bVar16.e = obtainStyledAttributes.getDimensionPixelOffset(index, bVar16.e);
                    break;
                case 18:
                    b bVar17 = aVar.d;
                    bVar17.f = obtainStyledAttributes.getDimensionPixelOffset(index, bVar17.f);
                    break;
                case 19:
                    b bVar18 = aVar.d;
                    bVar18.g = obtainStyledAttributes.getFloat(index, bVar18.g);
                    break;
                case 20:
                    b bVar19 = aVar.d;
                    bVar19.u = obtainStyledAttributes.getFloat(index, bVar19.u);
                    break;
                case 21:
                    b bVar20 = aVar.d;
                    bVar20.d = obtainStyledAttributes.getLayoutDimension(index, bVar20.d);
                    break;
                case 22:
                    d dVar = aVar.b;
                    dVar.b = obtainStyledAttributes.getInt(index, dVar.b);
                    d dVar2 = aVar.b;
                    dVar2.b = d[dVar2.b];
                    break;
                case 23:
                    b bVar21 = aVar.d;
                    bVar21.c = obtainStyledAttributes.getLayoutDimension(index, bVar21.c);
                    break;
                case 24:
                    b bVar22 = aVar.d;
                    bVar22.D = obtainStyledAttributes.getDimensionPixelSize(index, bVar22.D);
                    break;
                case 25:
                    b bVar23 = aVar.d;
                    int resourceId6 = obtainStyledAttributes.getResourceId(index, bVar23.h);
                    if (resourceId6 == -1) {
                        resourceId6 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar23.h = resourceId6;
                    break;
                case 26:
                    b bVar24 = aVar.d;
                    int resourceId7 = obtainStyledAttributes.getResourceId(index, bVar24.i);
                    if (resourceId7 == -1) {
                        resourceId7 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar24.i = resourceId7;
                    break;
                case 27:
                    b bVar25 = aVar.d;
                    bVar25.C = obtainStyledAttributes.getInt(index, bVar25.C);
                    break;
                case 28:
                    b bVar26 = aVar.d;
                    bVar26.E = obtainStyledAttributes.getDimensionPixelSize(index, bVar26.E);
                    break;
                case 29:
                    b bVar27 = aVar.d;
                    int resourceId8 = obtainStyledAttributes.getResourceId(index, bVar27.j);
                    if (resourceId8 == -1) {
                        resourceId8 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar27.j = resourceId8;
                    break;
                case 30:
                    b bVar28 = aVar.d;
                    int resourceId9 = obtainStyledAttributes.getResourceId(index, bVar28.k);
                    if (resourceId9 == -1) {
                        resourceId9 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar28.k = resourceId9;
                    break;
                case 31:
                    b bVar29 = aVar.d;
                    bVar29.I = obtainStyledAttributes.getDimensionPixelSize(index, bVar29.I);
                    break;
                case 32:
                    b bVar30 = aVar.d;
                    int resourceId10 = obtainStyledAttributes.getResourceId(index, bVar30.q);
                    if (resourceId10 == -1) {
                        resourceId10 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar30.q = resourceId10;
                    break;
                case 33:
                    b bVar31 = aVar.d;
                    int resourceId11 = obtainStyledAttributes.getResourceId(index, bVar31.r);
                    if (resourceId11 == -1) {
                        resourceId11 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar31.r = resourceId11;
                    break;
                case 34:
                    b bVar32 = aVar.d;
                    bVar32.F = obtainStyledAttributes.getDimensionPixelSize(index, bVar32.F);
                    break;
                case 35:
                    b bVar33 = aVar.d;
                    int resourceId12 = obtainStyledAttributes.getResourceId(index, bVar33.m);
                    if (resourceId12 == -1) {
                        resourceId12 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar33.m = resourceId12;
                    break;
                case 36:
                    b bVar34 = aVar.d;
                    int resourceId13 = obtainStyledAttributes.getResourceId(index, bVar34.l);
                    if (resourceId13 == -1) {
                        resourceId13 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar34.l = resourceId13;
                    break;
                case 37:
                    b bVar35 = aVar.d;
                    bVar35.v = obtainStyledAttributes.getFloat(index, bVar35.v);
                    break;
                case 38:
                    aVar.f2321a = obtainStyledAttributes.getResourceId(index, aVar.f2321a);
                    break;
                case 39:
                    b bVar36 = aVar.d;
                    bVar36.Q = obtainStyledAttributes.getFloat(index, bVar36.Q);
                    break;
                case 40:
                    b bVar37 = aVar.d;
                    bVar37.P = obtainStyledAttributes.getFloat(index, bVar37.P);
                    break;
                case 41:
                    b bVar38 = aVar.d;
                    bVar38.R = obtainStyledAttributes.getInt(index, bVar38.R);
                    break;
                case 42:
                    b bVar39 = aVar.d;
                    bVar39.S = obtainStyledAttributes.getInt(index, bVar39.S);
                    break;
                case 43:
                    d dVar3 = aVar.b;
                    dVar3.d = obtainStyledAttributes.getFloat(index, dVar3.d);
                    break;
                case 44:
                    e eVar = aVar.e;
                    eVar.l = true;
                    eVar.m = obtainStyledAttributes.getDimension(index, eVar.m);
                    break;
                case 45:
                    e eVar2 = aVar.e;
                    eVar2.c = obtainStyledAttributes.getFloat(index, eVar2.c);
                    break;
                case 46:
                    e eVar3 = aVar.e;
                    eVar3.d = obtainStyledAttributes.getFloat(index, eVar3.d);
                    break;
                case 47:
                    e eVar4 = aVar.e;
                    eVar4.e = obtainStyledAttributes.getFloat(index, eVar4.e);
                    break;
                case 48:
                    e eVar5 = aVar.e;
                    eVar5.f = obtainStyledAttributes.getFloat(index, eVar5.f);
                    break;
                case 49:
                    e eVar6 = aVar.e;
                    eVar6.g = obtainStyledAttributes.getDimension(index, eVar6.g);
                    break;
                case 50:
                    e eVar7 = aVar.e;
                    eVar7.h = obtainStyledAttributes.getDimension(index, eVar7.h);
                    break;
                case 51:
                    e eVar8 = aVar.e;
                    eVar8.i = obtainStyledAttributes.getDimension(index, eVar8.i);
                    break;
                case 52:
                    e eVar9 = aVar.e;
                    eVar9.j = obtainStyledAttributes.getDimension(index, eVar9.j);
                    break;
                case 53:
                    e eVar10 = aVar.e;
                    eVar10.k = obtainStyledAttributes.getDimension(index, eVar10.k);
                    break;
                case 54:
                    b bVar40 = aVar.d;
                    bVar40.T = obtainStyledAttributes.getInt(index, bVar40.T);
                    break;
                case 55:
                    b bVar41 = aVar.d;
                    bVar41.U = obtainStyledAttributes.getInt(index, bVar41.U);
                    break;
                case 56:
                    b bVar42 = aVar.d;
                    bVar42.V = obtainStyledAttributes.getDimensionPixelSize(index, bVar42.V);
                    break;
                case 57:
                    b bVar43 = aVar.d;
                    bVar43.W = obtainStyledAttributes.getDimensionPixelSize(index, bVar43.W);
                    break;
                case 58:
                    b bVar44 = aVar.d;
                    bVar44.X = obtainStyledAttributes.getDimensionPixelSize(index, bVar44.X);
                    break;
                case 59:
                    b bVar45 = aVar.d;
                    bVar45.Y = obtainStyledAttributes.getDimensionPixelSize(index, bVar45.Y);
                    break;
                case 60:
                    e eVar11 = aVar.e;
                    eVar11.b = obtainStyledAttributes.getFloat(index, eVar11.b);
                    break;
                case 61:
                    b bVar46 = aVar.d;
                    int resourceId14 = obtainStyledAttributes.getResourceId(index, bVar46.x);
                    if (resourceId14 == -1) {
                        resourceId14 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar46.x = resourceId14;
                    break;
                case 62:
                    b bVar47 = aVar.d;
                    bVar47.y = obtainStyledAttributes.getDimensionPixelSize(index, bVar47.y);
                    break;
                case 63:
                    b bVar48 = aVar.d;
                    bVar48.z = obtainStyledAttributes.getFloat(index, bVar48.z);
                    break;
                case 64:
                    c cVar = aVar.c;
                    int resourceId15 = obtainStyledAttributes.getResourceId(index, cVar.b);
                    if (resourceId15 == -1) {
                        resourceId15 = obtainStyledAttributes.getInt(index, -1);
                    }
                    cVar.b = resourceId15;
                    break;
                case 65:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        aVar.c.c = obtainStyledAttributes.getString(index);
                        break;
                    } else {
                        aVar.c.c = b3.f372a[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    aVar.c.e = obtainStyledAttributes.getInt(index, 0);
                    break;
                case 67:
                    c cVar2 = aVar.c;
                    cVar2.g = obtainStyledAttributes.getFloat(index, cVar2.g);
                    break;
                case 68:
                    d dVar4 = aVar.b;
                    dVar4.e = obtainStyledAttributes.getFloat(index, dVar4.e);
                    break;
                case 69:
                    aVar.d.Z = obtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.d.a0 = obtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 71:
                    break;
                case 72:
                    b bVar49 = aVar.d;
                    bVar49.b0 = obtainStyledAttributes.getInt(index, bVar49.b0);
                    break;
                case 73:
                    b bVar50 = aVar.d;
                    bVar50.c0 = obtainStyledAttributes.getDimensionPixelSize(index, bVar50.c0);
                    break;
                case 74:
                    aVar.d.f0 = obtainStyledAttributes.getString(index);
                    break;
                case 75:
                    b bVar51 = aVar.d;
                    bVar51.j0 = obtainStyledAttributes.getBoolean(index, bVar51.j0);
                    break;
                case 76:
                    c cVar3 = aVar.c;
                    cVar3.d = obtainStyledAttributes.getInt(index, cVar3.d);
                    break;
                case 77:
                    aVar.d.g0 = obtainStyledAttributes.getString(index);
                    break;
                case 78:
                    d dVar5 = aVar.b;
                    dVar5.c = obtainStyledAttributes.getInt(index, dVar5.c);
                    break;
                case 79:
                    c cVar4 = aVar.c;
                    cVar4.f = obtainStyledAttributes.getFloat(index, cVar4.f);
                    break;
                case 80:
                    b bVar52 = aVar.d;
                    bVar52.h0 = obtainStyledAttributes.getBoolean(index, bVar52.h0);
                    break;
                case 81:
                    b bVar53 = aVar.d;
                    bVar53.i0 = obtainStyledAttributes.getBoolean(index, bVar53.i0);
                    break;
                case 82:
                    Integer.toHexString(index);
                    e.get(index);
                    break;
                default:
                    Integer.toHexString(index);
                    e.get(index);
                    break;
            }
        }
        obtainStyledAttributes.recycle();
        return aVar;
    }

    public void e(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a d2 = d(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        d2.d.f2322a = true;
                    }
                    this.c.put(Integer.valueOf(d2.f2321a), d2);
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }
}
