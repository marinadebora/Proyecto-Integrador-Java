package Dao.InterfacesH2;

import Dao.dto.ExpensesDto;
import Exceptions.DAOException;

public interface ExpensesDaoH2 {
  //CREATE
  void insert(ExpensesDto expensesDto) throws DAOException;
  //READ
  void getAll()throws DAOException;


}
