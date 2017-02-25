package ppl;
public class boy
{

	public String name;
	public int attractiveness;
	public int intelligence;
	public int budget;
	public int minimum_attraction_requirement;
	public boolean Iscommitted;
	public String type_of_committed_boy;
	public String girlfriend_name;



		public boy(String name,int intelligence,int budget,int attractiveness,int minimum_attraction_requirement,boolean Iscommitted,String type_of_committed_boy,String girlfriend_name)
		{


			this.name = name;
			this.intelligence = intelligence;
			this.budget = budget;
		this.attractiveness = attractiveness;
			this.minimum_attraction_requirement = minimum_attraction_requirement;
			this.Iscommitted = Iscommitted;
			this.type_of_committed_boy = type_of_committed_boy;
			this.girlfriend_name = girlfriend_name;
		}

    
    public final boolean check_dating_req(boy b,girl g)
		{
                    if(b.budget >= g.maintenance_budget  && b.minimum_attraction_requirement <= g.attractiveness )
                        return true;
                    else
                        return false;

			//return (b.budget >= g.maintenance_budget != 0 && b.minimum_attraction_requirement <= g.attractiveness != 0 ? true : false);

		}




}