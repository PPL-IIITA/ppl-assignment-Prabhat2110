package ppl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main
{       public static void main(String[] args)
	{

		ArrayList<boy> Boy = new ArrayList<boy>();
		ArrayList<girl> Girl = new ArrayList<girl>();
		files_generator(Boy, Girl, 10000, 10000, 10000);
		find_couple(Boy, Girl);
           

	}
	public static void boy_generator(ArrayList<boy> Boy, int no_of_boys) throws FileNotFoundException, IOException
	{

		int i;
		int j;
		int attractiveness;
		int intelligence;
		int budget;
		int minimum_attraction_requirement;
                 Random rand;
      
       rand = new Random();
                File boyrecord =  new File("boy_record.txt");
                FileWriter file = new FileWriter(boyrecord);
		String type_of_committed_boy = new String(new char[15]);
		String[] type = {" Miser"," Generous"," Geeks"};
                    for (j = 0;j < no_of_boys;j++)
		{

                        file.write("boy" + (j+1) + " :\n");
			String name = new String(new char[11]);
			String str = "abcdefghiklmnopqrtuvwxyz";
			StringBuilder sb = new StringBuilder();
                        for(i=0;i<10;i++){
                            sb.append(str.charAt(rand.nextInt(24)));
                        }
                         name = sb.toString();


			attractiveness = rand.nextInt(10000) % 10 + 1;
			intelligence =rand.nextInt(10000) % 10 + 1;
			budget = rand.nextInt(10000) % 10000 + 1;
			minimum_attraction_requirement = rand.nextInt(10000) % 10 + 1;

			type_of_committed_boy = type[rand.nextInt(10000) % 3];
                         file.write("name :- " + name +"\n");
		
                        file.write("attractiveness :- " + attractiveness + "\n");
                        file.write("intelligence :-" + intelligence + "\n");
                        file.write("budget :- " + budget + "\n");
                        file.write("min_attraction :- " + minimum_attraction_requirement + "\n");
                        file.write("type_of_committed_boy :- " + type_of_committed_boy + "\n");
			
                        file.write("\n-------------------------------------------------------------\n");
                      
			boy Newboy = new boy(name, intelligence, budget, attractiveness, minimum_attraction_requirement, false, type_of_committed_boy, "");

			Boy.add(Newboy);
		}
		file.close();
	}

	public static void girl_generator(ArrayList<girl> Girl, int no_of_girls) throws IOException
	{

		int i;
		int j;
		int attractiveness;
                 Random rand;
      
       rand = new Random();
		int intelligence;
		int maintenance_budget;
                File girlrecord =  new File("girl_record.txt");
                FileWriter file = new FileWriter(girlrecord);
		String type_of_committed_girl = new String(new char[15]);
		String[] type = {" choosy"," normal"," desperate"};
		String criteria_for_selecting_boys = new String(new char[20]);
		String[] criteria = {"Most attractive","Most intelligent","Most rich"};
		for (j = 0;j < no_of_girls;j++)
		{
                        file.write("girl" + (j+1) + " :" + "\n");
			String name = new String(new char[11]);
			String str = "abcdefghijlmnopqrstuvwyz";
			StringBuilder sb = new StringBuilder();
                        for(i=0;i<10;i++){
                            sb.append(str.charAt(rand.nextInt(24)));
                        }
                         name = sb.toString();
                        
			attractiveness = rand.nextInt(1000) % 10 + 1;
			intelligence = rand.nextInt(1000) % 10 + 1;
			maintenance_budget = rand.nextInt(1000000) % 10000 + 1;
			criteria_for_selecting_boys = criteria[rand.nextInt(1000) % 3];

			type_of_committed_girl = type[rand.nextInt(1000) % 3];
                        file.write("name :-" + name + "\n");
			
                          file.write("attractiveness :- " + attractiveness + "\n");
                          file.write("intelligence :- " + intelligence + "\n");
                          file.write("maintainence_budget :- " + maintenance_budget + "\n");
                          file.write("criteria_for_selecting_boys :- " + criteria_for_selecting_boys  + "\n");
                          file.write("type_of_committed_girl :- " + type_of_committed_girl + "\n");
                          file.write("\n-------------------------------------------------------------\n");   

			girl Newgirl = new girl(name, attractiveness, maintenance_budget, intelligence, criteria_for_selecting_boys, false, type_of_committed_girl, "");

			Girl.add(Newgirl);

		}
		file.close();
	}

	public static void gift_generator(int no_of_gifts) throws IOException
	{
                 Random rand;
      
                rand = new Random();
		int price;
		int value;
		int i;
		int luxury_rating = 0;
		int difficulty = 0;
		int util_val = 0;
                File giftrecord =  new File("gift_record.txt");
                FileWriter file = new FileWriter(giftrecord);
		String type = new String(new char[15]);
		String[] type_of_gifts = {"Essential gift","Luxury gift","Utility gift"};
		String Class = "ABC";
		char util_class = 0;
		for (i = 1;i <= no_of_gifts;i++)
		{
			type = type_of_gifts[rand.nextInt(1000) % 3];
			price = rand.nextInt(1000)  % 100 + 1;
			value = rand.nextInt(1000)  % 10 + 1;
			
                        file.write("gifts :- "+i+"\n");
                        file.write("type :- " + type + "\n");
			
                         file.write("price :- " + price + "\n");
			
                         file.write("value :- " + value + "\n");
			if (type.charAt(0) == 'L')
			{
				luxury_rating =rand.nextInt(1000) % 10 + 1;
				difficulty = rand.nextInt(1000)  % 10 + 1;
                                 file.write("luxury_rating :- " + luxury_rating + "\n");
		
                                 file.write("difficult_to_obtain_the_gift :- " + difficulty + "\n");
			}
			else if (type.charAt(0) == 'U')
			{
				util_val = rand.nextInt(1000)  % 10 + 1;
				util_class =  Class.charAt(rand.nextInt(1000)  % 3);
			
                                 file.write("files_generator value :- " + util_val + "\n");
			
                                  file.write("files_generator class :- " + util_class + "\n");
			}

			file.write("\n");
			gift Newgift = new gift(price, value, type, luxury_rating, difficulty, util_val, util_class);

		}
		file.close();
	}

	public static void files_generator(ArrayList<boy> Boy, ArrayList<girl> Girl, int no_of_boys, int no_of_girls, int no_of_gifts)
	{
            try {
                boy_generator(Boy, no_of_boys);
                girl_generator(Girl, no_of_girls);
                gift_generator(no_of_gifts);
            } catch (IOException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

	public static void find_couple(ArrayList<boy> Boy, ArrayList<girl> Girl)
	{
            FileWriter file =  null;
            try {
                File log =  new File("log.txt");
                file = new FileWriter(log);
                int i;
                int j;
                int type;
                int index;
                int Max;
                int count = 0;
                for (i = 0;i < Girl.size();i++)
                {
                    
                    if (Girl.get(i).Iscommitted)
                    {
                        continue;
                    }
                    Max = 0;
                    index = -1;
                    type = -1;
                    
                    if (Girl.get(i).criteria_for_selecting_boys.equals("Most attractive"))
                    {
                        type = 0;
                    }
                    
                    else if (Girl.get(i).criteria_for_selecting_boys.equals("Most intelligent"))
                    {
                        type = 1;
                    }
                    else
                    {
                        type = 3;
                    }
                    
                    
                    for (j = 0;j < Boy.size();j++)
                    {
                        if (!Boy.get(j).Iscommitted)
                        {
                            
                            
                            if (Boy.get(j).check_dating_req(Boy.get(j), Girl.get(i)))
                            {
                                //cout<<"boy " << Boy[j].attractiveness << " " <<Boy[j].intelligence <<" " <<Boy[j].budget << endl;
                                if (type == 0)
                                {
                                    if (Boy.get(j).attractiveness > Max)
                                    {
                                        Max = Boy.get(j).attractiveness;
                                        index = j;
                                    }
                                }
                                
                                if (type == 1)
                                {
                                    if (Boy.get(j).intelligence > Max)
                                    {
                                        Max = Boy.get(j).intelligence;
                                        index = j;
                                    }
                                }
                                
                                if (type == 3)
                                {
                                    if (Boy.get(j).budget > Max)
                                    {
                                        Max = Boy.get(j).budget;
                                        index = j;
                                    }
                                }
                            }
                            
                            
                        }
                        
                    }
                    if (index == -1)
                    {       file.write(Girl.get(i).name + "'s requirements are too high. She will continue looking for a match." + "\n");
                  
                    }
                    else
                    {
                        Girl.get(i).Iscommitted = true;
                        Boy.get(index).Iscommitted = true;
                        Boy.get(index).girlfriend_name = Girl.get(i).name;
                        Girl.get(i).boyfriend_name = Boy.get(index).name;
                        count++;
                        file.write("timestamp :- " + count + "  " + Boy.get(index).name + "(boy) commited with " + Girl.get(i).name + "(girl)" + "\n");
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    file.close();
                } catch (IOException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
	}

	

}