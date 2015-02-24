import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
class record
{
String f1,f2,f3;
}
class ques
{
 int qn;
 String q,o1,o2,o3,o4,ans;
 }

class design  implements ActionListener,ItemListener
{
 JFrame f1;
 JLabel l1,l2,l3,l4,l5,time,end;
 JButton b1,b2,b3,b4,lock,prev,next,submitt,enter;
 Button but[]=new Button[35];
 TextField t1,t2,t3,last;
 TextArea area;
 Checkbox cb1,cb2,cb3,cb4;
 CheckboxGroup cg;
 Panel pn1,pn2,pn3;
 Image im;
 ques question[]=new ques[35];
  Thread t;
 record r[]=new record[10000];
 int current,previous,i,j,k,N,total_question;
 float score;
 int m,s;
 boolean status[]=new boolean[30];

 design()throws InstantiationException,ClassNotFoundException,IllegalAccessException,UnsupportedLookAndFeelException
 {
   f1=new JFrame("WELCOME TO TOTALC");
   f1.setSize(32767,32767);
   //f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
     f1.setVisible(true);


    f1.setContentPane(new JLabel(new ImageIcon("ad.jpg")));
   f1.setLayout(null);
   b1=new JButton("PLAY");
   prev=new JButton("prev");
   next=new JButton("next");
   lock=new JButton("Lock");
   f1.add(b1);

   b1.setBounds(500,600,80,30);
   b2=new JButton("HELP");
   f1.add(b2);
   enter=new JButton("Enter");
   b2.setBounds(650,600,100,30);


   set();
   f1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
     f1.setVisible(true);
   b3=new JButton(new ImageIcon("LOGIN.PNG"));
   b4=new JButton(new ImageIcon("cancel.PNG"));

    time=new JLabel("hello",JLabel.CENTER);
    f1.add(time);
            time.setBounds(1150,200,200,100);
            time.setOpaque(true);
            time.setFont(new Font("Arial",Font.BOLD,60));
            time.setBackground(Color.black);
            time.setForeground(Color.white);
            m=1;
            s=60;
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            b4.addActionListener(this);
            lock.addActionListener(this);
            prev.addActionListener(this);
            next.addActionListener(this);
            enter.addActionListener(this);


            startTime();

 }
  void set()
  {
  l1=new JLabel(new ImageIcon("cad.png"));
   f1.add(l1);

   l2=new JLabel(new ImageIcon("chaos.png"));
   f1.add(l2);

   l3=new JLabel(new ImageIcon("logo.png"));
   f1.add(l3);
   l1.setBounds(1200,30,77,77);
    l2.setBounds(450,30,315,43);
   l3.setBounds(100,30,77,70);
   }
   void startTime()
    {
           while (m >= 0 && s >= 0)
            {
                try
                {
                    t.sleep(1000);
                    s--;
                    if (s >= 10)
                    {
                          time.setText("" + m + ":" + s);
                    }
                    else
                    {
                        time.setText("" + m + ":" + "0"+s);

                        if (s == 0)
                        {
                            m--;
                            s=60;
                            if (m >= 10)
                            {
                             time.setText("" + m + ":" + s);

                            }
                            else
                             {
                                time.setText("0" + m + ":" + s);

                             }

                        }
                    }
                }
                 catch (Exception ex)
                {
                    System.out.println(ex);
                }
            } //closing of while
            submit();


      }

      void help_window()

      {
      JFrame f2;
       //Image im1;
       //JLabel l1;
       f2=new JFrame("welcome to help window");
       f2.setSize(1030,540);
       f2.setResizable(false);
       f2.setLayout(null);
      f2.setContentPane(new JLabel(new ImageIcon("help.PNG")));
       //f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f2.setVisible(true);

      }

