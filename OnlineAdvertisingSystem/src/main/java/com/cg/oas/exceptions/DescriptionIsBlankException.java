package com.cg.oas.exceptions;

public class DescriptionIsBlankException extends Exception
{
	private String message;
		
		public DescriptionIsBlankException() {
			this.message = "";
		}
		public DescriptionIsBlankException(String message) {
			this.message = message;
		}
		@Override
		public String toString() {
			return "Name cannot be Empty" + this.message;
		}
	}

