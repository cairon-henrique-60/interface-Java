package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Prestacao {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date vencimentoDaPrestacao;
	private Double quantia;
	
	public Prestacao() {
	}

	public Prestacao(Date vencimentoDaPrestacao, Double quantia) {
		this.vencimentoDaPrestacao = vencimentoDaPrestacao;
		this.quantia = quantia;
	}

	public Date getVencimentoDaPrestacao() {
		return vencimentoDaPrestacao;
	}

	public void setVencimentoDaPrestacao(Date vencimentoDaPrestacao) {
		this.vencimentoDaPrestacao = vencimentoDaPrestacao;
	}

	public Double getQuantia() {
		return quantia;
	}

	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}
	
	@Override
	public String toString() {
		return sdf.format(vencimentoDaPrestacao) + " - " 
				+ String.format("%.2f", quantia);
	}
}