    void play()
    {
      ///startTime();

     b1.setBounds(0,0,0,0);
     b2.setBounds(0,0,0,0);
     f1.remove(l2);
     pn1=new Panel();
     f1.add(pn1);
     pn1.setLayout(null);
     pn1.setBounds(200,200,900,400);
     pn1.setBackground(Color.gray);
     l1=new JLabel(new ImageIcon("un.PNG"));
     pn1.add(l1);
     l1.setBounds(50,50,200,40);
     t1=new TextField();
     pn1.add(t1);
     t1.setBounds(300,50,200,40);
     l2=new JLabel(new ImageIcon("pwd.PNG"));
     pn1.add(l2);
     //pn1.setBackground(new Color(0,0,0,20));
     l2.setBounds(50,130,201,33);
     t2=new TextField();
     pn1.add(t2);
     t2.setBounds(300,130,200,40);

     pn1.add(b3);
     b3.setBounds(200,250,167,48);
     pn1.add(b4);
     b4.setBounds(400,250,167,48);
     //b3.addActionListener(this);
     //b4.addActionListener(this);
     //startTime();
     }
     void cancel()
     {
      t1.setText("");
      t2.setText("");
    }
      void reg()
      {

       String un,pwd;
       fetch();
       boolean flag=false;
       int i;
       un=t1.getText();
       pwd=t2.getText();
       for(i=0;i<N;i++)
        {
           if(un.equals(r[i].f2)&&pwd.equals(r[i].f3))
            {
            flag=true;

            break;
            }
        }
           if(flag==false)
            {
             JOptionPane.showMessageDialog(f1,"INVALID USERNAME/PASSWORD TRY AGAIN");
             cancel();
            }
            else
            {
            m=1;
            s=60;
            cancel();
             f1.remove(pn1);

            start();
            }
      }
      public void actionPerformed(ActionEvent e)
      {

       if(e.getSource()==b2)
       {
         help_window();
         }
         else if(e.getSource()==b1)
          {
           //startTime();
           //m=1;
           //s=60;
           play();
           }
           else if(e.getSource()==b3)
            reg();
            else if(e.getSource()==b4)
             cancel();
             else if(e.getSource()==next)
             {
              current++;
              if(current==total_question)
               current=0;
               show_question(current);
               }
               else if(e.getSource()==prev)
               {
                current--;
                if(current==-1)
                 current=total_question-1;
                 show_question(current);
                 }
                 else if(e.getSource()==lock)
                   evaluate();
                   else if(e.getSource()==enter)
                   {
                     String myname=last.getText();
                     if(last.equals("1234"));
                     System.exit(0);
                     }
                   else
                    {
                     Button c=(Button)e.getSource();
                     String x=c.getLabel();
                     int index=Integer.parseInt(x)-1;
                     //JOptionPane.showMessageDialog(null," index= "+index);
                       current=index;
                       show_question(index);

                     }

      }
      void fetch()
      {
       Connection con;
        Statement st;
        ResultSet rs;
        String f1,f2,f3;
        int cnt=0;
        try
       {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       }
      catch(ClassNotFoundException e)
      {
      }
      try
      {
     con=DriverManager.getConnection("jdbc:odbc:caddsn","","");
     st=con.createStatement();
     rs=st.executeQuery("select * from reg");
     //System.out.print("\n serial   NAME    ROLL");
     while(rs.next())
     {
      f1=rs.getString(1);
      f2=rs.getString(2);
      f3=rs.getString(3);
      r[i]=new record();
      r[i].f1=f1;
      r[i].f2=f2;
      r[i].f3=f3;
      i++;
      }
      N=i;

      rs.close();
      con.close();
      st.close();
   }
   catch(SQLException e)
   {
   }


 }
 void submit()
 {
  time.setText("thanks");
  f1.remove(pn1);
  f1.remove(time);
  f1.remove(pn3);
  f1.remove(l1);
  f1.remove(l2);
  f1.remove(l3);
  //f1.setContentPane(new JLabel(new ImageIcon("abc.jpg")));
  f1.setSize(1600,1200);
  JLabel rajag=new JLabel("password");
  f1.add(rajag);
  rajag.setBounds(200,200,100,20);
  last=new TextField();
  f1.add(last);
  last.setBounds(350,200,100,20);
  f1.add(enter);
  enter.setBounds(400,260,70,25);
  try
  {
  blink();
  }catch(Exception e){}


  //JOptionPane.showMessageDialog(null,"hii welcome your total score is "+score);

  }
   void blink()  throws Exception
    {
     end=new JLabel("your score is "+Float.toString(score));
     end.setForeground(Color.red);
     end.setFont(new Font("Arial",Font.BOLD,60));
     while(true)
      {f1.add(end);
      end.setBounds(400,400,600,200);
       Thread.sleep(500);
       end.setBounds(0,0,0,0);
       f1.remove(end);
       Thread.sleep(500);
      }
    }

