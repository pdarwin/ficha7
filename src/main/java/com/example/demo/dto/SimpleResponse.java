package com.example.demo.dto;

public class SimpleResponse {

	private boolean statusOk;
	private String msg;
	
	public SimpleResponse() {
		statusOk= false;
		msg = "Ocorreu um erro";
	}

	public void addMsg(String msg) {
		this.msg += "\n" + msg;
	}
	
	/**
	 * @return the statusOk
	 */
	public boolean isStatusOk() {
		return statusOk;
	}

	/**
	 * @param statusOk the statusOk to set
	 */
	public void setStatusOk(boolean statusOk) {
		this.statusOk = statusOk;
		this.msg = "Executado sem erros.";
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
