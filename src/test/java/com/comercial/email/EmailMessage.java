
package com.comercial.email;

public class EmailMessage {

	private String from;
	private String to;
	private String subject;
	private String content;
	private String mimeType; // optional

	private EmailMessage() {
	}

	public static ITo from(String from) {
		return new EmailMessage.Builder(from);
	}

	public interface ITo {
		ISubject to(String to);
	}

	public interface ISubject {
		IContent subject(String subject);
	}

	public interface IContent {
		IBuild content(String content);
	}

	public interface IBuild {
		IBuild mimeType(String mimeTypeName);

		EmailMessage build();
	}

	private static class Builder implements ITo, ISubject, IContent, IBuild {
		private EmailMessage instance = new EmailMessage();

		public Builder(String from) {
			instance.from = from;
		}

		public ITo from(String from) {
			instance.from = from;
			return this;
		}

		@Override
		public ISubject to(String to) {
			instance.to = to;
			return this;
		}

		@Override
		public IContent subject(String subject) {
			instance.subject = subject;
			return this;
		}

		@Override
		public IBuild content(String content) {
			instance.content = content;
			return this;
		}

		@Override
		public IBuild mimeType(String mimeTypeName) {
			instance.mimeType = mimeTypeName;
			return this;
		}

		@Override
		public EmailMessage build() {
			return instance;
		}
	}

 

	//

}