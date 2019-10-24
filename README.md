# PairProgramming

You will work in pairs
 * First create a project on Gitub (follow the usual instructions)
 * Clone the project on one's computer
 * Both memebers will be coding in one's computer
 * When they decide, they will commit the code, push it to a repository created by themselves and then the other member will fork it, clone it and start making modifications on the other's computer

It doesnt' matter in which computer you are working, both of you will be all the time discussing the code and making modifications on just one computer

## The Requisites:
  > "You have to create in pairs a JAVA project to manage a dictionary built using Linked lists"

1. The application will be able to open a file called “unsorteddict.txt”
2. This file will be a collection of words where each line contains a word
3. The application will read the file line by line, in other words, it will read a new word each time a new line is read
  ** Each time a new line is read, the new word will be inserted in the correct position of a data structure called “dictionary” that will be of a Linked list type
  ** Therefore , this “dictionary” will be a sorted list of all the words read from the file
4. After the “unsorteddict.txt” has been fully read, the application will create another file called “sorteddict.txt” which will contain all the words (one word per line) alphabetically ordered
5. The application will also accept command line arguments, i.e. it could be executed as java LinkDictionary 23 butterfly
  ** The application will accept a minimum of 0 arguments and a maximum of 10 arguments
  ** If the argument is a number, the corresponding word placed in that position in the ordered linked list “dictionary” should be printed out on the console
  ** If the argument is a word, the application should print out in the console the number that represent the order of that word inside the dictionary. If it doesn’t exist, it should write “-1”.


