package servicos;

public interface ServicoDePagamentoOnline {
	
	Double taxaDePagamento(double valor);
	Double jurosPorMes(double valor, int meses);
}
