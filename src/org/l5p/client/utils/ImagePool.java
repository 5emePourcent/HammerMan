package org.l5p.client.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImagePool {
	
	public static final ImagePool instance = new ImagePool();
	
	private Map<String, BufferedImage> images;
	
	private ImagePool() {
		try {
			initImages();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initImages() throws IOException {
		images = new HashMap<String, BufferedImage>();
		images.put("wall", ImageIO.read(new File("resources/img/wall.png")));
		images.put("box", ImageIO.read(new File("resources/img/box1.png")));
		images.put("floor", ImageIO.read(new File("resources/img/floor.png")));
	}
	
	public BufferedImage get(String imageName) {
		return images.get(imageName);
	}

}
