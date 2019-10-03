package vo;

public class Funcionario {

	private Integer codeFunc;
	private String cargo;
	
	public Funcionario(){super();}

	public Funcionario(Integer codeFunc, String cargo, String cep) {
		super();
		this.codeFunc = codeFunc;
		this.cargo = cargo;
	}

	public Integer getCodeFunc() {
		return codeFunc;
	}

	public void setCodeFunc(Integer codeFunc) {
		this.codeFunc = codeFunc;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
