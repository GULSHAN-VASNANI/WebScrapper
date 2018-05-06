import java.util.ArrayList;


public class ScrapperNode {
	
	private ArrayList<ScrapperNode> node=new ArrayList<>();
	private String url;
	private int depthLevel;
	public int getDepthLevel() {
		return depthLevel;
	}
	public void setDepthLevel(int depthLevel) {
		this.depthLevel = depthLevel;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ArrayList<ScrapperNode> getNode() {
		return node;
	}
	public void setNode(ArrayList<ScrapperNode> node) {
		this.node = node;
	}
	

}
