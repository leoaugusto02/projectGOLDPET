package vo;

import java.util.Date;

public class Agenda {
	
	private Integer codeAgenda, codePerson, codeAnimal;
	private String dia_marcado, horario_marcado;
	
	public Agenda() {}
	
	public Agenda(Integer codeAgenda, Integer codePerson, Integer codeAnimal,
			 String dia_marcado,  String horario_marcado) {
		super();
		this.codeAgenda = codeAgenda;
		this.codePerson = codePerson;
		this.codeAnimal = codeAnimal;
		this.horario_marcado = horario_marcado;
		this.dia_marcado = dia_marcado;
	}

	public Integer getCodeAgenda() {
		return codeAgenda;
	}
	public void setCodeAgenda(Integer codeAgenda) {
		this.codeAgenda = codeAgenda;
	}
	public Integer getCodePerson() {
		return codePerson;
	}
	public void setCodePerson(Integer codePerson) {
		this.codePerson = codePerson;
	}
	public Integer getCodeAnimal() {
		return codeAnimal;
	}
	public void setCodeAnimal(Integer codeAnimal) {
		this.codeAnimal = codeAnimal;
	}

	public String getDia_marcado() {
		return dia_marcado;
	}

	public void setDia_marcado(String dia_marcado) {
		this.dia_marcado = dia_marcado;
	}

	public String getHorario_marcado() {
		return horario_marcado;
	}

	public void setHorario_marcado(String horario_marcado) {
		this.horario_marcado = horario_marcado;
	}
	
	
}
