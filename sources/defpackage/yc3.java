package defpackage;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import defpackage.xc3;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: yc3  reason: default package */
public class yc3<T extends xc3> extends xb3 {
    public zc3<T> g;

    public yc3(ac3 ac3, zc3<T> zc3) {
        super(ac3);
        this.g = zc3;
    }

    public final T X(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String lowerCase = xmlResourceParser.getName().toLowerCase(Locale.US);
                    if (lowerCase.equals("screenname")) {
                        String attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        String trim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(trim)) {
                            this.g.g(attributeValue, trim);
                        }
                    } else if (lowerCase.equals("string")) {
                        String attributeValue2 = xmlResourceParser.getAttributeValue(null, "name");
                        String trim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2) && trim2 != null) {
                            this.g.f(attributeValue2, trim2);
                        }
                    } else if (lowerCase.equals("bool")) {
                        String attributeValue3 = xmlResourceParser.getAttributeValue(null, "name");
                        String trim3 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(trim3)) {
                            try {
                                this.g.i(attributeValue3, Boolean.parseBoolean(trim3));
                            } catch (NumberFormatException e) {
                                r("Error parsing bool configuration value", trim3, e);
                            }
                        }
                    } else if (lowerCase.equals("integer")) {
                        String attributeValue4 = xmlResourceParser.getAttributeValue(null, "name");
                        String trim4 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue4) && !TextUtils.isEmpty(trim4)) {
                            try {
                                this.g.e(attributeValue4, Integer.parseInt(trim4));
                            } catch (NumberFormatException e2) {
                                r("Error parsing int configuration value", trim4, e2);
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException | XmlPullParserException e3) {
            L("Error parsing tracker configuration file", e3);
        }
        return this.g.c();
    }

    public final T Z(int i) {
        try {
            return X(this.f.b.getResources().getXml(i));
        } catch (Resources.NotFoundException e) {
            J("inflate() called with unknown resourceId", e);
            return null;
        }
    }
}
