package com.movie.xml.parser;

import com.movie.jaxb.document.IdImdbDocument;
import java.util.Arrays;
import java.util.List;
import javax.xml.xpath.XPathExpressionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;

/**
 * @author Aloren
 */
public class IdImdbXmlParser extends ImdbXmlParser {

    @Override
    public List<IdImdbDocument> parse(Document documentToParse) {
        IdImdbDocument imdbDocument = null;
        try {
            imdbDocument = parseImdbDocument("/imdbdocument", documentToParse);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(IdImdbXmlParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Arrays.asList(imdbDocument);
    }
}
