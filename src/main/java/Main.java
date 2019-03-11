public class Main {


    public static void main(String[] args) {

    }

}

class Holder<T> {
    private T a;

    public Holder(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }
}

class Sholder<T> extends Holder<T> {

    public Sholder(T a) {
        super(a);
    }
}
