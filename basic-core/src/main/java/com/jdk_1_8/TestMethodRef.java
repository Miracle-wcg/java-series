package com.jdk_1_8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.function.*;

/**
 * 方法引用：若lambda 体中的内容有方法已经实现了，我们可以使用"方法引用"
 * (可以理解为方法引用是Lambda 表达式的另外一种变现形式)
 * <p>
 * 主要有三种语法形式：
 * <p>
 * 对象::实例方法名
 * <p>
 * 类::静态方法名
 * <p>
 * 类::实例方法名
 * <p>
 * 注意：
 * a. Lambda 体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 * b. 若lambda 参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
 * <p>
 * 二：构造器引用
 * 格式：
 * ClassName:new;
 * <p>
 * 三：数组引用
 * Type[]::new;
 */
public class TestMethodRef {

    //数组引用
    @Test
    public void test06() {
        Function<Integer, String[]> fun = (x) -> new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);

        Function<Integer, String[]> fun2 = String[]::new;
        String[] strings = fun2.apply(20);
        System.out.println(strings.length);
    }

    /**
     * 构造器函数引用
     */
    @Test
    public void Test05() {
        Supplier<Employee> supplier = () -> new Employee();

        //构造器引用方式
        Supplier<Employee> supplier1 = Employee::new;

        Employee employee = supplier.get();
        System.out.println(employee);
    }

    @Test
    public void test05_1() {
        Function<String, Employee> fun = (x) -> new Employee(x);

        Function<String, Employee> fun2 = Employee::new;
        Employee emp = fun2.apply("aaa");
        System.out.println(emp);

        BiFunction<String, Integer, Employee> bf = Employee::new;
        Employee employee = bf.apply("bb", 18);
        System.out.println(employee);
    }

    //类::实例方法
    @Test
    public void Test04() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);

        BiPredicate<String, String> biPredicate = String::equals;
    }

    //对象::实例方法名
    @Test
    public void test1() {
        PrintStream ps = System.out;
        Consumer<String> con = (x) -> ps.println(x);

        PrintStream printStream = System.out;
        Consumer<String> consumer = printStream::println;

        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("aa");
    }
}
