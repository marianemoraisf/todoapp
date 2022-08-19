package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

public class TaskController {
    public void save(Task task) {
        String sql = "INSERT INTO tasks (idProject, name, description, completed, notes, deadline, created, updated) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new java.sql.Date(task.getDeadline().getTime()));
            statement.setDate(7, new java.sql.Date(task.getCreated().getTime()));
            statement.setDate(8, new java.sql.Date(task.getUpdated().getTime()));
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar a tarefa. " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void update(Task task) {        
        String sql = "UPDATE tasks SET idProject = ?, name = ?, description = ?, completed = ?, notes = ?, deadline = ?, created = ?, updated = ? WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {      
            connection = ConnectionFactory.getConnection(); //Estabelecendo a conexão com o banco de dados
            statement = connection.prepareStatement(sql); //Preparando a query
            //Setando os valores do statement
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new java.sql.Date(task.getDeadline().getTime()));
            statement.setDate(7, new java.sql.Date(task.getCreated().getTime()));
            statement.setDate(8, new java.sql.Date(task.getUpdated().getTime()));
            statement.setInt(9, task.getId());            
            statement.execute(); //Executando a query
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar a tarefa. " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void removeById(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection(); //Criação da conexão com o banco de dados
            statement = connection.prepareStatement(sql); //Preparando a query
            statement.setInt(1, id); //Substitui o ? da variavel sql para o id que será enviado como parametro
            statement.execute(); //Executando no banco 
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar a tarefa. " + ex.getMessage(), ex); 
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public List<Task> getAll(int id) {
        
        String sql = "SELECT * FROM tasks WHERE idProject = ?";
        
        //Lista de tarefas que será devolvida quando a chamada do método acontecer
        List<Task> tasks = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
                   
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id); //Setando valor que corresponde ao filtro de busca
            resultSet = statement.executeQuery(); //Valor retornado pela execução da query
            
            //Enquanto houverem valores a serem percorridos no resultSet
            while(resultSet.next()){
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setCompleted(resultSet.getBoolean("completed"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreated(resultSet.getDate("created"));
                task.setUpdated(resultSet.getDate("updated"));
                tasks.add(task);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar tarefas. " + ex.getMessage(), ex); 
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }       
        
        //Lista de tarefas que foi criada e carregado do banco de dados
        return tasks;
        
        
    }
}
