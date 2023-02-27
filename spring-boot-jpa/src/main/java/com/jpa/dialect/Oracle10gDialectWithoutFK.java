package com.jpa.dialect;

import org.hibernate.dialect.Oracle12cDialect;

public class Oracle10gDialectWithoutFK extends Oracle12cDialect {
    @Override
    public String getAddForeignKeyConstraintString(
            String constraintName,
            String[] foreignKey,
            String referencedTable,
            String[] primaryKey,
            boolean referencesPrimaryKey) {
//      通过修改外键列的默认值，而不是添加外键，避免生成外键
        return " modify " + foreignKey[0] + " default null ";
    }
}
