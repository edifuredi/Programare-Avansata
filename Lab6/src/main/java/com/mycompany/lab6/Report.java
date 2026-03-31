/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */
public class Report {

    public static void generate() throws Exception {

        List<Map<String, String>> movies = new ArrayList<>();

        Connection con = Database.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM movie_report");

        while (rs.next()) {
            Map<String, String> m = new HashMap<>();
            m.put("title", rs.getString("title"));
            m.put("genre", rs.getString("genre"));
            movies.add(m);
        }

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
        cfg.setDirectoryForTemplateLoading(new File("."));

        Template t = cfg.getTemplate("template.ftl");

        Map<String, Object> data = new HashMap<>();
        data.put("movies", movies);

        Writer out = new FileWriter("report.html");
        t.process(data, out);
        out.close();
    }
}
