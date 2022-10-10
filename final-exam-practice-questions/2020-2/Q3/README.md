
### Q3 - Persistent Data [25 marks]

Implement the method `levelTraversal()` of the class `RBTree` in the `RBTree.java` file, and the methods 'readCsv()', 'createTree()', and 'saveXML()' of the class 'Application' in the 'Application.java' file to save an XML file, following the format below:

````
<?xml version="1.0" encoding="utf-8" standalone="no"?>
<people>
    <person>
        <id>33</id>
        <name>John</name>
        <age>20</age>
        <occupation>Student</occupation>
    </person>
    <person>
        <id>88</id>
        <name>Tom</name>
        <age>21</age>
        <occupation>Student</occupation>
    </person>
    <person>
        <id>11</id>
        <name>Jerry</name>
        <age>40</age>
        <occupation>Lecturer</occupation>
    </person>
    <person>
        <id>43</id>
        <name>Ben</name>
        <age>45</age>
        <occupation>Youtuber</occupation>
    </person>
    <person>
        <id>16</id>
        <name>Paul</name>
        <age>40</age>
        <occupation>Programmer</occupation>
    </person>
    <person>
        <id>10</id>
        <name>Mary</name>
        <age>35</age>
        <occupation>Manager</occupation>
    </person>
</people>

````
The 'levelTraversal()' method must return the level order traversal from the right to left.

For instance, consider the following tree:
````
                        33
                      /    \
                    11      88
                   / \    /  
                  10  16  43   
````                                                        
it must return [33, 88, 11, 43, 16, 10].


The 'readCsv()' method must read a csv file in the following format and return a list of person:
For instance, consider the csv file where each field is separated by ';' :
````
id;name;age;occupation
33;John;20;Student
11;Jerry;40;Lecturer
88;Tom;21;Student
10;Mary;35;Manager
16;Paul;40;Programmer
43;Ben;45;Youtuber
````
it must return a list of instances of Person class with the id, name, age and occupation.

The 'createTree()' method must return an instance of a Red-Black tree containing all people from the list parameter (each node has an integer as key and an instance of Person as data).
The 'saveXML()' method must create an XML file containing all Person instances following the level traversal order. The final name of the XML file must be 'people.xml'.

You are allowed to add helper methods in the RBTree class.
You are NOT allowed to use any external library, you must use the standard Java 8+ library for XML.
Remember that XML is case-sensitive, you must strictly follow the specified format to avoid getting zero marks.

Note that if you are confronted with a timeout exception while running the given test cases in your computer, you are allowed to increase the timeout parameter to no more than 3000ms to bypass the issue.

Upload the files 'RBTree.java' and 'Application.java' to Wattle for marking.

Note that the 'ApplicationTest.java' is used to test all methods to be implemented in this question.
