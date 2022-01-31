package com.freshchat.consumer.sdk.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.util.Base64;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.perf.util.Constants;
import com.rabbitmq.client.StringRpcServer;
import com.razorpay.AnalyticsConstants;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class h implements SharedPreferences {
    private static SharedPreferences cH = null;
    private static byte[] cI = null;
    private static boolean cJ = false;
    private static int fB;

    public static class a implements SharedPreferences.Editor {
        private SharedPreferences.Editor dQ;

        private a() {
            this.dQ = h.cH.edit();
        }

        @TargetApi(9)
        public void apply() {
            this.dQ.apply();
        }

        public SharedPreferences.Editor clear() {
            this.dQ.clear();
            return this;
        }

        public boolean commit() {
            return this.dQ.commit();
        }

        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.dQ.putString(h.M(str), h.M(Boolean.toString(z)));
            return this;
        }

        public SharedPreferences.Editor putFloat(String str, float f) {
            this.dQ.putString(h.M(str), h.M(Float.toString(f)));
            return this;
        }

        public SharedPreferences.Editor putInt(String str, int i) {
            this.dQ.putString(h.M(str), h.M(Integer.toString(i)));
            return this;
        }

        public SharedPreferences.Editor putLong(String str, long j) {
            this.dQ.putString(h.M(str), h.M(Long.toString(j)));
            return this;
        }

        public SharedPreferences.Editor putString(String str, String str2) {
            this.dQ.putString(h.M(str), h.M(str2));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @TargetApi(11)
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            HashSet hashSet = new HashSet(set.size());
            for (String str2 : set) {
                hashSet.add(h.M(str2));
            }
            this.dQ.putStringSet(h.M(str), hashSet);
            return this;
        }

        public SharedPreferences.Editor remove(String str) {
            this.dQ.remove(h.M(str));
            return this;
        }
    }

    public h(Context context, String str) {
        if (cH == null) {
            cH = context.getSharedPreferences(str, 0);
        }
        try {
            String k = k(context);
            String string = cH.getString(k, null);
            if (string == null) {
                string = bb();
                cH.edit().putString(k, string).commit();
                ix();
            } else {
                fB = cH.getInt("PREF_ALG_VER", 1);
            }
            ai.i("FRESHCHAT", "Shared Preference encryption version " + fB);
            cI = decode(string);
        } catch (Exception e) {
            if (cJ) {
                StringBuilder i0 = hj1.i0("Error init:");
                i0.append(e.getMessage());
                ai.e("FRESHCHAT", i0.toString());
            }
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: private */
    public static String M(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        try {
            Cipher eP = eP();
            byte[] doFinal = eP.doFinal(str.getBytes(StringRpcServer.STRING_ENCODING));
            if (fB == 3) {
                doFinal = k.a(eP.getIV(), doFinal);
            }
            return encode(doFinal);
        } catch (Exception e) {
            if (cJ) {
                ai.w("FRESHCHAT", "encrypt", e);
            }
            return null;
        }
    }

    private static String N(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        try {
            byte[] decode = decode(str);
            Cipher a2 = a(decode);
            return new String(fB == 3 ? a2.doFinal(decode, 12, decode.length - 12) : a2.doFinal(decode), StringRpcServer.STRING_ENCODING);
        } catch (Exception e) {
            if (cJ) {
                ai.w("FRESHCHAT", "decrypt", e);
            }
            return null;
        }
    }

    private static Cipher a(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher iw = iw();
        int i = fB;
        if (i == 3) {
            iw.init(2, new SecretKeySpec(cI, getTransformation()), new IvParameterSpec(bArr, 0, 12));
        } else if (i == 2 || i == 4) {
            iw.init(2, new SecretKeySpec(cI, getTransformation()), new IvParameterSpec(new byte[iw.getBlockSize()]));
        } else {
            iw.init(2, new SecretKeySpec(cI, getTransformation()));
        }
        return iw;
    }

    private static SecretKey a(char[] cArr, byte[] bArr, String str, int i, int i2) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException {
        if (i == 0) {
            i = Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL;
        }
        return SecretKeyFactory.getInstance(str, "BC").generateSecret(new PBEKeySpec(cArr, bArr, i, i2));
    }

    private static String bb() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        try {
            instance.init(256, secureRandom);
        } catch (Exception unused) {
            try {
                instance.init(192, secureRandom);
            } catch (Exception unused2) {
                instance.init(128, secureRandom);
            }
        }
        return encode(instance.generateKey().getEncoded());
    }

    private static byte[] decode(String str) {
        return Base64.decode(str, 3);
    }

    private static Cipher eP() throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher iw = iw();
        int i = fB;
        if (i == 3) {
            iw.init(1, new SecretKeySpec(cI, getTransformation()), new IvParameterSpec(iv()));
        } else if (i == 2 || i == 4) {
            iw.init(1, new SecretKeySpec(cI, getTransformation()), new IvParameterSpec(new byte[iw.getBlockSize()]));
        } else {
            iw.init(1, new SecretKeySpec(cI, getTransformation()));
        }
        return iw;
    }

    private static String encode(byte[] bArr) {
        return Base64.encodeToString(bArr, 3);
    }

    private static String getTransformation() {
        return fB >= 2 ? "AES/GCM/NoPadding" : "AES";
    }

    private static byte[] iv() {
        byte[] bArr = new byte[12];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    private static Cipher iw() throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException {
        return fB >= 2 ? Cipher.getInstance(getTransformation()) : Cipher.getInstance(getTransformation(), "BC");
    }

    private void ix() {
        fB = 4;
        cH.edit().putInt("PREF_ALG_VER", 4).commit();
    }

    private static String k(Context context) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException {
        SecretKey secretKey;
        char[] charArray = context.getPackageName().toCharArray();
        byte[] bytes = l(context).getBytes();
        try {
            secretKey = a(charArray, bytes, "PBKDF2WithHmacSHA1", Constants.MAX_URL_LENGTH, 256);
        } catch (NoSuchAlgorithmException unused) {
            secretKey = a(charArray, bytes, "PBEWithMD5AndDES", Constants.MAX_URL_LENGTH, 256);
        }
        return encode(secretKey.getEncoded());
    }

    private static String l(Context context) {
        String str = null;
        try {
            str = (String) Build.class.getField("SERIAL").get(null);
        } catch (Exception unused) {
        }
        return as.isEmpty(str) ? Settings.Secure.getString(context.getContentResolver(), AnalyticsConstants.ANDROID_ID) : str;
    }

    /* renamed from: ci */
    public a edit() {
        return new a();
    }

    public boolean contains(String str) {
        return cH.contains(M(str));
    }

    public boolean eO() {
        return fB != 4;
    }

    @Override // android.content.SharedPreferences
    public Map<String, String> getAll() {
        Map<String, ?> all = cH.getAll();
        HashMap hashMap = new HashMap(all.size());
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            try {
                hashMap.put(N(entry.getKey()), N(entry.getValue().toString()));
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }

    public boolean getBoolean(String str, boolean z) {
        String string = cH.getString(M(str), null);
        if (string == null) {
            return z;
        }
        try {
            return Boolean.parseBoolean(N(string));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    public float getFloat(String str, float f) {
        String string = cH.getString(M(str), null);
        if (string == null) {
            return f;
        }
        try {
            return Float.parseFloat(N(string));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    public int getInt(String str, int i) {
        String string = cH.getString(M(str), null);
        if (string == null) {
            return i;
        }
        try {
            return Integer.parseInt(N(string));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    public long getLong(String str, long j) {
        String string = cH.getString(M(str), null);
        if (string == null) {
            return j;
        }
        try {
            return Long.parseLong(N(string));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    public String getString(String str, String str2) {
        String string = cH.getString(M(str), null);
        return string != null ? N(string) : str2;
    }

    @Override // android.content.SharedPreferences
    @TargetApi(11)
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> stringSet = cH.getStringSet(M(str), null);
        if (stringSet == null) {
            return set;
        }
        HashSet hashSet = new HashSet(stringSet.size());
        for (String str2 : stringSet) {
            hashSet.add(N(str2));
        }
        return hashSet;
    }

    public boolean jM() {
        return fB == 3;
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        cH.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        cH.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
