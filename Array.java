//import java.sql.SQLOutput;
//import java.util.Scanner;
//
//class Array{
//
//    static int  n,idx=-1;
//    static int[] arr;
//    static Scanner sc =new Scanner(System.in); ;
//
//    public static boolean isEmpty()
//    {
//        if(idx == -1) return true;
//
//        return false;
//    }
//
//    public static boolean isFull()
//    {
//        if(idx >= n) return true;
//
//        return false;
//    }
//
//    public static void insert()
//    {
//        idx++;
//
//        if(isFull())
//        {
//            System.out.println("Array is full! can't insert");
//            return;
//        }
//
//        System.out.print("Enter the lement the data into array:");
//
//        arr[idx] = sc.nextInt();
//    }
//
//    public static void insertAtPostion(int position)
//    {
//        if(position<=0 && position>=n)
//        {
//            System.out.println("Invalid Position!");
//            return;
//        }
//
//        idx++;
//
//        if(isFull())
//        {
//            System.out.println("Array is Full!");
//            return;
//        }
//
//        int ele = sc.nextInt();
//
//        int i = idx;
//
//        while(i>=position)
//        {
//            if(i-1 >=0)
//            {
//                arr[i] = arr[i-1];
//            }
//            i--;
//        }
//
//        arr[position-1] = ele;
//    }
//
//    public static int peek()
//    {
//        if(isEmpty())
//        {
//            System.out.println("Array is Empty!");
//            return -1;
//        }
//
//        return arr[idx];
//    }
//
//    public static void delete()
//    {
//        if(isEmpty())
//        {
//            System.out.println("Array is Empty!");
//            return;
//        }
//
//        arr[idx] = 0;
//        idx--;
//    }
//
//    public static void deleteAtPosition(int position)
//    {
//        if(position<=0 || position>=n)
//        {
//            System.out.println("Invalid Position");
//            return;
//        }
//
//        if(isEmpty())
//        {
//            System.out.println("Array is Empty!");
//            return;
//        }
//
//        for(int i=position-1;i<idx;i++)
//        {
//            arr[i] = arr[i+1];
//        }
//        idx--;
//    }
//
//
//
//    public static void main(String[] args)
//    {
//        System.out.println(peek());
//        System.out.print("Enter the size of an array:");
//        n = sc.nextInt();
//        arr = new int[n];
//
//        for(int i=0;i<n-3;i++)
//        {
//            insert();
//
//        }
//
//        insertAtPostion(3);
//
//        for(int i=0;i<=idx;i++)
//        {
//            System.out.println(arr[i]);
//        }
//
//        System.out.println("----------------------");
//
//        delete();arr
//
//        for(int i=0;i<=idx;i++)
//        {
//            System.out.println(arr[i]);
//        }
//        System.out.println("----------------------");
//
//        deleteAtPosition(4);
//
//        for(int i=0;i<=idx;i++)
//        {
//            System.out.println(arr[i]);
//
//        }
//    }
//}
//
