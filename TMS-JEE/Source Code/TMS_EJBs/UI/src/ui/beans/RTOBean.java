package ui.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlForm;

import javax.faces.component.html.HtmlPanelGroup;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import tms.business.RTOEJB;
import tms.business.RTOEJBLocal;

import tms.persistence.OffenseDetails;
import tms.persistence.OffenseTypes;
import tms.persistence.Owners;
import tms.persistence.Registrations;
import tms.persistence.Vehicles;


public class RTOBean {

    private HtmlForm form1;
    private OffenseTypes offTypes = new OffenseTypes();
    private Owners owners = new Owners();
    private Vehicles vehicles = new Vehicles();
    private Registrations registrations = new Registrations();
    private boolean isVehicleAdded = false;
    private boolean isOffenseCleared = false;
    private boolean isOwnerAdded = false;
    List<OffenseTypes> allOffTypes;
    List<Owners> allOwners;
    List<Vehicles> allVehicles;
    List<OffenseDetails> unpaidOfd;
    private HtmlPanelGroup content;
    private HtmlForm pop;
    private String popmsg;

    public RTOBean() {
        System.out.println("Inside managed bean..");
        allOffTypes = getRTOEJBLocal().getOffenseTypesFindAll();
        allOwners = getRTOEJBLocal().getOwnersFindAll();
        allVehicles = getRTOEJBLocal().getVehiclesFindAll();
    }

