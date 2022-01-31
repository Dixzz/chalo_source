package app.zophop.models;

public class SeatInfo {
    public int seatStatus;
    public String vehicleNo;

    public SeatInfo(String str, int i) {
        this.vehicleNo = str;
        this.seatStatus = i;
    }

    public int getSeatStatus() {
        return this.seatStatus;
    }

    public String getVehicleNo() {
        return this.vehicleNo;
    }

    public void setSeatStatus(int i) {
        this.seatStatus = i;
    }

    public void setVehicleNo(String str) {
        this.vehicleNo = str;
    }
}
