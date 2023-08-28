package Dao.Interfaces;

import Dao.dto.ExpensesDto;
import Dao.dto.SaleDto;
import Models.Expenses;
import Models.Sale;

import java.util.List;

public interface ExpensesDaoH2 {
  //CREATE
  void insert(ExpensesDto expensesDto);
  //READ
  void getAll();
  //UPDATE
  void update(ExpensesDto expensesDto);
  //DELETE
  void delete(int expensesId);
}
