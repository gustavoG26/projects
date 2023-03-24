# Project 3.2 FNCD Simulation

## Project Members: 
Zach Remer, Gustavo Guijarro, Ramy Kassam

## Java Version: 
Using Java 8, IDE: IntelliJ IDEA

## More comments/assumptions
Our initial UML diagram covered the most important aspects what was given in the writeup, as we started to code our project, we realized that we needed to implement much more functions and classes. We also discovered that certain functions had to be run in different classes than we had originally though such as the race function. We also were using Bruce Montgomery code that he had made for project 2.2 and added the functions that were needed for this project. This includes the new flow state diagram and updated UML diagram from project 2.2.

In Project 4.2 when making two FNCD run in parallel I instead broke up two functions in the FNCD class being specialDay and normalDay to smaller functions. This allowed me in the simulator class to call each function separately and approach this problem in a single threaded way. We also included 3 more types of cars being Super Cars, RVs, and Off Road Cars. This is repersented in the new UML diagram we made.

We also changed how the staff and vehicles were created. We changed them using factory patterns. Furthermore we added 15 JUnit test assertions and as well as singleton patterns for tracker and logger objects
