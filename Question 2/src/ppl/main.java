package ppl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main
{
	public static void main(String[] args) throws IOException
	{
		ArrayList<boy> Boy = new ArrayList<boy>();
		ArrayList<girl> Girl = new ArrayList<girl>();
		ArrayList<gift> Gift = new ArrayList<gift>();
		ArrayList<couple> Couple = new ArrayList<couple>();
		files_generator(Boy, Girl, Gift, 10000, 10000, 10000);
		find_couple(Boy, Girl, Couple);
		gift_distribution(Couple, Gift);
		Girl_happiness(Couple);
		Boy_happiness(Couple);
		Compatibility(Couple);

		int k=250;
		
		Sort_happy(Couple, k);
		Sort_Compt(Couple, k);

	}
	public static void gift_distribution(ArrayList<couple> Couple, ArrayList<gift> Gift) throws IOException  
	{
		File fi = new File("gift_exchange.txt");
		FileWriter file = new FileWriter(fi);
		file.write( "------------------------------------Gift Distribution-------------------------------------------" + "\n");
		for (int i = 0;i < Couple.size();i++)
		{
			boolean lux = false;
			int luxury_valueue = 0;
			int cost = 0;
			int value = 0;
			file.write(Couple.get(i).boyfriend_type + " " + Couple.get(i).boyfriend_name + "(boy) has given ");
			if (Couple.get(i).boyfriend_type.equals("The Miser"))
			{


				for (int j = 0;j < Gift.size();j++)
				{

					if (cost + Gift.get(j).price <= Couple.get(i).maintenance_budget)
					{
						value += Gift.get(j).value;
						cost += Gift.get(j).price;
						Couple.get(i).gift.add(Gift.get(j));
						file.write(Gift.get(j).type_of_gift + "(" + Gift.get(j).price + ") ,");
					}
				}

			}
			else if (Couple.get(i).boyfriend_type.equals("The Generous"))
			{

				for (int j = 0;j < Gift.size();j++)
				{

					if (cost + Gift.get(j).price <= Couple.get(i).boyfriend_budget)
					{
						value += Gift.get(j).value;
						cost += Gift.get(j).price;
						Couple.get(i).gift.add(Gift.get(j));
						file.write(Gift.get(j).type_of_gift + "(" + Gift.get(j).price + ") ,");
					}
				}

			}

			else
			{
				for (int j = 0;j < Gift.size();j++)
				{

					if (cost + Gift.get(j).price <= Couple.get(i).boyfriend_budget)
					{


						if (Gift.get(j).type_of_gift.equals("Luxury gift") && lux == true)
						{
							continue;
						}

						if (Gift.get(j).type_of_gift.equals("Luxury gift"))
						{
							lux = true;
						}
						luxury_valueue += Gift.get(j).value;

						cost += Gift.get(j).price;
						Couple.get(i).gift.add(Gift.get(j));
						file.write(Gift.get(j).type_of_gift + "(" + Gift.get(j).price + ") ,");

					}
				}
			}
			Couple.get(i).total_price = cost;
			Couple.get(i).total_value = value;
			file.write( " gift to " + Couple.get(i).girlfriend_name + "(girl) worth " + Couple.get(i).total_price + "\n");
			file.write( "\n");

		}

		file.close();

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

	public static void gift_generator(ArrayList<gift> Gift,int no_of_gifts) throws IOException
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
			Gift.add(Newgift);
		}
		file.close();
	}
	
	public static void files_generator(ArrayList<boy> Boy, ArrayList<girl> Girl, ArrayList<gift> Gift, int no_of_boys, int no_of_girls, int no_of_gifts)
	{
            try {
                boy_generator(Boy, no_of_boys);
                girl_generator(Girl, no_of_girls);
                gift_generator(Gift,no_of_gifts);
            } catch (IOException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
	}


	public static void find_couple(ArrayList<boy> Boy, ArrayList<girl> Girl,ArrayList<couple> Couple)
	{
            FileWriter file =  null;
            try {
                File log =  new File("log.txt");
                file = new FileWriter(log);
                ArrayList<gift> v = new ArrayList<gift>();
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
		                        //cout+"boy " + Boy[j].attractiveness + " " +Boy[j].intelligence +" " +Boy[j].budget + endl;
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
						couple Newcp = new couple(0, 0, Boy.get(index).name, Girl.get(i).name, Girl.get(i).maintenance_budget, Boy.get(index).budget, new ArrayList(v), Boy.get(index).type_of_committed_boy, Girl.get(i).type_of_committed_girl, 0, Girl.get(i).intelligence, 0, 0, Boy.get(index).intelligence, Boy.get(index).attractiveness, Girl.get(i).attractiveness);
						Couple.add(Newcp);
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


	public static void Boy_happiness(ArrayList<couple> Couple)
	{

		for (int i = 0;i < Couple.size();i++)
		{
			if (Couple.get(i).boyfriend_type.equals("The Miser"))
			{
				Couple.get(i).happiness_of_couple += (Couple.get(i).boyfriend_budget - Couple.get(i).total_price);
			}

			if (Couple.get(i).boyfriend_type.equals("The Generous"))
			{
				Couple.get(i).happiness_of_couple += Couple.get(i).happiness_of_couple;
			}

			else
			{
				Couple.get(i).happiness_of_couple += Couple.get(i).girlfriend_intelligence;
			}
		}
	}

	public static void Girl_happiness(ArrayList<couple> Couple)
	{

		for (int i = 0;i < Couple.size();i++)
		{
			if (Couple.get(i).girlfriend_type.equals("The choosy"))
			{
				Couple.get(i).happiness_of_couple += (int)Math.log(Math.abs(Couple.get(i).total_price - Couple.get(i).maintenance_budget + Couple.get(i).luxury_value * 2));
			}

			else if (Couple.get(i).girlfriend_type.equals("The normal"))
			{
				Couple.get(i).happiness_of_couple += Couple.get(i).total_price - Couple.get(i).maintenance_budget + Couple.get(i).total_value + Couple.get(i).luxury_value;
			}
			else
			{
				Couple.get(i).happiness_of_couple += (int)Math.exp(Math.abs(Couple.get(i).total_price - Couple.get(i).maintenance_budget));
			}
		}

	}

	public static void Compatibility(ArrayList<couple> Couple)
	{

		for (int i = 0;i < Couple.size();i++)
		{
			Couple.get(i).compatibility_of_couple = Math.abs(Couple.get(i).maintenance_budget - Couple.get(i).boyfriend_budget) + Math.abs(Couple.get(i).boyfriend_intelligence - Couple.get(i).girlfriend_intelligence) + Math.abs(Couple.get(i).boyfriend_attractiveness - Couple.get(i).girlfriend_attractiveness);

		}
	}
	
	public static int getItself(int itself, int dummy)
	{
	    return itself;
	}
	
	public static String getItself(String itself, String dummy)
	{
	    return itself;
	}
	
	public static void Sort_happy(ArrayList<couple> Couple, int k) throws IOException
	{
		File fi = new File("k_most_happiest_couples.txt");
		FileWriter file = new FileWriter(fi);
		int i;
		file.write( " **************************" + k + " most happiest couple ***********************************"
				+ "" + "\n");
		file.write( "\n");
		for (i = 0;i < Couple.size();i++)
		{
			for (int j = 0;j < Couple.size();j++)
			{

				if (Couple.get(i).happiness_of_couple > Couple.get(j).happiness_of_couple)
				{
					Couple.get(i).compatibility_of_couple = getItself(Couple.get(j).compatibility_of_couple,Couple.get(j).compatibility_of_couple=Couple.get(i).compatibility_of_couple);
					Couple.get(i).happiness_of_couple = getItself(Couple.get(j).happiness_of_couple,Couple.get(j).happiness_of_couple=Couple.get(i).happiness_of_couple);
					Couple.get(i).girlfriend_name = getItself(Couple.get(j).girlfriend_name,Couple.get(j).girlfriend_name=Couple.get(i).girlfriend_name);
					Couple.get(i).boyfriend_name = getItself(Couple.get(j).boyfriend_name,Couple.get(j).boyfriend_name=Couple.get(i).boyfriend_name);
				}
			}
		}

		for (i = 1;i <= k;i++)
		{
			if (Couple.get(i).happiness_of_couple < 0)
			{
				i--;
				break;
			}

			file.write( Couple.get(i).boyfriend_name + "(boy) " + Couple.get(i).girlfriend_name + "(girl) " + Couple.get(i).happiness_of_couple + "\n");
		}
		file.close();
	}

	public static void Sort_Compt(ArrayList<couple> Couple, int k) throws IOException
	{

		int i;
		File fi = new File("k_most_compatible_couples.txt");
		FileWriter file = new FileWriter(fi);

		file.write( " ******************************************" + k + " most compatible couple********************************" + "\n");
		file.write( "\n");
		
		//System.out.println("********************************\n");
		for (i = 0;i < Couple.size();i++)
		{
			for (int j = 0;j < Couple.size();j++)
			{

				if (Couple.get(i).compatibility_of_couple > Couple.get(j).compatibility_of_couple)
				{
					Couple.get(i).compatibility_of_couple = getItself(Couple.get(j).compatibility_of_couple,Couple.get(j).compatibility_of_couple=Couple.get(i).compatibility_of_couple);
					Couple.get(i).happiness_of_couple = getItself(Couple.get(j).happiness_of_couple,Couple.get(j).happiness_of_couple=Couple.get(i).happiness_of_couple);
					Couple.get(i).girlfriend_name = getItself(Couple.get(j).girlfriend_name,Couple.get(j).girlfriend_name=Couple.get(i).girlfriend_name);
					Couple.get(i).boyfriend_name = getItself(Couple.get(j).boyfriend_name,Couple.get(j).boyfriend_name=Couple.get(i).boyfriend_name);

				}
			}
		}

		for (i = 0;i < k;i++)
		{
			//System.out.println(Couple.get(i).compatibility_of_couple + " " + Couple.get(i).boyfriend_name + "\n");
			file.write( Couple.get(i).boyfriend_name + "(boy) " + Couple.get(i).girlfriend_name + "(girl) " + Couple.get(i).compatibility_of_couple + "\n");
		}
		file.close();
	}
	
}