package ui.beans;

import tms.persistence.OffenseDetails;

public class Clearlist {
    Boolean check = false;
    OffenseDetails off;

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setOff(OffenseDetails off) {
        this.off = off;
    }

    public OffenseDetails getOff() {
        return off;
    }
}
