package org.datagen;


import org.datagen.generator.UserDatapoolGenerator;
import org.datagen.generator.UserGenerator;
import org.datagen.io.Writer;

import org.datagen.server.handlers.GenerateHandler;
import org.datagen.server.handlers.TestHandler;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

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
