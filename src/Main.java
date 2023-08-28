import Dao.Interfaces.ExpensesDaoH2;
import Dao.Interfaces.SaleDaoH2;
import Dao.dto.SaleDto;
import Dao.impl.ExpensesDaoH2Impl;
import Dao.impl.SaleDaoH2Impl;
import Major.CreateAction;
import Models.Expenses;

import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) {

       // CreateAction.createAction();
//        ExpensesDaoH2 expenses= new ExpensesDaoH2Impl();
//        expenses.getAll();
        SaleDaoH2 sale = new SaleDaoH2Impl();
        sale.getAll();

    }

}

