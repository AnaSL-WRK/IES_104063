package ua.ana.showapi.builders;

public class allshows {
    long id;
    String show;

	public allshows() {
		
	}

	public allshows(long id, String show) {
		super();
		this.id = id;
        this.show = show;
	}
	
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getShow() {
        return show;
    }
    public void setShow(String show) {
        this.show = show;
	}

}
