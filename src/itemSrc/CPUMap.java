package itemSrc;

import java.util.TreeMap;


public class CPUMap 
{
    private TreeMap <String,CPU> allCPUs;

    
    public CPUMap()
    {
    	allCPUs = new TreeMap<String,CPU>();
    }
    
    public void addDetails(CPU details) 
    {
    	allCPUs.put(details.getId(), details);
    }
    
    public boolean hasParcel() {
    	if (allCPUs.isEmpty()) {
    		return false;
    	}
    	return true;
    }
    
    public int getNumberOfEntries()
    {
    	return allCPUs.size();
    }
    
    public boolean allGone () {
    	for(CPU c : allCPUs.values()) {
    		if (!c.isCollected()) {
    			return false;
    		}
    	}
    	return true;
    }
 
    public String listDetails()
    {
    	StringBuffer sb = new StringBuffer();
    	for(CPU c : allCPUs.values()) {
    		sb.append(c+"\n");
    	}
        return sb.toString();
    }
    
    public void setCollected(CPU p){
    	p.setCollected(true);
    	
    }

    public String listUncollected()
    {
    	StringBuffer sb = new StringBuffer();
    	for(CPU c : allCPUs.values()) {
    		if(! c.isCollected()) {
    			sb.append(c+"\n");
    		}
    	}
        return sb.toString();
    }
    
    public CPU findParcel(String id) {
    	return allCPUs.get(id);

    }

}
