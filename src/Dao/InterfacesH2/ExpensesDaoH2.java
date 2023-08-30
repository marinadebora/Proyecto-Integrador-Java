package Dao.InterfacesH2;

import Dao.dto.ExpensesDto;

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
