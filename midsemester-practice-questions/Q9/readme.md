## Design Pattern & Software Testing & Binary Search Tree

One day, your supervisor assigns to you a game development task, where a character can be controlled by external keyboard instructions.

The character has four states, where each state has only one unique instance:
* StandState
* SuspendState
* WalkState
* SquatState

The states are interconvertible based upon 4 keyboard instructions:
* Key.UP
* Key.DOWN
* Key.RIGHT
* Key.LEFT

You are expected to apply the `state` and `singleton` design patterns based on the given state graph `Graph.pdf`.

##### 1) You are expected to create all the state classes from scratch to pass the given test cases in `StateTest.java`, where a `getInstance()` method should be defined to obtain the singleton instance of each state.

##### 2) You are required to develop robust code, which ensures that the passed-in arguments are valid. You are expected to complete the `check()` method in the `State` interface and also create test cases in the following methods of the `ExceptionTest.java` class for the exception testing:
* `testNullKeyException()`: If the passed-in key is null, this exception will be thrown.
* `testNullCharacterException()`: If the passed-in character is null, this exception will be thrown.

Hint: For the marking of part 2, firstly we will check whether your code passes the test cases in the `ExceptionTest.java`. Secondly, we will also run the correct test cases to test whether your code in the `check()` method meets the requirements.

##### 3) The expected 4 keyboard instructions and other unknown instructions are stored in a binary search tree. You are expected to complete the `invertedPreOrder()` method to perform an inverted pre-order traversal of the tree in order to pass the given test cases in `BSTTest.java`.

Note that the traversal of an inverted pre-order should be: root, right child, left child.

* * *
* * *

##### You are expected to upload:
* `State.java`
* `StandState.java`
* `SuspendState.java`
* `WalkState.java`
* `SquatState.java`
* `ExceptionTest.java`
* `BST.java`

`IMPORTANT NOTES`:
* Please do not add any packages at the head of any of the above uploaded files. Otherwise, your code may fail to be compiled by the auto-marker and you may lose marks.
* You are allowed to create helper methods in the required java classes. Aside from creating those helper methods, you are only allowed to implement your code in the designated area between "START YOUR CODE" and "END YOUR CODE".
* Some test cases are provided to assist your understanding, but passing them does not guarantee you will get full marks. Remember that we use different test cases to mark your solution. You are free to add your own test cases to increase your confidence that your solution is correct and robust.
