package src.functional.functions;

public class HigherOrderFunctions {

    public static void main(String[] args) {

        IFactory<Integer> factory = createFactory(() -> Math.random() * 100, r -> r.intValue());
        Integer finishedProduct = factory.create();
        System.out.println(finishedProduct);
    }

    public static <T, R> IFactory<R> createFactory(IProducer<T> producer, IConfigurator<T, R> iConfigurator) {
        return () -> {
            T product = producer.produce();
            return iConfigurator.configure(product);
        };
    }
}
