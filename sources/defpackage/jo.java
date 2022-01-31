package defpackage;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.InflateException;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: jo  reason: default package */
/* compiled from: AnimatorInflaterCompat */
public class jo {

    /* renamed from: jo$a */
    /* compiled from: AnimatorInflaterCompat */
    public static class a implements TypeEvaluator<c6[]> {

        /* renamed from: a  reason: collision with root package name */
        public c6[] f1961a;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
        @Override // android.animation.TypeEvaluator
        public c6[] evaluate(float f, c6[] c6VarArr, c6[] c6VarArr2) {
            c6[] c6VarArr3 = c6VarArr;
            c6[] c6VarArr4 = c6VarArr2;
            if (h.l(c6VarArr3, c6VarArr4)) {
                if (!h.l(this.f1961a, c6VarArr3)) {
                    this.f1961a = h.D(c6VarArr3);
                }
                for (int i = 0; i < c6VarArr3.length; i++) {
                    c6 c6Var = this.f1961a[i];
                    c6 c6Var2 = c6VarArr3[i];
                    c6 c6Var3 = c6VarArr4[i];
                    Objects.requireNonNull(c6Var);
                    c6Var.f524a = c6Var2.f524a;
                    int i2 = 0;
                    while (true) {
                        float[] fArr = c6Var2.b;
                        if (i2 >= fArr.length) {
                            break;
                        }
                        c6Var.b[i2] = (c6Var3.b[i2] * f) + ((1.0f - f) * fArr[i2]);
                        i2++;
                    }
                }
                return this.f1961a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r15v12, resolved type: android.animation.AnimatorSet */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0329  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.animation.Animator a(android.content.Context r22, android.content.res.Resources r23, android.content.res.Resources.Theme r24, org.xmlpull.v1.XmlPullParser r25, android.util.AttributeSet r26, android.animation.AnimatorSet r27, int r28, float r29) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 891
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jo.a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    public static Keyframe b(Keyframe keyframe, float f) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f);
        }
        return Keyframe.ofObject(f);
    }

