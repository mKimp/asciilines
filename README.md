# asciilines
Copyright (c) 2019 Kim Ma

This program will create a command-line program that will accept a single .tvg file argument and render the file as ASCII on standard output. It will fail on several cases. Please read the Tests section for more details.

 # Build and Run

Build this program with Java. You can run this program with java readTvgFile: for example,

```
java readTvgFile
```
To edit the content and run again:

```
javac readTvgFile.java
java readTvgFile
```

# Tests

The test fails in several cases. 

+ If the input is an invalid file, the program fails immediately. 
+ If the file is not structured as expected (string, int, int, string, int), the program fails immediately.
+ if the length in the rendered command line is 0 or less, the program still executes normally. However, there is an error message which indicates the illegal rendered character and its lenghth. The canvas will not display that rendered character. (run with test1.tvg)
+ if the row or column in the rendered line is less than 0, it will be automatically converted to 0 base, and the program executes normally.(run with test2.tvg)

# License
This program is licensed under the "MIT License". Please see the file LICENSE in the source distribution of this software for license terms.




