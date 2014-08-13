package dev.haynesy.ui;

import org.junit.Assert;
import org.junit.Test;

public class BitmapTest {

    @Test
    public void can_render_to_a_bitmap_with_a_bitmap(){

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

    @Test
    public void can_negative_offset_bitmap_render(){

        // Arrange
        Bitmap result = blankBitmap();
        result.pixels = new int[]{
            0xffffffff, 0x00000000, 0x00000000, 0x00000000,
            0x00000000, 0x00000000, 0x00000000, 0x00000000,
            0x00000000, 0x00000000, 0x00000000, 0x00000000,
            0x00000000, 0x00000000, 0x00000000, 0x00000000,
        };

        Bitmap target = blankBitmap();
        Bitmap source = new Bitmap(2, 2);
        source.fill(0xffffffff);
        // Act
        target.render(source, -1, -1);

        // Assert
        Assert.assertEquals(result, target);
    }

    @Test
    public void can_offset_bitmap_larger_than_width_and_height(){

        // Arrange
        Bitmap result = blankBitmap();
        result.pixels = new int[]{
            0x00000000, 0x00000000, 0x00000000, 0x00000000,
            0x00000000, 0x00000000, 0x00000000, 0x00000000,
            0x00000000, 0x00000000, 0x00000000, 0x00000000,
            0x00000000, 0x00000000, 0x00000000, 0xffffffff,
        };

        Bitmap target = blankBitmap();
        Bitmap source = new Bitmap(2, 2);
        source.fill(0xffffffff);
        // Act
        target.render(source, 3, 3);

        // Assert
        Assert.assertEquals(result, target);
    }

    private Bitmap blankBitmap() {
        return new Bitmap(4, 4);
    }
}