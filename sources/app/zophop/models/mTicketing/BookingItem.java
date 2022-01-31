package app.zophop.models.mTicketing;

import app.zophop.models.ScanPayTicket;
import app.zophop.models.mTicketing.superPass.MagicSuperPass;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPass;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass;

/* compiled from: BookingItem.kt */
public final class BookingItem implements Comparable<BookingItem> {
    private MTicket mTicket;
    private MPass magicPass;
    private MagicSuperPass magicSuperPass;
    private PendingSuperPass pendingSuperPass;
    private RideBasedSuperPass rideBasedSuperPass;
    private RideDetails rideDetails;
    private ScanPayTicket scanPayTicket;
    private SuperPassApplication superPassApplication;

    private final long getApplicableSortingTimeForPass(MPass mPass) {
        if (mPass == null) {
            return 0;
        }
        if (mPass.getBookingTime() != 0) {
            return mPass.getBookingTime();
        }
        return mPass.getStartingTime();
    }

    public final SuperPass getApplicableSuperPass() {
        SuperPass superPass = this.magicSuperPass;
        if (superPass != null) {
            n86.c(superPass);
        } else {
            superPass = this.rideBasedSuperPass;
            if (superPass != null) {
                n86.c(superPass);
            } else {
                throw new IllegalStateException("booking item doesn't contain a super pass");
            }
        }
        return superPass;
    }

    public final String getBookingId() {
        MPass mPass = this.magicPass;
        if (mPass != null) {
            n86.c(mPass);
            return mPass.getBookingPassId();
        }
        MTicket mTicket2 = this.mTicket;
        if (mTicket2 != null) {
            n86.c(mTicket2);
            return mTicket2.getMTicketId();
        }
        ScanPayTicket scanPayTicket2 = this.scanPayTicket;
        if (scanPayTicket2 != null) {
            n86.c(scanPayTicket2);
            return scanPayTicket2.get_uuid();
        }
        MagicSuperPass magicSuperPass2 = this.magicSuperPass;
        if (magicSuperPass2 != null) {
            n86.c(magicSuperPass2);
            return magicSuperPass2.getSuperPassProperties().getPassId();
        }
        RideBasedSuperPass rideBasedSuperPass2 = this.rideBasedSuperPass;
        if (rideBasedSuperPass2 == null) {
            return "";
        }
        n86.c(rideBasedSuperPass2);
        return rideBasedSuperPass2.getSuperPassProperties().getPassId();
    }

    public final BookingItemType getBookingItemType() {
        if (this.magicPass != null) {
            return BookingItemType.MAGIC_PASS;
        }
        if (this.mTicket != null) {
            return BookingItemType.MTICKET;
        }
        if (this.superPassApplication != null) {
            return BookingItemType.SUPER_PASS_APPLICATION;
        }
        if (this.magicSuperPass != null) {
            return BookingItemType.MAGIC_SUPER_PASS;
        }
        if (this.rideBasedSuperPass != null) {
            return BookingItemType.RIDE_BASED_SUPER_PASS;
        }
        if (this.pendingSuperPass != null) {
            return BookingItemType.PENDING_SUPER_PASS;
        }
        return BookingItemType.SCAN_PAY;
    }

    public final String getBookingStatus() {
        String status;
        MPass mPass = this.magicPass;
        if (mPass != null) {
            n86.c(mPass);
            String status2 = mPass.getStatus();
            n86.d(status2, "magicPass!!.status");
            return status2;
        }
        MTicket mTicket2 = this.mTicket;
        if (mTicket2 == null) {
            ScanPayTicket scanPayTicket2 = this.scanPayTicket;
            if (scanPayTicket2 != null) {
                n86.c(scanPayTicket2);
                String str = scanPayTicket2.get_status();
                n86.d(str, "scanPayTicket!!._status");
                return str;
            }
            SuperPassApplication superPassApplication2 = this.superPassApplication;
            if (superPassApplication2 != null) {
                n86.c(superPassApplication2);
                return superPassApplication2.getSuperPassApplicationStatus().name();
            }
            MagicSuperPass magicSuperPass2 = this.magicSuperPass;
            if (magicSuperPass2 != null) {
                n86.c(magicSuperPass2);
                return magicSuperPass2.getSuperPassValidationProperties().getStatus().name();
            }
            RideBasedSuperPass rideBasedSuperPass2 = this.rideBasedSuperPass;
            if (rideBasedSuperPass2 == null) {
                return "";
            }
            n86.c(rideBasedSuperPass2);
            return rideBasedSuperPass2.getSuperPassValidationProperties().getStatus().name();
        } else if (mTicket2 == null || (status = mTicket2.getStatus()) == null) {
            return "";
        } else {
            return status;
        }
    }

