package com.movie.jaxb.document;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Imdbdocument }
     * 
     */
    public IdImdbDocument createImdbdocument() {
        return new IdImdbDocument();
    }

    /**
     * Create an instance of {@link Imdbdocument.Genres }
     * 
     */
    public IdImdbDocument.Genres createImdbdocumentGenres() {
        return new IdImdbDocument.Genres();
    }

    /**
     * Create an instance of {@link Imdbdocument.Directors }
     * 
     */
    public IdImdbDocument.Directors createImdbdocumentDirectors() {
        return new IdImdbDocument.Directors();
    }

    /**
     * Create an instance of {@link Imdbdocument.Writers }
     * 
     */
    public IdImdbDocument.Writers createImdbdocumentWriters() {
        return new IdImdbDocument.Writers();
    }

    /**
     * Create an instance of {@link Imdbdocument.Actors }
     * 
     */
    public IdImdbDocument.Actors createImdbdocumentActors() {
        return new IdImdbDocument.Actors();
    }

    /**
     * Create an instance of {@link Imdbdocument.AlsoKnownAs }
     * 
     */
    public IdImdbDocument.AlsoKnownAs createImdbdocumentAlsoKnownAs() {
        return new IdImdbDocument.AlsoKnownAs();
    }

    /**
     * Create an instance of {@link Imdbdocument.Language }
     * 
     */
    public IdImdbDocument.Language createImdbdocumentLanguage() {
        return new IdImdbDocument.Language();
    }

    /**
     * Create an instance of {@link Imdbdocument.Country }
     * 
     */
    public IdImdbDocument.Country createImdbdocumentCountry() {
        return new IdImdbDocument.Country();
    }

    /**
     * Create an instance of {@link Imdbdocument.Runtime }
     * 
     */
    public IdImdbDocument.Runtime createImdbdocumentRuntime() {
        return new IdImdbDocument.Runtime();
    }

}
