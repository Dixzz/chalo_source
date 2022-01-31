package defpackage;

/* renamed from: a96  reason: default package */
/* compiled from: ReflectionFactory */
public class a96 {
    public String a(k86 k86) {
        String obj = k86.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }
}
