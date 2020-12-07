package com.cg.oas.exceptions;

public class NameIsBlankException extends Exception
{
	private String message;
		
		public NameIsBlankException() {
			this.message = "";
		}
		public NameIsBlankException(String message) {
			this.message = message;
		}
		@Override
		public String toString() {
			return "Name cannot be Empty" + this.message;
		}
	}


