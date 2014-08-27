### Spreadsheet Evaluator

This is a basic console spreadsheet evaluator. It's definitely not robust by any means. It takes input in the form of a CSV file and outputs it in CSV format. It performs four arthimetic operations (+,-,*,/) and can reference other cells in the data sheet. All calculations are done in postfix form. 

Examples:

1,2,3						1,2,3
4,5,6    -> evaluates to 	4,5,6
7,8,9						7,8,9

1,2,3,4														1,2,3,4
=5 1 +,=6 2 +,=7 3 -,=8 2 -   			-> evaluates to 	6,8,4,6
=9 3.5 *,=10 5 *,=11 2 /,=12 4/								31.5,50,5.5,3

1,2,3							1,2,3
=A1,=B1,6    -> evaluates to 	1,2,6
=B3,8,=C2						8,8,6





