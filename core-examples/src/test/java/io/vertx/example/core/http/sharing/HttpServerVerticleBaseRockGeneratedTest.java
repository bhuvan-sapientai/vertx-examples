package io.vertx.example.core.http.sharing;

import org.junit.jupiter.api.Timeout;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import io.vertx.core.http.HttpServer;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import org.mockito.MockitoAnnotations;
import io.vertx.core.Vertx;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class HttpServerVerticleBaseRockGeneratedTest {

    private final Vertx vertxMock = mock(Vertx.class, "vertx");

    private AutoCloseable autoCloseableMocks;

    @InjectMocks()
    private HttpServerVerticle target;

    @AfterEach()
    public void afterTest() throws Exception {
        if (autoCloseableMocks != null)
            autoCloseableMocks.close();
    }

    //BaseRock generated method id: ${startTest}, hash: C020C1415B1CCDBADE8D251F8144D7AC
    @Test()
    void startTest() throws Exception {
        //Arrange Statement(s)
        HttpServer httpServerMock = mock(HttpServer.class);
        doReturn(httpServerMock).when(vertxMock).createHttpServer();
        HttpServer httpServerMock2 = mock(HttpServer.class);
        doReturn(httpServerMock2).when(httpServerMock).requestHandler((Handler) any());
        Future<HttpServer> futureMock = mock(Future.class);
        doReturn(futureMock).when(httpServerMock2).listen(8080);
        target = new HttpServerVerticle();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        
        //Act Statement(s)
        Future<?> result = target.start();
        
        //Assert statement(s)
        assertAll("result", () -> {
            assertThat(result, equalTo(futureMock));
            verify(vertxMock).createHttpServer();
            verify(httpServerMock).requestHandler((Handler) any());
            verify(httpServerMock2, atLeast(1)).listen(8080);
        });
    }
}
