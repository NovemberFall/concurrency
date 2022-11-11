package concurrency_CN.Lambda;

public class lambdaThread2 {
    public static void main(String[] args) {

//        Ilove love = null;

        //1. lambda 表示简化
        Ilove love = (int a) -> {
            System.out.println("I love Java => " + a);
        };

        // 简化1： 参数类型
        love = (a) -> {
            System.out.println("I love Java => " + a);
        };

        // 简化2： 简化刮号
        love = a -> {
            System.out.println("I love Java => " + a);
        };

        // 简化3： 简化 { }
        love = a -> System.out.println("I love Java => " + a);

        //总结：
           // lambda 只能有一行代码的情况下才能简化，如果有多行，就用代码块
           // 前提是interface is functional interface(Only one method)
        //多个参数也可以去掉参数类型，要去掉就一起去掉, 必须加上刮号
        love.love(520);
    }
}

interface Ilove{
    void love(int a);
}
