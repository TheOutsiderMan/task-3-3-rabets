package by.tr.web.task_3_3.dao.util.parser.dom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

import by.tr.web.task_3_3.domain.Movie;
import by.tr.web.task_3_3.domain.Title;

public class MovieDOMParser {

	private static final String TAG_MOVIE = "movie";
	private static final String TAG_IMDB_RATING = "imdb-rating";
	private static final String TAG_GENRE = "genre";
	private static final String TAG_COUNTRY = "country";
	private static final String TAG_ACTOR = "actor";
	private static final String TAG_DIRECTOR = "director";
	private static final String TAG_ORIGINAL = "original";
	private static final String TAG_RUSSIAN = "russian";
	private static final String TAG_YEAR = "year";
	private static final String TAG_TITLE = "title";

	public List<Movie> parse(String filepath) throws SAXException, IOException {
		DOMParser domParser = new DOMParser();
		domParser.parse(filepath);
		Document document = domParser.getDocument();
		Element root = document.getDocumentElement();
		List<Movie> movies = new ArrayList<>();
		NodeList movieNodes = root.getElementsByTagName(TAG_MOVIE);
		Movie movie = null;
		for (int i = 0; i < movieNodes.getLength(); i++) {
			movie = new Movie();
			Element movieElement = (Element) movieNodes.item(i);
			NodeList titleNodes = movieElement.getElementsByTagName(TAG_TITLE);
			Title title = new Title();
			Element titleElement = (Element) titleNodes.item(0);
			title.setRussian(getSingleChildTextContent(titleElement, TAG_RUSSIAN));
			title.setOriginal(getSingleChildTextContent(titleElement, TAG_ORIGINAL));
			movie.setTitle(title);
			movie.setActor(getSingleChildTextContent(movieElement, TAG_ACTOR));
			movie.setCountry(getSingleChildTextContent(movieElement, TAG_COUNTRY));
			movie.setDirector(getSingleChildTextContent(movieElement, TAG_DIRECTOR));
			movie.setGenre(getSingleChildTextContent(movieElement, TAG_GENRE));
			movie.setImdbRating(Double.parseDouble(getSingleChildTextContent(movieElement,TAG_IMDB_RATING )));
			movie.setYear(Integer.parseInt(getSingleChildTextContent(movieElement, TAG_YEAR)));
			movies.add(movie);
		}
		return movies;
	}

	private static String getSingleChildTextContent(Element element, String elementName) {
		NodeList nodeList = element.getElementsByTagName(elementName);
		Node node = nodeList.item(0);
		String text = node.getTextContent();
		return text;
	}
}
