# EskerAssessment
 Remote Assessment for Esker

 This assessment, only the programming portion, took around 7 hours of active work to complete. About 3 of those hours was dedicated to working out a regular expression, which is addressed further below.

 This program assumes only one argument, one text file, is entered. It uses a BufferedReader to parse the file and prints to a new file, Output.txt, filename, line count, total character count, letter count, digit count, other character count, word count, and frequency of varying lengths of words. It checks if Output.txt already exists, creating the file if it doesn't and otherwise appending the new information to the existing file. I used BufferedReader as opposed to filescanner because I was not manipulating the existing information in any way and didn't need to find out further information from the file, such as int, long, double, etc.
 
 I was unable to creat a regular expression that would remove parantheses and single or double quotes without adding extra spaces to the words array. I was also unable to create one that would ignore empty lines. So word count will be off depending on how many lines are inbetween paragraphs. I attempted, instead of using .split(), to try a matching regular expression with Matcher, one that would only match only letters a-z, A-Z, but wasn't able to get it working as well as the one currently in the code. If I had more resources, like people to ask in person as opposed to just searching online for help, I believe I would have been able to create a regex robust enough for the intended purpose of this program.

 The paragraphs for TestFile were taken from: https://en.wikipedia.org/wiki/Cat
 I did remove (Felis catus) and round 7.3 and 4.8 to 7 and 3 respectively. I did so to provide a more accurate Output file given I had trouble with the regex.

 Example of report to generate:

File name: D:\temp\file.txt
Number of lines: 85
Number of characters (total): 1441
Number of letters: 782
Number of figures: 17
Number of other characters: 642
Number of words: 195
Number of 1 letter words: 56
Number of 2 letters words: 27
[...]
Number of 16 letters words: 2
Number of 19 letters words: 1

