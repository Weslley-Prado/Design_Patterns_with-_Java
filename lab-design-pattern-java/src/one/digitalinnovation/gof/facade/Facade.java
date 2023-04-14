package one.digitalinnovation.gof.facade;

import subsistem1.crm.CrmService;
import subsistem2.cep.CepApi;

public class Facade {
	public void changeClient(String name, String cep) {
		String cidade = CepApi.getInstance().seekCity(cep);
		String state = CepApi.getInstance().seekState(cep);
		
		CrmService.recordClient(name, cep, cidade, state);
	}

}
