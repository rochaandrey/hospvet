package sistemahospitalar.view;

import sistemahospitalar.business.cliente.Plano;
import sistemahospitalar.business.geral.Sexo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static sistemahospitalar.business.cliente.Plano.planByID;

public class HospitalGUIFunctions {
    static Scanner scanner = new Scanner(System.in);

    public static String pedirCPF(){
        String cpf = "";
        variasLinhas();
        do{
            System.out.println("___________________________________");
            System.out.println("Digite seu cpf: ");

            try {
                cpf = scanner.nextLine().replaceAll("[^0-9]","");
            } catch (InputMismatchException e) {
                variasLinhas();
                System.out.println("CPF INVÁLIDO! USE APENAS NÚMEROS ");
            }

            if(!isValidCPF(cpf)){
                variasLinhas();
                System.out.println("CPF INVÁLIDO! DIGITE OS 11 NÚMEROS CORRETAMENTE ");
            }
        }while(!isValidCPF(cpf));
        return cpf;
    }

    public static Plano escolherPlano(){
        variasLinhas();
        Plano plano = null;
        int value;
        do{
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
            if(plano == null){
                variasLinhas();
                System.out.println("ESCOLHA UM PLANO VÁLIDO");
            }
        }while(plano==null);
        return plano;
    }

    public static String pedirNome(){
        String nome;
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
        return nome;
    }

    public static LocalDate definitDataDeNascimento(){
        String dataDeNascimento;
        LocalDate dataFormatada = null;
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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

        return dataFormatada;
    }

    public static Sexo definirSexo(){
        Sexo sexo = null;
        int value;
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
        return sexo;
    }

    public static boolean isValidCPF(String cpf){
        return cpf.length()==11;
    }

    public static boolean isValidName(String nome){
        String[] parts = nome.trim().split("\\s+");
        return parts.length >= 3;
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
