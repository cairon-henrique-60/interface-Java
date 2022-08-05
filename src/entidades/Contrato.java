package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
	
	private Integer numeroDoContrato;
	private Date data;
	private Double valorTotal;
	
	private List<Prestacao> list = new ArrayList<>();
	
	public Contrato() {
	}
	
	public Contrato(Integer numeroDoContrato, Date data, Double valorTotal) {
		this.numeroDoContrato = numeroDoContrato;
		this.data = data;
		this.valorTotal = valorTotal;
	}

	public Integer getNumeroDoContrato() {
		return numeroDoContrato;
	}

	public void setNumeroDoContrato(Integer numeroDoContrato) {
		this.numeroDoContrato = numeroDoContrato;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Prestacao> getList() {
		return list;
	}

	public void addPrestacao(Prestacao prestacao) {
		list.add(prestacao);
	}
	
	public void removerPrestacao(Prestacao prestacao) {
		list.remove(prestacao);
	}	
}
