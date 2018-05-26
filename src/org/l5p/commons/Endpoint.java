package org.l5p.commons;

/**
 * Point d'accès réseau pouvant être soit serveur soit client.
 * Permet de recevoir et traiter des messages depuis une ou plusieurs Socket.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public interface Endpoint {
	
	/**
	 * Traite un message envoyé par un autre point d'accès réseau.
	 * 
	 * @param listener l'objet d'écoute de la socket ayant envoyé le message
	 * @param message le contenu du message
	 */
	public void handleMessage(SocketListener listener, Object message);
	
	/**
	 * Méthode appelée lorsque la communication avec une socket reliée au point d'accès est coupée.
	 * 
	 * @param socketListener l'objet d'écoute lié à la socket s'étant déconnectée
	 */
	public void onDisconnect(SocketListener socketListener);

}
