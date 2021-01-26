import javax.swing.*;	
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.lang.Exception;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.lang.Math;

class accguesser{
	static int arr[]=new int[10000];
	
	public static void main(String arg[])
	{
		while(true)
		{
		try{
		JFrame frame=new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setBounds(200,200,500,450);
		
		frame.setTitle("Accurate Guesser");
		
		Container c=frame.getContentPane();
		JLabel label=new JLabel( "<html><p>Hello guys! Welcome to Accurate Guesser. It is a multiplayer (for 3 or more players) game that you can play with your friends and family. So, after entering all of the names of the participants one by one, in the same order write your secret word. No one will be able to see your word and you won't be able to see anyone's, so don't worry. Only you will know your secret word. Once, all of the participants have written their secret word, then all the secret words will be listed below and the players have to guess who has written that word. We hope you have fun playing this game.</p></html>");
		frame.getContentPane().add(label);		
		
		JButton btn=new JButton("Next");
		btn.setBounds(20,290,80,50);
		
		btn.setBackground(Color.BLUE);
		btn.setForeground(Color.WHITE);
		
		frame.getContentPane().setBackground(Color.PINK);
		
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg)
			{
				JFrame second=new JFrame();
				second.setVisible(true);
				second.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				second.setBounds(200,200,500,450);
				Container cc=second.getContentPane();
				Container gg=second.getContentPane();
				
				JLabel lab=new JLabel("Total Players: ");
				JTextField play=new JTextField();
				
				JButton btn2=new JButton("GO");
				btn2.setBounds(120,231,100,50);
				second.getContentPane().add(btn2);
				btn2.setBackground(Color.BLUE);
				btn2.setForeground(Color.WHITE);
				
				btn2.addActionListener(new ActionListener(){
				
					public void actionPerformed(ActionEvent e)
					{
						String tot=play.getText();
						if(tot.charAt(0)>='a' || tot.charAt(0)<='z')
						{
							JFrame fin=new JFrame();
							fin.setVisible(true);
							fin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							fin.setBounds(200,200,500,450);
							JLabel pll=new JLabel("  Enter as per instructions.");
							pll.setBounds(20,130,100,50);
							pll.setForeground(Color.WHITE);
							fin.getContentPane().add(pll);
							fin.getContentPane().setBackground(Color.BLUE);
							fin.setResizable(false);			
						}
						int totplayers=Integer.parseInt(tot);	
						JFrame third=new JFrame();
						third.setVisible(true);
						third.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						third.setBounds(200,200,500,450);
						third.setResizable(false);
	
						Vector<String> names=new Vector<String>();
						Vector<String> words= new Vector<String>();	
						Vector<String> shuffled_words = new Vector<String>();
						Vector<String> duplicate= new Vector<String>();
						Vector<String> sf=new Vector<String>();
						for(int i=0; i<totplayers; i++)
						{
							String nm;
							nm=JOptionPane.showInputDialog("Enter Name of Player "+ (i+1));
							names.addElement(nm);
						}
						for(int i=0; i<totplayers; i++)
						{
							String nm;
							nm=JOptionPane.showInputDialog(names.get(i)+" enter your secret word ");
							sf.addElement(nm);
						}
						generateRandom(names.size());
						for(int i=0; i<names.size(); i++)
						{
							shuffled_words.addElement(sf.get(arr[i]));
						}
						String winner;
						Vector<String> vec=new Vector<String>();
						int l=0,ct=0,flag=1;
						
						while(true)
						{
							ct=0;		
							duplicate=shuffled_words;

							third.getContentPane().setBackground(Color.PINK);
							for(int i=0; i<duplicate.size(); i++)
							{
								int second=-1;
								String wd=shuffled_words.get(i);
								for(int j=0; j<sf.size(); j++)
								{
									if((sf.get(j)).equals(wd))
									{
										second=j;
										break;
									}
								}
								if(second==l)
								{
									ct++;
									continue;
								}
								JButton labb=new JButton(shuffled_words.get(i));
								
								third.getContentPane().add(labb);
								labb.setBounds(20,130,100,50);
								labb.setBackground(Color.BLACK);
								labb.setForeground(Color.WHITE);
								String nm;
								
				    nm=JOptionPane.showInputDialog(names.get(l)+"'s time to guess the name of person who wrote "+shuffled_words.get(i));
								sf.addElement(nm);
								int first=names.indexOf(nm);
											
								if(first!=second)
								{
									flag=0;
									break;
								}
								else
									ct++;
							}
							if(ct==names.size())
								flag=1;
							if(flag==1)
							{	
								winner=names.get(l);
								break;
							}
							l++;
							if(l>=names.size())
								l=0;									
						}
						JFrame fin=new JFrame();
						fin.setVisible(true);
						fin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						fin.setBounds(200,200,500,450);
						JLabel pll=new JLabel("    Mr/Ms Accurate Guesser is  ------>>   "+ winner +"   <<------  Congratulations");
						pll.setBounds(20,130,100,50);
						pll.setForeground(Color.WHITE);
						fin.getContentPane().add(pll);
						fin.getContentPane().setBackground(Color.BLUE);
						fin.setResizable(false);
					}				
				});				
				play.setBounds(120,180,100,50);
				gg.add(play);			
				second.getContentPane().setBackground(Color.PINK);
				cc.add(lab);
				lab.setBounds(20,20,100,50);		
				second.setResizable(false);	
			}	
		});
		c.add(btn);
		frame.setResizable(false);
		break;
		}
		catch(Exception e)
		{
			JFrame fin=new JFrame();
			fin.setVisible(true);
			fin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fin.setBounds(200,200,500,450);
			JLabel pll=new JLabel("  Enter as per instructions.");
			pll.setBounds(20,130,100,50);
			pll.setForeground(Color.WHITE);
			fin.getContentPane().add(pll);
			fin.getContentPane().setBackground(Color.BLUE);
			fin.setResizable(false);
		}
		}
	}	
	static int getNum(ArrayList<Integer> v)  
    {  
        int n = v.size();  
        int index = (int)(Math.random() * n);  
        int num = v.get(index);   
        v.set(index, v.get(n - 1)); 
        v.remove(n - 1);  
        return num;  
    }   
    static void generateRandom(int n)  
    {  
        ArrayList<Integer> v = new ArrayList<>(n);  
        
        for (int i = 0; i < n; i++)  
            v.add(i + 1);   
           int j=0;
        while (v.size() > 0)  
        {  
            arr[j++]=getNum(v)-1;
        }  
    }  
}
