package defpackage;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

/* renamed from: nn1  reason: default package */
/* compiled from: GlideException */
public final class nn1 extends Exception {
    public static final StackTraceElement[] j = new StackTraceElement[0];
    public final List<Exception> f;
    public dm1 g;
    public xl1 h;
    public Class<?> i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public nn1(String str) {
        super(str);
        List<Exception> emptyList = Collections.emptyList();
        setStackTrace(j);
        this.f = emptyList;
    }

    public static void b(List<Exception> list, Appendable appendable) {
        try {
            c(list, appendable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void c(List<Exception> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            appendable.append("Cause (").append(String.valueOf(i3)).append(" of ").append(String.valueOf(size)).append("): ");
            Exception exc = list.get(i2);
            if (exc instanceof nn1) {
                ((nn1) exc).e(appendable);
            } else {
                d(exc, appendable);
            }
            i2 = i3;
        }
    }

    public static void d(Exception exc, Appendable appendable) {
        try {
            appendable.append(exc.getClass().toString()).append(": ").append(exc.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(exc);
        }
    }

    public final void a(Exception exc, List<Exception> list) {
        if (exc instanceof nn1) {
            for (Exception exc2 : ((nn1) exc).f) {
                a(exc2, list);
            }
            return;
        }
        list.add(exc);
    }

    public final void e(Appendable appendable) {
        d(this, appendable);
        b(this.f, new a(appendable));
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.getMessage());
        String str3 = "";
        if (this.i != null) {
            StringBuilder i0 = hj1.i0(", ");
            i0.append(this.i);
            str = i0.toString();
        } else {
            str = str3;
        }
        sb.append(str);
        if (this.h != null) {
            StringBuilder i02 = hj1.i0(", ");
            i02.append(this.h);
            str2 = i02.toString();
        } else {
            str2 = str3;
        }
        sb.append(str2);
        if (this.g != null) {
            StringBuilder i03 = hj1.i0(", ");
            i03.append(this.g);
            str3 = i03.toString();
        }
        sb.append(str3);
        return sb.toString();
    }

    public void printStackTrace() {
        e(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        e(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        e(printWriter);
    }

    /* renamed from: nn1$a */
    /* compiled from: GlideException */
    public static final class a implements Appendable {
        public final Appendable f;
        public boolean g = true;

        public a(Appendable appendable) {
            this.f = appendable;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c) throws IOException {
            boolean z = false;
            if (this.g) {
                this.g = false;
                this.f.append("  ");
            }
            if (c == '\n') {
                z = true;
            }
            this.g = z;
            this.f.append(c);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) throws IOException {
            if (charSequence == null) {
                charSequence = "";
            }
            append(charSequence, 0, charSequence.length());
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
            if (charSequence == null) {
                charSequence = "";
            }
            boolean z = false;
            if (this.g) {
                this.g = false;
                this.f.append("  ");
            }
            if (charSequence.length() > 0 && charSequence.charAt(i2 - 1) == '\n') {
                z = true;
            }
            this.g = z;
            this.f.append(charSequence, i, i2);
            return this;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public nn1(String str, Exception exc) {
        super(str);
        List<Exception> singletonList = Collections.singletonList(exc);
        setStackTrace(j);
        this.f = singletonList;
    }

    public nn1(String str, List<Exception> list) {
        super(str);
        setStackTrace(j);
        this.f = list;
    }
}
