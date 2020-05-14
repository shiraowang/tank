package com.sr.tank;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * @Author admin
 * @date 2020/5/14
 */
public class ImageTest {

    @Test
    public void test(){
        try {
            BufferedImage read = ImageIO.read(ResourcesMge.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            assertNotNull(read);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
