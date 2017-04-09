package ppl;

import java.util.*;

public class couple extends boy
{

		 public int happiness_of_couple;
		public int compatibility_of_couple;
		public String boyfriend_name;
		public String girlfriend_name;
		public int maintenance_budget;
		public int boyfriend_budget;
		public ArrayList<gift> gift = new ArrayList<gift>();
		public String boyfriend_type;
		public String girlfriend_type;
		public int total_price;
		public int girlfriend_intelligence;
		public int total_value;
		public int luxury_value;
		public int boyfriend_intelligence;
		public int boyfriend_attractiveness;
		public int girlfriend_attractiveness;


		public couple(int happiness_of_couple,int compatibility_of_couple,String boyfriend_name,String girlfriend_name,int maintenance_budget,int boyfriend_budget,ArrayList<gift> gift,String boyfriend_type,String girlfriend_type,int total_price,int girlfriend_intelligence,int total_value,int luxury_value,int boyfriend_intelligence,int boyfriend_attractiveness,int girlfriend_attractiveness)
		{
			this.boyfriend_name = boyfriend_name;
			this.girlfriend_name = girlfriend_name;
			this.maintenance_budget = maintenance_budget;
			this.boyfriend_budget = boyfriend_budget;
			this.happiness_of_couple = happiness_of_couple;
			this.compatibility_of_couple = compatibility_of_couple;
			this.gift = new ArrayList<gift>(gift);
			this.boyfriend_type = boyfriend_type;
			this.girlfriend_type = girlfriend_type;
			this.total_price = total_price;
			this.girlfriend_intelligence = girlfriend_intelligence;
			this.total_value = total_value;
			this.luxury_value = luxury_value;
			this.boyfriend_intelligence = boyfriend_intelligence;
			this.boyfriend_attractiveness = boyfriend_attractiveness;
			this.girlfriend_attractiveness = girlfriend_attractiveness;
		}

}