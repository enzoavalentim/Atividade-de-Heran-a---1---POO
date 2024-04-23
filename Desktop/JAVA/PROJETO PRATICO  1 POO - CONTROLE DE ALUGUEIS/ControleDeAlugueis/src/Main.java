import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int escolha = 0;
		
ArrayList<Equipamentos> listaEquipamentos = new ArrayList<>(); // Vetor Cadastro de Equipamentos
ArrayList<Cliente> listaClientes = new ArrayList<>(); // Vetor Cadastro de Clientes


	while (escolha != 5) {
	
		System.out.println("\n-=-=-=Menu Geral-=-=-=-");
		System.out.print("\n1. Cadastar Cliente");
		System.out.print("\n2. Cadastrar Produto");
		System.out.print("\n3. Aluguel de equipamentos");
		System.out.print("\n4. Lista de equipamentos");
		System.out.print("\n5. Lista de clientes");
		System.out.print("\nEscolha uma das opções: ");
	
		escolha = scanner.nextInt();
		scanner.nextLine();
		
		switch (escolha) {
		
		
		case 1: // CADASTRO DE CLIENTES //
			
			System.out.println("-=-=-=-Cadastro de Cliente-=-=-=-=");
			
			Cliente novoCliente = new Cliente(null, 0); // Cria um objeto tipo cliente vazio

			System.out.print("\nDigite o nome do cliente: ");
			String nomeCliente = scanner.nextLine(); //Passar atributo nome do Cliente
			novoCliente.setName(nomeCliente); // Seta o nome de acordo com o parametro passado

			
			 
			
			int newId; // Setar Id do cliente
			boolean idUnico = false;

			do {
			    
			    newId = Cliente.gerarIdCliente(); // Gera um ID aleatório para o cliente
			    
			    
			    idUnico = true; // Assume que o ID é único
			    for(Cliente cliente : listaClientes) {
			        if (cliente.getId() == newId) {
			            idUnico = false; // O ID não é único, então precisamos gerar um novo
			            break; // Sai do loop assim que encontrar um ID duplicado
			        }
			    }
			} while (!idUnico); 
			
			
			novoCliente.setId(newId); // Seta o id de acordo com o parametro passado
			
			
			listaClientes.add(novoCliente); // Adiciona o Cliente a lista de Clientes cadastrados
			
			System.out.println("\nCliente Cadastrado com Sucesso!");
			System.out.println("\nNome: " + novoCliente.getName());
			System.out.println("Id: " + novoCliente.getId());
			break;
			
		case 2: // CADASTRO DE EQUIPAMENTOS //
			
			System.out.println("-=-=-=-Cadastro de Produto-=-=-=-=");
			
			Equipamentos novoProduto = new Equipamentos(null, 0, 0, null, null, null, 0); // Cria um objeto tipo equipamento vazio
		
			System.out.print("\nDigite o tipo do produto: ");
			String nomeProduto = scanner.nextLine(); //Passar atributo nome do Equipamento
			novoProduto.setName(nomeProduto); // Seta o nome de acordo com o parametro passado
			
			
			int newIdProd; // Setar Id do Produto
			boolean idUnicoProd = false;
			
			do {
			    
			    newIdProd = Equipamentos.gerarIdProduto(); // Gera um ID aleatório para o cliente
			    
			    
			    idUnicoProd = true; // Assume que o ID é único
			    for(Cliente cliente : listaClientes) {
			        if (cliente.getId() == newIdProd) {
			            idUnicoProd = false; // O ID não é único, então precisamos gerar um novo
			            break; // Sai do loop assim que encontrar um ID duplicado
			        }
			    }
			} while (!idUnicoProd); 
			
			novoProduto.setId(newIdProd);
			
			
			System.out.print("\nDigite o valor da diaria do produto: ");
			double vlDiaria = scanner.nextDouble();  // Setar o valor da diaria do equipamento
			novoProduto.setVlLoc(vlDiaria);
			
			listaEquipamentos.add(novoProduto); // Adiciona o equipamento cadastrado a lista de equipamentos 
			
			System.out.println("\nNovo equipamento cadastrado com sucesso!");
			System.out.println("\nNome: " + novoProduto.getName());
			System.out.println("Id: " + novoProduto.getId());
			System.out.println("Valor da Locação diaria: " + "R$" + novoProduto.getVlLoc());
			
			break;
			
		case 3:	// ALUGUEL DE EQUIPAMENTOS // 
			
			System.out.println("-=-=-=-Aluguel de Equipamentos-=-=-=-=");
			
			System.out.println("\nLista de Clientes Cadastrados:");
			for(Cliente cliente:listaClientes) { // Vai mostrar todos os clientes cadastrados
				
				System.out.println("\nNome: " + cliente.getName());
				System.out.println("Id: " + cliente.getId());
			}
			
			
			System.out.println("\nDigite o nome do Locatário: ");
			String nomeCliAutentic = scanner.nextLine();  // Nome do cliente que está alugando
			
			System.out.println("\nDigite o Id do Locatário: ");
			int IdCliAutentic = scanner.nextInt(); // Id do cliente que está alugando
			
			Cliente clienteAutentic = null;
			
			for (Cliente cliente : listaClientes) { // Verifica se o s parametros passados conferem com os atribudos de algum dos objetos cliente cadastrados
				if (cliente.getName().equals(nomeCliAutentic) && cliente.getId() == IdCliAutentic)  { 
					clienteAutentic = cliente;
						} // Fecha If
				else 
					System.out.println("Este Cliente não existe no sistema");
				
				} //Fecha For
			
			
			System.out.println("\nLocatario: " + clienteAutentic.getName());
			
			System.out.println("\nLista de Equipamentos Disponiveis:");
			
			for(Equipamentos equipamento : listaEquipamentos) { // Vai mostrar todos os equipamentos disponiveis para locação 
				// fazer if com equipamentos que não estão disponiveis
				System.out.println("\nNome " + equipamento.getName());
				System.out.println("Id " + equipamento.getId());
				System.out.println("Valor da Diaria: " + "R$" + equipamento.getVlLoc());
			}
			
			
			System.out.println("\nDigite o nome do Equipamento a ser locado: ");
			String nomeEquipAutentic = scanner.nextLine();  // Nome do equipamento que está alugando
			scanner.nextLine();
			
			System.out.println("\nDigite o Id do equipamento a ser locado: ");
			int IdEquipAutentic = scanner.nextInt(); // Id do cliente que está alugando
			
			Locacao novaLoc = new Locacao();
			novaLoc.novaLocacao(nomeEquipAutentic, IdEquipAutentic, listaEquipamentos, clienteAutentic);
			break;
			
		case 4:
			
			System.out.println(listaEquipamentos.toString());
				
				
		case 5:
			
			System.out.println(listaClientes.toString());
			
			
			
			
		
		
			
			
		
		} // Fecha Switch principal
}// Fecha While Principal
			
		
	} // Fecha Public Static void Main



} // Fecha class Main
