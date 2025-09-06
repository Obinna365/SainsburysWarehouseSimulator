
## Read Me

**Sainsbury's Warehouse Picking Simulator**

**Description**

This is a terminal based application which simulates working in a Sainsbury's Warehouse as a Picker who's job is to make sure the goods are organised for the right stores so they are ready to be dispatched. The program is designed to emulate the working environment so for example working with other individuals whilst ensuring a smooth experience.

## **Terminal Commands**

_**Step 1.**_  To be able display the program you must change make sure you open the directory of the SainsburysWarehouseSimulator folder:

```
cd "SainsburysWarehouseSimulator"

```

_**Step 2.**_  After that you would want to go to the source code:

```
cd src

```

**Step 3.**  Once You are in the souce code you should chose the java file you want to run, (Main file run first!).

```
Java -cp src Main.java

```

_**Step 4.**_  After the Barista class is now running repeat  _**step 1**_  and  _**step 2**_  and now for step 3 instead of writing Main .java replace that with Picker.java.

```
Java -cp src Picker.java
```
## Instructions
1. To start the program you must first run the Main.java class first. This class acts as the server and is needed so it can connect to another socket. It should look like this:

> ::: Warehouse Server Running on Port 12345 :::

2. When the Main.java class is running you can now run the Picker.java file.
3. When the Picker class is now running it will print a message asking you to enter a payroll number which must be 6 digits.

> Connected to the Warehouse Server!
Warehouse Server: Enter Payroll Number:

4. Once you input any 6 digit number then a list of products with the amount will appear here is an example:

> Warehouse Server: Payroll number accepted.
Warehouse Server: Please choose a pallet to pick
Warehouse Server: 0 : {Ready Meal: Pasta Bolognese=11}
Warehouse Server: 1 : {Ready Meal: Pasta Bolognese=5}
Warehouse Server: 2 : {Bagels=120}
Warehouse Server: 3 : {Vienese Biscuits=119}
Warehouse Server: 4 : {Ready Meal: Toad in the hole=36}
Warehouse Server: 5 : {Bagels=89}
Warehouse Server: 6 : {Yogurt=45}
Warehouse Server: 7 : {Ready Meal: Pasta Bolognese=150}
Warehouse Server: 8 : {Ready Meal: Pasta Bolognese=58}
Warehouse Server: 9 : {Ready Meal: Fish and Chips=96}
Warehouse Server: 10 : {Yogurt=127}
Warehouse Server: 11 : {Cranberry Pie=91}
Warehouse Server: 12 : {Ready Meal: Fish and Chips=5}
Warehouse Server: 13 : {Ready Meal: Fish and Chips=131}
Warehouse Server: 14 : {Vienese Biscuits=122}
Warehouse Server: 15 : {Ready Meal: Fish and Chips=124}
Warehouse Server: 16 : {Yogurt=127}
Warehouse Server: 17 : {Yogurt=40}
Warehouse Server: 18 : {Yogurt=64}
Warehouse Server: 19 : {Ready Meal: Pasta Bolognese=35}




5. From 0 to 19 pick a number and once you pick a number then the product will be removed from the list will tell you where to pick the product.

> Warehouse Server: {Ready Meal: Pasta Bolognese=35}
Warehouse Server: Go to grid 2
Warehouse Server: Grid Assigned: 2
Warehouse Server: Store 2 has 1 units left.
Warehouse Server: Pick up to 1 units for cage 2: 

6. Now it will tell you to put a number of products to a designated cage so in this example you must type the number 1 and press enter 

> 1
Warehouse Server: Picked 1 units for cage 2, remaining 34
Warehouse Server: Store 4 has 1 units left.
Warehouse Server: Pick up to 1 units for cage 4: 

7. Once pressed enter the program will tell you how much is left and will ask you to put more products until the remaining amount reaches 0.
8. If a cage is full then the user must write get new cage to replace it and send the cage to the lorries once then another cage would be added and everything will continue.

> get new cage

10. After that then you must keep picking until the list is empty.

## Bugs, Fixes & Upcoming Improvements

 - An improvement I need to make to this project would be to make everyones payroll number unique and this can be done by either storing and reading it from a xlsx file or  a static arraylist.
 - In terms of testing I have not properly tested the full cage functionality so I am unsure whether it works as intended.
 - When you chose a pallet and you enter space it can end up breaking the program so that is something I need to have a proper look at.
