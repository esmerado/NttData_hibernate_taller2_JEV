package com.jesmeradonttdata.nttdata_hibernate_taller1_jev;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;

import com.jesmeradonttdata.persistence.NttDataClient;
import com.jesmeradonttdata.persistence.NttDataContract;
import com.jesmeradonttdata.services.NttDataClientManagementServiceI;
import com.jesmeradonttdata.services.NttDataClientManagementServiceImpl;
import com.jesmeradonttdata.services.NttDataContractManagementServiceI;
import com.jesmeradonttdata.services.NttDataContractManagementServiceImpl;

/**
 * 
 * Javier Esmerado Vela - Hibernate - Taller 2.
 * 
 * Main Class.
 * 
 * @author jesmerad
 *
 */
public class NttDataClientHibernateMain {

	/**
	 * 
	 * Main Method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Open Session.
		final Session session = NttDataHibernateUtil.getSessionFactory().openSession();

		// Service inicialization.
		final NttDataClientManagementServiceImpl clientService = new NttDataClientManagementServiceImpl(session);
		final NttDataContractManagementServiceImpl contractService = new NttDataContractManagementServiceImpl(session);

		// Audit
		final String updatedUser = "NTTDATAJEV_SYS";
		final Date updatedDate = new Date();

		// Client Generator.
		final NttDataClient clientOne = new NttDataClient();
		clientOne.setName("Javier3");
		clientOne.setFirstSurname("Esmerado3");
		clientOne.setSecondSurname("Vela3");
		clientOne.setNif(1234387L);
		clientOne.setUpdatedUser(updatedUser);
		clientOne.setUpdatedDate(updatedDate.toString());

		final NttDataClient clientTwo = new NttDataClient();
		clientTwo.setName("Alejandro");
		clientTwo.setFirstSurname("Tellez");
		clientTwo.setSecondSurname("Rubio");
		clientTwo.setNif(115668748L);
		clientTwo.setUpdatedUser(updatedUser);
		clientTwo.setUpdatedDate(updatedDate.toString());

		clientService.insertNewClient(clientOne);
		clientService.insertNewClient(clientTwo);

		final NttDataClient clientThree = new NttDataClient();
		clientThree.setUpdatedUser(updatedUser);
		clientThree.setUpdatedDate(updatedDate.toString());

		final NttDataContract contractOne = new NttDataContract();
		contractOne.setClient(clientOne);
		contractOne.setEffectiveDate(new Date(2020 - 12 - 22));
		contractOne.setExpirationDate(new Date(2022 - 12 - 01));
		contractOne.setMonthlyPrice(1230D);
		contractOne.setUpdatedDate(updatedDate.toString());
		contractOne.setUpdatedUser(updatedUser);

		contractService.insertNewContract(contractOne);

		final NttDataContract contractTwo = new NttDataContract();
		contractTwo.setUpdatedDate(updatedDate.toString());
		contractTwo.setUpdatedUser(updatedUser);

		// Menu Implement.

		menu(clientService, contractService, clientThree, contractTwo);

		// Sesssion Close.
		session.close();
	}

	private static void menu(NttDataClientManagementServiceImpl clientService,
			NttDataContractManagementServiceImpl contractService, NttDataClient clientThree,
			NttDataContract contractTwo) {
		
		menuClients(contractService, clientService, clientThree, contractTwo);

	}

	/**
	 * 
	 * Menu generation for contracts.
	 * 
	 * @param contractService
	 * @param contract
	 */
	public static void menuContract(NttDataContractManagementServiceI contractService, NttDataContract contract, NttDataClient client) {

		// Scanner
		Scanner sc = new Scanner(System.in);

		while (true) {

			try {

				System.out.println("!!BIENVENIDO AL TALLER 2 DE HIBERNATE!!");
				System.out.println("created by Javier Esmerado Vela");
				System.out.println("1.- Añadir contrato.");
				System.out.println("2.- Mostrar contratos.");
				System.out.println("3.- Modificar contrato.");
				System.out.println("4.- Eliminar contrato.");
				System.out.println("5.- Buscar contrato por id.");
				System.out.println("6.- Buscar contrato por id de cliente.");
				System.out.println("7.- Exit.");
				int select_num = sc.nextInt();

				switch (select_num) {
				case 1:
					añadirContract(contractService, contract, sc, client);
					break;
				case 2:
					mostrarContract(contractService);
					break;
				case 3:
					modificarContract(contractService, contract, sc);
					break;
				case 4:
					eliminarContrato(contractService, contract, sc);
					break;
				case 5:
					buscarContratoPorId(contractService, contract, sc);
					break;
				case 6:
					buscarContratoPorClienteId(contractService, contract, sc, client);
					break;
				default:
					System.out.println("Volviendo a clientes....");
					break;

				}
			} catch (Exception e) {
				System.err.println("[ERROR] Ha introducido un valor no permitido.");
			}
			break;
		}
	
	}

