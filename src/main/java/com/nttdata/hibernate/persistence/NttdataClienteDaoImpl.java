package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

import com.everis.hibernate.persistence.EverisTeam;
/**
 * drg-hibernate-taller2
 *
 * @author driverog
 */
public class NttdataClienteDaoImpl implements NttdataClienteDaoI {
	private Session session;

	public NttdataClienteDaoImpl(Session session) {
		this.session = session;
	}

	@Override
	public void addClientes(final NttdataCliente paramN) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.save(paramN);
		session.flush();

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public NttdataCliente showByID(final Long id) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por ID.
		NttdataCliente result = session.get(NttdataCliente.class, id);

		return result;
	}

	@Override
	public void deleteClientes(final NttdataCliente paramN) {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.delete(paramN);

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public void updateClientes(final NttdataCliente paramN) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.saveOrUpdate(paramN);

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public List<NttdataCliente> showAll() {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda de todos los registros.
		List<NttdataCliente> list = session.createQuery("FROM NttdataCliente").list();

		return list;
	}

	@Override
	public NttdataCliente showbyName(String nombre, String apellido1, String apellido2) {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza equipo en función del nombre.
		final List<NttdataCliente> clientList = session.createQuery("FROM EverisTeam WHERE nombreCliente=" + nombre+" AND apellido1="+apellido1+" AND apellido2="+apellido2).list();

		// Resultado.
		NttdataCliente client = null;
		if (clientList != null && clientList.size() > 0) {
			client = clientList.get(0);
		}

		return client;
	}

}
