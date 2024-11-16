package sistemahospitalar.view;

import sistemahospitalar.business.cliente.Cliente;
import sistemahospitalar.business.cliente.Plano;
import sistemahospitalar.business.geral.Sexo;

import java.time.LocalDate;
import java.util.Scanner;

import static sistemahospitalar.view.Listas.clientList;
import static sistemahospitalar.view.HospitalGUIFunctions.*;
import static sistemahospitalar.view.Functions.*;

public class HospitalGUI {
    static Scanner scanner = new Scanner(System.in);

    public static void firstPage(){
        int random;
        do {
            random = 0;
            System.out.println("___________________________________");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Login");
            System.out.println("3 - Sair");

            try {
                switch (scanner.nextInt()) {
                    case 1:
                        scanner.nextLine();
                        cadastro();
                        break;
                    case 2:
                        scanner.nextLine();
                        login();
                        break;
                    case 3:
                        variasLinhas();
                        System.out.println("Obrigado!");
                        random = 3;
                        break;
                    default:
                        scanner.nextLine();
                        variasLinhas();
                        System.out.println("Digite um número válido!");
                        break;
                }
            }catch(Exception e){
                scanner.nextLine();
                variasLinhas();
                System.out.println("Digite um número válido!");
            }
        }while(random!=3);
    }

    public static void cadastro(){
        String nome;
        String cpf;
        LocalDate data;
        Sexo sexo;
        Plano plano;

        nome = pedirNome();
        cpf = pedirCPF();
        data = definitDataDeNascimento();
        sexo = definirSexo();
        plano = escolherPlano();

        Cliente cliente = new Cliente(nome,cpf,data,sexo,plano);
        clientList.add(cliente);

        variasLinhas();

        System.out.println("Cliente criado!");
        scanner.nextLine();
        variasLinhas();
    }

    public static void login(){
        String cpf;
        boolean clienteEncontrado = false;

        variasLinhas();
        cpf = pedirCPF();
        for (Cliente cliente : clientList) {
            if (cliente.getCpf().trim().equals(cpf)) {
                clienteEncontrado = true;
                telaCliente(cliente);
                break;
            }
        }

        if (!clienteEncontrado) {
            variasLinhas();
            System.out.println("o cliente NÃO EXISTE na base de dados");
            scanner.nextLine();
        }
    }

    public static void telaCliente(Cliente cliente){
        variasLinhas();
        int input;

        System.out.println(cliente.toString());
        System.out.println("-----------------------------------");
        System.out.println("1 - Marcar consulta");
        System.out.println("2 - Remarcar consulta");
        System.out.println("3 - Realizar exame de imagem");
        System.out.println("4 - Mudar de plano");
        System.out.println("5 - Gerar boleto");
        System.out.println("6 - Gerar histórico");
        System.out.println("7 - voltar");

        input = scanner.nextInt();
        scanner.nextLine();

        switch ( input ){
            case 1:
                marcarConsulta();
                scanner.nextLine();
                telaCliente(cliente);
                break;
            case 2:
                remarcarConsulta();
                scanner.nextLine();
                telaCliente(cliente);
                break;
            case 3:
                marcarExame();
                scanner.nextLine();
                telaCliente(cliente);
                break;
            case 4:
                mudarPlano(cliente);
                scanner.nextLine();
                telaCliente(cliente);
                break;
            case 5:
                gerarBoleto();
                scanner.nextLine();
                telaCliente(cliente);
                break;
            case 6:
                gerarHistorico();
                scanner.nextLine();
                telaCliente(cliente);
                break;
            case 7:
                atualizarCadastro();
                scanner.nextLine();
                telaCliente(cliente);
                break;
            case 8:
                variasLinhas();
                firstPage();
                break;
            default:
                System.out.println("Digite um número válido!");
                scanner.nextLine();
                telaCliente(cliente);
                break;
        }
    }

}
