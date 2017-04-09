package ppl;
public class gift
{
		public gift(){
		}
		public gift(int price, int value, String type_of_gift, int luxury_rating, int difficulty_to_obtain_gift, int utility_value, char utility_class)
		{
			this.price = price;
			this.value = value;
			this.type_of_gift = type_of_gift;
			this.luxury_rating = luxury_rating;
			this.difficulty_to_obtain_gift = difficulty_to_obtain_gift;
			this.utility_value = utility_value;
			this.utility_class = utility_class;

		}
		String name;
		int attractiveness;
		int intelligence;
		boolean Iscommitted;
		int price;
		int value;
		String type_of_gift;
		int luxury_rating;
		int difficulty_to_obtain_gift;
		int utility_value;
		char utility_class;

}
