import java.util.concurrent.CompletableFuture;

public class PromiseExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate a delay
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            return "Data loaded!";
        });

        future.thenAccept(result -> {
            System.out.println("Success: " + result);
        }).exceptionally(error -> {
            System.out.println("Error: " + error.getMessage());
            return null;
        });

        System.out.println("Promise is running...");
    }
}
