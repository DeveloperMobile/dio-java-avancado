package aula6;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ClientHttpExemplo {
    static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            System.out.println("Nova Thread Criada ::  " + (thread.isDaemon() ? "Daemon" : "") + "Thread Group :: " + thread.getThreadGroup());
            return thread;
        }
    });

    public static void main(String[] args) throws IOException, InterruptedException {
        connectAndPrintUrlJavaOracle();
    }

    public static void connectAkamaiHttp11Cliente() throws IOException, InterruptedException {
        System.out.println("Running HTTP1.1 exemple...");

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .proxy(ProxySelector.getDefault())
                .build();

        long start = System.currentTimeMillis();

        HttpRequest minRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
                .build();

        HttpResponse<String> response = httpClient.send(minRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code ::: " + response.statusCode());
        System.out.println("Response Headers ::: " + response.headers());
        String responseBody = response.body();
        System.out.println(responseBody);

        List<Future<?>> future = new ArrayList<>();

        responseBody
                .lines()
                .filter(line -> line.trim().startsWith("<img height="))
                .map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>")))
                .forEach(image -> {
                    Future<?> imgFuture = executor.submit(() -> {
                        HttpRequest imgRequest = HttpRequest.newBuilder()
                                .uri(URI.create("https://http2.akamai.com" + image))
                                .build();

                        try {
                            HttpResponse<String> imageResponse =
                                    httpClient.send(imgRequest, HttpResponse.BodyHandlers.ofString());
                        } catch (IOException | InterruptedException e) {
                            System.out.println("Mensagem de erro durante requisição para recuperar a imagem :: " + image);
                        }
                    });
                    future.add(imgFuture);
                    System.out.println("Submetido um futoro para imagem :: " + image);
                });

        future.forEach(f -> {
            try {
                f.get();
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Erro ao carregar imagem do futuro");
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("Tempo de carregamento total :: " + (end - start) + " ms");
        executor.shutdown();
    }

    public static void connectAkamaiHttp11Cliente2() throws IOException, InterruptedException {
        System.out.println("Running HTTP2 exemple...");

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .proxy(ProxySelector.getDefault())
                .build();

        long start = System.currentTimeMillis();

        HttpRequest minRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
                .build();

        HttpResponse<String> response = httpClient.send(minRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code ::: " + response.statusCode());
        System.out.println("Response Headers ::: " + response.headers());
        String responseBody = response.body();
        System.out.println(responseBody);

        List<Future<?>> future = new ArrayList<>();

        responseBody
                .lines()
                .filter(line -> line.trim().startsWith("<img height="))
                .map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>")))
                .forEach(image -> {
                    Future<?> imgFuture = executor.submit(() -> {
                        HttpRequest imgRequest = HttpRequest.newBuilder()
                                .uri(URI.create("https://http2.akamai.com" + image))
                                .build();

                        try {
                            HttpResponse<String> imageResponse =
                                    httpClient.send(imgRequest, HttpResponse.BodyHandlers.ofString());
                        } catch (IOException | InterruptedException e) {
                            System.out.println("Mensagem de erro durante requisição para recuperar a imagem :: " + image);
                        }
                    });
                    future.add(imgFuture);
                    System.out.println("Submetido um futoro para imagem :: " + image);
                });

        future.forEach(f -> {
            try {
                f.get();
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Erro ao carregar imagem do futuro");
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("Tempo de carregamento total :: " + (end - start) + " ms");
        executor.shutdown();
    }

    public static void connectAndPrintUrlJavaOracle() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET().uri(URI.create("https://www.oracle.com/br/downloads/"))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status code :: " + response.statusCode());
        System.out.println("Handlers response :: " + response.headers());
        System.out.println("Body :: " + response.body());
    }
}
