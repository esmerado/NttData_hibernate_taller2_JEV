package com.jesmeradonttdata.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * Javier Esmerado Vela - Hibernate - Taller 1.
 * 
 * Entidad de la tabla NTTDATA_HEX_CONTRACT.
 * 
 * @author jesmerad
 *
 */
@Entity
@Table(name = "NTTDATA_HEX_CONTRACT")
public class NttDataContract extends AbstractEntity implements Serializable {

	/** SERIAL VERSION */
	private static final Long serialVersionUID = 1L;

	/** Identifier - Primary Key */
	private Long contractId;

	/** Start date contract */
	private Date effectiveDate;

	/** Final date contract */
	private Date expirationDate;

	/** Monthly Price */
	private Double monthlyPrice;

	/** Relationed Client */
	private NttDataClient client;

	/**
	 * 
	 * @return the contractId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getContractId() {
		return contractId;
	}

	/**
	 * 
	 * @param contractId to set.
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	/**
	 * 
	 * @return the effective date.
	 */
	@Column(name = "EFFECTIVE_DATE", nullable = false)
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	
	/**
	 * 
	 * @param effectiveDate to set.
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * 
	 * @return the expirationDate.
	 */
	@Column(name = "EXPIRATION_DATE", nullable = false)
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * 
	 * @param expirationDate to set.
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * 
	 * @return the monthly price.
	 */
	@Column(name = "MONTHLY_PRICE", nullable = false)
	public Double getMonthlyPrice() {
		return monthlyPrice;
	}

	/**
	 * 
	 * @param monthlyPrice to set.
	 */
	public void setMonthlyPrice(Double monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLIENT_ID")
	public NttDataClient getClient() {
		return client;
	}

	/**
	 * 
	 * @param client to set.
	 */
	public void setClient(NttDataClient client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "NttDataContract [contractId=" + contractId + ", effectiveDate=" + effectiveDate + ", expirationDate="
				+ expirationDate + ", monthlyPrice=" + monthlyPrice + ", client=" + client + "]";
	}
	
	@Transient
	public Class<?> getClase() {
		return NttDataContract.class;
	}

}
