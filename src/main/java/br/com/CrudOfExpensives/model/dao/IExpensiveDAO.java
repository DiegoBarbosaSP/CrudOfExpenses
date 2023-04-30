package br.com.CrudOfExpensives.model.dao;

import br.com.CrudOfExpensives.model.Category;
import br.com.CrudOfExpensives.model.Expensive;

import java.util.List;
import java.util.Optional;

public interface IExpensiveDAO {
    Expensive save(Expensive expensive);
    Expensive update(Expensive expensive);
    void delete(Integer id);
    List<Expensive> findaAll();
    Optional<Expensive>findaById(Integer id);
    List<Expensive> findByCategory(Category category);
}
