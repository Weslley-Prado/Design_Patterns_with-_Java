package subsistem2.cep;


public class CepApi {
private static CepApi instanceofItself = new CepApi();
	
	private CepApi() {
		super();
	}
	
	public static CepApi getInstance() {
		return instanceofItself;
	}
	
	public String seekCity(String cep) {
		return "Araraquara";
	}
	public String seekState(String cep) {
		return "SP";
	} 

}
