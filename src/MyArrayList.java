import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArrayList<T> {

    private T[] data;
    private int size;

    public MyArrayList(Class<T> clazz, int size) {
        //Initialises the data are with a type and size
        data = (T[]) Array.newInstance(clazz, size);
    }

    public MyArrayList() {
    }

    public void add (Object info) {
        //Checks if data array is full
        //If full increase max capacity by 10
        if (data[data.length-1] != null) {
            data = Arrays.copyOf(data, data.length + 10);
            data[size] = (T) info;
            size+=10;
        }
        //If not full add at available spot
        else {
            int i = 0;

            while (data[i] != null) {
                i++;
            }
            if (data[i] == null) {
                data[i] = (T) info;
            }
        }
    }

    public void removeFront (int num) {
        //Removes the first num of elements from the array
        data = Arrays.copyOfRange(data, num, data.length);
    }

    public void viewData () {
        int i = 0;
        //Prints all filled data spots up to the second to last spot
        while (data[i] != null && i < data.length-1) {
            System.out.println(data[i]);
            i++;
        }
        //Prints the last data spot if it isn't empty
        if (i == data.length-1 && data[i] != null) {
            System.out.println(data[i]);
        }
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>(Integer.class, 5);

        list.add(465);
        list.add(65);
        list.add(23);
        list.add(57);
        list.add(532);

        list.removeFront(3);

//        list.add(34);
//        list.add(56);
//        list.add(67);
//        list.add(83);

        list.viewData();
    }
}
