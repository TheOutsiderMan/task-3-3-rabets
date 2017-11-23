package by.tr.web.task_3_3.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tr.web.task_3_3.service.MovieService;
import by.tr.web.task_3_3.service.ServiceFactory;
import by.tr.web.task_3_3.service.exception.ServiceException;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PARAM_PARSER = "parser-type";
	private static final String ENCODING = "utf-8";
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(ENCODING);
		
		String parserType = request.getParameter(PARAM_PARSER);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		MovieService movieService = factory.getMovieService();
		try {
			movieService.parse(parserType);
		} catch (ServiceException e) {
			System.err.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
