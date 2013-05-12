package com.movie.url;

import com.movie.errors.MovieException;
import com.movie.requestbuilder.ImdbRequestBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionReader {

    public static String getResponse(ImdbRequestBuilder requestBuilder) throws MovieException {
        try {
            URL website = new URL(requestBuilder.getRequest().toString());
            URLConnection connection = website.openConnection();
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            return response.toString();
        } catch (MalformedURLException ex) {
            throw new RuntimeException("Malformed URL.", ex);
        } catch (IOException ex) {
            throw new RuntimeException("Problems creating or reading input stream.", ex);
        }
    }
}
