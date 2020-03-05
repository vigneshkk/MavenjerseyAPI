package com.jersey.jerseyapi;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/user")
public class UserService {
	UserDao userDao= new UserDao();
	
	@GET //finished
	@Produces({ MediaType.APPLICATION_JSON })
	public Response displayAllUsers(){
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = prettyGson.toJson(userDao.getAllUserLis());
	    return Response.ok(prettyJson).build();
	}
	
	@GET //finished
	@Path("/{uname}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response displayUser(@PathParam("uname") String uname){
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson=null;
		List<Userpojo> userLists= userDao.getAllUserLis();
		for(Userpojo obj: userLists){
			if(obj.user_name.equals(uname)){
				prettyJson = prettyGson.toJson(obj);
				break;
			}
		}
	    return Response.ok(prettyJson).build();
	}
	
	@GET //finished
	@Path("/{uname}/books")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response displayUserbooks(@PathParam("uname") String uname){
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = prettyGson.toJson(userDao.getAllUserBookLis(uname));
	    return Response.ok(prettyJson).build();
	}
	
	@PUT //finished
	@Path("/{uname}/{Action}/{bid}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response bookActions(@PathParam("uname") String uname,@PathParam("Action") String action,@PathParam("bid") int bid){
		userDao.bookActions(uname, action, bid);
		return Response.ok("Book"+action+"ed").build();
	}
	
}
