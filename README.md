# CSCI 1302 - GenList ADT v2019.sp

![Trains are like linked lists...](https://i.imgur.com/MdPMTcO.png)

This document contains the description for the Generic List API 
project assigned to the students in the Spring 2019 CSCI 1302 classes
at the University of Georgia.

## Deadline Options

There are different deadline options for this project. Students who perform their
final submission via the `submit` command before the date/times listed below
automatically receive the associated extra credit. The late penalty does not start
applying until after the final date listed. 

* **FRI 2019-03-08 (Mar 08) @ 11:55 PM EST (`+20` Extra Credit)**
* **SUN 2019-03-10 (Mar 10) @ 11:55 PM EST (`+10` Extra Credit)**
* **TUE 2019-03-12 (Mar 12) @ 11:55 PM EST (`+00` Extra Credit)**

## Table of Contents

* [Academic Honesty](#academic-honesty)
* [Updates](#updates)
* [Project Description](#project-description)
* [Project Requirements & Grading](#project-requirements--grading)
  * [Functional Requirements](#functional-requirements)
  * [Non-Functional Requirements](#non-functional-requirements)
  * [Absolute Requirements](#absolute-requirements)
* [How to Download the Project](#how-to-download-the-project)
* [Submission Instructions](#submission-instructions)
* [Appendix - FAQ](#appendix---faq)

## Academic Honesty

You agree to the Academic Honesty policy as outlined in the course syllabus. 
In accordance with this notice, I must caution you **not** to 
fork this repository on GitHub if you have an account. Doing so will more than
likely make your copy of the project publicly visible. Please follow the 
instructions contained in the 
[How to Download the Project](#how-to-download-the-project)
section below in order to do your development on nike. Furthermore, you must adhere
 to the copyright notice and licensing information at the bottom of this document.

## Updates

If there has been an update and you have already cloned the project to Nike, 
then you can update your copy of the project using the <code>$ git pull</code>
command while inside of your project directory.

## Project Description

After implementing the `StringList` interface a couple different ways, your project
manager discussed the finished product with the client. Well, it turns out that the
client was only using strings as "an example" of what they wanted. In reality, the
client wanted a generic list implementation. Without breaking a sweat, your project
manager assigned this new, updated task to you.

In this project, you are tasked with implementing a generic list interface `GenList<T>`
that provides stream-like functionality. Your implementation must use a linked list
as the internal storage for the list. Each node of the linked list should contain a 
generic type object along with a pointer to another node of the same type. The provided 
JAR file does not contain the generic node class. However, you are welcome to use any code you 
created in a class exercise as long as you can explain any part of the code, if asked 
to do so.

For this project, you will *NOT* have access to the `.java` files for the
interface. Instead, you will have access to the generated API documentation
for the interface <a href="http://cobweb.cs.uga.edu/~mec/cs1302-genlistadt-doc/index.html">here</a>
as well as a `.jar` file containing the compiled version of the interface..
Implementors should make sure that each method functions or behaves as described
by the interface's API documentation, except in cases where a functional requirement 
changes the behavior of the method.

**WARNING:** Pay close attention to the API documentation for each and every method. While some 
methods are new for this project, there are methods that existed in the previous list project that
are now genericized. Some such method may also have updated API documentation. For example, the 
`add` method that takes another list as a parameter is now required to handle self reference.
There are also methods that were optional / extra credit in the previous project that
are now mandatory (e.g., the `iterator` method).

Implementors are always free to implement additional methods in addition
to the ones defined by the interface. However, they should not assume that
users (e.g., graders) will use them (even if declared with `public` visibility), 
since they are not defined in the interface. In other words, a driver class should
not be required to call any methods that aren't given in the interface in order to 
fully test the implementation of the interface. Any additional methods you write may 
help avoid redundancy and promote code reuse.

### Suggested Reading

* [API Documentation for `GenList<T>`](http://cobweb.cs.uga.edu/~mec/cs1302-genlistadt-doc/index.html)

### Learning Outcomes

* Implement classes according to an interface (1302-LO1).
* Utilitze polymorphism in a software project (1302-LO3-LO4).
* Use common data structures including lists (1302-L05).
* Test your implementation using unit tests (1302-LO9).

## Project Requirements & Grading

This assignment is worth 100 points. The lowest possible grade is 0, and the 
highest possible grade is 120 based on the date of your last submission
(see [Deadline Options](#deadline-options)).

### Functional Requirements

A functional requirement is *added* to your point total if satisfied.
There will be no partial credit for any of the requirements that simply 
require the presence of a method related to a particular functionality. 
The actual functionality is tested using test cases.

* **(87 points) `LinkedGenList<T>`:** Create the `cs1302.genlist.LinkedGenList<T>` class such
  that it properly implements the `cs1302.genlistadt.GenList<T>` interface 
  with additional requirements listed below. 

  * You must explicitly define and document all constructors required by
    the interface API documentation.
    
  * The `iterator` method is requried for this project.
	
  * There is a requirement related to this class's storage included
    in the [Absolute Requirements](#absolute-requirements) section.
	
  * The bulk of this functional requirement will be graded
    based on 87 JUnit test cases, each worth 1 point. This is the same as
    someone using the classes you wrote based purely on the interface
    definitions. If you implement the interface correctly, then you should
    pass the associated test cases. 
    
  * An interactive tester will be provided to you via Piazza a couple days after
    the project has been released. This tester will contain a special, interactive
    driver-type class that you can use to partially test your `LinkedGenList<T>`
    class. This tester is not what will be used during grading, however, you
    may find it useful when _initially_ testing your methods.
    
* **(13 points) `LinkedGenListTest`:** Create the `cs1302.genlist.LinkedGenListTest` class
  to demo proper use of some of the more interesting methods provided by the
  interface using your `LinkedGenList<T>` class. In this class, you are required to
  create a static method that demos a `GenList<T>` method on two different
  reference types in a meaningful way **using multiple lambda expressions**. 
  You need one of these static demo methods for each of the following 
  interface methods:
  
  | Points | Static Method | List Method |
  |--------|---------------|-------------|
  | **(3 points)** | `demoMap` | [`<R> GenList<R> map(Function<T,R> f)`](http://cobweb.cs.uga.edu/~mec/cs1302-genlistadt-doc/cs1302/genlistadt/GenList.html#map-java.util.function.Function-) |
  | **(3 points)** | `demoReduce` | [`T reduce(T start, BinaryOperator<T> f)`](http://cobweb.cs.uga.edu/~mec/cs1302-genlistadt-doc/cs1302/genlistadt/GenList.html#reduce-T-java.util.function.BinaryOperator-) |
  | **(3 points)** | `demoFilter` | [`GenList<T> filter(Predicate<T> p)`](http://cobweb.cs.uga.edu/~mec/cs1302-genlistadt-doc/cs1302/genlistadt/GenList.html#filter-java.util.function.Predicate-) |
  | **(2 points)** | `demoMin` | [`T min(Comparator<T> c)`](http://cobweb.cs.uga.edu/~mec/cs1302-genlistadt-doc/cs1302/genlistadt/GenList.html#min-java.util.Comparator-) |
  | **(2 points)** | `demoAllMatch` | [`boolean allMatch(Predicate<T> p)`](http://cobweb.cs.uga.edu/~mec/cs1302-genlistadt-doc/cs1302/genlistadt/GenList.html#allMatch-java.util.function.Predicate-) |
  
  * **What is meaningful?** You need to make the code, documentation, and the printout clear such 
    that anyone who is reading it can understand what is going on. The scenarios
    that you demo should not be trivial. In most cases, this will involve using 
    some of your other list methods in conjunction with the ones that are requred 
    above.
    
  * **Do I need a `main` method?** You should create a `main` method that calls each of the
    demo functions. Please make sure that your program output is legible. 
  
### Non-Functional Requirements

A non-functional requirement is *subtracted* from your point total if
not satisfied. In order to emphasize the importance of these requirements,
non-compliance results in the full point amount being subtracted from your
point total. That is, they are all or nothing. 
  
* **(25 points) Code Style Guidelines:** You should be consistent with the style 
  aspect of your code in order to promote readability. All of the individual code
  style guidelines listed below are part of a single non-functional requirement
  that, like the others, is all or nothing. Besides consistency, the
  following conventions will be enforced:
  
  * **Reference type names are written in _UpperCamelCase_.** Class names are  
    typically nouns or noun phrases. For example, `Character` or `ImmutableList`. 
    Interface names may also be nouns or noun phrases (for example, `List`), but 
    may sometimes be adjectives or adjective phrases instead (for example, 
    `Readable`).
  
  * **Method names are written in _lowerCamelCase_.** Method names are also 
    typically verbs or verb phrases. For example, `sendMessage` or `stop`.
  
  * **Braces are always used where optional.** Braces should be used with `if`, 
    `else`, `for`, `do`, and `while` statements, even when the body is empty or 
    contains only a single statement.
	
  * **Block Indentation: 4 spaces.** Each time a new block or block-like construct 
	is 	opened, the indent increases by four spaces. When the block ends, the indent 
	returns to the previous indent level. The indent level applies to both code 
	and comments throughout the block. 
	
    If you use Emacs, you can add the following lines to your `~/.emacs` file to 
    make tabs for _new_ files comply with this requirement:
	```
	(setq-default indent-tabs-mode nil)
	(setq-default c-default-style "linux"
                      c-basic-offset 4)
	(setq-default tab-width 4)
	(setq indent-line-function 'insert-tab)
	```
    
  * **Column limit: 100.** You should limit the number of characters, including
    whitespace, on any given line to 100 characters. Except as noted below, any 
    line that would exceed this limit must be manually line-wrapped in a
    consistent manner. Exceptions to the column limit include:
    
    * Lines where obeying the column limit is not possible (for example, a long 
      URL in Javadoc, or a long JSNI method reference).
    * In `package` and `import` statements.
    * Command line input examples in a comment that may be cut-and-pasted into 
      a shell.
      
    If you use Emacs, then you can add the following lines to your `~/.emacs` file to 
    highlight characters that exceed the column limit:
    ```
    ;; check for lines that exceed some column limit
    (setq-default
     whitespace-line-column 100
     whitespace-style '(face lines-tail))
    (add-hook 'prog-mode-hook #'whitespace-mode)
    ```
    If you would rather have Emacs highlight entire lines that exceed the column
    limit, then use the following instead (not in addition to):
    ```
    ;; check for lines that exceed some column limit
    (setq-default
     whitespace-line-column 100
     whitespace-style '(face lines))
    (add-hook 'prog-mode-hook #'whitespace-mode)
    ```
    You can create the `~/.emacs` file if it does not exist. If you have
    an `~/.emacs.el` or `~/.emacs.d/init.el` file, then you can place the lines 
    in that file instead of `~/.emacs`. 
    
    If, after adding the configuration lines above, you still have trouble finding
    lines that exceed the column limit, then you can ask Emacs to mark newlines with
    a `$` by typing `M-x whitespace-newline-mode` then `RET` (return). 
      
  * **Method height <= window height.** You should limit the number of lines for
    a method so that the entire method can be seen on the screen at once. This
    includes the line(s) with the method's signature and opening curly brace, all
    lines in the body of the mthod (including blank lines), and the line with
    the method's ending curly brace. The method height does not include a
    method's Javadoc comment, however, it does include any comments contained
    within the body of the method. 
    
    Of all the style guidelines, this is the probably the most subjective and 
    hardest to grade because everyone might have a different window size due
    to different terminal emulator and physical screen size configurations. 
    Therefore, graders will be checking for compliance with the spirit
    of this guideline, which is: methods that are too big and/or repetitive 
    should be refactored to include proper looping constructs and/or broken
    up into smaller methods to improve readability.
    
    If you use Emacs, you can add the following lines to your `~/.emacs` file to 
    enable line numbers:
    ```
    ;; add line numbers
    (global-linum-mode 1)
    
    ;; display line numbers and column numbers
    (setq line-number-mode t)
    (setq column-number-mode t)
    
    ;; make sure the line numbers don't touch the text
    (setq linum-format "%d ")
    ```
    You can create the `~/.emacs` file if it does not exist. If you have
    an `~/.emacs.el` or `~/.emacs.d/init.el` file, then you can place the lines 
    in that file instead of `~/.emacs`. 

* **Javadoc Documentation (25 points):** All methods and classes needs to be __fully documented__
  using Javadoc comments and appropriate Jaadoc tags. Each comment should provide a description 
  of the method's functionality in the first sentence of the comment. This sentence needs to be
  a grammatically correct English sentence with proper punctuation. Further description can be 
  provided in subsequent sentence. 
  
  Even if documentation is inherited from an interface, you must explicitly include a 
  Javadoc comment with either a new description (if that makes sense) or make proper use
  of the `{@inheritDoc}` tag.

  It should be noted that we do expect you to provide a Javadoc comment for each class
  in addition to a comment for each method within a class. The Javadoc comment
  for a class is placed directly above the class declaration as seen in the examples
  provided in the link referenced earlier. 

* **In-line Documentation (25 points):** Code blocks should be adequately documented
  using in-line comments. This is especially necessary when a block of code
  is not immediately understood by a reader (e.g., yourself or the grader).

### Absolute Requirements

An absolute requirement is similar to a non-functional requirement, except that violating
it will result in an immediate zero for the assignment. In many cases, a violation
will prevent the graders from evaluating your functional requirements. No attempts will be
made to modify your submission to evaluate other requirements.

* **Project Directory Structure:** The location of the default
  package for the source code should be a direct subdirectory of 
  `cs1302-genlistadt` called `src`. When the project is compiled, 
  the `-d` option should be used with `javac` to make the default package 
  for compiled code a direct subdirectory of `cs1302-genlistadt` 
  called `bin`. 
  
  If you follow this structure, then you would type the following to compile 
  your code, assuming you are in the top-level project 
  directory `cs1302-genlistadt`:
  
  ```
  $ javac -cp lib/genlistadt.jar -d bin src/cs1302/genlist/LinkedGenList.java
  $ javac -cp bin:lib/genlistadt.jar -d bin src/cs1302/genlist/LinkedGenListTest.java
  ```
  
  Remember, when you compile `.java` files individually, there might be 
  dependencies between the files. In such cases, the order in which you
  compile the code matters. Also, if more than one default package is needed
  (e.g., `genlistadt.jar` and some other directory like `bin`), then a colon `:` 
  can be used to separate each path in a list of multiple paths supplied
  to `-cp`. For an example, see 
  ["Setting the Classpath"](https://github.com/cs1302uga/cs1302-tutorials/blob/master/packages.md#setting-the-class-path) 
  in the package tutorial.

* __Development Environment:__ This project must be implemented 
  in Java 8, and it *must compile and run* correctly on Nike using the specific
  version of Java 8 that is setup according to the instructions provided
  by your instructor. For Spring 2019, these instructions were posted on
  Piazza [@29](https://piazza.com/class/jpupoaxnvvs497?cid=29).
  
  If you decide to introduce additional `.java` files into your project,
  then they are expected to fulfill all non-functional and absolute requirements, 
  even if the main parts of the project do not use them. You may assume
  graders will compile your source code in an order that satisfies
  compilation dependencies. You should remove any `.java` files that you
  do not need before submission. 
  
* **`cs1302.genlist.LinkedGenList<T>` Storage Requirement:**
  You must use a sequence of generic node (or container) objects
  for this class's storage. The `Node` class is not provided for you.
  You will need to make your own as a separate generic class. 
  If you use Java's `java.util.LinkedList` class or something similar, then 
  that will result in an immediate violation of this absolute requirement, 
  regardless of any use of any `Node` objects elsewhere in the class.
  This requirement also prohibits any use of third-party implementations 
  of list or list-like interfaces. You may not use arrays in the
  `LinkedGenList<T>` class anywhere except in the `toArray` method --
  this also prohibits the use of `toArray` elsewhere in the class.
  
* **No Stream API:**
  You are not allowed to use built-in Java streams to implement any
  part of this project. Use of any class that implements
  `java.util.stream.Stream<T>` is prohibited. If you use Java's stream
  interface or something similar, then that will result in an immediate
  violation of this absolute requirement.

* **No Static Variables:** Use of static variables is 
  not allowed for this assignment. However, static constants are permitted.

### Grading

This project will be graded using unit tests, none of which will be made 
available before the project deadline. Graders will also inspect your implementation
of `LinkedGenListTest` to ensure proper use of lambda expressions.

## How to Download the Project

On Nike, execute the following terminal command in order to download the project
files into sub-directory within your present working directory:

```
$ git clone https://github.com/cs1302uga/cs1302-genlistadt.git
```

This should create a directory called `cs1302-genlistadt` in
your present working directory that contains a clone of the 
project's respository. Take a look around.

If any updates to the project files are announced by your instructor, you can
merge those changes into your copy by changing into your project's directory
on Nike and issuing the following terminal command:

```
$ git pull
```

If you have any problems with these download procedures, then please contact
your instructor.

## Submission Instructions

You will be submitting your project via Nike before the deadline indicated
near the top of this document. Make sure your project files
are on `nike.cs.uga.edu`. Change into the parent directory of your
project directory. If you've followed the instructions provided in this document, 
then the name of your project directory is likely `cs1302-listadt`. 
While in your project's parent directory, execute the following command: 

```
$ submit cs1302-genlistadt cs1302a
```

It is also a good idea to email a copy to yourself. To do this, simply execute 
the following command, replacing the email address with your email address:

```
$ tar zcvf cs1302-genlistadt.tar.gz cs1302-genlistadt
$ mutt -s "[cs1302] cs1302-genlistadt" -a cs1302-genlistadt.tar.gz -- your@email.com < /dev/null
```

If you have any problems submitting your project then please send a private
post to your instructor via the course Piazza as soon as possible. However, 
creating a post about something like this the day or night the project is due 
is probably not the best idea.

# Appendix - FAQ

Below are some frequently asked questions related to this project.
   
1. **Can I technically implement the methods first before I implement them correctly?**

   You may wish to write out the method signatures for the methods you are
   implementing from the interface with empty bodies in an attempt to get started.
   You will quickly discover that the methods that have a non-void return
   value actually need to return something. If you don't put a return statement,
   then this complicates trying to compile and test one method at a time.
   
   It is possible to _temporarily_ include a `throw` statement in the method
   until you commit to writing the return statement. I reccommend throwing
   an instance of [`UnsupportedOperationException`](https://docs.oracle.com/javase/8/docs/api/java/lang/UnsupportedOperationException.html)
   if you choose to do this. For example, you might write something like this for the `get(int)`
   method:
   ```
   public T get(int index) {
       throw new UnsupportedOperationException("not yet implemented");
   } // get
   ```
   
1. **What is `genlistadt.jar`?**

   In Java, `.jar` files are Java™ Archive (JAR) files that bundle multiple files into a single 
   compressed file. Typically a JAR file contains the package directories and `.class` files
   for a library. This is just like the `bin` directory that you are used to, except it's all
   bundled into a single file. For example, the `listadt.jar` file contains the package directories
   and `.class` files for `cs1302.listadt.StringList`. If you are in the same directory as
   `listadt.jar`, then you can use the following command to take peek into the archive:
   
   ```
   $ jar -tf genlistadt.jar
   ```
   
   You shold notice that the top-level directory in the JAR file is `cs1302`, which means that
   the JAR file itself can serve as the default package for compiled code--this is why we
   use with `-cp` in examples given elsewhere in this project description.

Have a question? Please post it on the course Piazza.

<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/)

<small>
Copyright &copy; Michael E. Cotterell and the University of Georgia.
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>

