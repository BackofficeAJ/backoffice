package sn.hubsocial.avisjournaux.backoffice.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Backoffice implements EntryPoint {

  public void onModuleLoad() {
	   
		    RootPanel.get().add(new Index());
		  }
}