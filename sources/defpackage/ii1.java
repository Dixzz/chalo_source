package defpackage;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import app.zophop.R;
import app.zophop.models.DataInfo;
import app.zophop.models.EtaInfo;
import app.zophop.models.NeighbouringStopTripInfo;
import app.zophop.models.StreamInfo;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.models.Point;
import zophop.models.ExtraTrips;
import zophop.models.FrequencyTuple;
import zophop.models.Itinerary;
import zophop.models.Leg;
import zophop.models.StationType;
import zophop.models.Stop;
import zophop.models.StopSequence;
import zophop.models.Trip;
import zophop.models.TripAndArrivalInfoTuple;

/* renamed from: ii1  reason: default package */
/* compiled from: RealTimeInfoUtil */
public class ii1 {

    /* renamed from: ii1$a */
    /* compiled from: RealTimeInfoUtil */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1519a;
        public List<i10> b;
        public List<i10> c;
        public EnumC0027a d;

        /* renamed from: ii1$a$a  reason: collision with other inner class name */
        /* compiled from: RealTimeInfoUtil */
        public enum EnumC0027a {
            SUCCESS,
            PASSED,
            NOT_ARRIVING_SOON,
            FAILURE,
            FIRST_STOP
        }
    }

    public static void a(Leg leg, ArrayList<TripAndArrivalInfoTuple> arrayList) {
        ExtraTrips extraTrips = new ExtraTrips();
        extraTrips.extraTrips = new ArrayList<>(arrayList);
        extraTrips.hasMoreTrips = true;
        leg.extraTrips = extraTrips;
    }

    public static StreamInfo b(String str, List<StreamInfo> list) {
        for (StreamInfo streamInfo : list) {
            if (streamInfo.getStreamId().equals(str)) {
                return streamInfo;
            }
        }
        return null;
    }

    public static HashSet<String> c(HashSet<String> hashSet, HashSet<String> hashSet2) {
        HashSet<String> hashSet3 = new HashSet<>();
        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (hashSet2.contains(next)) {
                hashSet3.add(next);
            }
        }
        return hashSet3;
    }

    public static String d(long j, Context context) {
        if (j < DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL) {
            return context.getString(R.string.eta_in_minute);
        }
        StringBuilder i0 = hj1.i0("In ");
        i0.append(jh1.k(j));
        return i0.toString();
    }

    public static j10 e(DataSnapshot dataSnapshot) {
        ArrayList arrayList = new ArrayList();
        for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
            String str = (String) dataSnapshot2.child("_vehicleNo").getValue();
            Integer valueOf = Integer.valueOf(((Number) dataSnapshot2.child("_eta").getValue()).intValue());
            long longValue = ((Number) dataSnapshot2.child("_timeStamp").getValue()).longValue();
            dataSnapshot2.getKey();
            if (!vn.R0(longValue, valueOf.intValue(), false)) {
                if (valueOf.intValue() == -1 || valueOf.intValue() < 0) {
                    if (valueOf.intValue() == -1 && dataSnapshot2.hasChild("_minEta") && dataSnapshot2.hasChild("_maxEta")) {
                        int intValue = ((Number) dataSnapshot2.child("_minEta").getValue()).intValue();
                        int intValue2 = ((Number) dataSnapshot2.child("_maxEta").getValue()).intValue();
                        if (intValue > 0 && intValue2 < 7200) {
                            arrayList.add(new i10(intValue, intValue2, longValue, str, longValue, false));
                        }
                    }
                } else if (valueOf.intValue() < 7200) {
                    arrayList.add(new i10(valueOf.intValue(), longValue, str, longValue, false));
                }
            }
        }
        return new j10(arrayList);
    }

    public static j10 f(DataSnapshot dataSnapshot, List<StreamInfo> list, LatLng latLng) {
        boolean z;
        long j;
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
            Integer valueOf = Integer.valueOf(((Number) dataSnapshot2.child("_eta").getValue()).intValue());
            long longValue = ((Number) dataSnapshot2.child("_timeStamp").getValue()).longValue();
            String str = (String) dataSnapshot2.child("_vehicleNo").getValue();
            String key = dataSnapshot2.getKey();
            if (!vn.R0(longValue, valueOf.intValue(), false)) {
                StreamInfo b = b(key, list);
                if (b != null) {
                    j = b.getTimeStamp();
                    z = b.isHalted();
                } else {
                    j = longValue;
                    z = false;
                }
                if (b != null) {
                    Point point = b.getPoint();
                    if (ui1.m(new LatLng(point.getLatitude(), point.getLongitude()), latLng) < 200.0d && valueOf.intValue() > 59) {
                        valueOf = 59;
                    }
                }
                if (valueOf.intValue() == -1 || valueOf.intValue() < 0) {
                    if (valueOf.intValue() == -1 && dataSnapshot2.hasChild("_minEta")) {
                        int intValue = ((Number) dataSnapshot2.child("_minEta").getValue()).intValue();
                        int intValue2 = ((Number) dataSnapshot2.child("_maxEta").getValue()).intValue();
                        if (intValue > 0 && intValue2 < 7200) {
                            arrayList.add(new i10(intValue, intValue2, longValue, str, j, z));
                        }
                    }
                } else if (valueOf.intValue() < 7200) {
                    arrayList.add(new i10(valueOf.intValue(), longValue, str, j, z));
                }
            }
        }
        return new j10(arrayList);
    }

    public static j10 g(List<DataInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            EtaInfo etaInfo = (EtaInfo) list.get(i);
            Integer valueOf = Integer.valueOf(etaInfo.get_eta());
            long j = etaInfo.get_timeStamp();
            String str = etaInfo.get_vehicleNo();
            etaInfo.get_streamId();
            if (!vn.R0(j, valueOf.intValue(), false)) {
                if (valueOf.intValue() == -1 || valueOf.intValue() < 0) {
                    if (valueOf.intValue() == -1 && etaInfo.get_minEta() != -1) {
                        int i2 = etaInfo.get_minEta();
                        int i3 = etaInfo.get_maxEta();
                        if (i2 > 0 && i3 < 7200) {
                            arrayList.add(new i10(i2, i3, j, str, j, false));
                        }
                    }
                } else if (valueOf.intValue() < 7200) {
                    arrayList.add(new i10(valueOf.intValue(), j, str, j, false));
                }
            }
        }
        return new j10(arrayList);
    }

    public static j10 h(List<DataInfo> list, List<StreamInfo> list2, LatLng latLng) {
        int i;
        boolean z;
        long j;
        EtaInfo etaInfo;
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        boolean z2 = false;
        int i2 = 0;
        while (i2 < list.size()) {
            EtaInfo etaInfo2 = (EtaInfo) list.get(i2);
            Integer valueOf = Integer.valueOf(etaInfo2.get_eta());
            long j2 = etaInfo2.get_timeStamp();
            String str = etaInfo2.get_vehicleNo();
            String str2 = etaInfo2.get_streamId();
            if (!vn.R0(j2, valueOf.intValue(), z2)) {
                StreamInfo b = b(str2, list2);
                if (b != null) {
                    long timeStamp = b.getTimeStamp();
                    z = b.isHalted();
                    j = timeStamp;
                } else {
                    j = j2;
                    z = false;
                }
                if (b != null) {
                    Point point = b.getPoint();
                    i = i2;
                    etaInfo = etaInfo2;
                    if (ui1.m(new LatLng(point.getLatitude(), point.getLongitude()), latLng) < 200.0d && valueOf.intValue() > 59) {
                        valueOf = 59;
                    }
                } else {
                    i = i2;
                    etaInfo = etaInfo2;
                }
                if (valueOf.intValue() == -1 || valueOf.intValue() < 0) {
                    if (valueOf.intValue() == -1 && etaInfo.get_minEta() != -1) {
                        int i3 = etaInfo.get_minEta();
                        int i4 = etaInfo.get_maxEta();
                        if (i3 > 0 && i4 < 7200) {
                            arrayList.add(new i10(i3, i4, j2, str, j, z));
                        }
                    }
                } else if (valueOf.intValue() < 7200) {
                    arrayList.add(new i10(valueOf.intValue(), j2, str, j, z));
                }
            } else {
                i = i2;
            }
            i2 = i + 1;
            z2 = false;
        }
        return new j10(arrayList);
    }

    public static j10 i(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String optString = jSONObject.optString(keys.next(), null);
            if (optString != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    String optString2 = jSONObject2.optString("vNo");
                    int optInt = jSONObject2.optInt("eta", -1);
                    long optLong = jSONObject2.optLong("tS", 0);
                    if (!vn.R0(optLong, optInt, false)) {
                        if (optInt == -1 || optInt < 0) {
                            if (optInt == -1 && jSONObject2.has("_minEta") && jSONObject2.has("_maxEta")) {
                                int optInt2 = jSONObject2.optInt("_minEta");
                                int optInt3 = jSONObject2.optInt("_maxEta");
                                if (optInt2 > 0 && optInt3 < 7200) {
                                    arrayList.add(new i10(optInt2, optInt3, optLong, optString2, optLong, false));
                                }
                            }
                        } else if (optInt < 7200) {
                            arrayList.add(new i10(optInt, optLong, optString2, optLong, false));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return new j10(arrayList);
    }

    public static NeighbouringStopTripInfo j() {
        return new NeighbouringStopTripInfo(Integer.MAX_VALUE, Integer.MAX_VALUE, (String) null, (String) null, -1);
    }

    public static String k(String str, String str2) {
        return hj1.T(str, ProductDiscountsObject.KEY_DELIMITER, str2);
    }

    public static NeighbouringStopTripInfo l(ArrayList<k20> arrayList, int i) {
        int m = m(arrayList, i);
        if (m < 0) {
            return j();
        }
        return (NeighbouringStopTripInfo) arrayList.get(m);
    }

    public static int m(ArrayList<k20> arrayList, int i) {
        if (arrayList == null) {
            return -1;
        }
        int i2 = 0;
        if (i == -1) {
            return 0;
        }
        int size = arrayList.size() - 1;
        if (((NeighbouringStopTripInfo) arrayList.get(size)).depTime < i) {
            if (i <= 82800) {
                return -1;
            }
            if (i <= 86400) {
                return m(arrayList, 0);
            }
            return m(arrayList, i % 86400);
        } else if (((NeighbouringStopTripInfo) arrayList.get(0)).depTime >= i) {
            return (i != 0 || ((NeighbouringStopTripInfo) arrayList.get(0)).depTime <= 3600) ? 0 : -1;
        } else {
            if (size == 1) {
                return size;
            }
            arrayList.size();
            int size2 = arrayList.size();
            int[] iArr = new int[size2];
            Iterator<k20> it = arrayList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                iArr[i3] = ((NeighbouringStopTripInfo) it.next()).depTime;
                i3++;
            }
            int i4 = size2 - 1;
            if (iArr[0] >= i) {
                return 0;
            }
            if (iArr[i4] < i) {
                return -1;
            }
            while (i2 < i4) {
                int i5 = (i2 + i4) / 2;
                if (iArr[i5] < i) {
                    int i6 = i5 + 1;
                    if (iArr[i6] >= i) {
                        return i6;
                    }
                }
                if (iArr[i5 - 1] < i && iArr[i5] >= i) {
                    return i5;
                }
                if (iArr[i5] < i) {
                    i2 = i5;
                } else {
                    i4 = i5;
                }
            }
            return -1;
        }
    }

    public static a n(StreamInfo streamInfo) {
        int originalEtaSec = streamInfo.getOriginalEtaSec();
        if (originalEtaSec > 0) {
            a aVar = new a();
            aVar.d = a.EnumC0027a.SUCCESS;
            ArrayList arrayList = new ArrayList();
            int parseInt = Integer.parseInt(Long.toString((long) originalEtaSec));
            arrayList.add(new i10(parseInt, streamInfo.getTimeStamp()));
            aVar.b = arrayList;
            aVar.f1519a = parseInt;
            return aVar;
        }
        a aVar2 = new a();
        aVar2.d = a.EnumC0027a.FAILURE;
        aVar2.f1519a = 0;
        return aVar2;
    }

    public static SpannableStringBuilder o(String str, int i, int i2, Context context) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) context.getString(R.string.every));
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(i)), 0, spannableStringBuilder.length(), 17);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(18, true), length, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(i2)), length, spannableStringBuilder.length(), 17);
        int length2 = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) " min");
        spannableStringBuilder.setSpan(vn.N(context, wg1.NOTOSANS_MEDIUM), 0, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(14, true), length2, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(i)), length2, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static Stop p(String str, Leg leg) {
        TransitMode transitMode;
        StationType stationType = leg.station_type;
        if (stationType != null) {
            transitMode = TransitMode.getTransitMode(stationType.toString());
        } else {
            transitMode = TransitMode.getTransitMode(leg.mode.toString());
        }
        return vn.m(xt.f3961a.A().e(str, transitMode));
    }

    public static Stop q(String str, StationType stationType) {
        return vn.m(xt.f3961a.A().e(str, TransitMode.getTransitMode(stationType.toString())));
    }

    public static int r(Itinerary itinerary) {
        int size = itinerary.legs.size();
        return ((itinerary.legs.get(size - 1).end_time - itinerary.legs.get(0).start_time) + 86400) % 86400;
    }

    public static Trip s(String str, ArrayList<String> arrayList, String str2, StationType stationType, int i, String str3) {
        Trip trip = new Trip();
        if (i > 0) {
            trip.setFrequencyTrip(true);
            trip.setStation_type(stationType);
            ArrayList<FrequencyTuple> arrayList2 = new ArrayList<>();
            FrequencyTuple frequencyTuple = new FrequencyTuple();
            frequencyTuple.frequency = i;
            frequencyTuple.start_time = 0;
            frequencyTuple.end_time = 86400;
            arrayList2.add(frequencyTuple);
            trip.setFrequency_data_array(arrayList2);
        } else {
            trip.setFrequencyTrip(false);
            trip.setStation_type(stationType);
        }
        ArrayList<StopSequence> arrayList3 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            StopSequence stopSequence = new StopSequence();
            stopSequence.setStop(q(next, stationType));
            stopSequence.setStop_id(next);
            stopSequence.setStop_sequence(arrayList.indexOf(next));
            arrayList3.add(stopSequence);
        }
        trip.setStopSequenceWithArrivalTime(arrayList3);
        trip.setFirst_stop(q(arrayList.get(0), stationType));
        trip.setLast_stop(q(arrayList.get(arrayList.size() - 1), stationType));
        trip.setDirection_stop(q(arrayList.get(arrayList.size() - 1), stationType));
        trip.setRoute_id(str2);
        trip.setTrip_id(str);
        trip.setRoute_name(str3);
        trip.setSpecial_features(new ArrayList<>());
        return trip;
    }

    public static boolean t(String str, int i) {
        return str.charAt(i) == '1';
    }

    public static void u(Leg leg, String str) {
        Stop p = p(str, leg);
        leg.first_stop = p;
        leg.first_stop_id = p.getStop_id();
        leg.start_place_name = leg.first_stop.getStop_name();
    }

    public static void v(Leg leg, String str) {
        Stop p = p(str, leg);
        leg.last_stop = p;
        leg.last_stop_id = p.getStop_id();
        leg.end_place_name = leg.last_stop.getStop_name();
    }
}
