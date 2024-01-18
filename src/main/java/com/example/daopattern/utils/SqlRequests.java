package com.example.daopattern.utils;

public class SqlRequests {
    public static final String SELECT_ALL_BY_FIO = "SELECT * FROM _user WHERE surname = ? AND name = ? AND patronymic = ?";
    public static final String SELECT_BY_ID = "SELECT * FROM _user WHERE id = ? ";
    public static final String INSERT_NEW_USER = "INSERT INTO _user (surname, name, patronymic) VALUES (?, ?, ?)";
    public static final String UPDATE_EXISTED_USER =  "UPDATE _user SET surname = ?, name = ?, patronymic = ? where id = ?";
    public static final String DELETE_USER_BY_ID = "DELETE FROM _user WHERE id = ?";
}