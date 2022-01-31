package zophop.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Itinerary implements Comparable<Itinerary>, Serializable {
    public double convenience;
    public ArrayList<Fare> fares = new ArrayList<>();
    public double firstEta = -1.0d;
    public boolean inCompleteFare;
    public ArrayList<Leg> legs = new ArrayList<>();
    public int number_of_transfers;
    public double reliability;
    public double time_taken;
    public double total_fare;
    public double weight;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Itinerary itinerary = (Itinerary) obj;
        if (Double.doubleToLongBits(this.convenience) != Double.doubleToLongBits(itinerary.convenience)) {
            return false;
        }
        ArrayList<Fare> arrayList = this.fares;
        if (arrayList == null) {
            if (itinerary.fares != null) {
                return false;
            }
        } else if (!arrayList.equals(itinerary.fares)) {
            return false;
        }
        ArrayList<Leg> arrayList2 = this.legs;
        if (arrayList2 == null) {
            if (itinerary.legs != null) {
                return false;
            }
        } else if (!arrayList2.equals(itinerary.legs)) {
            return false;
        }
        return this.number_of_transfers == itinerary.number_of_transfers && Double.doubleToLongBits(this.reliability) == Double.doubleToLongBits(itinerary.reliability) && Double.doubleToLongBits(this.time_taken) == Double.doubleToLongBits(itinerary.time_taken) && Double.doubleToLongBits(this.total_fare) == Double.doubleToLongBits(itinerary.total_fare) && Double.doubleToLongBits(this.weight) == Double.doubleToLongBits(itinerary.weight);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.convenience);
        int i = (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31;
        ArrayList<Fare> arrayList = this.fares;
        int i2 = 0;
        int hashCode = (i + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<Leg> arrayList2 = this.legs;
        if (arrayList2 != null) {
            i2 = arrayList2.hashCode();
        }
        int i3 = ((hashCode + i2) * 31) + this.number_of_transfers;
        long doubleToLongBits2 = Double.doubleToLongBits(this.reliability);
        long doubleToLongBits3 = Double.doubleToLongBits(this.time_taken);
        long doubleToLongBits4 = Double.doubleToLongBits(this.total_fare);
        long doubleToLongBits5 = Double.doubleToLongBits(this.weight);
        return (((((((i3 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
    }

    public int compareTo(Itinerary itinerary) {
        return (int) (this.time_taken - itinerary.time_taken);
    }
}
