package com.movie.xml.validator;

import com.movie.errors.Error;
import com.movie.errors.InvalidImdbDocumentException;
import com.movie.errors.MovieException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author Aloren
 */
public class DtdImdbValidator extends ImdbValidator {
    
    private final static String ID_IMDB_DOC_DTD = "imdbDocument.dtd";

    public DtdImdbValidator() {
        super(ID_IMDB_DOC_DTD);
    }
    
    public DtdImdbValidator(String pathToDtdSchema){
        super(pathToDtdSchema);
    }

    @Override
    public Document validate(String responseToValidate) throws MovieException {
        Document doc = null;
        try {
            //add the DTD element
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, pathToSchema);
            Writer stream = new StringWriter();
            transformer.transform(new StreamSource(IOUtils.toInputStream(responseToValidate)), new StreamResult(stream));

            //parse and validate
            doc = documentBuilder.parse(IOUtils.toInputStream(stream.toString()));
        } catch (SAXParseException ex) {
            throw new InvalidImdbDocumentException(Error.INVALID_DOC, ex);
        } catch (TransformerConfigurationException ex) {
            throw new RuntimeException("It is not possible to create a Transformer instance.", ex);
        } catch (SAXException ex) {
            throw new RuntimeException("Problems during parsing.", ex);
        } catch (IOException ex) {
            throw new RuntimeException("IO error while XML parsing occured.", ex);
        } catch (TransformerException ex) {
            throw new RuntimeException("Problems during transforming (adding doctype to xml-string).", ex);
        }
        return doc;
    }
}
