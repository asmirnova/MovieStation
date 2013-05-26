package com.movie.jaxb.document;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
@XmlRootElement(name = "imdbdocument")
public class IdImdbDocument {

    @XmlElement(name = "rating", required = true)
    protected float rating;
    @XmlElement(name = "rating_count")
    protected int ratingCount;
    @XmlElement(name = "year", required = true)
    protected int year;
    @XmlElement(required = true)
    protected IdImdbDocument.Genres genres;
    @XmlElement(required = true)
    protected String rated;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(name = "imdb_url", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String imdbUrl;
    @XmlElement(required = true)
    protected IdImdbDocument.Directors directors;
    @XmlElement(required = true)
    protected IdImdbDocument.Writers writers;
    @XmlElement(required = true)
    protected IdImdbDocument.Actors actors;
    @XmlElement(name = "plot_simple", required = true)
    protected String plotSimple;
    @XmlElement(name = "type", required = true)
    protected String type;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String poster;
    @XmlElement(name = "imdb_id", required = true)
    protected String imdbId;
    @XmlElement(name = "also_known_as", required = true)
    protected IdImdbDocument.AlsoKnownAs alsoKnownAs;
    @XmlElement(required = true)
    protected IdImdbDocument.Language language;
    @XmlElement(required = true)
    protected IdImdbDocument.Country country;
    @XmlElement(name = "release_date")
    protected int releaseDate;
    @XmlElement(name = "filming_locations")
    protected String filmingLocations;
    @XmlElement(required = true)
    protected IdImdbDocument.Runtime runtime;

    public IdImdbDocument() {
    }

    public IdImdbDocument(float rating, int count, int year, List<String> genres,
            String rated, String title, String imdbString,
            List<String> directors, List<String> writers,
            List<String> actors, String plotSimple, String type, String poster,
            String imdbId, List<String> alsoKnownAs,
            List<String> languages, List<String> countries,
            int releaseDate, String filmingLocations, List<String> runtime) {
        this.rating = rating;
        this.ratingCount = count;
        this.year = year;
        this.genres = new Genres();
        this.genres.getItem().addAll(genres);
        this.rated = rated;
        this.title = title;
        this.imdbUrl = imdbString;
        this.directors = new Directors();
        this.directors.getItem().addAll(directors);
        this.writers = new Writers();
        this.writers.getItem().addAll(writers);
        this.actors = new Actors();
        this.actors.getItem().addAll(actors);
        this.plotSimple = plotSimple;
        this.type = type;
        this.poster = poster;
        this.imdbId = imdbId;
        this.alsoKnownAs = new AlsoKnownAs();
        this.alsoKnownAs.getItem().addAll(alsoKnownAs);
        this.language = new Language();
        this.language.getItem().addAll(languages);
        this.country = new Country();
        this.country.getItem().addAll(countries);
        this.releaseDate = releaseDate;
        this.filmingLocations = filmingLocations;
        this.runtime = new Runtime();
        this.runtime.getItem().addAll(runtime);
    }

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

    public int getYear() {
        return year;
    }

    public void setYear(int value) {
        this.year = value;
    }

    public IdImdbDocument.Genres getGenres() {
        return genres;
    }

    public void setGenres(IdImdbDocument.Genres value) {
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

    public IdImdbDocument.Directors getDirectors() {
        return directors;
    }

    public void setDirectors(IdImdbDocument.Directors value) {
        this.directors = value;
    }

    public IdImdbDocument.Writers getWriters() {
        return writers;
    }

    public void setWriters(IdImdbDocument.Writers value) {
        this.writers = value;
    }

    public IdImdbDocument.Actors getActors() {
        return actors;
    }

    public void setActors(IdImdbDocument.Actors value) {
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

    public IdImdbDocument.AlsoKnownAs getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(IdImdbDocument.AlsoKnownAs value) {
        this.alsoKnownAs = value;
    }

    public IdImdbDocument.Language getLanguage() {
        return language;
    }

    public void setLanguage(IdImdbDocument.Language value) {
        this.language = value;
    }

    public IdImdbDocument.Country getCountry() {
        return country;
    }

    public void setCountry(IdImdbDocument.Country value) {
        this.country = value;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int value) {
        this.releaseDate = value;
    }

    public IdImdbDocument.Runtime getRuntime() {
        return runtime;
    }

    public void setRuntime(IdImdbDocument.Runtime value) {
        this.runtime = value;
    }

    public String getFilmingLocations() {
        return filmingLocations;
    }

    public void setFilmingLocations(String filmingLocations) {
        this.filmingLocations = filmingLocations;
    }
    
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "item"
    })
    public static class Actors {

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
    public static class AlsoKnownAs {

        @XmlElement(required = true)
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
    public static class Country {

        @XmlElement(required = true)
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

        @XmlElement(required = true)
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

        @XmlElement(required = true)
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

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "item"
    })
    public static class FilmingLocations {

        @XmlElement(required = true)
        protected String item;

        public String getItem() {
            return item;
        }

        public void setItem(String value) {
            this.item = value;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.year;
        hash = 67 * hash + Objects.hashCode(this.title);
        hash = 67 * hash + Objects.hashCode(this.imdbUrl);
        hash = 67 * hash + Objects.hashCode(this.imdbId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IdImdbDocument other = (IdImdbDocument) obj;
        if (this.year != other.year) {
            return false;
        }
        if (!Objects.equals(this.imdbUrl, other.imdbUrl)) {
            return false;
        }
        return Objects.equals(this.imdbId, other.imdbId);
    }

    @Override
    public String toString() {
        return "ImdbDocument{" + 
                "rating=" + rating + 
                ", ratingCount=" + ratingCount + 
                ", year=" + year + ", genres=" + genres + 
                ", rated=" + rated + ", title=" + title + 
                ", imdbUrl=" + imdbUrl + ", directors=" + directors + 
                ", writers=" + writers + ", actors=" + actors + 
                ", plotSimple=" + plotSimple + ", type=" + type + 
                ", poster=" + poster + ", imdbId=" + imdbId + 
                ", alsoKnownAs=" + alsoKnownAs + ", language=" + language + 
                ", country=" + country + ", releaseDate=" + releaseDate + 
                ", filmingLocations=" + filmingLocations + 
                ", runtime=" + runtime + '}';
    }
}
