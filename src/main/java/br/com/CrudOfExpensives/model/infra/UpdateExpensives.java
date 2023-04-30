package br.com.CrudOfExpensives.model.infra;

import br.com.CrudOfExpensives.model.Category;
import br.com.CrudOfExpensives.model.Expensive;
import br.com.CrudOfExpensives.model.dao.ExpensiveDAO;

import java.time.LocalDate;
import java.util.Optional;

public class UpdateExpensives {
    public static void main(String[] args) {
         ExpensiveDAO dao = new ExpensiveDAO();
         Optional<Expensive> optionalExpensives = dao.findaById(5);

         Expensive expensive = optionalExpensives.get();
        System.out.println(expensive.getId());
        System.out.println(expensive.getDescription());
        System.out.println(expensive.getDate());
        System.out.println(expensive.getValue());
        System.out.println(expensive.getCategory());

        expensive.setDescription("Dentist");
        expensive.setDate(LocalDate.of(2023,05,30));
        expensive.setValue(300.00);
        expensive.setCategory(Category.INSURANCE);

        dao.update(expensive);
    }
}
