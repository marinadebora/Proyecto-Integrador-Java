package Major;

import Dao.InterfacesH2.ExpensesDaoH2;
import Dao.dto.ExpensesDto;
import Dao.impl.ExpensesDaoH2Impl;

import java.util.Date;
import java.util.Scanner;

public class CreateBills {
    public static void createBills(){
        Scanner scanner = new Scanner(System.in);
        String expenseType;
        double amount;
        String addressee;
        ExpensesDto expensesDto;

        int salir;
        do {
            System.out.println("ingrese el typo de gastos");
            expenseType= scanner.nextLine();
            System.out.println("ingrese su destinatario");
            addressee= scanner.nextLine();
            System.out.println("ingrese el monto");
            amount = scanner.nextInt();
            System.out.println("para salir seleccione 1");
            salir = scanner.nextInt();
            scanner.nextLine();
            String date = new Date().toString();
            ExpensesDaoH2 expensesDaoH2= new ExpensesDaoH2Impl();
            expensesDto = new ExpensesDto(date, amount,expenseType,addressee,amount);
            expensesDaoH2.insert(expensesDto);
            System.out.println(expensesDto);

        }while (!(salir == 1));

    }

//
//                    do {
//                        System.out.println("ingrese el typo de gastos");
//                        expenseType= scanner.nextLine();
//
//                        System.out.println("ingrese su destinatario");
//                        addressee= scanner.nextLine();
//
//                        System.out.println("ingrese el monto");
//                        amount = scanner.nextInt();
//                        expenses= new Expenses(expenseType,addressee,amount);
//                        totalCompra+=amount;
//
//                        System.out.println("para salir seleccione 1");
//                        salir = scanner.nextInt();
//                        scanner.nextLine();
//                    }while (!(salir == 1));
//
//
//                    System.out.println("detalle del gasto: "+
//                            "Numero de comprobante: "+
//                            "\nFecha: "+ expenses.getDate()+
//                            "\nTypo de gasto: "+ expenseType+
//                            "\nDestino: "+ addressee+
//                            "\nmonto gastado: "+amount);
//
//                }else{
//                    System.out.println("Ingrese una opcion correcta!");
//                }
//
//            }else{
//                System.out.println("ingrese un numero");
//                System.out.println("Para crear ingreso escriba  1");
//                System.out.println("Para crear gasto escriba  2");
//            }
//
//        }while (isCorrect);
//        System.out.println("Para crear ingreso escriba  1");
//        System.out.println("Para crear gasto escriba  2");

}
