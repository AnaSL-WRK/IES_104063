package ua.ana.showapi.builders;

public class rdmquote {
    long id;
    String show;
    String quote;

	public rdmquote() {
		
	}

	public rdmquote(long id, String show, String quote) {
		super();
		this.id = id;
        this.show = show;
        this.quote = quote;

	}
	
	public String getQuote() {
        return quote;
    }
    public void setQuotes(String quotes) {
        this.quote = quotes;
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

