## Q2 - Tokenisation and Parsing

The code provided implements a simple compiler that compiles and executes a series of commands listed below. There are two types of commands with the syntax as below:

* `LOAD` object_key `FROM` file_name;
* `SAVE` object_key `TO` file_name;

where `object_key` is a string key referencing a certain object stored in a database and `file_name` is a string that is made of a file name and the XML file extension `.xml`.

This compiler aims to use the two commands to load and save a list of `persons` objects, where each `Person` object has four fields, `name`, `gender`, `age`, `occupation`. For example,

* `LOAD` persons `FROM` persons.xml, which loads a list of `persons` from a `persons.xml` file into the database
* `SAVE` persons `TO` persons.xml, which saves a list of `persons` to a `persons.xml` file from the database

`LOAD`, `FROM`, `SAVE`, `TO`, `TERMINATOR`, `PARAMETER` are the defined `keywords` of the commands.
`persons`, `persons.xml` are the `parameters` of the commands. The terminator is a semi-colon `;`. Note that `object_key` and `file_name` are not fixed to the given `persons` and `persons.xml` as we will use different parameters in the marking test cases to test the robustness of your solutions. But the objects to be stored in the database will be fixed to `Person` instances.

Part 1) Implement the `next()` method of the `Tokeniser` class to perform a tokenisation process. The `next()` method should be able to identify the `keywords` and `parameters` of the commands. The tokens and the types are defined in the `Token.java` class.

Please find more details in the given `TokeniserTest.java`.

Part 2) Implement the `parseCmds()` method of the `Parser` class to create two types of commands from the tokens:
* `LoadCommand` contains two parameters, a `key` indicating the object_key, e.g. persons, and a `fileName` indicating the file_name, e.g. persons.xml.
* `SaveCommand` contains two parameters, a `key` indicating the object_key, e.g. persons, and a `fileName` indicating the file_name, e.g. persons.xml.

Please find more details in the given `ParserTest.java`.

Part 3) Implement the `loadFrom()`, `saveTo()` methods of the `Executor` class to execute the parsed commands.

You are required to follow the format of the given example xml file `example.xml`. The variables `KEY_XXX` in `Person.java` class
give the tag names of the elements for the xml file. Note that `indent` property of the xml transformer is optional, you are allowed to uncomment it in `saveTo()` method of `Executor.java` class to make the files more readable.

Please find more details in the given `ExecutorTest.java`.

IMPORTANT NOTES:
* The `keywords` are all case insensitive, whereas the `parameters` are case sensitive. HINT: you can use `toLowerCase()` or `toUpperCase()`, etc. defined in the String.class to compare strings without care for case sensitivity.
* Each single command is terminated by a semi-colon `;`.
* Any number of spaces or tabs between the `keywords` are allowed.
* A series of single commands can be concatenated together in any order.
* All the commands in the given and marking test cases are valid. You don't need to consider the invalidity of the commands.

We give some examples of valid commands below:
* `LOAD persons    FROM  persons.xml;`
* `save persons   to  persons.xml;`
* `LOAD persons     from  persons.xml;   save persons      to  persons.xml;`

We may not give all the valid test cases. Feel free to add more test cases to test the robustness of your solutions.

* * *
* * *

#### You are expected to complete:
* `next()` method in the `Tokeniser.java` class
* `parseCmds()` method in the `Parser.java` class
* `loadFrom()`, `saveTo()` methods in the `Executor.java` class

#### You are expected to upload:
* `Tokeniser.java`
* `Parser.java`
* `Executor.java`

You are allowed to create helper methods in the required java classes. You are only allowed to implement your code in the designated area between "START YOUR CODE" and "END YOUR CODE". Some test cases are provided to assist your understanding, but it does not guarantee you will get full marks. Remember that we use different test cases to mark your solution. You are free to add your own test cases to increase your confidence that your solution is robust.
