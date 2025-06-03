import java.util.concurrent.CompletableFuture;

public class AsyncExample {

    public static void main(String[] args) {
        System.out.println("Start of main");

        CompletableFuture<Void> task = fetchDataAsync()
            .thenAccept(result -> {
                System.out.println("Data received: " + result);
            });

        // This runs immediately (non-blocking)
        System.out.println("Main is still running...");

        // Wait for the async task to finish before exiting (for demo)
        task.join();

        System.out.println("End of main");
    }

    public static CompletableFuture<String> fetchDataAsync() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000); // Simulate delay
            } catch (InterruptedException e) {
                return "Error";
            }
            return "Hello from async!";
        });
    }
}
