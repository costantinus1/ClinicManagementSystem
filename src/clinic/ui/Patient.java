package clinic.ui;

public class Patient {
	
	    private String  id;
	    private String  initials;
	    private boolean safeToScan;

	    public Patient(String id, String initials, boolean safeToScan) {
	        this.id         = id;
	        this.initials   = initials;
	        this.safeToScan = safeToScan;
	    }

	    public String  getId()         { return id; }
	    public String  getInitials()   { return initials; }
	    public boolean isSafeToScan()  { return safeToScan; }
	}


