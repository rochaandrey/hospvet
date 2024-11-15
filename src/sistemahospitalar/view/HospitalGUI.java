package sistemahospitalar.view;

import sistemahospitalar.business.cliente.Cliente;
import sistemahospitalar.business.cliente.Plano;
import sistemahospitalar.business.geral.Sexo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import static sistemahospitalar.business.cliente.Plano.planByID;
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
        String cpf = "";
        String dataDeNascimento;
        Sexo sexo = null;
        Plano plano = null;
        int value;

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate hoje = LocalDate.now();
        LocalDate dataFormatada = null;

        variasLinhas();
        do {
            System.out.println("___________________________________");
            System.out.println("Digite seu nome COMPLETO: ");
            nome = scanner.nextLine();

            if (!isValidName(nome)) {
                variasLinhas();
                System.out.println("Escreva seu nome completo");
            }
        } while (!isValidName(nome));

        cpf = pedirCPF();

        variasLinhas();
        do{
            System.out.println("___________________________________");
            System.out.println("Digite sua data de nascimento (dd/MM/yyyy) :");
            dataDeNascimento = scanner.nextLine();

            try{
                dataFormatada = LocalDate.parse(dataDeNascimento, format);
            }catch(DateTimeParseException e){
                variasLinhas();
                System.out.println("Digite a data de nascimento no FORMATO CORRETO! ");
            }

            if(dataFormatada != null){
                if(dataFormatada == hoje || dataFormatada.isAfter(hoje)){
                    dataFormatada = null;
                    variasLinhas();
                    System.out.println("Essa data ainda não existe!");
                }
            }

        }while(dataFormatada == null);

        variasLinhas();
        do {
            System.out.println("___________________________________");
            System.out.println("Qual o seu sexo?");
            System.out.println("1 - Masculino");
            System.out.println("2 - Feminino");

            value = scanner.nextInt();
            scanner.nextLine();

            if(value == 1){
                sexo = Sexo.MASCULINO;
            }else if(value == 2){
                sexo = Sexo.FEMININO;
            }else {
                variasLinhas();
                System.out.println("DIGITE UMA OPÇÃO VÁLIDA");
            }
        }while(!validSEX(sexo));

        do{
            variasLinhas();
            System.out.println("___________________________________");
            System.out.println("Escolha um plano: ");
            for(Plano plan : Plano.values()){
                System.out.println(plan.getId()+" - "+plan.getNome());
            }
            value = scanner.nextInt();

            scanner.nextLine();

            for(Plano plan : Plano.values()){
                if(value == plan.getId()){
                    plano = planByID(value);
                    break;
                }
            }
        }while(plano==null);

        Cliente cliente = new Cliente(nome,cpf,dataFormatada,sexo,plano);
        clientList.add(cliente);

        variasLinhas();

        System.out.println("Cliente criado!");
        scanner.nextLine();
        variasLinhas();
    }

    public static void login(){
        String cpf;
        boolean clienteEncontrado = false;
        cpf = " ";

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
        System.out.println(" ");
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
                mudarPlano();
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
