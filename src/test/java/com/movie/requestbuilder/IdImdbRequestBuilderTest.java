package com.movie.requestbuilder;

import com.movie.requestbuilder.impl.IdImdbRequestBuilder;
import com.movie.xml.ImdbXmlConst;
import com.movie.xml.types.PlotType;
import com.movie.xml.types.ReleaseType;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aloren
 */
public class IdImdbRequestBuilderTest {

    private IdImdbRequestBuilder builder;
    private final String id = "tt01";

    @Before
    public void setup() {
        builder = new IdImdbRequestBuilder(id);
    }

    @Test
    public void append() {
        final ReleaseType release = ReleaseType.SIMPLE;
        final PlotType plot = PlotType.FULL;
        String actual = builder.business(true).plot(plot).release(release).tech(true).getRequest().toString();
        String expected = ImdbXmlConst.IMDB_API + "id=" + id + "&type=xml&business=1&plot=" + plot.toString() + "&release=" + release.toString()+"&tech=1";
        assertTrue("", expected.equals(actual));
    }
}
