package com.jesmeradonttdata.persistence;

import java.util.List;

/**
 * 
 * Javier Esmerado Vela - Hibernate - Taller 2.
 * 
 * table DAO NTTDATA_HEX_CONTRACT.
 * 
 * @author jesmerad
 *
 */
public interface NttDataContractDaoI extends CommonDaoI<NttDataContract> {

	/**
	 * 
	 * Seach by the client id.
	 * 
	 * @param clientId
	 * @return 
	 */
	public List<NttDataContract> searchByClientId(final Long clientId);
	
}
