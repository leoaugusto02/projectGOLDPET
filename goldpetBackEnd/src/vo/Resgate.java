package vo;

public class Resgate {

	private Integer codResgate, nivelUrgencia;
	private String descricao, endereco, dogeImagem;

	public Resgate(Integer codResgate, Integer nivelUrgencia, String descricao, String endereco, String dogeImagem) {
		super();
		this.codResgate = codResgate;
		this.nivelUrgencia = nivelUrgencia;
		this.descricao = descricao;
		this.endereco = endereco;
		this.dogeImagem = dogeImagem;
	}

	public Integer getCodResgate() {
		return codResgate;
	}

	public void setCodResgate(Integer codResgate) {
		this.codResgate = codResgate;
	}

	public Integer getNivelUrgencia() {
		return nivelUrgencia;
	}

	public void setNivelUrgencia(Integer nivelUrgencia) {
		this.nivelUrgencia = nivelUrgencia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDogeImagem() {
		return dogeImagem;
	}

	public void setDogeImagem(String dogeImagem) {
		this.dogeImagem = dogeImagem;
	}
}
