package br.com.CrudOfExpensives.model.infra;

import br.com.CrudOfExpensives.model.dao.ExpensiveDAO;

public class RemoveExpensives {
    public static void main(String[] args) {

        ExpensiveDAO dao = new ExpensiveDAO();
        dao.delete(4);
    }
}
