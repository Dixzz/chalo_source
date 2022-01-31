package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.util.Xml;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: j4  reason: default package */
/* compiled from: ConstraintAttribute */
public class j4 {

    /* renamed from: a  reason: collision with root package name */
    public String f1869a;
    public a b;
    public int c;
    public float d;
    public String e;
    public boolean f;
    public int g;

    /* renamed from: j4$a */
    /* compiled from: ConstraintAttribute */
    public enum a {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    public j4(String str, a aVar, Object obj) {
        this.f1869a = str;
        this.b = aVar;
        b(obj);
    }

    public static void a(Context context, XmlPullParser xmlPullParser, HashMap<String, j4> hashMap) {
        Object obj;
        a aVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj2 = null;
        a aVar2 = null;
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == R.styleable.CustomAttribute_customBoolean) {
                obj2 = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                aVar2 = a.BOOLEAN_TYPE;
            } else {
                if (index == R.styleable.CustomAttribute_customColorValue) {
                    aVar = a.COLOR_TYPE;
                    obj = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customColorDrawableValue) {
                    aVar = a.COLOR_DRAWABLE_TYPE;
                    obj = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customPixelDimension) {
                    aVar = a.DIMENSION_TYPE;
                    obj = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == R.styleable.CustomAttribute_customDimension) {
                    aVar = a.DIMENSION_TYPE;
                    obj = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.CustomAttribute_customFloatValue) {
                    aVar = a.FLOAT_TYPE;
                    obj = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R.styleable.CustomAttribute_customIntegerValue) {
                    aVar = a.INT_TYPE;
                    obj = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == R.styleable.CustomAttribute_customStringValue) {
                    aVar = a.STRING_TYPE;
                    obj = obtainStyledAttributes.getString(index);
                }
                aVar2 = aVar;
                obj2 = obj;
            }
        }
        if (!(str == null || obj2 == null)) {
            hashMap.put(str, new j4(str, aVar2, obj2));
        }
        obtainStyledAttributes.recycle();
    }

    public void b(Object obj) {
        switch (this.b.ordinal()) {
            case 0:
                this.c = ((Integer) obj).intValue();
                return;
            case 1:
                this.d = ((Float) obj).floatValue();
                return;
            case 2:
            case 3:
                this.g = ((Integer) obj).intValue();
                return;
            case 4:
                this.e = (String) obj;
                return;
            case 5:
                this.f = ((Boolean) obj).booleanValue();
                return;
            case 6:
                this.d = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public j4(j4 j4Var, Object obj) {
        this.f1869a = j4Var.f1869a;
        this.b = j4Var.b;
        b(obj);
    }
}
