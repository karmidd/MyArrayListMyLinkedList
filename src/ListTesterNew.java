import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
public class ListTesterNew {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        Random rand = new Random();
        FileWriter fw = new FileWriter("testrun.txt",true);
        long start = 0;
        long end = 0;
        MyArrayList<Integer> mal1 = new MyArrayList<>(n);
        MyArrayList<Integer> mal2 = new MyArrayList<>(n);
        MyArrayList<Integer> mal3 = new MyArrayList<>(n);
        MyArrayList<Integer> mal4 = new MyArrayList<>(n);
        ArrayList<Integer> al1 = new ArrayList<>(n);
        ArrayList<Integer> al2 = new ArrayList<>(n);
        ArrayList<Integer> al3 = new ArrayList<>(n);
        ArrayList<Integer> al4 = new ArrayList<>(n);
        MyLinkedList2<Integer> mll1 = new MyLinkedList2<>();
        MyLinkedList2<Integer> mll2 = new MyLinkedList2<>();
        MyLinkedList2<Integer> mll3 = new MyLinkedList2<>();
        MyLinkedList2<Integer> mll4 = new MyLinkedList2<>();
        LinkedList<Integer> ll1 = new LinkedList<>();
        LinkedList<Integer> ll2 = new LinkedList<>();
        LinkedList<Integer> ll3 = new LinkedList<>();
        LinkedList<Integer> ll4 = new LinkedList<>();
        fw.write(String.format("%-15s %-25s %-23s %-26s", "N = " + n, "Insert@start (ms)", "Insert@end (ms)", "Insert@random (ms)"));
        fw.flush();
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            mal1.add(0,rand.nextInt(2*n));
        }
        System.out.println(mal1);
        end = System.currentTimeMillis();
        fw.write(String.format("%-25s %-25s", "\n" + "MyArrayList", (end - start)));
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            mal2.add(rand.nextInt(2*n));
        }
        end = System.currentTimeMillis();
        System.out.println(mal2);
        fw.write(String.format("%-23s", (end - start)));
        fw.flush();
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int random = rand.nextInt(mal3.size()+1);
            mal3.add(random,rand.nextInt(2*n));
        }
        end = System.currentTimeMillis();
        fw.write(String.format("%-26s", (end - start)));
        fw.flush();
        //MAL DONE--------------------------------------------------------------------------------------------------------------------

        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            al1.add(0,rand.nextInt(2*n));
        }
        System.out.println(al1);
        end = System.currentTimeMillis();
        fw.write(String.format("%-25s %-25s", "\n" + "ArrayList", (end - start)));
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            al2.add(rand.nextInt(2*n));
        }
        end = System.currentTimeMillis();
        System.out.println(al2);
        fw.write(String.format("%-23s", (end - start)));
        fw.flush();
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int random = rand.nextInt(al3.size()+1);
            al3.add(random,rand.nextInt(2*n));
        }
        System.out.println(al3);
        end = System.currentTimeMillis();
        fw.write(String.format("%-26s", (end - start)));
        fw.flush();
        //AL END-----------------------------------------------------------------------------

        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            mll1.add(0,rand.nextInt(2*n));
        }
        System.out.println(mll1);
        end = System.currentTimeMillis();
        fw.write(String.format("%-25s %-25s", "\n" + "MyLinkedList", (end - start)));
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            mll2.add(rand.nextInt(2*n));
        }
        end = System.currentTimeMillis();
        System.out.println(mll2);
        fw.write(String.format("%-23s", (end - start)));
        fw.flush();
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int random = rand.nextInt(mll3.size()+1);
            mll3.add(random,rand.nextInt(2*n));
        }
        System.out.println(mll3);
        end = System.currentTimeMillis();
        fw.write(String.format("%-26s", (end - start)));
        fw.flush();
        //MLL END --------------------------------------------------------------------------------------------------------

        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            ll1.add(0,rand.nextInt(2*n));
        }
        System.out.println(ll1);
        end = System.currentTimeMillis();
        fw.write(String.format("%-25s %-25s", "\n" + "LinkedList", (end - start)));
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            ll2.add(rand.nextInt(2*n));
        }
        end = System.currentTimeMillis();
        System.out.println(ll2);
        fw.write(String.format("%-23s", (end - start)));
        fw.flush();
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int random = rand.nextInt(ll3.size()+1);
            ll3.add(random,rand.nextInt(2*n));
        }
        System.out.println(ll3);
        end = System.currentTimeMillis();
        fw.write(String.format("%-26s", (end - start)) + "\n\n\n");
        fw.flush();
        //LL END --------------------------------------------------------------------------------------------------------

        mal4 = mal3.clone();
        al4 = (ArrayList<Integer>) al3.clone();
        mll4 = mll3.clone();
        ll4 = (LinkedList<Integer>) ll3.clone();

        fw.write(String.format("%-15s %-25s %-23s %-26s %-27s", "N = " + n, "Remove@start (ms)", "Remove@end (ms)", "Remove@random (ms)", "Remove byvalue (ms)"));
        fw.flush();
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            mal4.remove(0);
        }
        System.out.println(mal4);
        end = System.currentTimeMillis();
        fw.write(String.format("%-25s %-25s", "\n" + "MyArrayList", (end - start)));
        mal4 = mal3.clone();
        start = System.currentTimeMillis();
        for (int i = n-1; i >= 0; i--) {
            mal4.remove(i);
        }
        end = System.currentTimeMillis();
        System.out.println(mal4);
        fw.write(String.format("%-23s", (end - start)));
        fw.flush();
        mal4 = mal3.clone();
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            mal4.remove(rand.nextInt(mal4.size()));
        }
        end = System.currentTimeMillis();
        System.out.println(mal4);
        fw.write(String.format("%-26s", (end - start)));
        fw.flush();
        mal4 = mal3.clone();
        start = System.currentTimeMillis();
        while(mal4.size()!=0){
            Integer x = rand.nextInt(2*n);
            mal4.remove(x);
        }
        end = System.currentTimeMillis();
        System.out.println(mal4);
        fw.write(String.format("%-27s",(end - start)));
        fw.flush();
        //MAL END ---------------------------------------------------------------------------------------------------------

        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            al4.remove(0);
        }
        System.out.println(al4);
        end = System.currentTimeMillis();
        fw.write(String.format("%-25s %-25s", "\n" + "ArrayList", (end - start)));
        al4 = (ArrayList<Integer>) al3.clone();
        start = System.currentTimeMillis();
        for (int i = n-1; i >= 0; i--) {
            al4.remove(i);
        }
        end = System.currentTimeMillis();
        System.out.println(al4);
        fw.write(String.format("%-23s", (end - start)));
        fw.flush();
        al4 = (ArrayList<Integer>) al3.clone();
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            al4.remove(rand.nextInt(al4.size()));
        }
        end = System.currentTimeMillis();
        System.out.println(al4);
        fw.write(String.format("%-26s", (end - start)));
        fw.flush();
        al4 = (ArrayList<Integer>) al3.clone();
        start = System.currentTimeMillis();
        while(al4.size()!=0){
            Integer x = rand.nextInt(2*n);
            al4.remove(x);
        }
        end = System.currentTimeMillis();
        System.out.println(al4);
        fw.write(String.format("%-27s",(end - start)));
        fw.flush();
        //AL END ---------------------------------------------------------------------------------------------------------
    }
}
