package by.tr.web.task_3_3.dao.util.parser.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.tr.web.task_3_3.dao.util.parser.MovieTagName;
import by.tr.web.task_3_3.domain.Movie;
import by.tr.web.task_3_3.domain.Title;

public class MovieStAXParser {
	
	public List<Movie> parse(String filepath) throws FileNotFoundException, XMLStreamException {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		InputStream inputStream = new FileInputStream(filepath);
		XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
		List<Movie> movies = process(reader);
		if (movies == null) {
			return new ArrayList<Movie>();
		}
		return movies;
	}
	
	private static List<Movie> process(XMLStreamReader reader) throws XMLStreamException {
		List<Movie> movies = new ArrayList<>();
		Movie movie = null;
		Title title = null;
		MovieTagName elementName = null;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				String tag = reader.getLocalName();
				elementName = MovieTagName.valueOf(tag.toUpperCase());
				switch (elementName) {
				case MOVIE:
					movie = new Movie();
					break;
				case TITLE:
					title = new Title();
					break;
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if (text.isEmpty()) {
					break;
				}
				switch (elementName) {
				case ACTOR:
					movie.setActor(text.toString());
					break;
				case COUNTRY:
					movie.setCountry(text.toString());
					break;
				case DIRECTOR:
					movie.setDirector(text.toString());
					break;
				case GENRE:
					movie.setGenre(text.toString());
					break;
				case IMDB_RATING:
					double imdbRating = Double.parseDouble(text.toString());
					movie.setImdbRating(imdbRating);
					break;
				case ORIGINAL:
					title.setOriginal(text.toString());
					break;
				case RUSSIAN:
					title.setRussian(text.toString());
					break;
				case YEAR:
					int year = Integer.parseInt(text.toString());
					movie.setYear(year);
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				tag = reader.getLocalName();
				elementName = MovieTagName.valueOf(tag.toUpperCase());
				switch (elementName) {
				case MOVIE:
					movies.add(movie);
					break;
				case TITLE:
					movie.setTitle(title);
					break;
				}
				break;
			}
		}
		return movies;
	}
}
