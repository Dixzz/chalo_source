package defpackage;

import android.hardware.Camera;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: c45  reason: default package */
/* compiled from: CameraConfigurationUtils */
public final class c45 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f517a = 0;

    static {
        Pattern.compile(";");
    }

    public static String a(String str, Collection<String> collection, String... strArr) {
        Arrays.toString(strArr);
        String str2 = "Supported " + str + " values: " + collection;
        if (collection == null) {
            return null;
        }
        for (String str3 : strArr) {
            if (collection.contains(str3)) {
                return str3;
            }
        }
        return null;
    }

    public static void b(Camera.Parameters parameters, boolean z) {
        String str;
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (z) {
            str = a("flash mode", supportedFlashModes, "torch", "on");
        } else {
            str = a("flash mode", supportedFlashModes, "off");
        }
        if (str != null && !str.equals(parameters.getFlashMode())) {
            parameters.setFlashMode(str);
        }
    }
}
