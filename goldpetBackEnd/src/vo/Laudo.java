package vo;

import java.util.Date;

public class Laudo {

	private String nomeVeterinario, diagnostico, imagem;
	private Date dataDiagnostico, dataPostagen;

	public Laudo() {
		super();
	}

	public Laudo(String nomeVeterinario, Date dataDiagnostico, Date dataPostagen, String diagnostico,
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

	public Date getDataDiagnostico() {
		return dataDiagnostico;
	}

	public void setDataDiagnostico(Date dataDiagnostico) {
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

	public Date getDataPostagen() {
		return dataPostagen;
	}

	public void setDataPostagen(Date dataPostagen) {
		this.dataPostagen = dataPostagen;
	}

}
