# ScanbuyAssessment

I have developed a RESTful Web service that allows me to inventory my books from Library using Spring as the framework and MySql as the database. I have used Intellij IDEA 14.1.4 for developing this java project.

#TABLE
I have created a table called BOOKS in MySQL with the attributes Name, Barcode which is the Primary key, Author, Pages and Isread to determine whether the book is read or not. 
I have showcased the main operations such as Select, Insert, Delete and Update to handle with the books.

# >Insert Operation
  It is used to insert a new book and its attributes into the table. The following target address is used
  http://localhost:8080/rest/library/operationInsert/name/SherlockHolmes/barcode/117/author/Arthur/pages/260/isread/read
  
# >Delete Operation
  It is used to delete any existing book and its attributes from the table. The following target address is used 
  http://localhost:8080/rest/library/operationDelete/barcode/117
 
# >Update Operation
   It is used to update any existing book and its attributes into the table using Barcode as the reference. The following target address is used
   http://localhost:8080/rest/library/operationUpdate/name/Emma/barcode/111/pages/400

# >Select Operation
   It is used to display any book and its attributes from the table using Barcode as the reference and it displays the result in JSON format. The following target address is used
   http://localhost:8080/rest/library/select/101
