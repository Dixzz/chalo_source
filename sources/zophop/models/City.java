package zophop.models;

import java.io.Serializable;

public enum City implements Serializable {
    AGRA,
    BHOPAL,
    BHUBANESWAR,
    INDORE,
    GUWAHATI,
    JABALPUR,
    JAIPUR,
    KANPUR,
    KOCHI,
    KOLKATA,
    MUMBAI,
    DAVANAGERE,
    LUCKNOW,
    MANGALORE,
    MATHURA,
    MEERUT,
    NAGPUR,
    CHENNAI,
    HUBLI,
    VIJAYAWADA,
    SHIMOGA,
    PRAYAGRAJ,
    PATNA,
    UDUPI,
    MANGALURU,
    BELGAUM,
    CHITRADURGA,
    AMRITSAR,
    KOTTAYAM,
    BELLARY,
    GOA;

    public static City getCity(String str) {
        City[] values = values();
        for (int i = 0; i < 31; i++) {
            City city = values[i];
            if (city.toString().toLowerCase().equals(str.toLowerCase())) {
                return city;
            }
        }
        return null;
    }

    public static boolean isValidCity(String str) {
        City[] cityArr = {KOLKATA, BHOPAL, INDORE, LUCKNOW, NAGPUR, JABALPUR, KOCHI, AGRA, MATHURA, JAIPUR, KANPUR, PRAYAGRAJ, MEERUT, PATNA, BHUBANESWAR, GUWAHATI, VIJAYAWADA, MANGALURU, CHENNAI, HUBLI, BELGAUM, UDUPI, DAVANAGERE, AMRITSAR, KOTTAYAM, BELLARY, GOA};
        for (int i = 0; i < 27; i++) {
            if (cityArr[i].toString().toLowerCase().equals(str.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
