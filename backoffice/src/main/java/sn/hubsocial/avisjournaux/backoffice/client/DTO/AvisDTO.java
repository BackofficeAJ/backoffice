package sn.hubsocial.avisjournaux.backoffice.client.DTO;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.restlet.client.resource.ClientResource;
import org.restlet.client.resource.ResourceException;

import com.google.gson.reflect.TypeToken;

import sn.askane.server.entities.Commons;
import sn.askane.server.entities.Entity;
import sn.askane.server.entities.Objet;

public class AvisDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	 private static int nextId = 0;
	
	private long id;
	private String titre;
	private StructureDTO structure;
	private long structureId;
	private String fichierPdf;
	private String resume;
	private QuotidienDTO quotidien;	
	private String image;
	
	public AvisDTO(Objet askaneObject){
		this.id=askaneObject.getId();
		this.titre=askaneObject.getName();
		this.resume=askaneObject.getDescription();
		this.image=askaneObject.getImage();
		if (askaneObject.getOrganisation() != null) {
			this.quotidien = new QuotidienDTO(askaneObject.getOrganisation());
		}
		if (askaneObject.getCreator() != null) {
			this.structure = new StructureDTO(askaneObject.getCreator());
		}
		
		
		
	};

	public AvisDTO() {
		// TODO Auto-generated constructor stub
	}

	public AvisDTO( String titre, String structure,String fichierPdf, String resume , String quotidien, String image) {
		super();
		 nextId++;
	     this.id = nextId;
		this.titre = titre;
		this.structure = new StructureDTO(structure, null, null);
		this.fichierPdf = fichierPdf;
		this.resume = resume;
		this.quotidien = new QuotidienDTO(quotidien, "", null);
		this.image = image;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	
	
	public String getPdf() {
		return fichierPdf;
	}

	public void setPdf(String fichierPdf) {
		this.fichierPdf = fichierPdf;
	}
	

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public StructureDTO getStructure() {
		return structure;
	}

	public void setStructure(StructureDTO structure) {
		this.structure = structure;
	}

	public long getStructureId() {
		return structureId;
	}

	public void setStructureId(long structureId) {
		this.structureId = structureId;
	}

	public QuotidienDTO getQuotidien() {
		return quotidien;
	}

	public void setQuotidien(QuotidienDTO quotidien) {
		this.quotidien = quotidien;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	public static List<AvisDTO> retreive(int page, int offset, String sortOrder){
		ClientResource cr = new ClientResource(Commons.HTTP_REST_OBJECT + "?sortname=creationDate&sortorder=desc&rp="+offset+"&page="+page);
		List<AvisDTO> avis = new ArrayList<AvisDTO>(); 
		try {
			
			String json = cr.get().getText();
			@SuppressWarnings("unchecked")
			List<Objet> objets = (List<Objet>)Entity.gson.fromJson(json, (new TypeToken<List<Objet>>(){}).getType());
			for (Objet obj:objets) {
				avis.add(new AvisDTO(obj));
			}
			return avis;
		} catch (ResourceException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
