# Using regular expressions to handle date formats

Sooner or later one needs to work with dates. One way which one can do this is using a text matching technology called "regular expressions".

It is an advanced version search in text, which searches not for a substring, but for a **pattern**.

A pattern is specified using these fundamental rules:

* a letter X matches 'X'
* X|Y matches X or Y
* X* matches zero or more X

In practice there are many more patterns supported by regular expressions.

### Character groups
Rather than writing (0|1|2|3|4|5|6|7|8|9) for one digit, we have a shortcut "\d" which does the same.  

* `[abc]` Matches either an a, b or c character
* `[^abc]` Matches anything but a, b or c
* `[a-z]` Matches all characters in the range a-z
* `[a-zA-Z]` Matches all characters in the range a-z and A-Z
* `\d` Matches any digit
* `\w` Matches any letter, digit or underscore
* `.`  Matches any single character

### Combinators
* `X*` zero or more X
* `X+` one or more X (same as XX*)
* `X?` zero or one X (same as (|X) )
* `X{3}` Three X's (Same as XXX)

### Capture groups
* `(X)` Paranthesis - enables you to write e.g (X|Y)+ which is different from X|Y+
* Parenthesis also defines a **capture**. 
* A previous capture can be refered to as `\2` (second capture)

### Substitutions
You can specify a *substitution* which is a textstring where you can specify what should be inserted instead of the match. In the substitution text you can use the captured fragments.

## Online learning ressources

### [regexone.com](https://regexone.com)
Has a set of nice tutorials for regular expressions. Comes highly recommended!

### [regex101.com](https://regex101.com)
Where regexone has a fixed set of exercises, regex101 has an online tool for trying out your own regualar expression. 


### subtask 1
For this it is recommended that you solve the folowing exercises from regexone: Letters, Digits, Any Digit, Any Non-digit character, Any Character and Period, as well as Capture Group and Capture Sub-group

### subtask 2 
Write a regular expression which find all dates in the text below, and write a substitution which rearranges all dates into UTC format (2017-04-21).

Use the regex101 tool to try it out.

```
04.04.2017
Viral video of student skiing to the University of Applied Sciences in Valais-Switzerland : part II

After Laurent De Martin, it is now Ramon Hunziker’s turn to ride from Crans-Montana...
21.03.2017
First Workshop on Artificial Intelligence in Valais on March 24

The HES-SO Valais-Wallis and the research institute Idiap organize the first common...
Photo (from left to right): M. Zumstein, S. Mayor (Cambridge English Exams Centre Manager), B. Sollberger, B. Todeschini, J. Williams (Cambridge English Exams Centre Manager), not shown: L. Adkins.
01.03.2017
Cambridge English Exam Preparation Centre

The HES-SO Valais Wallis language centre received an official Cambridge English Exam...
Miriam Scaglione awarded at the ENTER2017 eTourism Conference
25.01.2017
Miriam Scaglione awarded at the ENTER2017 eTourism Conference

Prof. Miriam Scaglione, researcher at the Institute of Tourism, won the Best...

11.11.2016

L’institut Informatique de gestion et l’institut Tourisme de la HES-SO Valais-Wallis...
```

### subtask 3
Write a regular expression which recognize all day-month-year formats (e.g. 21.04.2017, 21/4/2017, 21-04-2017, 21 04 2017) and transforms it to UTC format. However, it should not match mixed formats like 21-04/2017.

