package vo;

public class Usuario {

	private Integer codUser;
	private String apelido, p_nome, s_nome, tipo, endereco, senha, email, cpf, rg, genero;
	
	public Usuario(){}
	
	public Usuario(Integer codUser, String apelido, String p_nome, String s_nome, String tipo, String endereco,
			String senha, String email, String cpf, String rg, String genero) {
		super();
		this.codUser = codUser;
		this.apelido = apelido;
		this.p_nome = p_nome;
		this.s_nome = s_nome;
		this.tipo = tipo;
		this.endereco = endereco;
		this.senha = senha;
		this.email = email;
		this.cpf = cpf;
		this.rg = rg;
		this.genero = genero;
	}
	public Integer getCodUser() {
		return codUser;
	}
	public void setCodUser(Integer codUser) {
		this.codUser = codUser;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getP_nome() {
		return p_nome;
	}
	public void setP_nome(String p_nome) {
		this.p_nome = p_nome;
	}
	public String getS_nome() {
		return s_nome;
	}
	public void setS_nome(String s_nome) {
		this.s_nome = s_nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	} 
}
