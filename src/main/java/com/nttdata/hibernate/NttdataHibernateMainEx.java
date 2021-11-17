package com.nttdata.hibernate;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NttdataCliente;
import com.nttdata.hibernate.services.NttdataClienteManagementServiceI;
import com.nttdata.hibernate.services.NttdataClienteManagementServiceImpl;

/**
 * drg-hibernate-taller2
 *
 * @author driverog
 */
public class NttdataHibernateMainEx {
	/**
	 * Metodo Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final Session session = NttdataHibernateUtil.getSessionFactory().openSession();

		final NttdataClienteManagementServiceI clienteService = new NttdataClienteManagementServiceImpl(session);

		// Generacion de clientes
		final NttdataCliente cliente1 = new NttdataCliente();
		// cliente1.setIdCliente(1);
		cliente1.setNombre("Pepe");
		cliente1.setApellido1("Perez");
		cliente1.setApellido2("Perez");
		cliente1.setIdDocumento(1);

		final NttdataCliente cliente2 = new NttdataCliente();
		// cliente2.setIdCliente(2);
		cliente2.setNombre("Manuel");
		cliente2.setApellido1("Ardañez");
		cliente2.setApellido2("Perez");
		cliente2.setIdDocumento(2);

		// Añadir clientes
		clienteService.addClientes(cliente1);
		clienteService.addClientes(cliente2);

		// Update clientes
		clienteService.updateClientes(cliente1);
		clienteService.updateClientes(cliente2);

		// Ver clientes

		for (NttdataCliente list : clienteService.showAll()) {
			System.out.println(
			        list.getIdCliente() + " | " + list.getNombre() + " | " + list.getApellido1() + " | " + list.getApellido2() + " | " + list.getIdDocumento());
		}
		// Ver un Cliente en concreto
		NttdataCliente rs = clienteService.showByID(1L);
		System.out.println(rs.getIdCliente() + " | " + rs.getNombre() + " | " + rs.getApellido1() + " | " + rs.getApellido2() + " | " + rs.getIdDocumento());

		// borrar un cliente
		clienteService.deleteClientes(cliente2);

		for (NttdataCliente list : clienteService.showAll()) {
			System.out.println(
			        list.getIdCliente() + " | " + list.getNombre() + " | " + list.getApellido1() + " | " + list.getApellido2() + " | " + list.getIdDocumento());
		}

		session.close();
	}
}
