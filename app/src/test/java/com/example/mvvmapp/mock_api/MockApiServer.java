package com.example.mvvmapp.mock_api;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

public class MockApiServer {

    private MockWebServer mockWebServer;

    public MockApiServer() {
        mockWebServer = new MockWebServer();
    }

    public void start() throws Exception {
        mockWebServer.start();
    }

    public void stop() throws Exception {
        mockWebServer.shutdown();
    }

    public String getBaseUrl() {
        return mockWebServer.url("/").toString();
    }

    public void enqueueResponse(String jsonResponse, int responseCode) {
        MockResponse response = new MockResponse()
                .setResponseCode(responseCode)
                .setBody(jsonResponse);

        mockWebServer.enqueue(response);
    }
}
