package com.immfly.filghtinfo.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebClientBuilderFactory {

    /**
     * Generates a base WebClient Builder with some configurations.
     *
     * @param baseUrl
     * @param readTimeOut
     * @return a base WebClient Builder
     */
    public static WebClient.Builder generate(String baseUrl, Duration readTimeOut) {
        return generate(readTimeOut).baseUrl(baseUrl);
    }

    /**
     * Generates a base WebClient Builder with some configurations.
     *
     * @param readTimeOut
     * @return a base WebClient Builder
     */
    public static WebClient.Builder generate(Duration readTimeOut) {

        int CONNECT_TIMEOUT = 500;

        HttpClient httpClient = HttpClient.create()
                .tcpConfiguration(tcpClient -> {

                    tcpClient = tcpClient.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, CONNECT_TIMEOUT);

                    tcpClient = tcpClient.doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(readTimeOut.toMillis(), TimeUnit.MILLISECONDS)));

                    return tcpClient;
                });

        ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);

        return WebClient.builder()
                .clientConnector(connector);
    }

}
