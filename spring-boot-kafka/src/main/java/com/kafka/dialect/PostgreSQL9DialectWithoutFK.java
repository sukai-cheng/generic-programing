package com.kafka.dialect;

import org.hibernate.dialect.PostgreSQL10Dialect;

public class PostgreSQL9DialectWithoutFK extends PostgreSQL10Dialect {
    @Override
    public String getAddForeignKeyConstraintString(
            String constraintName,
            String[] foreignKey,
            String referencedTable,
            String[] primaryKey,
            boolean referencesPrimaryKey) {
//      设置foreignkey对应的列值可以为空
        return " alter " + foreignKey[0] + " set default null ";
    }
}
