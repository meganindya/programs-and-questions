import java.util.*;
import java.io.*;
class input
{
    static void main()throws IOException
    {
        PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Anindya/Desktop/in1.dat")));
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no of lines : ");
        int n=sc.nextInt();
        pw.println(n);
        for(int i=0;i<n*2;i++)
        {
            System.out.print("Enter String : ");
            String s=sc.next()+sc.nextLine();
            pw.println(s);
        }
        pw.close();
    }
}