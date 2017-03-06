package org.ex.javabrains.messenger.resources;

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






//import org.eclipse.persistence.tools.profiler.Profile;
import org.ex.javabrains.messenger.model.Message;
import org.ex.javabrains.messenger.model.Profile;
//import org.ex.javabrains.messenger.service.MessageService;
import org.ex.javabrains.messenger.service.ProfileService;
@Path("/profiles")
public class ProfileResources {
	ProfileService ps=new ProfileService();
	@GET
	 //@Produces(MediaType.TEXT_PLAIN);
	@Produces(MediaType.APPLICATION_JSON)  
	// default method for /messages
	 public List<Profile> getProfiles(){
		 
		 return ps.getAllProfiles();
	 }
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile){
		return ps.addProfile(profile);
	}
	 @GET
	 @Path("/{profileName}")  //provides mapping for /messages/messageId
	 @Produces(MediaType.APPLICATION_JSON)
	 //the path param arg and path arg must be same 
	  public Profile  getProfile(@PathParam("profileName")String profileName){
		// MessageService mservice=new MessageService();
		 return ps.getProfile(profileName);
	 }
	
	 @PUT
	 @Path("/{profileName}") 
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 public Profile updateProfiles(@PathParam("profileName")String pname,Profile profile){
	 	profile.setProfileName(pname);
	 	return ps.updateProfile(profile);
	 }
	 @DELETE
	 @Path("/{profileName}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public void deleteProfile(@PathParam("profileName")String pname){
	 	 ps.removeProfile(pname);
	 }
	
}
