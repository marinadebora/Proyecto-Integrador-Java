package Dao.InterfacesH2;

import Dao.dto.ExpensesDto;
import Exceptions.DAOException;

import java.util.List;

public interface ExpensesDaoH2 {
  //CREATE
  void insert(ExpensesDto expensesDto) throws DAOException;
  //READ
  List<ExpensesDto> getAll()throws DAOException;


}
