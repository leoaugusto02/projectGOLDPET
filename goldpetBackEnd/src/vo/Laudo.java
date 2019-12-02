package vo;

public class Laudo {

	private String nomeVeterinario, dataDiagnostico, dataPostagen,diagnostico, imagem;

	public Laudo() {
		super();
	}

	public Laudo(String nomeVeterinario, String dataDiagnostico, String dataPostagen, String diagnostico,
			String imagem) {
		super();
		this.nomeVeterinario = nomeVeterinario;
		this.dataDiagnostico = dataDiagnostico;
		this.dataPostagen = dataPostagen;
		this.diagnostico = diagnostico;
		this.imagem = imagem;
	}

	public String getNomeVeterinario() {
		return nomeVeterinario;
	}

	public void setNomeVeterinario(String nomeVeterinario) {
		this.nomeVeterinario = nomeVeterinario;
	}

	public String getDataDiagnostico() {
		return dataDiagnostico;
	}

	public void setDataDiagnostico(String dataDiagnostico) {
		this.dataDiagnostico = dataDiagnostico;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getDataPostagen() {
		return dataPostagen;
	}

	public void setDataPostagen(String dataPostagen) {
		this.dataPostagen = dataPostagen;
	}

}
