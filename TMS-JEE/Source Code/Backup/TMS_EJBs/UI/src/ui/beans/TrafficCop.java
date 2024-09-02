package ui.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlPanelGroup;

import javax.naming.InitialContext;

import javax.naming.NamingException;

import tms.business.CopEJB;

import tms.persistence.OffenseDetails;
import tms.persistence.Owners;
import tms.persistence.Registrations;
import tms.persistence.Vehicles;

import ui.beans.Clearlist;

public class TrafficCop {

    OffenseDetails offdobj = new OffenseDetails();
    String registrationId;
    String offenseId;
    String userId;
    boolean isSelected = false;
    List<OffenseDetails> offlist = new ArrayList<OffenseDetails>();
    List<Clearlist> offdlist = new ArrayList<Clearlist>();
    private List<OffenseDetails> selectedOffenses =
        new ArrayList<OffenseDetails>();

    private Owners ownereo = new Owners();
    private Vehicles veheo = new Vehicles();
    private HtmlPanelGroup content;
    private HtmlForm pop;
    private String popmsg;

    public TrafficCop() {
        super();
    }

    public void clearOff() {
        System.out.println("I am here");
        int i = 0;
        for (Clearlist ofd : offdlist) {
            if (ofd.getCheck() == true) {
                try {
                    OffenseDetails of = ofd.getOff();
                    of.setPenaltyStatus("Paid");
                    getcon().mergeOffenceDetails(of);
                    i += 1;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (i == 0) {
            popmsg = "No Offense Cleared";
        } else {
            searchUnpaidVehOffense();
            popmsg = i + " Offenses Cleared";
        }
        showPop();

    }

    public void setOffdobj(OffenseDetails offdobj) {
        this.offdobj = offdobj;
    }

    public OffenseDetails getOffdobj() {
        return offdobj;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setOffenseId(String offenseId) {
        this.offenseId = offenseId;
    }

    public String getOffenseId() {
        return offenseId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public CopEJB getcon() throws NamingException {
        InitialContext context = new InitialContext();
        CopEJB copEJB =
            (CopEJB)context.lookup("TMSEjb-Model-CopEJB#tms.business.CopEJB");
        return copEJB;

    }

    public void raise() {
        try {
            System.out.println("--------------------------------------------------------Raising an offense");
            System.out.println(getcon().findOffenceType(offenseId));
            offdobj.setOffenseTypes(getcon().findOffenceType(offenseId));
            System.out.println(getcon().findRegistration(registrationId));
            offdobj.setRegistrations(getcon().findRegistration(registrationId));
            System.out.println(getcon().findUser(userId));
            offdobj.setUsers(getcon().findUser(userId));
            System.out.println(offdobj);
            getcon().persistOffenceDetails(offdobj);
            popmsg = "Offense Raised";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("-------------------------------------------raising offense failed----------------------------------------------------------");
            popmsg = "Can't Raise Offense";
        }
        showPop();
    }

    public void setOfflist(List<OffenseDetails> offlist) {
        this.offlist = offlist;
    }

    public void searchVehOffense() {
        System.out.println("Set offense vehicle...");
        offlist = new ArrayList<OffenseDetails>();
        try {
            List<OffenseDetails> allOffList =
                getcon().getOffenceDetailsFindAll();
            for (OffenseDetails off : allOffList) {
                if (off.getRegistrations().getRegistrationId().equals(registrationId)) {
                    System.out.println("off detail in list : " + off);
                    offlist.add(off);
                }
            }
            if (offlist.size() == 0) {
                popmsg = "No Offenses Found";
                showPop();
            }
        } catch (Exception e) {
            System.out.println("Catch in getOffList");
            e.printStackTrace();
            popmsg = "No Offenses Found";
            showPop();
        }
    }

    public List<OffenseDetails> getOfflist() {
        //        System.out.println("get off details.."+offlist);
        return offlist;
    }

    public void setOwnereo(Owners ownereo) {
        this.ownereo = ownereo;
    }

    public Owners getOwnereo() {
        return ownereo;
    }

    public void ownerDetails() {
        try {
            ownereo = getcon().findRegistration(registrationId).getOwners();
            if (ownereo == null) {
                popmsg = "Owner Not Found";
                ownereo = new Owners();
                showPop();

            }
        } catch (Exception e) {
            popmsg = "Owner Not Found";
            ownereo = new Owners();
            showPop();
        }
    }

    public void setVeheo(Vehicles veheo) {
        this.veheo = veheo;
    }

    public Vehicles getVeheo() {
        return veheo;
    }

    public void vehDetails() {
        try {
            veheo = getcon().findRegistration(registrationId).getVehicles();
            if (veheo == null)
                throw new Exception();
        } catch (Exception e) {
            popmsg = "Vehicle Details Not Found";
            veheo = new Vehicles();
            showPop();
            e.printStackTrace();
        }
    }

    public Object clearOffense() throws NamingException {
        Iterator<OffenseDetails> iterator = offlist.iterator();
        int length = 0;
        while (iterator.hasNext()) {
            OffenseDetails offence = iterator.next();
            if (length < 1) {
                offence.setPenaltyStatus("Paid");
                getcon().mergeOffenceDetails(offence);
                System.out.println("Updated");
            } else {
                break;
            }
            length++;
        }
        return null;
    }

    public Object searchUnpaidVehOffense() {
        System.out.println("Search Unpaid Offense...");
        offdlist = new ArrayList<Clearlist>();
        offlist = new ArrayList<OffenseDetails>();
        try {
            List<OffenseDetails> allOffList =
                getcon().getOffenceDetailsFindAll();
            //            System.out.println("allOffense  :  " + allOffList);
            for (OffenseDetails off : allOffList) {
                //                System.out.println("All Offenses"+off);
                if (off.getRegistrations().getRegistrationId().equals(registrationId) &&
                    off.getPenaltyStatus().equalsIgnoreCase("unpaid")) {
                    System.out.println("off detail in list : " + off);

                    offlist.add(off);
                    Clearlist ofd = new Clearlist();
                    ofd.setOff(off);
                    offdlist.add(ofd);
                }
            }
        } catch (Exception e) {
            System.out.println("Catch in getOffList");
            e.printStackTrace();
        }
        if (offlist.size() == 0) {
            popmsg = "No Offenses Found";
            showPop();
        }
        return offlist;
    }


    public void setSelectedOffenses(List<OffenseDetails> selectedOffenses) {
        this.selectedOffenses = selectedOffenses;
    }

    public List<OffenseDetails> getSelectedOffenses() {
        return selectedOffenses;
    }

    public Object clearSelectedOffenses() throws NamingException {
        // Access selected offenses from `selectedOffenses` list

        // Error handling: Check if any offenses are selected before proceeding
        if (selectedOffenses.isEmpty()) {
            System.out.println("No offenses selected for clearing.");
            // Optionally, display a message to the user
            return null;
        }
        for (OffenseDetails off : offlist) {
            if (isSelected)
                selectedOffenses.add(off);
        }
        for (OffenseDetails offense : selectedOffenses) {
            // Update penalty status and persist changes
            offense.setPenaltyStatus("Paid");
            getcon().mergeOffenceDetails(offense);
            System.out.println("Offense Cleared: " + offense);
        }

        // Optionally, update `offlist` to reflect the cleared offenses (for UI consistency)
        List<OffenseDetails> updatedOfflist = new ArrayList<OffenseDetails>();
        for (OffenseDetails offense : offlist) {
            if (!selectedOffenses.contains(offense)) {
                updatedOfflist.add(offense);
            }
        }
        offlist = updatedOfflist;

        // Optionally, clear the `selectedOffenses` list for future selections
        selectedOffenses.clear();

        return null;
    }

    public void setIsSelected(boolean isSelected) {
        System.out.println("In setter.. Select = " + isSelected);
        this.isSelected = isSelected;
    }

    public boolean isIsSelected() {
        System.out.println("In getter... Select = " + isSelected);
        return isSelected;
    }

    public void setOffdlist(List<Clearlist> offdlist) {
        this.offdlist = offdlist;
    }

    public List<Clearlist> getOffdlist() {
        return offdlist;
    }


    public void setPop(HtmlForm pop) {
        this.pop = pop;
    }

    public HtmlForm getPop() {
        return pop;
    }

    public void showPop() {
        pop.setRendered(true);
        content = (HtmlPanelGroup)pop.getParent();
        content.setStyle("pointer-events:none");
    }

    public void closePop() {
        pop.setRendered(false);
        content.setStyle("pointer-events:all");
    }

    public void setPopmsg(String popmsg) {
        this.popmsg = popmsg;
    }

    public String getPopmsg() {
        return popmsg;
    }
}
