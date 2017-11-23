package by.tr.web.task_3_3.service;

import java.util.List;

import by.tr.web.task_3_3.domain.Movie;
import by.tr.web.task_3_3.service.exception.ServiceException;

public interface MovieService {
	
	List<Movie> parse(String parserType) throws ServiceException;
}
