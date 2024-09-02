package tms.business.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tms.business.RTOOperations;
import tms.persistence.dao.DAO;
import tms.persistence.entities.OwnerEO;
import tms.persistence.entities.RegistrationEO;

@Controller
@RequestMapping(value = "/rto")
@CrossOrigin(origins = "http://localhost:4200")
public class RTOOperationsImpl implements RTOOperations {

	DAO<RegistrationEO, String> regDAORef = (DAO<RegistrationEO, String>) Context.getContextBean("regDAOBean");
	DAO<OwnerEO, String> ownerDAORef = (DAO<OwnerEO, String>) Context.getContextBean("ownerDAOBean");

	@Override
	@PutMapping(value = "/transfer")
	public ResponseEntity<RegistrationEO> transferVehicle(@RequestBody RegistrationEO registrationEO,
			@RequestBody OwnerEO ownerEO) {
		regDAORef.update(registrationEO);
		registrationEO = regDAORef.findByID(registrationEO.getRegistrationID());
		return ResponseEntity.ok(registrationEO);
	}

	@Override
	@GetMapping(value = "/getRegDetails")
	public ResponseEntity<RegistrationEO> fetchRegistrationDetails(@RequestParam String registrationNo) {
		return ResponseEntity.ok(regDAORef.findByID(registrationNo));
	}

	@Override
	@GetMapping(value = "/getOwnerDetals")
	public ResponseEntity<OwnerEO> fetchOwnerById(@RequestParam String ownerId) {
		return ResponseEntity.ok(ownerDAORef.findByID(ownerId));
	}

}