    public static PropertyValuesHolder c(TypedArray typedArray, int i, int i2, int i3, String str) {
        PropertyValuesHolder propertyValuesHolder;
        int i4;
        int i5;
        int i6;
        float f;
        float f2;
        float f3;
        PropertyValuesHolder propertyValuesHolder2;
        TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = peekValue != null;
        int i7 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        boolean z2 = peekValue2 != null;
        int i8 = z2 ? peekValue2.type : 0;
        if (i == 4) {
            i = ((!z || !d(i7)) && (!z2 || !d(i8))) ? 0 : 3;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolder3 = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            c6[] z4 = h.z(string);
            c6[] z5 = h.z(string2);
            if (z4 == null && z5 == null) {
                return null;
            }
            if (z4 != null) {
                a aVar = new a();
                if (z5 == null) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofObject(str, aVar, z4);
                } else if (h.l(z4, z5)) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofObject(str, aVar, z4, z5);
                } else {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                return propertyValuesHolder2;
            } else if (z5 == null) {
                return null;
            } else {
                return PropertyValuesHolder.ofObject(str, new a(), z5);
            }
        } else {
            ko koVar = i == 3 ? ko.f2090a : null;
            if (z3) {
                if (z) {
                    if (i7 == 5) {
                        f2 = typedArray.getDimension(i2, 0.0f);
                    } else {
                        f2 = typedArray.getFloat(i2, 0.0f);
                    }
                    if (z2) {
                        if (i8 == 5) {
                            f3 = typedArray.getDimension(i3, 0.0f);
                        } else {
                            f3 = typedArray.getFloat(i3, 0.0f);
                        }
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f2, f3);
                    } else {
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f2);
                    }
                } else {
                    if (i8 == 5) {
                        f = typedArray.getDimension(i3, 0.0f);
                    } else {
                        f = typedArray.getFloat(i3, 0.0f);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f);
                }
            } else if (z) {
                if (i7 == 5) {
                    i5 = (int) typedArray.getDimension(i2, 0.0f);
                } else if (d(i7)) {
                    i5 = typedArray.getColor(i2, 0);
                } else {
                    i5 = typedArray.getInt(i2, 0);
                }
                if (z2) {
                    if (i8 == 5) {
                        i6 = (int) typedArray.getDimension(i3, 0.0f);
                    } else if (d(i8)) {
                        i6 = typedArray.getColor(i3, 0);
                    } else {
                        i6 = typedArray.getInt(i3, 0);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5, i6);
                } else {
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5);
                }
            } else {
                if (z2) {
                    if (i8 == 5) {
                        i4 = (int) typedArray.getDimension(i3, 0.0f);
                    } else if (d(i8)) {
                        i4 = typedArray.getColor(i3, 0);
                    } else {
                        i4 = typedArray.getInt(i3, 0);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, i4);
                }
                if (propertyValuesHolder3 == null && koVar != null) {
                    propertyValuesHolder3.setEvaluator(koVar);
                    return propertyValuesHolder3;
                }
            }
            propertyValuesHolder3 = propertyValuesHolder;
            return propertyValuesHolder3 == null ? propertyValuesHolder3 : propertyValuesHolder3;
        }
    }

    public static boolean d(int i) {
        return i >= 28 && i <= 31;
    }

    public static ValueAnimator e(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        int i;
        int i2;
        int i3;
        int i4;
        TypedArray typedArray;
        ValueAnimator valueAnimator2;
        TypedArray typedArray2;
        ValueAnimator valueAnimator3;
        PropertyValuesHolder propertyValuesHolder;
        TypedArray k0 = h.k0(resources, theme, attributeSet, ho.g);
        TypedArray k02 = h.k0(resources, theme, attributeSet, ho.k);
        ValueAnimator valueAnimator4 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
        int i5 = 300;
        if (h.a0(xmlPullParser, "duration")) {
            i5 = k0.getInt(1, 300);
        }
        long j = (long) i5;
        int i6 = 0;
        if (!h.a0(xmlPullParser, "startOffset")) {
            i = 0;
        } else {
            i = k0.getInt(2, 0);
        }
        long j2 = (long) i;
        if (!h.a0(xmlPullParser, "valueType")) {
            i2 = 4;
        } else {
            i2 = k0.getInt(7, 4);
        }
        if (h.a0(xmlPullParser, "valueFrom") && h.a0(xmlPullParser, "valueTo")) {
            if (i2 == 4) {
                TypedValue peekValue = k0.peekValue(5);
                boolean z = peekValue != null;
                int i7 = z ? peekValue.type : 0;
                TypedValue peekValue2 = k0.peekValue(6);
                boolean z2 = peekValue2 != null;
                i2 = ((!z || !d(i7)) && (!z2 || !d(z2 ? peekValue2.type : 0))) ? 0 : 3;
            }
            PropertyValuesHolder c = c(k0, i2, 5, 6, "");
            if (c != null) {
                valueAnimator4.setValues(c);
            }
        }
        valueAnimator4.setDuration(j);
        valueAnimator4.setStartDelay(j2);
        if (!h.a0(xmlPullParser, "repeatCount")) {
            i3 = 0;
        } else {
            i3 = k0.getInt(3, 0);
        }
        valueAnimator4.setRepeatCount(i3);
        if (!h.a0(xmlPullParser, "repeatMode")) {
            i4 = 1;
        } else {
            i4 = k0.getInt(4, 1);
        }
        valueAnimator4.setRepeatMode(i4);
        if (k02 != null) {
            ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator4;
            String Q = h.Q(k02, xmlPullParser, "pathData", 1);
            if (Q != null) {
                String Q2 = h.Q(k02, xmlPullParser, "propertyXName", 2);
                String Q3 = h.Q(k02, xmlPullParser, "propertyYName", 3);
                if (Q2 == null && Q3 == null) {
                    throw new InflateException(k02.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path A = h.A(Q);
                float f2 = 0.5f * f;
                PathMeasure pathMeasure = new PathMeasure(A, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float f3 = 0.0f;
                do {
                    f3 += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(f3));
                } while (pathMeasure.nextContour());
                PathMeasure pathMeasure2 = new PathMeasure(A, false);
                int min = Math.min(100, ((int) (f3 / f2)) + 1);
                float[] fArr = new float[min];
                float[] fArr2 = new float[min];
                float[] fArr3 = new float[2];
                float f4 = f3 / ((float) (min - 1));
                valueAnimator2 = valueAnimator4;
                typedArray = k0;
                int i8 = 0;
                float f5 = 0.0f;
                while (true) {
                    propertyValuesHolder = null;
                    if (i6 >= min) {
                        break;
                    }
                    pathMeasure2.getPosTan(f5 - ((Float) arrayList.get(i8)).floatValue(), fArr3, null);
                    fArr[i6] = fArr3[0];
                    fArr2[i6] = fArr3[1];
                    f5 += f4;
                    int i9 = i8 + 1;
                    if (i9 < arrayList.size() && f5 > ((Float) arrayList.get(i9)).floatValue()) {
                        pathMeasure2.nextContour();
                        i8 = i9;
                    }
                    i6++;
                    min = min;
                }
                PropertyValuesHolder ofFloat = Q2 != null ? PropertyValuesHolder.ofFloat(Q2, fArr) : null;
                if (Q3 != null) {
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(Q3, fArr2);
                }
                if (ofFloat == null) {
                    i6 = 0;
                    objectAnimator.setValues(propertyValuesHolder);
                } else {
                    i6 = 0;
                    if (propertyValuesHolder == null) {
                        objectAnimator.setValues(ofFloat);
                    } else {
                        objectAnimator.setValues(ofFloat, propertyValuesHolder);
                    }
                }
            } else {
                valueAnimator2 = valueAnimator4;
                typedArray = k0;
                objectAnimator.setPropertyName(h.Q(k02, xmlPullParser, "propertyName", 0));
            }
        } else {
            valueAnimator2 = valueAnimator4;
            typedArray = k0;
        }
        if (!h.a0(xmlPullParser, "interpolator")) {
            typedArray2 = typedArray;
        } else {
            typedArray2 = typedArray;
            i6 = typedArray2.getResourceId(i6, i6);
        }
        if (i6 > 0) {
            valueAnimator3 = valueAnimator2;
            valueAnimator3.setInterpolator(AnimationUtils.loadInterpolator(context, i6));
        } else {
            valueAnimator3 = valueAnimator2;
        }
        typedArray2.recycle();
        if (k02 != null) {
            k02.recycle();
        }
        return valueAnimator3;
    }
}
