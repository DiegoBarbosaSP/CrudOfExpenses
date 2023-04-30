package br.com.CrudOfExpensives.model;

import br.com.CrudOfExpensives.model.dao.ExpensiveDAO;

import java.util.List;

public class application {
    public static void main(String[] args) {

        ExpensiveDAO expensiveDAO = new ExpensiveDAO();
//        List<Expensives>expensives = expensivesDAO.findaAll();
//
//        for (Expensives expensives1 : expensives) {
//            System.out.println("ID:" + expensives1.getId());
//            System.out.println("Descricao:" + expensives1.getDescription());
//            System.out.println("Valor:" + expensives1.getValue());
//        }

//        Optional<Expensives> expensivesOptional = expensivesDAO.findaById(2);
//        expensivesOptional.ifPresent(expensives -> {
//            System.out.println("ID:" + expensives.getId());
//            System.out.println("Descricao:" + expensives.getDescription());
//            System.out.println("Valor:" + expensives.getValue());
//        });

        List<Expensive>expensives = expensiveDAO.findByCategory(Category.RENT);
            for (Expensive expensive1 : expensives) {
            System.out.println("ID:" + expensive1.getId());
            System.out.println("Descricao:" + expensive1.getDescription());
            System.out.println("Categoria:" + expensive1.getCategory());
            System.out.println("Valor:" + expensive1.getValue());
            System.out.println("====================================");
        }

    }
}
