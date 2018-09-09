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
    public void sortBubble(){
        for (int i = size-1; i>0; i--) {
            for (int j = 0; j < i; j++) {
                if (myArray[j]>myArray[j+1]){
                    change(j, j+1);
                }
            }
        }
    }
    public void sortSelect(){
        int out, in ,mark;
        for (out = 0; out < size; out++) {
            mark=out;
            for (in = out; in <size ; in++) {
                if(myArray[in]<myArray[mark])
                    mark=in;
            }
            change(out,mark);
        }
    }
    public void sortInsert(){
        int in, out;
        for (out = 1;  out< size; out++) {
            int tmp = myArray[out];
            in = out;
            while (in>0 && myArray[in-1]>=tmp){
                myArray[in]=myArray[in-1];
                --in;
            }
            myArray[in]=tmp;
        }
    }
    public int len(){
        int len=0;
        len = myArray.length;
    return len;
    }
    private void change(int a, int b){
        int tmp= myArray[a];
        myArray[a]=myArray[b];
        myArray[b]=tmp;
    }
}
