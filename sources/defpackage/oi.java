package defpackage;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: oi  reason: default package */
/* compiled from: MultiDex */
public final class oi {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<File> f2692a = new HashSet();
    public static final boolean b;

    static {
        String property = System.getProperty("java.vm.version");
        boolean z = false;
        if (property != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(property);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        b = z;
    }

    public static void a(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field d = d(obj, str);
        Object[] objArr2 = (Object[]) d.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        d.set(obj, objArr3);
    }

    public static void b(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            file.getPath();
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                file.getPath();
                return;
            }
            for (File file2 : listFiles) {
                file2.getPath();
                file2.length();
                if (!file2.delete()) {
                    file2.getPath();
                } else {
                    file2.getPath();
                }
            }
            if (!file.delete()) {
                file.getPath();
            } else {
                file.getPath();
            }
        }
    }

    public static void c(Context context, File file, File file2, String str, String str2, boolean z) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
        Set<File> set = f2692a;
        synchronized (set) {
            if (!set.contains(file)) {
                set.add(file);
                System.getProperty("java.vm.version");
                try {
                    ClassLoader classLoader = context.getClassLoader();
                    if (classLoader != null) {
                        try {
                            b(context);
                        } catch (Throwable unused) {
                        }
                        File file3 = new File(file2, "code_cache");
                        try {
                            f(file3);
                        } catch (IOException unused2) {
                            file3 = new File(context.getFilesDir(), "code_cache");
                            f(file3);
                        }
                        File file4 = new File(file3, str);
                        f(file4);
                        qi qiVar = new qi(file, file4);
                        IOException e = null;
                        try {
                            try {
                                e(classLoader, file4, qiVar.f(context, str2, false));
                            } catch (IOException e2) {
                                if (z) {
                                    e(classLoader, file4, qiVar.f(context, str2, true));
                                } else {
                                    throw e2;
                                }
                            }
                            try {
                            } catch (IOException e3) {
                                e = e3;
                            }
                            if (e != null) {
                                throw e;
                            }
                        } finally {
                            try {
                                qiVar.close();
                            } catch (IOException unused3) {
                            }
                        }
                    }
                } catch (RuntimeException unused4) {
                }
            }
        }
    }

    public static Field d(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        StringBuilder l0 = hj1.l0("Field ", str, " not found in ");
        l0.append(obj.getClass());
        throw new NoSuchFieldException(l0.toString());
    }

    public static void e(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
        IOException[] iOExceptionArr;
        if (!list.isEmpty()) {
            Object obj = d(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList(list);
            Class<?>[] clsArr = {ArrayList.class, File.class, ArrayList.class};
            for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("makeDexElements", clsArr);
                    if (!declaredMethod.isAccessible()) {
                        declaredMethod.setAccessible(true);
                    }
                    a(obj, "dexElements", (Object[]) declaredMethod.invoke(obj, arrayList2, file, arrayList));
                    if (arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            IOException iOException = (IOException) it.next();
                        }
                        Field d = d(obj, "dexElementsSuppressedExceptions");
                        IOException[] iOExceptionArr2 = (IOException[]) d.get(obj);
                        if (iOExceptionArr2 == null) {
                            iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                        } else {
                            IOException[] iOExceptionArr3 = new IOException[(arrayList.size() + iOExceptionArr2.length)];
                            arrayList.toArray(iOExceptionArr3);
                            System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                            iOExceptionArr = iOExceptionArr3;
                        }
                        d.set(obj, iOExceptionArr);
                        IOException iOException2 = new IOException("I/O exception during makeDexElement");
                        iOException2.initCause((Throwable) arrayList.get(0));
                        throw iOException2;
                    }
                    return;
                } catch (NoSuchMethodException unused) {
                }
            }
            StringBuilder l0 = hj1.l0("Method ", "makeDexElements", " with parameters ");
            l0.append(Arrays.asList(clsArr));
            l0.append(" not found in ");
            l0.append(obj.getClass());
            throw new NoSuchMethodException(l0.toString());
        }
    }

    public static void f(File file) throws IOException {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                file.getPath();
            } else {
                file.getPath();
                parentFile.isDirectory();
                parentFile.isFile();
                parentFile.exists();
                parentFile.canRead();
                parentFile.canWrite();
            }
            StringBuilder i0 = hj1.i0("Failed to create directory ");
            i0.append(file.getPath());
            throw new IOException(i0.toString());
        }
    }
}
