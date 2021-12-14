package strategy;

import java.util.InputMismatchException;

import application.Dominio;
import dominio.Fornecedor;

public class ValidarCNPJ implements IStrategy{

	@Override
	public String processar(Dominio dominio) {
		Fornecedor f = (Fornecedor)dominio;
		
		if(f.getCnpj().equals("00000000000000") || f.getCnpj().equals("11111111111111") ||
		   f.getCnpj().equals("22222222222222") || f.getCnpj().equals("33333333333333") ||
		   f.getCnpj().equals("44444444444444") || f.getCnpj().equals("55555555555555") ||
		   f.getCnpj().equals("66666666666666") || f.getCnpj().equals("77777777777777") ||
		   f.getCnpj().equals("88888888888888") || f.getCnpj().equals("99999999999999") ||
		   f.getCnpj() == null || f.getCnpj().length() != 14) {
			return "Valores incorretos ou nao possui 14 digitos";
		}
		
		char digito13 = f.getCnpj().charAt(12);
		char digito14 = f.getCnpj().charAt(13);
		int soma = 0;
		int numero = 0;
		int valor = 2;
		char digiVerificador1;
		char digiVerificador2;
		
		try {
			for(int i=11; i>=0;i--) {
				numero = (int)(f.getCnpj().charAt(i) - 48);				
				soma += numero * valor;
				
				if(valor == 10) {
					valor = 2;
				}else {
					valor ++;
				}				
			}
			if(soma % 11 != 0 || soma % 11 != 1) {
				digiVerificador1 = (char)((11 - (soma % 11)) + 48);
			}else {
				digiVerificador1 = '0';
			}
			
			System.out.println("D1: " + digiVerificador1);
			soma = 0;
			for(int i=12; i>=0;i--) {
				numero = (int)(f.getCnpj().charAt(i) - 48);
				soma += numero * valor;
				if(valor == 10) {
					valor = 2;
				}else {
					valor ++;
				}	
			}
			if(soma % 11 != 0 || soma % 11 != 1) {
				digiVerificador2 = (char)((11 - (soma % 11)) + 48);				
			}else {
				digiVerificador2 = '0';
			}
			
			if(digiVerificador1 == digito13 && digiVerificador2 == digito14) {
				return null;
			}else {
				return null;
			}
		}catch(InputMismatchException e) {
			e.getMessage();
		}
		
		return null;
	}

}
