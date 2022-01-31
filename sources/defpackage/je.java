package defpackage;

import android.content.res.AssetManager;
import com.google.firebase.perf.util.Constants;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.LongString;
import j$.util.DesugarTimeZone;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/* renamed from: je  reason: default package */
/* compiled from: ExifInterface */
public class je {
    public static final c[] A;
    public static final c[] B;
    public static final c C = new c("StripOffsets", 273, 3);
    public static final c[] D;
    public static final c[] E;
    public static final c[] F;
    public static final c[] G;
    public static final c[][] H;
    public static final c[] I = {new c("SubIFDPointer", 330, 4), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4), new c("CameraSettingsIFDPointer", 8224, 1), new c("ImageProcessingIFDPointer", 8256, 1)};
    public static final HashMap<Integer, c>[] J;
    public static final HashMap<String, c>[] K;
    public static final HashSet<String> L = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
    public static final HashMap<Integer, Integer> M = new HashMap<>();
    public static final Charset N;
    public static final byte[] O;
    public static final List<Integer> m = Arrays.asList(1, 6, 3, 8);
    public static final List<Integer> n = Arrays.asList(2, 7, 4, 5);
    public static final int[] o = {8, 8, 8};
    public static final int[] p = {8};
    public static final byte[] q = {-1, -40, -1};
    public static final byte[] r = {79, 76, 89, 77, 80, 0};
    public static final byte[] s = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    public static SimpleDateFormat t;
    public static final String[] u = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    public static final int[] v = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    public static final byte[] w = {65, 83, 67, 73, 73, 0, 0, 0};
    public static final c[] x;
    public static final c[] y;
    public static final c[] z;

    /* renamed from: a  reason: collision with root package name */
    public final String f1907a;
    public final AssetManager.AssetInputStream b;
    public int c;
    public final HashMap<String, b>[] d;
    public Set<Integer> e;
    public ByteOrder f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;

    /* renamed from: je$b */
    /* compiled from: ExifInterface */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f1908a;
        public final int b;
        public final byte[] c;

        public b(int i, int i2, byte[] bArr) {
            this.f1908a = i;
            this.b = i2;
            this.c = bArr;
        }

        public static b a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(je.N);
            return new b(2, bytes.length, bytes);
        }

        public static b b(long j, ByteOrder byteOrder) {
            long[] jArr = {j};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(je.v[4] * 1)]);
            wrap.order(byteOrder);
            for (int i = 0; i < 1; i++) {
                wrap.putInt((int) jArr[i]);
            }
            return new b(4, 1, wrap.array());
        }

        public static b c(d dVar, ByteOrder byteOrder) {
            d[] dVarArr = {dVar};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(je.v[5] * 1)]);
            wrap.order(byteOrder);
            for (int i = 0; i < 1; i++) {
                d dVar2 = dVarArr[i];
                wrap.putInt((int) dVar2.f1910a);
                wrap.putInt((int) dVar2.b);
            }
            return new b(5, 1, wrap.array());
        }

        public static b d(int i, ByteOrder byteOrder) {
            int[] iArr = {i};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(je.v[3] * 1)]);
            wrap.order(byteOrder);
            for (int i2 = 0; i2 < 1; i2++) {
                wrap.putShort((short) iArr[i2]);
            }
            return new b(3, 1, wrap.array());
        }

        public double e(ByteOrder byteOrder) {
            Object h = h(byteOrder);
            if (h == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (h instanceof String) {
                return Double.parseDouble((String) h);
            } else {
                if (h instanceof long[]) {
                    long[] jArr = (long[]) h;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (h instanceof int[]) {
                    int[] iArr = (int[]) h;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (h instanceof double[]) {
                    double[] dArr = (double[]) h;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (h instanceof d[]) {
                    d[] dVarArr = (d[]) h;
                    if (dVarArr.length == 1) {
                        d dVar = dVarArr[0];
                        return ((double) dVar.f1910a) / ((double) dVar.b);
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int f(ByteOrder byteOrder) {
            Object h = h(byteOrder);
            if (h == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (h instanceof String) {
                return Integer.parseInt((String) h);
            } else {
                if (h instanceof long[]) {
                    long[] jArr = (long[]) h;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (h instanceof int[]) {
                    int[] iArr = (int[]) h;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String g(ByteOrder byteOrder) {
            Object h = h(byteOrder);
            if (h == null) {
                return null;
            }
            if (h instanceof String) {
                return (String) h;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (h instanceof long[]) {
                long[] jArr = (long[]) h;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (h instanceof int[]) {
                int[] iArr = (int[]) h;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (h instanceof double[]) {
                double[] dArr = (double[]) h;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(h instanceof d[])) {
                return null;
            } else {
                d[] dVarArr = (d[]) h;
                while (i < dVarArr.length) {
                    sb.append(dVarArr[i].f1910a);
                    sb.append('/');
                    sb.append(dVarArr[i].b);
                    i++;
                    if (i != dVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:122:0x014e A[SYNTHETIC, Splitter:B:122:0x014e] */
        /* JADX WARNING: Removed duplicated region for block: B:130:0x0155 A[SYNTHETIC, Splitter:B:130:0x0155] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object h(java.nio.ByteOrder r9) {
            /*
            // Method dump skipped, instructions count: 374
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.je.b.h(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("(");
            i0.append(je.u[this.f1908a]);
            i0.append(", data length:");
            return hj1.X(i0, this.c.length, ")");
        }
    }

    /* renamed from: je$d */
    /* compiled from: ExifInterface */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final long f1910a;
        public final long b;

        public d(long j, long j2) {
            if (j2 == 0) {
                this.f1910a = 0;
                this.b = 1;
                return;
            }
            this.f1910a = j;
            this.b = j2;
        }

        public String toString() {
            return this.f1910a + ConnectionFactory.DEFAULT_VHOST + this.b;
        }
    }

    static {
        c[] cVarArr = {new c("NewSubfileType", 254, 4), new c("SubfileType", Constants.MAX_HOST_LENGTH, 4), new c("ImageWidth", 256, 3, 4), new c("ImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", AMQP.NOT_ALLOWED, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("SensorTopBorder", 4, 4), new c("SensorLeftBorder", 5, 4), new c("SensorBottomBorder", 6, 4), new c("SensorRightBorder", 7, 4), new c("ISO", 23, 3), new c("JpgFromRaw", 46, 7)};
        x = cVarArr;
        c[] cVarArr2 = {new c("ExposureTime", 33434, 5), new c("FNumber", 33437, 5), new c("ExposureProgram", 34850, 3), new c("SpectralSensitivity", 34852, 2), new c("PhotographicSensitivity", 34855, 3), new c("OECF", 34856, 7), new c("ExifVersion", 36864, 2), new c("DateTimeOriginal", 36867, 2), new c("DateTimeDigitized", 36868, 2), new c("ComponentsConfiguration", 37121, 7), new c("CompressedBitsPerPixel", 37122, 5), new c("ShutterSpeedValue", 37377, 10), new c("ApertureValue", 37378, 5), new c("BrightnessValue", 37379, 10), new c("ExposureBiasValue", 37380, 10), new c("MaxApertureValue", 37381, 5), new c("SubjectDistance", 37382, 5), new c("MeteringMode", 37383, 3), new c("LightSource", 37384, 3), new c("Flash", 37385, 3), new c("FocalLength", 37386, 5), new c("SubjectArea", 37396, 3), new c("MakerNote", 37500, 7), new c("UserComment", 37510, 7), new c("SubSecTime", 37520, 2), new c("SubSecTimeOriginal", 37521, 2), new c("SubSecTimeDigitized", 37522, 2), new c("FlashpixVersion", 40960, 7), new c("ColorSpace", 40961, 3), new c("PixelXDimension", 40962, 3, 4), new c("PixelYDimension", 40963, 3, 4), new c("RelatedSoundFile", 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c("FlashEnergy", 41483, 5), new c("SpatialFrequencyResponse", 41484, 7), new c("FocalPlaneXResolution", 41486, 5), new c("FocalPlaneYResolution", 41487, 5), new c("FocalPlaneResolutionUnit", 41488, 3), new c("SubjectLocation", 41492, 3), new c("ExposureIndex", 41493, 5), new c("SensingMethod", 41495, 3), new c("FileSource", 41728, 7), new c("SceneType", 41729, 7), new c("CFAPattern", 41730, 7), new c("CustomRendered", 41985, 3), new c("ExposureMode", 41986, 3), new c("WhiteBalance", 41987, 3), new c("DigitalZoomRatio", 41988, 5), new c("FocalLengthIn35mmFilm", 41989, 3), new c("SceneCaptureType", 41990, 3), new c("GainControl", 41991, 3), new c("Contrast", 41992, 3), new c("Saturation", 41993, 3), new c("Sharpness", 41994, 3), new c("DeviceSettingDescription", 41995, 7), new c("SubjectDistanceRange", 41996, 3), new c("ImageUniqueID", 42016, 2), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
        y = cVarArr2;
        c[] cVarArr3 = {new c("GPSVersionID", 0, 1), new c("GPSLatitudeRef", 1, 2), new c("GPSLatitude", 2, 5), new c("GPSLongitudeRef", 3, 2), new c("GPSLongitude", 4, 5), new c("GPSAltitudeRef", 5, 1), new c("GPSAltitude", 6, 5), new c("GPSTimeStamp", 7, 5), new c("GPSSatellites", 8, 2), new c("GPSStatus", 9, 2), new c("GPSMeasureMode", 10, 2), new c("GPSDOP", 11, 5), new c("GPSSpeedRef", 12, 2), new c("GPSSpeed", 13, 5), new c("GPSTrackRef", 14, 2), new c("GPSTrack", 15, 5), new c("GPSImgDirectionRef", 16, 2), new c("GPSImgDirection", 17, 5), new c("GPSMapDatum", 18, 2), new c("GPSDestLatitudeRef", 19, 2), new c("GPSDestLatitude", 20, 5), new c("GPSDestLongitudeRef", 21, 2), new c("GPSDestLongitude", 22, 5), new c("GPSDestBearingRef", 23, 2), new c("GPSDestBearing", 24, 5), new c("GPSDestDistanceRef", 25, 2), new c("GPSDestDistance", 26, 5), new c("GPSProcessingMethod", 27, 7), new c("GPSAreaInformation", 28, 7), new c("GPSDateStamp", 29, 2), new c("GPSDifferential", 30, 3)};
        z = cVarArr3;
        c[] cVarArr4 = {new c("InteroperabilityIndex", 1, 2)};
        A = cVarArr4;
        c[] cVarArr5 = {new c("NewSubfileType", 254, 4), new c("SubfileType", Constants.MAX_HOST_LENGTH, 4), new c("ThumbnailImageWidth", 256, 3, 4), new c("ThumbnailImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", AMQP.NOT_ALLOWED, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
        B = cVarArr5;
        c[] cVarArr6 = {new c("ThumbnailImage", 256, 7), new c("CameraSettingsIFDPointer", 8224, 4), new c("ImageProcessingIFDPointer", 8256, 4)};
        D = cVarArr6;
        c[] cVarArr7 = {new c("PreviewImageStart", 257, 4), new c("PreviewImageLength", 258, 4)};
        E = cVarArr7;
        c[] cVarArr8 = {new c("AspectFrame", 4371, 3)};
        F = cVarArr8;
        c[] cVarArr9 = {new c("ColorSpace", 55, 3)};
        G = cVarArr9;
        c[][] cVarArr10 = {cVarArr, cVarArr2, cVarArr3, cVarArr4, cVarArr5, cVarArr, cVarArr6, cVarArr7, cVarArr8, cVarArr9};
        H = cVarArr10;
        J = new HashMap[cVarArr10.length];
        K = new HashMap[cVarArr10.length];
        Charset forName = Charset.forName("US-ASCII");
        N = forName;
        O = "Exif\u0000\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        t = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        int i2 = 0;
        while (true) {
            c[][] cVarArr11 = H;
            if (i2 < cVarArr11.length) {
                J[i2] = new HashMap<>();
                K[i2] = new HashMap<>();
                c[] cVarArr12 = cVarArr11[i2];
                for (c cVar : cVarArr12) {
                    J[i2].put(Integer.valueOf(cVar.f1909a), cVar);
                    K[i2].put(cVar.b, cVar);
                }
                i2++;
            } else {
                HashMap<Integer, Integer> hashMap = M;
                c[] cVarArr13 = I;
                hashMap.put(Integer.valueOf(cVarArr13[0].f1909a), 5);
                hashMap.put(Integer.valueOf(cVarArr13[1].f1909a), 1);
                hashMap.put(Integer.valueOf(cVarArr13[2].f1909a), 2);
                hashMap.put(Integer.valueOf(cVarArr13[3].f1909a), 3);
                hashMap.put(Integer.valueOf(cVarArr13[4].f1909a), 7);
                hashMap.put(Integer.valueOf(cVarArr13[5].f1909a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031 A[SYNTHETIC, Splitter:B:16:0x0031] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public je(java.lang.String r3) throws java.io.IOException {
        /*
            r2 = this;
            r2.<init>()
            je$c[][] r0 = defpackage.je.H
            int r1 = r0.length
            java.util.HashMap[] r1 = new java.util.HashMap[r1]
            r2.d = r1
            java.util.HashSet r1 = new java.util.HashSet
            int r0 = r0.length
            r1.<init>(r0)
            r2.e = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r2.f = r0
            if (r3 == 0) goto L_0x0038
            r0 = 0
            r2.b = r0
            r2.f1907a = r3
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x002e }
            r1.<init>(r3)     // Catch:{ all -> 0x002e }
            r2.m(r1)     // Catch:{ all -> 0x002b }
            r1.close()     // Catch:{ RuntimeException -> 0x0029, Exception -> 0x0028 }
        L_0x0028:
            return
        L_0x0029:
            r3 = move-exception
            throw r3
        L_0x002b:
            r3 = move-exception
            r0 = r1
            goto L_0x002f
        L_0x002e:
            r3 = move-exception
        L_0x002f:
            if (r0 == 0) goto L_0x0037
            r0.close()     // Catch:{ RuntimeException -> 0x0035, Exception -> 0x0037 }
            goto L_0x0037
        L_0x0035:
            r3 = move-exception
            throw r3
        L_0x0037:
            throw r3
        L_0x0038:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "filename cannot be null"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je.<init>(java.lang.String):void");
    }

    public static long[] b(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jArr[i2] = (long) iArr[i2];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }

    public final void a() {
        String c2 = c("DateTimeOriginal");
        if (c2 != null && c("DateTime") == null) {
            this.d[0].put("DateTime", b.a(c2));
        }
        if (c("ImageWidth") == null) {
            this.d[0].put("ImageWidth", b.b(0, this.f));
        }
        if (c("ImageLength") == null) {
            this.d[0].put("ImageLength", b.b(0, this.f));
        }
        if (c("Orientation") == null) {
            this.d[0].put("Orientation", b.b(0, this.f));
        }
        if (c("LightSource") == null) {
            this.d[1].put("LightSource", b.b(0, this.f));
        }
    }

    public String c(String str) {
        b d2 = d(str);
        if (d2 != null) {
            if (!L.contains(str)) {
                return d2.g(this.f);
            }
            if (str.equals("GPSTimeStamp")) {
                int i2 = d2.f1908a;
                if (i2 != 5 && i2 != 10) {
                    return null;
                }
                d[] dVarArr = (d[]) d2.h(this.f);
                if (dVarArr == null || dVarArr.length != 3) {
                    Arrays.toString(dVarArr);
                    return null;
                }
                return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) dVarArr[0].f1910a) / ((float) dVarArr[0].b))), Integer.valueOf((int) (((float) dVarArr[1].f1910a) / ((float) dVarArr[1].b))), Integer.valueOf((int) (((float) dVarArr[2].f1910a) / ((float) dVarArr[2].b))));
            }
            try {
                return Double.toString(d2.e(this.f));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final b d(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i2 = 0; i2 < H.length; i2++) {
            b bVar = this.d[i2].get(str);
            if (bVar != null) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0055 A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00fc A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(defpackage.je.a r9, int r10, int r11) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 400
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je.e(je$a, int, int):void");
    }

    public final int f(BufferedInputStream bufferedInputStream) throws IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        int i2 = 0;
        while (true) {
            byte[] bArr2 = q;
            z2 = true;
            if (i2 >= bArr2.length) {
                z3 = true;
                break;
            } else if (bArr[i2] != bArr2[i2]) {
                z3 = false;
                break;
            } else {
                i2++;
            }
        }
        if (z3) {
            return 4;
        }
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        int i3 = 0;
        while (true) {
            if (i3 >= bytes.length) {
                z4 = true;
                break;
            } else if (bArr[i3] != bytes[i3]) {
                z4 = false;
                break;
            } else {
                i3++;
            }
        }
        if (z4) {
            return 9;
        }
        a aVar = new a(bArr);
        ByteOrder o2 = o(aVar);
        this.f = o2;
        aVar.g = o2;
        short readShort = aVar.readShort();
        aVar.close();
        if (readShort == 20306 || readShort == 21330) {
            return 7;
        }
        a aVar2 = new a(bArr);
        ByteOrder o3 = o(aVar2);
        this.f = o3;
        aVar2.g = o3;
        short readShort2 = aVar2.readShort();
        aVar2.close();
        if (readShort2 != 85) {
            z2 = false;
        }
        if (z2) {
            return 10;
        }
        return 0;
    }

    public final void g(a aVar) throws IOException {
        i(aVar);
        b bVar = this.d[1].get("MakerNote");
        if (bVar != null) {
            a aVar2 = new a(bVar.c);
            aVar2.g = this.f;
            byte[] bArr = r;
            byte[] bArr2 = new byte[bArr.length];
            aVar2.readFully(bArr2);
            aVar2.c(0);
            byte[] bArr3 = s;
            byte[] bArr4 = new byte[bArr3.length];
            aVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                aVar2.c(8);
            } else if (Arrays.equals(bArr4, bArr3)) {
                aVar2.c(12);
            }
            p(aVar2, 6);
            b bVar2 = this.d[7].get("PreviewImageStart");
            b bVar3 = this.d[7].get("PreviewImageLength");
            if (!(bVar2 == null || bVar3 == null)) {
                this.d[5].put("JPEGInterchangeFormat", bVar2);
                this.d[5].put("JPEGInterchangeFormatLength", bVar3);
            }
            b bVar4 = this.d[8].get("AspectFrame");
            if (bVar4 != null) {
                int[] iArr = (int[]) bVar4.h(this.f);
                if (iArr == null || iArr.length != 4) {
                    Arrays.toString(iArr);
                } else if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                    int i2 = (iArr[2] - iArr[0]) + 1;
                    int i3 = (iArr[3] - iArr[1]) + 1;
                    if (i2 < i3) {
                        int i4 = i2 + i3;
                        i3 = i4 - i3;
                        i2 = i4 - i3;
                    }
                    b d2 = b.d(i2, this.f);
                    b d3 = b.d(i3, this.f);
                    this.d[0].put("ImageWidth", d2);
                    this.d[0].put("ImageLength", d3);
                }
            }
        }
    }

    public final void h(a aVar) throws IOException {
        aVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        aVar.read(bArr);
        aVar.skipBytes(4);
        aVar.read(bArr2);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        e(aVar, i2, 5);
        aVar.c((long) i3);
        aVar.g = ByteOrder.BIG_ENDIAN;
        int readInt = aVar.readInt();
        for (int i4 = 0; i4 < readInt; i4++) {
            int readUnsignedShort = aVar.readUnsignedShort();
            int readUnsignedShort2 = aVar.readUnsignedShort();
            if (readUnsignedShort == C.f1909a) {
                short readShort = aVar.readShort();
                short readShort2 = aVar.readShort();
                b d2 = b.d(readShort, this.f);
                b d3 = b.d(readShort2, this.f);
                this.d[0].put("ImageLength", d2);
                this.d[0].put("ImageWidth", d3);
                return;
            }
            aVar.skipBytes(readUnsignedShort2);
        }
    }

    public final void i(a aVar) throws IOException {
        b bVar;
        n(aVar, aVar.available());
        p(aVar, 0);
        s(aVar, 0);
        s(aVar, 5);
        s(aVar, 4);
        r(0, 5);
        r(0, 4);
        r(5, 4);
        b bVar2 = this.d[1].get("PixelXDimension");
        b bVar3 = this.d[1].get("PixelYDimension");
        if (!(bVar2 == null || bVar3 == null)) {
            this.d[0].put("ImageWidth", bVar2);
            this.d[0].put("ImageLength", bVar3);
        }
        if (this.d[4].isEmpty() && l(this.d[5])) {
            HashMap<String, b>[] hashMapArr = this.d;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        l(this.d[4]);
        if (this.c == 8 && (bVar = this.d[1].get("MakerNote")) != null) {
            a aVar2 = new a(bVar.c);
            aVar2.g = this.f;
            aVar2.c(6);
            p(aVar2, 9);
            b bVar4 = this.d[9].get("ColorSpace");
            if (bVar4 != null) {
                this.d[1].put("ColorSpace", bVar4);
            }
        }
    }

    public final void j(a aVar) throws IOException {
        i(aVar);
        if (this.d[0].get("JpgFromRaw") != null) {
            e(aVar, this.l, 5);
        }
        b bVar = this.d[0].get("ISO");
        b bVar2 = this.d[1].get("PhotographicSensitivity");
        if (bVar != null && bVar2 == null) {
            this.d[1].put("PhotographicSensitivity", bVar);
        }
    }

    public final void k(a aVar, HashMap hashMap) throws IOException {
        int i2;
        b bVar = (b) hashMap.get("JPEGInterchangeFormat");
        b bVar2 = (b) hashMap.get("JPEGInterchangeFormatLength");
        if (bVar != null && bVar2 != null) {
            int f2 = bVar.f(this.f);
            int min = Math.min(bVar2.f(this.f), aVar.available() - f2);
            int i3 = this.c;
            if (i3 == 4 || i3 == 9 || i3 == 10) {
                i2 = this.h;
            } else {
                if (i3 == 7) {
                    i2 = this.i;
                }
                if (f2 > 0 && min > 0 && this.f1907a == null && this.b == null) {
                    aVar.c((long) f2);
                    aVar.readFully(new byte[min]);
                    return;
                }
                return;
            }
            f2 += i2;
            if (f2 > 0) {
            }
        }
    }

    public final boolean l(HashMap hashMap) throws IOException {
        b bVar = (b) hashMap.get("ImageLength");
        b bVar2 = (b) hashMap.get("ImageWidth");
        if (bVar == null || bVar2 == null) {
            return false;
        }
        return bVar.f(this.f) <= 512 && bVar2.f(this.f) <= 512;
    }

    public final void m(InputStream inputStream) throws IOException {
        for (int i2 = 0; i2 < H.length; i2++) {
            try {
                this.d[i2] = new HashMap<>();
            } catch (IOException unused) {
            } catch (Throwable th) {
                a();
                throw th;
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        this.c = f(bufferedInputStream);
        a aVar = new a(bufferedInputStream);
        switch (this.c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                i(aVar);
                break;
            case 4:
                e(aVar, 0, 0);
                break;
            case 7:
                g(aVar);
                break;
            case 9:
                h(aVar);
                break;
            case 10:
                j(aVar);
                break;
        }
        q(aVar);
        a();
    }

    public final void n(a aVar, int i2) throws IOException {
        ByteOrder o2 = o(aVar);
        this.f = o2;
        aVar.g = o2;
        int readUnsignedShort = aVar.readUnsignedShort();
        int i3 = this.c;
        if (i3 == 7 || i3 == 10 || readUnsignedShort == 42) {
            int readInt = aVar.readInt();
            if (readInt < 8 || readInt >= i2) {
                throw new IOException(hj1.I("Invalid first Ifd offset: ", readInt));
            }
            int i4 = readInt - 8;
            if (i4 > 0 && aVar.skipBytes(i4) != i4) {
                throw new IOException(hj1.I("Couldn't jump to first Ifd: ", i4));
            }
            return;
        }
        StringBuilder i0 = hj1.i0("Invalid start code: ");
        i0.append(Integer.toHexString(readUnsignedShort));
        throw new IOException(i0.toString());
    }

    public final ByteOrder o(a aVar) throws IOException {
        short readShort = aVar.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        StringBuilder i0 = hj1.i0("Invalid byte order: ");
        i0.append(Integer.toHexString(readShort));
        throw new IOException(i0.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a8, code lost:
        if (r6 <= 2147483647L) goto L_0x00af;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void p(defpackage.je.a r24, int r25) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 657
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je.p(je$a, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
        if (java.util.Arrays.equals(r1, defpackage.je.p) != false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0068, code lost:
        if (java.util.Arrays.equals(r1, r5) != false) goto L_0x006c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(defpackage.je.a r12) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 208
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je.q(je$a):void");
    }

    public final void r(int i2, int i3) throws IOException {
        if (!this.d[i2].isEmpty() && !this.d[i3].isEmpty()) {
            b bVar = this.d[i2].get("ImageLength");
            b bVar2 = this.d[i2].get("ImageWidth");
            b bVar3 = this.d[i3].get("ImageLength");
            b bVar4 = this.d[i3].get("ImageWidth");
            if (bVar != null && bVar2 != null && bVar3 != null && bVar4 != null) {
                int f2 = bVar.f(this.f);
                int f3 = bVar2.f(this.f);
                int f4 = bVar3.f(this.f);
                int f5 = bVar4.f(this.f);
                if (f2 < f4 && f3 < f5) {
                    HashMap<String, b>[] hashMapArr = this.d;
                    HashMap<String, b> hashMap = hashMapArr[i2];
                    hashMapArr[i2] = hashMapArr[i3];
                    hashMapArr[i3] = hashMap;
                }
            }
        }
    }

    public final void s(a aVar, int i2) throws IOException {
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4 = this.d[i2].get("DefaultCropSize");
        b bVar5 = this.d[i2].get("SensorTopBorder");
        b bVar6 = this.d[i2].get("SensorLeftBorder");
        b bVar7 = this.d[i2].get("SensorBottomBorder");
        b bVar8 = this.d[i2].get("SensorRightBorder");
        if (bVar4 != null) {
            if (bVar4.f1908a == 5) {
                d[] dVarArr = (d[]) bVar4.h(this.f);
                if (dVarArr == null || dVarArr.length != 2) {
                    Arrays.toString(dVarArr);
                    return;
                } else {
                    bVar3 = b.c(dVarArr[0], this.f);
                    bVar2 = b.c(dVarArr[1], this.f);
                }
            } else {
                int[] iArr = (int[]) bVar4.h(this.f);
                if (iArr == null || iArr.length != 2) {
                    Arrays.toString(iArr);
                    return;
                } else {
                    bVar3 = b.d(iArr[0], this.f);
                    bVar2 = b.d(iArr[1], this.f);
                }
            }
            this.d[i2].put("ImageWidth", bVar3);
            this.d[i2].put("ImageLength", bVar2);
        } else if (bVar5 == null || bVar6 == null || bVar7 == null || bVar8 == null) {
            b bVar9 = this.d[i2].get("ImageLength");
            b bVar10 = this.d[i2].get("ImageWidth");
            if ((bVar9 == null || bVar10 == null) && (bVar = this.d[i2].get("JPEGInterchangeFormat")) != null) {
                e(aVar, bVar.f(this.f), i2);
            }
        } else {
            int f2 = bVar5.f(this.f);
            int f3 = bVar7.f(this.f);
            int f4 = bVar8.f(this.f);
            int f5 = bVar6.f(this.f);
            if (f3 > f2 && f4 > f5) {
                b d2 = b.d(f3 - f2, this.f);
                b d3 = b.d(f4 - f5, this.f);
                this.d[i2].put("ImageLength", d2);
                this.d[i2].put("ImageWidth", d3);
            }
        }
    }

    /* renamed from: je$a */
    /* compiled from: ExifInterface */
    public static class a extends InputStream implements DataInput {
        public static final ByteOrder j = ByteOrder.LITTLE_ENDIAN;
        public static final ByteOrder k = ByteOrder.BIG_ENDIAN;
        public DataInputStream f;
        public ByteOrder g;
        public final int h;
        public int i;

        public a(InputStream inputStream) throws IOException {
            this.g = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f = dataInputStream;
            int available = dataInputStream.available();
            this.h = available;
            this.i = 0;
            this.f.mark(available);
        }

        public long a() throws IOException {
            return ((long) readInt()) & LongString.MAX_LENGTH;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f.available();
        }

        public void c(long j2) throws IOException {
            int i2 = this.i;
            if (((long) i2) > j2) {
                this.i = 0;
                this.f.reset();
                this.f.mark(this.h);
            } else {
                j2 -= (long) i2;
            }
            int i3 = (int) j2;
            if (skipBytes(i3) != i3) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.i++;
            return this.f.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.i++;
            return this.f.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            int i2 = this.i + 1;
            this.i = i2;
            if (i2 <= this.h) {
                int read = this.f.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.i += 2;
            return this.f.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i2, int i3) throws IOException {
            int i4 = this.i + i3;
            this.i = i4;
            if (i4 > this.h) {
                throw new EOFException();
            } else if (this.f.read(bArr, i2, i3) != i3) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            int i2 = this.i + 4;
            this.i = i2;
            if (i2 <= this.h) {
                int read = this.f.read();
                int read2 = this.f.read();
                int read3 = this.f.read();
                int read4 = this.f.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.g;
                    if (byteOrder == j) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == k) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    StringBuilder i0 = hj1.i0("Invalid byte order: ");
                    i0.append(this.g);
                    throw new IOException(i0.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            int i2 = this.i + 8;
            this.i = i2;
            if (i2 <= this.h) {
                int read = this.f.read();
                int read2 = this.f.read();
                int read3 = this.f.read();
                int read4 = this.f.read();
                int read5 = this.f.read();
                int read6 = this.f.read();
                int read7 = this.f.read();
                int read8 = this.f.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.g;
                    if (byteOrder == j) {
                        return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                    }
                    if (byteOrder == k) {
                        return (((long) read) << 56) + (((long) read2) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                    }
                    StringBuilder i0 = hj1.i0("Invalid byte order: ");
                    i0.append(this.g);
                    throw new IOException(i0.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            int i2 = this.i + 2;
            this.i = i2;
            if (i2 <= this.h) {
                int read = this.f.read();
                int read2 = this.f.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.g;
                    if (byteOrder == j) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == k) {
                        return (short) ((read << 8) + read2);
                    }
                    StringBuilder i0 = hj1.i0("Invalid byte order: ");
                    i0.append(this.g);
                    throw new IOException(i0.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.i += 2;
            return this.f.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.i++;
            return this.f.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            int i2 = this.i + 2;
            this.i = i2;
            if (i2 <= this.h) {
                int read = this.f.read();
                int read2 = this.f.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.g;
                    if (byteOrder == j) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == k) {
                        return (read << 8) + read2;
                    }
                    StringBuilder i0 = hj1.i0("Invalid byte order: ");
                    i0.append(this.g);
                    throw new IOException(i0.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int skipBytes(int i2) throws IOException {
            int min = Math.min(i2, this.h - this.i);
            int i3 = 0;
            while (i3 < min) {
                i3 += this.f.skipBytes(min - i3);
            }
            this.i += i3;
            return i3;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int read = this.f.read(bArr, i2, i3);
            this.i += read;
            return read;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            int length = this.i + bArr.length;
            this.i = length;
            if (length > this.h) {
                throw new EOFException();
            } else if (this.f.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public a(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr));
        }
    }

    /* renamed from: je$c */
    /* compiled from: ExifInterface */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f1909a;
        public final String b;
        public final int c;
        public final int d;

        public c(String str, int i, int i2) {
            this.b = str;
            this.f1909a = i;
            this.c = i2;
            this.d = -1;
        }

        public c(String str, int i, int i2, int i3) {
            this.b = str;
            this.f1909a = i;
            this.c = i2;
            this.d = i3;
        }
    }

    public je(InputStream inputStream) throws IOException {
        c[][] cVarArr = H;
        this.d = new HashMap[cVarArr.length];
        this.e = new HashSet(cVarArr.length);
        this.f = ByteOrder.BIG_ENDIAN;
        this.f1907a = null;
        if (inputStream instanceof AssetManager.AssetInputStream) {
            this.b = (AssetManager.AssetInputStream) inputStream;
        } else {
            this.b = null;
        }
        m(inputStream);
    }
}
