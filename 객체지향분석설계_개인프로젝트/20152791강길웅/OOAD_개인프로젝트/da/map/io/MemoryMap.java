package da.map.io;

import java.util.LinkedHashMap;
import java.util.Map;

import entity.User;

public class MemoryMap {
	private static MemoryMap singletonMap;
	
	private Map<String,User> userMap;
	
	private MemoryMap() {
		this.userMap = new LinkedHashMap<>();
	}
	
	public static MemoryMap getInstance() {
		if(singletonMap == null) {
			singletonMap = new MemoryMap();
		}
		return singletonMap;
	}
	
	public Map<String,User> getUserMap(){
		return userMap;
	}
}
