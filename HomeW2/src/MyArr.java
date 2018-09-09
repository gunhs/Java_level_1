public class MyArr {
    public static void main(String[] args) {

    int[] bigArray = new int[1000000];
    for (int i = 0; i < bigArray.length; i++) {
        bigArray[i] = (int)(Math.random()*10);
    }
    for (int i = 0; i < 10; i++) {
            System.out.print(bigArray[i]+" ");
    }
    System.out.println();

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
    arr.insert(5);
    arr.display();
    arr.sortSelect();
    arr.display();

    ChangeArray arraySort1 = new ChangeArray(20000);
    for (int i = 0; i <arraySort1.len(); i++) {
    arraySort1.insert((int)(Math.random()*10));}
    long start1 = System.currentTimeMillis();
    arraySort1.sortBubble();
    long finish1 = System.currentTimeMillis();
    long time1 = finish1 - start1;
    System.out.println("Время выполнеия операции составило "+ time1);

    ChangeArray arraySort2 = new ChangeArray(20000);
    for (int i = 0; i <arraySort1.len(); i++) {
    arraySort2.insert((int)(Math.random()*10));}
    long start2 = System.currentTimeMillis();
    arraySort2.sortSelect();
    long finish2 = System.currentTimeMillis();
    long time2 = finish2 - start2;
    System.out.println("Время выполнеия операции составило " + time2);

    ChangeArray arraySort3 = new ChangeArray(20000);
    for (int i = 0; i < arraySort1.len(); i++) {
    arraySort3.insert((int) (Math.random() * 10));}
    long start3 = System.currentTimeMillis();
    arraySort3.sortInsert();
    long finish3 = System.currentTimeMillis();
    long time3 = finish3 - start3;
    System.out.println("Время выполнеия операции составило " + time3);

    }
}
