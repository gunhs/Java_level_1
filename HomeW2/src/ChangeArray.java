public class ChangeArray {

    private int[] myArray;
    private int size;

    public ChangeArray(int size){
        this.size = 0;
        this.myArray = new int[size];
    }
    public void display (){
        for (int i = 0; i <size ; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
    }
    public void delete( int value){
        int i = 0;
        for (i = 0; i < size; i++) {
            if (myArray[i]==value){
                break;
            }
        }
        for (int j = i; j < size-1; j++) {
            myArray[j]=myArray[j+1];
        }
        size--;
    }
    public void insert(int value){
        myArray[size]=value;
        size++;
    }
}
