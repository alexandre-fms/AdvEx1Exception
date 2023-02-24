import java.util.Arrays;
import java.util.List;

public class TestStream {

	public static void main(String[] args) {
		List<String> airbus = Arrays.asList("A320-", "A350-", "A400m-", "a380-", "B330-");
		
		airbus.stream().sorted();
		airbus.forEach(System.out::print);
		System.out.println();
		
		airbus.stream()
		.filter(s -> s.toUpperCase().startsWith("A"))
		.map(String::toUpperCase)
		.sorted()
		.forEach(System.out::print);
		System.out.println();
		
		airbus.forEach(System.out::print);

	}

}
