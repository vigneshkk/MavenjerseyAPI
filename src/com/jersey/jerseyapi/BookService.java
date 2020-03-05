package com.jersey.jerseyapi;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/book")
public class BookService {
	BookDao bookDao = new BookDao();
	GsonBuilder gsonBuilder = new GsonBuilder();
	Gson gson = gsonBuilder.create();
	Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

	@GET //finished
	@Produces({ MediaType.APPLICATION_JSON })
	public Response displayAllBooks() {
		String prettyJson = prettyGson.toJson(bookDao.getAllBookLis());
		return Response.ok(prettyJson).build();
	}

	@GET //finished
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response displayBook(@PathParam("id") int id) {
		String prettyJson = null;
		List<Bookpojo> bookLists = bookDao.getAllBookLis();
		for (Bookpojo obj : bookLists) {
			if (obj.id == id) {
				prettyJson = prettyGson.toJson(obj);
				break;
			}
		}
		return Response.ok(prettyJson).build();
	}

	@POST //finished
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBook(String uname) {
		JSONParser parser = new JSONParser();
		JSONObject json = null;
		try {
			json = (JSONObject) parser.parse(uname);
			bookDao.addBook(json.get("name").toString(), json.get("description").toString(),
					json.get("author").toString(), json.get("genre").toString(), json.get("status").toString(),
					json.get("published_date").toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Response.ok(uname).build();
	}

	@PUT //finished
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateBook(String uname) {
		JSONParser parser = new JSONParser();
		JSONObject json = null;
		try {
			json = (JSONObject) parser.parse(uname);
			bookDao.updateBook((long) json.get("id"), json.get("name").toString(), json.get("description").toString(),
					json.get("author").toString(), json.get("genre").toString(), json.get("status").toString(),
					json.get("published_date").toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Response.ok(uname).build();
	}

	@DELETE //finished
	@Path("/{id}")
	public Response deleteBook(@PathParam("id") int id) {
		bookDao.deleteBook(id);
		return Response.ok("Record Deleted").build();

	}

}