package com.freshchat.consumer.sdk.j.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.StatFs;
import com.freshchat.consumer.sdk.j.a.c;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.aw;
import com.freshchat.consumer.sdk.j.q;
import java.io.File;
import java.io.IOException;

public class d {
    private static final Bitmap.CompressFormat jF = Bitmap.CompressFormat.PNG;
    private static b jG;
    private static c.a jI;
    private static final Object jJ = new Object();
    private static boolean jK = true;
    private static d jV;
    private static s2<String, Bitmap> ny;

    public d(c.a aVar) {
        b(aVar);
    }

    public static d a(c.a aVar) {
        d dVar;
        synchronized (d.class) {
            if (jV == null) {
                jV = new d(aVar);
            }
            dVar = jV;
        }
        return dVar;
    }

    public static String aV(String str) {
        return aa.aA(str);
    }

    public static int b(Bitmap bitmap) {
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    private void b(c.a aVar) {
        jI = aVar;
        if (aVar.jR) {
            StringBuilder i0 = hj1.i0("Memory cache created (size = ");
            i0.append(jI.jM);
            i0.append(")");
            ai.d("ImageCache", i0.toString());
            ny = 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002a: SPUT  
                  (wrap: com.freshchat.consumer.sdk.j.a.c$1 : 0x0027: CONSTRUCTOR  (r0v4 com.freshchat.consumer.sdk.j.a.c$1) = 
                  (r2v0 'this' com.freshchat.consumer.sdk.j.a.d A[IMMUTABLE_TYPE, THIS])
                  (wrap: int : 0x0025: IGET  (r1v5 int) = 
                  (wrap: com.freshchat.consumer.sdk.j.a.c$a : 0x0023: SGET  (r1v4 com.freshchat.consumer.sdk.j.a.c$a) =  com.freshchat.consumer.sdk.j.a.d.jI com.freshchat.consumer.sdk.j.a.c$a)
                 com.freshchat.consumer.sdk.j.a.c.a.jM int)
                 call: com.freshchat.consumer.sdk.j.a.c.1.<init>(com.freshchat.consumer.sdk.j.a.d, int):void type: CONSTRUCTOR)
                 com.freshchat.consumer.sdk.j.a.d.ny s2 in method: com.freshchat.consumer.sdk.j.a.d.b(com.freshchat.consumer.sdk.j.a.c$a):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0027: CONSTRUCTOR  (r0v4 com.freshchat.consumer.sdk.j.a.c$1) = 
                  (r2v0 'this' com.freshchat.consumer.sdk.j.a.d A[IMMUTABLE_TYPE, THIS])
                  (wrap: int : 0x0025: IGET  (r1v5 int) = 
                  (wrap: com.freshchat.consumer.sdk.j.a.c$a : 0x0023: SGET  (r1v4 com.freshchat.consumer.sdk.j.a.c$a) =  com.freshchat.consumer.sdk.j.a.d.jI com.freshchat.consumer.sdk.j.a.c$a)
                 com.freshchat.consumer.sdk.j.a.c.a.jM int)
                 call: com.freshchat.consumer.sdk.j.a.c.1.<init>(com.freshchat.consumer.sdk.j.a.d, int):void type: CONSTRUCTOR in method: com.freshchat.consumer.sdk.j.a.d.b(com.freshchat.consumer.sdk.j.a.c$a):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:439)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.freshchat.consumer.sdk.j.a.c, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 23 more
                */
            /*
                this = this;
                com.freshchat.consumer.sdk.j.a.d.jI = r3
                boolean r0 = r3.jR
                if (r0 == 0) goto L_0x002c
                java.lang.String r0 = "Memory cache created (size = "
                java.lang.StringBuilder r0 = defpackage.hj1.i0(r0)
                com.freshchat.consumer.sdk.j.a.c$a r1 = com.freshchat.consumer.sdk.j.a.d.jI
                int r1 = r1.jM
                r0.append(r1)
                java.lang.String r1 = ")"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "ImageCache"
                com.freshchat.consumer.sdk.j.ai.d(r1, r0)
                com.freshchat.consumer.sdk.j.a.c$1 r0 = new com.freshchat.consumer.sdk.j.a.c$1
                com.freshchat.consumer.sdk.j.a.c$a r1 = com.freshchat.consumer.sdk.j.a.d.jI
                int r1 = r1.jM
                r0.<init>(r1)
                com.freshchat.consumer.sdk.j.a.d.ny = r0
            L_0x002c:
                boolean r3 = r3.jU
                if (r3 == 0) goto L_0x0033
                r2.fk()
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.a.d.b(com.freshchat.consumer.sdk.j.a.c$a):void");
        }

        public static long d(File file) {
            if (aw.eR()) {
                return file.getUsableSpace();
            }
            StatFs statFs = new StatFs(file.getPath());
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        }

        public static File y(Context context, String str) {
            File file = new File(hj1.a0(hj1.i0(context.getCacheDir().getPath()), File.separator, str));
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
            if (r1 != null) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x005f, code lost:
            if (0 == 0) goto L_0x0068;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(java.lang.String r5, android.graphics.Bitmap r6) {
            /*
            // Method dump skipped, instructions count: 110
            */
            throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.a.d.a(java.lang.String, android.graphics.Bitmap):void");
        }

        public Bitmap aT(String str) {
            Bitmap bitmap;
            s2<String, Bitmap> s2Var = ny;
            if (s2Var == null || (bitmap = s2Var.get(str)) == null) {
                return null;
            }
            ai.d("ImageCache", "Memory cache hit");
            return bitmap;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x002f, code lost:
            if (r4 != null) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x003c, code lost:
            if (r4 != null) goto L_0x0031;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0007 */
        /* JADX WARNING: Removed duplicated region for block: B:2:0x0007 A[LOOP:0: B:2:0x0007->B:45:0x0007, LOOP_START, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0043 A[SYNTHETIC, Splitter:B:35:0x0043] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.graphics.Bitmap aU(java.lang.String r4) {
            /*
                r3 = this;
                java.lang.String r4 = aV(r4)
                java.lang.Object r0 = com.freshchat.consumer.sdk.j.a.d.jJ
                monitor-enter(r0)
            L_0x0007:
                boolean r1 = com.freshchat.consumer.sdk.j.a.d.jK     // Catch:{ all -> 0x0049 }
                if (r1 == 0) goto L_0x0011
                java.lang.Object r1 = com.freshchat.consumer.sdk.j.a.d.jJ     // Catch:{ InterruptedException -> 0x0007 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0007 }
                goto L_0x0007
            L_0x0011:
                com.freshchat.consumer.sdk.j.a.b r1 = com.freshchat.consumer.sdk.j.a.d.jG
                r2 = 0
                if (r1 == 0) goto L_0x0047
                com.freshchat.consumer.sdk.j.a.b$c r4 = r1.aP(r4)     // Catch:{ IOException -> 0x0037, all -> 0x0035 }
                if (r4 == 0) goto L_0x002e
                r1 = 0
                java.io.InputStream r4 = r4.z(r1)     // Catch:{ IOException -> 0x0037, all -> 0x0035 }
                if (r4 == 0) goto L_0x002f
                android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r4)     // Catch:{ IOException -> 0x002c }
                r4.close()     // Catch:{ IOException -> 0x002a }
            L_0x002a:
                monitor-exit(r0)
                return r1
            L_0x002c:
                r1 = move-exception
                goto L_0x0039
            L_0x002e:
                r4 = r2
            L_0x002f:
                if (r4 == 0) goto L_0x0047
            L_0x0031:
                r4.close()     // Catch:{ IOException -> 0x0047 }
                goto L_0x0047
            L_0x0035:
                r1 = move-exception
                goto L_0x0041
            L_0x0037:
                r1 = move-exception
                r4 = r2
            L_0x0039:
                com.freshchat.consumer.sdk.j.q.a(r1)     // Catch:{ all -> 0x003f }
                if (r4 == 0) goto L_0x0047
                goto L_0x0031
            L_0x003f:
                r1 = move-exception
                r2 = r4
            L_0x0041:
                if (r2 == 0) goto L_0x0046
                r2.close()     // Catch:{ IOException -> 0x0046 }
            L_0x0046:
                throw r1
            L_0x0047:
                monitor-exit(r0)
                return r2
            L_0x0049:
                r4 = move-exception
                monitor-exit(r0)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.a.d.aU(java.lang.String):android.graphics.Bitmap");
        }

        public void clearCache() {
            fl();
            synchronized (jJ) {
                jK = true;
                b bVar = jG;
                if (bVar != null && !bVar.isClosed()) {
                    try {
                        jG.delete();
                        ai.d("ImageCache", "Disk cache cleared");
                    } catch (IOException e) {
                        q.a(e);
                    }
                    jG = null;
                    fk();
                }
            }
        }

        public void close() {
            synchronized (jJ) {
                b bVar = jG;
                if (bVar != null) {
                    try {
                        if (!bVar.isClosed()) {
                            jG.close();
                            jG = null;
                            ai.d("ImageCache", "Disk cache closed");
                        }
                    } catch (IOException e) {
                        q.a(e);
                    }
                }
            }
        }

        public void fk() {
            synchronized (jJ) {
                b bVar = jG;
                if (bVar == null || bVar.isClosed()) {
                    c.a aVar = jI;
                    File file = aVar.jO;
                    if (aVar.jS && file != null) {
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        long d = d(file);
                        int i = jI.jN;
                        if (d > ((long) i)) {
                            try {
                                jG = b.a(file, 1, 1, (long) i);
                                ai.d("ImageCache", "Disk cache initialized");
                            } catch (IOException e) {
                                jI.jO = null;
                                q.a(e);
                            }
                        }
                    }
                }
                jK = false;
                jJ.notifyAll();
            }
        }

        public void fl() {
            s2<String, Bitmap> s2Var = ny;
            if (s2Var != null) {
                s2Var.evictAll();
                ai.d("ImageCache", "Memory cache cleared");
            }
        }

        public void flush() {
            synchronized (jJ) {
                b bVar = jG;
                if (bVar != null) {
                    try {
                        bVar.flush();
                        ai.d("ImageCache", "Disk cache flushed");
                    } catch (IOException e) {
                        q.a(e);
                    }
                }
            }
        }
    }
