package Dao.impl;

import Config.JdbcConfig;
import Dao.InterfacesH2.ExpensesDaoH2;
import Dao.dto.ExpensesDto;
import Exceptions.DAOException;
import Models.Expenses;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpensesDaoH2Impl implements ExpensesDaoH2 {
  private  final Connection connection;
  public ExpensesDaoH2Impl() {
    this.connection = JdbcConfig.getDBConnection();
  }

  public ExpensesDaoH2Impl(Connection connection) {
    this.connection = connection;
  }

  PreparedStatement preparedStatement = null;
  @Override
  public void insert(ExpensesDto expensesDto) throws DAOException {
    Expenses expenses = new Expenses();
    expenses.setExpenseType(expensesDto.getExpenseType());
    expenses.setAddressee(expensesDto.getAddressee());
    expenses.setAmount(expensesDto.getAmount());
    expenses.setDate(expensesDto.getDate());
    expenses.setTotal(expensesDto.getTotal());
    try {
      preparedStatement = connection.prepareStatement(
          "INSERT INTO EXPENSES (EXPENSETYPE, ADDRESSEE ,AMOUNT  ,DATE  ,TOTAL ) VALUES (?,?,?,?,?)");
     preparedStatement.setString(1,expenses.getExpenseType());
     preparedStatement.setString(2,expenses.getAddressee());
     preparedStatement.setDouble(3,expenses.getAmount());
     preparedStatement.setString(4, expenses.getDate());
     preparedStatement.setDouble(5, expenses.getTotal());
     preparedStatement.executeUpdate();

    } catch (SQLException e) {
      throw new DAOException("error al intentar crear un gasto",e);
    }
  }

  @Override
  public List<ExpensesDto>  getAll() throws DAOException{
    List<ExpensesDto> expensesList = new ArrayList<>();
    try {
      preparedStatement = connection.prepareStatement("SELECT * FROM EXPENSES");
      ResultSet result = preparedStatement.executeQuery();

  while (result.next()){
    ExpensesDto expensesDto = new ExpensesDto();
    expensesDto.setExpenseType(result.getString("EXPENSETYPE"));
    expensesDto.setAddressee(result.getString("ADDRESSEE"));
    expensesDto.setAmount(result.getDouble("AMOUNT"));
    expensesDto.setDate(result.getString("DATE"));
    expensesDto.setTotal(result.getDouble("TOTAL"));
    expensesList.add(expensesDto);
  }

    } catch (SQLException e) {
      throw new DAOException("error al buscar gastos",e);
    }
    return expensesList;
  }
}
