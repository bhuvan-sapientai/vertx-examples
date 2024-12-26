package io.vertx.example.core.verticle.deploy;

import org.junit.jupiter.api.Timeout;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.core.internal.ContextInternal;
import org.mockito.MockitoAnnotations;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;
import static org.hamcrest.Matchers.is;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class OtherVerticleBaseRockGeneratedTest {

    private final ContextInternal contextMock = mock(ContextInternal.class, "context");

    private final ContextInternal fieldContextMock = mock(ContextInternal.class, "fieldContext");

    private AutoCloseable autoCloseableMocks;

    @InjectMocks()
    private OtherVerticle target;

    @AfterEach()
    public void afterTest() throws Exception {
        if (autoCloseableMocks != null)
            autoCloseableMocks.close();
    }

    //BaseRock generated method id: ${startTest}, hash: F1E4C2D018552DB2CD580943BA9B3998
    @Test()
    void startTest() throws Exception {
        //Arrange Statement(s)
        JsonObject jsonObjectMock = mock(JsonObject.class, "jsonObject");
        doReturn(jsonObjectMock).when(contextMock).config();
        Future<?> futureMock = mock(Future.class);
        doReturn(futureMock).when(contextMock).succeededFuture();
        target = new OtherVerticle();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        
        //Act Statement(s)
        Future<?> result = target.start();
        
        //Assert statement(s)
        assertAll("result", () -> {
            assertThat(result, equalTo(futureMock));
            verify(contextMock).config();
            verify(contextMock).succeededFuture();
        });
    }

    //BaseRock generated method id: ${stopThrowsNullPointerException}, hash: 499AEF29DB0B1AA29D47E65ACCC9EEBB
    @Test()
    void stopThrowsNullPointerException() throws Exception {
        //Arrange Statement(s)
        target = new OtherVerticle();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        //Act Statement(s)
        final NullPointerException result = assertThrows(NullPointerException.class, () -> {
            target.stop();
        });
        
        //Assert statement(s)
        assertAll("result", () -> assertThat(result, is(notNullValue())));
    }
}
