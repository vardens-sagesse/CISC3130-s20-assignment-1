# CISC3130-s20-assignment-1
Assignment 1 for CISC 3130/TY2/Spring 2020

Contains code for Assignment #1 for the Spring 2020 Semester, section TY2.

Two .txt output files are provided in the data folder. The .java can be found in src. The .csv can be found in source.

This code takes data from the .csv and seperates the fields by the delimiter value. In this case, it is the character ",".
It will then sort the data in alphabetical order and remove duplicates. While it is doing this, it is also keeping track
of how many times the duplicates appear and logging these frequencies next to the appropriate artists.

I chose to use an ArrayList because Lists are much more versatile than simple arrays. I am able to add elements to the List without having to declare a specific size for the array. This is helpful when one doesn't really know how many elements will end up in the array.

