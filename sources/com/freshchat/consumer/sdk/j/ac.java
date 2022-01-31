package com.freshchat.consumer.sdk.j;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.LongString;
import j$.util.DesugarTimeZone;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Pattern;

public class ac {
    private static SimpleDateFormat hL;
    private static final String[] hM = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    private static final int[] hN = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    private static final byte[] hO = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final c[] hP;
    private static final c[] hQ;
    private static final c[] hR;
    private static final c[] hS;
    private static final c[] hT;
    private static final c[][] hU;
    private static final c[] hV = {new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4)};
    private static final int[] hW = {1, 2, 3};
    private static final c hX = new c("JPEGInterchangeFormat", 513, 4);
    private static final c hY = new c("JPEGInterchangeFormatLength", 514, 4);
    private static final HashMap[] hZ;
    private static final HashMap[] ia;
    private static final HashSet<String> ib = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
    private static final Charset ic;
    private static final byte[] ie;
    private static final Pattern il = Pattern.compile(".*[1-9].*");
    private static final Pattern im = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");

    /* renamed from: if  reason: not valid java name */
    private final String f2if;
    private final HashMap[] ig = new HashMap[hU.length];
    private ByteOrder ih = ByteOrder.BIG_ENDIAN;
    private boolean ii;
    private int ij;
    private int ik;

    public static class a extends ByteArrayInputStream {
        private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        private ByteOrder in = ByteOrder.BIG_ENDIAN;

        /* renamed from: io  reason: collision with root package name */
        private final long f593io;
        private long ip;

        public a(byte[] bArr) {
            super(bArr);
            this.f593io = (long) bArr.length;
            this.ip = 0;
        }

        public long eJ() {
            return this.ip;
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public void readFully(byte[] bArr) throws IOException {
            long length = this.ip + ((long) bArr.length);
            this.ip = length;
            if (length > this.f593io) {
                throw new EOFException();
            } else if (super.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public int readInt() throws IOException {
            long j = this.ip + 4;
            this.ip = j;
            if (j <= this.f593io) {
                int read = super.read();
                int read2 = super.read();
                int read3 = super.read();
                int read4 = super.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.in;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    StringBuilder i0 = hj1.i0("Invalid byte order: ");
                    i0.append(this.in);
                    throw new IOException(i0.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public long readLong() throws IOException {
            long j = this.ip + 8;
            this.ip = j;
            if (j <= this.f593io) {
                int read = super.read();
                int read2 = super.read();
                int read3 = super.read();
                int read4 = super.read();
                int read5 = super.read();
                int read6 = super.read();
                int read7 = super.read();
                int read8 = super.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.in;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (((long) read) << 56) + (((long) read2) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                    }
                    StringBuilder i0 = hj1.i0("Invalid byte order: ");
                    i0.append(this.in);
                    throw new IOException(i0.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            long j = this.ip + 2;
            this.ip = j;
            if (j <= this.f593io) {
                int read = super.read();
                int read2 = super.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.in;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (short) ((read << 8) + read2);
                    }
                    StringBuilder i0 = hj1.i0("Invalid byte order: ");
                    i0.append(this.in);
                    throw new IOException(i0.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public long readUnsignedInt() throws IOException {
            return ((long) readInt()) & LongString.MAX_LENGTH;
        }

        public int readUnsignedShort() throws IOException {
            long j = this.ip + 2;
            this.ip = j;
            if (j <= this.f593io) {
                int read = super.read();
                int read2 = super.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.in;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (read << 8) + read2;
                    }
                    StringBuilder i0 = hj1.i0("Invalid byte order: ");
                    i0.append(this.in);
                    throw new IOException(i0.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public void seek(long j) throws IOException {
            this.ip = 0;
            reset();
            if (skip(j) != j) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.in = byteOrder;
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            long skip = super.skip(Math.min(j, this.f593io - this.ip));
            this.ip += skip;
            return skip;
        }
    }

    public static class b {
        public final byte[] bytes;
        public final int format;
        public final int numberOfComponents;

        private b(int i, int i2, byte[] bArr) {
            this.format = i;
            this.numberOfComponents = i2;
            this.bytes = bArr;
        }

        public static b a(long j, ByteOrder byteOrder) {
            return a(new long[]{j}, byteOrder);
        }

        public static b a(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ac.hN[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new b(4, jArr.length, wrap.array());
        }

        public static b aD(String str) {
            byte[] bytes2 = (str + (char) 0).getBytes(ac.ic);
            return new b(2, bytes2.length, bytes2);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private Object b(ByteOrder byteOrder) {
            try {
                a aVar = new a(this.bytes);
                aVar.setByteOrder(byteOrder);
                boolean z = true;
                int i = 0;
                switch (this.format) {
                    case 1:
                    case 6:
                        byte[] bArr = this.bytes;
                        if (bArr.length != 1 || bArr[0] < 0 || bArr[0] > 1) {
                            return new String(this.bytes, ac.ic);
                        }
                        return new String(new char[]{(char) (this.bytes[0] + 48)});
                    case 2:
                    case 7:
                        if (this.numberOfComponents >= ac.hO.length) {
                            int i2 = 0;
                            while (true) {
                                if (i2 < ac.hO.length) {
                                    if (this.bytes[i2] != ac.hO[i2]) {
                                        z = false;
                                    } else {
                                        i2++;
                                    }
                                }
                            }
                            if (z) {
                                i = ac.hO.length;
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            if (i < this.numberOfComponents) {
                                byte b = this.bytes[i];
                                if (b != 0) {
                                    if (b >= 32) {
                                        sb.append((char) b);
                                    } else {
                                        sb.append('?');
                                    }
                                    i++;
                                }
                            }
                        }
                        return sb.toString();
                    case 3:
                        int[] iArr = new int[this.numberOfComponents];
                        while (i < this.numberOfComponents) {
                            iArr[i] = aVar.readUnsignedShort();
                            i++;
                        }
                        return iArr;
                    case 4:
                        long[] jArr = new long[this.numberOfComponents];
                        while (i < this.numberOfComponents) {
                            jArr[i] = aVar.readUnsignedInt();
                            i++;
                        }
                        return jArr;
                    case 5:
                        d[] dVarArr = new d[this.numberOfComponents];
                        while (i < this.numberOfComponents) {
                            dVarArr[i] = new d(aVar.readUnsignedInt(), aVar.readUnsignedInt());
                            i++;
                        }
                        return dVarArr;
                    case 8:
                        int[] iArr2 = new int[this.numberOfComponents];
                        while (i < this.numberOfComponents) {
                            iArr2[i] = aVar.readShort();
                            i++;
                        }
                        return iArr2;
                    case 9:
                        int[] iArr3 = new int[this.numberOfComponents];
                        while (i < this.numberOfComponents) {
                            iArr3[i] = aVar.readInt();
                            i++;
                        }
                        return iArr3;
                    case 10:
                        d[] dVarArr2 = new d[this.numberOfComponents];
                        while (i < this.numberOfComponents) {
                            dVarArr2[i] = new d((long) aVar.readInt(), (long) aVar.readInt());
                            i++;
                        }
                        return dVarArr2;
                    case 11:
                        double[] dArr = new double[this.numberOfComponents];
                        while (i < this.numberOfComponents) {
                            dArr[i] = (double) aVar.readFloat();
                            i++;
                        }
                        return dArr;
                    case 12:
                        double[] dArr2 = new double[this.numberOfComponents];
                        while (i < this.numberOfComponents) {
                            dArr2[i] = aVar.readDouble();
                            i++;
                        }
                        return dArr2;
                    default:
                        return null;
                }
            } catch (IOException unused) {
                return null;
            }
        }

        public double getDoubleValue(ByteOrder byteOrder) {
            Object b = b(byteOrder);
            if (b == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (b instanceof String) {
                return Double.parseDouble((String) b);
            } else {
                if (b instanceof long[]) {
                    long[] jArr = (long[]) b;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (b instanceof int[]) {
                    int[] iArr = (int[]) b;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (b instanceof double[]) {
                    double[] dArr = (double[]) b;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (b instanceof d[]) {
                    d[] dVarArr = (d[]) b;
                    if (dVarArr.length == 1) {
                        return dVarArr[0].calculate();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int getIntValue(ByteOrder byteOrder) {
            Object b = b(byteOrder);
            if (b == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (b instanceof String) {
                return Integer.parseInt((String) b);
            } else {
                if (b instanceof long[]) {
                    long[] jArr = (long[]) b;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (b instanceof int[]) {
                    int[] iArr = (int[]) b;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String getStringValue(ByteOrder byteOrder) {
            Object b = b(byteOrder);
            if (b == null) {
                return null;
            }
            if (b instanceof String) {
                return (String) b;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (b instanceof long[]) {
                long[] jArr = (long[]) b;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (b instanceof int[]) {
                int[] iArr = (int[]) b;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (b instanceof double[]) {
                double[] dArr = (double[]) b;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(b instanceof d[])) {
                return null;
            } else {
                d[] dVarArr = (d[]) b;
                while (i < dVarArr.length) {
                    sb.append(dVarArr[i].numerator);
                    sb.append('/');
                    sb.append(dVarArr[i].denominator);
                    i++;
                    if (i != dVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("(");
            i0.append(ac.hM[this.format]);
            i0.append(", data length:");
            return hj1.X(i0, this.bytes.length, ")");
        }
    }

    public static class c {
        public final String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        private c(String str, int i, int i2) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = -1;
        }

        private c(String str, int i, int i2, int i3) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = i3;
        }
    }

    public static class d {
        public final long denominator;
        public final long numerator;

        private d(long j, long j2) {
            if (j2 == 0) {
                this.numerator = 0;
                this.denominator = 1;
                return;
            }
            this.numerator = j;
            this.denominator = j2;
        }

        public double calculate() {
            return ((double) this.numerator) / ((double) this.denominator);
        }

        public String toString() {
            return this.numerator + ConnectionFactory.DEFAULT_VHOST + this.denominator;
        }
    }

    static {
        c[] cVarArr = {new c("ImageWidth", 256, 3, 4), new c("ImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", (int) AMQP.NOT_ALLOWED, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4)};
        hP = cVarArr;
        c[] cVarArr2 = {new c("ExposureTime", 33434, 5), new c("FNumber", 33437, 5), new c("ExposureProgram", 34850, 3), new c("SpectralSensitivity", 34852, 2), new c("ISOSpeedRatings", 34855, 3), new c("OECF", 34856, 7), new c("ExifVersion", 36864, 2), new c("DateTimeOriginal", 36867, 2), new c("DateTimeDigitized", 36868, 2), new c("ComponentsConfiguration", 37121, 7), new c("CompressedBitsPerPixel", 37122, 5), new c("ShutterSpeedValue", 37377, 10), new c("ApertureValue", 37378, 5), new c("BrightnessValue", 37379, 10), new c("ExposureBiasValue", 37380, 10), new c("MaxApertureValue", 37381, 5), new c("SubjectDistance", 37382, 5), new c("MeteringMode", 37383, 3), new c("LightSource", 37384, 3), new c("Flash", 37385, 3), new c("FocalLength", 37386, 5), new c("SubjectArea", 37396, 3), new c("MakerNote", 37500, 7), new c("UserComment", 37510, 7), new c("SubSecTime", 37520, 2), new c("SubSecTimeOriginal", 37521, 2), new c("SubSecTimeDigitized", 37522, 2), new c("FlashpixVersion", 40960, 7), new c("ColorSpace", 40961, 3), new c("PixelXDimension", 40962, 3, 4), new c("PixelYDimension", 40963, 3, 4), new c("RelatedSoundFile", 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c("FlashEnergy", 41483, 5), new c("SpatialFrequencyResponse", 41484, 7), new c("FocalPlaneXResolution", 41486, 5), new c("FocalPlaneYResolution", 41487, 5), new c("FocalPlaneResolutionUnit", 41488, 3), new c("SubjectLocation", 41492, 3), new c("ExposureIndex", 41493, 5), new c("SensingMethod", 41495, 3), new c("FileSource", 41728, 7), new c("SceneType", 41729, 7), new c("CFAPattern", 41730, 7), new c("CustomRendered", 41985, 3), new c("ExposureMode", 41986, 3), new c("WhiteBalance", 41987, 3), new c("DigitalZoomRatio", 41988, 5), new c("FocalLengthIn35mmFilm", 41989, 3), new c("SceneCaptureType", 41990, 3), new c("GainControl", 41991, 3), new c("Contrast", 41992, 3), new c("Saturation", 41993, 3), new c("Sharpness", 41994, 3), new c("DeviceSettingDescription", 41995, 7), new c("SubjectDistanceRange", 41996, 3), new c("ImageUniqueID", 42016, 2)};
        hQ = cVarArr2;
        c[] cVarArr3 = {new c("GPSVersionID", 0, 1), new c("GPSLatitudeRef", 1, 2), new c("GPSLatitude", 2, 5), new c("GPSLongitudeRef", 3, 2), new c("GPSLongitude", 4, 5), new c("GPSAltitudeRef", 5, 1), new c("GPSAltitude", 6, 5), new c("GPSTimeStamp", 7, 5), new c("GPSSatellites", 8, 2), new c("GPSStatus", 9, 2), new c("GPSMeasureMode", 10, 2), new c("GPSDOP", 11, 5), new c("GPSSpeedRef", 12, 2), new c("GPSSpeed", 13, 5), new c("GPSTrackRef", 14, 2), new c("GPSTrack", 15, 5), new c("GPSImgDirectionRef", 16, 2), new c("GPSImgDirection", 17, 5), new c("GPSMapDatum", 18, 2), new c("GPSDestLatitudeRef", 19, 2), new c("GPSDestLatitude", 20, 5), new c("GPSDestLongitudeRef", 21, 2), new c("GPSDestLongitude", 22, 5), new c("GPSDestBearingRef", 23, 2), new c("GPSDestBearing", 24, 5), new c("GPSDestDistanceRef", 25, 2), new c("GPSDestDistance", 26, 5), new c("GPSProcessingMethod", 27, 7), new c("GPSAreaInformation", 28, 7), new c("GPSDateStamp", 29, 2), new c("GPSDifferential", 30, 3)};
        hR = cVarArr3;
        c[] cVarArr4 = {new c("InteroperabilityIndex", 1, 2)};
        hS = cVarArr4;
        c[] cVarArr5 = {new c("ThumbnailImageWidth", 256, 3, 4), new c("ThumbnailImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", (int) AMQP.NOT_ALLOWED, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4)};
        hT = cVarArr5;
        c[][] cVarArr6 = {cVarArr, cVarArr2, cVarArr3, cVarArr4, cVarArr5};
        hU = cVarArr6;
        hZ = new HashMap[cVarArr6.length];
        ia = new HashMap[cVarArr6.length];
        Charset forName = Charset.forName("US-ASCII");
        ic = forName;
        ie = "Exif\u0000\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        hL = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            c[][] cVarArr7 = hU;
            if (i < cVarArr7.length) {
                hZ[i] = new HashMap();
                ia[i] = new HashMap();
                c[] cVarArr8 = cVarArr7[i];
                for (c cVar : cVarArr8) {
                    hZ[i].put(Integer.valueOf(cVar.number), cVar);
                    ia[i].put(cVar.name, cVar);
                }
                i++;
            } else {
                return;
            }
        }
    }

    public ac(String str) throws IOException {
        if (str != null) {
            this.f2if = str;
            eD();
            return;
        }
        throw new IllegalArgumentException("filename cannot be null");
    }

    private void a(a aVar, int i) throws IOException {
        int i2;
        int i3;
        if (aVar.eJ() + 2 <= aVar.f593io) {
            short readShort = aVar.readShort();
            if (aVar.eJ() + ((long) (readShort * 12)) <= aVar.f593io) {
                for (short s = 0; s < readShort; s = (short) (s + 1)) {
                    int readUnsignedShort = aVar.readUnsignedShort();
                    int readUnsignedShort2 = aVar.readUnsignedShort();
                    int readInt = aVar.readInt();
                    long eJ = aVar.eJ() + 4;
                    c cVar = (c) hZ[i].get(Integer.valueOf(readUnsignedShort));
                    if (cVar != null && readUnsignedShort2 > 0) {
                        int[] iArr = hN;
                        if (readUnsignedShort2 < iArr.length) {
                            int i4 = iArr[readUnsignedShort2] * readInt;
                            if (i4 > 4) {
                                long readUnsignedInt = aVar.readUnsignedInt();
                                i2 = readUnsignedShort;
                                if (((long) i4) + readUnsignedInt <= aVar.f593io) {
                                    aVar.seek(readUnsignedInt);
                                }
                            } else {
                                i2 = readUnsignedShort;
                            }
                            int t = t(i2);
                            if (t >= 0) {
                                long j = -1;
                                if (readUnsignedShort2 != 3) {
                                    if (readUnsignedShort2 == 4) {
                                        j = aVar.readUnsignedInt();
                                    } else if (readUnsignedShort2 == 8) {
                                        i3 = aVar.readShort();
                                    } else if (readUnsignedShort2 == 9) {
                                        i3 = aVar.readInt();
                                    }
                                    if (j > 0 && j < aVar.f593io) {
                                        aVar.seek(j);
                                        a(aVar, t);
                                    }
                                } else {
                                    i3 = aVar.readUnsignedShort();
                                }
                                j = (long) i3;
                                aVar.seek(j);
                                a(aVar, t);
                            } else {
                                byte[] bArr = new byte[(iArr[readUnsignedShort2] * readInt)];
                                aVar.readFully(bArr);
                                this.ig[i].put(cVar.name, new b(readUnsignedShort2, readInt, bArr));
                                if (aVar.eJ() == eJ) {
                                }
                            }
                        }
                    }
                    aVar.seek(eJ);
                }
                if (aVar.eJ() + 4 <= aVar.f593io) {
                    long readUnsignedInt2 = aVar.readUnsignedInt();
                    if (readUnsignedInt2 > 8 && readUnsignedInt2 < aVar.f593io) {
                        aVar.seek(readUnsignedInt2);
                        a(aVar, 4);
                    }
                }
            }
        }
    }

    private void a(byte[] bArr, int i) throws IOException {
        ByteOrder byteOrder;
        a aVar = new a(bArr);
        short readShort = aVar.readShort();
        if (readShort == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (readShort == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            StringBuilder i0 = hj1.i0("Invalid byte order: ");
            i0.append(Integer.toHexString(readShort));
            throw new IOException(i0.toString());
        }
        this.ih = byteOrder;
        aVar.setByteOrder(this.ih);
        int readUnsignedShort = aVar.readUnsignedShort();
        if (readUnsignedShort == 42) {
            long readUnsignedInt = aVar.readUnsignedInt();
            if (readUnsignedInt < 8 || readUnsignedInt >= ((long) bArr.length)) {
                throw new IOException(hj1.M("Invalid first Ifd offset: ", readUnsignedInt));
            }
            long j = readUnsignedInt - 8;
            if (j <= 0 || aVar.skip(j) == j) {
                a(aVar, 0);
                String attribute = getAttribute(hX.name);
                String attribute2 = getAttribute(hY.name);
                if (attribute != null && attribute2 != null) {
                    try {
                        int parseInt = Integer.parseInt(attribute);
                        int min = Math.min(Integer.parseInt(attribute2) + parseInt, bArr.length) - parseInt;
                        if (parseInt > 0 && min > 0) {
                            this.ii = true;
                            this.ij = i + parseInt;
                            this.ik = min;
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            } else {
                throw new IOException(hj1.M("Couldn't jump to first Ifd: ", j));
            }
        } else {
            StringBuilder i02 = hj1.i0("Invalid exif start: ");
            i02.append(Integer.toHexString(readUnsignedShort));
            throw new IOException(i02.toString());
        }
    }

    private b aC(String str) {
        for (int i = 0; i < hU.length; i++) {
            Object obj = this.ig[i].get(str);
            if (obj != null) {
                return (b) obj;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0052 A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00ef A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.io.InputStream r11) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 384
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.ac.b(java.io.InputStream):void");
    }

    private void eD() throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(this.f2if);
            for (int i = 0; i < hU.length; i++) {
                this.ig[i] = new HashMap();
            }
            b(fileInputStream);
        } catch (IOException unused) {
        } catch (Throwable th) {
            eE();
            throw th;
        }
        eE();
    }

    private void eE() {
        String attribute = getAttribute("DateTimeOriginal");
        if (attribute != null) {
            this.ig[0].put("DateTime", b.aD(attribute));
        }
        if (getAttribute("ImageWidth") == null) {
            this.ig[0].put("ImageWidth", b.a(0, this.ih));
        }
        if (getAttribute("ImageLength") == null) {
            this.ig[0].put("ImageLength", b.a(0, this.ih));
        }
        if (getAttribute("Orientation") == null) {
            this.ig[0].put("Orientation", b.a(0, this.ih));
        }
        if (getAttribute("LightSource") == null) {
            this.ig[1].put("LightSource", b.a(0, this.ih));
        }
    }

    private static int t(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = hW;
            if (i2 >= iArr.length) {
                return -1;
            }
            if (hV[i2].number == i) {
                return iArr[i2];
            }
            i2++;
        }
    }

    public String getAttribute(String str) {
        b aC = aC(str);
        if (aC != null) {
            if (!ib.contains(str)) {
                return aC.getStringValue(this.ih);
            }
            if (str.equals("GPSTimeStamp")) {
                int i = aC.format;
                if (i != 5 && i != 10) {
                    return null;
                }
                d[] dVarArr = (d[]) aC.b(this.ih);
                if (dVarArr.length != 3) {
                    return null;
                }
                return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) dVarArr[0].numerator) / ((float) dVarArr[0].denominator))), Integer.valueOf((int) (((float) dVarArr[1].numerator) / ((float) dVarArr[1].denominator))), Integer.valueOf((int) (((float) dVarArr[2].numerator) / ((float) dVarArr[2].denominator))));
            }
            try {
                return Double.toString(aC.getDoubleValue(this.ih));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int getAttributeInt(String str, int i) {
        b aC = aC(str);
        if (aC == null) {
            return i;
        }
        try {
            return aC.getIntValue(this.ih);
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
