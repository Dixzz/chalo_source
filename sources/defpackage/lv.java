package defpackage;

import app.zophop.models.Agency;
import app.zophop.models.City;
import app.zophop.models.LineInfo;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.BookingPassInfo;
import app.zophop.models.mTicketing.BookingPassType;
import app.zophop.models.mTicketing.MagicPassInfo;
import app.zophop.models.mTicketing.PassengerType;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: lv  reason: default package */
/* compiled from: CityResponseConverter */
public class lv {
    /* JADX WARN: Type inference failed for: r0v2 */
    public List<City> a(JSONArray jSONArray) throws Exception {
        String str;
        ArrayList arrayList;
        int i;
        City city;
        ArrayList arrayList2;
        int i2;
        HashMap hashMap;
        JSONObject jSONObject;
        City city2;
        String str2;
        ArrayList arrayList3 = new ArrayList();
        boolean z = false;
        int i3 = 0;
        while (i3 < jSONArray.length()) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            String string = jSONObject2.getString("city");
            String string2 = jSONObject2.getString("city_display_name");
            JSONObject jSONObject3 = jSONObject2.getJSONObject("bound");
            JSONObject optJSONObject = jSONObject2.optJSONObject("cityCentre");
            LatLng latLng = optJSONObject != null ? new LatLng(optJSONObject.getDouble("lat"), optJSONObject.getDouble("lon")) : null;
            LatLng latLng2 = new LatLng(jSONObject3.getDouble("lat1"), jSONObject3.getDouble("lon1"));
            LatLng latLng3 = new LatLng(jSONObject3.getDouble("lat2"), jSONObject3.getDouble("lon2"));
            JSONArray jSONArray2 = jSONObject2.getJSONArray("station_type");
            JSONArray jSONArray3 = jSONObject2.getJSONArray("line_maps");
            String optString = jSONObject2.optString("bus_maps_url", null);
            ArrayList arrayList4 = new ArrayList();
            for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                arrayList4.add(TransitMode.getTransitMode(jSONArray2.getString(i4)));
            }
            String str3 = null;
            City city3 = new City(string, jSONObject2.optString("city_image_url", null), latLng2, latLng3, arrayList4, jSONObject2.optString("firebase_live_url", ut.p), jSONObject2.optBoolean("beta_mode", z), jSONObject2.optBoolean("isDisabled", z), latLng);
            city3.setDisplayName(string2);
            if (optString != null) {
                city3.setBusMapUrl(optString);
            }
            int i5 = 0;
            while (true) {
                str = "name";
                if (i5 >= jSONArray3.length()) {
                    break;
                }
                JSONObject jSONObject4 = jSONArray3.getJSONObject(i5);
                city3.addLineMap(jSONObject4.getString(str), jSONObject4.getString("url"));
                i5++;
            }
            if (jSONObject2.has("city_info")) {
                JSONObject jSONObject5 = jSONObject2.getJSONObject("city_info");
                int i6 = jSONObject5.getInt("routesAndLines");
                int i7 = jSONObject5.getInt("stops");
                int optInt = jSONObject5.optInt("liveRoutesAndLines", 0);
                city3.setRouteCount(i6);
                city3.setLiveRouteCount(optInt);
                city3.setStopsCount(i7);
            }
            if (jSONObject2.has("modes_map")) {
                HashMap hashMap2 = new HashMap();
                HashMap hashMap3 = new HashMap();
                JSONArray jSONArray4 = jSONObject2.getJSONArray("modes_map");
                int i8 = 0;
                while (i8 < jSONArray4.length()) {
                    JSONObject jSONObject6 = jSONArray4.getJSONObject(i8);
                    TransitMode transitMode = TransitMode.getTransitMode(jSONObject6.getString("mode"));
                    hashMap2.put(transitMode, jSONObject6.optString("imageUrl", str3));
                    JSONArray jSONArray5 = jSONObject6.getJSONArray("agencies");
                    ArrayList arrayList5 = new ArrayList();
                    int i9 = 0;
                    while (i9 < jSONArray5.length()) {
                        JSONObject jSONObject7 = jSONArray5.getJSONObject(i9);
                        String string3 = jSONObject7.getString("agencyName");
                        String optString2 = jSONObject7.optString("agencyLogo", str3);
                        String optString3 = jSONObject7.optString("agencyImage", str3);
                        int optInt2 = jSONObject7.optInt("priority", 0);
                        boolean optBoolean = jSONObject7.optBoolean("liveFeed", false);
                        boolean optBoolean2 = jSONObject7.optBoolean("liveDataAvailable", false);
                        boolean optBoolean3 = jSONObject7.optBoolean("mobileTicketing", false);
                        jSONObject7.optBoolean("passBooking", false);
                        jSONObject7.optBoolean("newPassBooking", false);
                        boolean optBoolean4 = jSONObject7.optBoolean("isProductAvailable", false);
                        boolean optBoolean5 = jSONObject7.optBoolean("isOnlineCardRechargeAvailable", false);
                        boolean optBoolean6 = jSONObject7.optBoolean("isScanPayAvailable", false);
                        jSONObject7.optBoolean("mTicketEnabled", false);
                        Agency agency = new Agency(string3, optString2, optBoolean, optBoolean2, optBoolean3, optBoolean4, optBoolean5);
                        agency.setAgencyUrl(optString3);
                        agency.setScanPayAvailable(optBoolean6);
                        agency.setPriority(optInt2);
                        ArrayList arrayList6 = new ArrayList();
                        if (jSONObject7.has("lines")) {
                            JSONArray jSONArray6 = jSONObject7.getJSONArray("lines");
                            int i10 = 0;
                            while (i10 < jSONArray6.length()) {
                                JSONObject jSONObject8 = jSONArray6.getJSONObject(i10);
                                arrayList6.add(new LineInfo(jSONObject8.getString(str), jSONObject8.optString("description", null), jSONObject8.optString("lineColorCode", null)));
                                i10++;
                                hashMap2 = hashMap2;
                                jSONArray6 = jSONArray6;
                                i3 = i3;
                                arrayList3 = arrayList3;
                            }
                            arrayList2 = arrayList3;
                            i2 = i3;
                            hashMap = hashMap2;
                            jSONObject = null;
                            agency.setLineInfos(arrayList6);
                        } else {
                            arrayList2 = arrayList3;
                            i2 = i3;
                            hashMap = hashMap2;
                            jSONObject = null;
                        }
                        if (jSONObject7.has("magicPass")) {
                            JSONArray jSONArray7 = jSONObject7.getJSONArray("magicPass");
                            ArrayList arrayList7 = new ArrayList();
                            for (int i11 = 0; i11 < jSONArray7.length(); i11++) {
                                JSONObject jSONObject9 = jSONArray7.getJSONObject(i11);
                                MagicPassInfo magicPassInfo = new MagicPassInfo(jSONObject9.getString(str), jSONObject9.getJSONObject("fares"), jSONObject9.has("discountedFares") ? jSONObject9.getJSONObject("discountedFares") : jSONObject, jSONObject9.has("verificationRequired") ? jSONObject9.getJSONArray("verificationRequired") : jSONObject, jSONObject9.optBoolean("isActive"), jSONObject9.optBoolean(SuperPassJsonKeys.IS_RENEWABLE));
                                if (magicPassInfo.getPassengerType() != null) {
                                    arrayList7.add(magicPassInfo);
                                }
                            }
                            agency.setMagicPassInfos(arrayList7);
                        }
                        if (jSONObject7.has("mobilePass")) {
                            JSONArray jSONArray8 = jSONObject7.getJSONArray("mobilePass");
                            ArrayList arrayList8 = new ArrayList();
                            int i12 = 0;
                            while (i12 < jSONArray8.length()) {
                                JSONObject jSONObject10 = jSONArray8.getJSONObject(i12);
                                BookingPassType fromString = BookingPassType.fromString(jSONObject10.getString("passType"));
                                int i13 = jSONObject10.getInt("punchesAllowed");
                                JSONArray jSONArray9 = jSONObject10.getJSONArray(SuperPassJsonKeys.NUM_OF_DAYS);
                                ArrayList arrayList9 = new ArrayList();
                                for (int i14 = 0; i14 < jSONArray9.length(); i14++) {
                                    arrayList9.add(Integer.valueOf(jSONArray9.getInt(i14)));
                                }
                                Collections.sort(arrayList9);
                                arrayList8.add(new BookingPassInfo(fromString, i13, arrayList9));
                                i12++;
                                jSONArray8 = jSONArray8;
                                str = str;
                                city3 = city3;
                            }
                            city2 = city3;
                            str2 = str;
                            agency.setBookingPassInfo(arrayList8);
                        } else {
                            city2 = city3;
                            str2 = str;
                        }
                        HashMap hashMap4 = new HashMap();
                        if (jSONObject7.has("passengerTypeProofs") && jSONObject7.has("magicPass")) {
                            JSONObject jSONObject11 = jSONObject7.getJSONObject("passengerTypeProofs");
                            Iterator<String> keys = jSONObject11.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                JSONArray jSONArray10 = jSONObject11.getJSONArray(next);
                                ArrayList arrayList10 = new ArrayList();
                                for (int i15 = 0; i15 < jSONArray10.length(); i15++) {
                                    if (!"NOT_REQUIRED".equalsIgnoreCase(jSONArray10.getString(i15))) {
                                        arrayList10.add(jSONArray10.getString(i15));
                                    }
                                }
                                hashMap4.put(next, arrayList10);
                                jSONObject11 = jSONObject11;
                            }
                        }
                        if (jSONObject7.has("passengerTypeProofs")) {
                            JSONObject jSONObject12 = jSONObject7.getJSONObject("passengerTypeProofs");
                            Iterator<String> keys2 = jSONObject12.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                JSONArray jSONArray11 = jSONObject12.getJSONArray(next2);
                                ArrayList arrayList11 = new ArrayList();
                                for (int i16 = 0; i16 < jSONArray11.length(); i16++) {
                                    if (!"NOT_REQUIRED".equalsIgnoreCase(jSONArray11.getString(i16))) {
                                        arrayList11.add(jSONArray11.getString(i16));
                                    }
                                }
                                hashMap4.put(next2, arrayList11);
                            }
                        }
                        agency.setPassengerTypeProofs(hashMap4);
                        HashMap hashMap5 = new HashMap();
                        if (jSONObject7.has("passengerTypeFields")) {
                            JSONObject jSONObject13 = jSONObject7.getJSONObject("passengerTypeFields");
                            Iterator<String> keys3 = jSONObject13.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                JSONArray jSONArray12 = jSONObject13.getJSONArray(next3);
                                ArrayList arrayList12 = new ArrayList();
                                for (int i17 = 0; i17 < jSONArray12.length(); i17++) {
                                    if (!jSONArray12.getString(i17).equals("NOT_REQUIRED")) {
                                        arrayList12.add(jSONArray12.getString(i17));
                                    }
                                }
                                hashMap5.put(PassengerType.fromString(next3), arrayList12);
                            }
                        }
                        agency.set_passengerTypeFields(hashMap5);
                        HashMap hashMap6 = new HashMap();
                        if (jSONObject7.has("documentGroups")) {
                            JSONObject jSONObject14 = jSONObject7.getJSONObject("documentGroups");
                            Iterator<String> keys4 = jSONObject14.keys();
                            while (keys4.hasNext()) {
                                String next4 = keys4.next();
                                JSONArray jSONArray13 = jSONObject14.getJSONArray(next4);
                                HashSet hashSet = new HashSet();
                                for (int i18 = 0; i18 < jSONArray13.length(); i18++) {
                                    hashSet.add(jSONArray13.getString(i18));
                                }
                                hashMap6.put(next4, hashSet);
                            }
                        }
                        agency.setProofDocumentGroups(hashMap6);
                        arrayList5.add(agency);
                        i9++;
                        hashMap2 = hashMap;
                        jSONArray4 = jSONArray4;
                        jSONArray5 = jSONArray5;
                        i3 = i2;
                        arrayList3 = arrayList2;
                        str = str2;
                        city3 = city2;
                        str3 = null;
                    }
                    hashMap3.put(transitMode, arrayList5);
                    i8++;
                    str3 = null;
                }
                arrayList = arrayList3;
                i = i3;
                city = city3;
                city.setModePropertiesMap(hashMap2);
                city.setModeAgencyMap(hashMap3);
            } else {
                arrayList = arrayList3;
                i = i3;
                city = city3;
            }
            arrayList.add(city == true ? 1 : 0);
            i3 = i + 1;
            arrayList3 = arrayList;
            z = false;
        }
        return arrayList3;
    }
}
