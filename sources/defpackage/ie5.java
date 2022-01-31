package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64OutputStream;
import android.util.DisplayMetrics;
import android.util.JsonWriter;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.firebase.perf.util.Constants;
import com.razorpay.AnalyticsConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

@TargetApi(16)
/* renamed from: ie5  reason: default package */
/* compiled from: ViewSnapshot */
public class ie5 {

    /* renamed from: a  reason: collision with root package name */
    public final jc5 f1510a;
    public final c b = new c();
    public final List<ce5> c;
    public final b d = new b(Constants.MAX_HOST_LENGTH);
    public final Handler e = new Handler(Looper.getMainLooper());
    public final yc5 f;

    /* renamed from: ie5$a */
    /* compiled from: ViewSnapshot */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f1511a = null;
        public final Paint b = new Paint(2);
    }

    /* renamed from: ie5$b */
    /* compiled from: ViewSnapshot */
    public static class b extends LruCache<Class<?>, String> {
        public b(int i) {
            super(i);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.LruCache
        public String create(Class<?> cls) {
            return cls.getCanonicalName();
        }
    }

    /* renamed from: ie5$c */
    /* compiled from: ViewSnapshot */
    public static class c implements Callable<List<d>> {
        public ee5<Activity> f;
        public final List<d> g = new ArrayList();
        public final DisplayMetrics h = new DisplayMetrics();
        public final a i = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00c4  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0135  */
        @Override // java.util.concurrent.Callable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.List<defpackage.ie5.d> call() throws java.lang.Exception {
            /*
            // Method dump skipped, instructions count: 338
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ie5.c.call():java.lang.Object");
        }
    }

    /* renamed from: ie5$d */
    /* compiled from: ViewSnapshot */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f1512a;
        public final View b;
        public a c = null;
        public float d = 1.0f;

        public d(String str, View view) {
            this.f1512a = str;
            this.b = view;
        }
    }

    public ie5(Context context, List<ce5> list, yc5 yc5) {
        this.f1510a = jc5.b(context);
        this.c = list;
        this.f = yc5;
    }

    public final void a(JsonWriter jsonWriter, View view) throws IOException {
        String str;
        vd5 vd5;
        Object a2;
        if (view.getVisibility() != 4 || !this.f1510a.v) {
            int id = view.getId();
            if (-1 == id) {
                str = null;
            } else {
                str = ((zc5) this.f).c.get(id);
            }
            jsonWriter.beginObject();
            jsonWriter.name("hashCode").value((long) view.hashCode());
            jsonWriter.name("id").value((long) id);
            jsonWriter.name("mp_id_name").value(str);
            CharSequence contentDescription = view.getContentDescription();
            if (contentDescription == null) {
                jsonWriter.name("contentDescription").nullValue();
            } else {
                jsonWriter.name("contentDescription").value(contentDescription.toString());
            }
            Object tag = view.getTag();
            if (tag == null) {
                jsonWriter.name("tag").nullValue();
            } else if (tag instanceof CharSequence) {
                jsonWriter.name("tag").value(tag.toString());
            }
            jsonWriter.name("top").value((long) view.getTop());
            jsonWriter.name("left").value((long) view.getLeft());
            jsonWriter.name("width").value((long) view.getWidth());
            jsonWriter.name("height").value((long) view.getHeight());
            jsonWriter.name("scrollX").value((long) view.getScrollX());
            jsonWriter.name("scrollY").value((long) view.getScrollY());
            jsonWriter.name("visibility").value((long) view.getVisibility());
            float translationX = view.getTranslationX();
            float translationY = view.getTranslationY();
            jsonWriter.name("translationX").value((double) translationX);
            jsonWriter.name("translationY").value((double) translationY);
            jsonWriter.name("classes");
            jsonWriter.beginArray();
            Class<?> cls = view.getClass();
            do {
                jsonWriter.value((String) this.d.get(cls));
                cls = cls.getSuperclass();
                if (cls == Object.class) {
                    break;
                }
            } while (cls != null);
            jsonWriter.endArray();
            Class<?> cls2 = view.getClass();
            for (ce5 ce5 : this.c) {
                if (!(!ce5.b.isAssignableFrom(cls2) || (vd5 = ce5.c) == null || (a2 = vd5.a(view, vd5.b)) == null)) {
                    if (a2 instanceof Number) {
                        jsonWriter.name(ce5.f558a).value((Number) a2);
                    } else if (a2 instanceof Boolean) {
                        jsonWriter.name(ce5.f558a).value(((Boolean) a2).booleanValue());
                    } else if (a2 instanceof ColorStateList) {
                        jsonWriter.name(ce5.f558a).value(Integer.valueOf(((ColorStateList) a2).getDefaultColor()));
                    } else if (a2 instanceof Drawable) {
                        Drawable drawable = (Drawable) a2;
                        Rect bounds = drawable.getBounds();
                        jsonWriter.name(ce5.f558a);
                        jsonWriter.beginObject();
                        jsonWriter.name("classes");
                        jsonWriter.beginArray();
                        for (Class<?> cls3 = drawable.getClass(); cls3 != Object.class; cls3 = cls3.getSuperclass()) {
                            jsonWriter.value(cls3.getCanonicalName());
                        }
                        jsonWriter.endArray();
                        jsonWriter.name("dimensions");
                        jsonWriter.beginObject();
                        jsonWriter.name("left").value((long) bounds.left);
                        jsonWriter.name("right").value((long) bounds.right);
                        jsonWriter.name("top").value((long) bounds.top);
                        jsonWriter.name("bottom").value((long) bounds.bottom);
                        jsonWriter.endObject();
                        if (drawable instanceof ColorDrawable) {
                            jsonWriter.name("color").value((long) ((ColorDrawable) drawable).getColor());
                        }
                        jsonWriter.endObject();
                    } else {
                        jsonWriter.name(ce5.f558a).value(a2.toString());
                    }
                }
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int[] rules = ((RelativeLayout.LayoutParams) layoutParams).getRules();
                jsonWriter.name("layoutRules");
                jsonWriter.beginArray();
                for (int i : rules) {
                    jsonWriter.value((long) i);
                }
                jsonWriter.endArray();
            }
            jsonWriter.name("subviews");
            jsonWriter.beginArray();
            boolean z = view instanceof ViewGroup;
            if (z) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt != null) {
                        jsonWriter.value((long) childAt.hashCode());
                    }
                }
            }
            jsonWriter.endArray();
            jsonWriter.endObject();
            if (z) {
                ViewGroup viewGroup2 = (ViewGroup) view;
                int childCount2 = viewGroup2.getChildCount();
                for (int i3 = 0; i3 < childCount2; i3++) {
                    View childAt2 = viewGroup2.getChildAt(i3);
                    if (childAt2 != null) {
                        a(jsonWriter, childAt2);
                    }
                }
            }
        }
    }

    public void b(ee5<Activity> ee5, OutputStream outputStream) throws IOException {
        this.b.f = ee5;
        FutureTask futureTask = new FutureTask(this.b);
        this.e.post(futureTask);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        List emptyList = Collections.emptyList();
        outputStreamWriter.write("[");
        try {
            emptyList = (List) futureTask.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
        }
        int size = emptyList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                outputStreamWriter.write(",");
            }
            d dVar = (d) emptyList.get(i);
            outputStreamWriter.write("{");
            outputStreamWriter.write("\"activity\":");
            outputStreamWriter.write(JSONObject.quote(dVar.f1512a));
            outputStreamWriter.write(",");
            outputStreamWriter.write("\"scale\":");
            outputStreamWriter.write(String.format("%s", Float.valueOf(dVar.d)));
            outputStreamWriter.write(",");
            outputStreamWriter.write("\"serialized_objects\":");
            JsonWriter jsonWriter = new JsonWriter(outputStreamWriter);
            jsonWriter.beginObject();
            jsonWriter.name("rootObject").value((long) dVar.b.hashCode());
            jsonWriter.name("objects");
            View view = dVar.b;
            jsonWriter.beginArray();
            a(jsonWriter, view);
            jsonWriter.endArray();
            jsonWriter.endObject();
            jsonWriter.flush();
            outputStreamWriter.write(",");
            outputStreamWriter.write("\"screenshot\":");
            outputStreamWriter.flush();
            a aVar = dVar.c;
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
            synchronized (aVar) {
                Bitmap bitmap = aVar.f1511a;
                if (!(bitmap == null || bitmap.getWidth() == 0)) {
                    if (aVar.f1511a.getHeight() != 0) {
                        outputStream.write(34);
                        Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, 2);
                        aVar.f1511a.compress(Bitmap.CompressFormat.PNG, 100, base64OutputStream);
                        base64OutputStream.flush();
                        outputStream.write(34);
                    }
                }
                outputStream.write(AnalyticsConstants.NULL.getBytes());
            }
            outputStreamWriter.write("}");
        }
        outputStreamWriter.write("]");
        outputStreamWriter.flush();
    }
}
