package concurrency_CN;

/**
 * Static Proxy Mode
 * 1.Real object
 * 2.Proxy Object
 *
 * The structures required for a static proxy mode include:
 * 1. An interface;
 * 2. A real object implements this interface;
 * 3. A proxy object implements this interface and
 *    passes real object parameters to "proxy" operations in the proxy object class.
 *
 */
public class staticProxy {
    public static void main(String[] args) {
        new WeddingProxy(new Person()).marry();
    }
}

interface Marry {
    void marry();
}

//Real Object
class Person implements Marry {
    @Override
    public void marry() {
        System.out.println("Congratulations on your marriage!");
    }
}

// Proxy Object
class WeddingProxy implements Marry {
    private Person person;

    public WeddingProxy(Person person) {//Constructor, with properties
        this.person = person;
    }

    @Override
    public void marry() {//Proxy function
        prepare();
        this.person.marry();
        finish();
    }

    public void prepare() {
        System.out.println("Preparing for marriage is done!");
    }

    public void finish() {
        System.out.println("Follow-up on your marriage is done!");
    }
}
