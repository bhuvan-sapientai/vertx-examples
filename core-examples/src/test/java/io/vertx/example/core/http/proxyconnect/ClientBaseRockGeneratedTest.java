package io.vertx.example.core.http.proxyconnect;

import org.junit.jupiter.api.Timeout;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import org.mockito.MockitoAnnotations;
import java.util.function.Function;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClientAgent;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpClientRequest;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class ClientBaseRockGeneratedTest {

    private final Vertx vertxMock = mock(Vertx.class, "vertx");

    private final HttpClientAgent clientMock = mock(HttpClientAgent.class, "client");

    private AutoCloseable autoCloseableMocks;

    @InjectMocks()
    private Client target;

    @AfterEach()
    public void afterTest() throws Exception {
        if (autoCloseableMocks != null)
            autoCloseableMocks.close();
    }

    //BaseRock generated method id: ${startWhenILessThan10}, hash: 96EDF11BFF3018D14A3CCB1EC2A42CE3
    @Test()
    void startWhenILessThan10() throws Exception {
        /* Branches:
         * (i < 10) : true  #  inside lambda$start$1 method
         */
         //Arrange Statement(s)
        doReturn(clientMock).when(vertxMock).createHttpClient((HttpClientOptions) any());
        Future<HttpClientRequest> futureMock = mock(Future.class);
        HttpMethod httpMethod = HttpMethod.GET;
        doReturn(futureMock).when(clientMock).request(httpMethod, 8080, "localhost", "/");
        Future futureMock2 = mock(Future.class);
        doReturn(futureMock2).when(futureMock).compose((Function) any());
        Future<?> futureMock3 = mock(Future.class);
        doReturn(futureMock3).when(futureMock2).onSuccess((Handler) any());
        target = new Client();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        
        //Act Statement(s)
        Future<?> result = target.start();
        
        //Assert statement(s)
        assertAll("result", () -> {
            assertThat(result, equalTo(futureMock3));
            verify(vertxMock).createHttpClient((HttpClientOptions) any());
            verify(clientMock).request(httpMethod, 8080, "localhost", "/");
            verify(futureMock).compose((Function) any());
            verify(futureMock2).onSuccess((Handler) any());
        });
    }
}
