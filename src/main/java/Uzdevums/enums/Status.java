package Uzdevums.enums;
/**
 * Statusa enums glabā vērtības pieprasījuma statusam
 */
public enum Status {
	ACTIVE("Pieprasīts"), DELETED("Dzēsts"), APPROVED("Apstiprināts"), DENIED("Noraidīts");

	public String value;

	Status(String value) {
		this.value = value;
	}
}
