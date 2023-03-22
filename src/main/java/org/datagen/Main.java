package org.datagen;

import org.datagen.server.handlers.GenerateHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;


public class Main {

    public static void main(String[] args) throws Exception {

        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8090);
        server.addConnector(connector);
        System.out.println(server.getURI().toString());

        ServletHandler context = new ServletHandler();
        context.addServletWithMapping(GenerateHandler.class,"/generate");
        server.setHandler(context);

        server.start();
    }
}
