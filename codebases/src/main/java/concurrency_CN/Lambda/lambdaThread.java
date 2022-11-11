package concurrency_CN.Lambda;


public class lambdaThread {

    // 3. static inner class
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("I like lambda 2");
        }
    }


    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        //4. 局部内部类
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("I like lambda 3");
            }
        }
        like = new Like3();
        like.lambda();

        //5. Anonymous inner class, 没有类的名称，必须借助interface
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda 4");
            }
        };
        like.lambda();

        //6. lambda expression
        like = () -> {
            System.out.println("I like lambda 5");
        };
        like.lambda();
    }
}

//1. declare an interface
interface ILike {
    void lambda();
}

//2. 实现类
class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}