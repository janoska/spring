package org.jboss.tools.example.springmvc.mvc;

import org.jboss.tools.example.springmvc.repo.Datasource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by janos on 2015.01.24..
 */
@Controller
@RequestMapping(value="/janos")
public class HomeController {

    @RequestMapping(method= RequestMethod.GET)
    public String get(ModelMap model) throws SQLException, NamingException {
        String email = null;
        Datasource datasource = new Datasource();
        Connection result = null;
        result = datasource.getDatasource().getConnection();
        Statement stmt = result.createStatement() ;
        String query = "select * from Member;" ;
        ResultSet rs = stmt.executeQuery(query) ;
        while (rs.next()) {
            email = rs.getString(2);
        }
        model.addAttribute("email", email);
        return "janos";
    }
}
