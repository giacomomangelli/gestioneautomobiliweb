package gestioneautomobiliweb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "automobile")
public class Automobile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "marca")
	private String marca;
	@Column(name = "modello")
	private String modello;
	@Column(name = "cilindrata")
	private Integer cilindrata;
	@Column(name = "data_di_immatricolazione")
	private Date dataDiImmatricolazione;

	public Automobile() {
	}

	public Automobile(String marca, String modello, Integer cilindrata, Date dataDiImmatricolazione) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.dataDiImmatricolazione = dataDiImmatricolazione;
	}

	public Automobile(Long id, String marca, String modello) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
	}

	public Automobile(String marca, String modello) {
		super();
		this.marca = marca;
		this.modello = modello;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public Integer getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(Integer cilindrata) {
		this.cilindrata = cilindrata;
	}

	public Date getDataDiImmatricolazione() {
		return dataDiImmatricolazione;
	}

	public void setDataDiImmatricolazione(Date dataDiImmatricolazione) {
		this.dataDiImmatricolazione = dataDiImmatricolazione;
	}

}
