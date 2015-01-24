package org.jboss.tools.example.springmvc.repo;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by janos on 2015.01.24..
 */
public class Datasource {

    public DataSource getDatasource() throws NamingException {
        Context initialContext = new InitialContext();
        DataSource datasource = (DataSource)initialContext.lookup("java:jboss/datasources/ExampleDS");
        return datasource;
    }
}
