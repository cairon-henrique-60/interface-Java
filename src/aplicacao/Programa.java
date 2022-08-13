package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import dominio.Exceptions.ExcecaoPersonalizada;
import entidades.Contrato;
import entidades.Prestacao;
import servicos.PaypalService;
import servicos.ServicoDeContrato;

public class Programa {

	public static void main(String[] args) throws ExcecaoPersonalizada {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<PaypalService> list = new ArrayList<>();
		
		try {
			System.out.println("Entre com os dados do contrado");
			System.out.print("Numero do contrato: ");
			int numeroDoContrato = sc.nextInt();
			System.out.print("Data (dd/MM/yyyy): ");
			Date data = sdf.parse(sc.next());
			System.out.print("Valor do contrato: ");
			double valor = sc.nextDouble();
			System.out.println();
			
			Contrato contrato = new Contrato(numeroDoContrato, data, valor);
		
			System.out.print("Entre com a quantidade de prestações (max 12): ");
			int numeroDePrestacoes = sc.nextInt();
			System.out.println();
			
			ServicoDeContrato sDeContrato = new ServicoDeContrato(new PaypalService());
			sDeContrato.processandoContrato(contrato, numeroDePrestacoes);
			
			System.out.println("Prestações:");
			for (Prestacao x : contrato.getList()) {
				System.out.println(x);			
			}	
		} 
		catch (InputMismatchException e) {
			System.out.println("Error: " + e.getMessage());
		}
		catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			sc.close();
		}
	}

}
