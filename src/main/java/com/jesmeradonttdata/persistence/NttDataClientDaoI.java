package com.jesmeradonttdata.persistence;

import java.util.List;

/**
 * 
 * Javier Esmerado Vela - Hibernate - Taller 2.
 * 
 * table DAO NTTDATA_HEX_CLIENT.
 * 
 * @author jesmerad
 *
 */
public interface NttDataClientDaoI extends CommonDaoI<NttDataClient> {
	
	
	/**
	 * 
	 * Seach client by name and surname.
	 * 
	 * @param name
	 * @return
	 */
	public List<NttDataClient> searchByNameAndSurname(final String name, final String surname);
	
	/**
	 * 
	 * Search client by nif.
	 * 
	 * @param nif
	 * @return
	 */
	public List<NttDataClient> searchByNif(final Long nif);

}
