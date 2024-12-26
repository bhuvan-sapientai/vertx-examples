package Io.vertx.examples.mongo;

import io.vertx.examples.mongo.MongoClientVerticle;
import io.vertx.core.json.JsonObject;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.mockito.ArgumentMatchers.eq;
import io.vertx.launcher.application.VertxApplication;
import io.vertx.core.Vertx;
import org.testcontainers.containers.MongoDBContainer;
import io.vertx.core.VerticleBase;
import org.mockito.Mock;
import io.vertx.ext.mongo.MongoClient;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import io.vertx.core.Future;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.endsWith;
import org.junit.jupiter.api.Timeout;
import org.mockito.InjectMocks;
import java.util.List;
import io.vertx.ext.mongo.MongoClientDeleteResult;
import io.vertx.core.Handler;
import java.util.function.Function;
import org.mockito.MockedStatic;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class MongoClientVerticleBaseRockGeneratedTest {

    private MongoClientVerticle verticle;

    @Mock
    private MongoClient mongoClient;

    @Mock
    private MongoDBContainer mongoDbContainer;

    private AutoCloseable closeable;

    private final MongoClient mongoClientMock = mock(MongoClient.class, "mongoClient");

    private AutoCloseable autoCloseableMocks;

    @InjectMocks()
    private MongoClientVerticle target;

    @AfterEach()
    public void afterTest() throws Exception {
        if (autoCloseableMocks != null)
            autoCloseableMocks.close();
    }

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        verticle = new MongoClientVerticle();
        verticle.init(mock(Vertx.class), mock(Vertx.class).getOrCreateContext());
    }

    @AfterEach
    void tearDown() throws Exception {
        if (closeable != null) {
            closeable.close();
        }
    }

    //BaseRock generated method id: ${startTest}, hash: E716CFFC1E93253F54B69540335D426B
    @Test()
    void startTest() {
        /*
         * TODO: Help needed! This method is not unit testable!
         *  A variable could not be isolated/mocked when calling a method - Variable name: MONGO_DB_CONTAINER - Method: getConnectionString
         *  Suggestions:
         *  You can pass them as constructor arguments or create a setter for them (avoid new operator)
         *  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.
         *  The test code, including the assertion statements, has been successfully generated.
         */
         //Arrange Statement(s)
        Future<String> futureMock = mock(Future.class);
        Future futureMock2 = mock(Future.class);
        Future futureMock3 = mock(Future.class);
        Future<?> futureMock4 = mock(Future.class);
        Future<List<JsonObject>> futureMock5 = mock(Future.class);
        Future<MongoClientDeleteResult> futureMock6 = mock(Future.class);
        try (MockedStatic<MongoClient> mongoClient = mockStatic(MongoClient.class)) {
            doReturn(futureMock).when(mongoClientMock).save(eq("products"), (JsonObject) any());
            doReturn(futureMock2).when(futureMock).compose((Function) any());
            doReturn(futureMock3).when(futureMock2).compose((Function) any());
            doReturn(futureMock4).when(futureMock3).onSuccess((Handler) any());
            doReturn(futureMock5).when(mongoClientMock).find(eq("products"), (JsonObject) any());
            doReturn(futureMock6).when(mongoClientMock).removeDocument(eq("products"), (JsonObject) any());
            mongoClient.when(() -> MongoClient.createShared(eq((Vertx) null), (JsonObject) any())).thenReturn(mongoClientMock);
            target = new MongoClientVerticle();
            autoCloseableMocks = MockitoAnnotations.openMocks(this);
            //Act Statement(s)
            Future<?> result = target.start();
            //Assert statement(s)
            assertAll("result", () -> {
                assertThat(result, equalTo(futureMock4));
                verify(mongoClientMock).save(eq("products"), (JsonObject) any());
                verify(futureMock).compose((Function) any());
                verify(futureMock2).compose((Function) any());
                verify(futureMock3).onSuccess((Handler) any());
                verify(mongoClientMock).find(eq("products"), (JsonObject) any());
                verify(mongoClientMock).removeDocument(eq("products"), (JsonObject) any());
                mongoClient.verify(() -> MongoClient.createShared(eq((Vertx) null), (JsonObject) any()));
            });
        }
    }
}
