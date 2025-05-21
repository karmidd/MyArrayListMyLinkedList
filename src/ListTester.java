import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class ListTester {
    static MyArrayList<Integer> mal = new MyArrayList<>();
    static MyLinkedList<Integer> mll = new MyLinkedList<>();
    static LinkedList<Integer> ll = new LinkedList<>();
    static ArrayList<Integer> al = new ArrayList<>();
    static public void printAddResult(int n){
        mal.clear();
        mll.clear();
        ll.clear();
        al.clear();
        Random rand = new Random();
        String[] types = {"MyArrayList", "ArrayList", "MyLinkedList", "LinkedList"};
        for (int j = 0; j < 4; j++) {
            try (FileWriter fw = new FileWriter("testrun.txt", true)) {
                if(j==0)
                    fw.write(String.format("%-15s %-25s %-23s %-26s", "N = " + n, "Insert@start (ms)", "Insert@end (ms)", "Insert@random (ms)"));
                long start = System.currentTimeMillis();
                for (int i = 0; i < n; i++) {
                    switch(j){
                        case 0:
                            mal.add(0,rand.nextInt(2*n));
                            break;
                        case 1:
                            al.add(0,rand.nextInt(2*n));
                            break;
                        case 2:
                            mll.add(0,rand.nextInt(2*n));
                            break;
                        case 3:
                            ll.add(0,rand.nextInt(2*n));
                            break;
                    }
                }
                long end = System.currentTimeMillis();
                fw.write(String.format("%-25s %-25s", "\n" + types[j], (end - start)));
                switch(j){
                    case 0:
                        mal.clear();
                        break;
                    case 1:
                        al.clear();
                        break;
                    case 2:
                        mll.clear();
                        break;
                    case 3:
                        ll.clear();
                        break;

                }
                start = 0;
                end = 0;
                start = System.currentTimeMillis();
                for (int i = 0; i < n; i++) {
                    switch(j){
                        case 0:
                            mal.add(rand.nextInt(2*n));
                            break;
                        case 1:
                            al.add(rand.nextInt(2*n));
                            break;
                        case 2:
                            mll.add(rand.nextInt(2*n));
                            break;
                        case 3:
                            ll.add(rand.nextInt(2*n));
                            break;
                    }
                }
                end = System.currentTimeMillis();
                fw.write(String.format("%-23s", (end - start)));
                switch(j){
                    case 0:
                        mal.clear();
                        break;
                    case 1:
                        al.clear();
                        break;
                    case 2:
                        mll.clear();
                        break;
                    case 3:
                        ll.clear();
                        break;

                }
                start = 0;
                end = 0;
                start = System.currentTimeMillis();
                for (int i = 0; i < n; i++) {
                    switch(j){
                        case 0:
                            mal.add(rand.nextInt(mal.size()+1),rand.nextInt(2*n));
                            break;
                        case 1:
                            al.add(rand.nextInt(al.size()+1),rand.nextInt(2*n));
                            break;
                        case 2:
                            mll.add(rand.nextInt(mll.size()+1),rand.nextInt(2*n));
                            break;
                        case 3:
                            ll.add(rand.nextInt(ll.size()+1),rand.nextInt(2*n));
                            break;
                    }
                }
                end = System.currentTimeMillis();
                fw.write(String.format("%-26s",(end - start)));
                switch(j){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
                if(j==3)
                    fw.write("\n\n\n");
            } catch (Exception e) {
                System.exit(1);
            }
        }
    }

    static public void printRemoveResult(int n){
        Random rand = new Random();
        MyArrayList<Integer> malClone1 = mal.clone();
        MyArrayList<Integer> malClone2 = mal.clone();
        MyArrayList<Integer> malClone3 = mal.clone();
        MyArrayList<Integer> malClone4 = mal.clone();

        ArrayList<Integer> alClone1 = (ArrayList<Integer>) al.clone();
        ArrayList<Integer> alClone2 = (ArrayList<Integer>) al.clone();
        ArrayList<Integer> alClone3 = (ArrayList<Integer>) al.clone();
        ArrayList<Integer> alClone4 = (ArrayList<Integer>) al.clone();

        MyLinkedList<Integer> mllClone1 = mll.clone();
        MyLinkedList<Integer> mllClone2 = mll.clone();
        MyLinkedList<Integer> mllClone3 = mll.clone();
        MyLinkedList<Integer> mllClone4 = mll.clone();

        LinkedList<Integer> llClone1 = (LinkedList<Integer>) ll.clone();
        LinkedList<Integer> llClone2 = (LinkedList<Integer>) ll.clone();
        LinkedList<Integer> llClone3 = (LinkedList<Integer>) ll.clone();
        LinkedList<Integer> llClone4 = (LinkedList<Integer>) ll.clone();

        String[] types = {"MyArrayList", "ArrayList", "MyLinkedList", "LinkedList"};
        for (int j = 0; j < 4; j++) {
            try (FileWriter fw = new FileWriter("testrun.txt", true)) {
                if(j==0)
                    fw.write(String.format("%-15s %-25s %-23s %-26s %-27s", "N = " + n, "Remove@start (ms)", "Remove@end (ms)", "Remove@random (ms)", "Remove byvalue (ms)"));
                long start = System.currentTimeMillis();
                for (int i = 0; i < n; i++) {
                    switch(j){
                        case 0:
                            malClone1.remove(0);
                            break;
                        case 1:
                            alClone1.remove(0);
                            break;
                        case 2:
                            mllClone1.remove(0);
                            break;
                        case 3:
                            llClone1.remove(0);
                            break;
                    }
                }
                long end = System.currentTimeMillis();
                fw.write(String.format("%-25s %-25s", "\n" + types[j], (end - start)));
                start = 0;
                end = 0;
                start = System.currentTimeMillis();
                for (int i = n-1; i >= 0; i--) {
                    switch(j){
                        case 0:
                            malClone2.remove(i);
                            break;
                        case 1:
                            alClone2.remove(i);
                            break;
                        case 2:
                            mllClone2.remove(i);
                            break;
                        case 3:
                            llClone2.remove(i);
                            break;
                    }
                }
                end = System.currentTimeMillis();
                fw.write(String.format("%-23s", (end - start)));
                start = 0;
                end = 0;
                start = System.currentTimeMillis();
                for (int i = 0; i < n; i++) {
                    switch(j){
                        case 0:
                            malClone3.remove(rand.nextInt(malClone3.size()));
                            break;
                        case 1:
                            alClone3.remove(rand.nextInt(alClone3.size()));
                            break;
                        case 2:
                            mllClone3.remove(rand.nextInt(mllClone3.size()));
                            break;
                        case 3:
                            llClone3.remove(rand.nextInt(llClone3.size()));
                            break;
                    }
                }
                end = System.currentTimeMillis();
                fw.write(String.format("%-26s",(end - start)));
                start = 0;
                end = 0;
                start = System.currentTimeMillis();
                    switch(j){
                        case 0:
                            while(malClone4.size()!=0){
                                Integer x = rand.nextInt(2*n);
                                malClone4.remove(x);
                            }
                            break;
                        case 1:
                            while(alClone4.size()!=0){
                                Integer x = rand.nextInt(2*n);
                                alClone4.remove(x);
                            }
                            break;
                        case 2:
                            while(mllClone4.size()!=0){
                                Integer x = rand.nextInt(2*n);
                                mllClone4.remove(x);
                            }
                            break;
                        case 3:
                            while(llClone4.size()!=0){
                                Integer x = rand.nextInt(2*n);
                                llClone4.remove(x);
                            }
                            break;
                    }
                end = System.currentTimeMillis();
                fw.write(String.format("%-27s",(end - start)));
                if(j==3) {
                    fw.write("\n\n\n");
                }
            } catch (Exception e) {
                System.out.println(e);
                System.exit(1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scan.nextInt();
        ListTester.printAddResult(n);
        ListTester.printRemoveResult(n);
    }
}
