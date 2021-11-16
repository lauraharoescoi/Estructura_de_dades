package apartado2;

public class CheckEven implements Check<Integer> {
    @Override
    public boolean test(Integer n) {
        return n % 2 == 0;
    }
}
