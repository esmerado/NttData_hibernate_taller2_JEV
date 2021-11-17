package com.jesmeradonttdata.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.jesmeradonttdata.persistence.NttDataClient;
import com.jesmeradonttdata.persistence.NttDataClientDaoImpl;
import com.jesmeradonttdata.persistence.NttDataContract;
import com.jesmeradonttdata.persistence.NttDataContractDaoImpl;

/**
 * 
 * Javier Esmerado Vela - Hibernate - Taller 2.
 * 
 * Contract Service implementation.
 * 
 * @author jesmerad
 *
 */
public class NttDataContractManagementServiceImpl implements NttDataContractManagementServiceI {

	/** DAO: NTTDATA_HEX_CONTRACT */
	private NttDataContractDaoImpl contractDao;
	
	public NttDataContractManagementServiceImpl(final Session session) {
		this.contractDao = new NttDataContractDaoImpl(session);
	}

	@Override
	public void insertNewContract(NttDataContract newContract) {

		// Check if is null and exists
		if (newContract != null && newContract.getContractId() == null) {

			// Insert contract.
			contractDao.insert(newContract);
		}

	}

	@Override
	public void updateContract(NttDataContract updatedContract) {

		// Check if is null and exists
		if (updatedContract != null && updatedContract.getContractId() != null) {

			// Updated contract.
			contractDao.update(updatedContract);
		}

	}

	@Override
	public void deleteContract(NttDataContract deletedContract) {

		// Check if is null and exists
		if (deletedContract != null && deletedContract.getContractId() != null) {

			// Remove contract.
			contractDao.delete(deletedContract);
		}

	}

	@Override
	public NttDataContract searchById(Long contractId) {

		// Result.
		NttDataContract contract = null;

		// Check if is null.
		if (contractId != null) {

			// Get the contract by id.
			contract = contractDao.searchById(contractId);

		}

		return contract;

	}

	@Override
	public List<NttDataContract> searchAll() {

		// Result.
		List<NttDataContract> contractList = new ArrayList<NttDataContract>();

		// Get contracts.
		contractList = contractDao.searchAll();

		return contractList;
	}

	@Override
	public List<NttDataContract> searchByClientId(Long clientId) {

		// Result.
		List<NttDataContract> contactList = new ArrayList<NttDataContract>();

		// Get contract.
		contactList = contractDao.searchByClientId(clientId);

		return contactList;
	}

}
