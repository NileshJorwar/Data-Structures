import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class User {
	private int age;
	private String name;

	public User(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + "]";
	}

}

public class Java8 {
	public static void print(final int number) {
		System.out.println("I am printing: " + number);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<>();
		users.add(new User(12, "Sachin"));
		users.add(new User(14, "asn"));
		users.add(new User(11, "ssda"));
		users.add(new User(55, "Sssss"));

		/*
		 * Collections.sort(users,new Comparator<User>() { public int compare(User
		 * u1,User u2) { return u1.getAge()-u2.getAge(); } });
		 */

		users.sort((u1, u2) -> u1.getAge() - u2.getAge());
		System.out.println(users);

		Function<Integer, Double> cal = cel -> new Double((cel * 222) / 32);
		System.out.println(cal.apply(15));

		Predicate<User> t = u -> u.getAge() < 12;
		System.out.println(t.test(new User(11, "Saaa")));

		// Method or constructor reference

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// normal
		for (int number : list) {
			Java8.print(number);
		}

		// Lambda expression
		list.forEach(number -> Java8.print(number));
		
		list.forEach(Java8::print);
		
	}

}
