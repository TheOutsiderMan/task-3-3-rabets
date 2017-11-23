package by.tr.web.task_3_3.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import by.tr.web.task_3_3.dao.MovieDAO;
import by.tr.web.task_3_3.dao.ParserType;
import by.tr.web.task_3_3.dao.exception.DAOException;
import by.tr.web.task_3_3.dao.util.parser.sax.MovieSAXParser;
import by.tr.web.task_3_3.dao.util.parser.stax.MovieStAXParser;
import by.tr.web.task_3_3.domain.Movie;

public class MovieDAOImpl implements MovieDAO {
	
	private final static String PATH = "src\\main\\resources\\source.xml";
	
	@Override
	public List<Movie> parse(String parserType) throws DAOException {
		List<Movie> movies = null;
		ParserType type = ParserType.valueOf(parserType.toUpperCase());
		switch (type) {
		case SAX:
			MovieSAXParser saxParser = new MovieSAXParser();
			try {
				saxParser.parse(PATH);
			} catch (SAXException e) {
				throw new DAOException("SAX parser problem", e);
			} catch (IOException e) {
				throw new DAOException("IO SAX parser problem", e);
			}

			break;
		case STAX:
			MovieStAXParser staxParser = new MovieStAXParser();
			try {
				staxParser.parse(PATH);
			} catch (FileNotFoundException e) {
				throw new DAOException("file problem", e);
			} catch (XMLStreamException e) {
				throw new DAOException("StAX parser problem", e);
			}
			break;
		case DOM:
			
			break;
		}
		if (movies == null) {
			movies =  new ArrayList<Movie>();
		}
		return movies;
	}

}
