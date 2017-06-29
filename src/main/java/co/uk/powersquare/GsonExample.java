package co.uk.powersquare;
import co.uk.powersquare.pojo.AlgoliaResponse;
import co.uk.powersquare.pojo.Document;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
/**
 * Created by wshao on 29/06/2017.
 */
public class GsonExample
{
    public static void main(String[] args) throws Exception
    {
        /**
         * Hard-code the HTTP client
         */
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("https://N0ZULSTIED-dsn.algolia.net/1/indexes/wei_index/query");
        httpPost.addHeader("X-Algolia-Application-Id", "N0ZULSTIED");
        httpPost.addHeader("X-Algolia-API-Key", "bf9b5c6d1c3d126a2f218161b8b2a295");
        httpPost.setHeader("Content-type", "application/json");

        Gson gson = new Gson();
        JsonObject playload = new JsonObject();
        playload.addProperty("params", "");
        String playloadStr = gson.toJson(playload);
        httpPost.setEntity(new StringEntity(playloadStr));

        HttpResponse response = httpClient.execute(httpPost);

        AlgoliaResponse algoliaResponse = gson
                .fromJson(new InputStreamReader(response.getEntity().getContent()), AlgoliaResponse.class);
        List<Document> documents = algoliaResponse.getHits();
        System.out.println(documents.size());
        System.out.println(documents.get(0).getUrl());

    }

}
