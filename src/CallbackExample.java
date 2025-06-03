interface Callback {
    void call(String result);
}

public class CallbackExample {

    public static void main(String[] args) {
        doCalculation(5, 10, result -> {
            System.out.println("Callback received result: " + result);
        });
    }

    public static void doCalculation(int a, int b, Callback callback) {
        int sum = a + b;
        callback.call("The sum is " + sum);
    }
}
