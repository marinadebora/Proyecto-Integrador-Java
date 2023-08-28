package Dao.Interfaces;

import Dao.dto.SaleDto;
import Models.Sale;

import java.util.List;

public interface SaleDaoH2 {
    //CREATE
    void insert(SaleDto saleDto);
    //READ
    void getAll();
    //UPDATE
    void update(SaleDto saleDto);
    //DELETE
    void delete(int saleId);
}
