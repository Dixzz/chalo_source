package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: l4  reason: default package */
/* compiled from: ConstraintLayoutStates */
public class l4 {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<a> f2157a = new SparseArray<>();
    public SparseArray<m4> b = new SparseArray<>();

    /* renamed from: l4$a */
    /* compiled from: ConstraintLayoutStates */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2158a;
        public ArrayList<b> b = new ArrayList<>();
        public int c = -1;
        public m4 d;

        public a(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.State_android_id) {
                    this.f2158a = obtainStyledAttributes.getResourceId(index, this.f2158a);
                } else if (index == R.styleable.State_constraints) {
                    this.c = obtainStyledAttributes.getResourceId(index, this.c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.c);
                    context.getResources().getResourceName(this.c);
                    if ("layout".equals(resourceTypeName)) {
                        m4 m4Var = new m4();
                        this.d = m4Var;
                        m4Var.b((ConstraintLayout) LayoutInflater.from(context).inflate(this.c, (ViewGroup) null));
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: l4$b */
    /* compiled from: ConstraintLayoutStates */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public float f2159a = Float.NaN;
        public float b = Float.NaN;
        public float c = Float.NaN;
        public float d = Float.NaN;
        public int e = -1;
        public m4 f;

        public b(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Variant_constraints) {
                    this.e = obtainStyledAttributes.getResourceId(index, this.e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if ("layout".equals(resourceTypeName)) {
                        m4 m4Var = new m4();
                        this.f = m4Var;
                        m4Var.b((ConstraintLayout) LayoutInflater.from(context).inflate(this.e, (ViewGroup) null));
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.d = obtainStyledAttributes.getDimension(index, this.d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.b = obtainStyledAttributes.getDimension(index, this.b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.c = obtainStyledAttributes.getDimension(index, this.c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f2159a = obtainStyledAttributes.getDimension(index, this.f2159a);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public l4(Context context, ConstraintLayout constraintLayout, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        a aVar = null;
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    char c = 65535;
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c = 3;
                                break;
                            }
                            break;
                    }
                    if (!(c == 0 || c == 1)) {
                        if (c == 2) {
                            aVar = new a(context, xml);
                            this.f2157a.put(aVar.f2158a, aVar);
                        } else if (c == 3) {
                            b bVar = new b(context, xml);
                            if (aVar != null) {
                                aVar.b.add(bVar);
                            }
                        } else if (c == 4) {
                            a(context, xml);
                        }
                    }
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01c8, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c8, code lost:
        if (r1.equals("PropertySet") != false) goto L_0x00e0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r13, org.xmlpull.v1.XmlPullParser r14) {
        /*
        // Method dump skipped, instructions count: 536
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l4.a(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }
}
