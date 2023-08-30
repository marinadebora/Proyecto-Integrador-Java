import Dao.InterfacesH2.ProductDaoH2;
import Dao.dto.ProductDto;
import Dao.exception.InvalidException;
import Dao.impl.PructDaoH2Impl;
import Major.Selectoption;

import static Major.CreateProducts.createProducts;

public class Main {
    public static void main(String[] args) {

       //CreateAction.createAction();
//        ExpensesDaoH2 expenses= new ExpensesDaoH2Impl();
//        expenses.getAll();
//        SaleDaoH2 sale = new SaleDaoH2Impl();
//        sale.getAll();

       // selectAction();

//
//        ProductDto productDto = new ProductDto("Pantalon","Riffle",17600.00);
//        productDaoH2.insert(productDto);
        try {
            Selectoption.selectOption();
        } catch (InvalidException e) {
            throw new RuntimeException(e);
        }
    }

}