    public RTOEJB getRTOEJBLocal() {
        System.out.println("Inside getRTOEJBLocal..");
        InitialContext ic = null;
        Object lookUpObj = null;
        try {
            ic = new InitialContext();
            lookUpObj = ic.lookup("APP-TMS-Model-RTOEJB#tms.business.RTOEJB");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        System.out.println(lookUpObj);
        return (RTOEJB)lookUpObj;
    }

    //Add offense types

    public Object addOffenseTypes() {
        try {
            if (getRTOEJBLocal().persistOffenseTypes(offTypes) != null) {
                offTypes = new OffenseTypes();
                allOffTypes = getRTOEJBLocal().getOffenseTypesFindAll();
                popmsg = "Offenses added";
                showPop();
                offTypes = new OffenseTypes();
                return "Offenses added";
            }
        } catch (Exception e) {
            popmsg = "Offense Not Added";
            showPop();
        }
        return null;
    }

    //Update offense type

    public Object updateOffensetypes() {
        try {
            offTypes = getRTOEJBLocal().mergeOffenseTypes(offTypes);
            System.out.println("Offense update..");
            allOffTypes = getRTOEJBLocal().getOffenseTypesFindAll();
            popmsg = "Offense Updated";
            offTypes = new OffenseTypes();
        } catch (Exception e) {
            popmsg = "Offense not updated";
        }
        showPop();
        return null;
    }

    //Delete offense types

    public void deleteOffenseType() {
        try {
            getRTOEJBLocal().removeOffenseTypes(offTypes);
            popmsg = "Offense Type Deleted";
            allOffTypes = getRTOEJBLocal().getOffenseTypesFindAll();
            offTypes = new OffenseTypes();
        } catch (Exception e) {
            popmsg = "Offense Type Not Deleted";
        }
        showPop();
    }

    public void setAllOffTypes(List<OffenseTypes> allOffTypes) {
        this.allOffTypes = allOffTypes;
    }

    //Find all offense types

    public List<OffenseTypes> getAllOffTypes() {
        return allOffTypes;
    }

    //Find offense type by ID

    public OffenseTypes fetchByOffenseID() {
        System.out.println("Find offense by id...");
        try {
            offTypes =
                    getRTOEJBLocal().findOffenceTypesById(offTypes.getOffenseId());
            System.out.println(offTypes);
            if (offTypes == null) {
                offTypes = new OffenseTypes();
                throw new Exception();
            }
        } catch (Exception e) {
            popmsg = "Offense Type Not Found";
            showPop();
        }
        return offTypes;
    }

    //View offense type by ID

    public List<OffenseTypes> viewByOffenseID() {
        System.out.println("View offense by id...");
        allOffTypes = new ArrayList<OffenseTypes>();
        try {
            allOffTypes.add(getRTOEJBLocal().findOffenceTypesById(offTypes.getOffenseId()));
            if (allOffTypes.size() == 0 || allOffTypes.get(0) == null) {
                throw new Exception();
            }
            System.out.println(allOffTypes);
        } catch (Exception e) {
            popmsg = "Offense Type Not Found";
            allOffTypes = getRTOEJBLocal().getOffenseTypesFindAll();
            showPop();
        }
        return allOffTypes;
    }

    //Create new owner

    public String addNewOwner() {
        System.out.println("Add owner method...");
        try {
            getRTOEJBLocal().persistOwners(owners);
            System.out.println(owners);
            isOwnerAdded = true;
            allOwners = getRTOEJBLocal().getOwnersFindAll();

            return "addveh";
        } catch (Exception e) {
            popmsg = "Owner Not Added";
            showPop();
        }
        return null;
    }

    //Update owner

    public Object updateOwner() {
        try {
            getRTOEJBLocal().mergeOwners(owners);
            popmsg = "Owner Details Updated";
            owners = new Owners();
            allOwners = getRTOEJBLocal().getOwnersFindAll();
            System.out.println("Owners update..");
        } catch (Exception e) {
            popmsg = "Owner Details Not Updated";
        }
        owners = new Owners();
        showPop();
        return null;
    }

    //Delete owner

    public Object deleteOwner() {
        try {
            getRTOEJBLocal().removeOwners(owners);
            popmsg = "Owner Deleted";
            allOwners = getRTOEJBLocal().getOwnersFindAll();
            owners = new Owners();
        } catch (Exception e) {
            popmsg = "Owner not Deleted";
        }
        owners = new Owners();
        showPop();
        return null;
    }

    public void setAllOwners(List<Owners> allOwners) {
        this.allOwners = allOwners;
    }

    //Find all owners

    public List<Owners> getAllOwners() {
        return allOwners;
    }

    //View by owner id

    public List<Owners> viewByOwnerId() {
        System.out.println("View by owner id..");
        try {
            allOwners = new ArrayList<Owners>();
            allOwners.add(getRTOEJBLocal().findOwnerByPK(owners.getOwnerId()));
            if (allOwners.size() == 0 || allOwners.get(0) == null) {
                allOwners = getRTOEJBLocal().getOwnersFindAll();
                throw new Exception();
            }
        } catch (Exception e) {
            popmsg = "Owner Not Found";
            showPop();
        }
        return allOwners;
    }

    //Find owner by ID

    public Owners fetchByOwnerID() {
        System.out.println("Find owner by id...");
        try {
            owners = getRTOEJBLocal().findOwnerByPK(owners.getOwnerId());
            if (owners == null) {
                owners = new Owners();
                throw new Exception();
            }
        } catch (Exception e) {
            popmsg = "Owner Not Found";
            showPop();
        }
        return owners;
    }

    //Create new vehicle

    public Object addNewVehicle() {
        System.out.println("Inside add vehicle..");
        getRTOEJBLocal().persistVehicles(vehicles);
        System.out.println("Vehicle added");
        allVehicles = getRTOEJBLocal().getVehiclesFindAll();
        isVehicleAdded = true;
        return null;
    }

    //Update vehicle

    public Vehicles updateVehicle() {
        try {
            getRTOEJBLocal().mergeVehicles(vehicles);
            popmsg = "Vehicle Details Updated";
            allVehicles = getRTOEJBLocal().getVehiclesFindAll();
            vehicles = new Vehicles();
            System.out.println("Vehicles update..");
            allVehicles = getRTOEJBLocal().getVehiclesFindAll();
        } catch (Exception e) {
            popmsg = "Vehicle Not Updated";
        }
        showPop();
        return null;
    }

    //Delete vehicle

    public void deleteVehicle() {
        try {
            getRTOEJBLocal().removeVehicles(vehicles);
            popmsg = "Vehicle Details Deleted";
            allVehicles = getRTOEJBLocal().getVehiclesFindAll();
            vehicles = new Vehicles();
            allVehicles = getRTOEJBLocal().getVehiclesFindAll();
        } catch (Exception e) {
            popmsg = "Vehicle Details not Deleted";
        }
        showPop();
    }

    public void setAllVehicles(List<Vehicles> allVehicles) {
        this.allVehicles = allVehicles;
    }

    //Find all vehicles

    public List<Vehicles> getAllVehicles() {
        return allVehicles;
    }

    //View by vehicle id

    public List<Vehicles> viewByVehicleId() {
        System.out.println("View by vehicle id..");
        try {
            allVehicles = new ArrayList<Vehicles>();
            allVehicles.add(getRTOEJBLocal().findVehiclesById(vehicles.getVehicleId()));
            if (allVehicles.size() == 0 || allVehicles.get(0) == null) {
                allVehicles = getRTOEJBLocal().getVehiclesFindAll();
                throw new Exception();
            }
        } catch (Exception e) {
            popmsg = "Vehicle Details Not Found";
            showPop();
        }
        return allVehicles;
    }

    //Find vehicle by ID

    public Vehicles fetchByVehicleID() {
        System.out.println("Find vehicle by id...");
        try {
            vehicles =
                    getRTOEJBLocal().findVehiclesById(vehicles.getVehicleId());
            if (vehicles == null) {
                throw new Exception();
            }
        } catch (Exception e) {
            vehicles = new Vehicles();
            popmsg = "Vehicle Details Not Found";
            showPop();
        }
        return vehicles;
    }

    public String veh() {
        Owners newowner = getRTOEJBLocal().findOwnerByPK(owners.getOwnerId());
        if (newowner != null) {
            owners = newowner;
            return "addveh";
        } else {
            popmsg = "Owner not registered";
            return null;
        }
    }

    public String reg() {
        Owners newowner = getRTOEJBLocal().findOwnerByPK(owners.getOwnerId());
        if (newowner != null) {
            owners = newowner;
            if (vehicles.getVehicleId() == null) {
                popmsg = "Vehicle not found";
                return null;
            }
            Vehicles newveh =
                getRTOEJBLocal().findVehiclesById(vehicles.getVehicleId());
            if (newveh != null) {
                vehicles = newveh;
                return "addreg";
            }
            popmsg = "Owner not registered";
        }
        return null;
    }
    //Create new registration

    public Object addNewRegistration() {
        System.out.println("Inside registrations..");
        try {

            vehicles = fetchByVehicleID();
            System.out.println("Vehicles : " + vehicles.getVehicleId());
            owners = fetchByOwnerID();
            System.out.println("Owners : " + owners.getOwnerId());
            registrations.setOwners(owners);
            registrations.setVehicles(vehicles);
            getRTOEJBLocal().persistRegistrations(registrations);
            System.out.println(registrations.getRegistrationId());
            popmsg = "Registration Successful";
        } catch (Exception e) {
            popmsg = "Registration Failed";
        }
        showPop();
        return null;
    }

    //Update registration

    public Object updateRegistration() {
        try {
            registrations.setOwners(owners);
            getRTOEJBLocal().mergeRegistrations(registrations);
            popmsg = "Vehicle Transfered";
            registrations = new Registrations();
            vehicles = new Vehicles();
            owners = new Owners();
            System.out.println("Registrations updated..");
        } catch (Exception e) {
            popmsg = "Vehicle Not Transfered";
        }
        showPop();
        return null;
    }

    //Find registration by ID

    public Registrations fetchByRegistrationID() {
        System.out.println("Find registration by id...");
        registrations =
                getRTOEJBLocal().findRegistrationsById(registrations.getRegistrationId());
        return registrations;
    }

    //Find owner and vehicle by registration id for transfer

    public Object findVehAndOwnDetails() {
        //fetching the registration details
        try {
            registrations = fetchByRegistrationID();
            //Fetching vehicle details
            vehicles = registrations.getVehicles();
            //Fetching owner details
            owners = registrations.getOwners();
            //Fetching unpaid offenses
            unpaidOfd = fetchUnpaidVehOffense();
            if (unpaidOfd == null || unpaidOfd.size() == 0)
                isOffenseCleared = true;
            else
                isOffenseCleared = false;
        } catch (Exception e) {
            registrations = new Registrations();
            popmsg = "Registration number not found";
            showPop();
        }
        return null;
    }

    //Fetch vehicle by registration id

    public Vehicles fetchVehByRegId() {
        vehicles.setVehicleId(registrations.getVehicles().getVehicleId());
        vehicles = fetchByVehicleID();
        return vehicles;
    }

    //Fetch owner by registration id

    public Owners fetchOwnByRegId() {
        registrations = fetchByRegistrationID();
        owners.setOwnerId(registrations.getOwners().getOwnerId());
        owners = fetchByOwnerID();
        return owners;
    }

    //Fetch unpaid offense

    public List<OffenseDetails> fetchUnpaidVehOffense() {
        System.out.println("Search Unpaid Offense...");
        unpaidOfd = new ArrayList<OffenseDetails>();
        List<OffenseDetails> allOffList =
            getRTOEJBLocal().getOffenseDetailsFindAll();
        //            System.out.println("allOffense  :  " + allOffList);
        for (OffenseDetails off : allOffList) {
            //                System.out.println("All Offenses"+off);
            if (off.getRegistrations().getRegistrationId().equals(registrations.getRegistrationId()) &&
                off.getPenaltyStatus().equalsIgnoreCase("unpaid")) {
                //                      System.out.println("off detail in list : " + off);
                unpaidOfd.add(off);
            }
        }
        return unpaidOfd;
    }
    //Clear Offenses

    public List<OffenseDetails> clearOffenses() {
        System.out.println("Inside clear offense");
        try {
            for (OffenseDetails ofd : unpaidOfd) {
                ofd.setPenaltyStatus("Paid");
                ofd = getRTOEJBLocal().mergeOffenseDetails(ofd);
                System.out.println(ofd.getPenaltyStatus());
            }
            popmsg = "Offenses are cleared";
            isOffenseCleared = true;
        } catch (Exception e) {
            popmsg = "Offenses are not cleared";
        }
        showPop();
        return unpaidOfd;
    }

    //Checking and navigating based on offense clearance

    public String nextPage() {
        if (isOffenseCleared || unpaidOfd.isEmpty()) {
            owners = new Owners();
            return "Success";
        }
        popmsg = "Enter Valid Registration Number";
        showPop();
        return "Failure";
    }

    //Method for clear offense

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }

