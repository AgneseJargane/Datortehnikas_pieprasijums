package Uzdevums.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Izvēles parametru  sagatavošanas klase - tiek sagatavotas dropdown vērtības
 */
public class Dropdown {
	public Dropdown(String key, String value) {
		Key = key;
		Value = value;
	}

	public String Key;
	public String Value;

	/**
	 * Sagatavo Datortehnikas veida izvēli, tiek izveidots saraksts ar objektiem, kurī satu gan key, gan value
	 * @return atgriež sagatavotu  dropdown
	 */
	public static List<Dropdown> createEquipmentNameList() {
		List<Dropdown> equipmentNameList = new ArrayList<>();
		equipmentNameList.add(new Dropdown("PC", "Stacionārais dators"));
		equipmentNameList.add(new Dropdown("PORTABLE_PC", "Portatīvais dators"));
		return equipmentNameList;
	}

	/**
	 * Sagatavo Datortehnikas ražotāja izvēlni
	 * @return atgriež sagatavotu dropdown
	 */
	public static  List<Dropdown> createManufacturerList() {
		List<Dropdown> manufacturerList = new ArrayList<>();
		manufacturerList.add(new Dropdown("PC_DELL", "DELL"));
		manufacturerList.add(new Dropdown("PC_HP", "HP"));
		manufacturerList.add(new Dropdown("PC_ACER", "ACER"));
		manufacturerList.add(new Dropdown("PC_LENOVO", "LENOVO"));
		return manufacturerList;
	}

	/**
	 * Sagatavo Datortehnikas procesora izvēlni
	 * @return atgriež sagatavotu dropdown
	 */
	public static List<Dropdown> createProcessorList() {
		List<Dropdown> processorList = new ArrayList<>();
		processorList.add(new Dropdown("INTEL_I3", "Intel i3"));
		processorList.add(new Dropdown("INTEL_I5", "Intel i5"));
		processorList.add(new Dropdown("INTEL_I7", "Intel i7"));
		return processorList;
	}

	/**
	 * Sagatavo Datortehnikas operatīvāsa atmiņas izvēlni
	 * @return atgriež sagatavotu dropdown
	 */
	public static  List<Dropdown> createMemoryList() {
		List<Dropdown> memoryList = new ArrayList<>();
		memoryList.add(new Dropdown("OP_8GB", "8GB"));
		memoryList.add(new Dropdown("OP_16GB", "16GB"));
		memoryList.add(new Dropdown("OP_32GB", "32GB"));
		return memoryList;
	}
}
