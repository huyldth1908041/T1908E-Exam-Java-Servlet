package com.t1908e.exam_wad.test;

import com.t1908e.exam_wad.entity.Employee;
import com.t1908e.exam_wad.exception.EntityException;
import com.t1908e.exam_wad.modelAnnotation.Column;
import com.t1908e.exam_wad.modelAnnotation.Entity;
import com.t1908e.exam_wad.modelAnnotation.ForeignKey;
import com.t1908e.exam_wad.modelAnnotation.Id;
import com.t1908e.exam_wad.util.ConnectionHelper;
import com.t1908e.exam_wad.util.SQLConstant;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        createTable(Employee.class);
    }
    private static void createTable(Class clazz) {
        try{

            if (!clazz.isAnnotationPresent(Entity.class)) {
                throw new EntityException("Not an entity class");
            }
            Entity currentEntity = (Entity) clazz.getAnnotation(Entity.class);
            //build sql cmd
            StringBuilder stringCmd = new StringBuilder();
            stringCmd.append(SQLConstant.CREATE_TABLE);
            stringCmd.append(SQLConstant.SPACE);
            stringCmd.append(currentEntity.tableName());
            stringCmd.append(SQLConstant.SPACE);
            stringCmd.append(SQLConstant.OPEN_PARENTHESES);
            Field[] fields = clazz.getDeclaredFields();

            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                if (!field.isAnnotationPresent(Column.class)) {
                    continue;
                }
                Column currentColumn = field.getAnnotation(Column.class);
                stringCmd.append(currentColumn.columnName());
                stringCmd.append(SQLConstant.SPACE);
                stringCmd.append(currentColumn.columnType());
                //id checker
                if (field.isAnnotationPresent(Id.class)) {
                    Id currentId = (Id) field.getAnnotation(Id.class);
                    stringCmd.append(SQLConstant.SPACE);
                    stringCmd.append(SQLConstant.PRIMARY_KEY);
                    //auto icreament checker
                    if (currentId.AutoIncrement()) {
                        stringCmd.append(SQLConstant.SPACE);
                        stringCmd.append(SQLConstant.AUTO_INCREMENT);
                    }
                }
                stringCmd.append(SQLConstant.COMMA);
                stringCmd.append(SQLConstant.SPACE);
                if (field.isAnnotationPresent(ForeignKey.class)) {
                    ForeignKey foreignKeyInformation = (ForeignKey) field.getAnnotation(ForeignKey.class);
                    String refColumn = foreignKeyInformation.referenceColumn();
                    String refTable = foreignKeyInformation.referenceTable();
                    stringCmd.append(SQLConstant.FOREIGN_KEY);
                    stringCmd.append(SQLConstant.SPACE);
                    stringCmd.append(SQLConstant.OPEN_PARENTHESES);
                    stringCmd.append(currentColumn.columnName());
                    stringCmd.append(SQLConstant.CLOSE_PARENTHESES);
                    stringCmd.append(SQLConstant.SPACE);
                    stringCmd.append(SQLConstant.REFERENCES);
                    stringCmd.append(SQLConstant.SPACE);
                    stringCmd.append(refTable);
                    stringCmd.append(SQLConstant.OPEN_PARENTHESES);
                    stringCmd.append(refColumn);
                    stringCmd.append(SQLConstant.CLOSE_PARENTHESES);
                    stringCmd.append(SQLConstant.COMMA);
                    stringCmd.append(SQLConstant.SPACE);
                }

            }
            stringCmd.setLength(stringCmd.length() - 2);
            stringCmd.append(SQLConstant.CLOSE_PARENTHESES);

            Connection connection = ConnectionHelper.getConnection();
            if(connection == null) {
                throw new EntityException("Can not connect to db");
            }
            connection.createStatement().execute(stringCmd.toString());
        } catch (SQLException | EntityException throwables) {
            System.out.println(throwables.getMessage());
        }
    }
}
