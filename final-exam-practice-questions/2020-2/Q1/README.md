## Q1 - Tokenization and Tree Build [30 marks]

Part 1 [20 marks]) Implement the 'next()' method of the 'MyTokenizer' class to perform a tokenization process. The 'next()' method should be able to identify the following token types: 
upper case words, lower case words, short camel case words, long camel case words, integers, and non-alphanumeric characters.

A token and the token types are defined in the 'Token.java' class.

Definitions:
- Digits are single characters from 0 to 9.
- Letters are single characters from 'A' to 'Z' and 'a' to 'z'.
- Words are composed of a series of concatenated letters.
- The word length is the number of characters that the word has.
- Short camel case words are those with length less or equal to 3.
- Long camel case words are those with length greater than 3.
- Integers are composed a series of concatenated digits of any length.
- Non-alphanumeric characters are single characters other than the digits and letters.

Example:
Consider the text: 'i am the KING of THE castle. The caStle is my HOME. I am 10 #@ 1234'.

- "KING, THE, HOME" are examples of upper case words.
- "i, am, of" are examples of lower case words.
- 10 and 1234 are examples of integer numbers.
- "The" is an example of short camel case words.
- caStle is an example of long camel case words.
- "., #, @" are examples of non-alphanumeric characters.

Part 2 [10 marks]) Implement the 'build()' method of the 'TreeBuilder' class to create a tree following the specifications below:
- The 'build()' method must create and return a tree containing all upper case words extracted from the input string.
- The key of each node in the tree corresponds to the length of the upper case word.
- If two or more distinct upper case words have the same length, those words must be added to the same node (in a list of strings in that node). For example, if a string contains the words HOME and KING, then HOME and KING should be at the same node of the tree, with key 4.

- The build method receives a string as input and returns a tree containing only the upper case words extracted from the input string.
- You must use the 'MyTokenizer' class to help you extract each upper case word from the input string and insert it in the tree you will return. 

Upload the files: 'MyTokenizer.java' and 'TreeBuilder.java' to Wattle for marking. 

Note that you are expected to give a generic solution that fulfils the question requirements. You are encouraged to create your own test cases locally to check your solutions. We will use different test cases from the given ones to evaluate your solutions.

