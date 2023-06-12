package java8;

public class GreetingTest {

    public static void main(String[] args) {
        Greeting lambda = () -> System.out.println("Lambda");
        Greeting inner = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Inner");
            }
        };
        lambda.perform();
        inner.perform();
    }
}
