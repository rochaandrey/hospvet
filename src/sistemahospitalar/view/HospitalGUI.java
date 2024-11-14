package sistemahospitalar.view;

import sistemahospitalar.business.cliente.Plano;
import sistemahospitalar.business.geral.Sexo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static sistemahospitalar.business.cliente.Plano.planByID;

public class HospitalGUI {
    static Scanner scanner = new Scanner(System.in);

    public static void firstPage(){
        System.out.println("___________________________________");
        System.out.println("1 - Cadastrar-se");
        System.out.println("2 - Login");
    }

    public static void cadastro(String nome, String cpf, String dataDeNascimento, Sexo sexo, Plano plano){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate hoje = LocalDate.now();
        LocalDate dataFormatada = null;
        plano = null;
        int value;

        System.out.println("Digite seu nome COMPLETO: ");
        nome = scanner.nextLine();

        do{
            System.out.println("Digite seu cpf: ");

            try {
                cpf = scanner.nextLine().replaceAll("^[0-9]","");
            } catch (InputMismatchException e) {
                System.out.println("CPF INVÁLIDO! USE APENAS NÚMEROS ");
            }

            if(!validCPF(cpf)){
                System.out.println("CPF INVÁLIDO! DIGITE OS 11 NÚMEROS CORRETAMENTE ");
            }
        }while(cpf.length() != 11);

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
        }while(plano!=null);

    }

    public static boolean validCPF(String cpf){
        return cpf.length()==11;
    }

    public static boolean validSEX(Sexo sexo){
        return sexo == Sexo.FEMININO || sexo == Sexo.MASCULINO;
    }


}
