package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: du4  reason: default package */
public final class du4 {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f890a = Pattern.compile("[0-9]+-(NAM|LFH)\\.dat");

    public static List<File> a(File file, File file2) throws IOException {
        File[] fileArr;
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file2.listFiles(cu4.f753a);
        if (listFiles == null) {
            fileArr = new File[0];
        } else {
            int length = listFiles.length;
            File[] fileArr2 = new File[length];
            for (File file3 : listFiles) {
                int parseInt = Integer.parseInt(file3.getName().split("-")[0]);
                if (parseInt > listFiles.length || fileArr2[parseInt] != null) {
                    throw new os4("Metadata folder ordering corrupt.");
                }
                fileArr2[parseInt] = file3;
            }
            fileArr = fileArr2;
        }
        for (File file4 : fileArr) {
            arrayList.add(file4);
            if (file4.getName().contains("LFH")) {
                FileInputStream fileInputStream = new FileInputStream(file4);
                try {
                    gu4 a2 = new is4(fileInputStream).a();
                    if (a2.f1305a != null) {
                        File file5 = new File(file, a2.f1305a);
                        if (file5.exists()) {
                            arrayList.add(file5);
                            fileInputStream.close();
                        } else {
                            throw new os4(String.format("Missing asset file %s during slice reconstruction.", file5.getCanonicalPath()));
                        }
                    } else {
                        throw new os4("Metadata files corrupt. Could not read local file header.");
                    }
                } catch (Throwable th) {
                    jw4.f1988a.a(th, th);
                }
            }
        }
        return arrayList;
        throw th;
    }
}
