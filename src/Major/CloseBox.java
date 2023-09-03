package Major;

import Dao.InterfacesH2.ExpensesDaoH2;
import Dao.InterfacesH2.SaleDaoH2;
import Dao.dto.BoxDto;
import Dao.dto.CloseBoxDto;
import Dao.dto.ExpensesDto;
import Dao.dto.SaleDto;
import Dao.impl.ExpensesDaoH2Impl;
import Dao.impl.SaleDaoH2Impl;
import Exceptions.DAOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class CloseBox {
  public static void closeBox(){
    String date = String.valueOf(new Date());
    final String today = date.substring(0, 10);
    SaleDaoH2 saleDaoH2 = new SaleDaoH2Impl();
    ExpensesDaoH2 expensesDaoH2 = new ExpensesDaoH2Impl();

    List<SaleDto> saleDtoList = null;
    try {
      saleDtoList = saleDaoH2.getAll();
    } catch (DAOException e) {
      throw new RuntimeException(e);
    }

    List<SaleDto> todaySaleFilter = saleDtoList.stream()
            .filter(e->date.contains(today))
           .toList();
    List<Double> saleFilter=todaySaleFilter.stream()
        .map(BoxDto::getTotal)
        .toList();
    List<ExpensesDto> expensesDtoList = null;
    try {
     expensesDtoList = expensesDaoH2.getAll();
    } catch (DAOException e) {
      throw new RuntimeException(e);
    }


    List<ExpensesDto> todayExpenseFilter = expensesDtoList.stream()
        .filter(e->date.contains(today))
        .toList();
    List<Double> expenseFilter=todayExpenseFilter.stream()
        .map(BoxDto::getTotal)
        .toList();

    int addSale = saleFilter.stream().mapToInt(Double::intValue).sum();
    int addExpense = expenseFilter.stream().mapToInt(Double::intValue).sum();
    int totalBox = addSale - addExpense;

    System.out.println(date+"\nVenta total del dia : "+ addSale + "\n Gasto total del dia: "+ addExpense + "\n Total de Caja: "+totalBox);


  }

}
