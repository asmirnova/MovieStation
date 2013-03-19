package com.movie.requestbuilder;

import com.movie.xml.ImdbXmlConst;
import com.movie.xml.types.MovieType;
import com.movie.xml.types.PlotType;
import com.movie.xml.types.ReleaseType;

/**
 * @author Aloren
 */
public abstract class ImdbRequestBuilder {

    private StringBuilder request = new StringBuilder(ImdbXmlConst.IMDB_API);

    public ImdbRequestBuilder(String valueName, String valueValue) {
        appendAttribute(valueName, valueValue);
        appendAttribute("type", "xml");
    }

    public String getRequest() {
        checkLastAnd();
        return request.toString();
    }

    public ImdbRequestBuilder plot(PlotType plot) {
        appendAttribute("plot", plot.toString());
        return this;
    }

    //    public IdImdbRequestBuilder episode(String episode) {
//        return this;
//    }
//    public IdImdbRequestBuilder aka(AkaType aka) {
//        appendAttribute("aka", aka.toString());
//        return this;
//    }
    public ImdbRequestBuilder release(ReleaseType release) {
        appendAttribute("release", release.toString());
        return this;
    }

    public ImdbRequestBuilder business(boolean business) {
        appendAttribute("business", booleanToIntString(business));
        return this;
    }

    public ImdbRequestBuilder tech(boolean tech) {
        appendAttribute("tech", booleanToIntString(tech));
        return this;
    }

    public ImdbRequestBuilder year(int year) {
        appendAttribute("year", Integer.toString(year));
        return this;
    }

    public ImdbRequestBuilder year(boolean year) {
        appendAttribute("yg", booleanToIntString(year));
        return this;
    }

    public ImdbRequestBuilder movieType(MovieType movieType) {
        appendAttribute("mt", movieType.toString());
        return this;
    }

    public ImdbRequestBuilder limit(int limit) {
        if (limit > 10) {
            limit = 10;
        }
        appendAttribute("limit", Integer.toString(limit));
        return this;
    }

    protected String booleanToIntString(boolean boolValue) {
        return Integer.toString(boolValue ? 1 : 0);
    }

    protected final void appendAttribute(String attributeName, String attributeValue) {
        this.request.append(attributeName);
        this.request.append("=");
        this.request.append(attributeValue);
        this.request.append("&");
    }

    private void checkLastAnd() {
        final int lastIndex = request.length() - 1;
        if (request.charAt(lastIndex) == '&') {
            request.deleteCharAt(lastIndex);
        }
    }
}
