package io.vertx.example.core.eventbus.pubsub;

import org.junit.jupiter.api.Timeout;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.Handler;
import org.mockito.MockitoAnnotations;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.Vertx;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;
import static org.hamcrest.Matchers.is;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class ReceiverBaseRockGeneratedTest {

    private final Vertx vertxMock = mock(Vertx.class, "vertx");

    private AutoCloseable autoCloseableMocks;

    @InjectMocks()
    private Receiver target;

    @AfterEach()
    public void afterTest() throws Exception {
        if (autoCloseableMocks != null)
            autoCloseableMocks.close();
    }

    //BaseRock generated method id: ${startThrowsNullPointerException}, hash: 38AAB9967D860B6535C3606F3D022785
    @Test()
    void startThrowsNullPointerException() throws Exception {
        //Arrange Statement(s)
        EventBus eventBusMock = mock(EventBus.class);
        doReturn(eventBusMock).when(vertxMock).eventBus();
        MessageConsumer messageConsumerMock = mock(MessageConsumer.class);
        MessageConsumer messageConsumerMock2 = mock(MessageConsumer.class);
        MessageConsumer messageConsumerMock3 = mock(MessageConsumer.class);
        doReturn(messageConsumerMock, messageConsumerMock2, messageConsumerMock3).when(eventBusMock).consumer(eq("news-feed"), (Handler) any());
        target = new Receiver();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        //Act Statement(s)
        final NullPointerException result = assertThrows(NullPointerException.class, () -> {
            target.start();
        });
        
        //Assert statement(s)
        assertAll("result", () -> {
            assertThat(result, is(notNullValue()));
            verify(vertxMock).eventBus();
            verify(eventBusMock, atLeast(3)).consumer(eq("news-feed"), (Handler) any());
        });
    }
}
