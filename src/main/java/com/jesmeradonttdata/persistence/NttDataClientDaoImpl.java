package com.jesmeradonttdata.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * 
 * Javier Esmerado Vela - Hibernate - Taller 2.
 * 
 * table DAO NTTDATA_HEX_CLIENT
 * 
 * @author jesmerad
 *
 */
public class NttDataClientDaoImpl extends CommonDaoImpl<NttDataClient> implements NttDataClientDaoI {

	/** BBDD Connection sesion */
	private Session session;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param session
	 */
	public NttDataClientDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NttDataClient> searchByNameAndSurname(String name, String first_surname) {

		// Open Session verification.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Find client by name.
		final List<NttDataClient> clientsList = session.createQuery("FROM NttDataClient WHERE name='" + name + "' AND firstSurname='" + first_surname + "'").list();

		return clientsList;
	}

	@Override
	public List<NttDataClient> searchByNif(Long nif) {
		
		// Query.
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<NttDataClient> cquery = cb.createQuery(NttDataClient.class);
		final Root<NttDataClient> rootP = cquery.from(NttDataClient.class);
		
		// Where
		final Predicate pr1 = cb.le(rootP.<Long> get("nif") , nif);
		
		// Consulta
		cquery.select(rootP).where(pr1);
		
		// Execute Query.
		final List<NttDataClient> client = session.createQuery(cquery).getResultList();
		
		return client;
	}

}
