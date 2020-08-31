package list.calculation;

/**
 * @author Ji Rui
 * @date 2020/8/30 10:54
 */
public class Test {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();

        // 5x^3 + 3x^2 + x + 1
        p1.insert(new Item(3, 5));
        p1.insert(new Item(2, 3));
        p1.insert(new Item(1, 1));
        p1.insert(new Item(0, 1));

        // 2x^2 + 1
        p2.insert(new Item(2, 2));
        p2.insert(new Item(0, 1));

        p1.print();

        System.out.println("------");

        p2.print();

        System.out.println("------");

        Polynomial res = p1.add(p2);
        res.print();
    }
}
