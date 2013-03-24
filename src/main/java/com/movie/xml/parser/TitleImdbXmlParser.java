package com.movie.xml.parser;

import com.movie.jaxb.document.IdImdbDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;

/**
 *
 * @author Aloren
 */
public class TitleImdbXmlParser extends ImdbXmlParser {
    
    @Override
    public List<IdImdbDocument> parse(Document documentToParse) {
        List<IdImdbDocument> imdbDocs = new ArrayList<>();
        try {
            int countImdbDocs = Integer.parseInt(xPath.evaluate("count(/IMDBDocumentList/item)", documentToParse));
            for (int i = 0; i < countImdbDocs; i++) {
                IdImdbDocument imdbDocument = parseImdbDocument("/IMDBDocumentList/item[" + (i + 1) + "]", documentToParse);
                imdbDocs.add(imdbDocument);
            }
        } catch (XPathExpressionException ex) {
            Logger.getLogger(IdImdbXmlParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imdbDocs;
    }
}
