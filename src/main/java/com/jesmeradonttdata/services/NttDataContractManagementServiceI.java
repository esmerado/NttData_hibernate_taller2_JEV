package com.jesmeradonttdata.services;

import java.util.List;

import com.jesmeradonttdata.persistence.NttDataContract;

/**
 * 
 * Javier Esmerado Vela - Hibernate - Taller 2.
 * 
 * Contract Service Interface.
 * 
 * @author jesmerad
 *
 */
public interface NttDataContractManagementServiceI {

	/**
	 * 
	 * Insert a new contract.
	 * 
	 * @param newContract
	 */
	public void insertNewContract(final NttDataContract newContract);
	
	/**
	 * 
	 * Update an existing contract.
	 * 
	 * @param updatedContract
	 */
	public void updateContract(final NttDataContract updatedContract);
	
	/**
	 * 
	 * Delete and existing contract.
	 * 
	 * @param deletedContract.
	 */
	public void deleteContract(final NttDataContract deletedContract);
	
	/**
	 * 
	 * @param contractId
	 * @return a contract
	 */
	public NttDataContract searchById(final Long contractId);
	
	/**
	 * 
	 * @return List<NttDataContract> of contracts.
	 */
	public List<NttDataContract> searchAll();
	
	/**
	 * 
	 * @param clientId.
	 * @return List<NttDataContract> with a contract.
	 */
	public List<NttDataContract> searchByClientId(final Long clientId);
	
}
