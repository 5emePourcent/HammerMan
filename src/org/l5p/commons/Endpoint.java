package org.l5p.commons;

/**
 * Point d'acc�s r�seau pouvant �tre soit serveur soit client.
 * Permet de recevoir et traiter des messages depuis une ou plusieurs Socket.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public interface Endpoint {
	
	/**
	 * Traite un message envoy� par un autre point d'acc�s r�seau.
	 * 
	 * @param listener l'objet d'�coute de la socket ayant envoy� le message
	 * @param message le contenu du message
	 */
	public void handleMessage(SocketListener listener, Object message);
	
	/**
	 * M�thode appel�e lorsque la communication avec une socket reli�e au point d'acc�s est coup�e.
	 * 
	 * @param socketListener l'objet d'�coute li� � la socket s'�tant d�connect�e
	 */
	public void onDisconnect(SocketListener socketListener);

}
