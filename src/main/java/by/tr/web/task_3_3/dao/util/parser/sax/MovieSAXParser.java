package by.tr.web.task_3_3.dao.util.parser.sax;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.tr.web.task_3_3.domain.Movie;

public class MovieSAXParser {
	
	public List<Movie> parse(String filepath) throws SAXException, IOException{
		XMLReader reader = XMLReaderFactory.createXMLReader();
		MovieSAXHandler handler = new MovieSAXHandler();
		reader.setContentHandler(handler);
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filepath);
		reader.parse(new InputSource(inputStream));
		List<Movie> movies = handler.getMovieList();
		if (movies == null) {
			return new ArrayList<Movie>();
		}
		return movies;
	}
}
