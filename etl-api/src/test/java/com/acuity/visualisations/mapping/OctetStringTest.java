package com.acuity.visualisations.mapping;

import org.junit.Test;
import org.junit.Assert;

public class OctetStringTest {

    @Test
    public void test() {
        {
            final String hexString = "01";
            OctetString octetString = new OctetString(hexString);
            Assert.assertEquals(new OctetString(new byte[]{1}), octetString);
            Assert.assertEquals(hexString, octetString.toString());
        }

        {
            final String hexString = "ff";
            OctetString octetString = new OctetString(hexString);
            Assert.assertEquals(new OctetString(new byte[]{(byte) 255}), octetString);
            Assert.assertEquals(hexString, octetString.toString());
        }

        {
            final String hexString = "00010203040506070809000a0b0c0d0e0f";
            OctetString octetString = new OctetString(hexString);
            Assert.assertEquals(octetString.getBytes()[0], 0);
            Assert.assertEquals(octetString.getBytes()[0], 0);
            Assert.assertEquals(octetString.getBytes()[1], 1);
            Assert.assertEquals(octetString.getBytes()[2], 2);
            Assert.assertEquals(octetString.getBytes()[10], 0);
            Assert.assertEquals(octetString.getBytes()[11], 0xa);
            Assert.assertEquals(octetString.getBytes()[12], 0xb);
            Assert.assertEquals(octetString.getBytes()[16], 0xf);
            Assert.assertEquals(hexString, octetString.toString());
        }
    }
}
