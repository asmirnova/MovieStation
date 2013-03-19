package com.movie.jaxb.documentList;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "item"
})
@XmlRootElement(name = "IMDBDocumentList")
public class ImdbDocumentList {

    protected List<ImdbDocumentList.Item> item;

    public List<ImdbDocumentList.Item> getItem() {
        if (item == null) {
            item = new ArrayList<ImdbDocumentList.Item>();
        }
        return this.item;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "rating",
        "ratingCount",
        "year",
        "genres",
        "rated",
        "title",
        "imdbUrl",
        "directors",
        "writers",
        "actors",
        "plotSimple",
        "type",
        "poster",
        "imdbId",
        "alsoKnownAs",
        "language",
        "country",
        "releaseDate",
        "filmingLocations",
        "runtime"
    })
    public static class Item {

        protected float rating;
        @XmlElement(name = "rating_count")
        protected int ratingCount;
        protected short year;
        @XmlElement(required = true)
        protected ImdbDocumentList.Item.Genres genres;
        @XmlElement(required = true)
        protected String rated;
        @XmlElement(required = true)
        protected String title;
        @XmlElement(name = "imdb_url", required = true)
        @XmlSchemaType(name = "anyURI")
        protected String imdbUrl;
        @XmlElement(required = true)
        protected ImdbDocumentList.Item.Directors directors;
        @XmlElement(required = true)
        protected ImdbDocumentList.Item.Writers writers;
        @XmlElement(required = true)
        protected ImdbDocumentList.Item.Actors actors;
        @XmlElement(name = "plot_simple", required = true)
        protected String plotSimple;
        @XmlElement(required = true)
        protected String type;
        @XmlElement(required = true)
        @XmlSchemaType(name = "anyURI")
        protected String poster;
        @XmlElement(name = "imdb_id", required = true)
        protected String imdbId;
        @XmlElement(name = "also_known_as", required = true)
        protected ImdbDocumentList.Item.AlsoKnownAs alsoKnownAs;
        @XmlElement(required = true)
        protected ImdbDocumentList.Item.Language language;
        @XmlElement(required = true)
        protected ImdbDocumentList.Item.Country country;
        @XmlElement(name = "release_date")
        protected int releaseDate;
        @XmlElement(name = "filming_locations", required = true)
        protected String filmingLocations;
        @XmlElement(required = true)
        protected ImdbDocumentList.Item.Runtime runtime;

        public float getRating() {
            return rating;
        }

        public void setRating(float value) {
            this.rating = value;
        }

        public int getRatingCount() {
            return ratingCount;
        }

        public void setRatingCount(int value) {
            this.ratingCount = value;
        }

        public short getYear() {
            return year;
        }

        public void setYear(short value) {
            this.year = value;
        }

        public ImdbDocumentList.Item.Genres getGenres() {
            return genres;
        }

        public void setGenres(ImdbDocumentList.Item.Genres value) {
            this.genres = value;
        }

        public String getRated() {
            return rated;
        }

        public void setRated(String value) {
            this.rated = value;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String value) {
            this.title = value;
        }

        public String getImdbUrl() {
            return imdbUrl;
        }

        public void setImdbUrl(String value) {
            this.imdbUrl = value;
        }

        public ImdbDocumentList.Item.Directors getDirectors() {
            return directors;
        }

        public void setDirectors(ImdbDocumentList.Item.Directors value) {
            this.directors = value;
        }

        public ImdbDocumentList.Item.Writers getWriters() {
            return writers;
        }

        public void setWriters(ImdbDocumentList.Item.Writers value) {
            this.writers = value;
        }

        public ImdbDocumentList.Item.Actors getActors() {
            return actors;
        }

        public void setActors(ImdbDocumentList.Item.Actors value) {
            this.actors = value;
        }

        public String getPlotSimple() {
            return plotSimple;
        }

        public void setPlotSimple(String value) {
            this.plotSimple = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String value) {
            this.type = value;
        }

        public String getPoster() {
            return poster;
        }

        public void setPoster(String value) {
            this.poster = value;
        }

        public String getImdbId() {
            return imdbId;
        }

        public void setImdbId(String value) {
            this.imdbId = value;
        }

        public ImdbDocumentList.Item.AlsoKnownAs getAlsoKnownAs() {
            return alsoKnownAs;
        }

        public void setAlsoKnownAs(ImdbDocumentList.Item.AlsoKnownAs value) {
            this.alsoKnownAs = value;
        }

        public ImdbDocumentList.Item.Language getLanguage() {
            return language;
        }

        public void setLanguage(ImdbDocumentList.Item.Language value) {
            this.language = value;
        }

        public ImdbDocumentList.Item.Country getCountry() {
            return country;
        }

        public void setCountry(ImdbDocumentList.Item.Country value) {
            this.country = value;
        }

        public int getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(int value) {
            this.releaseDate = value;
        }

        public String getFilmingLocations() {
            return filmingLocations;
        }

        public void setFilmingLocations(String value) {
            this.filmingLocations = value;
        }

        public ImdbDocumentList.Item.Runtime getRuntime() {
            return runtime;
        }

        public void setRuntime(ImdbDocumentList.Item.Runtime value) {
            this.runtime = value;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "item"
        })
        public static class Actors {

            protected List<String> item;

            /**
             * Gets the value of the item property.
             *
             * <p>
             * This accessor method returns a reference to the live list, not a
             * snapshot. Therefore any modification you make to the returned
             * list will be present inside the JAXB object. This is why there is
             * not a
             * <CODE>set</CODE> method for the item property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getItem().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             *
             *
             */
            public List<String> getItem() {
                if (item == null) {
                    item = new ArrayList<String>();
                }
                return this.item;
            }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "item"
        })
        public static class AlsoKnownAs {

            @XmlElement(required = true)
            protected String item;

            public String getItem() {
                return item;
            }

            public void setItem(String value) {
                this.item = value;
            }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "item"
        })
        public static class Country {

            protected List<String> item;

            public List<String> getItem() {
                if (item == null) {
                    item = new ArrayList<String>();
                }
                return this.item;
            }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "item"
        })
        public static class Directors {

            @XmlElement(required = true)
            protected String item;

            public String getItem() {
                return item;
            }

            public void setItem(String value) {
                this.item = value;
            }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "item"
        })
        public static class Genres {

            protected List<String> item;

            public List<String> getItem() {
                if (item == null) {
                    item = new ArrayList<String>();
                }
                return this.item;
            }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "item"
        })
        public static class Language {

            protected List<String> item;

            public List<String> getItem() {
                if (item == null) {
                    item = new ArrayList<String>();
                }
                return this.item;
            }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "item"
        })
        public static class Runtime {

            protected List<String> item;

            public List<String> getItem() {
                if (item == null) {
                    item = new ArrayList<String>();
                }
                return this.item;
            }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "item"
        })
        public static class Writers {

            protected List<String> item;

            public List<String> getItem() {
                if (item == null) {
                    item = new ArrayList<String>();
                }
                return this.item;
            }
        }
    }
}
