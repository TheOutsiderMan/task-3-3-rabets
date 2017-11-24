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
import by.tr.web.task_3_3.dao.util.parser.dom.MovieDOMParser;
import by.tr.web.task_3_3.dao.util.parser.sax.MovieSAXParser;
import by.tr.web.task_3_3.dao.util.parser.stax.MovieStAXParser;
import by.tr.web.task_3_3.domain.Movie;

public class MovieDAOImpl implements MovieDAO {
	
	private final static String PATH = "source.xml";
	
	@Override
	public List<Movie> parse(String parserType) throws DAOException {
		List<Movie> movies = null;
		ParserType type = ParserType.valueOf(parserType.toUpperCase());
		switch (type) {
		case SAX:
			MovieSAXParser saxParser = new MovieSAXParser();
			try {
				movies = saxParser.parse(PATH);
			} catch (SAXException e) {
				System.err.println(e);
				throw new DAOException("SAX parser problem", e);
			} catch (IOException e) {
				System.err.println(e);
				throw new DAOException("IO SAX parser problem", e);
			}

			break;
		case STAX:
			MovieStAXParser staxParser = new MovieStAXParser();
			try {
				movies = staxParser.parse(PATH);
			} catch (FileNotFoundException e) {
				System.err.println(e);
				throw new DAOException("file problem", e);
			} catch (XMLStreamException e) {
				System.err.println(e);
				throw new DAOException("StAX parser problem", e);
			}
			break;
		case DOM:
			MovieDOMParser domParser = new MovieDOMParser();
			try {
				movies = domParser.parse(PATH);
			} catch (SAXException e) {
				System.err.println(e);
				throw new DAOException("DOM parser problem", e);
			} catch (IOException e) {
				System.err.println(e);
				throw new DAOException("IO DOM parser problem", e);
			}
			break;
		}
		if (movies == null) {
			return new ArrayList<Movie>();
		}
		return movies;
	}

}
