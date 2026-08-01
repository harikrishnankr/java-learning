package com.tutorials.advanced.networking;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

/**
 * java.net.http.HttpClient (Java 11+) replaced the old HttpURLConnection —
 * immutable, builder-configured requests/clients, first-class HTTP/2, and
 * both blocking (send) and non-blocking (sendAsync, returning a
 * CompletableFuture) call styles. These methods require actual network
 * access to run — they're here to show the API shape, not to be called in
 * an offline build.
 */
public class HttpClientExamples {
    private static final HttpClient CLIENT = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5))
            .build();

    public static String getSynchronously(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .GET()
                .timeout(Duration.ofSeconds(10))
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static CompletableFuture<String> getAsynchronously(String url) {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();
        return CLIENT.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }

    public static String postJson(String url, String jsonBody) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        return CLIENT.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }
}
