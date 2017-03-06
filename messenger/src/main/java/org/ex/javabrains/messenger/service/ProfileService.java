package org.ex.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ex.javabrains.messenger.database.DatabaseClass;
import org.ex.javabrains.messenger.model.Profile;
 
public class ProfileService {
	    private Map<String,Profile> profiles=DatabaseClass.getProfiles();
		public ProfileService(){
		  profiles.put("harsha_neekhra",new Profile(1L,"harsha_neekhra","harsha","neekhra"));	
		 
		  profiles.put("soumya_jain",new Profile(2L,"soumya_jain","soumya","jain"));
		}
		
	     public List<Profile> getAllProfiles(){
	    /*	 Message m1=new Message(1L,"Hello World!!","harsha");
	    	 Message m2=new Message(2L,"Hey There!!","harsha");
	    	 List<Message> list = new ArrayList<>();
	    	 list.add(m1);
	    	 list.add(m2);
	    	 return list;
	     }*/
	    	 return new ArrayList<Profile>(profiles.values());
	     }
	     public Profile getProfile(String profileName ){
	    	 return profiles.get(profileName);
	     }
	     public Profile addProfile(Profile profile){
	    	 profile.setId(profiles.size()+1);
	    	 profiles.put(profile.getProfileName(),profile);
	    	 return profile;
	     }
	     public Profile removeProfile(String profileName){
	    	 Profile profile=profiles.get(profileName);
	         profiles.remove(profileName);
	    	 return profile;
	     }
	     public Profile updateProfile(Profile profile){
	    	 
	    	 profiles.put(profile.getProfileName(),profile);
	    	 return profile;
	     }
}
