package org.ex.javabrains.messenger.service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.ex.javabrains.messenger.database.DatabaseClass;
import org.ex.javabrains.messenger.exception.DataNotFoundException;
import org.ex.javabrains.messenger.model.Message;
public class MessageService {
	private Map<Long,Message> messages= DatabaseClass.getMessages();
	/*
	 * since the messages instance var  in the DatabaseClass is static 
	 * even though multiple instance of service are created they all point to
	 * same map of messages
	 */
	public MessageService(){
	  messages.put(1L,new Message(1,"hello world!!","harsha"));	
	  messages.put(2L,new Message(2,"hello there!!","harsha"));	
	}
	
     public List<Message> getAllMessages(){
    /*	 Message m1=new Message(1L,"Hello World!!","harsha");
    	 Message m2=new Message(2L,"Hey There!!","harsha");
    	 List<Message> list = new ArrayList<>();
    	 list.add(m1);
    	 list.add(m2);
    	 return list;
     }*/
    	 return new ArrayList<Message>(messages.values());
     }
     public List<Message> getAllMessagesForYear(int year){
    	 List message_year=new ArrayList();
    	 Calendar cal=Calendar.getInstance();
    	 for(Message message:messages.values()){
    		 cal.setTime(message.getCreated());
    		 if(cal.get(Calendar.YEAR)==year){
    			message_year.add(message);
    		 }
    	 }
    	 return message_year;
     }
     public List<Message> getAllMessagesPaginated(int start,int size){
    	 ArrayList<Message> al=new ArrayList<Message>(messages.values());
    	 if(start+size>al.size())
    		 return new ArrayList<Message>();
    	 return al.subList(start, start+size);
     }
     public Message getMessage(Long id){
    	// return messages.get(id);
    	 Message message=messages.get(id);
    	 if(message==null){
    		
    			 throw new DataNotFoundException("message with required id"+id+"not found"); //initially message resource doesnt have anyhandler later it is created
    		 }
    	 else
    		 return messages.get(id);
    	 
     }
     public Message addMessage(Message message){
    	 message.setId(messages.size()+1);
    	 messages.put(message.getId(),message);
    	 return message;
     }
     public Message removeMessage(Long id ){
    	 Message message=messages.get(id);
         messages.remove(id);
    	 return message;
     }
     public Message updateMessage(Message message){
    	 Long id= message.getId();
    	 messages.put(id,message);
    	 return getMessage(id);
     }
}