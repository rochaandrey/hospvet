package sistemahospitalar.view;

import sistemahospitalar.business.geral.Sexo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HospitalGUIFunctions {
    static Scanner scanner = new Scanner(System.in);

    public static String pedirCPF(){
        String cpf = "";
        do{
            variasLinhas();
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

    public static boolean isValidCPF(String cpf){
        return cpf.length()==11;
    }

    public static boolean isValidName(String nome){
        String[] parts = nome.trim().split("\\s+");
        if (parts.length < 3) {
            return false;
        }
        return true;
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
