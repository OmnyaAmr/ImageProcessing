import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class BlendImage {
	public static void main(String args[]) throws IOException {
		BufferedImage img1 = null;
		BufferedImage img2 = null;
		File f1 = null;
		File f2 = null;

		// read image
		try {
			f1 = new File("C:\\Image\\test1.jpg");
			f2= new File ("C:\\Image\\test2.jpg");
			img1 = ImageIO.read(f1);
			img2 = ImageIO.read(f2);
		} catch (IOException e) {
			System.out.println(e);
		}

		// get image width and height
		int width = img1.getWidth();
		int height = img1.getHeight();

		// convert to negative
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int p1 = img1.getRGB(x, y);

				int a1 = (p1 >> 24) & 0xff;
				int r1 = (p1 >> 16) & 0xff;
				int g1 = (p1 >> 8) & 0xff;
				int b1 = p1 & 0xff;
				
				int p2 = img2.getRGB(x, y);

				@SuppressWarnings("unused")
				int a2 = (p2 >> 24) & 0xff;
				int r2 = (p2 >> 16) & 0xff;
				int g2 = (p2 >> 8) & 0xff;
				int b2 = p2 & 0xff;
				
				

				// subtract RGB from 255
				r1 = (int)(0.8*r1 + 0.2*r2);
				g1 = (int)(0.8*g1 + 0.2*g2);
				b1 = (int)(0.8*b1 + 0.2*b2);

				// set new RGB value
				p1 = (a1 << 24) | (r1 << 16) | (g1 << 8) | b1;

				img1.setRGB(x, y, p1);
			}
		}

		// write image
		try {
			f1 = new File("C:\\Image\\test2Output.jpg");
			ImageIO.write(img1, "jpg", f1);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}