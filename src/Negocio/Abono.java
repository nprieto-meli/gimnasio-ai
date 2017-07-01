package Negocio;

import java.util.Date;

public class Abono {
	
	private int codigo;
	private String nombre;
	private float precio;
	private Date periodoVigencia;
	
	public Abono(String nombre, float precio, Date periodoVigencia) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.periodoVigencia = periodoVigencia;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Date getPeriodoVigencia() {
		return periodoVigencia;
	}

	public void setPeriodoVigencia(Date periodoVigencia) {
		this.periodoVigencia = periodoVigencia;
	}
	
	
	

}