package com.github.zipcodewilmington;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMapOneTest {
    DashaMap mappy;
    @Before
    public void before(){
        mappy = new DashaMap();
    }
    @Test
    public void testSet(){
        // Given
        String key = "key";
        String value = "value";
        long expected = 1;
        mappy.set(key, value);
        // When
        long actual = mappy.bucketSize("k");
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDelete(){
        // Given
        String key = "key";
        String value = "value";
        long expected = 0;

        // When
        mappy.set(key, value);
        mappy.delete(key);
        long actual = mappy.bucketSize("k");
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGet(){
        // Given
        String key = "key";
        String expected = "looking for me";

        // When
        mappy.set(key, expected);
        String actual = mappy.get(key);
        // Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testIsNotEmpty(){
        // Given
        String key = "key";
        String value = "value";

        // When
        mappy.set(key, value);
        // Then
        Assert.assertFalse(mappy.isEmpty());
    }
    @Test
    public void testIsEmpty(){
        Assert.assertTrue(mappy.isEmpty());
    }

    @Test
    public void testSize(){
        // Given
        String key = "key";
        String value = "value";
        long expected = 2;

        // When
        mappy.set(key, value);
        mappy.set("I want", "ice cream");
        long actual = mappy.size();
        // Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testBucketSize(){

    }

}
