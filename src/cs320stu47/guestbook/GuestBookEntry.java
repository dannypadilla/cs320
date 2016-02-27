package cs320stu47.guestbook;

import java.util.Date;

public class GuestBookEntry {

		static int numberOfEntries = 0;
	
		private int id;
		private String name;
		private String message;
		private Date created;
		
		public GuestBookEntry(String name, String message) {
			super();
			this.name = name;
			this.message = message;
			
			this.id = ++numberOfEntries;
			this.created = new Date();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public int getId() {
			return id;
		}

		public Date getCreated() {
			return created;
		}
		
		
		
		
}
