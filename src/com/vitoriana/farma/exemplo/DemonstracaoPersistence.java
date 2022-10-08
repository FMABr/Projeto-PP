package com.vitoriana.farma.exemplo;

import com.vitoriana.farma.model.Cliente;
import com.vitoriana.farma.model.Endereco;
import com.vitoriana.farma.persistence.ClienteService;

public class DemonstracaoPersistence {

	public static void main(String[] args) {

		Endereco endereco1 = new Endereco("123", "Alvorada", "Anjo", 3);

		Cliente cliente1 = new Cliente(12, "Asunder", "922", endereco1);
		
		ClienteService cserv = new ClienteService();
		
		System.out.println(cserv.registrar(cliente1));
		
		Cliente desserializado = cserv.buscar(cliente1.getId());
		
		System.out.println();
	}

}
