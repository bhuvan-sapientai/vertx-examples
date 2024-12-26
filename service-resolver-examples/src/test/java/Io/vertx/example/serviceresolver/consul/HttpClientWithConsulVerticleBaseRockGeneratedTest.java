package io.vertx.example.serviceresolver.consul;

import io.vertx.example.serviceresolver.consul.HttpClientWithConsulVerticle;

import static org.hamcrest.Matchers.endsWith;
import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.Test;
import io.vertx.serviceresolver.srv.SrvResolver;
import io.vertx.core.net.SocketAddress;
import org.mockito.Mock;
import io.vertx.example.serviceresolver.consul.HttpClientWithConsulVerticle;
import io.vertx.core.net.AddressResolver;
import io.vertx.core.net.endpoint.LoadBalancer;
import org.testcontainers.containers.GenericContainer;
import static org.mockito.ArgumentMatchers.*;
import org.testcontainers.containers.wait.strategy.HostPortWaitStrategy;
import static org.mockito.Mockito.*;
import io.vertx.core.json.JsonObject;
import org.testcontainers.containers.InternetProtocol;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.testcontainers.containers.FixedHostPortGenericContainer;
import static org.mockito.ArgumentMatchers.eq;
import io.vertx.core.Vertx;
import io.vertx.core.VerticleBase;
import io.vertx.core.http.*;
import io.vertx.core.buffer.Buffer;
import java.util.ArrayList;
import io.vertx.serviceresolver.ServiceAddress;
import io.vertx.serviceresolver.srv.SrvResolverOptions;
import static org.junit.jupiter.api.Assertions.*;
import io.vertx.core.Future;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.endsWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class HttpClientWithConsulVerticleBaseRockGeneratedTest {

    @Mock
    private Vertx vertx;

    @Mock
    private HttpClientAgent httpClientAgent;

    @Mock
    private HttpClientBuilder httpClientBuilder;

    @Mock
    private HttpClient httpClient;

    @Mock
    private HttpServerRequest httpServerRequest;

    @Mock
    private HttpServerResponse httpServerResponse;

    @Mock
    private HttpClientRequest httpClientRequest;

    @Mock
    private HttpClientResponse httpClientResponse;

    private HttpClientWithConsulVerticle verticle;

    @BeforeEach
    void setUp() {
        verticle = new HttpClientWithConsulVerticle();
        verticle.init(vertx, null);
    }

    //BaseRock generated method id: ${testMain}, hash: 6F6B1D699ABE92DDAD70F4481A19B1F7
    @Test
    void testMain() throws Exception {
        // The MockedStatic functionality is not available in the standard Mockito.
        // If you need this functionality, you might need to use a different mocking framework
        // or restructure your code to allow for easier testing.
    }

    //BaseRock generated method id: ${testStart}, hash: 06CF557749880B267BE452AD008E3FD0
    @Test
    void testStart() {
        when(vertx.httpClientBuilder()).thenReturn(httpClientBuilder);
        when(httpClientBuilder.withLoadBalancer(any(LoadBalancer.class))).thenReturn(httpClientBuilder);
        when(httpClientBuilder.withAddressResolver(any(AddressResolver.class))).thenReturn(httpClientBuilder);
        when(httpClientBuilder.build()).thenReturn(httpClientAgent);
        when(httpClientAgent.request(any(RequestOptions.class))).thenReturn(Future.succeededFuture(httpClientRequest));
        when(httpClientRequest.send()).thenReturn(Future.succeededFuture(httpClientResponse));
        when(httpClientResponse.body()).thenReturn(Future.succeededFuture(Buffer.buffer("response")));
        Future<?> result = verticle.start();
        assertNotNull(result);
        verify(vertx).httpClientBuilder();
        verify(httpClientBuilder).withLoadBalancer(LoadBalancer.ROUND_ROBIN);
        verify(httpClientBuilder).withAddressResolver(any(AddressResolver.class));
        verify(httpClientBuilder).build();
        verify(httpClientAgent, times(10)).request(any(RequestOptions.class));
    }

    //BaseRock generated method id: ${testStartWithFailure}, hash: E318764B28ADC6446F45CF434A579732
    @Test
    void testStartWithFailure() {
        when(vertx.httpClientBuilder()).thenReturn(httpClientBuilder);
        when(httpClientBuilder.withLoadBalancer(any(LoadBalancer.class))).thenReturn(httpClientBuilder);
        when(httpClientBuilder.withAddressResolver(any(AddressResolver.class))).thenReturn(httpClientBuilder);
        when(httpClientBuilder.build()).thenReturn(httpClientAgent);
        when(httpClientAgent.request(any(RequestOptions.class))).thenReturn(Future.failedFuture(new RuntimeException("Test failure")));
        Future<?> result = verticle.start();
        assertNotNull(result);
        verify(vertx).httpClientBuilder();
        verify(httpClientBuilder).withLoadBalancer(LoadBalancer.ROUND_ROBIN);
        verify(httpClientBuilder).withAddressResolver(any(AddressResolver.class));
        verify(httpClientBuilder).build();
        verify(httpClientAgent, times(10)).request(any(RequestOptions.class));
    }
}
