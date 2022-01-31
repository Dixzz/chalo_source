package com.urbanairship.iam.assets;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.storage.StorageManager;
import com.rabbitmq.client.StringRpcServer;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonValue;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class Assets implements Parcelable {
    public static final Parcelable.Creator<Assets> CREATOR = new a();
    public final Executor f;
    public final File g;
    public final File h;
    public final File i;
    public final Map<String, JsonValue> j;
    public final Object k = new Object();

    public static class a implements Parcelable.Creator<Assets> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public Assets createFromParcel(Parcel parcel) {
            zt5 zt5;
            try {
                zt5 = JsonValue.p(parcel.readString()).n();
            } catch (xt5 e) {
                yj5.e(e, "Failed to parse metadata", new Object[0]);
                zt5 = zt5.g;
            }
            return new Assets(new File(parcel.readString()), zt5);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public Assets[] newArray(int i) {
            return new Assets[i];
        }
    }

    public Assets(File file, zt5 zt5) {
        this.g = file;
        this.h = new File(file, "files");
        this.i = new File(file, "metadata");
        this.j = new HashMap(zt5.n());
        this.f = pj5.a();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                yj5.d(e);
            }
        }
    }

    public static Assets c(File file) {
        Throwable th;
        BufferedReader bufferedReader;
        IOException e;
        xt5 e2;
        File file2 = new File(file, "metadata");
        JsonValue jsonValue = JsonValue.g;
        if (file2.exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file2));
                try {
                    StringWriter stringWriter = new StringWriter();
                    char[] cArr = new char[1024];
                    while (true) {
                        int read = bufferedReader.read(cArr);
                        if (read == -1) {
                            break;
                        }
                        stringWriter.write(cArr, 0, read);
                    }
                    jsonValue = JsonValue.p(stringWriter.toString());
                    a(bufferedReader);
                } catch (IOException e3) {
                    e = e3;
                    bufferedReader2 = bufferedReader;
                    yj5.e(e, "Error reading file", new Object[0]);
                    a(bufferedReader2);
                    return new Assets(file, jsonValue.n());
                } catch (xt5 e4) {
                    e2 = e4;
                    bufferedReader2 = bufferedReader;
                    yj5.e(e2, "Error parsing file as JSON.", new Object[0]);
                    a(bufferedReader2);
                    return new Assets(file, jsonValue.n());
                } catch (Throwable th2) {
                    th = th2;
                    a(bufferedReader);
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                yj5.e(e, "Error reading file", new Object[0]);
                a(bufferedReader2);
                return new Assets(file, jsonValue.n());
            } catch (xt5 e6) {
                e2 = e6;
                yj5.e(e2, "Error parsing file as JSON.", new Object[0]);
                a(bufferedReader2);
                return new Assets(file, jsonValue.n());
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = bufferedReader2;
                a(bufferedReader);
                throw th;
            }
        }
        return new Assets(file, jsonValue.n());
    }

    public File b(String str) {
        d();
        File file = this.h;
        String str2 = null;
        if (str != null) {
            try {
                str2 = hd3.y(MessageDigest.getInstance("SHA-256").digest(str.getBytes(StringRpcServer.STRING_ENCODING)));
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
                yj5.e(e, "Failed to encode string: %s", str);
            }
        }
        return new File(file, str2);
    }

    public final void d() {
        if (!this.g.exists()) {
            if (!this.g.mkdirs()) {
                yj5.c("Failed to create assets directory.", new Object[0]);
            } else if (Build.VERSION.SDK_INT >= 26) {
                try {
                    ((StorageManager) UAirship.d().getSystemService("storage")).setCacheBehaviorGroup(this.g, true);
                } catch (IOException e) {
                    yj5.e(e, "Failed to set cache behavior on directory: %s", this.g.getAbsoluteFile());
                }
            }
        }
        if (!this.h.exists() && !this.h.mkdirs()) {
            yj5.c("Failed to create directory: %s", this.h.getAbsoluteFile());
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        synchronized (this.k) {
            parcel.writeString(JsonValue.x(this.j).toString());
        }
        parcel.writeString(this.g.getAbsolutePath());
    }
}
