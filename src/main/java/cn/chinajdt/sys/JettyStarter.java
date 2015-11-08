package cn.chinajdt.sys;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jacky on 15/11/5.
 */
public class JettyStarter extends AbstractHandler {


    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        httpServletResponse.setContentType("text/html;charset=utf-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        request.setHandled(true);
        httpServletResponse.getWriter().println("<h1>Hello World</h1>");
    }

    public static void main( String[] args ) throws Exception{
        int _port = 8080 ;
        try {
            _port = Integer.valueOf(args[0]);
        }catch ( Exception e ){}
        Server _server = new Server( _port ) ;
        _server.setHandler( new JettyStarter() );
        _server.start();
        _server.join();
    }
}
