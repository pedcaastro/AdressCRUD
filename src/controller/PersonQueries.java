package controller;

import models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PersonQueries {
    private static final String URL =  "jdbc:mysql://localhost:3306/wm";
    private static final String USERNAME = "root";
    public static final String PASSWORD = "pedro123";

    private Connection connection;
    private PreparedStatement selectAllPeople;
    private PreparedStatement selectPeopleByLastName;
    private PreparedStatement insertNewPerson;

    public PersonQueries(){
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            selectAllPeople = connection.prepareStatement("SELECT * FROM person");
            selectPeopleByLastName = connection.prepareStatement("SELECT * FROM person where lastName = ?");
            insertNewPerson = connection.prepareStatement("INSERT INTO person" + "(firstName,lastName,email,phoneNumber)" + "Values(?,?,?,?)");
            System.out.println("Sucesso!");

        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
            System.out.println("Erro ao acessar00: "+ sqlException.getMessage());
            System.exit(1);
        }
    }

    public List<Person> getAllPeople(){
        ResultSet resultSet = null;
        List<Person> results = null;


        try {
            resultSet = selectAllPeople.executeQuery();
            results = new ArrayList<Person>();

            while (resultSet.next()){
                results.add(new Person(
                        resultSet.getInt("adressID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber")
                ));
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
            System.out.println("Erro ao acessar0: "+ sqlException.getMessage());
        }
        finally {
            try {
                resultSet.close();
            }
            catch (SQLException sqlException){
                sqlException.printStackTrace();
                System.out.println("Erro ao acessar1: "+ sqlException.getMessage());
                close();
            }
        }
        return results;
    }

    public List<Person> getPeopleByLastName(String name){
        List<Person> results = null;
        ResultSet resultSet = null;

        try {
            selectPeopleByLastName.setString(1,name);
            resultSet = selectPeopleByLastName.executeQuery();
            results = new ArrayList<Person>();

            while (resultSet.next()){
                results.add(new Person(
                        resultSet.getInt("adressID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber")
                ));
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
            System.out.println("Erro ao acessar2: "+ sqlException.getMessage());
        }

        finally {
            try {
                resultSet.close();
            }
            catch (SQLException sqlException){
                sqlException.printStackTrace();
                System.out.println("Erro ao acessar3: "+ sqlException.getMessage());
                close();
            }
        }
        return  results;
    }

    public int addPerson(
            String fname,String lname,String email,String num)
    {
        int result = 0;

        try {
            insertNewPerson.setString(1,fname);
            insertNewPerson.setString(2,lname);
            insertNewPerson.setString(3,email);
            insertNewPerson.setString(4,num);

            result = insertNewPerson.executeUpdate();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
            System.out.println("Erro ao acessar4: "+ sqlException.getMessage());
            close();
        }
        return result;
    }

    public void close(){
        try {
            connection.close();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
            System.out.println("Erro ao acessar5: "+ sqlException.getMessage());

        }
    }
}
