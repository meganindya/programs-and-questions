import java.io.*;
class p1
{
    void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new FileReader("C:/Users/Anindya/Desktop/in1.dat"));
        PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Anindya/Desktop/out1.dat")));
        int v=Integer.parseInt(br.readLine());
        for(int z=0;z<v;z++)
        {
            int l=Integer.parseInt(br.readLine());
            String s=br.readLine();int u=0;
            char a1[]=new char[l],a2[]=new char[l];
            char h[]=s.toCharArray();int c1=0,c2=c1;
            int m=-1,n=-1;a1[++m]=h[0];
            for(int i=1;i<l;i++)
            {
                if(i==1)
                {
                    if(h[i]==a1[m])  a2[++n]=h[i];
                    else a1[++m]=h[i];
                }
                else
                {
                    if(m>=1)
                        c1=uniq(h[i],a1[m],a1[m-1]);
                    else if(m==0)
                    {
                        if(h[i]!=a1[m])
                            c1=2;
                    }
                    else    c1=1;
                    if(n>=1)
                        c2=uniq(h[i],a2[n],a2[n-1]);
                    else if(n==0)
                    {
                        if(h[i]!=a2[n])
                            c2=2;
                    }
                    else    c2=1;
                    if(c2==c1)
                        a1[++m]=h[i];
                    else if(c1>c2)
                        a1[++m]=h[i];
                    else if(c2>c1)
                        a2[++n]=h[i];
                }
            }
            String s1=new String(a1);
            String s2=new String(a2);
            u=count(s1)+count(s2);
            pw.println(u);
        }
        pw.close();
    }
    int count(String s)
    {
        s=s.trim();String t;int u=0;
        int l=s.length();
        for(int i=0;i<l;i++)
        {
            int c=0;
            if(i==0)
                t=s.substring(0,1);
            else if(i==1)
                t=s.substring(0,2);
            else
                t=s.substring(i-2,i+1);
            char a[]=t.toCharArray();
            if(a.length==1)
                c=1;
            else if(a.length==2)
            {
                if(a[0]!=a[1])  c=2;
                else            c=1;
            }
            else
            {
                for(int j=0;j<a.length;j++)
                {
                    for(int k=j+1;k<a.length;k++)
                    {
                        if(a[j]!=a[k])
                            c++;
                    }
                }
                if(c==0)    c++;
            }
            u+=c;
        }
        return u;
    }
    int uniq(char x,char y,char z)
    {
        char a[]={x,y,z};int c=0;
        for(int j=0;j<3;j++)
        {
            for(int k=j+1;k<3;k++)
            {
                if(a[j]!=a[k])
                    c++;
            }
        }
        if(c==0)    c++;
        return c;
    }
}