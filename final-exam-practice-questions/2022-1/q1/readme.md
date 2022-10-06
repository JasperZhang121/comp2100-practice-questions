## Q1 - Design Pattern & Software Testing & Persistent Data (20 marks)

One day, your supervisor assigns to you a game development task, where a character can be controlled by external keyboard instructions.

The character has five states, where each state has only one unique instance:
* StandState
* LieProneState
* RunState
* CrawlState
* ShootState

The states are interconvertible based upon 7 keyboard instructions:
* Key.UP
* Key.DOWN
* Key.RIGHT
* Key.LEFT
* Key.L
* Key.S
* Key.RESET

You are expected to apply the `state` and `singleton` design patterns based on the given state graph `Graph.pdf`.

##### 1) You are expected to create all the state classes from scratch to pass the given test cases in `StateTest.java` class, where a `getInstance()` method should be defined to obtain the singleton instance of each state. Note that any state will be reset to the default `StandState` on `Key.RESET`.

Please do not create all the state classes in one file!

##### 2) You are required to develop robust code, which ensures that the passed-in arguments are valid. You are expected to complete the `check()` method in the `State` interface and also create test cases in the following methods of the `ExceptionTest.java` class for the exception testing:
* `testNullKeyException()`: If the passed-in key is null, the `NullKeyException` will be thrown.
* `testNullCharacterException()`: If the passed-in character is null, the `NullCharacterException` will be thrown.

Hint: For the marking of part 2, firstly we will check whether your code passes the test cases in the `ExceptionTest.java`. Secondly, we will also run the correct test cases to test whether your code in the `check()` method meets the requirements.

###### 3) You are expected to complete the `read()` and `write()` methods in the `XMLProcessor.java`. `read()` aims to read the keys and events from the xml file. `write()` aims to write the keys and events to the xml file in the given order. You are required to comply with the XML format in the given `example.xml` file. Ensure that the example XML file is placed in the right directory.

`Please try your best to return a value for the required methods, e.g. 0 or null, to make sure your solutions do compile if you have trouble in providing the solutions. Otherwise, you may be subject to a mark loss due to compile errors.`

* * *
* * *

##### You are expected to upload:
* `State.java`
* `StandState.java`
* `LieProneState.java`
* `RunState.java`
* `CrawlState.java`
* `ShootState.java`
* `ExceptionTest.java`
* `XMLProcessor.java`

`IMPORTANT NOTES`:
* Please do not add any packages at the head of any of the above uploaded files. Otherwise, your code may fail to be compiled by the auto-marker and you may lose marks.
* You are allowed to create helper methods in the required java classes. Aside from creating those helper methods, you are only allowed to implement your code in the designated area between "YOUR CODE STARTS HERE" and "YOUR CODE ENDS HERE".
* Some test cases are provided to assist your understanding, but passing them does not guarantee you will get full marks. Remember that we use different test cases to mark your solution. You are free to add your own test cases to increase your confidence that your solution is correct and robust.
