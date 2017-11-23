package by.tr.web.task_3_3.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.tr.web.task_3_3.dao.DAOFactory;
import by.tr.web.task_3_3.dao.MovieDAO;
import by.tr.web.task_3_3.dao.exception.DAOException;
import by.tr.web.task_3_3.domain.Movie;
import by.tr.web.task_3_3.service.MovieService;
import by.tr.web.task_3_3.service.exception.ServiceException;

public class MovieServiceImpl implements MovieService {

	@Override
	public List<Movie> parse(String parserType) throws ServiceException {
		List<Movie> movies = null;
		DAOFactory factory = DAOFactory.getInstance();
		MovieDAO movieDAO = factory.getMovieDAO();
		try {
			movies = movieDAO.parse(parserType);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		if (movies == null) {
			movies =  new ArrayList<Movie>();
		}
		return movies;
	}

}
