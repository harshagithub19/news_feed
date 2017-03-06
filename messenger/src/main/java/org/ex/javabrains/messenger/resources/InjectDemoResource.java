package org.ex.javabrains.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
/*
 * here we are demonstrating diff ways to inject values
 */
@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	@GET
	@Path("context") //quick way to get info around a request when u r not sure what u r looking for
	//and if we are sure what we are lookin for we go for @path("annotations")
	public String getParamsUsingContext(@Context UriInfo uriinfo,@Context HttpHeaders header)
	{
		String path= uriinfo.getAbsolutePath().toString();
		String ck=header.getCookies().toString();
		return "Absolute path is"+path+" cookies are:"+ck;
	}
	
	
 
}
