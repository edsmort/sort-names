This program takes a file containing a list of names, sorts the names and stores them in a new file.

<h2>Setup:</h2>

To create the JAR, run the following

`mvn package`

*Note, this will also run the tests

<h2>Running the program:</h2>

After running the setup steps, run the program locally using the following command

`java -cp target/sort-names-1.0-SNAPSHOT.jar com.company.Main [file-path-to-text-file-containing-names]`

*Note, at this stage only one file can be given per execution, but the code can be easily adapted to take multiple files in the future.

<h2>Testing:</h2>

The tests will have been run when you ran `mvn package`, but if you wish to run them again, you can do so by running `mvn test`
