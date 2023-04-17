package one.digitalinnovation.gof.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import one.digitalinnovation.gof.model.Address;
import one.digitalinnovation.gof.model.AddressRepository;
import one.digitalinnovation.gof.model.Client;
import one.digitalinnovation.gof.model.ClientRepository;
import one.digitalinnovation.gof.services.ClientService;
import one.digitalinnovation.gof.services.ViaCepService;

public class ClientServiceImpl implements ClientService{// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Client> findAll() {
		// Buscar todos os Clientes.
		return clientRepository.findAll();
	}

	@Override
	public Client findById(Long id) {
		// Buscar Cliente por ID.
		Optional<Client> cliente = clientRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void insert(Client client) {
		salvarClientComCep(client);
	}

	@Override
	public void update(Long id, Client cliente) {
		// Buscar Cliente por ID, caso exista:
		Optional<Client> clientBd = clientRepository.findById(id);
		if (clientBd.isPresent()) {
			salvarClientComCep(cliente);
		}
	}

	@Override
	public void delete(Long id) {
		// Deletar Cliente por ID.
		clientRepository.deleteById(id);
	}

	private void salvarClientComCep(Client client) {
		// Verificar se o Endereco do Cliente já existe (pelo CEP).
		String cep = client.getAddress().getCep();
		Address endereco = addressRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Address novoEndereco = viaCepService.consultarCep(cep);
			addressRepository.save(novoEndereco);
			return novoEndereco;
		});
		client.setAddress(endereco);
		// Inserir Cliente, vinculando o Endereco (novo ou existente).
		clientRepository.save(client);
	}

}
