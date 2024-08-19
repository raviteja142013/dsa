import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Pair {
    int first;
    double second;

    Pair(int f,double s)
    {
        first = f;
        second =s ;
    }
}

class Sample implements Comparator<Pair>
{
    Sample(){}
    public int compare(Pair p1,Pair p2)
    {
        if(p1.second > p2.second) return -1;

        if(p1.second < p2.second) return  1;

        return 0;
    }
}

public class ComparatorSorting {

    public static void main(String[] args) {
        List<Pair> list = new ArrayList<>();

        for(int i=1;i<=8;i++)
        {
            double d= (double) Math.random()*i;

            list.add(new Pair(i , d));
        }

        for(Pair p:list)
        {
            System.out.println(p.first+" "+p.second);
        }

        Collections.sort(list , new Sample());

        System.out.println("After sorting");

        for(Pair p:list)
        {
            System.out.println(p.first+" "+p.second);
        }
    }
}