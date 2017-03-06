package org.ex.javabrains.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.ex.javabrains.messenger.model.Message;
import org.ex.javabrains.messenger.model.Profile;

public class DatabaseClass {
   private static Map<Long,Message> messages=new HashMap<>();
   private static Map<String,Profile> profiles = new HashMap<>(); // first arg is profile name 
                                                                 //so string is written
public static Map<Long, Message> getMessages() {
	return messages;
}

public static Map<String, Profile> getProfiles() {
	return profiles;
}
   
}
