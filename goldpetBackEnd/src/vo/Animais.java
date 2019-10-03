package vo;

public class Animais {
	
	private Integer codAnimal;
	private String especie;
	private String raca;
	private String porte;
	private Integer idade;
	private String status;
	private String sexo;

	public Animais() {
		super();
	}
	
	public Animais(Integer codAnimal, String especie, String raca, String porte, Integer idade, String status,
			String sexo) {
		super();
		this.codAnimal = codAnimal;
		this.especie = especie;
		this.raca = raca;
		this.porte = porte;
		this.idade = idade;
		this.status = status;
		this.sexo = sexo;
	}
	
	public Integer getCodAnimal() {
		return codAnimal;
	}
	public void setCodAnimal(Integer codAnimal) {
		this.codAnimal = codAnimal;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getPorte() {
		return porte;
	}
	public void setPorte(String porte) {
		this.porte = porte;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	

}