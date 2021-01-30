package Uzdevums.eqRequest;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import Uzdevums.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor()

/**
 *  Izveidota galvenā klase un nodefinēti izmantotie atribūti
 */
public class EqRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String status;

	private Date insertDate;
	private Date updateDate;
	private String eqName;
	private String eqManufacturer;
	private String eqProcessor;
	private String eqMemory;
	private String eqJustification;

	/**
	 * Pirms ieraksta ievietošanas DB tiek uzstādīts  ieraksta ievietošanas un atjaunošanas datums, kā arī statuss
	 */
	@PrePersist
	public void beforeInsert() {
		if (this.insertDate == null) {
			this.status = Status.ACTIVE.toString();
			this.insertDate = new Date();
			this.updateDate = new Date();
		}
	}

	public EqRequest() {
		super();
	}
}
