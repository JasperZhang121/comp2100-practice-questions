## Q3 - Tokenisation & Parsing & Tree (30 marks)

The provided code implements a simple compiler that compiles and executes a series of commands. The compiler interacts with a binary-tree based memory. The memory is initialised as empty. There are three types of commands with the syntax as below:

* `LOAD key;`: loads the value stored in an address referenced by the string `key` in memory. If the key does not exist, return null.
* `SAVE value TO key;` : saves the `value` to an address referenced by the string `key` in memory.
* `SUM pattern TO key;` : adds up all the values in addresses referenced by the keys satisfying the string `pattern` and saves the sum value to an address referenced by the string `key`. If no keys satisfy the given pattern, save 0 to memory.

The string `pattern` can be:
* a wildcard character `*` indicating 0 or at least 1 letter or digit.
* a series of letters and digits along with `at most one wildcard character`, e.g. `abc`, `abc*`, `*abc`, `a*c`.
For example, all of `aasdbc`, `abbbc`, `abc`, `a2c`, `ac` satisfy the pattern `a*c`. `bac` does not satisfy the pattern `a*c` because it does not start with the letter `a`. The pattern `*` references all the keys in memory.

Note that you are not allowed to use `regex` libraries to achieve the pattern search. We will check the usage of regex-related libraries and assign zero mark for those who use it.
`Tips: If you have some difficulties in handling the commands with a wildcard character, it would be better to adapt your solutions for the commands without a wildcard character. We will prepare different marking test cases to evaluate your solutions. This will help you get partial marks but not lose all the marks for this question.`

`LOAD`, `SAVE`, `SUM`, `TO`, `TERMINATOR`, `PARAMETER` are the defined `keywords` of the commands. `key`, `value`, and `pattern` are the `parameters` of the commands. The semi-colon `;` is the terminator.

Part 1) Implement the `next()` method of the `Tokeniser` class to perform a tokenisation process. The `next()` method should be able to identify the `keywords` and `parameters` of the commands. The token types are defined in the `Token.java` class.
The `keywords` and `parameters` are separated by at least one space or special symbol, where a special symbol can be any symbol except a letter, a digit, the wildcard character `*` or the terminator `;`. For instance, `^%&$@` are considered as special symbols. You are expected to return valid tokens that do not include any spaces or special symbols.

Please find more details in the given `TokeniserTest.java`.

Part 2) Implement the `parseCmds()` method of the `Parser` class to create three types of commands from the tokens:
* `LoadCommand` contains one parameter, a string `key`.
* `SaveCommand` contains two parameters, a string `key` and a non-negative integer `value`.
* `SumCommand` contains two parameters, a string `pattern` and a string `key`.

Please find more details in the given `ParserTest.java`.

Part 3) Implement the `find()` and `invertedPreOrder()` methods of the `BST` class to realise the underlying operations of binary search tree. `find()` aims to find a particular node based on a given key. `invertedPreOrder()` aims to perform an inverted pre-order traversal of the tree. Note that the traversal of an inverted pre-order should be: root, right child, left child.

Please find more details in the given `BSTTest.java`.

Part 4) Implement the `load()`, `save()` and `sum()` methods of the `Executor` class to execute the parsed commands.
You are required to use `find()` and `invertedPreOrder()` as helper methods. For instance, `invertedPreOrder()` method needs to be used to loop through all the keys stored in the tree-based memory.

Please find more details in the given `ExecutorTest.java`.

IMPORTANT NOTES:
* The string `key` parameters are composed of letters and digits, whereas the `value` parameters are non-negative integers.
* The `key` or `value` parameters DO NOT include a wildcard character.
* The `keywords` are all case `INSENSITIVE`, whereas the `key` parameters are case `SENSITIVE`. HINT: you can use `toLowerCase()` or `toUpperCase()`, etc. defined in the String.class to compare strings without care for case sensitivity.
* The `keywords` will not appear in the `parameters`.
* At least one space or special symbol between the `keyword` and `parameter` is allowed.
* Each single command is terminated by a semi-colon `;`.
* A series of single commands can be concatenated together in any order.
* All the commands in the given and marking test cases are valid. You don't need to consider the invalidity of the commands.

We give some examples of valid commands below:
* `LOAD a;`
* `save 100   to  a;`
* `save   10 to&^  variable!@#$%^&   ; Load variable  ; Sum vari* To ret ; `

We may not give all the valid test cases. Feel free to add more test cases to test the robustness of your solutions.

`Please try your best to return a value for the required methods, e.g. 0 or null, to make sure your solutions do compile if you have trouble in providing the solutions. Otherwise, you may be subject to a mark loss due to compile errors.`

* * *
* * *

#### You are expected to complete:
* `next()` method in the `Tokeniser.java` class
* `parseCmds()` method in the `Parser.java` class
* `find()`, `invertedPreOrder()` methods in the `BST.java` class
* `load()`, `save()`, `sum()` methods in the `Executor.java` class

#### You are expected to upload:
* `Tokeniser.java`
* `Parser.java`
* `BST.java`
* `Executor.java`

You are allowed to create helper methods in the required java classes. You are only allowed to implement your code in the designated area between "YOUR CODE STARTS HERE" and "YOUR CODE ENDS HERE". Some test cases are provided to assist your understanding, but it does not guarantee you will get full marks. Remember that we use different test cases to mark your solution. You are free to add your own test cases to increase your confidence that your solution is robust.
