package by.tr.web.task_3_3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tr.web.task_3_3.domain.Movie;
import by.tr.web.task_3_3.service.MovieService;
import by.tr.web.task_3_3.service.ServiceFactory;
import by.tr.web.task_3_3.service.exception.ServiceException;

public class FrontController extends HttpServlet {
	
	private static final String END_INDEX = "end";
	private static final String BEGIN_INDEX = "begin";
	private static final String PARAM_PAGE = "page";
	private static final String CURRENT_PAGE = "currentPage";
	private static final long serialVersionUID = 1L;
	private static final String PAGES_AMOUNT = "pagesAmount";
	private static final String PATH_FORWARD = "/result";
	private static final String PARAM_PARSER = "parser_type";
	private static final String ENCODING = "utf-8";
	private static final String MOVIES_ATTR = "movies";
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(ENCODING);
		
		String parserType = request.getParameter(PARAM_PARSER);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		MovieService movieService = factory.getMovieService();
		List<Movie> movies = null;
		try {
			movies = movieService.parse(parserType);
		} catch (ServiceException e) {
			System.err.println(e);
		}
		request.setAttribute(MOVIES_ATTR, movies);
		int page = 1;
        if(request.getParameter(PARAM_PAGE) != null)
            page = Integer.parseInt(request.getParameter(PARAM_PAGE));
		int recordPerPage = 20;
		int numberOfPages = 0;
		if (movies.size() % recordPerPage == 0) {
			numberOfPages = movies.size()/recordPerPage;
		} else {
			numberOfPages = movies.size()/recordPerPage + 1;
		}
		int begin = (page - 1)*recordPerPage;
		int end = page*recordPerPage - 1;
		request.setAttribute(BEGIN_INDEX, begin);
		request.setAttribute(END_INDEX, end);
		request.setAttribute(PAGES_AMOUNT, numberOfPages);
		request.setAttribute(CURRENT_PAGE, page);
		request.getRequestDispatcher(PATH_FORWARD).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
