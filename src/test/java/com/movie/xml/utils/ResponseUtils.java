package com.movie.xml.utils;

import com.movie.jaxb.document.IdImdbDocument;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.IOUtils;
import static org.junit.Assert.fail;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Aloren
 */
public class ResponseUtils {

    public static IdImdbDocument createIdImdbDocument() {
        Random random = new Random();
        float rating = random.nextFloat();
        int count = random.nextInt(100);
        int year = random.nextInt(2020);
        List<String> genres = generateStringList(random.nextInt(20), random);
        List<String> directors = generateStringList(random.nextInt(20), random);
        List<String> writers = generateStringList(random.nextInt(20), random);
        List<String> actors = generateStringList(random.nextInt(20), random);
        List<String> alsoKnownAs = generateStringList(random.nextInt(20), random);
        List<String> languages = generateStringList(random.nextInt(20), random);
        List<String> countries = generateStringList(random.nextInt(20), random);
        int releaseDate = random.nextInt(2000);
        List<String> runtime = generateStringList(random.nextInt(20), random);
        IdImdbDocument doc = new IdImdbDocument(rating, count, year, genres, "rated",
                "title", "imdbUrl", directors, writers, actors, "plotSimple", "type",
                "poster", "imdbId", alsoKnownAs, languages, countries, releaseDate,
                "filmingLocations", runtime);
        return doc;
    }

    public static IdImdbDocument createBadIdImdbDocument() {
        IdImdbDocument doc = createIdImdbDocument();
        doc.setImdbId(null);
        return doc;
    }

    public static IdImdbDocument createEmptyIdImdbDocument() {
        IdImdbDocument doc = new IdImdbDocument(0f, 0, 0, emptyList(), null,
                null, null, emptyList(), emptyList(), emptyList(), null, null,
                null, null, emptyList(), emptyList(), emptyList(), 0,
                null, emptyList());
        return doc;
    }
    
    public static List<String> emptyList(){
        List<String> list = Collections.emptyList();
        return list;
    }

    public static List<String> generateStringList(int listSize, Random random) {
        List<String> list = new ArrayList<>();
        if (listSize == 0) {
            listSize = 1;
        }
        for (int i = 0; i < listSize; i++) {
            list.add(generateString(random, "abcdefghijkmnopqrstuvw", 10));
        }
        return list;
    }

    public static String generateString(Random random, String characters, int stringLength) {
        char[] text = new char[stringLength];
        for (int i = 0; i < stringLength; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(text);
    }

    public static String convertToString(IdImdbDocument doc) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(IdImdbDocument.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            try (Writer writer = new StringWriter()) {
                jaxbMarshaller.marshal(doc, writer);
                return writer.toString();
            }
        } catch (JAXBException ex) {
            fail("Error parsing doc");
        } catch (IOException ex) {
            fail("Error with creating stream");
        }
        return null;
    }

    public static Document convertToDocument(String xmlResponse) {
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(IOUtils.toInputStream(xmlResponse));
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            fail("Problems during converting xml-string to Document");
        }
        return null;
    }
}
