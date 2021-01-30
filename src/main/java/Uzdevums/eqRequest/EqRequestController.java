package Uzdevums.eqRequest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/eqRequest")
public class EqRequestController {
	private final EqRequestService eqRequestService;

	@Autowired
	public EqRequestController(EqRequestService eqRequestService) {
		this.eqRequestService = eqRequestService;
	}

	/**
	 * Datortehnikas ieraksta izveidošanas pieprasījums
	 *
	 * @param eqRequest Datortehnikas klase ar atribūtiem
	 * @return atgriež saglabātu ierakstu
	 */
	@RequestMapping(value = "/createEquipmentReq", method = RequestMethod.POST)
	public EqRequest createEquipmentRequest(@RequestBody EqRequest eqRequest) {
		return eqRequestService.createEquipmentRequest(eqRequest);
	}

	/**
	 * Datortehnikas pieprasījuma izvēles lauku iegūšana
	 *
	 * @return atgriež izvēles lauku vērtības
	 */
	@RequestMapping(value = "/createEquipmentList", method = RequestMethod.GET)
	public Map createEquipmentList() {
		return eqRequestService.getDropdownLists();
	}

	/**
	 * Nosaukumu maiņas pieprasījums datortehnikas parametriem no key(glabājas datubāzē) uz value
	 *
	 * @return atgriež parametru vērtības
	 */
	@RequestMapping(value = "/getEquipmentList", method = RequestMethod.GET)
	public List<EqRequest> getEquipmentList() {
		return eqRequestService.getEquipmentRequestList();
	}

	/**
	 * Ieraksta dzēšanas pieprasījums
	 *
	 * @param id ieraksta id
	 */
	@RequestMapping(value = "/deleteRequest/{id}", method = RequestMethod.DELETE)
	public void deleteRequest(@PathVariable("id") Long id) {
		eqRequestService.deleteRequest(id);
	}

	/**
	 * Statusa maiņas pieprasījums - apstiprināt
	 *
	 * @param id       ieraksta id
	 * @param approved boolean vērtība, kas nosaka vai pieprasījums(iereaksts) ir apstiprināts)
	 */
	@RequestMapping(value = "/approveRequest", method = RequestMethod.POST)
	public void approveRequest(@RequestParam("id") Long id, @RequestParam("approved") Boolean approved) {
		eqRequestService.approveRequest(id, approved);
	}

	/**
	 * Statusa maiņas pieprasījums - Noraidīt
	 *
	 * @param id     ieraksta id
	 * @param denied boolean vērtība, kas nosaka vai pieprasījums (ieraksts) ir noraidīts
	 */
	@RequestMapping(value = "/deniedRequest", method = RequestMethod.POST)
	public void deniedRequest(@RequestParam("id") Long id, @RequestParam("denied") Boolean denied) {
		eqRequestService.deniedRequest(id, denied);
	}
}
