//this basically is an resource handler
package org.ex.javabrains.messenger.resources;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.ex.javabrains.messenger.model.Message;
import org.ex.javabrains.messenger.resources.beans.MessageFilterBeans;
import org.ex.javabrains.messenger.service.MessageService;

@Path("/messages")

public class MessageResources {
	MessageService ms=new MessageService();
 
 /*
  /specifies to jersey that what the return type of the request is
  //MediaType is an enumeration that contains a  lot of statndard 
  //content types that a http response should return
  //the conversion to xml is done by jax p but jax p needs
  //some clue and that is done by adding the xmlrootelement in 
  //model class
  */
  /*public String getAllMessages(){
	  return "hello world";
  }*/
@GET
 //@Produces(MediaType.TEXT_PLAIN);
@Produces(MediaType.APPLICATION_JSON)  
// default method for /messages
 //***public List<Message> getAllMessages(@QueryParam("year")int yr,@QueryParam("start")int start,@QueryParam("size")int size){
	//here year must be the same name which has been used in url
public List<Message> getAllMessages(@BeanParam MessageFilterBeans mfbean){
	 //if(yr>0) 
	if(mfbean.getYr()>0){
	 return ms.getAllMessagesForYear(mfbean.getYr());
	 }
	// if(size>0 && start >0)
	if(mfbean.getStart()>0 && mfbean.getSize()>0){
		 return ms.getAllMessagesPaginated(mfbean.getStart(), mfbean.getSize());
	 }
	 else
		 return ms.getAllMessages(); 
}

@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response addMessage(Message message, @Context UriInfo uriinfo){
	
	//return ms.addMessage(message); 
	/*commented becoz simply returning message is too mainstream
	 * we can add status code info and header info and with that info added  Response object is returned
    */
	Message newMessage =ms.addMessage(message);
	String id=String.valueOf(newMessage.getId());
    URI uri=uriinfo.getAbsolutePathBuilder().path(id).build();// this portion does the task of automatically concatenating the id fetched from the message to the uri and converts it back to uri type again
	return Response.created(uri)
	        .entity(newMessage)
	        .build();
	
	
	
}
@PUT
@Path("/{messageId}") 
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Message updateMessage(@PathParam("messageId")long id,Message message){
	message.setId(id);
	return ms.updateMessage(message);
}

@DELETE
@Path("/{messageId}")
@Produces(MediaType.APPLICATION_JSON)
public void deleteMessage(@PathParam("messageId")long id){
	 ms.removeMessage(id);
}
 
 @GET
 @Path("/{messageId}")  //provides mapping for /messages/messageId
 @Produces(MediaType.APPLICATION_JSON)
 //the path param arg and path arg must be same 
  public Message getMessage(@PathParam("messageId")long mid){
	 MessageService mservice=new MessageService();
	 return ms.getMessage(mid);
 }
} 
