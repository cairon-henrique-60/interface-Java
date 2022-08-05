package servicos;

public class PaypalService implements ServicoDePagamentoOnline{
	
	private static final double FEE_PERCENTAGE = 0.02;
	private static final double MONTHLY_INTEREST = 0.01;
	
	@Override
	public Double taxaDePagamento(double valor) {
		return valor * FEE_PERCENTAGE;
	}
	
	@Override
	public Double jurosPorMes(double valor, int meses) {
		return valor * MONTHLY_INTEREST * meses;
	}
}
