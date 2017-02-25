package ppl;
public class gift
{
		public gift(int price, int value, String type_of_gift, int luxury_rating, int difficulty_to_obtain_gift, int utility_value, String utility_class)
		{
			this.price = price;
			this.value = value;
			this.type_of_gift = type_of_gift;
			this.luxury_rating = luxury_rating;
			this.difficulty_to_obtain_gift = difficulty_to_obtain_gift;
			this.utility_value = utility_value;
			this.utility_class = utility_class;

		}

		private int price;
		private int value;
		private String type_of_gift;
		private int luxury_rating;
		private int difficulty_to_obtain_gift;
		private int utility_value;
		private String utility_class;

}
