package com.movie.servlets;

import javax.servlet.http.HttpServlet;

/**
 *
 * @author Aloren
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
// Servlet imports
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Movie database generated classes

public class MoviesServlet extends HttpServlet {

//    /**
//     * The Movies database object
//     */
//    private Movies movies = null;
//    /**
//     * Any error that occurred.
//     */
//    private String errorMessage = null;
//    /**
//     * The XML document storing the movie database
//     */
//    private static final String MOVIES_XML_DOCUMENT = "/dev/javajaxb/ch04/src/xml/movies.xml";
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//// Load the database using JAXB
//        try {
//// Load the XML
//            File xmlFile = new File(MOVIES_XML_DOCUMENT);
//            FileInputStream inputStream = new FileInputStream(xmlFile);
//// Unmarshal
//            movies = Movies.unmarshal(inputStream);
//        } catch (Exception e) {
//            errorMessage = e.getMessage();
//        }
//    }
//
//    @Override
//    public void doGet(HttpServletRequest req, HttpServletResponse res)
//            throws IOException, ServletException {
//// Handle any error conditions that might have occurred.
//        if (movies == null) {
//            error(res);
//        }
//// Get output stream
//        PrintWriter out = res.getWriter();
//        res.setContentType("text/html");
//// Write out movie database
//        out.println("<HTML><HEAD><TITLE>Movie Database</TITLE></HEAD>");
//        out.println("<BODY>");
//        out.println("<H2 ALIGN='center'>Movie Database</H2>");
//        List movieList = movies.getMovie();
//        for (Iterator i = movieList.iterator(); i.hasNext();) {
//            Movie movie = (Movie) i.next();
//// Title
//            out.print("<B><FONT SIZE='+1'>");
//            out.print(movie.getTitle());
//            out.println("</FONT></B><BR />");
//// Director
//            String director = movie.getDirector();
//            if (director != null) {
//                out.print("Director: ");
//                out.print(director);
//                out.println("<BR />");
//            }
//// Producer
//            out.println("Producers:<BR /><UL>");
//            List producerList = movie.getProducer();
//            for (Iterator j = producerList.iterator(); j.hasNext();) {
//                out.print("<LI>");
//                out.print((String) j.next());
//                out.println("</LI>");
//            }
//            out.println("</UL>");
//// Cast
//            out.println("Starring:<BR /><UL>");
//            Cast cast = movie.getCast();
//            List actorList = cast.getActor();
//            for (Iterator j = actorList.iterator(); j.hasNext();) {
//                Actor actor = (Actor) j.next();
//                out.print("<LI>");
//                out.print(actor.getContent());
//                if (actor.getHeadliner().equalsIgnoreCase("true")) {
//                    out.print(" (Headliner)");
//                }
//                out.println("</LI>");
//            }
//            out.println("</UL>");
//            out.println("<HR WIDTH='80%' />");
//        }
//        out.println("</BODY></HTML>");
//        out.close();
//    }
//
//    @Override
//    public void doPost(HttpServletRequest req, HttpServletResponse res)
//            throws IOException, ServletException {
//// Get action paramater; default is "list"
//        String[] actionValues = req.getParameterValues("action");
//        String action = null;
//        if ((actionValues == null) || (actionValues[0] == null)) {
//            action = "list";
//        } else {
//            action = actionValues[0];
//        }
//// Handle different actions
//        PrintWriter out = res.getWriter();
//        res.setContentType("text/plain");
//        /* **** List current movies **** */
//        if (action.equalsIgnoreCase("list")) {
//            out.write(" ***** Movies Database *****\n\n");
//// Print out each movie
//            List movieList = movies.getMovie();
//            for (Iterator i = movieList.iterator(); i.hasNext();) {
//                Movie movie = (Movie) i.next();
//// Title
//                out.print(" Movie: ");
//                out.println(movie.getTitle());
//// Director
//                String director = movie.getDirector();
//                if (director != null) {
//                    out.print(" Director: ");
//                    out.println(director);
//                    out.println();
//                }
//// Producer
//                out.println(" Producers:");
//                List producerList = movie.getProducer();
//                for (Iterator j = producerList.iterator(); j.hasNext();) {
//                    out.print(" * ");
//                    out.print((String) j.next());
//                    out.println();
//                }
//                out.println();
//// Cast
//                out.println(" Starring:");
//                Cast cast = movie.getCast();
//                List actorList = cast.getActor();
//                for (Iterator j = actorList.iterator(); j.hasNext();) {
//                    Actor actor = (Actor) j.next();
//                    out.print(" * ");
//                    out.print(actor.getContent());
//                    if (actor.getHeadliner().equalsIgnoreCase("true")) {
//                        out.print(" (Headliner)");
//                    }
//                    out.println();
//                }
//                out.println(" -------------------------------- ");
//            }
//        } else {
//            out.write("The action supplied, '");
//            out.write(action);
//            out.write("', is not currently supported.\n");
//        }
//        out.close();
//    }
//
//    private void error(HttpServletResponse res) throws IOException {
//        PrintWriter out = res.getWriter();
//        res.setContentType("text/plain");
//        out.write(" ************* ERROR OCCURRED ***************\n\n");
//        out.write("Error: " + errorMessage + "\n");
//        out.close();
//    }
}