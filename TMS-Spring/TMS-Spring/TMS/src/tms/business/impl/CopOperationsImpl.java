package tms.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tms.business.CopOperations;
import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.OffenseDetailDAOImpl;
import tms.persistence.entities.OffenseDetailEO;
import tms.persistence.entities.OffenseTypeEO;
import tms.persistence.entities.OwnerEO;
import tms.persistence.entities.RegistrationEO;
import tms.persistence.entities.VehicleEO;

@Controller
@RequestMapping(value="/cop")
@CrossOrigin(origins = "http://localhost:4200")
public class CopOperationsImpl implements CopOperations {
	
	private DAO<OffenseDetailEO, String> offDetailDAORef = (DAO<OffenseDetailEO, String>) Context.getContextBean("offDetailDAOBean");
    private DAO<RegistrationEO, String> regDAORef = (DAO<RegistrationEO, String>) Context.getContextBean("regDAOBean");
    private DAO<OffenseTypeEO, String> offtypeDAORef = (DAO<OffenseTypeEO, String>) Context.getContextBean("offTypeDAOBean");

	public CopOperationsImpl() {
		super();
	}

	public CopOperationsImpl(DAO<OffenseDetailEO, String> offDetailDAORef, 
							DAO<RegistrationEO, String> regDAORef,
							DAO<OffenseTypeEO, String> offtypeDAORef) {
		super();
		this.offDetailDAORef = offDetailDAORef;
		this.regDAORef = regDAORef;
		this.offtypeDAORef = offtypeDAORef;
	}

	public DAO<OffenseDetailEO, String> getOffDetailDAORef() {
		return offDetailDAORef;
	}

	public void setOffDetailDAORef(DAO<OffenseDetailEO, String> offDetailDAORef) {
		this.offDetailDAORef = offDetailDAORef;
	}

	public DAO<RegistrationEO, String> getRegDAORef() {
		return regDAORef;
	}

	public void setRegDAORef(DAO<RegistrationEO, String> regDAORef) {
		this.regDAORef = regDAORef;
	}

	public DAO<OffenseTypeEO, String> getOfftypeDAORef() {
		return offtypeDAORef;
	}

	public void setOfftypeDAORef(DAO<OffenseTypeEO, String> offtypeDAORef) {
		this.offtypeDAORef = offtypeDAORef;
	}

	@Override
	@PostMapping(value="/raiseOffense")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> raiseOffense(@RequestBody OffenseDetailEO offDetail)  {
		// TODO Auto-generated method stub
		System.out.println("Offense details ... " + offDetail);
		return ResponseEntity.ok(offDetailDAORef.add(offDetail));
	}

	@Override
	@PutMapping(value="/clearOffenses")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> clearOffense(@RequestBody OffenseDetailEO offDetail) {
	    offDetailDAORef.update(offDetail);
	    return ResponseEntity.ok("Offenses cleared successfully!");
	}

	@Override
	@GetMapping(value="/getAllOffensesOfRegNo")
	public ResponseEntity<List<OffenseDetailEO>> fetchAllOffensesCommitedByREgNo(@RequestParam String registrationNo)  {
		// TODO Auto-generated method stub

        ArrayList<OffenseDetailEO> foundOffenses = null;
//        RegistrationEO regRef = regDAORef.findByID(registrationNo);
        if(offDetailDAORef instanceof OffenseDetailDAOImpl)
        	foundOffenses = (ArrayList<OffenseDetailEO>) ((OffenseDetailDAOImpl) offDetailDAORef).findByReg(registrationNo, null);
        
        return ResponseEntity.ok(foundOffenses);
	}

	@GetMapping(value="/getOffenses")
	@Override
	public ResponseEntity<List<OffenseDetailEO>> fetchAllOffensesCommited()  {
		// TODO Auto-generated method stub
		
        return ResponseEntity.ok(offDetailDAORef.findAll());

	}

	@Override
	@GetMapping(value="/getRegDetails")
	public ResponseEntity<RegistrationEO> fetchRegistrationDetails(@RequestParam String registrationNo)  {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(regDAORef.findByID(registrationNo));
	}

	@Override
	@GetMapping(value="/getOffenseTypes")
	public ResponseEntity<List<OffenseTypeEO>> fetchAllOffenses() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(offtypeDAORef.findAll());
	}

}
