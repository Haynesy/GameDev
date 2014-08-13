package dev.haynesy.ui;

import org.junit.Assert;
import org.junit.Test;

public class BitmapTest {

    @Test
    public void bitmap_must_always_have_pixels(){

        // Arrange
        Bitmap result = blankBitmap();
        result.pixels = new int[]{
            0xffffffff, 0xffffffff, 0x00000000, 0x00000000,
            0xffffffff, 0xffffffff, 0x00000000, 0x00000000,
            0x00000000, 0x00000000, 0x00000000, 0x00000000,
            0x00000000, 0x00000000, 0x00000000, 0x00000000,
        };

        Bitmap target = blankBitmap();
        Bitmap source = new Bitmap(2, 2);
        source.fill(0xffffffff);
        // Act
        target.render(source, 0, 0);

        // Assert
        Assert.assertEquals(result, target);
    }

    private Bitmap blankBitmap() {
        return new Bitmap(4, 4);
    }
}