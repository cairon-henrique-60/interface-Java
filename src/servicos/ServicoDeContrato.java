package servicos;

import java.util.Calendar;
import java.util.Date;

import dominio.Exceptions.ExcecaoPersonalizada;
import entidades.Contrato;
import entidades.Prestacao;

public class ServicoDeContrato {

	private ServicoDePagamentoOnline serDePagamentoOnline;
	
	public ServicoDeContrato() {
	}

	public ServicoDeContrato(ServicoDePagamentoOnline serDePagamentoOnline) {
		this.serDePagamentoOnline = serDePagamentoOnline;
	}
	
	public void processandoContrato(Contrato contrato, int meses) throws ExcecaoPersonalizada {
		if (meses <=12) {
			
			double cotaBasica = contrato.getValorTotal() / meses;
			
			for(int i=1; i<=meses; i++) {
				Date date = addMeses(contrato.getData(), i);
				double atualizaCota = cotaBasica + serDePagamentoOnline.jurosPorMes(cotaBasica, i);
				double cotaCompleta = atualizaCota + serDePagamentoOnline.taxaDePagamento(atualizaCota);
				contrato.addPrestacao(new Prestacao(date, cotaCompleta));
			}
		}
		else {
			throw new ExcecaoPersonalizada("Error: A quantidade maxima de prestacooes é 12");
		}
	}
	
	//funcal auxiliar que incrementa mais um mes
	private Date addMeses(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
}
