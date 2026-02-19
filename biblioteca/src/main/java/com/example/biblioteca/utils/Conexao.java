package com.example.biblioteca.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private final static String URL = "";
    private final static String USER = "root";
    private final static String SENHA = "";

    public static Connection Conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, SENHA);
    }
}
