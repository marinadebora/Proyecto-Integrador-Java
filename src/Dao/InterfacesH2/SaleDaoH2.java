package Dao.InterfacesH2;

import Dao.dto.SaleDto;
import Exceptions.DAOException;

import java.util.List;

public interface SaleDaoH2 {
    //CREATE
    void insert(SaleDto saleDto)throws DAOException;
    //READ
    List<SaleDto> getAll()throws DAOException;


}
