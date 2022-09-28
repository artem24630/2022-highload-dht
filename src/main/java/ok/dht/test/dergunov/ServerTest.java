package ok.dht.test.dergunov;

import ok.dht.ServiceConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class ServerTest {

    private ServerTest() {
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException, TimeoutException {
        int port = 8084;
        String url = "http://localhost:" + port;
        ServiceConfig config = new ServiceConfig(
                port,
                url,
                Collections.singletonList(url),
                Files.createTempDirectory("server3")
        );
        new ServiceImpl(config).start().get(1, TimeUnit.SECONDS);

        System.out.println("Socket is ready: " + url);
    }
}