 void start()
  {

   pn3=new Panel();
   f1.add(pn3);
   pn3.setBounds(1120,500,200,160);
  // pn3.setBackground(Color.darkGray);
   pn3.setLayout(null);
   int x,y;
   x=2;
   y=-30;

   int tmp=0;
   int  z=1;
   for(int i=1;i<=5;i++)
    {
     y+=32;
     x=2;
     for(int j=1;j<=6;j++)
      {
      //int z=tmp+1;
      but[tmp]=new Button(Integer.toString(z));

       pn3.add(but[tmp]);
       but[tmp].setLabel(Integer.toString(z));
       but[tmp].setBounds(x,y,32,32);
       but[tmp].addActionListener(this);

       z++;

       x+=32;
       tmp++;
     }
   }
   pn1=new Panel();
   f1.add(pn1);

   pn1.setBounds(20,200,1000,450);
   pn1.setLayout(null);
   pn1.setBackground(Color.darkGray);
   fetch_ques();

   play_game();




   //JOptionPane.showMessageDialog(f1,"going to call start time");
   //startTime();

 }
 void fetch_ques()
 {

  int i,j,k;
  for(i=0;i<35;i++)
   {
    question[i]=new ques();
    }

       Connection con;
        Statement st;
        ResultSet rs;
        try
       {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       }
      catch(ClassNotFoundException e)
      {
      }
        try
      {
     con=DriverManager.getConnection("jdbc:odbc:caddsn","","");
     st=con.createStatement();
     rs=st.executeQuery("select * from ques");
     int cnt=0;

     while(rs.next())
      {
       question[cnt].qn=rs.getInt(1);
       question[cnt].q=rs.getString(2);
      question[cnt].o1=rs.getString(3);
      question[cnt].o2=rs.getString(4);
      question[cnt].o3=rs.getString(5);
      question[cnt].o4=rs.getString(6);
      question[cnt].ans=rs.getString(7);
      cnt++;
      }
      total_question=cnt;
      JOptionPane.showMessageDialog(null,"we have fteched "+cnt+" questions ");
      rs.close();
      con.close();
      st.close();
     }
     catch(SQLException e)
     {
     }



  }
  void play_game()
  {

   pn1.add(prev);
   prev.setBounds(330,380,80,30);

   pn1.add(next);
   next.setBounds(430,380,80,30);

   pn1.add(lock);
 lock.setBounds(530,380,80,30);
 current=0;
 area =new TextArea();
 pn1.add(area);
 area.setBounds(100,100,400,170);
 show_question(current);
}
void  show_question(int a)
 {


 String abc=question[a].qn+"."+question[a].q;
 area.setText(abc);
 if(status[a]==false)
 but[a].setBackground(Color.red);
  area.setEditable(false);
  if(cg==null)
  cg=new CheckboxGroup();
  if(cb1==null)
  {
  cb1=new Checkbox(question[a].o1,cg,false);
  pn1.add(cb1);
  cb1.setBounds(60,300,200,40);
  cb1.setFont(new Font("Arial",Font.BOLD,15));
  cb1.setForeground(Color.white);
  }else

  cb1.setLabel(question[a].o1);
  if(cb2==null)
  {
  cb2=new Checkbox(question[a].o2,cg,false);
  pn1.add(cb2);
  cb2.setBounds(320,300,200,40);
  cb2.setFont(new Font("Arial",Font.BOLD,15));
  cb2.setForeground(Color.white);
  }else
  cb2.setLabel(question[a].o2);

  if(cb3==null)
  {
  cb3=new Checkbox(question[a].o3,cg,false);
  pn1.add(cb3);
  cb3.setBounds(540,300,200,40);  cb3.setForeground(Color.white);

  cb3.setFont(new Font("Arial",Font.BOLD,15));
  }
  else
  cb3.setLabel(question[a].o3);
  if(cb4==null)
  {
  cb4=new Checkbox(question[a].o4,cg,false);
  pn1.add(cb4);
 cb4.setBounds(750,300,200,40);
 cb4.setFont(new Font("Arial",Font.BOLD,15));
 cb4.setForeground(Color.white);
 }else
 cb4.setLabel(question[a].o4);






 }
 public void itemStateChanged(ItemEvent e)
 {
 }
 void evaluate()
  {
    if(status[current]==true)
     {
      JOptionPane.showMessageDialog(null," sorry you have already locked your answer for this question");
      }
      else
      {
      status[current]=true;
      but[current].setBackground(Color.green);
      if(cb1.getState())
     {
       if((question[current].ans).equalsIgnoreCase("a"))
         score+=3;
         else
         score-=1;
      }
      else if(cb2.getState())
        {
          if((question[current].ans).equalsIgnoreCase("b"))
         score+=3;
         else
         score-=1;
         }else if(cb3.getState())
         {
        if((question[current].ans).equalsIgnoreCase("c"))
         score+=3;
         else
         score-=1;
         }
          else if(cb4.getState())
          {
            if((question[current].ans).equalsIgnoreCase("d"))
         score+=3;
         else
         score-=1;
        }


    }

   }

}//end of class work

   class totalchaos6
    {
     public static void main(String ar[])throws Exception
      {
       new design();//replace it with latest class
       }
     }