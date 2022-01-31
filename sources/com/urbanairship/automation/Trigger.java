package com.urbanairship.automation;

import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.razorpay.AnalyticsConstants;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.Locale;

public class Trigger implements Parcelable, cu5 {
    public static final Parcelable.Creator<Trigger> CREATOR = new a();
    public final int f;
    public final double g;
    public final bu5 h;

    public static class a implements Parcelable.Creator<Trigger> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public Trigger createFromParcel(Parcel parcel) {
            return new Trigger(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public Trigger[] newArray(int i) {
            return new Trigger[i];
        }
    }

    public Trigger(int i, double d, bu5 bu5) {
        this.f = i;
        this.g = d;
        this.h = bu5;
    }

    public static String a(int i) {
        switch (i) {
            case 1:
                return "foreground";
            case 2:
                return ProductPromotionsObject.KEY_BACKGROUND;
            case 3:
                return "region_enter";
            case 4:
                return "region_exit";
            case 5:
                return "custom_event_count";
            case 6:
                return "custom_event_value";
            case 7:
                return AnalyticsConstants.SCREEN;
            case 8:
                return "app_init";
            case 9:
                return "active_session";
            case 10:
                return "version";
            default:
                throw new IllegalArgumentException(hj1.I("Invalid trigger type: ", i));
        }
    }

    public static Trigger c(JsonValue jsonValue) throws xt5 {
        zt5 n = jsonValue.n();
        bu5 d = n.f.containsKey("predicate") ? bu5.d(n.u("predicate")) : null;
        double c = n.u("goal").c(-1.0d);
        if (c > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            String lowerCase = n.u("type").o().toLowerCase(Locale.ROOT);
            try {
                lowerCase.hashCode();
                lowerCase.hashCode();
                int i = 1;
                char c2 = 65535;
                switch (lowerCase.hashCode()) {
                    case -1566014583:
                        if (lowerCase.equals("region_exit")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1332194002:
                        if (lowerCase.equals(ProductPromotionsObject.KEY_BACKGROUND)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1302099507:
                        if (lowerCase.equals("region_enter")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -907689876:
                        if (lowerCase.equals(AnalyticsConstants.SCREEN)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 351608024:
                        if (lowerCase.equals("version")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 1167511662:
                        if (lowerCase.equals("app_init")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 1607242588:
                        if (lowerCase.equals("custom_event_count")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 1624363966:
                        if (lowerCase.equals("custom_event_value")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 1984457027:
                        if (lowerCase.equals("foreground")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case 2075869789:
                        if (lowerCase.equals("active_session")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        i = 4;
                        break;
                    case 1:
                        i = 2;
                        break;
                    case 2:
                        i = 3;
                        break;
                    case 3:
                        i = 7;
                        break;
                    case 4:
                        i = 10;
                        break;
                    case 5:
                        i = 8;
                        break;
                    case 6:
                        i = 5;
                        break;
                    case 7:
                        i = 6;
                        break;
                    case '\b':
                        break;
                    case '\t':
                        i = 9;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid trigger type: " + lowerCase);
                }
                return new Trigger(i, c, d);
            } catch (IllegalArgumentException unused) {
                throw new xt5(hj1.S("Invalid trigger type: ", lowerCase));
            }
        } else {
            throw new xt5("Trigger goal must be defined and greater than 0.");
        }
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.f("type", a(this.f));
        return JsonValue.x(s.b("goal", this.g).e("predicate", this.h).a());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Trigger.class != obj.getClass()) {
            return false;
        }
        Trigger trigger = (Trigger) obj;
        if (this.f != trigger.f || Double.compare(trigger.g, this.g) != 0) {
            return false;
        }
        bu5 bu5 = this.h;
        bu5 bu52 = trigger.h;
        if (bu5 != null) {
            return bu5.equals(bu52);
        }
        if (bu52 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f;
        long doubleToLongBits = Double.doubleToLongBits(this.g);
        int i2 = ((i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        bu5 bu5 = this.h;
        return i2 + (bu5 != null ? bu5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Trigger{type=");
        i0.append(a(this.f));
        i0.append(", goal=");
        i0.append(this.g);
        i0.append(", predicate=");
        i0.append(this.h);
        i0.append('}');
        return i0.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f);
        parcel.writeDouble(this.g);
        bu5 bu5 = this.h;
        parcel.writeParcelable(bu5 == null ? null : bu5.b(), i);
    }

    public Trigger(Parcel parcel) {
        int i;
        bu5 bu5;
        switch (parcel.readInt()) {
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 3;
                break;
            case 4:
                i = 4;
                break;
            case 5:
                i = 5;
                break;
            case 6:
                i = 6;
                break;
            case 7:
                i = 7;
                break;
            case 8:
                i = 8;
                break;
            case 9:
                i = 9;
                break;
            case 10:
                i = 10;
                break;
            default:
                throw new IllegalStateException("Invalid trigger type from parcel.");
        }
        double readDouble = parcel.readDouble();
        JsonValue jsonValue = (JsonValue) parcel.readParcelable(JsonValue.class.getClassLoader());
        if (jsonValue != null) {
            try {
                bu5 = bu5.d(jsonValue);
            } catch (xt5 e) {
                throw new IllegalStateException("Invalid trigger predicate from parcel.", e);
            }
        } else {
            bu5 = null;
        }
        this.f = i;
        this.g = readDouble;
        this.h = bu5;
    }
}
