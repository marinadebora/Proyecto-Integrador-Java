package Major;

import Dao.InterfacesH2.SaleDaoH2;
import Dao.dto.SaleDto;
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

    List<SaleDto> saleDtoList = null;
    try {
      saleDtoList = saleDaoH2.getAll();
    } catch (DAOException e) {
      throw new RuntimeException(e);
    }
    List<SaleDto> todayFilter = saleDtoList.stream()
            .filter(e->date.contains(today))

           .toList();

  }
  public static double calcularSuma(double num){

    double suma = 0;
    return suma+num;
  }
}
