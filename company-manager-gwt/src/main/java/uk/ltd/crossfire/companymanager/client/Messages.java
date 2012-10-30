package uk.ltd.crossfire.companymanager.client;

/**
 * Interface to represent the messages contained in resource bundle:
 * 	C:/dev/workspace/company-manager-gwt-TRUNK/target/company-manager-gwt-1.0-SNAPSHOT/WEB-INF/classes/uk/ltd/crossfire/company-manager-gwt/client/Messages.properties'.
 */
public interface Messages extends com.google.gwt.i18n.client.Messages {
  
  /**
   * Translated "Enter your name".
   * 
   * @return translated "Enter your name"
   */
  @DefaultMessage("Enter your name")
  @Key("nameField")
  String nameField();

  /**
   * Translated "Send".
   * 
   * @return translated "Send"
   */
  @DefaultMessage("Send")
  @Key("sendButton")
  String sendButton();
}
