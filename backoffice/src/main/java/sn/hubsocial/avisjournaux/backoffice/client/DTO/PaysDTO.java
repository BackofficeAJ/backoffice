package sn.hubsocial.avisjournaux.backoffice.client.DTO;

import sn.askane.server.entities.Pays;

public class PaysDTO {
	private String libelle;
	private long id;
	public PaysDTO(Pays pays) {
		this.libelle = pays.getName();
		this.id = pays.getId();
	}
	public PaysDTO() {
		super();
	}
	public PaysDTO(String libelle, long id) {
		super();
		this.libelle = libelle;
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
