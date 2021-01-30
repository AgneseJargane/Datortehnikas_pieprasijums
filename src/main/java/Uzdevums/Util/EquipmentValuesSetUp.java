package Uzdevums.Util;

import java.util.List;

import Uzdevums.eqRequest.EqRequest;

/**
 * Izvēlnes ierakstu vērtību piešķiršanas klase
 */
public class EquipmentValuesSetUp {

	/**
	 * Uzstāda Ražotāja izvēles vērtības no key uz Value
	 * @param eqRequest Datortehnikas klase
	 * @param manufacturerList Ražotāja izvēles lauku saraksts
	 */
	public static void setManufacturerValues(EqRequest eqRequest, List<Dropdown> manufacturerList) {
		for (Dropdown manufacturer : manufacturerList) {
			if (manufacturer.Key.equals(eqRequest.getEqManufacturer())) {
				eqRequest.setEqManufacturer(manufacturer.Value);
			}
		}
	}

	/**
	 * Uzstāda Datortehnikas tipa vērtības no key uz Value
	 * @param eqRequest Datortehnikas klase
	 * @param equipmentTypeList Datortehnikas tipa izvēles lauku saraksts
	 */
	public  static void setEquipmentTypeValues(EqRequest eqRequest, List<Dropdown> equipmentTypeList) {
		for (Dropdown equipmentType : equipmentTypeList) {
			if (equipmentType.Key.equals(eqRequest.getEqName())) {
				eqRequest.setEqName(equipmentType.Value);
			}
		}
	}

	/**
	 * Uzstāda Datortehnikas procesors vērtības no key uz value
	 * @param eqRequest Datortehnikas klase
	 * @param processorList Datortehnikas procesora  izvēles  lauku saraksts
	 */
	public  static void setProcessorValues(EqRequest eqRequest, List<Dropdown> processorList) {
		for(Dropdown processor : processorList){
			if(processor.Key.equals(eqRequest.getEqProcessor())){
				eqRequest.setEqProcessor(processor.Value);
			}
		}
	}

	/**
	 * Datortehnikas operatīvās atmiņas vērtības uzstādīšana n okey uz value
	 * @param eqRequest Datortehnikas klase
	 * @param memoryList Datortehnikas operatīvās atmiņas izvēles lauku saraksts
	 */
	public static  void setMemoryValues(EqRequest eqRequest, List<Dropdown> memoryList){
		for(Dropdown memory : memoryList){
			if(memory.Key.equals(eqRequest.getEqMemory())){
				eqRequest.setEqMemory(memory.Value);
			}
		}
	}

}
