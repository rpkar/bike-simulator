# **Bike Simulator**

A simple bike simulator which moves in a 7x7 grid based on the console commands.

**Description**

The bike is free to move around the grid but must be prevented from exiting the grid.
Any movement that would cause the bike to leave the grid must be prevented,
however further valid movement must still be allowed.
The following commands must be supported by the application:

1. PLACE \<X>,\<Y>,<Facing-direction>
2. FORWARD
3. TURN_LEFT
4. TURN_RIGHT
5. GPS_REPORT

**Running the application**

System requirement: Java 8 or above installed on your system

Navigate to out/artifacts/bike_simulator/ directory.

Run the following command to play with the application: 
_java -jar bike-simulator.jar_