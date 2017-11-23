package by.tr.web.task_3_3.service;

import by.tr.web.task_3_3.service.impl.MovieServiceImpl;

public final class ServiceFactory {
	
	private static final ServiceFactory factory = new ServiceFactory();
	private final MovieService movieService = new MovieServiceImpl();
			
	private ServiceFactory() {
		
	}
	
	public static ServiceFactory getInstance() {
		return factory;
	}
	
	public MovieService getMovieService() {
		return movieService;
	}
}
