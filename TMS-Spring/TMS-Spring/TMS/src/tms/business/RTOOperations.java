package tms.business;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import tms.persistence.entities.OwnerEO;
import tms.persistence.entities.RegistrationEO;

public interface RTOOperations {

	public ResponseEntity<RegistrationEO> transferVehicle(@RequestBody RegistrationEO registrationEO, @RequestParam OwnerEO ownerEO);

	public ResponseEntity<RegistrationEO> fetchRegistrationDetails(String registrationNo) ;

	public ResponseEntity<OwnerEO> fetchOwnerById(@RequestParam String ownerId);
}
