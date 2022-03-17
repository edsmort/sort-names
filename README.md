This program takes a file containing a list of names, sorts the names and stores them in a new file.

Setup:
To create the JAR, run the following

`mvn package`

*Note, this will also run the tests

Running the program:
After running the setup steps, run the program locally using the following command

`java -cp target/sort-names-1.0-SNAPSHOT.jar com.company.Main [file-path-to-text-file-containing-names]`

If the text file containing names is within the src directory, you can use the file path relative to the src directory - e.g. "src/name-list.txt".
Otherwise, please provide the absolute filepath.
*Note, at this stage only one file can be given per execution, but the code can be easily adapted to take multiple files in the future.

Testing:
The tests will have been run when you ran `mvn package`, but if you wish to run them again, you can do so by running `mvn test`
