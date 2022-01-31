package zophop.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class TripAndArrivalInfoTuple implements Serializable, Comparable<TripAndArrivalInfoTuple> {
    private static final long serialVersionUID = 1;
    private int arrival_time;
    private String platform;
    private Trip trip;

    public static FrequencyTuple getShiftedFrequencyTuple(TripAndArrivalInfoTuple tripAndArrivalInfoTuple, FrequencyTuple frequencyTuple) {
        FrequencyTuple frequencyTuple2 = new FrequencyTuple();
        frequencyTuple2.start_time = tripAndArrivalInfoTuple.getArrival_time() + frequencyTuple.start_time;
        frequencyTuple2.end_time = tripAndArrivalInfoTuple.getArrival_time() + frequencyTuple.end_time;
        frequencyTuple2.frequency = frequencyTuple.frequency;
        return frequencyTuple2;
    }

    public static ArrayList<FrequencyTuple> getShiftedFrequencyTuples(TripAndArrivalInfoTuple tripAndArrivalInfoTuple) {
        ArrayList<FrequencyTuple> arrayList = new ArrayList<>();
        Iterator<FrequencyTuple> it = tripAndArrivalInfoTuple.getTrip().getFrequency_data_array().iterator();
        while (it.hasNext()) {
            arrayList.add(getShiftedFrequencyTuple(tripAndArrivalInfoTuple, it.next()));
        }
        return arrayList;
    }

    public static TripAndArrivalInfoTuple getTuple(TripAndArrivalInfoTuple tripAndArrivalInfoTuple) {
        TripAndArrivalInfoTuple tuple_ = getTuple_(tripAndArrivalInfoTuple);
        if (tripAndArrivalInfoTuple.getTrip().isFrequencyTrip()) {
            tuple_.trip.setFrequency_data_array(getShiftedFrequencyTuples(tripAndArrivalInfoTuple));
        }
        return tuple_;
    }

    private static TripAndArrivalInfoTuple getTuple_(TripAndArrivalInfoTuple tripAndArrivalInfoTuple) {
        TripAndArrivalInfoTuple tripAndArrivalInfoTuple2 = new TripAndArrivalInfoTuple();
        tripAndArrivalInfoTuple2.setArrival_time(tripAndArrivalInfoTuple.getArrival_time());
        tripAndArrivalInfoTuple2.setPlatform(tripAndArrivalInfoTuple.getPlatform());
        Trip trip2 = new Trip();
        trip2.setDirection_stop(tripAndArrivalInfoTuple.getTrip().getDirection_stop());
        trip2.setFirst_stop(tripAndArrivalInfoTuple.getTrip().getFirst_stop());
        trip2.setLast_stop(tripAndArrivalInfoTuple.getTrip().getLast_stop());
        trip2.setTrip_id(tripAndArrivalInfoTuple.getTrip().getTrip_id());
        trip2.setRoute_id(tripAndArrivalInfoTuple.getTrip().getRoute_id());
        trip2.setRoute_name(tripAndArrivalInfoTuple.getTrip().getRoute_name());
        trip2.setTransport_type(tripAndArrivalInfoTuple.getTrip().getTransport_type());
        trip2.setFrequencyTrip(tripAndArrivalInfoTuple.getTrip().isFrequencyTrip());
        trip2.setExtrapolated(tripAndArrivalInfoTuple.getTrip().isExtrapolated());
        trip2.setAgency_name(tripAndArrivalInfoTuple.getTrip().getAgency_name());
        trip2.setSpecial_features(tripAndArrivalInfoTuple.getTrip().getSpecial_features());
        trip2.setTt_type(tripAndArrivalInfoTuple.getTrip().getTt_type());
        trip2.setTtStatus(tripAndArrivalInfoTuple.getTrip().getTtStatus());
        trip2.setTtSid(tripAndArrivalInfoTuple.getTrip().getTtSid());
        tripAndArrivalInfoTuple2.setTrip(trip2);
        return tripAndArrivalInfoTuple2;
    }

    public int getArrival_time() {
        return this.arrival_time;
    }

    public String getPlatform() {
        return this.platform;
    }

    public Trip getTrip() {
        return this.trip;
    }

    public boolean isFrequencyTrip() {
        return this.trip.isFrequencyTrip();
    }

    public void setArrival_time(int i) {
        this.arrival_time = i;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setTrip(Trip trip2) {
        this.trip = trip2;
    }

    public int compareTo(TripAndArrivalInfoTuple tripAndArrivalInfoTuple) {
        return this.arrival_time - tripAndArrivalInfoTuple.getArrival_time();
    }

    public static TripAndArrivalInfoTuple getTuple(TripAndArrivalInfoTuple tripAndArrivalInfoTuple, FrequencyTuple frequencyTuple) {
        TripAndArrivalInfoTuple tuple_ = getTuple_(tripAndArrivalInfoTuple);
        ArrayList<FrequencyTuple> arrayList = new ArrayList<>();
        arrayList.add(frequencyTuple);
        if (tripAndArrivalInfoTuple.getTrip().isFrequencyTrip()) {
            tuple_.trip.setFrequency_data_array(arrayList);
        }
        return tuple_;
    }
}
