package com.servicos.abcde.entidades;

import java.io.Serializable;
import java.time.Instant;

public class A implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String atributo1;
	private Double atributo2;
	private Instant atributo3;
	private Integer atributo4;
	
	public A() {}
	
	public A(Long id, String atributo1, Double atributo2, Instant atributo3, Integer atributo4) {
		super();
		this.id = id;
		this.atributo1 = atributo1;
		this.atributo2 = atributo2;
		this.atributo3 = atributo3;
		this.atributo4 = atributo4;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAtributo1() {
		return atributo1;
	}

	public void setAtributo1(String atributo1) {
		this.atributo1 = atributo1;
	}

	public Double getAtributo2() {
		return atributo2;
	}

	public void setAtributo2(Double atributo2) {
		this.atributo2 = atributo2;
	}

	public Instant getAtributo3() {
		return atributo3;
	}

	public void setAtributo3(Instant atributo3) {
		this.atributo3 = atributo3;
	}

	public Integer getAtributo4() {
		return atributo4;
	}

	public void setAtributo4(Integer atributo4) {
		this.atributo4 = atributo4;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		A other = (A) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

