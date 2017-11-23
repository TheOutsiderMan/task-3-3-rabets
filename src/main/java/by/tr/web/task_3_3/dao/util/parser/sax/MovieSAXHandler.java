package by.tr.web.task_3_3.dao.util.parser.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.tr.web.task_3_3.dao.util.parser.MovieTagName;
import by.tr.web.task_3_3.domain.Movie;
import by.tr.web.task_3_3.domain.Title;

public class MovieSAXHandler extends DefaultHandler {

	private List<Movie> movieList = new ArrayList<Movie>();
	private Movie movie;
	private Title title;
	private StringBuilder text;

	public List<Movie> getMovieList() {
		return movieList;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		text = new StringBuilder();
		String tagMovie = MovieTagName.MOVIE.toString().toLowerCase();
		String tagTitle = MovieTagName.TITLE.toString().toLowerCase();
		if (qName.equals(tagMovie)) {
			movie = new Movie();
		} else if (qName.equals(tagTitle)) {
			title = new Title();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		MovieTagName tagName = MovieTagName.valueOf(qName.toUpperCase().replace('-', '_'));
		switch (tagName) {
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
			movie.setImdbRating(Double.parseDouble(text.toString()));
			break;
		case MOVIE:
			movieList.add(movie);
			movie = null;
			break;
		case ORIGINAL:
			title.setOriginal(text.toString());
			break;
		case RUSSIAN:
			title.setRussian(text.toString());
			break;
		case TITLE:
			movie.setTitle(title);
			title = null;
			break;
		case YEAR:
			movie.setYear(Integer.parseInt(text.toString()));
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		text.append(ch, start, length);
	}

}
