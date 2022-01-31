package defpackage;

import com.google.firebase.messaging.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: fl6$a  reason: default package */
/* compiled from: FileSystem.kt */
public final class fl6$a implements gl6 {
    @Override // defpackage.gl6
    public qn6 a(File file) throws FileNotFoundException {
        n86.f(file, "file");
        n86.f(file, "$this$source");
        FileInputStream fileInputStream = new FileInputStream(file);
        n86.f(fileInputStream, "$this$source");
        return new gn6(fileInputStream, new rn6());
    }

    @Override // defpackage.gl6
    public on6 b(File file) throws FileNotFoundException {
        n86.f(file, "file");
        try {
            return ec6.x(file, false, 1, null);
        } catch (FileNotFoundException unused) {
            file.getParentFile().mkdirs();
            return ec6.x(file, false, 1, null);
        }
    }

    @Override // defpackage.gl6
    public void c(File file) throws IOException {
        n86.f(file, "directory");
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                n86.b(file2, "file");
                if (file2.isDirectory()) {
                    c(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }

    @Override // defpackage.gl6
    public boolean d(File file) {
        n86.f(file, "file");
        return file.exists();
    }

    @Override // defpackage.gl6
    public void e(File file, File file2) throws IOException {
        n86.f(file, Constants.MessagePayloadKeys.FROM);
        n86.f(file2, "to");
        f(file2);
        if (!file.renameTo(file2)) {
            throw new IOException("failed to rename " + file + " to " + file2);
        }
    }

    @Override // defpackage.gl6
    public void f(File file) throws IOException {
        n86.f(file, "file");
        if (!file.delete() && file.exists()) {
            throw new IOException("failed to delete " + file);
        }
    }

    @Override // defpackage.gl6
    public on6 g(File file) throws FileNotFoundException {
        n86.f(file, "file");
        try {
            return ec6.d(file);
        } catch (FileNotFoundException unused) {
            file.getParentFile().mkdirs();
            return ec6.d(file);
        }
    }

    @Override // defpackage.gl6
    public long h(File file) {
        n86.f(file, "file");
        return file.length();
    }

    public String toString() {
        return "FileSystem.SYSTEM";
    }
}
