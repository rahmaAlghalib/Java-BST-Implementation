# Java Binary Search Tree implementation
>Uber System is a simulation software to simulate a variety of Uber oriented functionalities for captains.
The system is capable of adding records for captains, booking rides, finishing a ride, displaying information and rating captains.
>---
>The commands for the system are found in the input file which is called input.txt. The commands in this file are as follow:
>>
>>*ADD_CAPTAIN:* This command generates a BST node for each captaininthe tree. The command followed by two values: the captain ID and the captain’s name. The default value for the rating stars will be “0”and the default value of available is “true”.
>>
>>*DISPLAY_CAPTAIN_INFO:* This command has one value which is the captain ID. It will output the name and the rating stars for the specified captain. If the specified captain is not found, it will output the “Couldn’t find any captain with ID number <ID >” message.
>>
>>*DISPLAY_ALL_CAPTAINS:* This command will output all the captains with the captains’ IDs, names, available and rating stars. (Similar to the output in the output.txt file).
>>
>>*BOOK_RIDE:* This command has one value which is the captain ID. The command will book a ride with the specified captain by changing the available to “false”. If the available for the specified captain is already “false”, then output the “The captain <name> is not available. He is on another ride!” message. If the specified captain is not found, it will output the “Couldn’t find any captain with ID number <ID >” message.
>>
>>*FINISH_RIDE:* This command has two value which is the captain ID, and the rider satisfaction (0 or 1). This command will make the specified captain available again by changing the available to “true”. The rating stars will affect the captain rating stars. The rating stars will increase by one if the rider is satisfied and decrease by one otherwise. (Note: the rating stars is a value between 0 and 5 only).
>>If the available for the specified captain is already “true”, then output the “The captain <name> is not in a ride!” message. If the specified captain is not found, it will output the “Couldn’t find any captain with ID number <ID >” message.
>>
>>*DELETE_CAPTAIN:* This command has one value that represents the captain’s ID. The command will search for this captain in the tree then remove his/her node from the BST, and it will output the “The captain <name> left Uber” message. If the specified captain is not found, it will output the “Couldn’t find any captain with ID number <ID >” message.
>>
>>*QUIT:* This command will stop the program.
>
>---
>there are three classes:
>>
>>*CaptainNode.java:* This class will be used to create objects of type captain and it will store each captain’s information.
>>
>>*UberTree.java:* All the methods will be implemented in this class.
>>
>>*MainProgram.java:* This is the class that contains the main.
>
>---
>
>Fianlly check the output.txt file for the output !


