package sistemahospitalar.view;

import sistemahospitalar.business.geral.Sexo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HospitalGUIFunctions {
    static Scanner scanner = new Scanner(System.in);

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
