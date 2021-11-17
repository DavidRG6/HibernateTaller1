package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * drg-hibernate-taller2
 *
 * @author driverog
 */
public interface NttdataClienteDaoI {
	/**
	 * Permite la insercion de nuevos clientes
	 * 
	 * @param paramN
	 */
	public void addClientes(NttdataCliente paramN);
	/**
	 * Muestra todos los clients que hay 
	 * 
	 * @return List<NttdataCliente>
	 */
	public List<NttdataCliente> showAll();

	/**
	 * Muestra los clientes que posean una id en concreto
	 * 
	 * @param id
	 * @return NttdataCliente
	 */
	public NttdataCliente showByID(Long id);

	/**
	 * Borra un cliente en concreto
	 * 
	 * @param paramN
	 */
	public void deleteClientes(NttdataCliente paramN);

	/**
	 * Actualiza los los clientes
	 * 
	 * @param paramN
	 */
	public void updateClientes(NttdataCliente paramN);

	/**
	 * Muestra Los clientes con un nombre concreto que nosotros le damos
	 * 
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @return NttdataCliente
	 */
	public NttdataCliente showbyName(String nombre, String apellido1, String apellido2);

}
