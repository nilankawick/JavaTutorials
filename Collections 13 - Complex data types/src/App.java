import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class App {

	public static String[] vehicles = { "ambulance", "helicopter", "lifeboat" };

	public static String[][] drivers = { { "Fred", "Sue", "Pete" }, { "Sue", "Richard", "Bob", "Fred" },
			{ "Pete", "Mary", "Bob" }, };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * We will be trying to have a MAP of which we can specify the VEHICLE
		 * type and get the list of DRIVERs who can drive the same VEHICLE type
		 * 
		 * to do so we can use a MAP --> HashMap to be precise, since we are not
		 * looking at any soughting
		 * 
		 * to achieve this MAP the following steps are followed step 1. create a
		 * MAP collection (KEY--> vehicles type, DETAILS -->to be defined by a
		 * SET of drivers step 2. we will iterate through the vehicles array,
		 * and for each element put vehicle name as the KEY step 3. and then
		 * also using the same index go through the drivers name and create a
		 * SET of drivers for each vehicle type
		 * 
		 */
		// Step 1
		Map<String, Set<String>> personnel = new HashMap<String, Set<String>>();

		// Step 2 + 3
		for (int i = 0; i < vehicles.length; i++) {
			String vehicle = vehicles[i];
			// System.out.println(vehicle);

			String[] driversList = drivers[i];
			// System.out.println(driversList);

			/*
			 * We are using a linkedHashSet because a. we only want to have
			 * unique items b. and the order should be of the order in which
			 * items are put in
			 */
			Set<String> driverSet = new LinkedHashSet<String>();

			for (String driver : driversList) {
				driverSet.add(driver);
				// System.out.println(driver);
			}

			personnel.put(vehicle, driverSet);
		}

		System.out.println("Getting a single list of drivers for a specific vehicle type");
		{ // Brackets just to scope driversList variable so can use again later
			// Example usage
			Set<String> driversList = personnel.get("helicopter");

			for (String driver : driversList) {
				System.out.println(driver);
			}
		}

		System.out.println("");
		{
			System.out.println("Printing the whole map");
			// Iterate through the whole thing
			for (String vehicle : personnel.keySet()) {
				System.out.print(vehicle);
				System.out.print(" - ");
				Set<String> driversList = personnel.get(vehicle);

				for (String driver : driversList) {
					System.out.print(driver);
					System.out.print(", ");
				}
				System.out.println("");
			}
		}

	}

}
