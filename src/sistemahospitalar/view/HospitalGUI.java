package sistemahospitalar.view;

import sistemahospitalar.business.cliente.Cliente;
import sistemahospitalar.business.cliente.Plano;
import sistemahospitalar.business.geral.Sexo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static sistemahospitalar.business.cliente.Plano.planByID;
import static sistemahospitalar.repository.Listas.clientList;

public class HospitalGUI {
    static Scanner scanner = new Scanner(System.in);

    public static void firstPage(){
        int random;
        do {
            random = 0;
            System.out.println("___________________________________");
            System.out.println("1 - Cadastrar-se");
            System.out.println("2 - Login");
            System.out.println("3 - Sair");

            switch (scanner.nextInt()){
                case 1:
                    scanner.nextLine();
                    cadastro();
                    break;
                case 2:
                    scanner.nextLine();
                    login();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    scanner.nextLine();

                    random = 3;
                    System.out.println("Digite um número válido!");
                    scanner.nextLine();
                    break;
            }
        }while(random!=3);
    }

    public static void cadastro(){
        String nome;
        String cpf = "";
        String dataDeNascimento;
        Sexo sexo = null;
        Plano plano;


        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate hoje = LocalDate.now();
        LocalDate dataFormatada = null;
        plano = null;
        int value;

        System.out.println("Digite seu nome COMPLETO: ");
        nome = scanner.nextLine();

        pedirCPF(cpf);

        do{
            System.out.println("Digite sua data de nascimento (dd,MM,yyyy) :");
            dataDeNascimento = scanner.nextLine();

            try{
                dataFormatada = LocalDate.parse(dataDeNascimento, format);
            }catch(DateTimeParseException e){
                System.out.println("Digite a data de nascimento no FORMATO CORRETO! ");
            }

            if(dataFormatada != null){
                if(dataFormatada == hoje || dataFormatada.isAfter(hoje)){
                    dataFormatada = null;
                    System.out.println("Essa data ainda não existe!");
                }
            }

        }while(dataFormatada == null);

        do {
            System.out.println("Qual o seu sexo?");
            System.out.println("1 - Masculino");
            System.out.println("2 - Feminino");

            value = scanner.nextInt();

            if(value == 1){
                sexo = Sexo.MASCULINO;
            }else if(value == 2){
                sexo = Sexo.FEMININO;
            }else {
                System.out.println("DIGITE UMA OPÇÃO VÁLIDA");
            }
            scanner.nextLine();
        }while(!validSEX(sexo));

        do{
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
        System.out.println("Cliente criado!");
    }

    public static void login(){
        String cpf;
        boolean clienteEncontrado;

        do {
            cpf = " ";
            clienteEncontrado = false;

            pedirCPF(cpf);
            for (Cliente cliente : clientList) {
                if (cliente.getCpf().equals(cpf)) {
                    clienteEncontrado = true;
                    telaCliente(cliente);
                    break;
                }
            }

            if (!clienteEncontrado) {
                System.out.println("o cliente NÃO EXISTE na base de dados");
            }
        }while(!clienteEncontrado);
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
                exameImagem();
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

    public static boolean isvalidCPF(String cpf){
        return cpf.length()==11;
    }

    public static void pedirCPF(String cpf){
        do{
            System.out.println("Digite seu cpf: ");

            try {
                cpf = scanner.nextLine().replaceAll("^[0-9]","");
            } catch (InputMismatchException e) {
                System.out.println("CPF INVÁLIDO! USE APENAS NÚMEROS ");
            }

            if(!isvalidCPF(cpf)){
                System.out.println("CPF INVÁLIDO! DIGITE OS 11 NÚMEROS CORRETAMENTE ");
            }
        }while(cpf.length() != 11);
    }

    public static boolean validSEX(Sexo sexo){
        return sexo == Sexo.FEMININO || sexo == Sexo.MASCULINO;
    }

    public static void variasLinhas(){
        for(int i=0;i<40;i++){
            System.out.println();
        }
    }
}
