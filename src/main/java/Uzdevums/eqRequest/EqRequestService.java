package Uzdevums.eqRequest;

import static Uzdevums.Util.Dropdown.createEquipmentNameList;
import static Uzdevums.Util.Dropdown.createManufacturerList;
import static Uzdevums.Util.Dropdown.createMemoryList;
import static Uzdevums.Util.Dropdown.createProcessorList;
import static Uzdevums.Util.EquipmentValuesSetUp.setEquipmentTypeValues;
import static Uzdevums.Util.EquipmentValuesSetUp.setManufacturerValues;
import static Uzdevums.Util.EquipmentValuesSetUp.setMemoryValues;
import static Uzdevums.Util.EquipmentValuesSetUp.setProcessorValues;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Uzdevums.Util.Dropdown;
import Uzdevums.enums.Status;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EqRequestService {
	private final EqRequestRepository eqRequestRepository;
	private final EqRequestMapper eqRequestMapper;

	/**
	 * Konstruktors
	 * @param eqRequestRepository klases repozitorijs
	 * @param eqRequestMapper klases mapperis
	 */
	@Autowired
	public EqRequestService(EqRequestRepository eqRequestRepository, EqRequestMapper eqRequestMapper) {
		this.eqRequestRepository = eqRequestRepository;
		this.eqRequestMapper = eqRequestMapper;
	}

	/**
	 *  Dropdown vērtību ierakstīšana map. Tiek izveidots maps, kurš satur List ar attiecīgajām dropdown vērtībām
	 * @return atgriež map ar dropdown vērtībām
	 */
	Map getDropdownLists() {
		Map<String, List<Dropdown>> result = new HashMap<>();
		result.put("Memory", createMemoryList());
		result.put("Processor", createProcessorList());
		result.put("Manufacturer", createManufacturerList());
		result.put("EquipmentName", createEquipmentNameList());
		return result;
	}

	/**
	 * Datortehnikas pieprasījuma izveide, tiek uzsetotas  iegūtās vērtības un saglabātas DB
	 * @param eqRequest Datortehnikas klase
	 * @return  tiek atgriezta klase
	 */
	public EqRequest createEquipmentRequest(EqRequest eqRequest) {
		eqRequest.setEqName(eqRequest.getEqName());
		eqRequest.setEqManufacturer(eqRequest.getEqManufacturer());
		eqRequest.setEqProcessor(eqRequest.getEqProcessor());
		eqRequest.setEqMemory(eqRequest.getEqMemory());
		eqRequest.setEqJustification(eqRequest.getEqJustification());

		eqRequestRepository.save(eqRequest);

		return eqRequest;
	}

	/**
	 * Tiek iegūtas ierakstu izvēles lauku vērtības, datubāzē tās tiek saglabātas pēc key, šeit tiek iegūtas values ,
	 * kā arī statusam tiek nomainīts no key uz value
	 * @return atgriež ierakstu sarakstu
	 */
	public List<EqRequest> getEquipmentRequestList() {
		List<EqRequest> eqRequestList = eqRequestMapper.getEquipmentRequestList();
		List<Dropdown> eqDropdownManufacturer = createManufacturerList();
		List<Dropdown> eqDropdownEquipmentType = createEquipmentNameList();
		List<Dropdown> eqDropdownProcessor = createProcessorList();
		List<Dropdown> eqDropdownMemory = createMemoryList();
		for (EqRequest eqRequest : eqRequestList) {
			setManufacturerValues(eqRequest, eqDropdownManufacturer);
			setEquipmentTypeValues(eqRequest, eqDropdownEquipmentType);
			setProcessorValues(eqRequest, eqDropdownProcessor);
			setMemoryValues(eqRequest, eqDropdownMemory);
			setStatus(eqRequest);
		}
		return eqRequestList;
	}

	/**
	 * Uzstāda statusam vērtību
	 * @param eqRequest Datortehnikas klase
	 */
	private void setStatus(EqRequest eqRequest) {
		for (Status status : Status.values()) {
			if (eqRequest.getStatus().equals(status.name())) {
				eqRequest.setStatus(status.value);
			}
		}
	}

	/**
	 * Džēšanas pieprasījums, ieraksts netiek izdzēsts, bet tiek nomainīts tā statuss uz 'DELETED'
	 * @param id ieraksta id
	 */
	public void deleteRequest(Long id) {
		eqRequestRepository.findById(id).ifPresent(request -> {
			request.setStatus(Status.DELETED.toString());
			request.setUpdateDate(new Date());
			eqRequestRepository.save(request);
		});
	}

	/**
	 * Pieprasījuma apstiprināšana, tiek nomainīts ieraksta statuss uz 'APPROVED'
	 * @param id ieraksta id
	 * @param approve boolean vērtība lai noteiktu vai ieraksts ir apstiprināts
	 */
	void approveRequest(Long id, Boolean approve) {
		if (id != null && approve) {
			eqRequestRepository.findById(id).ifPresent(approvedRequest -> {
				approvedRequest.setStatus(Status.APPROVED.toString());
				approvedRequest.setUpdateDate(new Date());
				eqRequestRepository.save(approvedRequest);
			});
		}
	}

	/**
	 * Pieprasījuma noraidīšana, tiek nomainīts statuss uz 'DENIED'
	 * @param id ieraksta id
	 * @param denied boolean vērtība lai noteiktu, vai ieraksts ir noraidīts
	 */
	void deniedRequest(Long id, Boolean denied) {
		if (id != null && denied) {
			eqRequestRepository.findById(id).ifPresent(deniedRequest -> {
				deniedRequest.setStatus(Status.DENIED.toString());
				deniedRequest.setUpdateDate(new Date());
				eqRequestRepository.save(deniedRequest);
			});
		}
	}

}
