package br.com.CrudOfExpensives.model.dao;

import br.com.CrudOfExpensives.model.Category;
import br.com.CrudOfExpensives.model.Expensive;
import br.com.CrudOfExpensives.model.infra.ConnectionFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExpensiveDAO implements IExpensiveDAO {
    @Override
    public Expensive save(Expensive expensive) {
       try(Connection connection= ConnectionFactory.getConnection()) {
           // avoiding sql injection
           String sql = "INSERT INTO Expensives(descricao, valor, data, categoria) VALUES (?,?,?,?)";
           PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           preparedStatement.setString(1, expensive.getDescription());
           preparedStatement.setDouble(2, expensive.getValue());
           preparedStatement.setDate(3,java.sql.Date.valueOf(expensive.getDate()));
           preparedStatement.setString(4, expensive.getCategory().toString());

           preparedStatement.executeUpdate();

           // recovering the key of id
           ResultSet resultSet = preparedStatement.getGeneratedKeys();
           resultSet.next();
           int generatedId = resultSet.getInt(1);
           expensive.setId(generatedId);




       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

        return expensive;
    }

    @Override
    public Expensive update(Expensive expensive) {

        try(Connection connection= ConnectionFactory.getConnection()) {
            // avoiding sql injection
            String sql = "UPDATE expensives SET descricao =?, valor = ?, data = ?, categoria = ? WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, expensive.getDescription());
            preparedStatement.setDouble(2, expensive.getValue());
            preparedStatement.setDate(3,java.sql.Date.valueOf(expensive.getDate()));
            preparedStatement.setString(4, expensive.getCategory().toString());
            preparedStatement.setLong(5, expensive.getId());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return expensive;
    }

    @Override
    public void delete(Integer id) {


        try(Connection connection= ConnectionFactory.getConnection()) {
            // avoiding sql injection
            String sql = "DELETE FROM expensives WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Expensive> findaAll() {
        String sql = "SELECT id, descricao, data, valor, categoria FROM expensives";
        List<Expensive> expensives = new ArrayList<>();

        try(Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
               Integer id = resultSet.getInt(1);
               String descricao = resultSet.getString(2);
               LocalDate data = resultSet.getDate(3).toLocalDate();
               Double valor = resultSet.getDouble(4);
               Category categoria = Category.valueOf(resultSet.getString(5));

              Expensive expensive1 = new Expensive(id, descricao,data,valor,categoria);
              expensives.add(expensive1);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return expensives;
    }

    @Override
    public Optional<Expensive> findaById(Integer id) {
        String sql = "SELECT id, descricao, data, valor, categoria FROM expensives WHERE id = ?";
        Expensive expensive = null;


        try(Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Integer pkey = resultSet.getInt(1);
                String descricao = resultSet.getString(2);
                LocalDate data = resultSet.getDate(3).toLocalDate();
                Double valor = resultSet.getDouble(4);
                Category categoria = Category.valueOf(resultSet.getString(5));

                expensive = new Expensive(pkey, descricao,data,valor,categoria);

            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(expensive);
    }

    @Override
    public List<Expensive> findByCategory(Category category) {
        String sql = "SELECT id, descricao, data, valor, categoria FROM expensives WHERE categoria = ?";
        List<Expensive> expensives = new ArrayList<>();

        try(Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Integer id = resultSet.getInt(1);
                String descricao = resultSet.getString(2);
                LocalDate data = resultSet.getDate(3).toLocalDate();
                Double valor = resultSet.getDouble(4);
                Category cat = Category.valueOf(resultSet.getString(5));

                Expensive expensive1 = new Expensive(id, descricao,data,valor,cat);
                expensives.add(expensive1);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return expensives;
    }
}
