package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: qk5  reason: default package */
/* compiled from: ActionRegistry */
public class qk5 {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f2957a = new HashMap();

    /* renamed from: qk5$a */
    /* compiled from: ActionRegistry */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f2958a;
        public nk5 b;
        public Class c;
        public b d;
        public final SparseArray<nk5> e = new SparseArray<>();

        public a(Class cls, List<String> list) {
            this.c = cls;
            this.f2958a = list;
        }

        public nk5 a(int i) {
            nk5 nk5 = this.e.get(i);
            if (nk5 != null) {
                return nk5;
            }
            if (this.b == null) {
                try {
                    this.b = (nk5) this.c.newInstance();
                } catch (Exception unused) {
                    throw new IllegalArgumentException("Unable to instantiate action class.");
                }
            }
            return this.b;
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("Action Entry: ");
            i0.append(this.f2958a);
            return i0.toString();
        }
    }

    /* renamed from: qk5$b */
    /* compiled from: ActionRegistry */
    public interface b {
        boolean a(ok5 ok5);
    }

    public a a(String str) {
        a aVar;
        if (hd3.G1(str)) {
            return null;
        }
        synchronized (this.f2957a) {
            aVar = this.f2957a.get(str);
        }
        return aVar;
    }

    public void b(Context context, int i) {
        List<a> arrayList;
        ArrayList arrayList2;
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            arrayList = hd3.q2(xml);
        } catch (Resources.NotFoundException | IOException | NullPointerException | XmlPullParserException e) {
            yj5.e(e, "Failed to parse action entries.", new Object[0]);
            arrayList = new ArrayList();
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
        xml.close();
        for (a aVar : arrayList) {
            synchronized (aVar.f2958a) {
                arrayList2 = new ArrayList(aVar.f2958a);
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                if (hd3.G1((String) it.next())) {
                    throw new IllegalArgumentException("Unable to register action because one or more of the names was null or empty.");
                }
            }
            synchronized (this.f2957a) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (!hd3.G1(str)) {
                        a remove = this.f2957a.remove(str);
                        if (remove != null) {
                            synchronized (remove.f2958a) {
                                remove.f2958a.remove(str);
                            }
                        }
                        this.f2957a.put(str, aVar);
                    }
                }
            }
        }
    }
}
