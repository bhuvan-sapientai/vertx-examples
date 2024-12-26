package hello;

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
class SampleVerticleBaseRockGeneratedTest {

    private final Vertx vertxMock = mock(Vertx.class, "vertx");

    private AutoCloseable autoCloseableMocks;

    @InjectMocks()
    private SampleVerticle target;

    @AfterEach()
    public void afterTest() throws Exception {
        if (autoCloseableMocks != null)
            autoCloseableMocks.close();
    }

    //BaseRock generated method id: ${startTest}, hash: 2733C801B699ABF3BCDCFCB8668C2514
    @Test()
    void startTest() {
        //Arrange Statement(s)
        HttpServer httpServerMock = mock(HttpServer.class);
        doReturn(httpServerMock).when(vertxMock).createHttpServer();
        HttpServer httpServerMock2 = mock(HttpServer.class);
        doReturn(httpServerMock2).when(httpServerMock).requestHandler((Handler) any());
        Future<HttpServer> futureMock = mock(Future.class);
        doReturn(futureMock).when(httpServerMock2).listen(11981);
        target = new SampleVerticle();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        
        //Act Statement(s)
        Future<?> result = target.start();
        
        //Assert statement(s)
        assertAll("result", () -> {
            assertThat(result, equalTo(futureMock));
            verify(vertxMock).createHttpServer();
            verify(httpServerMock).requestHandler((Handler) any());
            verify(httpServerMock2, atLeast(1)).listen(11981);
        });
    }
}
