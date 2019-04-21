package dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Predicate;

public class A {
    String name;

    public A(String name) {
        this.name = name;
    }

    public void printA() {
        System.out.println(this.name);
    }
}

class B extends A {
    public B(String name) {
        super(name);
    }
}

class C {
    static public <T extends A> void printG(T i) {
        i.printA();
    }

    public static void main(String[] args) {
        A a = new A("a");
        B b = new B("b");
        printG(b);
        printG(a);
    }
}

class D {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Geedks", "QA", "GeeksForQuiz", "goo");
        Predicate<String> p = s -> s.startsWith("G");
        for(String s: strings) {
            if(p.test(s)) {
                System.out.println(s);
            }
        }
    }
}

class PP {

}

class E {

    public void doA(Queue q) {
        if(q.isEmpty()) return;
        Object remove = q.remove();
        doA(q);
        System.out.println(remove.toString());
    }
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>(Arrays.asList("A", "B", "c", "d", "e"));
        for (String string : strings) {
            System.out.println(string);
        }
        new E().doA(strings);

    }
}


