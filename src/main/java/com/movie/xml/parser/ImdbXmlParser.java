package com.movie.xml.parser;

import com.movie.jaxb.document.IdImdbDocument;
import com.movie.xml.ImdbXmlConst;
import java.util.ArrayList;
import java.util.List;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author Aloren
 */
public abstract class ImdbXmlParser {

    protected final XPath xPath = XPathFactory.newInstance().newXPath();

    public abstract List<IdImdbDocument> parse(Document documentToParse);

    protected IdImdbDocument parseImdbDocument(String root, Document document) throws XPathExpressionException, NumberFormatException {
        float rating = Float.parseFloat(xPath.evaluate(root + ImdbXmlConst.ratingQ, document));
        int count = Integer.parseInt(xPath.evaluate(root + ImdbXmlConst.ratingCountQ, document));
        int year = Integer.parseInt(xPath.evaluate(root + ImdbXmlConst.yearQ, document));
        List<String> genres = parseList(root + ImdbXmlConst.genresQ, document);
        String rated = xPath.evaluate(root + ImdbXmlConst.ratedQ, document);
        String title = xPath.evaluate(root + ImdbXmlConst.titleQ, document);
        String imdbUrl = xPath.evaluate(root + ImdbXmlConst.imdbUrlQ, document);
        List<String> directors = parseList(root + ImdbXmlConst.directorsQ, document);
        List<String> writers = parseList(root + ImdbXmlConst.writersQ, document);
        List<String> actors = parseList(root + ImdbXmlConst.actorsQ, document);
        String plotSimple = xPath.evaluate(root + ImdbXmlConst.plotSimpleQ, document);
        String type = xPath.evaluate(root + ImdbXmlConst.typeQ, document);
        String poster = xPath.evaluate(root + ImdbXmlConst.posterQ, document);
        String imdbId = xPath.evaluate(root + ImdbXmlConst.imdbIdQ, document);
        List<String> alsoKnownAs = parseList(root + ImdbXmlConst.alsoKnownAsQ, document);
        List<String> languages = parseList(root + ImdbXmlConst.languageQ, document);
        List<String> countries = parseList(root + ImdbXmlConst.countryQ, document);
        int releaseDate = Integer.parseInt(xPath.evaluate(root + ImdbXmlConst.releaseDateQ, document));
        String filmingLocations = xPath.evaluate(root + ImdbXmlConst.filmingLocationsQ, document);
        List<String> runtime = parseList(root + ImdbXmlConst.runtimeQ, document);
        IdImdbDocument imdbDocument = new IdImdbDocument(rating, count, year, genres,
                rated, title, imdbUrl, directors, writers, actors, plotSimple, type,
                poster, imdbId, alsoKnownAs, languages, countries,
                releaseDate, filmingLocations, runtime);
        return imdbDocument;
    }

    protected List<String> parseList(String query, Document document) throws XPathExpressionException {
        NodeList nodesToParse = (NodeList) xPath.evaluate(query, document, XPathConstants.NODESET);
        List<String> items = new ArrayList<>();
        for (int i = 0; i < nodesToParse.getLength(); i++) {
            String itemData = xPath.evaluate(query + "[" + (i + 1) + "]", document);
            items.add(itemData);
        }
        return items;
    }
}