	/**
	 * 
	 * Menu generation for clients.
	 * 
	 * @param clientService
	 * @param client
	 */
	private static void menuClients(NttDataContractManagementServiceI contractService,NttDataClientManagementServiceI clientService, NttDataClient client, NttDataContract contract) {

		// Scanner
		Scanner sc = new Scanner(System.in);

		while (true) {

			try {

				System.out.println("!!BIENVENIDO AL TALLER 2 DE HIBERNATE!!");
				System.out.println("created by Javier Esmerado Vela");
				System.out.println("1.- Añadir cliente.");
				System.out.println("2.- Mostrar clientes.");
				System.out.println("3.- Modificar cliente.");
				System.out.println("4.- Eliminar cliente.");
				System.out.println("5.- Buscar cliente por id.");
				System.out.println("6.- Buscar cliente por nombre y apellido.");
				System.out.println("7.- Buscar cliente por nif.");
				System.out.println("8.- Contratos");
				System.out.println("9.- Exit.");
				int select_num = sc.nextInt();

				switch (select_num) {
				case 1:
					añadirCliente(clientService, client, sc);
					break;
				case 2:
					mostrarClientes(clientService);
					break;
				case 3:
					modificarCliente(clientService, client, sc);
					break;
				case 4:
					eliminarCliente(clientService, client, sc);
					break;
				case 5:
					buscarClientePorId(clientService, client, sc);
					break;
				case 6:
					buscarClientePorNombreApellido(clientService, client, sc);
					break;
				case 7:
					buscarPorNif(clientService, client, sc);
					break;
				case 8:
					mostrarClientes(clientService);
					System.out.println("Seleccione un cliente con el que acceder.");
					Long num = sc.nextLong();
					
					NttDataClient clientSelected = clientService.searchById(num);
					
					menuContract(contractService, contract, clientSelected);
					
					
					break;
				default:
					exit();

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * 
	 * Search client by name and surname.
	 * 
	 * @param clientService
	 * @param client
	 * @param sc
	 */
	private static void buscarClientePorNombreApellido(NttDataClientManagementServiceI clientService,
			NttDataClient client, Scanner sc) {
		
		System.out.println("Introduce el nombre del cliente a buscar: ");
		String name = sc.next();
		System.out.println("Introduce el apellido del cliente a buscar: ");
		String surname = sc.next();
		
		if (clientService.searchByNameAndSurname(name, surname) != null) {
			List<NttDataClient> clientFinded = clientService.searchByNameAndSurname(name, surname);
			
			clientFinded.stream().forEach(p -> System.out.println(p));
		} else {
			System.out.println("Lo sentimos, no se ha encontrado ningún cliente.");
		}
		
		
	}
	
	private static void buscarContratoPorClienteId(NttDataContractManagementServiceI contractService, NttDataContract contract, Scanner sc, NttDataClient client) {
		
		
		System.out.println("Se van a buscar todos los contratos del cliente actual:");
		
		if (contractService.searchByClientId(client.getClientID()) != null) {
			
			List<NttDataContract> contractList = contractService.searchByClientId(client.getClientID());
			contractList.stream().forEach(p -> System.out.println(p));
			
		} else {
			System.out.println("Lo sentimos, contratos no encontrados.");
		}
		
	}
	

	/**
	 * 
	 * Search by Id.
	 * 
	 * @param clientService
	 * @param client
	 * @param sc
	 */
	private static void buscarClientePorId(NttDataClientManagementServiceI clientService, NttDataClient client,
			Scanner sc) {

		System.out.println("Introduce el id del cliente que desea buscar: ");
		Long id = sc.nextLong();

		if (clientService.searchById(id) != null) {

			NttDataClient clientFromDB = clientService.searchById(id);

			System.out.println(clientFromDB.toString());

		} else {
			System.out.println("Lo sentimos, el id introducido no coincide con ningún cliente.");
		}

	}
	
	/**
	 * 
	 * Search by Id.
	 * 
	 * @param contractService
	 * @param contract
	 * @param sc
	 */
	private static void buscarContratoPorId(NttDataContractManagementServiceI contractService, NttDataContract contract,
			Scanner sc) {

		System.out.println("Introduce el id del contrato que desea buscar: ");
		Long id = sc.nextLong();

		if (contractService.searchById(id) != null) {

			NttDataContract contractFromDB = contractService.searchById(id);

			System.out.println(contractFromDB.toString());

		} else {
			System.out.println("Lo sentimos, el id introducido no coincide con ningún contrato.");
		}

	}

	/**
	 * 
	 * Remove a client.
	 * 
	 * @param clientService
	 * @param client
	 */
	private static void eliminarCliente(NttDataClientManagementServiceI clientService, NttDataClient client,
			Scanner sc) {

		mostrarClientes(clientService);

		try {

			System.out.println("Introduzca el id del usuario a eliminar:");
			Long num = sc.nextLong();

			client = clientService.searchById(num);

			clientService.deleteClient(client);
		} catch (Exception e) {
			System.err.println("[ERROR] Ha introducido un valor erróneo.");
		}

	}
	
	/**
	 * 
	 * Remove a contract.
	 * 
	 * @param contractService
	 * @param contract
	 */
	private static void eliminarContrato(NttDataContractManagementServiceI contractService, NttDataContract contract,
			Scanner sc) {

		mostrarContract(contractService);

		try {

			System.out.println("Introduzca el id del contrato a eliminar:");
			Long num = sc.nextLong();

			contract = contractService.searchById(num);

			contractService.deleteContract(contract);
		} catch (Exception e) {
			System.err.println("[ERROR] Ha introducido un valor erróneo.");
		}

	}

	/**
	 * 
	 * Update Client.
	 * 
	 * @param clientService
	 * @param client
	 * @param sc
	 */
	private static void modificarCliente(NttDataClientManagementServiceI clientService, NttDataClient client,
			Scanner sc) {

		mostrarClientes(clientService);

		try {

			System.out.println("Introduce el id del cliente a modificar: ");
			Long num = sc.nextLong();

			client = clientService.searchById(num);

			System.out.println("Introduce el nuevo nombre: ");
			String name = sc.next();
			System.out.println("Introduce el nuevo primer apellido: ");
			String first_name = sc.next();
			System.out.println("Introduce el nuevo segundo apellido: ");
			String second_name = sc.next();

			client.setName(name);
			client.setFirstSurname(first_name);
			client.setSecondSurname(second_name);

			clientService.updateClient(client);

		} catch (Exception e) {
			System.err.println("[ERROR] Ha introducido un id o un valor incorrecto.");
		}

	}
	
	/**
	 * 
	 * Update Contract.
	 * 
	 * @param contractService
	 * @param contract
	 * @param sc
	 */
	private static void modificarContract(NttDataContractManagementServiceI contractService, NttDataContract contract,
			Scanner sc) {

		mostrarContract(contractService);

		try {

			System.out.println("Introduce el id del contrato a modificar: ");
			Long num = sc.nextLong();

			contract = contractService.searchById(num);

			System.out.println("Inserte su nuevo sueldo mensual: ");
			Double monthlyPrice = sc.nextDouble();
			
			contract.setMonthlyPrice(monthlyPrice);

			contractService.updateContract(contract);

		} catch (Exception e) {
			System.err.println("[ERROR] Ha introducido un id o un valor incorrecto.");
		}

	}

	/**
	 * 
	 * Show all the clients.
	 * 
	 * @param clientService
	 * @param sc
	 */
	private static void mostrarClientes(NttDataClientManagementServiceI clientService) {

		List<NttDataClient> listOfClients = clientService.searchAll();

		listOfClients.stream().forEach(p -> System.out.println(p));
	}
	
	/**
	 * 
	 * Show all the contracts.
	 * 
	 * @param contractService
	 * @param sc
	 */
	private static void mostrarContract(NttDataContractManagementServiceI contractService) {

		List<NttDataContract> listOfContracts = contractService.searchAll();

		listOfContracts.stream().forEach(p -> System.out.println(p));
	}

	/**
	 * 
	 * Method to create a new client.
	 * 
	 * @param clientService
	 * @param client
	 * @param sc
	 */
	private static void añadirCliente(NttDataClientManagementServiceI clientService, NttDataClient client, Scanner sc) {

		try {

			System.out.println("Nombre: ");
			String name = sc.next();
			System.out.println("Primer apellido: ");
			String first_name = sc.next();
			System.out.println("Segundo apellido: ");
			String second_name = sc.next();
			System.out.println("DNI(Sólo números): ");
			Long nif = sc.nextLong();

			client.setName(name);
			client.setFirstSurname(first_name);
			client.setSecondSurname(second_name);
			client.setNif(nif);

			clientService.insertNewClient(client);

		} catch (Exception e) {
			System.err.println("[ERROR] Ha introducido un valor incorrecto.");
		}

	}
	
	/**
	 * 
	 * Method to create a new client.
	 * 
	 * @param clientService
	 * @param client
	 * @param sc
	 */
	private static void añadirContract(NttDataContractManagementServiceI contractService, NttDataContract contract, Scanner sc, NttDataClient client) {

		try {

			System.out.println("Inserte su sueldo mensual: ");
			Double monthlyPrice = sc.nextDouble();
			
			contract.setEffectiveDate(new Date());
			contract.setExpirationDate(new Date(2023 - 01 - 01));
			contract.setMonthlyPrice(monthlyPrice);
			

			contractService.insertNewContract(contract);

		} catch (Exception e) {
			System.err.println("[ERROR] Ha introducido un valor incorrecto.");
		}

	}
	
	/**
	 * 
	 * Search a client by nif.
	 * 
	 * @param clientService
	 * @param client
	 * @param sc
	 */
	private static void buscarPorNif(NttDataClientManagementServiceI clientService, NttDataClient client, Scanner sc) {
		
		System.out.println("Introduce el nif del cliente a buscar: ");
		Long nif = sc.nextLong();
		
		if (clientService.searchByNif(nif) != null) {
			
			List<NttDataClient> clientFromDB = clientService.searchByNif(nif);
			
			clientFromDB.stream().forEach(p -> System.out.println(p));
			
		} else {
			System.out.println("El Nif introducido no pertenece a ningún cliente.");
		}
		
	}

	/**
	 * Method to exit the app.
	 */
	private static void exit() {
		System.out.println("¡¡HASTA PRONTO!!");
		System.exit(0);

	}

}
