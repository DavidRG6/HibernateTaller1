package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NttdataCliente;
import com.nttdata.hibernate.persistence.NttdataClienteDaoI;
import com.nttdata.hibernate.persistence.NttdataClienteDaoImpl;
/**
 * drg-hibernate-taller2
 *
 * @author driverog
 */
public class NttdataClienteManagementServiceImpl implements NttdataClienteManagementServiceI {

	private NttdataClienteDaoI clienteDaoI;

	public NttdataClienteManagementServiceImpl(final Session clienteDaoI) {
		super();
		this.clienteDaoI = new NttdataClienteDaoImpl(clienteDaoI);
	}

	@Override
	public void addClientes(NttdataCliente newCliente) {

		// Verificación de nulidad e inexistencia.
		if (newCliente != null && newCliente.getIdCliente() == null) {

			// Insercción del nuevo cliente.
			clienteDaoI.addClientes(newCliente);
		}
	}

	@Override
	public List<NttdataCliente> showAll() {
		// Resultado.
		List<NttdataCliente> contractsList = new ArrayList<NttdataCliente>();

		// Obtención de cliente.
		contractsList = clienteDaoI.showAll();

		return contractsList;

	}

	@Override
	public NttdataCliente showByID(Long clienteId) {
		NttdataCliente client = null;

		// Verificación de nulidad.
		if (clienteId != null) {

			// Obtención del cliente por ID.
			client = clienteDaoI.showByID(clienteId);
		}

		return client;
	}

	@Override
	public void deleteClientes(NttdataCliente deletedCliente) {

		// Verificación de nulidad y existencia.
		if (deletedCliente != null && deletedCliente.getIdCliente() != 0) {

			// Eliminación del cliente.
			clienteDaoI.deleteClientes(deletedCliente);
		}
	}

	@Override
	public void updateClientes(NttdataCliente updateClientes) {
		// Verificación de nulidad y existencia.
		if (updateClientes != null && updateClientes.getIdCliente() != 0) {

			// Actualización del cliente.
			clienteDaoI.updateClientes(updateClientes);
		}

	}

	@Override
	public NttdataCliente showbyName(String nombre, String apellido1, String apellido2) {
		NttdataCliente client = null;
		// Verificación de nulidad y existencia.
		if (nombre!=null && apellido1!=null&&apellido2!=null) {
			//obencion del cliente especifico
			client =clienteDaoI.showbyName(nombre, apellido1, apellido2);
		}
		return client ;
	}

}
