public class MyArr {

    public static void main(String[] args) {
    ChangeArray arr = new ChangeArray(7);
    arr.insert(4);
    arr.insert(3);
    arr.insert(5);
    arr.insert(10);
    arr.insert(7);
    arr.insert(5);
    arr.insert(2);
    arr.display();
    arr.delete(5);
    arr.delete(5);
    arr.display();
    }

}
