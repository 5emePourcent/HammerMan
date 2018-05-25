package org.l5p.commons;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Utilitaire pour l'envoi et la réception d'objets sérialisés via Socket.
 * 
 * @author Lucas Moura de Oliveira
 *
 */
public class IOUtils {
	
	/**
	 * Lit un objet depuis un ObjectInputStream et le retourne.
	 * 
	 * @param reader le flux à lire
	 * 
	 * @return un objet lu depuis le flux ou null en cas d'erreur de lecture
	 */
	public static Object readMessage(ObjectInputStream reader) {
		try {
			Object message = reader.readObject();
			return message;
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Ecrit un objet dans un ObjectOutputStream.
	 * 
	 * @param writer le flux dans lequel le message sera écrit
	 * 
	 * @param message le message à écrire
	 */
	public static void sendMessage(ObjectOutputStream writer, Object message) {
		try {
			writer.writeObject(message);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
