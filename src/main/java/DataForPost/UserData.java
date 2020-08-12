package DataForPost;

import org.testng.annotations.DataProvider;

public class UserData {
	
	
	@DataProvider(name = "DataForPost")
	public static Object[] [] postData(){
		Object[] [] data = new Object[2] [4];
		data[0] [0] = 5;
		data[0] [1] = "Marry";
		data[0] [2] = "AIA";
		data[0] [3] = 1;
		
		data[1] [0] = 6;
		data[1] [1] = "Stephe";
		data[1] [2] = "BD";
		data[1] [3] = 2;
		return data;
	}

	@DataProvider(name = "simpleData")
	public Object[] [] simpleDataFormat(){
		
		return new Object[] [] {
			{7, "Holy", "AIA", 1},
			{8, "Diya", "BD", 2},
			{8, "Diya", "BD", 2}
		};
	}
	
}
