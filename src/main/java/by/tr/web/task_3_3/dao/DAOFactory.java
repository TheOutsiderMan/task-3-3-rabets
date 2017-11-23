package by.tr.web.task_3_3.dao;

import by.tr.web.task_3_3.dao.impl.MovieDAOImpl;

public final class DAOFactory {
	
	private static final DAOFactory factory =  new DAOFactory();
	private final MovieDAO movieDAO = new MovieDAOImpl();
	
	private DAOFactory() {

	}
	
	public static DAOFactory getInstance() {
		return factory;
	}
	
	public MovieDAO getMovieDAO() {
		return movieDAO;
	}
}
