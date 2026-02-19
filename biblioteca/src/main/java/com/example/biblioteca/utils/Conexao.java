package com.example.biblioteca.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private final static String URL = "jdbc:mysql://localhost:3306/biblioteca?useSSL=false&serverTimezone=UTC";
    private final static String USER = "root";
    private final static String SENHA = "";

    public static Connection Conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, SENHA);
    }
}
