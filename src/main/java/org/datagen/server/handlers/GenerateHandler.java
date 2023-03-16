package org.datagen.server.handlers;

import org.datagen.generator.UserDatapoolGenerator;
import org.datagen.generator.UserGenerator;
import org.datagen.io.Writer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateHandler extends HttpServlet {

    private static final UserDatapoolGenerator userDatapoolGenerator;

    static {
        userDatapoolGenerator = new UserDatapoolGenerator(new UserGenerator(),new Writer());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        BufferedReader reader = req.getReader();
        List<String> collect = reader.lines().collect(Collectors.toList());
        reader.close();
        userDatapoolGenerator.generateUsers(getCountParam(collect));
        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("{ \"status\": \"ok\"}");
    }

    private int getCountParam(List<String> params){
        return Integer.parseInt(params.get(1).split(":")[1].split("\"")[1]);
    }
}
