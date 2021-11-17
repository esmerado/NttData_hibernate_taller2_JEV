package com.jesmeradonttdata.persistence;



import java.util.List;

import org.hibernate.Session;

public class NttDataContractDaoImpl extends CommonDaoImpl<NttDataContract> implements NttDataContractDaoI {

	/** Open BD Session */
	private Session session;

	/**
	 * 
	 * Constructor Method.
	 * 
	 * @param session
	 */
	public NttDataContractDaoImpl(Session session) {
		super(session);
		this.session = session;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NttDataContract> searchByClientId(Long clientId) {

		// Open Session verification.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Find client by name.
		final List<NttDataContract> contractList = session
				.createQuery("FROM NttDataContract WHERE client.clientID='" + clientId + "'")
				.list();

		return contractList;

	}

}
