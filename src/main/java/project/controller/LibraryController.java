package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import project.model.Library;

import java.sql.*;

@Controller
@RequestMapping("/library")
public class LibraryController {
	@RequestMapping(value="/operationInsert/name/{name}/barcode/{barcode}/author/{author}/pages/{pages}/isread/{isread}", method = RequestMethod.GET)
	public String getBook1(@PathVariable String name,@PathVariable int barcode,@PathVariable String author,@PathVariable int pages,@PathVariable String isread, ModelMap model) throws Exception
	{

		Library lib = new Library();
		Connection connect = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		String url="com.mysql.jdbc.Driver";
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName(url);
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/library","root","Ashwin7@mak");
			String insert = "insert into books values ('"+name+"',"+barcode+",'"+author+"',"+pages+",'"+isread+"');";
			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query


			// PreparedStatements can use variables and are more efficient
			preparedStatement = connect.prepareStatement(insert);
			int i = preparedStatement.executeUpdate(insert);
			lib.setName(name);
			lib.setBarcode(barcode);
			lib.setAuthor(author);
			lib.setPages(pages);
			lib.setIsread(isread);
			model.addAttribute("name",lib.toString());

		}
		catch (Exception e) {
			throw e;
		} finally{
			System.out.println("finally");
		}


		return "list";

	}
	@RequestMapping(value="/operationDelete/barcode/{barcode}", method = RequestMethod.GET)
	public String getBook2(@PathVariable int barcode, ModelMap model) throws Exception
	{

		Connection connect = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		String url="com.mysql.jdbc.Driver";
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName(url);
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/library","root","Ashwin7@mak");
			String delete = "delete from books where barcode="+barcode+";";
			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query


			// PreparedStatements can use variables and are more efficient
			preparedStatement = connect.prepareStatement(delete);
			int d = preparedStatement.executeUpdate(delete);


		}
		catch (Exception e) {
			throw e;
		} finally{

		}

		return "list";

	}

	@RequestMapping(value="/operationUpdate/name/{name}/barcode/{barcode}/pages/{pages}", method = RequestMethod.GET)
	public String getBook3(@PathVariable String name,@PathVariable int barcode,@PathVariable int pages) throws Exception
	{

		Connection connect = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		String url="com.mysql.jdbc.Driver";
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName(url);
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/library","root","Ashwin7@mak");
			String update = "update books set name='"+name+"' , pages="+pages+" where barcode="+barcode+";";
			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query


			// PreparedStatements can use variables and are more efficient
			preparedStatement = connect.prepareStatement(update);
			int u = preparedStatement.executeUpdate(update);


		}
		catch (Exception e) {
			throw e;
		} finally{

		}

		return "list";
	}
	@RequestMapping(value="/select/{barcode}", method = RequestMethod.GET)
	public @ResponseBody
	Library display(@PathVariable int barcode) throws Exception{

		Connection connect = null;
		Library book = new Library();
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		String url="com.mysql.jdbc.Driver";
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName(url);
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "Ashwin7@mak");
			String select = "Select * from books where barcode="+barcode+";";
			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			preparedStatement = connect.prepareStatement(select);
			// PreparedStatements can use variables and are more efficient
			ResultSet s = preparedStatement.executeQuery(select);
			while(s.next()){
				book.setName(s.getString("name"));
				book.setBarcode(s.getInt("barcode"));
				book.setAuthor(s.getString("author"));
				book.setPages(s.getInt("pages"));
				book.setIsread(s.getString("isread"));
			}


		}
		catch (Exception e) {
			throw e;
		} finally{

		}

		return book;
	}
}