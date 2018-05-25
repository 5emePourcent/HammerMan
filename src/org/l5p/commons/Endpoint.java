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

}
