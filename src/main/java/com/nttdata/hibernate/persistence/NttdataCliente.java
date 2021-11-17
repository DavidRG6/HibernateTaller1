package com.nttdata.hibernate.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * drg-hibernate-taller2
 *
 * @author driverog
 */
@Entity
@Table(name="NTTDATA_CLIENTE")
public class NttdataCliente {
	private Long idCliente;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int idDocumento;

	public NttdataCliente() {
	}

	/**
	 * @return the idCliente
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente
	 *            the idCliente to set
	 */
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * @return the nombre
	 */
	@Column(name = "nombreCliente")
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido1
	 */
	@Column(name = "apellido1")
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * @param apellido1
	 *            the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * @return the apellido2
	 */
	@Column(name = "apellido2")
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * @param apellido2
	 *            the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * @return the idDocumento
	 */
	@Column(nullable = false,unique = true,length = 9,name = "idDocumento")
	public int getIdDocumento() {
		return idDocumento;
	}

	/**
	 * @param idDocumento
	 *            the idDocumento to set
	 */
	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

}
