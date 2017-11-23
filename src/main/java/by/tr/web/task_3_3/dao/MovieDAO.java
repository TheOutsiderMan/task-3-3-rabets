package by.tr.web.task_3_3.dao;

import java.util.List;

import by.tr.web.task_3_3.dao.exception.DAOException;
import by.tr.web.task_3_3.domain.Movie;

public interface MovieDAO {
	
	List<Movie> parse(String parserType) throws DAOException;
}
