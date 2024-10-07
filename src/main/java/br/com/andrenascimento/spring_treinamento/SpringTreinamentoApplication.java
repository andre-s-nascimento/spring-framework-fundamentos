package br.com.andrenascimento.spring_treinamento;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTreinamentoApplication implements CommandLineRunner{
	
	private final ClienteRepository clienteRepository;

	public SpringTreinamentoApplication(ClienteRepository clienteRepository){
		this.clienteRepository = clienteRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringTreinamentoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		clienteRepository.save(new Cliente("André", 45));
		clienteRepository.save(new Cliente("Kalel", 7));

		var clients = clienteRepository.findAll();

		System.out.println(clients);

		var cliente1 = clienteRepository.findById(1L);
		var cliente2 = clienteRepository.findById(2L);

		if(cliente1.isPresent()){
			System.out.println("Cliente com ID 1 encontrado: ");
			System.out.println(cliente1);
		}

		if(!cliente2.isPresent()){
			System.out.println("Cliente com ID 2 não encontrado:");

		}

		cliente1.get().setNome("Andre SNascimento");
		clienteRepository.save(cliente1.get());

		//clienteRepository.deleteById(1L);
		clienteRepository.delete(cliente1.get());

	}

}
