README for Assignment 1, COL106
Rohit Agarwal
2018EE10494

This assignment required us to make programme to maintain student records and retrieve data from them.

LinkedList and Position:
Positions were the nodes for the linked lists which stored a value and the next Position. Thus forming a chain.
The add function in LinkedList adds a new Position to the start of the lists. This was done so because the queries were to answered in reversed order. So simply adding each query in a LinkedList first and then iterating through it gave the queries in reversed order.
The positions function returned an iterator which starts from the first element and then goes to lasts one.
Count function maintained the length of the LinkedList.

Iterator:
The iterator allows us to go through a LinkedList and access each value.
In the next method, I stored the current Position in a variable and then set the current Position as Position.after() and returned the Position stored in the variable. Effectively I return the current Position rather than Position.next();
I did this so that I could also access the first element of the list by calling next() otherwise the first element will be skipped and it would require a new method to access the first element.
Similarly, in the hasNext method, I checked whether the current Position is null or not rather than checking Position .after().
This does not break the function as next() still returns the element which comes after the element which was returned when the previous next() was called.

I made two implementations of iterator as the type of the iterator was <Position<T>> in the LinkedList interface while on the other hand, it was <Student_> in Entity and <CourseGrade_> in Student interfaces. Same code would not have been compatible with each of those because the next() in <Position<T>> will return a Position object while the <Student_> iterator expects a student object.
These two are almost same, takes the first Position in the LinkedList as input and iterate through them. The only difference is that next() method returns position for <Position<T>> and position.value() for <Student_> and <CourseGrade_>.

CourseGrade:
This stores information about a particular course a student had. It stores and returns the title and number and grade achieved in that Course. Each student maintains a list of CourseGrade object for containing information about his/her courses and grades.
It does not store a Course object but only its name and number because it does not need the list of all student enrolled in that Course. Also storing the list will lead to a requirement of infinite memory as each student has a coursegrade object list and each coursegrade object has student object lists of students enrolled in the Course. These students contain coursegrade object for this Course, which again contains the list of students which again contain coursegrade object and so on and an infinite chain is formed which will lead to error.

GradeInfo:
This stores the LetterGrade enum, which lists all the achievable grades and also a static method to return the points earned corresponding to the grade passed to it as an argument.

The grade() method returns a GradeInfo object rather than the LetterGrade directly. So the constructor of the GradeInfo object takes a grade as an argument and then stores it. It is returned by a method called grade() in the GradeInfo interface.
So to access the grade from courseinfo, we need to call courseinfo.grade().grade() when first grade() refers to the CourseInfo method and the second one refers to GradeInfo method.
The design of the assignment required us to do this.

Entity:
This is a common interface for Hostel, Course and Department classes which tells to store and return the name of the Entity and the list of students belonging to that Entity.
Course class also stores the course number to answer the COURSETITLE query easily. To answer it we can iterate through allCourses list and match the course number with given input and easily give the answer.

Student:
This stored data about a student and had getter functions to get them as defined by the interface.
The CGPA calculation method is explained in INFO query explanation below.

getData:
getData takes input using buffered reader and file reader (surrounded by try-catch to avoid runtime errors). The working is pretty straight forward. It extracts data from Student file and then makes new student objects and add them in a LinkedList of students called allStudents, which contains all students. After that, it extracts data from course file and for each line, searches the student in the allStudent lists and creates a new CourseGrade object containing information about the Course and adds it to the coursegrade list maintained by the student and then iterates through allCourses list and add the Course if not already added and then adds the student to students list of the Course.
It also does something regarding CGPA calculation for the student. (mentioned below)
After that, it iterates through the student list and for each student iterates through the allHostels and allDepartments lists and adds the hostel/department if not in the lists or adds the student to the student list of the hostel/department if it is found.

answerQueries:
INFO:
This iterates through allStudents list and after the entry number matches, it displays all the information.
For CGPA calculation:
I have maintained two variables named points and completedCredits in each student object. In the getData query along with adding the coursegrade object to the coursegrade list maintained the student, it also added 3 to the completedCredits (if grade not equal to I) and added 3*gradepoint value of the grade (using gradepoint() function) to points.
The cgpa() method returns points/completedCredits. To round off, I first multiplied the result with hundred and then used Math.round() to round the result off to a whole number(no extra library needed) and then divided the result by 100.
For courses:
I first stored all the courses in an array and then used bubble sort to sort them in lexicographic order according to course number and then printed them.

COURSETITLE:
explained above in Entity explanation.

SHARE:
This was also straightforward. I iterated the allStudents list and stored the entry number of the student who had a match in a LinkedList. After that, I stored the LinkedList elements in an array and applied bubble sort and then printed the answer.