// Java code to demonstrate Graph representation 
// using ArrayList in Java 
import java.util.* ; 


class AjiraQuestion { 
    
  static  HashMap<String, ArrayList<String>> graph = new HashMap< String, ArrayList<String>>();	
    HashMap<String,Integer> graph_strength = new HashMap<String,Integer>();
    static boolean add_node(String key)
    {
       
            ArrayList<String> newArrayList = new ArrayList<String>(); 
            try{
                graph.put(key,newArrayList);  
                return true ;
            }
            catch(Exception e)
            {
                    return false; 
            }
            
    }
    
    //function to connect two nodes
    static boolean connect_node(String key, String value)
    {
        try{

        ArrayList<String> arr = graph.get(key);
        
        if(arr.contains(value))
        {
            System.out.println("Error : Devices are already connected");
            return false;
        }
        arr.add(value);
        graph.put(key, arr);
        
        return true ;
        }
        catch(Exception e)
        {
            System.out.println("Error occured please try later "+e);
            return false; 
        }
    }

    
    //function info route

    static void info_route(String source, String dest)
    {
        ArrayList<String> arr = graph.get(source);
        if(arr.contains(dest)) 
        {   
            System.out.print(source);
            for(int i =0 ;i<arr.size();i++)
                {   
                    System.out.print("->"+arr.get(i));
                if(arr.get(i).equals(dest))
                   break; 
                }

        }
        else
          System.out.println("Error: No such route"); 

    }



    //Executor program
    static void executer_program(String s)
    {
        
      
        List valid_commands = Arrays.asList("CONNECT", "SET_DEVICE_STRENGTH", "INFO_ROUTE","ADD");
	   
	    List devices = Arrays.asList("COMPUTER", "REPEATER");
	    
	     
            String user_input = s;
            
            String[] full_command = user_input.split(" ");  
            String select_command = full_command[0];
            if(full_command.length!=3)
                System.out.println("Error : Invalid command syntax");

            else
            {
	  
            if (valid_commands.contains(select_command)) 
            {       
                    //ADD A NODE
                    if(select_command.equals("ADD"))
                        {
                          String device  = full_command[1];
                       
                          
                          if(devices.contains(device))
                                {
                                String device_name = full_command[2];
                                if(!graph.containsKey(device_name))
                                {
                                    if(add_node(device_name))
                                    {
                                        System.out.println("Successfully Added " + device_name);     
                                    }
                                }
                                else
                                    {
                                        
                                        System.out.println("That name already exists");
                                    }
                            }
                            else
                            {
                                System.out.println("Device not registered");
                            }
                        }
                        
                    //CONNECT TWO NODES 
                    if(select_command.equals("CONNECT"))
                    {
                        String key  = full_command[1];
                        String value = full_command[2];

                        if(key.equals(value))
                            {
                                System.out.println("Error: Cannot connect  device to itself");
                            }
                        else 
                        {
                            if(graph.containsKey(key) && graph.containsKey(value))
                            {
                            if(connect_node(key, value))
                                System.out.println("Successfully Connected");
                            }
                        else
                          System.out.println("Error : No such node found");
                       }
                 } 

                 //GET INFORMATION FOR A ROUTE 
                 if(select_command.equals("INFO_ROUTE"))
                    {
                        String source  = full_command[1];
                        String dest = full_command[2];
                        if(dest.contains("R"))
                            System.out.println("Error : Route cannot be calculated with a repeater ");
                        else
                        {
                            info_route(source,dest);

                        }
                        

                      
                 } 

                 //Set device strength
                 if(select_command.equals("SET_DEVICE_STRENGTH"))
                 {
                     String device  = full_command[1];
                     try{
                        int strength = Integer.parseInt(full_command[2]);
                        System.out.println("Successfully defined strength");

                     }catch(Exception e)
                        {
                            System.out.println("Error: Invalid command syntax") ;
                        }
                
                            
              } 

                
            }
	       else
	       {
	           System.out.println("Please enter a valid command - ADD,CONNECT,SET_DEVICE_STRENGTH,INFO_ROUTE");    
	            
	       }
	       
        }
	   
        
    }
    
     // Driver Code 
     
	public static void main(String[] args) 
	{ 
	  

    System.out.println("Please enter your commnd");
  
    // Scanner myObj = new Scanner(System.in);  
    int option = 0 ;
    while(option != 5)
    
    {
        //cn be improved with the buffered reder. 
        Scanner cmd_input = new Scanner(System.in);  
        String command = cmd_input.nextLine();
        executer_program(command);
       
        
    }
    
	        
 }
	
	 
} 
