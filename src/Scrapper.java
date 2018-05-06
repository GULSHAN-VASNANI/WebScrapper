import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class Scrapper {
	
		
	public static void main(String[] args) {
		
			        ScrapperNode node=new ScrapperNode();
			        //node.setUrl("http://www.shmdegreecollege.in/");
			        String rootUrl = "http://localhost:8000/root.html";
			        int depth = 2;
			        node.setUrl(rootUrl);
			        boolean checkDepth = doScrapping(node,depth,0);
			        
			        if(checkDepth){
			        	System.out.println("Data populated");
			        	printValues(node);
			        	
			        }else{
			        	System.out.println("Check depth value");
			        }

		
	}

	public static void printValues(ScrapperNode nodess){
		
		Queue<ScrapperNode> queue=new LinkedList<>();
		ArrayList<ScrapperNode> nodeList =nodess.getNode();
		System.out.println(nodess.getUrl()+" "+nodess.getDepthLevel());
		queue.addAll(nodeList);
		//System.out.println(queue.size());
		int i=queue.size();
		while(i > 0){
			nodess=queue.peek();
			nodeList=nodess.getNode();
			queue.addAll(nodeList);
			queue.remove();
			i=queue.size();
		}
		
	}
	public static boolean doScrapping(ScrapperNode node,int depth,int current){
		
		if(current > depth)
			return false;
		
		String url=node.getUrl();
		if(url.isEmpty())
			return false;//to avoid javascript:void(0) value in href
		Document doc;
		Elements links = null;
		try {
			doc = Jsoup.connect(url).get();
			System.out.println(url +"  "+current);
			//System.out.println("Depth current :"+current+"Url "+node.getUrl());
			links = doc.select("a[href]");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		ArrayList<ScrapperNode> childNodeList=node.getNode();
		if (links !=null && links.size() > 0){
			for (Element link : links){
			ScrapperNode childNode=new ScrapperNode();
			childNode.setUrl(link.attr("abs:href"));
			childNode.setDepthLevel(current + 1);
			
			boolean checkIfNodeToBeAdded=doScrapping(childNode,depth,current + 1);
			if(checkIfNodeToBeAdded){
				childNodeList.add(childNode);
			}
			}
			node.setNode(childNodeList);
		}
		
	return true;	
	}
	
}