    public boolean getIsVehicleAdded() {
        return isVehicleAdded;
    }

    public void setIsVehicleAdded(boolean isVehicleAdded) {
        this.isVehicleAdded = isVehicleAdded;
    }

    public void setOffTypes(OffenseTypes offTypes) {
        this.offTypes = offTypes;
    }

    public OffenseTypes getOffTypes() {
        return offTypes;
    }

    public void setOwners(Owners owners) {
        this.owners = owners;
    }

    public Owners getOwners() {
        return owners;
    }

    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }

    public Vehicles getVehicles() {
        return vehicles;
    }

    public void setRegistrations(Registrations registrations) {
        this.registrations = registrations;
    }

    public Registrations getRegistrations() {
        return registrations;
    }

    public void setIsOffenseCleared(boolean isOffenseCleared) {
        this.isOffenseCleared = isOffenseCleared;
    }

    public boolean isIsOffenseCleared() {
        return isOffenseCleared;
    }

    public String createVehicle() {
        // Add event code here...
        System.out.println("Imside create vehicle");
        try {
            getRTOEJBLocal().persistVehicles(vehicles);
            System.out.println(vehicles);
            allVehicles = getRTOEJBLocal().getVehiclesFindAll();
            return "addreg";
        } catch (Exception e) {
            popmsg = "Vehicle Details Not Added";
            showPop();
            e.printStackTrace();
        }
        return null;
    }

    public void setIsOwnerAdded(boolean isOwnerAdded) {
        this.isOwnerAdded = isOwnerAdded;
    }

    public boolean isIsOwnerAdded() {
        return isOwnerAdded;
    }

    public void setUnpaidOfd(List<OffenseDetails> unpaidOfd) {
        this.unpaidOfd = unpaidOfd;
    }

    public List<OffenseDetails> getUnpaidOfd() {
        return unpaidOfd;
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