    public final long getBookingTime() {
        PendingSuperPass pendingSuperPass2;
        SuperPassApplication superPassApplication2;
        RideBasedSuperPass rideBasedSuperPass2;
        MagicSuperPass magicSuperPass2;
        ScanPayTicket scanPayTicket2;
        MTicket mTicket2;
        MPass mPass;
        if (BookingItemType.MAGIC_PASS == getBookingItemType() && (mPass = this.magicPass) != null) {
            return getApplicableSortingTimeForPass(mPass);
        }
        if (BookingItemType.MTICKET == getBookingItemType() && (mTicket2 = this.mTicket) != null) {
            n86.c(mTicket2);
            return mTicket2.getBookingTime();
        } else if (BookingItemType.SCAN_PAY == getBookingItemType() && (scanPayTicket2 = this.scanPayTicket) != null) {
            n86.c(scanPayTicket2);
            return scanPayTicket2.get_bookingTime();
        } else if (getBookingItemType() == BookingItemType.MAGIC_SUPER_PASS && (magicSuperPass2 = this.magicSuperPass) != null) {
            n86.c(magicSuperPass2);
            return magicSuperPass2.getSuperPassUIProperties().getBookingTime();
        } else if (getBookingItemType() == BookingItemType.RIDE_BASED_SUPER_PASS && (rideBasedSuperPass2 = this.rideBasedSuperPass) != null) {
            n86.c(rideBasedSuperPass2);
            return rideBasedSuperPass2.getSuperPassUIProperties().getBookingTime();
        } else if (getBookingItemType() == BookingItemType.SUPER_PASS_APPLICATION && (superPassApplication2 = this.superPassApplication) != null) {
            n86.c(superPassApplication2);
            return superPassApplication2.getPassStartDate();
        } else if (getBookingItemType() != BookingItemType.PENDING_SUPER_PASS || (pendingSuperPass2 = this.pendingSuperPass) == null) {
            return 0;
        } else {
            n86.c(pendingSuperPass2);
            return pendingSuperPass2.getPendingSuperPassUIProperties().getBookingTime();
        }
    }

    public final MTicket getMTicket() {
        return this.mTicket;
    }

    public final MPass getMagicPass() {
        return this.magicPass;
    }

    public final MagicSuperPass getMagicSuperPass() {
        return this.magicSuperPass;
    }

    public final PendingSuperPass getPendingSuperPass() {
        return this.pendingSuperPass;
    }

    public final RideBasedSuperPass getRideBasedSuperPass() {
        return this.rideBasedSuperPass;
    }

    public final RideDetails getRideDetails() {
        return this.rideDetails;
    }

    public final ScanPayTicket getScanPayTicket() {
        return this.scanPayTicket;
    }

    public final SuperPassApplication getSuperPassApplication() {
        return this.superPassApplication;
    }

    public final void setMTicket(MTicket mTicket2) {
        this.mTicket = mTicket2;
    }

    public final void setMagicPass(MPass mPass) {
        this.magicPass = mPass;
    }

    public final void setMagicSuperPass(MagicSuperPass magicSuperPass2) {
        this.magicSuperPass = magicSuperPass2;
    }

    public final void setPendingSuperPass(PendingSuperPass pendingSuperPass2) {
        this.pendingSuperPass = pendingSuperPass2;
    }

    public final void setRideBasedSuperPass(RideBasedSuperPass rideBasedSuperPass2) {
        this.rideBasedSuperPass = rideBasedSuperPass2;
    }

    public final void setRideDetails(RideDetails rideDetails2) {
        this.rideDetails = rideDetails2;
    }

    public final void setScanPayTicket(ScanPayTicket scanPayTicket2) {
        this.scanPayTicket = scanPayTicket2;
    }

    public final void setSuperPassApplication(SuperPassApplication superPassApplication2) {
        this.superPassApplication = superPassApplication2;
    }

    public int compareTo(BookingItem bookingItem) {
        n86.e(bookingItem, "other");
        int i = (bookingItem.getBookingTime() > getBookingTime() ? 1 : (bookingItem.getBookingTime() == getBookingTime() ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }
}
