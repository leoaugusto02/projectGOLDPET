package vo;

public class Guardiao {
	private Integer codeGuard, animasResgatados;
	private String rg, rank;
	
	public Guardiao() {super();}
	
	public Guardiao(Integer codeGuard, Integer animasResgatados, String rg, String rank) {
		super();
		this.codeGuard = codeGuard;
		this.animasResgatados = animasResgatados;
		this.rg = rg;
		this.rank = rank;
	}

	public Integer getCodeGuard() {
		return codeGuard;
	}

	public void setCodeGuard(Integer codeGuard) {
		this.codeGuard = codeGuard;
	}

	public Integer getAnimasResgatados() {
		return animasResgatados;
	}

	public void setAnimasResgatados(Integer animasResgatados) {
		this.animasResgatados = animasResgatados;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
}
