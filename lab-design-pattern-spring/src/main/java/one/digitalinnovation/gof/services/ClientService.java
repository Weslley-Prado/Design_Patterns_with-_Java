package one.digitalinnovation.gof.services;

import one.digitalinnovation.gof.model.Client;

public interface ClientService {
	Iterable<Client> findAll();

	Client findById(Long id);

	void insert(Client client);

	void update(Long id, Client cliente);

	void delete(Long id);

}
