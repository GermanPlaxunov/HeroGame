package org.imperium.game.core.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.WorldMapDto;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MapLoader {

    private final String URL_TO_LOAD_THE_MAP = "http://localhost:8080/game-engine/get-world-map";

    public WorldMapDto getWorldMap() {
            var requestStream = requestServer();
            return convertStringToWorldMap(requestStream);
    }

    private InputStream requestServer() {
        try {
            var httpClient = HttpClients.createDefault();
            var httpPost = new HttpPost(URL_TO_LOAD_THE_MAP);
            var response = httpClient.execute(httpPost);
            return response.getEntity().getContent();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private WorldMapDto convertStringToWorldMap(InputStream stream){
        try(var reader = new BufferedReader(new InputStreamReader(stream))){
            var type = new TypeReference<WorldMapDto>(){};
            var mapper = new ObjectMapper();
            return mapper.reader()
                    .forType(type)
                    .readValue(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
