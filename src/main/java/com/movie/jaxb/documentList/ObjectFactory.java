package com.movie.jaxb.documentList;


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
     * Create an instance of {@link IMDBDocumentList }
     * 
     */
    public ImdbDocumentList createIMDBDocumentList() {
        return new ImdbDocumentList();
    }

    /**
     * Create an instance of {@link IMDBDocumentList.Item }
     * 
     */
    public ImdbDocumentList.Item createIMDBDocumentListItem() {
        return new ImdbDocumentList.Item();
    }

    /**
     * Create an instance of {@link IMDBDocumentList.Item.Genres }
     * 
     */
    public ImdbDocumentList.Item.Genres createIMDBDocumentListItemGenres() {
        return new ImdbDocumentList.Item.Genres();
    }

    /**
     * Create an instance of {@link IMDBDocumentList.Item.Directors }
     * 
     */
    public ImdbDocumentList.Item.Directors createIMDBDocumentListItemDirectors() {
        return new ImdbDocumentList.Item.Directors();
    }

    /**
     * Create an instance of {@link IMDBDocumentList.Item.Writers }
     * 
     */
    public ImdbDocumentList.Item.Writers createIMDBDocumentListItemWriters() {
        return new ImdbDocumentList.Item.Writers();
    }

    /**
     * Create an instance of {@link IMDBDocumentList.Item.Actors }
     * 
     */
    public ImdbDocumentList.Item.Actors createIMDBDocumentListItemActors() {
        return new ImdbDocumentList.Item.Actors();
    }

    /**
     * Create an instance of {@link IMDBDocumentList.Item.AlsoKnownAs }
     * 
     */
    public ImdbDocumentList.Item.AlsoKnownAs createIMDBDocumentListItemAlsoKnownAs() {
        return new ImdbDocumentList.Item.AlsoKnownAs();
    }

    /**
     * Create an instance of {@link IMDBDocumentList.Item.Language }
     * 
     */
    public ImdbDocumentList.Item.Language createIMDBDocumentListItemLanguage() {
        return new ImdbDocumentList.Item.Language();
    }

    /**
     * Create an instance of {@link IMDBDocumentList.Item.Country }
     * 
     */
    public ImdbDocumentList.Item.Country createIMDBDocumentListItemCountry() {
        return new ImdbDocumentList.Item.Country();
    }

    /**
     * Create an instance of {@link IMDBDocumentList.Item.Runtime }
     * 
     */
    public ImdbDocumentList.Item.Runtime createIMDBDocumentListItemRuntime() {
        return new ImdbDocumentList.Item.Runtime();
    }

}
